package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.beans.application.ProviderInquiryBean;
import com.hhstechgroup.steps.serenity.provider.ProvidersInquirySteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProvidersInquiryScenario {

    @Steps
    ProvidersInquirySteps providersInquirySteps;

    @When("click on Provider row with npi '$npi'")
    public void checkRow(String npi) {
        providersInquirySteps.clickOnRecordWithNpi(npi);
    }

    @Then("providers Inquiry search block should be present")
    public void isSearchBlockPresent() {
        assertTrue(providersInquirySteps.isSearchPanelPresent());
    }

    @Then("next information about provider should be displayed on Provider details page: $table")
    public void checkProviderInformation(ExamplesTable table) {
        assertEquals(table.getRow(0), providersInquirySteps.getProviderDetails());
    }

    @Then("next $type should be connected to Provider: $table")
    public void checkRequestsConnected(String type, ExamplesTable table) {
        assertEquals(table.getRows(), providersInquirySteps.getRequests(type));

    }
    //sp23
    @When("search for provider inquiry data on IU portal by next parameters: $table")
    public void searchByParameters(ExamplesTable table) {
        ProviderInquiryBean parameters = ExamplesTableUtil.parseTableToClass(table, ProviderInquiryBean.class).get(0);
        providersInquirySteps.setProviderInquirySearchCriteriaAndClickSearch(parameters);
    }
    //sp47.2.1
    @Then("click on the 'MASS UPDATE' Provider Details Page")
    public  void clickonMassUpdateButton() {
        providersInquirySteps.clickonMassUpdateButton();
    }

    @Then("select the npi in the search results")
    public  void clickonnpicheckbox(){
        providersInquirySteps.clickonnpicheckbox();
    }
    @Then("click on the 'BULK SUSPENSION' button in Provider Details Page")
    public  void clickonBulkSuspensionButton() {
        providersInquirySteps.clickonBulkSuspensionButton();
    }

    @Then("click on the 'BULK TERMINATION' button in Provider Details Page")
    public  void clickonBulkSuTerminationButton() {
        providersInquirySteps.clickonTerminationButton();
    }

    @Then("set the provider bulk terminate date '$bulkterminatedate' from the Bulk Terminate Page")
    public void fillBulkTerminateDate(String bulkterminateDate) {
        providersInquirySteps.fillBulkTerminateDate(bulkterminateDate);
    }
    @Then("select provider bulk termination reason '$reason' and '$note' Bulk Termination Page")
    public void setReasonForProviderBulkTermination(String reason,String note) {
        providersInquirySteps.setReasonForProviderBulkTermination(reason, note);
    }
    @Then("click on the '$button' button in Bulk Termination Page")
    public void clickOnTerminationAndReactivationButton(String button) {
        providersInquirySteps.clickOnUpdateButton(button);
    }

    @Then("upload excel file '$path'")
    public void uploadExcel(String path){
        providersInquirySteps.uploadExcel(path);
    }

}
