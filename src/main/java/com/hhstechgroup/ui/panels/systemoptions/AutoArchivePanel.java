package com.hhstechgroup.ui.panels.systemoptions;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import static java.lang.String.format;


public class AutoArchivePanel extends AbstractPanel {
    private static final String  SCHEDULE = ".//h3[contains(text(),'Auto Archive Data')]/../../../../../..//input[contains(@id,'RequestID')]";
    private static final String  CLICK_DROPDOWN_BUTTON = ".//h3[contains(text(),'Auto Archive Data')]/../../../../../..//div[contains(@role,'button')]";
    private static final String  PEROID  = ".//ul/li[contains(@data-value,'%s')]";

    private static final String  SCHEDULE_FILES = ".//h3[contains(text(),'Auto Archive Files')]/../../../../../..//input[contains(@id,'RequestID')]";
    private static final String  CLICK_DROPDOWN_BUTTON_FILES = ".//h3[contains(text(),'Auto Archive Files')]/../../../../../..//div[contains(@role,'button')]";

    public AutoArchivePanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage); }

    public void setSchedule(String schedule) {
        findBy(SCHEDULE).click();
        findBy(SCHEDULE).clear();
        findBy(SCHEDULE).type(schedule);
    }

    public void setPeriod(String period) {
        findBy(CLICK_DROPDOWN_BUTTON).click();
       findBy(format(PEROID,period)).click();
    }


    public void setScheduleForFiles(String scheduleForFiles) {
        findBy(SCHEDULE_FILES).click();
        findBy(SCHEDULE_FILES).clear();
        findBy(SCHEDULE_FILES).type(scheduleForFiles);

    }
    public void setPeriodForFiles(String periodForFiles) {
        waitABit(500);
        jsClick(CLICK_DROPDOWN_BUTTON_FILES);
        waitABit(500);
        findBy(format(PEROID,periodForFiles)).click();

    }






}
