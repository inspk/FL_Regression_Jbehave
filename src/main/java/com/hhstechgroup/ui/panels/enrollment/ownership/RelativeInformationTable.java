package com.hhstechgroup.ui.panels.enrollment.ownership;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseTable;
import net.serenitybdd.core.pages.WebElementFacade;

public class RelativeInformationTable extends BaseTable {

    private final static String FIRST_NAME = ".//label[contains(text(), 'First name')]/parent::div//input";
    private final static String MI = ".//label[contains(text(), 'MI')]/parent::div//input";
    private final static String LAST_NAME = ".//label[contains(text(), 'Last name')]/parent::div//input";
    private final static String RELATIONSHIP = ".//label[contains(text(), 'Relationship')]/parent::div//input/preceding-sibling::div";
    private final static String SUBCONTRACTOR_NAME = ".//label[contains(text(), 'Subcontractor Name')]/parent::div//input";
    private final static String COUNTRY = ".//label[contains(text(), 'Country')]/parent::div//input/preceding-sibling::div";
    private final static String ADDRESS_LINE1 = ".//label[contains(text(), 'line1')]/parent::div//input";
    private final static String ADDRESS_LINE2 = ".//label[contains(text(), 'line2')]/parent::div//input";
    private final static String CITY = ".//label[contains(text(), 'City')]/parent::div//input";
    private final static String STATE = ".//label[contains(text(), 'State')]/parent::div//input/preceding-sibling::div";
    private final static String ZIP = ".//label[contains(text(), 'Zip')]/parent::div//input";

    public RelativeInformationTable(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
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

    public void setCountry(String country) {
        findBy(COUNTRY).click();
        selectFromDropDown(country);
    }

    public void setSubcontractorName(String subcontractorName) {
        findBy(SUBCONTRACTOR_NAME).type(subcontractorName);
    }

    public void setRelationship(String relationship) {
        findBy(RELATIONSHIP).click();
        selectFromDropDown(relationship);
    }

    public void setAddressLine1(String addressLine1) {
        findBy(ADDRESS_LINE1).type(addressLine1);
    }

    public void setAddressLine2(String addressLine2) {
        findBy(ADDRESS_LINE2).type(addressLine2);
    }

    public void setCity(String city) {
        findBy(CITY).type(city);
    }

    public void setState(String state) {
        findBy(STATE).click();
        selectFromDropDown(state);
    }

    public void setZip(String zip) {
        findBy(ZIP).type(zip);
    }
}
