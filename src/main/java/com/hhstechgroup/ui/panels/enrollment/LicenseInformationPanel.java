package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.LocalDate;

public class LicenseInformationPanel extends BaseEnrollmentPanel {
    //sp26
    private final static String LICENSE_NUMBER = ".//label[contains(text(), 'License Number')]/parent::div//input";
    private final static String LICENSE_TYPE = ".//label[contains(text(), 'License Type')]/parent::div//input/preceding-sibling::div";
    private final static String LICENSE_ISSUSED_STATE = ".//label[contains(text(), 'License Issued State')]/parent::div//input/preceding-sibling::div";
    private final static String LICENCE_EFFECTIVE_DATE = ".//label[text() = 'License Effective Date']/following-sibling::div/input/following-sibling::div/button";
    private final static String LICENSE_EXPIRATION_DATE = ".//label[text() = 'License Expiration Date']/following-sibling::div/input/following-sibling::div/button";
    private static final String CALENDAR = "//div[@role='document']";

    public LicenseInformationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setLicenseNumber(String licenseNumber) {
        waitABit(500);
        findBy(LICENSE_NUMBER).type(licenseNumber);
    }

    public void setLicenseType(String licenseType) {
        waitABit(500);
        findBy(LICENSE_TYPE).click();
        selectFromDropDown(licenseType);
    }

    public void setLicenseIssuedState(String licenseIssuedState) {
        waitABit(500);
        findBy(LICENSE_ISSUSED_STATE).click();
        selectFromDropDown(licenseIssuedState);
    }
/*
    public void setLicensEffectiveDate(String licensEffectiveDate) {
        LocalDate date = DateConverter.toLocalDate(licensEffectiveDate);
        findBy(LICENCE_EFFECTIVE_DATE).click();
        waitForCalendarPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setYear(date.getYear());
        waitABit(500);
        calendar.setMonth(date.getMonthValue());
        waitABit(500);
        calendar.setDayOfMonth(date.getDayOfMonth());
        waitABit(500);
    }

    public void setLicenseExpirationDate(String licenseExpirationDate) {
        LocalDate date = DateConverter.toLocalDate(licenseExpirationDate);
        findBy(LICENSE_EXPIRATION_DATE).click();
        waitForCalendarPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setYear(date.getYear());
        waitABit(1000);
        calendar.setMonth(date.getMonthValue());
        waitABit(1000);
        calendar.setDayOfMonth(date.getDayOfMonth());
        waitABit(1000);
    }*/
   // sp28
    public void setNewlicenseNumber(String newlicenseNumber) {
        try {
            waitABit(500);
            findBy(LICENSE_NUMBER).type(newlicenseNumber);
        }
        catch (Exception e){
            System.out.println("license section not present"); }
    }
    public void setNewlicenseType(String newlicenseType) {
        try {
            waitABit(500);
            findBy(LICENSE_TYPE).click();
            selectFromDropDown(newlicenseType);
        }
        catch (Exception e){
            System.out.println("license section not present"); }
    }
    public void setNewlicenseIssuedState(String newlicenseIssuedState) {
        try {
            waitABit(500);
            findBy(LICENSE_ISSUSED_STATE).click();
            selectFromDropDown(newlicenseIssuedState);
        }
        catch (Exception e){
            System.out.println("license section not present"); } }

    public void setNewlicensEffectiveDate(String newlicensEffectiveDate) {
        try {
            LocalDate date = DateConverter.toLocalDate(newlicensEffectiveDate);
            findBy(LICENCE_EFFECTIVE_DATE).click();
            waitForCalendarPopUpOpened();
            CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
            calendar.setYear(date.getYear());
            waitABit(500);
            calendar.setMonth(date.getMonthValue());
            waitABit(500);
            calendar.setDayOfMonth(date.getDayOfMonth());
            waitABit(500);
        }
        catch (Exception e){
            System.out.println("license section not present"); }
    }

    public void setNewlicenseExpirationDate(String newlicenseExpirationDate) {
        try {
            LocalDate date = DateConverter.toLocalDate(newlicenseExpirationDate);
            findBy(LICENSE_EXPIRATION_DATE).click();
            waitForCalendarPopUpOpened();
            CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
            calendar.setYear(date.getYear());
            waitABit(1000);
            calendar.setMonth(date.getMonthValue());
            waitABit(1000);
            calendar.setDayOfMonth(date.getDayOfMonth());
            waitABit(1000);

        }
        catch (Exception e){
            System.out.println("license section not present"); }

    }
//sp29
private final static String PHARMACY_LICENSE_ISSUSE_STATE = ".//label[contains(text(), 'License Issue State')]/parent::div//input/preceding-sibling::div";
    public void setPharmacylicenseIssuedState(String pharmacylicenseIssuedState) {
        waitABit(500);
        findBy(PHARMACY_LICENSE_ISSUSE_STATE).click();
        selectFromDropDown(pharmacylicenseIssuedState);
    }
    public void setPharmacyLicenseNumber(String pharmacylicenseLicenseNumber){
        waitABit(500);
        scrollToElement(LICENSE_NUMBER);
        findBy(LICENSE_NUMBER).type(pharmacylicenseLicenseNumber);
    }
   //sp30
    //private final static String LICENCE_EFFECTIVE_DATE1 = ".//label[text()='License Effective Date']//ancestor::div[contains(@class, 'styles_datepicker')]//input";
    //private final static String LICENSE_EXPIRATION_DATE1 = ".//label[text()='License Expiration Date']//ancestor::div[contains(@class, 'styles_datepicker')]//input";
    //sp35
    private final static String LICENCE_EFFECTIVE_DATE1 =  ".//label[contains(text(),'License Effective Date')]//ancestor::div[contains(@class, 'styles_datepicker')]//input";
    private final static String LICENSE_EXPIRATION_DATE1 = ".//label[contains(text(),'License Expiration Date')]//ancestor::div[contains(@class, 'styles_datepicker')]//input";
    public void setLicensEffectiveDate(String licensEffectiveDate) {
        waitABit(2000);
        jsClick(LICENCE_EFFECTIVE_DATE1);
        findBy(LICENCE_EFFECTIVE_DATE1).sendKeys(licensEffectiveDate);
        waitABit(2500);
    }
    public void setLicenseExpirationDate(String licenseExpirationDate) {
    waitABit(2000);
    jsClick(LICENSE_EXPIRATION_DATE1);
    findBy(LICENSE_EXPIRATION_DATE1).sendKeys(licenseExpirationDate);
    waitABit(500);
    }

    //Demo Affiliation Section
    private final static String NPI_FEIN_NUMBER = ".//label[contains(text(), 'NPI/FEIN Number')]/parent::div//input";
    public void setNpiFeinNumber(String npiFeinNumber) {
        waitABit(2000);
        jsClick(NPI_FEIN_NUMBER);
        findBy(NPI_FEIN_NUMBER).sendKeys(npiFeinNumber);
        waitABit(500);
    }

    private final static String AFFILIATION_TYPE = ".//label[contains(text(), 'Affiliation Type')]/parent::div//input/preceding-sibling::div";
    public void setAffiliationType(String affiliationType) {
        waitABit(500);
        findBy(AFFILIATION_TYPE).click();
        selectFromDropDown(affiliationType);
        waitABit(500);
    }

    private final static String EFFECTIVE_FROM_DATE = ".//label[contains(text(),'Effective Date From')]//ancestor::div[contains(@class, 'styles_datepicker')]//input";
    public void setEffectiveDateFrom(String effectiveDateFrom) {
        waitABit(2000);
        jsClick(EFFECTIVE_FROM_DATE);
        findBy(EFFECTIVE_FROM_DATE).sendKeys(effectiveDateFrom);
        waitABit(2500);
    }

    private final static String EFFECTIVE_TO_DATE = ".//label[contains(text(),'Effective Date To')]//ancestor::div[contains(@class, 'styles_datepicker')]//input";
    public void setEffectiveDateTo(String effectiveDateTo) {
        waitABit(2000);
        jsClick(EFFECTIVE_TO_DATE);
        findBy(EFFECTIVE_TO_DATE).sendKeys(effectiveDateTo);
        waitABit(2500);
    }
    private final static String CERTIFICATE_NUMBER = ".//label[contains(text(), 'Certification Number')]/parent::div//input";
    public void setCertificateNumber(String certificateNumber) {
        waitABit(2000);
        jsClick(CERTIFICATE_NUMBER);
        findBy(CERTIFICATE_NUMBER).sendKeys(certificateNumber);
        waitABit(500);
    }
    private final static String CERTIFICATE_EFFECTIVE_DATE = ".//label[contains(text(),'Certification Effective Date')]//ancestor::div[contains(@class, 'styles_datepicker')]//input";
    public void setCertificateEffectiveDate(String certificateEffectiveDate) {
        waitABit(2000);
        jsClick(CERTIFICATE_EFFECTIVE_DATE);
        findBy(CERTIFICATE_EFFECTIVE_DATE).sendKeys(certificateEffectiveDate);
        waitABit(2500);
    }
}






