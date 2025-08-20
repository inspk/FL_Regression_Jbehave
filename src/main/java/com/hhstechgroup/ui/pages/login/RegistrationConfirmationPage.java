package com.hhstechgroup.ui.pages.login;
import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static java.lang.String.format;

public class RegistrationConfirmationPage extends ProviderManagementBasePage {
    private static final String REG_CONFIRM_PAGE_NAME = "//div[contains(@class, 'header-wrapper_menu-container')]//span[text() = 'Registration Confirmation']";
    private static final String REGISTRATION_NOTCONFIRMED_TEXT = "//div[contains(@class, 'header-wrapper_body')]//h1";

    public RegistrationConfirmationPage (WebDriver driver) {
        super(driver);
    }

    public boolean isRegistrationConfirmationPageDisplayed() {
        waitForPresenceOf(REG_CONFIRM_PAGE_NAME);
        return findBy(REG_CONFIRM_PAGE_NAME).isDisplayed();

    }

    public boolean registrationNotConfirmedTextIsDisplayed(String text){
        return findBy(REGISTRATION_NOTCONFIRMED_TEXT).containsText(text);

    }

    //SD-SP-03

    private static final String  LEGAL_DISCLAIMER = ".//div/p[contains(text(),'%s')]" ;

    public String getValidationLegalDisclaimerMessage(String field) {
        waitAbit(4000);
        return findBy(format(LEGAL_DISCLAIMER, field)).getText();

    }

    private static final String PRIVACY_LINK = ".//div//a[text()='%s']";

    public String getValidationLinks(String field) {
        return findBy(format(PRIVACY_LINK, field)).getText();
    }

    public void clickOnLegalPrivacyLinks( String field){
        findBy(format(PRIVACY_LINK, field)).click();
        waitAbit(3000);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        waitAbit(2000);
    }



}
