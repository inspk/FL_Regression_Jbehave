package com.hhstechgroup.steps.serenity.systemoption;

import com.hhstechgroup.ui.pages.systemoptions.NotificationEnginePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NotificationEngineSteps extends ScenarioSteps {

    NotificationEnginePage notificationEnginePage;


    @Step
    public void clickoneditbutton(){
        notificationEnginePage.clickoneditbutton();
    }

    @Step
    public void setEffectiveStartDate(String date){
        notificationEnginePage.setEffectiveStartDate(date);
    }

    @Step
    public void setEffectiveEndDate(String date){
        notificationEnginePage.setEffectiveEndDate(date);
    }

    @Step
    public void clickOnMessageNotification(String infoType){
        notificationEnginePage.clickOnMessageNotification(infoType);
    }

    @Step
    public void clickOnEmailNotification(String infoType){
        notificationEnginePage.clickOnEmailNotification(infoType);
    }

    @Step
    public void clickSave(){
        notificationEnginePage.clickOnSaveButton();
    }

    @Step
    public void clickOk(){
        notificationEnginePage.clickOnOkButton();
    }

    @Step
    public void clickCancel(){
        notificationEnginePage.clickOnCancelButton();
    }

    @Step
    public void clickOnRegisteredEmailTriggerButton(){
        notificationEnginePage.clickOnRegisteredEmailTriggerButton();
    }

    @Step
    public void clickOnApplicationEmailTriggerButton(){
        notificationEnginePage.clickOnApplicationEmailTriggerButton();
    }

    @Step
    public String verifyDialog(){
        if(notificationEnginePage.verifyDialogBox()) {
            String message = notificationEnginePage.getDialogMessage();
            notificationEnginePage.clickOnOkButton();
            return message;
        }
        else
            return null;
    }

    @Step
    public void enableCustomSection(String section){
        notificationEnginePage.enableCustomSection(section);
    }
    @Step
    public boolean isCustomSectionEnabled(String section){
        return notificationEnginePage.isCustomSectionEnabled(section);
    }

    @Step
    public boolean isMessageCenterEnabled(String value){
        return notificationEnginePage.isMessageCenterEnabled(value);
    }

    @Step
    public boolean isEmailEnabled(String value){
        return notificationEnginePage.isEmailEnabled(value);
    }
}

