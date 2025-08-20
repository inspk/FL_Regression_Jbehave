package com.hhstechgroup.ui.panels.sitevisit;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.LocalDate;

public class DatesAndReasonPanel extends BaseEnrollmentPanel {

    private static final String DATE_ORDERED = ".//label[text() = 'Date Ordered']/following-sibling::div//button";
    private static final String DATE_OF_FIRST_VISIT = ".//label[text() = 'Date of First Visit *']/following-sibling::div//button";
    private static final String DATE_OF_SECOND_VISIT = ".//label[text() = 'Date of Second Visit *']/following-sibling::div//button";
    private static final String REASON_FOR_VISIT = "Please select reason";
    private static final String CALENDAR = "//div[@role='document']";


    public DatesAndReasonPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setReasonForVisit(String reasonForVisit) {
        setCheckbox(REASON_FOR_VISIT, reasonForVisit);
    }

    public void setDateOrdered(String dateOrdered) {
        setDate(DATE_ORDERED, dateOrdered);
    }

    public void setDateOfFirstVisit(String dateOfFirstVisit) {
        setDate(DATE_OF_FIRST_VISIT, dateOfFirstVisit);
    }

    public void setDateOfSecondVisit(String dateOfSecondVisit) {
        setDate(DATE_OF_SECOND_VISIT, dateOfSecondVisit);
    }

    private void setDate(String locator, String dateValue) {
        LocalDate date = DateConverter.toLocalDate(dateValue);
        scrollToElement(locator);
        findBy(locator).waitUntilClickable().click();
        waitForPresenceOf(CALENDAR);
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setYear(date.getYear());
        calendar.setMonth(date.getMonthValue());
        calendar.setDayOfMonth(date.getDayOfMonth());
    }
}
