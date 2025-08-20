package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.iuportal.RolesSteps;
import com.hhstechgroup.steps.serenity.peportalpages.DashboardSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;


public class RolesScenario {

    private static final String SYSTEM_OPTIONS = "System Options";
    private static final String CHANGE_PASSWORD = "Change Password";
    private static final String HELP_CENTRE = "Help center";

    @Steps
    RolesSteps rolesSteps;
    @Steps
    DashboardSteps dashboardSteps;

    @When("click '$tab' tab on left panel")
    public void clickTabOnRolesPage(String tab) {
        rolesSteps.clickTabOnRolesPage(tab);
    }

    @When("navigate to '$tab' page from user pop-up")
    public void navigateToSystemOptions() {
        dashboardSteps.clickOnUserEmail();
        dashboardSteps.selectOptionOnUserPopUp(SYSTEM_OPTIONS);
    }

    @When("navigate to 'Change Password' page")
    public void navigateToChangePassword() {
        dashboardSteps.clickOnUserEmail();
        dashboardSteps.selectOptionOnUserPopUp(CHANGE_PASSWORD);
    }

    @When("navigate to 'Help Center' page from user pop-up")
    public void navigateToHelpCenter() {
        dashboardSteps.clickOnUserEmail();
        dashboardSteps.selectOptionOnUserPopUp(HELP_CENTRE);
    }

    @When("activate edit mode")
    public void activateEditMode() {
        rolesSteps.activateEditMode();
    }

    @When("select '$role' from role list")
    public void selectRole(String role) {
        rolesSteps.selectRole(role);
    }
    @When("select any role from the list")
    public void selectAnyRole(){rolesSteps.selectAnyRole();}

    @When("expand '$typeOfPermissions' permissions")
    public void expandPermissions(String section) {
        rolesSteps.expandPermissions(section);
    }

    @When("deselect '$typeOfPermissions' permissions")
    public void deselectPermissions(String section) {
        rolesSteps.deselectPermissions(section);
    }

    @When("click Add new button")
    public void addNew() {
        rolesSteps.clickAddNew();
    }
    @When("click Add button from the Add new Role page")
    public void clickAddButtonFromAddNewRole(){rolesSteps.clickAddButtonFromAddNewRole();}

    @When("click Add button on Add new role pop-up")
    public void clickAdd() {
        rolesSteps.clickAdd();
    }

    @When("create new user with role name - '$roleName' and  description - '$roleDescription'")
    public void createUser(String roleName, String roleDescription) {
        rolesSteps.setRoleName(roleName);
        rolesSteps.setRoleDescription(roleDescription);
        rolesSteps.clickAdd();
    }

    @When("click Cancel button on Add new role pop-up")
    public void clickCancel() {
        rolesSteps.clickCancel();
    }

    @When("click Cancel button on Role details page")
    public void clickCancelOnPermissions() {
        rolesSteps.clickCancelOnPermissions();
    }

    @When("search for role - '$role'")
    public void searchForRole(String role) {
        rolesSteps.searchForRole(role);
    }

    @When("click on Back to list button")
    public void clickBack() {
        rolesSteps.clickBack();
    }

    @Then("edit mode is activated")
    public void isEditModeActivated() {
        assertTrue(rolesSteps.isEditModeActivated());
    }

    @Then("edit mode is deactivated")
    public void isEditModeDeactivated() {
        assertFalse(rolesSteps.isEditModeActivated());
    }

    @Then("next role should be present in the list for role - '$roleName': $table")
    public void checkRole(ExamplesTable table, String roleName) {
        assertReflectionEquals(table.getRow(0), rolesSteps.getRole(roleName));
    }

    @Then("validation error message '$error' should be displayed")
    public void checkUploadError(String error) {
        assertEquals("Error not present or incorrect", error, rolesSteps.getErrorDisplayed());
    }

    @Then("Add new role pop-up is closed")
    public void isPopupClosed() {
        assertFalse(rolesSteps.isPopupClosed());
    }

    @Then("Add new role pop-up is opened")
    public void isPopupOpened() {
        assertTrue(rolesSteps.isPopupOpened());
    }

    @Then("user navigated to role details for role - '$role'")
    public void isRoleDetailsOpened(String role) {
        assertTrue(rolesSteps.isRoleDetailsOpened(role));
    }

    @Then("role should have description -  '$description' and status - '$status'")
    public void areDetailsCorrect(String description, String status) {
        assertEquals("Description is incorrect", description, rolesSteps.getDescription());
        assertEquals("Status is incorrect", status, rolesSteps.getStatus());
    }

    @Then("role should have creation date - '$createDate' and update date - '$updateDate'")
    public void areDatesCorrect(String createDate, String updateDate) {
        assertEquals("Date of creation is incorrect", createDate, rolesSteps.getCreateDate());
        assertEquals("Date of update if incorrect", updateDate, rolesSteps.getUpdateDate());
    }

    //sp21
    @When("create new user with role - '$roleName', description - '$roleDescription' and effective date - '$effectiveDate'")
    public void createUser(String roleName, String roleDescription, String effectiveDate) {
        System.out.println(effectiveDate);
        rolesSteps.setEffectiveDate(effectiveDate);
        rolesSteps.setRoleName(roleName);
        rolesSteps.setRoleDescription(roleDescription);
        rolesSteps.clickAdd();
    }

    @When("click the role with $text")
    public void clickRoleWithText(String role){
        rolesSteps.clickRoleWithText(role);
    }

    @When("expand the permission with label $label")
    public void expandPermission(String text){
        rolesSteps.expandPermission(text);
    }

    @When("verify that below permissions are given to $permission by default:$permissions")
    public void verifyPermissions(String permission, ExamplesTable permissions){
        System.out.println("Rows: " + permissions.getRows());

        for (Map<String,String> row : permissions.getRows()) {
            assertTrue(row.get(permissions.getHeaders().get(0)) + " permission not enabled", rolesSteps.verifyPermissions(permission, row.get(permissions.getHeaders().get(0))));
        }
    }

    @When("save role permission changes")
    public void saveChanges(){
        rolesSteps.saveChanges();
    }
}
