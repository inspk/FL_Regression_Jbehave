package com.hhstechgroup.steps.jbehave.scenarios.gmail;


import com.hhstechgroup.steps.serenity.gmail.GmailSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GmailScenario {

    @Steps
    GmailSteps gmailSteps;

    @When("login to gmail")
    public void loginToGmail(){
        gmailSteps.loginToGmail();
    }

    @When("login to Internal User gmail")
    public void loginToSupervisorGmail(){
        gmailSteps.loginToSupervisorGmail();
    }
    @When("navigate to gmail")
    public void openGmail(){
        gmailSteps.openGmail();
    }

    @When("navigate to inbox")
    public void navigateToInbox(){
        gmailSteps.navigateToInbox();
    }

    @Then("email with text '$text', link text '$linkText' and link '$relativeUri' is visible")
    public void verifyEmailContent(String text, String linkText, String relativeUri){
        String textFormatted = text.replaceAll("\\\\n", "\n");
        assertTrue("Email content is incorrect", gmailSteps.isEmailContentCorrect(textFormatted, linkText, relativeUri));
    }

    @Then("email with text '$text' and button '$buttonText' is visible")
    public void verifyEmailContent(String text, String buttonName){
        assertTrue("Email content is incorrect", gmailSteps.isEmailContentCorrect(text, buttonName));
    }

    @Then("email with text '$text' is displayed")
    public void verifyEmailContent(String text){
        assertTrue("Email content is incorrect", gmailSteps.isEmailContentCorrect(text));
    }

    @When("click on email link")
    public void clickOnEmailLink(){
        gmailSteps.clickOnEmailLink();
    }

    @When("search for message by email - $email")
    public void searchForEmail(String criteria) {
        gmailSteps.searchForMessage(criteria);
    }

    @When("open new '$emailTitle' email")
    public void openNewEmail(String emailTitle) {
        gmailSteps.openNewEmail(emailTitle);
    }


    @When("open '$emailTitle' email")
    public void openEmail(String emailTitle) {
        gmailSteps.openEmail(emailTitle);
    }

    @Then("verify new '$emailTitle' email is present")
    public void verifyNewEmailPresent(String emailTitle) {
        assertTrue("New Application status change email is not present", gmailSteps.isNewEmailPresent(emailTitle));
    }

    @When("move to Inbox")
    public void moveToInbox() {
        gmailSteps.returnToInbox();
    }

    @Then("verify receiver email is '$email'")
    public void verifyEmailReceiver(String email) {
        gmailSteps.openCloseEmailDetais();
        assertEquals("Email receiver is incorrect",email.toLowerCase(), gmailSteps.getReceiverEmail());
        gmailSteps.openCloseEmailDetais();
    }
    //sp21
    @When("open new '$emailTitle' email to the Deaction and Activation user")
    public void openNewEmail1(String emailTitle) {
        gmailSteps.openNewEmail1(emailTitle);
    }

    //sp26
    @When("open new '$emailTitle' email to the Reassign Provider")
    public void openNewEmail2(String emailTitle) {
        gmailSteps.openNewEmail1(emailTitle);
    }

    //sp23
    @When("login to user gmail")
    public void loginToUserGmail(){
        gmailSteps.loginToUserGmail();
    }

    @When("Delete all existing Gmails")
    public void selectDeleteCheckboxInGmail(){gmailSteps.selectDeleteCheckboxInGmail();}

    //sp24
    @When("open new '$emailTitle' collaborator user email")
    public void openCollemail(String emailTitle) {
        gmailSteps.openCollemail(emailTitle);
    }

    //sp33
    @When("open new '$emailTitle' email for denied notification message")
    public void openNewEmail5(String emailTitle) {
        gmailSteps.openNewEmail1(emailTitle);
    }
   //sp37
   @When("open new '$emailTitle' email for change enrollment type message")
   public void openNewchangeenrollment(String emailTitle) {
       gmailSteps.openNewEmail1(emailTitle);
   }

    //sp37 directly open the gmail
    @When("login to user gmail directly")
    public void loginToUserGmail1(){
        gmailSteps.loginToUserGmail1();
    }

}