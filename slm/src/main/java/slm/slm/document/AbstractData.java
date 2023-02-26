package slm.slm.document;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
public class AbstractData<T> {
    private String application;
    private LocalDate date;
    private T data;

    public AbstractData() {
        // Required by JAXB
    }

    public AbstractData(String application, LocalDate date, T data) {
        this.application = application;
        this.date = date;
        this.data = data;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

