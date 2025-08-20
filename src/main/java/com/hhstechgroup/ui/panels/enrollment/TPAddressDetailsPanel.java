package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

public class TPAddressDetailsPanel extends BaseEnrollmentPanel {

    private static final String PROVIDER_NAME = "Provider name";
    private static final String PROVIDER_ADDRESS = "Physical Address (P.O. box not accepted)";
    private static final String BUILDING_SUITE = "Building, Suite";
    private static final String ZIP = ".//div[@label = 'Zip']//input";

    public TPAddressDetailsPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    public String setProviderName() {
        return getFieldValue(PROVIDER_NAME);
    }

    public void setProviderAddress(String providerAddress ){
        fillField(PROVIDER_ADDRESS,providerAddress); }

    public void setBuilding(String building) {
        fillField(BUILDING_SUITE,building);
    }

    public void setZip(String zip) {
        findBy(ZIP).type(zip);
        waitABit(500);
    }
}


