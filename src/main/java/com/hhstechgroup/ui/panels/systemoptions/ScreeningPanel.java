package com.hhstechgroup.ui.panels.systemoptions;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class ScreeningPanel extends AbstractPanel {
    //latest  sp28
    private static final String DOB = ".//div[contains(text(),'Date of Birth')]/..//select//option[@value='%s']";
    //latest  sp26
    //private static final String DOB = ".//div[contains(text(),'DOB')]/..//select//option[@value='%s']";
    private static final String GENDER = ".//div[contains(text(),'Gender')]/..//select//option[@value='%s']";
    private static final String REVALIDATION_MISSED = ".//div[contains(text(),'revalidation missed')]/..//select//option[@value='%s']";
    private static final String NPI = ".//div[contains(text(),'National Provider Identifier')]/..//select//option[@value='%s']";
    private static final String FEIN = ".//div[contains(text(),'SSN / FEIN')]/..//select//option[@value='%s']";
    private static final String TAXONOMY = ".//div[contains(text(),'Taxonomy')]/..//select//option[@value='%s']";
    private static final String BUSINESS_NAME = ".//div[contains(text(),'Name / Doing Business as (DBA)')]/..//select//option[@value='%s']";
    private static final String ZIP = ".//div[contains(text(),'Zip')]/..//select//option[@value='%s']";
    //  private static final String REVALIDATION_MISSED = ".//div[contains(text(),'revalidation missed')]/..//select//option[@value='%s']";
    private static final String PRIMARY_BUSINESS_ADDRESS = ".//div[contains(text(),'Primary Business Address')]/..//select//option[@value='%s']";
    private static final String FINGERPRINT_BACKGROUND = ".//div[contains(text(),'Fingerprint')]/..//select//option[@value='%s']";
    private static final String PROOF_AUTHENTIFICATION = ".//div[contains(text(),'Authentication')]/..//select//option[@value='%s']";
    private static final String LICENSE_LIMITATIONS = ".//div[contains(text(),'License limitations found')]/..//select//option[@value='%s']";
    private static final String CORPORATE_DBA = ".//div[contains(text(),'Name and aliases')]/..//select//option[@value='%s']";
    private static final String BANKRUPTCY = ".//div[contains(text(),'Bankruptcy found')]/..//select//option[@value='%s']";
    private static final String LIEN_FOUND = ".//div[contains(text(),'Lien found')]/..//select//option[@value='%s']";
    private static final String APPLICATION_FEE_PAID = ".//div[contains(text(),'Application')]/..//select//option[@value='%s']";
    private static final String JUDGMENT_FOUND = ".//div[contains(text(),'Judgement')]/..//select//option[@value='%s']";
    private static final String VERIFICATION_AND_DISCLOSURE= ".//div[contains(text(),'Verification and disclosure')]/..//select//option[@value='%s']";
    private static final String DEA_NUMBER_IS_INVALID = ".//div[contains(text(),'DEA')]/..//select//option[@value='%s']";
    private static final String LANDLINE_AND_WIRELESS_NUMBERS= ".//div[contains(text(),'Land-line')]/..//select//option[@value='%s']";

    public ScreeningPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    public void setDob(String dob) {
        waitABit(200);
        findBy(format(DOB,dob)).click();
    }
    public void setGender(String gender) {
        waitABit(200);
        findBy(format(GENDER,gender)).click();
    }
    public void setRevalidationMissed(String revalidationMissed) {
        findBy(format(REVALIDATION_MISSED,revalidationMissed)).click();
    }
    public void setFein(String fein) {
        findBy(format(FEIN,fein)).click();
    }

    public void setNpi(String npi) {
        findBy(format(NPI,npi)).click();
    }

    public void setZip(String zip) {
        findBy(format(ZIP,zip)).click();
    }

    public void setTaxonomy(String taxonomy) {
        findBy(format(TAXONOMY,taxonomy)).click();
    }

    public void setBusinessName(String businessName){

        findBy(format(BUSINESS_NAME,businessName)).click();
    }

    private static final String DEA_NUMBER = ".//div[contains(text(),'DEA Number')]/..//select//option[@value='%s']";
    public void setDeaNumber(String deaNumber){

        findBy(format(DEA_NUMBER,deaNumber)).click();
    }

    public void setBusinessAddress(String primaryBusinessAddress) {
        findBy(format(PRIMARY_BUSINESS_ADDRESS, primaryBusinessAddress)).click();
    }
    public void setFingerprint(String fingerprint) {
        findBy(format(FINGERPRINT_BACKGROUND, fingerprint)).click();
    }

    public void setAuthentication(String authentication) {
        findBy(format(PROOF_AUTHENTIFICATION, authentication)).click();
    }
    //sp29
    private static final String SCREENINGPROVIDERDOB = ".//div[contains(text(),'DOB')]/..//select//option[@value='%s']";
    public void setScreeingproviderdob(String screeingproviderdob) {
        waitABit(200);
        findBy(format(SCREENINGPROVIDERDOB,screeingproviderdob)).click();
        waitABit(200);
    }

    private static final String MONITORING_FREQENCY = ".//div/label[text()='Number of days']/..";
    public void setMonitoringfrequency(String monitoringfrequency){
        waitABit(500);
        findBy(MONITORING_FREQENCY).clear();
        waitABit(500);
        findBy(MONITORING_FREQENCY).type(monitoringfrequency);
        waitABit(500);
    }

    private static final String CUT_OFF_PERSENT = ".//div[contains(text(),'Cut Off Percentage')]/..//div//input[@id='inbox-search']";
    public void setCutOffPersent(String cutOffPersent){
        waitABit(500);
        findBy(CUT_OFF_PERSENT).clear();
        waitABit(500);
        findBy(CUT_OFF_PERSENT).sendKeys(cutOffPersent);
        waitABit(500);
    }
}
