package com.hhstechgroup.steps.jbehave.scenarios.approvals;

import com.hhstechgroup.steps.serenity.approvals.ApprovalSteps;
import com.hhstechgroup.steps.serenity.peportalpages.DashboardSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.yecht.Data;

import static org.junit.Assert.*;


public class ApprovalsScenario {

    @Steps
    ApprovalSteps approvalSteps;

    @Steps
    DashboardSteps dashboardSteps;


    @When("click on Back to Dashboard from System Options")
    public void clickBackToDashboard() {
        dashboardSteps.backToDashboardFromSysOptions();
    }

    @When("click on View button for request '$request'")
    public void clickOnViewForRequest(String request) {
        approvalSteps.clickWiewForRequest(request);
    }

    @When("click on edit button in System Options")
    public void clickOnEditButton() {
        approvalSteps.clickEdit();
    }

    @When("click on edit button in Screening from System Options")
    public void clickOnEditButton1() {
        approvalSteps.clickEdit1();
    }

    @When("click on save changes button in System Options")
    public void clickOnSaveButton() {
        approvalSteps.clickSave();
    }

    @When("click on save changes button in Payment Fees page")
    public void clickOnSaveButton1() {
        approvalSteps.clickSave1();
    }

    @When("set number of approvers '$approversNumber' in System Options")
    public void selectNumberOfApprovers(String number) {
        approvalSteps.selectApproversNumber(number);
    }

    @When("turn on reviewers configuration in System Options")
    public void enableReviewers() {
        approvalSteps.turnOnReviwers();
    }

    @When("turn off reviewers configuration in System Options")
    public void turnOffReviewers() {
        approvalSteps.turnOffReviwers();
    }

    @When("add reviewer in System Options")
    public void addReviewer() {
        approvalSteps.clickAddReviewer();
    }


    @When("turn on CVO reviewers configuration in System Options")
    public void enableCVOReviewers() {
        approvalSteps.turnOnCVOReviwers();
    }

    @When("turn off CVO reviewers configuration in System Options")
    public void turnOffCVOReviewers() {
        approvalSteps.turnOffCVOReviwers();
    }

    @When("add CVO reviewer in System Options")
    public void addCVOReviewer() {
        approvalSteps.clickAddCVOReviewer();
    }

    @When("set number of CVO reviewers '$reviewersNumber' in System Options")
    public void selectNumberOfCVOReviewers(String number) {
        approvalSteps.selectCVOReviewersNumber(number);
    }


    @When("add approver in System Options")
    public void addApprover() {
        approvalSteps.clickAddApprover();
    }

    @When("remove approver '$approver' in System Options")
    public void removeApprover(String approver) {
        approvalSteps.clickRemoveApprover(approver);
    }

    @When("remove reviewer '$reviewer' in System Options")
    public void removeReviewer(String reviewer) {
        approvalSteps.clickRemoveReviewer(reviewer);
    }

    @When("select {role|user} '$roleUser' in System Options")
    public void addReviewer(String roleUser) {
        approvalSteps.selectRoleUser(roleUser);
    }

    @When("verify that '$title' with '$name' is not displayed System Options and add new one with role '$role'")
    public void addApproverReviewerWithVerification(String reviewerApprover,  String name, String typeRole) {
        approvalSteps.addApproverReviewerWithVerification(reviewerApprover, name, typeRole);
    }


    @When("verify that '$title' with '$name' is not displayed System Options and also add new one with role '$role'")
    public void addCVOReviewerWithVerification(String cvoreviewer,  String name, String typeRole) {
        approvalSteps.addCVOReviewerWithVerification(cvoreviewer, name, typeRole);
    }


    @When("select '$byTypeRoleUser' in type dropdown in System Options")
    public void addReviewher(String roleUser) {
        approvalSteps.selectTypeRoleUser(roleUser);
    }

    @When("click on Add button in popup in System Options")
    public void clickAddButton() {
        approvalSteps.clickAddInPopup();
    }

    @When("set number of reviewers '$reviewersNumber' in System Options")
    public void selectNumberOfReviewers(String number) {
        approvalSteps.selectReviewersNumber(number);
    }

    @When("click on '$approveDeny' button on decision panel")
    public void clickOnApproveDenyButton(String vote) {
        approvalSteps.clickApproveDeny(vote);
    }

    @When("select approve reason '$reason' in Approval popup")
    public void setReason(String reason) {
        approvalSteps.selectReason(reason);
    }

    @When("select deny reason '$reason' in Approval popup")
    public void setDenyReason(String reason) {
        approvalSteps.selectDenyReason(reason);
    }

    @When("click on Approve button in Approval popup")
    public void clickApproveButtonInPopup() {
        approvalSteps.clickApproveButtonInPopup();
    }

    @When("click on Deny button in Approval popup")
    public void clickDenyButtonInPopup() {
        approvalSteps.clickDenyButtonInPopup();
    }

    @Then("verify '$text' text is present on decision panel")
    public void verifyTextPresent(String text) {
        assertTrue(approvalSteps.isVoteTextPresent(text));
    }

    @Then("verify reviewers info is present on decision panel")
    public void verifyReviewersInfoPresent() {
        assertTrue(approvalSteps.isReviewersInfoPresent());
    }

    @Then("verify reviewers info is NOT present on decision panel")
    public void verifyReviewersInfoNotPresent() {
        assertFalse(approvalSteps.isReviewersInfoPresent());
    }

    @When("switch {on|off} Auto")
    public void turnOnAuto(){approvalSteps.turnOnAuto();}

    @When("verify the voting when the status is pending approval")
    public void clickOnHiddenButtonWhenPendingApproval(){approvalSteps.clickOnHiddenButtonPendingApproval();}

    @When("verify the voting when the status is pending review")
    public void clickOnHiddenButtonWhenPendingReview(){approvalSteps.clickOnHiddenButtonWhenPendingReview();}

    @When("click on '$changeStatusButton' button from the enrollment details page")
    public void clickOnChangeStatusButton(String changeStatusButton){approvalSteps.clickOnChangeStatusButton(changeStatusButton);}

    @When("click On '$option' button")
    public void clickOnVerifyPayment(){
        approvalSteps.clickOnVerifyPayment();
    }

    //adding duplicity sp20
    @When("click on edit button in Duplicity from System Options")
    public void clickduplicityeditButton() {
        approvalSteps.clickduplicityeditButton();
    }
    //sp22
    @When("click on save changes button in Screening page")
    public void clickOnSaveButton2() {
        approvalSteps.clickSave1();
    }
    //sp21
    @Then("verify the Finger Print button '$button' is displaying")
    public boolean VerifyFingerPrintButton(String button){
        return approvalSteps.VerifyFingerPrintButton(button);
    }
    //sp22
    @When("expand the Individual Providers Approval configuration for '$name'  Enrollment type Page")
    public void clickIndividualProviders(String individualproviders){
        approvalSteps.clickIndividualProviders(individualproviders);
    }

    @When("expand the Group Providers Approval configuration for '$name' Enrollment type Page")
    public void clickGroupProviders(String groupproviders){
        approvalSteps.clickGroupProviders(groupproviders);
    }

    @When("expand the Pharmacy Providers Approval configuration for '$name' Enrollment type Page")
    public void clickPharmacyProviders(String pharmacyproviders){
        approvalSteps.clickPharmacyProviders(pharmacyproviders);
    }

    @Then("verify print button '$button' is displaying")
    public boolean VerifyPaymentPrintButton(String button){
        System.out.println("Verifying : " + button + " is Displaying");
        return approvalSteps.VerifyFingerPrintButton(button);
    }
    //sp26
    @When("expand the Provider Enrollment Manager Approval configuration for '$name' Enrollment type Page")
    public void clickProviderEnrollmentManger(String providerenrollmentmanger){
        approvalSteps.clickProviderEnrollmentManger(providerenrollmentmanger);
    }
    //sp28
    @When("expand the Ordering/Referring/Prescribing Provider Approval configuration for '$name' Enrollment type Page")
    public void clickOrderingReferringProvider(String orderingreferringprovider){
        approvalSteps.clickOrderingReferringProvider(orderingreferringprovider);
    }
    @When("expand the Facility Provider Enrollment Application Approval configuration for '$name' Enrollment type Page")
    public void clickFacilityProvider(String facilityprovider){
        approvalSteps.clickFacilityProvider(facilityprovider);
    }

    @When("expand the Managed Care Organisation Approval configuration for '$name' Enrollment type Page")
    public void clickManagedCareOrganisation(String mco){
        approvalSteps.clickManagedCareOrganisation(mco);
    }
    //sp32
    @When("set the EffectiveStartDate '$effectivedate' Enrollment type Page")
    public void setEffectiveStartDate(String effectiveStartDate) {
        approvalSteps.setEffectiveStartDate(effectiveStartDate);
    }
    @When("fill the effective start '$date' and effective end '$date' to enrollment type page")
    public void fillEffectiveDates(String dateStart,String dateEnd){
        approvalSteps.fillEffectiveDates(dateStart,dateEnd);
    }

    //sp33

    @When("fill the effective end '$date' to enrollment end affiliation type page")
    public void fillEffectiveDatesAff(String dateEnd){
        approvalSteps.fillEffectiveDatesAff(dateEnd);
    }

    //sp35
    @When("click on ok button in finger print page")
    public void clickOnOkButtonForFingerPrint() {
        approvalSteps.clickOnOkButtonForFingerPrint();
    }

    //sp37
    @When("fill the effective start '$date' and effective end '$date' to enrollment end affiliation type page")
    public void fillEffectiveDatesAff1(String dateStart,String dateEnd){
        approvalSteps.fillEffectiveDatesAff1(dateStart,dateEnd);
    }

    //sp37
    @When("click on plus enrollment provider button")
    public void clickOnPlusEnrollmentProviderButton(){
        approvalSteps.clickOnPlusEnrollmentProviderButton();
    }

    //sp41.4
    @When("click on reenrollment button")
    public void clickOnReEnrollmentButton(){approvalSteps.clickOnReEnrollmentButton();}

    //sp68

    @When("expand the Trading Partner Provider Enrollment Application Approval configuration for '$name' Enrollment type Page")
    public void clickTradingPartnerProvider(String tradingpartnerprovider){
        approvalSteps.clickTradingPartnerProvider(tradingpartnerprovider);
    }

    // sd-04

    @When("turn on '$status' configuration in System Options")
    public void turnOnNew() {
        approvalSteps.turnOnNew();
    }

    @When("turn off NEW configuration in System Options")
    public void turnOffNew() {
        approvalSteps.turnOffNew();
    }

    // SD-08

    @Then("verify the enrollment request '$field' is '$value'")
    public void verifyEnrollmentRequestData(String field, String expected){
        String actual = approvalSteps.verifyEnrollmentRequestData(field);
        System.out.println(field.toUpperCase()+" :: Expected: "+ expected +" Actual: "+actual);
        assertEquals("Expected: "+ expected +" Actual: "+actual, actual, expected);
    }

    @Then("verify the Provider submitted COC details '$field' is '$value'")
    public void verifyCocRequestDataInProviderSection(String field, String expected){
        String actual = approvalSteps.verifyCocRequestDataInProviderCocTab(field);
        System.out.println(field.toUpperCase()+" :: Expected: "+ expected +" Actual: "+actual);
        assertEquals("Expected: "+ expected +" Actual: "+actual, actual, expected);
    }

    @Then("verify the Provider name submitted  COC '$field' is '$value'")
    public void verifyCocProviderNameInProviderSection(String field, String expected){
        String actual = approvalSteps.verifyCocProviderNameInProviderCocTab(field);
        System.out.println(field.toUpperCase()+" :: Expected: "+ expected +" Actual: "+actual);
        assertEquals("Expected: "+ expected +" Actual: "+actual, actual, expected);
    }

    @Then("verify the Provider Module details '$field' is '$value'")
    public void ProviderModuleDataInternalUserTab(String field, String expected){
        String actual = approvalSteps.verifyProviderModuleDataInternalUserTab(field);
        System.out.println(field.toUpperCase()+" :: Expected: "+ expected +" Actual: "+actual);
        assertEquals("Expected: "+ expected +" Actual: "+actual, actual, expected);
    }

//SD-10

    @When("{enable|disable} '$button' configuration in approval page")
    public void enableCocConfiguration(String button) {
        approvalSteps.enableCocConfiguration(button);
    }

    @When("verify '$button' configuration is $checked in approval page")
    public void verifyCocConfiguration(String button, String checked) {
        boolean isEnabled = approvalSteps.verifyCocConfiguration(button);

        if (checked.equalsIgnoreCase("on")) {
            if (!isEnabled) {
                approvalSteps.toggleCocConfiguration(button, true); // Turn it ON if it's OFF
            }
        } else {
            if (isEnabled) {
                approvalSteps.toggleCocConfiguration(button, false); // Turn it OFF if it's ON
            }
        }
    }

//SD-11

    @Then("verify the Provider data details '$field' is '$value'")
    public void ProviderModuleDataProviderTab(String field, String expected){
        String actual = approvalSteps.verifyProviderModuleDataProviderTab(field);
        System.out.println(field.toUpperCase()+" :: Expected: "+ expected +" Actual: "+actual);
        assertEquals("Expected: "+ expected +" Actual: "+actual, actual, expected);
    }

    @When("add transaction type '$type' transaction value '$value'")
    public void addTransactions(String type, String value){
        approvalSteps.addTransaction(type, value);
    }

    @When("{enable|disable} '$button' configuration in Re-enrollment approval page")
    public void enableReEnrollmentConfiguration(String button) {
        approvalSteps.enableReEnrollmentConfiguration(button);
    }

    @When("verify '$button' configuration is $checked in Re-enrollment approval page")
    public void verifyReEnrollmentConfiguration(String button,String checked) {
        if(checked.equalsIgnoreCase("on"))
            assertTrue(button + " is not enabled!", approvalSteps.verifyReEnrollmentConfiguration(button));
        else
            assertFalse(button + " is enabled!", approvalSteps.verifyReEnrollmentConfiguration(button));
    }

    @When("verify Download Excel button present in Re-enrollment page")
    public void verifyDownloadExcelButton(){
        assertTrue("Download Excel button not presents!",approvalSteps.verifyDownloadExcelButton());
    }

    @Then("click Required site visit signature from Internal user checkbox")
    public void clickSitevisitSignIU() {
        approvalSteps.clickSitevisitSignIU();
    }

    @Then("click Required site visit signature from Provider checkbox")
    public void  clickSitevisitSignPE() {
        approvalSteps.clickSitevisitSignPE();
    }

    @Then("'$description' switch should be turned $on")
    public void checkAutoCheckboxEnabled(String description, String button) {
        if(button.equalsIgnoreCase("on")) {
            assertTrue(description + " is turned off!",
                    approvalSteps.isAutoCheckboxSelected(description));
        }
        else {
            assertFalse(description + " is turned on!",
                    approvalSteps.isAutoCheckboxSelected(description));
        }
    }

    @Then("switch $on the '$description' auto configuration in coc approval page")
    public void clickAutoCheckbox(String mode, String description) {
        if(approvalSteps.isAutoCheckboxSelected(description)) {
            if(mode.equalsIgnoreCase("off")) {
                approvalSteps.clickAutoCheckbox(description);
            }
            else {
                System.out.println(description + " is already on!");
            }
        }
        else {
            if(mode.equalsIgnoreCase("on")) {
                approvalSteps.clickAutoCheckbox(description);
            }
            else {
                System.out.println(description + " is already off!");
            }
        }
    }

    @Then("set auto approve slider")
    public void setAutoApproveSlider(){
        approvalSteps.setAutoapproveSlider();
    }

    @When("turn on Auto Approve configuration in System Options")
    public void turnOnAutoApprove() {
        approvalSteps.turnOnAutoApprove();
    }

    @When("turn off Auto Approve configuration in System Options")
    public void turnOffAutoApprove() {
        approvalSteps.turnOffAutoApprove();
    }

    @When("turn on {TP|PEM} Auto Approve configuration in System Options")
    public void turnOnAutoApproveTpPem() {
        approvalSteps.turnOnAutoApproveTpPem();
    }

    @When("turn off {TP|PEM} Auto Approve configuration in System Options")
    public void turnOffAutoApproveTpPem() {
        approvalSteps.turnOffAutoApproveTpPem();
    }

    @When("turn on Assignee configuration in System Options")
    public void turnOnAssigneeConfiguration() {
        approvalSteps.turnOnAssigneeConfiguration();
    }

    @When("turn off Assignee configuration in System Options")
    public void turnOffAssigneeConfiguration() {
        approvalSteps.turnOffAssigneeConfiguration();
    }

    @When("turn on Coc Screening configuration in System Options")
    public void turnOnCocScreening() {
        approvalSteps.turnOnCocScreening();
    }

    @When("enable instate in coc affiliation")
    public void enableInstate() {
        approvalSteps.enableInstate();
    }

    @When("enable outstate in coc affiliation")
    public void enableOutstate() {
        approvalSteps.enableOutstate();
    }

    @When("enable bothstate in coc affiliation")
    public void enableBothstate() {
        approvalSteps.enableBothstate();
    }

    @When("instate switch should be enabled")
    public void instateSwitchEnable() {
        assertTrue(approvalSteps.isInstateEnabled());
    }

    @When("instate switch should be disabled")
    public void instateSwitchDisble() {
        assertFalse(approvalSteps.isInstateEnabled());
    }

    @When("outstate switch should be enabled")
    public void outstateSwitchEnabled() {
        assertTrue(approvalSteps.isOutstateEnabled());
    }

    @When("outstate switch should be disabled")
    public void outstateSwitchDisable() {
        assertFalse(approvalSteps.isOutstateEnabled());
    }

    @When("bothstate switch should be enabled")
    public void bothstateSwitchEnable() {
        assertTrue(approvalSteps.isBothEnabled());
    }

    @When("bothstate switch should be disabled")
    public void bothstateSwitchDisable() {
        assertFalse(approvalSteps.isBothEnabled());
    }

}
