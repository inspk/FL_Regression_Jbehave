package com.hhstechgroup.ui.panels.pedashboard;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Collectors;
import static java.lang.String.format;

public class HeaderPanel extends AbstractPanel {

    private static final String TABS = "//*/div/ul/li/a";
    private static final String TAB = ".//div/ul/li/a[text()='%s']";
    private static final String TAB1 = ".//div/ul/li/a/p[text()='%s']";

    private static final String LOGO = ".//div[contains(@class, 'logo')]//img";
    private static final String MESSAGE_CENTER_BUTTON = ".//a[contains(@href, 'inbox')]/button";
    private static final String MESSAGE_CENTER_NOTITFICATION_COUNT = ".//a[contains(@href, 'inbox')]/button//span[div]";
    private static final String USER = ".//div[contains(@class, 'helptour_user')]/div";
    private static final String BACK_TO_DASHBOARD = ".//div[contains(@class, 'header_menu-container')]//a[contains(text(), 'Back to dashboard')]";
    private static final String PAGE_TITLE = ".//span[contains(@class, 'header-heading')]";
    private static final String OTHER = "//*/div/ul/li[contains(@class, 'header_other')]";
    private static final String OTHER_TABS = "//ul/li/a/ul/li";
    private static final String LOADING_SPINNER_BAR = ".//div[@id = 'loading-bar-spinner']/div[@class = 'spinner-icon']";
    private static final String MORE = ".//button[contains(@class, 'header_more-btn')]";

    public HeaderPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public boolean isTabsAbsent() {
        return findAll(TABS).size() == 0;
    }

    public List<String> getTabs() {
        return findAll(TABS).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    public List<String> getOtherTabs() {
        action().moveToElement(findBy(OTHER)).build().perform();
        return findAll(OTHER_TABS).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    public boolean isLogoPresent() {
        return isElementPresent(LOGO);
    }

    //latest
    public void clickOnLogo() {findBy(LOGO).click();}

    public boolean isMessageCenterButtonPresent() {
        return isElementPresent(MESSAGE_CENTER_BUTTON);
    }

    public String getUserEmail() {
        return findBy(USER).getText();
    }

//replaced this method clickontab
    public void clickOnTab(String tabName) {
        if (findBy(String.format(TAB, tabName)).isCurrentlyVisible()) {
            findBy(String.format(TAB, tabName)).click();
        } else {
            waitABit(500);
            selectHiddenTab(tabName);
            waitABit(500);
        }

//        waitForAbsenceOf(SPINNER);
    }

    //latest


    public void clickOnTab1(String tabName) {
        waitABit(500);
        jsClick(format(TAB,tabName));
      //  findBy(String.format(TAB, tabName)).click();
        waitABit(500);

    }




    //latest click on provider data in more tab
    public void clickOnProviderDataTab(String tabName) {
        if (findBy(String.format(TAB, tabName)).isCurrentlyVisible()) {
            waitABit(2000);
            findBy(String.format(TAB, tabName)).click();
        } else {
            waitABit(2000);
            selectHiddenTab(tabName);
        }

        waitForAbsenceOf(SPINNER);
    }

    public void clickOnDashoardTab(String tabName1) {
        if (findBy(String.format(TAB1, tabName1)).isCurrentlyVisible()) {
            findBy(String.format(TAB1, tabName1)).click();
        } else {
            selectHiddenTab(tabName1);
        }

        waitForAbsenceOf(SPINNER);
    }

    //click on edi and close   [latest]
    public void selectHiddenTab(String tabName){
        findBy(MORE).click();
        jsClick(String.format(".//ul/li[node() = '%s']//a", tabName));
        action().sendKeys(Keys.ESCAPE).build().perform();
    }

    /*public void selectHiddenTab(String tabName){
        findBy(MORE).click();                                //old
        selectFromDropDown(tabName);
    }*/

    public void clickOnUser() {
        try{
        jsClick(USER);
        }
        catch (Exception e) {
           jsClick(USER);
           System.out.println("clicked on user");
        }

    }

    public void clickOnBackToDashboard() {
        findBy(BACK_TO_DASHBOARD).click();
    }

    public String getNotitficationsCount() {
        waitForPresenceOf(MESSAGE_CENTER_NOTITFICATION_COUNT);
        return findBy(MESSAGE_CENTER_NOTITFICATION_COUNT).getText();
    }
    public void waitUserEmail() {
        waitForPresenceOf(USER);
    }

    public void clickOnMessageCenterButton() {
        //sp26
        waitABit(100);
        jsClick(MESSAGE_CENTER_BUTTON);
        waitABit(200);
//        findBy(MESSAGE_CENTER_BUTTON).click();
//        waitForAbsenceOf(LOADING_SPINNER_BAR);
    }

    public boolean isPageTitleCorrect(String pageTitle){
        return findBy(PAGE_TITLE).getText().contains(pageTitle);
    }
}