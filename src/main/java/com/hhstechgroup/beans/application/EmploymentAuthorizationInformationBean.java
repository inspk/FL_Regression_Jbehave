package com.hhstechgroup.beans.application;

public class EmploymentAuthorizationInformationBean implements ApplicationSectionData{
    public String getUsCitizen() {
        return usCitizen;
    }

    public void setUsCitizen(String usCitizen) {
        this.usCitizen = usCitizen;
    }

    private String usCitizen;
}
