package com.hhstechgroup.steps.serenity.registration;

import com.hhstechgroup.ui.pages.registration.RestorePasswordPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;



public class RestorePasswordSteps {

    @Page
    RestorePasswordPage restorePasswordPage;

    @Step
    public String getRestorePasswordTitle(){
        return restorePasswordPage.getRestorePasswordTitle();
    }

    @Step
    public String getRestorePasswordText(){
        return restorePasswordPage.getRestorePasswordText();
    }

    @Step
    public void clickResetPassword(){
        restorePasswordPage.clickResetPassword();
    }

    @Step
    public boolean isValidationErrorDisplayed(String error){
        return restorePasswordPage.isValidationErrorDisplayed(error);
    }

    @Step
    public void typeEmail(String email){
        restorePasswordPage.typeEmail(email);
    }

    @Step
    public void clickBackToLoginLink(){
        restorePasswordPage.clickBackToLoginLink();
    }

    @Step
    public void enterNewPassword(String newPassword){
        restorePasswordPage.enterNewPassword(newPassword);
    }

    @Step
    public void enterNewPassword1(String newPassword){
        restorePasswordPage.enterNewPassword1(newPassword);
    }


    @Step
    public void enterComparePassword(String newPassword){
        restorePasswordPage.enterComparePassword(newPassword);
    }

    @Step
    public void clickChangePassword(){
        restorePasswordPage.clickChangePassword();
    }

    @Step
    public boolean isOneStepLeftTextPresent(String text1, String text2){return restorePasswordPage.isOneStepLeftTextPresent(text1, text2);}

    @Step
    public void clickOnBackToLoginButton(){
        restorePasswordPage.clickOnBackToLoginButton();
    }

    @Step
    public void clickInComparePasswordInput(){
        restorePasswordPage.clickInComparePasswordField();
    }

    @Step
    public boolean isInvalidPasswordErrorDisplayed(String error){
        return restorePasswordPage.isInvalidPasswordErrorDisplayed(error);
    }

    @Step
    public boolean isPageTitleCorrect(String pageTitle){
        return restorePasswordPage.getHeaderPanel().isPageTitleCorrect(pageTitle);
    }

    @Step
    public void enterForgotNewPassword(String newPassword){restorePasswordPage.enterForgotNewPassword(newPassword);}

    @Step
    public void enterForgotConfirmPassword(String newPassword){restorePasswordPage.enterForgotConfirmPassword(newPassword);}

    @Step
    public void clickSetPassword(){restorePasswordPage.clickSetPassword();}

    //sp24
    @Step
    public boolean isPasswordPolicyPopupOpened() {
        return restorePasswordPage.isPasswordPolicyPopupOpened();
    }
    @Step
    public void clickOkButton() {
        restorePasswordPage.clickOkButton();
    }

    //sp37 change password
    @Step
    public void enterCurrentPassword(String currentPassword){
        restorePasswordPage.enterCurrentPassword(currentPassword);
    }

    @Step
    public void clickOnBackToLoginForChangePassword(){
        restorePasswordPage.clickOnBackToLoginForChangePassword();
    }

    @Step
    public void clickOnForgotPassword(){
        restorePasswordPage.clickOnForgotPassword();
    }

    @Step
    public boolean shouldShowUserLockedPopup(String message) {
        return restorePasswordPage.shouldShowUserLockedPopup(message);
    }

}
