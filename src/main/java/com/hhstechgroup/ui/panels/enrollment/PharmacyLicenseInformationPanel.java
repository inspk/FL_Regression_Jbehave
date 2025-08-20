package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

public class PharmacyLicenseInformationPanel extends BaseEnrollmentPanel {
    //sp35
    private final static String PHARMACY_LICENSE_NUMBER = ".//label[contains(text(), 'License Number')]/parent::div//input";
    private final static String PHARMACY_LICENSE_TYPE = ".//label[contains(text(), 'License Type')]/parent::div//input";
    private final static String PHARMACY_LICENSE_ISSUSED_STATE = ".//label[contains(text(), 'License Issue State')]/parent::div//input";
    private final static String PHARMACY_LICENCE_EFFECTIVE_DATE = ".//label[text()='License Effective Date *']//ancestor::div[contains(@class, 'styles_datepicker')]//input";
    private final static String PHARMACY_LICENSE_EXPIRATION_DATE = ".//label[text()='License Expiration Date *']//ancestor::div[contains(@class, 'styles_datepicker')]//input";
    private final static String STATE_PHARMACY_LICENSE_NUMBER = "(.//label[contains(text(), 'License Number')]/parent::div//input)[2]";
    private final static String STATE_PHARMACY_LICENSE_TYPE= ".//label[contains(text(), 'License Type')]/parent::div//input/preceding-sibling::div";
    private final static String STATE_PHARMACY_LICENSE_ISSUSED_STATE= ".//label[contains(text(), 'License Issue State')]/parent::div//input/preceding-sibling::div";
    private final static String STATE_PHARMACY_LICENCE_EFFECTIVE_DATE = "(.//label[contains(text(),'License Effective Date')]//ancestor::div[contains(@class, 'styles_datepicker')]//input)[2]";
    private final static String STATE_PHARMACY_LICENSE_EXPIRATION_DATE = "(.//label[contains(text(),'License Expiration Date')]//ancestor::div[contains(@class, 'styles_datepicker')]//input)[2]";
    private static final String DROP_DOWN_LIST= ".//ul[contains(@role, 'listbox')]/li[contains(text(), '%s')]" ;

    public PharmacyLicenseInformationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    public void setPharmacylicenseNumber(String pharmacylicenseNumber) {
        waitABit(500);
        findBy(PHARMACY_LICENSE_NUMBER).type(pharmacylicenseNumber);
    }
    public void setPharmacylicenseType(String pharmacylicenseType){
        waitABit(500);
        findBy(PHARMACY_LICENSE_TYPE).click();
        selectFromDropDown(pharmacylicenseType);
    }
    public void setPharmacylicenseIssuedState(String pharmacylicenseIssuedState) {
        waitABit(500);
        jsClick(PHARMACY_LICENSE_ISSUSED_STATE);
        findBy(PHARMACY_LICENSE_ISSUSED_STATE).type(pharmacylicenseIssuedState);
        waitABit(1500);
    }
    public void setPharmacylicensEffectiveDate(String pharmacylicensEffectiveDate){
        waitABit(1000);
        jsClick(PHARMACY_LICENCE_EFFECTIVE_DATE);
        findBy(PHARMACY_LICENCE_EFFECTIVE_DATE).sendKeys(pharmacylicensEffectiveDate);
        waitABit(2500);
    }
    public void setPharmacylicenseExpirationDate(String pharmacylicenseExpirationDate){
        waitABit(1000);
        jsClick(PHARMACY_LICENSE_EXPIRATION_DATE);
        findBy(PHARMACY_LICENSE_EXPIRATION_DATE).sendKeys(pharmacylicenseExpirationDate);
        waitABit(500);
    }
    public void setStatepharmacylicenseNumber(String statepharmacylicenseNumber) {
        waitABit(500);
        findBy(STATE_PHARMACY_LICENSE_NUMBER).type(statepharmacylicenseNumber);
    }
    public void setStatepharmacylicenseType(String statepharmacylicenseType){
        waitABit(500);
        findBy(STATE_PHARMACY_LICENSE_TYPE).click();
        selectFromDropDown(statepharmacylicenseType);
        waitABit(500);

    }
    public void setStatepharmacylicenseIssuedState(String statepharmacylicenseIssuedState) {
        waitABit(500);
        findBy(STATE_PHARMACY_LICENSE_ISSUSED_STATE).click();
        selectFromDropDown(statepharmacylicenseIssuedState);
        waitABit(3500);

    }
    public void setStatepharmacylicensEffectiveDate(String statepharmacylicensEffectiveDate) {
        waitABit(1000);
        jsClick(STATE_PHARMACY_LICENCE_EFFECTIVE_DATE);
        findBy(STATE_PHARMACY_LICENCE_EFFECTIVE_DATE).sendKeys(statepharmacylicensEffectiveDate);
        waitABit(2500);
    }
    public void setStatepharmacylicenseExpirationDate(String statepharmacylicenseExpirationDate) {
        waitABit(1000);
        jsClick(STATE_PHARMACY_LICENSE_EXPIRATION_DATE);
        findBy(STATE_PHARMACY_LICENSE_EXPIRATION_DATE).sendKeys(statepharmacylicenseExpirationDate);
        waitABit(500);
    }

    //Demo - Pharmacy

    private final static String LIST_ALL_STATES = ".//label[contains(text(), 'List all states where pharmacy is licensed')]/parent::div//input";
    public void setListAllStates(String listAllStates) {
        waitABit(500);
        findBy(LIST_ALL_STATES).type(listAllStates);
    }
    private final static String CONTACT_NAME= ".//label[contains(text(), 'Contact Name')]/parent::div//input";
    public void setContactName340B(String contactName340B) {
        waitABit(500);
        findBy(CONTACT_NAME).type(contactName340B);
    }
    private final static String CONTACT_PHONE= ".//label[contains(text(), 'Contact Phone')]/parent::div//input";
    public void setContactPhone340B(String contactPhone340B) {
        waitABit(500);
        findBy(CONTACT_PHONE).type(contactPhone340B);
    }
    private final static String CONTACT_EMAIL= ".//label[contains(text(), 'Contact Email')]/parent::div//input";
    public void setContactEmail340B(String contactEmail340B) {
        waitABit(500);
        findBy(CONTACT_EMAIL).type(contactEmail340B);
    }

    //Pharmacy - Demo out of state
    private final static String NAME_OF_DRUG_NCD = ".//label[contains(text(), 'Name of drug/NDC example')]/parent::div//input";
    public void setDrugNcdExample(String drugNcdExample) {
        waitABit(500);
        findBy(NAME_OF_DRUG_NCD).type(drugNcdExample);
    }

    private final static String ADDITIONAL_INFORMATION = ".//label[contains(text(), 'Additional Information')]/parent::div//input";
    public void setAdditionalInformation(String additionalInformation) {
        waitABit(500);
        findBy(ADDITIONAL_INFORMATION).type(additionalInformation);
    }




}
