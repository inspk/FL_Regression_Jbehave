package com.hhstechgroup.ui.panels.peportal;


import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.KeyValueMapper;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.HashMap;
import java.util.Map;

public class MembersContactInfo extends AbstractPanel implements KeyValueMapper{

    private static final String KEYS = ".//span[contains(@class, 'contacts_title_')]";
    private static final String VALUES = "following-sibling::span";


    public MembersContactInfo(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    @Override
    public Map<String, String> getMappedValues() {
        Map<String, String> pairs = new HashMap<>();
        findAll(KEYS).forEach(kv-> {
            String key = kv.getText().trim();
            String value = kv.findBy(VALUES).getText();
            if (pairs.get(key)!= null) {
                String newKey = key + "1";
                pairs.put(newKey,value );
            }else {
               pairs.put(key,value );
            }
        });
        return pairs;
    }

}
