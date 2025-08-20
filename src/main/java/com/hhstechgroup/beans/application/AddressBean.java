package com.hhstechgroup.beans.application;

import com.hhstechgroup.ui.panels.enrollment.AddressPanel;

public class AddressBean implements ApplicationSectionData {

    private String providerName;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    private String providerAddress;
    private String building;
    private String zip;

    public String getGroupProviderAddress() {
        return groupProviderAddress;
    }

    public void setGroupProviderAddress(String groupProviderAddress) {
        this.groupProviderAddress = groupProviderAddress;
    }

    private String groupProviderAddress;

    public String getGroupBuilding() {
        return groupBuilding;
    }

    public void setGroupBuilding(String groupBuilding) {
        this.groupBuilding = groupBuilding;
    }

    private String groupBuilding;

    //sp26
    private String mailingAddressLine1;
    private String mailingAddressZip;
    private String mailingAddressCountycode;

    public String getMailingAddressLine1() {
        return mailingAddressLine1;
    }

    public void setMailingAddressLine1(String mailingAddressLine1) {
        this.mailingAddressLine1 = mailingAddressLine1; }

    public String getMailingAddressZip() {
        return mailingAddressZip;
    }

    public void setMailingAddressZip(String mailingAddressZip) {
        this.mailingAddressZip = mailingAddressZip;
    }

    public String getMailingAddressCountycode() {
        return mailingAddressCountycode;
    }

    public void setMailingAddressCountycode(String mailingAddressCountycode) {
        this.mailingAddressCountycode = mailingAddressCountycode;
    }
    //sp34
    private String primaryServiceLocationZip;
    private String primaryServiceLocationCountyCode;

    public String getPrimaryServiceLocationZip() {
        return primaryServiceLocationZip;
    }

    public void setPrimaryServiceLocationZip(String primaryServiceLocationZip) {
        this.primaryServiceLocationZip = primaryServiceLocationZip;
    }

    public String getPrimaryServiceLocationCountyCode() {
        return primaryServiceLocationCountyCode;
    }

    public void setPrimaryServiceLocationCountyCode(String primaryServiceLocationCountyCode) {
        this.primaryServiceLocationCountyCode = primaryServiceLocationCountyCode;
    }

    //sp35
    private String mailingAddressCity;
    private String mailingAddressState;
    private String primaryServiceLocationCity;
    private String primaryServiceLocationState;

    public String getMailingAddressState() {
        return mailingAddressState;
    }
    public void setMailingAddressState(String mailingAddressState) {
        this.mailingAddressState = mailingAddressState;
    }
    public String getMailingAddressCity() {
        return mailingAddressCity;
    }
    public void setMailingAddressCity(String mailingAddressCity) {
        this.mailingAddressCity = mailingAddressCity;
    }

    public String getPrimaryServiceLocationCity() {
        return primaryServiceLocationCity;
    }
    public void setPrimaryServiceLocationCity(String primaryServiceLocationCity) {
        this.primaryServiceLocationCity = primaryServiceLocationCity;
    }

    public String getPrimaryServiceLocationState() {
        return primaryServiceLocationState;
    }

    public void setPrimaryServiceLocationState(String primaryServiceLocationState) {
        this.primaryServiceLocationState = primaryServiceLocationState;
    }

    public String getMailingAddressLine2() {
        return mailingAddressLine2;
    }

    public void setMailingAddressLine2(String mailingAddressLine2) {
        this.mailingAddressLine2 = mailingAddressLine2;
    }

    private String mailingAddressLine2;

    public String getBillingAddressContactPersonDetailsHomeOrCorp() {
        return billingAddressContactPersonDetailsHomeOrCorp;
    }

    public void setBillingAddressContactPersonDetailsHomeOrCorp(String billingAddressContactPersonDetailsHomeOrCorp) {
        this.billingAddressContactPersonDetailsHomeOrCorp = billingAddressContactPersonDetailsHomeOrCorp;
    }

    private String billingAddressContactPersonDetailsHomeOrCorp;

    public String getBillingAddressHomeOrCorp() {
        return billingAddressHomeOrCorp;
    }

    public void setBillingAddressHomeOrCorp(String billingAddressHomeOrCorp) {
        this.billingAddressHomeOrCorp = billingAddressHomeOrCorp;
    }

    private String billingAddressHomeOrCorp;

    //sp47.2.1
    private String billingAddress;
    public String getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    private String billingContactPersonDetails;
    public String getBillingContactPersonDetails() {
        return billingContactPersonDetails;
    }
    public void setBillingContactPersonDetails(String billingContactPersonDetails) {
        this.billingContactPersonDetails = billingContactPersonDetails;
    }
    //Demo Service Location
    private  String  genderServiceLocation;
    public String getGenderServiceLocation() { return genderServiceLocation;}
    public void setGenderServiceLocation(String genderServiceLocation) { this.genderServiceLocation = genderServiceLocation; }

    private String acceptingNewPatients;
    private String locationEquipped;
    private String openHours;
    private String emergencyServices;

    public String getAcceptingNewPatients() {
        return acceptingNewPatients;
    }

    public void setAcceptingNewPatients(String acceptingNewPatients) {
        this.acceptingNewPatients = acceptingNewPatients;
    }

    public String getLocationEquipped() {
        return locationEquipped;
    }

    public void setLocationEquipped(String locationEquipped) {
        this.locationEquipped = locationEquipped;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public String getEmergencyServices() {
        return emergencyServices;
    }

    public void setEmergencyServices(String emergencyServices) {
        this.emergencyServices = emergencyServices;
    }




    //SD16 Alternative address code

    private String alternateAddressline1;

    public String getAlternateAddressline1() {
        return alternateAddressline1;
    }

    public void setAlternateAddressline1(String alternateAddressline1) {
        this.alternateAddressline1 = alternateAddressline1;
    }

    private String alternateAddressCity;

    public String getAlternateAddressCity() {
        return alternateAddressCity;
    }

    public void setAlternateAddressCity(String alternateAddressCity) {
        this.alternateAddressCity = alternateAddressCity;
    }

    private String alternateAddressState;

    public String getAlternateAddressState() {
        return alternateAddressState;
    }

    public void setAlternateAddressState(String alternateAddressState) {
        this.alternateAddressState = alternateAddressState;
    }

    private String alternateAddressZipCode;

    public String getAlternateAddressZipCode() {
        return alternateAddressZipCode;
    }

    public void setAlternateAddressZipCode(String alternateAddressZipCode) {
        this.alternateAddressZipCode = alternateAddressZipCode;
    }

    private String alternateAddressCountry;

    public String getAlternateAddressCountry() {
        return alternateAddressCountry;
    }

    public void setAlternateAddressCountry(String alternateAddressCountry) {
        this.alternateAddressCountry = alternateAddressCountry;
    }

    public String getEffectiveStartDate() {
        return effectiveStartDate;
    }

    public void setEffectiveStartDate(String effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    private String effectiveStartDate;

    public String getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(String effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    private String effectiveEndDate;

    public String getHomeOrCorpOfficeAddress() {
        return homeOrCorpOfficeAddress;
    }

    public void setHomeOrCorpOfficeAddress(String homeOrCorpOfficeAddress) {
        this.homeOrCorpOfficeAddress = homeOrCorpOfficeAddress;
    }

    private String homeOrCorpOfficeAddress;

    public String getHomeOrCorpOfficeContactPersonDetails() {
        return homeOrCorpOfficeContactPersonDetails;
    }

    public void setHomeOrCorpOfficeContactPersonDetails(String homeOrCorpOfficeContactPersonDetails) {
        this.homeOrCorpOfficeContactPersonDetails = homeOrCorpOfficeContactPersonDetails;
    }

    private String homeOrCorpOfficeContactPersonDetails;

    public String getServiceLocOfcAddress() {
        return serviceLocOfcAddress;
    }

    public void setServiceLocOfcAddress(String serviceLocOfcAddress) {
        this.serviceLocOfcAddress = serviceLocOfcAddress;
    }

    private String serviceLocOfcAddress;

    public String getServiceLocOfcContactPersonDetails() {
        return serviceLocOfcContactPersonDetails;
    }

    public void setServiceLocOfcContactPersonDetails(String serviceLocOfcContactPersonDetails) {
        this.serviceLocOfcContactPersonDetails = serviceLocOfcContactPersonDetails;
    }

    private String serviceLocOfcContactPersonDetails;

    public String getHomeOrCorpAddressContactPersonDetails() {
        return homeOrCorpAddressContactPersonDetails;
    }

    public void setHomeOrCorpAddressContactPersonDetails(String homeOrCorpAddressContactPersonDetails) {
        this.homeOrCorpAddressContactPersonDetails = homeOrCorpAddressContactPersonDetails;
    }

    private String homeOrCorpAddressContactPersonDetails;



    //.



}
