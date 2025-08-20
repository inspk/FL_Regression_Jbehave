package com.hhstechgroup.ui.panels.enrollment.affiliation;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.KeyValueMapper;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class AffiliationPanel extends BaseEnrollmentPanel implements KeyValueMapper {

    private static final String AFFILIATION_TITLE = ".//div[contains(@class, 'affiliation_section-header')]/h3[text() = 'Provider affiliation information']";
    private static final String AFFILIATION_SEARCH_FIELD = "//input[contains(@id,'providerNameNpi')]";
    private static final String AFFILIATION_SEARCH_BUTTON = "//button/span[text()='Search']";
    private static final String AFFILIATION_TABLE = ".//div[contains(@class, 'affiliation_table')]";
    private static final String AFFILIATION_ADD_BUTTON = "//button/span[text()='Add']";
    private static final String AFFILIATION_TYPE = "Affiliation type";
    private static final String COLUMNS = ".//div[contains(@class, 'affiliation_head')]/span[text()]";
    private static final String ROWS =".//div[contains(@class, 'affiliation_provider-list-item')]";
    private static final String CELLS =".//div[text()]";
    private static final String CELL_TEXT = "./.";
    private WebElementFacade row;

    public AffiliationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }


    public void setAffiliationField(String affiliationNpiValue) {
        findBy(AFFILIATION_SEARCH_FIELD).type(affiliationNpiValue);
    }

    public void clickSearchAffiliationButton() {
        scrollToElement(AFFILIATION_SEARCH_BUTTON);
        waitABit(500);
        findBy(AFFILIATION_SEARCH_BUTTON).click();
    }

    public void clickAddAffiliationButton() {
        waitABit(1000);
        jsClick(AFFILIATION_ADD_BUTTON);
    }

    @Override
    public List<Map<String, String>> getListOfMappedValues() {
        return findAll(ROWS).stream().map(row -> {
            this.row = row;
            return getMappedValues();
        }).collect(toList());
    }
    @Override
    public  Map<String, String> getMappedValues() {
        Map<String, String> affiliationDetails = new HashMap<>();
        findAll(COLUMNS).forEach(detail -> affiliationDetails.put(detail.getText().replaceAll("&amp;", "&"), getVisibleText(row.thenFindAll(CELLS).get(getPositionRelatedToSibling(detail) - 1))));
        return affiliationDetails;
    }
    private String getVisibleText(WebElementFacade element) {
        return element.thenFindAll(CELL_TEXT).stream().filter(WebElementFacade::isCurrentlyVisible).map(el -> el.getText().replaceAll("\\n", " ")).collect(Collectors.joining(" "));
    }

    //SD-08
    private static final String TYPE = "(//div[@role=\"button\"])[2]";
    private static final String SELECT_TYPE="//div//ul[@role='listbox']//li[text()='%s']";
    public void setTypeAffiliationDropdownValue(String type){
        waitABit(1000);
//        selectFromDropDown(TYPE, type);
        findBy(TYPE).click();
        waitABit(100);
        findBy(format(SELECT_TYPE, type)).click();
        waitABit(1000);
    }

    private static final String ADD_AFFILIATION = "//button/span[text()='ADD AFFILIATION']";
    public void addAffiliation(){
        scrollToElement(ADD_AFFILIATION);
        waitABit(500);
        findBy(ADD_AFFILIATION).click();
        waitABit(500);
    }

    private static final String ALL_AFFILIATIONS = "//div[contains(@class, 'affiliation_provider-item')]/div/parent::div//span/input[@type='checkbox' and @value='this.value']";
    public void selectAllAffiliations(){
        waitABit(500);
        findBy(ALL_AFFILIATIONS).click();
        waitABit(500);
    }

    private static final String AFFILIATION_ROW = "//div[contains(@class, 'affiliation_provider-item')]/div[text()='%s']/parent::div//span/input[@type='checkbox' and @value='rowUpdate']";
    public void selectAffiliationByRowText(String text){
        waitABit(500);
        findBy(format(AFFILIATION_ROW, text));
        waitABit(500);
    }

    private static final String ADD_BULK_AFFILIATION = "//button/span[text()='Bulk Add Affiliations']";
    public void clickAddBulkAffiliationButton(){
        waitABit(500);
        findBy(ADD_BULK_AFFILIATION).click();
    }

    private static final String YES_NO_BUTTON = "//div[div[text()='%s']]/div/button[span[text()='%s']]";
    public void clickOptionToQuestion(String option, String question){
        waitABit(500);
        findBy(format(YES_NO_BUTTON, question, option)).click();
        waitABit(500);
    }

    private static final String SSN = "SSN";
    public void setSsnAffiliationDropdownValue(String value){
        waitABit(1000);
        fillModifiedField(SSN, value);
        waitABit(1000);
        findBy("//*").click();
    }

    private static final String DOB = "DOB";
    public void setDobAffiliationDropdownValue(String value){
        waitABit(1000);
        fillModifiedField(DOB, value);
        waitABit(1000);
        findBy("//*").click();
    }
    private static final String AFFILIATE_Individual ="//span[text() = 'Yes']/..";
    public void addAffiliationgroup() {
        scrollToElement(ADD_AFFILIATION);
        waitABit(500);
        findBy(ADD_AFFILIATION).click();
        waitABit(500);
        findBy(AFFILIATE_Individual).click();
        waitABit(500);
    }
    private static final String SERACH_WITH_PROVIDERID="//input[@id='providerID']";
    public void setProviderIDValueSearchField(String providerId){
        findBy(SERACH_WITH_PROVIDERID).type(providerId);
    }

    private static final String AFFILIATION_MORE="(//div[contains(text(),'%s')]/..//div//button//*[name()='svg'])[1]";
    private static final String END="//button[@type='button']//span[contains(text(),'End')]";
    public void endAffiliation(String affiliationType){
        waitABit(400);
        findBy(String.format(AFFILIATION_MORE, affiliationType)).click();
        waitABit(500);
        findBy(END).click();
        waitABit(2000);
    }
    private static final String TAXONOMY_AND_PROVIDERTYPE="//input[contains(@name,'providerPPRadio')]";
    public void clickOnTaxonomyAndProviderType(){
        waitABit(3000);
        findBy(TAXONOMY_AND_PROVIDERTYPE).click();
        waitABit(4000);
    }
}
