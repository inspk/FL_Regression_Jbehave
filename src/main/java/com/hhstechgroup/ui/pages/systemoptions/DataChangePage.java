package com.hhstechgroup.ui.pages.systemoptions;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class DataChangePage extends ProviderManagementBasePage {

    private static final String EDIT_BUTTON = "//div[contains(text(),'Actions on data change')]/..//div//button//span[contains(text(),'Edit')]";
    private static final String CLICK_SAVE_BUTTON = ".//div/button/span[contains(.,'Save')]";
    private static final String CLICK_CANCEL_BUTTON = ".//div/button/span[contains(text(),'Cancel')]";
    private static final String ENABLE_NOTIFICATION= ".//div[contains(text(),'%s')]/..//div/label//span/input[@name='Notification']";
    private static final String ENABLE_CONFIRMATION=".//div[contains(text(),'%s')]/..//div/label//span/input[@name='Confirmation']";
    private static final String CLOSE_POPUP =".//div[contains(@class,'_notification-close')]/i";
    private static final String DATACHANGE_NOTIFICATION_BANNER  =".//div[contains(@class,'styles_data-changes-notification_')]/p[text()='%s']";
    private static final String DATACHANGE_REVIEW_CONFIRMORDISCARD=".//div[contains(@class,'styles_select-btn_')]/div[contains(text(),'%s')]";
    private static final String SUBMIT_BUTTON=".//div/button/span[contains(text(),'Submit')]";
    //private static final String CLICK_OVERIDE_ICON =".//div/span[text()='Address Details']/../../../../..//div[contains(@class,'field_circle-status_')]";
    //sp41.4
   // private static final String CLICK_OVERIDE_ICON=".//div[contains(@class,'sc-RefOD fYMHUE')]/div/button/span/i";
    //sp44.2
    private static final String CLICK_OVERIDE_ICON=".//div[contains(@class,'field_circle-status_')]";
    private static final String CLICK_OVERIDE_OPTION ="(.//div/div/span[contains(text(),'Override')])[1]";
    private static final String REASON_DROPDOWN =".//input[contains(@id, 'Reason')]/preceding-sibling::div";
    private static final String SELECT_REASONS =".//ul/li[contains(text(),'%s')]";
    private static final String NOTE_FIELD =".//label[contains(text(), 'Note')]/../div/input";

    public DataChangePage(WebDriver driver) {
        super(driver);
    }

    public void clickoneditbutton(){ jsClick(EDIT_BUTTON);waitAbit(2000); }

    public void clickOnNotification(String infoType){ findBy(format(ENABLE_NOTIFICATION, infoType)).click();waitAbit(200); }

    //sp44.2
    private static final String OK_BUTTON =".//button/span[contains(text(), 'OK')]";
    public void clickOnSaveButton() {
        scrollToElement(CLICK_SAVE_BUTTON);
        findBy(CLICK_SAVE_BUTTON).click();
        waitABit(500);
        findBy(OK_BUTTON).click();
        waitABit(500);}

    public void clickOnConfirmation(String confirmation){
            findBy(format(ENABLE_CONFIRMATION, confirmation)).click();waitAbit(2000); }

    public void clickOnClosepopup(){
        //findBy(CLOSE_POPUP).click();
        waitAbit(300);
        jsClick(CLOSE_POPUP);
    }

    public void clickDataChangeNotificationBanner(String banner){
      //  waitAbit(500);
        findBy(format(DATACHANGE_NOTIFICATION_BANNER, banner)).click();waitAbit(500); }

    public void clickDataChangeReviewDiscardAll(String discardall){
        jsClick(format(DATACHANGE_REVIEW_CONFIRMORDISCARD, discardall));
      //  findBy(format(DATACHANGE_REVIEW_CONFIRMORDISCARD, discardall)).click();
        waitAbit(500); }

     public void clickSubmitButton(){
        scrollToElement(SUBMIT_BUTTON);
        findBy(SUBMIT_BUTTON).click();
        waitAbit(1000);
     }

    public void clickOnOverideIcon(){
        waitAbit(500);
        jsClick(CLICK_OVERIDE_ICON);
        //findBy(CLICK_OVERIDE_ICON).click();
        waitAbit(1000); }

    public void clickOnOverideOption(){
        jsClick(CLICK_OVERIDE_OPTION);
        waitAbit(1000);}

    public void setReason(String reason,String note) {
        waitAbit(500);
        jsClick(REASON_DROPDOWN);
        scrollToElement(format(SELECT_REASONS,reason));
        waitAbit(500);
        findBy(format(SELECT_REASONS, reason)).click();
        waitAbit(500);
        findBy(NOTE_FIELD).click();
        findBy(NOTE_FIELD).type(note);
        waitAbit(1000);
    }

    //sp44.2
    private static final String EFFECTIVE_START_DATE = ".//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;
    public void setEffectiveStartDate(String effectiveStartDate) {
        scrollToElement(EFFECTIVE_START_DATE);
        jsClick(EFFECTIVE_START_DATE);
        findBy(format(EFFECTIVE_START_DATE,effectiveStartDate)).sendKeys(effectiveStartDate);
    }
}
