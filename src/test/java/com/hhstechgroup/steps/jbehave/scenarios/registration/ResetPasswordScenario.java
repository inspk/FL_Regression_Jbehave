package com.hhstechgroup.steps.jbehave.scenarios.registration;

import com.hhstechgroup.steps.serenity.registration.ResetPasswordSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

public class ResetPasswordScenario {

    @Steps
    ResetPasswordSteps resetPasswordSteps;

    @When("set collaborator password $password")
    public void setCollaboratorPassword(String password) {
        resetPasswordSteps.resetPassword(password);
    }
}
