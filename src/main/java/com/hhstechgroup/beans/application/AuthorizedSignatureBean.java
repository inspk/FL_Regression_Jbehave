package com.hhstechgroup.beans.application;

public class AuthorizedSignatureBean implements ApplicationSectionData {
    //sp26
    private String signatureOfPersonSubmittingEnrollment;
    private String titleOfPersonSubmittingEnrollment;
    private String submissionDate;

    public String getAuthorizedSignatoryName() {
        return authorizedSignatoryName;
    }

    public void setAuthorizedSignatoryName(String authorizedSignatoryName) {
        this.authorizedSignatoryName = authorizedSignatoryName;
    }

    private String authorizedSignatoryName;

    public String getSignatureOfPersonSubmittingEnrollment() {
        return signatureOfPersonSubmittingEnrollment;
    }

    public void setSignatureOfPersonSubmittingEnrollment(String signatureOfPersonSubmittingEnrollment) {
        this.signatureOfPersonSubmittingEnrollment = signatureOfPersonSubmittingEnrollment;
    }

    public String getTitleOfPersonSubmittingEnrollment() {
        return titleOfPersonSubmittingEnrollment;
    }

    public void setTitleOfPersonSubmittingEnrollment(String titleOfPersonSubmittingEnrollment) {
        this.titleOfPersonSubmittingEnrollment = titleOfPersonSubmittingEnrollment;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    private String title;
    private String name;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
