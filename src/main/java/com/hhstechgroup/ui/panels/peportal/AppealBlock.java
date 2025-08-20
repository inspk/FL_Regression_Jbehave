package com.hhstechgroup.ui.panels.peportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.KeyValueMapper;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.Map;

public class AppealBlock extends AbstractPanel implements KeyValueMapper {

    private static final String KEYS = ".//h4";
    private static final String VALUES = "following-sibling::*";
    private static final String BUTTON = ".//button";

    public AppealBlock(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    @Override
    public Map<String, String> getMappedValues() {
        return new FieldsValues(getPanelBaseLocation(), getBasePage(), KEYS, VALUES).getMappedValues();
    }

    public void clickOnButton() {
        scrollToElement(BUTTON);
        findBy(BUTTON).click();
    }

}
