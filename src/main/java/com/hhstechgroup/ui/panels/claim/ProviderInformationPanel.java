package com.hhstechgroup.ui.panels.claim;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProviderInformationPanel extends BaseEnrollmentPanel {

    private static final String PROVIDER_ID = "National provider ID";
    private static final String TAX_ID = "Tax ID";
    private static final String PREFIX = "Prefix";
    private static final String FIRST_NAME = "First name";
    private static final String LAST_NAME = "Last name";
    private static final String MI = "MI";
    private static final String SUFFIX = "Suffix";
    private static final String PHYSICAL_ADDRESS = "Physical address";
    private static final String ZIP = ".//div[@label = 'Zip']//input";

    public ProviderInformationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setNationalProviderID(String providerID) {
        fillField(PROVIDER_ID, providerID);
    }

    public void setTaxID(String providerID) {
        fillField(TAX_ID, providerID);
    }

    public void setPrefix(String prefix) {
        select(PREFIX, prefix);
    }

    public void setFirstName(String firstName) {
        fillField(FIRST_NAME, firstName);
    }

    public void setLastName(String lastName) {
        fillField(LAST_NAME, lastName);
    }

    public void setMI(String mi) {
        fillField(MI, mi);
    }

    public void setSuffix(String suffix) {
        select(SUFFIX, suffix);
    }

    public void setPhysicalAddress(String address) {
        fillField(PHYSICAL_ADDRESS, address);
    }

    public void setZip(String zip) {
        scrollToElement(ZIP);
        findBy(ZIP).type(zip);
    }
}
