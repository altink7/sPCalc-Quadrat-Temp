package slm.slm.document;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
public class CountryData extends AbstractData<String> {
    private String country;
    private String capitalCity;

    public CountryData() {
        // Required by JAXB
    }

    public CountryData(String application, LocalDate date, String data, String country, String capitalCity) {
        super(application, date, data);
        this.country = country;
        this.capitalCity = capitalCity;
    }

    @XmlElement
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement
    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }
}
