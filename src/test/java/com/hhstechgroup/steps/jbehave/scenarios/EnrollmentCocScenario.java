package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.enrollment.EnrollmentCocSteps;
import com.hhstechgroup.util.common.ExternalEmails;
import com.hhstechgroup.util.converters.DateConverter;
import com.hhstechgroup.util.properties.ProviderProperties;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.core.StringContains;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.unitils.reflectionassert.ReflectionComparatorMode;
import org.yecht.Data;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class EnrollmentCocScenario {

    @Steps
    EnrollmentCocSteps enrollmentCocSteps;

    @When("wait for screening process execution during '$sec' seconds")
    public void waitForScreeningProcess(long time){
            try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("implicit wait '$sec' seconds")
    public void implicitWait(long time){
            try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("click search link on iu appeals page")
    public void clickSearchLink() {
        enrollmentCocSteps.clickSearchLink();
    }

    @When("search for {coc|enrollment|site visit|appeal} request by request id $id")
    public void searchByRequestId(String id) {
        enrollmentCocSteps.setRequestId(id);
        enrollmentCocSteps.clickSearch();
    }

    @When("get request id '$variable' from file")
    public void getRequestIdFromFile(String variable) {
       ProviderProperties.getData("requestId");

    }

    @When("search provider by name $idName")
    public void searchByRequestNameOrId(String name) {
        enrollmentCocSteps.setProviderIdOrName(name);
        enrollmentCocSteps.clickSearch();
    }

    @When("select '$action' action for request '$id'")
    public void selectAction(String action, String id) {
        enrollmentCocSteps.selectRequestAction(id, action);
    }

    @When("select assignee - '$name'")
    public void selectAssignee(String name) {
        enrollmentCocSteps.setSearchForAssignee(name);
        enrollmentCocSteps.clickSearchForAssignee();
        enrollmentCocSteps.selectAssignee(name);
        enrollmentCocSteps.clickApplyAssignee();
    }

    @When("navigate to $section section")
    public void navigateToSection(String section) {
        enrollmentCocSteps.moveToSection(section);
    }

    @When("click Change status for {coc|enrollment} request")
    public void changeStatus() {
        enrollmentCocSteps.clickChangeStatus();
    }

    @When("set {appeal|coc|enrollment} request status to - $status")
    public void setEnrollmentStatus(String status) {
        enrollmentCocSteps.setStatus(status);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));

    }
    @When("set {appeal|coc|enrollment} request status - '$status' with reason - '$reason'")
    public void setStatusWithReason(String status, String reason) {
        enrollmentCocSteps.setStatus(status, reason);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

    @When("set to the  {appeal|coc|enrollment} request status - '$status' with reason - '$reason' and set the '$date'")
    public void setStatusWithReason1(String status, String reason,String date) {
        enrollmentCocSteps.setStatus1(status, reason, date);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

    @When("set to the status for {appeal|coc|enrollment} request status - '$status' and set date '$date' and set agentId '$agentId' with reason - '$reason'")
    public void setTPStatus(String status, String reason,String id, String date) {
        enrollmentCocSteps.setTPStatus(status, reason, id, date);
    }

    @When("set to the status for {appeal|coc|enrollment} request status - '$status' and set the '$date' with reason - '$reason'")
    public void setStatusWithReason2(String status, String reason,String date) {
        enrollmentCocSteps.setStatus2(status, reason, date);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }
    @When("set '$option' option and set the '$date with note-'note'")
    public void setPaymentReceived(String option, String date, String note){
        enrollmentCocSteps.setPaymentReceived(option, date, note);

    }

    @When("click on {coc|enrollment} request $request {status|assignee} - $link")
    public void clickOnLink(String id, String link) {
        enrollmentCocSteps.clickOnActionLink(id, link);
    }

    @When("close actions pop-up for {coc|enrollment} request $request")
    public void closeActionsPopUp(String id) {
        enrollmentCocSteps.closeActionsPopUp(id);
    }

    @When("click download document $document in '$section' section")
    public void clickDownloadDocument(String document, String section) {
        enrollmentCocSteps.clickDownloadDocument(document, section);
    }

    @When("click Add File button on Files and Documents tab")
    public void addFile() {
        enrollmentCocSteps.clickAddFile();
    }

    @When("select section - $section")
    public void selectSection(String section) {
        enrollmentCocSteps.setUploadSection(section);
    }

    @When("select field - $field")
    public void selectField(String field) {
        enrollmentCocSteps.setUploadField(field);
    }

    @When("upload file $path in Files and documents section")
    public void uploadFile(String path) {
        enrollmentCocSteps.uploadAttachment(path);
    }

    @When("close add file pop-up")
    public void closeAddFilePopUp() {
        enrollmentCocSteps.closeUploadPopUp();
    }

    @When("add comment to file - '$comment'")
    public void addComment(String comment) {
        enrollmentCocSteps.addComment(comment);
    }

    @When("click Add File button in add file popup")
    public void clickAddFielOnPopUp() {
        enrollmentCocSteps.clickAddFileOnPopUp();
    }

    @Then("request with id '$id' should be found")
    public void isRequestFound(String id) {
        assertTrue(enrollmentCocSteps.isRequestFound(id));
    }

    @Then("request should contain next details: $table")
    public void checkRequestDetails(ExamplesTable table) {
        assertReflectionEquals(table.getRows(), enrollmentCocSteps.getRequestDetails(),ReflectionComparatorMode.LENIENT_ORDER);
    }
    @Then("coc request should contain next affiliation details: $table")
    public void checkCocAffiliationDetails(ExamplesTable table) {
        assertReflectionEquals(table.getRows(), enrollmentCocSteps.getCocAffiliationDetails());
    }

    @Then("document $document should be uploaded to '$field' on Files and documents section")
    public void isDocumentPresent(String document, String field) {
        System.out.println(enrollmentCocSteps.isDocumentPresent(document, field));
        assertTrue(enrollmentCocSteps.isDocumentPresent(document, field));
    }

    @Then("Change status pop-up should not be displayed")
    public void isChangeStatusPopUpAbsent() {
        assertFalse("Change status pop-up should not be displayed", enrollmentCocSteps.isChangeStatusPopUpOpened());
    }

    @Then("request should contain next information in details page: $table")
    public void checkRequestInfo(ExamplesTable table) {
        assertEquals(table.getRows().get(0), enrollmentCocSteps.getRequestInformation());
    }

    @Then("new tab with url '$url' should be opened")
    public void checkDownloadUrl(String url) {
        assertThat(enrollmentCocSteps.getDownloadPageUrl(), StringContains.containsString(url));
    }

    @Then("print document button should be displayed for document $document in '$section' section")
    public void isPrintButtonDisplayed(String document, String section) {
        assertTrue(enrollmentCocSteps.isPrintDocumentButtonPresent(document, section));
    }

    @Then("add file pop-up should appear with title - $title")
    public void isAddFilePopUpDisplayed(String title) {
        assertEquals(title, enrollmentCocSteps.getUploadPopUpTitle());
    }

    @Then("Select Field field should be absent in add file pop-up")
    public void isSelectFieldAbsent() {
        assertFalse(enrollmentCocSteps.isUploadFieldPresent());
    }

    @Then("Select Field field should be present in add file pop-up")
    public void isSelectFieldPresent() {
        assertTrue(enrollmentCocSteps.isUploadFieldPresent());
    }

    @Then("section name - '$section' should be present in add file popup")
    public void checkUploadSection(String sectionName) {
        assertEquals(sectionName, enrollmentCocSteps.getUploadSection());
    }

    @Then("'$file' file should be present in add file popup")
    public void isFilePresent(String fileName) {
        assertTrue(enrollmentCocSteps.isFileDisplayedInPopUp(fileName));
    }

    @When("click update document $document in '$section' section")
    public void clickUpdateDocument(String document, String section) {
        enrollmentCocSteps.clickUpdateDocument(document, section);
    }
    @When("click view outdated version in '$section' section")
    public void clickViewOutdatedVersionDocument(String section) {
        enrollmentCocSteps.clickViewOutdatedVersionDocument(section);
    }
    @When("click Update File button on Files and Documents tab")
    public void updateFile() {
        enrollmentCocSteps.clickUpdateFileOnPopUp();
    }
    @Then("comment '$text' at '$section' section under file name '$document' should be present")
    public void checkComment(String text, String section, String document) {
        assertEquals(text, enrollmentCocSteps.getCommentText(section, document));
    }

    @When("select the '$option' in the action menu")
    public void selectAppealOption(String action){
        enrollmentCocSteps.selectAppealOption(action);
    }
    //sp30
    @Then("verify the 'Download' button is displaying")
    public void verifyDeleteIconisDisplaying() {
        System.out.println("Download Button is Displaying");
        assertTrue(enrollmentCocSteps.verifyDownloadButtonDisplaying());
    }
    @Then("click on the 'Download' button")
    public void clickDownloadButton(){
        enrollmentCocSteps.clickDownloadButton();
    }

    //sp32
    @When("set {appeal|coc|enrollment} request document status to - $status")
    public void setDocumentReviewStatus(String status) {
        enrollmentCocSteps.setDocumentReviewStatus(status);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }
    @Then("click on the search document '$document'")
    public void clicksearch(String documentname){
        enrollmentCocSteps.clicksearch(documentname);
    }
    @Then("click on the 'filters' in the files and documents page")
    public  void clickfilters() {
        enrollmentCocSteps.clickfilters();
    }

    //sp34
    @When("set to the status for {appeal|coc|enrollment} request status - '$status' and reason - '$reason'")
    public void setStatusWithReasonNew(String status, String reason) {
        enrollmentCocSteps.setStatusNew(status, reason);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }
    //sp60 adding new filed original status in appeal

    @When("set to the original status for {appeal|coc|enrollment} request status - '$status' and reason - '$reason' with status - '$originalStatus'")
    public void setOriginalStatus(String status, String reason , String originalStatus) {
        enrollmentCocSteps.setOriginalStatus(status, reason , originalStatus);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

    //sp37
    @When("set to the  retroactive approval for {appeal|coc|enrollment} request status - '$status' with reason - '$reason' and set the '$date'")
    public void setStatusWithReason3(String status, String reason,String date) {
        enrollmentCocSteps.setStatus3(status, reason, date);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

    //sp57
    @When("set {appeal|coc|enrollment} request ready for screening status to - $status")
    public void setDocumentReviewStatus1(String status) {
        enrollmentCocSteps.setDocumentReviewStatus1(status);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

    @When("set termination request New status to - $status")
    public void setTerminationApprove(String status){
        enrollmentCocSteps.setTerminationApprove(status);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }
    //SD-04

    @When("set {appeal|coc|enrollment} request New status to - $status")
    public void setDocumentReviewStatus2(String status) {
        enrollmentCocSteps.setDocumentReviewStatus2(status);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }


    @When("set to the status for {appeal|coc|enrollment} request status - '$status' and set the '$date' with reason - '$reason' and see '$text' is displaying")
    public void setStatusWithReason3(String status, String reason,String date, String text) {
        enrollmentCocSteps.setStatus3(status, reason, date,text);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

    @When("set Approved status for {appeal|coc|enrollment} request status - '$status' and popup - '$popup' and date '$date' with reason - '$reason'")
    public void approveWithPastOrFutureDate(String status, String popup, String reason,String date) {
        enrollmentCocSteps.approveWithPastOrFutureDate(status, popup, reason, date);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

    @When("set {appeal|coc|enrollment} request from document review status to - $status")
    public void setRequestAdditionalInformationStatus(String status) {
        enrollmentCocSteps.setRequestAdditionalInformationStatus(status);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

    @When("set {appeal|coc|enrollment} request Under Clearing House Check status to - $status")
    public void setClearingHouseCheck(String status){
        enrollmentCocSteps.setClearingHouseCheck(status);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

}
