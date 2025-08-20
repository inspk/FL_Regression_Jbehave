package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.beans.CollaboratorPermissionsBean;
import com.hhstechgroup.steps.serenity.collaborator.CollaboratorSteps;
import com.hhstechgroup.steps.serenity.peportalpages.DashboardSteps;
import com.hhstechgroup.util.common.ExternalEmails;
import com.hhstechgroup.util.converters.DateConverter;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class InviteCollaboratorScenario {

    private static final String MANAGE_USERS_SECTION = "Manage users";
    private Logger logger = Logger.getLogger(InviteCollaboratorScenario.class);


    @Steps
    DashboardSteps dashboardSteps;
    @Steps
    CollaboratorSteps collaboratorSteps;

    @When("invite collaborator with email - $email, name - $name and permissions: $table")
    public void inviteCollaborator(String email, String name, ExamplesTable table) {
        navigateToManageUsers();
        collaboratorSteps.clickInviteCollaborator();
        collaboratorSteps.setCollaboratorEmail(email);
        collaboratorSteps.setCollaboratorName(name);
        setCollaboratorPermissions(table);
        collaboratorSteps.clickSendInvite();
        String time = DateConverter.convert(LocalDateTime.now(), "h:mm a");
        logger.info(time);
        Serenity.setSessionVariable(ExternalEmails.REGISTRATION.getValue()).to(time);
    }
    //latest

    @When("click on invite collaborator button")
    public void clickOnInviteCollaborator() {
        navigateToManageUsers();
        collaboratorSteps.clickInviteCollaborator(); }


    @When("navigate to Manage Users")
    public void navigateToManageUsers() {
        dashboardSteps.clickOnUserEmail();
        dashboardSteps.selectOptionOnUserPopUp(MANAGE_USERS_SECTION);
    }

    @When("edit collaborator permissions")
    public void editCollaborator() {
        collaboratorSteps.clickEdit();
    }

    @When("set next permissions to collaborator: $table")
    public void setCollaboratorPermissions(ExamplesTable table) {
        collaboratorSteps.switchOffPages(ExamplesTableUtil.parseTableColumnAsList(table, 0));
        ExamplesTableUtil.parseTableToClass(table, CollaboratorPermissionsBean.class)
                .forEach(per -> collaboratorSteps.addPermissions(per.getSection(), per.getAccess()));
    }

    @When("save edited permissions")
    public void savePermissions() {
        collaboratorSteps.saveChanges();
    }

    @When("navigate back to Collaborators list")
    public void clickBackButton() {
        collaboratorSteps.clickBackButton();
    }

    @When("navigate to collaborator's '$email' details")
    public void navigateToCollaboratorDetails(String email) {
        collaboratorSteps.clickOnCollaboratorByEmail(email);
    }

    @Then("$title - title should be displayed on Collaborators page")
    public void checkCollaboratorsTitle(String title) {
        assertEquals(title, collaboratorSteps.getCollaboratorsTitle());
    }

    @Then("Invite collaborator button should be displayed on Collaborators page")
    public void isInviteButtonDisplayed() {
        assertTrue(collaboratorSteps.isInviteButtonDisplayed());
    }

    @Then("collaborator name and email - $name should be displayed on Collaborator details page")
    public void checkName(String name) {
        assertEquals(name, collaboratorSteps.getCollaboratorName());
    }

    @Then("collaborator should have next info on Collaborator details page: $table")
    public void checkStatus(ExamplesTable table) {
        assertEquals(table.getRow(0), collaboratorSteps.getCollaboratorInfo());
    }

    @Then("next collaborator should be present in collaborators list: $table")
    public void checkCollaborators(ExamplesTable table) {
        assertReflectionEquals(table.getRows(), collaboratorSteps.getCollaboratorsList());
    }

    @Then("collaborator should have next permissions: $table")
    public void checkCollaboratorPermissions(ExamplesTable table) {
        assertTrue(collaboratorSteps.getCollaboratorPermissions().containsAll(ExamplesTableUtil.parseTableToClass(table, CollaboratorPermissionsBean.class)));
    }

    @Then("message - '$message' should be displayed on Collaborators page")
    public void getCollaboratorsAbsenceMessage(String message) {
        assertEquals(message, collaboratorSteps.getCollaboratorsAbsenceMessage());
    }
    //sp24
    @When("fill the collaborator user Email ID '$email'")
    public void setCollaboratorEmail(String email){
        collaboratorSteps.setCollaboratorEmail(email);
    }

    @Then("fill the collaborator user name '$name'")
    public void setCollaboratorName(String name){
        collaboratorSteps.setCollaboratorName(name);
    }

    @Then("click o the 'Send Invite' button in the collaborators page")
    public  void clickSendInvite(){
        collaboratorSteps.clickSendInvite();
    }

}
