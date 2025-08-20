package com.hhstechgroup.ui.pages.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.iuportal.ProviderInquiryPanel;
import com.hhstechgroup.ui.panels.peportal.MainInfoBlock;
import com.hhstechgroup.ui.panels.peportal.RecordsPanel;
import com.hhstechgroup.ui.panels.peportal.Table;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class ProvidersInquiryPage extends AbstractPage {

    private static final String PROVIDERS_SEARCH = ".//div[contains(@class, '_search-box_')]";
    private static final String PROVIDERS_RECORDS = ".//div[contains(@class, 'tile-table-body')]/parent::div";
    // private static final String PROVIDER_DETAILS = "//div[contains(@class, 'main-info-panel_card_')]";
    private static final String PROVIDER_DETAILS = "//div[contains(@class, 'tile-table sc-')]";
    //private static final String CONNECTED_REQUESTS = "//h4[node() = '%s']/parent::div";
    private static final String CONNECTED_REQUESTS = ".//div[contains(@class, '-table-head')]/..";
    // private static final String REQUESTS_COLUMNS = ".//div[contains(@class, '_header_')]//span[normalize-space(text())]";
    private static final String REQUESTS_COLUMNS = ".//div[contains(@class, '-table-head')]//div[span]";
    // private static final String REQUESTS_ROWS = ".//div[contains(@class, 'one_data_')]/div[contains(@class, 'one_row_')]";
    private static final String REQUESTS_ROWS = "//div[contains(@class, 'tile-table-body')]/div//div[contains(@class, '-summary')]";
    // private static final String REQUESTS_CELLS = ".//span[normalize-space(node())]";
    private static final String REQUESTS_CELLS = ".//p";


    public ProvidersInquiryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchPanelPresent() {
        return isElementPresent(PROVIDERS_SEARCH);
    }

    public RecordsPanel getRecords() {
        return new RecordsPanel(findBy(PROVIDERS_RECORDS), this);
    }

    public Map<String, String> getProviderDetails() {
        return new MainInfoBlock(findBy(PROVIDER_DETAILS), this).getMappedValues();
    }

    public List<Map<String, String>> getRequests(String type) {
        return new Table(findBy(format(CONNECTED_REQUESTS, type)), this, REQUESTS_COLUMNS, REQUESTS_ROWS, REQUESTS_CELLS).getListOfMappedValues();
    }

    //sp23
    private static final String SEARCH_PANEL = ".//div[contains(@class, 'search-box')]";

    public ProviderInquiryPanel getProviderInquiryinfoSearchPanel() {
        return new ProviderInquiryPanel(findBy(SEARCH_PANEL), this);
    }

    //sp47.2.1
    private static final String MASS_UPDATE_BUTTON = ".//div/button[contains(@type,'button')]/span[contains(text(),'MASS UPDATE')]";
    public void clickonMassUpdateButton() {
        waitAbit(200);
        findBy(MASS_UPDATE_BUTTON).click();
        waitAbit(100);
    }
    private static final String SELECT_NPI_CHECKBOX = ".//span/input[contains(@type,'checkbox')]";
    public void clickonnpicheckbox() {
        waitAbit(200);
        scrollToElement(SELECT_NPI_CHECKBOX);
        waitAbit(200);
        findBy(SELECT_NPI_CHECKBOX).click();
        waitAbit(200);
    }

    private static final String BULK_SUSPENSION_BUTTON = ".//div/button[contains(@type,'button')]/span[contains(text(),'Bulk SUSPENSION')]";
    public void clickonBulkSuspensionButton() {
        waitAbit(200);
        findBy(BULK_SUSPENSION_BUTTON).click();
        waitAbit(100);
    }
    private static final String BULK_TERMINATION_BUTTON = ".//div/button[contains(@type,'button')]/span[contains(text(),'Bulk TERMINATION')]";
    public void clickonBulkSTerminationButton() {
        waitAbit(200);
        findBy(BULK_TERMINATION_BUTTON).click();
        waitAbit(100);
    }

    private static final String BULK_TERMINATION_DATE = ".//label[contains(text(),'Effective date *')]/..//div/input[@placeholder='MM/DD/YYYY']";
    public void fillBulkTerminateDate(String bulkterminateDate) {
        jsClick(BULK_TERMINATION_DATE);
        findBy(BULK_TERMINATION_DATE).click();
        findBy(format(BULK_TERMINATION_DATE, bulkterminateDate)).clear();
        waitAbit(2000);
        findBy(format(BULK_TERMINATION_DATE, bulkterminateDate)).type(bulkterminateDate);
    }
    private static final String REASON_FIELD = ".//input[contains(@id, 'Reason')]/preceding-sibling::div" ;
    private static final String  REASON = ".//ul/li[contains(text(),'%s')]" ;
    private static final String  NOTE = ".//label[contains(text(), 'Note')]/../div/div/textarea[3]" ;
    public void setReasonForProviderBulkTermination(String reason,String note) {
        waitAbit(1000);
        jsClick(REASON_FIELD);
        scrollToElement(format(REASON,reason));
        waitAbit(1000);
        findBy(format(REASON, reason)).click();
        waitAbit(1000);
        findBy(NOTE).click();
        findBy(NOTE).type(note);
        waitAbit(1000);
    }
    private static final String CLICK_UPDATE_BUTTON = ".//button/span[contains(text(),'%s')]" ;
    private static final String CLICK_OK_BUTTON = ".//button/span[contains(text(),'OK')]" ;
    public void clickOnUpdateButton(String button){
        findBy(format(CLICK_UPDATE_BUTTON,button)).click();
        findBy(CLICK_OK_BUTTON).click();
    }
}

