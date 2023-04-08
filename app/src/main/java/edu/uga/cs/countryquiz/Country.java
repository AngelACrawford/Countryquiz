package edu.uga.cs.countryquiz;

import java.io.Serializable;

public class Country implements Serializable {
    private String key;
    private String country;
    private String continent;

    public Country(String country, String continent) {
        this.country = country;
        this.continent = continent;
    }


    public String getCountry() {
        return country;
    }

    public String getContinent() {
        return continent;
    }



}

