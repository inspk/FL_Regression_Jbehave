package com.hhstechgroup.steps.serenity.enrollment;

import com.hhstechgroup.ui.pages.iuportal.EnrollmentCocPage;
import com.hhstechgroup.ui.pages.iuportal.ViewRequestPage;
import com.hhstechgroup.util.common.FileUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;
import java.util.Map;

public class EnrollmentCocSteps extends ScenarioSteps {

    EnrollmentCocPage enrollmentCocPage;
    ViewRequestPage viewRequestPage;



    @Step
    public void clickSearchLink() {
        enrollmentCocPage.clickOnSearchLink();

    }
    @Step
    public void setRequestId(String requestId) {
        enrollmentCocPage.getSearchPanel().setRequestId(requestId);
    }

    @Step
    public void setProviderIdOrName(String providserIdOrName) {
        enrollmentCocPage.getSearchPanel().setProviderIDorName(providserIdOrName);
    }


    @Step
    public String  getRequestIdByName(String providerIdOrName,String status, int delay) {
        String requestId = enrollmentCocPage.getSearchPanel().getRequestIdByProviderName(providerIdOrName,status, delay);
        waitABit(500);
        System.out.println("Request id " + requestId);
        waitABit(500);
        return requestId;
    }

    @Step
    public String  getRequestIdByTrackingNum(String status, int delay) {
        String requestId = enrollmentCocPage.getSearchPanel().getRequestIdByTrackingNum(status, delay);
        waitABit(500);
        System.out.println("Request id " + requestId);
        waitABit(500);
        return requestId;
    }

    @Step
    public boolean  ifStatusDisplayedByName(String providerIdOrName,String status, int delay) {
      return enrollmentCocPage.getSearchPanel().getStatusEnrollmentByName(providerIdOrName, status,delay);
    }

    @Step
    public void clickSearch() {
        waitABit(5000);
        enrollmentCocPage.getSearchPanel().clickSearch();
        waitABit(2000);
        enrollmentCocPage.waitForSpinnerToDisappear();
    }

    @Step
    public boolean isRequestFound(String requestId) { waitABit(2000);
        return enrollmentCocPage.getRequestsPanel().isRequestFound(requestId);
    }

    @Step
    public List<Map<String, String>> getRequestDetails() {
        return enrollmentCocPage.getRequestsPanel().getListOfMappedValues();
    }

    @Step
    public List<Map<String, String>> getCocAffiliationDetails() {
        return enrollmentCocPage.getRequestsPanel().getListOfMappedValuesInCoCDetails();
    }

    @Step
    public void selectRequestAction(String id, String action) {
        enrollmentCocPage.getRequestsPanel().getRequestById(id).selectAction(action);
    }

    @Step
    public void setSearchForAssignee(String searchCriteria) {
        enrollmentCocPage.getChangeAssigneeModal().setSearchInput(searchCriteria);
    }

    @Step
    public void clickSearchForAssignee() {
        enrollmentCocPage.getChangeAssigneeModal().clickSearch();
    }

    @Step
    public void selectAssignee(String assignee) {
        enrollmentCocPage.getChangeAssigneeModal().selectAssignee(assignee);
    }

    @Step
    public void clickApplyAssignee() {
        enrollmentCocPage.getChangeAssigneeModal().clickApply();
    }

    @Step
    public void moveToSection(String section) {
        viewRequestPage.clickOnSection(section);
    }

    @Step
    public boolean isDocumentPresent(String field, String documentName) {
        return viewRequestPage.getFilesDocumentsPanel().isDocumentPresent(field, documentName);
    }

    @Step
    public void clickChangeStatus() {
        viewRequestPage.getEnrollmentCardPanel().clickOnButton();
    }

    @Step
    public void setStatus(String status) {
        setStatus(status, null);
    }

    @Step
    public void setStatus(String status, String reason) {
        viewRequestPage.getChangeStatusPopUp().setStatus(status);
        if (reason != null) {
            enrollmentCocPage.getChangeStatusPopUp().setReason(reason);
        }
        enrollmentCocPage.getChangeStatusPopUp().fillInNewApprovalForm();
        viewRequestPage.getChangeStatusPopUp().clickApply();
    }

    //new
    @Step
    public void setStatus1(String status, String reason,String date) {
        viewRequestPage.getChangeStatusPopUp().setStatus(status);
        if (reason != null) {
            enrollmentCocPage.getChangeStatusPopUp().setReason1(reason);
            enrollmentCocPage.getChangeStatusPopUp().setEffectiveDate(date);
        }
        viewRequestPage.getChangeStatusPopUp().clickApply();
    }

    @Step
    public void setStatus2(String status, String reason,String date) {
        viewRequestPage.getChangeStatusPopUp().setStatus(status);
        viewRequestPage.getChangeStatusPopUp().setEffectiveDate(date);
        if (reason != null) {
            enrollmentCocPage.getChangeStatusPopUp().setReason1(reason);
        }
        viewRequestPage.getChangeStatusPopUp().clickApply();
    }
    @Step
    public void setPaymentReceived(String option, String date, String  note){
    }

    @Step
    public void clickOnActionLink(String id, String linkText) {
        enrollmentCocPage.getRequestsPanel().getRequestById(id).clickOnActionLink(linkText);
    }

    @Step
    public boolean isChangeStatusPopUpOpened() {
        return enrollmentCocPage.isChangeStatusPopUpOpened();
    }

    @Step
    public void closeActionsPopUp(String id) {
        enrollmentCocPage.getRequestsPanel().getRequestById(id).closeActionsPopUp();
    }

    @Step
    public Map<String, String> getRequestInformation() {
        return viewRequestPage.getEnrollmentCardPanel().getMappedValues();
    }

    @Step
    public void clickDownloadDocument(String field, String documentName) {
        viewRequestPage.getFilesDocumentsPanel().clickDownloadButton(field, documentName);
    }

    @Step
    public String getDownloadDocumentUrl(String field, String documentName) {
        return viewRequestPage.getFilesDocumentsPanel().getDownloadUrl(field, documentName);
    }

    @Step
    public String getDownloadPageUrl() {
        return viewRequestPage.getFilesDocumentsPanel().getDownloadPageUrl();
    }

    @Step
    public boolean isPrintDocumentButtonPresent(String field, String documentName) {
        return viewRequestPage.getFilesDocumentsPanel().isPrintButtonPresent(field, documentName);
    }

    @Step
    public void clickAddFile() {
        viewRequestPage.getFilesDocumentsPanel().clickAddFileButton();
    }

    @Step
    public void setUploadSection(String section) {
        viewRequestPage.getAddFilePopUp().setSection(section);
    }

    @Step
    public void setUploadField(String field) {
        viewRequestPage.getAddFilePopUp().setField(field);
    }

    @Step
    public boolean isUploadFieldPresent() {
        return viewRequestPage.getAddFilePopUp().isSelectFieldFieldPresent();
    }

    @Step
    public String getUploadPopUpTitle() {
        return viewRequestPage.getAddFilePopUp().getTitle();
    }

    @Step
    public String getUploadSection() {
        return viewRequestPage.getAddFilePopUp().getSectionName();
    }

    @Step
    public String getUploadSectionDescription() {
        return viewRequestPage.getAddFilePopUp().getSectionDescription();
    }

    @Step
    public void uploadAttachment(String path) {
        viewRequestPage.getAddFilePopUp().uploadAttachment(FileUtils.getAbsolutePath(path));
    }

    @Step
    public boolean isFileDisplayedInPopUp(String fileName) {
        return viewRequestPage.getAddFilePopUp().isDocumentUploaded(fileName);
    }

    @Step
    public void closeUploadPopUp() {
        viewRequestPage.getAddFilePopUp().clickClose();
    }

    @Step
    public void addComment(String comment) {
        viewRequestPage.getAddFilePopUp().addComment(comment);
    }

    @Step
    public void clickAddFileOnPopUp() {
        viewRequestPage.getAddFilePopUp().clickAddFile();
    }

    @Step
    public void clickUpdateDocument(String field, String documentName) {
        viewRequestPage.getFilesDocumentsPanel().clickUpdateButton(field, documentName);
    }

    @Step
    public String getCommentText(String section, String document) {
        return viewRequestPage.getFilesDocumentsPanel().getCommentTextInDocument(section, document);
    }

    @Step
    public void clickUpdateFileOnPopUp() { viewRequestPage.getAddFilePopUp().clickUpdateFileButton();
    }

    @Step
    public void clickViewOutdatedVersionDocument(String type) {
        viewRequestPage.getFilesDocumentsPanel().clickViewOutdatedVersionByType(type);
    }

    @Step
    public void selectAppealOption(String action) {
        enrollmentCocPage.selectAppealOption(action);
    }

    //newly adding
    @Step
    public Map<String, String> getMappedCocValuesForRecord() {
        return enrollmentCocPage.getproviderCocPanel().getMappedCocValuesForRecord();
    }

    @Step
    public Map<String, String> getMappedCocValuesForRecord1() {
        return enrollmentCocPage.getproviderCocPanel().getMappedCocValuesForRecord1();
    }

    //duplicity

    @Step
    public boolean  ifStatusDisplayedByName(String status, int delay) {
        return enrollmentCocPage.getSearchPanel().getStatusProvider(status,delay);
    }

    @Step
    public void clickButtonMore() {
        enrollmentCocPage.getSearchPanel().clickMoreButton();
    }

    //sp30
    @Step
    public boolean verifyDownloadButtonDisplaying() {
        return enrollmentCocPage.verifyDownloadButtonDisplaying();
    }
    @Step
    public void clickDownloadButton(){
        enrollmentCocPage.clickDownloadButton();
    }
    //sp32
    @Step
    public void setDocumentReviewStatus(String status) {
        viewRequestPage.getChangeStatusPopUp().setDocumentReviewStatus(status);
        viewRequestPage.getChangeStatusPopUp().clickApply();
    }
    @Step
    public void clicksearch(String documentname){
        viewRequestPage.getFilesDocumentsPanel().clicksearch(documentname);
    }
    @Step
    public  void clickfilters() {
        viewRequestPage.getFilesDocumentsPanel().clickfilters();
    }

    //sp 34
    @Step
    public void setStatusNew(String status, String reason) {
        viewRequestPage.getChangeStatusPopUp().setStatus(status);
        if (reason != null) {
            enrollmentCocPage.getChangeStatusPopUp().setReason1(reason);
        }
        viewRequestPage.getChangeStatusPopUp().clickApply();
    }

    //sp60 adding new filed original status in appeal
    @Step
    public void setOriginalStatus(String status, String reason , String originalStatus) {
        viewRequestPage.getChangeStatusPopUp().setStatus(status);
        viewRequestPage.getChangeStatusPopUp().setOriginalStatus(originalStatus);
        if (reason != null) {
            enrollmentCocPage.getChangeStatusPopUp().setReason1(reason);
        }
        viewRequestPage.getChangeStatusPopUp().clickApply();
    }

    //sp 37
    @Step
    public void setStatus3(String status, String reason,String date) {
        viewRequestPage.getChangeStatusPopUp().setStatus(status);
        viewRequestPage.getChangeStatusPopUp().clickYesInRetroApprovalButton();
        if (reason != null) {
            enrollmentCocPage.getChangeStatusPopUp().setReason1(reason);
            enrollmentCocPage.getChangeStatusPopUp().setEffectiveDate(date);
        }
       // viewRequestPage.getChangeStatusPopUp().clickApply();
    }

    //sp57

    @Step
    public void setDocumentReviewStatus1(String status) {
        viewRequestPage.getChangeStatusPopUp().setDocumentReviewStatus1(status);
    }

    //SD-04
    @Step
    public void setDocumentReviewStatus2(String status) {
        viewRequestPage.getChangeStatusPopUp().setDocumentReviewStatus2(status);
        viewRequestPage.getChangeStatusPopUp().clickApply();
    }
    @Step
    public void setTerminationApprove(String status){
        viewRequestPage.getChangeStatusPopUp().setTerminationApprove(status);
    }

    @Step
    public void setStatus3(String status, String reason,String date,String text) {
        viewRequestPage.getChangeStatusPopUp().setStatus(status);
        viewRequestPage.getChangeStatusPopUp().setEffectiveDate(date);
        if (reason != null) {
            enrollmentCocPage.getChangeStatusPopUp().setReason1(reason);
        }
        viewRequestPage.getChangeStatusPopUp().isNotesToProviderIsDisplaying(text);
        viewRequestPage.getChangeStatusPopUp().clickApply();
    }

    @Step
    public void approveWithPastOrFutureDate(String status,String popup, String reason,String date) {
        viewRequestPage.getChangeStatusPopUp().setStatus(status);
        viewRequestPage.getChangeStatusPopUp().futureApprovePopup(popup);
        viewRequestPage.getChangeStatusPopUp().setEffectiveDate(date);
        enrollmentCocPage.getChangeStatusPopUp().setReason1(reason);
        viewRequestPage.getChangeStatusPopUp().clickApply();
    }

    @Step
    public void setTPStatus(String status, String reason,String id, String date) {
        viewRequestPage.getChangeStatusPopUp().setStatus(status);
        viewRequestPage.getChangeStatusPopUp().setEffectiveDate(date);
        viewRequestPage.getChangeStatusPopUp().setTpAgentid(id);
        enrollmentCocPage.getChangeStatusPopUp().setReason1(reason);
        viewRequestPage.getChangeStatusPopUp().clickApply();
    }


    @Step
    public void setRequestAdditionalInformationStatus(String status){
        viewRequestPage.getChangeStatusPopUp().setRequestAdditionalInformationStatus(status);

    }

    @Step
    public void setClearingHouseCheck(String status){
        viewRequestPage.getChangeStatusPopUp().setClearingHouseCheck(status);
    }



}
