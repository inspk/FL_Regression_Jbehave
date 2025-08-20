package com.hhstechgroup.beans.application;

public class LicenseInformationBean implements ApplicationSectionData {
    //sp26
    private String licenseNumber;
    private String licenseType;
    private String licenseIssuedState;
    private String licensEffectiveDate;
    private String licenseExpirationDate;

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getLicenseIssuedState() {
        return licenseIssuedState;
    }

    public void setLicenseIssuedState(String licenseIssuedState) {
        this.licenseIssuedState = licenseIssuedState;
    }

    public String getLicensEffectiveDate() {
        return licensEffectiveDate;
    }

    public void setLicensEffectiveDate(String licensEffectiveDate) {
        this.licensEffectiveDate = licensEffectiveDate;
    }

    public String getLicenseExpirationDate() {
        return licenseExpirationDate;
    }

    public void setLicenseExpirationDate(String licenseExpirationDate) {
        this.licenseExpirationDate = licenseExpirationDate;
    }
    //sp28
    private String newlicenseType;
    private String newlicenseIssuedState;
    private String newlicensEffectiveDate;
    private String newlicenseExpirationDate;
    private String newlicenseNumber;

    public String getNewlicenseNumber() {
        return newlicenseNumber;
    }

    public void setNewlicenseNumber(String newlicenseNumber) {
        this.newlicenseNumber = newlicenseNumber;
    }

    public String getNewlicenseType() {
        return newlicenseType;
    }

    public void setNewlicenseType(String newlicenseType) {
        this.newlicenseType = newlicenseType;
    }

    public String getNewlicenseIssuedState() {
        return newlicenseIssuedState;
    }

    public void setNewlicenseIssuedState(String newlicenseIssuedState) {
        this.newlicenseIssuedState = newlicenseIssuedState;
    }

    public String getNewlicensEffectiveDate() {
        return newlicensEffectiveDate;
    }

    public void setNewlicensEffectiveDate(String newlicensEffectiveDate) {
        this.newlicensEffectiveDate = newlicensEffectiveDate;
    }

    public String getNewlicenseExpirationDate() {
        return newlicenseExpirationDate;
    }

    public void setNewlicenseExpirationDate(String newlicenseExpirationDate) {
        this.newlicenseExpirationDate = newlicenseExpirationDate;
    }

    //sp29
    private String pharmacyLicenseNumber;
    public String getPharmacylicenseLicenseNumber() {
        return pharmacyLicenseNumber;
    }

    public void setPharmacylicenseLicenseNumber(String pharmacylicenseLicenseNumber) {
        this.pharmacyLicenseNumber = pharmacylicenseLicenseNumber;
    }
    private String pharmacylicenseIssuedState;
    public String getPharmacylicenseIssuedState() {
        return pharmacylicenseIssuedState;
    }
    public void setPharmacylicenseIssuedState(String pharmacylicenseIssuedState) {
        this.pharmacylicenseIssuedState = pharmacylicenseIssuedState;
    }

    //Demo Individual Section - Affiliation

    private String npiFeinNumber;
    private String affiliationType;
    private String effectiveDateFrom;
    private String effectiveDateTo;

    public String getNpiFeinNumber() {
        return npiFeinNumber;
    }

    public void setNpiFeinNumber(String npiFeinNumber) {
        this.npiFeinNumber = npiFeinNumber;
    }

    public String getAffiliationType() {
        return affiliationType;
    }

    public void setAffiliationType(String affiliationType) {
        this.affiliationType = affiliationType;
    }

    public String getEffectiveDateFrom() {
        return effectiveDateFrom;
    }

    public void setEffectiveDateFrom(String effectiveDateFrom) {
        this.effectiveDateFrom = effectiveDateFrom;
    }

    public String getEffectiveDateTo() {
        return effectiveDateTo;
    }

    public void setEffectiveDateTo(String effectiveDateTo) {
        this.effectiveDateTo = effectiveDateTo;
    }

    //Demo - Facility Type - Certification Section in Taxonomy

    private String certificateNumber;
    private String certificateEffectiveDate;

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getCertificateEffectiveDate() {
        return certificateEffectiveDate;
    }

    public void setCertificateEffectiveDate(String certificateEffectiveDate) {
        this.certificateEffectiveDate = certificateEffectiveDate;
    }
}
