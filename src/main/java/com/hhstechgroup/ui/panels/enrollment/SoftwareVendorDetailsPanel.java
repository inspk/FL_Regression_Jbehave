package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;


public class SoftwareVendorDetailsPanel extends BaseEnrollmentPanel {

    private static final String SOFTWARE_VENDOR_NAME = ".//label[contains(text(), 'Software Vendor Name')]/parent::div//input";
    private static final String SOFTWARE_NAME = ".//label[contains(text(), 'Software Name')]/parent::div//input";
    private static final String VERSION_ID = ".//label[contains(text(), 'Version ID')]/parent::div//input";
    private static final String ENTITY_CODE = ".//label[contains(text(), 'Entity code')]/parent::div//input";

    public SoftwareVendorDetailsPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

        public void setSoftwareVendorName(String softwareVendorName) {
        findBy(SOFTWARE_VENDOR_NAME).type(softwareVendorName);}

        public void setSoftwareName(String softwareName){
        findBy(SOFTWARE_NAME).type(softwareName);}

        public void setVersionId(String versionId){
        findBy(VERSION_ID).type(versionId);}

        public void setEntityCode(String entityCode){
            scrollToElement(ENTITY_CODE);
            waitABit(2000);
           findBy(ENTITY_CODE).type(entityCode);}

}
