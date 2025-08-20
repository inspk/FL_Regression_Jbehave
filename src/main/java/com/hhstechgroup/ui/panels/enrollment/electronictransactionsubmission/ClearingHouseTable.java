package com.hhstechgroup.ui.panels.enrollment.electronictransactionsubmission;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseTable;
import net.serenitybdd.core.pages.WebElementFacade;

public class ClearingHouseTable extends BaseTable {

    private static final String CLEARING_HOUSE_NAME = ".//label[contains(text(), 'Agent/Clearing')]/parent::div//input";
    private static final String CLEARING_HOUSE_FIRST_NAME = ".//label[contains(text(), 'Contact first')]/parent::div//input";
    private static final String CLEARING_HOUSE_LAST_NAME = ".//label[contains(text(), 'Contact last')]/parent::div//input";
    private static final String CLEARING_HOUSE_PHONE = ".//label[contains(text(), 'Contact phone number')]/parent::div//input";
    private static final String CLEARING_HOUSE_FIRST_ADDRESS = ".//label[text() = 'Street address']/parent::div//input";
    private static final String CLEARING_HOUSE_SECOND_ADDRESS = ".//label[text() = 'Street address 2']/parent::div//input";
    private static final String CLEARING_HOUSE_CITY = ".//label[text() = 'City']/parent::div//input";
    private static final String CLEARING_HOUSE_STATE = ".//label[contains(@for,'State')]/following-sibling::div//input/preceding-sibling::div";

    public ClearingHouseTable(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setClearingHouseName(String clearingHouseName) {
        findBy(CLEARING_HOUSE_NAME).type(clearingHouseName);
    }

    public void setClearingHouseFirstName(String clearingHouseFirstName) {
        findBy(CLEARING_HOUSE_FIRST_NAME).type(clearingHouseFirstName);
    }

    public void setClearingHouseLastName(String clearingHouseLastName) {
        findBy(CLEARING_HOUSE_LAST_NAME).type(clearingHouseLastName);
    }

    public void setClearingHousePhone(String clearingHousePhone) {
        findBy(CLEARING_HOUSE_PHONE).type(clearingHousePhone);
    }

    public void setClearingHouseFirstAddress(String clearingHouseFirstAddress) {
        findBy(CLEARING_HOUSE_FIRST_ADDRESS).type(clearingHouseFirstAddress);
    }

    public void setClearingHouseCity(String clearingHouseCity) {
        findBy(CLEARING_HOUSE_CITY).type(clearingHouseCity);
    }

    public void setClearingHouseState(String clearingHouseState) {
        int position = getPositionRelatedToSibling(CLEARING_HOUSE_STATE);
        findBy(CLEARING_HOUSE_STATE).click();
        selectFromDropDown(clearingHouseState);
    }
}
