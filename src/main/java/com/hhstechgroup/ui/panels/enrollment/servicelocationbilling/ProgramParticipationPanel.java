package com.hhstechgroup.ui.panels.enrollment.servicelocationbilling;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.bytebuddy.asm.Advice;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class ProgramParticipationPanel extends BaseEnrollmentPanel {

    protected static final String DROP_DOWN_OPTION = "//ul/li[node() = '%s']";
    private static final int SECTION_PULL_UP_TIMEOUT_IN_MILLISECONDS = 300;
    private static final String DROP_DOWN = ".//label[contains(text() , '%s')]/following-sibling::div/*";
    private static final String PROGRAM_PARTICIPATION = "Program Participation";
    private static final String SPECIALITY = "Speciality";
    private static final String BUTTON = "//button/span[text()='%s']";
    //    private static final String TAXONOMY = "Taxonomy/Description";
    private static final String TAXONOMY = ".//label[contains(text() , 'Taxonomy')]/following-sibling::div";
    private static final String TAXONOMY_OPTIONS = "//div/ul[@role='listbox']/li[normalize-space()='%s']";
    private static final String EFFECTIVE_START_DATE = ".//label[contains(text(), 'Location Taxonomy Effective Start Date')]/parent::div//input";
    private static final String EFFECTIVE_END_DATE = "//label[contains(text(), 'Location Taxonomy Effective End Date')]/parent::div//input";
    private static final String LICENSE_CERTIFICATE_TYPE = "License/Certificate Type";
    private static final String ISSUER = "Issuer";
    private static final String LICENSE_CERTIFICATE_NUMBER = "License/Certificate Number";
    private static final String EFFECTIVE_START_DATE2 = "(.//label[contains(text(), 'Effective start Date')]/parent::div//input)[2]";
    private static final String EFFECTIVE_END_DATE2 = "(.//label[contains(text(), 'Effective end Date')]/parent::div//input)[2]";
    private static final String UPLOAD = ".//*[text() = '%s']/../..//div[contains(@class, 'upload_upload-controls')]/input";
    private static final String PROGRAM_PARTICIPATION_SAVE = "(//button/span[text()='Save'])[last()]";
//    private static final String SELECT_TAXONOMY = ".//div[contains(@class,'pp-item-checkbox')]//span//input";
    private static final String SELECT_TAXONOMY = "//div[contains(@class,'sc-')]//input[contains(@type,'checkbox')]";
//    private static final String SAVE_TAXONOMY = "(//div/button/span[text()='Save'])[3]";
private static final String SAVE_TAXONOMY = "//label[contains(text(), 'Effective End Date')]/parent::div//input/following::button[.='Save']";



    public ProgramParticipationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void waitForSectionPulledUp() {
        waitABit(SECTION_PULL_UP_TIMEOUT_IN_MILLISECONDS);
    }

    protected void selectFromDropDown(String dropDownName, String option) {
        scrollToElement(format(DROP_DOWN, dropDownName));
        findBy(format(DROP_DOWN, dropDownName)).click();
        waitABit(1000);
        action().moveToElement(findBy(format(DROP_DOWN_OPTION, option))).click().build().perform();


    }

    public void setProgramParticipation(String programParticipation) {
        waitABit(500);
        selectFromDropDown(PROGRAM_PARTICIPATION, programParticipation);
        waitABit(500);
    }

    public void setSpeciality(String speciality) {
        waitABit(500);
        selectFromDropDown(SPECIALITY, speciality);
        waitABit(500);
    }

    public void clickButton(String button) {
        waitABit(500);
        scrollToElement(format(BUTTON, button));
        waitABit(1000);
        findBy(format(BUTTON, button)).click();
//        jsClick(format(BUTTON, button));
    }

    public void setTaxonomy(String taxonomy) {
        waitABit(500);
//        selectFromDropDown(TAXONOMY, taxonomy);
        findBy(TAXONOMY).click();
        waitABit(2000);
        findBy(format(TAXONOMY_OPTIONS, taxonomy)).click();
        waitABit(500);

    }

    public void setEffectiveStartDate(String effectiveStartDate) {
        waitABit(500);
        jsClick(EFFECTIVE_START_DATE);
        findBy(EFFECTIVE_START_DATE).sendKeys(effectiveStartDate);
    }

    public void setEffectiveEndDate(String effectiveEndDate) {
        waitABit(500);
        jsClick(EFFECTIVE_END_DATE);
        findBy(EFFECTIVE_END_DATE).sendKeys(effectiveEndDate);}

    public void setLicenseCertificateType(String licenseCertificateType) {
        waitABit(500);
        selectFromDropDown(LICENSE_CERTIFICATE_TYPE, licenseCertificateType);
    }

    public void setIssuer(String issuer) {
        waitABit(500);
        selectFromDropDown(ISSUER, issuer);
    }

    public void setLicenseCertificateNumber(String licenseCertificateNumber) {
        waitABit(500);
        fillModifiedField(LICENSE_CERTIFICATE_NUMBER, licenseCertificateNumber);
    }

    public void setEffectiveStartDate2(String effectiveStartDate2) {
        waitABit(500);
        findBy(EFFECTIVE_START_DATE2).sendKeys(effectiveStartDate2);
    }

    public void setEffectiveEndDate2(String effectiveEndDate2) {
        waitABit(500);
        findBy(EFFECTIVE_END_DATE2).sendKeys(effectiveEndDate2);
//        findBy("(.//span[contains(@class,'material-icons jss1386')])[4]").click();
        findBy("/html").click();
    }

    public void uploadDocument(String type, String path) {
        scrollToElement(format(UPLOAD, type));
        WebElement element = findBy(String.format(UPLOAD, type));
        upload(element, path);
        findBy("//*").sendKeys(Keys.TAB);
        waitABit(500);
    }

    public void saveProgramParticipation() {
        waitABit(500);
        findBy(PROGRAM_PARTICIPATION_SAVE).click();
        waitABit(500);
    }

    public void selectTaxonomy() {
        waitABit(500);
        findBy(SELECT_TAXONOMY).click();
        waitABit(1000);
    }

    public void saveTaxonomy() {
        waitABit(500);
        findBy(SAVE_TAXONOMY).click();
        waitABit(500);
    }
    private static final String SELECT_TAXONOMY_IN_SL="//div[contains(text(),'%s')]/..//span//span//input";
    public void selectTaxonomyInServiceLocation(String taxonomy){
        waitABit(500);
        findBy(String.format(SELECT_TAXONOMY_IN_SL,taxonomy)).click();
        waitABit(500);
    }
}
