package com.hhstechgroup.steps.jbehave.scenarios.IUFlowScenarios;

import com.hhstechgroup.steps.serenity.IUFlowSteps.MCO_Admin_Steps;
import com.hhstechgroup.ui.pages.IUFlowPages.CredentialingPage;
import com.hhstechgroup.util.properties.ProviderProperties;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.yecht.Data;

public class MCO_Admin_Scenario {


    @Steps
    MCO_Admin_Steps mcoAdminSteps;
    CredentialingPage credentialingPage;

    @Then("click on text Add new User")
    public void Click_AddNewUserText(){
        mcoAdminSteps.Click_AddNewUserText();
    }
    @Then("fetch status of the added user")
    public void Fetch_StatusOfUser(){
        mcoAdminSteps.Fetch_StatusOfUser();
    }

    @When("click on MCO ADMIN mail '$text'")
    public void openMCO_AdminEmail(String text){
        mcoAdminSteps.openMCO_AdminEmail(text);
    }

    @Then("click on link in mail")
    public void clickOnMCOADMINUserLinkFromGmail(){
        mcoAdminSteps.clickOnMCOADMINUserLinkFromGmail();
    }

    @Then("set password '$password' for MCO ADMIN")
    public void set_Password(String password){
        mcoAdminSteps.set_Password(password);
    }

    @Then("Click on Back to LOgin")
    public void BackToLogin(){
        mcoAdminSteps.BackToLogin();
    }
    @When("Fill First name with value '${firstName}' on Add New User")
    public void fillfirstname(String firstName){
        mcoAdminSteps.setfirst_name(firstName);
    }
    @When("Fill Last name with value '${lastName}' on Add New User")
    public void filllastname(String lastname){
        mcoAdminSteps.setlast_name(lastname);
    }
    @When("Fill Email with '${email}' on Add New User")
    public void fillemail(String email){
        mcoAdminSteps.setemail(email);
    }
    @Then("search with '${email}' on User Management page")
    public void searchwithusername(String criteria) {
        String savedEmail = ProviderProperties.getData1("Email", "Individual2", "Initialized");
        mcoAdminSteps.searchwithusername(savedEmail);
    }
    @Then("verify the status as '$status' on User Management page")
    public void statusverification(String status){
        mcoAdminSteps.statusverification(status);
    }
    @Then("verify the error message '$errormsg'")
    public void verifexistingusemsg(String errormsg){
        mcoAdminSteps.verifexistingusemsg(errormsg);
    }
    @Then("Deactivate the user with reason '$reason'")
    public void deactivateuser(String reason){
        mcoAdminSteps.deactivateuser(reason);
    }
    @Then("click on the link to complete registration")
    public void clickonthelink(){
        mcoAdminSteps.clickonthelink();
    }

    @Then("enter '$password' as password and confirm passowrd")
    public void enterpassword(String password){
        mcoAdminSteps.enterpassword(password);
    }

    @Then("verify generated provider contracts")
    public void verifygeneratedprovidercontract(){
        mcoAdminSteps.verifygeneratedprovidercontract();
    }
    @When("search with request id in providers page")
    public void searchreqid(){
        credentialingPage.searchRequestId("073");
        credentialingPage.clickSearchButton();
    }
    @Then("verify the alert message for MCO Admin")
    public void verifyinactivemsg(){
        mcoAdminSteps.verifyinactivemsg();
    }

    @Then("reactivate the user with reason '$reason'")
    public void reactiveMCOAdmin(String reason){
        mcoAdminSteps.reactiveMCOAdmin(reason);
    }

    @Then("verify '$verification' is displayed")
    public void verifymcoadminpage(String verification){
        mcoAdminSteps.verifymcoadminpage(verification);
    }

}
