package com.hhstechgroup.ui.panels.systemoptions;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.LocalDate;

import static java.lang.String.format;

public class SecurityPalicyPanel extends AbstractPanel {

    public SecurityPalicyPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    private static final String PASSWORD_LENGTH = ".//input[contains(@name,'passwordlength')]";
    private static final String PASSWORD_REUSE = ".//input[contains(@name,'preventPasswordReuse')]";
    private static final String PASSWORD_RESET = ".//input[contains(@name,'passwordReset')]";
    private static final String PASSWORD_EXPIRATION = ".//input[contains(@name,'passwordExpiration')]";
    private static final String PASSWORD_ACCOUNT_LOCK = ".//input[contains(@name,'accountLock')]";
    private static final String PASSWORD_LOCKOUT_PERIOD = ".//input[contains(@name,'lockoutPeriod')]";
    private static final String START_EFFECTIVE_DATE = "//label[contains(text(),'Effective start *')]/..//div/input[@placeholder='MM/DD/YYYY']" ;
    private static final String CALENDAR = "//div[@role='document']";

    protected SecurityPalicyPanel(String panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setPasswordlength(String passwordlength) {
        findBy(PASSWORD_LENGTH).type(passwordlength);
    }
    public void setPreventPasswordReuse(String preventPasswordReuse) {
        findBy(PASSWORD_REUSE).type(preventPasswordReuse);
    }
    public void setPasswordReset(String passwordReset) {
        findBy(PASSWORD_RESET).type(passwordReset);
    }
    public void setPasswordExpiration(String passwordExpiration) {
        findBy(PASSWORD_EXPIRATION).type(passwordExpiration);

    }
    public void setAccountLock(String accountLock) {
        findBy(PASSWORD_ACCOUNT_LOCK).type(accountLock);
    }
    public void setLockoutPeriod(String lockoutPeriod) {
        findBy(PASSWORD_LOCKOUT_PERIOD).type(lockoutPeriod);
    }

    //sp25
    private static final String SUSPENDED_PROVIDERS_TERMINATED_NOTIFICATION= ".//span[text()='Period After which suspended Providers will be terminated']/../..//div/input[contains(@type,'number')]";
    private static final String FIRST_NOTIFICATION = ".//div[text()='1st notification']/..//div/input[contains(@type,'number')]";
    private static final String SECOND_NOTIFICATION= ".//div[text()='2nd notification']/..//div/input[contains(@type,'number')]";
    private static final String THIRD_NOTIFICATION= ".//div[text()='3rd notification']/..//div/input[contains(@type,'number')]";

    public void setSuspendedProvidersTerminated(String suspendedProvidersTerminated){
        waitABit(500);
        findBy(SUSPENDED_PROVIDERS_TERMINATED_NOTIFICATION).clear();
        waitABit(500);
        findBy(format(SUSPENDED_PROVIDERS_TERMINATED_NOTIFICATION,suspendedProvidersTerminated)).type(suspendedProvidersTerminated);
        waitABit(1000);
    }

    public void setFisrtNotification(String fisrtNotification){
        waitABit(500);
        findBy(FIRST_NOTIFICATION).clear();
        waitABit(500);
        findBy(format(FIRST_NOTIFICATION,fisrtNotification)).type(fisrtNotification);
        waitABit(1000);
    }

    public void setSecondNotification(String secondNotification){
        waitABit(500);
        findBy(SECOND_NOTIFICATION).clear();
        waitABit(500);
        findBy(format(SECOND_NOTIFICATION,secondNotification)).type(secondNotification);
        waitABit(1000);
    }

    public void setThirdNotification(String thirdNotification){
        waitABit(500);
        findBy(THIRD_NOTIFICATION).clear();
        waitABit(500);
        findBy(format(THIRD_NOTIFICATION,thirdNotification)).type(thirdNotification);
        waitABit(1000);
    }

}
