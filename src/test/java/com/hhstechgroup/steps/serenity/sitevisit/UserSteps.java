package com.hhstechgroup.steps.serenity.sitevisit;

import com.hhstechgroup.ui.pages.gmail.GmailPage;
import com.hhstechgroup.ui.pages.sitevisit.UserPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;

public class UserSteps extends ScenarioSteps {
    @Page
    UserPage userPage;

    @Page
    GmailPage gmailPage;


    @Step
    public void setUserFirstName(String userFirstName) {userPage.newUserPopup();}

    @Step
    public void clickOnAddUser() {userPage.clickOnAddUser(); }

    @Step
    public boolean isAddNewUserPopupOpened() {
        return userPage.isAddNewUserPopupOpened();
    }

    @Step
    public void clickUserFirstName(){userPage.clickUserFirstName();}

    @Step
    public void clickUserLastName(){userPage.clickUserLastName();}

    @Step
    public void fillUserFirstName(String username) { userPage.fillUserFirstName(username);}
    @Step
    public String getUserFirstNameValue() { return userPage.getUserFirstNameValue(); }
    @Step
    public void fillUserLastName(String password) {userPage.fillUserLastName(password);}
    @Step
    public String getUserLastNameValue() {  return userPage.getUserLastNameValue(); }

    @Step
    public void fillUserEmailUserId(String useremail) {userPage.fillUserEmailUserId(useremail);}

    @Step
    public void clickAddbuttonFromUserPage(){userPage.clickAddbuttonFromUserPage();}

    @Step
    public void clickOnRoleField(){userPage.clickOnRoleField();}

    @Step
    public void selectAnyRolefromUser(){userPage.selectAnyRolefromUser();}

    @Step
    public void setUserEmailId(String emailId){userPage.setUserEmailId(emailId);}

    @Step
    public void setUserEmailPw(String emailpw){userPage.setUserEmailPw(emailpw);}

    @Step
    public void clickOnNextButton() {userPage.clickOnNextButton();}

    @Step
    public void setUserPassword(String setpassword){userPage.setUserPassword(setpassword);}

    @Step
    public void setUserConfirmPassword(String confirmpassword){userPage.setUserConfirmPassword(confirmpassword);}

    @Step
    public void clickOnSetPasswordButton(){userPage.clickOnSetPasswordButton();}

    @Step
    public void clickoOnDashboardButton() {userPage.clickoOnDashboardButton();}

    @Step
    public void selectParentMail(){
        userPage.selectParentMail();
        gmailPage.typePassword();
        gmailPage.clickPasswordNext();
    }

    @Step
    public void clickOnYesButton(){userPage.clickOnYesButton();}

    @Step
    public void clickOnGmailIcon(){userPage.clickOnGmailIcon();}

    @Step
    public void switchToGmailtab(){userPage.switchToGmailtab();}

    @Step
    public  void clickOnUserLinkFromGmail(){
        userPage.clickOnUserLinkFromGmail();}

    @Step
    public void switchTosetPasswordWindow(){userPage.switchTosetPasswordWindow();}

    @Step
    public void enterPasswordForUser(String userpassword) {userPage.enterPasswordForUser(userpassword);}

    @Step
    public void clickOnConfirmPasswordField(){userPage.clickOnConfirmPasswordField();}

    @Step
    public void enterConfirmedPassword(String userconfirmpassword) {userPage.enterConfirmedPassword(userconfirmpassword);}

    @Step
    public void clickOnSetPasswordFromUser() {userPage.clickOnSetPasswordFromUser();}

    @Step
    public void clickOnDashboard(){userPage.clickOnDashboard();}

    @Step
    public void selectUserRole() {userPage.selectUserRole();}

    @Step
    public void clickOnCancelButtonInAddUser(){userPage.clickOnCancelButtonInAddUser();}

    //latest
    @Step
    public void selectUser(String user) {userPage.selectUser(user);}

    @Step
    public void setUserName(String userName) {userPage.setUserName(userName);}

    @Step
    public void selectReasonToActiveAndDeactiveTheUser(String reasonForDeactivate,String note){
      userPage.selectReasonToActiveAndDeactiveTheUser(reasonForDeactivate,note);
    }

    @Step
    public void clickOnDeatils( ) {userPage.clickOnDeatils();}

    @Step
    public void scrollToDetailsField(){userPage.scrollToDetailsField();}

    @Step
    public void selectAnyRolefromUser1(String role){userPage.selectAnyRolefromUser1(role);}

    public void selectGroupForMCOAdminUser(String grouptype){userPage.selectGroupForMCOAdminUser(grouptype);}

    @Step
    public void editUserName(String userName,String field) {
      userPage.editUserName(userName,field);
    }

    @Step
    public void editTimeZone(String timeZone,String zone) {
        userPage.editTimeZone(timeZone,zone);
    }

    @Step
    public void editLaguageSpoken(String languageSpoken) {
        userPage.editLaguageSpoken(languageSpoken);
    }

    //sp21
    @Step
    public void selectReasonDeactiveAndActiveUser(String reasonForDeactivate,String note){
        userPage.selectReasonDeactiveAndActiveUser(reasonForDeactivate,note);
    }

    @Step
    public void clickOnDectivationAndReactivationButton(String button){
        userPage.clickOnDectivationAndReactivationButton(button);
    }

    @Step
    public boolean isPopupisplaying(String popup) {
      return   userPage.isPopupisplaying(popup);
    }

    @Step
    public void removeRoleFromUserDetails(String remove) {
        userPage.removeRoleFromUserDetails(remove);
    }

    @Step
    public void clickOnAddbuttonFromUserDetails(){
        userPage.clickOnAddbuttonFromUserDetails();
    }

    @Step
    public void selectAnyRoleFromUserDetaisPage(String role) {
        userPage.selectAnyRoleFromUserDetaisPage(role);
    }

    @Step
    public void selectActionFromProviderDetails(String action) {userPage.selectActionFromProviderDetails(action);}


    @Step
    public boolean isUserTerminationPopupOpened(){return userPage.isUserTerminationPopupOpened();}

    @Step
    public void setProviderReactivateDate(String reactiveDate) {userPage.fillProviderReactivateDate(reactiveDate);}

    @Step
    public void setProviderTerminateDate(String terminateDate) {userPage.fillProviderTerminateDate(terminateDate);}

    @Step
    public void clickOnTerminationAndReactivationButton(String button){userPage.clickOnTerminationAndReactivationButton(button);}

    // adding sp21

    @Step
    public void fillProviderSuspendedDate(String suspenedeDate) {userPage.fillProviderSuspendedDate(suspenedeDate);}

    @Step
    public void setReasonForProviderTerminationOrReactivatation(String reason,String note){userPage.setReason(reason,note);}
    @Step
    public void setReasonForProviderTermination(String reason, String note){
        userPage.setReasonForProviderTermination(reason, note);
    }

    @Step
    public boolean isTerminationOrReactivationdisplaying(String action){return userPage.isTerminationOrReactivationdisplaying(action);}
//
    @Step
    public boolean prividerTerminated(){return userPage.prividerTerminated();}
 //
    @Step
    public void backFromTerminatedProvider(){userPage.backFromTerminatedProvider();}

    @Step
    public void isTerminationOrReactivationNotdisplaying(String action){userPage.isTerminationOrReactivationNotdisplaying(action);}
    @Step
    public void clickOnActionMenu(){userPage.clickOnActionMenu();}

    @Step
    public void clickOnPermissionName(String name){userPage.clickOnPermissionName(name);}

    @Step
    public void selectTerminateCheckbox(){userPage.selectTerminateCheckbox();}

    @Step
    public void selectReactivateCheckbox(){userPage.selectReactivateCheckbox();}

    //sp23
    @Step
    public boolean isReassignRolePopupOpened() {
        return userPage.isReassignRolePopupOpened();
    }
    @Step
    public void fillEmailId(String email) {
        userPage.fillEmailId(email);}

    @Step
    public void clickReassignButtonForValidation(){
        userPage.clickReassignButtonForValidation();}

    @Step
    public void clickReassignButton(){
        userPage.clickReassignButton();}

    //sp34
    @Step
    public void clickBacktoLogin(){
        userPage.clickBacktoLogin();
    }

    //sp34
    @Step
    public void clickBacktoLogin1(){
        userPage.clickBacktoLogin1();
    }

    //sp35
    @Step
    public void clickBacktoLogin2(){
        userPage.clickBacktoLogin2();
    }

    //sp37
    @Step
    public void fillProviderDetails(String userEmail,String firstName,String lastName) {
        userPage.fillProviderDetails(userEmail,firstName,lastName);
    }

    //sp37
    @Step
    public void clickOnContinueButton() {
        userPage.clickOnContinueButton();
    }

    //Demo

    @Step
    public void selectAdditionalTaxonomy(String additionalTaxonomy){
        userPage.selectAdditionalTaxonomy(additionalTaxonomy);
    }
    @Step
    public void selectLanguage(String language){
        userPage.selectLanguage(language);
    }

    //sp54 new ui  gmail link

    @Step
    public  void clickOnNewUserLinkFromGmail(){
        userPage.clickOnNewUserLinkFromGmail();}

    //sp57
        @Step
        public void clickOnApplyButton(){
        userPage.clickOnApplyButton();
        }

        @Step
        public void clickOnLinkInGmail(){
        userPage.clickOnLinkInGmail();
        }

        //SD 07

    @Step
    public void fillProviderDetails1(String firstName,String lastName) {
        userPage.fillProviderDetails1(firstName,lastName);
    }

    @Step
    public void clickTooltip(String button, String tooltip) {
        userPage.clickTooltip(button,tooltip);
    }


    @Step
    public void setDeathDate(String deathDate){
        userPage.setDeathDate(deathDate);
    }

    @Step
    public boolean isDeathDateMessagePresent(String message){
        return userPage.isDeathDateMessagePresent(message);
    }

    @Step
    public boolean isButtonEnabled(String button){
        return userPage.isButtonEnabled(button);
    }

    @Step
    public void selectTimeZone(String timeZone) {
        userPage.setTimeZone(timeZone);
    }

    @Step
    public void selectLanguages(String languages) {
        userPage.setLanguages(languages);
    }

    @Step
    public void fillDisplayName(String displayName) {
        userPage.setDisplayName(displayName);
    }

    @Step
    public void fillCompany(String company) {
        userPage.setCompany(company);
    }

    @Step
    public void fillJobTitle(String jobtitle) {
        userPage.setJobTitle(jobtitle);
    }

    @Step
    public void fillDepartment(String department){
        userPage.setDepartment(department);
    }

    @Step
    public void fillLocation(String location) {
        userPage.setLocation(location);
    }

    @Step
    public void fillMobile(String mobile) {
        userPage.setMobile(mobile);
    }

    @Step
    public void fillFax(String fax) {
        userPage.setFax(fax);
    }

    @Step
    public void fillPhone(String phone) {
        userPage.setPhone(phone);
    }

    @Step
    public void fillExt(String ext) {
        userPage.setExt(ext);
    }
    @Step
    public String getProviderID(){
        return userPage.getProviderID();
    }

    @Step
    public String getProviderId(){
        return  userPage.getProviderId();
    }


}

