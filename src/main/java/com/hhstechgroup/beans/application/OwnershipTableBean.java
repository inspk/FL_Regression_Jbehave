package com.hhstechgroup.beans.application;

public class OwnershipTableBean implements ApplicationSectionData {

    private String businessName;
    private String effectiveDate;
    private String endDate;
    private String fein;
    private String medicareOrTitle;
    private String currentMedicare;
    private String currentNpiApi;
    private String idType;
    private String country;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFein() {
        return fein;
    }

    public void setFein(String fein) {
        this.fein = fein;
    }

    public String getMedicareOrTitle() {
        return medicareOrTitle;
    }

    public void setMedicareOrTitle(String medicareOrTitle) {
        this.medicareOrTitle = medicareOrTitle;
    }

    public String getCurrentMedicare() {
        return currentMedicare;
    }

    public void setCurrentMedicare(String currentMedicare) {
        this.currentMedicare = currentMedicare;
    }

    public String getCurrentNpiApi() {
        return currentNpiApi;
    }

    public void setCurrentNpiApi(String currentNpiApi) {
        this.currentNpiApi = currentNpiApi;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
