package com.hhstechgroup.ui.panels.coc;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class SelectCoCTypeModalWindow extends BaseModalPanel {

    private static final String TYPE_AFFILIATION = ".//label/span[text()='Affiliation']";
    private static final String TYPE_ENROLLMENT_DATA = ".//label/span[text()='Enrollment Data']";
    private static final String CREATE_BUTTON = ".//button[span[text() = 'Create']]";
    private static final String NEXT_BUTTON = ".//button[span[text() = 'Next']]";
    private static final String Taxonomy_Data = ".//label/span[contains(text(),'Taxonomy')]";
private static final String Add_Affiliation_Data = ".//label/span[text()='Add Affiliation']";

    public SelectCoCTypeModalWindow(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    public void clickCreateButtonInSelectTypePopUp() {
        findBy(CREATE_BUTTON).click();
//        waitForPopUpClosed();
    }
    public void clickNextButtonInSelectTypePopUp() {
        findBy(NEXT_BUTTON).click();
    }
    public void selectAffiliationType() {
        findBy(TYPE_AFFILIATION).click();
    }

    public void selectEnrollmentDataType() {
        findBy(TYPE_ENROLLMENT_DATA).click();
    }

    public void selectTaxonomyDataType(){
        findBy(Taxonomy_Data).click();
    }

    public void selectAddAffiliationDataType(){
        findBy(Add_Affiliation_Data).click();
    }

    //newly adding
    private static final String COC_NAME1 =".//div[contains(@class, 'details_blue-text_')]//div[1]";
    private static final String STATUS_APPROVED =".//div[contains(text(),'APPROVED')]";
    private static final String COC_TYPE1 =".//div[contains(@class, 'details_text-wrap_')]";
    private static final String COC_NAME2 =".//div[contains(@class, 'details_blue-text_')]//div[1]";
    private static final String STATUS_DENIED =".//div[contains(text(),'DENIED')]";
    private static final String COC_TYPE2 =".//div[contains(@class, 'details_text-wrap_')]";

    public Map<String, String> getMappedCocValuesForRecord() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("PROVIDER NAME",(findBy(format(COC_NAME1))).getText());
        map.put("TYPE",(findBy(format(COC_TYPE1))).getText());
        map.put("STATUS_APPROVED",(findBy(format(STATUS_APPROVED))).getText());
        return  map;
    }

    public Map<String, String> getMappedCocValuesForRecord1() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("PROVIDER NAME", (findBy(format(COC_NAME2))).getText());
        map.put("TYPE",(findBy(format(COC_TYPE2))).getText());
        map.put("STATUS_DENIED", (findBy(format(STATUS_DENIED))).getText());
        return map;
    }

    private static final String TYPE_ADD_AFFILIATION = ".//label/span[text()='Add Affiliation']";
    public void selectAddAffiliationType() {
        findBy(TYPE_ADD_AFFILIATION).click();
    }

    private static final String TYPE_END_AFFILIATION = ".//label/span[text()='End Affiliation']";
    public void selectEndAffiliationType() {
        findBy(TYPE_END_AFFILIATION).click();
    }

    private static final String TYPE_PROGRAMPARTICIPATION_TAXONOMY = ".//label/span[text()='Program Participation / Taxonomy / License and Service location']";
    public void selectProgramParticipationTaxonomyType() {
        findBy(TYPE_PROGRAMPARTICIPATION_TAXONOMY).click();
    }

    private static final String TYPE_EDIT_AFFILIATION = "//label/span[text()='Edit Affiliation']";
    public void selectEditAffiliationType() {
        findBy(TYPE_EDIT_AFFILIATION).click();
    }

}
