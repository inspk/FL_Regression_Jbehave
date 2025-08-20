package com.hhstechgroup.ui.pages.systemoptions;
import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.systemoptions.ContactInformationPanel;
import com.hhstechgroup.ui.panels.systemoptions.PaymentFeesPanel;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class UserProfilePage extends ProviderManagementBasePage {

    //private static final String EDIT_BUTTON = "//div//button[@type='button']";
    //sp66
    private static final String EDIT_BUTTON =  "//div[contains(text(),'User Profile Configuration')]/../following-sibling::div//button/span[contains(text(),'Edit')]";
    private static final String CLICK_SAVE_BUTTON = ".//div/button/span[contains(text(),'Save')]";
    private static final String CLICK_ENABLE_USER_PROFILE_UPDATE = ".//span/input[@name='logoutSwitch']";
    private static final String SET_USER_PROFILE_DAYS =".//div/input[@name='loginTimeout']";
    private static final String UPDATE_PROFILE_PAGE =".//span[contains(text(),'%s')]/parent::span";
    private static final String CLICK_UPDATE_BUTTON=".//button/span[text()='Update']";
    public static final String BUTTON_OK ="//span[text() = 'OK']";

    private static final String UPDATE_PROFILE_PANEL =".//div[contains(@class,'registration_input-wrapper')]";
    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnContactInfo(String contactinfo){
        findBy(format(UPDATE_PROFILE_PAGE, contactinfo)).click();
        waitAbit(200);
    }
    public void clickOKButton() {
        jsClick(BUTTON_OK); waitAbit(500);
    }

    public void clickoneditbutton(){
        scrollToElement(EDIT_BUTTON);
        //findBy(EDIT_BUTTON).click();
        jsClick(EDIT_BUTTON);
        waitAbit(500);
    }
    public void clickOnEnableUserUpdateProfile(){
        //findBy(CLICK_ENABLE_USER_PROFILE_UPDATE).click();
        jsClick(CLICK_ENABLE_USER_PROFILE_UPDATE);
        waitAbit(500);}

    public void setUserProfileUpdateDays(String days){
        waitAbit(100);
        findBy(SET_USER_PROFILE_DAYS).type(days);
    }

    public void clickOnSaveButton() {
        scrollToElement(CLICK_SAVE_BUTTON);
        jsClick(CLICK_SAVE_BUTTON); waitAbit(500);
    }

    public void clickOnUpdateButton() {
        findBy(CLICK_UPDATE_BUTTON).click();
        waitAbit(200);
    }

    public ContactInformationPanel getUserUpdateProfile(){
        return  new ContactInformationPanel(findBy(UPDATE_PROFILE_PANEL),this);
    }
}
