package com.hhstechgroup.ui.panels;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;

import java.time.Month;

import static com.hhstechgroup.util.converters.DateConverter.toLocalDate;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.substringBefore;


public class CalendarPopUp extends BaseModalPanel {

    private static final String YEAR_HEADER = ".//div/h3";
    private static final String YEAR = ".//div[text() = '%s']";
    private static final String MONTH = ".//span[text() = 'keyboard_arrow_left']/ancestor::div[not(@class)]//p";
    private static final String MONTH_ARROW_RIGHT = ".//span[text() = 'keyboard_arrow_right']";
    private static final String MONTH_ARROW_LEFT = ".//span[text() = 'keyboard_arrow_left']";
    private static final String DAY_OF_MONTH = ".//div[@role = 'presentation']/button[@tabindex = '0']//span[text() ='%s']";
    private static final String OK_BUTTON = ".//button[span[text() = 'OK']]";
    //latest
    private static final String CLICK_TIME_CLOCK=".//button//span[contains(text(),'access_time')]";
//   private static final String CLICK_HOURSORMINUTES="..//span[contains(text(),'%s')]";
    private static final String CLICK_HOURSORMINUTES=".//div[@role='menu']";

    public void setHour(int hour) {
        String hourElement = format(CLICK_HOURSORMINUTES, hour);
        findBy(CLICK_HOURSORMINUTES).click();
    }
    public void setMinute(int minute) {
        String minuteElement = format(CLICK_HOURSORMINUTES, minute);
        findBy(CLICK_HOURSORMINUTES).click();
    }

    public CalendarPopUp(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setYear(int year) {
        String yearElement = format(YEAR, year);
        findBy(YEAR_HEADER).click();
        waitForPresenceOf(yearElement);
        action().moveToElement(findBy(yearElement)).click().build().perform();
        waitForAbsenceOf(yearElement);
    }
    private static final String YEAR1 = ".//div/h3[text() = '%s']";
    public void setYear1(int year) {
        String yearElement = format(YEAR, year);
       findBy(YEAR_HEADER).click();
       waitForAbsenceOf(yearElement);
    }

    public void setMonth(int month) {
        int currentMonth = Month.valueOf(substringBefore(findBy(MONTH).getText(), " ").toUpperCase()).getValue();
        while (currentMonth != month) {
            if (currentMonth < month) {
                findBy(MONTH_ARROW_RIGHT).click();
                currentMonth = Month.valueOf(substringBefore(findBy(MONTH).getText(), " ").toUpperCase()).getValue();
            } else if (currentMonth > month) {
                findBy(MONTH_ARROW_LEFT).click();
                currentMonth = Month.valueOf(substringBefore(findBy(MONTH).getText(), " ").toUpperCase()).getValue();
            }
        }
    }

    public void setDayOfMonth(int dayOfMonth) {
        waitForPresenceOf(format(DAY_OF_MONTH, dayOfMonth));
        findAll(format(DAY_OF_MONTH, dayOfMonth)).stream().filter(WebElementState::isCurrentlyVisible).findFirst().get().click();
        waitForCalendarPopUpClosed();
    }

    public void clickOk() {
        findBy(OK_BUTTON).click();
    }
}
