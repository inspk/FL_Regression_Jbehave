package com.hhstechgroup.ui.pages.sitevisit;
import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class UserDeactivationPage extends ProviderManagementBasePage {

    //private static final String  USER_EDIT_BUTTON = "//div//button[@type='button']";
    //sp66
    private static final String  USER_EDIT_BUTTON = "//div[contains(text(),'User Inactivity')]//button/span[contains(text(),'Edit')]";
    private static final String  INTERNALUSER_INACTIVE_DAYS= "(.//div /input[@id='requestID'])[1]";
    private static final String  INTERNALUSER_INVITATION_NOT_ACCEPTABLE_DAYS= "(.//div /input[@id='RequestID'])[1]";

    private static final String  PROVIDER_INACTIVE_DAYS= "(.//div /input[@id='requestID'])[2]";
    private static final String  PROVIDER_INVITATION_NOT_ACCEPTABLE_DAYS= "(.//div /input[@id='RequestID'])[2]";
    private static final String USER_CLICK_SAVE_BUTTON = ".//div/button/span[text()='Save']";
    public UserDeactivationPage(WebDriver driver) {  super(driver); }

    public void clickOnEdit(){ jsClick(USER_EDIT_BUTTON);waitAbit(1000); }
    public void setInactiveDays1(String days) {
        scrollToElement(INTERNALUSER_INACTIVE_DAYS);
        findBy(INTERNALUSER_INACTIVE_DAYS).click();
        findBy(INTERNALUSER_INACTIVE_DAYS).clear();
        findBy(INTERNALUSER_INACTIVE_DAYS).type(days);waitAbit(1000);
       }
    public void setInvitationNotAcceptableDays1(String days) {
        scrollToElement(INTERNALUSER_INVITATION_NOT_ACCEPTABLE_DAYS);
        findBy(INTERNALUSER_INVITATION_NOT_ACCEPTABLE_DAYS).click();
        findBy(INTERNALUSER_INVITATION_NOT_ACCEPTABLE_DAYS).clear();
        findBy(INTERNALUSER_INVITATION_NOT_ACCEPTABLE_DAYS).type(days);
        waitAbit(500); }

    public void setInactiveDays2(String days) {
        scrollToElement(PROVIDER_INACTIVE_DAYS);
        findBy(PROVIDER_INACTIVE_DAYS).click();
        findBy(PROVIDER_INACTIVE_DAYS).clear();
        findBy(PROVIDER_INACTIVE_DAYS).type(days);waitAbit(1000);
    }
    public void setInvitationNotAcceptableDays2(String days) {
        scrollToElement(PROVIDER_INVITATION_NOT_ACCEPTABLE_DAYS);
        findBy(PROVIDER_INVITATION_NOT_ACCEPTABLE_DAYS).click();
        findBy(PROVIDER_INVITATION_NOT_ACCEPTABLE_DAYS).clear();
        findBy(PROVIDER_INVITATION_NOT_ACCEPTABLE_DAYS).type(days);
        waitAbit(500); }

        //sp26

    private static final String OK = ".//span[contains(text(),'OK')]"  ;
    public void clickOnSave(){
        jsClick(USER_CLICK_SAVE_BUTTON);
        waitAbit(200);
        jsClick(OK);
        waitAbit(200);
    }

    //sp23

    private static final String USER_DEACTIVATION_DATE = ".//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;
    public void setUserDeactivationDate(String userDeactivationDate) {
        scrollToElement(USER_DEACTIVATION_DATE);
        jsClick(USER_DEACTIVATION_DATE);
        findBy(format(USER_DEACTIVATION_DATE,userDeactivationDate)).sendKeys(userDeactivationDate);

    }
// sp 25
    private static final String USER_END_DATE = ".//label[text()='Effective end']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;
    public void setEffectiveEndDate(String endDate) {
        scrollToElement(USER_END_DATE);
        jsClick(USER_END_DATE);
        findBy(format(USER_END_DATE,endDate)).sendKeys(endDate);

    }

    // sp 26
    private static final String USER_CLICK_CANCEL_BUTTON = ".//div/button/span[text()='Cancel']";
    private static final String EXIT = ".//span[contains(text(),'EXIT')]"  ;
    public void clickOnCancel(){
        jsClick(USER_CLICK_CANCEL_BUTTON);
        waitAbit(200);
        jsClick(EXIT);
        waitAbit(200);
    }



}
