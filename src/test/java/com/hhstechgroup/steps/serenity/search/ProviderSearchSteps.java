package com.hhstechgroup.steps.serenity.search;


import com.hhstechgroup.beans.ProviderSearchParametersBean;
import com.hhstechgroup.beans.ProviderSearchResultBean;
import com.hhstechgroup.ui.pages.ProviderSearchPage;
import com.hhstechgroup.ui.panels.providersearch.SearchPanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;
import java.util.stream.Collectors;

public class ProviderSearchSteps extends ScenarioSteps {

    ProviderSearchPage providerSearchPage;

    @Step
    public void setSearchParameters(ProviderSearchParametersBean params) {
        SearchPanel search = providerSearchPage.getSearchPanel();
        BeanUtils.copyPropertiesInOrder(search, params);
        providerSearchPage.waitForSpinnerToDisappear();
    }

    @Step
    public List<ProviderSearchResultBean> getProviders() {
        return providerSearchPage.getProviders().stream().map(panel -> {
            ProviderSearchResultBean providerInfo = new ProviderSearchResultBean();
            BeanUtils.copyProperties(providerInfo, panel);
            return providerInfo;
        }).collect(Collectors.toList());
    }

    @Step
    public int getLocationsCount() {
        return providerSearchPage.getSearchMapPanel().getLocationsCount();
    }

    @Step
    public List<String> getAppliedFilters() {
        return providerSearchPage.getFiltersPanel().getFilters();
    }

    @Step
    public String getSearchResultsCount() {
        return providerSearchPage.getFiltersPanel().getResultsCount();
    }
}
