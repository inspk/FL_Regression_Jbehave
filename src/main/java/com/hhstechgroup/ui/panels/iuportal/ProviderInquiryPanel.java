package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.substringBefore;

public class ProviderInquiryPanel extends AbstractPanel {
    //sp23
    private static final String NPI = ".//input[contains(@id, 'npi')]";
    private static final String ENROLLMENT_TYPE = ".//input[contains(@id, 'Enrollment Type')]/preceding-sibling::div";
    //private static final String PROVIDER_STATUS = ".//input[contains(@id, 'Provider status')]/preceding-sibling::div";
    // private static final String ACCEPTING_NEW_PATIENT = ".//input[contains(@id, 'Accepting new patient')]/preceding-sibling::div";
    // private static final String SPECIALITY_FEILD =".//label[contains(text(),'Specialty')]/..//input[contains(@id, 'select-multiple-chip')]/preceding-sibling::div";
    //private static final String TAXONOMY_ID_FEILD =".//label[contains(text(),'Taxonomy Id')]/..//input[contains(@id, 'select-multiple-chip')]/preceding-sibling::div";
    //sp30
    private static final String PROVIDER_STATUS = ".//input[contains(@id, 'Provider Status')]/preceding-sibling::div";
    private static final String ACCEPTING_NEW_PATIENT = ".//input[contains(@id, 'Accepting New Patients')]/preceding-sibling::div";
    private static final String SPECIALITY_FEILD = "(.//label[contains(text(),'Taxonomy Category')])[1]/..//input[contains(@id, 'select-multiple-chip')]/preceding-sibling::div";
    private static final String TAXONOMY_ID_FEILD = "(.//label[contains(text(),'Taxonomy')])[2]/..//input[contains(@id, 'select-multiple-chip')]/preceding-sibling::div";

    private static final String TAXONOMY_ID = "(.//input[contains(@id, 'select-multiple-chip')]/preceding-sibling::div)[3]";
    private static final String ADDRESS = ".//input[contains(@id, 'address')]";
    private static final String TAXONOMY_FEILD = ".//label[contains(text(),'Taxonomy Description')]/..//input[contains(@id, 'select-multiple-chip')]/preceding-sibling::div";
    private static final String DROP_DOWN_LIST = "//ul/li[contains(text(), '%s')]";
    private static final String PROVIDER_NAME_AND_ID = ".//input[contains(@id, 'providerName')]";
    private static final String ZIP = ".//input[contains(@id, 'zip')]";
    private static final String SEARCH_BUTTON = ".//button[span[text() = 'Search']]";
    private static final String RESET_FILTERS = ".//a/span";
    private static final String SEARCH_RESULTS_LABLE = ".//div/h2[contains (text(), 'Search results')]";
    private static final String SEARCH_RESULTS_COUNT = ".//div[contains(@class,'sc-CtfFt vlffu')]";
    private static final String LOADING_SPINNER_BAR = ".//div[@id = 'loading-bar-spinner']";
    private static final String RESULTS_SEPARATOR = " RESULTS";
    private static final String POP_UP = "//div[@role='document']";
    private static final String SSN_FEIN = ".//input[contains(@id, 'SSN/FEIN')]";

    public ProviderInquiryPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setNpi(String npi) {
        findBy(NPI).type(npi);
        waitABit(500);
    }

    //sp26
    public void setFien(String fien) {
        findBy(SSN_FEIN).type(fien);
        waitABit(500);
    }

    public void setSsn(String ssn) {
        findBy(SSN_FEIN).type(ssn);
        waitABit(500);
    }

    public void setEnrollmentType(String enrollmentType) {
        scrollToElement(ENROLLMENT_TYPE);
        findBy(ENROLLMENT_TYPE).click();
        selectFromDropDown(enrollmentType);
        waitABit(500);
    }

    public void setProviderStatus(String providerStatus) {
        jsClick(PROVIDER_STATUS);
        selectFromDropDown(providerStatus);
        waitABit(500);
    }

    public void setAcceptingnewpatient(String acceptingnewpatient) {
        jsClick(ACCEPTING_NEW_PATIENT);
        selectFromDropDown(acceptingnewpatient);
        waitABit(500);
    }

    public void setTaxonomyId(String taxonomyId) {
        jsClick(TAXONOMY_ID_FEILD);
        scrollToElement(format(DROP_DOWN_LIST, taxonomyId));
        waitABit(500);
        findBy(format(DROP_DOWN_LIST, taxonomyId)).click();
        waitABit(500);
        action().sendKeys(Keys.TAB).build().perform();
        waitABit(500);
    }

    public void setTaxonomyDescription(String taxonomyDescription) {
        jsClick(TAXONOMY_FEILD);
        scrollToElement(format(DROP_DOWN_LIST, taxonomyDescription));
        waitABit(500);
        findBy(format(DROP_DOWN_LIST, taxonomyDescription)).click();
        waitABit(500);
        action().sendKeys(Keys.TAB).build().perform();
        waitABit(500);

    }

    public void setAddress(String address) {
        findBy(ADDRESS).type(address);
        waitABit(500);
    }

    public void setSpecialty(String specialty) {
        jsClick(SPECIALITY_FEILD);
        scrollToElement(format(DROP_DOWN_LIST, specialty));
        waitABit(500);
        findBy(format(DROP_DOWN_LIST, specialty)).click();
        waitABit(500);
        action().sendKeys(Keys.TAB).build().perform();
        waitABit(500);
    }

    public void setProviderNameAndId(String providerNameAndId) {
        findBy(PROVIDER_NAME_AND_ID).type(providerNameAndId);
    }

    public void clickSearch() {
        scrollToElement(SEARCH_BUTTON);
        findBy(SEARCH_BUTTON).waitUntilEnabled();
        findBy(SEARCH_BUTTON).click();
        // waitForAbsenceOf(SPINNER);
        waitForPresenceOf(SEARCH_RESULTS_LABLE);
    }

    public void clickResetFilters() {
//        findBy(RESET_FILTERS).click();
//        waitForAbsenceOf(SPINNER);
        scrollToElement(RESET_FILTERS);
        waitABit(2000);
        jsClick(RESET_FILTERS);
    }

    public String getSearchCount(String count) {
        waitForAbsenceOf(LOADING_SPINNER_BAR);
        // return substringBefore(findBy(SEARCH_RESULTS_COUNT).getText(), RESULTS_SEPARATOR);
        return findBy(format(SEARCH_RESULTS_COUNT, count)).getText();
    }

    //sp28
    // private static final String CITY_FIELD =".//input[contains(@id, 'City')]/preceding-sibling::div";
    //sp30
    private static final String CITY_FIELD = ".//input[contains(@id, 'city')]";
    private static final String COUNTY_CODE = ".//input[contains(@id, 'countyCode')]";

    public void setCity(String city) {
        findBy(CITY_FIELD).type(city);
//        scrollToElement(CITY_FIELD);
//        findBy(CITY_FIELD).click();
//        selectFromDropDown(city);
        waitABit(500);
    }

    public void setZip(String zip) {
        findBy(ZIP).type(zip);
        waitABit(500);
    }

    public void setCountryCode(String countryCode) {
        findBy(COUNTY_CODE).type(countryCode);
        waitABit(500);
    }

    //sp30
    private static final String STATE = ".//input[contains(@id, 'State')]/preceding-sibling::div";

    public void setState(String state) {
        scrollToElement(STATE);
        findBy(STATE).click();
        selectFromDropDown(state);
        waitABit(500);
    }

    //sp47.2.1
    private static final String STATUS = ".//input[contains(@id, 'Status')]/preceding-sibling::div";
    public void setStatus(String status) {
        jsClick(STATUS);
        selectFromDropDown(status);
        waitABit(500);
    }

    private static final String MASSUPDATE_SPECIALTY = ".//input[contains(@id, 'Specialty')]/preceding-sibling::div";
    public void setMassupdatespecialty(String massupdatespecialty){
        jsClick(MASSUPDATE_SPECIALTY);
        selectFromDropDown(massupdatespecialty);
        waitABit(500);
    }

    private static final String MASSUPDATE_STATUS = "//div[text()='Status *']/parent::div";
    private static final String STATUS_OPTIONS = "//div[contains(@id,'react-select')][text()='%s']";

    public void setMassupdateStatus(String massupdateStatus) {
        findBy(MASSUPDATE_STATUS).click();
        scrollToElement(format(STATUS_OPTIONS, massupdateStatus));
        waitABit(500);
        findBy(format(STATUS_OPTIONS, massupdateStatus)).click();
        waitABit(500);
    }

    private static final String UPLOAD_INPUT = ".//input[@type=\'file\']";
    public void uploadExcel(String path) {
        WebElement element = findBy(UPLOAD_INPUT);
        getBasePage().evaluateJavascript("arguments[0].style = \"\"; arguments[0].style.display = \"block\"; arguments[0].style.visibility = \"visible\";", element);
        waitABit(1000);
        getBasePage().upload(path).to(element);
        waitABit(1000);
    }

    private static final String DROPDOWN_OPTIONS = "//div[@id][normalize-space()='%s']";
    private static final String PROGRAM_PARTICIPATION = "(//div[label[text()='Program Participation']]//div[text()])|(//div[contains(text(),'Program Participation')])";
    public void setProgramParticipation(String programParticipation){
        scrollToElement(PROGRAM_PARTICIPATION);
        waitABit(500);
        findBy(PROGRAM_PARTICIPATION).click();
        waitABit(500);
        scrollToElement(format(DROPDOWN_OPTIONS, programParticipation));
        waitABit(1000);
        findBy(format(DROPDOWN_OPTIONS, programParticipation)).click();
        waitABit(500);
    }

    private static final String STATE1 = "(//div[label[text()='State']]//div[text()])|(//div[contains(text(),'State')])";
    public void setState1(String state1){
        scrollToElement(STATE1);
        waitABit(500);
        findBy(STATE1).click();
        waitABit(500);
        scrollToElement(format(DROPDOWN_OPTIONS, state1));
        waitABit(1000);
        findBy(format(DROPDOWN_OPTIONS, state1)).click();
        waitABit(500);
    }

    private static final String SERVICE_LOCATION = "//div[label[normalize-space()='Service Location']]//input";
    public void setServiceLocation(String serviceLocation){
        scrollToElement(SERVICE_LOCATION);
        waitABit(500);
        findBy(SERVICE_LOCATION).type(serviceLocation);
        waitABit(500);
    }
}

