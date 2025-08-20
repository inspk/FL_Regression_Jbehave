package com.hhstechgroup.ui.panels.peportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.KeyValueMapper;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.HashMap;
import java.util.Map;

public class FieldsValues extends AbstractPanel implements KeyValueMapper {

    private static final String DEFAULT_KEYS = ".//div[contains(@class, 'field-title_')]";
    private static final String DEFAULT_VALUES = "following-sibling::div";

    private String keys;
    private String values;

    public FieldsValues(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        this(panelBaseLocation, basePage, DEFAULT_KEYS, DEFAULT_VALUES);
    }

    public FieldsValues(WebElementFacade panelBaseLocation, AbstractPage basePage, String keys, String values) {
        super(panelBaseLocation, basePage);
        this.keys = keys;
        this.values = values;
    }

    @Override
    public Map<String, String> getMappedValues() {
        Map<String, String> details = new HashMap<>();
        findAll(this.keys).forEach(detail -> details.put(detail.getText().trim(), detail.findBy(this.values).getText().trim()));
        return details;
    }
}
