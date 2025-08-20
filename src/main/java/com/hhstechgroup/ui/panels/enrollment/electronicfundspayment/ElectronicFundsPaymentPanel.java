package com.hhstechgroup.ui.panels.enrollment.electronicfundspayment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import com.hhstechgroup.ui.panels.enrollment.servicelocationbilling.ContactPersonTable;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

public class ElectronicFundsPaymentPanel extends BaseEnrollmentPanel {

    private static final String PROVIDER_NAME = "Provider name";
    private static final String PROVIDER_ADDRESS = "Provider address";
    private static final String BUILDING_SUITE = "Building, Suite";
    private static final String CITY = "City";
    private static final String STATE = "State";
    private static final String ZIP = ".//div[@label = 'Zip']//input";
    private static final String NPI = ".//div[label[text()='National provider identifier(NPI)']]//input";
    private static final String EMAIL_ADDRESS = "Email Address";
    private static final String TELEPHONE = ".//div[label='Telephone number']//input";
    private static final String LOCATION_CONTACT_PERSON_TABLE = ".//div[h3[contains(text() , 'contact person')]]/following-sibling::div//div[table]/ancestor::div[2]";
    private static final String FINANCIAL_INSTITUTION_NAME = "institution name";
    private static final String FINANCIAL_INSTITUTION_ROUTING_NUMBER = "institution routing number";
    private static final String TYPE_OF_ACCOUNT = "Type of account";
    private static final String PROVIDER_ACCOUNT_NUMBER = "Providers account number";
    private static final String ACCOUNT_NUMBER_LINKAGE = "Account number";
    private static final String REASON_FOR_SUBMISSION = "Reason for submission";
    private static final String BILLING_ADDRESS_SAME_AS_MAILING = "billing address";
    private static final String PHYSICAL_ADDRESS = "Physical address";
    private static final String PROVIDER_IDENTIFIERS = "Provider identifiers";

    public ElectronicFundsPaymentPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public ContactPersonTable getContactPersonTable() {
        return new ContactPersonTable(findBy(LOCATION_CONTACT_PERSON_TABLE), getBasePage());
    }

    public void setFinInstitutionName(String finInstitutionName) {
        fillField(FINANCIAL_INSTITUTION_NAME, finInstitutionName);
    }

    public void setFinRoutingNumber(String finRoutingNumber) {
        fillField(FINANCIAL_INSTITUTION_ROUTING_NUMBER, finRoutingNumber);
    }

    public void setFinTypeOfAccount(String finTypeOfAccount) {
        select(TYPE_OF_ACCOUNT, finTypeOfAccount);
    }

    public void setFinProvidersAccountNumber(String finProvidersAccountNumber) {
        fillField(PROVIDER_ACCOUNT_NUMBER, finProvidersAccountNumber);
    }

    public void setAccountNumberLinkage(String accountNumberLinkage) {
        select(ACCOUNT_NUMBER_LINKAGE, accountNumberLinkage);
    }

    public void setNpiNumber(String npiNumber) {
        scrollToElement(NPI);
        findBy(NPI).type(npiNumber);
        action().sendKeys(Keys.TAB).build().perform();
    }

    public void setReasonForSubmission(String reasonForSubmission) {
        select(REASON_FOR_SUBMISSION, reasonForSubmission);
    }

    public void setSameAsMailingAddress(String sameAsMailingAddress) {
        selectRadionButton(BILLING_ADDRESS_SAME_AS_MAILING, sameAsMailingAddress);
    }

    public void setPhysicalAddress(String physicalAddress) {
        fillField(PHYSICAL_ADDRESS, physicalAddress);
    }

    public void setProviderName(String providerName) {
        fillField(PROVIDER_NAME, providerName);
    }

    public void setProviderAddress(String providerAddress) {
        fillField(PROVIDER_ADDRESS, providerAddress);
    }

    public void setBuilding(String building) {
        fillField(BUILDING_SUITE, building);
    }

    public void setCity(String city) {
        fillField(CITY, city);
    }

    public void setState(String state) {
        selectFromDropDown(STATE, state);
    }

    public void setProviderIdentifiers(String providerIdentifiers) {
        select(PROVIDER_IDENTIFIERS, providerIdentifiers);
    }

    public void setZip(String zip) {
        scrollToElement(ZIP);
        findBy(ZIP).type(zip);
    }

    public void setEmail(String email) {
        fillField(EMAIL_ADDRESS, email);
    }

    public void setTelephoneNumber(String telephoneNumber) {
        scrollToElement(TELEPHONE);
        findBy(TELEPHONE).type(telephoneNumber);
    }

    public String getProviderName() {
        return getFieldValue(PROVIDER_NAME);
    }

    public String getProviderAddress() {
        return getFieldValue(PROVIDER_ADDRESS);
    }

    public String getBuilding() {
        return getFieldValue(BUILDING_SUITE);
    }

    public String getZip() {
        return findBy(ZIP).getValue();
    }

    public String getEmail() {
        return getFieldValue(EMAIL_ADDRESS);
    }

    public String getTelephoneNumber() {
        return findBy(TELEPHONE).getValue();
    }

    public String getFinInstitutionName() {
        return getFieldValue(FINANCIAL_INSTITUTION_NAME);
    }

    public String getFinRoutingNumber() {
        return getFieldValue(FINANCIAL_INSTITUTION_ROUTING_NUMBER);
    }

    public String getFinTypeOfAccount() {
        return getFieldValue(TYPE_OF_ACCOUNT);
    }

    public String getFinProvidersAccountNumber() {
        return getFieldValue(PROVIDER_ACCOUNT_NUMBER);
    }

    public String getAccountNumberLinkage() {
        return getFieldValue(ACCOUNT_NUMBER_LINKAGE);
    }

    public String getReasonForSubmission() {
        return getFieldValue(REASON_FOR_SUBMISSION);
    }

    public String getSameAsMailingAddress() {
        return getRadioButtonValue(BILLING_ADDRESS_SAME_AS_MAILING);
    }

    public String getNpiNumber() {
        return findBy(NPI).getValue();
    }
}
