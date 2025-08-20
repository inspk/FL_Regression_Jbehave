package com.hhstechgroup.ui.panels.pedashboard;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class EnrollmentMiniPanel extends AbstractPanel {

    private static final String BODY =".//following-sibling::p";

    public EnrollmentMiniPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public String getBody() {
        return findBy(BODY).getText();
    }

    public void clickOnType() {
        waitABit(500);
        scrollToElement(BODY);
        findBy(BODY).click();
        waitABit(500);
//        waitForAbsenceOf(SPINNER);
    }
}
