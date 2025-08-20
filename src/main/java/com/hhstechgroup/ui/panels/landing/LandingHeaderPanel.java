package com.hhstechgroup.ui.panels.landing;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

public class LandingHeaderPanel extends AbstractPanel {

    private static final String SIGN_REGISTER_BUTTON = ".//span[text() = 'Sign In / Register']";
    private static final String TAB = ".//nav//a[text() = '%s']";

    public LandingHeaderPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void clickSignRegisterButton() {
        findBy(SIGN_REGISTER_BUTTON).click();
    }

    public void clickOnTab(String tab) {
        findBy(String.format(TAB, tab)).click();
    }

}
