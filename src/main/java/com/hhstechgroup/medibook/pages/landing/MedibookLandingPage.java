package com.hhstechgroup.medibook.pages.landing;

import com.hhstechgroup.medibook.pages.MedibookBasePage;
import com.hhstechgroup.medibook.panels.MedibookLandingPanel;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;


public class MedibookLandingPage extends MedibookBasePage {

    private static final String LANDING_HEADER_PANEL = "//p[text()='Get all the information about your members in just a minute']/parent::div";
    private static final String USERNAME = "//label[text()='Email']/parent::div//input[@name='email']";
    private static final String PASSWORD = "//label[text()='Password']/parent::div//input[@type='password']";
    private static final String USERNAME_ERROR_MESSAGE = ".//label[text()='Email']/parent::div//p";
    private static final String PASSWORD_ERROR_MESSAGE = ".//label[text()='Password']/parent::div//p";
    private static final String INCORRECT_LOGIN_PASS_MESSAGE = ".//div[text()='Sign in']/parent::div//div[4]";
    private static final String LOGOUT = "//div[text()='%s']/*[local-name() = 'svg' and @aria-hidden='true']";

    public MedibookLandingPanel getMedibookLandingPanel () {
        return new MedibookLandingPanel(findBy(LANDING_HEADER_PANEL), this);
    }

    public MedibookLandingPage(WebDriver driver) {
        super(driver);
    }

    public void fillUsername(String username) {
        findBy(USERNAME).type(username);
    }

    public void fillPassword(String password) {
        findBy(PASSWORD).type(password);
    }

    public String getUsernameValue() {
        return findBy(USERNAME).getAttribute("value");
    }

    public String getPasswordValue() {
        return findBy(PASSWORD).getAttribute("value");
    }

    public boolean usernameErrorIsDisplayed(String error){
        return findBy(USERNAME_ERROR_MESSAGE).containsText(error);
    }

    public boolean passwordErrorIsDisplayed(String error){
        return findBy(PASSWORD_ERROR_MESSAGE).containsText(error);
    }

    public boolean incorrectLoginPassErrorIsDisplayed(String error){
        waitAbit(500);
        return waitForPresenceOf(INCORRECT_LOGIN_PASS_MESSAGE).containsText(error);
    }
    public void logOutFromMedibookAs (String name) {
        findBy(format(LOGOUT, name)).click();
    }


}