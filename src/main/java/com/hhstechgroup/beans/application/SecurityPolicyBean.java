package com.hhstechgroup.beans.application;

public class SecurityPolicyBean {
    private String passwordlength;
    private String preventPasswordReuse ;
    private String passwordReset ;
    private String passwordExpiration ;
    private String  accountLock;
    private String lockoutPeriod ;
    public String getPasswordlength() {
        return passwordlength;
    }

    public void setPasswordlength(String passwordlength) {
        this.passwordlength = passwordlength;
    }

    public String getPreventPasswordReuse() {
        return preventPasswordReuse;
    }

    public void setPreventPasswordReuse(String preventPasswordReuse) {
        this.preventPasswordReuse = preventPasswordReuse;
    }

    public String getPasswordReset() {
        return passwordReset;
    }

    public void setPasswordReset(String passwordReset) {
        this.passwordReset = passwordReset;
    }

    public String getPasswordExpiration() {
        return passwordExpiration;
    }

    public void setPasswordExpiration(String passwordExpiration) {
        this.passwordExpiration = passwordExpiration;
    }

    public String getAccountLock() {
        return accountLock;
    }

    public void setAccountLock(String accountLock) {
        this.accountLock = accountLock;
    }

    public String getLockoutPeriod() {
        return lockoutPeriod;
    }

    public void setLockoutPeriod(String lockoutPeriod) {
        this.lockoutPeriod = lockoutPeriod;
    }

    //sp25
    private String suspendedProvidersTerminated;
    private String fisrtNotification;
    private String secondNotification;
    private String thirdNotification;

    public String getSuspendedProvidersTerminated() {
        return suspendedProvidersTerminated; }

    public void setSuspendedProvidersTerminated(String suspendedProvidersTerminated) {
        this.suspendedProvidersTerminated = suspendedProvidersTerminated; }

    public String getFisrtNotification() {
        return fisrtNotification;
    }

    public void setFisrtNotification(String fisrtNotification) {
        this.fisrtNotification = fisrtNotification;
    }

    public String getSecondNotification() {
        return secondNotification;
    }

    public void setSecondNotification(String secondNotification) {
        this.secondNotification = secondNotification;
    }

    public String getThirdNotification() {
        return thirdNotification;
    }

    public void setThirdNotification(String thirdNotification) {
        this.thirdNotification = thirdNotification;
    }


}
