package com.hhstechgroup.beans.application;

public class OtherCredentialingInformationBean implements ApplicationSectionData{
    private String typeOfTraining;
    private String organizationName;
    private String effectiveStartDate;
    private String effectiveEndDate;
    private String gradutaionType;
    private String professionalSchoolName;

    public String getMedicalSchool() {
        return medicalSchool;
    }

    public void setMedicalSchool(String medicalSchool) {
        this.medicalSchool = medicalSchool;
    }

    private String medicalSchool;
    private String professionalSchoolAddress;
    public String getTypeOfTraining() {
        return typeOfTraining;
    }

    public void setTypeOfTraining(String typeOfTraining) {
        this.typeOfTraining = typeOfTraining;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getEffectiveStartDate() {
        return effectiveStartDate;
    }

    public void setEffectiveStartDate(String effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    public String getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(String effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    public String getGradutaionType() {
        return gradutaionType;
    }

    public void setGradutaionType(String gradutaionType) {
        this.gradutaionType = gradutaionType;
    }

    public String getProfessionalSchoolName() {
        return professionalSchoolName;
    }

    public void setProfessionalSchoolName(String professionalSchoolName) {
        this.professionalSchoolName = professionalSchoolName;
    }

    public String getProfessionalSchoolAddress() {
        return professionalSchoolAddress;
    }

    public void setProfessionalSchoolAddress(String professionalSchoolAddress) {
        this.professionalSchoolAddress = professionalSchoolAddress;
    }



}
