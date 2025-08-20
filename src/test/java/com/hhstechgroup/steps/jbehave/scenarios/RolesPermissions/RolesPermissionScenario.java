package com.hhstechgroup.steps.jbehave.scenarios.RolesPermissions;

import com.hhstechgroup.steps.serenity.dashboard.IUDashboardSteps;
import com.hhstechgroup.steps.serenity.rolespermissions.RolePermissionSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;



public class RolesPermissionScenario {
    @Steps
    RolePermissionSteps RolePermissionSteps;

    @Steps
    IUDashboardSteps iuDashboardSteps;


    @When("click on edit button in the Roles details page")
    public void clickOnEditButtonInRolesDetailsPage() {
        RolePermissionSteps.clickOnEditButtonInRolesDetailsPage();}

    @Then("desable all the switches in the roles details page")
    public void desableAlltheSwitches(){
        RolePermissionSteps.desableAlltheSwitches();}

    @Then("enable dashboard switch '$tab' on the Roles permission page")
    public void enableDashboardPermissionSwitch(String tab){
        RolePermissionSteps.enableDashboardPermissionSwitch(tab);}

    @Then("select dashboard display page section")
    public void selectDashboardDisplayPageSection() {
        RolePermissionSteps.selectDashboardDisplayPageSection();}

    @Then("enable read option in the dashboard display page section")
    public void selectReadOptionInDashboardDisplayPageSection(){
        RolePermissionSteps.selectReadOptionInDashboardDisplayPageSection();}

    @Then("click on save changes button in the Roles details page")
    public void clickOnSaveChangesButton() {
        RolePermissionSteps.clickOnSaveChangesButton();}

    @Then("navigate back to dashboard page")
    public void clickbackToDashboardButton() {
        RolePermissionSteps.clickbackToDashboardButton();}

    @Then("Verifying all sub sections names displying")
    public String getAlltheSectionsListInDashBoard(){return RolePermissionSteps.getAlltheSectionsListInDashBoard();}


    @Then("Verifying All Requests '$value1'tab should display in dashboad page '$value2'")
    public void VerifyimgAllrequestTabPresent(String text,String requestname){
        assertEquals("All request name should display",text, RolePermissionSteps.getAllrequestTab(requestname));

    }

    @Then("Verifying Enrollment '$value1'tab should display in dashboad page '$value2'")
    public void getEnrollmentTab(String text,String enrollmentname){
        assertEquals("Enrollment name should display",text, RolePermissionSteps.getEnrollmentTab(enrollmentname));
    }

    @Then("Verifying Appeal '$value1'tab should display in dashboad page '$value2'")
    public void getAppealTab(String text,String appealname){
        assertEquals("Enrollment name should display",text, RolePermissionSteps.getAppealTab(appealname));
    }

    @Then("Verifying Coc '$value1'tab should display in dashboad page '$value2'")
    public void getCocTab(String text,String cocname) {
        assertEquals("Enrollment name should display", text, RolePermissionSteps.getCocTab(cocname));
    }

    @Then("select claim display switch from the roles details")
    public void selectClaimsDisplayPageSection(){
        RolePermissionSteps.selectClaimsDisplayPageSection();}

    @Then("enable read option in the claims display page section")
    public void selectReadOptionInClaimsDisplayPageSection(){
        RolePermissionSteps.selectReadOptionInClaimsDisplayPageSection();}

    //Tc-2 Claims
    @Then("enable claims switch '$tab' on the Roles permission page")
    public void enableClaimsPermissionSwitch(String tab) {
        RolePermissionSteps.enableClaimsPermissionSwitch(tab);
    }
    //1099
    @Then("enable 1099 switch '$tab' on the Roles permission page")
    public void enable1099PermissionSwitch(String tab){
        RolePermissionSteps.enable1099PermissionSwitch(tab);}

    //coc
    @Then("enable coc switch '$tab' on the Roles permission page")
    public void enableCocPermissionSwitch(String tab){
        RolePermissionSteps.enableCocPermissionSwitch(tab);}

    //Appeal
    @Then("enable appeal switch '$tab' on the Roles permission page")
    public void enableAppealPermissionSwitch(String tab){
        RolePermissionSteps.enableAppealPermissionSwitch(tab);}

    //Reports
    @Then("enable reports switch '$tab' on the Roles permission page")
    public void enableReportsPermissionSwitch(String tab){
        RolePermissionSteps.enableReportsPermissionSwitch(tab);}

    @Then("Verifying report $canned , $letter and $adhoc displaying")
    public void isReportsNamesDisplaying(String canned,String letter,String adhoc){
        RolePermissionSteps.isReportsNamesDisplaying(canned, letter, adhoc);}

    //General
    @Then("enable general switch '$tab' on the Roles permission page")
    public void enableGeneralPermissionSwitch(String tab){
        RolePermissionSteps.enableGeneralPermissionSwitch(tab);}

    //System Options

    @Then("enable system options switch '$tab' on the Roles permission page")
    public void enableSystemOptionsPermissionSwitch(String tab){
        RolePermissionSteps.enableSystemOptionsPermissionSwitch(tab);}

    // Enrollment

    @Then("enable enrollment switch '$tab' on the Roles permission page")
    public void enableEnrollmentPermissionSwitch(String tab){RolePermissionSteps.enableEnrollmentPermissionSwitch(tab);}

    //Payment

    @Then("enable payment switch '$tab' on the Roles permission page")
    public void enablePaymentPermissionSwitch(String tab){RolePermissionSteps.enablePaymentPermissionSwitch(tab);}

    //Provider

    @Then("enable provider switch '$tab' on the Roles permission page")
    public void enableProviderPermissionSwitch(String tab){RolePermissionSteps.enableProviderPermissionSwitch(tab);}

    //Message Box

    @Then("enable message box switch '$tab' on the Roles permission page")
    public void enableMessageBoxPermissionSwitch(String tab){RolePermissionSteps.enableMessageBoxPermissionSwitch(tab);}

    //Authourization

    @Then("enable authorization switch '$tab' on the Roles permission page")
    public void enableAuthorizationPermissionSwitch(String tab){RolePermissionSteps.enableAuthorizationPermissionSwitch(tab);}

    //Chat

    @Then("enable chat switch '$tab' on the Roles permission page")
    public void enableChatPermissionSwitch(String tab){RolePermissionSteps.enableChatPermissionSwitch(tab);}

    //Help Centre

    @Then("enable help centre switch '$tab' on the Roles permission page")
    public void enableHelpCentrePermissionSwitch(String tab){RolePermissionSteps.enableHelpCentrePermissionSwitch(tab);}

    //SiteVisit

    @Then("enable sitevisit switch '$tab' on the Roles permission page")
    public void enableSitevisitPermissionSwitch(String tab){RolePermissionSteps.enableSitevisitPermissionSwitch(tab);}


}
