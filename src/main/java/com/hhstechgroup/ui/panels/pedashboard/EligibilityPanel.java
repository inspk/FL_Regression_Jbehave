package com.hhstechgroup.ui.panels.pedashboard;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class EligibilityPanel extends AbstractPanel{

    private static final String FORM_FIELDS = ".//label";
    private static final String SERVICE_FORM = ".//button//span[contains(text(), '%s')]";

    public EligibilityPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public List<String> getFormFields() {
        final List<WebElementFacade> collect1 = findAll(FORM_FIELDS).stream().collect(Collectors.toList());
        final List<String> collect = findAll(FORM_FIELDS).stream().map(WebElementFacade::getText).collect(Collectors.toList());
        System.out.println(collect);
        return collect;
    }

    public void clickServiceForm(String form) {
        findBy(String.format(SERVICE_FORM, form)).click();
    }
}
