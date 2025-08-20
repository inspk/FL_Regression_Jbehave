package com.hhstechgroup.ui.panels.pedashboard;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.KeyValueMapper;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class EnrollmentInfoPanel extends AbstractPanel implements KeyValueMapper{

    private static final String ENROLLMENT_INFO = ".//p[contains(@class, 'row')]/span";
    private static final String VIEW_DETAILS = ".//span[contains(text(), 'View details')]";

    public EnrollmentInfoPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public Map<String, String> getMappedValues() {
        final List<String> enrollmentInfo = findAll(ENROLLMENT_INFO).stream().map(WebElementFacade::getText).collect(toList());
        final Map<String, String> table = new HashMap<>();
        String key = "";
        for (int i = 0; i < enrollmentInfo.size(); i++) {
            if (i % 2 == 0) {
                key = enrollmentInfo.get(i);
            } else {
                table.put(key, enrollmentInfo.get(i));
            }
        }
        return table;
    }

    public void clickViewDetails() { findBy(VIEW_DETAILS).click(); }

}
