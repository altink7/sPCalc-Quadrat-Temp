package slm.slm.document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.time.LocalDate;

public class TestDataXml {
    public static void main(String[] args) {
        // Create some sample data
        CountryData data = new CountryData(
                "My Application",
                LocalDate.now(),
                "Some data",
                "Canada",
                "Ottawa"
        );

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
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
