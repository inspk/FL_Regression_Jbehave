package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class ProfileSetupPanel extends BaseEnrollmentPanel {


    public ProfileSetupPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    private static final String PHARMACY_NPI = "NPI";
    private static final String PHARMACY_FEIN = "FEIN";
    private static final String PHARMACY_OR_LEGAL_BUSSINESS_NAME = "Pharmacy or Legal Business Name";
    private static final String PHARMACY_TYPE = ".//span//input[@value='%s']";
    private static final String PHARMACY_PRIMARY_TAXONOMY_CODE = "Primary Taxonomy Code";
    private static final String PHARMACY_EMAIL = "Pharmacy Email";
    private static final String PHARMACY_ADDRESS = "Address";
    private static final String PHARMACY_ZIP = ".//label[contains(text() , 'Zip Code')]/..//div//input";
    private static final String PHARMACY_STATE = "State";
    private static final String PHARMACY_PHONE_NO = "Phone";
    private static final String PHARMACY_ENROLLMENT_TYPE = "Enrollment Type";

    public void setPharmacyNpi(String pharmacyNpi) {
        waitABit(200);
        fillField(PHARMACY_NPI,pharmacyNpi);
        waitABit(100);

    }

    public void setPharmacyFein(String pharmacyFein) {
        waitABit(200);
        fillField(PHARMACY_FEIN,pharmacyFein);
        waitABit(100);

    }

    public void setPharmacyOrLegalBussinessName(String pharmacyOrLegalBussinessName) {
        waitABit(200);
        fillField(PHARMACY_OR_LEGAL_BUSSINESS_NAME,pharmacyOrLegalBussinessName);
        fillField(PHARMACY_OR_LEGAL_BUSSINESS_NAME,pharmacyOrLegalBussinessName);
        waitABit(100);

    }

    public void setPharmacyType(String pharmacyType) {
        scrollToElement(format(PHARMACY_TYPE,pharmacyType));
        findBy(format(PHARMACY_TYPE,pharmacyType)).click();
        waitABit(200);
   //     select(PHARMACY_TYPE,pharmacyType);
    }

    public void setPharmacyPrimaryTaxonomyCode(String pharmacyPrimaryTaxonomyCode) {
        waitABit(200);
        fillField(PHARMACY_PRIMARY_TAXONOMY_CODE,pharmacyPrimaryTaxonomyCode);
        fillField(PHARMACY_PRIMARY_TAXONOMY_CODE,pharmacyPrimaryTaxonomyCode);
        waitABit(100);

    }

    public void setPharmacyEmail(String pharmacyEmail) {
        waitABit(200);
        fillField(PHARMACY_EMAIL,pharmacyEmail);

    }

    public void setPharmacyAddress(String pharmacyAddress) {
        waitABit(200);
        fillField(PHARMACY_ADDRESS,pharmacyAddress);

    }

    public void setPharmacyZip(String pharmacyZip) {
        waitABit(200);
        findBy(PHARMACY_ZIP).type(pharmacyZip);
        findBy(PHARMACY_ZIP).type(pharmacyZip);


    }

    public void setPharmacyState(String pharmacyState) {
        waitABit(200);
        select(PHARMACY_STATE,pharmacyState);

    }

    public void setPharmacyPhoneNo(String pharmacyPhoneNo) {
        waitABit(200);
        fillField(PHARMACY_PHONE_NO,pharmacyPhoneNo);

    }

    public void setPharmacyEnrollmentType(String pharmacyEnrollmentType) {
        waitABit(200);
        select(PHARMACY_ENROLLMENT_TYPE,pharmacyEnrollmentType);
        waitABit(200);
    }



}
