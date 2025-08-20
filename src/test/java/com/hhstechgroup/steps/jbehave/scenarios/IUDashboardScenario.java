package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.beans.IUportal.UpdateProfileBean;
import com.hhstechgroup.steps.serenity.dashboard.IUDashboardSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class IUDashboardScenario {

    @Steps
    IUDashboardSteps iuDashboardSteps;

    @Then("statistics should be displayed on dashboard page")
    public void isStatisticsPresent() {
        assertTrue(iuDashboardSteps.isStatisticsDisplayed());
    }

    @Then("news should be displayed on dashboard page")
    public void isNewsPresent() {
        assertTrue(iuDashboardSteps.isNewsDisplayed());
    }

    @Then("list with requests should be displayed on dashboard page with next columns: $table")
    public void isNewsPresent(ExamplesTable table) {
        List<String> expectedColumns = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertTrue(iuDashboardSteps.isRequestsListPresentOnDashboard());
        assertEquals(expectedColumns, iuDashboardSteps.getRequestsColumnsOnDashboard());
    }

    @Then("next filters should be displayed on dashboard page: $table")
    public void checkFilters(ExamplesTable table) {
        List<String> expectedFilters = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertEquals(expectedFilters, iuDashboardSteps.getFilters());
    }
    //sp30
    @Then("verify the '$tabs' should be displayed on dashboard page")
    public void isTabsPresent(String tabs){
        assertTrue(iuDashboardSteps.isTabsPresent(tabs));
    }

    @When("click on the '$tabs' in dashboard Page")
    public void clickonTabs(String tabs) {
        iuDashboardSteps.clickonTabs(tabs);
    }

    //sp33
    @Then("email validation denied  reason '$validationMsg' displaying")
    public void isValidationMsgPresent(String validationMsg){
        assertTrue(iuDashboardSteps.isValidationMsgPresent(validationMsg));
    }

    //sp37 change password validation

    @Then("email validation for change password '$validationMsg' displaying")
    public void isValidationMsgPresent1(String validationMsg){
        assertTrue(iuDashboardSteps.isValidationMsgPresent(validationMsg));
    }

    @When("click on $tab tab in Update Profile Popup")
    public void clickOnUpdateProfileTab(String tab) {
        iuDashboardSteps.clickOnUpdateProfileTab(tab);
    }

    @When("click update in Update Profile Popup")
    public void updateProfile(){
        iuDashboardSteps.updateProfile();
    }

    @When("To fill the update your profile: $table")
    public void setUpdateProfileInfo(ExamplesTable user) {
        iuDashboardSteps.setUpdateProfileInfo(ExamplesTableUtil.parseTableToClass(user, UpdateProfileBean.class).get(0));
    }

}
