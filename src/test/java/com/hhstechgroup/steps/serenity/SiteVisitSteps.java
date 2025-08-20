package com.hhstechgroup.steps.serenity;

import com.hhstechgroup.ui.pages.sitevisit.AddRequestPage;
import com.hhstechgroup.ui.pages.sitevisit.SiteVisitPage;
import com.hhstechgroup.util.common.FileUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.Map;

public class SiteVisitSteps extends ScenarioSteps {

    AddRequestPage addRequestPage;
    SiteVisitPage siteVisitPage;

    @Step
    public void addNewRequest() {
        siteVisitPage.clickAddNewButton();
    }

    @Step
    public void uploadPhotograph(String path) {
        siteVisitPage.getFacilityInspectionPanel().uploadPhotograph(FileUtils.getAbsolutePath(path));
    }

    @Step
    public void uploadPhotographs(String path) {
        siteVisitPage.getAdditionalQuestionsPanel().uploadPhotographs(FileUtils.getAbsolutePath(path));
    }

    @Step
    public void clickSubmit() {
        siteVisitPage.getAdditionalQuestionsPanel().clickSubmit();
    }

    @Step
    public Map<String, String> getRequestDetails() {
        return addRequestPage.getRequestDetails();
    }

    //laetst
    @Step
    public void selectsitevisitprovider(String siteProvider) {
        siteVisitPage.selectsitevisitprovider(siteProvider);
    }
}
