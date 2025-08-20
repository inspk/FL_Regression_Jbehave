package com.hhstechgroup.steps.jbehave.scenarios.IUFlowScenarios;

import com.hhstechgroup.steps.serenity.IUFlowSteps.AlternateIdentifierSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AlternateIdentifierScenario {
    @Steps
    AlternateIdentifierSteps alternateidentifiersteps;

    @Then("I add an alternate identifier with level $level, type $type, reason $reason")
    public void addAlternateIdentifier(String level, String type, String reason) {
        alternateidentifiersteps.addAlternateIdentifier(level, type, reason);
    }

    @Then("I add an alternate identifier in providers tab with level $level, type $type, reason $reason")
    public void addAlternateIdentifier_Providerstab(String level, String type, String reason) {
        alternateidentifiersteps.addAlternateIdentifier_Providerstab(level, type, reason);
    }

    @Then("I should see \"$expected\"")
    public void verifyAddedConfirmation(String expected) {
        alternateidentifiersteps.verifyAddedConfirmation(expected);
    }

    @When("I edit that alternate identifier to reason $reason and status $status")
    public void editAlternateIdentifier(String reason, String status) {
        alternateidentifiersteps.editAlternateIdentifier(reason, status);
    }

    @Then("I should get \"$expected\"")
    public void verifyEditConfirmation(String expected) {
        alternateidentifiersteps.verifyEditConfirmation(expected);
    }


}

