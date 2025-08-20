package com.hhstechgroup.ui.pages.iuportal;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.iuportal.UpdateProfilePanel;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class UpdateProfilePage extends ProviderManagementBasePage {

    private static final String UPDATE_PROFILE_PANEL = ".//div[@role= 'dialog' and @aria-label='responsive-dialog-title']";
    private static final String TAB = "//button//span[text()='%s']";
    private static final String UPDATE_BUTTON = "//button/span[text()='Update']";
    private static final String OK_BUTTON = "//button/span[text()='OK']";

    public UpdateProfilePage(WebDriver driver) {
        super(driver);
    }

    public UpdateProfilePanel getUpdateProfilePanel() {
        return new UpdateProfilePanel(findBy(UPDATE_PROFILE_PANEL), this);
    }

    public void clickTab(String tab) {
        findBy(format(TAB, tab)).click();
        waitAbit(500);
    }

    public void clickUpdate() {
        waitAbit(500);
        findBy(UPDATE_BUTTON).click();
        waitAbit(500);
    }

    public void clickOK() {
        waitAbit(500);
        findBy(OK_BUTTON).click();
        waitAbit(500);
    }

}
