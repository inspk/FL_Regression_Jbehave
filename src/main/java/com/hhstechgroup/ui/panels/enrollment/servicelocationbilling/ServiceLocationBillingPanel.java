package com.hhstechgroup.ui.panels.enrollment.servicelocationbilling;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import com.hhstechgroup.ui.panels.enrollment.affiliation.AffiliationTable;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

public class ServiceLocationBillingPanel extends BaseEnrollmentPanel {

    private static final String PHYSICAL_ADDRESS = "Physical address";
    private static final String BUILDING = "Building";
    private static final String CITY = "City";
    private static final String STATE = "State";
    private static final String ZIP = ".//div[@label = 'Zip']//input";
    private static final String PHONE_FAX_TABLE = ".//div[h4[text() = 'Address Information']]/following-sibling::div//div[table]/ancestor::div[2]";
    private static final String LOCATION_CONTACT_PERSON_TABLE = ".//div[h4[contains(text() , 'contact person')]]/following-sibling::div//div[table]/ancestor::div[2]";
    private static final String EMAIL_TABLE = ".//div[h4[contains(text() , 'Email')]]/following-sibling::div//div[table]/ancestor::div[2]";
    private static final String NPI_TABLE = ".//div[h4[contains(text() , 'National Provider Information')]]/following-sibling::div//div[table]/ancestor::div[2]";
    private static final String GENDER_SERVED = "Gender served";
    private static final String LANGUAGES_SUPPORTED = "Languages supported";
    private static final String AGE_RANGE_SERVED = "Age";
    private static final String NUMBER_OF_MEMBERS = "Number";
    private static final String POPULATION_SERVED = "Population served available";
    private static final String COUNTY = "County";
    private static final String RESERVATION = "Reservation";
    private static final String INTERPRETIVE_SERVICES = "Interpretive services";
    private static final String AFTER_HOURS_CONTACT_PHONE = ".//div[@label = 'After Hours Contact Phone']//input";

    public ServiceLocationBillingPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    //sp23
   /* private static final String ACCEPTING_NEW_PATIENTS =".//input[contains(@type,'radio')]";
    public void setAcceptingNewPatients(String acceptingNewPatients) {
        waitABit(100);
        scrollToElement(ACCEPTING_NEW_PATIENTS);
        findBy(ACCEPTING_NEW_PATIENTS).click();
        waitABit(2000);
    }
    */
   //sp26
    private static final String ACCEPTING_NEW_PATIENTS ="Accepting new patients?";
    public void setAcceptingNewPatients(String acceptingNewPatients) {
        waitABit(500);
        selectRadionButton(ACCEPTING_NEW_PATIENTS, acceptingNewPatients);
        waitABit(1000);

    }

    public PhoneFaxTable getPhoneFaxTable() {
        scrollToElement(PHONE_FAX_TABLE);
        return new PhoneFaxTable(findBy(PHONE_FAX_TABLE), getBasePage());
    }

    public ContactPersonTable getContactPersonTable() {
        scrollToElement(LOCATION_CONTACT_PERSON_TABLE);
        return new ContactPersonTable(findBy(LOCATION_CONTACT_PERSON_TABLE), getBasePage());
    }

    public EmailTable getEmailTable() {
        scrollToElement(EMAIL_TABLE);
        return new EmailTable(findBy(EMAIL_TABLE), getBasePage());
    }

    public AffiliationTable getNpiTable() {
        scrollToElement(NPI_TABLE);
        return new AffiliationTable(findBy(NPI_TABLE), getBasePage());
    }

    public void setPhysicalAddress(String physicalAddress) {
        fillField(PHYSICAL_ADDRESS, physicalAddress);
    }

    public void setBuilding(String building) {
        fillField(BUILDING, building);
    }

    public void setCity(String city) {
        fillField(CITY, city);
    }

    public void setZip(String zip) {
        scrollToElement(ZIP);
        findBy(ZIP).type(zip);
    }

    public void setState(String state) {
        selectFromDropDown(STATE, state);
    }

    public void setGenderServed(String genderServed) {
        select(GENDER_SERVED, genderServed);
    }

    public void setLanguages(String languages) {
        select(LANGUAGES_SUPPORTED, languages);
    }

    public void setAgeRangeServed(String ageRangeServed) {
        setCheckbox(AGE_RANGE_SERVED, ageRangeServed);
    }

    public void setInterpretiveServices(String interpretiveServices) {
        setCheckbox(INTERPRETIVE_SERVICES, interpretiveServices);
    }

    public void setNumberOfMembers(String numberOfMembers) {
        waitABit(1000);
        fillField(NUMBER_OF_MEMBERS, numberOfMembers);
        action().sendKeys(Keys.TAB).build().perform();
    }

    public void setPopulationServedAvailable(String populationServedAvailable) {
        setCheckbox(POPULATION_SERVED, populationServedAvailable);
        action().sendKeys(Keys.TAB).build().perform();
    }

    public void setCounty(String county) {
        selectRadionButton(COUNTY, county);
    }

    public void setReservation(String reservation) {
        selectRadionButton(RESERVATION, reservation);
    }

    public void setAfterHoursContactPhone(String afterHoursContactPhone) {
        waitABit(1000);
        scrollToElement(AFTER_HOURS_CONTACT_PHONE);
        findBy(AFTER_HOURS_CONTACT_PHONE).type(afterHoursContactPhone);
        action().sendKeys(Keys.TAB).build().perform();
    }

    public String getPhysicalAddress() {
        return getFieldValue(PHYSICAL_ADDRESS);
    }


    public String getZip() {
        return findBy(ZIP).getValue();
    }

    public String getGenderServed() {
        return getFieldValue(GENDER_SERVED);
    }

    public String getLanguages() {
        return getFieldValue(LANGUAGES_SUPPORTED);
    }

    public String getAgeRangeServed() {
        return getCheckboxValue(AGE_RANGE_SERVED);
    }

    public String getNumberOfMembers() {
        return getFieldValue(NUMBER_OF_MEMBERS);
    }

    public String getPopulationServedAvailable() {
        return getCheckboxValue(POPULATION_SERVED);
    }

    public String getCounty() {
        return getRadioButtonValue(COUNTY);
    }

    public String getReservation() {
        return getRadioButtonValue(RESERVATION);
    }

    //sp26
    //private static final String PRIMARY_SERVICE_LOCATION_ADDRESS_LINE1="Primary Service Location Address Line 1";
    //sp43.2
    private static final String PRIMARY_SERVICE_LOCATION_ADDRESS_LINE1=".//div//input[@id='line1']";
    private static final String SELECT_ADDRESS =".//div[contains(@role,'menuitem')]";
    public void setPrimaryServiceLocationAddressLine1(String primaryServiceLocationAddressLine1){
        waitABit(500);
        findBy(PRIMARY_SERVICE_LOCATION_ADDRESS_LINE1).click();
        waitABit(500);
        findBy(PRIMARY_SERVICE_LOCATION_ADDRESS_LINE1).type(primaryServiceLocationAddressLine1);
        waitABit(10000);
        findBy(SELECT_ADDRESS).click();
        waitForSectionPulledUp();
        waitABit(1000);
//        fillField(PRIMARY_SERVICE_LOCATION_ADDRESS_LINE1,primaryServiceLocationAddressLine1);
    }
    //sp28
    private static final String SECONDARY_SERVICE_LOCATION_ADDRESS_LINE1=".//div//input[@id='line1']";
    public void setSecondaryServiceLocationAddressLine1(String secondaryServiceLocationAddressLine1){
        waitABit(500);
        findBy(SECONDARY_SERVICE_LOCATION_ADDRESS_LINE1).click();
        waitABit(500);
        findBy(SECONDARY_SERVICE_LOCATION_ADDRESS_LINE1).type(secondaryServiceLocationAddressLine1);
        waitABit(10000);
        findBy(SELECT_ADDRESS).click();
        waitForSectionPulledUp();
        waitABit(1000);
    }

    //sp44.2
    public void setPrimaryServiceLocationAddressLine2(String primaryServiceLocationAddressLine1){
        waitABit(500);
        findBy(PRIMARY_SERVICE_LOCATION_ADDRESS_LINE1).click();
        waitABit(500);
        findBy(PRIMARY_SERVICE_LOCATION_ADDRESS_LINE1).type(primaryServiceLocationAddressLine1);
        waitABit(1000);
        //        fillField(PRIMARY_SERVICE_LOCATION_ADDRESS_LINE1,primaryServiceLocationAddressLine1);
    }
}
