package com.hhstechgroup.steps.serenity.systemoption;

import com.hhstechgroup.beans.application.ScreeningBean;
import com.hhstechgroup.ui.pages.sitevisit.UserPage;
import com.hhstechgroup.ui.pages.systemoptions.ScreeningPage;
import com.hhstechgroup.ui.panels.systemoptions.ScreeningPanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;

public class ScreeningSteps extends ScenarioSteps {

    @Page
    UserPage userPage;
    @Page
    ScreeningPage screeningPage;

    @Step
    public  void setScreeningInfor(ScreeningBean newScreeningInfo) {
        ScreeningPanel panel = userPage.getScreeningInfo();
        waitABit(2000);
        BeanUtils.copyPropertiesInOrder(panel, newScreeningInfo); }

    @Step
    public void clickScreeningProviderName(String name){
        screeningPage.clickScreeningProviderName(name);
    }
    //sp24
    @Step
    public void selectCustomScreening(){
        screeningPage.selectCustomScreening();
    }
    @Step
    public void clickTypeParameterInScreening(String typeEnrollment){
        screeningPage.clickScreeningTypeParameter(typeEnrollment);
    }
    //sp29
    @Step
    public void clickMonitoringEdit(){
        screeningPage.clickMonitoringEdit();
    }
    @Step
    public void clickOnEnablePeriodicMonitoring(String enablperiodicmonitoring){
        screeningPage.clickOnEnablePeriodicMonitoring(enablperiodicmonitoring);
    }
    @Step
    public  void setMonitoringScreeningInfo(ScreeningBean newScreeningInfo) {
        ScreeningPanel panel = userPage.getMonitoringScreeningInfo();
        waitABit(500);
        BeanUtils.copyPropertiesInOrder(panel, newScreeningInfo);
    }
    @Step
     public void clickSaveButton() {
        screeningPage.clickSaveButton();
     }
     //sp32
     @Step
     public void selectDefaultScreening(){
         screeningPage.selectDefaultScreening();
     }

     //sp43.2
     @Step
     public void setEffectiveStartDate(String effectiveStartDate) {
         screeningPage.setEffectiveStartDate(effectiveStartDate);
     }

     //sp68
    @Step
    public void clickOnEnablePeriodicMonitoring2(String enablperiodicmonitoring){
        screeningPage.clickOnEnablePeriodicMonitoring2(enablperiodicmonitoring);
    }

    //sp68
    @Step
    public void clickSaveButton1() {
        screeningPage.clickSaveButton1();
    }

    //SD-05

    @Step
    public boolean verifyAffiliationPage(String str) {
        return screeningPage.verifyAffiliationPage(str);
    }

    @Step
    public boolean verifyDownloadExcelButton(){
        return screeningPage.verifyDownloadExcelButton();
    }

    @Step
    public boolean verifyViewHistory(){
        return screeningPage.verifyViewHistory();
    }

    @Step
    public boolean verifyButtonEnabled(String button){
        return screeningPage.verifyButtonEnabled(button);
    }

    @Step
    public void selectAllowedAffiliationAndSign(String enablperiodicmonitoring){
        screeningPage.selectAllowedAffiliationAndSign(enablperiodicmonitoring);
    }

    @Step
    public void enableAffiliation(String enablperiodicmonitoring){
        screeningPage.enableAffiliation(enablperiodicmonitoring);
    }

    @Step
    public void disableAffiliation(String enablperiodicmonitoring){
        screeningPage.disableAffiliation(enablperiodicmonitoring);
    }

    @Step
    public void enableAffiliationSign(String enablperiodicmonitoring){
        screeningPage.enableAffiliationSign(enablperiodicmonitoring);
    }

    @Step
    public void disableAffiliationSign(String enablperiodicmonitoring){
        screeningPage.disableAffiliationSign(enablperiodicmonitoring);
    }

}
