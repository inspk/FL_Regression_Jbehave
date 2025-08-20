package com.hhstechgroup.ui.panels.systemoptions;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class LicensurePanel extends BaseEnrollmentPanel {
//sp24
    public LicensurePanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage); }

    private static final String FIRST_NOTIFICATION = ".//div[text()='1st notification']/..//div/input[contains(@type,'number')]";
    private static final String SECOND_NOTIFICATION= ".//div[text()='2nd notification']/..//div/input[contains(@type,'number')]";
    private static final String THIRD_NOTIFICATION= ".//div[text()='3rd notification']/..//div/input[contains(@type,'number')]";

    public void setFisrtNotification(String fisrtNotification){
        waitABit(500);
        findBy(FIRST_NOTIFICATION).clear();
        waitABit(500);
        findBy(format(FIRST_NOTIFICATION,fisrtNotification)).type(fisrtNotification);
        waitABit(1000);
    }

    public void setSecondNotification(String secondNotification){
        waitABit(500);
        findBy(SECOND_NOTIFICATION).clear();
        waitABit(500);
        findBy(format(SECOND_NOTIFICATION,secondNotification)).type(secondNotification);
        waitABit(1000);
    }

    public void setThirdNotification(String thirdNotification){
        waitABit(500);
        findBy(THIRD_NOTIFICATION).clear();
        waitABit(500);
        findBy(format(THIRD_NOTIFICATION,thirdNotification)).type(thirdNotification);
        waitABit(1000);
    }
}


