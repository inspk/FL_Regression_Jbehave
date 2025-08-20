package com.hhstechgroup.ui.pages.peportal;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.PermissionsPanel;
import com.hhstechgroup.ui.panels.peportal.Table;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class CollaboratorsPage extends ProviderManagementBasePage {

    private static final String INVITE_COLLABORATOR_BUTTON = ".//div[contains(@class, 'collaborators_create')]/button[span[contains(text(), 'Invite')]]";
    private static final String TITLE = ".//div[contains(@class, 'collaborators_heading-line_')]//h1";
    private static final String COLUMNS = ".//div[contains(@class, 'table-head')]/div";
    private static final String ROWS = ".//div[contains(@class, 'table-row')]";
    private static final String CELLS = ".//div[contains(@class,'table-column')]";
    private static final String COLLABORATORS_LIST = ".//div[contains(@class, 'collaborators_table_')]";
    private static final String COLLABORATOR_EMAIL = ".//div[text() = '%s']";
    private static final String PERMISSIONS = "//div[contains(@class, 'collaborators_permissions-list_')]";
    private static final String COLLABORATORS_ABSENCE_MESSAGE = "//div[contains(@class, 'collaborators_empty')]";


    public CollaboratorsPage(WebDriver driver) {
        super(driver);
    }

    public void clickInviteCollaboratorButton() {
        findBy(INVITE_COLLABORATOR_BUTTON).click();
    }

    public String getTitle() {
        return findBy(TITLE).getText();
    }

    public boolean isInviteButtonDisplayed() {
        return isElementPresent(INVITE_COLLABORATOR_BUTTON);
    }

    public List<Map<String, String>> getCollaboratorsList() {
        return new Table(findBy(COLLABORATORS_LIST), this, COLUMNS, ROWS, CELLS).getListOfMappedValues();
    }

    public void clickOnCollaboratorByEmail(String email) {
        findBy(format(COLLABORATOR_EMAIL, email)).click();
    }

    public PermissionsPanel getPermissions() {
        return new PermissionsPanel(findBy(PERMISSIONS), this);
    }

    public String getCollaboratorsAbsenceMessage() {
        return findBy(COLLABORATORS_ABSENCE_MESSAGE).getText();
    }
}
