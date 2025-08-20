package com.hhstechgroup.ui.pages.chat;

import com.hhstechgroup.util.webdriver.PrivateWebDriver;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.hhstechgroup.util.properties.SystemProperties.ROCKET_CHAT_LOGIN;
import static com.hhstechgroup.util.properties.SystemProperties.ROCKET_CHAT_PASSWORD;
import static com.hhstechgroup.util.properties.SystemProperties.ROCKET_CHAT_URL;

public class RocketChatPage extends PageObject {

    private static final String LOGIN = ".//form[@id = 'login-card']//div//input[contains(@id, 'emailOrUsername')]";
    private static final String PASSWORD = ".//form[@id = 'login-card']//div//input[contains(@id, 'pass')]";
    private static final String LOG_IN_BUTTON = ".//form[@id = 'login-card']//div[@class = 'submit']//button";
    private static final String USER = ".//div[contains(@class, 'livechat-section')]//li/a[@title = '%s']";
    private static final String USER_MESSAGE = ".//ul[@aria-live='polite']//li//span/following-sibling::div[contains(@class, 'body')]";

    private WebDriver privateDriver;

    public RocketChatPage(WebDriver driver) {
        super(driver);
        privateDriver = PrivateWebDriver.getInstance().runInPrivateMode(getDriver());
        setDriver(privateDriver);
    }

    private void navigateToRocketChat() {
        privateDriver.manage().window().maximize();
        privateDriver.get(ROCKET_CHAT_URL.getProperty());
    }

    private void setLogin() {
        privateDriver.findElement(By.xpath(LOGIN)).sendKeys(ROCKET_CHAT_LOGIN.getProperty());
    }

    private void setPassword() {
        privateDriver.findElement(By.xpath(PASSWORD)).sendKeys(ROCKET_CHAT_PASSWORD.getProperty());
    }

    private void submit() {
        privateDriver.findElement(By.xpath(LOG_IN_BUTTON)).click();
    }

    public void logInToRocketChat() {
        navigateToRocketChat();
        setLogin();
        setPassword();
        submit();
    }

    public void closeChat() {
        privateDriver.close();
    }

    public boolean isUserPresent(String user) {
        return privateDriver.findElement(By.xpath(String.format(USER, user))).isDisplayed();
    }

    public String getMessageFromUser(String user) {
        privateDriver.findElement(By.xpath(String.format(USER, user))).click();
        return privateDriver.findElement(By.xpath(USER_MESSAGE)).getText();
    }

}
