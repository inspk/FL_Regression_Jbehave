package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.electronicfundspayment.ElectronicFundsPaymentPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class AddressPanel extends BaseEnrollmentPanel {

    private static final String PROVIDER_NAME = "Provider name";
    private static final String PROVIDER_ADDRESS = "Physical Address (P.O. box not accepted)";
    private static final String BUILDING_SUITE = "Building, Suite";
    private static final String ZIP = ".//div[@label = 'Zip']//input";
    private static final String ZIP2 = "//div[@label='Mailing - Service Location Zip']//input";

    public AddressPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    public String setProviderName() {
        return getFieldValue(PROVIDER_NAME);
    }

    public void setProviderAddress(String providerAddress ){
        fillField(PROVIDER_ADDRESS,providerAddress);
    }
    public void setBuilding(String building) {
        fillField(BUILDING_SUITE,building);
    }
    public void setGroupProviderAddress(String groupProviderAddress) {
        waitABit(1000);
        fillField(PROVIDER_ADDRESS,groupProviderAddress);
        fillField(PROVIDER_ADDRESS,groupProviderAddress);
        waitABit(1000);
    }
    public void setGroupBuilding(String groupBuilding) {
        waitABit(1000);
        fillField(BUILDING_SUITE,groupBuilding);
        fillField(BUILDING_SUITE,groupBuilding);
        waitABit(1000);
    }
    public void setZip(String zip) {
        waitABit(300);
        findBy(ZIP).type(zip);
        findBy(ZIP).type(zip);
        waitABit(500);
    }
    public void setZip2(String zip) {
        findBy(ZIP2).type(zip);
    }

    //sp20
    public void editZip(String zip) {
        waitABit(800);
        findBy(ZIP).clear();
        findBy(ZIP).type(zip);
        waitABit(1000);
    }
    //sp26
   // private static final String MAILING_ADDRESS_LINE1= "Mailing Address Line 1";
    //sp43.2
    private static final String MAILING_ADDRESS_LINE1= ".//div//input[@id='line1']";
    private static final String SELECT_ADDRESS =".//div[contains(@role,'menuitem')]";
     public void setMailingAddressLine1(String mailingAddressLine1) {
        waitABit(500);
        findBy(MAILING_ADDRESS_LINE1).click();
        waitABit(500);
        findBy(MAILING_ADDRESS_LINE1).type(mailingAddressLine1);
        waitABit(20000);
        findBy(SELECT_ADDRESS).click();
        waitForSectionPulledUp();
        waitABit(2000);
        //fillField(MAILING_ADDRESS_LINE1,mailingAddressLine1);
    }
    //sp28
  //  private static final String MAILING_ADDRESS_ZIP= ".//input[contains(@id,'Mailing Address Zip')]";
    //sp34
    private static final String MAILING_ADDRESS_ZIP= ".//div[@label='Mailing Address Zip']//input";
    private static final String MAILING_ADDRESS_ZIP1 = ".//div//label[text()='Zip']" ;
    private static final String MAILING_ADDRESS_ZIP1_TEXT = ".//div//label[text()='Zip']/..//input" ;

    public void setMailingAddressZip(String mailingAddressZip) {
        waitABit(500);
        jsClick(MAILING_ADDRESS_ZIP);
        findBy(MAILING_ADDRESS_ZIP).type(mailingAddressZip);
        waitABit(500);
    }
    //latest sp41.3
   // private static final String MAILING_ADDRESS_COUNTY_CODE= ".//input[contains(@id,'Mailing Address County Code')]";
    private static final String MAILING_ADDRESS_COUNTY_CODE = ".//div[contains(@label,'Mailing Address County Code')]";
    private static final String MAILING_ADDRESS_COUNTY_CODE1 =".//label[contains(text(),'County')]" ;
    private static final String MAILING_ADDRESS_COUNTY_CODE_LIST = ".//div[contains(@label,'Mailing Address County Code')]//input";
    private static final String MAILING_ADDRESS_COUNTY_CODE_LIST_TEXT =".//label[contains(text(),'County')]/..//input" ;
    //sp44.2
    private static final String SELECT_COUNTY_CODE=".//ul[contains(@role,'listbox')]";
    public void setMailingAddressCountycode(String mailingAddressCountycode) {
        waitABit(500);
       // scrollToElement(MAILING_ADDRESS_COUNTY_CODE_LIST_TEXT);
        jsClick(MAILING_ADDRESS_COUNTY_CODE_LIST_TEXT);
        waitABit(500);
        findBy(MAILING_ADDRESS_COUNTY_CODE_LIST_TEXT).type(mailingAddressCountycode);
        waitABit(1000);
        //findBy(SELECT_COUNTY_CODE).click();
        waitForSectionPulledUp();
        waitABit(1000);
    }

    private static final String PRIMARY_SERVICE_LOCATION_ZIP= ".//h4[text()='Address']/../..//label[text()='Zip']";
    private static final String PRIMARY_SERVICE_LOCATION_ZIP_TEXT= ".//h4[text()='Address']/../..//label[text()='Zip']/..//input" ;
    public void setPrimaryServiceLocationZip(String primaryServiceLocationZip) {
        waitABit(500);
        scrollToElement(PRIMARY_SERVICE_LOCATION_ZIP);
        jsClick(PRIMARY_SERVICE_LOCATION_ZIP);
        findBy(PRIMARY_SERVICE_LOCATION_ZIP_TEXT).type(primaryServiceLocationZip);
        waitABit(500);
    }
    // private static final String PRIMARY_SERVICE_LOCATION_COUNTY_CODE = ".//input[contains(@id,'Primary Service Location County Code')]";
    private static final String PRIMARY_SERVICE_LOCATION_COUNTY_CODE = ".//h4[text()='Address']/../..//label[text()='County']";
    private static final String PRIMARY_SERVICE_LOCATION_COUNTY_CODE_LIST = ".//h4[text()='Address']/../..//label[text()='County']/..//input";
    public void setPrimaryServiceLocationCountyCode(String primaryServiceLocationCountyCode) {
        waitABit(500);
        scrollToElement(PRIMARY_SERVICE_LOCATION_COUNTY_CODE);
        jsClick(PRIMARY_SERVICE_LOCATION_COUNTY_CODE);
        findBy(PRIMARY_SERVICE_LOCATION_COUNTY_CODE_LIST).type(primaryServiceLocationCountyCode);
        waitABit(500);
    }

    //sp35
//    private static final String MAILING_ADDRESS_STATE_BUTTON = ".//label[contains(text(), 'Mailing Address State')]/following-sibling::div//input";
    //sp44.2
    private static final String MAILING_ADDRESS_STATE_BUTTON1 = ".//label[contains(text(), 'State')]/following-sibling::div//input";
    //private static final String SELECT_ADDRESS_STATE_OPTION = ".//li[@data-suggestion-index='%s']";
    private static final String SELECT_ADDRESS_STATE_OPTION = ".//div[contains(@role,'menuitem')]/div/strong[text()='%s']";
    public void setMailingAddressState(String mailingAddressState) {
        waitABit(500);
       // scrollToElement(MAILING_ADDRESS_STATE_BUTTON1);
        findBy(MAILING_ADDRESS_STATE_BUTTON1).click();
        waitABit(1000);
        findBy(format(SELECT_ADDRESS_STATE_OPTION,mailingAddressState)).click();
        waitABit(500);

    }

    private static final String MAILING_ADDRESS_CITY= ".//label[contains(text(), 'Mailing Address City')]/following-sibling::div//input";
    private static final String MAILING_ADDRESS_CITY1 = ".//label[text()='City']";
    private static final String MAILING_ADDRESS_CITY_TEXT = ".//label[text()='City']/..//input";
    public void setMailingAddressCity(String mailingAddressCity) {
        waitABit(500);
        findBy(MAILING_ADDRESS_CITY_TEXT).type(mailingAddressCity);
        waitABit(500);
    }
    private static final String PRIMARY_SERVICE_LOCATION_CITY= ".//h4[text()='Address']/../..//label[text()='City']";
    private static final String PRIMARY_SERVICE_LOCATION_CITY_TEXT = ".//h4[text()='Address']/../..//label[text()='City']/..//input" ;
    public void setPrimaryServiceLocationCity(String primaryServiceLocationCity){
        waitABit(500);
        scrollToElement(PRIMARY_SERVICE_LOCATION_CITY);
        jsClick(PRIMARY_SERVICE_LOCATION_CITY);
        findBy(PRIMARY_SERVICE_LOCATION_CITY_TEXT).type(primaryServiceLocationCity);
        waitABit(500);
    }

   // private static final String PRIMARY_SERVICE_LOCATION_STATE = ".//label[contains(text(), 'Primary Service Location State')]/following-sibling::div//input";
    //sp44.2
    private static final String PRIMARY_SERVICE_LOCATION_STATE = ".//label[contains(text(), 'State')]/following-sibling::div//input";
    //private static final String SELECT_PRIMARY_SERVICE_LOCATION_OPTION = ".//li[@data-suggestion-index='%s']";
    private static final String SELECT_PRIMARY_SERVICE_LOCATION_OPTION = ".//div[contains(@role,'menuitem')]/div/strong[text()='%s']";

    public void setPrimaryServiceLocationState(String primaryServiceLocationState) {
        waitABit(500);
        //scrollToElement(PRIMARY_SERVICE_LOCATION_STATE);
        findBy(PRIMARY_SERVICE_LOCATION_STATE).click();
        waitABit(1000);
        findBy(format(SELECT_PRIMARY_SERVICE_LOCATION_OPTION, primaryServiceLocationState)).click();
        waitABit(500);
    }
    //sp47.2.1
    private static final String MAILING_ADDRESS_ZIP_TYPE = ".//h4[contains(text(),'Mailing Address Zip')]/../..//div[contains(@class,'sc-')]";
    public Map<String, String> getMappedZipValues() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("MAILING ADDRESS ZIP TYPE", (findBy(format(MAILING_ADDRESS_ZIP_TYPE))).getText());
        return map;
    }
    public void setMailingAddressLine2(String mailingAddressLine1) {
        waitABit(500);
        findBy(MAILING_ADDRESS_LINE1).click();
        waitABit(500);
        findBy(MAILING_ADDRESS_LINE1).type(mailingAddressLine1);
        waitABit(1000);
    }
    //sp47.2.1
    private static final String BILLING_ADDRESS = "Is Billing Address same as Mailing Address?";
    public void setBillingAddress(String billingAddress) {
        selectRadionButton(BILLING_ADDRESS,billingAddress);
    }
    private static final String BILLING_CONTACT_PERSON_DETAILS = "Is Billing Address Contact Person Details same as Mailing Address Contact Person Details?";
    public void setBillingContactPersonDetails(String billingContactPersonDetails) {
        selectRadionButton(BILLING_CONTACT_PERSON_DETAILS,billingContactPersonDetails);
    }

    //Demo

    private static final String GENDER_SERVICE_LOCATION=".//label[contains(text(), 'Gender served')]";
    public void setGenderServiceLocation(String genderServiceLocation){
        waitABit(500);
        findBy(GENDER_SERVICE_LOCATION).click();
        waitABit(500);
        selectFromDropDown(genderServiceLocation);
        waitABit(1000);

    }
    private static final String ACCEPTING_NEW_PATIENTS="Accepting new patients?";
    public void setAcceptingNewPatients(String acceptingNewPatients) {
        waitABit(500);
        selectRadionButton(ACCEPTING_NEW_PATIENTS,acceptingNewPatients);
        waitABit(1000);
    }
    private static final String LOCATION_EQUIPPED="Is this location TDD/TTY equipped?";
    public void setLocationEquipped(String locationEquipped) {
        waitABit(500);
        selectRadionButton(LOCATION_EQUIPPED,locationEquipped);
        waitABit(1000);
    }
    private static final String OPEN_HOURS="Is this location open 24 hours?";
    public void setOpenHours(String openHours) {
        waitABit(500);
        selectRadionButton(OPEN_HOURS,openHours);
        waitABit(1000);
    }

    private static final String EMERGENCY_SERVICES="Is this location open 24 hours?";
    public void setEmergencyServices(String emergencyServices) {
        waitABit(500);
        selectRadionButton(EMERGENCY_SERVICES,emergencyServices);
        waitABit(1000);

    }


    //SD16 Alternative address code

    private static final String ALTERNATE_ADDRESS_LINE1="//input[@id='line1']";
    public void setAlternateAddressline1(String alternateAddressline1) {
        waitABit(500);
        findBy(ALTERNATE_ADDRESS_LINE1).click();
        waitABit(500);
        findBy(ALTERNATE_ADDRESS_LINE1).type(alternateAddressline1);
        waitABit(1000);
    }

        private static final String ALTERNATE_ADDRESS_CITY=".//input[contains(@id,'Mailing Address City')]";
        public void setAlternateAddressCity(String alternateAddressCity) {
            waitABit(500);
            findBy(ALTERNATE_ADDRESS_CITY).click();
            waitABit(500);
            findBy(ALTERNATE_ADDRESS_CITY).type(alternateAddressCity);
            waitABit(1000);
        }


    private static final String ALTERNATE_ADDRESS_ZIPCODE="//div[@data-for='Mailing Address Zip Code']/input";
    public void setAlternateAddressZipCode(String alternateAddressZipCode) {
        waitABit(500);
        findBy(ALTERNATE_ADDRESS_ZIPCODE).click();
        waitABit(500);
        findBy(ALTERNATE_ADDRESS_ZIPCODE).type(alternateAddressZipCode);
        waitABit(1000);
    }

    private static final String ALTERNATE_ADDRESS_COUNTRY=".//input[contains(@id,'Mailing Address County')]";
    public void setAlternateAddressCountry(String alternateAddressCountry) {
        waitABit(500);
        findBy(ALTERNATE_ADDRESS_COUNTRY).click();
        waitABit(500);
        findBy(ALTERNATE_ADDRESS_COUNTRY).type(alternateAddressCountry);
        waitABit(1000);
    }

    private static final String ALTERNATE_ADDRESS_STATE="//div[@data-for='Mailing Address State']/div/input";
    public void setAlternateAddressState(String alternateAddressState) {
        waitABit(500);
        findBy(ALTERNATE_ADDRESS_STATE).click();
        waitABit(500);
        selectFromDropDown(alternateAddressState);
        waitABit(1000);
    }
    private static final String EFFECTIVE_START_DATE=".//label[contains(text(), 'Effective Start Date')]/parent::div//input";
    private static final String EFFECTIVE_END_DATE=".//label[contains(text(), 'Effective End Date')]/parent::div//input";

    public void setEffectiveStartDate(String effectiveStartDate) {
        waitABit(500);
        jsClick(EFFECTIVE_START_DATE);
        findBy(EFFECTIVE_START_DATE).sendKeys(effectiveStartDate);
    }

    public void setEffectiveEndDate(String effectiveEndDate) {
        waitABit(500);
        jsClick(EFFECTIVE_END_DATE);
        findBy(EFFECTIVE_END_DATE).sendKeys(effectiveEndDate);}
    private static final String HOME_OR_CORP_OFFICE_CONTACTPERSON_DETAILS="Is Home/Corp Office Contact";
    public void setHomeOrCorpOfficeContactPersonDetails(String homeOrCorpOfficeContactPersonDetails){
        waitABit(200);
        selectRadionButton(HOME_OR_CORP_OFFICE_CONTACTPERSON_DETAILS, homeOrCorpOfficeContactPersonDetails);
waitABit(200);
    }
    private static final String HOME_OR_CORP_OFFICE_ADDRESS="Home/Corp Office Address is same";
    public void setHomeOrCorpOfficeAddress(String homeOrCorpOfficeAddress){
        waitABit(200);
        selectRadionButton(HOME_OR_CORP_OFFICE_ADDRESS, homeOrCorpOfficeAddress);
        waitABit(200);
    }
    private static final String HOME_OR_CORP_ADDRESS_CONTACT_PERSON_DETAILS="Home/Corp Office Address Contact person details is same as the Mailing Address Contact person details";
    public void setHomeOrCorpAddressContactPersonDetails(String homeOrCorpAddressContactPersonDetails){
        waitABit(200);
        selectRadionButton(HOME_OR_CORP_ADDRESS_CONTACT_PERSON_DETAILS, homeOrCorpAddressContactPersonDetails);
        waitABit(200);
    }
    private static final String SERVICE_LOC_OFC_CONTACT_PERSON_DETAILS="Service Location Office Contact";
    public void setServiceLocOfcContactPersonDetails(String serviceLocOfcContactPersonDetails){
        waitABit(200);
        selectRadionButton(SERVICE_LOC_OFC_CONTACT_PERSON_DETAILS, serviceLocOfcContactPersonDetails);
        waitABit(200);
    }
    private static final String SERVICE_LOCATION_OFFICE_ADDRESS="Service Location Office Address";
    public void setServiceLocOfcAddress(String serviceLocOfcAddress){
        waitABit(200);
        selectRadionButton(SERVICE_LOCATION_OFFICE_ADDRESS,serviceLocOfcAddress);
        waitABit(200);
    }
    private static final String BILLING_ADDRESS_HOME_CORP="Billing Address is same as the Home/Corp Office Address";

    public void setBillingAddressHomeOrCorp(String billingAddressHomeOrCorp){
        waitABit(200);
        selectRadionButton(BILLING_ADDRESS_HOME_CORP,billingAddressHomeOrCorp);
        waitABit(200);
    }
    private static final String BILLING_ADDRESS_CONTACT_PERSON_DETAILS_HOME_CORP="Billing Address Contact person details is same as the Home/Corp Office Address Contact person details";
    public void setBillingAddressContactPersonDetailsHomeOrCorp(String billingAddressContactPersonDetailsHomeOrCorp){
        waitABit(200);
        selectRadionButton(BILLING_ADDRESS_CONTACT_PERSON_DETAILS_HOME_CORP,billingAddressContactPersonDetailsHomeOrCorp);
        waitABit(200);
    }

}