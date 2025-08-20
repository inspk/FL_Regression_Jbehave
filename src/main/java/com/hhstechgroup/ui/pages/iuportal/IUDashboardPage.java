package com.hhstechgroup.ui.pages.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.iuportal.RequestsPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class IUDashboardPage extends AbstractPage {

    private static final String REQUESTS_PANEL = ".//div[contains(@class, 'list-table')]";
    private static final String STATISTICS = ".//div[contains(@class, 'MuiCardContent-root')]";
    private static final String NEWS_STREAM = ".//div[contains(@class, 'right-content')]";
    private static final String FILTERS = ".//div[contains(@class, 'horizontal-tabs')]//button";

    public IUDashboardPage(WebDriver driver) {
        super(driver);
    }

    public RequestsPanel getRequestsPanel() {
        return new RequestsPanel(findBy(REQUESTS_PANEL), this);
    }

    public boolean isSatisticsPresent() {
        return isElementPresent(STATISTICS);
    }

    public boolean isNewsPresent() {
        return isElementPresent(NEWS_STREAM);
    }

    public List<String> getFilters() { waitAbit(3000);
        return findAll(FILTERS).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }
    //sp30
    private static final String DASHBOARD_PAGE_TABS = ".//button[contains(@role,'tab')]/span[contains(text(),'%s')]";
    public boolean isTabsPresent(String tabs) {
        waitAbit(500);
        scrollToElement(format(DASHBOARD_PAGE_TABS,tabs));
        return isElementPresent(format(DASHBOARD_PAGE_TABS,tabs));
    }
    public  void clickonTabs(String tabs){
        waitForSpinnerToDisappear();
        jsClick(format(DASHBOARD_PAGE_TABS,tabs));
        waitAbit(300);
        scrollToElement(format(DASHBOARD_PAGE_TABS,tabs));
       waitAbit(1500);
    }

    //sp33
    private static final String VALIDATION = ".//td//h3[contains(text(),'%s')]";
    public boolean isValidationMsgPresent(String validationMsg) {
        waitAbit(500);
        scrollToElement(format(VALIDATION,validationMsg));
        return isElementPresent(format(VALIDATION,validationMsg));
    }


}
