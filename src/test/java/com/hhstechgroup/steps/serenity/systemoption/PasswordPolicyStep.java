package com.hhstechgroup.steps.serenity.systemoption;


import com.hhstechgroup.beans.application.SecurityPolicyBean;
import com.hhstechgroup.ui.pages.sitevisit.UserPage;
import com.hhstechgroup.ui.pages.systemoptions.PasswordPolicyPage;
import com.hhstechgroup.ui.panels.systemoptions.SecurityPalicyPanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;

public class PasswordPolicyStep  extends ScenarioSteps {

    @Page
    PasswordPolicyPage passwordPolicyPage;


    @Page
    UserPage userPage;

    @Step
    public  void setPasswordInfor(SecurityPolicyBean newPasswordInfo) {
        SecurityPalicyPanel panel = userPage.getpasswordPolicyinfor();
        waitABit(2000);
        BeanUtils.copyPropertiesInOrder(panel, newPasswordInfo);
    }

    @Step
    public void clickOnClosePopup(){passwordPolicyPage.clickOnClosePopup();}

    @Step
    public void clickOnEditButtonFromPasswordPolicy(){passwordPolicyPage.clickOnEditButtonFromPasswordPolicy();}

    @Step
    public void clickOnSaveButtonFromPasswordPolicy(){passwordPolicyPage.clickOnSaveButtonFromPasswordPolicy();}

    @Step
    public void typeEffectiveDates(String effectiveDate){
        passwordPolicyPage.addEffectiveDate(effectiveDate);
    }

    //sp25
    @Step
    public void clickOnEnableAutoTerminate(String enableautoterminate){
        passwordPolicyPage.clickOnEnableAutoTerminate(enableautoterminate); }

    @Step
    public void clickOnEditButtoninAutoTermainate(){
        passwordPolicyPage.clickOnEditButtoninAutoTermainate(); }

    @Step
    public void setsuspendedProvidersTerminatedRemainders(SecurityPolicyBean remainderinfo) {
        SecurityPalicyPanel panel = userPage.getAutoTerminatepasswordPolicyinfo();
        waitABit(2000);
        BeanUtils.copyPropertiesInOrder(panel, remainderinfo); }

    @Step
    public void clickOnAutoTerminateSaveButton(){
        passwordPolicyPage.clickOnAutoTerminateSaveButton();
    }

    //sp37
    @Step
    public void clickOnDisableCaptchaVerificationButton(String disablecaptchabutton){
        passwordPolicyPage.clickOnDisableCaptchaVerificationButton(disablecaptchabutton);
    }

    @Step
    public void clickOnDisableMultiFactorAuthenticationButton(String disableauthenticationbutton){
        passwordPolicyPage.clickOnDisableMultiFactorAuthenticationButton(disableauthenticationbutton);
    }

    @Step
    public void clickPasswordPolicyCheckbox(String text) {
        passwordPolicyPage.clickPasswordPolicyCheckbox(text);
    }

    public boolean isAutoTerminateEnabled(String enableautoterminate) {
        return passwordPolicyPage.isAutoTerminateEnabled(enableautoterminate);
    }

    @Step
    public void clickOnEnableCaptchaVerificationButton(String enablecaptchabutton){
        passwordPolicyPage.clickOnEnableCaptchaVerificationButton(enablecaptchabutton);
    }

}
