package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class AddNewRolePopup extends AbstractPanel {

    private static final String ROLE_NAME = ".//label[contains(text(), 'Role Name')]/..//input";
    private static final String ROLE_DESCRIPTION = ".//label[contains(text(), 'Role Description')]/../div/textarea[1]";
    //private static final String ADD = ".//span[contains(text(), 'Add')]";
    //latest
    private static final String ADD ="//span[text()='Add']/parent::button";
    private static final String ERROR_DISPLAYED = ".//label[contains(text(), 'Role Name')]/../p";
    private static final String CANCEL = ".//span[contains(text(), 'Cancel')]";

    public AddNewRolePopup(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setRoleName(String roleName) {
        jsClick(ROLE_NAME);
        //findBy(ROLE_NAME).click();
        findBy(ROLE_NAME).type(roleName);
    }

    public void setRoleDescription(String roleDescription) {
        findBy(ROLE_DESCRIPTION).click();
        findBy(ROLE_DESCRIPTION).type(roleDescription);
    }

    public void clickAdd() {waitABit(2000);
        findBy(ADD).click();
        waitABit(2000);
    }

    public String getErrorDisplayed() {
        return findBy(ERROR_DISPLAYED).getText();
    }

    public void clickCancel() {
        findBy(CANCEL).click();
    }

}
