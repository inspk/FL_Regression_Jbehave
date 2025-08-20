package com.hhstechgroup.ui.panels;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

public class InformationalPopUp extends BaseModalPanel{

    private static final String MESSAGE = ".//p";
    private static final String CLOSE_BUTTON = ".//button";

    public InformationalPopUp(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public String getMessage() {
        return findBy(MESSAGE).getText();
    }

    public void clickCloseButton() {
        jsClick(CLOSE_BUTTON);
    }
}
