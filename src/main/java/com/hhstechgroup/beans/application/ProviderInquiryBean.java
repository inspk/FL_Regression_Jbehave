package com.hhstechgroup.beans.application;

public class ProviderInquiryBean  implements ApplicationSectionData  {
    //sp23
    private String npi;
    private String enrollmentType;
    private String address;
    private String specialty;
    private String providerNameAndId;
    private String countryCode;
    private String taxonomyDescription;
    private String providerStatus;
    private String city;
    private String taxonomyId;
    private String fien;
    private String zip;
    private String acceptingnewpatient;
    private String ssn;

    public String getSsn() { return ssn; }

    public void setSsn(String ssn) { this.ssn = ssn; }

    public String getProviderStatus() {
        return providerStatus;
    }

    public void setProviderStatus(String providerStatus) {
        this.providerStatus = providerStatus;
    }

    public String getNpi() {
        return npi;
    }

    public void setNpi(String npi) {
        this.npi = npi;
    }

    public String getEnrollmentType() {
        return enrollmentType;
    }

    public void setEnrollmentType(String enrollmentType) {
        this.enrollmentType = enrollmentType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getProviderNameAndId() {
        return providerNameAndId;
    }

    public void setProviderNameAndId(String providerNameAndId) {
        this.providerNameAndId = providerNameAndId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTaxonomyDescription() {
        return taxonomyDescription;
    }

    public void setTaxonomyDescription(String taxonomyDescription) {
        this.taxonomyDescription = taxonomyDescription;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTaxonomyId() {
        return taxonomyId;
    }

    public void setTaxonomyId(String taxonomyId) {
        this.taxonomyId = taxonomyId;
    }

    public String getFien() {
        return fien;
    }

    public void setFien(String fien) {
        this.fien = fien;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAcceptingnewpatient() {
        return acceptingnewpatient;
    }

    public void setAcceptingnewpatient(String acceptingnewpatient) {
        this.acceptingnewpatient = acceptingnewpatient;
    }
    //sp30
    private String state;
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    //sp47.2.1
    private String status;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    private String massupdatespecialty;
    public String getMassupdatespecialty() {
        return massupdatespecialty;
    }
    public void setMassupdatespecialty(String massupdatespecialty) {
        this.massupdatespecialty = massupdatespecialty;
    }

    private String massupdateStatus;

    public String getMassupdateStatus() {
        return massupdateStatus;
    }

    public void setMassupdateStatus(String massupdateStatus) {
        this.massupdateStatus = massupdateStatus;
    }

    private String programParticipation;
    private String state1;
    private String serviceLocation;

    public String getProgramParticipation() {
        return programParticipation;
    }

    public void setProgramParticipation(String programParticipation) {
        this.programParticipation = programParticipation;
    }

    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    public String getServiceLocation() {
        return serviceLocation;
    }

    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation = serviceLocation;
    }
}

