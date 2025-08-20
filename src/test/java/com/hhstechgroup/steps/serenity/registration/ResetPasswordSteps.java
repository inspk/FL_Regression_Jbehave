package com.hhstechgroup.steps.serenity.registration;

import com.hhstechgroup.ui.pages.registration.ResetPasswordPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ResetPasswordSteps extends ScenarioSteps {

    ResetPasswordPage resetPasswordPage;

    @Step
    public void resetPassword(String password) {
        resetPasswordPage.setPassword(password);
        resetPasswordPage.setConfirmPassword(password);
        resetPasswordPage.clickSetPassword();
        resetPasswordPage.clickGoToDashboard();
    }
}
