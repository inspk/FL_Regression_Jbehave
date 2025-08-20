package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.peportalpages.DashboardSteps;
import com.hhstechgroup.steps.serenity.peportalpages.MyAccountSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MyAccountScenario {

    private static final String MY_ACCOUNT = "My Account";
    private static final String HELP_CENTRE = "Help center";
    private static final String MANAGE_USERS =  "Manage users";

    @Steps
    DashboardSteps dashboardSteps;
    @Steps
    MyAccountSteps myAccountSteps;

    @When("navigate to My Account page")
    public void navigateToMyAccount() {
        dashboardSteps.clickOnUserEmail();
        dashboardSteps.selectOptionOnUserPopUp(MY_ACCOUNT);
    }
    //latest

    @When("navigate to Manage Users page")
    public void navigateToManageUser() {
        dashboardSteps.clickOnUserEmail();
        dashboardSteps.selectOptionOnUserPopUp(MANAGE_USERS);
    }
    @When("navigate to Help Centre page")
    public void navigateToHelpCentre() {
        dashboardSteps.clickOnUserEmail();
        dashboardSteps.selectOptionOnUserPopUp(HELP_CENTRE);

    }


    @When("upload user photo $path")
    public void uploadUserPhoto(String path) {
        myAccountSteps.uploadUserPhoto(path);
    }

    @Then("$section section should contain next info: $table")
    public void checkAccountInfo(String section, ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(myAccountSteps.getAccountInfo(section), is(expectedInfo));
    }

    @Then("validation error '$error' should be displayed")
    public void checkUploadError(String error) {
        assertEquals("Error not present or incorrect", error, myAccountSteps.getErrorDisplayed());
    }

    @Then("user photo $photo should be uploaded")
    public void checkDocumentUploaded() {
        assertTrue(myAccountSteps.isPhotoUploaded());
    }

}
