package com.hhstechgroup.beans;

import lombok.Data;

import java.util.List;

@Data
public class ProviderDataSearchResultBean {
    private String speciality;
    private String address;
    private List<String> enrollmentType;
    private String providerNameAndId;
    private String npi;
    private String zip;

    public String getSitevisitProviderNameAndId() {
        return sitevisitProviderNameAndId;
    }

    public void setSitevisitProviderNameAndId(String sitevisitProviderNameAndId) {
        this.sitevisitProviderNameAndId = sitevisitProviderNameAndId;
    }

    private String sitevisitProviderNameAndId;
}