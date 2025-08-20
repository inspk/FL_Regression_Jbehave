package com.hhstechgroup.ui.panels.iuportal;


import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import net.serenitybdd.core.pages.WebElementFacade;



public class ReactivationPopup extends BaseModalPanel {

    private static final String REACTIVATE_BUTTON = ".//button[span[text()='Reactivate']]";
    private static final String REASON = ".//input[contains(@id, 'Reason')]/preceding-sibling::div";


    public ReactivationPopup(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }


    public void setReason(String reason) {
        waitForPopUpAttributeAppear();
        findBy(REASON).click();
        selectFromDropDown(reason);
    }

    public void clickReactivate() {
        waitForPopUpAttributeAppear();
        findBy(REACTIVATE_BUTTON).click();
        waitForPopUpClosed();
    }

}
