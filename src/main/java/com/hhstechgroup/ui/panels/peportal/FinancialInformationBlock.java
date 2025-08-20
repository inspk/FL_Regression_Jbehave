package com.hhstechgroup.ui.panels.peportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.Map;

public class FinancialInformationBlock extends AbstractPanel {

    private static final String FIELDS_LIST = ".//div[contains(@class, 'details_field-box')]";

    public FinancialInformationBlock(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public Map<String, String> getFinancialInformation() {
        return new FieldsValues(findBy(FIELDS_LIST), getBasePage()).getMappedValues();
    }
}
