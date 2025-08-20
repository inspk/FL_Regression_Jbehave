package com.hhstechgroup.steps.jbehave.scenarios.sitevisit;

import com.hhstechgroup.steps.serenity.sitevisit.SystemOptionsDypSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.model.ExamplesTable;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SystemOptionsDypScenario {
    @Steps
    SystemOptionsDypSteps systemOptionsDypSteps;


    @Then("Validating all the name should be displayed on system option page: $table")
    public void checkFilters(ExamplesTable table) {
        List<String> expectedNames = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertEquals(expectedNames, systemOptionsDypSteps.getSystemOptionsNames());
    }

    @Then("click on '$value' links in system options")
    public void clickOnLinksInSystemOptionsPage(String link){
        systemOptionsDypSteps.clickOnLinksInSystemOptionsPage(link);
    }

    @Then("click on '$value' exit links and navigate back to system option page")
    public void clickOnExitLinks(String link){systemOptionsDypSteps.clickOnExitLinks(link);}

    @Then("Verifying User Link displaying in System Options Page")
    public void ValidatingUserLinkDisplaying() {
        assertTrue("User link should be displaying",systemOptionsDypSteps.ValidatingUserLinkDisplaying());
    }
    @Then("Verifying Screening Link displaying in System Options Page")
    public void ValidatingScreeningLinkDisplaying() {
        assertTrue("Screening link should be displaying",systemOptionsDypSteps.ValidatingScreeningLinkDisplaying());
    }

    @Then("Verifying AutoAssign Link displaying in System Options Page")
    public void ValidatingAutoAssignLinkDisplaying() {
        assertTrue("AutoAssign link should be displaying",systemOptionsDypSteps.ValidatingAutoAssignLinkDisplaying());
    }

    @Then("Verifying DataChange Link displaying in System Options Page")
    public void ValidatingDataChangeLinkDisplaying() {
        assertTrue("DataChange link should be displaying",systemOptionsDypSteps.ValidatingDataChangeLinkDisplaying());
    }

    @Then("Verifying Approvals Link displaying in System Options Page")
    public void ValidatingApprovalsLinkDisplaying() {
        assertTrue("Approvals link should be displaying",systemOptionsDypSteps.ValidatingApprovalsLinkDisplaying());
    }

    @Then("Verifying Roles Link displaying in System Options Page")
    public void ValidatingRolesLinkDisplaying() {
        assertTrue("Roles link should be displaying",systemOptionsDypSteps.ValidatingRolesLinkDisplaying());
    }

    @Then("Verifying Revalidation Link displaying in System Options Page")
    public void ValidatingRevalidationLinkDisplaying() {
        assertTrue("Revalidation link should be displaying",systemOptionsDypSteps.ValidatingRevalidationLinkDisplaying());
    }


    @Then("Verifying SiteVisit Link displaying in System Options Page")
    public void ValidatingSiteVisitLinkDisplaying() {
        assertTrue("SiteVisit link should be displaying",systemOptionsDypSteps.ValidatingSiteVisitLinkDisplaying());
    }

//Test Case 2

    @Then("Click on User Link in System Options Page")
    public void clickOnUserLink(){systemOptionsDypSteps.clickOnUserLink();}

    @Then("Click on Screening Link in System Options Page")
    public void clickOnScreeningLink(){systemOptionsDypSteps.clickOnScreeningLink();}

    @Then("Click on AutoAssign Link in System Options Page")
    public void clickOnAutoAssignLink(){systemOptionsDypSteps.clickOnAutoAssignLink();}

    @Then("Click on DataChange Link in System Options Page")
    public void clickOnDataChangeLink(){systemOptionsDypSteps.clickOnDataChangeLink();}

    @Then("Click on Approvals Link in System Options Page")
    public void clickOnApprovalsLink(){systemOptionsDypSteps.clickOnApprovalsLink();}

    @Then("Click on Roles Link in System Options Page")
    public void clickOnRolesLink(){systemOptionsDypSteps.clickOnRolesLink();}

    @Then("Click on Revalidation Link in System Options Page")
    public void clickOnRevalidationLink(){systemOptionsDypSteps.clickOnRevalidationLink();}

    @Then("Click on SiteVisit Link in System Options Page")
    public void clickOnSiteVisitLink(){systemOptionsDypSteps.clickOnSiteVisitLink();}

    //test case 2

    @Then("click on exit user link from the user page")
    public  void clickOnExitUser() {systemOptionsDypSteps.clickOnExitUser();}

    @Then("click on exit Screening link from the Screening page")
    public  void clickOnExitScreeing() {systemOptionsDypSteps.clickOnExitScreeing();}

    @Then("click on exit Auto Assign link from the Auto Assign page")
    public  void clickOnExitAutoAssign() {systemOptionsDypSteps.clickOnExitAutoAssign();}

    @Then("click on exit Data Change link from the Data Change page")
    public  void clickOnExitDataChange() {systemOptionsDypSteps.clickOnExitDataChange();}

    @Then("click on exit Approvals link from the Approvals page")
    public  void clickOnExitApprovals() {systemOptionsDypSteps.clickOnExitApprovals();}

    @Then("click on exit Roles link from the Roles page")
    public  void clickOnExitRoles() {systemOptionsDypSteps.clickOnExitRoles();}

    @Then("click on exit Revalidation link from the Revalidation page")
    public  void clickOnExitRevalidation() {systemOptionsDypSteps.clickOnExitRevalidation();}

    //sp39.2
    @Then("click on exit user link list from the user page")
    public  void clickOnExitUserList() {
        systemOptionsDypSteps.clickOnExitUserList();
    }

    @Then("validate '$text' Exit link is displayed")
    public void exitLinkIsDisplaying(String text){
        systemOptionsDypSteps.exitLinkIsDisplaying(text);
        System.out.println("Exit link of" +text+"isPresent");
    }
    @Then("check '$text' text is displayed in system options")
    public void checkText(String text){
       assertTrue(systemOptionsDypSteps.checkText(text));
    }

    @Then("check '$editButton' button is displayed in system options")
    public void  checkEditButton(String editButton){
        assertTrue(systemOptionsDypSteps.checkEditButton(editButton));
    }
}
