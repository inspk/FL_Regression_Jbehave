package com.hhstechgroup.steps.serenity.sitevisit;

import com.hhstechgroup.ui.pages.sitevisit.SystemOptionsDypPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.List;

public class SystemOptionsDypSteps {
    @Page
    SystemOptionsDypPage systemOptionsDypPage;

    @Step
    public List<String> getSystemOptionsNames() {
        return systemOptionsDypPage.getSystemOptionsNames();
    }

    @Step
    public void clickOnLinksInSystemOptionsPage(String link){
        systemOptionsDypPage.clickOnLinksInSystemOptionsPage(link);
    }

    @Step
    public void clickOnExitLinks(String link){systemOptionsDypPage.clickOnExitLinks(link);}

    @Step
    public boolean ValidatingUserLinkDisplaying() { return systemOptionsDypPage.ValidatingUserLinkDisplaying();}

    @Step
    public boolean ValidatingScreeningLinkDisplaying() { return systemOptionsDypPage.ValidatingScreeningLinkDisplaying();}

    @Step
    public boolean ValidatingAutoAssignLinkDisplaying() { return systemOptionsDypPage.ValidatingAutoAssignLinkDisplaying();}

    @Step
    public boolean ValidatingDataChangeLinkDisplaying() { return systemOptionsDypPage.ValidatingDataChangeLinkDisplaying();}

    @Step
    public boolean ValidatingApprovalsLinkDisplaying() { return systemOptionsDypPage.ValidatingApprovalsLinkDisplaying();}

    @Step
    public boolean ValidatingRolesLinkDisplaying() { return systemOptionsDypPage.ValidatingRolesLinkDisplaying();}

    @Step
    public boolean ValidatingRevalidationLinkDisplaying() { return systemOptionsDypPage.ValidatingRevalidationLinkDisplaying();}

    @Step
    public boolean ValidatingSiteVisitLinkDisplaying() { return systemOptionsDypPage.ValidatingSiteVisitLinkDisplaying();}

    @Step
    public void clickOnUserLink(){systemOptionsDypPage.clickOnUserLink();}

    @Step
    public void clickOnScreeningLink(){systemOptionsDypPage.clickOnScreeningLink();}

    @Step
    public void clickOnAutoAssignLink(){systemOptionsDypPage.clickOnAutoAssignLink();}

    @Step
    public void clickOnDataChangeLink(){systemOptionsDypPage.clickOnDataChangeLink();}

    @Step
    public void clickOnApprovalsLink(){systemOptionsDypPage.clickOnApprovalsLink();}

    @Step
    public void clickOnRolesLink(){systemOptionsDypPage.clickOnRolesLink();}

    @Step
    public void clickOnRevalidationLink(){systemOptionsDypPage.clickOnRevalidationLink();}

    @Step
    public void clickOnSiteVisitLink(){systemOptionsDypPage.clickOnSiteVisitLink();}

    @Step
    public  void clickOnExitUser() {systemOptionsDypPage.clickOnExitUser();}

    @Step
    public  void clickOnExitScreeing() {systemOptionsDypPage.clickOnExitScreeing();}

    @Step
    public  void clickOnExitAutoAssign() {systemOptionsDypPage.clickOnExitAutoAssign();}

    @Step
    public  void clickOnExitDataChange() {systemOptionsDypPage.clickOnExitDataChange();}

    @Step
    public  void clickOnExitApprovals() {systemOptionsDypPage.clickOnExitApprovals();}

    @Step
    public  void clickOnExitRoles() {systemOptionsDypPage.clickOnExitRoles();}

    @Step
    public  void clickOnExitRevalidation() {systemOptionsDypPage.clickOnExitRevalidation();}

    //sp39.2
    @Step
    public  void clickOnExitUserList() {
        systemOptionsDypPage.clickOnExitUserList();
    }

    public  void exitLinkIsDisplaying(String text) {
        systemOptionsDypPage.exitLinkIsDisplaying(text);
    }
    @Step
    public boolean checkText(String text){
        return systemOptionsDypPage.checkText(text);
    }
    @Step
    public boolean checkEditButton(String editButton){
        return systemOptionsDypPage.checkEditButton(editButton);
    }

}
