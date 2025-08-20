package com.hhstechgroup.steps.jbehave.scenarios.IUFlowScenarios;

import com.hhstechgroup.steps.serenity.IUFlowSteps.FloridaMedicaidSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FloridaMedicaidScenario {
    @Steps
    FloridaMedicaidSteps floridaMedicaidSteps;

    @Then("verify configuration for FloridaMedicaid in SystemOption")
    public void verifyConfigurationForFloridaMedicaid(){
        floridaMedicaidSteps.verifyConfigurationForFloridaMedicaid();
    }

    @Then("verify BaseProviderID, LocationProviderID and status for Provider tab")
    public void verifyFloridaMedicaidProvider(){
        floridaMedicaidSteps.verifyFloridaMedicaidProvider();
    }
    @Then("verify BaseProviderID , LocationProviderID and status")
    public void verifyFloridaMedicaid(){
        floridaMedicaidSteps.verifyFloridaMedicaid();
    }

    @When("edit date and status")
    public void editFloridaMedicaid(){
        floridaMedicaidSteps.EditFloridaMedicaid();
    }

    @Then("I should see edit confirmation message :  \"$expected\"")
    public void verifyConfirmationMessage(String expected){
        floridaMedicaidSteps.VerifyConfirmationMessage(expected);
    }

    @Then("click on Dashboard tab on header")
    public void verifyBackToDashBoardButton(){
        floridaMedicaidSteps.verifyBackToDashboardButton();
    }
}
