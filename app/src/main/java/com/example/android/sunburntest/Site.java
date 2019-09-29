package com.example.android.sunburntest;

import java.util.ArrayList;
import java.util.Arrays;

public class Site {
    private String name;
    private String webAddress;
    private ArrayList<String> allowedCountries;

    public Site(String name, String webAddress) {
        this.name = name;
        this.webAddress = webAddress;
    }

    public Site(String name, String webAddress, String[] allowedCountries) {
        this.name = name;
        this.webAddress = webAddress;
        this.allowedCountries = new ArrayList<String>(Arrays.asList(allowedCountries));
    }

    public String getName() {
        return name;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public ArrayList<String> getAllowedCountries() {
        return allowedCountries;
    }
}
