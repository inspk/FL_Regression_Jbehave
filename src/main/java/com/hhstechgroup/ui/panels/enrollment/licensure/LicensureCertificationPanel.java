package com.hhstechgroup.ui.panels.enrollment.licensure;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class LicensureCertificationPanel extends BaseEnrollmentPanel {

    private static final String PROVIDER_TYPE = "Provider type";
    private static final String PROGRAM_PARTICIPATION = "Program participation";
    private static final String DESIGNED_BY_CMS = "CMS";
    private static final String SPECIALITY = "Specialty";
    private static final String GROUP_SPECIALITY = "Speciality";
    private static final String ANOTHER_STATE = "Are you or have you ever provide MCO services in another state?";
    private static final String OTHER_STATE = "Current/Recent other Medicaid state";
    private static final String LICENSURE_TABLE = ".//div[h4[contains(text() , 'Licensure')]]/following-sibling::div//div[table]/ancestor::div[2]";
   //new sp20
    private static final String SPECIALITIES_AND_SUBSPECIALITIES = "Please Chose Type of Enrollment";
    public LicensureCertificationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public LicensureTable getLicensureTable() {
        scrollToElement(LICENSURE_TABLE);
        return new LicensureTable(findBy(LICENSURE_TABLE), getBasePage());
    }

    public void setProviderType(String providerType) {
        select(PROVIDER_TYPE, providerType);
    }

    public void setProgramParticipation(String programParticipation) {
        select(PROGRAM_PARTICIPATION, programParticipation);
    }

    public void setDesignedByCms(String designedByCms) {
        selectRadionButton(DESIGNED_BY_CMS, designedByCms);
    }

    public void setSpeciality(String speciality) {
      //  waitABit(500);
        setCheckbox(SPECIALITY, speciality);
    }

    public void setAnotherState(String anotherState) {
        selectRadionButton(ANOTHER_STATE, anotherState);
    }

    public void setOtherState(String otherState) {
        select(OTHER_STATE, otherState);
    }

    public String getSpeciality() {
        return getCheckboxValue(SPECIALITY);
    }

    public void setGroupSpeciality(String speciality) {
        setCheckbox(GROUP_SPECIALITY, speciality);
    }

    public String setGroupSpeciality() {
        return getCheckboxValue(GROUP_SPECIALITY);
    }
   //new sp20
    public void setSpecialitiesandsubspecialities(String specialitiesandsubspecialities) {
        selectRadionButton(SPECIALITIES_AND_SUBSPECIALITIES, specialitiesandsubspecialities);
        waitABit(3000);
    }
    //sp26
    private static final String TAXONOMY_CATEGORY = "Please select Taxonomy Category (Specialties)";
    public void setTaxonomyCategory(String taxonomyCategory) {
        waitABit(500);
        selectRadionButton(TAXONOMY_CATEGORY,taxonomyCategory);
        waitABit(1000);
    }

    private static final String PRIMARY_TAXONOMY = "//label[text()='Primary Taxonomy']//ancestor::div[@role='combobox']//input";
    private static final String PRIMARY_TAXONOMY_OPTION = ".//div[contains(@role,'menuitem')]/../div/div/strong[contains(text(),'%s')]";
    public void setPrimaryTaxonomy(String primaryTaxonomy) {
        waitABit(1000);
        findBy(PRIMARY_TAXONOMY).click();
        waitABit(500);
        scrollToElement(format(PRIMARY_TAXONOMY_OPTION,primaryTaxonomy));
        waitABit(1000);
    }
    //sp29
    private static final String PHARMACY_TPYE = "Pharmacy Type (Select All that Applies)";
    public void setPharmacyType(String pharmacyType){
        waitABit(500);
        setCheckbox(PHARMACY_TPYE,pharmacyType);
        waitABit(1000);
    }

    //Demo for Individual
    private static final String DEA_NUMBER = "//input[@placeholder='_________']";
    public void setDeaNumber(String deaNumber) {
        waitABit(500);
        scrollToElement(DEA_NUMBER);
        jsClick(DEA_NUMBER);
        waitABit(1000);
        findBy(DEA_NUMBER).sendKeys(deaNumber);
        waitABit(1000);

    }





}
