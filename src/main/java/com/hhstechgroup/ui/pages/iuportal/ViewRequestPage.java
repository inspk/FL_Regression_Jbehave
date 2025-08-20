package com.hhstechgroup.ui.pages.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.iuportal.*;
import com.hhstechgroup.ui.panels.iuportal.approval.ApprovalPanel;
import com.hhstechgroup.ui.panels.iuportal.approval.ApprovePopup;
import com.hhstechgroup.ui.panels.iuportal.approval.DenyPopup;
import com.hhstechgroup.ui.panels.iuportal.ReactivationPopup;
import com.hhstechgroup.ui.panels.peportal.MainInfoBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ViewRequestPage extends AbstractPage {

    private static final String ENROLLMENT_INFO_PANEL = ".//div[contains(@class, 'main-info-panel_card_')]";
    private static final String APPROVAL_INFO_PANEL = ".//div[contains(@class, 'review-panel')]/..";
    private static final String REVIEWERS_INFO_PANEL = ".//div[contains(@class, 'details_review-panel-approver')]/..";
    private static final String SECTION = ".//button//span[text() = '%s']";
    private static final String FILES_AND_DOCUMENTS_PANEL = ".//div[contains(@class, 'layout_app-details-inner-body')]";
    private static final String CHANGE_STATUS_POP_UP = "//h2[span[text() = 'Change status']]/parent::div/parent::div[@role='dialog']";
    private static final String ADD_FILE_POP_UP = "//div[contains(@class, 'attachments-dialog')]";
    private static final String NOTES_PANEL = "//div[contains(@class, 'notes_app-details-body')]";
    private static final String ADD_NOTE_POP_UP = "//div[@role='document']";
    protected static final String APPROVE_POPUP = ".//h2[div[contains(text(), 'Approve')]]/parent::div/parent::div[@role='dialog']";
    protected static final String DENY_POPUP = ".//h2[div[contains(text(), 'Deny')]]/parent::div/parent::div[@role='dialog']";
    private static final String REACTIVATION_POPUP = ".//h2[div[contains(text(), 'Reactivate enrollment')]]/parent::div/parent::div[@role='document']";

    public ViewRequestPage(WebDriver driver) {
        super(driver);
    }

    public MainInfoBlock getEnrollmentCardPanel() {
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(ENROLLMENT_INFO_PANEL)));
        return new MainInfoBlock(findBy(ENROLLMENT_INFO_PANEL), this);
    }

    public ApprovalPanel getApprovalPanel() {
        withTimeoutOf(Duration.ofSeconds(20)).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(APPROVAL_INFO_PANEL)));
        return new ApprovalPanel(findBy(APPROVAL_INFO_PANEL), this);
    }

    public ApprovePopup getApprovePopup() {
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(APPROVE_POPUP)));
        return new ApprovePopup(findBy(APPROVE_POPUP), this);
    }

    public ReactivationPopup getReactivationPopup() {
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(REACTIVATION_POPUP)));
        return new ReactivationPopup(findBy(REACTIVATION_POPUP), this);
    }

    public DenyPopup getDenyPopup() {
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(DENY_POPUP)));
        return new DenyPopup(findBy(DENY_POPUP), this);
    }

    public boolean isRequestInfoDisplayed() {
        return isElementPresent(ENROLLMENT_INFO_PANEL);
    }

    public boolean isReviewersInfoPresent() {
        return isElementPresent(REVIEWERS_INFO_PANEL);
    }

    public void clickOnSection(String section) {
        String element = String.format(SECTION, section);
        scrollToElement(element);
        findBy(element).click();
    }

    public FilesDocumentsPanel getFilesDocumentsPanel() {
        return new FilesDocumentsPanel(findBy(FILES_AND_DOCUMENTS_PANEL), this);
    }

    public ChangeStatusPopUp getChangeStatusPopUp() {
        waitForPopUpOpened();
        return new ChangeStatusPopUp(findBy(CHANGE_STATUS_POP_UP), this);
    }

    public boolean isChangeStatusPopUpOpened() {
        return isElementPresent(CHANGE_STATUS_POP_UP);
    }

    public AddFilePopUp getAddFilePopUp() {
        return new AddFilePopUp(findBy(ADD_FILE_POP_UP), this);
    }

    public NotesPanel getNotesPanel() {
        return new NotesPanel(findBy(NOTES_PANEL), this);
    }

    public AddNotePopUp getAddNotePopUp() {
        return new AddNotePopUp(findBy(ADD_NOTE_POP_UP), this);
    }

}
