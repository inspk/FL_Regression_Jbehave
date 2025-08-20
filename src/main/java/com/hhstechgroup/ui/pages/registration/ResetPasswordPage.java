package com.hhstechgroup.ui.pages.registration;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.registration.RegistrationHeaderPanel;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage extends ProviderManagementBasePage {

    private static final String PASSWORD = ".//input[contains(@id, 'enterPassword')]";
    private static final String CONFIRM_PASSWORD = ".//label[contains(text(), 'Confirm password')]/..//input";
    private static final String SET_PASSWORD_BUTTON = ".//button/span[text() = 'Set Password']";
    private static final String CONFIRMAION_MESSAGE = ".//a[contains(@href,'dashboard')]/parent::div/preceding-sibling::p";
    private static final String GO_TO_DASHBOARD = ".//button[span[text() = 'Go to dashboard']]";
    private static final String HEADER = ".//div[contains(@class, 'header-wrapper__header__')]";


    public ResetPasswordPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationHeaderPanel getHeaderPanel() {
        return new RegistrationHeaderPanel(findBy(HEADER), this);
    }

    public void setPassword(String password) {
        findBy(PASSWORD).type(password);
    }

    public void setConfirmPassword(String password) {
        findBy(CONFIRM_PASSWORD).type(password);
    }


    public void clickSetPassword() {
        findBy(SET_PASSWORD_BUTTON).click();
    }

    public String getConfirmationMessage() {
        StringBuilder message = new StringBuilder();
        findAll(CONFIRMAION_MESSAGE).forEach(m -> message.append(m.getText()));
        return message.toString();
    }

    public void clickGoToDashboard() {
        waitForPresenceOf(GO_TO_DASHBOARD);
        findBy(GO_TO_DASHBOARD).click();
    }
}
