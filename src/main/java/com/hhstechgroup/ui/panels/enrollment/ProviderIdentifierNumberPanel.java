package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

import static java.lang.String.format;

public class ProviderIdentifierNumberPanel extends BaseEnrollmentPanel {

    private static final String PREVIOUSLY_ENROLLED_IN_ANOTHER_STATE = "another state";
    private static final String ENROLLED_IN_MEDICARE = "enrolled in Medicare";
    private static final String PARTICIPATE_P4P = "pay for performance";
    private static final String NPI_DATE = ".//label[contains(text(),'NPI Date')]/..//div/input[@placeholder='MM/DD/YYYY']";
    public ProviderIdentifierNumberPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    public void setPreviouslyEnrolledAsMedicaidChip(String previouslyEnrolledAsMedicaidChip) {
        selectRadionButton(PREVIOUSLY_ENROLLED_IN_ANOTHER_STATE, previouslyEnrolledAsMedicaidChip);
    }
    public void setEnrolledInMedicare(String enrolledInMedicare) {
        selectRadionButton(ENROLLED_IN_MEDICARE, enrolledInMedicare);
    }

    public void setParticioateP4P(String particioateP4P) {
        selectRadionButton(PARTICIPATE_P4P, particioateP4P);
    }

    public void setnpiDate(String npiDate) {
        jsClick(NPI_DATE);
        findBy(NPI_DATE).click();
        findBy(NPI_DATE).type(npiDate);
        waitABit(300);
    }
    //Newly Added
//    private static final String NPI = "National provider identification";
//    public void setNpi(String npi) {
//        waitABit(500);
//        fillField(NPI,npi);
//        fillField(NPI,npi);
//        waitABit(800);
//    }
    private static final String GROUPNPI = ".//label[contains(text(),'National provider identification (NPI)')]/..//div/input";
    public void  setGroupnpi(String groupnpi) {
        jsClick(GROUPNPI);
        waitABit(500);
        selectFromDropDown(GROUPNPI,groupnpi);
    }

    //sp26
    //private static final String NPI="NPI Number";
    //sp36
    private static final String NPI =".//label[contains(text(), 'NPI')]/following-sibling::div//input";
    public void setNpi(String npi) {
        waitABit(500);
        scrollToElement(NPI);
        findBy(NPI).type(npi);
        waitABit(3000);
//        findBy(NPI).type(npi);
////        findBy(NPI).sendKeys(Keys.TAB);
//        waitABit(3000);
        for (int i = 0; i < 4; i++) {
            try {
                if (findBy("//*[text()='Verified']").isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
            }
            waitABit(3000);
            findBy(NPI).type(npi);
            waitABit(3000);
            selectRadionButton(MEDICARE_PARTICIPANT,"No");
            waitABit(2000);
        }


//        waitABit(500);
//        //scrollToElement(NPI);
//        findBy(NPI).type(npi);
//        waitABit(500);
    }
    private static final String DEA_NUMBER="Do you have a DEA Number?";
    private static final String LABORATORY_SERVICES="Do you bill laboratory services?";
    public void setDeaNumber(String deaNumber){
        waitABit(500);
        selectRadionButton(DEA_NUMBER,deaNumber);
        waitABit(1000);
    }
    public void setLaboratoryServices(String laboratoryServices){
        waitABit(500);
        selectRadionButton(LABORATORY_SERVICES,laboratoryServices);
        waitABit(1000);
    }
    //sp29
    //private static final String PHARMACYNPI="NPI";
   //sp36
    private static final String PHARMACYNPI=".//label[contains(text(), 'NPI')]/following-sibling::div//input";
    public void setPharmacynpi(String pharmacynpi) {
        waitABit(500);
        findBy(PHARMACYNPI).type(pharmacynpi);
        waitABit(3000);
//        findBy(PHARMACYNPI).type(pharmacynpi);
//        waitABit(3000);
        for (int i = 0; i < 2; i++) {
            try {
                if (findBy("//*[text()='Verified']").isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
            }
            // sp62 updating new changes
            findBy(PHARMACYNPI).type(pharmacynpi);
            waitABit(3000);
            selectRadionButton(MEDICARE_PARTICIPANT,"No");
            waitABit(2000);
            selectRadionButton(DEA_NUMBER,"No");
            findBy(PHARMACYNPI).type(pharmacynpi);
            waitABit(3000);

        }
//        waitABit(500);
//        //fillField(PHARMACYNPI,pharmacynpi);
//        findBy(PHARMACYNPI).type(pharmacynpi);
//        waitABit(1000);
    }
    private static final String NCPDPNUMBER="NCPDP Number";
    public void setNcpdpNumber(String ncpdpNumber){
        waitABit(100);
        fillField(NCPDPNUMBER,ncpdpNumber);
    }

    //Demo
    private static final String MEDICARE_PARTICIPANT="Are you a participant in Medicare?";
    public void setMedicareParticipant(String medicareParticipant){
        waitABit(500);
        selectRadionButton(MEDICARE_PARTICIPANT,medicareParticipant);
        waitABit(1000); }

    private static final String MEDICAL_DIRECTOR="Do you have a Medical Director?";
    public void setMedicalDirector(String medicalDirector){
        waitABit(500);
        selectRadionButton(MEDICAL_DIRECTOR,medicalDirector);
        waitABit(1000); }

    private static final String TEACHING_PROVIDER="Are you a Teaching Provider?";
    public void setTeachingProvider(String teachingProvider){
        waitABit(500);
        selectRadionButton(TEACHING_PROVIDER,teachingProvider);
        waitABit(1000); }

    private static final String TREATING_PROVIDER="Are you a Treating Provider?";
    public void setTreatingProvider(String treatingProvider){
        waitABit(500);
        selectRadionButton(TREATING_PROVIDER,treatingProvider);
        waitABit(1000); }

    private static final String PARTICIPATING_PROVIDER="Are you a DRG Participating Provider?";
    public void setDrgParticipatingProvider(String drgParticipatingProvider){
        waitABit(500);
        selectRadionButton(PARTICIPATING_PROVIDER,drgParticipatingProvider);
        waitABit(1000); }

    private static final String PASRR_ACCESS="Do you need PASRR Access?";
    public void setPasrrAccess(String pasrrAccess){
        waitABit(500);
        selectRadionButton(PASRR_ACCESS,pasrrAccess);
        waitABit(1000); }

    private static final String DRUG_PRICING="Are you a part of the 340-B Drug Pricing program?";
    public void setDrugPricingProgram(String drugPricingProgram){
        waitABit(500);
        selectRadionButton(DRUG_PRICING,drugPricingProgram);
        waitABit(1000); }

    private static final String CARE_AGREEMENT="Do you have a Standard of Care Agreement?";
    public void setCareAgreement(String careAgreement){
        waitABit(500);
        selectRadionButton(CARE_AGREEMENT,careAgreement);
        waitABit(1000); }

    private static final String TRADING_PARTNER="Do you have Electronic Data Interchange (EDI) or Trading partner Authorization?";
    public void setTradingPartnerAuthorization(String tradingPartnerAuthorization){
        waitABit(500);
        selectRadionButton(TRADING_PARTNER,tradingPartnerAuthorization);
        waitABit(1000); }

        private static final String IDENTIFIER_TYPE= ".//label[contains(text(), 'Type')]/parent::div//input/preceding-sibling::div";
       public void setIdentifierType(String identifierType) {
         waitABit(500);
           findBy(IDENTIFIER_TYPE).click();
         selectFromDropDown(identifierType);
         waitABit(1000); }

        private static final String IDENTIFIER_ID= "Identifier";
    public void setIdentifierId(String identifierId) {
        waitABit(500);
        fillField(IDENTIFIER_ID,identifierId);
        waitABit(1000);
    }
    private static final String CALENDAR = "//div[@role='document']";
    private static final String IDENTIFIER_EFFECTIVE= ".//label[contains(text() ,'Effective Date')]/following-sibling::div/input";
    public void setIdentifierEffectiveDate(String identifierEffectiveDate) {
        waitABit(2000);
        jsClick(IDENTIFIER_EFFECTIVE);
        findBy(IDENTIFIER_EFFECTIVE).sendKeys(identifierEffectiveDate);
        waitABit(2500);
    }
    private static final String IDENTIFIER_END= ".//label[contains(text() ,'End Date')]/following-sibling::div/input";
    public void setIdentifierEndDate(String identifierEndDate) {
        waitABit(200);
        jsClick(IDENTIFIER_END);
        findBy(IDENTIFIER_END).sendKeys(identifierEndDate);
        waitABit(2500);
    }

    //Pharmacy -- Demo

    private static final String DO_YOU_HAVE_DEA = "Do you have a DEA Number?";
    public void setDoYouHaveDeaNumber(String doYouHaveDeaNumber) {
        waitABit(500);
        selectRadionButton(DO_YOU_HAVE_DEA,doYouHaveDeaNumber);
        waitABit(1000);
    }
    private static final String DO_YOU_HAVE_PHARMACY_CONTACT = "Do you have a Pharmacy Contact?";
    public void setDoYouHavePharmacyContact(String doYouHavePharmacyContact) {
        waitABit(500);
        selectRadionButton(DO_YOU_HAVE_PHARMACY_CONTACT,doYouHavePharmacyContact);
        waitABit(1000);
    }

    private static final String SELECT_NPI = "Do you have an NPI or Other ID?";
    public void setSelectNpi(String selectNpi) {
        waitABit(500);
        selectRadionButton(SELECT_NPI, selectNpi);
        waitABit(1000);
    }


    private static final String MEDICAID_STATE  = "out-of-state provider";
    public void setMedicaidState(String medicaidState) {
        waitABit(500);
        selectRadionButton(MEDICAID_STATE, medicaidState);
        waitABit(1000);
    }

    private static final String LIABILITY_INSURANCE  = "Do you have malpractice or general liability insurance?";
    public void setInsurance(String insurance) {
        waitABit(2000);
        selectRadionButton(LIABILITY_INSURANCE, insurance);
        waitABit(2000);
    }

    private static final String CLAIM_SUBMIT = ".//label[contains(text(), 'claim')]/parent::div//input/..//div";
    private static final String SELECT_CLAIM_SUBMIT = ".//div//ul[@role='listbox']//li[text()='%s']";

    public void setClaimSubmit(String claimSubmit)
    {
        scrollToElement(CLAIM_SUBMIT);
        findBy(CLAIM_SUBMIT).click();
        waitABit(500);
        //     new WebDriverWait(getDriver(), 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath(".//li[text()='Electronic Data Interchange (EDI)']")));
        getDriver().findElement(By.xpath(".//li[text()='Direct Data Entry']")).click();
        waitABit(200);
        findBy("//html").sendKeys(Keys.ESCAPE);
    waitABit(500);
    }

    private static final String TEACHING_FACILITY  = "Are you a Teaching Facility?";
    public void setTeachingFacility(String teachingFacility) {
        waitABit(500);
        selectRadionButton(TEACHING_FACILITY, teachingFacility);
        waitABit(1000);
    }

    private static final String INDIAN_HEALTH_SERVICES  = "Are you in Indian Health Services (IHS) / 638 Tribal Provider?";
    public void setIndianHealthServices(String indianHealthServices) {
        waitABit(500);
        selectRadionButton(INDIAN_HEALTH_SERVICES, indianHealthServices);
        waitABit(1000);
    }

    private static final String GROUP_CLAIM_SUBMIT = ".//label[contains(text(), 'What claim submission(s) do you use?')]/parent::div//input";
    private static final String SELECT_GROUP_CLAIM_SUBMIT = ".//div/strong[text()='%s']";
    public void setGroupClaimSubmit(String groupClaimSubmit)
    {

        findBy(GROUP_CLAIM_SUBMIT).click();
        waitABit(500);
//        new WebDriverWait(getDriver(), 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath(".//li[text()='Electronic Data Interchange (EDI)']")));
//        getDriver().findElement(By.xpath(".//div/strong[text()='Electronic Data Interchange EDI']")).click();
//        findBy("//html").sendKeys(Keys.ESCAPE);
//        waitABit(500);
        findBy(format(SELECT_GROUP_CLAIM_SUBMIT,groupClaimSubmit)).click();
        waitABit(200);
        findBy("//html").sendKeys(Keys.ESCAPE);
        waitABit(500);

    }

    private static final String TPNPI =".//label[contains(text(), 'NPI Number')]/following-sibling::div//input";
    public void setTpnpi(String tpnpi) {
        waitABit(500);
        scrollToElement(TPNPI);
        findBy(TPNPI).type(tpnpi);
        waitABit(3000);
        for (int i = 0; i < 4; i++) {
            try {
                if (findBy("//*[text()='Verified']").isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
            }
            waitABit(3000);
            findBy(TPNPI).type(tpnpi);
            waitABit(3000);
            selectRadionButton("Do you have an NPI or Other ID?", "Yes");
            waitABit(2000);
        }
    }

    public boolean isDuplicateNpiMessagePresents(String npi){
        waitABit(500);
        scrollToElement(NPI);
        findBy(NPI).type(npi);
        waitABit(3000);
        selectRadionButton(MEDICARE_PARTICIPANT,"No");
        for (int i = 0; i < 4; i++) {
            try {
                if (findBy("//*[text()='NPI already exist in the system']").isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
            }
            waitABit(3000);
            findBy(NPI).type(npi);
            waitABit(3000);
            selectRadionButton(MEDICARE_PARTICIPANT,"No");
            waitABit(2000);
        }
        return false;
    }

    private static final String LANGUAGE_SUPPORTED = "//div[label[contains(text(), 'Language Supported (Select all that apply)')]]";
    private static final String LANGUAGE_OPTIONS = "//ul/li[node()='%s']";

    public void setLanguageSupported(String languageSupported) {
        waitABit(500);
        scrollToElement(LANGUAGE_SUPPORTED);
        findBy(LANGUAGE_SUPPORTED).click();
        waitABit(1000);
        findBy(format(LANGUAGE_OPTIONS, languageSupported)).click();
        waitABit(1000);
        findBy("//*").sendKeys(Keys.ESCAPE);
        waitABit(1000);
    }
    private static final String CROSS_OVER_APPLICATION="Is this a Crossover only application?";
    public void setCrossOverApplication(String crossOverApplication){
        waitABit(500);
        selectRadionButton(CROSS_OVER_APPLICATION, crossOverApplication);
        waitABit(1000);
    }

    private static final String MEDICARE_CROSS_OVER_CLAIM="Are you applying to submit Medicare Crossover claims only?";
    public void setMedicareCrossoverClaim(String medicareCrossoverClaim){
        waitABit(500);
        selectRadionButton(MEDICARE_CROSS_OVER_CLAIM, medicareCrossoverClaim);
        waitABit(1000);
    }


}
