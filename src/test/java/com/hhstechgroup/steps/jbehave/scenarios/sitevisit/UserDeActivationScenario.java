package com.hhstechgroup.steps.jbehave.scenarios.sitevisit;

import com.hhstechgroup.steps.serenity.sitevisit.UserDeActivationSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class UserDeActivationScenario {
    @Steps
    UserDeActivationSteps userDeActivationSteps;

    @Then("click on 'Edit Button' in the user inactivity page")
    public void clickOnEdit() { userDeActivationSteps.clickOnEdit(); }

    @Then("set the internal user inactive days '$value'")
    public void setInactiveDays1(String days) { userDeActivationSteps.setInactiveDays1(days); }

    @Then("set the internal user invitation is not acceptable days '$value'")
    public void setInvitationNotAcceptableDays1(String days){ userDeActivationSteps.setInvitationNotAcceptableDays1(days);}

    //sd-16

    @Then("set the provider user inactive days '$value'")
    public void setInactiveDays2(String days) { userDeActivationSteps.setInactiveDays2(days); }

    @Then("set the provider user invitation is not acceptable days '$value'")
    public void setInvitationNotAcceptableDays2(String days){ userDeActivationSteps.setInvitationNotAcceptableDays2(days);}


    @Then("click on save button in the user inactivity page")
   public void clickOnSave(){userDeActivationSteps.clickOnSave();}

   @When("Set the User Deactivation Date '$userDeactivationDate'")
   public void setUserDeactivationDate(String userDeactivationDate) {
        userDeActivationSteps.setUserDeactivationDate(userDeactivationDate);
   }

   // sp25

    @When("Set effective start date '$startDate'")
    public void setEffectiveStartDate(String userDeactivationDate) {
        userDeActivationSteps.setUserDeactivationDate(userDeactivationDate);
    }

    @When("Set effective end date '$endDate'")
    public void setEffectiveEndDate(String endDate) {userDeActivationSteps.setEffectiveEndDate(endDate);}

//sp 26

    @Then("click on cancel button in the user inactivity page")
    public void clickOnCancel(){userDeActivationSteps.clickOnCancel();}

}
