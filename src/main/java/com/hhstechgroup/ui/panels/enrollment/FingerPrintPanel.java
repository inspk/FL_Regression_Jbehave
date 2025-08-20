package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

public class FingerPrintPanel extends BaseEnrollmentPanel {
    //sp21
    private static final String VERIFY_FINGERPRINT =".//input[contains(@type,'radio')]";
    private static final String CLICK_OK_BUTTON=".//div/button/span[text()='Ok']";
    private static final String CLICK_CLOSE_BUTTON =".//button[@aria-label='Close']";
    //sp22
    private static final String NOTE=".//label[contains(text(), 'Note')]/../div/div/textarea[3]";
    public void setVerifyFingerPrint(String verifyFingerPrint) {
        waitABit(100);
        findBy(VERIFY_FINGERPRINT).click();
        waitABit(200);
    }
    public void setNote(String note){
        waitABit(200);
        findBy(NOTE).type(note);
        waitABit(500);
        jsClick(CLICK_OK_BUTTON);
    }

    public FingerPrintPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
}
