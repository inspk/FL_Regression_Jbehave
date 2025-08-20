package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LeftMenuPanel extends AbstractPanel {

    private static final String SECTION = ".//div[contains(@class, 'menu-item')]/span[text() = '%s']";
    private static final String SECTIONS = ".//div[contains(@class, 'menu-item')]";

    public LeftMenuPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void clickOnSection(String section) {
        String element = String.format(SECTION, section);
//        waitForPresenceOf(element);
        scrollToElement(element);
//        findBy(element).click();
        jsClick(element);
    }

    //sp29
    private static final String SECTION1 = ".//div[contains(@class, 'menu-item')]/span[text() = '%s']";
    public void clickOnSection1(String section) {
        String element = String.format(SECTION1, section);
//        waitForPresenceOf(element);
        scrollToElement(element);
//        findBy(element).click();
        jsClick(element);
    }

    public List<String> getSections() {
        waitForPresenceOf(SECTIONS);
        return findAll(SECTIONS).stream().map(WebElementFacade::getText).collect(toList());
    }

    public boolean isSectionDisabled(String section) {
        return findBy(String.format(SECTION, section)).getAttribute("class").contains("disabled");
    }

    public boolean isSectionActive(String section) {
        return findBy(String.format(SECTION, section)).getAttribute("class").contains("active");
    }

    public boolean isSectionPresent(String sectionName) {
        return getSections().stream().anyMatch(s -> s.equals(sectionName));
    }

    //sp42.3
    private static final String SECTION2 = ".//div//span[text()='%s']";
    public void clickOnSection2(String section) {
        String element = String.format(SECTION2, section);
        waitForPresenceOf(element);
        scrollToElement(element);
        waitABit(500);
        findBy(element).click();
        waitABit(500);
    }
}
