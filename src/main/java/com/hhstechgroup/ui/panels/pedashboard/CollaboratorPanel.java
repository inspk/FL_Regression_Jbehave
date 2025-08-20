package com.hhstechgroup.ui.panels.pedashboard;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class CollaboratorPanel extends AbstractPanel {

    private static final String NAME = ".//div[contains(@class, 'modal_name_')]";
    private static final String STATUS = ".//div[contains(@class, 'modal_name_')]/following-sibling::div";
    private static final String PERMISSIONS = ".//div[contains(@class, 'modal_sections_')]";
    private static final String PERMISSIONS_COUNT = ".//div[contains(@class, 'modal_sections_')]/following-sibling::div";
    private static final String EDIT_BUTTON = ".//div[contains(@class, 'modal_actions')]//button[1]";
    private static final String DELETE_BUTTON = ".//div[contains(@class, 'modal_actions')]//button[2]";

    public CollaboratorPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public String getName() {
        return findBy(NAME).getText();
    }

    public String getStatus() {
        return findBy(STATUS).getText();
    }

    public String getPermissions() {
        return findBy(PERMISSIONS).getText();
    }

    public String getPermissionsCount() {
        return findBy(PERMISSIONS_COUNT).getText();
    }

    public void clickEdit() {
        action().moveToElement(findBy(EDIT_BUTTON)).click().build().perform();
    }

    public void clickDelete() {
        action().moveToElement(findBy(DELETE_BUTTON)).click().build().perform();
    }
}
