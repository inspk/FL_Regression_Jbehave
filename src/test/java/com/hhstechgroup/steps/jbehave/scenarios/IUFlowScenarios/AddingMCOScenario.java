package com.hhstechgroup.steps.jbehave.scenarios.IUFlowScenarios;

import com.hhstechgroup.steps.serenity.IUFlowSteps.AddingMCOSteps;
import com.hhstechgroup.steps.serenity.providerData.ProviderDataSteps;
import com.hhstechgroup.util.properties.ProviderProperties;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AddingMCOScenario {

    @Steps
    AddingMCOSteps addingMCOSteps;
    @Steps
    ProviderDataSteps providerDataSteps;

    @When("user clicks on Add MCO button")
    public void userClicksOnAddMCOButton() {
        addingMCOSteps.clickAddMCOButton();
    }

    @When("search for provider by id ' {providerId}'")
    public void searchForProviderById(String providerId) {
        // Save providerId to properties file for use in page object
        ProviderProperties.save("ProviderID", providerId);
        providerDataSteps.searchWithProviderIDInProviderTab();
    }

    @Then("provider details should be displayed for ' {providerId}'")
    public void providerDetailsShouldBeDisplayed(String providerId) {
        // This checks if the provider name is present in the details
        boolean found = providerDataSteps.checkProviderNameOnProviderDetails(providerId);
        org.junit.Assert.assertTrue("Provider details should be displayed for " + providerId, found);
    }

    @When("provider clicks on radio button for Ownership lessthanfivepercent")
    public void setAnyOwnersLessThanFivePercent(){
        addingMCOSteps.setAnyOwnersLessThanFivePercent();
    }

    @Then("click on Go To MCO button")
    public void click_Go_TO_MCO(){
        addingMCOSteps.click_Go_TO_MCO();
    }

    @Then("affiliate '$enrolltype' with provider of '$plantype'")
    public void fillInAffiliationSectionwithMCO(String enrolltype,String plantype){
        addingMCOSteps.fillInAffiliationSectionwithMCO(enrolltype,plantype);
    }

    @Then("affiliate '$enrolltype' with provider")
    public void fillInAffiliationSectionforMCO(String enrolltype){
        addingMCOSteps.fillInAffiliationSectionforMCO(enrolltype);
    }

} 