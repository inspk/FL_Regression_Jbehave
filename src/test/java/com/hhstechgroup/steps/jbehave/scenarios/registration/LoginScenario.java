package com.hhstechgroup.steps.jbehave.scenarios.registration;

import com.hhstechgroup.steps.serenity.registration.LandingSteps;
import com.hhstechgroup.steps.serenity.registration.LoginSteps;
import com.hhstechgroup.util.properties.ProviderProperties;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.time.LocalDateTime;

import static com.hhstechgroup.util.converters.DateConverter.convert;
import static com.hhstechgroup.util.properties.SystemProperties.STAFF_LOGIN;
import static com.hhstechgroup.util.properties.SystemProperties.STAFF_PASSWORD;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class LoginScenario {

    @Steps
    LoginSteps loginStep;
    @Steps
    LandingSteps landingStep;


    @When ("fill Username field with value '$value'")
    public void fillUsername (String value) {
        loginStep.fillUsername(value);
    }

    /*@When ("fill User Email Id field with value '$value2'")
    public void fillUserEmailId(String value1) {
        loginStep.fillUsername(value1);
    }*/

    @When ("fill Password field with value '$value'")
    public void fillPassword (String value) {
        loginStep.fillPassword(value);
    }

    @When ("click Log In button")
    public void clickLoginButtonOnLoginPage () {
        loginStep.clickLoginButton();
    }

    @When ("click Forgot password link")
    public void clickForgotPassword () {
        loginStep.clickForgotPassLink();
    }

    @When ("click Register button on login page")
    public void clickRegisterButtonOnLoginPage () {
        loginStep.clickRegisterButtonOnLoginPage();
    }

    @When("user logs to {Provider Enrollment|Internal User} portal with username - $email and password - $password")
    public void logIn(String email, String password) {
        landingStep.clickSignRegisterButton();
        fillUsername(email);
        fillPassword(password);
        LocalDateTime logInTime = LocalDateTime.now();
        loginStep.clickLoginAndWaitForLoading();

    }
    @When("user logs to  portal with default provider")
    public void defaultLogin() {
        landingStep.clickSignRegisterButton();
        fillUsername(ProviderProperties.getData("First.Name.Provider1"));
        fillPassword(ProviderProperties.getData("Password.Provider1"));
        LocalDateTime logInTime = LocalDateTime.now();
        loginStep.clickLoginAndWaitForLoading();

    }
    @When("login as staff")
    public void loginAsStaff() {
        logIn(STAFF_LOGIN.getProperty(), STAFF_PASSWORD.getProperty());
    }

    @Then("login form should be displayed")
    public void isLoginFormDisplayed() {
        assertTrue("Login form should be displayed", loginStep.isLoginFormDisplayed());
    }

    @Then("value '$email' should be displayed in Username field")
    public void isEmailFilled(String email) {
        assertEquals("Wronf value is displayed", email, loginStep.getUsernameValue());
    }

    @Then("value '$password' should be displayed in Password field")
    public void isPasswordFilled(String password) {
        assertEquals("Wronf value is displayed", password, loginStep.getPasswordValue());
    }

    @Then("error message '$error' for username is displayed")
    public void usernameErrorIsDisplayed(String error){
        assertTrue("This field is required for username error message is not displayed", loginStep.usernameErrorIsDisplayed(error));
    }

    @Then("error message '$error' for password is displayed")
    public void passwordErrorIsDisplayed(String error){
        assertTrue("This field is required for password error message is not displayed", loginStep.passwordErrorIsDisplayed(error));
    }

    @Then("error message '$error' is displayed")
    public void commonErrorIsDisplayed(String error){
        assertTrue("This field is required for password error message is not displayed", loginStep.incorrectLoginPassErrorIsDisplayed(error));
    }
    //sp32
    @Then("verify the '$inactivemessage' is displayed")
    public boolean inactiveMessageDisplayed(String inactivemessage){
        System.out.println("Verifying button :" + inactivemessage + "is displaying in portal page");
        return loginStep.inactiveMessageDisplayed(inactivemessage);
    }

    //sp54 new ui login

    @When("new user logs to {Provider Enrollment|Internal User} portal with username - $email and password - $password")
    public void newLogIn(String email, String password) {
        fillUsername(email);
        fillPassword(password);
        LocalDateTime logInTime = LocalDateTime.now();
        loginStep.clickNewLoginAndWaitForLoading();

    }

    @When("deactivated user logs to Internal User portal with username - ${email} and password - ${password}")
    public void newLogInMCOADMIN(String email, String password) {
        String savedEmail = ProviderProperties.getData1("Email", "Individual2", "Initialized");
        fillUsername(savedEmail);
        fillPassword(password);
        LocalDateTime logInTime = LocalDateTime.now();
        loginStep.clickNewLoginAndWaitForLoading();

    }


}
