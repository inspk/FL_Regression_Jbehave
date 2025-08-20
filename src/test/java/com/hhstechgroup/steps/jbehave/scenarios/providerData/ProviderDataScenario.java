package com.hhstechgroup.steps.jbehave.scenarios.providerData;

import com.hhstechgroup.beans.AuditEventsSearchBean;
import com.hhstechgroup.beans.ProviderDataSearchResultBean;
import com.hhstechgroup.beans.ProviderSearchResultBean;
import com.hhstechgroup.steps.serenity.enrollment.EnrollmentCocSteps;
import com.hhstechgroup.steps.serenity.providerData.ProviderDataSteps;
import com.hhstechgroup.steps.serenity.screening.ScreeningSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import com.hhstechgroup.util.properties.ProviderProperties;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.collection.IsArrayContaining;
import org.hamcrest.collection.IsMapContaining;
import org.hamcrest.core.Is;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class ProviderDataScenario {

    @Steps
    ProviderDataSteps providerDataSteps;

    @Steps
    ScreeningSteps screeningSteps;

    @Steps
    EnrollmentCocSteps enrollmentCocSteps;

    @When("click tab with name '$name' on provider data page")
    public void clickTabWithName(String tabName) {
        providerDataSteps.clickToTabWithName(tabName);
    }


    @When("search for provider by name '$provider' with status '$status' and get specific request id and save it to '$variable' with delay '$delay'")
    public void getRequestId(String name, String status, String variable, String delay) {
        String requestId =  enrollmentCocSteps.getRequestIdByName(name,status, Integer.parseInt(delay));
        String updatedRequestId = requestId.replaceAll("[^0-9]", "");
        Serenity.setSessionVariable(variable).to(updatedRequestId);
        ProviderProperties.save("First.Name.Provider1", name);
        ProviderProperties.save("requestId", requestId);
        ProviderProperties.save("Status.Provider1", status);

    }
    @When("submits screening with status '$status' and get specific request id and save it to '$variable' with delay '$delay'")
    public void getRequestIdWithTrackingNum(String status, String variable, String delay) {
        String requestId =  enrollmentCocSteps.getRequestIdByTrackingNum(status, Integer.parseInt(delay));
        String updatedRequestId = requestId.replaceAll("[^0-9]", "");
        Serenity.setSessionVariable(variable).to(updatedRequestId);
//        ProviderProperties.save("First.Name.Provider1", name);
        ProviderProperties.save("requestId", requestId);
        ProviderProperties.save("Status.Provider1", status);

    }

    @Then("search for provider by name '$provider' with status '$status' with delay '$delay'")
    public void getEnrollmentStatus(String name, String status, String delay) {
        Assert.assertTrue(enrollmentCocSteps.ifStatusDisplayedByName(name, status, Integer.parseInt(delay)));
        ProviderProperties.save("Status.Provider1", status);

    }



    @Then("provider name is '$providerName' on provider details page")
    public void checkProviderNameOnProviderDetails(String providerName) {
        assertTrue(providerDataSteps.checkProviderNameOnProviderDetails(providerName));
    }

    @Then("provider name is '$providerName' and status is '$providerStatus' on provider details page on IU portal")
    public void checkProviderNameStatusOnProviderDetailsIU(String providerName, String providerStatus) {
        assertTrue(providerDataSteps.checkProviderNameStatusOnProviderDetailsIU(providerName, providerStatus));
    }

    @When("click view details for record type '$type' on provider history page")
    public void clickViewDetailsForRowWithText(String type) {
        providerDataSteps.clickViewHistoryByType(type);
    }

    @When("search for provider data on IU portal by next parameters: $table")
    public void searchByParameters(ExamplesTable table) {
        ProviderDataSearchResultBean parameters = ExamplesTableUtil.parseTableToClass(table, ProviderDataSearchResultBean.class).get(0);
        providerDataSteps.setProviderDataSearchCriteriaAndClickSearch(parameters);
    }

    @When("click reset filters for provider data on IU portal")
    public void resetFiltersForProviderSearch() {
        providerDataSteps.resetFiltersOnProviderSearch();
    }

    //latest
    @When("click reset filters for enrollment data on IU portal")
    public void resetFiltersForEnrollmentSearch() {
        providerDataSteps.resetFiltersOnProviderSearch();
    }

    @When("click to provider data with text '$text' on IU portal")
    public void checkProviderDataFound(String text) {
        providerDataSteps.clickViewDetailsForRowWithText(text);
    }

    @When("click on View Details button on Revalidation tab")
    public void clickViewDetailsOnRevalidation() {
        providerDataSteps.clickOnViewRevalidationDetails();
    }

    @When("expand Revalidation history tab")
    public void expandRevalidationHistory() {
        providerDataSteps.clickOnViewRevalidationHistory();
    }

    @Then("view details should have next data on provider history page: $table")
    public void checkExpandedRow(ExamplesTable table) {
        table.getRow(0).forEach((key, value) -> assertThat(providerDataSteps.getViewDetailsRowInfo(), IsMapContaining.hasEntry(key, value)));
    }

    @Then("next provider data should be found on IU portal: $table")
    public void checkProviderDataFound(ExamplesTable table) {
        table.getRows().forEach(row -> { providerDataSteps.getProviderDataSearchResults().forEach(inf -> { row.forEach((key, value) -> assertThat(inf, IsMapContaining.hasEntry(key, value))); }); });
    }

    @Then("provider data search results should be not found on IU portal")
    public void checkProviderDataNotFound() {
        assertTrue(providerDataSteps.checkProviderSearchResultsNotFound());
    }

    @Then("provider data history should contain next info: $table")
    public void checkRequestDetailsInfo(ExamplesTable table) {
        assertReflectionEquals(table.getRows(), providerDataSteps.getProviderDataHistoryList());
    }

    @Then("verify $tab block on Summary tab contains next info: $table")
    public void verifyAppealsOnSummary(String type, ExamplesTable table) {
        assertEquals(table.getRows(), providerDataSteps.getSummaryRequests(type));
    }

    @Then("provider data should contain next details: $table")
    public void checkRequestDetails(ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), providerDataSteps.getProviderInformation());
    }

    @Then("provider data should contain next details on IU portal: $table")
    public void checkRequestDetailsOnIuPortal(ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), providerDataSteps.getProviderInformationOnIUPortal());
    }

    @Then("provider data should contain next details in Revalidation tab: $table")
    public void checkRevalidationDetails(ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), providerDataSteps.getRevalidationDetails());
    }

    @Then("expanded Revalidation history should have next info: $table")
    public void checkRevalidationHistory(ExamplesTable table) {
        assertReflectionEquals(table.getRows(), providerDataSteps.getExpandedRevalidationDetails());
    }

    @Then("timeline record # '$record' has following details: $table")
    public void checkTimelineValuesForRecordWithNumber(ExamplesTable table, String record) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(providerDataSteps.getMappedTimelineValuesForRecord(record), Is.is(expectedInfo));
    }

    @When ("click on request link for record # '$record' in timeline")
    public void clickOnRequestLinkInTimelineForRecordWithNumber(String record) {
        providerDataSteps.clickOnRequestLinkInTimeline(record);
    }

    @When ("click on record with # '$record' in timeline")
    public void clickOnTimelineRecordWithNumber(String record) {
        providerDataSteps.clickOnTimelineRecordWithNumber(record);
    }

    @When("click on Reactivate button in provider details")
    public void clickOnReactivatinButton() {
        providerDataSteps.clickReactivation();
    }
    @When("select reactivation reason '$reason' in Reactivation popup")
    public void setReason(String reason) {
        providerDataSteps.setReasonForReactivation(reason);
    }

    @When("click on Reactivate button in Reactivation popup")
    public void clickReactivateButtonInPopup() {
        providerDataSteps.clickReactivateButtonInPopup();
    }

    @Then("Reactivate button should not be displayed")
    public void isReactivateButtonAbsent() {
        assertFalse("Reactivate button should not be displayed", providerDataSteps.isReactivateButtonAbsent());
    }
    //latest
    @Then("verify the Message '$npi' is displaying")
    public boolean isDulpicateNPIMessagedisplaying(String npi) {return providerDataSteps.isDulpicateNPIMessagedisplaying(npi);}

    @Then("verify the data change Notification is '$notification' is displaying")
    public boolean isDataChangeNotificationdisplaying(String notification) {
        return providerDataSteps.isDataChangeNotificationdisplaying(notification);}

    @Then("click on back to TP button in povider portal page")
    public void clickOnBackToTPPortalButton(){providerDataSteps.clickOnBackToTPPortalButton();};

    @Then("verify the PE portal datachange Notification is '$notification' is displaying")
    public boolean isPEDataChangeNotificationdisplaying(String penotification) {
        return providerDataSteps.isPEDataChangeNotificationdisplaying(penotification);}

    @Then("next provider data should be found: $table")
    public void checkProviderData(ExamplesTable table) {
        List<Map<String, String>> actualResults = providerDataSteps.getResults();
        actualResults.forEach(entry -> entry.remove("Provider ID"));
        actualResults.forEach(entry -> entry.remove("Next Site Visit Date"));
        actualResults.forEach(entry -> entry.remove("Next Revalidation Date"));
        assertFalse(actualResults.containsAll(table.getRows()));
    }
    @Then("expanded provider data  should have next attributes: $table")
    public void checkExpandedRow1(ExamplesTable table) {
        table.getRow(0).forEach((key, value) -> assertThat(providerDataSteps.getExpandedRowInfo(), IsMapContaining.hasEntry(key, value)));
    }

    @Then("provider status as '$status' is displaying")
    public void checkstatus(String status) {
        assertTrue(providerDataSteps.checkStatus(status));
    }
    @Then("verify provider status should be '$providerStatus' on the Enrollment tab in IU portal")
    public void checkProviderStatus(String providerStatus){
        assertTrue(providerDataSteps.checkProviderStatus(providerStatus));
    }
    @Then("check '$doc' is present")
    public void checkScreeningDocument(String screeningDoc){
//        assertTrue(providerDataSteps.checkScreeningDocument(screeningDoc));
        providerDataSteps.checkScreeningDocument(screeningDoc);
    }
    @Then("check '$button' is present in COC tab")
    public void checkCOCButton(String cocButton){
        assertTrue(providerDataSteps.checkCOCButton(cocButton));
    }
    @Then("Tp provider status as '$status' is displaying")
    public void notCheckstatus(String status) {
        assertTrue(providerDataSteps.checkTpStatus(status));
    }


    //sp23

    @When("click on search in affiliation coc")
    public void clickOnSearchIcon(){providerDataSteps.clickOnSearchIcon();}

    @When("select checkbox '$checkbox' in the Affiliation Page")
    public void selectEndAffiliationCheckboxAndSearch(String checkbox){
        providerDataSteps.selectEndAffiliationCheckboxAndSearch(checkbox);
    }
    @When("select '$checkbox' in the Affiliation Page")
    public void selectShowEndedAffiliationCheckboxAndSearch(String checkbox){
        providerDataSteps.selectShowEndedAffiliationCheckboxAndSearch(checkbox);
    }
    @When("click on search in Affiliation tab")
    public void clickOnSearch(){
        providerDataSteps.clickOnSearch();
    }
    @Then("click on reconsideration type to search with '$type'  in reconsideration tab")
    public void clickOnReconsiderationTypeAndSelectTypeAndSearch(String reconsiderationType){
        providerDataSteps.clickReconsiderationTypeAndSelectTypeAndSearch(reconsiderationType);
    }
    @Then("click on site visit FAQ to verify '$answer' text")
    public void clickAndVerify(String answer){
        assertTrue(providerDataSteps.verifySiteVisitFaqAnswer(answer));

    }
    @Then("check results after search")
    public void checkSearchResult(){
        providerDataSteps.checkSearchResult();
    }
    @Then("fetch PESID")
    public void fetchPESID(){
        providerDataSteps.fetchPESID();
    }
    @Then("click on the '$enrollmentType' provider")
    public void clickOnEnrollmentType(String enrollmentType){
        providerDataSteps.clickOnEnrollmentType(enrollmentType);
    }
    @Then("click on the PEM provider")
    public void clickonpemenrollmenttype(){
        providerDataSteps.clickonpemenrollmenttype();
    }
    @Then("check '$sectionName' section is displaying in provider data")
    public void checkSectionName(String sectionName){
        assertTrue(providerDataSteps.checkSectionName(sectionName));
    }

    //new
    @When("edit '$fieldName' name and change the data '$changedata'")
    public void editField(String fieldName,String changedata) {providerDataSteps.editField(fieldName,changedata);}

    //duplicity

    @Then("search for provider with status '$status' with delay '$delay'")
    public void getEnrollmentStatus(String status, String delay) {
        Assert.assertTrue(enrollmentCocSteps.ifStatusDisplayedByName(status, Integer.parseInt(delay)));
    }

    @When("click button More")
    public void clickMoreButton() {
        enrollmentCocSteps.clickButtonMore();
    }

    // sp30 pem status
    @Then("provider pem status as '$status' is displaying")
    public void checkPemstatus(String status) {
        assertTrue(providerDataSteps.checkPemStatus(status));
    }

    //WY-65

    @When("click to new provider data with text '$text' on IU portal")
    public void checkProviderDataFound1(String text) {
        providerDataSteps.clickViewDetailsForRowWithText1(text);
    }

    @When("verify provider data style color: $color")
    public void verifyStyleColor(String color){
        providerDataSteps.verifyStyleColor(color);
    }

    @Then("verify popup message '$message' is displaying on IU portal")
    public void isMessageDisplaying(String message) {
        if(providerDataSteps.isDulpicateNPIMessagedisplaying(message))
            System.out.println(message + " - is displayed!");
        else
            System.out.println(message + " - is not displayed!");

    }

    @When("verify that Re-Enrollment Button presents")
    public void isReEnrollmentButtonPresents(){
        if(providerDataSteps.isReEnrollmentButtonPresents()){
            System.out.println("Re-enrollment button presents");
        }
        else{
            System.out.println("Re- enrollment button not presents");
        }
    }

    @Then("Validating all the parameters should be displayed on Provider Data Page: $table")
    public void checkFilters(ExamplesTable table) {
        List<String> expectedNames = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertEquals(expectedNames, providerDataSteps.getScreeningParameters());
    }

    @Then("click ok in popup")
    public void clickPopupOk(){
        providerDataSteps.clickPopupOk();
    }

    @When("click edit for $field")
    public void clickEditField(String header){
        providerDataSteps.clickEditField(header);
    }

    @Then("set new death date '$deathdate' with reason code '$reasoncode'")
    public void setNewDeathDate(String deathDate, String reasonCode) {
        providerDataSteps.setNewDeathDate(deathDate, reasonCode);
    }

    @Then("set new agentid '$newagentid' with reason code '$reasoncode'")
    public void setNewAgentId(String newAgentId, String reasoncode) {
        providerDataSteps.setNewAgentId(newAgentId, reasoncode);
    }

    @Then("validate all the parameters should be displayed on monitoring tab: $table")
    public void getMonitoringTabParameters(ExamplesTable table) {
        List<String> expectedNames = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertEquals(expectedNames, providerDataSteps.getMonitoringTabParameters());
    }

    @Then("click '$tab' in monitoring tab")
    public void clickMonitoringTab(String tab){
        providerDataSteps.clickMonitoringTab(tab);
    }

    @Then("validate all the columns should be displayed on monitoring tab: $table")
    public void getMonitoringColoumns(ExamplesTable table) {
        List<String> expectedNames = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertEquals(expectedNames, providerDataSteps.getMonitoringColoumns());
    }

    @Then("verify '$text' as '$value' in sitevisit")
    public void verifySitevisitTextValue(String text, String value) {
        String data = providerDataSteps.getSitevisitData(text);
        assertTrue(data,data.contains(value));
    }

    @Then("search with providerID in provider tab")
    public void searchWithProviderID(){
        providerDataSteps.searchWithProviderIDInProviderTab();
        providerDataSteps.clickOnSearchIcon();
    }
    @Then("search with tracking num in Enrollment tab")
    public void searchWithTrackingNum(){
        providerDataSteps.searchWithTrackingNum();
        providerDataSteps.clickOnSearchIcon();

    }

    @Then("search with reconsideration requestID in reconsideration tab")
    public void searchWithReconsiderationRequestID(){
        providerDataSteps.searchWithReconsiderationRequestID();
        providerDataSteps.clickOnSearchIcon();


    }
    @Then("search with coc request id to approve the request of the provider")
    public void searchWithCOCIDToApprove(){
        providerDataSteps.searchWithCOCIDToApprove();
        providerDataSteps.clickOnSearchIcon();
    }

    @Then("search with coc request id to deny the request of the provider")
    public void searchWithCOCIDToDeny(){
        providerDataSteps.searchWithCOCIDToDeny();
        providerDataSteps.clickOnSearchIcon();
    }

    @Then("search with reenrollment request ID to approve the request of the provider in Enrollment tab")
    public void searchWithReenrollmentRequestIDToApprove(){
        providerDataSteps.searchWithReenrollmentRequestIDToApprove();
        providerDataSteps.clickOnSearchIcon();
    }
    @Then("search with reenrollment request ID to deny the request of the provider in Enrollment tab")
    public void searchWithReenrollmentRequestIDToDeny(){
        providerDataSteps.searchWithReenrollmentRequestIDToDeny();
        providerDataSteps.clickOnSearchIcon();
    }
    @Then("search with the revalidation request ID")
    public void searchWithRevalidationRequestID(){
        providerDataSteps.searchWithRevalidationRequestID();
        providerDataSteps.clickOnSearchIcon();
    }

}
