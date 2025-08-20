package com.hhstechgroup.steps.jbehave.scenarios.chat;

import com.hhstechgroup.steps.serenity.chat.ChatSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChatScenario {

    @Steps
    ChatSteps chatSteps;

    @When("activate rocket chat")
    public void activateChat() {
        chatSteps.logInToRocketChat();
        chatSteps.closeRocketChat();
    }

    @When("user send message '$message' in chat")
    public void sendMessageInChae(String message) {
        chatSteps.sendMessage(message);
    }

    @When("collapse chat")
    public void collapseChat() {
        chatSteps.closeChat();
    }

    @When("navigate to Rocket Chat")
    public void navigateToRocketChat() {
        chatSteps.logInToRocketChat();
    }

    @Then("chat should be active")
    public void isChatActive() {
        assertTrue(chatSteps.isChatActive());
    }

    @Then("specialist should receive message $message from user $user")
    public void checkMessageFromUser(String message, String user) {
        assertTrue("Specialist didn't receive message from user", chatSteps.isMessageFromUserReceived(user));
        assertEquals("Specialist received wrong message", message, chatSteps.getMessageFromUserReceived(user));
        chatSteps.closeRocketChat();
    }

    @Then("message '$message' from '$from' should be sent")
    public void isMessageSent(String message, String from) {
        assertEquals(from, chatSteps.getSentMessageAuthor());
        assertTrue("Wrong message body is displayed", chatSteps.getSentMessageBody().startsWith(message));
    }
}
