package com.hhstechgroup.ui.pages.peportal;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.peportal.*;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class EligibilityPage extends ProviderManagementBasePage {

    private static final String ELIGIBILITY_SEARCH = ".//div[contains(@class, '_search-box_')]";
    private static final String RECORDS = ".//div[contains(@class, 'tile-table-head')]/parent::div";
    private static final String ELIGIBILITY_CONFIRMATION = "//div[contains(@class, 'main-info-panel_card_')]";
    private static final String ELIGIBILITY_SECTION_TITLE = ".//h2[text() = '%s']";
    private static final String SERVICE_DATE = "//div[contains(@class, 'details_subtitle_')]";
    private static final String ELIGIBILITY_SECTION = "//a[text() = '%s']";
    private static final String ELIGIBILITY_BLOCK = ".//h2/../div";
    private static final String ACCORDION_BLOCK = "//div[contains(@class, 'details_status-details_')]";
    private static final String ELIGIBILITY_DETAILS_COLUMNS = "//h2/..//div[contains(@class, 'details_header')]/span";
    private static final String ELIGIBILITY_DETAILS_ROWS = ".//div[contains(@class, 'details_content')]/div";
    private static final String ELIGIBILITY_DETAILS_CELLS = ".//parent::div/span[contains(@class, 'details')]";
    private static final String COLUMN_VALUE = ".//span[text()='%s']";
    private static final String SECTIONS = ".//div[contains(@class, 'details_claim-nav_')]";
    private static final String VIEW_ADDRESS = ".//p[contains(text(), 'View address')]/span";

    public EligibilityPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchPanelPresent() {
        return isElementPresent(ELIGIBILITY_SEARCH);
    }

    public SearchForRecordPanel getSearchPanel() {
        return new SearchForRecordPanel(findBy(ELIGIBILITY_SEARCH), this);
    }

    public RecordsPanel getRecords() {
        return new RecordsPanel(findBy(RECORDS), this);
    }

    public MainInfoBlock getEligibilityConfirmation() {
        return new MainInfoBlock(findBy(ELIGIBILITY_CONFIRMATION), this);
    }

    public void clickViewAddress() {
        findBy(VIEW_ADDRESS).click();
    }

    public boolean isSectionOpened(String sectionTitle) {
        return isElementPresent(format(ELIGIBILITY_SECTION_TITLE, sectionTitle));
    }

    public boolean isServiceDateCorrect(String dateFrom, String dateTo){
        return findBy(SERVICE_DATE).getText().contains(dateFrom) && findBy(SERVICE_DATE).getText().contains(dateTo);
    }

    public void navigateToSection(String sectionName){
        scrollToElement(SECTIONS);
        findBy(format(ELIGIBILITY_SECTION, sectionName)).click();
    }

    public List<Map<String, String>> getEligibilityInfo() {
        return new Table(findBy(ELIGIBILITY_BLOCK), this, ELIGIBILITY_DETAILS_COLUMNS, ELIGIBILITY_DETAILS_ROWS, ELIGIBILITY_DETAILS_CELLS).getListOfMappedValues();
    }

    public void clickRowWithEligibilityType(String type){
        findBy(format(COLUMN_VALUE, type)).click();
    }

    public void clickRowWithCarrierName(String name){
        findBy(format(COLUMN_VALUE, name)).click();
    }

    public Map<String, String> getAccordionInfo() {
        return new EligibilityType(findBy(ACCORDION_BLOCK), this).getMappedValues();
    }
}



