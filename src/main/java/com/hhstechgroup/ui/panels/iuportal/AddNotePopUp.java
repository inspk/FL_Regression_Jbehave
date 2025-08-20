package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class AddNotePopUp extends BaseModalPanel {

    private static final String NOTE_TEXT = ".//div[contains(@class, 'rich-text-input')]//div[@contenteditable='true']";
    private static final String SUGGESTIONS = ".//div[contains(@class, 'suggestions-list')]";
    private static final String TEMPLATE = ".//a[text() = '%s']";
    private static final String ADD_NOTE = ".//button[span[text() = 'Add Note']]";
    private static final String SAVE_CHANGES = ".//button[span[text() = 'Save Changes']]";


    public AddNotePopUp(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setNoteText(String text) {
        findBy(NOTE_TEXT).type(text);
        waitForAbsenceOf(SUGGESTIONS);
    }

    public void clickAddNote() {
        findBy(ADD_NOTE).click();
        waitForPopUpClosed();
        waitABit(5000);
    }

    public void clickSaveChanges() {
        findBy(SAVE_CHANGES).click();
        waitForPopUpClosed();
    }

    public void selectTemplate(String template) {
        findBy(SUGGESTIONS).findBy(format(TEMPLATE, template)).click();
    }

    public String getNoteText() {
        return findBy(NOTE_TEXT).getText();
    }

    private static final String SUBJECT = "//div/label[text()='Subject']/../div/input";
    public void setNoteSubject(String subject){
        findBy(SUBJECT).type(subject);
    }


    private final static String UPLOAD_BUTTON = ".//div[contains(@class, 'upload_upload-controls_')]//input";
    public void uploadAttachment(String path) {
        waitABit(1000);
        upload(findBy(UPLOAD_BUTTON), path);
    }
}
