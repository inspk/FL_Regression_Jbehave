package com.hhstechgroup.ui.pages.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.iuportal.AuditResultsPanel;
import com.hhstechgroup.ui.panels.iuportal.AuditSearchPanel;
import org.openqa.selenium.WebDriver;

public class AuditPage extends AbstractPage {

    private static final String SEARCH_PANEL = ".//div[contains(@class, 'search-box_')]";
    private static final String RESULTS_PANEL = ".//div[starts-with(@class, 'tile-table-row ')]";
    private static final String PARAMETER = ".//div[text()= 'Parameter']/..";
    private static final String USER_ID = ".//input[contains(@id, 'userID')]";
    private static final String SEARCH_BUTTON = ".//button[span[text() = 'Search']]";

    private static final String RESULTS = "//p[text()='%s']";

    private static final String USER_NAME = "//input[contains(@id, 'userName')]";

    private static final String IU = "(//p[text()='%s'])[1]";

    private static final String TIMESTAMP_FROM =".//label[contains(text(), 'Timestamp from')]/parent::div//input";

    private static final String TIMESTAMP_TO =".//label[contains(text(), 'Timestamp to')]/parent::div//input";

    private static final String PARAMETER_VALUES =".//div[starts-with(@class, 'css-11')]";

    private static final String VALUES ="(.//div[starts-with(@class, 'css-11')]//div)[1]";

    public AuditPage(WebDriver driver) {
        super(driver);
    }

    public AuditSearchPanel getSearchPanel() { waitAbit(2000);
        return new AuditSearchPanel(findBy(SEARCH_PANEL), this);
    }

    public AuditResultsPanel getAuditResultsPanel() {
        waitForPresenceOf(RESULTS_PANEL);
        return new AuditResultsPanel(findBy(RESULTS_PANEL), this);
    }
    public void clickAndSelectParameter(String parameteroption){
        waitAbit(200);
        findBy(PARAMETER).click();
        waitAbit(200);
        // selectFromDropDown(parameteroption);
        findBy(PARAMETER_VALUES).selectByVisibleText(VALUES).click();
//        findBy(VALUES).click();
        waitAbit(200);
//        jsClick(PARAMETER_VALUES);
        findBy(SEARCH_BUTTON).click();
}
    public void setUserId(String userId){
        waitAbit(100);
        findBy(USER_ID).sendKeys(userId);
 //       findBy(SEARCH_BUTTON).click();
        jsClick(SEARCH_BUTTON);
}
    public void clickAndExpand(String userId){
        waitAbit(100);
        scrollToElement(RESULTS_PANEL);
        findBy(RESULTS_PANEL).click();
    }

    public void setUserName(String userName){
        waitAbit(100);
        findBy(USER_NAME).sendKeys(userName);
        findBy(SEARCH_BUTTON).click();

    }
    public void clickAndExpand1(String userName){
        waitAbit(100);
        scrollToElement(RESULTS_PANEL);
        findBy(RESULTS_PANEL).click();
    }

}
