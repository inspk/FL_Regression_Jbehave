package com.hhstechgroup.ui.panels.pedashboard;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentsList extends AbstractPanel {

    private static final String TABS = ".//div[contains(@class, 'details_header')]//div[contains(@class, 'col')]";

    public PaymentsList(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public List<String> getTabs() {
        return findAll(TABS).stream().map(WebElementFacade::getText).filter(text -> !text.isEmpty()).collect(Collectors.toList());
    }
}
