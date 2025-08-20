package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.AutoCompleteSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertTrue;

public class AddressAutocompleteScenario {

    @Steps
    AutoCompleteSteps autoCompleteSteps;

    @When("select first address from auto-complete variants")
    public void selectFirstAddress() {
        autoCompleteSteps.clickOnFirstAddress();
    }

    @Then("address auto-complete list should be displayed")
    public void isAddressAutoCompleteDisplayed() {
        assertTrue(autoCompleteSteps.isAddressAutocompleteListAppeared());
    }

    @Then("'$message' should be displayed in address auto-complete variants")
    public void checkNoMatchesFound(String message) {
        assertTrue(autoCompleteSteps.isNoMatchesFoundDisplayed(message));
    }

    @Then("'Verified' label should be displayed under the '$fieldName' field")
    public void isAddressVerified(String fieldName) {
        assertTrue(autoCompleteSteps.isVerifiedLabelPresent(fieldName));
    }
}
