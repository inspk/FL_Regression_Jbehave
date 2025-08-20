package com.hhstechgroup.ui.pages.systemoptions;


import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.util.converters.DateConverter;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

import static java.lang.String.format;

public class PasswordPolicyPage extends ProviderManagementBasePage {
    private static final String CLOSE_POPUP = ".//button[contains(@class,'styles_btn-close_3S2n-')]/span";
    public PasswordPolicyPage(WebDriver driver) {
        super(driver);
    }

    private static final String CLICK_EDIT_PASSWORD_POLICY = ".//div[contains(text(),'Password Policy')]//following-sibling::div//button//span[contains(text(),'Edit')]" ;
    private static final String CLICK_SAVE_PASSWORD_POLICY = ".//div[contains(text(),'Password Policy')]/..//button//span[contains(text(), 'Save')]" ;
    private static final String CLICK_OK_BUTTON_TO_SAVE_PASSWORD_POLICY = ".//button/span[contains(text(),'OK')]" ;
    private static final String START_EFFECTIVE_DATE = "//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;

    public void clickOnEditButtonFromPasswordPolicy(){
        scrollToElement(CLICK_EDIT_PASSWORD_POLICY);
        findBy(CLICK_EDIT_PASSWORD_POLICY).click();
    }
    public void clickOnSaveButtonFromPasswordPolicy(){
        waitAbit(500);
        scrollToElement(CLICK_SAVE_PASSWORD_POLICY);
        waitAbit(500);
        findBy(CLICK_SAVE_PASSWORD_POLICY).click();
        waitAbit(500);
        scrollToElement(CLICK_OK_BUTTON_TO_SAVE_PASSWORD_POLICY);
        waitAbit(500);
        findBy(CLICK_OK_BUTTON_TO_SAVE_PASSWORD_POLICY).click();
        waitAbit(500);
    }

    public void addEffectiveDate(String effectiveDate){
        jsClick(START_EFFECTIVE_DATE);
        findBy(START_EFFECTIVE_DATE).sendKeys(effectiveDate);
    }
    public void clickOnClosePopup(){ jsClick(CLOSE_POPUP);}

    //sp25
    private static final String AUTO_TERMINATE_EDIT_BUTTON=".//div[contains(text(),'Auto Terminate')]/..//button/span[contains(text(), 'Edit')]";
    private static final String ENABLE_AUTO_TERMINATE=".//div/h3[contains(text(),'%s')]/..//following-sibling::div//span/input[@type='checkbox']";
    private static final String SAVE_BUTTON=".//div[contains(text(),'Auto Terminate')]/..//button/span[contains(text(), 'Save')]";
    public void clickOnEnableAutoTerminate(String enableautoterminate){
        findBy(format(ENABLE_AUTO_TERMINATE, enableautoterminate)).click();
        waitAbit(300); }

    public void clickOnEditButtoninAutoTermainate(){
        scrollToElement(AUTO_TERMINATE_EDIT_BUTTON);
        findBy(AUTO_TERMINATE_EDIT_BUTTON).click();
    }
    //sp44.2
    private static final String OK_BUTTON =".//button/span[contains(text(), 'Ok')]";
    public void clickOnAutoTerminateSaveButton() {
        waitAbit(500);
        scrollToElement(SAVE_BUTTON);
        waitAbit(500);
        findBy(SAVE_BUTTON).click();
        waitAbit(500);
        findBy(OK_BUTTON).click();
        waitAbit(200);
    }
    //sp37
    private static final String DISABLE_CAPTCHA_VERIFICATION=".//div/h3[contains(text(),'%s')]/../..//span/input[@name='isRecaptchaEnabled']";
    private static final String DISABLE_MULTI_FACTOR_AUTHENTICATION=".//div/h3[contains(text(),'%s')]/../..//span/input[@name='MFAForIUSwitch']";

    public void clickOnDisableCaptchaVerificationButton(String disablecaptchabutton) {
        scrollToElement(format(DISABLE_CAPTCHA_VERIFICATION, disablecaptchabutton));
        waitAbit(100);
        if(findBy(format(DISABLE_CAPTCHA_VERIFICATION, disablecaptchabutton)).isSelected()) {
            findBy(format(DISABLE_CAPTCHA_VERIFICATION, disablecaptchabutton)).click();
        } else {
            System.out.println(disablecaptchabutton + " already turned off!!!");
        }
        waitAbit(500);
    }

    public void clickOnEnableCaptchaVerificationButton(String enablecaptchabutton) {
        scrollToElement(format(DISABLE_CAPTCHA_VERIFICATION, enablecaptchabutton));
        waitAbit(100);
        if(findBy(format(DISABLE_CAPTCHA_VERIFICATION, enablecaptchabutton)).isSelected()) {
            System.out.println(enablecaptchabutton + " already turned on!!!");
        } else {
            findBy(format(DISABLE_CAPTCHA_VERIFICATION, enablecaptchabutton)).click();

        }
        waitAbit(500);
    }

    public void clickOnDisableMultiFactorAuthenticationButton(String disableauthenticationbutton){
        scrollToElement(format(DISABLE_MULTI_FACTOR_AUTHENTICATION,disableauthenticationbutton));
        waitAbit(100);
        findBy(format(DISABLE_MULTI_FACTOR_AUTHENTICATION,disableauthenticationbutton)).click();
        waitAbit(500);
    }

    private static final String PASSWORD_POLICY_CHECKBOX = "(//div[contains(.,'%s')]//span/input)[12]";
    public void clickPasswordPolicyCheckbox(String text) {
        scrollToElement(format(PASSWORD_POLICY_CHECKBOX, text));
        waitAbit(500);
        findBy(format(PASSWORD_POLICY_CHECKBOX, text)).click();
        waitAbit(500);
    }

    public boolean isAutoTerminateEnabled(String enableautoterminate) {
        return findBy(format(ENABLE_AUTO_TERMINATE, enableautoterminate)).isSelected();
    }




}
