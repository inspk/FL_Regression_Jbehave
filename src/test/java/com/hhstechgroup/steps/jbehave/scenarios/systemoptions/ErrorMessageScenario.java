package com.hhstechgroup.steps.jbehave.scenarios.systemoptions;

import com.hhstechgroup.steps.serenity.systemoption.ErrorMessageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class ErrorMessageScenario {
    @Steps
    ErrorMessageSteps errorMassageSteps;

    @When("click on system downtime messages drop down option")
    public void clickOnSystemDownTimeDropDown() {errorMassageSteps.clickOnSystemDownTimeDropDown();}

    @Then("click on edit button in error and massges page")
    public void clickoneditbutton(){errorMassageSteps.clickoneditbutton();}

    @Then("System should '$message' for downtime")
    public void clickMessageField(String message){errorMassageSteps.clickMessageField(message);}

    @When("set the effective from '$date' from system downtime page")
    public void  setEffectiveDate(String effectiveDate){errorMassageSteps.setEffectiveDate(effectiveDate);}

    @When("set the effective end '$date' from system downtime page")
    public void  setEffectiveEndDate(String effectiveEndDate){errorMassageSteps.setEffectiveEndDate(effectiveEndDate);}
}


