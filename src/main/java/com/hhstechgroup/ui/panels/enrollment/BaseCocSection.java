package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

import static java.lang.String.format;

public class BaseCocSection extends BaseEnrollmentPanel {

    private static final String SECTION_HEADER = "//div[contains(@class, 'section-header_')]/h3";
    private static final String FIELD_NAME = ".//div[contains(@class, 'section-group_')]//label[contains(text(), '%s')]";
    private static final int SECTION_HEADER_POSITION = 195;

    private BaseCocSection(WebElementFacade panelBaseLocation, AbstractPage basePage, String title) {
        super(panelBaseLocation, basePage);
    }

    public BaseCocSection(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        this(panelBaseLocation, basePage, SECTION_HEADER);
    }

    public void waitForSectionAppeared() {
        waitForElementPulledUp(SECTION_HEADER, SECTION_HEADER_POSITION);
    }

    public String getSectionHeader() {
        return findBy(SECTION_HEADER).getText();
    }

    public boolean areFieldsPresent(List<String> fields) {
        return fields.stream().allMatch(field -> isElementPresent(format(FIELD_NAME, field)));
    }
}
