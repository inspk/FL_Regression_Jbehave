package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChangeAssigneeModal extends BaseModalPanel {

    private static final String SEARCH_INPUT = ".//input[@id = 'inbox-search']";
    private static final String SEARCH_BUTTON = ".//input[@id = 'inbox-search']/following-sibling::div/button";
    private static final String FIRST_NAME = ".//li//span[text() = '%s']";
    private static final String APPLY_BUTTON = ".//button[span[text() = 'Assign']]";

    public ChangeAssigneeModal(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setSearchInput(String search) {
        findBy(SEARCH_INPUT).type(search);
    }

    public void clickSearch() {
        findBy(SEARCH_BUTTON).click();
    }

    public void selectAssignee(String assignee) {
        findBy(String.format(FIRST_NAME, assignee)).click();
    }

    public void clickApply() {
        findBy(APPLY_BUTTON).click();
        waitForPopUpClosed();
    }
}
