package slm.slm.data;

public class Country {
    public String name;
    public String capital;

    public Country(){
    }

    public Country(String capital,String name){
        this.capital=capital;
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
