package com.hhstechgroup.ui.panels.chat;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChatFrame extends AbstractPanel {

    private static final String TITLE = ".//div[@class = 'title']";
    private static final String MESSAGE_AREA = ".//textarea[@class = 'input-message']";
    private static final String SEND_MESSAGE_BUTTON = ".//div[@class = 'buttons']";
    private static final String SENT_MESSAGES_FROM = ".//ul//li//span[@class='user']";
    private static final String SENT_MESSAGES_BODY = ".//ul//li//div[@class='body']";
    private static final String NAME_INPUT = ".//input[@id = 'guestName']";
    private static final String EMAIL_INPUT = ".//input[@id = 'guestEmail']";
    private static final String START_CHAT_BUTTON = ".//button[@id = 'btnEntrar']";


    public ChatFrame(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void typeMessage(String message) {
        if (!isElementPresent(MESSAGE_AREA)) {
            findBy(NAME_INPUT).type("John Doe");
            findBy(EMAIL_INPUT).type(Serenity.sessionVariableCalled("provider") + "wy.providers@gmail.com");
            findBy(START_CHAT_BUTTON).click();
        }
        findBy(MESSAGE_AREA).type(message);
    }

    public void clickSendMessage() {
        findBy(SEND_MESSAGE_BUTTON).click();
    }

    public String getSentMessageAuthor() {
        waitABit(500);
        waitForPresenceOf(SENT_MESSAGES_FROM);
        return findBy(SENT_MESSAGES_FROM).getText();
    }

    public String getSentMessageBody() {
        return findBy(SENT_MESSAGES_BODY).getText();
    }

    public String checkChatActive() {
        findBy(TITLE).click();
        return findBy(TITLE).getCssValue("background-color");
    }

    public void closeChat() {
        findBy(TITLE).click();
        getDriver().switchTo().defaultContent();
    }
}
