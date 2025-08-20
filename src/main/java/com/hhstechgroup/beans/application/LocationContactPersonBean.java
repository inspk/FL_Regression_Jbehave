package com.hhstechgroup.beans.application;

public class LocationContactPersonBean implements ApplicationSectionData {

    private String lastName;
    private String firstName;
    private String phone;
    private String position;
    private String mi;
    private String ext;
    private String fax;
    private String email;

    public String getBillingContactDetails() {
        return billingContactDetails;
    }

    public void setBillingContactDetails(String billingContactDetails) {
        this.billingContactDetails = billingContactDetails;
    }

    private String billingContactDetails;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String attentionLine;

    public String getAttentionLine() {
        return attentionLine;
    }

    public void setAttentionLine(String attentionLine) {
        this.attentionLine = attentionLine;
    }

}
