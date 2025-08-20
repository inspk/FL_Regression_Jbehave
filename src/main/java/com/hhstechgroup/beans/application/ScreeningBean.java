package com.hhstechgroup.beans.application;

public class ScreeningBean {

    private String dob;
    private String gender;
    private String revalidationMissed;
    private String npi;
    private String fein;
    private String taxonomy;
    private String businessName;
    private String zip;

    //Custom Screening Thresholds for Group parameters
    private String businessAddress;
    private String fingerprint;
    private String authentication;
    private String licenseLimitations;
    private String dba;
    private String bankruptcy;
    private String lien;
    private String applicationFee;
    private String judgement;
    private String disclosure;
    private String deaNumberIsInvalid;
    private String landLineAndWireless;

    //Custom Screening Thresholds for Individual parameters. Bug is not fixed. Individual parameters doesn't display drop-down lists.
    private String improperlySsn;
    private String licenseExpired;

    public String getCutOffPersent() {
        return cutOffPersent;
    }

    public void setCutOffPersent(String cutOffPersent) {
        this.cutOffPersent = cutOffPersent;
    }

    private String invalidExpiredNpi;
    private String invalidExpiredFeinTin;
    private String unsatisfactorySiteVisits ;
    private String criminalRecord;
    private String deathIndicatorsRecords;
    private String excludedIndividualsRecords;
    private String excludedPartiesRecords;
    private String sanctions;
    private String deaNumber;
    private String cutOffPersent;

    public String getDeaNumber() {
        return deaNumber;
    }

    public void setDeaNumber(String deaNumber) {
        this.deaNumber = deaNumber;
    }

    public String getRevalidationMissed() {
        return revalidationMissed;
    }

    public void setRevalidationMissed(String revalidationMissed) {
        this.revalidationMissed = revalidationMissed;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    public String getNpi() {
        return npi;
    }

    public String getFein() {
        return fein;
    }

    public void setFein(String fein) {
        this.fein = fein;
    }

    public void setNpi(String npi) {
        this.npi = npi;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public String getImproperlySsn() {
        return improperlySsn;
    }

    public void setImproperlySsn(String improperlySsn) {
        this.improperlySsn = improperlySsn;
    }

    public String getLicenseExpired() {
        return licenseExpired;
    }

    public void setLicenseExpired(String licenseExpired) {
        this.licenseExpired = licenseExpired;
    }

    public String getInvalidExpiredNpi() {
        return invalidExpiredNpi;
    }

    public void setInvalidExpiredNpi(String invalidExpiredNpi) {
        this.invalidExpiredNpi = invalidExpiredNpi;
    }

    public String getInvalidExpiredFeinTin() {
        return invalidExpiredFeinTin;
    }

    public void setInvalidExpiredFeinTin(String invalidExpiredFeinTin) {
        this.invalidExpiredFeinTin = invalidExpiredFeinTin;
    }

    public String getUnsatisfactorySiteVisits() {
        return unsatisfactorySiteVisits;
    }

    public void setUnsatisfactorySiteVisits(String unsatisfactorySiteVisits) {
        this.unsatisfactorySiteVisits = unsatisfactorySiteVisits;
    }

    public String getCriminalRecord() {
        return criminalRecord;
    }

    public void setCriminalRecord(String criminalRecord) {
        this.criminalRecord = criminalRecord;
    }

    public String getDeathIndicatorsRecords() {
        return deathIndicatorsRecords;
    }

    public void setDeathIndicatorsRecords(String deathIndicatorsRecords) {
        this.deathIndicatorsRecords = deathIndicatorsRecords;
    }

    public String getExcludedIndividualsRecords() {
        return excludedIndividualsRecords;
    }

    public void setExcludedIndividualsRecords(String excludedIndividualsRecords) {
        this.excludedIndividualsRecords = excludedIndividualsRecords;
    }

    public String getExcludedPartiesRecords() {
        return excludedPartiesRecords;
    }

    public void setExcludedPartiesRecords(String excludedPartiesRecords) {
        this.excludedPartiesRecords = excludedPartiesRecords;
    }

    public String getSanctions() {
        return sanctions;
    }

    public void setSanctions(String sanctions) {
        this.sanctions = sanctions;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }


    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }


    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public String getLicenseLimitations() {
        return licenseLimitations;
    }

    public void setLicenseLimitations(String licenseLimitations) {
        this.licenseLimitations = licenseLimitations;
    }

    public String getDba() {
        return dba;
    }

    public void setDba(String dba) {
        this.dba = dba;
    }

    public String getBankruptcy() {
        return bankruptcy;
    }

    public void setBankruptcy(String bankruptcy) {
        this.bankruptcy = bankruptcy;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getApplicationFee() {
        return applicationFee;
    }

    public void setApplicationFee(String applicationFee) {
        this.applicationFee = applicationFee;
    }

    public String getJudgement() {
        return judgement;
    }

    public void setJudgement(String judgement) {
        this.judgement = judgement;
    }

    public String getDisclosure() {
        return disclosure;
    }

    public void setDisclosure(String disclosure) {
        this.disclosure = disclosure;
    }

    public String getDeaNumberIsInvalid() {
        return deaNumberIsInvalid;
    }

    public void setDeaNumberIsInvalid(String deaNumberIsInvalid) {
        this.deaNumberIsInvalid = deaNumberIsInvalid;
    }

    public String getLandLineAndWireless() {
        return landLineAndWireless;
    }

    public void setLandLineAndWireless(String landLineAndWireless) {
        this.landLineAndWireless = landLineAndWireless;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    //sp29
    private String screeingproviderdob;

    public String getScreeingproviderdob() {
        return screeingproviderdob;
    }

    public void setScreeingproviderdob(String screeingproviderdob) {
        this.screeingproviderdob = screeingproviderdob;
    }

    private String monitoringfrequency;

    public String getMonitoringfrequency() {
        return monitoringfrequency; }

    public void setMonitoringfrequency(String monitoringfrequency) {
        this.monitoringfrequency = monitoringfrequency; }
}
