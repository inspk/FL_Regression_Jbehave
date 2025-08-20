package com.hhstechgroup.steps.serenity.iuportal;

import com.hhstechgroup.ui.pages.iuportal.RoleDetailsPage;
import com.hhstechgroup.ui.pages.iuportal.RolesPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.Map;

public class RolesSteps extends ScenarioSteps{

    RolesPage rolesPage;
    RoleDetailsPage roleDetailsPage;

    @Step
    public void clickTabOnRolesPage(String tab) {
        rolesPage.clickTabOnRolesPage(tab);

    }

    @Step
    public void selectRole(String role) {
        rolesPage.selectRole(role);
    }
    @Step
    public void selectAnyRole(){rolesPage.selectAnyRole();}

    @Step
    public void activateEditMode() {
        rolesPage.activateEditMode();
    }

    @Step
    public boolean isEditModeActivated() {
        return rolesPage.isEditModeActivated();
    }

    @Step
    public void expandPermissions(String section) {
        roleDetailsPage.getPermissions().expandPermissions(section);
    }

    @Step
    public void deselectPermissions(String section) {
        roleDetailsPage.getPermissions().deselectPermissions(section);
    }

    @Step
    public void clickAddNew() {
        rolesPage.clickAddNew();
    }
    //latest
    @Step
    public void clickAddButtonFromAddNewRole(){rolesPage.clickAddButtonFromAddNewRole();}

    @Step
    public void setRoleName(String roleName)  {
        rolesPage.newRolePopup().setRoleName(roleName);
    }

    @Step
    public void setRoleDescription(String roleDescription)  {
        rolesPage.newRolePopup().setRoleDescription(roleDescription);
    }

    @Step
    public void clickAdd() {
        rolesPage.newRolePopup().clickAdd();
    }

    @Step
    public String getErrorDisplayed() {
        return rolesPage.newRolePopup().getErrorDisplayed();
    }

    @Step
    public void clickCancel() {
        rolesPage.newRolePopup().clickCancel();
    }

    @Step
    public boolean isPopupOpened() {
        return rolesPage.isPopupOpened();
    }

    @Step
    public boolean isPopupClosed() {
        return rolesPage.isPopupClosed();
    }

    @Step
    public void searchForRole(String role) {
        rolesPage.searchForRole(role);
    }

    @Step
    public Map<String, String> getRole(String roleName) {
        return rolesPage.getRoleInfo(roleName);
    }

    @Step
    public boolean isRoleDetailsOpened(String role) {
        return rolesPage.isRoleDetailsOpened(role);
    }

    @Step
    public String getDescription() {
        return roleDetailsPage.getDescription();
    }

    @Step
    public String getStatus() {
        return roleDetailsPage.getStatus();
    }

    @Step
    public String getCreateDate() {
        return roleDetailsPage.getCreateDate();
    }

    @Step
    public String getUpdateDate() {
        return roleDetailsPage.getUpdateDate();
    }

    @Step
    public void clickCancelOnPermissions() {
        roleDetailsPage.getPermissions().clickCancel();
    }

    @Step
    public void clickBack() {
        roleDetailsPage.clickBack();
    }

  //sp21
  @Step
  public void setEffectiveDate(String effectiveDate)  {
    rolesPage.addEffectiveDate(effectiveDate);;
  }

    @Step
    public void clickRoleWithText(String role) {
        rolesPage.clickRoleWithText(role);
    }

    @Step
    public void expandPermission(String text) {
        rolesPage.expandPermission(text);
    }

    @Step
    public boolean verifyPermissions(String permission, String permissions) {
        return rolesPage.verifyPermissions(permission, permissions);
    }

    @Step
    public void saveChanges(){
        rolesPage.saveChanges();
    }

}
