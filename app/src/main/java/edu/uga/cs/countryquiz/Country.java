package edu.uga.cs.countryquiz;

import java.io.Serializable;

public class Country implements Serializable {
    private String key;
    private String country;
    private String continent;

    public Country(String key, String country, String continent) {
        this.key = key;
        this.country = country;
        this.continent = continent;
    }

    public String getKey() {
        return key;
    }

    public String getCountry() {
        return country;
    }

    public String getContinent() {
        return continent;
    }

    public String toString(){
        String msg = "Id = " + this.getKey() + "| Country = " + this.getCountry() + " | Cont = " + this.getContinent() ;

        return msg ;
    }

}

