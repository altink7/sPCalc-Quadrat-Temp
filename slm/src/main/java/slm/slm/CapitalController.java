package slm.slm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import slm.slm.data.Country;
import slm.slm.data.CountryList;
import slm.slm.document.CountryData;
import slm.slm.document.TestDataXml;
import slm.slm.document.XmlToPdfConverter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("api/capital")
public class CapitalController {

    Country[] liste= { //TestData
            new Country("Vienna", "Austria"),
            new Country("Berlin", "Germany"),
            new Country("Paris", "France"),
            new Country("Bern", "Switzerland"),
            new Country("Amsterdam", "Netherlands")};



    @GetMapping("/{land}")
    public String capital(@PathVariable String land){
        CountryList.add(liste);
        String match="kein Ergebnis :(((";

        for(Country c: CountryList.getList()){
            if(c.getName().matches(land)){
                return c.getCapital();
            }
        }
        return match;
    }

    @GetMapping("/{land}/{format}")
    public String createPdfFromCountry(HttpServletRequest request, HttpServletResponse response, @PathVariable String land, @PathVariable String format){
        CountryList.add(liste);
        Country country = null;

        for(Country c: CountryList.getList()){
            if(c.getName().matches(land)){
                country = c;
            }
        }
        if(country == null){
            return "Country not found";
        }
        CountryData countryData = new CountryData("Capital-Rest", LocalDate.now(), "Capital-Country", country.getName(), country.getCapital());
        if(format.matches("pdf")) {
            XmlToPdfConverter.createXmlFileAndPdf(countryData, request, response,true);
            return "PDF created";
        }else if(format.matches("xml")){
            XmlToPdfConverter.createXmlFileAndPdf(countryData, request, response,false);
            return readXmlFile(XmlToPdfConverter.xmlFile);
        }else{
            return "Format not supported";
        }
    }
    public static String readXmlFile(File file){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
