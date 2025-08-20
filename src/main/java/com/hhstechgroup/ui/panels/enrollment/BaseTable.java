package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.peportal.Table;
import net.serenitybdd.core.pages.PageUrls;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class BaseTable extends AbstractPanel {

    private final static String ADD_LINE = ".//button[span[text() = '+ Add Line']]";
    private final static String SAVE = ".//button[span[text() = 'Save']]";
    private final static String CANCEL = ".//button[span[text() = 'Cancel']]";
    private final static String INPUT = ".//input[contains(@id, '%s')]";
    private final static String DROP_DOWN = ".//input[contains(@id, '%s')]/preceding-sibling::div";
    private final static String DEFAULT_TABLE_LOCATION = "//table/ancestor::div[3]";
    private final static String HEADERS = ".//thead//th";
    private final static String SETTINGS_BUTTON = ".//div[@class='settings']//button";
    private final static String SETTINGS_CHECKBOX = "//span[text() = '%s']/preceding-sibling::span//input";
    private final static String ROWS = ".//tbody//tr";
    private final static String CELLS = "./td//span";

    public BaseTable(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public BaseTable(AbstractPage basePage) {
        super(DEFAULT_TABLE_LOCATION, basePage);
    }

    public void clickAddRow() {
        scrollToElement(ADD_LINE);
        waitABit(500);
        //findBy(ADD_LINE).click();
        //sp20
        jsClick(ADD_LINE);
    }
    public void clickSave() {
        findBy(SAVE).click();
    }
    public void clickCancel() {
        findBy(CANCEL).click();
    }
    public void setField(String locator, String position, String value) {
        action().moveToElement(findBy(format(locator, position))).sendKeys(value).build().perform();
    }
    public List<String> getHeaders() {
        return findAll(HEADERS).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }
    public void clickOnHeader(String headerName) {
        scrollToElement(HEADERS);
        findAll(HEADERS).stream().filter(header -> header.getText().equals(headerName)).findFirst().get().click();
        action().moveToElement(findBy(ADD_LINE)).build().perform();
    }
    public void showTableColumn(String columnName) {
        findBy(SETTINGS_BUTTON).click();
        findBy(format(SETTINGS_CHECKBOX, columnName)).click();
        action().sendKeys(Keys.ESCAPE).build().perform();
        waitForAbsenceOf(HIDDEN_ROOT_ELEMENT);
    }
    public void setField(String fieldName, String value) {
        scrollToElement(format(INPUT, fieldName));
        findBy(format(INPUT, fieldName)).type(value);
    }
    public void select(String fieldName, String value) {
        scrollToElement(format(DROP_DOWN, fieldName));
        findBy(format(DROP_DOWN, fieldName)).click();
        selectFromDropDown(value);
    }

    public List<Map<String, String>> getTableData() {
        return new Table(getPanelBaseLocation(), getBasePage(), HEADERS, ROWS, CELLS).getListOfMappedValues();
    }
}
