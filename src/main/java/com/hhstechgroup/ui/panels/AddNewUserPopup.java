package com.hhstechgroup.ui.panels;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

public class AddNewUserPopup extends AbstractPanel {
    private static final String USER_FIRST_NAME = "//label[text()='First Name']/../parent::div";


    public AddNewUserPopup(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setUserFirstName(String roleName) {
        jsClick(USER_FIRST_NAME);
        //findBy(ROLE_NAME).click();
        findBy(USER_FIRST_NAME).type(roleName);
    }
}
