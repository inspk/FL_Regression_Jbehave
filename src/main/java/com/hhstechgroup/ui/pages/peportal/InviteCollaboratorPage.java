package com.hhstechgroup.ui.pages.peportal;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.PermissionsPanel;
import org.openqa.selenium.WebDriver;

public class InviteCollaboratorPage extends ProviderManagementBasePage {

    private static final String EMAIL = ".//div[contains(@class, 'collaborators_actions')]//input[contains(@id, 'email')]";
    private static final String NAME = ".//div[contains(@class, 'collaborators_actions')]//input[contains(@id, 'name')]";
    private static final String CANCEL_BUTTON = ".//div[contains(@class, 'collaborators_buttons')]//button[span[text() =  'Cancel']]";
    private static final String SEND_INVITE_BUTTON = ".//div[contains(@class, 'collaborators_buttons')]//button[span[text() =  'Send invite']]";
    private static final String PERMISSIONS = "//div[contains(@class, 'collaborators_permissions-list_')]";

    public InviteCollaboratorPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        findBy(EMAIL).type(email);
    }

    public void setName(String name) {
        findBy(NAME).type(name);
    }

    public void clickSendInvite() {
        scrollToElement(SEND_INVITE_BUTTON);
        findBy(SEND_INVITE_BUTTON).click();
        //waitForAbsenceOf(SEND_INVITE_BUTTON);
        //waitForSpinnerToDisappear();
    }

    public void clickCancel() {
        findBy(CANCEL_BUTTON).click();
        waitForAbsenceOf(CANCEL_BUTTON);
        waitForSpinnerToDisappear();
    }

    public PermissionsPanel getPermissions() {
        return new PermissionsPanel(findBy(PERMISSIONS), this);
    }
}
