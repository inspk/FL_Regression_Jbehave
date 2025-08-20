package com.hhstechgroup.steps.serenity.peportalpages;

import com.hhstechgroup.ui.pages.peportal.DashboardPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;
import java.util.Map;

public class DashboardSteps extends ScenarioSteps {

    DashboardPage dashboardPage;

    @Step
    public List<String> getHeaderTabs() {
        return dashboardPage.getHeaderPanel().getTabs();
    }

    @Step
    public List<String> getFormFields(String form) {
        return dashboardPage.getBodyPanel().getEligibilityPanel(form).getFormFields();
    }

    @Step
    public Map<String, String> getEnrollmentInfo() {
        return dashboardPage.getBodyPanel().getEnrollmentInfoPanel().getMappedValues();
    }

    @Step
    public boolean isEnrollmentInfoPresent() {
        return dashboardPage.getBodyPanel().isEnrollmentInfoPanelPresent();
    }

    @Step
    public List<String> getOtherTabs() {
        return dashboardPage.getHeaderPanel().getOtherTabs();
    }

    @Step
    public boolean isLogoPresent() {
        return dashboardPage.getHeaderPanel().isLogoPresent();
    }

    //latest
    @Step
    public void clickOnLogo(){dashboardPage.getHeaderPanel().clickOnLogo();}

    @Step
    public boolean isMessagesButtonPresent() {
        return dashboardPage.getHeaderPanel().isMessageCenterButtonPresent();
    }

    @Step
    public String getUserEmail() {
        return dashboardPage.getHeaderPanel().getUserEmail();
    }

    @Step
    public String getInvitationMessage() {
        return dashboardPage.getBodyPanel().getInvitationMessage();
    }

    @Step
    public String getMiniPanelText(String miniPanel) {
        return dashboardPage.getBodyPanel().getEnrollmentMiniPanel(miniPanel).getBody();
    }

    @Step
    public String getPaymentPanelAmount(String paymentPanel) {
        return dashboardPage.getBodyPanel().getPaymentClaimPanel(paymentPanel).getAmount();
    }

    @Step
    public void clickViewDetails() {
        dashboardPage.getBodyPanel().getEnrollmentInfoPanel().clickViewDetails();
    }

    @Step
    public void clickOnPayer(String payer) {
        dashboardPage.getBodyPanel().clickSelectPayer(payer);
    }


    @Step
    public void clickOnEnrollmentType(String type) {
        dashboardPage.getBodyPanel().getEnrollmentMiniPanel(type).clickOnType();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void clickOnHeaderTab(String tabName) {
        dashboardPage.getHeaderPanel().clickOnTab(tabName);
    }

    @Step
    public void clickTabOnProvidersTab(String tabName){
        dashboardPage.clickTabOnProvidersTab(tabName);
    }

    @Step
    public void clickOnHiddenTabInIU(String nameOfTheTab){
        dashboardPage.clickOnHiddenTabInIU(nameOfTheTab);
    }
    //latest

    @Step
    public void clickOnHeaderTab1(String tabName) {
        dashboardPage.getHeaderPanel().clickOnTab1(tabName);
    }

    //latest
    @Step
    public void clickOnProviderDataTab(String tabname){
        dashboardPage.getHeaderPanel().clickOnProviderDataTab(tabname);
    }

    @Step
    public void clickOnDashboardTab(String tabName1) {
        dashboardPage.getHeaderPanel().clickOnDashoardTab(tabName1);
    }
    @Step
    public void selectHiddenTab (String tabName){
        dashboardPage.getHeaderPanel().selectHiddenTab(tabName);
    }

    @Step
    public String getWelcomeUserMessage() {
        return dashboardPage.getBodyPanel().getWelcomeMessage();
    }

    @Step
    public String getContinueTitle() {
        return dashboardPage.getBodyPanel().getContinueEnrollmentPanel().getTitle();
    }

    @Step
    public boolean isDeleteButtonPresent() {
        return dashboardPage.getBodyPanel().getContinueEnrollmentPanel().isDeleteApplicationButtonDisplayed();
    }

    @Step
    public void clickAffiliationDetailsLink() {
         dashboardPage.getBodyPanel().getContinueEnrollmentPanel().clickAffiliationDetailsLink();
    }

    @Step
    public Map<String, String> getContinueInfo() {
        return dashboardPage.getBodyPanel().getContinueEnrollmentPanel().getMappedValues();
    }

    @Step
    public void clickOnUserEmail() {
        dashboardPage.getHeaderPanel().clickOnUser();
    }

    @Step
    public void selectOptionOnUserPopUp(String option) {
        dashboardPage.getUserPopUp().clickOnOption(option);
    }
    @Step
    public void clickHelpTour(){
        dashboardPage.clickHelpTour();
    }

    @Step
    public void clickContinueEnrollment() {
        dashboardPage.getBodyPanel().getContinueEnrollmentPanel().clickOnButton();
    }

    @Step
    public String getNotitficationsCount() {
        return dashboardPage.getHeaderPanel().getNotitficationsCount();
    }

    @Step
    public void clickOnMessageCenterButton() {
        dashboardPage.getHeaderPanel().clickOnMessageCenterButton();
    }

    @Step
    public void clickOnConfirmAffiliation(){
        dashboardPage.getMessageCenterpanel().clickOnConfirmAffiliation();
    }

    @Step
    public void clickServiceForm(String form) {
        dashboardPage.getBodyPanel().getEligibilityPanel(form).clickServiceForm(form);
    }

    @Step
    public String getSuccessMessage() {
        return dashboardPage.getSuccessPanel().getTitle();
    }

    @Step
    public String getDoneMessage() {
        return dashboardPage.getDonePanel().getTitle();
    }

    @Step
    public String getCongratsMessage() {
        return dashboardPage.getCongratPanel().getTitle();
    }

    @Step
    public void clickGoToDashboardFromPopUp() {
        dashboardPage.getSuccessPanel().clickGoToDashboard();
    }

    @Step
    public void clickSign() {
        dashboardPage.clickSign();
    }

    @Step
    public boolean isSignButtonPresentAfterSubmit() {
        return dashboardPage.getCongratPanel().isSignButtonDisplayedOnSuccessPanel();
    }

    @Step
    public boolean isButtonPresentOnDashboard(String title) {
        return dashboardPage.getBodyPanel().getContinueEnrollmentPanel().isButtonDisplayed(title);
    }

    @Step
    public void navigateToDashboardBeforeSign() {
        dashboardPage.getCongratPanel().clickNavigateToDashboard();
    }

    @Step
    public void navigateToDashboardAfterSign() {
        dashboardPage.getDonePanel().clickNavigateToDashboard();
    }
    @Step
    public void navigateToDashboardAfterSign2() {
        dashboardPage.clickNavigateToDahsboard();
    }

    @Step
    public void navigateToDashboard() {
        dashboardPage.getSuccessPanel().clickNavigateToDashboard();
    }

    @Step
    public void backToDashboardFromSysOptions() {
        dashboardPage.getHeaderPanel().clickOnBackToDashboard();
    }

    @Step
    public void clickDeleteApplication() {
        dashboardPage.getBodyPanel().getContinueEnrollmentPanel().clickDeleteApplication();
    }

    @Step
    public String getDeletePopUpTitle() {
        return dashboardPage.getDeleteApplicationPanel().getTitle();
    }

    @Step
    public String getDeletePopUpText() {
        return dashboardPage.getDeleteApplicationPanel().getText();
    }

    @Step
    public boolean isDeleteButtonPresentInPopUp() {
        return dashboardPage.getDeleteApplicationPanel().isDeleteButtonDisplayed();
    }

    @Step
    public boolean isCancelButtonPresentInPopUp() {
        return dashboardPage.getDeleteApplicationPanel().isCancelButtonDisplayed();
    }

    @Step
    public void clickCancelButton() {
        dashboardPage.getDeleteApplicationPanel().clickCancelButton();
    }

    @Step
    public void clickDeleteButton() {
        dashboardPage.getDeleteApplicationPanel().clickDeleteButton();
    }

    @Step
    public boolean isDeleteApplicationPopUpPresent() {
        return dashboardPage.isDeleteApplicationPopUpPresent();
    }

    @Step
    public String getInformationalMessage() {
        return dashboardPage.getInformationalPopUp().getMessage();
    }

    @Step
    public void closeInformationalPopUp() {
        try {
            dashboardPage.waitForInformationalPopUpOpened();
            dashboardPage.getInformationalPopUp().clickCloseButton();
            dashboardPage.waitForInformationalPopUpClosed();
        }catch (Exception e){

        }
    }

    @Step
    public void closePopUpIfExists() {
        dashboardPage.closePopUpIfExists();
    }

    @Step
    public void clickViewDetails(String tab) {
        dashboardPage.getBodyPanel().getPaymentClaimPanel(tab).clickViewDetails();
    }

    @Step
    public boolean isListOfPaymentsDisplayed() {
        return dashboardPage.getBodyPanel().isPaymentsListDisplayed();
    }

    @Step
    public List<String> getPaymentsListInfo() {
        return dashboardPage.getBodyPanel().getPaymentsList().getTabs();
    }

    @Step
    public boolean isEnrollmentPackagePresent() {
        return dashboardPage.getBodyPanel().getEnrollmentPackageTitle();
    }

    @Step
    public String getEnrollmentPackageText() {
        return dashboardPage.getBodyPanel().getEnrollmentPackageText();
    }

    @Step
    public void clickDownloadPackage() {
        dashboardPage.getBodyPanel().clickDownloadPackage();
    }

    @Step
    public void clickRequestPackage() {
        dashboardPage.getBodyPanel().clickRequestPackage();
    }

    @Step
    public String getDownloadPopUpTitle() {
        return dashboardPage.getDownloadEnrollmentPackage().getTitle();
    }

    @Step
    public String getDownloadPopUpDescription() {
        return dashboardPage.getDownloadEnrollmentPackage().getDescription();
    }

    @Step
    public void setApplicationType(List<String> types) {
        dashboardPage.getDownloadEnrollmentPackage().selectApplicationType(types);
    }

    @Step
    public void setAdditionalInformation(List<String> info) {
        dashboardPage.getDownloadEnrollmentPackage().selectAdditionalInformation(info);
    }

    @Step
    public void downloadPackage() {
        dashboardPage.getDownloadEnrollmentPackage().clickDownload();
    }

    @Step
    public Map<String, String> getAppealInfo() {
        return dashboardPage.getBodyPanel().getAppealPanel().getMappedValues();
    }

    @Step
    public String getRevalidationWidgetTitle() {
        return dashboardPage.getBodyPanel().getRevalidationWidget().getTitle();
    }

    @Step
    public String getRevalidationWidgetDescription() {
        return dashboardPage.getBodyPanel().getRevalidationWidget().getRevalidationDescription();
    }

    @Step
    public String getRevalidationMissedWidgetDescription() {
        return dashboardPage.getBodyPanel().getRevalidationWidget().getRevalidationMissedDescription();
    }

    @Step
    public void clickCreateRevalidation() {
        dashboardPage.getBodyPanel().getRevalidationWidget().clickRevalidationButton();
    }



    @Step
    public String getNotificationBannerText() {
        return dashboardPage.getNotificationBannerText();
    }

    @Step
    public boolean isHeaderTabsAbsent() {
        return dashboardPage.getHeaderPanel().isTabsAbsent();
    }

    @Step
    public String getEnrollmentTerminatedDescription() {
        return dashboardPage.getBodyPanel().getEnrollmentTerminatedDescription();
    }
    @Step
    public List<Map<String, String>> getAffiliationDetails() {
        return dashboardPage.getAffiliationDetails();
    }

    @Step
    public void clickOnLogoutButtonInTerminatedPage(){dashboardPage.clickOnLogoutButtonInTerminatedPage();}

    //latest


    @Step
    public void clickCreateRevalidation1() {
        dashboardPage.clickRevalidationButton1();
    }

    @Step
    public void waitUserEmailInProfile(){
        dashboardPage.getHeaderPanel().waitUserEmail();
    }

    @Step
    public void clickContinueButton(){
        dashboardPage.clickContinueButton();
    }

    //sp41.4
    @Step
    public void clickRequestTerminationButton() {
        dashboardPage.clickRequestTerminationButton();
    }
    public boolean isRequestTerminationPopupOpened() {
        return dashboardPage.isRequestTerminationPopupOpened();
    }
    @Step
    public void setReasonForRequestTerminationProvider(String reason,String note){
        dashboardPage.setReasonForRequestTerminationProvider(reason,note);
    }
    @Step
    public void clickonTerminationButton(String button){
        dashboardPage.clickonTerminationButton(button);
    }

    //WY-65

    @Step
    public void setReasonForRequestTerminationProvider1(String note){
        dashboardPage.setReasonForRequestTerminationProvider1(note);
    }

    // SP-72

    @Step
    public void clickonHelpcenter() {
        dashboardPage.clickonHelpcenter();
    }

    //SD-04

    @Step
    public List<String> checkDashBoardFields(){
        return dashboardPage.checkDashBoardFields();
    }

    @Step
    public List<String> checkProviderDataFields(){
        return dashboardPage.checkProviderDataFields();
    }

    @Step
    public Boolean checkDashBoardBoxes(String box){
        return dashboardPage.checkDashBoardBoxes(box);
    }

    //SD08

    @Step
    public void proceedToSign() {
        dashboardPage.proceedToSign();
    }

    @Step
    public void clickNavigateToDashboard() {
        dashboardPage.clickNavigateToDashboard();
    }

    @Step
    public void setTerminationEffectiveDate(String date){
        dashboardPage.setTerminationEffectiveDate(date);
    }

    @Step
    public void setDeathDate(String deathDate){
        dashboardPage.setDeathDate(deathDate);
    }

    @Step
    public boolean isDeathDateMessagePresent(String message){
        return dashboardPage.isDeathDateMessagePresent(message);
    }
    @Step
    public void clickAndSearch(String docType){
        dashboardPage.clickAndSearch(docType);
    }

    @Step
    public String getTrackingNumOfTheProvider(){
         return dashboardPage.getTrackingNumOfTheProvider();
    }
    @Step
    public String getTrackingNumberOfTheProvider(){
        return dashboardPage.getTrackingNumberOfTheProvider();
    }
    @Step
    public String getReconsiderationRequestIDOfTheProvider(){
        return dashboardPage.getReconsiderationRequestIDOfTheProvider();
    }
    @Step
    public String getCocIDToApprove(){
        return  dashboardPage.getCocIDToApprove();
    }

    @Step
    public String getCocRequestIDToDeny(){
        return  dashboardPage.getCocRequestIDToDeny();
    }


    @Step
    public String getReenrollmentRequestIDToApprove(){
        return dashboardPage.getReenrollmentRequestIDToApprove();
    }

    @Step
    public String getReenrollmentRequestIDToDeny(){
        return dashboardPage.getReenrollmentRequestIDToDeny();
    }
    @Step
    public String getRevalidationRequestID(){
        return  dashboardPage.getRevalidationRequestID();
    }
    @Step
    public boolean verifyTitle(String titleName){
        return dashboardPage.verifyTitle(titleName);
    }

    @Step
    public void getEnrollmentTypes(){
        dashboardPage.getEnrollmentTypes();
    }

    @Step
    public void verifyAddNoteButtonAndSendNote(String noteButton,String noteSubject,String typeNote){
        dashboardPage.verifyAddNoteButtonAndSendNote(noteButton,noteSubject,typeNote);
    }
    @Step
    public void verifyAddedNote(String subjectNote,String sentNote){
        dashboardPage.verifyAddedNote(subjectNote,sentNote);
    }

    @Step
    public void verifyAndAddMessage(String msgButton,String subject, String message){
        dashboardPage.verifyAndAddMessage(msgButton,subject,message);
    }

    @Step
    public void verifyAddedMsgSubject(String addedSubject){
        dashboardPage.verifyAddedMsgSubject(addedSubject);
    }
    @Step
    public void  verifyAffiliationDetails(){
        dashboardPage.verifyAffiliationDetails();
    }
    @Step
    public void verifyDatainFloridaMedicaidProviderID(){
        dashboardPage.verifyDatainFloridaMedicaidProviderID();
    }
    @Step
    public void addAlternativeIdentifier(){
        dashboardPage.addAlternativeIdentifier();
    }
    @Step
    public void backGroundScreening(String result){
        dashboardPage.backGroundScreening(result);
    }

    @Step
    public void verifyAddedAlternativeIdentifier(String identifier){
        dashboardPage.verifyAddedAlternativeIdentifier(identifier);
    }

    @Step
    public void verifyAffiliation(){
        dashboardPage.verifyAffiliation();
    }

    @Step
    public void verifyClaimPayment(String claimPayment){
        dashboardPage.verifyClaimPayment(claimPayment);
    }

    @Step
    public void clickOnLink(String link){
        dashboardPage.clickOnLink(link);
    }


}
