package com.hhstechgroup.steps.jbehave.scenarios.eligibility;


import com.hhstechgroup.steps.serenity.peportalpages.EligibilityUISteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.core.Is;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class EligibilityScenario {



    @Steps
    EligibilityUISteps eligibilityUISteps;




    @When("click on eligibility row with member id '$memberId'")
    public void clickOnRowWithPaymentId(String id) {
        eligibilityUISteps.clickOnRowByMemberId(id);
    }

    @When("search for eligibility with member id '$id'")
    public void searchForEligibility(String id) {
        eligibilityUISteps.setMemberId(id);
        eligibilityUISteps.clickSearch();
    }

    @When("click View address button")
    public void clickViewAddress() {
        eligibilityUISteps.clickViewAddress();
    }

    @Then("eligibility search block should be present")
    public void isSearchBlockPresent() {
        assertTrue(eligibilityUISteps.isSearchBlockPresent());
    }

    @Then("Eligibility confirmation should have next information: $table")
    public void checkEligibilityConfirmation(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(eligibilityUISteps.getEligibilityConfirmation(), Is.is(expectedInfo));
    }

    @Then("$section left menu should be opened on Eligibility page")
    public void checkClaimsTable(String section) {
        assertTrue(eligibilityUISteps.isSectionOpened(section));
    }

    @Then("service from date is '$dateFrom' and service to date is '$dateTo'")
    public void checkServiceDate(String dateFrom, String dateTo){
        assertTrue("Service date is not displayed or is incorrect", eligibilityUISteps.isServiceDateCorrect(dateFrom, dateTo));
    }

    @When("click on Back to Search link")
    public void clickBackToSearch(){
        eligibilityUISteps.clickBackToSearch();
    }

    @When("move to '$sectionName' eligibility section")
    public void navigateToSection(String sectionName){
        eligibilityUISteps.navigateToSection(sectionName);
    }

    @Then("$section should be present with information: $table")
    public void checkEligibilityInfo(ExamplesTable table) {
        assertReflectionEquals(table.getRows(), eligibilityUISteps.getEligibilityInfo());
    }

    @When("click on row with eligibility type '$type' in Eligibility status section")
    public void clickRowWithEligibilityType(String type){
        eligibilityUISteps.clickRowWithEligibilityType(type);
    }

    @When("click on row with carrier name '$name'")
    public void clickRowWithCarrierName(String name){
        eligibilityUISteps.clickRowWithCarrierName(name);
    }

    @Then("eligibility type should have next information: $table")
    public void checkAccordionInfo(ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), eligibilityUISteps.getAccordionInfo());
    }

}
