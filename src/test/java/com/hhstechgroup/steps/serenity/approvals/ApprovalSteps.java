package com.hhstechgroup.steps.serenity.approvals;

import com.hhstechgroup.ui.pages.iuportal.ViewRequestPage;
import com.hhstechgroup.ui.pages.systemoptions.ApprovalsConfigurationPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import java.util.List;;

public class ApprovalSteps extends ScenarioSteps {

    ViewRequestPage viewRequestPage;
    ApprovalsConfigurationPage approvalsConfigurationPage;

    @Step
    public void clickWiewForRequest(String request) {
        approvalsConfigurationPage.clickViewForRequest(request);
    }

    @Step
    public void clickEdit() {
        approvalsConfigurationPage.clickEditButton();
    }

    @Step
    public void clickEdit1() {
        approvalsConfigurationPage.clickEditButton1();
    }

    @Step
    public void clickSave() {
        approvalsConfigurationPage.clickSaveButton();
    }
    @Step
    public void clickSave1() {
        approvalsConfigurationPage.clickSaveButton1();
    }


    @Step
    public void selectApproversNumber(String number) {
        approvalsConfigurationPage.selectApproversNumber(number);
    }

    @Step
    public void turnOnReviwers() {
        approvalsConfigurationPage.turnOnReviewers();
    }

    @Step
    public void turnOffReviwers() {
        approvalsConfigurationPage.turnOffReviewers();
    }

    @Step
    public void selectReviewersNumber(String number) {
        approvalsConfigurationPage.selectReviewersNumber(number);
    }

    @Step
    public void clickAddReviewer() {
        approvalsConfigurationPage.clickAddReviewer();
    }

    @Step
    public void turnOnCVOReviwers() {
        approvalsConfigurationPage.turnOnCVOReviewers();
    }

    @Step
    public void turnOffCVOReviwers() {
        approvalsConfigurationPage.turnOffCVOReviewers();
    }

    @Step
    public void clickAddCVOReviewer() {
        approvalsConfigurationPage.clickAddCVOReviewer();
    }

    @Step
    public void selectCVOReviewersNumber(String number) {
        approvalsConfigurationPage.selectCVOReviewersNumber(number);
    }

    @Step
    public void addCVOReviewerWithVerification(String cvoreviewer,  String name, String typeRole){
        approvalsConfigurationPage.addCVOReviewerAllSteps(cvoreviewer, name, typeRole);
    }


        @Step
    public void addApproverReviewerWithVerification(String reviewerApprover,  String name, String typeRole){
        approvalsConfigurationPage.addApproverReviewerAllSteps(reviewerApprover, name, typeRole);
    }

    @Step
    public void clickAddApprover() {
        approvalsConfigurationPage.clickAddApprover();
    }

    @Step
    public void  clickRemoveApprover(String approver) {
        approvalsConfigurationPage.clickRemoveApprover(approver);
    }
    @Step
    public void clickRemoveReviewer(String reviewer) {
        approvalsConfigurationPage.clickRemoveReviewer(reviewer);
    }

    @Step
    public void selectRoleUser(String roleUser) {
        approvalsConfigurationPage.selectRoleUser(roleUser);
    }

    @Step
    public void selectTypeRoleUser(String typeRoleUser) {
        approvalsConfigurationPage.selectTypeRoleUser(typeRoleUser);
    }

    @Step
    public void clickAddInPopup() {
        approvalsConfigurationPage.clickAddInPopup();
    }

    @Step
    public boolean areFieldsReadOnly(List<String> fields) {
        return approvalsConfigurationPage.areFieldsReadOnly(fields);
    }

    @Step
    public String getApprovalSectionsAndType(String section) {
        return approvalsConfigurationPage.getApprovalsSectionsAndType(section);
    }

    @Step
    public void clickApproveDeny(String vote) {
        viewRequestPage.getApprovalPanel().clickApproveDeny(vote);
    }

    @Step
    public boolean isVoteTextPresent(String text) {
        return viewRequestPage.getApprovalPanel().isVoteTextPresent(text);
    }

    @Step
    public void selectReason(String reason) {
        viewRequestPage.getApprovePopup().setReason(reason);
    }

    @Step
    public void selectDenyReason(String reason) {
        viewRequestPage.getDenyPopup().setReason(reason);
    }

    @Step
    public void clickApproveButtonInPopup() {
        viewRequestPage.getApprovePopup().clickApprove();
    }

    @Step
    public void clickDenyButtonInPopup() {
        viewRequestPage.getDenyPopup().clickDeny();
    }

    @Step
    public boolean isReviewersInfoPresent() {
        return viewRequestPage.isReviewersInfoPresent();
    }

 //latest
    @Step
    public void turnOnAuto(){approvalsConfigurationPage.turnOnAuto();}

    @Step
    public void clickOnHiddenButtonPendingApproval(){approvalsConfigurationPage.clickOnHiddenButtonWhenPendingApproval();}

    @Step
    public void clickOnHiddenButtonWhenPendingReview(){approvalsConfigurationPage.clickOnHiddenButtonWhenPendingReview();}

    @Step
    public void clickOnChangeStatusButton(String changeStatusButton){
        approvalsConfigurationPage.clickOnChangeStatusButton(changeStatusButton);}
    @Step
    public void clickOnVerifyPayment(){
        approvalsConfigurationPage.clickOnVerifyPayment();
    }

//adding duplicity in sp20
    @Step
    public void clickduplicityeditButton() {
        approvalsConfigurationPage.clickduplicityeditButton();
    }

    //sp21
    @Step
    public boolean VerifyFingerPrintButton(String button){
        return approvalsConfigurationPage.VerifyFingerPrintButton(button);
    }
    //sp22
    @Step
    public void clickIndividualProviders(String individualproviders){
        approvalsConfigurationPage.clickIndividualProviders(individualproviders);
    }
    @Step
    public void clickGroupProviders(String groupproviders){
        approvalsConfigurationPage.clickGroupProviders(groupproviders);
    }
    @Step
    public void clickPharmacyProviders(String pharmacyproviders){
        approvalsConfigurationPage.clickPharmacyProviders(pharmacyproviders);
    }
    //sp26
    @Step
    public void  clickProviderEnrollmentManger(String providerenrollmentmanger){
        approvalsConfigurationPage.clickProviderEnrollmentManger(providerenrollmentmanger);
    }
    @Step
    public void  clickManagedCareOrganisation(String mco){
        approvalsConfigurationPage.clickManagedCareOrganisation(mco);
    }
    //sp28
    @Step
    public void clickOrderingReferringProvider(String orderingreferringprovider){
        approvalsConfigurationPage.clickOrderingReferringProvider(orderingreferringprovider);
    }
    @Step
    public void clickFacilityProvider(String facilityprovider){
        approvalsConfigurationPage.clickFacilityProvider(facilityprovider);
    }
    //sp32
    @Step
    public void setEffectiveStartDate(String effectiveStartDate) {
        approvalsConfigurationPage.setEffectiveStartDate(effectiveStartDate);
    }
    @Step
    public void fillEffectiveDates(String dateStart,String dateEnd) {
        approvalsConfigurationPage.fillEffectiveDates(dateStart, dateEnd);
    }
    //sp33
    @Step
    public void fillEffectiveDatesAff(String dateEnd) {
        approvalsConfigurationPage.fillEffectiveDatesAff(dateEnd);
    }

    //sp35
    @Step
    public void clickOnOkButtonForFingerPrint() {
        approvalsConfigurationPage.clickOnOkButtonForFingerPrint();
    }

    //sp37
    @Step
    public void fillEffectiveDatesAff1(String dateStart,String dateEnd) {
        approvalsConfigurationPage.fillEffectiveDatesAff1(dateStart,dateEnd);
    }

    //sp37
    @Step
    public void clickOnPlusEnrollmentProviderButton(){
        approvalsConfigurationPage.clickOnPlusEnrollmentProviderButton();
    }

    //sp41.4
    @Step
    public void clickOnReEnrollmentButton(){approvalsConfigurationPage.clickOnReEnrollmentButton();}

    // sp68

    @Step
    public void clickTradingPartnerProvider(String tradingpartneryprovider){
        approvalsConfigurationPage.clickTradingPartnerProvider(tradingpartneryprovider);
    }

    //sd-04

    @Step
    public void turnOnNew() {
        approvalsConfigurationPage.turnOnNew();
    }

    @Step
    public void turnOffNew() {
        approvalsConfigurationPage.turnOffNew();
    }

    //SD-08

    @Step
    public String verifyEnrollmentRequestData(String field) {
        return approvalsConfigurationPage.verifyEnrollmentRequestData(field);
    }

    @Step
    public String verifyCocRequestDataInProviderCocTab(String field) {
        return approvalsConfigurationPage.verifyCocRequestDataInProviderCocTab(field);
    }
    @Step
    public String verifyCocProviderNameInProviderCocTab(String field) {
        return approvalsConfigurationPage.verifyCocProviderNameInProviderCocTab(field);
    }

    @Step
    public String verifyProviderModuleDataInternalUserTab(String field) {
        return approvalsConfigurationPage.verifyProviderModuleDataInternalUserTab(field);
    }

    // SD-10

    @Step
    public void  enableCocConfiguration(String button){
        approvalsConfigurationPage.enableCocConfiguration(button);
    }

    @Step
    public boolean verifyCocConfiguration(String button){
        return approvalsConfigurationPage.verifyCocConfiguration(button);
    }
    @Step
    public void toggleCocConfiguration(String button, boolean enable) {
        approvalsConfigurationPage.toggleCocConfiguration(button, enable);
    }
//SD-11

    @Step
    public String verifyProviderModuleDataProviderTab(String field) {
        return approvalsConfigurationPage.verifyProviderModuleDataProviderTab(field);
    }

    @Step
    public void addTransaction(String transactionType, String transactionValue){
        approvalsConfigurationPage.clickAddLine();
        approvalsConfigurationPage.setTransactionType(transactionType);
        approvalsConfigurationPage.setTransactionValue(transactionValue);
        approvalsConfigurationPage.clickAffiSaveButton();
    }


    @Step
    public void  enableReEnrollmentConfiguration(String button){
        approvalsConfigurationPage.enableReEnrollmentConfiguration(button);
    }

    @Step
    public boolean verifyReEnrollmentConfiguration(String button){
        return approvalsConfigurationPage.verifyReEnrollmentConfiguration(button);
    }

    @Step
    public boolean verifyDownloadExcelButton(){
        return approvalsConfigurationPage.verifyDownloadExcelButton();
    }

    @Step
    public void clickSitevisitSignIU() {
        approvalsConfigurationPage.clickSitevisitSignIU();
    }

    @Step
    public void clickSitevisitSignPE() {
        approvalsConfigurationPage.clickSitevisitSignPE();
    }

    @Step
    public boolean isAutoCheckboxSelected(String description){
        return approvalsConfigurationPage.isAutoCheckboxEnabled(description);
    }

    @Step
    public void clickAutoCheckbox(String description){
        approvalsConfigurationPage.clickAutoCheckbox(description);
    }

    @Step
    public void setAutoapproveSlider(){
        approvalsConfigurationPage.setAutoApproveSlider();
    }





    @Step
    public void turnOnAutoApprove() {
        approvalsConfigurationPage.turnOnAutoApprove();
    }

    @Step
    public void turnOffAutoApprove() {
        approvalsConfigurationPage.turnOffAutoApprove();
    }

    @Step
    public void turnOnAutoApproveTpPem() {
        approvalsConfigurationPage.turnOnAutoApproveTpPem();
    }

    @Step
    public void turnOffAutoApproveTpPem() {
        approvalsConfigurationPage.turnOffAutoApproveTpPem();
    }

    @Step
    public void turnOnAssigneeConfiguration() {
        approvalsConfigurationPage.turnOnAssigneeConfiguration();
    }

    @Step
    public void turnOffAssigneeConfiguration() {
        approvalsConfigurationPage.turnOffAssigneeConfiguration();
    }

    @Step
    public void turnOnCocScreening() {
        approvalsConfigurationPage.turnOnCocScreening();
    }

    @Step
    public void enableInstate() {
        approvalsConfigurationPage.enableInstate();
    }



    @Step
    public void enableOutstate() {
        approvalsConfigurationPage.enableOutstate();
    }



    @Step
    public void enableBothstate() {
        approvalsConfigurationPage.enableBothstate();
    }



    @Step
    public boolean isInstateEnabled() {
        return approvalsConfigurationPage.isInstateEnabled();
    }

    @Step
    public boolean isOutstateEnabled() {
        return approvalsConfigurationPage.isOutstateEnabled();
    }

    @Step
    public boolean isBothEnabled() {
        return approvalsConfigurationPage.isBothEnabled();
    }

}
