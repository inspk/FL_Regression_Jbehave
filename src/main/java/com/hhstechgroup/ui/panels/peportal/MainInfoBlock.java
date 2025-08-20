package com.hhstechgroup.ui.panels.peportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.KeyValueMapper;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.Map;
import java.util.stream.Collectors;

public class MainInfoBlock extends AbstractPanel implements KeyValueMapper {

    private static final String TITLE = ".//span";
    private static final String BUTTON = ".//button";
    private static final String DELETE_APPLICATION = ".//span[contains(text(), 'Delete Application')]";
    private static final String KEYS = ".//h4";
    private static final String VALUES_IU_PORTAL = ".//following-sibling::p";
    private static final String VALUES = ".//following-sibling::div";
    private static final String CLAIM_VALUES = ".//following-sibling::p";

    private static final String AFFILIATION_DETAILS_LINK = ".//div[contains(@class, 'dashboard_collapse-trigger')]";

    public MainInfoBlock(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    @Override
    public Map<String, String> getMappedValues() {
        return findAll(KEYS).stream().collect(Collectors.toMap(key -> key.getText().trim(), key -> key.findBy(VALUES).getText().replaceAll("\\n", " ")));
    }

    public Map<String, String> getMappedValuesOnIuPortal() {
        return findAll(KEYS).stream().collect(Collectors.toMap(key -> key.getText().trim(), key -> key.findBy(VALUES_IU_PORTAL).getText().replaceAll("\\n", " ")));
    }

    public Map<String, String> getClaimMappedValues() {
        return findAll(KEYS).stream().collect(Collectors.toMap(key -> key.getText().trim(), key -> key.findBy(CLAIM_VALUES).getText().replaceAll("\\n", " ")));
    }

    public String getTitle() {
        return findBy(TITLE).getText();
    }

    public boolean isButtonDisplayed(String title) {
        return findAll(BUTTON).size() == 1 && findBy(BUTTON).getText().equalsIgnoreCase(title);
    }

    public boolean isDeleteApplicationButtonDisplayed() {
        return isElementPresent(DELETE_APPLICATION);
    }
    public void clickAffiliationDetailsLink() {
         findBy(AFFILIATION_DETAILS_LINK).click();
    }

    public void clickOnButton() {
        scrollToElement(BUTTON);
        findBy(BUTTON).waitUntilClickable().click();
    }

    public void clickDeleteApplication() {
        findBy(DELETE_APPLICATION).click();
    }
}
