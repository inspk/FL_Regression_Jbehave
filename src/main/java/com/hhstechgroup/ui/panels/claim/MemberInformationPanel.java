package com.hhstechgroup.ui.panels.claim;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.LocalDate;

public class MemberInformationPanel extends BaseEnrollmentPanel {

    private static final String MEMBER_ID = "Member ID";
    private static final String PREFIX = "Prefix";
    private static final String FIRST_NAME = "First name";
    private static final String LAST_NAME = "Last name";
    private static final String MI = "MI";
    private static final String SUFFIX = "Suffix";
    private static final String PHYSICAL_ADDRESS = "Physical address";
    private static final String ZIP = ".//div[@label = 'Zip']//input";
    private static final String GENDER = "Gender";
    private static final String DATE_OF_BIRTH = ".//label[text() = 'Date of birth']/following-sibling::div//button";
    private static final String CALENDAR = "//div[@role='document']";

    public MemberInformationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setMemberID(String providerID) {
        fillField(MEMBER_ID, providerID);
    }

    public void setPrefix(String prefix) {
        select(PREFIX, prefix);
    }

    public void setFirstName(String firstName) {
        fillField(FIRST_NAME, firstName);
    }

    public void setLastName(String lastName) {
        fillField(LAST_NAME, lastName);
    }

    public void setMI(String mi) {
        fillField(MI, mi);
    }

    public void setSuffix(String suffix) {
        select(SUFFIX, suffix);
    }

    public void setPhysicalAddress(String physicalAddress) {
        fillField(PHYSICAL_ADDRESS, physicalAddress);
    }

    public void setZip(String zip) {
        scrollToElement(ZIP);
        findBy(ZIP).type(zip);
    }

    public void setGender(String gender) {
        select(GENDER, gender);
    }

    public void setDateOfBirth(String dateOfBirth) {
        LocalDate date = DateConverter.toLocalDate(dateOfBirth);
        findBy(DATE_OF_BIRTH).click();
        waitForCalendarPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setYear(date.getYear());
        calendar.setMonth(date.getMonthValue());
        calendar.setDayOfMonth(date.getDayOfMonth());

    }
}
