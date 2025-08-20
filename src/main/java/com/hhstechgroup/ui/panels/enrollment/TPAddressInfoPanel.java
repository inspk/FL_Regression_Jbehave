package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

public class TPAddressInfoPanel extends BaseEnrollmentPanel {

    private static final String PROVIDER_ADDRESS = "Address";
    private static final String BUILDING_SUITE = "PO box, building, suite, etc";
    private static final String ZIP="Zip";

    public TPAddressInfoPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setProviderAddress(String providerAddress ){
        fillField(PROVIDER_ADDRESS,providerAddress); }

    public void setBuilding(String building) {
        fillField(BUILDING_SUITE,building);
    }
    public void setZip(String zip) {
        fillField(ZIP,zip);
        waitABit(500);
    }
}


