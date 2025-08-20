package com.hhstechgroup.steps.jbehave.scenarios.sitevisit;

import com.hhstechgroup.steps.serenity.sitevisit.SiteVisitSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class SiteVisitScenario {

    @Steps
    SiteVisitSteps siteVisitSteps ;

    @When("click on create site visit button")
    public void clickCreateSiteVisitButton(){siteVisitSteps.clickCreateSiteVisitButton();}

    @When("set the date '${sitevisitDate}' from the create sitevisit popup")
    public void fillSiteVisitDate(String sitevisitDate){siteVisitSteps.fillSiteVisitDate(sitevisitDate);}

    @When("set the reschedule date '${sitevisitDate}' from the create sitevisit popup")
    public void fillSiteVisitDate1(String sitevisitDate){siteVisitSteps.fillSiteVisitDate1(sitevisitDate);}

    @When("select reason '$reason' and '$note' create site visit popup")
    public void setSiteVisitReason(String reason,String note) {siteVisitSteps.setSiteVisitReason(reason,note);}

    @When("select '$action' from the site visit list")
    public void clickOnActionMenuFromSiteVisitrecordsList(String action){siteVisitSteps.clickOnActionMenuFromSiteVisitrecordsList(action);}

    @When("click on go to sitevisit button")
    public void clickGoToSiteVisitButton(){siteVisitSteps.clickGoToSiteVisitButton();}

    @When("select reschedule reason '$reason' and '$note' create site visit popup")
    public void setSiteVisitReason1(String reason,String note) {siteVisitSteps.setSiteVisitReason1(reason,note);}

    //sp45.3
    @Then("click on plus site visit button")
    public void clickPlusSiteVisitButton(){
        siteVisitSteps.clickPlusiteVisitButton();
    }
    @Then("search the '$npi' field for site visit")
    public void searchNPIfield(String searchnpifield) {
        siteVisitSteps.searchNPIfield(searchnpifield);
    }
    @Then("click on the 'Create' site visit button")
    public void clickonCreateButton() {
        siteVisitSteps.clickonCreateButton();
    }

    //SD-05

    @When("click on $yes to waive Site Visit")
    public void clickYesInRetroApprovalButton(String button) {
        siteVisitSteps.clickYesInRetroApprovalButton(button);
    }

    @Then("select locations '$locations' to create sitevisit")
    public void selectLocationsToCreateSiteVisit(String locations) {
        siteVisitSteps.selectLocationsToCreateSiteVisit(locations);
    }
}
