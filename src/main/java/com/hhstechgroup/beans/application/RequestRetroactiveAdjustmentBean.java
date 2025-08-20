package com.hhstechgroup.beans.application;

public class RequestRetroactiveAdjustmentBean implements ApplicationSectionData  {

    private String requestRetroactiveAdjustment;
    private String reasonCode;
    private String justificationRequest;
    private String effectiveDate;

    public String getRequestRetroactiveAdjustment() {
        return requestRetroactiveAdjustment;
    }

    public void setRequestRetroactiveAdjustment(String requestRetroactiveAdjustment) {
        this.requestRetroactiveAdjustment = requestRetroactiveAdjustment;
    }
    public String getJustificationRequest() {
        return justificationRequest;
    }

    public void setJustificationRequest(String justificationRequest) {
        this.justificationRequest = justificationRequest;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    //sp26
    private String otherMediacidState;

    public String getOtherMediacidState() {
        return otherMediacidState; }

    public void setOtherMediacidState(String otherMediacidState) {
        this.otherMediacidState = otherMediacidState; }
}
