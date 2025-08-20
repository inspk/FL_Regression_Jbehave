package com.hhstechgroup.steps.serenity.inbox;

import com.hhstechgroup.ui.pages.inbox.InboxPage;
import com.hhstechgroup.ui.panels.inbox.MessagePanel;

import com.hhstechgroup.util.common.FileUtils;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static com.hhstechgroup.util.converters.DateConverter.SUBMIT_TIME;

public class InboxSteps extends ScenarioSteps {

    InboxPage inboxPage;

    @Step
    public String getLatestMessageFrom(String title) {
        MessagePanel panel = inboxPage.getMessagesAfter(Serenity.sessionVariableCalled(SUBMIT_TIME)).stream().filter(message -> message.getTitle().equals(title)).findFirst().get();
        return panel.getFromTo();
    }

    @Step
    public boolean isMessageWithTitlePresent(String title) {
        return inboxPage.getMessagesAfter(Serenity.sessionVariableCalled(SUBMIT_TIME)).stream().filter(message -> message.getTitle().equals(title)).count() == 1;
    }

    @Step
    public String getLatestMessageBody(String title) {
        MessagePanel panel = inboxPage.getMessagesAfter(Serenity.sessionVariableCalled(SUBMIT_TIME)).stream().filter(message -> message.getTitle().equals(title)).findFirst().get();
        return panel.getMessageBody();
    }

    @Step
    public String getLatestNotificationBody(String title) {
        MessagePanel panel = inboxPage.getMessagesAfter(Serenity.sessionVariableCalled(SUBMIT_TIME)).stream().filter(message -> message.getTitle().equals(title)).findFirst().get();
        return panel.getNotificationBody();
    }

    @Step
    public boolean isAttachmentPreset() {
        MessagePanel panel = inboxPage.getMessagesAfter(Serenity.sessionVariableCalled(SUBMIT_TIME)).get(0);
        return panel.isLinkPresent();
    }

    @Step
    public boolean isFileNamePreset(String fileName) {
        MessagePanel panel = inboxPage.getMessagesAfter(Serenity.sessionVariableCalled(SUBMIT_TIME)).get(0);
        return panel.isAttachmentPresent(fileName);
    }

    @Step
    public void clickNewMessage() {
        inboxPage.clickNewMessage();
    }

    @Step
    public void setTo(String to) {
        inboxPage.getWriteMessagePanel().setTo(to);
    }

    @Step
    public void setSubject(String subject) {
        inboxPage.getWriteMessagePanel().setSubject(subject);
    }

    @Step
    public void setBody(String body) {
        inboxPage.getWriteMessagePanel().setMessageBody(body);
    }

    @Step
    public void uploadFile(String path){
        inboxPage.getWriteMessagePanel().uploadDocument(FileUtils.getAbsolutePath(path));
    }

    @Step
    public void deleteFile(String fileName){
        inboxPage.getWriteMessagePanel().deleteDocument(fileName);
    }

    @Step
    public boolean isFileUploaded(String fileName){
        return inboxPage.getWriteMessagePanel().isDocumentUploaded(fileName);
    }

    @Step
    public boolean isErrorPresent(){
        return inboxPage.getWriteMessagePanel().isErrorDisplayed();
    }

    @Step
    public String checkError(){
        return inboxPage.getWriteMessagePanel().checkError();
    }

    @Step
    public void clickSendMessage() {
        inboxPage.getWriteMessagePanel().clickSendButton();
    }

    @Step
    public void closeWriteMessageModal() {
        inboxPage.getWriteMessagePanel().clickCloseButton();
    }

    @Step
    public void openTab(String tab) {
        inboxPage.clickOnTab(tab);
    }

    @Step
    public void selectOptionOnMessage(String option) {
        inboxPage.getMessagesAfter(Serenity.sessionVariableCalled(SUBMIT_TIME)).get(0).selectOption(option);
    }

    @Step
    public void clickReplyMessage() {
        inboxPage.getMessagesAfter(Serenity.sessionVariableCalled(SUBMIT_TIME)).get(0).clickReply();
    }
    @Step
    public void clickLinkSignInEmail() {
        inboxPage.getMessagesAfter(Serenity.sessionVariableCalled(SUBMIT_TIME)).get(0).clickSignLinkInEmail();
    }
    //new
    @Step
    public void openMessageInbox(String messageTitle){
        inboxPage.openMessageInbox(messageTitle);
    }
    @Step
    public void openMessageInbox1(String messageTitle){
        inboxPage.openMessageInbox1(messageTitle);
    }
    //sp24
    @Step
    public void openMessageEnrollmentSuspened(String messageTitle) {
        inboxPage.openMessageEnrollmentSuspened(messageTitle);
    }
    @Step
    public void clickActionMenuOption(String option) {
        inboxPage.clickActionMenuOption(option);
    }
    //sp37
    @Step
    public void openMessageChangeEnrollmentType(String messageTitle) {
        inboxPage.openMessageChangeEnrollmentType(messageTitle);
    }
    @Step
    public boolean isMessagePresent(String verifymessage){
        return inboxPage.isMessagePresent(verifymessage);
    }

    //SD-05

    @Step
    public boolean isExpiryDatePresent(String expDate){
        return inboxPage.isExpiryDatePresent(expDate);
    }
}
