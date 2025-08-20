package com.hhstechgroup.ui.panels.systemoptions;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.security.Key;
import java.util.List;

import static java.lang.String.format;

public class ExternalizationPanel extends BaseEnrollmentPanel {
    public ExternalizationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    //adding Taxonomy in sp21
    private static final String  TAXONOMY = ".//input[contains(@id,'taxonomy')]";
    private static final String  TAXONOMY_DESCRIPTION = ".//input[contains(@id,'description')]";
//    private static final String  SPECIALITY_FIELD =".//input[contains(@id, 'Specialty')]/preceding-sibling::div";
    //sp22
    //private static final String  SPECIALITY_FIELD = ".//input[contains(@id, 'Speciality')]/preceding-sibling::div";
    //sp39.2
    private static final String  SPECIALITY_FIELD =".//label[contains(text(), 'Specialty')]/following-sibling::div//input/preceding-sibling::div";
    private static final String  SPECIALITY = "//ul/li[contains(text(), '%s')]";
    private static final String  CLAIM_TYPE_FIELD =".//input[contains(@id, 'Claim Type')]/preceding-sibling::div";
    private static final String  CLAIM_TYPE = "//ul/li[contains(text(), '%s')]";
    private static final String  RISK_LEVEL_FIELD =".//input[contains(@id, 'Risk Level')]/preceding-sibling::div";
    private static final String  RISK_LEVEL = "//ul/li[contains(text(), '%s')]";
    private static final String  FINGER_PRINT_VERIFICATION = ".//p[contains(text(), 'Fingerprint Verification Required')]/following-sibling::div//span[text() = '%s']/preceding-sibling::span//input";
    //private static final String  REQUIRES_TYPE = ".//span[contains(text(), '%s')]/../../..//input";

    public void setTaxonomy(String taxonomy) {
        findBy(TAXONOMY).type(taxonomy);
    }

    public void setTaxonomyDescription(String taxonomyDescription) {
        findBy(TAXONOMY_DESCRIPTION).type(taxonomyDescription);
    }

    public void setSpeciality(String speciality) {
        waitABit(500);
        jsClick(SPECIALITY_FIELD);
        scrollToElement(format(SPECIALITY,speciality));
        waitABit(500);
        findBy(format(SPECIALITY,speciality)).click();
        waitABit(500);
    }
    private static final String DROPDOWN_LIST = "//div[@role='document']/ul";
    public void setClaimType(String claimType) {
        waitABit(500);
        jsClick(CLAIM_TYPE_FIELD);
        scrollToElement(format(CLAIM_TYPE,claimType));
        findBy(format(CLAIM_TYPE,claimType)).click();
        findBy(format(CLAIM_TYPE,claimType)).sendKeys(Keys.ESCAPE);
       // waitForAbsenceOf(DROPDOWN_LIST);
//        waitForAbsenceOf(CLAIM_TYPE);
      //  jsClick(TAXONOMY);
        waitABit(1000);


    }

    public void setRiskLevel(String riskLevel) {
        waitABit(500);
        jsClick(RISK_LEVEL_FIELD);
        scrollToElement(format(RISK_LEVEL,riskLevel));
        waitABit(500);
        findBy(format(RISK_LEVEL,riskLevel)).click();
        waitABit(500);

    }

    public void setFingerPrintVerification(String fingerPrintVerification) {
        scrollToElement(format(FINGER_PRINT_VERIFICATION,fingerPrintVerification));
        findBy(format(FINGER_PRINT_VERIFICATION,fingerPrintVerification)).click();


    }

   // sp62
    private static final String  REQUIRES_TYPE =".//span[contains(text(),'%s')]/..//input[@id='requireFees']"  ;
    public void setRequireType(String requireType) {
        scrollToElement(format(REQUIRES_TYPE,requireType));
        findBy(format(REQUIRES_TYPE,requireType)).click();

    }
}
