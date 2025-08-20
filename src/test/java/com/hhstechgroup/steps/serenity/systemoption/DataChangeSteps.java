package com.hhstechgroup.steps.serenity.systemoption;

import com.hhstechgroup.ui.pages.systemoptions.DataChangePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

public class DataChangeSteps extends ScenarioSteps {
    DataChangePage dataChangePage;

    @Step
    public void clickoneditbutton() { dataChangePage.clickoneditbutton(); }

    @Step
    public void clickOnNotification(String infoType){dataChangePage.clickOnNotification(infoType);}

    @Step
    public void clickOnSaveButton() {dataChangePage.clickOnSaveButton();}

    @Step
    public void clickOnConfirmation(String confirmation){dataChangePage.clickOnConfirmation(confirmation);}

    @Step
    public void clickOnClosepopup(){dataChangePage.clickOnClosepopup();}

    @Step
    public void clickDataChangeNotificationBanner(String banner){
       dataChangePage.clickDataChangeNotificationBanner(banner); }

    @Step
    public void clickDataChangeReviewDiscardAll(String discardall){
        dataChangePage.clickDataChangeReviewDiscardAll(discardall);}

    @Step
    public void clickSubmitButton(){dataChangePage.clickSubmitButton();}

    @Step
    public void clickOnOverideIcon(){
        dataChangePage.clickOnOverideIcon();}

     @Step
     public void clickOnOverideOption(){dataChangePage.clickOnOverideOption();}

    @Step
    public void setReasonForDataChangeOverride(String reason,String note){dataChangePage.setReason(reason,note);}

    //sp44.2
    @Step
    public void setEffectiveStartDate(String effectiveStartDate) {
        dataChangePage.setEffectiveStartDate(effectiveStartDate);
    }

}
