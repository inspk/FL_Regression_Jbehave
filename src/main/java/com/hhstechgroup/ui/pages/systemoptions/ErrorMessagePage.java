package com.hhstechgroup.ui.pages.systemoptions;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.util.converters.DateConverter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.lang.String.format;

public class ErrorMessagePage extends ProviderManagementBasePage {

    private static final String DOMNTIMEDROPDOWN = ".//div/span/i[@class='SVGInline SVGInline--cleaned']";
    private static final String EDIT_BUTTON = "//div//button[@type='button']";
    private static final String EFFECTIVE_FROM_DATE = ".//label[contains(text(),'Effective From')]/..//div/input";
    private static final String CLICK_TIME_CLOCK=".//button//span[contains(text(),'access_time')]";
    private static final String CLICK_HOURSORMINUTES="..//span[contains(text(),'%s')]";
    private static final String EFFECTIVE_END_DATE = ".//label[contains(text(),'End Date *')]/..//div/input";
    private static final String MESSAGE_TEXT_FIELD = ".//div/textarea[@placeholder='DyP scheduled Maintenance *']";
    private static final String CLICK_OK="//div/button[@type='button']/span[contains(text(),'OK')]";
    private static final String CALENDAR = "//div[@role='document']";
    protected static final String CALENDAR_POP_UP = ".//div[@role='document']";
    private static final String TIMECLOCK_POP_UP=".//div[@role='menu']";

    private AbstractPage basePage;

    public ErrorMessagePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSystemDownTimeDropDown() {
        scrollToElement(DOMNTIMEDROPDOWN);
        jsClick(DOMNTIMEDROPDOWN);
        waitAbit(500);
    }

        public void clickoneditbutton(){ jsClick(EDIT_BUTTON); }

        public void clickMessageField(String message){
        waitAbit(1000);
        findBy(MESSAGE_TEXT_FIELD).click();
        findBy(MESSAGE_TEXT_FIELD).type(message);
        }

        public void setEffectiveDate(String effectiveDate) {
   //   LocalDateTime date = DateConverter.toLocalDate1(effectiveDate);
       LocalDate date = DateConverter.toLocalDate1(effectiveDate);
       findBy(EFFECTIVE_FROM_DATE).click();
        waitAbit(500);
        findBy(CLICK_TIME_CLOCK).click();
        waitAbit(500);
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setHour(6);
        calendar.setMinute(5);
        findBy(CLICK_OK).click();
    }
    protected AbstractPage getBasePage() {
        return basePage;
    }
    public void waitForCalendarPopUpOpened() {
        waitForPresenceOf(CALENDAR_POP_UP);
    }

    public void waitForTimeClockPopUpOpened() {
        waitForPresenceOf(TIMECLOCK_POP_UP);
    }
    public void setEffectiveEndDate(String effectiveEndDate) {
        LocalDate date = DateConverter.toLocalDate1(effectiveEndDate);
        findBy(EFFECTIVE_END_DATE).click();
        waitAbit(500);
        findBy(CLICK_TIME_CLOCK).click();
        waitAbit(500);
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setHour(6);
        calendar.setMinute(5);
        findBy(CLICK_OK).click();
    }
}