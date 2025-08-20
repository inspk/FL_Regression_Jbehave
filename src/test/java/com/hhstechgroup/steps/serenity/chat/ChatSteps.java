package com.hhstechgroup.steps.serenity.chat;

import com.hhstechgroup.ui.pages.chat.RocketChatPage;
import com.hhstechgroup.ui.pages.peportal.DashboardPage;
import com.hhstechgroup.ui.panels.chat.ChatFrame;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ChatSteps extends ScenarioSteps {

    private static final String ACTIVE_CHAT_COLOR = "rgba(76, 175, 80, 1)";

    RocketChatPage rocketChatPage;
    DashboardPage dashboardPage;
    ChatFrame chat = null;

    @Step
    public void logInToRocketChat() {
        rocketChatPage.logInToRocketChat();
    }

    @Step
    public boolean isMessageFromUserReceived(String user) {
        return rocketChatPage.isUserPresent(user);
    }

    @Step
    public String getMessageFromUserReceived(String user) {
        return rocketChatPage.getMessageFromUser(user);
    }

    private ChatFrame accessChat() {
        if (chat == null) {
            chat = dashboardPage.getChat();
        }
        return chat;
    }

    @Step
    public boolean isChatActive() {
        return accessChat().checkChatActive().equals(ACTIVE_CHAT_COLOR);
    }

    @Step
    public void sendMessage(String message) {
        accessChat().typeMessage(message);
        accessChat().clickSendMessage();
    }

    @Step
    public String getSentMessageAuthor() {
        return accessChat().getSentMessageAuthor();
    }

    @Step
    public String getSentMessageBody() {
        return accessChat().getSentMessageBody();
    }

    @Step
    public void closeChat() {
        accessChat().closeChat();
    }

    @Step
    public void closeRocketChat() {
        rocketChatPage.closeChat();
    }
}
