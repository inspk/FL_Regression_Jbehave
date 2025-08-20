package com.hhstechgroup.ui.pages.sitevisit;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class AddNewUserPopup  extends AbstractPanel {
    private static final String  CLICK_ADD_USER = "//span[contains(text(), 'Add User')]/parent::button";
    private static final String ADD_NEW_USER_PANEL = "//h2[contains(text(), 'Add New User')]/../parent::div";
    private static final String USER_FIRST_NAME = "//label[text()='First Name']/../parent::div";
    private static final String USER_LAST_NAME = "//label[text()='Last Name']/../parent::div";


    public AddNewUserPopup(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void clickOnAddUser() { jsClick(CLICK_ADD_USER);}



    public boolean isAddNewUserPopupOpened() {
        return isElementPresent(ADD_NEW_USER_PANEL);
    }

    public void fillUserFirstName(String username) {
        findBy(USER_FIRST_NAME).type(username);
    }

    public String getUserFirstNameValue() {
        return findBy(USER_FIRST_NAME).getAttribute("value");
    }

    public void fillUserLastName(String password) {
        findBy(USER_LAST_NAME).type(password);}

    public String getUserLastNameValue() {
        return findBy(USER_LAST_NAME).getAttribute("value");
    }

}
