package slm.slm.document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement(name = "countryData")
@XmlAccessorType(XmlAccessType.FIELD)
public class CountryData extends AbstractData<String> {
    @XmlElement
    private String country;
    @XmlElement
    private String capitalCity;

    public CountryData() {
        // Required by JAXB
    }

    public CountryData(String application, LocalDate date, String data, String country, String capitalCity) {
        super(application, date, data);
        this.country = country;
        this.capitalCity = capitalCity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }
}
