package com.hhstechgroup.beans.application;

import lombok.Data;

@Data
public class IdentifyingInformationBean implements ApplicationSectionData {

    private String prefix;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String mi;
    private String suffix;
    private String gender;
    private String dateOfBirth;
    private String countryOfBirth;
    private String state;
    private String shareWithMembers;
    private String email;
    private String ssn;
    private String taxReportingNumber;
    private String race;
    private String previouslyEnrolled;
    private String idType;
    private String npiApi;
    private String mcoName;
    private String federalEmployerIdentification;
    private String fiscalYearEnd;
    private String mainContactEmail;
    private String doingBusinessName;
    private String differentName;
    private String formerDbaName;
    private String taxExemptStatus;
    private String groupName;
    private String taxEntityType;
    //latest
    private String businessName;
    private String providerType;

    public String getMcoEmail() {
        return mcoEmail;
    }

    public void setMcoEmail(String mcoEmail) {
        this.mcoEmail = mcoEmail;
    }

    private String mcoEmail;


    public String getPlanLegalName() {
        return planLegalName;
    }

    public void setPlanLegalName(String planLegalName) {
        this.planLegalName = planLegalName;
    }

    private String planLegalName;

    public String getAppliationContactName() {
        return appliationContactName;
    }

    public void setAppliationContactName(String appliationContactName) {
        this.appliationContactName = appliationContactName;
    }

    private String appliationContactName;

    public String getApplicationContactPhone() {
        return applicationContactPhone;
    }

    public void setApplicationContactPhone(String applicationContactPhone) {
        this.applicationContactPhone = applicationContactPhone;
    }

    private String applicationContactPhone;

    public String getApplicationContactNum() {
        return applicationContactNum;
    }

    public void setApplicationContactNum(String applicationContactNum) {
        this.applicationContactNum = applicationContactNum;
    }

    private String applicationContactNum;


    //sp26
    private String mediacidPayment;

    public String getMediacidPayment() {
        return mediacidPayment; }

    public void setMediacidPayment(String mediacidPayment) {
        this.mediacidPayment = mediacidPayment; }

    private String typeOfBusiness;
    public String getTypeOfBusiness() {
        return typeOfBusiness;
    }
    public void setTypeOfBusiness(String typeOfBusiness) {
        this.typeOfBusiness = typeOfBusiness;
    }

    //sp26 for groupprovider
    private String providerName;
    public String getProviderName() {
        return providerName;
    }
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    //sp 32 profit status
    private String profitStatus;

    public String getProfitStatus() {
        return profitStatus;
    }

    public void setProfitStatus(String profitStatus) {
        this.profitStatus = profitStatus;
    }

    //sp35
    private String stateofBirth;
    public String getStateofBirth() {
        return stateofBirth;
    }
    public void setStateofBirth(String stateofBirth) {
        this.stateofBirth = stateofBirth;
    }

    //Demo

    private String title;
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    private String middleName;
    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    private String dba;
    public String getdba() { return dba; }
    public void setdba(String dba) { this.dba = dba; }

    //PEM

    private String fax;
    private String alternateEmail;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    //Pharmacy-- Demo

    private String differentDbaName;
    public String getDifferentDbaName() {
        return differentDbaName;
    }

    public void setDifferentDbaName(String differentDbaName) {
        this.differentDbaName = differentDbaName;
    }

    private String taxExempt;
    public String getTaxExempt() {
        return taxExempt;
    }
    public void setTaxExempt(String taxExempt) {
        this.taxExempt = taxExempt;
    }


    private String enrollmentDate;
    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }


    private String reasonCode;
    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    private String paymentrecived;
    public String getPaymentrecived() {
        return paymentrecived;
    }

    public void setPaymentrecived(String paymentrecived) {
        this.paymentrecived = paymentrecived;
    }

    private String selectorp;
    public String getSelectorp() {
        return selectorp;
    }

    public void setSelectorp(String selectorp) {
        this.selectorp = selectorp;
    }



    private String dbaName;
    public String getDbaName() {
        return dbaName;
    }

    public void setDbaName(String dbaName) {
        this.dbaName = dbaName;
    }

    private String providerLegalBusinessName;

    public String getProviderLegalBusinessName() {
        return providerLegalBusinessName;}

    public void setProviderLegalBusinessName(String providerLegalBusinessName) {
        this.providerLegalBusinessName = providerLegalBusinessName;}

    private String differentLegalName;

    public String getDifferentLegalName() {
        return differentLegalName;
    }

    public void setDifferentLegalName(String differentLegalName) {
        this.differentLegalName = differentLegalName;
    }

    private String isChangeOwnFein;

    public String getIsChangeOwnFein() {
        return isChangeOwnFein;
    }

    public void setIsChangeOwnFein(String isChangeOwnFein) {
        this.isChangeOwnFein = isChangeOwnFein;
    }

    private String fiscalEnd;

    public String getFiscalEnd() {
        return fiscalEnd;
    }

    public void setFiscalEnd(String fiscalEnd) {
        this.fiscalEnd = fiscalEnd;
    }

    private String addressLine1;
    private String city;
    private String fein;
    private String zipCode;
    private String county;

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFein() {
        return fein;
    }

    public void setFein(String fein) {
        this.fein = fein;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    private String degree;

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }


}
