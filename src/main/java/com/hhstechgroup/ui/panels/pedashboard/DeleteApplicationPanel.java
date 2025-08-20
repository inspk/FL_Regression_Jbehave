package com.hhstechgroup.ui.panels.pedashboard;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class DeleteApplicationPanel extends BaseModalPanel {

    private static final String TITLE = ".//h2";
    private static final String TEXT = ".//p";
    private static final String DELETE_BUTTON = ".//button/span[text()='Delete']";
    private static final String CANCEL_BUTTON = ".//button/span[text()='Cancel']";


    public DeleteApplicationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public String getTitle() {
        return findBy(TITLE).getText();
    }

    public String getText() {
        return findBy(TEXT).getText();
    }

    public boolean isDeleteButtonDisplayed() {
        return isElementPresent(DELETE_BUTTON);
    }

    public boolean isCancelButtonDisplayed() {
        return isElementPresent(CANCEL_BUTTON);
    }

    public void clickCancelButton() {
        findBy(CANCEL_BUTTON).click();
        waitForPopUpClosed();
    }

    public void clickDeleteButton() {
        findBy(DELETE_BUTTON).click();
//        waitForPopUpClosed();
    }
}
