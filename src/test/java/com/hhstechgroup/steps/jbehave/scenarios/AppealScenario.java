package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.enrollment.EnrollmentCocSteps;
import com.hhstechgroup.steps.serenity.peportalpages.AppealSteps;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.core.Is;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.Map;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class AppealScenario {

    @Steps
    AppealSteps appealSteps;

    @Steps
    EnrollmentCocSteps enrollmentCocSteps;

    @When("click Appeal button on enrollment section")
    @Alias("click Appeal button")
    public void clickAppeal() {
        appealSteps.clickAppeal();
    }

    @When("click Appeal button on Appeal page")
    public void clickAppealFromAppeals() {
        appealSteps.clickAppealFromAppeals();
    }

    @When("click Appeal button for denied claim with request id - '$requestId'")
    public void clickAppealWithId(String requestId) {
        appealSteps.clickAppealWithId(requestId);
    }

    @When("click Appeal button on claim section")
    public void clickAppealClaim() {
        appealSteps.clickAppealClaim();
    }

    @When("{fill|edit} Appeal application with: $table")
    public void fillAppeal(ExamplesTable table) {
        Map<String, String> appealInfo = table.getRow(0);
        Optional.ofNullable(appealInfo.get("reason")).ifPresent(reason -> appealSteps.setAppealReason(reason));
        Optional.ofNullable(appealInfo.get("firstName")).ifPresent(firstName -> appealSteps.setAppealFirstName(firstName));
        Optional.ofNullable(appealInfo.get("lastName")).ifPresent(lastName -> appealSteps.setAppealLastName(lastName));
    }

    @When("upload Appeal document $path")
    public void uploadAppealDoc(String path) {
        appealSteps.uploadAppealDoc(path);
    }

    @When("sign Appeal application")
    public void signAppeal() {
        appealSteps.signAppeal();
    }

    @When("wait for Appeal button presence")
    public void isAppealButtonPresent() {
        appealSteps.isAppealButtonPresent();
    }

    @When("wait for Appeal presence")
    public void waitForAppealPanel() {
        appealSteps.waitForAppealPanel();
    }

    @When("submit Appeal application")
    public void submitAppeal() {
        appealSteps.submitAppeal();
    }

    @When("verify upload button is present")
    public void isUploadButtonPresent() {
        assertTrue(appealSteps.isUploadButtonPresent());
    }

    @When("click Go to Appeals")
    public void goToAppeals() {
        appealSteps.goToAppeals();
    }

    @When("edit Appeal field $field")
    public void editField(String field) {
        appealSteps.editAppealField(field);
    }

    @Then("success message with text - $text should be displayed")
    public void isMessageDisplayed(String text) {
        assertEquals(text, appealSteps.getSuccessMessage());
    }

    @Then("next information should be displayed in Appeal request form: $table")
    public void isAppealInfoCorrect(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(appealSteps.getAppealInfo(), is(expectedInfo));
    }

    @When("click Continue button for appeals request")
    public void clickContinueButton() {
        appealSteps.continueAppealRequest();
    }

    @Then("document $document should be uploaded")
    public void chechAppealDocumentUploaded(String document) {
        assertTrue(appealSteps.isAppealDocUploaded(document));
    }

    @Then("Appeal application should have next information: $table")
    public void checkAppealInformation(ExamplesTable table) {
        Map<String, String> expectedFields = table.getRows().get(0);
        assertEquals(expectedFields, appealSteps.getFieldsValues(table.getHeaders()));
    }

    //temporary method; can be removed when PRMG-3280 is fixed
    @Then("claim appeal application should be displayed")
    public void isAppealFormPresent() {
        appealSteps.isAppealFormPresent();
    }

    @When("create Appeal for claim with request id - '$requestId'")
    public void createAppealForId(String id) {
        appealSteps.createAppealForId(id);
    }

    @Then("next application information should be displayed in appeal details for IU: $table")
    public void checkAppealInformationIU(ExamplesTable table) {
        Map<String, String> expectedFields = table.getRows().get(0);
        assertEquals(expectedFields, appealSteps.getAppFieldsValues(table.getHeaders()));
    }

    @When("click on appeal with '$appealId'")
    public void clickAppealDetails(String appealId) {
        appealSteps.appealDetailsById(appealId);
    }

    @Then("main appeal information is displayed: $table")
    public void checkAppealMainInfo(ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), appealSteps.getAppealMainInfo());
    }

    @Then("appeal to request in application section details for IU should have next information: $table")
    public void checkAppDetailsIU(ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), appealSteps.getAppealAppTabInfoIU());
    }

    @Then("hearing container # '$blockNumber' is displayed: $table")
    public void checkHearingInfo(ExamplesTable table, String blockNumber) {
        assertReflectionEquals(table.getRow(0), appealSteps.getAppealHearingInfo(blockNumber));
    }

    @When("click on '$appTab' in appeal details")
    public void clickAppTabInAppealDetails(String appTab) {
        appealSteps.appTabInAppealDetails(appTab);
    }

    @Then("document '$document' should be uploaded to '$field' on Files and documents section in appeal details")
    public void isDocumentPresent(String document, String field) {
        assertTrue(appealSteps.isDocumentPresent(document, field));
    }

    //newly added
    @Then("Validating appeal details: $table")
    public void checkCocValuesForRecordWithNumber(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(enrollmentCocSteps.getMappedCocValuesForRecord(), Is.is(expectedInfo));
    }

    @Then("Validating appeal details with denied status: $table")
    public void checkCocValuesForRecordWithNumber1(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(enrollmentCocSteps.getMappedCocValuesForRecord1(), Is.is(expectedInfo));
    }

    //wyomi WY-63 updating appeal
    @When("{fill|edit} new Appeal application with: $table")
    public void fillAppeal1(ExamplesTable table) {
        Map<String, String> appealInfo = table.getRow(0);
        Optional.ofNullable(appealInfo.get("reason")).ifPresent(reason -> appealSteps.setAppealReason1(reason));
        Optional.ofNullable(appealInfo.get("firstName")).ifPresent(firstName -> appealSteps.setAppealFirstName1(firstName));
        Optional.ofNullable(appealInfo.get("lastName")).ifPresent(lastName -> appealSteps.setAppealLastName1(lastName));
    }

    @When("upload new Appeal document $path")
    public void uploadAppealDoc1(String path) {
        appealSteps.uploadAppealDoc1(path);
    }

    @When("sign new Appeal application")
    public void signAppeal1() {
        appealSteps.signAppeal1();
    }

}