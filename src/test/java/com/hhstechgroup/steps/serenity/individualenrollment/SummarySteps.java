package com.hhstechgroup.steps.serenity.individualenrollment;


import com.hhstechgroup.beans.application.SummaryBean;
import com.hhstechgroup.ui.pages.enrollment.EnrollmentPage;
import com.hhstechgroup.ui.panels.enrollment.SummaryPanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SummarySteps extends ScenarioSteps {

    EnrollmentPage enrollmentPage;

    @Step
    public void setSummary(SummaryBean info) {
        SummaryPanel panel = enrollmentPage.getSummaryPanel();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, info);
    }

    @Step
    public void clickProceed() {
        enrollmentPage.getSummaryPanel().clickProceedButton();
        waitABit(500);
    enrollmentPage.waitForSpinnerToDisappear();
    }

    @Step
    public void clickProceed1() {
        enrollmentPage.getSummaryPanel().clickProceedButton1();
      waitABit(500);
    }
// // SP-65 calling new method for COC summary panel
    @Step
    public void clickSubmit(){
        enrollmentPage.getSummaryPanel1().clickSubmitButton();
    }

    @Step
    public boolean isButtonDisabled(String button){
        return enrollmentPage.getSummaryPanel().isButtonDisabled(button);
    }

    //sp42.3
    @Step
    public void clickSubmit1(){
        enrollmentPage.clickSubmitButton1();
    }

    //SD08
    @Step
    public void submitApplication(){
        enrollmentPage.getSummaryPanel().clickSubmitButton();
    }

    @Step
    public void clickSignSubmit(){
        enrollmentPage.getSummaryPanel1().clickSignSubmit();
    }

}
