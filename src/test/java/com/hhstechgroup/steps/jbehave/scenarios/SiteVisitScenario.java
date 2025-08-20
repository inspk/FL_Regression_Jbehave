package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.SiteVisitSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class SiteVisitScenario {

    @Steps
    SiteVisitSteps siteVisitSteps;

    @When("click on Add New button on Site Visit page")
    public void clickAddNew() {
        siteVisitSteps.addNewRequest();
    }

    @When("upload Photograph $path to Facility inspection section")
    public void uploadPhotograph(String path) {
        siteVisitSteps.uploadPhotograph(path);
    }

    @When("upload Photographs $path to Additional questions for inspector section")
    public void uploadPhotographs(String path) {
        siteVisitSteps.uploadPhotographs(path);
    }

    @When("submit new Site Visit Request")
    public void submitSiteVisitRequest() {
        siteVisitSteps.clickSubmit();
    }

    @Then("site visit request shoud have next details: $table")
    public void checkRequestDetails(ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), siteVisitSteps.getRequestDetails());
    }
    @When("select '$siteProvider' from site visit tab")
    public void selectsitevisitprovider(String siteProvider) {
        siteVisitSteps.selectsitevisitprovider(siteProvider);
    }

    }
