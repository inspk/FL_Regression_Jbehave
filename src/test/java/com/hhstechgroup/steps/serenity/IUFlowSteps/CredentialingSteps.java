package com.hhstechgroup.steps.serenity.IUFlowSteps;

import com.hhstechgroup.ui.pages.IUFlowPages.CredentialingPage;
import com.hhstechgroup.ui.pages.iuportal.IUDashboardPage;
import com.hhstechgroup.util.properties.ProviderProperties;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class CredentialingSteps extends ScenarioSteps {

    public CredentialingPage credentialingPage;
    public IUDashboardPage iuDashboardPage;
    String requestId;

    @Step
    public void clickAddCredentialing() {
        credentialingPage.clickAddCredentialing();
    }

    @Step
    public void searchWithNPI(String npi) {
        credentialingPage.searchWithNPI(npi);
    }

    @Step
    public void clickNPISearchButton() {
        credentialingPage.clickNPISearchButton();
    }

    @Step
    public void clickCreateButton() {
        credentialingPage.clickCreateButton();
    }

    @Step
    public void clickSectionCredentialingDetails() {
        credentialingPage.clickSectionCredentialingDetails();
    }

    @Step
    public void clickSectionUploadCredentialingDocuments() {
        credentialingPage.clickSectionUploadCredentialingDocuments();
    }

    @Step
    public void clickLinkCredentialing() {
        credentialingPage.clickSubmitButton();
        waitABit(1000);
        credentialingPage.clickLinkCredentialing();
    }

    public void verifyCredentailingToggleSystemOption(){
        credentialingPage.verifyCredentialing();
    }

    @Step
    public void clickSubmitbutton(){
        credentialingPage.clickSubmitButton();
    }

    @Step
    public void selectAllRadioButtonsForCredentialingDetails(String radioButtonValue) {
        credentialingPage.selectAllRadioButtonsForCredentialingDetails(radioButtonValue);
    }

    @Step
    public void searchNPICredentialing(String npi) {
        credentialingPage.searchNPICredentialing(npi);
    }

    @Step
    public void clickSearchButtonCredentialing() {
        credentialingPage.clickSearchButtonCredentialing();
    }

    @Step
    public void clickOnNew() {
        credentialingPage.clickOnNew();
    }

    @Step
    public void clickOnUnassigned() {
        credentialingPage.clickOnUnassigned();
    }

    @Step
    public void selectCVOReviewCommittee() {
        credentialingPage.selectCVOReviewCommittee();
    }

    @Step
    public void clickOnAssign() {
        credentialingPage.clickOnAssign();
    }

    @Step
    public void clickCredentialing() {
        credentialingPage.clickCredentialing();
    }

    @Step
    public void clickAssignee() {
        credentialingPage.clickAssignee();
    }

    @Step
    public void clickCVOMedicalDirector() {
        credentialingPage.clickCVOMedicalDirector();
    }

    @Step
    public void clickAssignButtonCVORC() {
        credentialingPage.clickAssignButtonCVORC();
    }

    @Step
    public String getCredentialingRequestId() {
        return credentialingPage.getCredentialingRequestId();
    }

    @Step
    public String ReturnCredentialingRequestID(){
        return credentialingPage.ReturnCredentialingRequestID();
    }

    @Step
    public void searchRequestId(String requestId) {
        credentialingPage.searchRequestId(requestId);
    }

    @Step
    public void clickSearchButton() {
        credentialingPage.clickSearchButton();
    }

    @Step
    public void clickOnRequestIdRow(String lastThreeDigits) {
        credentialingPage.clickOnRequestIdRow(lastThreeDigits);
    }

    @Step
    public void clickOnChangeStatus() {
        credentialingPage.clickOnChangeStatus();
        credentialingPage.clickChangeStatusDropdown();
    }

    @Step
    public void clickFlagToMedicalDirector() {
        credentialingPage.clickFlagToMedicalDirector();
    }

    @Step
    public void clickChangeStatusDropdown() {
        credentialingPage.clickChangeStatusDropdown();
    }

    @Step
    public void clickOnReason() {
        credentialingPage.clickOnReason();
    }

    @Step
    public void clickReasonDropdown() {
        credentialingPage.clickReasonDropdown();
    }

    @Step
    public void clickOnResult() {
        credentialingPage.clickOnResult();
    }

    @Step
    public void clickResultDropdown() {
        credentialingPage.clickResultDropdown();
    }

    @Step
    public void clickOnApply() {
        credentialingPage.clickOnApply();
    }

    @Step
    public boolean isCompletedSuccessfulDisplayed() {
        return credentialingPage.isCompletedSuccessfulDisplayed();
    }

    @Step
    public void addCredentialingForProvider(String npi) {
        clickAddCredentialing();
        searchWithNPI(npi);
        clickNPISearchButton();
        clickCreateButton();
    }

    @Step
    public void fillCredentialingInformation(String radioButtonValue) {
        clickSectionCredentialingDetails();
        selectAllRadioButtonsForCredentialingDetails(radioButtonValue);
        clickSectionUploadCredentialingDocuments();
    }

    @Step
    public void performCoReviewAndMedicalDirectorActions(String npi) {
//        searchNPICredentialing(npi);
        searchRequestId(credentialingPage.ReturnCredentialingRequestID());
//        saveCredentialingRequestId();
        clickSearchButtonCredentialing();
        clickOnUnassigned();
        waitABit(2000);
        selectCVOReviewCommittee();
        clickOnAssign();
    }

    @Step
    public void assignToCVOMedicalDirector(String enrolltype) {
        clickCredentialing();
//        searchNPICredentialing(npi);
        waitABit(5000);
        searchRequestId(credentialingPage.ReturnCredentialingRequestID());
        clickSearchButtonCredentialing();
        waitABit(2000);
        credentialingPage.ChangeStatusFlagToMedicalDirector(enrolltype);
        getDriver().navigate().refresh();
        clickCredentialing();
        waitABit(5000);
        searchRequestId(credentialingPage.ReturnCredentialingRequestID());
        clickSearchButtonCredentialing();
        waitABit(2000);
        clickAssignee();
        clickCVOMedicalDirector();
        clickAssignButtonCVORC();
    }

    public void assignToCVOMedicalDirector_AutoCredentialing(String enrolltype) {
        waitABit(10000);
        clickCredentialing();
//        searchNPICredentialing(npi);
        waitABit(5000);
        searchRequestId(credentialingPage.ReturnCredentialingRequestID());
//        searchRequestId("115");
        clickSearchButtonCredentialing();
        waitABit(2000);
        credentialingPage.ChangeStatusFlagToMedicalDirector(enrolltype);
        getDriver().navigate().refresh();
        clickCredentialing();
        waitABit(5000);
        searchRequestId(credentialingPage.ReturnCredentialingRequestID());
//        searchRequestId("115");
        clickSearchButtonCredentialing();
        waitABit(2000);
    }

    @Step
    public void approveCredentialingCVOMedicalDirector(String requestId) {
//        searchRequestId(requestId);
//        clickSearchButton();
//        clickCredentialing();
//        searchNPICredentialing(npi);
//        waitABit(5000);
        searchRequestId(credentialingPage.ReturnCredentialingRequestID());
//        searchRequestId("115");
        clickSearchButtonCredentialing();
        waitABit(2000);
        
        // Extract last 3 digits from request ID
        String lastThreeDigits = requestId.substring(requestId.length() - 2);
        clickOnRequestIdRow(lastThreeDigits);
        waitABit(5000);
        clickOnChangeStatus();
//        clickFlagToMedicalDirector();
        credentialingPage.clickCHANGESTATUSDROPDOWNOption();
        clickOnReason();
        clickReasonDropdown();
        clickOnResult();
        clickResultDropdown();
        clickOnApply();
    }

    @Step
    public void verifyCredentialingCompletedSuccessfully() {
        Assert.assertTrue("Credentialing should be completed successfully", isCompletedSuccessfulDisplayed());
    }

    @Step
    public void saveCredentialingRequestId() {
        requestId = getCredentialingRequestId();
        ProviderProperties.save("CredentialingRequestID", requestId);
    }

    @Step
    public String getSavedCredentialingRequestId() {
        return ProviderProperties.getData("CredentialingRequestID");
    }
} 