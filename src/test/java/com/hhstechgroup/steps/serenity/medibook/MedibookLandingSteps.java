package com.hhstechgroup.steps.serenity.medibook;

import com.hhstechgroup.medibook.pages.landing.MedibookLandingPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MedibookLandingSteps extends ScenarioSteps {

    MedibookLandingPage medibookLandingPage;

    @Step
    public void openLandingPage() {
        medibookLandingPage.open();
    }

    @Step
    public void clickOnButton(String button) {
        medibookLandingPage.getMedibookLandingPanel().clickOnButton(button);
    }

    @Step
    public void fillUsername(String username) {
        medibookLandingPage.fillUsername(username);
    }

    @Step
    public void fillPassword(String password) {
        medibookLandingPage.fillPassword(password);
    }

    @Step
    public String getUsernameValue() {
        return medibookLandingPage.getUsernameValue();
    }

    @Step
    public String getPasswordValue() {
        return medibookLandingPage.getPasswordValue();
    }

    @Step
    public boolean usernameErrorIsDisplayed(String error) {
        return medibookLandingPage.usernameErrorIsDisplayed(error);
    }

    @Step
    public boolean passwordErrorIsDisplayed(String error) {
        return medibookLandingPage.passwordErrorIsDisplayed(error);
    }

    @Step
    public boolean incorrectLoginPassErrorIsDisplayed(String error) {
        return medibookLandingPage.incorrectLoginPassErrorIsDisplayed(error);
    }

    @Step
    public void logOutAs (String name) {
        medibookLandingPage.logOutFromMedibookAs(name);
    }
}