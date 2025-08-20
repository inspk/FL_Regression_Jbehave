package com.hhstechgroup.ui.pages.peportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.peportal.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;
import static java.util.stream.Collectors.*;


public class AuthorizationPage extends AbstractPage {

    private static final String AUTHORIZATION_SEARCH = ".//div[contains(@class, 'search-box-container')]";
    private static final String AUTHORIZATION_REQUEST = "//div[contains(@class, 'main-info-panel_card_')]";
    private static final String RECORDS = ".//div[contains(@class, 'list-table_')]";
    private static final String SEARCH = ".//div[contains(@class, 'list_auth-show-search-box')]";
    private static final String AUTH_REQUESTS = "//div[@class='wr']/div[4]";
    private static final String AUTH_COLUMNS = "//ancestor-or-self::div[@class='wr']/div[4]/div[1]/div";
    private static final String AUTH_ROWS = "//div[contains(@class, 'expansion-panel-summary')]/div";
    private static final String AUTH_CELLS = ".//div[contains(@class, 'table-text_table')]";
    private static final String SEARCH_BUTTON = ".//button[span[text() = 'Search']]";
    private static final String PAGE_TITLE = ".//div[contains(@class, 'main-info-panel_card-heading')]//span";
    private static final String AUTH_INFO_MAIN = "//div[contains(@class, 'main-info-panel_column')][1]";
    private static final String SERVICE_ITEM_DETAILS = "//h2/following-sibling::div";
    private static final String SERVICE_ITEM_HEADER = "//h2/following-sibling::div/div[1]/div";
    private static final String SERVICE_ITEM_ROWS_DETAILS = "//div[contains(@class, 'expansion-panel-summary')]";
    private static final String SERVICE_ITEM_CELLS_DETAILS = "./div/div";
    private static final String EXPAND_BUTTON = ".//div[text()='%s']/../../..//button[@aria-label='Expand More']";
    private static final String DETAILS_KEYS = ".//p[contains(@class, 'list-details')]";
    private static final String DETAILS_VALUES = "following-sibling::*";
    private static final String SERVICE_ITEM = ".//div[contains(@class, 'list_auth-list-tbody')]//div[contains(@class, 'list_auth-list-table')]";
    private static final String SERVICE_ITEM_ROWS = ".//div[contains(@class, 'list_child')][2]//div[contains(@class, 'list_list-item')]";
    private static final String SERVICE_ITEM_CELLS = ".//div[contains(@class, 'list_child')][2]//div[contains(@class, 'list_list-item')]/span";



    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public Map<String, String> getAuthorizationRequestInfo() {
        Map<String, String> info = new MainInfoBlock(findBy(AUTHORIZATION_REQUEST), this).getMappedValues();
        return info.entrySet().stream().collect(toMap(Map.Entry::getKey, entry -> entry.getValue().replaceAll("\\n", " ")));
    }

    public boolean isSearchPanelPresent() {
        return isElementPresent(AUTHORIZATION_SEARCH);
    }


    public SearchForRecordPanel getSearchPanel() {
        return new SearchForRecordPanel(findBy(AUTHORIZATION_SEARCH), this);
    }

    public RecordsPanel getRecords() {
        return new RecordsPanel(findBy(RECORDS), this);
    }

    public void expandSearchBox(){
        findBy(SEARCH).click();
    }

    public List<Map<String, String>> getAuthRequest() {
        return new Table(findBy(AUTH_REQUESTS), this, AUTH_COLUMNS, AUTH_ROWS, AUTH_CELLS).getListOfMappedValues();
    }

    public void clickSearch(){
        findBy(SEARCH_BUTTON).click();
    }

    public void navigateToAuthRequestDetails(){
        waitAbit(5000);
        scrollToElement(AUTH_ROWS);
        findBy(AUTH_ROWS).click();
    }

    public boolean isCorrectTitleDisplayed(String title){
        return findBy(PAGE_TITLE).getText().contains(title);
    }

    public MainInfoBlock getAuthInformation() {
        return new MainInfoBlock(findBy(AUTH_INFO_MAIN), this);
    }

    public List<Map<String, String>> getProceduresAndServices() {
        return new Table(findBy(SERVICE_ITEM_DETAILS), this, SERVICE_ITEM_HEADER, SERVICE_ITEM_ROWS_DETAILS, SERVICE_ITEM_CELLS_DETAILS).getListOfMappedValues();
    }
    public List<Map<String, String>> getProcedures() {
        return new Table(findBy(SERVICE_ITEM), this, SERVICE_ITEM_HEADER, SERVICE_ITEM_ROWS, SERVICE_ITEM_CELLS).getListOfMappedValues();
    }

    public void expandServicesDetails(String cptCode){
        findBy(format(EXPAND_BUTTON, cptCode)).click();
    }

    public Map<String, String> getMappedValues() {
        Map<String, String> details = new HashMap<>();
        findAll(DETAILS_KEYS).forEach(detail -> details.put(detail.getText().trim(), detail.findBy(DETAILS_VALUES).isVisible() ? detail.findBy(DETAILS_VALUES).getText().trim() : ""));
        return details;
    }
    public void authorizedSignatoryName(String authorizedSignatoryName){
        waitABit(2000);
        findBy(format(AUTHORIZED_SIGNATORY_NAME,authorizedSignatoryName)).click();
        waitAbit(1000);
        findBy(SELECT_AUTHORIZED_SIGNATORY_NAME).click();
        waitAbit(3000);
    }
    private static final String AUTHORIZED_SIGNATORY_NAME="//input[@name='%s']";
    private static final String VERIFY_AUTHORIZED_SIGNATORY_NAME="//div[contains(@id,'Authorized Signatory')]//ul//li//div//div//strong[contains(text(),'%s')]";
    private static final String SELECT_AUTHORIZED_SIGNATORY_NAME="(//div[contains(@id,'Authorized Signatory')]//ul//li//div)[1]";
    public void VerifyNameAndSelectauthorizedSignatoryName(String value,String authorizedSignatoryName){
        waitABit(2000);
        findBy(format(AUTHORIZED_SIGNATORY_NAME,authorizedSignatoryName)).click();
        waitAbit(3000);
        WebElement element = findBy(format(VERIFY_AUTHORIZED_SIGNATORY_NAME, value));
        if (element.isDisplayed() && element.getText().trim().equals(value)) {
            System.out.println("Found expected text");
            element.click();
            waitABit(1000);
        } else {
            throw new AssertionError("Expected text '" + value + "' not found.");
        }
        waitAbit(3000);
    }
}
