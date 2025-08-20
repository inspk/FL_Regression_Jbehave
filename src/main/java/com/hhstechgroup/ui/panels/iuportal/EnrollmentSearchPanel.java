package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.bcel.generic.PUSH;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class EnrollmentSearchPanel extends AbstractPanel {

    private static final String REQUEST_ID = ".//input[@id = 'RequestID']";
    private static final String SEARCH_BUTTON = ".//button[span[text() = 'Search']]";
    //latest
    private static final String PROVIDER_NAME = ".//input[contains(@id, 'ProviderID')]";
    private static final String REQUESTS_ID = ".//input[contains(@id, 'RequestID')]";
    private static final String STATUS = ".//div[contains(text(),'Status')]/..";
    private static final String PROVIDER_STATUS="//div[contains(text(),'Provider Status')]/..";
    private static final String ENROLLMENT_TYPE = "//div[text()='Enrollment Type']/..";
    private static final String SELECT_ENROLLMENT_TYPE="//div[text()='%s']";
    private static final String POP_UP = "//div[@role='document']";
    private static final String DROPDOWN_LIST = "//div[@role='document']/ul";
    private static final String STATUS_OF_ENROLLMENT = "//div//p[text()='%s']";
  // private static final String PART_OF_ENROLLMENT_INFO = "//div[contains(@class, 'tile-table-column sc-gwVKww fbbde')]";

    //sprint 20 xpath changed
    private static final String PART_OF_ENROLLMENT_INFO = "//div[contains(@class, 'tile-table-column')]" ;
    private static final String SELECT_STATUS=".//div[text()='%s']";
    private static final String SELECT_TYPE="//div[text()='%s']";
    private static final String ENROLL_TYPE="//div[text()='Enrollment type']/..";
    private static final String SELECT_ENROLL_TYPE="//div[text()='%s']";


    public void setProviderIDorName(String providerIDorName) {
        scrollToElement(PROVIDER_NAME);
        findBy(PROVIDER_NAME).sendKeys(providerIDorName);
        waitABit(2000);
        findBy(SEARCH_BUTTON).click();
        waitABit(3000);
    }
    private static final String REQUEST_TYPE = ".//div[text()='Request type']/parent::div";
    public void setRequestType(String requestType){
        waitABit(1000);
        findBy(REQUEST_TYPE).click();
        waitABit(2000);
        findBy(format(OPTIONS, requestType)).click();
    }
    public void setRequestID(String requestID) {
        findBy(REQUESTS_ID).type(requestID);
    }

    public void setStatus(String status) {
        findBy(STATUS).click();
//        selectFromDropDown(status);
        waitABit(200);
        findBy(format(SELECT_STATUS,status)).click();
        waitABit(200);
    }

    public void setProviderStatus(String providerStatus){
        findBy(PROVIDER_STATUS).click();
        waitABit(300);
        findBy(format(SELECT_STATUS,providerStatus)).click();
        waitABit(300);

    }

    public void setEnrollmentType(String enrollmentType) {
        scrollToElement(ENROLLMENT_TYPE);
        findBy(ENROLLMENT_TYPE).click();
        // scrollToElement(format(POP_UP,enrollmentType));
        findBy(format(SELECT_TYPE,enrollmentType)).click();
//        selectFromDropDown(enrollmentType);
    }

    public EnrollmentSearchPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setRequestId(String requestId) {
        waitForAbsenceOf(SPINNER);
        waitABit(500);
        findBy(REQUEST_ID).type(requestId);
        waitABit(500);
        getBasePage().waitForCondition().until(driver -> findBy(REQUEST_ID).getAttribute("value").equals(requestId));
        waitABit(500);
    }

    public void clickSearch() {
        scrollToElement(SEARCH_BUTTON);
        WebElementFacade el = findBy(SEARCH_BUTTON);
        waitABit(1000);
        getBasePage().evaluateJavascript("arguments[0].click();", el);
    }

    public String getRequestIdByProviderName(String name, String status, int delay) {
        setProviderIDorName(name);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(delay * 1000);
                clickSearch();
                waitABit(500);
                String statusEnrollment = String.format(STATUS_OF_ENROLLMENT, status);
                if(findBy(statusEnrollment).getText().equals(status)){
                    return getSpecificEnrollmentColumnText(0);
                }else{
                    System.out.println("Status is not displayed yet");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Request id is still not displayed");
                if (i == 9) {
                    throw new RuntimeException("Request is not found");
                }
            }
        }
        waitABit(500);
        return null;
    }

    public String getRequestIdByTrackingNum(String status, int delay) {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(delay * 1000);
                clickSearch();
                waitABit(500);
                String statusEnrollment = String.format(STATUS_OF_ENROLLMENT, status);
                if(findBy(statusEnrollment).getText().equals(status)){
                    return getSpecificEnrollmentColumnText(0);
                }else{
                    System.out.println("Status is not displayed yet");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Request id is still not displayed");
                if (i == 9) {
                    throw new RuntimeException("Request is not found");
                }
            }
        }
        waitABit(500);
        return null;
    }


    public boolean getStatusEnrollmentByName(String name, String status, int delay) {
        setProviderIDorName(name);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(delay * 1000);
                clickSearch();
                waitABit(500);
                String statusEnrollment = String.format(STATUS_OF_ENROLLMENT, status);
                if(findBy(statusEnrollment).getText().equals(status)) {
                    return true;
                }else{
                    System.out.println("Status is not displayed yet");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Status is still not displayed");
                if (i == 9) {
                    throw new RuntimeException("Status is not found");
                }
            }
        }
        waitABit(500);
        return false;
    }

    public String getSpecificEnrollmentColumnText(int index) {

        String columnText = findAll(PART_OF_ENROLLMENT_INFO).get(index).getText();

        return columnText;
    }

    //newly adding
    private static final String ENROLLMENT_NAME1 =".//div[contains(@class, 'main-info-panel_item_')]//div";
    private static final String STATUS_APPROVED =".//div[contains(text(),'APPROVED')]";
    private static final String ENROLLMENT_NAME2 =".//div[contains(@class, 'main-info-panel_item_')]//div";
    private static final String STATUS_DENIED =".//div[contains(text(),'DENIED')]";

    public Map<String, String> getMappedEnrollmentValuesForRecord() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("PROVIDER NAME",(findBy(format(ENROLLMENT_NAME1))).getText());
        map.put("STATUS_APPROVED",(findBy(format(STATUS_APPROVED))).getText());
        return  map;
    }

    public Map<String, String> getMappedEnrollmentValuesForRecord1() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("PROVIDER NAME", (findBy(format(ENROLLMENT_NAME2))).getText());
        map.put("STATUS_DENIED",(findBy(format(STATUS_DENIED))).getText());
        return map;

    }
    //sp23
    private static final String ASSIGNEE =".//div[contains(@class, 'details_action_')]/span";
    public Map<String, String> getMappedEnrollmentValuesForAssinee() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("PROVIDER NAME", (findBy(format(ENROLLMENT_NAME1))).getText());
        map.put("ASSIGNEE", (findBy(format(ASSIGNEE))).getText());
        return map;

    }

    public boolean getStatusProvider(String status, int delay) {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(delay * 1000);
                clickSearch();
                String statusEnrollment = String.format(STATUS_OF_ENROLLMENT, status);
                if (findBy(statusEnrollment).getText().equals(status)) {
                    return true;
                } else {
                    System.out.println("Status is not displayed yet");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Status is still not displayed");
                if (i == 9) {
                    throw new RuntimeException("Status is not found");
                }
            }
        }
        return false;
    }

//duplicity
    private static final String MORE_BUTTON = ".//following-sibling::div//button[@aria-label = 'More']";
    public void clickMoreButton(){
        findAll(MORE_BUTTON).get(0).click();
    }

    private static final String TYPE = "//div[text()='Type']/parent::div";
    private static final String OPTIONS = "//div[contains(@id,'option') and text()='%s']";
    public void setCocType(String cocType){
        waitABit(1000);
        findBy(TYPE).click();
        waitABit(2000);
        findBy(format(OPTIONS, cocType)).click();
    }

    private static final String FEIN_SSN = ".//input[@id = 'FeinSSN']";
    public void setFeinSSN(String feinSSN) {
        waitABit(1000);
        findBy(FEIN_SSN).click();
        waitABit(1000);
        findBy(FEIN_SSN).type(feinSSN);
        waitABit(1000);
    }

    private static final String REQUEST_STATUS = ".//div[text()='Request status']/parent::div";
    public void setRequestStatus(String requestStatus){
        waitABit(1000);
        findBy(REQUEST_STATUS).click();
        waitABit(2000);
        findBy(format(OPTIONS, requestStatus)).click();
    }


    private static final String NPI = ".//input[@id = 'NPI']";
    public void setNpi(String npi) {
        waitABit(1000);
        findBy(NPI).click();
        waitABit(1000);
        findBy(NPI).type(npi);
        waitABit(1000);
    }

    private static final String ASSIGNEE_SEARCH = ".//input[@id = 'Assignee']";
    public void setAssignee(String assignee) {
        waitABit(1000);
        findBy(ASSIGNEE_SEARCH).click();
        waitABit(1000);
        findBy(ASSIGNEE_SEARCH).type(assignee);
        waitABit(1000);
    }

    private static final String DATE_FROM = ".//label[contains(text(), 'Status date from')]/parent::div//input";
    public void setFromDate(String fromDate) {
        waitABit(1000);
        findBy(DATE_FROM).click();
        waitABit(1000);
        findBy(DATE_FROM).type(fromDate);
        waitABit(1000);
    }

    private static final String DATE_TO = ".//label[contains(text(), 'Status date to')]/parent::div//input";
    public void setToDate(String toDate) {
        waitABit(1000);
        findBy(DATE_TO).click();
        waitABit(1000);
        findBy(DATE_TO).type(toDate);
        waitABit(1000);
    }

    private static final String PROGRAM_PARTICIPATION = "//div[label[text()='Program Participation']]/div | //div[text()='Program Participation']/parent::div";
    public void setCocProgramParticipation(String cocProgramParticipation){
        waitABit(1000);
        scrollToElement(PROGRAM_PARTICIPATION);
        waitABit(500);
        findBy(PROGRAM_PARTICIPATION).click();
        waitABit(2000);
        findBy(format(OPTIONS, cocProgramParticipation)).click();
    }

    private static final String SPECIALITY = "//div[label[text()='Speciality']]/div | //div[text()='Speciality']/parent::div";
    public void setCocSpeciality(String cocSpeciality){
        waitABit(1000);
        findBy(SPECIALITY).click();
        waitABit(2000);
        findBy(format(OPTIONS, cocSpeciality)).click();
        waitABit(500);
        action().sendKeys(Keys.ESCAPE);
    }

    private static final String TAXONOMY = "//div[label[text()='Taxonomy']]/div | //div[text()='Taxonomy']/parent::div";
    public void setCocTaxonomy(String cocTaxonomy){
        waitABit(1000);
        findBy(TAXONOMY).click();
        waitABit(2000);
        findBy(format(OPTIONS, cocTaxonomy)).click();
    }

    private static final String LICENSE_TYPE = "//div[label[text()='License Type']]/div | //div[text()='License Type']/parent::div";
    public void setCocLicenseType(String cocLicenseType){
        waitABit(1000);
        findBy(LICENSE_TYPE).click();
        waitABit(2000);
        findBy(format(OPTIONS, cocLicenseType)).click();
    }
    public void setType(String type){
        waitABit(200);
        findBy(TYPE).click();
        waitABit(200);
        findBy(format(SELECT_TYPE,type)).click();
        waitABit(200);

    }
    public void setEnrollType(String enrollType){
        waitABit(200);
        findBy(ENROLL_TYPE).click();
        waitABit(200);
        findBy(format(SELECT_ENROLL_TYPE,enrollType)).click();
        waitABit(200);

    }
    public void setApplicationType(String applicationType){
        waitABit(500);
        try{
//        if(findBy(format(SUBTABS_TITLES, applicationType)).isDisplayed()) {
          findBy(format(SUBTABS_TITLES, applicationType)).isDisplayed();
            System.out.println("Application Type question is displayed");
        }
//        }
        catch (Exception e){
//        else {
            System.out.println("=====Application Type question is not displayed====");
        }
//        }
    }
    private static final String DUPLICATE_RECORDS="(//div[contains(@class,'tile-table-row')])[1]";
    public void setPracticeType(String practiceType){
//      try{

        if(  findBy(String.format(SUBTABS_TITLES,practiceType)).isDisplayed())
          System.out.println("Practice Type is displayed");
//      }
//      catch (Exception e){
        else {
            System.err.println("=====PRACTICE TYPE FIELD IS NOT DISPLAYED=====");
        }
//      }
    }
    private static final String SUBTABS_TITLES="//div//h2[contains(text(),'%s')]";

    public void setFirstName(String firstName){
//        try{
//            waitFor((ExpectedCondition) findBy(format(SUBTABS_TITLES, firstName)));
            if(findBy(format(SUBTABS_TITLES,firstName)).isDisplayed()) {
                System.out.println("First Name is displayed");
            }
//        }
//        catch (Exception e){
        else {
                System.err.println("====FIRST NAME FIELD IS NOT DISPLAYED====");
            }
//        }
    }
    public void setProviderEnrollmentDetails(String providerEnrollmentDetails){
        try{
            findBy(String.format(SUBTABS_TITLES,providerEnrollmentDetails)).isDisplayed();
        }
        catch (Exception e){
            System.err.println("====Provider Enrollment Details not found====");
        }
    }

    public void setDuplicatesFound(String duplicatesFound) {
        try {
            if (findBy(String.format(SUBTABS_TITLES, duplicatesFound)).isVisible()) {
                System.out.println("Duplicate info displayed via SUBTABS_TITLES.");
                return;
            }
        } catch (Exception e) {
            try {
                if (findBy(DUPLICATE_RECORDS).isVisible()) {
                    System.out.println("Duplicate data found using fallback locator.");
                    return;
                }
            } catch (Exception ee) {
                System.err.println("====Duplicate data not Found====");
            }
        }
    }
    private static final String INDICATOR_LEVEL="//div[@id='indicatorlevel']";
    public void setIndicatorLevel(String indicatorLevel){
        waitABit(400);
        findBy(INDICATOR_LEVEL).click();
        waitABit(400);
        selectFromDropDown(indicatorLevel);
        waitABit(300);
    }
    private static final String INDICATOR_TYPE="//div[@id='indicatorType']";
    public void setIndicatorType(String indicatorType){
        findBy(INDICATOR_TYPE).click();
        waitABit(500);
        selectFromDropDown(indicatorType);
        waitABit(300);
    }
    private static final String INDICATOR_VALUE="//div[@id='indicatorvalue']";
    public void setIndicatorValue(String indicatorValue){
        findBy(INDICATOR_VALUE).click();
        waitABit(500);
        selectFromDropDown(indicatorValue);
        waitABit(200);
    }

    private static final String REASON_CODE="//div[@id='reasoncode']";
    public void setReasonCode(String reasonCode){
        waitABit(300);
        findBy(REASON_CODE).click();
        selectFromDropDown(reasonCode);
    }
    private static final String PROVIDER_START_DATE="//label[contains(text(),'Effective Start Date')]/parent::div//input";
    public void setProviderStartDate(String providerStartDate){
        waitABit(300);
        findBy(PROVIDER_START_DATE).click();
        findBy(PROVIDER_START_DATE).sendKeys(providerStartDate);
        waitABit(300);
    }
    private static final String IDENTIFIER_LEVEL="//div[contains(@id,'identifierlevel')]";
    public void setIdentifierLevel(String identifierLevel){
        waitABit(200);
        findBy(IDENTIFIER_LEVEL).click();
        waitABit(400);
        selectFromDropDown(identifierLevel);
        waitABit(300);
    }

    private static final String IDENTIFIER_NAME="//div[contains(@id,'identifiername')]";
    public void setIdentifierName(String identifierName){
        waitABit(300);
        findBy(IDENTIFIER_NAME).click();
        waitABit(500);
        selectFromDropDown(identifierName);
    }
    private static final String INDENTIFIER_TYPE="//div[contains(@id,'identifiertype')]";
    public void setIdentifierType(String identifierType){
        waitABit(200);
        findBy(INDENTIFIER_TYPE).click();
        waitABit(500);
        selectFromDropDown(identifierType);
    }
    private static final String IDENTIFIER_VALUE="//div//input[contains(@name,'identifierValue')]";
    public void setIdentifierValue(String identifierValue){
        waitABit(200);
        findBy(IDENTIFIER_VALUE).sendKeys(identifierValue);
        waitABit(400);
    }
    private static final String IDENTIFIER_REASON_CODE="//div[contains(@id,'reasoncode')]";
    public void setIdentifierReasonCode(String identifierReasonCode){
        waitABit(200);
        findBy(IDENTIFIER_REASON_CODE).click();
        waitABit(500);
        selectFromDropDown(identifierReasonCode);
        waitABit(300);
    }
    private static final String START_DATE=".//label[contains(text(), 'Start Date')]/parent::div//input";
    public void setStartDate(String startDate){
        waitABit(300);
        findBy(START_DATE).click();
        findBy(START_DATE).sendKeys(startDate);
        waitABit(200);
    }
    private static final String PROVIDER_TYPE="//div[contains(@id,'providerType')]";
    public void setProviderType(String providerType){
        findBy(PROVIDER_TYPE).click();
        waitABit(400);
        selectFromDropDown(providerType);
        waitABit(400);
    }
    private static final String CONTRACTS="//div[contains(@id,'contracts')]";
    public void setContracts(String contracts){
        waitABit(200);
        findBy(CONTRACTS).click();
        waitABit(400);
        selectFromDropDown(contracts);
        waitABit(400);
    }
    private static final String FINANCIAL_PAYER="//div[contains(@id,'financialPayer')]";
    public void setFinancialPayer(String financialPayer){
        waitABit(200);
        findBy(FINANCIAL_PAYER).click();
        waitABit(400);
        selectFromDropDown(financialPayer);
        waitABit(400);
    }
    private static final String CONTRACT_STATUS="//div[contains(@id,'status')]";
    public void setContractStatus(String contractStatus){
        waitABit(200);
        findBy(CONTRACT_STATUS).click();
        waitABit(300);
        selectFromDropDown(contractStatus);
        waitABit(300);
    }

}
