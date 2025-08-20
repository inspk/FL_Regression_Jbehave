package com.hhstechgroup.ui.pages.iuportal;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.iuportal.ReportSearchResultsListBlock;
import com.hhstechgroup.ui.panels.peportal.MainInfoBlock;
import org.openqa.selenium.*;

import java.util.Map;

import static java.lang.String.format;


public class ReportsCannedPage extends ProviderManagementBasePage {
    private static final String SEARCH_BLOCK = ".//div[contains(@class, 'search-box')]";
    private static final String RECORDS = ".//div[contains(@class, 'list_content')]";
    private static final String RECORD_BY_REPORT_ID = "//div[contains(@class,'list_content')]//span[text() = '%s']/..";
    private static final String VIEW_BY_REPORT_NAME = "//div[contains(@class,'list_row')]/span[text() = '%s']/../a";
    private static final String IMAGE = "//img[@src='/img/mock/canned-report.jpg']";
    private static final String REPORT_CANNED_DETAILS ="//div[contains(@class, 'main-info-panel_card_')]";
    private static final String REPORT_CANNED_LIST =".//div[contains(@class, 'list_results-container')]";
    private static final String REPORT_CANNED_DETAILS_NAME ="//div[contains(@class,'main-info-panel_card-heading')]//span";

    public ReportsCannedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchReportsPanelPresent() {
        return isElementPresent(SEARCH_BLOCK);
    }

    public boolean isSearchResultsPresent() {
        return isElementPresent(RECORDS);
    }

    public void clickOnRecordWithReportId(String reportId) {
        findBy(format(RECORD_BY_REPORT_ID, reportId)).waitUntilVisible().click();
    }

    public void clickOnViewByReportName(String reportName) {
        findBy(format(VIEW_BY_REPORT_NAME, reportName)).waitUntilVisible().click();
    }

    public boolean verifyImageOnCannedReportDetails() {
        return isElementPresent(IMAGE);
    }

    public Map<String, String> getReportCannedDetails() {
        return new MainInfoBlock(findBy(REPORT_CANNED_DETAILS), this).getMappedValues();
    }
    public ReportSearchResultsListBlock getReportSearchResultsListBlock() {
        waitForPresenceOf(REPORT_CANNED_LIST);
        return new ReportSearchResultsListBlock(findBy(REPORT_CANNED_LIST), this);
    }
    public String getCannedReportNameInDetails() {
       return findBy(REPORT_CANNED_DETAILS_NAME).getText();

    }
}
