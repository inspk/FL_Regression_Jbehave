package com.hhstechgroup.ui.pages.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.PermissionsPanel;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class RoleDetailsPage extends AbstractPage {

    private static final String DESCRIPTION = "//h1/../../span";
    private static final String STATUS = "//span[contains(text(), 'Status')]/following-sibling::span//div[text() and @role='button']";
    private static final String CREATE_DATE = "//span[contains(text(), 'Created')]/following-sibling::span";
    private static final String UPDATE_DATE = "//span[contains(text(), 'Updated')]/following-sibling::span";
    private static final String PERMISSIONS = "//h2[contains(text(), 'Permissions')]/../parent::div";
    private static final String BACK_TO_LIST = "//div[contains(@class, 'breadcrumb')]/span";

    public RoleDetailsPage(WebDriver driver) {
        super(driver);
    }

    public PermissionsPanel getPermissions() {
        return new PermissionsPanel(findBy(PERMISSIONS), this);
    }

    public String getDescription() {
        return findBy(DESCRIPTION).getText();
    }

    public String getStatus() {
        return findBy(format(STATUS)).getText();
    }

    public String getCreateDate() {
        return findBy(CREATE_DATE).getText();
    }

    public String getUpdateDate() {
        return findBy(UPDATE_DATE).getText();
    }

    public void clickBack() {
        findBy(BACK_TO_LIST).click();
    }


}
