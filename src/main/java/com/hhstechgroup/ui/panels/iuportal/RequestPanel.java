package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

public class RequestPanel extends AbstractPanel {

    private static final String ACTIONS_BUTTON = ".//div[contains(@class, 'expansion-panel-menu')]/button";
    private static final String ACTIONS_LINK = ".//div[contains(@class, '_action')]/span[text() = '%s']";
    protected static final String DROP_DOWN_OPTION = "//ul/li[text() = '%s']";
    private static final String LOADING_SPINNER_BAR = ".//div[@id = 'loading-bar-spinner']/div[@class = 'spinner-icon']";


    public RequestPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void selectAction(String action) {
        waitForAbsenceOf(LOADING_SPINNER_BAR);
        scrollToElement(ACTIONS_BUTTON);
        findBy(ACTIONS_BUTTON).click();
        waitABit(200);
        action().moveToElement(findBy(String.format(DROP_DOWN_OPTION, action))).click().build().perform();
    }

    public void clickOnActionLink(String link) {
        findBy(String.format(ACTIONS_LINK, link)).click();
    }

    public void closeActionsPopUp() {
        action().sendKeys(Keys.TAB).build().perform();
        waitABit(300);
    }

}
