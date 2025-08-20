package com.hhstechgroup.ui.panels.enrollment.exclusionsanction;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseTable;
import net.serenitybdd.core.pages.WebElementFacade;

public class NameTable extends BaseTable {

    private final static String FIRST_NAME = ".//label[contains(text(), 'First name')]/parent::div//input";
    private final static String MI = ".//label[contains(text(), 'MI')]/parent::div//input";
    private final static String LAST_NAME = ".//label[contains(text(), 'Last name')]/parent::div//input";
    private final static String RELATIONSHIP = ".//label[contains(text(), 'Relationship')]/parent::div//input/preceding-sibling::div";
    private final static String SUFFIX = ".//label[contains(text(), 'Suffix')]/parent::div//input/preceding-sibling::div";

    public NameTable(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setExclusionFirstName(String exclusionFirstName) {
        findBy(FIRST_NAME).type(exclusionFirstName);
    }

    public void setExclusionLastName(String exclusionLastName) {
        findBy(LAST_NAME).type(exclusionLastName);
    }

    public void setExclusionMi(String exclusionMi) {
        findBy(MI).type(exclusionMi);
    }

    public void setExclusionSuffix(String exclusionSuffix) {
        findBy(SUFFIX).click();
        selectFromDropDown(exclusionSuffix);
    }

    public void setExclusionRelationship(String exclusionRelationship) {
        findBy(RELATIONSHIP).click();
        selectFromDropDown(exclusionRelationship);
    }

}
