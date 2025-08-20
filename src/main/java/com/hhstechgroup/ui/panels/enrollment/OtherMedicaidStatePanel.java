package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.LocalDate;

public class OtherMedicaidStatePanel extends BaseEnrollmentPanel {
    //sp26
    private final static String OTHER_MEDICAID_STATE = ".//label[contains(text(), 'Other Medicaid state')]/parent::div";
    private final static String STATE_PROGRAM = ".//label[contains(text(), 'State program')]/parent::div//input/preceding-sibling::div";
    private final static String ENROLLMENT_BEGIN_DATE = ".//label[text() = 'Enrollment begin date']/following-sibling::div/input/following-sibling::div/button";
    private final static String ENROLLMENT_END_DATE = ".//label[text() = 'Enrollment end date']/following-sibling::div/input/following-sibling::div/button";
    private static final String CALENDAR = "//div[@role='document']";

    public OtherMedicaidStatePanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setOtherMedicaidState(String otherMedicaidState){
        findBy(OTHER_MEDICAID_STATE).click();
        selectFromDropDown(otherMedicaidState);
        waitABit(500);
    }

    public void setStateProgram(String stateProgram){
        waitABit(500);
        findBy(STATE_PROGRAM).click();
        selectFromDropDown(stateProgram);
    }

    public void setEnrollmentBeginDate(String enrollmentBeginDate) {
        LocalDate date = DateConverter.toLocalDate(enrollmentBeginDate);
        findBy(ENROLLMENT_BEGIN_DATE).click();
        waitForCalendarPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setYear(date.getYear());
        waitABit(500);
        calendar.setMonth(date.getMonthValue());
        waitABit(500);
        calendar.setDayOfMonth(date.getDayOfMonth());
        waitABit(500);
    }

    public void setEnrollmentEndDate(String enrollmentEndDate) {
        LocalDate date = DateConverter.toLocalDate(enrollmentEndDate);
        findBy(ENROLLMENT_END_DATE).click();
        waitForCalendarPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setYear(date.getYear());
        waitABit(1000);
        calendar.setMonth(date.getMonthValue());
        waitABit(1000);
        calendar.setDayOfMonth(date.getDayOfMonth());
        waitABit(1000);
    }
}
