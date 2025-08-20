package com.hhstechgroup.steps.jbehave.scenarios.applications;

import com.hhstechgroup.beans.ProviderSearchParametersBean;
import com.hhstechgroup.beans.ProviderSearchResultBean;
import com.hhstechgroup.steps.serenity.search.ProviderSearchSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Parameters;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class ProviderSearchScenario {

    @Steps
    ProviderSearchSteps providerSearchSteps;

    @When("search for provider by next parameters: $table")
    public void searchForProvider(ExamplesTable table) {
        ProviderSearchParametersBean searchParameters = ExamplesTableUtil.parseTableToClass(table, ProviderSearchParametersBean.class).get(0);
        providerSearchSteps.setSearchParameters(searchParameters);
    }

    @Then("next providers should be found in search results: $table")
    public void checkProviders(ExamplesTable table) {
        List<ProviderSearchResultBean> expectedProviders = table.getRowsAsParameters(true).stream().map(this::getProviderInfo).filter(this::isNameEmpty).collect(Collectors.toList());
        List<ProviderSearchResultBean> actualProviders = providerSearchSteps.getProviders();
        assertReflectionEquals(expectedProviders, actualProviders);
    }

    @Then("$count locations should be displayed on the map")
    public void checkLocationsCount(int count) {
        assertEquals(count, providerSearchSteps.getLocationsCount());
    }

    @Then("next filters should be applied: $table")
    public void checkFiltersApplied(ExamplesTable table) {
        List<String> expectedFilters = parseFilters(table.getRowAsParameters(0, true));
        assertReflectionEquals(expectedFilters, providerSearchSteps.getAppliedFilters(), ReflectionComparatorMode.LENIENT_ORDER);
    }

    @Then("$count providers should be found")
    public void getProvidersCount(String count) {
        assertEquals(count, providerSearchSteps.getSearchResultsCount());
    }

    private ProviderSearchResultBean getProviderInfo(Parameters row) {
        List<String> languages = parseLanguages(row);
        List<String> ages = parseAges(row);
        row.values().remove("languages");
        row.values().remove("ages");
        ProviderSearchResultBean provider = ExamplesTableUtil.parseTableRowToClass(row, ProviderSearchResultBean.class);
        provider.setLanguages(languages);
        provider.setAges(ages);
        return provider;
    }

    private List<String> parseLanguages(Parameters row) {
        return Arrays.asList(row.values().get("languages").split(","));
    }

    private List<String> parseAges(Parameters row) {
        return Arrays.asList(row.values().get("ages").split(","));
    }

    private List<String> parseFilters(Parameters row) {
        return Arrays.asList(row.values().get("filters").split(","));
    }

    private boolean isNameEmpty(ProviderSearchResultBean provider) {
        return !provider.getName().equals("");
    }
}
