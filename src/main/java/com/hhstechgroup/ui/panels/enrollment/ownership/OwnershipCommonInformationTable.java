package com.hhstechgroup.ui.panels.enrollment.ownership;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.ui.panels.enrollment.BaseTable;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.LocalDate;

public class OwnershipCommonInformationTable extends BaseTable {

    private final static String BUSINESS_NAME = ".//label[contains(text(), 'business name')]/parent::div//input";
    private final static String EFFECTIVE_DATE = ".//label[text() = 'Effective date']/following-sibling::div/input/following-sibling::div";
    private final static String END_DATE = ".//label[text() = 'End date']/following-sibling::div/input/following-sibling::div";
    private final static String FEIN = ".//label[contains(text(), 'FEIN')]/parent::div//input";
    private final static String SELECT_PROGRAM = ".//label[contains(text(), 'Select program')]/parent::div//input/preceding-sibling::div";
    private final static String CURRENT_MEDICARE = ".//label[contains(text(), 'Current Medicare')]/parent::div//input";
    private final static String CURRENT_NPI_API = ".//label[contains(text(), 'Current NPI/API')]/parent::div//input";
    private final static String ID_TYPE = ".//label[contains(text(), 'ID type')]/parent::div//input/preceding-sibling::div";
    private final static String COUNTRY = ".//label[contains(text(), 'Country')]/parent::div//input/preceding-sibling::div";
    private final static String ADDRESS_LINE1 = ".//label[contains(text(), 'line1')]/parent::div//input";
    private final static String ADDRESS_LINE2 = ".//label[contains(text(), 'line2')]/parent::div//input";
    private final static String CITY = ".//label[contains(text(), 'City')]/parent::div//input";
    private final static String STATE = ".//label[contains(text(), 'State')]/parent::div//input/preceding-sibling::div";
    private final static String ZIP = ".//label[contains(text(), 'Zip')]/parent::div//input";
    private static final String CALENDAR = "//div[@role='document']";


    public OwnershipCommonInformationTable(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setBusinessName(String businessName) {
        findBy(BUSINESS_NAME).type(businessName);
    }

    public void setEffectiveDate(String effectiveDate) {
        action().moveToElement(findBy(EFFECTIVE_DATE)).click().build().perform();
        LocalDate date = DateConverter.toLocalDate(effectiveDate);
        waitForCalendarPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setYear(date.getYear());
        calendar.setMonth(date.getMonthValue());
        calendar.setDayOfMonth(date.getDayOfMonth());
    }

    public void setEndDate(String endDate) {
        action().moveToElement(findBy(END_DATE)).click().build().perform();
        LocalDate date = DateConverter.toLocalDate(endDate);
        waitForCalendarPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setYear(date.getYear());
        calendar.setMonth(date.getMonthValue());
        calendar.setDayOfMonth(date.getDayOfMonth());
    }

    public void setFein(String fein) {
        findBy(FEIN).type(fein);
    }

    public void setMedicareOrTitle(String medicareOrTitle) {
        findBy(SELECT_PROGRAM).click();
        selectFromDropDown(medicareOrTitle);
    }

    public void setCurrentMedicare(String currentMedicare) {
        findBy(CURRENT_MEDICARE).type(currentMedicare);
    }

    public void setCurrentNpiApi(String currentNpiApi) {
        findBy(CURRENT_NPI_API).type(currentNpiApi);
    }

    public void setIdType(String idType) {
        findBy(ID_TYPE).click();
        selectFromDropDown(idType);
    }

    public void setCountry(String country) {
        findBy(COUNTRY).click();
        selectFromDropDown(country);
    }

    public void setAddressLine1(String addressLine1) {
        findBy(ADDRESS_LINE1).type(addressLine1);
    }

    public void setAddressLine2(String addressLine2) {
        findBy(ADDRESS_LINE2).type(addressLine2);
    }

    public void setCity(String city) {
        findBy(CITY).type(city);
    }

    public void setState(String state) {
        findBy(STATE).click();
        selectFromDropDown(state);
    }

    public void setZip(String zip) {
        findBy(ZIP).type(zip);
    }
}
