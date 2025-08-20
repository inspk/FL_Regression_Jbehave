package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.peportalpages.AuthorizationSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;




import static org.junit.Assert.assertTrue;


public class AuthorizationScenario {

    @Steps
    AuthorizationSteps authorizationSteps;

    @When("click on authorization row with member id '$id'")
    public void clickOnRowWithId(String id) {
        authorizationSteps.clickOnRecordByMemberId(id);
    }

    @When("set member id in search box '$id'")
    public void searchAuthorizationByMember(String id) {
        authorizationSteps.setMemberId(id);
    }

    @When("set CPT code in search box '$cptCode'")
    public void searchAuthorizationByCPTCode(String cptCode){
        authorizationSteps.setCPTCode(cptCode);
    }

    @When("select status '$status' in search box")
    public void searchAuthorizationByStatus(String status) {
        authorizationSteps.selectStatus(status);
    }

    @When("click search")
    public void clickSearch(){
        authorizationSteps.clickSearch();
    }

    @When("reset filters")
    public void resetFilters(){
        authorizationSteps.resetFilters();
    }

    @Then("authorization search block should be present")
    public void isSearchBlockPresent() {
        assertTrue(authorizationSteps.isSearchPanelPresent());
    }

//    @Then("Authorization request details is displayed with next information: $table")
//    public void checkRequestDetails(ExamplesTable table) {
//        assertReflectionEquals(table.getRow(0), authorizationSteps.getAuthorizationRequestInfo());
//    }

    @When("expand search box")
    public void expandSearchBox(){
        authorizationSteps.expandSearchBox();
    }

//    @Then("authorization request with next information should be displayed: $table")
//    public void checkAuthorizationRequests(ExamplesTable table) {
//        assertReflectionEquals(table.getRows(), authorizationSteps.getAuthRequest());
//    }

    @When("navigate to request details")
    public void navigateToRequestDetails(){
        authorizationSteps.navigateToRequestDetails();
    }

    @Then("verify title '$title' is displayed")
    public void verifyPageTitle(String title){
       assertTrue(authorizationSteps.isTitleDisplayed(title));
    }

//    @Then("next general Authorization request information should be displayed: $table")
//    public void checkAuthInfo(ExamplesTable table) {
//        assertReflectionEquals(table.getRow(0), authorizationSteps.getAuthInformation());
//    }
//
//    @Then("requested procedures and services should have text information on details page: $table")
//    public void checkServiceInfo(ExamplesTable table) {
//        assertReflectionEquals(table.getRows(), authorizationSteps.getProceduresAndServices(),  ReflectionComparatorMode.LENIENT_ORDER);
//    }
//
//    @Then("requested procedures and services should have text information: $table")
//    public void checkProceduresServiceInfo(ExamplesTable table) {
//        assertReflectionEquals(table.getRows(), authorizationSteps.getProcedures(), ReflectionComparatorMode.LENIENT_ORDER);
//    }

    @When("expand service details information for service with CPT Code '$cptCode'")
    public void ecpandServiceDetails(String cptCode){
        authorizationSteps.expandService(cptCode);
    }

//    @Then("expanded service details should have next info: $table")
//    public void checkRevalidationHistory(ExamplesTable table) {
//        assertReflectionEquals(table.getRow(0), authorizationSteps.getServiceDetails());
//    }
@Then("select '$name' in Authorized Signatory section")
public void authorizedSignatoryName(String authorizedSignatoryName){
    authorizationSteps.authorizedSignatoryName(authorizedSignatoryName);
}
    @Then("verify the Name with text '$value' and select '$name' in Authorized Signatory section")
    public void VerifyNameAndSelectauthorizedSignatoryName(String value,String authorizedSignatoryName){
        authorizationSteps.VerifyNameAndSelectauthorizedSignatoryName(value,authorizedSignatoryName);
    }

}
