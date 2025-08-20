package com.hhstechgroup.ui.panels.enrollment;


import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.servicelocationbilling.ContactPersonTable;
import net.serenitybdd.core.pages.WebElementFacade;

public class MembershipOperationsPanel extends BaseEnrollmentPanel{

    private static final String LOCATION_CONTACT_INFORMATION_TABLE = ".//div[h4[contains(text() , 'Contact Information')]]/following-sibling::div//div[table]/ancestor::div[2]";

    public MembershipOperationsPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public ContactPersonTable getContactPersonTable() {
        scrollToElement(LOCATION_CONTACT_INFORMATION_TABLE);
        return new ContactPersonTable(findBy(LOCATION_CONTACT_INFORMATION_TABLE), getBasePage());
    }

}
