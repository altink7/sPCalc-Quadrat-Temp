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
import java.io.File;
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

    @GetMapping("/{land}/pdf")
    public String createPdfFromCountry(HttpServletRequest request, HttpServletResponse response, @PathVariable String land){
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
        XmlToPdfConverter.createXmlFileAndPdf(countryData, request, response);
        return XmlToPdfConverter.xmlFile.toString();
    }

}
