package com.hhstechgroup.util.common;

    public enum ExternalEmails {

    WELCOME("Welcome to ProviderPortal"),
    REGISTRATION("Registration in ProviderPortal"),
    NEW_EMAIL("New mail in Portal"),
    STATUS_CHANGE("Application status change"),
    RESET_PASSWORD("Reset Password for ProviderPortal"),
    ENROLLMENT_TERMINATED("Your enrollment is terminated"),
    REGISTRATION_IU("Registration in IU Portal"),
    IU_DEACTIVATION("User Deactivation in IU Portal"),
        IU_ACTIVATION("User Activation in IU Portal");


    private String value;

    private ExternalEmails(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
