package com.hhstechgroup.ui.panels.iuportal.approval;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import com.hhstechgroup.util.common.Wait;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class ApprovePopup extends BaseModalPanel {

    private static final String APPROVE_BUTTON = ".//button[span[text()='Approve']]";
    private static final String REASON = ".//input[contains(@id, 'Reason')]/preceding-sibling::div";


    public ApprovePopup(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }


    public void setReason(String reason) {
  //      waitForPopUpAttributeAppear();
        findBy(REASON).click();
        selectFromDropDown(reason);
    }

    public void clickApprove() {
   //     waitForPopUpAttributeAppear();
        findBy(APPROVE_BUTTON).click();
//        waitForPopUpClosed();
    }

}
