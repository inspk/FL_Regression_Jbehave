package com.hhstechgroup.ui.pages.systemoptions;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import static java.lang.String.format;

public class ApprovalsConfigurationPage extends AbstractPage {

    private static final String VIEW_BUTTON = "//h3[text()='%s']/../..//button/span[contains(text(), 'VIEW')]";
    private static final String EDIT_BUTTON = "//button[.//span[text()='Edit']]";
    private static final String SAVE_BUTTON = "//button/span[contains(text(), 'Save')]";
    private static final String SAVE_BUTTON_FOR_AFFILIATION="//button//span[text()= 'Save']";
    private static final String CANCEL_BUTTON = "//button/span[contains(text(), 'Cancel')]";
    //private static final String NUMBER_OF_APPROVERS_NOT_ACTIVE = "//h4[text()='Number of approvers']/following-sibling::span";
    //latest
    private static final String NUMBER_OF_APPROVERS_NOT_ACTIVE =  "//h4[text()='Number of approvals required']/following-sibling::span";
  //  private static final String NUMBER_OF_REVIEWERS_NOT_ACTIVE = "//h4[text()='Number of reviewers']/following-sibling::span";
    //latest
   // private static final String NUMBER_OF_REVIEWERS_NOT_ACTIVE ="//h4[text()='Number of votes required']/following-sibling::span";
    //latest
  private static final String NUMBER_OF_REVIEWERS_NOT_ACTIVE = "//h4[text()='Number of votes required']/following-sibling::span";
    private static final String NUMBER_OF_APPROVERS_ACTIVE = "//h4[text()='Number of approvals required']/following-sibling::div";
   // private static final String NUMBER_OF_REVIEWERS_ACTIVE = "//h4[text()='Number of reviewers']/following-sibling::div";
    //latest
    private static final String NUMBER_OF_REVIEWERS_ACTIVE = "//h4[text()='Number of votes required']/following-sibling::div";
    private static final String ENABLE_REVIEWERS = "//h3[text()='Configure reviewers to vote for request approval']/..//input";
    private static final String SWITCHER = "//h3[text()='Configure reviewers to vote for request approval']/../..//div//label//span//span";
    private static final String SWITCHER_ON_COLOR = "rgba(71, 176, 75, 1)";
    private static final String SWITCHER_OFF_COLOR = "rgba(241, 241, 241, 1)";
    //private static final String ADD_REVIEWERS = "//h4[text()='Number of reviewers']/../../..//button[span[contains(text(),'ADD')]]";
    //latest
    private static final String ADD_REVIEWERS = "//h4[text()='Number of votes required']/../../..//button[span[contains(text(),'ADD')]]";
    private static final String ADD_APPROVERS = "//h4[text()='Number of approvals required']/../../..//button[span[contains(text(),'ADD')]]";
    private static final String REMOVE_REVIEWERS = "//h4[text()='Number of votes required']/../../..//div[contains(@class, 'tile-table-row') and .//p[text()='%s']]//button[@aria-label='Remove']";
   // private static final String REMOVE_APPROVERS = "//h4[text()='Number of approvers']/../../..//div[contains(@class, 'tile-table-row') and .//p[text()='%s']]//button[@aria-label='Remove']";
  //latest
    private static final String REMOVE_APPROVERS = "//h4[text()='Number of approvals required']/../../..//div[contains(@class,'tile-table-row') and .//p[text()='%s']]//button[@aria-label='Remove']";
    private static final String POP_UP = "//div[@role='presentation']";
    private static final String ADD_BUTTON = "//button[span[text()='Add']]";
   // private static final String SELECT_ROLE_USER = ".//input[contains(@id, 'select-multiple-chip')]/preceding-sibling::div";

    //sp57
    private static final String SELECT_ROLE_USER =  ".//input[contains(@id, 'select-multiple-chip')]/.." ;

   // private static final String SELECT_TYPE =".//input[contains(@id, 'Select type')]/preceding-sibling::div";
   //latest
    private static final String SELECT_TYPE = ".//div[text()='Role']";
    private static final String DROPDOWN_LIST = "//div[@role='document']/ul";
    private static final String READ_ONLY_FIELD = "//h3[contains(text(), '%s')//div[@role='document']/ul]/../..//input[@disabled]";
    private static final String APPROVALS_SECTIONS_AND_TYPE = "//div[contains(@class, 'styles_approval')]//h3[text() = '%s']/parent::div/following-sibling::div//p[contains(@class, 'styles_value_')]";

    public ApprovalsConfigurationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFieldReadOnly(String field){
        return findBy(format(READ_ONLY_FIELD, field)).isPresent();
    }

    public boolean areFieldsReadOnly(List<String> fields) {
        return fields.stream().allMatch(this::isFieldReadOnly);
    }

    public String getApprovalsSectionsAndType (String section) {
            waitForPresenceOf(format(APPROVALS_SECTIONS_AND_TYPE, section));
            return findBy(format(APPROVALS_SECTIONS_AND_TYPE, section)).getText();
        }

    public void clickViewForRequest(String request) {
        waitAbit(600);
        jsClick(format(VIEW_BUTTON, request));
//        findBy(String.format(VIEW_BUTTON, request));
        waitAbit(5000);
        waitForRenderedElementsToBePresent(By.xpath(EDIT_BUTTON));
    }

    public void clickEditButton() {
        scrollToElement(EDIT_BUTTON);
       // findBy(EDIT_BUTTON).click();
        jsClick(EDIT_BUTTON);
        waitForRenderedElementsToBePresent(By.xpath(SAVE_BUTTON));
    }

    //private static final String EDIT_BUTTON1 = ".//div[contains(text(),'Screening Issues Ranking')]/../..//button//*[local-name() = 'svg' and @aria-hidden='true']" ;
    //sp29
    //private static final String EDIT_BUTTON1 = ".//div[contains(text(),'Screening Issues Ranking')]/div/div/button" ;
    //sp66
    private static final String EDIT_BUTTON1 = ".//div[contains(text(),'Screening Issues Ranking')]/..//following-sibling::div//button//span[text()='Edit']" ;
    public void clickEditButton1() {
        waitAbit(200);
        scrollToElement(EDIT_BUTTON1);
        waitAbit(200);
         findBy(EDIT_BUTTON1).click();
        waitAbit(200);
        waitForRenderedElementsToBePresent(By.xpath(SAVE_BUTTON));
    }

    public void clickSaveButton() {
        scrollToElement(SAVE_BUTTON);
        waitAbit(2000);
        findBy(SAVE_BUTTON).click();
        waitAbit(500);
       // waitForRenderedElementsToBePresent(By.xpath(EDIT_BUTTON));
    }
    public void clickAffiSaveButton(){
        scrollToElement(SAVE_BUTTON_FOR_AFFILIATION);
        waitAbit(2000);
        findBy(SAVE_BUTTON_FOR_AFFILIATION).click();
        waitAbit(500);

    }
    private static final String CLICK_OK_BUTTON = ".//button/span[contains(text(),'Ok')]";

    //sprint 20 new lick Duplicity is adding

    private static final String DUPLICITY_EDIT_BUTTON = ".//div[contains(text(),'Configuration for Duplicity & Data Matching')]/../..//button/span/p[contains(text(),'Edit')]" ;
    public void clickduplicityeditButton() {
        scrollToElement(DUPLICITY_EDIT_BUTTON);
        findBy(DUPLICITY_EDIT_BUTTON).click();
//        waitForRenderedElementsToBePresent(By.xpath(SAVE_BUTTON));
    }



    public void clickSaveButton1() {
        scrollToElement(SAVE_BUTTON);
        waitAbit(500);
        findBy(SAVE_BUTTON).click();
        waitAbit(500);
       jsClick(CLICK_OK_BUTTON);

    }
    public void clickCancelButton() {
        findBy(CANCEL_BUTTON).click();
        waitForRenderedElementsToBePresent(By.xpath(EDIT_BUTTON));
    }

    public void selectApproversNumber(String number) {
        waitAbit(500);
       scrollToElement(SET_NUMBER_OF_APPROVAL_NUMBER);
       // waitAbit(500);
      //  waitFor(ExpectedConditions.elementToBeClickable(By.xpath(NUMBER_OF_APPROVERS_NOT_ACTIVE)));
        findBy(SET_NUMBER_OF_APPROVAL_NUMBER).click();
        findBy(SET_NUMBER_OF_APPROVAL_NUMBER).type(number);
       // selectFromDropDown(number);
        waitAbit(500);
    }
    private static final String SET_NUMBER_OF_REVIEWER_NUMBER = ".//h4[contains(text(),'Number of votes required')]/..//input[@type='text']";
    private static final String SET_NUMBER_OF_APPROVAL_NUMBER =  ".//h4[contains(text(),'Number of approvals required')]/..//input[@type='text']" ;
    private static final String SET_NUMBER_OF_CVOREVIEWER_NUMBER =  "(.//h4[contains(text(),'Number of votes required')]/..//input[@type='text'])[1]";
    private static final String ENABLE_CVOREVIEWERS ="//h3[text()='Configure CVO committee to vote for request approval']/..//input";
    private static final String ADD_CVOREVIEWERS =".//h3[text()='Configure CVO committee to vote for request approval']/../..//*[local-name() = 'svg' and @aria-hidden='true' ]";
    private static final String CVO_SWITCHER ="//h3[text()='Configure CVO committee to vote for request approval']/..//input/preceding-sibling::span";

    public void selectReviewersNumber(String number) {
        turnOnReviewers();
     //   waitFor(ExpectedConditions.elementToBeClickable(By.xpath(NUMBER_OF_REVIEWERS_NOT_ACTIVE)));
       //sp26
        jsClick(SET_NUMBER_OF_REVIEWER_NUMBER);
       // findBy(SET_NUMBER_OF_REVIEWER_NUMBER).click();
        findBy(SET_NUMBER_OF_REVIEWER_NUMBER).type(number);
       // selectFromDropDown(number);
        waitAbit(500);
    }

    public void turnOnReviewers() {
        if(!findBy(SWITCHER).getCssValue("color").contentEquals(SWITCHER_ON_COLOR)){
            scrollToElement(ENABLE_REVIEWERS);
            findBy(ENABLE_REVIEWERS).click();
        }
    }

    public void turnOffReviewers() {
        if(!findBy(SWITCHER).getCssValue("color").contentEquals(SWITCHER_OFF_COLOR)){
            findBy(ENABLE_REVIEWERS).click();
        }
    }

    public void clickAddReviewer() {
     jsClick(ADD_REVIEWERS);
    }


    public void selectCVOReviewersNumber(String number) {
        turnOnCVOReviewers();
        findBy(SET_NUMBER_OF_CVOREVIEWER_NUMBER).click();
        findBy(SET_NUMBER_OF_CVOREVIEWER_NUMBER).type(number);
        waitAbit(500);
    }

    public void turnOnCVOReviewers() {
        if(!findBy(CVO_SWITCHER).getCssValue("color").contentEquals(SWITCHER_ON_COLOR)){
            scrollToElement(ENABLE_CVOREVIEWERS);
            findBy(ENABLE_CVOREVIEWERS).click();
        }
    }

    public void turnOffCVOReviewers() {
        if(!findBy(CVO_SWITCHER).getCssValue("color").contentEquals(SWITCHER_OFF_COLOR)){
            findBy(ENABLE_CVOREVIEWERS).click();
        }
    }

    public void clickAddCVOReviewer() {
        findBy(ADD_CVOREVIEWERS).click();

    }

      public void addCVOReviewerAllSteps(String cvoreviewer, String name, String typeRole) {
            clickAddCVOReviewer();
        selectTypeRoleUser(typeRole);
        selectRoleUser(name);
        clickAddInPopup();
    }

    public void addApproverReviewerAllSteps(String reviewerApprover, String name, String typeRole){
        List<WebElementFacade> reviewers = findAll("//div[contains(@class, 'expansion-panel-summary clickable')]");
        for (int i = 0; i <reviewers.size() ; i++) {
            if(reviewers.get(i).getAttribute("innerHTML").contains(name)){
                System.out.println("This name " + name + " is already exist");
//                return;
            }
        }
        if(reviewerApprover.equals("Reviewer")){
            clickAddReviewer();
        }else if(reviewerApprover.equals("Approver")) {
            clickAddApprover();
        }
        selectTypeRoleUser(typeRole);
        selectRoleUser(name);
        clickAddInPopup();

    }


    public void clickAddApprover() {
        jsClick(ADD_APPROVERS);
        waitForPopUpOpened();
    }

    public void clickRemoveReviewer(String reviewer) {
        findBy(format(REMOVE_REVIEWERS, reviewer)).click();
    }

    public void clickRemoveApprover(String approver) {
        //sp22
        try{
            waitAbit(1000);
            jsClick(format(REMOVE_APPROVERS,approver));
        }
        catch (Exception e) {
        }
        System.out.println("step is pass");
    }

    public void selectRoleUser(String roleUser) {
//        waitForPopUpOpened();
       scrollToElement(SELECT_ROLE_USER);
        waitAbit(1000);
        findBy(SELECT_ROLE_USER).click();
        BaseModalPanel dropDown = new BaseModalPanel(findBy(POP_UP), this);
        dropDown.selectFromMultiChoiceDropDown(roleUser);
        action().sendKeys(Keys.TAB).build().perform();
//        waitForAbsenceOf(DROPDOWN_LIST);
    }

    public void selectTypeRoleUser(String typeRoleUser) {
        waitForPopUpOpened();
        findBy(SELECT_TYPE).click();
        BaseModalPanel dropDown = new BaseModalPanel(findBy(POP_UP), this);
        dropDown.selectFromDropDown(typeRoleUser);
        waitForAbsenceOf(DROPDOWN_LIST);
    }

    public void clickAddInPopup() {

      findBy(ADD_BUTTON).waitUntilEnabled().click();
        waitForAbsenceOf(POP_UP);
    }
    //latest

    private static final String SWITCHER_ON_AUTO =  ".//div/p[text()='Request is automatically approved after appearing on IU portal']/../..//input";
    public void turnOnAuto() {
        scrollToElement(SWITCHER_ON_AUTO);
        waitAbit(500);
        findBy(SWITCHER_ON_AUTO).click();
    }
    private static final String CLICK_HIDDEN_BUTTON_PENDINGAPPROVAL =".//div[contains(text(),'PENDING APPROVAL')]/..//*[local-name() = 'svg' and @aria-hidden='true']";
    public void clickOnHiddenButtonWhenPendingApproval(){findBy(CLICK_HIDDEN_BUTTON_PENDINGAPPROVAL).click();}

    private static final String CLICK_HIDDEN_BUTTON_PENDINGREVIEW =".//div[contains(text(),'PENDING REVIEW')]/..//*[local-name() = 'svg' and @aria-hidden='true']";
    public void clickOnHiddenButtonWhenPendingReview(){findBy(CLICK_HIDDEN_BUTTON_PENDINGREVIEW).click();}

    private static final String CHANGE_STATUS =".//button[span[text()='%s']]" ;
    public void clickOnChangeStatusButton(String changeStatusButton){
        //SP-64 adding scroll for change status button
        try {
            scrollToElement(format(CHANGE_STATUS, changeStatusButton));
            waitAbit(500);
            findBy(format(CHANGE_STATUS, changeStatusButton)).click();
        }
        catch (Exception e)
        {
            System.out.println("Change sttaus button is not there");
        }
        }

    //sp21
    private static final String FINGER_PRINT_BUTTON =".//button[span[text()='%s']]";
    public boolean VerifyFingerPrintButton(String button) {
        waitAbit(200);
        scrollToElement(format(FINGER_PRINT_BUTTON,button));
        waitAbit(500);
        return findBy(format(FINGER_PRINT_BUTTON,button)).isDisplayed();
    }
    //sp22
    private static final String EXPAND_INDIVIDUAL_PROVIDERS = "(.//div/i[contains(@class,'material-icons')]|//div/h3[text()='%s']/../..)[1]";
    public void clickIndividualProviders(String individualproviders){
        scrollToElement(EXPAND_INDIVIDUAL_PROVIDERS);
        findBy(EXPAND_INDIVIDUAL_PROVIDERS).click();
        waitAbit(1000);
    }
    private static final String EXPAND_GROUP_PROVIDERS = "(.//div/i[contains(@class,'material-icons')]|//div/h3[text()='%s']/../..)[2]";
    public void clickGroupProviders(String groupproviders){
        scrollToElement(String.format(EXPAND_GROUP_PROVIDERS,groupproviders));
        findBy(EXPAND_GROUP_PROVIDERS).click();
        waitAbit(1000);
    }

    private static final String EXPAND_PHARMACY_PROVIDERS = "(.//div/i[contains(@class,'material-icons')]|//div/h3[text()='%s']/../..)[4]";
    public void clickPharmacyProviders(String pharmacyproviders){
        scrollToElement(EXPAND_PHARMACY_PROVIDERS);
        findBy(EXPAND_PHARMACY_PROVIDERS).click();
        waitAbit(1000);
    }
    //sp26
    private static final String EXPAND_PROVIDER_ENROLLMENT_MANAGER = "(.//div/i[contains(@class,'material-icons')]|//div/h3[text()='%s']/../..)[5]";
    public void clickProviderEnrollmentManger(String providerenrollmentmanger){
        String locator = String.format(EXPAND_PROVIDER_ENROLLMENT_MANAGER, providerenrollmentmanger);
        scrollToElement(locator);
//        findBy(locator).click();
        jsClick(locator);
    }
    private static final String EXPAND_MANAGED_CARE_ORGANISATION = "(.//div/i[contains(@class,'material-icons')]|//div/h3[text()='%s']/../..)[8]";
    public void clickManagedCareOrganisation(String mco){
        scrollToElement(EXPAND_MANAGED_CARE_ORGANISATION);
        findBy(EXPAND_MANAGED_CARE_ORGANISATION).click();
        waitAbit(1000);
    }
   //sp28
    private static final String EXPAND_ORDERING_REFERRING_PROVIDER = "(.//div/i[contains(@class,'material-icons')]|//div/h3[text()='%s']/../..)[6]";
    public void clickOrderingReferringProvider(String orderingreferringprovider){
        scrollToElement(EXPAND_ORDERING_REFERRING_PROVIDER);
        findBy(EXPAND_ORDERING_REFERRING_PROVIDER).click();
        waitAbit(1000);
    }

    //private static final String EXPAND_FACILITY_PROVIDER = "(.//div/i[contains(@class,'material-icons')]|//div/h3[text()='%s']/../..)[7]";
    //sp39.2
    private static final String EXPAND_FACILITY_PROVIDER = "(.//div/i[contains(@class,'material-icons')]|//div/h3[text()='%s']/../..)[3]";
    public void clickFacilityProvider(String facilityprovider){
        scrollToElement(EXPAND_FACILITY_PROVIDER);
        findBy(EXPAND_FACILITY_PROVIDER).click();
        waitAbit(1000);
    }
    //sp32
    private final static String EFFECTIVE_START_DATE = ".//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input";
    public void setEffectiveStartDate(String effectiveStartDate) {
        scrollToElement(EFFECTIVE_START_DATE);
        jsClick(EFFECTIVE_START_DATE);
        findBy(format(EFFECTIVE_START_DATE,effectiveStartDate)).sendKeys(effectiveStartDate);
    }
    private static final String EFFECTIVE_END_DATE = ".//label[text()='Effective end ']//ancestor::div[contains(@class, 'effectivedatepicker')]//input";

    public void fillEffectiveDates(String dateStart,String dateEnd){
        scrollToElement(EFFECTIVE_START_DATE);
        jsClick(EFFECTIVE_START_DATE);
        findBy(format(EFFECTIVE_START_DATE,dateStart)).sendKeys(dateStart);
        waitAbit(1000);
        scrollToElement(EFFECTIVE_END_DATE);
        jsClick(EFFECTIVE_END_DATE);
        findBy(format(EFFECTIVE_END_DATE,dateEnd)).sendKeys(dateEnd);
    }

    //sp33

    private static final String END_DATE = ".//label[contains(text(),'Effective end date')]//ancestor::div[contains(@class, 'datepicker')]//input";
    private static final String START_DATE = ".//label[contains(text(),'Effective start date')]//ancestor::div[contains(@class, 'datepicker')]//input" ;
    public void fillEffectiveDatesAff(String dateEnd){
        waitAbit(500);
        scrollToElement(END_DATE);
        jsClick(END_DATE);
        findBy(END_DATE).clear();
        findBy(format(END_DATE,dateEnd)).sendKeys(dateEnd);
        findBy(END_DATE).click();
        //findBy(START_DATE).click();
        waitAbit(1000);
    }

    //sp35
    private static final String FINGER_PRINT_OK_BUTTON = ".//button/span[contains(text(),'Ok')]";
    public void clickOnOkButtonForFingerPrint() {
        waitAbit(500);
        jsClick(FINGER_PRINT_OK_BUTTON);

    }

    //sp37
    public void fillEffectiveDatesAff1(String dateStart,String dateEnd){
        waitAbit(500);
        scrollToElement(START_DATE);
        jsClick(START_DATE);
        findBy(START_DATE).clear();
        findBy(format(START_DATE,dateStart)).sendKeys(dateStart);
        findBy(START_DATE).click();
        waitAbit(100);
        scrollToElement(END_DATE);
        jsClick(END_DATE);
        findBy(END_DATE).clear();
        findBy(format(END_DATE,dateEnd)).sendKeys(dateEnd);
        findBy(END_DATE).click();
        waitAbit(100);
    }

    //sp37
    private static final String PLUS_ENROLLMENT_BUTTON = ".//button/span[contains(text(),'Enroll Provider')]";
    public void clickOnPlusEnrollmentProviderButton(){
        waitAbit(100);
        scrollToElement(PLUS_ENROLLMENT_BUTTON);
        waitAbit(100);
        jsClick(PLUS_ENROLLMENT_BUTTON);
        waitAbit(100);
    }

    //sp41.4
    private static final String RE_ENROLLMENT_BUTTON = ".//button/span[contains(text(),'RE-ENROLLMENT APPLICATION')]";
    public void clickOnReEnrollmentButton(){
        waitAbit(100);
        scrollToElement(RE_ENROLLMENT_BUTTON);
        waitAbit(100);
        jsClick(RE_ENROLLMENT_BUTTON);
        waitAbit(100);
    }

    //sp68

    private static final String EXPAND_TRADING_PROVIDER = "(.//div/i[contains(@class,'material-icons')]|//div/h3[text()='%s']/../..)[7]";
    public void clickTradingPartnerProvider(String tradingpartneryprovider){
        scrollToElement(String.format(EXPAND_TRADING_PROVIDER,tradingpartneryprovider));
        findBy(String.format(EXPAND_TRADING_PROVIDER,tradingpartneryprovider)).click();
        waitAbit(1000);
    }

    //SD 04

    private static final String SWITCHER1 = "//h3[contains(text(),'%s')]/../..//input";
    private static final String ENABLE_NEW = "//h3[contains(text(),'%s')]/../..//input";

    public void turnOnNew() {
        if(!findBy(SWITCHER1).getCssValue("color").contentEquals(SWITCHER_ON_COLOR)){
            scrollToElement(ENABLE_NEW);
            findBy(ENABLE_NEW).click();
        }
    }

    private static final String AUTO_APPROVE_SWITCH = "//input[@aria-label='Auto Switch']";
    private static final String SWITCH1 = "(//div[@role='slider']/div/button)[1]";
    private static final String SWITCH2 = "(//div[@role='slider']/div/button)[2]";
    public void setAutoApproveSlider(){
        if(findBy(AUTO_APPROVE_SWITCH).isSelected()){
            System.out.println("Already switch enabled!!!");
        }
        else {
            scrollToElement(AUTO_APPROVE_SWITCH);
            waitAbit(500);
            findBy(AUTO_APPROVE_SWITCH).click();
        }

       try{
           Actions actions = new Actions(getDriver());
           waitAbit(2000);
           actions.dragAndDropBy(findBy(SWITCH1), 100, 100).build().perform();
           waitAbit(2000);
           actions.dragAndDropBy(findBy(SWITCH2), -100, -100).build().perform();

       }catch (Exception e) {
           System.out.println("***************** Can't handle Sliders!!! *****************");
           e.printStackTrace();
       }
        waitAbit(2000);
        scrollToElement(AUTO_APPROVE_SWITCH);
        waitAbit(2000);
        findBy(AUTO_APPROVE_SWITCH).click();
        waitAbit(2000);
    }

    public void turnOffNew() {
        scrollToElement(ENABLE_NEW);
        waitAbit(1000);
        if(!findBy(SWITCHER1).getCssValue("color").contentEquals(SWITCHER_OFF_COLOR)){
            findBy(ENABLE_NEW).click();
        }
    }

    //SD-08

    private static final String ENROLLMENT_REQUEST = ".//div[contains(@class,'main-info-panel_item')]//span[contains(text(),'%s')]/../../div";
    public String verifyEnrollmentRequestData(String field){
        return findBy(format(ENROLLMENT_REQUEST, field)).getText();
    }

    private static final String PROVIDER_SUBMITTED_COC_DETAILS = ".//div[contains(@class,'main-info-panel_content')]/div//*[contains(text(),'%s')]/../../div";
    public String verifyCocRequestDataInProviderCocTab(String field){
        return findBy(format(PROVIDER_SUBMITTED_COC_DETAILS, field)).getText();
    }

    private static final String SUBMITTED_COC_PROVIDER_NAME = ".//div[contains(@class,'main-info-panel_content')]/div//p[contains(text(),'Provider Name')]/following::p";
    public String verifyCocProviderNameInProviderCocTab(String field){
        return findBy(format(SUBMITTED_COC_PROVIDER_NAME, field)).getText();
    }

    private static final String SUBMITTED_PROVIDER_MODULE_DETAILS = ".//div[contains(@class,'detailed-panel sc-hmzhuo kYmeqA')]/div/div//h2[contains(text(),'%s')]/../p";
    public String verifyProviderModuleDataInternalUserTab(String field){
        return findBy(format(SUBMITTED_PROVIDER_MODULE_DETAILS, field)).getText();
    }

    //SD-10

    private static final String COC_CONFIGURATION = ".//div/h3[contains(text(),'%s')]/../../..//span/input[@type='checkbox']";
    public void enableCocConfiguration(String button){
        waitAbit(500);
        scrollToElement(format(COC_CONFIGURATION, button));
        waitAbit(500);
        findBy(format(COC_CONFIGURATION, button)).click();
        waitAbit(500);
    }

    public boolean verifyCocConfiguration(String button){
        return findBy(format(COC_CONFIGURATION, button)).isSelected();
    }

    //SD-11

    private static final String SUBMITTED_PROVIDER_DATA_DETAILS = "//div[contains(@class,'main-info-panel_content')]/div[contains(@class,'main-info-panel_item')]//span[text()='%s']/../..//div";
    public String verifyProviderModuleDataProviderTab(String field){
        return findBy(format(SUBMITTED_PROVIDER_DATA_DETAILS, field)).getText();
    }

    private static final String ADDLINE_BUTTON = "//button[span[text() = '+ Add Line']]";
    public void clickAddLine(){
        waitAbit(1000);
        findBy(ADDLINE_BUTTON).click();
    }

    private static final String TRANSACTION_TYPE = "//input[contains(@id, 'Transaction type')]/../div";
    public void setTransactionType(String transactionType){
        waitAbit(500);
        findBy(TRANSACTION_TYPE).click();
        waitAbit(1000);
        selectFromDropDown(transactionType);
    }

    private static final String TRANSACTION_VALUE = "//input[contains(@id, 'Value')]/../div";
    public void setTransactionValue(String transactionValue){
        waitAbit(500);
        findBy(TRANSACTION_VALUE).click();
        waitAbit(1000);
        selectFromDropDown(transactionValue);
    }

    private static final String REENROLLMENT_CONFIGURATION = ".//div/h3[contains(text(),'%s')]/../../..//span/input[@type='checkbox']";
    public void enableReEnrollmentConfiguration(String button){
        waitAbit(500);
        scrollToElement(format(REENROLLMENT_CONFIGURATION, button));
        waitAbit(500);
        findBy(format(REENROLLMENT_CONFIGURATION, button)).click();
        waitAbit(500);
    }

    public boolean verifyReEnrollmentConfiguration(String button){
        return findBy(format(REENROLLMENT_CONFIGURATION, button)).isSelected();
    }

    private static final String DOWNLOAD_EXCEL = "//button[@title='Download as Excel']" ;
    public boolean verifyDownloadExcelButton(){
        return isElementPresent(DOWNLOAD_EXCEL);
    }


    private static final String SITEVISIT_SIGN_IU  = "(//div[contains(@class, 'sitevisitsign')]//input[@type='checkbox'])[1]";
    private static final String SITEVISIT_SIGN_PE = "(//div[contains(@class, 'sitevisitsign')]//input[@type='checkbox'])[2]";
    public void clickSitevisitSignIU() {
        scrollToElement(SITEVISIT_SIGN_IU);
        waitAbit(500);
        findBy(SITEVISIT_SIGN_IU).click();
    }

    public void clickSitevisitSignPE() {
        scrollToElement(SITEVISIT_SIGN_PE);
        waitAbit(500);
        findBy(SITEVISIT_SIGN_PE).click();
    }

    private static final String CHECKBOX_AUTO = "//div[p[text()='%s']]/..//input[@type='checkbox']";
    public boolean isAutoCheckboxEnabled(String description){
        return findBy(format(CHECKBOX_AUTO, description)).isSelected();
    }

    public void clickAutoCheckbox(String description){
        waitAbit(500);
        scrollToElement(format(CHECKBOX_AUTO, description));
        waitAbit(500);
        findBy(format(CHECKBOX_AUTO, description)).click();
    }

    public void turnOnAutoApprove() {
        if(!findBy(AUTO_APPROVE_SWITCH).isSelected()) {
            scrollToElement(AUTO_APPROVE_SWITCH);
            waitAbit(500);
            findBy(AUTO_APPROVE_SWITCH).click();
        } else {
            System.out.println("Auto Approve already turned on!!!");
        }
    }

    public void turnOffAutoApprove() {
        if(findBy(AUTO_APPROVE_SWITCH).isSelected()) {
            scrollToElement(AUTO_APPROVE_SWITCH);
            waitAbit(500);
            findBy(AUTO_APPROVE_SWITCH).click();
        } else {
            System.out.println("Auto Approve already turned off!!!");
        }
    }

    private static final String AUTO_APPROVE_SWITCH_TPPEM = "//div/p[text()='Request is automatically approved after appearing on IU portal']/../..//input";
    public void turnOnAutoApproveTpPem() {
        if(!findBy(AUTO_APPROVE_SWITCH_TPPEM).isSelected()) {
            scrollToElement(AUTO_APPROVE_SWITCH_TPPEM);
            waitAbit(500);
            findBy(AUTO_APPROVE_SWITCH_TPPEM).click();
        } else {
            System.out.println("Auto Approve already turned on!!!");
        }
    }
    public void turnOffAutoApproveTpPem() {
        if(findBy(AUTO_APPROVE_SWITCH_TPPEM).isSelected()) {
            scrollToElement(AUTO_APPROVE_SWITCH_TPPEM);
            waitAbit(500);
            findBy(AUTO_APPROVE_SWITCH_TPPEM).click();
        } else {
            System.out.println("Auto Approve already turned off!!!");
        }
    }

    private static final String ASSIGNEE_CONFIGURATION = "//h3[contains(text(),'Assignee Configuration')]//following::input[1]";
    public void turnOnAssigneeConfiguration() {
        if(!findBy(ASSIGNEE_CONFIGURATION).isSelected()) {
            scrollToElement(ASSIGNEE_CONFIGURATION);
            waitAbit(500);
            findBy(ASSIGNEE_CONFIGURATION).click();
        } else {
            System.out.println("Assignee Configuration already turned on!!!");
        }
    }
    public void turnOffAssigneeConfiguration() {
        if(findBy(ASSIGNEE_CONFIGURATION).isSelected()) {
            scrollToElement(ASSIGNEE_CONFIGURATION);
            waitAbit(500);
            findBy(ASSIGNEE_CONFIGURATION).click();
        } else {
            System.out.println("Assignee Configuration already turned off!!!");
        }
    }

    private static final String COC_SCREENING_APPROVAL = "//p[text()='Request is automatically approved if the COC screening score is greater than latest screening score']/../..//input";
    public void turnOnCocScreening() {
        if (!findBy(COC_SCREENING_APPROVAL).isSelected()) {
            scrollToElement(COC_SCREENING_APPROVAL);
            waitAbit(500);
            findBy(COC_SCREENING_APPROVAL).click();
        } else {
            System.out.println("Coc Screening Configuration already turned on!!!");
        }
    }


    private static final String INSTATE_RADIOBUTTON = "//input[@value='inState']";
    private static final String OUTSTATE_RADIOBUTTON = "//input[@value='outState']";
    private static final String BOTH_STATE_RADIOBUTTON = "//input[@value='both']";

    public boolean isInstateEnabled() {
        return findBy(INSTATE_RADIOBUTTON).isEnabled();
    }

    public boolean isOutstateEnabled() {
        return findBy(OUTSTATE_RADIOBUTTON).isEnabled();
    }

    public boolean isBothEnabled() {
        return findBy(BOTH_STATE_RADIOBUTTON).isEnabled();
    }

    public void enableInstate() {
        if(!isInstateEnabled()) {
            waitAbit(500);
            scrollToElement(INSTATE_RADIOBUTTON);
            waitAbit(500);
            findBy(INSTATE_RADIOBUTTON).click();
            waitAbit(500);
        }
    }



    public void enableOutstate() {
        if(!isOutstateEnabled()) {
            waitAbit(500);
            scrollToElement(OUTSTATE_RADIOBUTTON);
            waitAbit(500);
            findBy(OUTSTATE_RADIOBUTTON).click();
            waitAbit(500);
        }
    }

    public void enableBothstate() {
        if(!isBothEnabled()) {
            waitAbit(500);
            scrollToElement(BOTH_STATE_RADIOBUTTON);
            waitAbit(500);
            findBy(BOTH_STATE_RADIOBUTTON).click();
            waitAbit(500);
        }
    }
    private static final String VERIFY_PAYMENT="//span[text()='Verify Payment']";
    private static final String VERIFY_PAYMENT_OPTION="//p[text()='Is Payment received?']/..//div//label[3]//span//span//input[@value='na']";
    private static final String VERIFY_PAYMENT_NOTE="//label[text()='Notes']/..//div//textarea[1]";
    private static final String VERIFY="//div//button[@type='button']//span[text()='Verify']";
    public void clickOnVerifyPayment(){
        waitAbit(500);
        findBy(VERIFY_PAYMENT).click();
        waitAbit(2000);
    }

    public void toggleCocConfiguration(String button, boolean enable) {
        WebElement element = findBy(format(COC_CONFIGURATION, button));
        if (element.isSelected() != enable) {
            scrollToElement(String.format(COC_CONFIGURATION, button));
            element.click(); // Toggle the switch
        }
    }

}




