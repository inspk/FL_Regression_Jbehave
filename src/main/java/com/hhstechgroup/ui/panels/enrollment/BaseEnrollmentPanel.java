package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class BaseEnrollmentPanel extends AbstractPanel {

    private static final String TITLE = ".//h3";
    private static final String NEXT_BUTTON = "//button[@id='nextBtn']//span[contains(text(),'Next')]";
    private static final String EDIT = "(//button[@aria-label='%s']//span//*[name()='svg'])[1]";
    private static final String EDIT_ICON = "(//button[@aria-label='%s']//span//*[name()='svg'])[1]";
    private static final String VALUE = ".//h4[text() = '%s']/following-sibling::div";
    private static final String FIELD_VALUE = ".//label[contains(text(), '%s')]/following-sibling::div//input";
    private static final String READ_ONLY_FIELD = "//h4[text()='%s']/../../div";
    private static final String DROP_DOWN = ".//label[contains(text() , '%s')]/following-sibling::div/*";
    private static final String INPUT_FIELD = ".//input[contains(@id, '%s')]";
    private static final String INPUT_FIELD_MODIFIED = ".//label[contains(text(), '%s')]/following-sibling::div//input";
    private static final String DATE_FIELD = ".//input[contains(@id, '%s') and @type='date']";
    private static final String RADIO_BUTTON = ".//span[text() = '%s']/preceding-sibling::span//input[contains(@name, '%s')]";
    private static final String SELECTED_RADIO_BUTTON = ".//input[contains(@name, '%s')]/ancestor::label/span[span]";
    private static final String SELECTED_RADIO_BUTTON_VALUE = "following-sibling::span";
    private static final String SELECTED_OPTION_COLOR = "rgba(33, 150, 243, 1)";
    private static final String CHECKBOX_BY_VALUE = ".//span[contains(text(), '%s')]/..//span//input[@value='%s']";
    private static final String SELECTED_CHECKBOX = ".//label[contains(text(), '%s')]/following-sibling::div//span[input]";
    private static final String SELECTED_CHECKBOX_VALUE = "parent::span/following-sibling::span";
    private static final String CHECKBOX = ".//label[contains(text(), '%s')]/following-sibling::div/label";
    private static final int SECTION_PULL_UP_TIMEOUT_IN_MILLISECONDS = 300;
    private static final String EDITED_FIELD = ".//*[text() = '%s']/parent::div//div";
    private static final String EDITED_VALUE = ".//*[text() = '%s']";
    private static final String EDITED_FIELD_COLOR = "rgba(76, 175, 80, 1)";

    public BaseEnrollmentPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void waitForSectionPulledUp() {
        waitABit(SECTION_PULL_UP_TIMEOUT_IN_MILLISECONDS);
    }

    public void waitForSectionTitleAppeared() {
        getBasePage().withTimeoutOf(Duration.ofSeconds(10)).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE)));
    }

    public void editField(String fieldName) {
        waitFor(ExpectedConditions.elementToBeClickable(findBy(format(EDIT, fieldName))));
        String element = format(EDIT, fieldName);
        String elementOnHover = format(EDIT_ICON,fieldName);
        scrollToElement(element);
        action().moveToElement(findBy(element)).moveToElement(findBy(elementOnHover)).click().build().perform();
    }

    public Map<String, String> getFieldsValuesReadMode(List<String> fields) {
        Map<String, String> fieldsValues = new HashMap<>();
        fields.forEach(field -> {
            String element = format(VALUE, field);
            if (!isElementPresent(element)) {
                scrollToElement(TITLE);
                findBy(TITLE).click();
            }
            fieldsValues.put(field, findBy(element).getText());
        });
        return fieldsValues;
    }

    public void fillField(String fieldName, String text) {
        String field = format(INPUT_FIELD, fieldName);
        scrollToElement(field);
        findBy(field).type(text);
    }

    public void fillModifiedField(String fieldName, String text) {
        String field = format(INPUT_FIELD_MODIFIED, fieldName);
        scrollToElement(field);
        findBy(field).type(text);
    }

    protected void select(String dropDownName, String option) {
        String element = format(DROP_DOWN, dropDownName);
        scrollToElement(element);
        if (!findBy(element).getAttribute("value").isEmpty()) {
            findBy(element).clear();
        }
        selectFromDropDown(dropDownName, option);
    }

    protected void selectFromDropDown(String dropDownName, String option) {
        String element = format(DROP_DOWN, dropDownName);
        scrollToElement(element);
        findBy(element).click();
        selectFromDropDown(option);
    }

    protected void clickOn(String option) {
        scrollToElement(option);
        findBy(option).click();
    }

    public boolean isFieldReadOnly(String field){
        return findBy(format(READ_ONLY_FIELD, field)).getAttribute("class").contains("field_readonly-field_");
    }

    public boolean areFieldsReadOnly(List<String> fields) {
        return fields.stream().allMatch(this::isFieldReadOnly);
    }

    protected void setDateOfBirth(String fieldName, String dateValue) {
        LocalDate date = DateConverter.toLocalDate(dateValue);
        Actions action = new Actions(getDriver());
        findBy(format(DATE_FIELD, fieldName)).click();
        action.sendKeys(String.valueOf(date.getYear())).build().perform();
        action.sendKeys(Keys.ARROW_LEFT).build().perform();
        action.sendKeys(String.valueOf(date.getMonthValue())).build().perform();
        action.sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).build().perform();
        action.sendKeys(String.valueOf(date.getDayOfMonth())).build().perform();
    }

    public void selectRadionButton(String buttonName, String value) {
        clickOn(format(RADIO_BUTTON, value, buttonName));
        waitABit(2000);
    }

    protected void setCheckbox(String checkboxName, String value) {
        clickOn(format(CHECKBOX_BY_VALUE, checkboxName, value));
    }

    public String getRadioButtonValue(String fieldName) {
        return findAll(format(SELECTED_RADIO_BUTTON, fieldName)).stream().filter(radio -> radio.getCssValue("color").equals(SELECTED_OPTION_COLOR)).findFirst().get().findBy(SELECTED_RADIO_BUTTON_VALUE).getText();
    }

    protected String getCheckboxValue(String fieldName) {
        StringBuilder result = new StringBuilder();
        List<WebElementFacade> selectedCheckboxes = findAll(format(SELECTED_CHECKBOX, fieldName)).stream().filter(radio -> radio.getCssValue("color").equals(SELECTED_OPTION_COLOR)).collect(toList());
        selectedCheckboxes.forEach(checkbox -> result.append(checkbox.findBy(SELECTED_CHECKBOX_VALUE).getText()));
        return result.toString().isEmpty() ? null : result.toString();
    }

    public String getFieldValue(String fieldName) {
        String field = format(FIELD_VALUE, fieldName);
        scrollToElement(field);
        return findBy(field).getValue();
    }

    public void clearField(String fieldName) {
        String field = format(FIELD_VALUE, fieldName);
        scrollToElement(field);
        findBy(field).clear();
    }

    public void clickNextButton() {
        waitABit(300);
        scrollToElement(NEXT_BUTTON);
        findBy(NEXT_BUTTON).click();
    }

    public boolean areFieldsHighlighted(List<String> fields) {
        scrollToElement(TITLE);
        clickOnTitle();
        return fields.stream().allMatch(field -> findBy(format(EDITED_FIELD, field)).getCssValue("color").equals(EDITED_FIELD_COLOR));
    }

    public boolean areReadOnlyValuesHighlighted(List<String> values) {
        scrollToElement(TITLE);
        clickOnTitle();
        return values.stream().allMatch(value -> findBy(format(EDITED_VALUE, value)).getCssValue("color").equals(EDITED_FIELD_COLOR));
    }

    public void clickOnTitle() {
        findBy(TITLE).click();
    }

    public List<List<String>> getOptionsInDisplayedOrder(String name, int columnsNumber) {
        List<List<String>> options = new ArrayList<>();
        List<WebElementFacade> elements = findAll(format(CHECKBOX, name));
        for (int i = 1; i <= columnsNumber; i++) {
            List<String> elementsInColumn = new ArrayList<>();
            for (int j = i; j <= elements.size(); j += columnsNumber) {
                elementsInColumn.add(elements.get(j - 1).getText());
            }
            options.add(elementsInColumn);
        }
        return options;
    }

    //WY-65
    private static final String EDIT1 = "(//button[@aria-label='%s']//span//*[name()='svg'])[1]";
    private static final String EDIT_ICON1 = "(//button[@aria-label='%s']//span//*[name()='svg'])[1]";
    public void editField1(String fieldName) {
        waitFor(ExpectedConditions.elementToBeClickable(findBy(format(EDIT1, fieldName))));
        String element = format(EDIT1, fieldName);
        String elementOnHover = format(EDIT_ICON1,fieldName);
        scrollToElement(element);
        action().moveToElement(findBy(element)).moveToElement(findBy(elementOnHover)).click().build().perform();
    }
}
