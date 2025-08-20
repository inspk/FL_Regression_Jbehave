package com.hhstechgroup.ui.pages.registration;


import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.registration.RegistrationHeaderPanel;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class RestorePasswordPage extends ProviderManagementBasePage {

    private static final String RESTORE_PASSWORD_TEXT = ".//h1";
    private static final String ENTER_EMAIL_TEXT = ".//p";
    private static final String RESET_PASSWORD_BUTTON = ".//button[contains(@type, 'submit')]";
    private static final String VALIDATION_ERROR = ".//div[contains(@class, 'utils_field-errors_')]";
    private static final String EMAIL_INPUT = ".//input[contains(@id, 'email')]";
    private static final String BACK_TO_LOGIN = ".//a[text() = 'Back to Log in']";
    private static final String NEW_PASSWORD_INPUT = ".//input[contains(@id, 'newPassword')]";
    private static final String NEW_PASSWORD_INPUT1 = ".//input[contains(@id, 'password')]";
    private static final String COMPARE_PASSWORD_INPUT = ".//input[contains(@id, 'newPasswordToCompare')]";
    private static final String CHANGE_PASSWORD_BUTTON = ".//span[text()='Change Password']";
    private static final String ONE_STEP_LEFT_TEXT = ".//div[contains(@class, 'MuiPaper-root-')]//p";
    private static final String CHECK_EMAIL_TEXT = ".//div[contains(@class, 'MuiPaper-root-')]//p[2]";
    private static final String BACK_TO_LOGIN_BUTTON = ".//span[text()='Back to log in']";
    private static final String INVALID_PASSWORD_ERROR = ".//div[contains(@class, 'utils_field-error_')]/span";
    private static final String HEADER = ".//div[contains(@class, 'header-wrapper_header_')]";



    public RestorePasswordPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationHeaderPanel getHeaderPanel() {
        return new RegistrationHeaderPanel(findBy(HEADER), this);
    }

    public boolean isRestorePasswordTextPresent(){
        return findBy(RESTORE_PASSWORD_TEXT).containsText("Restore your password") && findBy(ENTER_EMAIL_TEXT).containsText("Please enter your email address to retrieve your password.");
    }

    public String getRestorePasswordTitle() {
        return findBy(RESTORE_PASSWORD_TEXT).getText();
    }

    public String getRestorePasswordText() {
        return findBy(ENTER_EMAIL_TEXT).getText();
    }

    public void clickResetPassword(){
        findBy(RESET_PASSWORD_BUTTON).click();
    }

    public boolean isValidationErrorDisplayed(String error){
        return findBy(VALIDATION_ERROR).containsText(error);
    }

    public void typeEmail(String email){
        findBy(EMAIL_INPUT).type(email);
    }

    public void clickBackToLoginLink(){
        findBy(BACK_TO_LOGIN).click();
    }

    public void enterNewPassword(String newPassword){
        String currentTab = getDriver().getWindowHandle();
        System.out.println(currentTab);
        findBy(NEW_PASSWORD_INPUT).type(newPassword);
    }

    public void enterNewPassword1(String newPassword){
        String currentTab = getDriver().getWindowHandle();
        System.out.println(currentTab);
        findBy(NEW_PASSWORD_INPUT1).click();
        waitAbit(2000);
        findBy(NEW_PASSWORD_INPUT1).type(newPassword);
    }

    public void enterComparePassword(String newPassword){
        findBy(COMPARE_PASSWORD_INPUT).type(newPassword);
    }

    public void clickChangePassword(){
        findBy(CHANGE_PASSWORD_BUTTON).click();
    }

    public boolean isOneStepLeftTextPresent(String text1, String text2){
        return findBy(ONE_STEP_LEFT_TEXT).containsText(text1) && findBy(CHECK_EMAIL_TEXT).containsText(text2);
    }

    public void clickOnBackToLoginButton(){
        findBy(BACK_TO_LOGIN_BUTTON).click();
    }

    public void clickInComparePasswordField(){
        findBy(COMPARE_PASSWORD_INPUT).click();
    }

    public boolean isInvalidPasswordErrorDisplayed(String error){
        return findBy(INVALID_PASSWORD_ERROR).containsText(error);
    }


    private static final String FORGOT_NEWPASSWORD = ".//input[@id='newPassword']";
    private static final String FORGOT_CONFIRM_PASSWORD = ".//label[contains(text(),'Confirm password')]/..//input[contains(@type, 'password')]";
    private static final String  SET_PASSWORD= ".//span[text()='Change Password']";


    public void enterForgotNewPassword(String newPassword){
        String currentTab = getDriver().getWindowHandle();
        System.out.println(currentTab);
        findBy(FORGOT_NEWPASSWORD).type(newPassword);
    }

    public void enterForgotConfirmPassword(String newPassword)
    {
        findBy(FORGOT_CONFIRM_PASSWORD).type(newPassword);
    }

    public void clickSetPassword(){

        findBy(SET_PASSWORD).click();
    }

    //sp24
    private static final String PASSWORD_POPUP = "//h2[contains(text(), 'Password Policy')]/../parent::div";
    public boolean isPasswordPolicyPopupOpened() {
        waitAbit(500);
        return isElementPresent(PASSWORD_POPUP);
    }
    private static final String CLICK_OK_BUTTON = ".//button/span[text()='OK']/..";
    public void clickOkButton(){
        waitAbit(500);
        jsClick(CLICK_OK_BUTTON);
        waitAbit(500);
    }

    //sp37 change password
    private static final String CURRENT_PASSWORD_INPUT = ".//input[contains(@id, 'oldPassword')]";
    public void enterCurrentPassword(String currentPassword){
        String currentTab = getDriver().getWindowHandle();
        System.out.println(currentTab);
        findBy(CURRENT_PASSWORD_INPUT ).type(currentPassword);
    }
    private static final String BACK_TO_LOGIN_CHANGE_PASSWORD = ".//button/span[contains(text(),'BACK TO LOG IN')]";
    public void clickOnBackToLoginForChangePassword(){
        findBy(BACK_TO_LOGIN_CHANGE_PASSWORD).click();
    }

    private static final String FORGOT_PASSWORD_LINK = ".//div/a[contains(text(),'Forgot password')]";
    public void clickOnForgotPassword(){
        waitAbit(200);
        //findBy(FORGOT_PASSWORD_LINK).click();
        jsClick(FORGOT_PASSWORD_LINK);
        waitAbit(200);
    }

    private static final String USER_LOCKED_POPUP_MESSAGE = "//div[@role='dialog']//h2[text()='%s']";
    public boolean shouldShowUserLockedPopup(String message) {
        if(isElementPresent(format(USER_LOCKED_POPUP_MESSAGE, message))){
            clickOkButton();
            return true;
        }
        else
            return false;
    }

}