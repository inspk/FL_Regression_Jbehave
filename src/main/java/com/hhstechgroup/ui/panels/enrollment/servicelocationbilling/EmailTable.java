package com.hhstechgroup.ui.panels.enrollment.servicelocationbilling;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseTable;
import net.serenitybdd.core.pages.WebElementFacade;

public class EmailTable extends BaseTable {

    private final static String EMAIL_TYPE = ".//label[contains(text(), 'Email type')]/parent::div//input/preceding-sibling::div";
    private final static String EMAIL_ADDRESS = ".//label[contains(text(), 'Email address')]/parent::div//input";


    public EmailTable(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setEmailType(String emailType) {
        findBy(EMAIL_TYPE).click();
        selectFromDropDown(emailType);
    }

    public void setEmailAddress(String address) {
        findBy(EMAIL_ADDRESS).type(address);
    }
}
