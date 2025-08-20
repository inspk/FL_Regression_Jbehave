package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.time.LocalDate;

import static java.lang.String.format;

public class AuditSearchPanel extends AbstractPanel {

    private static final String USER_ID = ".//input[contains(@id, 'userID')]";
    private static final String USER_ROLE = ".//input[contains(@id, 'UserRole')]/preceding-sibling::div";
    private static final String USER_NAME = ".//input[contains(@id, 'userName')]";
    private static final String PORTAL = ".//input[contains(@id, 'Portal')]/preceding-sibling::div";
    private static final String PAGE = ".//input[contains(@id, 'Page')]/preceding-sibling::div";
   // private static final String EVENT_NAME = ".//label[contains(text(), 'Event names')]/..//input/preceding-sibling::div";

    //latest
    private static final String EVENT_NAME = ".//label[contains(text(), 'Event name')]/..//input/preceding-sibling::div";
    private static final String DATE_FROM = ".//label[contains(text(), 'Date from')]/parent::div//button";
    private static final String DATE_TO = ".//label[contains(text(), 'Date to')]/parent::div//button";
    private static final String TAGS = ".//label[contains(text(), 'Tags')]/..//input/preceding-sibling::div";
    private static final String ADD_PARAMETER_BUTTON = ".//div[contains(@class, 'audit_action-add')]";
    private static final String PARAMETER = ".//div[contains(@id, 'parameter')]";
    private static final String VALUE = ".//label[text() = 'Value']/following-sibling::div/input";
    private static final String SEARCH_BUTTON = ".//button[span[text() = 'Search']]";
    private static final String POP_UP = "//div[@role='document']";

    private static final String RESULT_ROW_BY_TEXT = ".//div[contains(@class, 'tile-table-row')]//p[contains(text(), '%s')]";

    private static final String TIMESTAMP_FROM =".//label[contains(text(), 'Timestamp from')]/parent::div//input";

    private static final String TIMESTAMP_TO =".//label[contains(text(), 'Timestamp to')]/parent::div//input";

    private static final String PARAMETER_VALUES ="//div[text()='%s']";


    public AuditSearchPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void addParameter() {
        findBy(ADD_PARAMETER_BUTTON).click();
    }

    public void setParameter(String parameter) {
        waitABit(2000);
        findBy(PARAMETER).click();
        selectFromDropDown(parameter);
    }

    public void setValue(String value) {
        findBy(VALUE).type(value);
    }

    public void clickSearch() {
        findBy(SEARCH_BUTTON).waitUntilEnabled();
        findBy(SEARCH_BUTTON).click();
    }

    public void setUserId(String userId) {
        waitABit(1000);
        findBy(USER_ID).type(userId);
        waitABit(500);
    }

    public void setUserRole(String userRole) {
        findBy(USER_ROLE).type(userRole);
    }

    public void setUserName(String userName) {
        findBy(USER_NAME).type(userName);
    }

    public void setPortal(String portal) {
        waitABit(2000);
        findBy(PORTAL).click();
        selectFromDropDown(portal);
        waitABit(2000);
    }

    public void setPage(String page) {
        waitABit(2000);
        scrollToElement(PAGE);
        findBy(PAGE).click();
       waitForPresenceOf(POP_UP);
        BaseModalPanel dropDown = new BaseModalPanel(findBy(POP_UP), getBasePage());
        waitABit(1000);
        dropDown.selectFromMultiChoiceDropDown(page);
        waitABit(1000);
        action().sendKeys(Keys.TAB).build().perform();
        waitForAbsenceOf(POP_UP);
    }


    public void setEventName(String eventName) {
        waitABit(4000);
        scrollToElement(EVENT_NAME);
        findBy(EVENT_NAME).click();
        waitForPresenceOf(POP_UP);
        BaseModalPanel dropDown = new BaseModalPanel(findBy(POP_UP), getBasePage());
        dropDown.selectFromMultiChoiceDropDown(eventName);
        action().sendKeys(Keys.TAB).build().perform();
        waitForAbsenceOf(POP_UP);
        waitABit(1000);
    }

    public void setDateFrom(String dateFrom) {
        LocalDate date = DateConverter.toLocalDate(dateFrom);
        findBy(DATE_FROM).click();
        waitForPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(POP_UP), getBasePage());
        calendar.setYear(date.getYear());
        calendar.setMonth(date.getMonthValue());
        calendar.setDayOfMonth(date.getDayOfMonth());
    }

    public void setDateTo(String dateTo) {
        LocalDate date = DateConverter.toLocalDate(dateTo);
        findBy(DATE_TO).click();
        waitForPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(POP_UP), getBasePage());
        calendar.setYear(date.getYear());
        calendar.setMonth(date.getMonthValue());
        calendar.setDayOfMonth(date.getDayOfMonth());
    }

    public void setTags(String tags) {
        findBy(TAGS).click();
        waitForPresenceOf(POP_UP);
        BaseModalPanel dropDown = new BaseModalPanel(findBy(POP_UP), getBasePage());
        dropDown.selectFromMultiChoiceDropDown(tags);
        action().sendKeys(Keys.TAB).build().perform();
        waitForAbsenceOf(POP_UP);
    }

    public void setTimeStampFrom(String timestampFrom){
        waitABit(200);
        findBy(TIMESTAMP_FROM).sendKeys(timestampFrom);
        waitABit(200);
    }

    public void setTimestampTo(String timestampTo){
        waitABit(200);
        findBy(TIMESTAMP_TO).sendKeys(timestampTo);
        waitABit(200);
    }

    public void setParameterValue(String parameterValues){
        waitABit(100);
        findBy(PARAMETER).click();
        waitABit(100);
  //      findBy(PARAMETER_VALUES).click();
        findBy(format(PARAMETER_VALUES, parameterValues)).click();
    }
}
