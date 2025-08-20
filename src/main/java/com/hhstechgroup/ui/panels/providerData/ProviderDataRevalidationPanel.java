package com.hhstechgroup.ui.panels.providerData;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.KeyValueMapper;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProviderDataRevalidationPanel extends AbstractPanel implements KeyValueMapper {

    private static final String DETAILS_KEYS = ".//p[1]";
    private static final String DETAILS_VALUES = "following-sibling::*";
    private static final String VIEW_DETAILS_BUTTON = ".//button[node() = 'VIEW DETAILS']";
    private static final String EXPAND_HISTORY_LINK = ".//div[contains(@class, 'revalidation_view-history')]/a";
    private static final String EXPANDED_HISTORY_ROWS = ".//div[contains(@class, 'revalidation_data')]/div[contains(@class, 'revalidation_row_')]";
    private static final String EXPANDED_HISTORY_COLUMNS = ".//div[contains(@class, 'header')]//span";
    private static final String EXPANDED_HISTORY_CELLS = "./span";


    public ProviderDataRevalidationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public Map<String, String> getMappedValues() {
        Map<String, String> details = new HashMap<>();
        findAll(DETAILS_KEYS).forEach(detail -> details.put(detail.getText().trim(), detail.findBy(DETAILS_VALUES).isVisible() ? detail.findBy(DETAILS_VALUES).getText().trim() : ""));
        return details;
    }

    public void clickViewDetails() {
        findBy(VIEW_DETAILS_BUTTON).click();
    }

    public void clickViewHistory() {
        findBy(EXPAND_HISTORY_LINK).click();
    }

    public List<Map<String, String>> getExpandedDetails() {
        return findAll(EXPANDED_HISTORY_ROWS).stream()
                .map(row -> {
                    return findAll(EXPANDED_HISTORY_COLUMNS).stream()
                            .collect(Collectors.toMap(WebElementFacade::getText, el -> row.thenFindAll(EXPANDED_HISTORY_CELLS).get(getPositionRelatedToSibling(el) - 1).getText()));
                })
                .collect(Collectors.toList());

        }
    }

