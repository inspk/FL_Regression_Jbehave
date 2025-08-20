package com.hhstechgroup.beans.application;

public class EFTInformationBean implements ApplicationSectionData{

    private String financialInstitution;

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    private String accountHolderName;
    public String getFinancialInstitution() {
        return financialInstitution;
    }
    public void setFinancialInstitution(String financialInstitution) {
        this.financialInstitution = financialInstitution;
    }

    private String EFTRoutingNumber;
    public String getEFTRoutingNumber() {
        return EFTRoutingNumber;
    }
    public void setEFTRoutingNumber(String EFTRoutingNumber) {
        this.EFTRoutingNumber = EFTRoutingNumber;
    }

    private String accountNumber;
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    private String accountType;
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    private String startDate;
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
