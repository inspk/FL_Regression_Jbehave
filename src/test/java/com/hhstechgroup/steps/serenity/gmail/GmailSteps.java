package com.hhstechgroup.steps.serenity.gmail;


import com.hhstechgroup.ui.pages.gmail.GmailPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class GmailSteps extends ScenarioSteps{

    GmailPage gmailPage;

    @Step
    public void loginToGmail(){
        gmailPage.openPage();
        gmailPage.typeEmail();
        gmailPage.clickEmailNext();
        gmailPage.typePassword();
        gmailPage.clickPasswordNext();
    }

    //latest
    @Step
    public void loginToSupervisorGmail(){
        gmailPage.openPage();
        gmailPage.typeSupervisorEmail();
        gmailPage.clickEmailNext();
        gmailPage.typeSupervisorPassword();
        gmailPage.clickPasswordNext();
    }

    @Step
    public void openGmail() {
        gmailPage.openPage();
    }

    @Step
    public void navigateToInbox(){
        gmailPage.selectGmail();
    }

    @Step
    public boolean isEmailContentCorrect(String text, String linkText, String relativeURI){
        return isEmailContentCorrect(text) && gmailPage.isLinkTextCorrect(linkText) && gmailPage.isLinkCorrect(relativeURI);
    }

    @Step
    public boolean isEmailContentCorrect(String text, String button){
        return isEmailContentCorrect(text) && gmailPage.isButtonTextCorrect(button) ;
    }

    @Step
    public boolean isEmailContentCorrect(String text){
        return gmailPage.isEmailTextCorrect(text);
    }

    @Step
    public void clickOnEmailLink(){
        gmailPage.clickOnEmailLink();
    }

    @Step
    public boolean isNewEmailPresent(String emailTitle){
         return gmailPage.isNewEmailPresent(emailTitle);
    }

    @Step
    public void openNewEmail(String emailTitle){
        gmailPage.openNewEmail(emailTitle);
    }

    @Step
    public void openEmail(String emailTitle){
        gmailPage.openEmail(emailTitle);
    }

    @Step
    public String getReceiverEmail(){
        return gmailPage.getReceiverEmail();
    }

    @Step
    public void searchForMessage(String criteria) {
        gmailPage.searchForMessage(criteria);
    }

    @Step
    public void openCloseEmailDetais() {
        gmailPage.openCloseEmailDetais();
    }

    @Step
    public void returnToInbox() {
        gmailPage.returnToInbox();
    }
    //sp21
    @Step
    public void openNewEmail1(String emailTitle){
        gmailPage.openNewEmail1(emailTitle);
    }
    //sp23
    @Step
    public void loginToUserGmail(){
        gmailPage.openPage();
        gmailPage.typeEmailUserName();
        gmailPage.clickEmailNext();
        gmailPage.typeUserPassword();
        gmailPage.clickPasswordNext();
    }
    @Step
    public void selectDeleteCheckboxInGmail(){ gmailPage.selectDeleteCheckboxInGmail();}
    //sp24
    @Step
    public void openCollemail(String emailTitle){
        gmailPage.openCollemail(emailTitle);
    }

    //sp37 directly open the gmail
    @Step
    public void loginToUserGmail1() {
        gmailPage.openPage();
    }

    //sp 59 random npi from the list
    @Step
    public void getTest(String file){gmailPage.getNpiFromList(file);}
    }