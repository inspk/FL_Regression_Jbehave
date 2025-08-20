package com.hhstechgroup.beans.application;

public class ProviderIdentifierNumberBean implements ApplicationSectionData {

    private String previouslyEnrolledAsMedicaidChip;
    private String enrolledInMedicare;
    private String particioateP4P;
    private String npi;
    private String npiDate;
    private String groupnpi;
    private String crossOverApplication;

    public String getMedicareCrossoverClaim() {
        return medicareCrossoverClaim;
    }

    public void setMedicareCrossoverClaim(String medicareCrossoverClaim) {
        this.medicareCrossoverClaim = medicareCrossoverClaim;
    }

    private String medicareCrossoverClaim;

    public String getCrossOverApplication() {
        return crossOverApplication;
    }

    public void setCrossOverApplication(String crossOverApplication) {
        this.crossOverApplication = crossOverApplication;
    }

    public String getGroupnpi() {
        return groupnpi;
    }
    public void setGroupnpi(String groupnpi) {
        this.groupnpi = groupnpi;
    }
    public String getNpiDate() {
        return npiDate;
    }
    public void setNpiDate(String npiDate) {
        this.npiDate = npiDate;
    }

    public String getNpi() {
        return npi;
    }

    public void setNpi(String npi) {
        this.npi = npi;
    }

    public String getPreviouslyEnrolledAsMedicaidChip() {
        return previouslyEnrolledAsMedicaidChip;
    }

    public void setPreviouslyEnrolledAsMedicaidChip(String previouslyEnrolledAsMedicaidChip) {
        this.previouslyEnrolledAsMedicaidChip = previouslyEnrolledAsMedicaidChip;
    }

    public String getEnrolledInMedicare() {
        return enrolledInMedicare;
    }

    public void setEnrolledInMedicare(String enrolledInMedicare) {
        this.enrolledInMedicare = enrolledInMedicare;
    }

    public String getParticioateP4P() {
        return particioateP4P;
    }

    public void setParticioateP4P(String particioateP4P) {
        this.particioateP4P = particioateP4P;
    }

    //sp26
    private String deaNumber;
    private String laboratoryServices;


    public String getDeaNumber() {
        return deaNumber;
    }

    public void setDeaNumber(String deaNumber) {
        this.deaNumber = deaNumber;
    }

    public String getLaboratoryServices() {
        return laboratoryServices;
    }

    public void setLaboratoryServices(String laboratoryServices) {
        this.laboratoryServices = laboratoryServices;
    }

    //sp29
    private String pharmacynpi;
    private String ncpdpNumber;
    public String getPharmacynpi() {
        return pharmacynpi;
    }
    public void setPharmacynpi(String pharmacynpi) {
        this.pharmacynpi = pharmacynpi;
    }
    public String getNcpdpNumber() {
        return ncpdpNumber;
    }
    public void setNcpdpNumber(String ncpdpNumber) {
        this.ncpdpNumber = ncpdpNumber;
    }

    //Demo
    private String medicareParticipant;
    public String getMedicareParticipant() { return medicareParticipant; }
    public void setMedicareParticipant(String medicareParticipant) { this.medicareParticipant = medicareParticipant; }

    private String medicalDirector;
    public String getMedicalDirector() { return medicalDirector; }
    public void setMedicalDirector(String medicalDirector) { this.medicalDirector = medicalDirector; }

    public String getTeachingProvider() {
        return teachingProvider;
    }

    public void setTeachingProvider(String teachingProvider) {
        this.teachingProvider = teachingProvider;
    }

    public String getTreatingProvider() {
        return treatingProvider;
    }

    public void setTreatingProvider(String treatingProvider) {
        this.treatingProvider = treatingProvider;
    }

    public String getDrgParticipatingProvider() {
        return drgParticipatingProvider;
    }

    public void setDrgParticipatingProvider(String drgParticipatingProvider) {
        this.drgParticipatingProvider = drgParticipatingProvider;
    }

    public String getPasrrAccess() {
        return pasrrAccess;
    }

    public void setPasrrAccess(String pasrrAccess) {
        this.pasrrAccess = pasrrAccess;
    }

    public String getDrugPricingProgram() {
        return drugPricingProgram;
    }

    public void setDrugPricingProgram(String drugPricingProgram) {
        this.drugPricingProgram = drugPricingProgram;
    }

    public String getCareAgreement() {
        return careAgreement;
    }

    public void setCareAgreement(String careAgreement) {
        this.careAgreement = careAgreement;
    }

    public String getTradingPartnerAuthorization() {
        return tradingPartnerAuthorization;
    }

    public void setTradingPartnerAuthorization(String tradingPartnerAuthorization) {
        this.tradingPartnerAuthorization = tradingPartnerAuthorization;
    }

    private String teachingProvider;
    private String treatingProvider;
    private String drgParticipatingProvider;
    private String pasrrAccess;
    private String drugPricingProgram;
    private String careAgreement;
    private String tradingPartnerAuthorization;

// Alternative identifiers



    public String getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(String identifierType) {
        this.identifierType = identifierType;
    }

    public String getIdentifierId() {
        return identifierId;
    }

    public void setIdentifierId(String identifierId) {
        this.identifierId = identifierId;
    }

    public String getIdentifierEffectiveDate() {
        return identifierEffectiveDate;
    }

    public void setIdentifierEffectiveDate(String identifierEffectiveDate) {
        this.identifierEffectiveDate = identifierEffectiveDate;
    }

    public String getIdentifierEndDate() {
        return identifierEndDate;
    }

    public void setIdentifierEndDate(String identifierEndDate) {
        this.identifierEndDate = identifierEndDate;
    }

    private String identifierType;
    private String identifierId;
    private String identifierEffectiveDate;
    private String identifierEndDate;

    //Pharmacy -- Demo
    private String doYouHaveDeaNumber;
    private String doYouHavePharmacyContact;


    public String getDoYouHaveDeaNumber() {
        return doYouHaveDeaNumber;
    }

    public void setDoYouHaveDeaNumber(String doYouHaveDeaNumber) {
        this.doYouHaveDeaNumber = doYouHaveDeaNumber;
    }

    public String getDoYouHavePharmacyContact() {
        return doYouHavePharmacyContact;
    }

    public void setDoYouHavePharmacyContact(String doYouHavePharmacyContact) {
        this.doYouHavePharmacyContact = doYouHavePharmacyContact;
    }

    private String selectNpi;
    public String getSelectNpi() {
        return selectNpi;
    }

    public void setSelectNpi(String selectNpi) {
        this.selectNpi = selectNpi;
    }

    private String medicaidState;
    public String getMedicaidState() {
        return medicaidState;
    }

    public void setMedicaidState(String medicaidState) {
        this.medicaidState = medicaidState;
    }

    private String insurance;
    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    private String claimSubmit;
    public String getClaimSubmit() {
        return claimSubmit;
    }

    public void setClaimSubmit(String claimSubmit) {
        this.claimSubmit = claimSubmit;
    }

    private String teachingFacility;

    public String getTeachingFacility() {
        return teachingFacility;
    }

    public void setTeachingFacility(String teachingFacility) {
        this.teachingFacility = teachingFacility;
    }

    private String indianHealthServices;
    public String getIndianHealthServices() {
        return indianHealthServices;
    }

    public void setIndianHealthServices(String indianHealthServices) {
        this.indianHealthServices = indianHealthServices;
    }

    private String groupClaimSubmit;

    public String getGroupClaimSubmit() {
        return groupClaimSubmit;
    }

    public void setGroupClaimSubmit(String groupClaimSubmit) {
        this.groupClaimSubmit = groupClaimSubmit;
    }

    private String tpnpi;

    public String getTpnpi() {
        return tpnpi;
    }

    public void setTpnpi(String tpnpi) {
        this.tpnpi = tpnpi;
    }

    private String languageSupported;

    public String getLanguageSupported() {
        return languageSupported;
    }

    public void setLanguageSupported(String languageSupported) {
        this.languageSupported = languageSupported;
    }
}

