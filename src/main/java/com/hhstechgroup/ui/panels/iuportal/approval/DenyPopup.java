package com.hhstechgroup.ui.panels.iuportal.approval;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class DenyPopup extends BaseModalPanel {

    private static final String DENY_BUTTON = ".//button[span[text()='Deny']]";
    private static final String REASON = ".//input[contains(@id, 'Reason')]/preceding-sibling::div";


    public DenyPopup(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }


    public void setReason(String reason) {
  //      waitForPopUpAttributeAppear();
        findBy(REASON).click();
        selectFromDropDown(reason);
    }

    public void clickDeny() {
 //       waitForPopUpAttributeAppear();
        findBy(DENY_BUTTON).click();
//        waitForPopUpClosed();
    }

}
