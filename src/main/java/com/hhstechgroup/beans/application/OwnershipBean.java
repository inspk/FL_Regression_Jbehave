package com.hhstechgroup.beans.application;

public class OwnershipBean implements ApplicationSectionData {

    private String hadOwnershipInAnyOrganization;
    private String effectiveStartDate;
    private String fein;

    private String ownershipnpi;

    public String getDbaName() {
        return dbaName;
    }

    public void setDbaName(String dbaName) {
        this.dbaName = dbaName;
    }

    private String dbaName;

    private String previouslyManagedOrganizations;
    private String hasOwnershipInterest;
    private String hasFamilyOwnershipInterest;
    private String lastName;
    private String firstName;
    private String relationship;
    private String organizationLegalBusinessName;
    private String subcontractorName;


    public String getOwnershipnpi() {
        return ownershipnpi;
    }

    public void setOwnershipnpi(String ownershipnpi) {
        this.ownershipnpi = ownershipnpi;
    }

    public String getSelectProgram() {
        return selectProgram;
    }

    public void setSelectProgram(String selectProgram) {
        this.selectProgram = selectProgram;
    }

    private String selectProgram;
    public String getOrganizationLegalBusinessName() {
        return organizationLegalBusinessName;
    }

    public void setOrganizationLegalBusinessName(String organizationLegalBusinessName) {
        this.organizationLegalBusinessName = organizationLegalBusinessName;
    }
    public String getFein() {
        return fein;
    }

    public void setFein(String fein) {
        this.fein = fein;
    }
    public String getTypeOfContract() {
        return typeOfContract;
    }

    public void setTypeOfContract(String typeOfContract) {
        this.typeOfContract = typeOfContract;
    }

    private String typeOfContract;

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    private String middleName;
    public String getFillSsn() {
        return fillSsn;
    }

    public void setFillSsn(String fillSsn) {
        this.fillSsn = fillSsn;
    }

    private String fillSsn;
    private String mi;
    private String country;
    private String addressLine1;
    private String addressLine2;

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    private String effectiveDate;

    public String getPercentOfInterest() {
        return percentOfInterest;
    }

    public void setPercentOfInterest(String percentOfInterest) {
        this.percentOfInterest = percentOfInterest;
    }

    private String percentOfInterest;

    public String getTypeOfInterest() {
        return typeOfInterest;
    }

    public void setTypeOfInterest(String typeOfInterest) {
        this.typeOfInterest = typeOfInterest;
    }

    private String typeOfInterest;


    public String getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(String effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    private String effectiveEndDate;
    private String city;
    private String state;
    private String zip;
    public String getEffectiveStartDate() {
        return effectiveStartDate;
    }

    public void setEffectiveStartDate(String effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }



    public String getLessThanFivePercent() {
        return lessThanFivePercent;
    }

    public void setLessThanFivePercent(String lessThanFivePercent) {
        this.lessThanFivePercent = lessThanFivePercent;
    }

    private String lessThanFivePercent;

    public String getHadOwnershipInAnyOrganization() {
        return hadOwnershipInAnyOrganization;
    }

    public void setHadOwnershipInAnyOrganization(String hadOwnershipInAnyOrganization) {
        this.hadOwnershipInAnyOrganization = hadOwnershipInAnyOrganization;
    }

    public String getPreviouslyManagedOrganizations() {
        return previouslyManagedOrganizations;
    }

    public void setPreviouslyManagedOrganizations(String previouslyManagedOrganizations) {
        this.previouslyManagedOrganizations = previouslyManagedOrganizations;
    }

    public String getHasOwnershipInterest() {
        return hasOwnershipInterest;
    }

    public void setHasOwnershipInterest(String hasOwnershipInterest) {
        this.hasOwnershipInterest = hasOwnershipInterest;
    }

    public String getHasFamilyOwnershipInterest() {
        return hasFamilyOwnershipInterest;
    }

    public void setHasFamilyOwnershipInterest(String hasFamilyOwnershipInterest) {
        this.hasFamilyOwnershipInterest = hasFamilyOwnershipInterest;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getSubcontractorName() {
        return subcontractorName;
    }

    public void setSubcontractorName(String subcontractorName) {
        this.subcontractorName = subcontractorName;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
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

    private String ownershipCode;
    private String personOwnership;
    private String entityOwnership;
    private String personOrEntityOwnership;
    private String corporationOwnership;
    private String partnershipOwnership;
    private String subcontractorOwnership;
    private String familymembersOwnership;
    private String ownersOwnership;


    public String getOwnershipCode() {
        return ownershipCode;
    }

    public void setOwnershipCode(String ownershipCode) {
        this.ownershipCode = ownershipCode;
    }

    public String getPersonOwnership() {
        return personOwnership;
    }

    public void setPersonOwnership(String personOwnership) {
        this.personOwnership = personOwnership;
    }

    public String getEntityOwnership() {
        return entityOwnership;
    }

    public void setEntityOwnership(String entityOwnership) {
        this.entityOwnership = entityOwnership;
    }

    public String getPersonOrEntityOwnership() {
        return personOrEntityOwnership;
    }

    public void setPersonOrEntityOwnership(String personOrEntityOwnership) {
        this.personOrEntityOwnership = personOrEntityOwnership;
    }

    public String getCorporationOwnership() {
        return corporationOwnership;
    }

    public void setCorporationOwnership(String corporationOwnership) {
        this.corporationOwnership = corporationOwnership;
    }

    public String getPartnershipOwnership() {
        return partnershipOwnership;
    }

    public void setPartnershipOwnership(String partnershipOwnership) {
        this.partnershipOwnership = partnershipOwnership;
    }

    public String getSubcontractorOwnership() {
        return subcontractorOwnership;
    }

    public void setSubcontractorOwnership(String subcontractorOwnership) {
        this.subcontractorOwnership = subcontractorOwnership;
    }

    public String getFamilymembersOwnership() {
        return familymembersOwnership;
    }

    public void setFamilymembersOwnership(String familymembersOwnership) {
        this.familymembersOwnership = familymembersOwnership;
    }

    public String getOwnersOwnership() {
        return ownersOwnership;
    }

    public void setOwnersOwnership(String ownersOwnership) {
        this.ownersOwnership = ownersOwnership;
    }


    private String personOwnership1;
    private String billedEntityOwnership;

    public String getPersonOwnership1() {
        return personOwnership1;
    }

    public void setPersonOwnership1(String personOwnership1) {
        this.personOwnership1 = personOwnership1;
    }

    public String getBilledEntityOwnership() {
        return billedEntityOwnership;
    }

    public void setBilledEntityOwnership(String billedEntityOwnership) {
        this.billedEntityOwnership = billedEntityOwnership;
    }
}
