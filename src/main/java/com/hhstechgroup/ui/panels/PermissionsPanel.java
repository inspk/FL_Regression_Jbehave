package com.hhstechgroup.ui.panels;


import com.hhstechgroup.beans.CollaboratorPermissionsBean;
import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class PermissionsPanel extends AbstractPanel {

    private static final String DISPLAYED_SECTIONS = ".//span[contains(@class, 'collaborators_switcher')]";
    private static final String SECTION_SWITCHER = ".//span[input]";
    private static final String SECTION_BY_NAME = ".//span[text() = '%s']";
    private static final String SELECTED_OPTION_COLOR = "rgba(255, 196, 0, 1)";
    private static final String PERMISSION_CHECKBOX = ".//span[text() = '%s']/ancestor::div[span[contains(@class, 'collaborators_switcher')]]//label/span[text() = '%s']/preceding-sibling::span";
    private static final String HIDDEN_SECTION_BY_NAME = ".//div[text() = '%s']";
    private static final String EXPAND_HIDDEN_SECTIONS_BUTTON = ".//button[@aria-label='Expand More']";
    private static final String HIDDEN_SECTION_PERMISSION_CHECKBOX = ".//div[text() = '%s']/ancestor::div[contains(@class, 'collaborators_section-permissions_')]//label/span[text() = '%s']/preceding-sibling::span";
    private static final String PERMISSION_ROW = ".//span[contains(@class, 'collaborators_switcher')]/parent::div";
    private static final String PERMISSIONS = ".//span[contains(@class, 'collaborators_checks')]//label//input";
    private static final String PERMISSION_CHECKBOX_TEXT = "./ancestor::label/span[text()]";
    private static final String HIDDEN_PERMISSION_ROW = ".//div[contains(@class, 'collaborators_section-permissions_')]";
    private static final String HIDDEN_PERMISSIONS = ".//div[contains(@class, 'collaborators_section-checks')]//label//input";
    private static final String HIDDEN_SECTION_NAME = ".//div[contains(@class, 'collaborators_section-name')]";
    private static final String EXPAND_PERMISSIONS = ".//span[contains(text(), '%s')]//ancestor::div[@role='button']";
    private static final String PERMISSIONS_SWITCHER = ".//span[contains(text(), '%s')]/../..//input/parent::span";
    private static final String CANCEL = ".//h1/..//span[contains(text(), 'Cancel')]";

    public PermissionsPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void switchOffPages(List<String> pages) {
        List<WebElementFacade> pagesToSwitchOff = findAll(DISPLAYED_SECTIONS).stream().filter(page -> !pages.contains(page.getText())).collect(Collectors.toList());
        pagesToSwitchOff.forEach(page -> page.findBy(SECTION_SWITCHER).click());
    }

    public void setPermissionsToPage(String page, String permissions) {
        List<String> permissionsList = Arrays.asList(permissions.split(" "));
        String sectionXpath = format(SECTION_BY_NAME, page);
        String sectionHiddenXpath = format(HIDDEN_SECTION_BY_NAME, page);
        if (isElementPresent(sectionXpath)) {
            scrollToElement(sectionXpath);
            setPermissions(permissionsList, page, PERMISSION_CHECKBOX);
        } else {
            if (!isElementPresent(sectionHiddenXpath)) {
                expandHiddenSections();
            }
            waitForPresenceOf(sectionHiddenXpath);
            scrollToElement(sectionHiddenXpath);
            setPermissions(permissionsList, page, HIDDEN_SECTION_PERMISSION_CHECKBOX);
        }
    }

    public void expandHiddenSections() {
        findAll(EXPAND_HIDDEN_SECTIONS_BUTTON).forEach(WebElementFacade::click);
    }

    private void setPermissions(List<String> permissions, String page, String pageLocator) {
        List<String> permissionsToTurnOn = permissions.stream().filter(per -> !findBy(format(pageLocator, page, per)).getCssValue("color").equals(SELECTED_OPTION_COLOR)).collect(Collectors.toList());
        permissionsToTurnOn.forEach(per -> findBy(format(pageLocator, page, per)).click());
    }

    public List<CollaboratorPermissionsBean> getPermissions() {
        List<CollaboratorPermissionsBean> collaboratorPermissions = new ArrayList<>();
        collaboratorPermissions.addAll(getPermissions(PERMISSION_ROW, PERMISSIONS, DISPLAYED_SECTIONS));
        if (!isElementPresent(HIDDEN_PERMISSION_ROW)) {
            expandHiddenSections();
        }
        collaboratorPermissions.addAll(getPermissions(HIDDEN_PERMISSION_ROW, HIDDEN_PERMISSIONS, HIDDEN_SECTION_NAME));
        return collaboratorPermissions;
    }


    private List<CollaboratorPermissionsBean> getPermissions(String rowLocator, String permissionsLocator, String sectionName) {
        List<CollaboratorPermissionsBean> collaboratorPermissions = new ArrayList<>();
        List<WebElementFacade> permissions = findAll(rowLocator)
                .stream()
                .filter(row -> row.thenFindAll(permissionsLocator)
                        .stream()
                        .anyMatch(per -> per.getAttribute("checked") != null))
                .collect(Collectors.toList());
        permissions.forEach(p -> collaboratorPermissions.add(getPermission(p, permissionsLocator, sectionName)));
        return collaboratorPermissions;
    }

    private CollaboratorPermissionsBean getPermission(WebElementFacade permission, String permissionsLocator, String sectionName) {
        CollaboratorPermissionsBean collaboratorPermission = new CollaboratorPermissionsBean();
        collaboratorPermission.setSection(permission.findBy(sectionName).getText());
        List<String> permissions = permission.thenFindAll(permissionsLocator)
                .stream()
                .filter(per -> per.getAttribute("checked") != null)
                .map(per -> per.findBy(PERMISSION_CHECKBOX_TEXT).getText())
                .collect(Collectors.toList());
        collaboratorPermission.setAccess(permissions.stream().collect(Collectors.joining(" ")));
        return collaboratorPermission;
    }

    public void expandPermissions(String section) {
        findBy(format(EXPAND_PERMISSIONS, section)).click();
    }

    public void deselectPermissions(String section) {
        findBy(format(PERMISSIONS_SWITCHER, section)).click();
    }

    public void clickCancel() {
        findBy(CANCEL).click();
    }


}
