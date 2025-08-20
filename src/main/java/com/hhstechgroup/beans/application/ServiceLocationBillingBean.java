package com.hhstechgroup.beans.application;

public class ServiceLocationBillingBean implements ApplicationSectionData {

    private String physicalAddress;
    private String city;
    private String state;
    private String zip;
    private String genderServed;
    private String languages;
    private String ageRangeServed;
    private String interpretiveServices;
    private String numberOfMembers;
    private String populationServedAvailable;
    private String county;
    private String reservation;
    private String firstName;
    private String lastName;
    private String phone;
    private String emailType;
    private String emailAddress;
    private String afterHoursContactPhone;

    //sp23
     private String acceptingNewPatients;
     public String getAcceptingNewPatients() {
        return acceptingNewPatients;
    }

    public void setAcceptingNewPatients(String acceptingNewPatients) {
        this.acceptingNewPatients = acceptingNewPatients;
    }
    public String getAfterHoursContactPhone() {
        return afterHoursContactPhone;
    }

    public void setAfterHoursContactPhone(String afterHoursContactPhone) {
        this.afterHoursContactPhone = afterHoursContactPhone;
    }

    public String getInterpretiveServices() {
        return interpretiveServices;
    }

    public void setInterpretiveServices(String interpretiveServices) {
        this.interpretiveServices = interpretiveServices;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
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

    public String getGenderServed() {
        return genderServed;
    }

    public void setGenderServed(String genderServed) {
        this.genderServed = genderServed;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getAgeRangeServed() {
        return ageRangeServed;
    }

    public void setAgeRangeServed(String ageRangeServed) {
        this.ageRangeServed = ageRangeServed;
    }

    public String getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(String numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public String getPopulationServedAvailable() {
        return populationServedAvailable;
    }

    public void setPopulationServedAvailable(String populationServedAvailable) {
        this.populationServedAvailable = populationServedAvailable;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    //sp26
    private String primaryServiceLocationAddressLine1;
    public String getPrimaryServiceLocationAddressLine1() {
        return primaryServiceLocationAddressLine1;
    }
    public void setPrimaryServiceLocationAddressLine1(String primaryServiceLocationAddressLine1) {
        this.primaryServiceLocationAddressLine1 = primaryServiceLocationAddressLine1;
    }

    //sp28
    private String secondaryServiceLocationAddressLine1;
    public String getSecondaryServiceLocationAddressLine1() {
        return secondaryServiceLocationAddressLine1;
    }
    public void setSecondaryServiceLocationAddressLine1(String secondaryServiceLocationAddressLine1) {
        this.secondaryServiceLocationAddressLine1 = secondaryServiceLocationAddressLine1;
    }
}

