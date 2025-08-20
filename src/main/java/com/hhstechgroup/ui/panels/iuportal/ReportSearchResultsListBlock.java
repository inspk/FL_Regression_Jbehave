package com.hhstechgroup.ui.panels.iuportal;
import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.peportal.Table;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;
import java.util.Map;

public  class ReportSearchResultsListBlock extends  AbstractPanel {

    private static final String RESULTS = ".//div[contains(@class, 'list_header')]/..";

    private static final String RESULTS_COLUMNS = ".//div[contains(@class, '_header_')]/span";
    private static final String RESULTS_ROWS = ".//div[contains(@class, 'list_content_')]/div";
    private static final String RESULTS_CELLS = ".//span";

    public ReportSearchResultsListBlock(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public List<Map<String, String>> getResults() {
        return new Table(findBy(RESULTS), getBasePage(), RESULTS_COLUMNS, RESULTS_ROWS, RESULTS_CELLS).getListOfMappedValues();
    }

}

