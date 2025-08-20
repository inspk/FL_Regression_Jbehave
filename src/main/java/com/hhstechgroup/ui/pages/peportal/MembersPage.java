package com.hhstechgroup.ui.pages.peportal;


import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.peportal.*;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static java.lang.String.format;
import static java.util.stream.Collectors.toMap;

public class MembersPage extends ProviderManagementBasePage {

    private static final String PAYER_DATA = ".//div[text()='Medibook']";
    private static final String FIRST_NAME = ".//input[@name = 'firstName']";
    private static final String LAST_NAME = ".//input[@name = 'lastName']";
    private static final String SEARCH_BUTTON = ".//button/span[text() = 'Search']";
    private static final String MEMBER_ROW = ".//div[contains(@class, 'table-row')]";
    private static final String MAIN_INFO_PANEL = "//div[contains(@class, 'main-info-panel_card_')]";
    private static final String CONTACT_INFORMATION = ".//div[text() = 'Contact information']";
    private static final String CONTACT_INFO_BLOCK = ".//div[contains(@class, 'contacts_contacts-wrapper_')]";
    private static final String VITAL_SIGNS_BLOCK = ".//div[contains(@class, 'details_signs-list_')]";
    private static final String VITAL_SIGNS_HEADER = ".//div[contains(@class, 'details_head')]//div[contains(@class, 'details_history-col_') and text()]";
    private static final String VITAL_SIGNS_ROWS = ".//div[contains(@class, 'details_historyItemExpanded')]//div[contains(@class, 'details_history-row_')]";
    private static final String VITAL_SIGNS_CELLS = ".//div[contains(@class, 'details_history-col_')]";
    private static final String MEMBER_INFO_TAB = ".//span[text() = '%s']/ancestor::button[contains(@class, 'members_tab_')][contains(@aria-selected, 'true')]";
    private static final String VITAL_SIGN_ROW_EXPANDED = ".//div[contains(@class, 'details_titleRow') and @aria-expanded='true']//div[text() = '%s']";
    private static final String VITAL_SIGN_ROW_HIDDEN = ".//div[contains(@class, 'details_titleRow') and @aria-expanded='false']//div[text() = '%s']";
    private static final String SECTION_HEADER = ".//h1[text() = '%s']";
    private static final String ALLERGIES_IMMUNIZATIONS = ".//div[contains(@class, 'details_bottom-blocks-container_')]";
    private static final String SECTION_TITLE = ".//h2[text() = '%s']";
    private static final String TABLE = ".//table";
    private static final String MEMBER_TAB = ".//span[text() = '%s']";
    private static final String MEDICATIONS = ".//div[contains(@class, 'members_table_')]";
    private static final String LINE_ITEM_HEADER = ".//div[contains(@class, 'details__head')]//div[span]";
    private static final String LINE_ITEM_ROWS = ".//li";
    private static final String LINE_ITEM_CELLS = ".//div[contains(@class, 'details__row')]/div";
    private static final String PCCM_SECTION = ".//div[contains(@class, 'pccm_block-')]/h1[text() = '%s']/following-sibling::*[node() = '%s']";
    private static final String PCCM_SECTION_LIST = ".//h2[text() = '%s']/following-sibling::div";
    private static final String PCCM_COLUMNS = ".//div[contains(@class, 'pccm_header')]/span";
    private static final String PCCM_ROWS = ".//div[contains(@class, 'pccm_content')]/div";
    private static final String PCCM_CELLS = ".//span[contains(@class, 'pccm_col') and not(*)]";
    private static final String PCCM_ROW_VALUE = ".//h2[text() = '%s']/following-sibling::div//span[text() = '%s']/parent::div/following-sibling::div";
    private static final String PCCM_ROW_EXPANDED = ".//h2[text() = '%s']/following-sibling::div//div[@aria-expanded='true']/following-sibling::div//div[contains(@class, '-details-')]";
    private static final String PCCM_ROW_EXPANDED_VALUE = ".//span";
    private static final String PCCM_MEMBER_DETAILS = ".//h2[text() = 'Member details']/following-sibling::div[contains(@class, 'member-details')]/div";
    private static final String MEMBER_ID = "//p[contains(text(), '%s')]//ancestor-or-self::div[contains(@class, 'summary')]";
    private static final String REQUEST_ACCESS = "//p[contains(text(), '%s')]//ancestor-or-self::div[contains(@class, 'summary')]//div[text()='Request Access']";
    private static final String SEARCH_DETAILS_BY_MEMBER_INFO = ".//div[@class = 'wr']/div[contains(@class, 'tile-table')]";
    private static final String SEARCH_DETAILS_HEADER = ".//div[contains(@class, 'tile-table-head')]/div";
    private static final String SEARCH_DETAILS_ROWS = ".//div[contains(@class, 'expansion-panel-summary')]";
    private static final String SEARCH_DETAILS_CELLS = ".//div[contains(@class, 'table-text_tooltip')]";
    private static final String SEARCH_MEMBER_RECORD = ".//p[text() = '%s']//ancestor::div[contains(@class, 'tile-table-row')]";
    private static final String MEMBERS_SEARCH = ".//div[contains(@class, 'styles_search-box-container')]";
    private static final String RESULTS_NOT_FOUND = ".//p[contains(text(),'There are no records by selected search parameters')]";

    public MembersPage(WebDriver driver) {
        super(driver);
    }

    public boolean searchTitleIsDisplayed(){
        return isElementPresent(PAYER_DATA);
    }

    public SearchForRecordPanel getSearchPanel() {
        return new SearchForRecordPanel(findBy(MEMBERS_SEARCH), this);
    }

    public void clickSearchButton(){
        findBy(SEARCH_BUTTON).click();
    }

    public void typeMemberFirstName(String firstName){
        findBy(FIRST_NAME).type(firstName);
    }

    public List<Map<String, String>>getMemberDetailsInfo() {
        return new Table(findBy(SEARCH_DETAILS_BY_MEMBER_INFO), this, SEARCH_DETAILS_HEADER, SEARCH_DETAILS_ROWS, SEARCH_DETAILS_CELLS).getListOfMappedValues();
    }

    public boolean isMemberPresent(String memberId){
        return isElementPresent(format(SEARCH_MEMBER_RECORD,memberId));
    }

    public boolean checkResultsNotFoundTextPresent() {
        return isElementPresent(RESULTS_NOT_FOUND);
    }

    public void typeMemberLastName(String lastName){
        findBy(LAST_NAME).type(lastName);
    }

    public void goToMemberDetails() {
        findBy(MEMBER_ROW).click();
    }

    public void clickOnMemberWithId (String memberId) {
        findBy(format(MEMBER_ID, memberId)).click();
    }

    public void clickOnRequestAccessWithMemberId (String memberId) {
        findBy(format(REQUEST_ACCESS, memberId)).click();
    }

    public Map<String, String> getMemberMainInfo() {
        Map<String, String> info = new MainInfoBlock(findBy(MAIN_INFO_PANEL), this).getMappedValues();
        return info.entrySet().stream().collect(toMap(Map.Entry::getKey, entry -> entry.getValue().replaceAll("\\n", " ")));
    }

    public void clickContactInfo(){
        findBy(CONTACT_INFORMATION).click();
    }

    public Map<String, String> getContactInfo() {
        Map<String, String> info = new MembersContactInfo(findBy(CONTACT_INFO_BLOCK), this).getMappedValues();
        return info.entrySet().stream().collect(toMap(Map.Entry::getKey, entry -> entry.getValue().replaceAll("\\n", " ")));
    }

    public List<Map<String, String>> getVitalSigns() {
        return new Table(findBy(VITAL_SIGNS_BLOCK), this, VITAL_SIGNS_HEADER, VITAL_SIGNS_ROWS, VITAL_SIGNS_CELLS).getListOfMappedValues();
    }

    public boolean isTabActive(String tabName){
        return isElementPresent(format(MEMBER_INFO_TAB, tabName));
    }

     public void expandHistoryForSign(String sign){
        scrollToElement(VITAL_SIGNS_BLOCK);
        waitAbit(200);
        withAction().moveToElement(findBy(format(VITAL_SIGN_ROW_HIDDEN, sign))).click().build().perform();
        waitForPresenceOf(format(VITAL_SIGN_ROW_EXPANDED, sign));
    }

    public void hideHistoryForSign(String sign){
        findBy(format(VITAL_SIGN_ROW_EXPANDED, sign)).click();
        waitForPresenceOf(format(VITAL_SIGN_ROW_HIDDEN, sign));
    }

    public boolean isSectionDisplayed(String sectionName){
        return isElementPresent(format(SECTION_HEADER, sectionName));
    }

    public void navigateToTab(String tabName){
        waitForPresenceOf(String.format(MEMBER_TAB, tabName));
        findBy(format(MEMBER_TAB, tabName)).click();
    }

    public boolean isSectionVisible(String sectionName){
        return isElementPresent(String.format(SECTION_TITLE, sectionName)) && isElementPresent(TABLE);
    }

    public List<Map<String, String>> getActualInfo() {
        return new Table(findBy(TABLE), this).getListOfMappedValues();
    }

    public Map<String, String> getAllergiesAndImmunizations() {
        return new AllergiesAndImmunizations(findBy(ALLERGIES_IMMUNIZATIONS), this).getMappedValues();
    }

    public List<Map<String, String>> getMedicationsInformation() {
        return new Table(findBy(MEDICATIONS), this, LINE_ITEM_HEADER, LINE_ITEM_ROWS, LINE_ITEM_CELLS).getListOfMappedValues();
    }

    public boolean isPccmSectionDisplayed(String sectionName, String listName) {
        return isElementPresent(format(PCCM_SECTION, sectionName, listName));
    }

    public List<Map<String, String>> getPccmRowsList(String listName) {
        return new Table(findBy(format(PCCM_SECTION_LIST, listName)), this, PCCM_COLUMNS, PCCM_ROWS, PCCM_CELLS).getListOfMappedValues();
    }

    public void clickOnPccmRow(String section, String rowValue) {
        findBy(format(PCCM_ROW_VALUE, section, rowValue)).click();
    }

    public Map<String, String> getExpandedPccmRowInformation(String section) {
        return findAll(format(PCCM_ROW_EXPANDED, section)).stream().collect(toMap(element -> element.thenFindAll(PCCM_ROW_EXPANDED_VALUE).get(0).getText(), element -> element.thenFindAll(PCCM_ROW_EXPANDED_VALUE).get(1).getText()));
    }

    public Map<String, String> getPccmMemberDetails() {
        return findAll(PCCM_MEMBER_DETAILS).stream().collect(toMap(element -> element.thenFindAll(PCCM_ROW_EXPANDED_VALUE).get(0).getText(), element -> element.thenFindAll(PCCM_ROW_EXPANDED_VALUE).get(1).getText()));
    }

    //duplicity

    public void collectAndCompareDuplicityInfo(String index){
        if(index.contains("DuplicityIndividual2") || index.contains("DuplicityGroup2") ){
            List<WebElementFacade> duplicityInfo = findAll(SEARCH_DETAILS_ROWS);
            for (int i = 0; i < 1 ; i++) {
                String textDuplicityRow1 = duplicityInfo.get(i).getText();
                System.out.println("FIRST ROW: " + textDuplicityRow1);
            }
        }
    }

/*    public void collectAndCompareDuplicityInfo(String index){
        if(index.contains("DuplicityIndividual002") || index.contains("DuplicityGroup2")){
            List<WebElementFacade> duplicityInfo = findAll(SEARCH_DETAILS_ROWS);
            for (int i = 0; i < 1 ; i++) {
                String textDuplicityRow1 = duplicityInfo.get(i).getText();
                System.out.println("FIRST ROW: " + textDuplicityRow1);
               String textDuplicityRow2 = duplicityInfo.get(i + 1).getText();
               System.out.println("SECOND ROW: " + textDuplicityRow2);
               Assert.assertTrue(textDuplicityRow1.contains(textDuplicityRow2));
            }
        }
    }*/

    private static final String CELL_DUPLICITY_TABLE = "//div[contains(@class, 'table-text_table')]";

    public void verifyPercentageOfDuplicity(String percentage, String index){
        if(index.contains("DuplicityIndividual2") || index.contains("DuplicityGroup2")){
            String textDuplicityRow1 = findAll(CELL_DUPLICITY_TABLE).get(0).getText();
            System.out.println("FIRST ROW PERCANTAGE: " + textDuplicityRow1);
//            Assert.assertTrue(textDuplicityRow1.contains(percentage));
        }
    }

 /*   public void verifyPercentageOfDuplicity(String percentage, String index){
        if(index.contains("DuplicityIndividual001") || index.contains("DuplicityGroup2")){
            String textDuplicityRow1 = findAll(CELL_DUPLICITY_TABLE).get(0).getText();
            System.out.println("FIRST ROW PERCANTAGE: " + textDuplicityRow1);
//            String textDuplicityRow2 = findAll(CELL_DUPLICITY_TABLE).get(9).getText();
//            System.out.println("SECOND ROW PERCANTAGE: " + textDuplicityRow2);
            Assert.assertTrue(textDuplicityRow1.contains(percentage));
//            Assert.assertTrue(textDuplicityRow2.contains(percentage));

        }
    }*/

}
