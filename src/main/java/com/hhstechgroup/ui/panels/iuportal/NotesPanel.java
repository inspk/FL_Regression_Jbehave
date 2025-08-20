package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class NotesPanel extends AbstractPanel {

    private static final String NO_NOTES_MESSAGE = ".//div[contains(@class, 'notes_no-attachments') and text() = 'No matches.']";
    private static final String ADD_NOTE_BUTTON = ".//button[contains(@class, 'notes_app-details-add-btn')]/span";
    private static final String NOTE_BY_AUTHOR_AND_TEXT = ".//div[span[text() = '%s'] and span[text() = '%s']]/following-sibling::div//div//span[text() = '%s']";
    private static final String NOTE_DATE_TIME = "./ancestor::div//span[contains(@class, '_note-msg-date')]";
    private static final String EDITED_NOTE = "/ancestor::div//span[contains(@class, '_note-msg-edited')]";
    private static final String EDIT_BUTTON = "/ancestor::div[contains(@class, '_note-msg-box')]//div[contains(@class, 'note-actions')]/button[1]";
    private static final String DELETE_BUTTON = "/ancestor::div[contains(@class, '_note-msg-box')]//div[contains(@class, 'note-actions')]/button[2]";
    private static final String RESTORE_NOTE = "/ancestor::div[contains(@class, 'note-msg-box')]/following-sibling::div/p";
    private static final String RESTORE_NOTE_LINK = "/ancestor::div[contains(@class, 'note-msg-box')]/following-sibling::div/p/a";
    private static final String FILTER_DROP_DOWN = ".//div[contains(@class, '-sorting_')]//input/preceding-sibling::div";
    private static final String NOTES = ".//div//span[@data-text]";
    private static final String SEARCH = ".//div[contains(@class, '-search_')]//input";

    public NotesPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public boolean isNoNotesMessageDisplayed() {
        return isElementPresent(NO_NOTES_MESSAGE);
    }

    public void clickOnAddNote() {
        scrollToElement(ADD_NOTE_BUTTON);
        waitABit(1000);
        findBy(ADD_NOTE_BUTTON).click();
        waitForPopUpOpened();
    }

    public boolean getNote(String authorName, String authorRole, String text) {
        return isElementPresent(prepareNoteLocator(authorName, authorRole, text));
    }

    public String getNoteDate(String authorName, String authorRole, String text) {
        return findBy(prepareNoteLocator(authorName, authorRole, text)).findBy(NOTE_DATE_TIME).getText();
    }

    public boolean isEditedTextDisplayed(String authorName, String authorRole, String text) {
        return isElementPresent(prepareNoteLocator(authorName, authorRole, text).concat(EDITED_NOTE));
    }

    public void clickEditNote(String authorName, String authorRole, String text) {
        action().moveToElement(findBy(prepareNoteLocator(authorName, authorRole, text))).build().perform();
        findBy(prepareNoteLocator(authorName, authorRole, text).concat(EDIT_BUTTON)).click();
        waitABit(3000);
    }

    public void clickDeleteNote(String authorName, String authorRole, String text) {
        action().moveToElement(findBy(prepareNoteLocator(authorName, authorRole, text))).build().perform();
        findBy(prepareNoteLocator(authorName, authorRole, text).concat(DELETE_BUTTON)).click();
    }

    private String prepareNoteLocator(String authorName, String authorRole, String text) {
        return format(NOTE_BY_AUTHOR_AND_TEXT, authorName, authorRole, text);
    }

    public String getRestoreMessage(String authorName, String authorRole, String text) {
        return findBy(prepareNoteLocator(authorName, authorRole, text).concat(RESTORE_NOTE)).getText();
    }

    public boolean isNoteDeleted(String authorName, String authorRole, String text) {
        return isElementPresent(prepareNoteLocator(authorName, authorRole, text).concat(RESTORE_NOTE));
    }

    public void clickRestoreNote(String authorName, String authorRole, String text) {
        findBy(prepareNoteLocator(authorName, authorRole, text).concat(RESTORE_NOTE_LINK)).click();
    }

    public void selectFilterOption(String option) {
        findBy(FILTER_DROP_DOWN).click();
        selectFromDropDown(option);
    }

    public List<String> getNotes() {
        return findAll(NOTES).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    public void setSearchCriteria(String criteria) {
        findBy(SEARCH).type(criteria);
    }

    private final static String DOWNLOAD_BUTTON = "//div/a[text()='%s']";
    public void downloadAttachment(String file){
        waitABit(500);
        scrollToElement(format(DOWNLOAD_BUTTON, file));
        waitABit(500);
        findBy(format(DOWNLOAD_BUTTON, file)).click();
    }

}
