package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.iuportal.RequestNotesSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class RequestNotesScenario {

    @Steps
    RequestNotesSteps requestNotesSteps;

    @When("click Add Note button on Notes section")
    public void clickAddNoteButton() {
        requestNotesSteps.clickAddNote();
    }

    @When("add note with text - '$text'")
    public void addNote(String text) {
        requestNotesSteps.setNoteText(text);
        requestNotesSteps.clickAddNoteOnPopUp();
    }

    @When("set note text - '$text'")
    public void setNoteText(String text) {
        requestNotesSteps.setNoteText(text);
    }

    @When("select note text from template - '$template'")
    public void addNoteFromTemplate(String template) {
        requestNotesSteps.addNoteFromTemplate(template);
    }

    @When("click Add Note button on Add Note pop-up")
    public void clickAddNoteOnPopUp() {
        requestNotesSteps.clickAddNoteOnPopUp();
    }

    @When("click Save Changes button on Edit Note pop-up")
    public void clickSaveChangesOnPopUp() {
        requestNotesSteps.clickSaveChangesOnPopUp();
    }

    @When("edit note with text - '$text', author name - $name and author role - $role")
    public void editNote(String text, String authorName, String authorRole) {
        requestNotesSteps.editNote(authorName, authorRole, text);
    }

    @When("remove note with text - '$text', author name - $name and author role - $role")
    public void removeNote(String text, String authorName, String authorRole) {
        requestNotesSteps.removeNote(authorName, authorRole, text);
    }

    @When("restore note with text - '$text', author name - $name and author role - $role")
    public void restoreeNote(String text, String authorName, String authorRole) {
        requestNotesSteps.clickRestoreNote(authorName, authorRole, text);
    }

    @When("filter notes by criteria - '$criteria'")
    public void filterNotes(String criteria) {
        requestNotesSteps.filterNotesByCriteria(criteria);
    }

    @When("search for note by criteria - '$criteria'")
    public void searchForNote(String criteria) {
        requestNotesSteps.setSearchCriteria(criteria);
    }

    @Then("'No matches.' - message should be displayed on Notes section")
    public void isNoMatchesMessageDisplayed() {
        assertTrue(requestNotesSteps.isNoNotesMessageDisplayed());
    }

    @Then("note with text - '$text', author name - $name and author role - $role should be present")
    public void checkNoteCreated(String expectedText, String authorName, String authorRole) {
        assertTrue("Wrong note text is displayed!", requestNotesSteps.getNote(authorName, authorRole, expectedText));
    }

    @Then("note with text - '$text', author name - $name and author role - $role should have next date - '$date'")
    public void checkNoteCreated(String text, String authorName, String authorRole, String expectedDate) {
        String actualDate = requestNotesSteps.getNoteDate(authorName, authorRole, text);
        assertTrue(String.format("Expected note date is %s, but was - %s", expectedDate, actualDate), actualDate.startsWith(expectedDate));
    }

    @Then("template text '$template' should be copied to note text field")
    public void checkNoteText(String template) {
        assertEquals(template, requestNotesSteps.getNoteText());
    }

    @Then("Edited text should be displayed near the note with text - '$text', author name - $name and author role - $role")
    public void isNoteEdited(String text, String authorName, String authorRole) {
        assertTrue(requestNotesSteps.isNoteEdited(authorName, authorRole, text));
    }

    @Then("message '$message' should be displayed after deleting the note with text - '$text', author name - $name and author role - $role")
    public void checkRestoreMessage(String expectedMessage, String text, String authorName, String authorRole) {
        assertEquals(expectedMessage, requestNotesSteps.getRestoreNoteMessage(authorName, authorRole, text));
    }

    @Then("note with text - '$text', author name - $name and author role - $role should be restored")
    public void isNoteRestored(String text, String authorName, String authorRole) {
        assertFalse("Note should be restored", requestNotesSteps.isNoteDeleted(authorName, authorRole, text));
    }

    @Then("next notes should be displayed in the following order: $table")
    public void isNoteRestored(ExamplesTable table) {
        assertReflectionEquals(ExamplesTableUtil.parseTableColumnAsList(table, 0),  requestNotesSteps.getNotes());
    }

    @When("set note subject - '$subject'")
    public void setNoteSubject(String subject) {
        requestNotesSteps.setNoteSubject(subject);
    }

    @When("upload file $path in add note popup")
    public void uploadFile(String path) {
        requestNotesSteps.uploadAttachment(path);
    }

    @When("download file $file in notes tab")
    public void downloadFile(String file) {
        requestNotesSteps.downloadAttachment(file);
    }


}
