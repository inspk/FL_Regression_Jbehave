package com.hhstechgroup.ui.panels.enrollment.licensure;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.ui.panels.enrollment.BaseTable;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.LocalDate;

public class LicensureTable extends BaseTable {

    private final static String LCAE_NUMBER = ".//label[contains(text(), 'LCAE')]/parent::div//input";
    private final static String TYPE = ".//label[contains(text(), 'Type')]/parent::div//input/preceding-sibling::div";
    private final static String STATE = ".//label[contains(text(), 'State')]/parent::div//input/preceding-sibling::div";
    private final static String EFFECTIVE_DATE = ".//label[text() = 'Effective date']/following-sibling::div/input/following-sibling::div/button";
    private final static String EXPIRATION_DATE = ".//label[text() = 'Expiration date']/following-sibling::div/input/following-sibling::div/button";
    private static final String CALENDAR = "//div[@role='document']";
    private final static String TAXONOMY_NUMBER = ".//label[contains(text(), 'Taxonomy number')]/parent::div//input";


    public LicensureTable(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setLcaeNumber(String number) {
        findBy(LCAE_NUMBER).type(number);
    }
    public void setTaxonomyNumber(String number) {
        findBy(TAXONOMY_NUMBER).type(number);
    }

    public void setType(String type) {
        findBy(TYPE).click();
        selectFromDropDown(type);
    }

    public void setState(String state) {
        findBy(STATE).click();
        selectFromDropDown(state);
    }

    public void setEffectiveDate(String effectiveDate) {
        LocalDate date = DateConverter.toLocalDate(effectiveDate);
        findBy(EFFECTIVE_DATE).click();
        waitForCalendarPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setYear(date.getYear());
        waitABit(500);
        calendar.setMonth(date.getMonthValue());
        waitABit(500);
        calendar.setDayOfMonth(date.getDayOfMonth());
        waitABit(500);
    }

    public void setExpirationDate(String expirationDate) {
        LocalDate date = DateConverter.toLocalDate(expirationDate);
        findBy(EXPIRATION_DATE).click();
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
