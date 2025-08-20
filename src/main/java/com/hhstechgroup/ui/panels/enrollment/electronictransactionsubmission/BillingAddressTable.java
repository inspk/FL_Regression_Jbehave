package com.hhstechgroup.ui.panels.enrollment.electronictransactionsubmission;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseTable;
import net.serenitybdd.core.pages.WebElementFacade;

public class BillingAddressTable extends BaseTable {

    private static final String COMPANY_NAME = ".//label[contains(text(), 'Software company name')]/parent::div//input";
    private static final String NAME = ".//label[contains(text(), 'Software name')]/parent::div//input";
    private static final String VERSION = ".//label[contains(text(), 'Version')]/parent::div//input";
    private static final String PROTOCOL = ".//label[contains(text(), 'Protocol')]/parent::div//input";

    public BillingAddressTable(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setSoftwareCompanyName(String softwareCompanyName) {
        findBy(COMPANY_NAME).type(softwareCompanyName);
    }

    public void setSoftwareName(String softwareName) {
        findBy(NAME).type(softwareName);
    }

    public void setSoftwareVersion(String softwareVersion) {
        findBy(VERSION).type(softwareVersion);
    }

    public void setSoftwareProtocol(String softwareProtocol) {
        findBy(PROTOCOL).type(softwareProtocol);
    }
}
