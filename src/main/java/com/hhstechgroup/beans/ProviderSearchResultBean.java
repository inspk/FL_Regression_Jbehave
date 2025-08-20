package com.hhstechgroup.beans;

import lombok.Data;

import java.util.List;

@Data
public class ProviderSearchResultBean {

    private String name;
    private String distance;
    private String specialty;
    private String address;
    private String phone;
    private List<String> languages;
    private List<String> ages;
    private String gender;
    private String npi;
    private String openHours;
    private String payer;
}
