package com.hhstechgroup.steps.serenity.registration;

import com.hhstechgroup.ui.pages.login.LoginPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;


public class LoginSteps {

    @Page
    LoginPage loginPage;

    @Step
    public void clickRegisterButtonOnLoginPage() {
        loginPage.clickRegisterButtonOnLoginPage();
    }

    @Step
    public void fillUsername(String username) {
        loginPage.fillUsername(username);
    }

   /* @Step
    public void fillUserEmailId(String username1) {
        loginPage.fillUserEmailId(username1);
    }*/
    @Step
    public void fillPassword(String password) {
        loginPage.fillPassword(password);
    }

    @Step
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Step
    public void clickLoginAndWaitForLoading() {
        loginPage.clickLoginButton();
       // loginPage.waitForLoginCompleted();    //sp 20 after warning message user update pop up displaying,but not in the login time , so commented
    }

    @Step
    public void clickForgotPassLink() {
        loginPage.clickForgotPassLink();
    }

    @Step
    public String getUsernameValue() {
        return loginPage.getUsernameValue();
    }

    @Step
    public String getPasswordValue() {
        return loginPage.getPasswordValue();
    }

    @Step
    public boolean usernameErrorIsDisplayed(String error) {
        return loginPage.usernameErrorIsDisplayed(error);
    }

    @Step
    public boolean passwordErrorIsDisplayed(String error) {
        return loginPage.passwordErrorIsDisplayed(error);
    }

    @Step
    public boolean incorrectLoginPassErrorIsDisplayed(String error) {
        return loginPage.incorrectLoginPassErrorIsDisplayed(error);
    }

    @Step
    public boolean isLoginFormDisplayed() {
        return loginPage.isLoginFormDisplayed();
    }

    //sp32
    @Step
    public boolean inactiveMessageDisplayed(String inactivemessage){
        return loginPage.inactiveMessageDisplayed(inactivemessage);
    }
//sp54 new ui login
    @Step
    public void clickNewLoginAndWaitForLoading() {
        loginPage.clickNewLoginButton();
        // loginPage.waitForLoginCompleted();    //sp 20 after warning message user update pop up displaying,but not in the login time , so commented
    }
}
