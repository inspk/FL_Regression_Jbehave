package com.hhstechgroup.steps.jbehave.scenarios.IUFlowScenarios;

import com.hhstechgroup.steps.serenity.IUFlowSteps.CredentialingSteps;
import com.hhstechgroup.steps.serenity.providerData.ProviderDataSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class CredentialingScenario {

    @Steps
    CredentialingSteps credentialingSteps;
    @Steps
    ProviderDataSteps providerDataSteps;

    @Given("user is on credentialing page")
    public void userIsOnCredentialingPage() {
        // This step assumes user is already logged in and on credentialing page
        // Additional navigation logic can be added if needed
    }

    @When("user clicks on Add Credentialing button")
    public void userClicksOnAddCredentialingButton() {
        credentialingSteps.clickAddCredentialing();
    }

    @When("user searches for provider by NPI '$npi'")
    public void userSearchesForProviderByNPI(String npi) {
        credentialingSteps.searchWithNPI(npi);
    }

    @When("user clicks on NPI search button")
    public void userClicksOnNPISearchButton() {
        credentialingSteps.clickNPISearchButton();
    }

    @When("user clicks on Create button")
    public void userClicksOnCreateButton() {
        credentialingSteps.clickCreateButton();
    }

    @When("user fills credentialing information with radio button value '$radioButtonValue'")
    public void userFillsCredentialingInformation(String radioButtonValue) {
        credentialingSteps.fillCredentialingInformation(radioButtonValue);
    }

    @When("user performs Co Review and Medical Director actions for NPI '$npi'")
    public void userPerformsCoReviewAndMedicalDirectorActions(String npi) {
        credentialingSteps.performCoReviewAndMedicalDirectorActions(npi);
    }

    @When("user assigns credentialing to CVO Medical Director for Enrollment '$enrolltype'")
    public void userAssignsCredentialingToCVOMedicalDirector(String enrolltype) {
        credentialingSteps.assignToCVOMedicalDirector(enrolltype);
    }

    @When("user changes status to FLAG TO CVO MEDICAL DIRECTOR in auto credentialing for enrolltype '$enrolltype'")
    public void assignToCVOMedicalDirector_AutoCredentialing(String enrolltype){
        credentialingSteps.assignToCVOMedicalDirector_AutoCredentialing(enrolltype);
    }

    @When("user saves credentialing request ID")
    public void userSavesCredentialingRequestId() {
        credentialingSteps.saveCredentialingRequestId();
    }

    @When("user approves credentialing as CVO Medical Director")
    public void userApprovesCredentialingAsCVOMedicalDirector() {
        String requestId = credentialingSteps.getSavedCredentialingRequestId();
        credentialingSteps.approveCredentialingCVOMedicalDirector(requestId);
    }

    @When("user approves credentialing as CVO Medical Director for request ID '$requestId'")
    public void userApprovesCredentialingAsCVOMedicalDirectorWithRequestId(String requestId) {
        credentialingSteps.approveCredentialingCVOMedicalDirector(requestId);
    }

    @Then("credentialing should be completed successfully")
    public void credentialingShouldBeCompletedSuccessfully() {
        credentialingSteps.verifyCredentialingCompletedSuccessfully();
    }

    @Then("credentialing request ID should be saved")
    public void credentialingRequestIdShouldBeSaved() {
        String requestId = credentialingSteps.getSavedCredentialingRequestId();
        org.junit.Assert.assertNotNull("Credentialing request ID should be saved", requestId);
        org.junit.Assert.assertFalse("Credentialing request ID should not be empty", requestId.isEmpty());
    }

    @When("user clicks on Credentialing Details section")
    public void userClicksOnCredentialingDetailsSection() {
        credentialingSteps.clickSectionCredentialingDetails();
    }

    @When("user clicks on Upload Credentialing Documents section")
    public void userClicksOnUploadCredentialingDocumentsSection() {
        credentialingSteps.clickSectionUploadCredentialingDocuments();
    }

    @When("user clicks on Go to Credentialing link")
    public void userClicksOnGoToCredentialingLink() {
        credentialingSteps.clickLinkCredentialing();
    }

    @Then("verify Credentialing toggle in SystemOption")
    public void verifyCredentialingToggleSystemoption(){
        credentialingSteps.verifyCredentailingToggleSystemOption();
    }

    @When("user searches for credentialing by NPI '$npi'")
    public void userSearchesForCredentialingByNPI(String npi) {
        credentialingSteps.searchNPICredentialing(npi);
    }

    @When("user clicks on Search button in credentialing")
    public void userClicksOnSearchButtonInCredentialing() {
        credentialingSteps.clickSearchButtonCredentialing();
    }

    @When("user clicks on NEW entry")
    public void userClicksOnNewEntry() {
        credentialingSteps.clickOnNew();
    }

    @When("user clicks on Unassigned")
    public void userClicksOnUnassigned() {
        credentialingSteps.clickOnUnassigned();
    }

    @When("user selects CVO Review Committee")
    public void userSelectsCVOReviewCommittee() {
        credentialingSteps.selectCVOReviewCommittee();
    }

    @When("user clicks on Assign button")
    public void userClicksOnAssignButton() {
        credentialingSteps.clickOnAssign();
    }

    @When("user clicks on Credentialing tab")
    public void userClicksOnCredentialingTab() {
        credentialingSteps.clickCredentialing();
    }

    @When("user clicks on Assignee")
    public void userClicksOnAssignee() {
        credentialingSteps.clickAssignee();
    }

    @When("user clicks on CVO Medical Director")
    public void userClicksOnCVOMedicalDirector() {
        credentialingSteps.clickCVOMedicalDirector();
    }

    @When("user clicks on Assign button for CVO RC")
    public void userClicksOnAssignButtonForCVORC() {
        credentialingSteps.clickAssignButtonCVORC();
    }

    @When("user searches for request ID '$requestId'")
    public void userSearchesForRequestId(String requestId) {
        credentialingSteps.searchRequestId(requestId);
    }

    @When("user clicks on Search button")
    public void userClicksOnSearchButton() {
        credentialingSteps.clickSearchButton();
    }

    @When("user clicks on Change Status button")
    public void userClicksOnChangeStatusButton() {
        credentialingSteps.clickOnChangeStatus();
    }

    @When("user clicks on Flag to Medical Director")
    public void userClicksOnFlagToMedicalDirector() {
        credentialingSteps.clickFlagToMedicalDirector();
    }

    @When("user clicks on Change Status dropdown")
    public void userClicksOnChangeStatusDropdown() {
        credentialingSteps.clickChangeStatusDropdown();
    }

    @When("user clicks on Reason dropdown")
    public void userClicksOnReasonDropdown() {
        credentialingSteps.clickOnReason();
        credentialingSteps.clickReasonDropdown();
    }

    @When("user clicks on Result dropdown")
    public void userClicksOnResultDropdown() {
        credentialingSteps.clickOnResult();
        credentialingSteps.clickResultDropdown();
    }

    @When("user clicks on Apply button")
    public void userClicksOnApplyButton() {
        credentialingSteps.clickOnApply();
    }
} 