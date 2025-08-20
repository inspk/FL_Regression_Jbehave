package com.hhstechgroup.steps.jbehave.scenarios.sitevisit;

import com.hhstechgroup.steps.serenity.enrollment.EnrollmentCocSteps;
import com.hhstechgroup.steps.serenity.gmail.GmailSteps;
import com.hhstechgroup.steps.serenity.sitevisit.UserSteps;
import com.hhstechgroup.util.common.ExternalEmails;
import com.hhstechgroup.util.converters.DateConverter;
import com.hhstechgroup.util.properties.ProviderProperties;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.yecht.Data;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class UserScenario {
    @Steps
    UserSteps userSteps;

    @Steps
    GmailSteps gmailSteps;

    @Steps
    EnrollmentCocSteps enrollmentCocSteps;


    @When("click on adduser")
    public void clickOnAddUser() {userSteps.clickOnAddUser(); }


    @Then("Verifying Add new user pop-up is opened")
    public void isAddNewUserPopupOpened() {
        assertTrue(userSteps.isAddNewUserPopupOpened());}


        @When("Click user first name")
        public void clickUserFirstName(){userSteps.clickUserFirstName();}


    @When("Click user last name")
    public void clickUserLastName(){userSteps.clickUserLastName();}

    @When ("fill User firstname field with value '$value1'")
    public void fillUserFirstName(String value) {
        userSteps.fillUserFirstName(value);}

    @When ("fill User lastname field with value '$value2'")
    public void  fillUserLastName(String value) { userSteps.fillUserLastName(value);}

    @Then("Verifying '$username' should be displayed in Username field1")
    public void getUserFirstNameValue(String username) {
        assertEquals("user first name value is displayed", username,userSteps.getUserFirstNameValue() );
    }

    @Then("Verifying '$password' should be displayed in Lastname field2")
    public void getUserLastNameValue(String password) {
        assertEquals("user last name value is displayed", password, userSteps.getUserLastNameValue());}

     @When("fill user Email ID '$value2'")
     public void fillUserEmailUserId(String value2) {userSteps.fillUserEmailUserId(value2);}

     @Then("click on add button from the user page")
     public void clickAddbuttonFromUserPage(){userSteps.clickAddbuttonFromUserPage();

        String time = DateConverter.convert(LocalDateTime.now(), "h:mm a");
        // logger.info(time);
         Serenity.setSessionVariable(ExternalEmails.REGISTRATION_IU.getValue()).to(time);}

    @Then("click on role field from the user")
    public void clickOnRoleField(){userSteps.clickOnRoleField();}

     @Then("select any role from user page")
     public void selectAnyRolefromUser(){userSteps.selectAnyRolefromUser();}

     @Then("type user email id '$value1'")
     public void setUserEmailId(String value){userSteps.setUserEmailId(value);}

     @Then("set user password '$value2'")
     public void setUserEmailPw(String value){userSteps.setUserEmailPw(value);}

     @Then("click on next button from the user email")
     public void clickOnNextButton() {userSteps.clickOnNextButton();}

     @Then("set user password '$value3'")
     public void setUserPassword(String value3){userSteps.setUserPassword(value3);}

     @Then("confirm user password '$value4'")
    public void setUserConfirmPassword(String value4){userSteps.setUserConfirmPassword(value4);}

    @Then("click on set password button to confirm the user")
    public void clickOnSetPasswordButton(){userSteps.clickOnSetPasswordButton();}

    @Then("navigate back to user dashboard page")
    public void clickoOnDashboardButton() {userSteps.clickoOnDashboardButton();}

    @Then("select the parent mail")
    public void selectParentMail(){
        userSteps.selectParentMail();
        userSteps.clickOnYesButton();
        }

    @Then("go to gmail to inbox page")
    public void clickOnGmailIcon(){
        userSteps.clickOnGmailIcon();
    }

    @Then("switch to gmail tab")
    public void switchToGmailtab(){userSteps.switchToGmailtab(); }

    @Then("switch to current tab")
    public void switchToCurrentTab(){userSteps.switchToGmailtab(); }

    @Then("click on user link from the gmail")
    public  void clickOnUserLinkFromGmail(){
        userSteps.clickOnUserLinkFromGmail();}

    @Then("switch to user set password window")
    public void switchTosetPasswordWindow(){userSteps.switchTosetPasswordWindow();}

    @Then("enter password to reset the user password '$password1'")
    public void enterPasswordForUser(String value1) {
        userSteps.enterPasswordForUser(value1);
    }

    @Then("click on confirm password field")
    public void clickOnConfirmPasswordField(){userSteps.clickOnConfirmPasswordField();}

    @Then("confirm the password by re entering the user password '$password1'")
    public void enterConfirmedPassword(String value1) {userSteps.enterConfirmedPassword(value1);}

    @Then("click on set password fro the user")
    public void clickOnSetPasswordFromUser() {userSteps.clickOnSetPasswordFromUser();}

    @Then("navigate to user dashboard page")
    public void clickOnDashboard(){userSteps.clickOnDashboard();}

    @Then("select role from user list")
    public void selectUserRole(){userSteps.selectUserRole();}

    @Then("click on cancel button in add user page")
    public void clickOnCancelButtonInAddUser(){userSteps.clickOnCancelButtonInAddUser();}

    //latest
    @When("select '$user' from user list")
    public void selectUser(String user) {
        userSteps.selectUser(user);

    }
    @When("search for $username in site visit user")
    public void setUserName(String userName){
        userSteps.setUserName(userName);
        enrollmentCocSteps.clickSearch();
    }

    //sp21
    @When("select the reason '$reason' and '$note' to the deactivation and inactive the user")
    public void selectReasonDeactiveAndActiveUser(String reasonForDeactivate,String note){
        userSteps.selectReasonDeactiveAndActiveUser(reasonForDeactivate,note);
    }
    @Then("click on '$button' user Deactivation or Reactivation")
    public void clickOnDectivationAndReactivationButton(String button){
        userSteps.clickOnDectivationAndReactivationButton(button);
    }

    @Then("verify the User Deactivation Popup '$popup' is displaying")
    public boolean isPopupisplaying(String popup) {
        return userSteps.isPopupisplaying(popup);
    }

    @When("select the reason '$reason' and '$note' to active and inactive the user")
    public void selectReasonToActiveAndDeactiveTheUser(String reasonForDeactivate,String note){
        userSteps.selectReasonToActiveAndDeactiveTheUser(reasonForDeactivate,note);
    }
    @When("click on details button from the user details page")
    public void clickOnDeatils( ) {
        userSteps.clickOnDeatils();
    }

    @When("scroll to details field in the user details page")
    public void scrollToDetailsField(){userSteps.scrollToDetailsField();}

    @When("select roles as '$role'")
    public void selectAnyRolefromUser1(String role){userSteps.selectAnyRolefromUser1(role);}

    @When("select grpup type as '$grouptype'")
    public void selectGroupForMCOAdminUser(String grouptype){userSteps.selectGroupForMCOAdminUser(grouptype);}

    @When("edit user name '$name' in the user details page - '$field'")
    public void editUserName(String userName,String field) {
    userSteps.editUserName(userName,field);
    }

    @When("edit time zone '$timezone' in the user details page- '$zone'")
    public void editTimeZone(String timeZone,String zone) {
        userSteps.editTimeZone(timeZone,zone);
    }

    @When("edit language spaken '$languagespaken' in the user details page")
    public void editLaguageSpoken(String languageSpoken) {
        userSteps.editLaguageSpoken(languageSpoken);
    }
    @When("remove role '$role' from the user details page")
    public void removeRoleFromUserDetails(String remove) {
        userSteps.removeRoleFromUserDetails(remove);
    }

    @When("click on add button in the user details page")
    public void clickOnAddbuttonFromUserDetails(){userSteps.clickOnAddbuttonFromUserDetails();}

    @When("select any role '$role' from the user details page")
    public void selectAnyRoleFromUserDetaisPage(String role) { userSteps.selectAnyRoleFromUserDetaisPage(role);}

    @When("select '$action' from the provider details page")
    public void selectActionFromProviderDetails(String action) {userSteps.selectActionFromProviderDetails(action);}

    @When("validating provider termination popup is displaying")
    public void isUserTerminationPopupOpened(){assertTrue(userSteps.isUserTerminationPopupOpened());}

    @When("set the provider reactivate date '$reactivatedate' from the Provider Reactivate popup")
    public void providerReactivateDate(String reactivateDate){userSteps.setProviderReactivateDate(reactivateDate);}

    @When("set the provider terminate date '$terminatedate' from the Provider Terminate popup")
    public void providerTerminateDate(String terminateDate){userSteps.setProviderTerminateDate(terminateDate);}

    @When("click '$button' button reactivate or terminate the provider")
    public void clickOnTerminationAndReactivationButton(String button){userSteps.clickOnTerminationAndReactivationButton(button);}

    //adding to sp21

    @When("set the provider suspended date '$suspenedeDate' from the Provider suspended popup")
    public void fillProviderSuspendedDate(String suspenedeDate) {userSteps.fillProviderSuspendedDate(suspenedeDate);}


    @When("select provider reactivation reason '$reason' and '$note' Provider Reactivation/Termination popup")
    public void setReasonForProviderReactivation(String reason,String note) {
        userSteps.setReasonForProviderTerminationOrReactivatation(reason,note);

    }
    @When("verifing '$action' button present")
    public void isTerminationOrReactivationdisplaying(String action){
        assertTrue("Terminate button is present",userSteps.isTerminationOrReactivationdisplaying(action));
    }
    @When("verifing '$action' button not present")
    public void isTerminationOrReactivationNotdisplaying(String action){
        userSteps.isTerminationOrReactivationNotdisplaying(action);
    }
//
    @When("verify provider is Your enrollment has been terminated displaying")
    public void prividerTerminated(){
        assertTrue("provider is terminated",userSteps.prividerTerminated());
    }
//

    @When("click on back button from the Terminated Provider")
    public void backFromTerminatedProvider(){userSteps.backFromTerminatedProvider();}


    @When("click on action from the user ")
    public void clickOnActionMenu(){userSteps.clickOnActionMenu();}



    @Then("click on '$name' in the permission page")
    public void clickOnPermissionName(String name){
        userSteps.clickOnPermissionName(name);}

    @When("select provider terminate checkbox")
    public void selectProviderTerminateCheckbox(){userSteps.selectTerminateCheckbox();}

    @When("select provider reactivate checkbox")
    public void selectProviderReactivateCheckbox(){userSteps.selectReactivateCheckbox();}

    //sp23
    @Then("verifying the Reassign Role pop-up is opened")
    public void isReassignRolePopupOpened() {
        assertTrue(userSteps.isReassignRolePopupOpened());
    }
    @When("fill the Email in the Reassign Role page '$value'")
    public void fillEmailId(String email) {
        userSteps.fillEmailId(email);}

    @Then("click the Reassign button and verify the error messages")
    public void clickReassignButtonForValidation(){
        System.out.println("Reassign button and verify the error messages" );
        userSteps.clickReassignButtonForValidation();}

        @Then("click on Reassign button in the Reassign Role page")
        public void clickReassignButton(){
        userSteps.clickReassignButton();
    }

    //sp34
    @Then("navigate Back to Login page")
    public void clickBacktoLogin(){
        userSteps.clickBacktoLogin();
    }

    //sp34
    @Then("navigate Back to Login page for User Profile")
    public void clickBacktoLogin1(){
        userSteps.clickBacktoLogin1();
    }

    //sp35
    @Then("navigate Back to Login page after set the password")
    public void clickBacktoLogin2(){
        userSteps.clickBacktoLogin2();
    }

    //sp37

    @When("fill provider email '$userEmail' firstname '$firstName' and lastname '$lastName'")
    public void fillProviderDetails(String userEmail,String firstName,String lastName) {
        userSteps.fillProviderDetails(userEmail,firstName,lastName);
    }

    //sp37
    @When("click on continue button from the provider")
    public void clickOnContinueButton() {
        userSteps.clickOnContinueButton();
    }

    //Demo
    @When("select additional Taxonomy '$additionalTaxonomy' from the user list")
    public void selectAdditionalTaxonomy(String additionalTaxonomy){
        userSteps.selectAdditionalTaxonomy(additionalTaxonomy);
    }
    @When("select language '$language' from the user list")
    public void selectLanguage(String language){
        userSteps.selectLanguage(language);
    }

    //sp54 new ui  gmail link

    @Then("click on new user link from the gmail")
    public  void clickOnNewUserLinkFromGmail(){
        userSteps.clickOnNewUserLinkFromGmail();}

        //sp57
    @When("select provider reason '$reason' and '$note' Provider under screening")
    public void setReasonForProviderReactivation1(String reason,String note) {
        userSteps.setReasonForProviderTerminationOrReactivatation(reason,note); }
    @When("select provider reason '$reason' and '$note' to approve termination of the provider")
    public void setReasonForProviderTermination(String reason, String note){
        userSteps.setReasonForProviderTermination(reason, note);
    }

   @When("click on apply button in under screening page")
    public void clickOnApplyButton(){
        userSteps.clickOnApplyButton();
    }

    @When("click on user link in gmail page")
    public void clickOnLinkInGmail(){
        userSteps.clickOnLinkInGmail();
    }

    //SD 07

    @When("click $button on '$tooltip'")
    public void clickTooltip(String button, String tooltip) {
        userSteps.clickTooltip(button,tooltip);
    }

    @When("fill provider firstname '$firstName' and lastname '$lastName'")
    public void fillProviderDetails1(String firstName,String lastName) {
        userSteps.fillProviderDetails1(firstName,lastName);
    }

    @When("set death date '$date' in Provider Termination popup")
    public void setDeathDate(String deathDate){
        userSteps.setDeathDate(deathDate);
    }

    @When("verify death date message '$message' in Provider Termination popup")
    public void isDeathDateMessagePresent(String message){
        assertTrue(message + " - message not presents!", userSteps.isDeathDateMessagePresent(message));
    }

    @When("verify '$button' button disabled in Provider Termination popup")
    public void verifyDeathDateMandatory(String button){
        System.out.println("Is enabled: " + userSteps.isButtonEnabled(button));
        assertFalse(button + " - button is enabled!", userSteps.isButtonEnabled(button));
    }

    @When("select timezone '$timeZone' from the user list")
    public void selectTimeZone(String timeZone) {
        userSteps.selectTimeZone(timeZone);
    }

    @When("select languages '$languages' from the user list")
    public void selectLanguages(String languages) {
        userSteps.selectLanguages(languages);
    }

    @When("fill display name '$displayName' from the user list")
    public void fillDisplayName(String displayName) {
        userSteps.fillDisplayName(displayName);
    }

    @When("fill company '$company' from the user list")
    public void fillCompany(String company) {
        userSteps.fillCompany(company);
    }

    @When("fill job title '$jobTitle' from the user list")
    public void fillJobTitle(String jobTitle) {
        userSteps.fillJobTitle(jobTitle);
    }

    @When("fill department '$department' from the user list")
    public void fillDepartment(String department) {
        userSteps.fillDepartment(department);
    }

    @When("fill location '$location' from the user list")
    public void fillLocation(String location) {
        userSteps.fillLocation(location);
    }

    @When("fill mobile '$mobile' from the user list")
    public void fillMobile(String mobile) {
        userSteps.fillMobile(mobile);
    }

    @When("fill fax '$fax' from the user list")
    public void fillFax(String fax) {
        userSteps.fillFax(fax);
    }

    @When("fill phone '$phone' from the user list")
    public void fillPhone(String phone) {
        userSteps.fillPhone(phone);
    }
    @When("fill ext '$ext' from the user list")
    public void fillExt(String ext) {
        userSteps.fillExt(ext);
    }

    @Then("save ProviderID")
    public void getProviderID(){
        String ProviderID=userSteps.getProviderID();
        ProviderProperties.save("ProviderID", ProviderID);
    }

    @Then("save the providerID from COC tab")
    public void getProviderId(){
        String ProviderID=userSteps.getProviderId();
        ProviderProperties.save("ProviderID", ProviderID);

    }


}




