package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.peportalpages.PaymentsSteps;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.core.Is;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class PaymentsPageScenario {

    @Steps
    PaymentsSteps paymentsSteps;

    @When("click on payment row with payment id '$paymentId'")
    public void clickOnRecordWithValue(String id) {
        paymentsSteps.clickOnRecordWithValue(id);
    }

    @When("search for payment with request id '$id'")
    public void searchForPayment(String id) {
        paymentsSteps.setPaymentID(id);
        paymentsSteps.clickSearch();
    }

    @When("click on search button")
    public void clickSearch(){
        paymentsSteps.clickSearch();
    }

    @When("click Back To Search Results link on Payment details page")
    public void clickBackToSearchResults() {
        paymentsSteps.clickBackToSearchResults();
    }

    @When("click on claim with tcn $tcn on Payment details page")
    public void clickOnClaimByTcn(String tcn) {
        paymentsSteps.clickOnClaimWithTcn(tcn);
    }

    @When("click on claim with provider id $id on Payment details page")
    public void clickOnClaimByProviderId(String id) {
        paymentsSteps.clickOnClaimWithProviderId(id);
    }

    @Then("search for payments block should be present")
    public void isSearchBlockPresent() {
        assertTrue(paymentsSteps.isSearchBlockPresent());
    }

    @Then("Payment Id block should be present with next information: $table")
    public void checkPaymentIdInfo(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(paymentsSteps.getPaymentIdInformation(), Is.is(expectedInfo));
    }

    @Then("Payment Id block should have title - '$title'")
    public void checkPaymentIdTitle(String title) {
        assertEquals(title, paymentsSteps.getPaymentIdTitle());
    }

    @Then("Payment Id block should be present with next information and title - $title: $table")
    public void checkPaymentId(String title, ExamplesTable table) {
        checkPaymentIdTitle(title);
        checkPaymentIdInfo(table);
    }

    @Then("Claims block should be present with next information: $table")
    public void checkClaimsTable(ExamplesTable table) {
        assertReflectionEquals(table.getRows(), paymentsSteps.getClaimsInfo());
    }

    @Then("Financial information block should be present with next information: $table")
    public void checkFinancialInformation(ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), paymentsSteps.getFinancialInformation());
    }

    @Then("Originating institution block should be present with next information: $table")
    public void checkOriginatingInstitutionInformation(ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), paymentsSteps.getOriginatingInstitutionInformation());
    }
}
