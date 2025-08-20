package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class OwerKeyPersonalPanel extends BaseEnrollmentPanel {
//sp29
    private static final String EMPLOYEE_TITLE = ".//label[contains(text(), 'Employee Title')]/parent::div//input";
    private static final String NAME = ".//label[contains(text(), 'Name')]/parent::div//input";
    private static final String NPI = ".//label[contains(text(), 'NPI')]/parent::div//input";
    private static final String LICENSE_NUMBER = ".//label[contains(text(), 'License Number')]/parent::div//input";
    private static final String SSN = ".//label[contains(text(), 'SSN')]/parent::div//input";
    private static final String DOB = ".//label[contains(text(),'Date of Birth')]//ancestor::div[contains(@class, 'datepicker')]//input";
    private static final String ADDRESS_LINE = ".//label[contains(text(), 'Address line2')]/parent::div//input";
    private static final String BIRTH_STATE = ".//label[contains(text(), 'Birth State')]/parent::div";
    private static final String BIRTH_COUNTRY = ".//label[contains(text(), 'Birth Country')]/parent::div//input";
    private static final String BIRTH_COUNTY = ".//label[contains(text(), 'Birth County')]/parent::div//input";

    public OwerKeyPersonalPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    public void setEmploymeeTitle(String employmeeTitle){
        waitABit(200);
        findBy(EMPLOYEE_TITLE).type(employmeeTitle);
    }
    public void setName(String name){
        waitABit(200);
        findBy(NAME).type(name);
    }
    public void setNpi(String npi){
        waitABit(200);
        findBy(NPI).type(npi);
    }
    public void setLicenseNumber(String licenseNumber) {
        waitABit(200);
        findBy(LICENSE_NUMBER).type(licenseNumber);
    }

    public void setSsn(String ssn) {
        waitABit(200);
        findBy(SSN).type(ssn);
    }

    public void setDob(String dob) {
        waitABit(2000);
//        jsClick(DOB);
        findBy(DOB).click();
        findBy(DOB).sendKeys(dob);
        waitABit(2500);
    }

    //Demo

    private static final String MANAGING_EMPLOYEE_TYPE = ".//label[contains(text(), 'Managing Employee Type')]/parent::div//input/preceding-sibling::div";

    private static final String SELECT_MANAGING_EMPLOYEE_TYPE = "//li[text()='%s']";
    public void setManagingEmployeeType(String managingEmployeeType) {
        waitABit(500);
        findBy(MANAGING_EMPLOYEE_TYPE).click();
        waitABit(100);
        findBy(format(SELECT_MANAGING_EMPLOYEE_TYPE,managingEmployeeType)).click();
  //      selectFromDropDown(managingEmployeeType);
        waitABit(500);

    }

    private static final String FIRST_NAME = ".//label[contains(text(), 'First Name')]/parent::div//input";
    private static final String MIDDLE_NAME = ".//label[contains(text(), 'Middle Name')]/parent::div//input";
    private static final String LAST_NAME = ".//label[contains(text(), 'Last Name')]/parent::div//input";
    private static final String SSN1 = ".//label[contains(text(), 'SSN')]/parent::div//input";

    public void setFirstName(String firstName) {
        waitABit(500);
        findBy(FIRST_NAME).type(firstName);
        waitABit(500);

    }
    public void setMiddleName(String middleName) {
        waitABit(500);
        findBy(MIDDLE_NAME).type(middleName);
        waitABit(500);

    }
    public void setLastName(String lastName) {
        waitABit(500);
        findBy(LAST_NAME).type(lastName);
    }
    public void setSsn1(String ssn1) {
        waitABit(500);
        findBy(SSN1).type(ssn1);
        waitABit(500);

    }

    private static final String DATE_OF_BIRTH = ".//label[contains(text(),'Date of Birth')]//ancestor::div[contains(@class, 'styles_datepicker')]//input";
    public void setDob1(String dob1) {
        waitABit(2000);
        jsClick(DATE_OF_BIRTH);
        findBy(DATE_OF_BIRTH).sendKeys(dob1);
        waitABit(2500);
    }

    private static final String COUNTRY_OF_BIRTH = ".//label[contains(text(), 'Country of Birth')]/parent::div//input/preceding-sibling::div";

    private static final String SELECT_COUNTRY_OF_BIRTH = "//li[text()='%s']";
    private static final String STATE_OF_BIRTH = ".//label[contains(text(), 'State of Birth')]/parent::div//input/preceding-sibling::div";
    private static final String SELECT_STATE_OF_BIRTH = "//div//ul//li[text()='%s']";
    public void setCountryOfBirth(String countryOfBirth) {
        try {
            waitABit(500);
            findBy(COUNTRY_OF_BIRTH).click();
            waitABit(500);
            findBy(format(SELECT_COUNTRY_OF_BIRTH,countryOfBirth)).click();
  //          selectFromDropDown(countryOfBirth);
            waitABit(500);

        }
        catch (Exception e){
            System.out.println("license section not present"); }
    }

    public void setStateOfBirth(String stateOfBirth) {
        try {
            waitABit(500);
            findBy(STATE_OF_BIRTH).click();
            waitABit(100);
          //  findBy(format(SELECT_STATE_OF_BIRTH, stateOfBirth)).click();
            selectFromDropDown("Alabama");
            waitABit(500);

        }
        catch (Exception e){
            System.out.println("license section not present"); }
    }

    private static final String COUNTY_OF_BIRTH = ".//label[contains(text(), 'County of Birth')]/parent::div//input";
    public void setCountyOfBirth(String countyOfBirth) {
        waitABit(500);
        findBy(COUNTY_OF_BIRTH).type(countyOfBirth);
        waitABit(500);
    }

    private static final String EMPLOYEE_STATUS = ".//label[contains(text(), 'Employee Status')]/parent::div//input/preceding-sibling::div";

    private static final String SELECT_EMPLOYEE_STATUS = "//li[text()='%s']";

    public void setEmployeeStatus(String employeeStatus) {
        waitABit(500);
        findBy(EMPLOYEE_STATUS).click();
        waitABit(100);
        findBy(format(SELECT_EMPLOYEE_STATUS,employeeStatus)).click();
   //     selectFromDropDown(employeeStatus);
        waitABit(500);
    }
    private static final String SSN_START_DATE = ".//div[@data-for='Effective Start Date']//div//input";
    public void setSsnStartDate(String ssnStartDate) {
        waitABit(2000);
        jsClick(SSN_START_DATE);
        findBy(SSN_START_DATE).sendKeys(ssnStartDate);
        waitABit(2500);
    }

    private static final String SSN_END_DATE = ".//div[@data-for='End Date']//div//input";
    public void setSsnEndDate(String ssnEndDate) {
        waitABit(2000);
        jsClick(SSN_END_DATE);
        findBy(SSN_END_DATE).sendKeys(ssnEndDate);
        waitABit(2500);
    }

    private static final String SSN_ADDRESS = ".//div[contains(@data-for,'Address')]//div//input";
    private static final String SELECT_SSN_ADDRESS = "//li[contains(@role,'option')]/div";
    public void setSsnAddress(String ssnAddress) {
        scrollToElement(SSN_ADDRESS);
        waitABit(2000);
        findBy(SSN_ADDRESS).sendKeys(ssnAddress);
        waitABit(2000);
        findBy(SELECT_SSN_ADDRESS).click();
        waitABit(2000);
    }

    private static final String ADDRESS_LINE1 = ".//label[contains(text(), 'Address')]/parent::div//input";
    private static final String OPTIONS = "//li[@role='option']/div";
    public void setAddressLine1(String addressLine1){
        scrollToElement(ADDRESS_LINE1);
        waitABit(2000);
        findBy(ADDRESS_LINE1).sendKeys(addressLine1);
        waitABit(2000);
        findBy(OPTIONS).click();
    }
    private static final String EMP_TYPE = ".//label[contains(text(), 'Managing Employee Type')]/parent::div//input/preceding-sibling::div";
    private static final String EMP_TYPE_DROPDOWN = "//li[text()='%s']";
    public void setEmpType(String empType){
        scrollToElement(EMP_TYPE);
        waitABit(200);
        findBy(EMP_TYPE).click();
        waitABit(200);
//        findBy(format(EMP_TYPE_DROPDOWN,empType)).click();
        selectFromDropDown("Partner");
        waitABit(200);
    }
    private static final String PROVIDER_ID="//input[contains(@aria-label,'Provider ID')]";
    public void setProviderID(String providerID){
        scrollToElement(PROVIDER_ID);
        waitABit(200);
        findBy(PROVIDER_ID).type(providerID);
        waitABit(300);
    }
    private static final String RACE="//div[contains(@id,'Race')]";
    private static final String SELECT_RACE="//li[text()='%s']";
    public void setRace(String race){
        waitABit(500);
        findBy(RACE).click();
        waitABit(100);
        findBy(format(SELECT_RACE,race)).click();
        waitABit(500);
    }
    private static final String GENDER="//div[contains(@id,'Gender')]";
    private static final String SELECT_GENDER="//li[text()='%s']";
    public void setGender(String gender){
        waitABit(500);
        findBy(GENDER).click();
        waitABit(100);
        findBy(format(SELECT_GENDER,gender)).click();
        waitABit(500);

    }
}
