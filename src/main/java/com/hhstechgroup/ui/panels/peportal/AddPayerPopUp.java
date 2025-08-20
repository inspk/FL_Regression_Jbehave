package com.hhstechgroup.ui.panels.peportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class AddPayerPopUp extends BaseModalPanel {

    private static final String SELECT_PAYER = ".//input[contains(@id, 'Select payer')]/preceding-sibling::div";
    private static final String ADD_BUTTON = ".//button[span[text() = 'Add']]";

    public AddPayerPopUp(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void selectPayer(String payer) {
        findBy(SELECT_PAYER).click();
        selectFromDropDown(payer);

    }

    public void clickAdd() {
        findBy(ADD_BUTTON).waitUntilEnabled().click();
        waitForPopUpClosed();
    }
}
