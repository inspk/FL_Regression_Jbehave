package com.hhstechgroup.ui.panels.enrollment.servicelocationbilling;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class ProgramParticipationSectionPanel extends BaseEnrollmentPanel {
    public ProgramParticipationSectionPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    protected static final String DROP_DOWN_OPTION = "//ul/li[node() = '%s']";
    private static final String ADD_TAXONOMY = ".//button/span[text()='ADD TAXONOMY']";
    private static final int SECTION_PULL_UP_TIMEOUT_IN_MILLISECONDS = 300;
    private static final String DROP_DOWN = "(.//label[contains(. , '%s')]/following-sibling::div/*)[1]";
    private static final String PROGRAM_PARTICIPATION = "Program Participation";
    private static final String SPECIALITY = "Specialty";
    private static final String SPECIALTY = "Specialty";

    private static final String BUTTON = "//button/span[text()='%s']";
    private static final String TAXONOMY = ".//label[contains(text() , 'Taxonomy')]/following-sibling::div";
    private static final String TAXONOMY_OPTIONS = "//div/ul[@role='listbox']/li[text()='%s']";
    private static final String TAXONOMY_OPTIONS_FOR_GRP = "//div/ul[@role='listbox']/li[text()='%s ']";
    private static final String EFFECTIVE_START_DATE = "(//label[contains(text(), 'Effective Start Date *')]/following::input[@placeholder='MM/DD/YYYY'])[1]";
    private static final String LOCATION_TAXONOMY_EFFECTIVE_START_DATE="//label[contains(text(), 'Effective Start Date')]/parent::div//input";
    private static final String LOCATION_TAXONOMY_EFFECTIVE_END_DATE="//label[contains(text(), 'Effective End Date')]/parent::div//input";
    private static final String EFFECTIVE_END_DATE = "//label[contains(text(), 'Effective End Date')]/parent::div//input";
    private static final String LICENSE_CERTIFICATE_TYPE = "//label[contains(text(), 'License/Certificate Type')]/following-sibling::div//div[contains(@class, 'MuiSelect-root') and @role='button']";
    private static final String SELECT_LICENSE_CERTIFICATE_TYPE = "//ul//li[contains(text(),'%s')]";

    private static final String ISSUER = "Issuer";
    private static final String LICENSE_CERTIFICATE_NUMBER = "//input[contains(@id,'Num')]";
    private static final String EFFECTIVE_START_DATE2 = "(//label[contains(text(), 'Effective start Date *')]/following::input[@placeholder='MM/DD/YYYY'])[1]";
    private static final String EFFECTIVE_END_DATE2 = "//label[contains(text(), 'Licensure Effective end Date')]/following::input[@placeholder='MM/DD/YYYY']";
    private static final String UPLOAD = "//input[@id='licenseAddAttachments']";

    private static final String PROGRAM_PARTICIPATION_SAVE = "(//button/span[text()='Save'])[2]";



    public void waitForSectionPulledUp() {
        waitABit(SECTION_PULL_UP_TIMEOUT_IN_MILLISECONDS);
    }

    protected void selectFromDropDown(String dropDownName, String option) {
        scrollToElement(format(DROP_DOWN, dropDownName));

        waitABit(1000);
        findBy(format(DROP_DOWN, dropDownName)).click();
        System.out.println("clicked on dropdown");
        waitABit(1000);
        action().moveToElement(findBy(format(DROP_DOWN_OPTION, option))).click().build().perform();


    }


    public void clickAddTaxonomyButton() {
        waitABit(500);
        scrollToElement(ADD_TAXONOMY);
        waitABit(500);
        findBy(ADD_TAXONOMY).click();
        System.out.println("clicked on taxonomy");
        waitABit(1000);
    }

    public void setProgramParticipation(String programParticipation) {
        waitABit(500);
        selectFromDropDown(PROGRAM_PARTICIPATION, programParticipation);
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

    public void setTaxonomyForGrp(String taxonomyForGrp){
        waitABit(500);
        findBy(TAXONOMY).click();
        waitABit(1000);
        findBy(format(TAXONOMY_OPTIONS_FOR_GRP, taxonomyForGrp)).click();
        waitABit(500);
    }

    public void setEffectiveStartDate(String effectiveStartDate) {
        waitABit(1000);
        findBy(EFFECTIVE_START_DATE).click();
        waitABit(200);
        findBy(EFFECTIVE_START_DATE).sendKeys(effectiveStartDate);
    }

    public void setEffectiveEndDate(String effectiveEndDate) {
        waitABit(500);
        jsClick(EFFECTIVE_END_DATE);
        findBy(EFFECTIVE_END_DATE).sendKeys(effectiveEndDate);}


    public void setLicenseCertificateType(String licenseCertificateType) {
        waitABit(1000);
//        selectFromDropDown(LICENSE_CERTIFICATE_TYPE, licenseCertificateType);
        findBy(LICENSE_CERTIFICATE_TYPE).click();
        waitABit(300);
        findBy(String.format(SELECT_LICENSE_CERTIFICATE_TYPE,licenseCertificateType)).click();
        waitABit(200);
    }

    public void setIssuer(String issuer) {
        waitABit(1000);
        selectFromDropDown(ISSUER, issuer);
    }

    public void setLicenseCertificateNumber(String licenseCertificateNumber) {
        waitABit(500);
//        fillModifiedField(LICENSE_CERTIFICATE_NUMBER, licenseCertificateNumber);
        findBy(LICENSE_CERTIFICATE_NUMBER).sendKeys(licenseCertificateNumber);
        waitABit(200);
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
        findBy("/html").click();
    }



    public void saveProgramParticipation() {
        waitABit(500);
        findBy(PROGRAM_PARTICIPATION_SAVE).click();
        waitABit(500);
    }


    private static final String MORE_BUTTON = "//span[contains(text(),'%s')]/ancestor::div[contains(@class, 'tile-table-row')]//button[@aria-label='More']";
    private static final String DELETE_BUTTON = "//button[span[text()='Delete']]|//button[span[text()='Remove/End']]";
    public void editTaxonomy(String taxonomy){
        waitABit(400);
        findBy(String.format(MORE_BUTTON,taxonomy)).click();
        waitABit(500);
        findBy(String.format(DROP_DOWN_OPTION, "Edit")).click();
        waitABit(500);
    }

    public void removeTaxonomy(String taxonomy){
        findBy(String.format(MORE_BUTTON, taxonomy)).click();
        waitABit(500);
        findBy(String.format(DROP_DOWN_OPTION, "Remove/End")).click();
        waitABit(500);
        findBy(DELETE_BUTTON).click();
    }

    private static final String REMOVE_END_BUTTON = "//button[span[text()='Remove/End']]";
    public void editCocProgramParticipation(String taxonomy){
        jsClick(format(MORE_BUTTON, taxonomy));
        waitABit(500);
        jsClick(format(DROP_DOWN_OPTION, "Edit"));
        waitABit(500);
    }

    public void removeCocProgramParticipation(String taxonomy){
        jsClick(format(MORE_BUTTON, taxonomy));
        waitABit(500);
        jsClick(format(DROP_DOWN_OPTION, "Remove/End"));
        waitABit(500);
        findBy(REMOVE_END_BUTTON).click();
    }
    private static final String TAXONOMY_DESCRIPTION="//input[contains(@name,'Select Taxonomy - Description')]";
    private static final String SELECT_TAXONOMY_DESCRIPTION="(//div[contains(@id,'Select Taxonomy - Description')]//ul//li//div)[1]";
    public void setTaxonomyDescription(String taxonomyDescription){
        scrollToElement(TAXONOMY_DESCRIPTION);
        waitABit(300);
        findBy(TAXONOMY_DESCRIPTION).click();
        waitABit(500);
//        findBy(TAXONOMY_DESCRIPTION).sendKeys(taxonomyDescription);
        getDriver().findElement(By.xpath(TAXONOMY_DESCRIPTION)).sendKeys(taxonomyDescription);
        waitABit(5000);
        findBy(SELECT_TAXONOMY_DESCRIPTION).click();
    }

    public void setSpeciality(String speciality) {
        waitABit(5000);
        findBy(SPECIALITY).click();
        selectFromDropDown(SPECIALITY, speciality);
        waitABit(500);
    }
    private static final String SELECT_SPECIALTY="//label[contains(text(),'Select Specialty *')]/..//div//div";
    private static final String SELECT_SPECIALTY_IN_DROPDOWN="//ul/li[node() = '%s']";
    public void setSpecialty(String specialty){
        waitABit(200);
//        selectFromDropDown(SPECIALTY, specialty);
        findBy(SELECT_SPECIALTY).click();
        System.out.println("clicked on specailty");
        waitABit(2000);
        findBy(format(SELECT_SPECIALTY_IN_DROPDOWN,specialty)).click();
        System.out.println("selected sepcailty from dropdown");
        waitABit(200);
    }
    public void setLocationTaxonomyEffectiveEndDate(String locationTaxonomyEffectiveEndDate){
        waitABit(500);
        jsClick(LOCATION_TAXONOMY_EFFECTIVE_END_DATE);
        findBy(LOCATION_TAXONOMY_EFFECTIVE_END_DATE).sendKeys(locationTaxonomyEffectiveEndDate);
    }
    public void setLocationTaxonomyEffectiveStartDate(String locationTaxonomyEffectiveStartDate){
        waitABit(500);
        jsClick(LOCATION_TAXONOMY_EFFECTIVE_START_DATE);
        findBy(LOCATION_TAXONOMY_EFFECTIVE_START_DATE).sendKeys(locationTaxonomyEffectiveStartDate);
    }
    private static final String PROVIDER_TYPE="//label[text()='Select Provider Type *']/..//div//div";
    private static final String SELECT_PROVIDER_TYPE="//ul/li[node() = '%s']";
    public void setProviderType(String providerType){
        waitABit(200);
        findBy(PROVIDER_TYPE).click();
        waitABit(3000);
        findBy(format(SELECT_PROVIDER_TYPE, providerType)).click();
        waitABit(2000);
    }


}
