package com.hhstechgroup.steps.serenity.iuportal;

import com.hhstechgroup.ui.pages.iuportal.ViewRequestPage;
import com.hhstechgroup.util.common.FileUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class RequestNotesSteps extends ScenarioSteps {

    ViewRequestPage viewRequestPage;

    @Step
    public void clickAddNote() {
        viewRequestPage.getNotesPanel().clickOnAddNote();
    }

    @Step
    public boolean isNoNotesMessageDisplayed() {
        return viewRequestPage.getNotesPanel().isNoNotesMessageDisplayed();
    }

    @Step
    public void setNoteText(String text) {
        viewRequestPage.getAddNotePopUp().setNoteText(text);
    }

    @Step
    public void clickAddNoteOnPopUp() {
        viewRequestPage.getAddNotePopUp().clickAddNote();
    }

    @Step
    public void clickSaveChangesOnPopUp() {
        viewRequestPage.getAddNotePopUp().clickSaveChanges();
    }

    @Step
    public boolean getNote(String authorName, String authorRole, String noteText) {
        return viewRequestPage.getNotesPanel().getNote(authorName, authorRole, noteText);
    }

    @Step
    public String getNoteDate(String authorName, String authorRole, String noteText) {
        return viewRequestPage.getNotesPanel().getNoteDate(authorName, authorRole, noteText);
    }

    @Step
    public void addNoteFromTemplate(String template) {
        viewRequestPage.getAddNotePopUp().selectTemplate(template);
    }

    @Step
    public String getNoteText() {
        return viewRequestPage.getAddNotePopUp().getNoteText();
    }

    @Step
    public void editNote(String authorName, String authorRole, String noteText) {
        viewRequestPage.getNotesPanel().clickEditNote(authorName, authorRole, noteText);
    }

    @Step
    public void removeNote(String authorName, String authorRole, String noteText) {
        viewRequestPage.getNotesPanel().clickDeleteNote(authorName, authorRole, noteText);
    }

    @Step
    public boolean isNoteEdited(String authorName, String authorRole, String noteText) {
        return viewRequestPage.getNotesPanel().isEditedTextDisplayed(authorName, authorRole, noteText);
    }

    @Step
    public String getRestoreNoteMessage(String authorName, String authorRole, String noteText) {
        return viewRequestPage.getNotesPanel().getRestoreMessage(authorName, authorRole, noteText);
    }

    @Step
    public boolean isNoteDeleted(String authorName, String authorRole, String noteText) {
        return viewRequestPage.getNotesPanel().isNoteDeleted(authorName, authorRole, noteText);
    }

    @Step
    public void clickRestoreNote(String authorName, String authorRole, String noteText) {
        viewRequestPage.getNotesPanel().clickRestoreNote(authorName, authorRole, noteText);
    }

    @Step
    public void filterNotesByCriteria(String criteria) {
        viewRequestPage.getNotesPanel().selectFilterOption(criteria);
    }


    @Step
    public void setSearchCriteria(String criteria) {
        viewRequestPage.getNotesPanel().setSearchCriteria(criteria);
    }

    @Step
    public List<String> getNotes() {
        waitABit(1000);
        return viewRequestPage.getNotesPanel().getNotes();

    }

    @Step
    public void setNoteSubject(String subject){
        viewRequestPage.getAddNotePopUp().setNoteSubject(subject);
    }

    @Step
    public void uploadAttachment(String path) {
        viewRequestPage.getAddNotePopUp().uploadAttachment(FileUtils.getAbsolutePath(path));
    }

    @Step
    public void downloadAttachment(String file) {
        viewRequestPage.getNotesPanel().downloadAttachment(file);
    }
}
