package com.hhstechgroup.ui.panels.pedashboard;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class MoreMenu extends BaseModalPanel {

    private static final String SITE_VISIT = ".//li[@id = 'siteList']";

    public MoreMenu(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void clickOnSiteVisit() {
        findBy(SITE_VISIT).click();
        waitForPopUpClosed();
    }
}
