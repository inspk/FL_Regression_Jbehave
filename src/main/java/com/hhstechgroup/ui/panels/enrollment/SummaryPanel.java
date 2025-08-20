package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class SummaryPanel extends BaseEnrollmentPanel {

    private static final String FIRST_NAME = ".//input[contains(@id, 'First name')]";
    private static final String LAST_NAME = ".//input[contains(@id, 'Last name')]";
    private static final String PROCEED_BUTTON = "//button[span[text() = 'PROCEED TO SIGN']]";
    private final static String SECTION_HEADER = ".//div[contains(@class, 'diffs_section-name') and text() = '%s']";
    private final static String SECTION = ".//div[contains(@class, 'diffs_section-name')]";
    private final static String BUTTON_DISABLED = ".//button[span[text()='%s'] and @disabled]";
    private final static String FIELD_NEW_VALUE = ".//div[contains(@class, 'field-name_') and text() = '%s']/following-sibling::div/span[contains(@class, 'current-value')]";
    private final static String FIELD_OLD_VALUE = ".//div[contains(@class, 'field-name_') and text() = '%s']/following-sibling::div/span[contains(@class, 'previous-value')]";
    private static final String SUBMIT_BUTTON = "//button[span[text() = 'SUBMIT']]";
    private static final String PREPOPULATED_FIELD = "//label[contains(text(), '%s')]/parent::div//input";

    public SummaryPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setFirstName(String firstName) {
        fillField(FIRST_NAME, firstName);
    }

    public void setLastName(String lastName) {
        fillField(LAST_NAME, lastName);
    }

    public void clickProceedButton() {
        scrollToElement(PROCEED_BUTTON);
        waitABit(300);
        jsClick(PROCEED_BUTTON);
        waitABit(9000);
    }
    private static final String PROCEED_BUTTON1 = "//button[span[text() = 'Sign']]";
    public void clickProceedButton1() {
        scrollToElement(PROCEED_BUTTON1);
        waitABit(500);
        findBy(PROCEED_BUTTON1).click();
        waitABit(500);
    }
    public void clickSubmitButton() {
        waitABit(500);
        scrollToElement(SUBMIT_BUTTON);
        waitABit(700);
        jsClick(SUBMIT_BUTTON);
       // findBy(SUBMIT_BUTTON).click();
    }

    public boolean isSectionDisplayed(String section) {
        return isElementPresent(format(SECTION_HEADER, section));
    }

    public String getFieldNewValue(String field) {
        return findBy(format(FIELD_NEW_VALUE, field)).getText();
    }

    public String getFieldOldValue(String field) {
        return findBy(format(FIELD_OLD_VALUE, field)).getText();
    }

    public boolean isSectionPresent() {
        return isElementPresent(SECTION);
    }

    public boolean isButtonDisabled(String button) {
        return isElementPresent(format(BUTTON_DISABLED, button));
    }

    public String getPrepopulatedData(String field) {
        return findBy(format(PREPOPULATED_FIELD, field)).getValue();
    }

    private static final String SIGN_SUBMIT_BUTTON = "//button[span[text() = 'SIGN / SUBMIT']]";
    public void clickSignSubmit() {
        waitABit(500);
        scrollToElement(SIGN_SUBMIT_BUTTON);
        waitABit(700);
        jsClick(SIGN_SUBMIT_BUTTON);
        // findBy(SIGN_SUBMIT_BUTTON).click();
    }

}
