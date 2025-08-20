package com.hhstechgroup.ui.panels.claim;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class BasicLineItemInformationPanel extends BaseEnrollmentPanel {

    private static final String TOTAL_CLAIM_CHARGE = ".//div[@label='Total claim charge amount:']/input";
    private static final String LINE_ITEM_INFORMATION_TABLE = ".//div[h4[contains(text() , 'Service Line Summary')]]/following-sibling::div//div[table]/ancestor::div[2]";
    private static final String SUBMIT_BUTTON = ".//button[span[text() = 'Submit']]";

    public BasicLineItemInformationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public BasicLineItemTablePanel getBasicLineItemTable() {
        scrollToElement(LINE_ITEM_INFORMATION_TABLE);
        return new BasicLineItemTablePanel(findBy(LINE_ITEM_INFORMATION_TABLE), getBasePage());
    }

    public void setTotalClaimChargeAmount(String amount) {
        scrollToElement(TOTAL_CLAIM_CHARGE);
        findBy(TOTAL_CLAIM_CHARGE).type(amount);
    }

    public void clickSubmit() {
        scrollToElement(SUBMIT_BUTTON);
        findBy(SUBMIT_BUTTON).waitUntilClickable().click();
        waitForAbsenceOf(SUBMIT_BUTTON);
    }

}
