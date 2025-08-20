package com.hhstechgroup.ui.pages.peportal;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.PermissionsPanel;
import com.hhstechgroup.ui.panels.peportal.FieldsValues;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class CollaboratorDetailsPage extends ProviderManagementBasePage {

    private static final String PERMISSIONS = "//div[contains(@class, 'collaborators_permissions-list_')]";
    private static final String NAME = "//div[contains(@class, 'collaborators_heading-line_')]/h1";
    private static final String COLLABORATOR_INFO = "//div[contains(@class, 'collaborators_info-columns')]";
    private static final String COLLABORATOR_INFO_KEYS = ".//span[1]";
    private static final String COLLABORATOR_INFO_VALUES = "following-sibling::span";
    private static final String EDIT_BUTTON = ".//div[contains(@class, 'collaborators_edit-btn')]/button";
    private static final String SAVE_CHANGES_BUTTON = ".//span[contains(@class, 'collaborators_btns')]/button[span[text() = 'Save changes']]";
    private static final String BACK_BUTTON = ".//div[contains(@class, 'breadcrumb_breadcrumb')]/span";


    public CollaboratorDetailsPage(WebDriver driver) {
        super(driver);
    }

    public PermissionsPanel getPermissions() {
        return new PermissionsPanel(findBy(PERMISSIONS), this);
    }

    public String getCollaboratorNameMail() {
        return findBy(NAME).getText();
    }

    public Map<String, String> getCollaboratorInfo() {
        return new FieldsValues(findBy(COLLABORATOR_INFO), this, COLLABORATOR_INFO_KEYS, COLLABORATOR_INFO_VALUES).getMappedValues();
    }

    public void clickEdit() {
        findBy(EDIT_BUTTON).click();
        waitForPresenceOf(SAVE_CHANGES_BUTTON);
    }

    public void saveChanges() {
        scrollToElement(SAVE_CHANGES_BUTTON);
        findBy(SAVE_CHANGES_BUTTON).click();
        waitForAbsenceOf(SAVE_CHANGES_BUTTON);
    }

    public void clickBackButton() {
        findBy(BACK_BUTTON).click();
    }
}
