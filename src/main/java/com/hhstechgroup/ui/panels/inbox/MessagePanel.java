package com.hhstechgroup.ui.panels.inbox;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.apache.commons.lang3.StringUtils.substringAfter;

public class MessagePanel extends AbstractPanel {

    private static final String FROM = ".//div[contains(@class, 'message-center_row')]/div[2]";
    private static final String TITLE = ".//div[contains(@class, 'message-center_row')]/div[4]";
    private static final String MESSAGE_BODY = ".//div[contains(@class, 'letter-inside-body')]";
    private static final String NOTIFICATION_BODY = ".//div[contains(@class, 'message-center_letter-body')]//div[not(@class)]";
    private static final String RECEIVED_TIME = ".//div[contains(@class, 'message-center_row')]/div[5]";
    private static final String ATTACHMENT_LINK = ".//div[contains(@class, 'message-center')]//a";
    private static final String ATTACHMENT = ".//div[contains(@class, 'message-center_attachments')]/a/span[contains(text(), '%s')]";
    private static final String MORE_BUTTON = ".//following-sibling::div//button[@aria-label = 'More']";
    private static final String REPLY_BUTTON = ".//following-sibling::div//button[@aria-label = 'Reply']";
    private static final String SIGN_LINK_IN_EMAIL = ".//a[@title= 'Link to Sign']";
    private static final String FIRST_MESSAGE_IN_INBOX="(//div[contains(@class, 'letter-buttons')]//button[@aria-label='More'])[1]";
    private static final String SELECT_VIEW_OPTION="(//li[@role='menuitem'])[1]";

    private static final String LINK_TO_SIGN="(//div[contains(@class,'message')]/following::a)[1]";

    public MessagePanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public String getFromTo() {
        return findBy(FROM).getText();
    }

    public String getTitle() {
        return findBy(TITLE).getText();
    }

    private String getBody(String bodyLocator) {
        scrollToElement(TITLE);
        findBy(TITLE).click();
        waitABit(300);
        return findBy(bodyLocator).getText();
    }

    public String getMessageBody() {
        return getBody(MESSAGE_BODY);
    }

    public String getNotificationBody() {
        return getBody(NOTIFICATION_BODY);
    }

    public String getReceivedTime() {
        return substringAfter(findBy(RECEIVED_TIME).getText(), "at ");
    }

    public boolean isLinkPresent() {
        return isElementPresent(ATTACHMENT_LINK);
    }

    public boolean isAttachmentPresent(String fileName) {
        return isElementPresent(String.format(ATTACHMENT, fileName));
    }

    public void selectOption(String option) {
        waitABit(2000);    //latest
        findBy(MORE_BUTTON).click();
        action().moveToElement(getBasePage().findBy(String.format(DROP_DOWN_OPTION, option))).click().build().perform();
        waitABit(2000);     //latest
    }

    public void clickReply() {
        findBy(REPLY_BUTTON).click();
    }
    public void clickSignLinkInEmail() {
        findBy(SIGN_LINK_IN_EMAIL).click();
    }


    public void clickOnConfirmAffiliation() {
            waitABit(500);
            jsClick(FIRST_MESSAGE_IN_INBOX);
            waitABit(500);
           jsClick(SELECT_VIEW_OPTION);
            waitABit(500);
            jsClick(LINK_TO_SIGN);
            waitABit(500);

    }
}
