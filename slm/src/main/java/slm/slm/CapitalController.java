package slm.slm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import slm.slm.data.Country;
import slm.slm.data.CountryList;

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
}
