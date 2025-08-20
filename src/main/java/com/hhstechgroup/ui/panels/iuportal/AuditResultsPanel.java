package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.peportal.Table;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class AuditResultsPanel extends AbstractPanel {

    private static final String RESULTS = ".//div[contains(@class, '-table-head')]/..";
    private static final String RESULTS_COLUMNS = ".//div[contains(@class, '-table-head')]//div[span]";
    private static final String RESULTS_ROWS = ".//div[contains(@class, 'tile-table-body')]/div//div[contains(@class, '-summary')]";
    private static final String RESULTS_CELLS = ".//p";
    private static final String NEXT_RESULTS_BUTTON = ".//table//button[2]";
    private static final String RESULT_ROW_BY_TEXT = ".//div[contains(@class, 'tile-table-body')]/div[contains(node(), '%s')]//div[contains(@class, '-actions')]//button";
    private static final String EXPANDED_ROW_KEYS = "..//div[contains(@class, 'expansion-panel-details')]//div/span[1]";
    private static final String EXPANDED_ROW_VALUES = "following-sibling::span";

    public AuditResultsPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public List<Map<String, String>> getResults() {
        waitABit(1000);
        return new Table(findBy(RESULTS), getBasePage(), RESULTS_COLUMNS, RESULTS_ROWS, RESULTS_CELLS).getListOfMappedValues();
    }

    public List<Map<String, String>> getAllResults() {
        List<Map<String, String>> results = new ArrayList<>();
        results.addAll(getResults());
        while (findBy(NEXT_RESULTS_BUTTON).getAttribute("disabled") == null) {
            scrollToElement(NEXT_RESULTS_BUTTON);
            findBy(NEXT_RESULTS_BUTTON).click();
            waitABit(500);
            results.addAll(getResults());
        }
        return results;
    }

    public void expandRowWithText(String text) {
        scrollToElement(format(RESULT_ROW_BY_TEXT, text));
        findBy(format(RESULT_ROW_BY_TEXT, text)).click();
    }

    public Map<String, String> getExpandedRowInfo() {
        Map<String, String> details = new HashMap<>();
        findAll(EXPANDED_ROW_KEYS).forEach(detail -> details.put(detail.getText(), detail.findBy(EXPANDED_ROW_VALUES).getAttribute("innerText")));
        return details;
    }
}
