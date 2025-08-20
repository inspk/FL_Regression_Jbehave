package com.hhstechgroup.ui.panels.providerData;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.peportal.FieldsValues;
import com.hhstechgroup.ui.panels.peportal.Table;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class ProviderDataHistoryPanel extends AbstractPanel {
    private static final String PROVIDER_DATA_HISTORY_COLUMNS = ".//div[contains(@class, 'head_')]/div[span]";
    private static final String PROVIDER_DATA_HISTORY_ROWS = ".//div[contains(@class, 'table-body')]//div[contains(@class, 'requests_hr-row')]";
    private static final String PROVIDER_DATA_HISTORY_CELLS = "./div/span";
    private static final String VIEW_DETAILS_ROW_KEYS = ".//div[contains(@class, 'requests_history-record_')]/div[contains(@style, 'auto')]//div[contains(@class,'requests_col')]/div[1]";
    private static final String VIEW_DETAILS_ROW_VALUES = "following-sibling::div";
    private static final String VIEW_DETAILS_BY_TYPE = ".//div[span[contains(text(), '%s')]]/following-sibling::div/a";

    public ProviderDataHistoryPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public List<Map<String, String>> getProviderDataHistoryList() {
        waitABit(2000);   //latest
        scrollToElement(format(PROVIDER_DATA_HISTORY_COLUMNS, PROVIDER_DATA_HISTORY_ROWS, PROVIDER_DATA_HISTORY_CELLS)); //latest
        return new Table(getPanelBaseLocation(),getBasePage(), PROVIDER_DATA_HISTORY_COLUMNS, PROVIDER_DATA_HISTORY_ROWS, PROVIDER_DATA_HISTORY_CELLS).getListOfMappedValues();
    }

    public Map<String, String> getViewDetailsRowInfo() {
        return new FieldsValues(getPanelBaseLocation(), getBasePage(), VIEW_DETAILS_ROW_KEYS, VIEW_DETAILS_ROW_VALUES).getMappedValues();
    }

    public void clickViewDetails(String enrollmentType) {
        findBy(format(VIEW_DETAILS_BY_TYPE, enrollmentType)).click();
    }
}
