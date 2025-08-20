package com.hhstechgroup.steps.serenity.collaborator;


import com.hhstechgroup.beans.CollaboratorPermissionsBean;
import com.hhstechgroup.ui.pages.peportal.CollaboratorDetailsPage;
import com.hhstechgroup.ui.pages.peportal.CollaboratorsPage;
import com.hhstechgroup.ui.pages.peportal.DashboardPage;
import com.hhstechgroup.ui.pages.peportal.InviteCollaboratorPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;
import java.util.Map;

public class CollaboratorSteps extends ScenarioSteps {

    DashboardPage dashboardPage;
    InviteCollaboratorPage inviteCollaboratorPage;
    CollaboratorsPage collaboratorsPage;
    CollaboratorDetailsPage collaboratorDetailsPage;

    @Step
    public void clickInviteCollaborator() {
        collaboratorsPage.clickInviteCollaboratorButton();
    }

    @Step
    public void setCollaboratorEmail(String email) {
        inviteCollaboratorPage.setEmail(email);
    }

    @Step
    public void setCollaboratorName(String name) {
        inviteCollaboratorPage.setName(name);
    }

    @Step
    public void switchOffPages(List<String> pages) {
        inviteCollaboratorPage.getPermissions().switchOffPages(pages);
    }

    @Step
    public void addPermissions(String page, String permissions) {
        inviteCollaboratorPage.getPermissions().setPermissionsToPage(page, permissions);
    }

    @Step
    public void clickSendInvite() {
        inviteCollaboratorPage.clickSendInvite();
    }

    @Step
    public String getCollaboratorName() {
        return collaboratorDetailsPage.getCollaboratorNameMail();
    }

    @Step
    public Map<String, String> getCollaboratorInfo() {
        return collaboratorDetailsPage.getCollaboratorInfo();
    }

    @Step
    public String getCollaboratorsTitle() {
        return collaboratorsPage.getTitle();
    }

    @Step
    public boolean isInviteButtonDisplayed() {
        return collaboratorsPage.isInviteButtonDisplayed();
    }

    @Step
    public void clickEdit() {
        collaboratorDetailsPage.clickEdit();
    }

    @Step
    public void saveChanges() {
        collaboratorDetailsPage.saveChanges();
    }

    @Step
    public void clickBackButton() {
        collaboratorDetailsPage.clickBackButton();
    }

    @Step
    public void saveEditedPermissions() {}

    @Step
    public List<Map<String, String>> getCollaboratorsList() {
        return collaboratorsPage.getCollaboratorsList();
    }

    @Step
    public void clickOnCollaboratorByEmail(String email) {
        collaboratorsPage.clickOnCollaboratorByEmail(email);
    }

    @Step
    public List<CollaboratorPermissionsBean> getCollaboratorPermissions() {
        return collaboratorDetailsPage.getPermissions().getPermissions();
    }

    @Step
    public String getCollaboratorsAbsenceMessage() {
        return collaboratorsPage.getCollaboratorsAbsenceMessage();
    }
}
