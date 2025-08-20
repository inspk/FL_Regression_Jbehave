package com.hhstechgroup.steps.serenity.dashboard;

import com.hhstechgroup.beans.IUportal.UpdateProfileBean;
import com.hhstechgroup.ui.pages.iuportal.IUDashboardPage;
import com.hhstechgroup.ui.pages.iuportal.UpdateProfilePage;
import com.hhstechgroup.ui.panels.iuportal.UpdateProfilePanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class IUDashboardSteps extends ScenarioSteps {

    IUDashboardPage iuDashboardPage;
    UpdateProfilePage updateProfilePage;

    @Step
    public boolean isStatisticsDisplayed() {
        return iuDashboardPage.isSatisticsPresent();
    }

    @Step
    public boolean isNewsDisplayed() {
        return iuDashboardPage.isNewsPresent();
    }

    @Step
    public boolean isRequestsListPresentOnDashboard() {
        return iuDashboardPage.getRequestsPanel().isRequestsListPresentOnDashboard();
    }

    @Step
    public List<String> getRequestsColumnsOnDashboard() {
        return iuDashboardPage.getRequestsPanel().getTabsOnDashboard();
    }

    @Step
    public List<String> getFilters() {
        return iuDashboardPage.getFilters();
    }

    //sp30
    @Step
    public boolean isTabsPresent(String tabs) {
        return iuDashboardPage.isTabsPresent(tabs);
    }

    @Step
    public void clickonTabs(String tabs){
        iuDashboardPage.clickonTabs(tabs);
    }

    //sp33
    @Step
    public boolean isValidationMsgPresent(String validationMsg) {
        return iuDashboardPage.isValidationMsgPresent(validationMsg);
    }

    @Step
    public void clickOnUpdateProfileTab(String tab){
        updateProfilePage.clickTab(tab);
    }

    @Step
    public void updateProfile(){
        updateProfilePage.clickUpdate();
        updateProfilePage.clickOK();
    }

    @Step
    public void setUpdateProfileInfo(UpdateProfileBean updateProfileBean){
        UpdateProfilePanel panel = updateProfilePage.getUpdateProfilePanel();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, updateProfileBean);
    }



}
