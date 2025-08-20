package com.hhstechgroup.beans.application;

public class TaxonomyBean {
    //adding Taxonomy in sp21
    private String taxonomy;
    private String taxonomyDescription;
    private String speciality;
    private String claimType;
    private String riskLevel;
    private String fingerPrintVerification;
    private String requireType;

    public String getFingerPrintVerification() {
        return fingerPrintVerification;
    }

    public void setFingerPrintVerification(String fingerPrintVerification) {
        this.fingerPrintVerification = fingerPrintVerification;
    }

    public String getRequireType() {
        return requireType;
    }

    public void setRequireType(String requireType) {
        this.requireType = requireType;
    }
    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public String getTaxonomyDescription() {
        return taxonomyDescription;
    }

    public void setTaxonomyDescription(String taxonomyDescription) {
        this.taxonomyDescription = taxonomyDescription;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }


}
