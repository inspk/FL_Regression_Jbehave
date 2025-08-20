package com.hhstechgroup.beans.application;

public class AffilitionInformationBean implements ApplicationSectionData {
    //sp33
    private String npifeinNumber;
    private String affiliationType;
    private String effectiveDateForm;
    private String effectiveDateTo;

    public String getNpifeinNumber() {
        return npifeinNumber;
    }

    public void setNpifeinNumber(String npifeinNumber) {
        this.npifeinNumber = npifeinNumber;
    }

    public String getAffiliationType() {
        return affiliationType;
    }

    public void setAffiliationType(String affiliationType) {
        this.affiliationType = affiliationType;
    }

    public String getEffectiveDateForm() {
        return effectiveDateForm;
    }

    public void setEffectiveDateForm(String effectiveDateForm) {
        this.effectiveDateForm = effectiveDateForm;
    }

    public String getEffectiveDateTo() {
        return effectiveDateTo;
    }

    public void setEffectiveDateTo(String effectiveDateTo) {
        this.effectiveDateTo = effectiveDateTo;
    }
}
