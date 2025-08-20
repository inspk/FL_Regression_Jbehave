package com.hhstechgroup.ui.pages.peportal;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.InformationalPopUp;
import com.hhstechgroup.ui.panels.chat.ChatFrame;
import com.hhstechgroup.ui.panels.inbox.MessagePanel;
import com.hhstechgroup.ui.panels.pedashboard.*;
import com.hhstechgroup.ui.panels.peportal.EnrollmentPackagePopUp;
import com.hhstechgroup.ui.panels.peportal.Table;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class DashboardPage extends ProviderManagementBasePage {

    private static final String HEADER = ".//div[contains(@class, 'header')]";
    private static final String MESSAGE_BODY = "//div//ul[@class='MuiList-root messages-table-body MuiList-padding']";
    private static final String BODY = ".//div[contains(@class, 'header')]/following-sibling::div[contains(@class, 'root_content')]";
    private static final String USER_POP_UP = ".//ul[@role='menu']";
    private static final String HELP_TOUR = "//div[contains(@class, 'helptour_user header_user')]//div";
    private static final String SUCCESS_PANEL = ".//p[text() = 'Success!']/parent::div";
    private static final String DONE_PANEL = ".//h1[contains(text(), 'Done')]/parent::div";
    private static final String CONGRATULATION_PANEL = ".//h1[contains(text(), 'Congratulations')]/parent::div";
    private static final String CHAT_IFRAME = "rocketchat-iframe";
    private static final String CHAT = ".//div[@class = 'livechat-room']";
    private static final String DELETE_APPLICATION_POP_UP = ".//div[h2[contains(text(), 'Delete')]]/parent::div";
    private static final String INFO_MESSAGE_POP_UP = ".//div[contains(@class, 'alert') and @role='document']";
    private static final String DOWNLOAD_ENROLLMENT_PACKAGE = ".//h2[contains(text(), 'package')]/ancestor::div[@role = 'document']";
    private static final String NOTIFICATION_BANNER = ".//div[contains(@class, '_notification_')]";
    private static final String SIGN = ".//button[span[text() = 'SIGN']]";
    private static final String AFFILIATION_DETAILS_PANEL = ".//div[starts-with(@class, 'tile-table ')]";
    private static final String COLUMNS = ".//div[contains(@class, 'tile-table-head')]/div[text()]";
    private static final String ROWS = ".//div[contains(@class, 'tile-table-row ')]";
    private static final String CELLS = ".//div[contains(@class, 'column') and node()]";
    private static final String CONTINUE_BUTTON = ".//span[text() = 'Continue']";

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public HeaderPanel getHeaderPanel() {
        return new HeaderPanel(findBy(HEADER), this);
    }

    public MessagePanel getMessageCenterpanel() {
        return new MessagePanel(findBy(MESSAGE_BODY), this);

    }

    public BodyPanel getBodyPanel() {
        return new BodyPanel(findBy(BODY), this);
    }

    public List<Map<String, String>> getAffiliationDetails() {
        return new Table(findBy(AFFILIATION_DETAILS_PANEL), this, COLUMNS, ROWS, CELLS).getListOfMappedValues();
    }

    public UserPopUp getUserPopUp() {
        return new UserPopUp(findBy(USER_POP_UP), this);
    }

    public void clickHelpTour() {
        jsClick(HELP_TOUR);
    }
    private static final String TAB_NAME=".//div[contains(@role,'tablist')]//button//span[text() = '%s']";
    public void clickTabOnProvidersTab(String tabName){
        waitAbit(500);
        findBy(format(TAB_NAME,tabName)).click();
        waitAbit(500);
    }

    public void clickOnHiddenTabInIU(String nameOfTheTab){
        WebElement hiddenTab = findBy(String.format(TAB_NAME,nameOfTheTab));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", hiddenTab);
        js.executeScript("arguments[0].click();", hiddenTab);
    }

    public SuccessPanel getSuccessPanel() {
        return new SuccessPanel(findBy(SUCCESS_PANEL), this);
    }

    public SuccessPanel getDonePanel() {
        return new SuccessPanel(findBy(DONE_PANEL), this);
    }

    public SuccessPanel getCongratPanel() {
        return new SuccessPanel(findBy(CONGRATULATION_PANEL), this);
    }

    public ChatFrame getChat() {
        getDriver().switchTo().frame(CHAT_IFRAME);
        return new ChatFrame(findBy(CHAT), this);
    }

    public DeleteApplicationPanel getDeleteApplicationPanel() {
        return new DeleteApplicationPanel(findBy(DELETE_APPLICATION_POP_UP), this);
    }

    public boolean isDeleteApplicationPopUpPresent() {
        return isElementPresent(DELETE_APPLICATION_POP_UP);
    }

    public InformationalPopUp getInformationalPopUp() {
        return new InformationalPopUp(findBy(INFO_MESSAGE_POP_UP), this);
    }

    public void waitForInformationalPopUpOpened() {
        waitForPresenceOf(INFO_MESSAGE_POP_UP);
    }

    public void waitForInformationalPopUpClosed() {
        waitForAbsenceOf(INFO_MESSAGE_POP_UP);
    }

    public EnrollmentPackagePopUp getDownloadEnrollmentPackage() {
        return new EnrollmentPackagePopUp(findBy(DOWNLOAD_ENROLLMENT_PACKAGE), this);
    }

    public String getNotificationBannerText() {
        return findBy(NOTIFICATION_BANNER).getText();
    }

    public void clickSign() {
//        waitForSpinnerToDisappear();
        jsClick(SIGN);
        waitAbit(500);
//        waitForAbsenceOf(SIGN);
    }

    public void closePopUpIfExists() {
        if (isElementPresent(INFO_MESSAGE_POP_UP)) {
            getInformationalPopUp().clickCloseButton();
            waitForInformationalPopUpClosed();
        } else {
            System.out.println("INFORMATIONAL POP-UP IS ABSENT!");
        }
    }

    private static final String CLICK_TERMINATED_LOGOUT_BUTTON = ".//span[text()='Logout']";

    public void clickOnLogoutButtonInTerminatedPage() {
        waitABit(500);
        jsClick(CLICK_TERMINATED_LOGOUT_BUTTON);
        waitABit(500);
    }

    //latest
    private static final String CREATE_REVALIDATION_BUTTON1 = ".//button/span[contains(text(),'CREATE REVALIDATION')]";

    public void clickRevalidationButton1() {
        //sp51.2
        waitABit(500);
        scrollToElement(CREATE_REVALIDATION_BUTTON1);
        jsClick(CREATE_REVALIDATION_BUTTON1);
    }

    private static final String NAVIGATE_TO_DASHBOARD = ".//button[span[text() = 'Navigate to dashboard']]";

    public void clickNavigateToDahsboard() {
        jsClick(NAVIGATE_TO_DASHBOARD);
    }

    //sp28
    public void clickContinueButton() {
        waitAbit(500);
        jsClick(CONTINUE_BUTTON);
        waitAbit(1000);
    }

    //sp41.4
    private static final String CLICK_REQUEST_TERMINATION_BUTTON = ".//p[span[text() = 'Request Termination']]";

    public void clickRequestTerminationButton() {
        waitAbit(500);
        scrollToElement(CLICK_REQUEST_TERMINATION_BUTTON);
        jsClick(CLICK_REQUEST_TERMINATION_BUTTON);
        waitAbit(200);
    }

    private static final String REQUEST_TERMINATION_POPUP = ".//h2[contains(text(), 'Request Termination')]/../parent::div";

    public boolean isRequestTerminationPopupOpened() {
        waitAbit(500);
        return isElementPresent(REQUEST_TERMINATION_POPUP);
    }

    private static final String REASON_FIELD = ".//input[contains(@id, 'Reason')]/preceding-sibling::div";
    private static final String REASON = ".//ul/li[contains(text(),'%s')]";
    private static final String NOTE = ".//label[contains(text(), 'Note')]/../div/textarea[1]";
    private static final String REQUESTTERMINATION_BUTTON = ".//button/span[contains(text(),'%s')]";
    private static final String CLICK_OK_BUTTON = ".//button/span[contains(text(),'OK')]";

    public void setReasonForRequestTerminationProvider(String reason, String note) {
        waitAbit(1000);
        // jsClick(REASON_FIELD);
        findBy(REASON_FIELD).click();
        scrollToElement(format(REASON, reason));
        waitAbit(1000);
        findBy(format(REASON, reason)).click();
        waitAbit(1000);
        findBy(NOTE).click();
        findBy(NOTE).type(note);
        waitAbit(1000);
    }

    public void clickonTerminationButton(String button) {
        findBy(format(REQUESTTERMINATION_BUTTON, button)).click();
        findBy(CLICK_OK_BUTTON).click();
    }

    //WY-65
    public void setReasonForRequestTerminationProvider1(String note) {
        waitAbit(1000);
        findBy(NOTE).click();
        findBy(NOTE).type(note);
        waitAbit(1000);
    }

    // SP-72

    private static final String CLICK_HELP_CENTER = ".//*[contains(text(),'Help Center')]";

    public void clickonHelpcenter() {
        waitABit(500);
        jsClick(CLICK_HELP_CENTER);
        waitABit(500);
    }

    //SD-04

    private static final String DASHBOARD_FIELD_NAMES = ".//div/p[text()='Provider Data']/..//span/../p";

    public List<String> checkDashBoardFields() {
        waitAbit(1000);
        return findAll(DASHBOARD_FIELD_NAMES).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    private static final String PROVIDERDATA_FIELD_NAMES = ".//div[contains(@class,'panel_item')]/span[contains(@class,'panel_title')]/span";

    public List<String> checkProviderDataFields() {
        waitAbit(1000);
        return findAll(PROVIDERDATA_FIELD_NAMES).stream().map(WebElementFacade::getText).map(s -> s.trim()).collect(Collectors.toList());
    }

    private static final String PROVIDERDATA_BOX_NAMES = "(.//div/h3[text()='%s']) | (.//div//span[text()='%s']) | (.//div/h2[text()='%s'])";

    public Boolean checkDashBoardBoxes(String box) {
        waitAbit(1000);
        return isElementPresent(format(PROVIDERDATA_BOX_NAMES, box, box, box));
    }

    //sd08

    private static final String PROCEED_TO_SIGN = "//button[span[text() = 'PROCEED TO SIGN']]";

    public void proceedToSign() {
        waitAbit(500);
        jsClick(PROCEED_TO_SIGN);
        waitAbit(500);
    }

    private static final String NEW_NAVIGATE_TO_DASHBOARD = ".//button[span[text() = 'Navigate to dashboard']]";

    public void clickNavigateToDashboard() {
        waitAbit(500);
        jsClick(NEW_NAVIGATE_TO_DASHBOARD);
//        findBy(NEW_NAVIGATE_TO_DASHBOARD).click();
        waitAbit(500);
    }

    private static final String TERMINATION_EFFECTIVE_DATE = ".//label[contains(text(), 'Effective Date')]/parent::div//input";

    public void setTerminationEffectiveDate(String date) {
        waitAbit(500);
        findBy(TERMINATION_EFFECTIVE_DATE).type(date);
        waitAbit(500);
    }

    private static final String DEATH_DATE = ".//label[contains(text(), 'Death Date')]/parent::div//input";

    public void setDeathDate(String deathDate) {
        waitAbit(500);
        findBy(DEATH_DATE).type(deathDate);
        waitAbit(500);
    }

    private static final String DEATH_DATE_MESSAGE = ".//label[contains(text(), 'Death Date')]/parent::div/p/span[text()='%s']";

    public boolean isDeathDateMessagePresent(String message) {
        return isElementPresent(format(DEATH_DATE_MESSAGE, message));
    }

    private static final String TYPE = "//label[@for='type']/..//div//div//div";
    private static final String SELECT_TYPE = "//div//ul//li[text()='%s']";
    private static final String SEARCH = "//span[text()='Search']";

    public void clickAndSearch(String docType) {
        waitAbit(100);
        findBy(TYPE).click();
        waitAbit(200);
        findBy(format(SELECT_TYPE, docType)).click();
        waitAbit(1000);
        findBy(SEARCH).click();
        waitAbit(5000);

    }

    private static final String TRACKING_NUMBER_OF_THE_PROVIDER = "(//div[contains(@class,'main-info-panel_item_')]//div)[7]";

    public String getTrackingNumOfTheProvider() {
        scrollToElement(TRACKING_NUMBER_OF_THE_PROVIDER);
       String trackingNum=findBy(TRACKING_NUMBER_OF_THE_PROVIDER).getText();
        return trackingNum;
    }
    private static final String TRACKING_NUM_OF_THE_PROVIDER = "//span[contains(text(),'Tracking number')]/../..//div";
    public String getTrackingNumberOfTheProvider(){
        scrollToElement(TRACKING_NUM_OF_THE_PROVIDER);
        String trackingNum=findBy(TRACKING_NUM_OF_THE_PROVIDER).getText();
        return trackingNum;
    }

    private static final String RECONSIDERATION_REQUEST_ID="//*[@id=\"pe-in-progress-dashboard\"]/div/div/div[2]/div/div[2]/div[4]/div";

    public String getReconsiderationRequestIDOfTheProvider(){
        scrollToElement(RECONSIDERATION_REQUEST_ID);
        String reconsiderationRequestID=findBy(RECONSIDERATION_REQUEST_ID).getText();
        return reconsiderationRequestID;

    }

    private static final String COC_REQUEST_ID_TO_APPROVE="(//div[contains(@class,'tile-table-column')]//div//div)[1]";

    public String getCocIDToApprove(){
        scrollToElement(COC_REQUEST_ID_TO_APPROVE);
        String cocIDToApprove=findBy(COC_REQUEST_ID_TO_APPROVE).getText();
        return cocIDToApprove;

    }

    private static final String COC_REQUEST_ID_TO_DENY="(//div[contains(@class,'tile-table-column')]//div//div)[1]";
    public String getCocRequestIDToDeny(){
        scrollToElement(COC_REQUEST_ID_TO_DENY);
        String cocRequestIDToDeny=findBy(COC_REQUEST_ID_TO_DENY).getText();
        return cocRequestIDToDeny;

    }
    private static final String REENROLLMENT_ID_TO_APPROVE="(//div[contains(@class,'main-info-panel_item')]//div)[6]";


    public String getReenrollmentRequestIDToApprove(){
        scrollToElement(REENROLLMENT_ID_TO_APPROVE);
        String reenrollmentRequestIDToApprove=findBy(REENROLLMENT_ID_TO_APPROVE).getText();
        return reenrollmentRequestIDToApprove;

    }
    private static final String REENROLLMENT_ID_TO_DENY="(//div[contains(@class,'main-info-panel_item')]//div)[6]";
    public String getReenrollmentRequestIDToDeny(){
        scrollToElement(REENROLLMENT_ID_TO_DENY);
        String reenrollmentRequestIDToDeny=findBy(REENROLLMENT_ID_TO_DENY).getText();
        return reenrollmentRequestIDToDeny;

    }
    private static final String REVALIDATION_ID="//span[contains(text(),'Tracking Number')]/../..//div";
    public String getRevalidationRequestID(){
        scrollToElement(REVALIDATION_ID);
        String revalidationRequestID=findBy(REVALIDATION_ID).getText();
        return revalidationRequestID;

    }
    private static final String VERIFY_TITLE="//div[contains(text(),'%s')]";
    public boolean verifyTitle(String titleName){
        return findBy(String.format(VERIFY_TITLE,titleName)).isDisplayed();
    }



        private static final String ENROLLMENT_TYPES = "//div[contains(@class,'dashboard_link-wrap')]";

        public void getEnrollmentTypes() {
            List<WebElementFacade> enrollmentTypes = findAll(ENROLLMENT_TYPES);
            System.out.println("Enrollment types displayed on the dashboard:");
            for (WebElementFacade types : enrollmentTypes) {
                System.out.println("- " + types.getText().trim());

        }
    }
    private static final String ADD_NOTE="//button//span[contains(text(),'%s')]";
        private static final String ADD_NOTE2="(//button//span[contains(text(),'Add Note')])[2]";
        private static final String SUBJECT="//div//input[contains(@aria-label,'Subject')]";
        private static final String TYPE_NOTE_HERE="(//div[contains(text(),'Type note here')]/../..//div)[5]//div[contains(@data-block,'true')]";
    public void verifyAddNoteButtonAndSendNote(String noteButton,String noteSubject,String typeNote){
            try{
                findBy(String.format(ADD_NOTE,noteButton)).isDisplayed();
                System.out.println("Add note button is present and adding note");
                findBy(String.format(ADD_NOTE,noteButton)).click();
                waitAbit(500);
                findBy(SUBJECT).sendKeys(noteSubject);
                waitAbit(200);
                findBy(TYPE_NOTE_HERE).click();
                waitAbit(400);
                findBy(TYPE_NOTE_HERE).sendKeys(typeNote);
                waitAbit(300);
                findBy(ADD_NOTE2).click();
                waitAbit(300);
            }
            catch (Exception e){
                System.err.println("====ADD NOTE BUTTON IS NOT PRESENT IN NOTES TAB IN ENROLLMENT TAB====");
            }
    }
    private static final String ADDED_SUBJECT="(//span[contains(@class,'notes_note-author-name')])[2]";
    private static final String ADDED_NOTE_MESSAGE="//span[contains(@data-text,'true')]";
    public void verifyAddedNote(String subjectNote,String sentNote){
        try{
            findBy(ADDED_SUBJECT).isDisplayed();
            System.out.println("Added subject is displayed");
            String addedSubject=findBy(ADDED_SUBJECT).getText();
            String addedNoteMsg=findBy(ADDED_NOTE_MESSAGE).getText();
            if (addedSubject.equals(subjectNote)) {
                System.out.println("Subject matches: " + addedSubject);
            } else {
                System.err.println("Subject mismatch! Expected: " + subjectNote + ", Found: " + addedSubject);
            }
            if (addedNoteMsg.equals(sentNote)) {
                System.out.println("Note message matches: " + addedNoteMsg);
            } else {
                System.err.println("Note message mismatch! Expected: " + sentNote + ", Found: " + addedNoteMsg);
            }

        }
        catch (Exception e){
            System.err.println("===ADDED NOTE IS NOT DISPLAYING===");
        }
    }
    private static final String ADD_MESSAGE_BUTTON="//button//span[contains(text(),'%s')]";
    private static final String MSG_SUBJECT="//input[contains(@aria-label,'Subject')]";
    private static final String TYPE_MSG="(//div[contains(@class,'rdw-rich-text-input')]//div//div//div//div//div)[1]";
    private static final String SEND="//button//span[contains(text(),'Send')]";

    public void verifyAndAddMessage(String msgButton,String subject, String message){
        try{
            findBy(String.format(ADD_MESSAGE_BUTTON,msgButton)).isDisplayed();
            System.out.println("Add Message buttn is displayed and Adding Message");
            findBy(String.format(ADD_MESSAGE_BUTTON,msgButton)).click();
            waitAbit(300);
            findBy(MSG_SUBJECT).sendKeys(subject);
            waitAbit(400);
            findBy(TYPE_MSG).click();
            waitAbit(200);
            findBy(TYPE_MSG).sendKeys(message);
            waitAbit(400);
            findBy(MSG_SUBJECT).click();
            waitAbit(400);
            findBy(SEND).click();
            waitAbit(500);

        }
        catch (Exception e){
            System.err.println("====ADD MESSAGE BUTTON IS NOT DIPLAYING IN MESSAGE TAB====");
        }
    }
    private static final String ADDED_MESSAGE_SUBJECT = "(//div[contains(@class,'message-center')]//div)[41]";

    public void verifyAddedMsgSubject(String addedSubject) {
        try {
            findBy(ADD_MESSAGE_BUTTON).isDisplayed();
            System.out.println("Added Subject is displaying");

            String addedMsgSubject = findBy(ADDED_MESSAGE_SUBJECT).getText();
            System.out.println("UI Displayed Subject: " + addedMsgSubject);
            System.out.println("Expected Subject: " + addedSubject);

            if (addedMsgSubject.equalsIgnoreCase(addedSubject)) {
                System.out.println("Added message subject matches expected subject");
            } else {
                System.err.println("Mismatch in added message subject");
            }

        } catch (Exception e) {
            System.err.println("Added message is not displaying");
        }
    }
    private static final String AFFILIATION_DETAILS=".//div[contains(@class, 'affiliation_provider-list-item')]";
    public void  verifyAffiliationDetails(){
        try{
            findBy(AFFILIATION_DETAILS).isDisplayed();
            System.out.println("Affiliation details are present");
        }
        catch (Exception e){
            System.err.println("====AFFILIATION DETAILS ARE NOT PRESENT====");
        }
    }

    private static final String FLORIDA_MEDICAID_PROVIDER_ID="(//div[contains(@class,'tile-table-row')])[1]";
    public void verifyDatainFloridaMedicaidProviderID(){
        try {
            findBy(FLORIDA_MEDICAID_PROVIDER_ID).isDisplayed();
            System.out.println("Florida MEdicaid Provider ID Data is present");
        }
        catch (Exception e){
            System.err.println("====FLORIDA MEDICAID PROVIDER ID DATA IS NOT DISPLAYED====");
        }

    }

    private static final String ADD_ALTERNATIVE_IDENTIFIER="//button//span[contains(text(),'%s')]";
    public void addAlternativeIdentifier(){
        try {
            findBy(ADD_ALTERNATIVE_IDENTIFIER).isDisplayed();
            System.out.println("Add Alternative Identifier Button is displayed");
            findBy(ADD_ALTERNATIVE_IDENTIFIER).click();
            waitAbit(400);
        }
        catch (Exception e){
            System.err.println("====ADD ALTERNATIVE IDENTIFIER BUTTON IS NOT DISPLAYED====");
        }
    }
    private static final String BACKGROUND_SCREENING="//div[contains(text(),'%s')]";
    public void backGroundScreening(String result){
        try{
            findBy(BACKGROUND_SCREENING).isDisplayed();
            System.out.println("Background Screening result is displaying");
        }
        catch (Exception e){
            System.err.println("====BACKGROUND SCREENING RESULT IS NOT FOUND====");
        }
    }

    private static final String ADDED_ALTERNATIVE_IDENTIFIER="(//div//p[contains(text(),'%s')])[1]";
    public void verifyAddedAlternativeIdentifier(String identifier){
        try{
            findBy(String.format(ADDED_ALTERNATIVE_IDENTIFIER,identifier)).isDisplayed();
            System.out.println("Added Alternative identifier is displaying");
        }
        catch (Exception e){
            System.err.println("====ADDED ALTERNATIVE IDETIFIER IS NOT DISPLAYING====");
        }
    }
    private static final String AFFILIATIONS=".//div[contains(@class, 'tile-table-row')]";
    private static final String NO_RESULTS_FOUND="//p[contains(text(),'No Results Found')]";
    public void verifyAffiliation(){
       try{
            findBy(AFFILIATIONS).isDisplayed();
            System.out.println("Affiliation Information is displayed");
       }
       catch (Exception e){
           findBy(NO_RESULTS_FOUND).isDisplayed();
           System.err.println("===PREVIOUS AFFILAITION DETAILS ARE NOT DISPLAYED====");

       }
    }

    private static final String CLAIMS_PAYMENTS="//span[contains(text(),'%s')]";
    private static final String CLAIMS_PAYMENTS_DATA="(//div[contains(@class,'summary_data')])[1]";
    public void verifyClaimPayment(String claimPayment){
        try{
            findBy(String.format(CLAIMS_PAYMENTS,claimPayment)).isDisplayed();
            findBy(CLAIMS_PAYMENTS_DATA).isDisplayed();
            System.out.println("Claim PaymNets Data is displaying");
        }
        catch (Exception e){
            System.err.println("====CLAIM PAYMENTS DATA IS NOT DISPLAYING====");
        }
    }
    private static final String LINK = "//a[contains(text(),'%s')]";
    private static final String DATA = "//div[contains(@class,'MuiCollapse-container')]";

    public void clickOnLink(String linkText) {
        try {
            WebElement linkElement = findBy(String.format(LINK, linkText));
            if (linkElement.isDisplayed()) {
                System.out.println("Link is displayed: " + linkText);
                linkElement.click();  // Assuming you want to click it
                waitAbit(400);

                try {
                    if (findBy(DATA).isDisplayed()) {
                        System.out.println("Associated data is displayed.");
                    } else {
                        System.err.println("===== Data is not displaying =====");
                    }
                } catch (Exception e) {
                    System.err.println("===== Data element not found =====");
                }
            }
        } catch (Exception e) {
            System.err.println("===== LINK IS NOT DISPLAYING: " + linkText + " =====");
        }
    }


}
