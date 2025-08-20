package com.hhstechgroup.ui.panels.peportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.LocalDate;

import static java.lang.String.format;

public class SearchForRecordPanel extends AbstractPanel {

    private static final String PAYMENT_ID = ".//input[@id = 'paymentId']";
    private static final String MEMBER_ID = ".//input[@id = 'memberId']";
    private static final String MEMBER_NAME = ".//input[@id = 'memberName']";
    private static final String PERIOD_FROM_BEGIN = "(//h5[contains(text(), 'Period')]/..//input)[1]/following-sibling::div";
    private static final String PERIOD_TO_END = "(//h5[contains(text(), 'Period')]/..//input)[2]/following-sibling::div";
    private static final String CALENDAR = "//div[@role='document']";
    private static final String TCN = ".//input[@id = 'tcn']";
    private static final String SEARCH_BUTTON = ".//button[span[text() = 'Search']]";
    private final static String STATUS = ".//input[contains(@id, 'Status')]/preceding-sibling::div";
    private static final String RESET_FILTERS = ".//a[contains(@class, 'styles_action-reset')]";
    private static final String CPT_CODE = ".//input[@id = 'cptCode']";
    private static final String MEMBER_SEARCH_BY = ".//label[text() = '%s']/following-sibling::div/input";

    public SearchForRecordPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setPaymentId(String paymentId) {
        findBy(PAYMENT_ID).type(paymentId );
    }


    public void setMemberId(String memberId) {
        findBy(MEMBER_ID).type(memberId);
    }

    public void setMemberName(String memberName) {
        findBy(MEMBER_NAME).type(memberName);
    }

    public void setMemberSearchField(String searchField, String memberSearchFieldValue) {
        findBy(format(MEMBER_SEARCH_BY, searchField)).type(memberSearchFieldValue);
    }

    public void setDateFrom(String dateFrom) {
        LocalDate date = DateConverter.toLocalDate(dateFrom);
        findBy(PERIOD_FROM_BEGIN).click();
        waitForCalendarPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setYear(date.getYear());
        calendar.setMonth(date.getMonthValue());
        calendar.setDayOfMonth(date.getDayOfMonth());
    }

    public void setDateTo(String dateTo) {
        LocalDate date = DateConverter.toLocalDate(dateTo);
        findBy(PERIOD_TO_END).click();
        waitForCalendarPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setYear(date.getYear());
        calendar.setMonth(date.getMonthValue());
        calendar.setDayOfMonth(date.getDayOfMonth());
    }

    public void selectStatus(String status){
        findBy(STATUS).click();
        selectFromDropDown(status);
    }

    public void setTcn(String tcn) {
        waitABit(3000);findBy(TCN).type(tcn);
    }

    public void clickSearch() {
        waitABit(3000);
        waitForAbsenceOf(SPINNER);
        //latest
        findBy(SEARCH_BUTTON).click();
       // findBy(SEARCH_BUTTON).click();
        waitForAbsenceOf(SPINNER);
    }

    public void resetFilters(){
        findBy(RESET_FILTERS).click();
    }

    public void setCPTCode(String cptCode){
        findBy(CPT_CODE).type(cptCode);
    }
}