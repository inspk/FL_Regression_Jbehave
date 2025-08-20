package com.hhstechgroup.ui.pages.iuportal;

import com.hhstechgroup.ui.pages.peportal.Form1099Page;
import com.hhstechgroup.ui.panels.peportal.RecordsPanel;
import org.openqa.selenium.WebDriver;

public class Lists1099 extends Form1099Page {

    private static final String SEARCH_BLOCK = ".//div[contains(@class, 'search-box')]";
    private static final String RECORDS = ".//div[starts-with(@class, 'tile-table ')]";
    private static final String FORM_NAME = ".//div[contains(@class, 'details_title')]/h1";
    private static final String NPI = ".//div[contains(@class, 'details_description')]/span[not(a)]";
    private static final String PROVIDER_ID = ".//div[contains(@class, 'details_description')]/span[a]";
    private static final String SEARCH_BUTTON = ".//button[span[text() = 'Search']]";


    public Lists1099(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchPanelPresent() {
        return isElementPresent(SEARCH_BLOCK);
    }

    public void clickSearch() {
        findBy(SEARCH_BUTTON).click();
        waitForSpinnerToDisappear();
    }

    public RecordsPanel getRecords() {
        return new RecordsPanel(findBy(RECORDS), this);
    }

    public String getFormName() {
        return findBy(FORM_NAME).getText();
    }

    public String getNPI() {
        return findBy(NPI).getText();
    }

    public String getProviderId() {
        return findBy(PROVIDER_ID).getText();
    }
}
