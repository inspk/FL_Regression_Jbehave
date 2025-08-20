package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.peportalpages.Form1099Steps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class Form1099Scenario {

    @Steps
    Form1099Steps form1099Steps;

    @When("view details for $year year block")
    public void clickViewDetails(String year) {
        form1099Steps.clickViewDetails(year);
    }

    @When("click on 1099 search history row with provider id - '$id'")
    public void clickOnRecordWithValue(String id) {
        form1099Steps.clickOnRecordWithValue(id);
    }

    @When("click Search button on 1099 page")
    public void clickOnRecordWithValue() {
        form1099Steps.clickSearch();
    }

    @Then("1099 page should have next blocks: $table")
    public void check1099History(ExamplesTable table) {
        List<String> historyBlocks = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertReflectionEquals(historyBlocks, form1099Steps.get1099Blocks());
    }

    @Then("form 1099 page for 2018 year is displayed with filled data")
    public void isFormDisplayed() {
        assertTrue(form1099Steps.isFormDisplayed());
    }

    @Then("search for 1099 form should be present")
    public void isSearchBlockPresent() {
        assertTrue(form1099Steps.isSearchBlockPresent());
    }

    @Then("form name - '$name', npi - '$npi' and provider id - '$id' should be displayed")
    public void checkFormData(String name, String npi, String id) {
        assertEquals(name, form1099Steps.getFormName());
        assertEquals(npi, form1099Steps.getNPI());
        assertEquals(id, form1099Steps.getProviderId());
    }
}
