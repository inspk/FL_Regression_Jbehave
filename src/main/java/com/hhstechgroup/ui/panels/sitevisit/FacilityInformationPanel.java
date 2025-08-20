package com.hhstechgroup.ui.panels.sitevisit;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class FacilityInformationPanel extends BaseEnrollmentPanel {

    private static final String ZIP = ".//div[@label = 'Zip Code']//input";

    public FacilityInformationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setZip(String zip) {
        scrollToElement(ZIP);
        findBy(ZIP).type(zip);
    }
}
