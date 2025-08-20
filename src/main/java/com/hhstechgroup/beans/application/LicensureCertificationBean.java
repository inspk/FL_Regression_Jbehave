package com.hhstechgroup.beans.application;

public class LicensureCertificationBean implements ApplicationSectionData {

    private String providerType;
    private String programParticipation;
    private String designedByCms;
    private String speciality;
    private String anotherState;
    private String otherState;
    private String lcaeNumber;
    private String type;
    private String state;
    private String effectiveDate;
    private String expirationDate;
    private String groupSpeciality;

   //new sp20
    private String specialitiesandsubspecialities;

    public String getSpecialitiesandsubspecialities() {
        return specialitiesandsubspecialities;
    }

    public void setSpecialitiesandsubspecialities(String specialitiesandsubspecialities) {
        this.specialitiesandsubspecialities = specialitiesandsubspecialities;
    }

    public String getGroupSpeciality() {
        return groupSpeciality;
    }

    public void setGroupSpeciality(String groupSpeciality) {
        this.groupSpeciality = groupSpeciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public String getProgramParticipation() {
        return programParticipation;
    }

    public void setProgramParticipation(String programParticipation) {
        this.programParticipation = programParticipation;
    }

    public String getDesignedByCms() {
        return designedByCms;
    }

    public void setDesignedByCms(String designedByCms) {
        this.designedByCms = designedByCms;
    }

    public String getAnotherState() {
        return anotherState;
    }

    public void setAnotherState(String anotherState) {
        this.anotherState = anotherState;
    }

    public String getOtherState() {
        return otherState;
    }

    public void setOtherState(String otherState) {
        this.otherState = otherState;
    }

    public String getLcaeNumber() {
        return lcaeNumber;
    }

    public void setLcaeNumber(String lcaeNumber) {
        this.lcaeNumber = lcaeNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    //sp26
    private String taxonomyCategory;
    public String getTaxonomyCategory() {
        return taxonomyCategory;
    }
    public void setTaxonomyCategory(String taxonomyCategory) {
        this.taxonomyCategory = taxonomyCategory;
    }
    private String primaryTaxonomy;
    public String getPrimaryTaxonomy() {
        return primaryTaxonomy;
    }
    public void setPrimaryTaxonomy(String primaryTaxonomy) {
        this.primaryTaxonomy = primaryTaxonomy;
    }

    //sp29
    private String pharmacyType;
    public String getPharmacyType() {
        return pharmacyType;
    }
    public void setPharmacyType(String pharmacyType) {
        this.pharmacyType = pharmacyType;
    }

    //Demo for Individual
    public String getDeaNumber() {
        return deaNumber;
    }

    public void setDeaNumber(String deaNumber) {
        this.deaNumber = deaNumber;
    }

    private String deaNumber;
}
