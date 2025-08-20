package com.hhstechgroup.ui.pages.iuportal;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.coc.SelectCoCTypeModalWindow;
import com.hhstechgroup.ui.panels.iuportal.*;
import org.openqa.selenium.WebDriver;

public class EnrollmentCocPage extends ProviderManagementBasePage {

    private static final String SEARCH_PANEL = ".//div[contains(@class, 'search-box-container')]";
    private static final String REQUESTS_PANEL = ".//div[contains(@class, 'tile-table ')]";
    private static final String CHANGE_ASSIGNEE = ".//h2[span[text() = 'Assign']]/parent::div/parent::div[@role='dialog']";
    private static final String CHANGE_STATUS_POP_UP = ".//h2[span[text() = 'Change status']]/parent::div/parent::div[@role='dialog']";
    private static final String SEARCH_LINK = ".//span[contains(text(), 'Search')]";

    public EnrollmentCocPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSearchLink() {
        findBy(SEARCH_LINK).click();
    }

    public EnrollmentSearchPanel getSearchPanel() {
        //sp39
        waitAbit(500);
        return new EnrollmentSearchPanel(findBy(SEARCH_PANEL), this);
    }

    public RequestsPanel getRequestsPanel() {
        return new RequestsPanel(findBy(REQUESTS_PANEL), this);
    }

    public ChangeAssigneeModal getChangeAssigneeModal() {
        return new ChangeAssigneeModal(findBy(CHANGE_ASSIGNEE), this);
    }

    public ChangeStatusPopUp getChangeStatusPopUp() {
        return new ChangeStatusPopUp(findBy(CHANGE_STATUS_POP_UP), this);
    }

    public boolean isChangeStatusPopUpOpened() {
        return isElementPresent(CHANGE_STATUS_POP_UP);
    }

    private static final String CLICK_APPEAL_IN_ACTIONMENU =".//div[contains(@class,'expansion-panel-menu ')]/button/span";
    protected static final String DROP_DOWN_OPTION = "//ul/li[text() = '%s']";
    public void selectAppealOption(String action){
        scrollToElement(CLICK_APPEAL_IN_ACTIONMENU);
        findBy(CLICK_APPEAL_IN_ACTIONMENU).click();
        waitABit(3000);
        action().moveToElement(findBy(String.format(DROP_DOWN_OPTION, action))).click().build().perform();
    }

    private static final String COCPANEL = ".//div[contains(@class, 'details_panel')]";
    public SelectCoCTypeModalWindow getproviderCocPanel() {
        return new SelectCoCTypeModalWindow(findBy(COCPANEL), this);
    }
    //sp30
    private static final String DOWNLOAD_BUTTON = ".//div[contains(@class,'details_header-actions')]/a";
    public boolean verifyDownloadButtonDisplaying() {
        waitAbit(500);
        scrollToElement(DOWNLOAD_BUTTON);
        return isElementPresent(DOWNLOAD_BUTTON);
    }
    public void clickDownloadButton() {
        waitABit(500);
        scrollToElement(DOWNLOAD_BUTTON);
        findBy(DOWNLOAD_BUTTON).click();
        waitABit(200);
    }
}
