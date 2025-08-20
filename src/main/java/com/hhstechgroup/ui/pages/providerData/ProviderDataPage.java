
package com.hhstechgroup.ui.pages.providerData;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.enrollment.LeftMenuPanel;
import com.hhstechgroup.ui.panels.iuportal.ProviderDataSearchResultsPanel;
import com.hhstechgroup.ui.panels.peportal.MainInfoBlock;
import com.hhstechgroup.ui.panels.peportal.Table;
import com.hhstechgroup.ui.panels.providerData.ProviderDataHistoryPanel;
import com.hhstechgroup.ui.panels.providerData.ProviderDataRevalidationPanel;
import com.hhstechgroup.ui.panels.providerData.ProviderTimelinePanel;
import com.hhstechgroup.util.properties.ProviderProperties;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Keys;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class ProviderDataPage extends ProviderManagementBasePage {

    private static final String PROVIDER_ENROLLMENT_BLOCK = "//div[contains(@class, 'main-info-panel_card_')]";
    private static final String PROVIDER_ENROLLMENT_BLOCK_IU_PORTAL = "//div[contains(@class, 'detailed-panel')]";
    private static final String PROVIDER_DATA_NAME_ENROLLMENT_BLOCK = "//div[contains(@class, 'main-info-panel_card_')]//span[contains(text(), '%s')]";
    private static final String PROVIDER_DATA_NAME_STATUS_IU = "//div[contains(@class, 'detailed-panel-head')]/h1[text()='%s']/following-sibling::div//span[text()='%s']";
    private static final String LEFT_PANEL = ".//div[contains(@class, 'root')]//div[contains(@class, 'menu_side-bar')]";
    private static final String PROVIDER_DATA_TAB = ".//button//span[contains(text(), '%s')]/..";
    private static final String CONNECTED_REQUESTS = "//h4[node() = '%s']/parent::div";
    private static final String REQUESTS_COLUMNS = ".//div[contains(@class, '_header_')]//span[normalize-space(text())]/parent::div";
    private static final String REQUESTS_ROWS = ".//div[contains(@class, 'summary_data')]";
    private static final String REQUESTS_CELLS = ".//div/div/span[normalize-space(node())]";
    private static final String PROVIDER_DATA_HISTORY = ".//h3[contains(@class, 'requests_pd-title')]/..";
    private static final String PROVIDER_TIMELINE = ".//div[contains(@class, 'timeline_timeline')]";
    private static final String PROVIDER_DATA_REVALIDATION = ".//div[contains(@class, 'revalidation_revalidation_')]";
    private static final String REACTIVATION_BUTTON = ".//button[span[text()='Reactivate']]";
//latest
    private static final String DATACHANGE_NOTIFICATION   =".//div[contains(@class,'styles_data-changes-notification_')]/p[text()='%s']";
    public boolean isPEDataChangeNotificationdisplaying(String penotification) {
        return  findBy(format(DATACHANGE_NOTIFICATION ,penotification)).isDisplayed();
    }

    //latest
     private static final String BACK_TO_TPPORTAL_BUTTON=".//a[contains(text(),'Back To TP Portal')]/parent::span";
     public void clickOnBackToTPPortalButton () {
        // waitAbit(3000);
         jsClick(BACK_TO_TPPORTAL_BUTTON);
         //findBy(BACK_TO_TPPORTAL_BUTTON).click();
    }

    //latest
    private static final String DUPLICATE_NPI_MASSAGE=".//div[contains(@class,'details_notification')]/p[text()='%s']";
    public boolean isDulpicateNPIMessagedisplaying(String npi) {
        return  findBy(format(DUPLICATE_NPI_MASSAGE,npi)).isDisplayed();
    }

    private static final String NOTIFICATIONS= ".//div[contains(@class,'_notification')]/p[contains(text(),'%s')]";
    public boolean isDataChangeNotificationdisplaying(String notification) {
        //sp41.3
        scrollToElement(format(NOTIFICATIONS,notification));
        return  findBy(format(NOTIFICATIONS,notification)).isDisplayed();
    }

    public ProviderDataPage(WebDriver driver) {
        super(driver);
    }

    public MainInfoBlock getProviderInformation() {
        return new MainInfoBlock(findBy(PROVIDER_ENROLLMENT_BLOCK), this);
    }
    public MainInfoBlock getProviderInformationOnIuPortal() {
        return new MainInfoBlock(findBy(PROVIDER_ENROLLMENT_BLOCK_IU_PORTAL), this);
    }

    public boolean checkProviderNameOnProviderDetails(String providerName) {
       return isElementPresent(String.format(PROVIDER_DATA_NAME_ENROLLMENT_BLOCK, providerName));
    }

    public boolean checkProviderNameStatusOnProviderDetailsIU(String providerName, String providerStatus) {
        return isElementPresent(String.format(PROVIDER_DATA_NAME_STATUS_IU, providerName, providerStatus));
    }
//latest
    public void clickTabWithName(String tabName) {
        waitForSpinnerToDisappear();
        // findBy(String.format(PROVIDER_DATA_TAB, tabName)).click();
        jsClick(format(PROVIDER_DATA_TAB,tabName));
        waitAbit(4000);
       // waitForSpinnerToDisappear();
    }
    public LeftMenuPanel getLeftMenuPanel() {
        return new LeftMenuPanel(findBy(LEFT_PANEL), this);
    }

    public List<Map<String, String>> getSummaryRequests(String type) {
        String connectedRequestsXPath = format(CONNECTED_REQUESTS, type);
        waitAbit(2000);
        waitForPresenceOf(connectedRequestsXPath);
        return new Table(findBy(connectedRequestsXPath), this, REQUESTS_COLUMNS, REQUESTS_ROWS, REQUESTS_CELLS).getListOfMappedValues();
    }

    public ProviderDataHistoryPanel getProviderDataHistoryPanel() {
        return new ProviderDataHistoryPanel(findBy(PROVIDER_DATA_HISTORY), this);
    }

    public ProviderDataRevalidationPanel getRevalidationPanel() {
        return new ProviderDataRevalidationPanel(findBy(PROVIDER_DATA_REVALIDATION), this);
    }
    public ProviderTimelinePanel getproviderTimelinePanel() {
        return new ProviderTimelinePanel(findBy(PROVIDER_TIMELINE), this);
    }

    public void clickOnReactivationButton () {
        findBy(REACTIVATION_BUTTON).click();
    }

    public boolean isReactivateAbsent() {
        return isElementPresent(REACTIVATION_BUTTON);
    }

    //new
    private static final String RESULTS_PANEL = ".//div[contains(@class,'root_content')]";
    public ProviderDataSearchResultsPanel getProviderResultsPanel() {
        waitAbit(500);
        return new ProviderDataSearchResultsPanel(findBy(RESULTS_PANEL), this);
    }

    //new
    private static final String STATUS = ".//span[contains(.,'%s')]";
    public boolean checkStatus(String status) {
        scrollToElement(format(STATUS,status));
        return isElementPresent(String.format(STATUS,status));
    }
    private static final String PROVIDER_STATUS="//div[contains(text(),'%s')]";
    public boolean checkProviderStatus(String providerStatus){
        return isElementPresent(String.format(PROVIDER_STATUS,providerStatus));
    }
    private static final  String SECTION_NAME="//span[text()='%s']";
    public boolean checkSectionName(String sectionName){
        scrollToElement(format(SECTION_NAME,sectionName));
        return isElementPresent(String.format(SECTION_NAME,sectionName));
    }
    private static final String SITE_VISIT_FAQ_ANS="//p[contains(text(),'%s')]";
    private static final String SITE_VISIT_QUE="//p[text()='Why are sites visits performed?']/..//div";
    public boolean verifySiteVisitFaqAnswer(String answer) {
        findBy(SITE_VISIT_QUE).click();
        waitAbit(200);
        scrollToElement(format(SITE_VISIT_FAQ_ANS, answer));
        return isElementPresent(format(SITE_VISIT_FAQ_ANS,answer));

    }

    private static final String SCREENING_DOC="//a[text()=' %s']";
    public void checkScreeningDocument(String screeningDoc){
//      scrollToElement(format(SCREENING_DOC,screeningDoc));
//      return isElementPresent(String.format(SCREENING_DOC,screeningDoc));
      try{
          findBy(String.format(SCREENING_DOC,screeningDoc)).isDisplayed();
          System.out.println("Screening Document is displaying");
      }
      catch (Exception e){
          System.err.println("====SCREENING DOCUMENT IS NOT DISPLAYING===");
      }
    }

    private static final String COC_BUTTON="//span[text()='%s']";
    public boolean checkCOCButton(String cocButton){
        scrollToElement(format(COC_BUTTON,cocButton));
        return isElementPresent(String.format(COC_BUTTON,cocButton));

    }

    //new
    private static final String TPSTATUS = ".//h2[contains(text(),'%s')]";
    public boolean checkTpStatus(String status) {
        scrollToElement(format(TPSTATUS,status));
        return isElementPresent(String.format(TPSTATUS,status));
    }

    private static final String EDIT = ".//h4[text() = '%s']";
    private static final String EDIT_ICON = ".//h4[text() = '%s']/following-sibling::div/span[contains(@class, 'field_icon')]";
    private static final String FEILD =  ".//input[contains(@id,'%s')]" ;
    public void editField(String fieldName, String changedata) {
        String element = format(EDIT, fieldName);
        String elementOnHover = format(EDIT_ICON,fieldName);
        scrollToElement(element);
        action().moveToElement(findBy(element)).moveToElement(findBy(elementOnHover)).click().build().perform();
        waitAbit(100);
        findBy(format(FEILD,fieldName)).clear();
        waitAbit(100);
        findBy(format(FEILD,fieldName)).type(changedata);
        waitAbit(500);
        action().sendKeys(Keys.TAB).build().perform();
        waitABit(1000);
    }

    // sp30 pem status

    private static final String PEM_STATUS = ".//h2[contains(text(),'%s')]";
    public boolean checkPemStatus(String status) {
        scrollToElement(format(PEM_STATUS,status));
        return isElementPresent(String.format(PEM_STATUS,status));
    }

    private static final String REENROLLMENT_BUTTON = ".//button/span[text()='RE-ENROLLMENT APPLICATION']";
    public boolean isReEnrollmentButtonPresents(){
        return isElementPresent(REENROLLMENT_BUTTON);
    }

    private static final String SCREENING_PARAMETERS = "//div/ul[contains(@class, 'details_list')]/li";
    public List<String> getScreeningParameters() {
        scrollToElement(SCREENING_PARAMETERS);
        waitAbit(1000);
        return findAll(SCREENING_PARAMETERS).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    private static final String POPUP_MESSAGE = ".//div[@role='document']/div/h2[text()]";
    private static final String POPUP_OK_BUTTON = ".//div[@role='document']//button[span[text()='OK']]";
    public void clickPopupOk(){
        waitAbit(500);
        System.out.println("Popup Text: " + findBy(POPUP_MESSAGE).getText());
        findBy(POPUP_OK_BUTTON).click();
        waitAbit(500);
    }

    private static final String EDIT_ICON_NEW = "//div[div[h2[text() = '%s']]]//div/span[contains(@class, 'field_icon') and not(@aria-hidden='true')]";
    private static final String PAYMENT_QUESTION = "//div/h2[text()='Will you receive payment directly from Medicaid that will be reported to the IRS under your SSN?']";
    public void clickEditField(String header){
        scrollToElement(format(EDIT_ICON_NEW, header));
        waitAbit(1000);
        jsClick(PAYMENT_QUESTION);
        waitAbit(2000);
        jsClick(format(EDIT_ICON_NEW, header));
        waitAbit(500);
    }

    private static final String EDIT_DEATHDATE = "//div[h2[text()='Death Date']]//span";
    public void clickEditDeathDate(){
        waitAbit(500);
        action().moveToElement(findBy(EDIT_DEATHDATE)).click().build().perform();
        waitAbit(500);
    }

    private static final String DEATH_DATE = "//div/label[normalize-space()='Death date *']/..//input";
    public void setDeathDate(String deathDate) {
        waitAbit(500);
        findBy(DEATH_DATE).type(deathDate);
        waitAbit(500);
    }

    private static final String REASON_CODE = "//label[@id='Reason Code']/../div";
    private static final String DROPDOWN_OPTIONS = "//ul/li[node()='%s']";
    public void setReasonCode(String reasonCode) {
        waitAbit(500);
        findBy(REASON_CODE).click();
        waitAbit(500);
        findBy(format(DROPDOWN_OPTIONS, reasonCode)).click();
    }

    private static final String UPDATE_BUTTON = "//button[span[normalize-space()='Update']]";
    public void clickUpdate(){
        waitAbit(500);
        findBy(UPDATE_BUTTON).click();
    }

    private static final String EDIT_AGENTID = "//div[h2[normalize-space()='Trading Partner Agent ID']]//span";
    public void clickEditAgentId(){
        waitAbit(500);
        action().moveToElement(findBy(EDIT_AGENTID)).click().build().perform();
        waitAbit(500);
    }

    private static final String TRADING_PARTNER_AGENTID = "//div[label[text()='Trading Partner Agent ID']]//textarea[3]";
    public void setTradingPartnerAgentid(String tradingPartnerAgentid) {
        waitAbit(500);
        findBy(TRADING_PARTNER_AGENTID).type(tradingPartnerAgentid);
        waitAbit(500);
    }

    private static final String MONITORING_TABS = "//button[contains(@class, 'monitoring_tab')]//span[text()]";
    private static final String MONITORING_COLUMNS = "//span[@class='sortable']";
    private static final String MONITORING_TAB = "//button[contains(@class, 'monitoring_tab')]//span[text()='%s']";
    public List<String> getMonitoringTabParameters() {
        return findAll(MONITORING_TABS).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    public void clickMonitoringTab(String tab){
        scrollToElement(format(MONITORING_TAB, tab));
        waitAbit(500);
        findBy(format(MONITORING_TAB, tab)).click();
        waitAbit(500);
    }

    public List<String> getMonitoringColoumns() {
        return findAll(MONITORING_COLUMNS).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }


    private static final String SITEVISIT_DATA = "//p[text()='%s']/../../div/div";
    public String getSitevisitData(String text) {
        return findBy(format(SITEVISIT_DATA,text)).getText();
    }

    private static final String RECONSIDERATION_TYPE="//label[text()='Reconsideration Type']/..//div//div";
    private static final String SELECT_RECONSIDERATION_TYPE="//div//ul[@role='listbox']//li[text()='%s']";
    private static final String SEARCH_RESULT = ".//button/span[contains(text(),'Search')]" ;
    public void clickReconsiderationTypeAndSelectTypeAndSearch(String reconsiderationType){
        waitAbit(100);
        findBy(RECONSIDERATION_TYPE).click();
        waitAbit(300);
        findBy(format(SELECT_RECONSIDERATION_TYPE,reconsiderationType)).click();
        waitAbit(200);
        findBy(SEARCH_RESULT).click();
        waitAbit(200);

    }
    private static final String REQUEST_ID = "//input[contains(@id,'RequestID')]";

    public void searchWithTrackingNum(){
        String trackingNum =  ProviderProperties.getData("trackingNum") ;
        findBy(REQUEST_ID).type(trackingNum);
    }

    private static final String PROVIDER_NAME_AND_ID = ".//input[contains(@id, 'providerName')]";
    public void searchWithProviderIDInProviderTab(){
        String ProviderID =  ProviderProperties.getData("ProviderID") ;
        findBy(PROVIDER_NAME_AND_ID).type(ProviderID);


    }
    private static final String RECONSIDERATION_REQUEST_ID="//input[contains(@id,'RequestID')]";

    public void searchWithReconsiderationRequestID(){
        String reconsiderationRequestID=ProviderProperties.getData("reconsiderationRequestID");
        findBy(RECONSIDERATION_REQUEST_ID).type(reconsiderationRequestID);
    }
    private static final String COC_REQUEST_ID="//input[contains(@id,\"RequestID\")]";
    public void searchWithCOCIDToApprove(){
        String cocIDToApprove=ProviderProperties.getData("cocIDToApprove");
        findBy(COC_REQUEST_ID).type(cocIDToApprove);
    }
    public void searchWithCOCIDToDeny(){
        String cocRequestIDToDeny=ProviderProperties.getData("cocRequestIDToDeny");
        findBy(COC_REQUEST_ID).type(cocRequestIDToDeny);
    }

    public void searchWithReenrollmentRequestIDToApprove(){
        String reenrollmentRequestIDToApprove=ProviderProperties.getData("reenrollmentRequestIDToApprove");
        findBy(REQUEST_ID).type(reenrollmentRequestIDToApprove);
    }
    public void searchWithReenrollmentRequestIDToDeny(){
        String reenrollmentRequestIDToDeny=ProviderProperties.getData("reenrollmentRequestIDToDeny");
        findBy(REQUEST_ID).type(reenrollmentRequestIDToDeny);
    }

    public void searchWithRevalidationRequestID(){
        String revalidationRequestID=ProviderProperties.getData("revalidationRequestID");
        findBy(REQUEST_ID).type(revalidationRequestID);
    }

}
