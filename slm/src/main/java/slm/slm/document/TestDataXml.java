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

            // Save the XML to a file
            File file = new File("testdata.xml");
            marshaller.marshal(data, file);

            // Print the XML to the console
            marshaller.marshal(data, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
