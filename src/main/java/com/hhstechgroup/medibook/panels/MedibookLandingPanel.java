package com.hhstechgroup.medibook.panels;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class MedibookLandingPanel extends AbstractPanel {

    private static final String BUTTON = ".//span[text() = '%s']";

    public MedibookLandingPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void clickOnButton(String button) {
        findBy(String.format(BUTTON, button)).click();
    }

}