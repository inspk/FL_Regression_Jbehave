package com.hhstechgroup.ui.pages.login;
import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static java.lang.String.format;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@DefaultUrl("/login")
public class LoginPage extends ProviderManagementBasePage {

    private static final String USERNAME = "//label[@for='username']/..//input";
    //private static final String USERNAME = "//label[text()='Email (User ID)']/../div/input" ;
    private static final String PASSWORD = "//label[@for='password']/..//input";
    private static final String LOGIN_BUTTON = "//button[span[text() = 'Login']]";
    private static final String REGISTER_BUTTON = "//div[contains(@class, 'login-form')]//span[text() = 'Register']";
    private static final String FORGOT_PASS_LINK = "//a[text() = 'Forgot Password?']";
    private static final String USERNAME_ERROR_MESSAGE = ".//div[contains(@class, 'utils_field-errors')]/div";
    private static final String PASSWORD_ERROR_MESSAGE = ".//div[contains(@class, 'utils_field-errors')][2]/div";
   // private static final String INCORRECT_LOGIN_PASS_MESSAGE = ".//div[contains(@class, 'utils_field-errors')][3]/div";
   private static final String INCORRECT_LOGIN_PASS_MESSAGE = ".//div/span[contains(text(), 'Incorrect email address or password')]" ;
    public static final String LOGIN_FORM = "//div[contains(@class, 'login-form')]";
    public static final String LINK_DASHBOARD = "//a[@href='/dashboard']";
    public static final String BUTTON_UPDATE = "//span[text() = 'Update']";
    public static final String BUTTON_OK ="//span[text() = 'OK']";
    public static final String BUTTON_SKIP ="//div[contains(@class, 'joyride-tooltip-')]//button[@data-type='skip' and text() = 'Skip']";



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUsername(String username) {
        findBy(USERNAME).type(username);
    }
   /* //latest
    private static final String USER_EMAIL_ID = "//label[text()='Email (User ID)']/../div/input" ;
    public void fillUserEmailId(String username1) {
        findBy(USER_EMAIL_ID).type(username1);
    }*/

    public String getUsernameValue() {
        return findBy(USERNAME).getAttribute("value");
    }

    public String getPasswordValue() {
        return findBy(PASSWORD).getAttribute("value");
    }

    public void fillPassword(String password) {
        findBy(PASSWORD).type(password);
    }

    public void clickLoginButton() {
//        jsClick(LOGIN_BUTTON);
        findBy(LOGIN_BUTTON).click();
    }

    public void waitForLoginCompleted() {
      waitForAbsenceOf(LOGIN_BUTTON);
           try {
               withTimeoutOf(Duration.ofSeconds(3)).waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_UPDATE)));
               findBy(BUTTON_UPDATE).click();
               findBy(BUTTON_OK).click();
             //  findBy(BUTTON_SKIP).click();      //sp 20 skip is not displaying so commented
           }catch (Exception e){

           }
           //waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(LINK_DASHBOARD)));
    }


    public void clickRegisterButtonOnLoginPage() {
        findBy(REGISTER_BUTTON).click();
    }

    public void clickForgotPassLink() {
        findBy(FORGOT_PASS_LINK).click();
    }

    public boolean usernameErrorIsDisplayed(String error){
        return findBy(USERNAME_ERROR_MESSAGE).containsText(error);
    }

    public boolean passwordErrorIsDisplayed(String error){
        return findBy(PASSWORD_ERROR_MESSAGE).containsText(error);
    }

    public boolean incorrectLoginPassErrorIsDisplayed(String error){ 
        return waitForPresenceOf(INCORRECT_LOGIN_PASS_MESSAGE).containsText(error);
    }

    public boolean isLoginFormDisplayed() {
        return  findBy(LOGIN_FORM).isDisplayed();

    }
    //sp32
    public static final String INACTIVE_USER_MASSEAGE = ".//div/span[text()='%s']";
    public boolean inactiveMessageDisplayed(String inactivemessage) {
        return  findBy(format(INACTIVE_USER_MASSEAGE ,inactivemessage)).isDisplayed();
    }

    //sp54 new ui login

    private static final String NEW_LOGIN_BUTTON = "//button[span[text() = 'Login']]";

    public void clickNewLoginButton() {
        waitAbit(5000);
        jsClick(NEW_LOGIN_BUTTON);
//        findBy(NEW_LOGIN_BUTTON).click();
        waitAbit(2000);
//        findBy(NEW_LOGIN_BUTTON).click();
  //      jsClick(NEW_LOGIN_BUTTON);
    }

}