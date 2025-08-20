package com.hhstechgroup.steps.jbehave.scenarios.chat;

import com.hhstechgroup.steps.serenity.chat.MessageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class MessageScenario {

    @Steps
    MessageSteps messageSteps;


    @When("click on Message Icon in internal user header tab")
    public void clickOnMessageBox() {
        messageSteps.clickOnMessageBox();
    }


    @When("click on New message")
    public void clickOnNewMessage() {
        messageSteps.clickOnNewMessage();
    }


    @When("enter the provider email $email")
    public void enterEmail(String email) {
       messageSteps.enterEmail(email);
    }

    @When("select the provider Request Id")
    public void selectRequestId() {
        messageSteps.selectRequestId();
    }

    @When("fill the Subject of the Message")
    public void enterSubject() {
        messageSteps.enterSubject();
    }

    @When("Verify Provider name and NPI is displaying")
    public void verifyProviderNameAndNPI() {
        messageSteps.verifyProviderNameAndNPI();
    }

    @Then("click on Send message")
    public void sendMessage() {
        messageSteps.sendMessage();
    }

}
