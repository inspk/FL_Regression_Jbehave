package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class AutoAssignSearchPanel extends AbstractPanel {

    private static final String EFFECTIVE_FROM_DATE =".//div[contains(@class,'auto-assign_aa-list-itme-inner_')]/div[6]";
    private static final String EFFECTIVE_END_DATE=".//div[contains(@class,'auto-assign_aa-list-itme-inner_')]/div[7]";

    public AutoAssignSearchPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public Map<String, String> getMappedDateValues() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("EFFECTIVE FROM", (findBy(format(EFFECTIVE_FROM_DATE))).getText());
        map.put("EFFECTIVE END", (findBy(format(EFFECTIVE_END_DATE))).getText());
        return map;
    }

//sp24
    private static final String START_DATE =".//div[contains(@class, 'auto-assign_row_')]/span[2]";
    private static final String END_DATE=".//div[contains(@class, 'auto-assign_row_')]/span[3]";

    public Map<String, String> getMappedEffectiveDateValues() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("START", (findBy(format(START_DATE))).getText());
        map.put("END", (findBy(format(END_DATE))).getText());
        return map;
    }

    private static final String UPDATED_ON =".//div[contains(@class, 'auto-assign_row_')]/span[1]";
    public Map<String, String> getMappedUpdatedDateValues() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("UPDATED_DATE", (findBy(format(UPDATED_ON))).getText());
        return map;
    }
}
