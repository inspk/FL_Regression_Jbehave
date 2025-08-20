package com.hhstechgroup.ui.pages.peportal;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.coc.SelectCoCTypeModalWindow;
import com.hhstechgroup.ui.panels.enrollment.BaseCocSection;
import com.hhstechgroup.ui.panels.coc.SelectCategoryModalWindow;
import com.hhstechgroup.ui.panels.enrollment.LeftMenuPanel;
import com.hhstechgroup.ui.panels.pedashboard.SuccessPanel;
import com.hhstechgroup.ui.panels.peportal.MainInfoBlock;
import com.hhstechgroup.ui.panels.peportal.Table;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import static java.lang.String.format;

public class CocPage extends ProviderManagementBasePage {

    private static final String INDIVIDUAL_PROVIDER_ENROLLMENT = "//div[contains(@class, 'main-info-panel_card_')]";
    private static final String CHANGE_REQUEST_BUTTON = "(.//*[contains(text(), 'Change of Circumstance')])[3]";
    private static final String REVALIDATE_BUTTON = ".//h3/following-sibling::button[span[text() = 'Revalidate']]";
    private static final String LEFT_PANEL = ".//div[contains(@class, 'coc')]//div[contains(@class, 'menu_side-bar')]";
    private static final String SUCCESS_PANEL = ".//p[text() = 'Success!']/parent::div";
    private static final String REQUESTS_HISTORY = ".//div[starts-with(@class, 'tile-table ')]";
    private static final String REQUESTS_HISTORY_COLUMNS = ".//div[contains(@class, 'table-head')]//div[span]";
    private static final String REQUESTS_HISTORY_ROWS = ".//div[contains(@class, 'table-body')]//div[contains(@class, 'row')]";
    private static final String REQUESTS_HISTORY_CELLS = ".//div[contains(@class, 'column')]";
    private static final String SELECT_CATEGORY_WINDOW = ".//div[contains(@class, 'dialog-title')]/parent::div";
    private static final String REQUEST_VALUE = ".//div[contains(@class, 'tile-table-body')]//p[contains(text(), '%s')]";
    private static final String SECTION = ".//div[contains(@class, 'section-inner')]";
    private static final String CONTINUE_BUTTON = ".//span[text()= '%s']/parent::div/..//button[span[text() = 'Continue']]";
    private static final String SELECT_COC_TYPE_POPUP = ".//div[contains(@class, 'dialog-title')]/following-sibling::div";
    private static final String REQUEST_EXPAND_LINK = "//p[contains(text(), '%s')]/ancestor::div[contains(@class, 'expansion-panel-summary clickable')]/following-sibling::div//button[@aria-label='Expand More']";

    public CocPage(WebDriver driver) {
        super(driver);
    }

    public MainInfoBlock getProviderInformation() {
        return new MainInfoBlock(findBy(INDIVIDUAL_PROVIDER_ENROLLMENT), this);
    }

    public void clickChangeRequestButton() {
        waitForSpinnerToDisappear();
        waitFor(ExpectedConditions.elementToBeClickable(By.xpath(CHANGE_REQUEST_BUTTON)));
        waitForSpinnerToDisappear();
       // findBy(CHANGE_REQUEST_BUTTON).waitUntilEnabled().click();
        //latest
        jsClick(CHANGE_REQUEST_BUTTON);
    }

    public void clickRevalidateButton() {
        waitForSpinnerToDisappear();
        findBy(REVALIDATE_BUTTON).click();
    }

    public LeftMenuPanel getLeftMenuPanel() {
        return new LeftMenuPanel(findBy(LEFT_PANEL).waitUntilEnabled(), this);
    }

    public SuccessPanel getSuccessPanel() {
        return new SuccessPanel(findBy(SUCCESS_PANEL), this);
    }

    public List<Map<String, String>> getCocRequests() { waitAbit(3000);
        return new Table(findBy(REQUESTS_HISTORY), this, REQUESTS_HISTORY_COLUMNS, REQUESTS_HISTORY_ROWS, REQUESTS_HISTORY_CELLS).getListOfMappedValues();
    }

    public SelectCategoryModalWindow getSelectCategoryModalWindow() {
        return new SelectCategoryModalWindow(findBy(SELECT_CATEGORY_WINDOW), this);
    }

    public void clickOnRequestWithValue(String value) {
        findBy(format(REQUEST_VALUE, value)).click();
    }

    public BaseCocSection getSection() {
        waitAbit(1000);
        return new BaseCocSection(findBy(SECTION), this);
    }

    public void continueCoCWithId(String id){
        findBy(format(CONTINUE_BUTTON, id)).click();
    }

    public SelectCoCTypeModalWindow getSelectCoCTypeModalWindow() {
        return new SelectCoCTypeModalWindow(findBy(SELECT_COC_TYPE_POPUP), this);
    }

    public void clickOnExpandButtonForCocWithId(String id) {
        findBy(format(REQUEST_EXPAND_LINK, id)).click();
    }

    //sp22

    private static final String COC_POPUP   =".//div/div[contains(text(),'%s')]";
    public boolean isCocPopUp(String cocPopUp) {
        return  findBy(format(COC_POPUP ,cocPopUp)).isDisplayed();
    }

    public static final String BUTTON_OK ="//span[contains(text(),'OK')]";

    public void clickOKButton() {
        jsClick(BUTTON_OK); waitAbit(500);
    }

    //sp23
    private static final String COC_MENU_ICON   = ".//div[contains(@class, 'affiliation_provider-list-item')]//button  ";

    public void clickOnCocMenuIcon(){
        waitAbit(200);
        scrollToElement(COC_MENU_ICON);
        waitAbit(200);
        findBy(COC_MENU_ICON).click();
        waitAbit(200);
    }

    private static final String COC_END_BUTTON   = ".//button//span[contains(text(),'%s')]" ;
    public boolean isVerifyingEndButtonInCocDisplaying(String end){
        return findBy(format(COC_END_BUTTON,end)).isDisplayed();
    }

    public void clickOnCocEndButton(String cocend){
        waitAbit(300);
        findBy(format(COC_END_BUTTON,cocend)).click();
        waitAbit(100);
    }

    private static final String END_AFFILIATION   = ".//div[contains(@class,'affiliation_dialog-title')]//h2[contains(text(),'%s')]" ;
    public boolean isVerifyingCocEndAffiliationPopUpDisplaying(String endAffilation){
        return findBy(format(END_AFFILIATION,endAffilation)).isDisplayed();
    }

    private static final String REASON_FIELD = ".//input[contains(@id, 'Reason')]/preceding-sibling::div" ;
    private static final String  REASON = ".//ul/li[contains(text(),'%s')]" ;
    private static final String  NOTE = ".//label[contains(text(), 'Note')]/..//input[contains(@type,'text')]" ;
    private static final String  END = ".//button/span[text()='END']" ;

    public void selectReasonCodeForEndCoc(String reason,String note) {
        waitAbit(1000);
        jsClick(REASON_FIELD);
        scrollToElement(format(REASON,reason));
        waitAbit(1000);
        findBy(format(REASON, reason)).click();
        waitAbit(1000);
//        findBy(NOTE).click();
        findBy(NOTE).type(note);
        waitAbit(500);
        findBy(END).click();
        waitAbit(200);
    }

    //sp23

    private static final String BUTTON = ".//button/span[contains(text(),'%s')]";
    public boolean checkButton(String button) {
        scrollToElement(format(BUTTON,button));
        return isElementPresent(String.format(BUTTON,button));
    }


//sp33

    private static final String TYPE_FIELD = ".//input[contains(@id, 'Affiliation type')]/preceding-sibling::div";
    private static final String TYPE= ".//ul/li[contains(text(),'%s')]";

    public void selectType(String type) {
        waitAbit(1000);
       // jsClick(TYPE_FIELD);
        findBy(TYPE_FIELD).click();
        scrollToElement(format(TYPE,type));
        waitAbit(1000);
        findBy(format(TYPE, type)).click();
        waitAbit(1000);
    }

    private static final String COC_TYPES = "//fieldset/div/label/span[text()]";
    public List<String> getCocTypes() {
        return findAll(COC_TYPES).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    private static final String EXPAND_BUTTON = "//div[contains(text(), '%s')]/ancestor::div[contains(@class, 'affiliation_provider-list-item')]/div[not(text())]";
    private static final String ADD_SERVICELOCATON_BUTTON = "//div[normalize-space()='+ ADD']";
    private static final String EDIT_SERVICElOCATION_BUTTON = "//div[normalize-space()='EDIT']";
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

    private static final String ACCEPTING_NEW_PATIENTS = "//div[div[text()='Accepting new Patients?']]/div//label/span[text()='%s']";
    public void setAcceptingNewPatients(String acceptingNewPatients){
        scrollToElement(format(ACCEPTING_NEW_PATIENTS, acceptingNewPatients));
        waitABit(500);
        findBy(format(ACCEPTING_NEW_PATIENTS, acceptingNewPatients)).click();
        waitABit(500);
    }

    private static final String UPDATE_BUTTON = "//button[span[text()='Update']]";
    public void clickUpdateServiceLocation(){
        waitABit(500);
        findBy(UPDATE_BUTTON).click();
    }

    private static final String ADD_I_COC = "//button[span[normalize-space()='ADD I-COC']]";
    private static final String ADD_I_COC_DIALOG = "//div[@aria-label='responsive-dialog-title']";
    public void clickAddICoc() {
        waitABit(1000);
        scrollToElement(ADD_I_COC);
        waitABit(1000);
        findBy(ADD_I_COC).click();
    }
    public SelectCategoryModalWindow getAddICoC() {
        return new SelectCategoryModalWindow(findBy(ADD_I_COC_DIALOG), this);
    }

    private static final String PP_ICOC_MESSAGE = "//div[contains(@class, 'programParticipation_icoc-select')]/div";
    private static final String OK_BUTTON = "//div[@role='document']/div/button";
    public String getPpIcocMessage() {
        return findBy(PP_ICOC_MESSAGE).getText();
    }

    public void clickPopupOk(){
        waitABit(500);
        findBy(OK_BUTTON).click();
        waitABit(500);
    }
    private static final String ELLIPSIS="//div[contains(text(),'%s')]/..//div[7]//button//span//*[name()='svg']";
    private static final String COC_END_AFFILIATION="//button[@type='button']//span[contains(text(),'End')]";
    private static final String REASON_CODE="//div[contains(@id,'Reason Code')]";
    private static final String SELECT_REASON_CODE="//div//ul[contains(@aria-label,'Select an option')]//li[contains(text(),'%s')]";
    private static final String END_COC="//button[@type='button']//span[contains(text(),'END')]";
    public void endAffiliation(String affiliationType,String reason){
        waitAbit(200);
        findBy(format(ELLIPSIS,affiliationType)).click();
        waitAbit(300);
        findBy(COC_END_AFFILIATION).click();
        waitAbit(300);
        findBy(REASON_CODE).click();
        waitAbit(300);
        findBy(format(SELECT_REASON_CODE,reason)).click();
        waitAbit(300);
        findBy(END_COC).click();
        waitAbit(500);
    }

    private static final String TEXT_XPATH = "//div//p[contains(text(),'%s')]";
    private static final String YES = "//div//button[@type='button']//span[text()='%s']";

    public void verifyApprovedTaxonomyTextAndSelectOption(String expectedText, String option) {
        WebElement textElement = findBy(String.format(TEXT_XPATH, expectedText));

        if (textElement.isDisplayed()) {
            System.out.println("Verified text: " + expectedText);
            WebElement yes = findBy(String.format(YES, option));
            yes.click();
        } else {
            throw new AssertionError("Expected text '" + expectedText + "' not found.");
        }
    }

    private static final String PROVIDERNAME_AFFILIATIONTYPE="//div[contains(@class,'tile-table-row')]//p[contains(., '%s')]";
    public void verifyActiveAffiliationProviderNameAndType(String name,String affiliationType){
     WebElement providerName=findBy(String.format(PROVIDERNAME_AFFILIATIONTYPE,name));
     WebElement activeAffiliationType=findBy(String.format(PROVIDERNAME_AFFILIATIONTYPE,affiliationType));
     if (providerName.isDisplayed() && activeAffiliationType.isDisplayed()){
         System.out.println("Verified Providername: "+ name);
         System.out.println("Verified Affiliation Type: "+ affiliationType);
     }else {
         throw new AssertionError("Expected ProviderName '" + providerName + "' not found." + "\nExpected ProviderName '" + activeAffiliationType + "' not found.");

     }
    }
    private static final String SHOW_ENDED_AFFILAITIONS="//label//span[text()='%s']/..//input[@type='checkbox']";
    public void clickOnShowEndedAffiliation(String text){
        waitAbit(500);
        findBy(String.format(SHOW_ENDED_AFFILAITIONS,text)).click();
        waitAbit(2000);
    }
    private static final String VERIFY_STATUS = "(//p[contains(text(),'%s')])[1]";
    private static final String SEARCH_BUTTON = "(//button[contains(text(),'Search')])[2]";

    public boolean verifyStatusWithRetry(String expectedStatus, int timeoutInSeconds) {
        int retryInterval = 5;
        int maxRetries = timeoutInSeconds / retryInterval;

        for (int i = 0; i < maxRetries; i++) {
            if (isElementPresent(String.format(VERIFY_STATUS, expectedStatus))) {
                return true; // Status matched
            }
            findBy(SEARCH_BUTTON).click(); // Click Search to refresh status
            waitAbit(retryInterval);
        }
        return false; // Status not found within the time
    }



}