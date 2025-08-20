package com.hhstechgroup.ui.panels.pedashboard;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SuccessPanel extends AbstractPanel {

    private static final String TITLE = ".//p";
    private static final String GO_TO_DASHBOARD = ".//button[span[text() = 'Go to dashboard']]";
    private static final String GO_TO_COC = ".//button[span[text() = 'Go to Change of Circumstance']]";
    private static final String GO_TO_APPEALS = ".//button[span[text() = 'Go to Appeals']]";
    private static final String GO_TO_CLAIMS = ".//button[span[text() = 'Go to Claims']]";
    private static final String NAVIGATE_TO_DASHBOARD = ".//a[contains(node(), 'Navigate to ') and @href = '/dashboard']";
    private static final String SIGN = ".//button[span[text() = 'SIGN']]";


    public SuccessPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public String getTitle() {
        StringBuilder title = new StringBuilder();
        findAll(TITLE).forEach(t -> title.append(t.getText()));
        return title.toString();
    }

    public void clickGoToDashboard() {
        findBy(GO_TO_DASHBOARD).click();
        waitForAbsenceOf(GO_TO_DASHBOARD);
    }

    public boolean isSignButtonDisplayedOnSuccessPanel() {
        return isElementPresent(SIGN);
    }

    public void clickGoToCoc() {
        findBy(GO_TO_COC).click();
        waitForAbsenceOf(GO_TO_COC);
    }

    public void clickGoToClaims() {
        findBy(GO_TO_CLAIMS).click();
        waitForAbsenceOf(GO_TO_CLAIMS);
    }

    public void clickGoToAppeals() {
        findBy(GO_TO_APPEALS).click();
        waitForAbsenceOf(GO_TO_APPEALS);
    }

    public void clickNavigateToDashboard() {
        waitABit(4000);
       jsClick(NAVIGATE_TO_DASHBOARD);
//        findBy(NAVIGATE_TO_DASHBOARD).click();
        waitABit(1000);
        //Newly replaced
    }



}
