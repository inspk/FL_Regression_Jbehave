package com.hhstechgroup.ui.panels.inbox;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import com.hhstechgroup.util.common.ExternalEmails;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;

import static com.hhstechgroup.util.converters.DateConverter.SUBMIT_TIME;

public class WriteMessagePanel extends BaseModalPanel {

    private static final String TO = ".//label[contains(text(), 'To')]/following-sibling::div//input";
    private static final String SUBJECT = ".//input[contains(@id, 'Subject')]";
    private static final String MESSAGE_BODY = ".//div[contains(@class, 'rich-text-input')]//div[@contenteditable='true']";
    private static final String SEND_BUTTON = ".//button[span[text() = 'Send']]";
    private static final String CLOSE_BUTTON = ".//button[@aria-label='Close']";
    private static final String UPLOAD_BUTTON = "//div[contains(@class, 'upload_upload-body')]//input";
    private static final String UPLOADED_DOCUMENT = ".//div[contains(@class, 'upload_upload-progress')]//div[text() = '%s']";
    private static final String UPLOAD_ERROR = "//div[contains(@class, 'utils_field-errors')]";
    private static final String DELETE_BUTTON = ".//div[contains(@class, 'upload_upload-progress')]//div[text() = '%s']/following-sibling::button[@aria-label='Remove Upload']";

    public WriteMessagePanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setTo(String to) {
        //One click need to be removed https://tasks.engagepoint.us/browse/PRMG-3423
        waitABit(200);
        findBy(TO).type(to);
        //findBy(TO).click();
      //  selectFromDropDown(to);
        waitABit(500);
    }

    public void setSubject(String subject) {
        waitABit(200);
        findBy(SUBJECT).type(subject);
        waitABit(500);
    }

    public void setMessageBody(String body)
    {
        waitABit(100);
        findBy(MESSAGE_BODY).type(body);
        waitABit(500);
    }

    public void uploadDocument(String path) {
        WebElement element = findBy(UPLOAD_BUTTON);
        getBasePage().upload(path).to(element);
    }

    public void deleteDocument(String documentName) {
        findBy(String.format(DELETE_BUTTON, documentName)).click();
    }

    public boolean isDocumentUploaded(String documentName) {
        return isElementPresent(String.format(UPLOADED_DOCUMENT, documentName));
    }

    public boolean isErrorDisplayed() {
        return isElementPresent(UPLOAD_ERROR);
    }

    public String checkError() {
        return findBy(UPLOAD_ERROR).getText();
    }

    public void clickSendButton() {
        findBy(SEND_BUTTON).click();
        waitABit(500);
        //waitForPopUpClosed();
        Serenity.setSessionVariable(SUBMIT_TIME).to(DateConverter.getSubmissionDate());
        Serenity.setSessionVariable(ExternalEmails.NEW_EMAIL.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

    public void clickCloseButton() {
        findBy(CLOSE_BUTTON).click();
        waitForPopUpClosed();
        Serenity.setSessionVariable(SUBMIT_TIME).to(DateConverter.getSubmissionDate());
    }
}

