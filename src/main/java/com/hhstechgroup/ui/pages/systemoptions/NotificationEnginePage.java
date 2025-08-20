package com.hhstechgroup.ui.pages.systemoptions;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class NotificationEnginePage extends ProviderManagementBasePage {

    public NotificationEnginePage(WebDriver driver) {
        super(driver);
    }

    private static final String EDIT_BUTTON = ".//div[contains(text(),'Notification Engine')]/..//following-sibling::div//span[text()='Edit']";
    private static final String EFFECTIVE_START_DATE = ".//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;
    private static final String EFFECTIVE_END_DATE = ".//label[text()='Effective end ']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;
    private static final String ENABLE_MESSAGE_NOTIFICATION = ".//div[contains(text(),'%s')]/..//div/label//span/input[@name='MessageNotification' and @type='checkbox']";
    private static final String ENABLE_EMAIL_NOTIFICATION = ".//div[contains(text(),'%s')]/..//div/label//span/input[@name='EmailNotification' and @type='checkbox']";
    private static final String SAVE_BUTTON = ".//button/span[contains(text(),'Save')]";
    private static final String CANCEL_BUTTON = ".//button/span[contains(text(),'Cancel')]";
    private static final String OK_BUTTON = ".//button/span[contains(text(),'OK')]";
    private static final String REGISTERED_EMAIL_BUTTON = ".//span/input[@name='RegisteredEmailTrigger']";
    private static final String APPLICATION_EMAIL_BUTTON = ".//span/input[@name='ApplicationEmailTrigger']";
    private static final String ALERT_DIALOG = ".//div/p[contains(@id, 'alert-dialog')]";

    public void clickoneditbutton(){
        jsClick(EDIT_BUTTON);
        waitAbit(2000);
    }

    public void setEffectiveStartDate(String effectiveStartDate) {
        scrollToElement(EFFECTIVE_START_DATE);
        jsClick(EFFECTIVE_START_DATE);
        findBy(EFFECTIVE_START_DATE).sendKeys(effectiveStartDate);
    }

    public void setEffectiveEndDate(String effectiveEndDate) {
        scrollToElement(EFFECTIVE_END_DATE);
        jsClick(EFFECTIVE_END_DATE);
        findBy(EFFECTIVE_END_DATE).sendKeys(effectiveEndDate);
    }

    public void clickOnMessageNotification(String infoType){
        scrollToElement(format(ENABLE_MESSAGE_NOTIFICATION, infoType));
        waitAbit(500);
        findBy(format(ENABLE_MESSAGE_NOTIFICATION, infoType)).click();
        waitAbit(1000);
    }

    public void clickOnEmailNotification(String infoType){
        scrollToElement(format(ENABLE_EMAIL_NOTIFICATION, infoType));
        waitAbit(500);
        findBy(format(ENABLE_EMAIL_NOTIFICATION, infoType)).click();
        waitAbit(1000);
    }

    public void clickOnSaveButton(){
        scrollToElement(SAVE_BUTTON);
        waitAbit(500);
        jsClick(SAVE_BUTTON);
    }

    public void clickOnCancelButton(){
        scrollToElement(CANCEL_BUTTON);
        waitAbit(500);
        jsClick(CANCEL_BUTTON);
    }

    public void clickOnOkButton(){
        scrollToElement(OK_BUTTON);
        waitAbit(500);
        jsClick(OK_BUTTON);
    }

    public void clickOnRegisteredEmailTriggerButton(){
        scrollToElement(REGISTERED_EMAIL_BUTTON);
        waitAbit(500);
        jsClick(REGISTERED_EMAIL_BUTTON);
    }

    public void clickOnApplicationEmailTriggerButton(){
        scrollToElement(APPLICATION_EMAIL_BUTTON);
        waitAbit(500);
        jsClick(APPLICATION_EMAIL_BUTTON);
    }

    public boolean verifyDialogBox(){
        waitAbit(500);
        return isElementPresent(ALERT_DIALOG);
    }

    public String getDialogMessage(){
        waitAbit(500);
        return findBy(ALERT_DIALOG).getText();
    }

    private static final String CUSTOM_SECTION = "//div[contains(text(),'%s')]/parent::div//input";
    public void enableCustomSection(String section) {
        scrollToElement(format(CUSTOM_SECTION, section));
        waitAbit(500);
        findBy(format(CUSTOM_SECTION, section)).click();
        waitAbit(500);
    }

    public boolean isCustomSectionEnabled(String section) {
        return findBy(format(CUSTOM_SECTION, section)).isSelected();
    }

    private static final String INFO_TYPE = "//div[contains(@class,'notification-engine_actions-title')]/div[text()='%s']";
    private static final String MESSAGE_CENTER = "//div[contains(@class,'notification-engine_actions-title')][div[text()='%s']]/div/label[1]//input";
    private static final String EMAIL = "//div[contains(@class,'notification-engine_actions-title')][div[text()='%s']]/div/label[2]//input";

    public boolean isMessageCenterEnabled(String value){
        return findBy(format(MESSAGE_CENTER, value)).isSelected();
    }

    public boolean isEmailEnabled(String value){
        return findBy(format(EMAIL, value)).isSelected();
    }

}
