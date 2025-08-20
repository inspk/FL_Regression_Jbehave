package com.hhstechgroup.ui.panels.builder;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class ElementSettings extends AbstractPanel {

    private static final String FIELD_TYPE = ".//div[contains(@class,'entity_type')]//label[text() = 'Field type']/following-sibling::div";
    private static final String DEFAULT_VALUE = ".//div[text() = 'Default value']/following-sibling::div//input";
    private static final String OPTIONS = ".//div[contains(@class,'active-entity_options')]//textarea";
    private static final String REMOVE_OPTIONS = ".//div[contains(@class,'active-entity_options')]//textarea/preceding-sibling::div//i";
    private static final String PRESENTATION = ".//label[text() = 'Presentation']/following-sibling::div//span[text() = '%s']/preceding-sibling::span";
    private static final String COLUMNS_COUNT = ".//div[contains(@class,'_columns-amount_')]//label[text() = 'In columns']/following-sibling::div";
    private static final String DROP_DOWN_ELEMENT = "//ul/li";
    private static final String COPY_CURRENT_ELEMENT = ".//div[contains(@class, 'active-entity_duplicate')]";
    private static final String COLUMN_NAME = ".//div[contains(@class,'table-properties_label')]//div[text() = '%s']";
    private static final String COLUMN_NAME_TEXTAREA = ".//div[contains(@class,'table-properties_label')]//textarea";
    private static final String HIDE_COLUMN = ".//div[contains(@class,'table-properties_label') and node() = '%s']/following-sibling::div[contains(@class, '_table-options_')]//input";
    private static final String COLUMN_TYPE = ".//div[contains(@class,'table-properties_label') and node() = '%s']/following-sibling::div[contains(node(),'Letter category')]";
    private static final String COLUMN_DROP_DOWN_OPTIONS = ".//div[contains(@class,'table-properties_label') and node() = '%s']/following-sibling::div[contains(@class, '_table-options_')]//textarea";
    private static final String TAB = ".//h3[text() = '%s']";
    private static final String SOURCE_FIELD_SELECT = ".//div[contains(text(), 'Map source')]/following-sibling::div//div[contains(@class, 'Select-control')]";
    private static final String SOURCE_FIELDS_OPTIONS = ".//div[contains(@class, 'Select-menu-outer')]//div/div";
    private static final String DESTINATION_FIELDS = ".//div[contains(text(), 'Map source')]/following-sibling::div//div[contains(@class, 'Select-control')]//div[span]";
    private static final String DATA_MAPPING_MESSAGE = ".//div[contains(@class, 'data-mapping_no-fields-message')]";

    public ElementSettings(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void clickOnTab(String tabName) {
        findBy(format(TAB, tabName)).click();
    }

    public void setDefaultValue(String defaultValue) {
        findBy(DEFAULT_VALUE).type(defaultValue);
    }

    public void setNewColumnName(String oldName, String newName) {
        if (!isElementPresent(COLUMN_NAME_TEXTAREA)) {
            findBy(format(COLUMN_NAME, oldName)).click();
            waitForPresenceOf(COLUMN_NAME_TEXTAREA);
        }
        findBy(COLUMN_NAME_TEXTAREA).type(newName);
        action().sendKeys(Keys.ENTER).build().perform();
    }

    public void copyCurrentElement() {
        WebElementFacade elementFacade = findBy(COPY_CURRENT_ELEMENT);
        action().moveToElement(elementFacade).build().perform();
        elementFacade.click();
    }

    public void selectFieldType(String type) {
        findBy(FIELD_TYPE).click();
        selectFromDropDown(type);
    }

    public void setOptions(List<String> options) {
        setOptions(OPTIONS, options);
    }

    public void setColumnOptions(String columnName, List<String> options) {
        setOptions(format(COLUMN_DROP_DOWN_OPTIONS, columnName), options);
    }

    private void setOptions(String element, List<String> options) {
        options.forEach(opt -> {
            findBy(element).type(opt.concat(";"));
        });
    }

    public void removeOptions() {
        while (findAll(REMOVE_OPTIONS).size() != 0) {
            findAll(REMOVE_OPTIONS).get(0).click();
        }
    }

    public void setPresentation(String presentation) {
        findBy(format(PRESENTATION, presentation)).click();
    }

    public void selectColumnsCount(String count) {
        findBy(COLUMNS_COUNT).click();
        selectFromDropDown(count);
    }

    public void selectTableColumnType(String columnName, String type) {
        findBy(format(COLUMN_TYPE, columnName)).click();
        selectFromDropDown(type);
    }

    public void hideTableColumn(String columnName) {
        findBy(format(HIDE_COLUMN, columnName)).click();
    }

    public List<String> getMappingOptions() {
        findBy(SOURCE_FIELD_SELECT).click();
        List<String> options = findAll(SOURCE_FIELDS_OPTIONS).stream().map(WebElementFacade::getText).collect(Collectors.toList());
        action().sendKeys(Keys.ESCAPE).build().perform();
        return options;
    }

    public void selectMappingDestinationField(String fieldName) {
        findBy(SOURCE_FIELD_SELECT).click();
        findAll(SOURCE_FIELDS_OPTIONS).stream().filter(option -> option.getText().equals(fieldName)).findFirst().get().click();
    }

    public List<String> getAllColumnsCountOptions() {
        findBy(COLUMNS_COUNT).click();
        List<String> options =  findAll(DROP_DOWN_ELEMENT).stream().map(WebElementFacade::getText).collect(Collectors.toList());
        action().sendKeys(Keys.ESCAPE).build().perform();
        waitForAbsenceOf(HIDDEN_ROOT_ELEMENT);
        return options;
    }

    public String getDataMappingMessage() {
        return findBy(DATA_MAPPING_MESSAGE).getText();
    }

    public List<String> getDestinationFields() {
        return findAll(DESTINATION_FIELDS).stream().map(f -> f.getText().trim()).map(f -> f.replaceAll("\n", "")).collect(Collectors.toList());
    }

}
