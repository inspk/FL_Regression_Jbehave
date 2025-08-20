package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class OtherCredentialingInformationPanel extends BaseEnrollmentPanel{
    public OtherCredentialingInformationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    private static final String TYPE_PF_TRAINING="//div[contains(@id,'Type of Training')]";
    private static final String ORGANIZATION_NAME="//input[contains(@aria-label,'Organization Name')]";
    private static final String UPLOAD_FILE="//div[contains(@data-for,'Upload Training Document')]//div//input";

    public void setTypeOfTraining(String typeOfTraining){
        waitABit(300);
        findBy(TYPE_PF_TRAINING).click();
        waitABit(500);
        selectFromDropDown(typeOfTraining);
        waitABit(500);
    }
    public void setOrganizationName(String organizationName){
        waitABit(200);
        findBy(ORGANIZATION_NAME).click();
        findBy(ORGANIZATION_NAME).sendKeys(organizationName);
        waitABit(400);
    }
    private static final String EFFECTIVE_START_DATE=".//label[contains(text(), 'Effective Start Date')]/parent::div//input";
    private static final String EFFECTIVE_END_DATE=".//label[contains(text(), 'Effective End Date')]/parent::div//input";

    public void setEffectiveStartDate(String effectiveStartDate) {
        waitABit(500);
        jsClick(EFFECTIVE_START_DATE);
        findBy(EFFECTIVE_START_DATE).sendKeys(effectiveStartDate);
    }

    public void setEffectiveEndDate(String effectiveEndDate) {
        waitABit(500);
        jsClick(EFFECTIVE_END_DATE);
        findBy(EFFECTIVE_END_DATE).sendKeys(effectiveEndDate);}
    public void uploadDoc(String docType,String path){
        scrollToElement(format(UPLOAD_FILE, docType));
        WebElement element = findBy(format(UPLOAD_FILE, docType));
        upload(element, path);
        findBy("//*").sendKeys(Keys.TAB);
        waitABit(500);
        findBy("/html").click();
    }
    private static final String GRADUATION_TYPE="//div[contains(@id,'Graduation Type')]";
    public void setGradutaionType(String gradutaionType){
        waitABit(300);
        findBy(GRADUATION_TYPE).click();
        waitABit(500);
        selectFromDropDown(gradutaionType);
        waitABit(300);
    }
    private static final String PROFESSIONAL_MEDICAL_SCHOOL="Did you attend Professional/Medical School?";
    public void setMedicalSchool(String medicalSchool){
        waitABit(200);
        selectRadionButton(PROFESSIONAL_MEDICAL_SCHOOL,medicalSchool);
        waitABit(300);
    }
    private static final String PROFESSIONAL_SCHOOL_NAME="//input[contains(@aria-label,'Professional School Name')]";
    public void setProfessionalSchoolName(String professionalSchoolName){
        waitABit(200);
        findBy(PROFESSIONAL_SCHOOL_NAME).click();
        waitABit(200);
        findBy(PROFESSIONAL_SCHOOL_NAME).sendKeys(professionalSchoolName);
        waitABit(300);
    }
    private static final String PROFESSIONAL_SCHOOL_ADDRESS="//input[contains(@id,'line1')]";
    private static final String SELECT_ADDRES =".//div[contains(@role,'menuitem')]";
    private static final String COUNTRY="//input[contains(@aria-label,'Professional School Country')]";
    public void setProfessionalSchoolAddress(String professionalSchoolAddress){
        waitABit(200);
        findBy(PROFESSIONAL_SCHOOL_ADDRESS).sendKeys(professionalSchoolAddress);
        waitABit(6000);
        findBy(SELECT_ADDRES).click();
        waitForSectionPulledUp();
        findBy(COUNTRY).sendKeys("United States");
        waitABit(400);
    }
}
