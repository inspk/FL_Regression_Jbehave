package com.hhstechgroup.beans.application;

public class ChangeEnrollmentTypeBean implements ApplicationSectionData  {
    //sp37
    private String changeenrollmenttype;
    private String reason;
    private String note;

    public String getChangeenrollmenttype() {
        return changeenrollmenttype;
    }
    public void setChangeenrollmenttype(String changeenrollmenttype) {
        this.changeenrollmenttype = changeenrollmenttype;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
}
