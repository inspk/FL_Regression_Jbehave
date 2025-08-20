package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class AddFilePopUp extends BaseModalPanel {

    private final static String SECTION = ".//input[contains(@id, 'section')]/preceding-sibling::div";
    private final static String FIELD = ".//input[contains(@id, 'field')]/preceding-sibling::div";
    private final static String UPLOAD_BUTTON = ".//div[contains(@class, 'upload_upload-controls_')]//input";
    private final static String TITLE = ".//h1[contains(@class, 'dialog-title')]";
    private final static String SECTION_DESCRIPTION = ".//div[contains(@class, 'upload-description')]//p";
    private final static String SECTION_NAME = ".//div[contains(@class, 'upload-description')]//h4";
    private final static String UPLOADED_DOCUMENT = ".//div[contains(@class, 'progress')]//div[text() = '%s']";
    private final static String COMMENT = ".//input[contains(@id, 'comment')]";
    private final static String CLOSE = ".//button[@aria-label='Close']";
    private final static String SELECT_FILE = ".//div[contains(@class, 'edi_upload-input')]/input";
    private final static String ADD_FILE_BUTTON = ".//div[contains(@class, 'documents_controls')]/button[span[text() = 'Add File']]";
    private final static String UPDATE_FILE_BUTTON = ".//button[span[text() = 'Update File']]";

    public AddFilePopUp(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setSection(String section) {
        findBy(SECTION).click();
        selectFromDropDown(section);
    }

    public void setField(String field) {
        waitForPopUpAttributeAppear();
        findBy(FIELD).click();
        selectFromDropDown(field);
    }

    public boolean isSelectFieldFieldPresent() {
        return isElementPresent(FIELD);
    }

    public void uploadAttachment(String path) {
        waitABit(1000);
        upload(findBy(UPLOAD_BUTTON), path);
    }

    public void uploadEdiFile(String path) {
        upload(findBy(SELECT_FILE), path);
    }

    public String getTitle() {
        return findBy(TITLE).getText();
    }

    public String getSectionName() {
        return findBy(SECTION_NAME).getText();
    }

    public String getSectionDescription() {
        return findBy(SECTION_DESCRIPTION).getText();
    }

    public boolean isDocumentUploaded(String documentName) {
        return isElementPresent(String.format(UPLOADED_DOCUMENT, documentName));
    }

    public void clickClose() {
        findBy(CLOSE).click();
        waitForPopUpClosed();
    }

    public void addComment(String comment) {
        findBy(COMMENT).type(comment);
    }

    public void clickAddFile() {
        findBy(ADD_FILE_BUTTON).click();
        waitForPopUpClosed();
    }

    public void clickUpdateFileButton() {
        findBy(UPDATE_FILE_BUTTON).click();
        waitForPopUpClosed();
    }
}
