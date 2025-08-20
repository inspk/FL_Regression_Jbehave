package com.hhstechgroup.ui.panels.peportal;


import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.KeyValueMapper;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.HashMap;
import java.util.Map;

public class AllergiesAndImmunizations extends AbstractPanel implements KeyValueMapper{

    private static final String KEYS = ".//span[contains(@class, 'details_head_')]";
    private static final String VALUES = "..//li";

    public AllergiesAndImmunizations(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    @Override
    public Map<String, String> getMappedValues() {
        Map<String, String> details = new HashMap<>();
        findAll(KEYS).stream().forEach(detail -> details.put(detail.getText(), detail.findBy(VALUES).getText()));
        return details;
    }
}
