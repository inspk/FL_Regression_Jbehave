package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.KeyValueMapper;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class RequestsPanel extends AbstractPanel implements KeyValueMapper {

    private static final String REQUESTS_LIST_DASHBOARD = ".//div[contains(@class, '_table-body_')]";
    private static final String TABS_DASHBOARD = ".//div[contains(@class, '_head')]//div/span";
    private static final String REQUEST = ".//p[text() = '%s']/ancestor::div[contains(@class, 'text_table-text')][1]/ancestor::div[contains(@class, '-row')]";
    private static final String COLUMNS = ".//parent::div/parent::div//div[contains(@class, 'tile-table-head')]/div";
    private static final String COC_COLUMNS_DETAILS = ".//div[contains(@class, 'expansion-panel-details')]//div[contains(@class, 'tile-table-head')]/div";
    private static final String ROWS = ".//div[contains(@class, 'tile-table-body')]/div";
    private static final String COC_ROWS_DETAILS = ".//div[contains(@class, 'expansion-panel-details')]//div[contains(@class, 'tile-table-body')]/div";
    private static final String CELLS = ".//div[contains(@class, 'table-text_table-text')]";
    private static final String CELL_TEXT = ".//p";
    private WebElementFacade row;

    public RequestsPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public boolean isRequestsListPresentOnDashboard() {
        waitForAbsenceOf(SPINNER);
        return isElementPresent(REQUESTS_LIST_DASHBOARD);
    }

    public List<String> getTabsOnDashboard() {
        return findAll(TABS_DASHBOARD).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    public RequestPanel getRequestById(String id) {
        return new RequestPanel(findBy(String.format(REQUEST, id)), getBasePage());
    }

    public boolean isRequestFound(String id) {
        waitForAbsenceOf(SPINNER);
        return isElementPresent(String.format(REQUEST, id));

    }

    @Override
    public List<Map<String, String>> getListOfMappedValues() {
        return findAll(ROWS).stream().map(row -> {
            this.row = row;
            return getMappedValues();
        }).collect(toList());
    }

    @Override
    public Map<String, String> getMappedValues() {
        Map<String, String> paymentDetails = new HashMap<>();
        findAll(COLUMNS).forEach(detail -> paymentDetails.put(detail.getText().replaceAll("&amp;", "&"), getVisibleText(row.thenFindAll(CELLS).get(getPositionRelatedToSibling(detail) - 1))));
        return paymentDetails;
    }


    public List<Map<String, String>> getListOfMappedValuesInCoCDetails() {
        return findAll(COC_ROWS_DETAILS).stream().map(row -> {
            this.row = row;
            return getMappedValuesInCocDetails();
        }).collect(toList());
    }

    public Map<String, String> getMappedValuesInCocDetails() {
        Map<String, String> paymentDetails = new HashMap<>();
        findAll(COC_COLUMNS_DETAILS).forEach(detail -> paymentDetails.put(detail.getText().replaceAll("&amp;", "&"), getVisibleText(row.thenFindAll(CELLS).get(getPositionRelatedToSibling(detail) - 1))));
        return paymentDetails;
    }

    private String getVisibleText(WebElementFacade element) {
        return element.thenFindAll(CELL_TEXT).stream().filter(WebElementFacade::isCurrentlyVisible).map(el -> el.getText().replaceAll("\\n", " ")).collect(Collectors.joining(" "));
    }
}
