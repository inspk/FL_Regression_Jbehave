package com.hhstechgroup.ui.panels.providersearch;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchMapPanel extends AbstractPanel {

    private static final String PROVIDER_LOCATION = ".//img[contains(@class, 'leaflet-marker-icon') and not(contains(@src, 'home'))]";
    private static final String PROVIDERS_LOCATION = ".//div[contains(@class, 'leaflet-marker-icon')]//span";

    public SearchMapPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public int getLocationsCount() {
        int count = 0;
        for (WebElementFacade location : findAll(PROVIDERS_LOCATION)) {
            count += Integer.parseInt(location.getText());
        }
        return findAll(PROVIDER_LOCATION).size() + count;
    }
}
