package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.peportal.Table;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class ProviderDataSearchResultsPanel extends AbstractPanel {

    private static final String RESULTS_COLUMNS = ".//div[contains(@class, 'thead_head')]/div";
    private static final String RESULTS_ROWS = ".//div[contains(@class, 'requests_row')]";
    private static final String RESULTS_CELLS = "./div";
    //add after PRMG-2418 private static final String NEXT_RESULTS_BUTTON = "";
    private static final String RESULT_ROW_BY_TEXT = "//div[contains(@class,'table')]//p[contains(text(),'%s')]";
    private static final String SEARCH_BUTTON = ".//button[span[text() = 'Search']]";
    public ProviderDataSearchResultsPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public List<Map<String, String>> getProviderDataSearchResults() {
        waitABit(1000);
        return new Table(getPanelBaseLocation(), getBasePage(), RESULTS_COLUMNS, RESULTS_ROWS, RESULTS_CELLS).getListOfMappedValues();
    }

    public void clickProviderDataRowWithText(String text) {
        waitABit(1000);
//        waitInfo(text, 5);
        waitABit(1000);
        scrollToElement(format(RESULT_ROW_BY_TEXT,text));        //latest
        findBy(format(RESULT_ROW_BY_TEXT, text)).click();
        waitABit(7000);                    //latest
    }


    public void waitInfo(String text, int delay) {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(delay * 1000);
                jsClick(SEARCH_BUTTON);
                if(findBy(format(RESULT_ROW_BY_TEXT,text)).isVisible()){
                   break;
                }else{
                    System.out.println("Row is not displayed yet");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Row is still not displayed");
                if (i == 9) {
                    throw new RuntimeException("Row not found");
                }
            }
        }
    }







    //new
    private static final String RESULTS_COLUMNS1 = ".//div[contains(@class, '-table-head')]//div[span]";
    private static final String RESULTS_ROWS1 = ".//div[contains(@class, 'tile-table-body')]/div//div[contains(@class, '-summary')]";
    private static final String RESULTS_CELLS1 = ".//p";
    public List<Map<String, String>> getResults() {
       waitABit(200);
        return new Table(getPanelBaseLocation(), getBasePage(), RESULTS_COLUMNS1, RESULTS_ROWS1, RESULTS_CELLS1).getListOfMappedValues();
    }

    private static final String EXPANDED_ROW_KEYS  = ".//div[contains(@class, 'detailed-panel')]//div/h4[1]";
    private static final String EXPANDED_ROW_VALUES = "following-sibling::p";
    public Map<String, String> getExpandedRowInfo() {
        Map<String, String> details = new HashMap<>();
        findAll(EXPANDED_ROW_KEYS).forEach(detail -> details.put(detail.getText(), detail.findBy(EXPANDED_ROW_VALUES).getAttribute("innerText")));
        return details;
    }

    //WY-65
    private static final String RESULT_ROW_BY_TEXT1  = "(.//div[contains(@class, 'tile-table-row')]//p)[1]";
    public void clickProviderDataRowWithText1(String text) {
        waitABit(1000);
       // waitInfo(text, 5);
        waitABit(1000);
        scrollToElement(format(RESULT_ROW_BY_TEXT1,text));        //latest
        findBy(format(RESULT_ROW_BY_TEXT1, text)).click();
        waitABit(7000);                    //latest
    }

    private static final String RESULT_ROW = ".//div[contains(@class, 'tile-table-row')]//div[@style='color: %s;']";
    public Boolean verifyStyleColor(String color) {
        waitABit(500);
        return isElementPresent(format(RESULT_ROW, color));
    }
}






