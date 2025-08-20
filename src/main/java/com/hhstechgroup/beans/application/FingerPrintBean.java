package com.hhstechgroup.beans.application;

public class FingerPrintBean implements ApplicationSectionData  {
//sp21
    private String verifyFingerPrint;
    private String note;

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getVerifyFingerPrint() {
        return verifyFingerPrint;
    }

    public void setVerifyFingerPrint(String verifyFingerPrint) {
        this.verifyFingerPrint = verifyFingerPrint;
    }

}
