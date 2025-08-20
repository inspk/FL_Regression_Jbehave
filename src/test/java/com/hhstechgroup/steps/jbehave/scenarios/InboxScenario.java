package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.inbox.InboxSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InboxScenario {

    @Steps
    InboxSteps inboxSteps;

    @When("click on New Message button")
    public void clickNewMessage() {
        inboxSteps.clickNewMessage();
    }

    @When("set To - '$to' on message modal")
    public void setTo(String to) {
        inboxSteps.setTo(to);
    }

    @When("set subject - '$subject' on message modal")
    public void setSubject(String subject) {
        inboxSteps.setSubject(subject);
    }

    @When("set message body - '$body' on message modal")
    public void setBody(String body) {
        inboxSteps.setBody(body);
    }

    @When("upload file '$path' on message modal")
    public void uploadDocument(String path) {
        inboxSteps.uploadFile(path);
    }

    @When("delete file '$fileName' on message modal")
    public void deleteDocument(String fileName) {
        inboxSteps.deleteFile(fileName);
    }

    @Then("file '$fileName' should be uploaded on message modal")
    public void checkDocumentUploaded(String fileName) {
        assertTrue(inboxSteps.isFileUploaded(fileName));
    }

    @Then("error '$error' should be displayed on message modal")
    public void checkErrorDisplayed(String error) {
        assertTrue("Error isn't displayed", inboxSteps.isErrorPresent());
        assertEquals("Incorrect error", error, inboxSteps.checkError());
    }

    @When("send message")
    public void sendMessage() {
        inboxSteps.clickSendMessage();
    }

    @When("close write message modal")
    public void closeWriteMessageModal() {
        inboxSteps.closeWriteMessageModal();
    }

    @When("navigate to $tab tab on Message box")
    public void openTab(String tab) {
        inboxSteps.openTab(tab);
    }

    @When("select '$option' option for message")
    public void selectOption(String option) {
        inboxSteps.selectOptionOnMessage(option);
    }

    @When("reply for message")
    public void replyForMessage() {
        inboxSteps.clickReplyMessage();
    }

    @When("click link to sign in notification email")
    public void clickLinkToSignInEmail() {
        inboxSteps.clickLinkSignInEmail();
    }

    @Then("message { |about changed status} {from|to|from_to} - '$from_to' and title - '$title' and body '$body' should be present")
    public void checkMessage(String from_to, String title, String body) {
        String formattedBody = formatBody(body);
        assertTrue(String.format("Message with title %s isn't received", title), inboxSteps.isMessageWithTitlePresent(title));
        assertEquals("Wrong inbox From or To field!", from_to, inboxSteps.getLatestMessageFrom(title));
        assertEquals("Wrong inbox Body field!", formattedBody, inboxSteps.getLatestMessageBody(title));
    }

    @Then("user should receive notification from - '$from', title - '$title' and body '$body' with file attached")
    public void checkLatestNotificationWithAttachment(String from, String title, String body) {
        checkLatestNotification(from, title, body);
        assertTrue("Attachment is missing", inboxSteps.isAttachmentPreset());
    }

    @Then("user should receive notification from - '$from' and title - '$title' and body '$body'")
    public void checkLatestNotification(String from, String title, String body) {
        String formattedBody = formatBody(body);
        assertTrue(String.format("Notification with title %s isn't received", title), inboxSteps.isMessageWithTitlePresent(title));
        assertEquals("Wrong notification From field!", from, inboxSteps.getLatestMessageFrom(title));
        assertEquals("Wrong notification Body field!", formattedBody, inboxSteps.getLatestNotificationBody(title));
    }

    @Then("verify message has file '$fileName' attached")
    public void checkAttachmentInMessage(String fileName) {
        assertTrue("Attachment is missing", inboxSteps.isFileNamePreset(fileName));
    }

    private String formatBody(String body) {
        return body.replaceAll("\\\\n", "\n");
    }

    //new
    @When("open message in the '$messageTitle' message center")
    public void openMessageInbox(String messageTitle) {
        inboxSteps.openMessageInbox(messageTitle);
    }

    @When("open message in the '$messageTitle' message center for Provider Portal")
    public void openMessageInbox1(String messageTitle) {
        inboxSteps.openMessageInbox1(messageTitle);
    }

    //sp24
    @When("open message in the '$messageTitle' Licencure exipration for Provider Portal")
    public void openMessageEnrollmentSuspened(String messageTitle) {
        System.out.println("Display the Enrollment Status is Suspended");
        inboxSteps.openMessageEnrollmentSuspened(messageTitle);
    }

    @Then("select the action menu '$option' message center")
    public void clickActionMenuOption(String option) {
        inboxSteps.clickActionMenuOption(option);
    }

    //sp37
    @When("open message '$messageTitle' message center")
    public void openMessageChangeEnrollmentType(String messageTitle) {
        inboxSteps.openMessageChangeEnrollmentType(messageTitle);
    }

    @Then("verify the '$message' is displaying in the message center")
    public void isMessagePresent(String verifymessage) {
        assertTrue(inboxSteps.isMessagePresent(verifymessage));
    }

    //SD-05

    @Then("verify the '$expDate' is displaying in the message")
    public void isExpiryDatePresent(String expDate) {
        assertTrue(inboxSteps.isExpiryDatePresent(expDate));
    }
}


