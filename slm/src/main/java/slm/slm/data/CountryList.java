package slm.slm.data;


import java.util.ArrayList;
import java.util.Arrays;


public class CountryList {
            static ArrayList<Country> list = new ArrayList<>();

            public static void add(Country[] arrayList){
                list.addAll(Arrays.asList(arrayList));
            }

    public static ArrayList<Country> getList() {
        return list;
    }
}
