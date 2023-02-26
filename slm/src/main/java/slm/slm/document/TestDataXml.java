package slm.slm.document;

import java.time.LocalDate;

public class TestDataXml {
    public static void main(String[] args) {
        // Create some sample data for testing
        CountryData data = new CountryData(
                "My Application",
                LocalDate.now(),
                "Some data",
                "Canada",
                "Ottawa"
        );

        XmlToPdfConverter.createXmlFileAndPdf(data,null,null);
    }
}
