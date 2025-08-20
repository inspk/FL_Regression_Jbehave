package com.hhstechgroup.ui.pages;

import com.hhstechgroup.ui.panels.providersearch.FiltersPanel;
import com.hhstechgroup.ui.panels.providersearch.ProviderPanel;
import com.hhstechgroup.ui.panels.providersearch.SearchMapPanel;
import com.hhstechgroup.ui.panels.providersearch.SearchPanel;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class ProviderSearchPage extends AbstractPage {

    private static final String SEARCH_PANEL = ".//section[contains(@class, 'heading mobile-filter-for-map')]";
    private static final String PROVIDERS_SEARCH_RESULT = ".//section[contains(@class, 'aside-facilities')]//li";
    private static final String MAP = ".//div[contains(@class, 'leaflet-map ')]";
    private static final String FILTERS = ".//section[contains(@class, 'extended-filters')]";

    public ProviderSearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPanel getSearchPanel() {
        return new SearchPanel(findBy(SEARCH_PANEL), this);
    }

    public List<ProviderPanel> getProviders() {
        return findAll(PROVIDERS_SEARCH_RESULT).stream().map(provider -> new ProviderPanel(provider, this)).collect(Collectors.toList());
    }

    public SearchMapPanel getSearchMapPanel() {
        return new SearchMapPanel(findBy(MAP), this);
    }

    public FiltersPanel getFiltersPanel() {
        return new FiltersPanel(findBy(FILTERS), this);
    }
}
