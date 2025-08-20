package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.enrollment.EnrollmentCocSteps;
import com.hhstechgroup.steps.serenity.peportalpages.ClaimsSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import static org.junit.Assert.assertTrue;


public class ClaimsScenario {

    @Steps
    ClaimsSteps claimsSteps;

    @Steps
    EnrollmentCocSteps enrollmentCocSteps;

    @When("click on claims row with $value '$tcn'")
    public void clickOnRowWitValue(String tcn) {
        claimsSteps.clickOnRecordWithValue(tcn);
    }

    @When("open $section on Claim details page")
    public void openSection(String section) {
        claimsSteps.openSection(section);
    }

    @When("search for {claim|payment} with tcn '$tcn'")
    public void searchForClaimByTcn(String tcn) {
        claimsSteps.setTcn(tcn);
        claimsSteps.clickSearch();
    }

    @When("click Back To Search Results link on Claim details page")
    public void clickBackToSearchResults() {
        claimsSteps.clickBackToSearch();
    }

    @When("search for claim by member name '$memberName'")
    public void searchForClaimMemberName(String memberName) {
        claimsSteps.setMemberName(memberName);
        claimsSteps.clickSearch();
    }

    @When("search for claim by service period from '$dateFrom' to '$dateTo'")
    public void searchForClaimMemberName(String dateFrom, String dateTo) {
        claimsSteps.setServicePeriod(dateFrom, dateTo);
        claimsSteps.clickSearch();
    }

    @When("search for claim by status '$status' and member id '$memberId'")
    public void searchForClaimStatusMemberId(String status, String memberId) {
        claimsSteps.setStatus(status);
        claimsSteps.setMemberId(memberId);
        claimsSteps.clickSearch();
    }

    @Then("claims search block should be present")
    public void isSearchBlockPresent() {
        assertTrue(claimsSteps.isSearchPanelPresent());
    }

//    @Then("Claim details is displayed with next information: $table")
//    public void checkClaimDetails(ExamplesTable table) {
//        assertReflectionEquals(table.getRow(0), claimsSteps.getClaimDetails());
//    }
//
//    @Then("Adjustment reason codes should have text information: $table")
//    public void checkReasonCodes(ExamplesTable table) {
//        assertReflectionEquals(table.getRows(), claimsSteps.getAdjustmentReasonCodes());
//    }
//
//    @Then("Remark codes should have text information: $table")
//    public void checkRemarkCodes(ExamplesTable table) {
//        assertReflectionEquals(table.getRows(), claimsSteps.getRemarkCodes());
//    }
//
//    @Then("Adjustment reason codes should have text information on IU portal: $table")
//    public void checkReasonCodesIu(ExamplesTable table) {
//        assertReflectionEquals(table.getRows(), claimsSteps.getAdjustmentReasonCodesIu());
//    }
//
//    @Then("Remark codes should have text information on IU portal: $table")
//    public void checkRemarkCodesIu(ExamplesTable table) {
//        assertReflectionEquals(table.getRows(), claimsSteps.getRemarkCodesIu());
//    }
//
//    @Then("Member Data should have text information: $table")
//    public void checkMemberData(ExamplesTable table) {
//        assertReflectionEquals(table.getRow(0), claimsSteps.getMemberData());
//    }
//
//    @Then("Provider Data should have text information: $table")
//    public void checkProviderData(ExamplesTable table) {
//        assertReflectionEquals(table.getRow(0), claimsSteps.getProviderData());
//    }
//
//    @Then("Payment Data should have text information: $table")
//    public void checkPaymentData(ExamplesTable table) {
//        assertReflectionEquals(table.getRow(0), claimsSteps.getPaymentData());
//    }
//
//    @Then("Payer Data should have text information: $table")
//    public void checkPayerData(ExamplesTable table) {
//        assertReflectionEquals(table.getRow(0), claimsSteps.getPayerData());
//    }
//
//    @Then("Information Receiver Data should have text information: $table")
//    public void checkReceiverData(ExamplesTable table) {
//        assertReflectionEquals(table.getRow(0), claimsSteps.getReceiverData());
//    }
//
//    @Then("Line item should have text information: $table")
//    public void checkgetLineItems(ExamplesTable table) {
//        assertReflectionEquals(table.getRows(), claimsSteps.getLineItems());
//    }
//
//    @Then("claims with next information should be displayed: $table")
//    @Alias("payments with next information should be displayed: $table")
//    public void checkClaimPaymentDetails(ExamplesTable table) {
//        assertReflectionEquals(table.getRows(), enrollmentCocSteps.getRequestDetails(), ReflectionComparatorMode.LENIENT_ORDER);
//    }
//
//    @Then("Line item should have text information on IU portal: $table")
//    public void checkgetLineItemsIu(ExamplesTable table) {
//        assertReflectionEquals(table.getRows(), claimsSteps.getLineItemsIu(), ReflectionComparatorMode.LENIENT_ORDER);
//    }

    @When("click Create Professional claim")
    public void clickCreateClaim() {
        claimsSteps.clickCreateClaim();
    }

    @When("click Continue claim")
    public void clickContinueClaim() {
        claimsSteps.clickContinue();
    }

    @When("submit Claim application")
    public void submitClaim() {
        claimsSteps.clickSubmit();
    }

    @When("click on Go to Claims button")
    public void clickOnGoToClaims() {
        claimsSteps.clickGoToClaims();
    }
}
