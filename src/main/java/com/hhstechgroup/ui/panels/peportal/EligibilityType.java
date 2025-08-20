package com.hhstechgroup.ui.panels.peportal;


import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.KeyValueMapper;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.By.xpath;

public class EligibilityType extends AbstractPanel implements KeyValueMapper {

    private static final String KEY_VALUE_CONTAINER = ".//div[contains(@class, 'details_status-details-i')]";

    public EligibilityType(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    @Override
    public Map<String, String> getMappedValues() {
        Map<String, String> pairs = new HashMap<>();
        findAll(KEY_VALUE_CONTAINER).stream().map(kvContainer -> kvContainer.thenFindAll(xpath("span")))
                .forEach(kv -> pairs.put(kv.get(0).getText(), kv.get(1).getAttribute("innerHTML")));
                return pairs;
    }
}
