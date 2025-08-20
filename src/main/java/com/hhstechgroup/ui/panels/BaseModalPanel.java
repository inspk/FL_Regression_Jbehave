package com.hhstechgroup.ui.panels;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class BaseModalPanel extends AbstractPanel {

    private static final String DROP_DOWN_OPTION = "//div//ul[@role='listbox']//li[text()='%s']";
    private static final String DROP_DOWN = "//ul[@role='listbox']/..";
    private static final String POP_UP_HIDDEN = ".//div[contains(@class, 'alert_alert') and @aria-hidden='true']";


    public BaseModalPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void waitForPopUpClosed() {
        waitForAbsenceOf(POP_UP);
    }

    public void waitForCalendarPopUpClosed() {
        waitForAbsenceOf(CALENDAR_POP_UP);
    }

    public void selectFromDropDown(String option) {
//        waitForPresenceOf(DROP_DOWN);
        waitABit(200);
        action().moveToElement(findBy(String.format(DROP_DOWN_OPTION, option))).click().build().perform();
//        waitForAbsenceOf(DROP_DOWN);
    }

    public void selectFromMultiChoiceDropDown(String option) {
        waitForPresenceOf(DROP_DOWN);
        waitABit(2000);
        action().moveToElement(findBy(String.format(DROP_DOWN_OPTION, option))).click().build().perform();
    }
}
