package com.hhstechgroup.ui.panels.enrollment.servicelocationbilling;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.opencv.ml.EM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.String.format;


public class ServiceLocationPanel extends BaseEnrollmentPanel {

    private static final String ADD_LOCATION = "//div//button[@id='addSL']//span[1]";
    private static final String START_EFFECTIVE_DATE = "//label[text()='Effective start *']/..//div//input";
    private static final String LOCATION_NAME = "Location Name";
    private static final String ADDRESS_LINE1 = "Address Line";
    private static final String SELECT_ADDRESS = ".//div[contains(@role,'menuitem')]";
    private static final String ATTENTION_LINE = "Attention Line";
    private static final String EMAIL = "Email";
    private static final String PHONE_NUMBER = "Phone Number";
    private static final String FAX = "Fax";
    private static final String EXT = "Ext";
    private static final String POSITION = "Position";
    private static final String ADD_TAXONOMY_SPECIALITY = "//div/a[text()='Add Specialty/Taxonomy']";
    private static final String PRIOR_AUTORIZATION = "//div/span[contains(text(),'prior authorization')]/..//span[text()='%s']";
    private static final String LANGUAGE_SUPPORTED = ".//label[contains(text(), 'Language Supported')]/parent::div";
    private static final String LANGUAGE_OPTIONS = "//ul/li[node()='%s']";
    private static final String GENDER_SERVED ="//label[text() ='Gender Served']/..//div/div"; //"Gender Served";
    private static final String GENDER_SERVED_OPTIONS = "//li[text()= '%s']";
    private static final String AGE_RANGES_SERVED = "//label[text()='%s']/..//input[@type='checkbox']";
    private static final String UPLOAD = ".//*[text() = '%s']/../..//div[contains(@class, 'upload_upload-controls')]/input";
    private static final String UPLOAD_CLAIM = "//*[text() = '%s']/../..//div//input[contains(@id,'claimaddAttachment')]";
    private static final String ACCEPTING_NEW_PATIENTS = "//div/p[contains(text(),'Accepting new patients')]/..//span[text()='%s']";
    private static final String TTD_TTY = "//div/p[contains(text(),'TTD/TTY')]/..//span[text()='%s']";
    private static final String COUNTY = "//div/p[contains(text(),'County')]/..//span//input[@value='%s']";
    private static final String OPEN_24HOURS = "//div/p[contains(text(),'Open 24 Hours')]/..//span[text()='%s']";
    private static final String OFFICE_HOURS_SAME = "//div/p[contains(text(),'office hours same')]/..//span[text()='%s']";
    private static final String EMERGENCY_SERVICES = "//div/p[contains(text(),'provide urgent care services')]/..//span[text()='%s']";
    private static final String PATIENT_RECORDS = "//div/p[contains(text(),'store patient records')]/..//span[text()='%s']";
    private static final String PERSONNEL_RECORDS = "//div/p[contains(text(),'store employee and or privacy records')]/..//span[text()='%s']";
    private static final String BUTTON = "(//button/span[text()='%s'])[1]";
    private static final String ADDRESS_LINE_SL="//input[contains(@id,'line1')]";
    private static final String EFFECTIVE_START_DATE="//label[contains(text(),'Effective start date')]/..//div//input";
    private static final String REGION_SAVE="(//button[@type='button']//span[contains(text(),'Save')])[3]";

    public ServiceLocationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void clickAddLocation() {
        waitABit(2000);
//        findBy(ADD_LOCATION).click();
        jsClick(ADD_LOCATION);
        waitABit(1000);
    }

    public void setEffectiveDate(String effectiveDate) {
        jsClick(START_EFFECTIVE_DATE);
        findBy(START_EFFECTIVE_DATE).sendKeys(effectiveDate);
    }
    public void setStartDate(String startDate){
        jsClick(EFFECTIVE_START_DATE);
        findBy(EFFECTIVE_START_DATE).sendKeys(startDate);
        waitABit(3000);
        findBy(REGION_SAVE).click();
    }

    public void setLocationName(String locationName) {
        waitABit(500);
        fillModifiedField(LOCATION_NAME, locationName);
    }

    public void setAddressLine1(String addressLine1) {
        waitABit(500);
        fillModifiedField(ADDRESS_LINE1, addressLine1);
        waitABit(4000);
        findBy(SELECT_ADDRESS).click();
        waitABit(6000);
    }
//    public void setAddressLineInSL(String addressLineInSL){
//        waitABit(1000);
//        fillModifiedField(ADDRESS_LINE_SL, addressLineInSL);
//        waitABit(2000);
//        findBy(SELECT_ADDRESS).click();
//
//        waitABit(2000);
//    }
public void setAddressLineInSL(String addressLineInSL){
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    // Wait for input field to be clickable
    WebElement addressInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADDRESS_LINE_SL)));
    addressInput.clear();
    addressInput.sendKeys(addressLineInSL);

    // Wait for the dropdown selection
    WebElement selectAddress = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SELECT_ADDRESS)));
    selectAddress.click();
}
    public void setAttentionLine(String attentionLine) {
        waitABit(500);
        fillModifiedField(ATTENTION_LINE, attentionLine);
    }

    public void setEmail(String email) {
        waitABit(500);
        fillModifiedField(EMAIL, email);
    }

    public void setPhoneNumber(String phoneNumber) {
        waitABit(500);
        fillModifiedField(PHONE_NUMBER, phoneNumber);
    }

    public void setFax(String fax) {
        waitABit(500);
        fillModifiedField(FAX, fax);
    }

    public void setExt(String ext) {
        waitABit(500);
        fillModifiedField(EXT, ext);
    }

    public void setPosition(String position) {
        waitABit(500);
        selectFromDropDown(POSITION, position);
    }

    public void clickAddTaxonomyOrSpeciality() {
        waitABit(500);
        scrollToElement(ADD_TAXONOMY_SPECIALITY);
        waitABit(500);
        findBy(ADD_TAXONOMY_SPECIALITY).click();
        waitABit(1000);
    }
    private static final String ADD_REGION="//button//span[contains(text(),'%s')]";
    public void clickOnAddRegion(String addregion){
        waitABit(300);
        findBy(String.format(ADD_REGION,addregion)).click();
        waitABit(500);
    }

    public void setLanguageSupported(String languageSupported) {
        waitABit(1000);
        scrollToElement(LANGUAGE_SUPPORTED);
        findBy(LANGUAGE_SUPPORTED).click();
        waitABit(1000);
        findBy(format(LANGUAGE_OPTIONS, languageSupported)).click();
        waitABit(1000);
        findBy("//ul[@aria-label='Select an option']").sendKeys(Keys.ESCAPE);
        waitABit(1000);
    }

    public void setGenderServed(String genderServed) {
        waitABit(500);
        findBy(GENDER_SERVED).click();
        findBy(format(GENDER_SERVED_OPTIONS, genderServed)).click();
//        selectFromDropDown(GENDER_SERVED, genderServed);
        waitABit(1000);
    }

    public void setAgeRangesServed(String ageRangesServed) {
        waitABit(500);
        findBy(format(AGE_RANGES_SERVED, ageRangesServed)).click();
        waitABit(1000);
    }

    public void uploadDocument(String type, String path) {
        scrollToElement(format(UPLOAD, type));
        WebElement element = findBy(String.format(UPLOAD, type));
        upload(element, path);
    }

    public void uploadClaimDocument(String type, String path) {
        try {
            scrollToElement(format(UPLOAD_CLAIM, type));
            WebElement element = findBy(String.format(UPLOAD_CLAIM, type));
            upload(element, path);
        }
        catch (Exception e){
            System.out.println("section not applicable");
        }
    }

    public void setPriorAutorization(String priorAutorization) {
        waitABit(500);
        findBy(format(PRIOR_AUTORIZATION, priorAutorization)).click();
        waitABit(500);
    }

    public void setAcceptingNewPatients(String acceptingNewPatients) {
        waitABit(500);
        findBy(format(ACCEPTING_NEW_PATIENTS, acceptingNewPatients)).click();
        waitABit(500);
    }

    public void setTtdTty(String ttdTty) {
        waitABit(500);
        findBy(format(TTD_TTY, ttdTty)).click();
        waitABit(500);
    }

    public void setCounty(String county) {
        waitABit(500);
        findBy(format(COUNTY, county)).click();
        waitABit(500);
    }

    public void setOpen24Hours(String open24Hours) {
        waitABit(500);
        findBy(format(OPEN_24HOURS, open24Hours)).click();
        waitABit(500);
    }

    public void setOfficeHoursSame(String officeHoursSame){
        waitABit(500);
        findBy(format(OFFICE_HOURS_SAME, officeHoursSame)).click();
        waitABit(500);
    }

    public void setEmergencyServices(String emergencyServices) {
        waitABit(500);
        findBy(format(EMERGENCY_SERVICES, emergencyServices)).click();
        waitABit(500);
    }

    public void setPatientRecords(String patientRecords) {
        waitABit(500);
        findBy(format(PATIENT_RECORDS, patientRecords)).click();
        waitABit(500);
    }

    public void setPersonnelRecords(String personnelRecords) {
        waitABit(500);
        findBy(format(PERSONNEL_RECORDS, personnelRecords)).click();
        waitABit(500);
    }

    public void clickButton(String button) {
        waitABit(500);
        scrollToElement(format(BUTTON, button));
        findBy(format(BUTTON, button)).click();
    }

    private static final String DRG_PARTICIPATION = "//div[contains(text(),'DRG ')]/..//..//span/input[@value='%s']";
    public void setdrgParticipation(String drgParticipation) {
        scrollToElement(format(DRG_PARTICIPATION, drgParticipation));
        waitABit(500);
        findBy(format(DRG_PARTICIPATION, drgParticipation)).click();
        waitABit(500);
    }


    private static final String OFFICE_LOCATION_INFO = "//div[contains(text(),'Are services provided')]/..//..//span/input[@value='%s']";
    public void setOfficeLocation(String officeLocation) {
        scrollToElement(format(OFFICE_LOCATION_INFO, officeLocation));
        waitABit(500);
        findBy(format(OFFICE_LOCATION_INFO, officeLocation)).click();
        waitABit(500);
    }


    private static final String PRIOR_AUTHORIZATION = "//div/span[contains(text(),'prior authorization')]/..//..//span/input[@value='%s']";
    public void setpriorAuthorization(String priorAuthorization) {
        try {
            scrollToElement(format(PRIOR_AUTHORIZATION, priorAuthorization));
            waitABit(500);
            findBy(format(PRIOR_AUTHORIZATION, priorAuthorization)).click();
            waitABit(500);
        }
        catch (Exception e){
            System.out.println("section not applicable");
        }
    }

    private static final String SERVICE_TYPE = "//div/input[contains(@id,'Service Type')]/../div";
    private static final String SERVICE_OPTION = "//ul/li[node()='%s']";
    public void setserviceType(String serviceType) {
        waitABit(200);
        findBy(SERVICE_TYPE).click();
        waitABit(500);
        findBy(format(SERVICE_OPTION, serviceType)).click();
        waitABit(500);
        findBy("//*").sendKeys(Keys.ESCAPE);
        waitABit(1000);
    }


    private static final String BED_TYPE = "//div/input[contains(@id,'Bed Type')]/../div";
    public void setBedType(String bedType) {
        waitABit(500);
        findBy(BED_TYPE).click();
        selectFromDropDown(bedType);
        waitABit(500);
    }

    private static final String N0_OF_BEDS = "//div/input[contains(@id,'No of Beds')]";
    public void setNoOfBeds(String noOfBeds) {
        waitABit(500);
        findBy(N0_OF_BEDS).sendKeys(noOfBeds);
        waitABit(200);
        findBy("//html").click();
        waitABit(500);
    }


    private static final String SEARCH_ICON = "//div[contains(@class, 'search-box')][div[contains(@class, 'styles_down')]]/span[text()='Search']";
    public void expandSearchCriteria() {
        waitABit(1000);
        if(isElementPresent(SEARCH_ICON)){
            scrollToElement(SEARCH_ICON);
            waitABit(500);
            findBy(SEARCH_ICON).click();
            waitABit(1000);
        }
    }

    private static final String ENDED_SERVICE_LOCATION = "//input[@name='endedServiceLocation']";
    public void setEndedServiceLocation(String endedServiceLocation) {
        scrollToElement(ENDED_SERVICE_LOCATION);
        waitABit(500);
        if(endedServiceLocation.equalsIgnoreCase("Yes")) {
            if(!findBy(ENDED_SERVICE_LOCATION).isSelected()) {
                findBy(ENDED_SERVICE_LOCATION).click();
                waitABit(500);
            }
        }
        else {
            if(findBy(ENDED_SERVICE_LOCATION).isSelected()) {
                findBy(ENDED_SERVICE_LOCATION).click();
                waitABit(500);
            }
        }
    }

    private static final String LOCATION_TYPE = "Location Type";
    public void setLocationType(String locationType) {
        waitABit(500);
        selectFromDropDown(LOCATION_TYPE, locationType);
    }

    private static final String SERVICE_LOCATION_NAME = "//input[@id='serviceLocationLname']";
    public void setServiceLocationName(String serviceLocationName) {
        waitABit(500);
        findBy(SERVICE_LOCATION_NAME).type(serviceLocationName);
    }

    private static final String SERVICE_LOCATION_ADDRESS = "//input[@id='secondaryServiceAddress']";
    public void setServiceLocationAddress(String serviceLocationAddress) {
        waitABit(500);
        findBy(SERVICE_LOCATION_ADDRESS).type(serviceLocationAddress);
    }

    private static final String SERVICE_LOCATION_CITY = "//input[@id='secondaryServiceCity']";
    public void  setServiceLocationCity(String serviceLocationCity) {
        waitABit(500);
        findBy(SERVICE_LOCATION_CITY).type(serviceLocationCity);
    }

    private static final String SERVICE_LOCATION_STATE = "State";
    public void setServiceLocationState(String serviceLocationState) {
        waitABit(500);
        selectFromDropDown(SERVICE_LOCATION_STATE, serviceLocationState);
    }

    private static final String SERVICE_LOCATION_ZIPCODE = "//input[@id='secondaryServiceZipCode']";
    public void setServiceLocationZipcode(String serviceLocationZipcode) {
        waitABit(500);
        findBy(SERVICE_LOCATION_ZIPCODE).type(serviceLocationZipcode);
    }

    private static final String SEARCH_BUTTON = "//button[span[text()='Search']]";
    public void clickSearch() {
        waitABit(1000);
        jsClick(SEARCH_BUTTON);
        waitABit(1000);
    }

    public static final String RESULT_DATA = "//div/p/span[normalize-space()='%s']";
    public boolean isDataPresents(String data) {
        waitABit(1000);
        return isElementPresent(format(RESULT_DATA, data));
    }

    public static final String END_EFFECTIVE_DATE = "//div[label[text()='Effective end ']]//input[@name='effectiveDatePicker']";
    public void setEndEffectiveDate(String endEffectiveDate) {
        jsClick(END_EFFECTIVE_DATE);
        waitABit(500);
        findBy(END_EFFECTIVE_DATE).sendKeys(endEffectiveDate);
    }

    private static final String IS_NPI_USED = "//label[span[text()='%s']]//input[@name='isNPIUsedForBill']";
    public void setIsNpiUsed(String isNpiUsed) {
        waitABit(500);
        scrollToElement(format(IS_NPI_USED, isNpiUsed));
        waitABit(500);
        findBy(format(IS_NPI_USED, isNpiUsed)).click();
    }

    private static final String IS_SCRIPT_SUPPLIER = "//label[span[text()='%s']]//input[@name='isScriptSupplier']";
    public void setIsScriptSupplier(String isScriptSupplier) {
        waitABit(500);
        scrollToElement(format(IS_SCRIPT_SUPPLIER, isScriptSupplier));
        waitABit(500);
        findBy(format(IS_SCRIPT_SUPPLIER, isScriptSupplier)).click();
    }

    private static final String PUBLIC_PHONE_NUMBER = "//div[label[contains(text(),'Phone Number for Patients')]]//input";
    public void setPublicPhoneNumber(String publicPhoneNumber) {
        findBy(PUBLIC_PHONE_NUMBER).type(publicPhoneNumber);
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

    private static final String PHONE_NUMBER_OF_PATIENTS = "//div[label[contains(text(),'Phone number for Patients')]]//input";
    public void setPhoneNumberOfPatients(String phoneNumberOfPatients){
waitABit(500);
        findBy(PHONE_NUMBER_OF_PATIENTS).type(phoneNumberOfPatients);
    }


    private static final String BILLING_SERVICES = "//div[input[@name='billedServices']]";
    public void setBillingServices(String billingServices) {
        scrollToElement(BILLING_SERVICES);
        waitABit(500);
        findBy(BILLING_SERVICES).click();
        waitABit(500);
        findBy(format(OPTIONS, billingServices)).click();
        waitABit(500);
    }

    private static final String FAMILY_PLANNING = "//div[input[starts-with(@id, '-')]]";
    public void setFamilyPlanning(String familyPlanning) {
        scrollToElement(FAMILY_PLANNING);
        waitABit(500);
        findBy(FAMILY_PLANNING).click();
        waitABit(500);
        findBy(format(OPTIONS, familyPlanning)).click();
        findBy(format(OPTIONS, familyPlanning)).sendKeys(Keys.ESCAPE);
        waitABit(500);
    }

    private static final String ESRD_SERVICES = "//div[input[@name='hospitalType']]";
    public void setEsrdServices(String esrdServices) {
        scrollToElement(ESRD_SERVICES);
        waitABit(500);
        findBy(ESRD_SERVICES).click();
        waitABit(500);
        findBy(format(OPTIONS, esrdServices)).click();
        waitABit(500);
    }

    private static final String GROUP_SPECIALITY = "//div[input[@name='speciality']]";
    public void setGroupSpeciality(String groupSpeciality) {
        scrollToElement(GROUP_SPECIALITY);
        waitABit(500);
        findBy(GROUP_SPECIALITY).click();
        waitABit(500);
        findBy(format(OPTIONS, groupSpeciality)).click();
        waitABit(500);
    }


    private static final String MORE_BUTTON = "//p[contains(text(),'%s')]/ancestor::div[contains(@class, 'tile-table-row')]//button[@aria-label='More']";
    private static final String DELETE_BUTTON = "//button[span[text()='Delete']]|//button[span[text()='Remove/End']]";
    public void editServiceLocation(String locationName){
        jsClick(format(MORE_BUTTON, locationName));
        waitABit(500);
        jsClick(format(DROP_DOWN_OPTION, "Edit"));
        waitABit(500);
    }

    private static final String DROP_DOWN_OPTION = "//ul/li[node() = '%s']";
    public void removeServiceLocation(String locationName){
        jsClick(format(MORE_BUTTON, locationName));
        waitABit(500);
        jsClick(format(DROP_DOWN_OPTION, "Remove/End"));
        waitABit(500);
        findBy(DELETE_BUTTON).click();
        waitABit(500);
    }


    private static final String FIRSTNAME = "First Name";
    private static final String LASTNAME = "Last Name";
    private static final String CREDENTIALS = "Credentials";
    private static final String NPI = "NPI";
    private static final String EFFECTIVE_START = "//label[text()='Effective start *']//ancestor::div[contains(@class, 'styles_datepicker')]//input";
    private static final String EFFECTIVE_END  = "//label[text()='Effective End']//ancestor::div[contains(@class, 'styles_datepicker')]//input";
    private static final String SAVE_DESIGNATED_PROVIDERS = "//div[@class='edit-cell-command']//button[span[text()='Save']]";
    public void setFirstname(String firstname){
        fillField(FIRSTNAME, firstname);
    }
    public void setLastname(String lastname){
        fillField(LASTNAME, lastname);
    }
    public void setCredentials(String credentials){
        selectFromDropDown(CREDENTIALS, credentials);
    }
    public void setNpi(String npi){
        fillField(NPI, npi);
    }
    public void setEffectiveStart(String effectiveStart){
        jsClick(EFFECTIVE_START);
        findBy(EFFECTIVE_START).sendKeys(effectiveStart);
    }
    public void setEffectiveEnd(String effectiveEnd){
        jsClick(EFFECTIVE_END);
        findBy(EFFECTIVE_END).sendKeys(effectiveEnd);
    }
    public void saveDesignatedproviders(){
        waitABit(500);
        jsClick(SAVE_DESIGNATED_PROVIDERS);
    }

    private static final String REMOVE_END_PRIMARY_LOCATION = "//label/span/span[input[@value='%s']]";
    private static final String REMOVE_END_BUTTON = "//button[span[text()='Remove/End']]";
    private static final String YES_BUTTON = "//button[span[text()='Yes']]";
    private static final String REASON_CODE = "//label[contains(text(), 'Reason Code')]/following-sibling::div/*";
    private static final String NOTES = "//div[label[text()='Note(s)']]/div/input";
    private static final String OK_BUTTON = "//button[span[text()='Ok']]";

    public void editCocServiceLocation(String locationName){
        jsClick(format(MORE_BUTTON, locationName));
        waitABit(500);
        jsClick(format(DROP_DOWN_OPTION, "Edit"));
        waitABit(500);
    }
    public void removeCocPrimaryServiceLocation(String locationName, String reason, String note){
        jsClick(format(MORE_BUTTON, locationName));
        waitABit(500);
        jsClick(format(DROP_DOWN_OPTION, "Remove/End"));
        waitABit(500);
        findBy(format(REMOVE_END_PRIMARY_LOCATION, "Yes")).click();
        waitABit(500);
        selectReasonCode(reason);
        findBy(NOTES).type(note);
        findBy(OK_BUTTON).click();
        waitABit(500);
    }

    public void removeCocSecondaryServiceLocation(String locationName, String reason, String note){
        jsClick(format(MORE_BUTTON, locationName));
        waitABit(500);
        jsClick(format(DROP_DOWN_OPTION, "Remove/End"));
        waitABit(500);
        findBy(REMOVE_END_BUTTON).click();
    }

    private void selectReasonCode(String reason){
        scrollToElement(REASON_CODE);
        waitABit(500);
        findBy(REASON_CODE).click();
        waitABit(1000);
        findBy(format(OPTIONS, reason)).click();
        waitABit(500);
    }

    private static final String POPUP_OPTION = "//div[div[text()='%s']]//button[span[text()='%s']]";
    public void clickPopupOption(String description, String value){
        waitABit(500);
        findBy(format(POPUP_OPTION, description, value)).click();
    }

    private static final String SECONDARY_LOCATION_NAME = "//div[label[text()='Location Name']]";
    public void selectPrimaryLocationName(String primaryLocationName){
        waitABit(500);
        findBy(SECONDARY_LOCATION_NAME).click();
        waitABit(500);
        findBy(format(OPTIONS, primaryLocationName)).click();
        waitABit(500);
    }
    private static final String MAILING_ADDRESS="(.//span[text() = 'Is the Mailing Address is same as the Service Location Address? *']/..//following-sibling::div//div//div//label//span//span//input[@value='%s'])[1]";
    public void setMailingAddress(String mailingAddress){
        waitABit(200);
//        selectRadionButton(MAILING_ADDRESS, mailingAddress);
        findBy(format(MAILING_ADDRESS, mailingAddress)).click();
        waitABit(200);
    }
    private static final String MIALING_ADDRESS_CONTACT_INFO="//span[contains(text(),'Service Location Contact Information? *')]/..//following-sibling::div//div//div//label//span//span//input[@value='%s']";
    public void setMailingAddressContactInfo(String mailingAddressContactInfo){
        waitABit(200);
        findBy(format(MIALING_ADDRESS_CONTACT_INFO, mailingAddressContactInfo)).click();
        waitABit(200);
    }
    public static final String WHEEL_CHAIR_ACCESSIBILITY="//div/p[contains(text(),'wheelchair accessibility features like ramps')]/..//div//label[2]//span//span//input[@value='%s']";
    public void setWheelChairAccessibility(String wheelChairAccessibility){
        waitABit(200);
        findBy(format(WHEEL_CHAIR_ACCESSIBILITY, wheelChairAccessibility)).click();
        waitABit(200);
    }

    public static final String PARKING_SPACE_FOR_HANDICAPPED="//div/p[contains(text(),'Does this location have a designated parking space for handicapped')]/..//div//label[2]//span//span//input[@value='%s']";
    public void setParkingSpaceForHandicapped(String parkingSpaceForHandicapped){
        waitABit(200);
        findBy(format(PARKING_SPACE_FOR_HANDICAPPED, parkingSpaceForHandicapped)).click();
        waitABit(200);
    }

    public static final String ASSITIVE_LISTENING_DEVICES="//div/p[contains(text(),'assistive listening devices')]/..//div//label[2]//span//span//input[@value='%s']";
    public void setAssistiveListeningDevices(String assistiveListeningDevices){
    waitABit(200);
    findBy(format(ASSITIVE_LISTENING_DEVICES, assistiveListeningDevices)).click();
    waitABit(200);
}

    public static final String ACCESSIBLE_EXAM_ROOMS="//div/p[contains(text(),'Does this location have accessible exam rooms?')]/..//div//label[2]//span//span//input[@value='%s']";
    public void setAccessibleExamRooms(String accessibleExamRooms){
        waitABit(200);
        findBy(format(ACCESSIBLE_EXAM_ROOMS,accessibleExamRooms)).click();
        waitABit(200);
    }
    public static final String SELECT_REGION="//div[contains(@id,'Select Region')]";
    public static final String REGION_VALUE="//ul//li[contains(text(),'%s')]";
    public void setRegion(String region){
        waitABit(300);
        findBy(SELECT_REGION).click();
        waitABit(400);
        findBy(String.format(REGION_VALUE,region)).click();
        waitABit(500);
    }
    private static final String SELECT_SPECIALTY="//label[contains(text(),'Select Specialty *')]/..//div//div";
    private static final String SELECT_SPECIALTY_IN_DROPDOWN="//ul/li[node() = '%s']";
    public void setSpecialty(String specialty){
        waitABit(200);
//        selectFromDropDown(SPECIALTY, specialty);
        findBy(SELECT_SPECIALTY).click();
        System.out.println("clicked on specailty");
        waitABit(2000);
        findBy(format(SELECT_SPECIALTY_IN_DROPDOWN,specialty)).click();
        System.out.println("selected sepcailty from dropdown");
        waitABit(200);
    }
    private static final String LOCATION_TAXONOMY_EFFECTIVE_START_DATE="//label[contains(text(), 'Effective Start Date')]/parent::div//input";
    private static final String LOCATION_TAXONOMY_EFFECTIVE_END_DATE="//label[contains(text(), 'Effective End Date')]/parent::div//input";

    public void setLocationTaxonomyEffectiveStartDate(String locationTaxonomyEffectiveStartDate){
        waitABit(500);
        jsClick(LOCATION_TAXONOMY_EFFECTIVE_START_DATE);
        findBy(LOCATION_TAXONOMY_EFFECTIVE_START_DATE).sendKeys(locationTaxonomyEffectiveStartDate);
    }
    public void setLocationTaxonomyEffectiveEndDate(String locationTaxonomyEffectiveEndDate){
        waitABit(500);
        jsClick(LOCATION_TAXONOMY_EFFECTIVE_END_DATE);
        findBy(LOCATION_TAXONOMY_EFFECTIVE_END_DATE).sendKeys(locationTaxonomyEffectiveEndDate);
    }
}
