package com.hhstechgroup.steps.jbehave.scenarios;


import com.hhstechgroup.beans.AuditEventsSearchBean;
import com.hhstechgroup.steps.serenity.AuditSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import io.appium.java_client.pagefactory.AndroidBy;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.collection.IsMapContaining;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AuditScenario {

    @Steps
    AuditSteps auditSteps;

    @When("search for event by next parameters: $table")
    public void searchByParameters(ExamplesTable table) {
        AuditEventsSearchBean parameters = ExamplesTableUtil.parseTableToClass(table, AuditEventsSearchBean.class).get(0);
        auditSteps.setSearchCriteria(parameters);
        auditSteps.clickSearch();
    }
    @When("expand audit event: $table")
    public void expandRow(ExamplesTable table) {
        String text = "";
        table.getRow(0).forEach((key, value) -> text.concat(value));
        auditSteps.expandRow(text);
    }

    @Then("all found audit events should contain tag '$tag'")
    public void isSearchResultContainTag(String tag) {
        assertTrue(auditSteps.isAllContainsTag(tag));
    }

    @Then("next audit event should be found: $table")
    public void checkEventFound(ExamplesTable table) {
        List<Map<String, String>> actualResults = auditSteps.getResults();
        actualResults.forEach(entry -> entry.remove("Date"));
        assertTrue(actualResults.containsAll(table.getRows()));
    }

    @Then("expanded event should have next attributes: $table")
    public void checkExpandedRow(ExamplesTable table) {
        table.getRow(0).forEach((key, value) -> assertThat(auditSteps.getExpandedRowInfo(), IsMapContaining.hasEntry(key, value)));
    }

    //sp23

    @When("expand end affiliation coc row: $table")
    public void expandAffiliationRow(ExamplesTable table) {
        String text = "";
        table.getRow(0).forEach((key, value) -> text.concat(value));
        auditSteps.expandRow(text);
    }

    @Then("next enrollment span should be contains: $table")
    public void checkEventFound1(ExamplesTable table) {
        List<Map<String, String>> actualResults = auditSteps.getResults();
        actualResults.forEach(entry -> entry.remove("EFFECTIVE TO DATE"));
        actualResults.forEach(entry -> entry.remove("EFFECTIVE FROM DATE"));
        actualResults.forEach(entry -> entry.remove("NOTES"));
        assertTrue(actualResults.containsAll(table.getRows()));
    }

    @Then("next enrollment span should be found: $table")
    public void checkEventFound2(ExamplesTable table) {
        List<Map<String, String>> actualResults = auditSteps.getResults();
        assertTrue(actualResults.containsAll(table.getRows()));
    }
    @Then("click on parameter and search with '$parameteroption'")
    public void clickAndSelectParameter(String parameteroption) {
        auditSteps.clickAndSelectParameter(parameteroption);
    }
    @Then("click on User ID and search with '$userid'")
    public void clickAndSearch(String userId){
        auditSteps.setUserId(userId);
    }


    @Then("click on audit data with text '$userid' on IU portal")
    public void checkEventFound3(String userId) {
     auditSteps.clickAndExpand(userId);
    }

    @Then("click on User Name and search with '$userName' on IU portal")
    public void setUserName(String userName) {
        auditSteps.setUserName(userName);
    }

    @When("To fill the following fields: $table")
    public void setTimestampFrom(ExamplesTable table){
        AuditEventsSearchBean parameters = ExamplesTableUtil.parseTableToClass(table, AuditEventsSearchBean.class).get(0);
        auditSteps.setSearchCriteria(parameters);
        auditSteps.clickSearch();
    }

    @When("To fill the following fields for parameter fileds : $table")
    public void setParamterValues(ExamplesTable table) {
        AuditEventsSearchBean parameters = ExamplesTableUtil.parseTableToClass(table, AuditEventsSearchBean.class).get(0);
        auditSteps.setSearchCriteria(parameters);
        auditSteps.clickSearch();
    }

}




