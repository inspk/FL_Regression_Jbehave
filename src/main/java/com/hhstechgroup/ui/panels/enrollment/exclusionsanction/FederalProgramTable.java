package com.hhstechgroup.ui.panels.enrollment.exclusionsanction;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseTable;
import net.serenitybdd.core.pages.WebElementFacade;

public class FederalProgramTable extends BaseTable {

    private final static String FEDERAL_PROGRAM = ".//label[contains(text(), 'Federal program')]/parent::div//input";
    private final static String BUSINESS_NAME = ".//label[contains(text(), 'Business name')]/parent::div//input";
    private final static String FIRST_NAME = ".//label[contains(text(), 'First name')]/parent::div//input";
    private final static String MI = ".//label[contains(text(), 'MI')]/parent::div//input";
    private final static String SUFFIX = ".//label[contains(text(), 'Suffix')]/parent::div//input/preceding-sibling::div";

    public FederalProgramTable(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setFederalProgramName(String federalProgramName) {
        findBy(FEDERAL_PROGRAM).type(federalProgramName);
    }

    public void setFederalBusinessName(String federalBusinessName) {
        findBy(BUSINESS_NAME).type(federalBusinessName);
    }

    public void setFederalFirstName(String federalFirstName) {
        findBy(FIRST_NAME).type(federalFirstName);
    }

    public void setFederalMi(String federalMi) {
        findBy(MI).type(federalMi);
    }

    public void setFederalSuffix(String federalSuffix) {
        findBy(SUFFIX).click();
        selectFromDropDown(federalSuffix);
    }
}
