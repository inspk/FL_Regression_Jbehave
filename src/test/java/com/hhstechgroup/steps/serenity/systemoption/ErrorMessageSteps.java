package com.hhstechgroup.steps.serenity.systemoption;

import com.hhstechgroup.ui.pages.systemoptions.ErrorMessagePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ErrorMessageSteps extends ScenarioSteps {
    ErrorMessagePage errorMassagePage;

    @Step
    public void clickOnSystemDownTimeDropDown() {errorMassagePage.clickOnSystemDownTimeDropDown();}

    @Step
    public void clickoneditbutton(){errorMassagePage.clickoneditbutton();}

    @Step
    public void clickMessageField(String message){errorMassagePage.clickMessageField(message);}

    @Step
    public void setEffectiveDate(String effectiveDate){errorMassagePage.setEffectiveDate(effectiveDate);}

    @Step
    public void setEffectiveEndDate(String effectiveEndDate){errorMassagePage.setEffectiveEndDate(effectiveEndDate);}

}
