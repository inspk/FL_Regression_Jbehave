package com.hhstechgroup.ui.panels.enrollment.servicelocationbilling;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseTable;
import net.serenitybdd.core.pages.WebElementFacade;

public class PhoneFaxTable extends BaseTable {

    private final static String PHONE = ".//label[contains(text(), 'Phone')]/parent::div//input";
    private final static String FAX = ".//label[contains(text(), 'Fax')]/parent::div//input";

    public PhoneFaxTable(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setPhone(String phone) {
        findBy(PHONE).type(phone);
    }

    public void setFax(String fax) {
        findBy(FAX).type(fax);
    }
}
