package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;

import static java.lang.String.format;
import static java.util.stream.Collectors.toMap;

public class IdentifyingInformationPanel extends BaseEnrollmentPanel {

    private static final String PREFIX = "Prefix";
    private static final String FIRST_NAME = "First Name";
    private static final String LAST_NAME = "Last Name";
    private static final String MI = "MI";
    private static final String SUFFIX = "Suffix";
    private static final String GENDER = "//input[@name='Gender']";

    private static final String SELECT_GENDER ="//div//ul[@role='listbox']//li//div[@role='menuitem']//div//strong[text()='%s']";

    private static final String COUNTRY_OF_BIRTH = "Country of birth";

    private static final String DATE_OF_BIRTH_VALUE = ".//label[text() = 'Date of birth *']/following-sibling::div//input";
    private static final String STATE = "State";
    private static final String STATE_VALUE = ".//label[contains(text(), 'State')]/following-sibling::div//input/preceding-sibling::div";
    private static final String SHARE_WITH_MEMBERS_OPTION = "May gender information";
    //    private static final String EMAIL = "email";
    private static final String EMAIL = "Application Contact Email";
    private static final String SSN = "SSN";
    private static final String TAX_REPORTING = "tax reporting";
    private static final String RACE = "Race";
    private static final String PREVIOUSLY_ENROLLED = "previously enrolled";
    private static final String ID_TYPE = "ID type";
    private static final String NPI_API = "NPI/API";
    private static final String CALENDAR = "//div[@role='document']";
    private static final String MCO_NAME = "MCO Name";
    //private static final String FEIN = "FEIN";
    private static final String FISCAL_YEAR_END = "Fiscal year end";
    private static final String CONTACT_EMAIL = "MCO main contact email";
    private static final String DIFFERENT_NAME = "Have you used a different DBA name?";
    private static final String FORMER_DBA_NAME = "Former DBA Name";
    private static final String TAX_EXEMPT = "Is the business listed under tax-exempt status?";
    private static final String GROUP_NAME = "Group name";
    //private static final String TAX_ENTITY_TYPE = "Tax entity type";
    //latest
    private static final String BUSINESS_NAME = "Legal Business Name";
    private static final String PROVIDER_TYPE = "Provider type";

    public IdentifyingInformationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setFormerDbaName(String formerDbaName) {
        fillField(FORMER_DBA_NAME, formerDbaName);
    }

    public void setPrefix(String prefix) {
        select(PREFIX, prefix);
    }

    public void setFirstName(String firstName) {
        waitABit(1000);
        fillModifiedField(FIRST_NAME, firstName);
        fillModifiedField(FIRST_NAME, firstName);
//        waitABit(1000);
//        fillField(FIRST_NAME, firstName);
        waitABit(2000);
    }

    public void setLastName(String lastName) {
        waitABit(1000);
        fillModifiedField(LAST_NAME, lastName);
        fillModifiedField(LAST_NAME, lastName);
        waitABit(2000);
//        fillField(LAST_NAME, lastName);
//        waitABit(500);
    }

    public void setMi(String mi) {
        fillField(MI, mi);
    }

    public void setSuffix(String suffix) {
        select(SUFFIX, suffix);
    }

    public void setGender(String gender) {
        waitABit(1000);
   //     select(GENDER, gender);
        findBy(GENDER).click();
        waitABit(100);
findBy(format(SELECT_GENDER,gender)).click();

//        waitABit(200);
//        select(GENDER, gender);
        waitABit(2000);
    }

    //latest sp41.2
    private static final String NEW_COUNTRY_OF_BIRTH = "//input[contains(@name,'Country of Birth')]";
    private static final String NEW_COUNTRY_OF_BIRTH_LIST = ".//div/strong[text()='United States']";

    public void setCountryOfBirth(String countryOfBirth) {
        waitABit(100);
        scrollToElement(NEW_COUNTRY_OF_BIRTH);
        findBy(NEW_COUNTRY_OF_BIRTH).sendKeys(countryOfBirth);
        waitABit(3000);
    }

    public void setState(String state) {
        selectFromDropDown(STATE, state);
    }

    public void setShareWithMembers(String shareWithMembers) {
        selectRadionButton(SHARE_WITH_MEMBERS_OPTION, shareWithMembers);
    }

    public void setEmail(String email) {
        waitABit(200);
        fillModifiedField(EMAIL, email);
//        fillField(EMAIL, email);
        //  waitABit(200);
//        fillField(EMAIL, email);
        waitABit(1000);
    }

    public void setSsn(String ssn) {
        waitABit(200);
        fillModifiedField(SSN, ssn);
        waitABit(1000);
    }

    public void setTaxReportingNumber(String taxReportingNumber) {
        selectRadionButton(TAX_REPORTING, taxReportingNumber);
    }

    public void setRace(String race) {
        select(RACE, race);
    }

    public void setPreviouslyEnrolled(String previouslyEnrolled) {
        selectRadionButton(PREVIOUSLY_ENROLLED, previouslyEnrolled);
    }

    public void setIdType(String idType) {
        select(ID_TYPE, idType);
    }

    public void setNpiApi(String npiApi) {
        fillField(NPI_API, npiApi);
    }

    public void setMcoName(String mcoName) {
        fillField(MCO_NAME, mcoName);
    }

    //sp35
    private static final String FEIN = ".//label[contains(text(), 'FEIN Number') or contains(text(),'FEIN')]/following-sibling::div//input";

    public void setFederalEmployerIdentification(String federalEmployerIdentification) {
        waitABit(500);
        findBy(FEIN).type(federalEmployerIdentification);
        // fillField(FEIN, federalEmployerIdentification);
        //fillField(FEIN, federalEmployerIdentification);
        waitABit(1000);

    }

    public void setFiscalYearEnd(String fiscalYearEnd) {
        select(FISCAL_YEAR_END, fiscalYearEnd);
    }

    public void setMainContactEmail(String setMainContactEmail) {
        fillField(CONTACT_EMAIL, setMainContactEmail);
    }

    public void setDifferentName(String differentName) {
        selectRadionButton(DIFFERENT_NAME, differentName);
    }

    public void setTaxExemptStatus(String taxExemptStatus) {
        selectRadionButton(TAX_EXEMPT, taxExemptStatus);
    }

    public String getPrefix() {
        return getFieldValue(PREFIX);
    }

    public String getFirstName() {
        return getFieldValue(FIRST_NAME);
    }

    public String getLastName() {
        return getFieldValue(LAST_NAME);
    }

    public String getMi() {
        return getFieldValue(MI);
    }

    public String getGender() {
        return getFieldValue(GENDER);
    }

    public String getCountryOfBirth() {
        return getFieldValue(COUNTRY_OF_BIRTH);
    }

    public String getState() {
        scrollToElement(STATE_VALUE);
        return findBy(STATE_VALUE).getText();
    }

    public String getDateOfBirth() {
        return findBy(DATE_OF_BIRTH_VALUE).getValue();
    }

    public String getShareWithMembers() {
        return getRadioButtonValue(SHARE_WITH_MEMBERS_OPTION);
    }

    public String getEmail() {
        waitABit(2000);
        return getFieldValue(EMAIL);
    }

    public String getSsn() {
        waitABit(500);
        return getFieldValue(SSN);

    }

    public String getTaxReportingNumber() {
        return getRadioButtonValue(TAX_REPORTING);
    }

    public String getRace() {
        return getFieldValue(RACE);
    }

    public void setGroupName(String groupName) {
        waitABit(500);
        fillField(GROUP_NAME, groupName);
        waitABit(500);
    }

    //latest
    public void setBusinessName(String businessName) {
        fillModifiedField(BUSINESS_NAME, businessName);
    }

    public String getBusinessName() {
        return getFieldValue(BUSINESS_NAME);
    }

    public void setProviderType(String providerType) {
        select(PROVIDER_TYPE, providerType);
    }

    public String getProviderType() {
        return getFieldValue(PROVIDER_TYPE);
    }

//sp22

//    private static final String DATE_OF_BIRTH = ".//label[text() = 'Date of birth *']/following-sibling::div/input/following-sibling::div/button";

//public void setDateOfBirth(String dateOfBirth) {
//    LocalDate date = DateConverter.toLocalDate(dateOfBirth);
//    findBy(DATE_OF_BIRTH).click();
//    waitForCalendarPopUpOpened();
//    CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
//    calendar.setYear(date.getYear());
//    waitABit(700);
//    calendar.setMonth(date.getMonthValue());
//    waitABit(700);
//    calendar.setDayOfMonth(date.getDayOfMonth());
//    waitABit(700);
//}

    private static final String DATE_OF_BIRTH = "//label[text()='Date of Birth *']//ancestor::div[contains(@class, 'datepicker')]//input";

    public void setDateOfBirth(String dateOfBirth) {
        waitABit(2000);
        jsClick(DATE_OF_BIRTH);
        findBy(DATE_OF_BIRTH).sendKeys(dateOfBirth);
        waitABit(2500);
    }

    //sp26
    private static final String MEDICAID_PAYMENT = "Will you receive payments directly from Medicaid?";

    public void setMediacidPayment(String mediacidPayment) {
        waitABit(500);
        selectRadionButton(MEDICAID_PAYMENT, mediacidPayment);
        waitABit(500);
    }

    private static final String TYPE_OF_BUSINESS_NAME = "What type of business are you?";
private static final String SELECT_TYPE_OF_BUSINESS_NAME = "//strong[text()='%s']";

    public void setTypeOfBusiness(String typeOfBusiness) {
        waitABit(1000);
        findBy(TYPE_OF_BUSINESS_NAME).click();
        waitABit(100);
        findBy(format(SELECT_TYPE_OF_BUSINESS_NAME,typeOfBusiness)).click();
   //     select(TYPE_OF_BUSINESS_NAME, typeOfBusiness);
        waitABit(200);
    }

    //sp26 group
    // private static final String PROVIDER_NAME = "Provider Name";
    //sp35
    private static final String PROVIDER_NAME = ".//label[contains(text(), 'Provider Name')]/following-sibling::div//input";

    public void setProviderName(String providerName) {
        waitABit(500);
        findBy(PROVIDER_NAME).type(providerName);
//        fillField(PROVIDER_NAME, providerName);
        waitABit(500);
    }

    //sp28
    private static final String TAX_ENTITY_TYPE = ".//label[contains(text(), 'Tax Entity Type')]/following-sibling::div//input";
    private static final String TAX_ENTITY_TYPE_LIST = ".//div/strong[text()='%s']";
    public void setTaxEntityType(String taxEntityType) {
        waitABit(500);
        findBy(TAX_ENTITY_TYPE).click();
//        findBy(TAX_ENTITY_TYPE).type(taxEntityType);
//        waitABit(1000);
//        findBy(TAX_ENTITY_TYPE).type(taxEntityType);
        waitABit(1000);
        findBy(format(TAX_ENTITY_TYPE_LIST, taxEntityType)).click();

    }

    //latest sp41.2
    private static final String PROFIT_STATUS = ".//div[@data-for='Profit Status']";
    private static final String PROFIT_STATUS_LIST = ".//div/strong[text()='%s']";

    //private static final String PROFIT_STATUS = "Profit Status";
    public void setProfitStatus(String profitStatus) {
        waitABit(1000);
        scrollToElement(PROFIT_STATUS);
        findBy(PROFIT_STATUS).click();
        findBy(format(PROFIT_STATUS_LIST, profitStatus)).click();
        //select(PROFIT_STATUS, profitStatus);
        waitABit(2000);
    }

    //sp35
    private static final String STATE_OF_BIRTH = ".//label[contains(text(), 'State of Birth')]/following-sibling::div//input";
    //private static final String SELECT_STATE_OF_BIRTH_OPTION = ".//div[contains(@role,'listbox')]//ul/li";
    private static final String SELECT_STATE_OF_BIRTH_OPTION = ".//li[@data-suggestion-index='%s']";

    public void setStateofBirth(String stateofBirth) {
        waitABit(500);
        scrollToElement(STATE_OF_BIRTH);
        waitABit(100);
        findBy(STATE_OF_BIRTH).sendKeys(stateofBirth);

        waitABit(500);
    }

    // Demo

    private static final String TITLE = "//input[@name='Title']";

    private static final String SELECT_TITLE = "//strong[text()='%s']";

    public void setTitle(String title) {
        waitABit(500);
  //      selectFromDropDown(TITLE, title);
        scrollToElement(TITLE);
        findBy(TITLE).click();
        waitABit(100);
        findBy(format(SELECT_TITLE,title)).click();
        waitABit(500);
    }

    private static final String MIDDLE_NAME = "Middle Name";

    public void setMiddleName(String middleName) {
        waitABit(500);
        fillModifiedField(MIDDLE_NAME, middleName);
        waitABit(500);
    }

    private static final String DBA = "Doing Business As";

    public void setdba(String dba) {
        waitABit(500);
        fillModifiedField(DBA, dba);
        waitABit(500);
    }

    //PEM
    private static final String PHONE_NUMBER = ".//label[contains(text(), 'Phone')]/parent::div//input";

    public void setPhoneNumber(String phoneNumber) {
        waitABit(200);
        findBy(PHONE_NUMBER).type(phoneNumber);
        findBy(PHONE_NUMBER).type(phoneNumber);
        waitABit(200);
    }

    private static final String FAX = ".//label[contains(text(), 'Fax')]/parent::div//input";

    public void setFax(String fax) {
        waitABit(200);
        findBy(FAX).type(fax);
        waitABit(100);
        findBy(FAX).click();
        waitABit(200);
    }

    private static final String ALTERNATE_EMAIL = ".//label[contains(text(), 'Alternate Email')]/parent::div//input";

    public void setAlternateEmail(String alternateEmail) {
        waitABit(200);
        findBy(ALTERNATE_EMAIL).type(alternateEmail);
        findBy(ALTERNATE_EMAIL).type(alternateEmail);
        waitABit(200);

    }

    private static final String DIFFERENT_DBA_NAME = "Have you used a different DBA name?";

    public void setDifferentDbaName(String differentDbaName) {
        waitABit(500);
        selectRadionButton(DIFFERENT_DBA_NAME, differentDbaName);
        waitABit(1000);
    }

    private static final String PAYMENT_RECIVED  = "Will you receive payment directly from Medicaid that will be reported to the IRS under your SSN?";

    public void setPaymentrecived(String paymentrecived) {
        waitABit(500);
        selectRadionButton(PAYMENT_RECIVED, paymentrecived);
        waitABit(1000);
    }

    private static final String IND_ORP_TYPE  = "Are you an  ORP provider?";

    public void setSelectorp(String selectorp) {
        waitABit(500);
        selectRadionButton(IND_ORP_TYPE, selectorp);
        waitABit(1000);
    }
    private static final String TAX_EXEMPTION = "Are you 1099 tax exempt?";

    public void setTaxExempt(String taxExempt) {
        waitABit(500);
        selectRadionButton(TAX_EXEMPTION, taxExempt);
        waitABit(1000);
    }

    private static final String ENROLLMENT_DATE = "//label[text()='Select Requested Enrollment Date *']//ancestor::div[contains(@class, 'styles_datepicker')]//input";
    public void setEnrollmentDate(String enrollmentDate){
        waitABit(500);
        jsClick(ENROLLMENT_DATE);
        findBy(ENROLLMENT_DATE).sendKeys(enrollmentDate);
        waitABit(1000);
    }


    private static final String REASON_CODE = ".//label[contains(text(), 'Reason Code')]/parent::div//input";
    private static final String SELECT_REASON_CODE = ".//li[@data-suggestion-index='3']";
    public void setReasonCode(String reasonCode) {
        findBy(REASON_CODE).click();
        waitABit(500);
        scrollToElement(SELECT_REASON_CODE);
        jsClick(SELECT_REASON_CODE);
//        select(SELECT_REASON_CODE,reasonCode);
        waitABit(500);
    }

    private static final String DBA_NAME = "Doing Business As (DBA) Name";
    public void setDbaName(String dbaName) {
        fillModifiedField(DBA_NAME, dbaName);
    }

    private static final String PROVIDER_LEGAL_BUSINESS_NAME = "Provider Legal Business Name";
    public void setProviderLegalBusinessName(String providerLegalBusinessName) {
        fillModifiedField(PROVIDER_LEGAL_BUSINESS_NAME, providerLegalBusinessName);
    }

    private static final String DIFFERENT_LEGAL_NAME = "Have you used a different DBA Name/Legal Business Name?";

    public void setDifferentLegalName(String differentLegalName) {
        waitABit(500);
        selectRadionButton(DIFFERENT_LEGAL_NAME, differentLegalName);
        waitABit(1000);
    }

    private static final String IS_CHANGE_OWN_FEIN = "Is this application due to a change of ownership/FEIN?";

    public void setIsChangeOwnFein(String isChangeOwnFein) {
        waitABit(500);
        selectRadionButton(IS_CHANGE_OWN_FEIN, isChangeOwnFein);
        waitABit(1000);
    }

    private static final String FISCAL_END = ".//div/input[@name='Month']";
    private static final String FISCAL_END_LIST = ".//li[@data-suggestion-index='%s']";
    private static final String FISCAL_END_DATE = ".//div/input[@name='Date']";
    private static final String SELECT_FISCAL_END_DATE = ".//li[@data-suggestion-index='28']";

    public void setFiscalEnd(String fiscalEnd) {
        waitABit(1000);
        scrollToElement(FISCAL_END);
        findBy(FISCAL_END).click();
        findBy(format(FISCAL_END_LIST, fiscalEnd)).click();
        waitABit(2000);
        findBy(FISCAL_END_DATE).click();
        waitABit(2000);
        findBy(SELECT_FISCAL_END_DATE).click();
    }


    public String getEnrollmentDate() {
        return findBy(ENROLLMENT_DATE).getText();
    }

    public String getReasonCode() {
        return findBy(REASON_CODE).getText();
    }


    private static final String ENROLLMENT_DATE_MESSAGE = "//label[text()='Select Requested Enrollment Date *']//ancestor::div/div/ul/li[text()='This field is required']";
    public boolean isEnrollmentDateMandatory(){
        return isElementPresent(ENROLLMENT_DATE_MESSAGE);
    }

    private static final String REASON_CODE_MESSAGE = "//label[contains(text(), 'Reason Code')]//ancestor::div/div/ul/li[text()='This field is required']";
    public boolean isReasonCodeMandatory(){
        return isElementPresent(REASON_CODE_MESSAGE);
    }

    private static final String DEGREE = "Degree";
    public void setDegree(String degree){
        fillModifiedField(DEGREE, degree);
    }

    private static final String APPLICATION_CONTACT_NAME="//input[contains(@aria-label,'Application Contact Name')]";
    public void setAppliationContactName(String appliationContactName){
        waitABit(300);
        findBy(APPLICATION_CONTACT_NAME).sendKeys(appliationContactName);
        waitABit(300);
    }
    private static final String APPLICATION_CONTACT_NUM="//div[contains(@data-for,'Application Contact Number')]//input";

    public void setApplicationContactNum(String applicationContactNum){
        waitABit(300);
        findBy(APPLICATION_CONTACT_NUM).sendKeys(applicationContactNum);
        waitABit(300);

    }
    private static final String APPLICATION_CONTACT_PHONE="//div[contains(@data-for,'Application Contact Phone')]//input";

    public void setApplicationContactPhone(String applicationContactPhone){
        waitABit(300);
        findBy(APPLICATION_CONTACT_PHONE).sendKeys(applicationContactPhone);
        waitABit(300);
    }
    private static final String MCO_EMAIL="//input[contains(@aria-label,'Application contact email')]";
    public void setMcoEmail(String mcoEmail){
        waitABit(200);
      findBy(MCO_EMAIL).sendKeys(mcoEmail);
        waitABit(200);
    }
    private static final String PLAN_LEGAL_NAME="//input[contains(@aria-label,'Plan Legal Name')]";

    public void setPlanLegalName(String planLegalName){
        waitABit(200);
        findBy(PLAN_LEGAL_NAME).sendKeys(planLegalName);
        waitABit(200);
    }




}






