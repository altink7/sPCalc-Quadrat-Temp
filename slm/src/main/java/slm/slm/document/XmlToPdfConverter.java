package slm.slm.document;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.awt.*;
import java.io.*;

public class XmlToPdfConverter{
    public static File xmlFile;

    public static void createPdf(File xmlFile, HttpServletRequest request, HttpServletResponse response) throws SAXException, IOException, TransformerException {
        // Create a FopFactory object
        FopFactory fopFactory = FopFactory.newInstance(new File("slm/src/main/java/slm/slm/document/config/fop.xconf"));

        // Set up a Transformer to convert the XML file to XSL-FO
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File("slm/src/main/java/slm/slm/document/config/stylesheet.xsl"));
        Transformer transformer = transformerFactory.newTransformer(xslt);
        Source xml;

        if(xmlFile == null) {
            xml = new StreamSource(new File("slm/src/main/java/slm/slm/document/config/data.xml"));
        }else {
            xml = new StreamSource(xmlFile);
        }
        OutputStream foStream = new FileOutputStream("output.fo");
        Result foResult = new StreamResult(new File("output.fo"));

        transformer.transform(xml, foResult);
        foStream.close();

        // Set up a Fop object to generate the PDF file
        OutputStream pdfStream = new FileOutputStream("output.pdf");
        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, pdfStream);

        // Convert the XSL-FO file to PDF using Apache FOP
        Source fo = new StreamSource(new File("output.fo"));
        Result pdfResult = new SAXResult(fop.getDefaultHandler());
        transformer.transform(fo, pdfResult);

        OutputStream filledPdf = new FileOutputStream("filled.pdf");
        transformer = transformerFactory.newTransformer();
        Fop filledFop = fopFactory.newFop(MimeConstants.MIME_PDF, pdfStream);
        pdfResult = new SAXResult(filledFop.getDefaultHandler());
        transformer.transform(fo, pdfResult);
        pdfStream.close();

        //show the pdf
        if(Desktop.isDesktopSupported()&& Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
            Desktop.getDesktop().open(new File("output.pdf"));
        }else {
            doGet(request, response);
        }
    }

    public static void createXmlFileAndPdf(CountryData data, HttpServletRequest request, HttpServletResponse response) {
        try {
            // Create JAXB context and marshaller
            JAXBContext context = JAXBContext.newInstance(CountryData.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Saved the XML to a file
            File file = new File("data.xml");
            marshaller.marshal(data, file);

            // Saved the XML to a file in the same directory as the class file
            File xmlFile = new File(TestDataXml.class.getResource("").getPath() + "data.xml");
            marshaller.marshal(data, xmlFile);

            // Printed the XML to the console
            marshaller.marshal(data, System.out);

            XmlToPdfConverter.xmlFile = xmlFile;

            createPdf(xmlFile, request, response);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException | TransformerException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public static void doGet(HttpServletRequest request, HttpServletResponse response){
        // Get the PDF file from disk
        File file = new File("output.pdf");

        // Set response headers
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));

        // Write the file to the response output stream
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}