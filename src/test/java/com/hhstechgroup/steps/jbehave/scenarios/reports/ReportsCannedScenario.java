package com.hhstechgroup.steps.jbehave.scenarios.reports;

import com.hhstechgroup.steps.serenity.ReportsCannedSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jruby.RubyProcess;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class ReportsCannedScenario {

    @Steps
    ReportsCannedSteps reportsCannedSteps;

    @When("click on canned reports search history row with report id - '$id'")
    public void clickOnSearchRow(String id)
    {
        reportsCannedSteps.clickOnReportByReportId(id);
    }

    @When("click view icon on canned report row with report name - '$name'")
    public void clickOnViewByReportName(String name) {
        reportsCannedSteps.clickOnViewReportByName(name);
    }

    @When("click on Back to Search Results on Reports")
    public void clickBackToSearchResults() {
        reportsCannedSteps.clickBackToSearchResults();
    }

    @Then("search block for canned reports form should be present")
    public void isSearchBlockPresent() {
        assertTrue(reportsCannedSteps.isSearchBlockPresent());
    }

    @Then("search results for canned reports form should be present")
    public void isSearchResultsPresent() {
        assertTrue(reportsCannedSteps.isSearchResultsPresent());
    }

    @Then("canned report image is displayed")
    public void isCannedReportImageDisplayed() {
        assertTrue(reportsCannedSteps.isCannedReportImageIsPresent());
    }

    @Then("report details is displayed with next information: $table")
    public void checkCannedReportsDetails(ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), reportsCannedSteps.getReportCannedDetails());
    }

    @Then("report name '$reportName' on details page is displayed")
    public void checkCannedReportNameDetails(String reportName) {
        assertEquals(reportName, reportsCannedSteps.getCannedReportNameInDetails());
    }

    @Then("report results are displayed with next information: $table")
    public void checkReportList(ExamplesTable table) {
        List<Map<String, String>> actualResults = reportsCannedSteps.getResults();
        assertTrue(actualResults.containsAll(table.getRows()));
    }
}
