package com.hhstechgroup.ui.panels.providersearch;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.substringBefore;


public class FiltersPanel extends AbstractPanel {

    private static final String RESULTS_COUNT = ".//span[contains(@class, 'results-total')]";
    private static final String RESULTS_SEPARATOR = " RESULTS";
    private static final String FILTERS = ".//div[contains(@class, 'meta-tag')]/span";
    private static final String LOADING_SPINNER_BAR = ".//div[@id = 'loading-bar-spinner']";

    public FiltersPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public String getResultsCount() {
        waitForAbsenceOf(LOADING_SPINNER_BAR);
        return substringBefore(findBy(RESULTS_COUNT).getText(), RESULTS_SEPARATOR);
    }

    public List<String> getFilters() {
        waitForAbsenceOf(LOADING_SPINNER_BAR);
        return findAll(FILTERS).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }
}
