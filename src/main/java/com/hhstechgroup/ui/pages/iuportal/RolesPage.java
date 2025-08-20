package com.hhstechgroup.ui.pages.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.iuportal.AddNewRolePopup;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class RolesPage extends AbstractPage {

    private static final String ROLES_PAGE_TAB = "//a[contains(text(), '%s')]";
   private static final String ROLE = "//a/span[contains(text(), '%s')]";
  // private static final String ROLE = "//ul/li[contains(text(), '%s')]";
    //latest
    private static final String ROLE1= "//a/span[contains(text(), 'Provider Supervisor')]";

    private static final String EDIT_BUTTON = "//button/span[contains(text(), 'Edit')]";
    private static final String EDIT_MODE_ACTIVATED = "//h1[contains(text(), 'Edit Mode')]";
    //private static final String ADD_NEW = "//span[contains(text(), ' Add new')]/parent::button";
    //latest
    private static final String ADD_NEW  = "//span[contains(text(),'Add new')]/parent::button";
    private static final String ADD_BUTTON  = "//span[text()='Add']/parent::button";

    private static final String NEW_ROLE_PANEL = "//h2[contains(text(), 'Add New Role')]/../parent::div";
    private static final String SEARCH_ICON = "//h1/..//div[contains(@class, 'search-button_search')]";
    private static final String SEARCH_ROLE = "//input[@id='inbox-search']";
    private static final String ROLE_LIST_KEYS = "//span[contains(text(), 'Role Name')]/../span[text()]";
    private static final String ROLE_LIST_VALUES = "//div[contains(@class, 'roles-list_content')]//span[contains(text(), '%s')]/../span[text()]";
    private static final String ROLE_DETAILS_HEADER = "//h1[contains(text(), '%s')]";

    public RolesPage(WebDriver driver) {
        super(driver);
    }

    public AddNewRolePopup newRolePopup() {
        return new AddNewRolePopup(findBy(NEW_ROLE_PANEL), this);
    }

    public void clickTabOnRolesPage(String tab) {
        scrollToElement(format(ROLES_PAGE_TAB,tab));
        jsClick(format(ROLES_PAGE_TAB, tab));
        waitAbit(500);
    }

    public void selectRole(String role) {
        scrollToElement(format(ROLE, role));
        findBy(format(ROLE, role)).click();
    }
    //latest
    public void selectAnyRole() {
        scrollToElement(ROLE1);
        waitAbit(1000);
        jsClick(ROLE1); waitAbit(5000);}





    public void activateEditMode() {
        findBy(EDIT_BUTTON).click();
    }

    public boolean isEditModeActivated() {
        return isElementPresent(EDIT_MODE_ACTIVATED);
    }

    public void clickAddNew() {
        scrollToElement(ADD_NEW);
        findBy(ADD_NEW).click();
    }

    //latest
    public void clickAddButtonFromAddNewRole(){jsClick(ADD_BUTTON);}

    public boolean isPopupOpened() {
        return isElementPresent(NEW_ROLE_PANEL);
    }

    public boolean isPopupClosed() {
        findBy(NEW_ROLE_PANEL).waitUntilNotVisible();
        return isElementPresent(NEW_ROLE_PANEL);
    }

    public void searchForRole(String role) {
        findBy(SEARCH_ICON).click();
        findBy(SEARCH_ROLE).type(role);
    }

    public boolean isRoleDetailsOpened(String role) {
        return isElementPresent(format(ROLE_DETAILS_HEADER, role));
    }

    public Map<String, String> getRoleInfo(String roleName) {
        final List<WebElementFacade> headers = findAll(ROLE_LIST_KEYS);
        final List<WebElementFacade> values = findAll(format(ROLE_LIST_VALUES, roleName));
        final Map<String, String> result = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            result.put(headers.get(i).getText(), values.get(i).getText());
        }
        return result;
    }

    private static final String ROLES = "//div[contains(@class, 'roles-list_table-container')]/div/a/span[text()='%s']";
    public void clickRoleWithText(String role) {
        scrollToElement(format(ROLES, role));
        waitAbit(1000);
        findBy(format(ROLES, role)).click();
    }

    private static final String SAVE_BUTTON = "//button/span[text()='Save changes']";
    private static final String OK_BUTTON = "//button/span[text()='OK']";
    public void saveChanges(){
        waitAbit(1000);
        jsClick(SAVE_BUTTON);
        waitAbit(1000);
        jsClick(OK_BUTTON);
    }

    private static final String EXPAND_PERMISSION = "//div[@role='button']//div/span[text()='%s']";
    public void expandPermission(String text){
        findBy(format(EXPAND_PERMISSION, text)).click();
    }

    private static final String PERMISSION = "//div/span[text()='%s']/../..//div[*[text()='%s']]//input";
    public boolean verifyPermissions(String permission, String permissions){
        return findBy(format(PERMISSION, permission, permissions)).isSelected();
    }

}
