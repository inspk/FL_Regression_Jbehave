package com.hhstechgroup.steps.jbehave.scenarios.registration;

import com.hhstechgroup.steps.serenity.peportalpages.DashboardSteps;
import com.hhstechgroup.steps.serenity.registration.RestorePasswordSteps;
import com.hhstechgroup.util.common.ExternalEmails;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.time.LocalDateTime;
import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RestorePasswordScenario {

    private Logger logger = Logger.getLogger(RestorePasswordScenario.class);

    @Steps
    RestorePasswordSteps restorePasswordSteps;
    @Steps
    DashboardSteps dashboardSteps;


    @Then("correct title '$title' and text '$text' is present on restore password form")
    public void verifyRestorePasswordFormTitlePresent(String title, String text) {
        assertEquals("Restore password form title is incorrect or is nor displayed", title, restorePasswordSteps.getRestorePasswordTitle());
        assertEquals("Restore password form text is incorrect or is nor displayed", text, restorePasswordSteps.getRestorePasswordText());
    }

    @When("click on Reset Password button")
    public void clickResetPassword() {
        restorePasswordSteps.clickResetPassword();
        String time = DateConverter.convert(LocalDateTime.now(), "h:mm a");
        logger.info(time);
        Serenity.setSessionVariable(ExternalEmails.RESET_PASSWORD.getValue()).to(time);
    }

    @Then("validation error '$error' is displayed for email")
    public void verifyValidationErrorPresent(String error) {
        assertTrue("Validation error is not displayed or is incorrect", restorePasswordSteps.isValidationErrorDisplayed(error));
    }

    @When("type email '$email'")
    public void typeEmail(String email) {
        restorePasswordSteps.typeEmail(email);
    }

    @When("click on Back to Login link")
    public void clickBackToLoginLink() {
        restorePasswordSteps.clickBackToLoginLink();
    }

    @Then("page title '$title' is displayed")
    public void verifyPageTitle(String pageTitle) {
        assertTrue("Title is not displayed or is incorrect", restorePasswordSteps.isPageTitleCorrect(pageTitle));
    }

    @When("type new password '$password'")
    public void typeNewPassword(String newPasswod) {
        restorePasswordSteps.enterNewPassword(newPasswod);
    }

    @When("type password '$password'")
    public void typeNewPassword1(String newPasswod) {
        restorePasswordSteps.enterNewPassword1(newPasswod);
    }

    @When("confirm new password '$password'")
    public void confirmNewPassword(String newPassword) {
        restorePasswordSteps.enterComparePassword(newPassword);
    }

    @When("click on Change Password button")
    public void clickChangePassword() {
        restorePasswordSteps.clickChangePassword();
    }

    @Then("text $text1 $text2 in form is present")
    public void verifyOneStepFormText(String text1, String text2) {
        assertTrue("Text is not present or is incorrect", restorePasswordSteps.isOneStepLeftTextPresent(text1, text2));
    }

    @When("click on Back to log in button")
    public void clickOnBackToLoginButton() {
        restorePasswordSteps.clickOnBackToLoginButton();
    }

    @Then("validation error '$error' is displayed for new password")
    public void verifyValidationErrorForNewPassword(String error) {
        assertTrue("Validation error is not displayed or is incorrect", restorePasswordSteps.isValidationErrorDisplayed(error));
    }

    @Then("validation error '$error' is displayed for confirm password")
    public void verifyValidationErrorForConfirmPassword(String error) {
        assertTrue("Validation error is not displayed or is incorrect", restorePasswordSteps.isValidationErrorDisplayed(error));
    }

    @When("click in Confirm password input field")
    public void clickInConfirmPasswordInput() {
        restorePasswordSteps.clickInComparePasswordInput();
    }

    @Then("error '$error' for invalid password is displayed")
    public void invalidPasswordErrorValidation(String error) {
        restorePasswordSteps.isInvalidPasswordErrorDisplayed(error);
    }

    @When("type forgot new password '$password'")
    public void enterForgotNewPassword(String newPassword) {
        restorePasswordSteps.enterForgotNewPassword(newPassword);
    }

    @When("confirm forgot new password '$password'")
    public void enterForgotConfirmPassword(String newPassword) {
        restorePasswordSteps.enterForgotConfirmPassword(newPassword);
    }

    @When("click on Set Password button")
    public void clickSetPassword() {
        restorePasswordSteps.clickSetPassword();
    }

    //sp24
    @Then("verify the Password Policy Pop up is displaying")
    public void isPasswordPolicyPopupOpened() {
        assertTrue(restorePasswordSteps.isPasswordPolicyPopupOpened());
    }
    @Then("click on the Ok button in the password policy popup page")
    public void clickOkButton() {
        restorePasswordSteps.clickOkButton();
    }

    //sp37 change password
    @Then("type current password '$currentPassword'")
    public void enterCurrentPassword(String currentPassword){
        restorePasswordSteps.enterCurrentPassword(currentPassword);
    }

    @When("click on back to login button for change password")
    public void clickOnBackToLoginForChangePassword(){
        restorePasswordSteps.clickOnBackToLoginForChangePassword();
    }

    @When("click on forgot password link")
    public void clickOnForgotPassword(){restorePasswordSteps.clickOnForgotPassword();}

    @Then("should show that user locked popup with '$message'")
    public void shouldShowUserLockedPopup(String message){
        assertTrue(restorePasswordSteps.shouldShowUserLockedPopup(message));
    }

}