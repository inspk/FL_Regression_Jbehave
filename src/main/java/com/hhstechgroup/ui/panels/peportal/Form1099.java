package com.hhstechgroup.ui.panels.peportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class Form1099 extends AbstractPanel {

    private static final String VIEW_DETAILS = ".//a[span[text() = 'View details']]";
    private static final String HIDE_DETAILS = ".//a[span[text() = 'Hide details']]";

    public Form1099(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void clickViewDetails() {
        findBy(VIEW_DETAILS).click();
    }

    public void clickHideDetails() {
        findBy(HIDE_DETAILS).click();
    }
}
