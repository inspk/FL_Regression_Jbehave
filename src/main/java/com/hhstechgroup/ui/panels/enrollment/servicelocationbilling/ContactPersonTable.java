package com.hhstechgroup.ui.panels.enrollment.servicelocationbilling;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseTable;
import net.serenitybdd.core.pages.WebElementFacade;

public class ContactPersonTable extends BaseTable {

    private final static String FIRST_NAME = ".//label[contains(text(), 'First name')]/parent::div//input";
    private final static String MI = ".//label[contains(text(), 'MI')]/parent::div//input";
    private final static String LAST_NAME = ".//label[contains(text(), 'Last name')]/parent::div//input";
    private final static String PHONE = ".//label[contains(text(), 'Phone')]/parent::div//input";
    private final static String EXT = ".//label[contains(text(), 'Ext')]/parent::div//input";
    private final static String FAX = ".//label[contains(text(), 'Fax')]/parent::div//input";
    private final static String EMAIL = ".//label[contains(text(), 'Email')]/parent::div//input";
    private final static String POSITION = ".//label[contains(text(), 'Position')]/parent::div//input/preceding-sibling::div";


    public ContactPersonTable(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setPhone(String phone) {
        findBy(PHONE).type(phone);
    }

    public void setFirstName(String firstName) {
        findBy(FIRST_NAME).type(firstName);
    }

    public void setMi(String mi) {
        findBy(MI).type(mi);
    }

    public void setLastName(String lastName) {
        findBy(LAST_NAME).type(lastName);
    }

    public void setExt(String ext) {
        findBy(EXT).type(ext);
    }

    public void setFax(String fax) {
        findBy(FAX).type(fax);
    }

    public void setEmail(String email) {
        findBy(EMAIL).type(email);
    }

    public void setPosition(String position) {
        findBy(POSITION).click();
        selectFromDropDown(position);
    }

}
