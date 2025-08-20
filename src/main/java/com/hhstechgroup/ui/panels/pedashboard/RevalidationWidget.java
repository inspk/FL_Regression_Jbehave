package com.hhstechgroup.ui.panels.pedashboard;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class RevalidationWidget extends AbstractPanel {

    private static final String TITLE = ".//h3";
    private static final String REVALIDATION_DESCRIPTION = ".//p";
    private static final String REVALIDATION_MISSED_DESCRIPTION = ".//h2";
    private static final String CREATE_REVALIDATION_BUTTON = ".//button";




    public RevalidationWidget(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public String getTitle() {
        return findBy(TITLE).getText();
    }

    public String getRevalidationDescription() {
        return findBy(REVALIDATION_DESCRIPTION).getText();
    }

    public String getRevalidationMissedDescription() {
        return findBy(REVALIDATION_MISSED_DESCRIPTION).getText();
    }

    public void clickRevalidationButton() {
        findBy(CREATE_REVALIDATION_BUTTON).waitUntilClickable();
        findBy(CREATE_REVALIDATION_BUTTON).click();
    }


}
