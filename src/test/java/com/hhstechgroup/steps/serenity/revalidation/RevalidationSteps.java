package com.hhstechgroup.steps.serenity.revalidation;

import com.hhstechgroup.ui.pages.systemoptions.RevalidationConfigurationPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class RevalidationSteps extends ScenarioSteps {

    RevalidationConfigurationPage revalidationConfigurationPage;

    @Step
    public String getRevalidationSectionsAndSettings(String section, String notification) {
        return revalidationConfigurationPage.getRevalidationConfiguration(section, notification);
    }

    @Step
    public void setRevalidationSectionsAndSettings(String section, String notification, String value) {
         revalidationConfigurationPage.setRevalidationConfiguration(section, notification, value);
    }
    @Step
    public String getDataProviderIdByName(String firstName, String lastName){
      String providerDataId =  revalidationConfigurationPage.getProviderDataId(firstName, lastName);
      return providerDataId;
    }

    @Step
    public void sendRevalidationRequest(String cookies, String providerDataId, String timeToRevalidationPlus30d){
        revalidationConfigurationPage.revalidationRequest(cookies, providerDataId, timeToRevalidationPlus30d);
    }

    @Step
    public boolean checkRedRevalidationMessage(){
        return revalidationConfigurationPage.redRevalidationMessageIsDisplayed();
    }
    @Step
    public boolean checkRevalidationMessage(){
        return revalidationConfigurationPage.revalidationMessageIsDisplayed();
    }

    @Step
    public boolean checkEnrollmentMessage(){
        return revalidationConfigurationPage.enrollmentMessageIsDisplayed();
    }

    @Step
    public String getTextFromRevalidationRedMessage(){
       return revalidationConfigurationPage.getTextFromRedRevalidationMessage();
    }
    @Step
    public String getTextFromSimpleRevalidationMessage(){
       return revalidationConfigurationPage.getTextFromRevalidationMessage();
    }

    @Step
    public void sendRevalidationRequest1(String cookies,String timeToRevalidationPlus30d){
        revalidationConfigurationPage.revalidationRequest1(cookies,timeToRevalidationPlus30d);
    }

    @Step
    public void setRemindersForReviewersSettings(String notification, String days) {
        revalidationConfigurationPage.setRemindersForReviewersSettings(notification, days);
    }
    @Step
    public String getRemainderNotification(String notification){
        return revalidationConfigurationPage.getRemainderNotification(notification);
    }
    @Step
    public void revalidationRequestForFirstNotification(String cookies,String timeToRevalidationPlus90d){
        revalidationConfigurationPage.revalidationRequestForFirstNotification(cookies,timeToRevalidationPlus90d);
    }
    @Step
    public void revalidationRequestForSecondNotification(String cookies,String timeToRevalidationPlus60d){
        revalidationConfigurationPage.revalidationRequestForSecondNotification(cookies,timeToRevalidationPlus60d);
    }
    @Step
    public void revalidationRequestForThirdNotification(String cookies,String timeToRevalidationPlus30d){
        revalidationConfigurationPage.revalidationRequestForThirdNotification(cookies,timeToRevalidationPlus30d);
    }

    @Step
    public boolean verifyTheRevalidationText(String months){
        return revalidationConfigurationPage.verifyTheRevalidationText(months);
    }
@Step
    public String getProviderDataID(){
        return revalidationConfigurationPage.getProviderDataID();
}

@Step
    public void verifyAndGetNextRevalidationDate(){
        revalidationConfigurationPage.verifyAndGetNextRevalidationDate();
}

}




