package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class ClassificationPanel extends BaseEnrollmentPanel {
    public ClassificationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public static final String CLASSIFICATION = "//div[@role='radiogroup']/label/span[text()='%s']";
    public void setClassification(String classification){
        waitABit(500);
        findBy(format(CLASSIFICATION, classification)).click();
        waitABit(500);
    }

    public static final String SOFTWARE_VENDOR_NAME = "Software Vendor Name";
    public void setSoftwareVendorName(String softwareVendorName){
        waitABit(500);
        fillModifiedField(SOFTWARE_VENDOR_NAME, softwareVendorName);
    }

    public static final String SOFTWARE_NAME = "Software Name";
    public void setSoftwareName(String softwareName){
        waitABit(500);
        fillModifiedField(SOFTWARE_NAME, softwareName);
    }

    public static final String VERSION_ID = "Version ID";
    public void setVersionId(String versionId){
        waitABit(500);
        fillModifiedField(VERSION_ID, versionId);
    }

    public static final String ENTITY_CODE = "//input[@name='Entity Code']";
    public void setEntityCode(String entityCode){
        waitABit(500);
        //select(ENTITY_CODE, entityCode);
        findBy(ENTITY_CODE).click();
        waitABit(200);
        findBy(format(ENTITY_CODE,entityCode)).click();
  //      selectFromDropDown(entityCode);
    }

}

