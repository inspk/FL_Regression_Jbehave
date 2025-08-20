package com.hhstechgroup.ui.panels.enrollment.affiliation;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class AffiliationPopUpPanel extends BaseModalPanel{
    private static final String AFFILIATION_TYPE = "Affiliation type";
    private static final String AFFILIATION_BUTTON_POPUP = "(//button//span[contains(text(),'Add')])[2]";
    private static final String AFFILIATION_DROPDOWN=".//div[contains(@class, 'affiliation_row')]//input/preceding-sibling::div";

    public AffiliationPopUpPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    public void selectAffiliationTypeValue(String type) {
        findBy(AFFILIATION_DROPDOWN).click();
        selectFromDropDown(AFFILIATION_TYPE, type);
    }

    public void clickAddAffiliationButtonInPopup() {
        waitABit(1000);
        findBy(AFFILIATION_BUTTON_POPUP).click();
    }

    private static final String AFFILIATE_PRIMARY_LOCATION = "//div//span[text()='%s']/..//div//div//div//label//span//span//input[@value='%s']";
    public void setAffiliatePrimaryLocation(String question, String option){
        waitABit(500);
        findBy(format(AFFILIATE_PRIMARY_LOCATION, question, option)).click();
        waitABit(500);
    }

    private static final String CONFIRM_AFFILIATION_WITH_INDI="//div[text()='%s']/..//following-sibling::div//button//span[text()='%s']";
    public void setConfirmAffiliationWithIndi(String question, String option){
        waitABit(500);
        findBy(format(CONFIRM_AFFILIATION_WITH_INDI, question, option)).click();
        waitABit(500);
    }


    private static final String AFFILIATE_LOCATION_START_DATE = "//label[contains(text(),'Affiliate Location Effective start date')]/..//input" ;
    private static final String AFFILIATE_LOCATION_END_DATE = "//label[contains(text(),'Affiliate Location Effective end date')]/..//input";
    public void setLocationEffectiveDates(String dateStart, String dateEnd){
        waitABit(500);
        scrollToElement(AFFILIATE_LOCATION_START_DATE);
        waitABit(500);
        findBy(AFFILIATE_LOCATION_START_DATE).type(dateStart);
        waitABit(500);
        scrollToElement(AFFILIATE_LOCATION_END_DATE);
        waitABit(500);
        findBy(AFFILIATE_LOCATION_END_DATE).type(dateEnd);
        waitABit(500);
    }

    public void setLocationEffectiveDate(String dateStart,String dateEnd){
        scrollToElement(AFFILIATE_TAXONOMY_START_DATE);
        waitABit(500);
        findBy(AFFILIATE_TAXONOMY_START_DATE).type(dateStart);
        waitABit(500);
        scrollToElement(AFFILIATE_TAXONOMY_END_DATE);
        waitABit(500);
        findBy(AFFILIATE_TAXONOMY_END_DATE).type(dateEnd);
        waitABit(500);
    }

    private static final String PROGRAM_PARTICIPATION = "//div[contains(@class, 'pp-table')]//div[contains(text(), '225100000X - PHYSICAL THERAPIST')]/..//input[@type='checkbox']";
    private static final String AFFILIATE_TAXONOMY_START_DATE = "//label[contains(text(),'Affiliate Taxonomy Effective Start Date')]/..//input" ;
    private static final String AFFILIATE_TAXONOMY_END_DATE = "//label[contains(text(),'Affiliate Taxonomy Effective End Date')]/..//input";
    public void selectProgramParticipation(String programparticipation, String startdate, String enddate){
        waitABit(500);
        findBy(format(PROGRAM_PARTICIPATION, programparticipation)).click();
        waitABit(1000);
        scrollToElement(AFFILIATE_TAXONOMY_START_DATE);
        waitABit(500);
        findBy(AFFILIATE_TAXONOMY_START_DATE).type(startdate);
        waitABit(500);
        scrollToElement(AFFILIATE_TAXONOMY_END_DATE);
        waitABit(500);
        findBy(AFFILIATE_TAXONOMY_END_DATE).type(enddate);
        waitABit(500);
    }

    private static final String HOME_LOCATION = "//div[div[div[contains(text(),'Are services provided only in a residential home')]]]//div/following-sibling::div//div//div//label//span//span//input[@value='%s']";
    public void setHomeLocation(String homeLocation){
        waitABit(500);
        findBy(format(HOME_LOCATION, homeLocation)).click();
        waitABit(500);
    }

    private static final String ADDRESS = "//input[@id='secondaryServiceAddress']";
    public void setAddress(String address){
        waitABit(500);
        findBy(ADDRESS).type(address);
        waitABit(500);
    }

    private static final String CITY = "//input[@id='secondaryServiceCity']";
    public void setCity(String city){
        waitABit(500);
        findBy(CITY).type(city);
        waitABit(500);
    }

    private static final String ZIP = "//input[@id='secondaryServiceZipCode']";
    public void setZip(String zip){
        waitABit(500);
        findBy(ZIP).type(zip);
        waitABit(500);
    }

    private static final String STATE = "//label[text()='State']/../div";
    private static final String STATE_OPTIONS = "//ul/li[node() = '%s']";
    public void setState(String state){
        waitABit(500);
        findBy(STATE).click();
        waitABit(500);
        scrollToElement(format(STATE_OPTIONS, state));
        findBy(format(STATE_OPTIONS, state)).click();
        waitABit(500);
    }

    private static final String SERVICE_LOCATION = "//div[contains(@class, 'tile-table-body')][//div/p[contains(text(), '%s')]]//div[text()='+ ADD']";
    public void addServiceLocation(String text){
        waitABit(500);
        findBy(format(SERVICE_LOCATION, text)).click();
        waitABit(500);
    }

    private static final String SEARCH = "//div[@role='dialog']//button[span[text()='Search']]";
    public void searchSecondaryServiceLocation(){
        waitABit(500);
        findBy(SEARCH).click();
        waitABit(500);
    }

    private static final String POPUP_MESSAGE = "//div[@role='document']//h2";
    private static final String POPUP_OK = "//div[@role='document']//button[span[text()='Ok']]";
    public String getPopupMessage() {
        if(isElementPresent(POPUP_MESSAGE)) {
            String message = findBy(POPUP_MESSAGE).getText();
            waitABit(500);
            findBy(POPUP_OK).click();
            return message;
        }
        else
            return null;
    }

    private static final String MANNER_OF_SERVICE = "//div[label[text()='Manner of services']]";
    private static final String OPTIONS = "//ul/li[node()='%s']";
    public void setMannerOfService(String mannerOfService){
        scrollToElement(MANNER_OF_SERVICE);
        waitABit(500);
        findBy(MANNER_OF_SERVICE).click();
        waitABit(500);
        findBy(format(OPTIONS, mannerOfService)).click();
        waitABit(500);
    }

    private static final String ACCEPTING_NEW_PATIENTS = "//div[div[div[text()='Accepting new Patients?']]]//div/following-sibling::div//div//div//label//span//span//input[@value='%s']";
    public void setAcceptingNewPatients(String acceptingNewPatients){
        scrollToElement(format(ACCEPTING_NEW_PATIENTS, acceptingNewPatients));
        waitABit(500);
        findBy(format(ACCEPTING_NEW_PATIENTS, acceptingNewPatients)).click();
        waitABit(500);
    }

    private static final String EXPAND_BUTTON = "//div[contains(text(), '%s')]/ancestor::div[contains(@class, 'affiliation_provider-list-item')]/div[not(text())]";
    private static final String ADD_SERVICELOCATON_BUTTON = "//div[normalize-space()='+ ADD']";
    private static final String EDIT_SERVICElOCATION_BUTTON = "//div[normalize-space()='EDIT']";
    private static final String DELETE_SERVICELOCATION_BUTTON = "//div[span[normalize-space()='DELETE']]";
    private static final String MORE_BUTTON = "//div[contains(text(), '%s')]/ancestor::div[contains(@class, 'affiliation_provider-list-item')]//button[@aria-label='more']";
    private static final String END_BUTTON = "//ul[@role='menu']/button[//span[text()='End']]";

    public void expandAffiliation(String provider){
        waitABit(500);
        jsClick(format(EXPAND_BUTTON, provider));
    }

    public void clickAddServiceLocationButton(){
        waitABit(500);
        jsClick(ADD_SERVICELOCATON_BUTTON);
    }

    public void clickEditServiceLocationButton(){
        waitABit(500);
        jsClick(EDIT_SERVICElOCATION_BUTTON);
    }

    public void clickDeleteServiceLocationButton(){
        waitABit(500);
        jsClick(DELETE_SERVICELOCATION_BUTTON);
    }

    public void endAffiliation(String provider){
        jsClick(format(MORE_BUTTON, provider));
        waitABit(500);
        jsClick(END_BUTTON);
        waitABit(500);
    }

}
