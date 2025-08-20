package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class AddressAutoCompletePanel extends AbstractPanel {

    private static final String ADDRESS_AUTOCOMPLETE_LIST = "//ul[@role='listbox']/li";
    private static final String ADDRESS_AUTOCOMPLETE_VARIANT = "//ul[@role='listbox']/li/div/div";

    public AddressAutoCompletePanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void selectFirstAddress() {
        findAll(ADDRESS_AUTOCOMPLETE_VARIANT).get(0).click();
        if (isElementPresent(ADDRESS_AUTOCOMPLETE_LIST)) {
            findAll(ADDRESS_AUTOCOMPLETE_VARIANT).get(0).click();
        }
        waitForAbsenceOf(ADDRESS_AUTOCOMPLETE_LIST);
    }

    public boolean isNoMatchesMessageDisplayed(String message) {
        List<WebElementFacade> variants = getBasePage().findAll(ADDRESS_AUTOCOMPLETE_LIST);
        return getBasePage().waitForCondition().until(driver -> variants.size() == 1 && variants.get(0).getText().equals(message));
    }
}
