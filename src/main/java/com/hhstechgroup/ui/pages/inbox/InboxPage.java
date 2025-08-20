package com.hhstechgroup.ui.pages.inbox;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.inbox.MessagePanel;
import com.hhstechgroup.ui.panels.inbox.WriteMessagePanel;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.Serenity;
import org.joda.time.LocalTime;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;


public class InboxPage extends ProviderManagementBasePage {

    private static final String MESSAGE_PANELS = ".//ul[contains(@class, 'messages-table')]//li";
    private static final String NEW_MESSAGE_BUTTON = ".//button[span[text() = 'NEW MESSAGE']]";
    //latest
    // private static final String NEW_MESSAGE_BUTTON  = ".//button[span[text() = '+ ADD MESSAGE']]";
    private static final String WRITE_MESSAGE_PANEL = ".//div[contains(@class, 'message-center_title')]/parent::div";
    private static final String TAB = ".//div[contains(@class, 'tabs')]//span[text() = '%s']";
    private static final String SELECTED_TAB = ".//div[contains(@class, 'tabs')]//span[text() = '%s']/ancestor::button[@aria-selected='true']";

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public List<MessagePanel> getAllMessages() {
        return findAll(MESSAGE_PANELS).stream().map(e -> new MessagePanel(e, this)).collect(Collectors.toList());
    }

    public List<MessagePanel> getMessagesAfter(String time) {
        waitAbit(2000);
        waitForSpinnerToDisappear();
        LocalTime timeAfter = LocalTime.parse(time);
        return getAllMessages().stream().filter(message -> {
            LocalTime receivedTime = LocalTime.parse(DateConverter.to24HFormat(message.getReceivedTime()));
            return receivedTime.isEqual(timeAfter) || receivedTime.isAfter(timeAfter);
        }).collect(Collectors.toList());
    }

    public void clickNewMessage() {
        waitForSpinnerToDisappear();
        waitForPresenceOf(NEW_MESSAGE_BUTTON);
        findBy(NEW_MESSAGE_BUTTON).click();
    }

    public WriteMessagePanel getWriteMessagePanel() {
        return new WriteMessagePanel(findBy(WRITE_MESSAGE_PANEL), this);
    }

    public void clickOnTab(String tab) {
        findBy(format(TAB, tab)).click();
        waitForPresenceOf(format(SELECTED_TAB, tab));
        waitForPresenceOf(MESSAGE_PANELS);
        waitAbit(1000);//added wait step to avoid case when data is checked before loading page data
    }

    //new
    private static final String AFFILIATION_TITLE = ".//div[contains(text(),'%s')]";
    private static final String AFFILIATION__SIGN_LINK = ".//p/a[contains(text(),'Link to Sign')]";

    public void openMessageInbox(String messageTitle) {
        waitAbit(5000);
        jsClick(format(AFFILIATION_TITLE, messageTitle));
        findBy(AFFILIATION__SIGN_LINK).waitUntilClickable().click();
    }

    private static final String MESSAGE_TITLE = ".//div[contains(text(),'%s')]";
    private static final String MESSAGE_LINK = ".//div[@class='message-center_inner_1MnzK']/div[contains(text(),'Some of your data was overridden')]";
    public void openMessageInbox1(String messageTitle) {
        waitAbit(5000);
        jsClick(format(MESSAGE_TITLE, messageTitle));
        waitAbit(100);
        findBy(MESSAGE_LINK).waitUntilClickable().click();
        waitAbit(300);
    }
    //sp24
    public void openMessageEnrollmentSuspened(String messageTitle) {
        waitAbit(5000);
        jsClick(format(MESSAGE_TITLE, messageTitle));
        waitAbit(200);
    }
    private static final String ACTION_MENU = ".//following-sibling::div//button[@aria-label = 'More']";
    private static final String OPTIONS = ".//ul[contains(@role,'menu')]/li[text()='%s']";
    public void clickActionMenuOption(String option) {
        waitAbit(1000);
        findBy(ACTION_MENU).click();
        findBy(format(OPTIONS, option)).click();
        waitAbit(500);
    }
    //sp37
    public void openMessageChangeEnrollmentType(String messageTitle) {
        waitAbit(5000);
        jsClick(format(MESSAGE_TITLE, messageTitle));
        waitAbit(200);
    }

    private static final String VERIFY_MESSAGE= ".//div[contains(@class,'public-DraftStyleDefault-block public-DraftStyleDefault-ltr')]//span";
    public boolean isMessagePresent(String verifymessage) {
        waitAbit(500);
        scrollToElement(format(VERIFY_MESSAGE,verifymessage));
        return isElementPresent(format(VERIFY_MESSAGE));
    }
    //SD-05

    private static final String VERIFY_FUTURE_APPROVE_DATE= ".//div[contains(@class,'message-center_md')]";
    public boolean isExpiryDatePresent(String expDate) {
        waitAbit(500);
        scrollToElement(VERIFY_FUTURE_APPROVE_DATE);
        return findBy(VERIFY_FUTURE_APPROVE_DATE).containsText(expDate);
    }
}
