package com.hhstechgroup.beans.application;

public class PCCMBean implements ApplicationSectionData {

    private String participatePCCM;
    private String type;
    private String countOfClients;
    private String phone;
    private String callToMember;
    private String groupNpi;

    public String getParticipatePCCM() {
        return participatePCCM;
    }

    public void setParticipatePCCM(String participatePCCM) {
        this.participatePCCM = participatePCCM;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountOfClients() {
        return countOfClients;
    }

    public void setCountOfClients(String countOfClients) {
        this.countOfClients = countOfClients;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCallToMember() {
        return callToMember;
    }

    public void setCallToMember(String callToMember) {
        this.callToMember = callToMember;
    }

    public String getGroupNpi() {
        return groupNpi;
    }

    public void setGroupNpi(String groupNpi) {
        this.groupNpi = groupNpi;
    }
}
