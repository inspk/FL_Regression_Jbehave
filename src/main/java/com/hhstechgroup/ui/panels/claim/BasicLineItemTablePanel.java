package com.hhstechgroup.ui.panels.claim;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.ui.panels.enrollment.BaseTable;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.LocalDate;

public class BasicLineItemTablePanel extends BaseTable {

    private static final String SERVICE_DATE_BEGIN = ".//label[text() = 'Service date begin']/following-sibling::div//button";
    private static final String SERVICE_DATE_END = ".//label[text() = 'Service date end']/following-sibling::div//button";
    private static final String PROCEDURE_CODE = "Procedure code";
    private static final String MODIFIER_1 = "Modifier 1";
    private static final String MODIFIER_2 = "Modifier 2";
    private static final String MODIFIER_3 = "Modifier 3";
    private static final String MODIFIER_4 = "Modifier 4";
    private static final String DIAGNOSIS_POINTER_1 = "Diagnosis pointer 1";
    private static final String LINE_ITEM_CHARGE_AMOUNT = "Line item charge amount";
    private static final String CALENDAR = "//div[@role='document']";

    public BasicLineItemTablePanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setServiceDateBegin(String dateBegin) {
        LocalDate date = DateConverter.toLocalDate(dateBegin);
        findBy(SERVICE_DATE_BEGIN).click();
        waitForCalendarPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setYear(date.getYear());
        calendar.setMonth(date.getMonthValue());
        calendar.setDayOfMonth(date.getDayOfMonth());
    }

    public void setServiceDateEnd(String dateEnd) {
        LocalDate date = DateConverter.toLocalDate(dateEnd);
        findBy(SERVICE_DATE_END).click();
        waitForCalendarPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setYear(date.getYear());
        calendar.setMonth(date.getMonthValue());
        calendar.setDayOfMonth(date.getDayOfMonth());
    }

    public void setProcedureCode(String procedureCode) {
        setField(PROCEDURE_CODE, procedureCode);
    }

    public void setModifier1(String modifier) {
        setField(MODIFIER_1, modifier);
    }

    public void setModifier2(String modifier) {
        setField(MODIFIER_2, modifier);
    }

    public void setModifier3(String modifier) {
        setField(MODIFIER_3, modifier);
    }

    public void setModifier4(String modifier) {
        setField(MODIFIER_4, modifier);
    }

    public void setDiagnosisPointer(String diagnosis) {
        setField(DIAGNOSIS_POINTER_1, diagnosis);
    }

    public void setLineItemChargeAmount(String lineAmount) {
        setField(LINE_ITEM_CHARGE_AMOUNT, lineAmount);
    }

}
