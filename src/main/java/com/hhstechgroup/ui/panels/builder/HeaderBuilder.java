package com.hhstechgroup.ui.panels.builder;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

public class HeaderBuilder extends AbstractPanel {

    private static final String APPLICATION_NAME = ".//div[contains(@class,'header_applicationName_')]//div";
    private static final String APPLICATION_TEXTAREA = ".//div[contains(@class,'header_applicationName_')]//textarea";

    public HeaderBuilder(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setApplicationName(String applicationName) {
        if (!isElementPresent(APPLICATION_TEXTAREA)) {
            findBy(APPLICATION_NAME).click();
            waitForPresenceOf(APPLICATION_TEXTAREA);
        }
        findBy(APPLICATION_TEXTAREA).type(applicationName);
        action().sendKeys(Keys.ENTER).build().perform();
    }

    public String getApplicationName() {
        return findBy(APPLICATION_NAME).getText();
    }
}
