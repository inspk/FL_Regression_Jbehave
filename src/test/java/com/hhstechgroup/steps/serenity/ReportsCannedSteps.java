package com.hhstechgroup.steps.serenity;

import com.hhstechgroup.ui.pages.iuportal.ReportsCannedPage;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Map;

public class ReportsCannedSteps {

    ReportsCannedPage reportsCannedPage;

    @Step
    public boolean isSearchBlockPresent() {
        return reportsCannedPage.isSearchReportsPanelPresent();
    }

    @Step
    public boolean isSearchResultsPresent() {
        return reportsCannedPage.isSearchResultsPresent();
    }

    @Step
    public void clickOnReportByReportId(String reportId) {
        reportsCannedPage.clickOnRecordWithReportId(reportId);
    }

    @Step
    public void clickOnViewReportByName(String reportName) {
        reportsCannedPage.clickOnViewByReportName(reportName);
    }

    @Step
    public boolean isCannedReportImageIsPresent() {
        return reportsCannedPage.verifyImageOnCannedReportDetails();
    }

    @Step
    public void clickBackToSearchResults() {
        reportsCannedPage.clickBackToSearchResults();
    }

    @Step
    public Map<String, String> getReportCannedDetails() {
        return reportsCannedPage.getReportCannedDetails();
    }
    @Step
    public List<Map<String, String>> getResults() {
        return reportsCannedPage.getReportSearchResultsListBlock().getResults();
    }
    @Step
    public String getCannedReportNameInDetails() {
       return  reportsCannedPage.getCannedReportNameInDetails();
    }


}
