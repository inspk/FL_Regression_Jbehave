package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.PagesNavigationSteps;
import com.hhstechgroup.steps.serenity.peportalpages.DashboardSteps;
import com.hhstechgroup.steps.serenity.registration.LandingSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import com.hhstechgroup.util.properties.ProviderProperties;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.collection.IsMapContaining;
import org.hamcrest.core.Is;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.reflectionassert.ReflectionComparatorMode;
import org.yecht.Data;

import java.util.List;
import java.util.Map;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class ProviderDashboardScenario {

    private static final String LOG_OUT = "Log out";

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    PagesNavigationSteps pagesNavigationSteps;

    @When("user selects payer '$payer' on Dashboard")
    public void selectPayer(String payer) {
        dashboardSteps.clickOnPayer(payer);
    }

    @When("user selects payer '$payer' on Dashboard and save it to variable - '${payer}'")
    public void selectAndSavePayer(String payer) {
        dashboardSteps.clickOnPayer(payer);
        Serenity.setSessionVariable("payer").to(payer);
    }

    @When("user click on $enrollmentType type")
    public void selectEnrollmentType(String enrollmentType) {
        dashboardSteps.clickOnEnrollmentType(enrollmentType);
        Serenity.setSessionVariable("enrollmentType").to(enrollmentType);
    }

    @When("log out from {PE|IU} portal")
    public void logOutFromDashboard() {
        String currentUrl = getDriver().getCurrentUrl();
        dashboardSteps.clickOnUserEmail();
        dashboardSteps.selectOptionOnUserPopUp(LOG_OUT);
        pagesNavigationSteps.waitForRedirectedFrom(currentUrl);
    }

    @When("log out from portal")
    public void logOut() {
        String currentUrl = getDriver().getCurrentUrl();
        dashboardSteps.clickOnUserEmail();
        dashboardSteps.selectOptionOnUserPopUp(LOG_OUT);
        pagesNavigationSteps.waitForRedirectedFrom(currentUrl);
    }

    @When("log out")
    public void logOut2() {
        dashboardSteps.clickHelpTour();
        dashboardSteps.selectOptionOnUserPopUp(LOG_OUT);
    }

    @When("continue enrollment process")
    public void clickContinueEnrollment() {
        dashboardSteps.clickContinueEnrollment();
    }

    @When("click on $tab tab on header")
    public void clickOnTab(String tab) {
        dashboardSteps.clickOnHeaderTab(tab);
    }
    @When("click on '$tabName' tab in IU")
    @Then("click on '$tabName' tab in IU")
    public void clickTabOnProvidersTab(String tabName){
        dashboardSteps.clickTabOnProvidersTab(tabName);
    }

    @When("click on hidden '$nameOfTheTab' tab in IU")
    public void clickOnHiddenTabInIU(String nameOfTheTab){
        dashboardSteps.clickOnHiddenTabInIU(nameOfTheTab);
    }

    @When("click on '$tab' tab on header of Tp")
    public void clickOnTab1(String tab) {
        dashboardSteps.clickOnHeaderTab1(tab);
    }

    //latest
    @When("click on '$tab' provider  data tab on the dashboard")
    public void clickOnProviderDataTab(String tabname){dashboardSteps.clickOnProviderDataTab(tabname);}

    @When("click on dashboard '$tabs' from the provider portal")
    public void clickOnDashboardTab(String tabs) {
        dashboardSteps.clickOnDashboardTab(tabs);
    }

    @When("select hidden tab '$tabName'")
    public void selectHiddenTab(String tabName){
        dashboardSteps.selectHiddenTab(tabName);
    }

    @When("navigate to Message Center")
    public void navigateToMessageCenter() {
        dashboardSteps.clickOnMessageCenterButton();
    }

    @When("click on '$text' in message center")
    public void confirmAffiliation(){
        dashboardSteps.clickOnConfirmAffiliation();
    }

    @When("navigate to $form form")
    public void navigateToServiceForm(String form) {dashboardSteps.clickServiceForm(form); }

    @When("click on Go To Dashboard button")
    public void clickOnGoToDashboard() {
        dashboardSteps.clickGoToDashboardFromPopUp();
    }

    @When("click navigate to dashboard link before sign")
    public void navigateToDashboardBeforeSign() {
        dashboardSteps.navigateToDashboardBeforeSign();
    }

    @When("click navigate to dashboard link after sign")
    public void navigateToDashboardAfterSign() {
        dashboardSteps.navigateToDashboardAfterSign();
    }

    @When("click Navigate to Dashboard button after sign")
    public void navigateToDashboardAfterSign2() {
        dashboardSteps.navigateToDashboardAfterSign2();
    }

    @When("click navigate to dashboard link after application submission")
    public void navigateToDashboard() {
        dashboardSteps.navigateToDashboard();
    }

    @When("click on Sign button")
    @Alias("click sign application")
    public void clickSign() {
        dashboardSteps.clickSign();
    }

    @When("click delete application button")
    public void clickDeleteApplication() {
        dashboardSteps.clickDeleteApplication();
    }

    @When("click on Cancel button on Delete application pop-up")
    public void clickCancelDeleteApp() {
        dashboardSteps.clickCancelButton();
    }

    @When("click on Delete button on Delete application pop-up")
    public void clickDeleteApp() {
        dashboardSteps.clickDeleteButton();
    }

    @When("click on View details on $tab tab")
    public void viewPaymentDetails(String tab) {
        dashboardSteps.clickViewDetails(tab);
    }

    @When("close informational pop-up")
    public void closeInformationalPopUp() {
        dashboardSteps.closeInformationalPopUp();
    }

    @When("close informational pop-up if exists")
    public void closePopUpIfExists() {
        dashboardSteps.closePopUpIfExists();
    }

    @When("click Download enrollment package link on Dashboard")
    public void clickDownloadPackageLink() {
        dashboardSteps.clickDownloadPackage();
    }

    @When("click Request enrollment package on Dashboard")
    public void clickRequestPackageLink() {
        dashboardSteps.clickRequestPackage();
    }

    @When("select Application type on package download pop-up: $table")
    public void selectApplicationTypeOnPopUp(ExamplesTable table) {
        dashboardSteps.setApplicationType(ExamplesTableUtil.parseTableColumnAsList(table, 0));
    }

    @When("select Additional information on package download pop-up: $table")
    public void selectAdditionalInformationOnPopUp(ExamplesTable information) {
        dashboardSteps.setAdditionalInformation(ExamplesTableUtil.parseTableColumnAsList(information, 0));
    }

    @When("click on Download button on package download pop-up")
    public void downloadPackage() {
        dashboardSteps.downloadPackage();
    }
    @When("click on show affiliation details link")
    public void clickAffiliationDetailsLink() {
        dashboardSteps.clickAffiliationDetailsLink();
    }

    @When("click on Create Revalidation button on dashboard")
    public void clickCreateRevalidation() {
        dashboardSteps.clickCreateRevalidation();
    }

    @When("click to View Details button on Enrollment info tab")
    public void clickViewDetails() {
        dashboardSteps.clickViewDetails();
    }

    @Then("logo should be displayed on Dashboard page")
    public void isLogoDisplayed() {
        assertTrue("Logo should be displayed", dashboardSteps.isLogoPresent());
    }
    //latest
    @Then("click on logo")
    public void clickOnLogo(){dashboardSteps.clickOnLogo();}

    @Then("next tabs should be displayed in the header on Dashboard page: $table")
    public void checkTabsInHeader(ExamplesTable table) {
        List<String> expectedTabs = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertReflectionEquals(expectedTabs, dashboardSteps.getHeaderTabs());
    }

    @Then("next fields should be displayed in the $form form: $table")
    public void checkForm(ExamplesTable table, String form) {
        List<String> expectedFields = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertReflectionEquals(expectedFields, dashboardSteps.getFormFields(form));
    }

    @Then("$tab tab should have next amount - $amount")
    public void checkBodyTab(String tab, String amount) {
        assertEquals(amount, dashboardSteps.getPaymentPanelAmount(tab));
    }

    @Then("next tabs should be displayed in Other dropdown: $table")
    public void checkOtherTabs(ExamplesTable table) {
        List<String> expectedTabs = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertReflectionEquals(expectedTabs, dashboardSteps.getOtherTabs());
    }

    @Then("Message Center button should be displayed on Dashboard page")
    public void isMessageButtonDisplayed() {
        assertTrue("Message Center button should be displayed ", dashboardSteps.isMessagesButtonPresent());
    }

    @Then("Message Center button should not be displayed on Dashboard page")
    public void isMessageButtonAbsent() {
        assertFalse("Message Center button should be displayed ", dashboardSteps.isMessagesButtonPresent());
    }

    @Then("user email $email should be displayed on Dashboard page")
    public void checkUserEmailInHeader(String email) {
        assertEquals(email.toLowerCase(), dashboardSteps.getUserEmail());
    }

    @Then("invitation message '$message' should be displayed when enrollment haven't started yet")
    public void checkInvitationMessage(String message) {
        String formattedMessage = message.replaceAll("\\\\n", "\n");
        assertEquals("Wrong invitation message is displayed", formattedMessage, dashboardSteps.getInvitationMessage());
    }

    @Then("next enrollment types should be displayed on Dashboard page: $table")
    public void checkEnrollmentTypes(ExamplesTable table) {
        table.getRows().forEach(row -> assertEquals(row.get("text"), dashboardSteps.getMiniPanelText(row.get("type"))));
    }

    @Then("message '$message' should be displayed {after starting enrollment|enrollment is terminated}")
    public void checkWelcomeUserMessage(String expectedMessage) {
        assertEquals(expectedMessage, dashboardSteps.getWelcomeUserMessage());
    }

    @Then("continue enrollment page with title - '$title' should be displayed")
    public void checkContinueEnrollmentTitle(String expectedTitle) {
        assertEquals(expectedTitle, dashboardSteps.getContinueTitle());
    }

    @Then("Delete Application button should be displayed")
    public void isDeleteButtonPresent() {
        assertTrue(dashboardSteps.isDeleteButtonPresent());
    }



    @Then("next information should be displayed on Enrollment info tab: $table")
    public void checkEnrollmentInfo(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(dashboardSteps.getEnrollmentInfo(), Is.is(expectedInfo));
    }

    @Then("provider receive $count notification")
    @Alias("staff receive $count message")
    public void checkCountOfNotiications(String expecetdCount) {
        assertEquals(expecetdCount, dashboardSteps.getNotitficationsCount());
    }

    @Then("pop-up with title '$title' should be displayed after submission")
    public void checkSubmissionPopUp(String title) {
        assertEquals(title, dashboardSteps.getSuccessMessage());
    }

    @Then("pop-up with title '$title' should be displayed when application is ready for sign")
    public void checkReadyForSignPopUp(String title) {
        assertEquals(title, dashboardSteps.getCongratsMessage());
    }

    @Then("pop-up with title '$title' should be displayed when application is signed")
    public void checkSignedPopUp(String title) {
        assertEquals(title, dashboardSteps.getDoneMessage());
    }

    @Then("pop-up with title - '$title' and text - '$text' should be displayed after deletion")
    public void checkDeletePopUp(String title, String text) {
        assertEquals("Wrong title is displayed on Delete application pop-up", title, dashboardSteps.getDeletePopUpTitle());
        assertEquals("Wrong text is displayed on Delete application pop-up", text, dashboardSteps.getDeletePopUpText());
    }

    @Then("Delete application pop-up should contain Delete Button")
    public void isDeleteButtonPresentInPopUp() {
        assertTrue(dashboardSteps.isDeleteButtonPresent());
    }

    @Then("Delete application pop-up should contain Cancel Button")
    public void isCancelButtonPresentInPopUp() {
        assertTrue(dashboardSteps.isCancelButtonPresentInPopUp());
    }

    @Then("Delete application pop-up should disappear")
    public void isDeleteApplicationPopUpPresent() {
        assertFalse(dashboardSteps.isDeleteApplicationPopUpPresent());
    }

    @Then("pop-up with message '$message' should appear on dashboard")
    public void checkPopUpMessage(String message) {
        assertEquals(message, dashboardSteps.getInformationalMessage());
        closeInformationalPopUp();
    }

    @Then("list of payments should be displayed")
    public void isListOfPaymentsDisplayed() {
        assertTrue(dashboardSteps.isListOfPaymentsDisplayed());
    }

    @Then("next information should be displayed in list of payments: $table")
    public void checkPaymentsListInfo(ExamplesTable table) {
        assertReflectionEquals(ExamplesTableUtil.parseTableColumnAsList(table, 0), dashboardSteps.getPaymentsListInfo());
    }

    @Then("Enrollment package section should be present with description '$description'")
    public void checkEnrollmentPackageSection(String description) {
        assertTrue(dashboardSteps.isEnrollmentPackagePresent());
        assertEquals(description, dashboardSteps.getEnrollmentPackageText());
    }

    @Then("pop-up for package downloading with title '$title' and description '$description' should appear")
    public void checkDownloadPopUp(String title, String description) {
        assertEquals(title, dashboardSteps.getDownloadPopUpTitle());
        assertEquals(description, dashboardSteps.getDownloadPopUpDescription());
    }

    @Then("verify Sign button is not displayed after submit")
    public void verifySignButtonIsNotDisplayed(){
        assertFalse("Sign button is present", dashboardSteps.isSignButtonPresentAfterSubmit());
    }

    @Then("button '$buttonTitle' should be displayed on Dashboard")
    public void verifyButtonIsDisplayedOnDashboard(String title){
        assertTrue("Button is not present", dashboardSteps.isButtonPresentOnDashboard(title));
    }

    @Then("button '$buttonTitle' should not be displayed on Dashboard")
    public void verifyButtonIsNotDisplayedOnDashboard(String title){
        assertFalse("Button is present", dashboardSteps.isButtonPresentOnDashboard(title));
    }

    @Then("next appeals information should be displayed on Dashboard: $table")
    public void checkAppealInfo(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        table.getRow(0).forEach((key, value) -> assertThat(dashboardSteps.getAppealInfo(), IsMapContaining.hasEntry(key, value)));
    }

    @Then("Enrollment info should be absent")
    public void isEnrollmentInfoAbsent() {
        assertFalse(dashboardSteps.isEnrollmentInfoPresent());
    }

    @Then("revalidation widget with title - '$title' and description - '$description' should be present")
    public void checkRevalidationWidget(String title, String description) {
        assertEquals(title, dashboardSteps.getRevalidationWidgetTitle());
        assertEquals(description, dashboardSteps.getRevalidationWidgetDescription());
    }

    @Then("revalidation missed widget with description - '$description' should be present")
    public void checkRevalidationMissedWidget(String description) {
        assertEquals(description, dashboardSteps.getRevalidationMissedWidgetDescription());
    }

    @Then("notification banner should be displayed with text - '$text'")
    public void checkNotificationBanner(String expectedText) {
        assertEquals(expectedText, dashboardSteps.getNotificationBannerText());
    }

    @Then("header should be absent")
    public void isHeaderAbsent() {
        assertTrue(dashboardSteps.isHeaderTabsAbsent());
    }

    @Then("description '$text' should be displayed when enrollment is terminated")
    public void checkTerminatedDescription(String expectedMessage) {
        assertEquals(expectedMessage, dashboardSteps.getEnrollmentTerminatedDescription());
    }

    @Then("affiliation details should contain next data: $table")
    public void checkAffiliationDetails(ExamplesTable table) {
        ReflectionAssert.assertReflectionEquals(table.getRows(), dashboardSteps.getAffiliationDetails(), ReflectionComparatorMode.LENIENT_ORDER);

    }
    private String getTrackingNumber(String trackingNumber) {
        final String defaultTrackingNumber = "000000000";
        String formattedTrackingNumber = new StringBuilder(defaultTrackingNumber.substring(0, defaultTrackingNumber.length() - trackingNumber.length())).append(trackingNumber).toString();
        return formattedTrackingNumber.replaceFirst("(\\d{3})(\\d{3})(\\d{3})",  "$1-$2-$3");
    }

    @When("click on logout button in the terminated page")
    public void clickOnLogoutButtonInTerminatedPage(){dashboardSteps.clickOnLogoutButtonInTerminatedPage();}

    //latest

    @When("click on Create Revalidation button")
    public void clickCreateRevalidation1() {
        dashboardSteps.clickCreateRevalidation1();
    }

    @When("click on Continue button")
    public void clickContinueButtonOnDashboard() {
        dashboardSteps.clickContinueButton();
    }

    @When("wait till user's email is displayed")
        public void waitUserEmailOnDahsboard(){
            dashboardSteps.waitUserEmailInProfile();
        }

    //sp41.4
    @Then("click on the Request Termination Button")
    public void clickRequestTerminationButton() {
        dashboardSteps.clickRequestTerminationButton();
    }

    @Then("verifying the Request Termination pop-up is displaying")
    public void isRequestTerminationPopupOpened() {
        assertTrue(dashboardSteps.isRequestTerminationPopupOpened());
    }

    @When("set provider '$reason' and '$note' in Request Termination popup")
    public void setReasonForRequestTerminationProvider(String reason,String note) {
        dashboardSteps.setReasonForRequestTerminationProvider(reason,note);
    }
    @Then("click '$button' button for the provider")
        public void clickonTerminationButton(String button){
        dashboardSteps.clickonTerminationButton(button);
    }

    //WY-65

    @When("select provider '$note' in Request Termination popup")
    public void setReasonForRequestTerminationProvider1(String note) {
        dashboardSteps.setReasonForRequestTerminationProvider1(note);
    }

    // SP-72

    @When("user click on Help center")
    public void clickonHelpcenter() {
        dashboardSteps.clickonHelpcenter();
    }

    //SD-04

    @Then("Validating all the fields should be displayed on dashboard page: $table")
    public void checkDashBoardFields(ExamplesTable table) {
        List<String> expectedFields = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertEquals(expectedFields, dashboardSteps.checkDashBoardFields());
    }

    @Then("Validating all the fields should be displayed on provider data page: $table")
    public void checkProviderDataFields(ExamplesTable table) {
        List<String> expectedFields = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertEquals(expectedFields, dashboardSteps.checkProviderDataFields());
    }

    @Then("Validating all the boxes should not be displayed on dashboard page: $table")
    public void checkDashBoardBoxes(ExamplesTable table) {
        List<String> expectedBoxes = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        for(String box:expectedBoxes) {
            if(dashboardSteps.checkDashBoardBoxes(box))
                System.out.println(box+" is Presents !");
            else
                System.out.println(box+" is not Presents !");

        }
    }

    //SD08

    @When("click on Proceed To Sign button")
    public void proceedToSign() {
        dashboardSteps.proceedToSign();
    }

    @When("click on navigate to dashboard for Proceed To Sign")
    public void clickNavigateToDashboard() {
        dashboardSteps.clickNavigateToDashboard();
    }

    @When("set effective date '$date' in Request Termination popup")
    public void setTerminationEffectiveDate(String date){
        dashboardSteps.setTerminationEffectiveDate(date);
    }

    @When("set death date '$date' in Request Termination popup")
    public void setDeathDate(String deathDate){
        dashboardSteps.setDeathDate(deathDate);
    }

    @When("verify death date message '$message' in Request Termination popup")
    public void isDeathDateMessagePresent(String message){
        assertTrue(message + " - message not presents!", dashboardSteps.isDeathDateMessagePresent(message));
    }

    @When("verify death date is mandatory with '$message'")
    public void verifyDeathDateMandatory(String message){
        assertTrue(message + " - message not presents!", dashboardSteps.isDeathDateMessagePresent(message));
    }

    @Then("click on type to search with '$doc' in document tab")
    public void clickAndSearch(String docType){
        dashboardSteps.clickAndSearch(docType);
    }

    @Then("save the tracking number of the provider")
    public void getTrackingNumOfTheProvider(){
        String trackingNum=dashboardSteps.getTrackingNumOfTheProvider();
        ProviderProperties.save("trackingNum", trackingNum);
    }
    @Then("save the Tracking Number of the provider")
    public void getTrackingNumberOfTheProvider(){
        String trackingNum=dashboardSteps.getTrackingNumberOfTheProvider();
        ProviderProperties.save("trackingNum", trackingNum);
    }

    @Then("save the requestID of reconsideration")
    public void getReconsiderationRequestIDOfTheProvider(){
        String reconsiderationRequestID=dashboardSteps.getReconsiderationRequestIDOfTheProvider();
        ProviderProperties.save("reconsiderationRequestID", reconsiderationRequestID);
    }

    @Then("save coc request ID to approve the request of the provider")
    public void getCocIDToApprove(){
        String cocIDToApprove=dashboardSteps.getCocIDToApprove();
        ProviderProperties.save("cocIDToApprove", cocIDToApprove);
    }
    @Then("save coc request ID to deny the request of the provider")
    public void getCocRequestIDToDeny(){
        String cocRequestIDToDeny=dashboardSteps.getCocRequestIDToDeny();
        ProviderProperties.save("cocRequestIDToDeny", cocRequestIDToDeny);

    }
    @Then("save the request ID of the reenrollment to approve the request of the provider")
    public void getReenrollmentRequestIDToApprove(){
        String reenrollmentRequestIDToApprove=dashboardSteps.getReenrollmentRequestIDToApprove();
        ProviderProperties.save("reenrollmentRequestIDToApprove", reenrollmentRequestIDToApprove);

    }
    @Then("save the request ID of the reenrollment to deny the request of the provider")
    public void getReenrollmentRequestIDToDeny(){
        String reenrollmentRequestIDToDeny=dashboardSteps.getReenrollmentRequestIDToDeny();
        ProviderProperties.save("reenrollmentRequestIDToDeny", reenrollmentRequestIDToDeny);

    }

    @Then("save the tracking ID of the revalidation")
    public void getRevalidationRequestID(){
        String revalidationRequestID=dashboardSteps.getRevalidationRequestID();
        ProviderProperties.save("revalidationRequestID", revalidationRequestID);
    }
    @When("verify the title '$titleName' is displaying")
    public void verifyTitle(String titleName){
        assertTrue(dashboardSteps.verifyTitle(titleName));
    }

    @Then("print all the enrollment types displayed on the dashboard")
    public void getAllEnrollmentTypes() {
        dashboardSteps.getEnrollmentTypes();
    }

    @Then("verify '$noteButton' button, add subject '$noteSubject' and type note '$typeNote' in Notes tab")
    public void verifyAddNoteButtonAndSendNote(String noteButton,String noteSubject,String typeNote){
        dashboardSteps.verifyAddNoteButtonAndSendNote(noteButton,noteSubject,typeNote);
    }

    @Then("verify the added note subject '$subjectNote' and note message '$sentNote' is displaying in Notes tab")
    public void verifyAddedNote(String subjectNote,String sentNote){
        dashboardSteps.verifyAddedNote(subjectNote,sentNote);
    }

    @Then("verify '$msgButton' button, add subject '$subject' and type message '$message' in Message tab")
    public void verifyAndAddMessage(String msgButton,String subject, String message) {
        dashboardSteps.verifyAndAddMessage(msgButton,subject, message);
    }

    @Then("verify added message subject '$addedSubject' is diaplaying in Message tab")
    public void verifyAddedMsgSubject(String addedSubject){
        dashboardSteps.verifyAddedMsgSubject(addedSubject);
    }

    @Then("verify that the affiliation details are displayed")
    public void verifyAffiliationDetails(){
        dashboardSteps.verifyAffiliationDetails();
    }

    @Then("verify data is present in Florida Medicaid Provider ID")
    public void verifyDatainFloridaMedicaidProviderID(){
        dashboardSteps.verifyDatainFloridaMedicaidProviderID();
    }

    @Then("verify '$button' button is displaying")
    public void addAlternativeIdentifier(){
      dashboardSteps.addAlternativeIdentifier();
    }

    @Then("verify the '$result' is displaying")
    public void backGroundScreening(String result){
        dashboardSteps.backGroundScreening(result);
    }

    @Then("verify added Alternative Identifier '$identifier' is displaying")
    public void verifyAddedAlternativeIdentifier(String identifier){
        dashboardSteps.verifyAddedAlternativeIdentifier(identifier);
    }

    @Then("verify the affiliations are present in Affiliation tab")
    public void verifyAffiliations(){
        dashboardSteps.verifyAffiliation();
    }
     @Then("verify the '$claimPayment' data is present")
    public void verifyClaimPayment(String claimPayment){
        dashboardSteps.verifyClaimPayment(claimPayment);
     }

     @Then("verify and click on '$link' link")
    public void clickOnLink(String link){
        dashboardSteps.clickOnLink(link);
     }


}
