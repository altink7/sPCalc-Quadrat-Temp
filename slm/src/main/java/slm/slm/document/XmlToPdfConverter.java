package slm.slm.document;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class XmlToPdfConverter {
    public static void main(String[] args) throws Exception {
        // Create a FopFactory object
        FopFactory fopFactory = FopFactory.newInstance(new File("slm/src/main/java/slm/slm/document/config/fop.xconf"));

        // Set up a Transformer to convert the XML file to XSL-FO
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File("slm/src/main/java/slm/slm/document/config/stylesheet.xsl"));
        Transformer transformer = transformerFactory.newTransformer(xslt);
        Source xml = new StreamSource(new File("slm/src/main/java/slm/slm/document/files/testdata.xml"));
        OutputStream foStream = new FileOutputStream("output.fo");
        Result foResult = new StreamResult(new File("output.fo"));

        transformer.transform(xml, foResult);
        foStream.close();

        // Set up a Fop object to generate the PDF file
        OutputStream pdfStream = new FileOutputStream(new File("output.pdf"));
        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, pdfStream);

        // Convert the XSL-FO file to PDF using Apache FOP
        Source fo = new StreamSource(new File("output.fo"));
        Result pdfResult = new SAXResult(fop.getDefaultHandler());
        transformer.transform(fo, pdfResult);

        pdfStream.close();
    }
}