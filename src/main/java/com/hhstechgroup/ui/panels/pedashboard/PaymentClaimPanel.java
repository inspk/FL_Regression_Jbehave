package com.hhstechgroup.ui.panels.pedashboard;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class PaymentClaimPanel extends AbstractPanel{

    private static final String AMOUNT = ".//p[contains(@class, 'sum')]";
    private static final String VIEW_DETAILS = ".//div[span[text() = 'View details']]";


    public PaymentClaimPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public String getAmount() {
        return findBy(AMOUNT).getText();
    }

    public void clickViewDetails() {
        findBy(VIEW_DETAILS).click();
    }

}
