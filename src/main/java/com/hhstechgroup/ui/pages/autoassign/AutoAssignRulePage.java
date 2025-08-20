package com.hhstechgroup.ui.pages.autoassign;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.iuportal.AutoAssignSearchPanel;
import com.hhstechgroup.ui.panels.iuportal.EnrollmentSearchPanel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static java.lang.String.format;


public class AutoAssignRulePage extends AbstractPage {
    private static final String CLICK_CREATE_RULE_BUTTON = ".//button/span[text()='Create rule']";
    private static final String RULE_NAME = ".//div[contains(text(),'New rule')]/..";
    private static final String RULE_NAME_TEXT = ".//div/textarea[text()='New rule']";
    private static final String FILL_RULE_NAME =  ".//div/textarea[@placeholder='Add name']" ;
    private static final String EFFECTIVE_DATE_FROM = ".//label[contains(text(), 'Effective From')]/parent::div//input[contains(@placeholder,'%s')]";
   // private static final String EFFECTIVE_DATE_FROM = ".//label[contains(text(), 'Effective From')]/parent::div//button";
    private static final String EFFECTIVE_DATE_END= ".//label[contains(text(), 'Effective End Date')]/parent::div//input[contains(@placeholder,'%s')]";
   //private static final String EFFECTIVE_DATE_END= ".//label[contains(text(), 'Effective End Date')]/parent::div//button";
    private static final String CLICK_HIDDEN_DROPDOWN =  "//input[contains(@id,'%s')]/preceding-sibling::div";
    private static final String PARAMETER = ".//ul[@role='listbox']//li[text()='%s']";

    private static final String CLICK_HIDDEN_DROPDOWN2 =  "(//input[contains(@id,'%s')]/preceding-sibling::div)[2]";
    private static final String CLICK_ADD_CONDITION_LINK = ".//div/a[text()='Add condition']";
    private static final String SELECT_CONDITONS = ".//div[contains(@class,'auto-assign_conditions')]/div/div[text()='%s']";

    private static final String CLICK_SAVE_OR_CANCEL_BUTTON = ".//button/span[text()='%s']/..";

    public AutoAssignRulePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCreateRuleButton(){
        scrollToElement(CLICK_CREATE_RULE_BUTTON);
        jsClick(CLICK_CREATE_RULE_BUTTON);
    }
    public void fillRuleName(String rulename) {
        jsClick(RULE_NAME);
        findBy(RULE_NAME_TEXT).click();
      //  jsClick(RULE_NAME);
       findBy(format(RULE_NAME_TEXT,rulename)).clear();
        findBy(FILL_RULE_NAME).type(rulename);
    }

    public void clickOnAddConditionLink() {
        waitABit(1000);
        scrollToElement(CLICK_ADD_CONDITION_LINK);
        jsClick(CLICK_ADD_CONDITION_LINK);
    }

//    public void setApplicationType(String dropdown,String parameter) {
//        waitABit(1000);
//        findBy(format(CLICK_HIDDEN_DROPDOWN,dropdown)).click();
//        scrollToElement(format(PARAMETER,parameter));
//        waitABit(1000);
//        findBy(format(PARAMETER,parameter)).click();
//        waitABit(1000);
//
//    }


    public void setParameter(String dropdown,String parameter) {
        waitABit(500);
        //sp32
//        jsClick(format(CLICK_HIDDEN_DROPDOWN,dropdown));
       findBy(format(CLICK_HIDDEN_DROPDOWN,dropdown)).click();
       //scrollToElement(format(PARAMETER,parameter));
        waitABit(500);
        findBy(format(PARAMETER,parameter)).click();
        waitABit(500);

    }
    //sp22
    private static final String CLICK_HIDDEN_DROPDOWN1 =  "//input[contains(@id,'%s')]/preceding-sibling::div";
    private static final String PARAMETER1 = ".//ul[@role='listbox']//li[contains(text(),'%s')]";
    public void setDocumentReviewParameter(String dropdown3,String parameter3) {
        waitABit(500);
        jsClick(format(CLICK_HIDDEN_DROPDOWN1,dropdown3));
        waitABit(500);
        findBy(format(PARAMETER1,parameter3)).click();
        waitABit(500);
    }

    public void setsecondParameter(String dropdown,String parameter) {
        waitABit(500);
        findBy(format(CLICK_HIDDEN_DROPDOWN2,dropdown)).click();
        scrollToElement(format(PARAMETER,parameter));
        waitABit(500);
        findBy(format(PARAMETER,parameter)).click();
        waitABit(500);

    }
    private static final String CLICK_HIDDEN_DROPDOWN3 =  "//input[contains(@id,'%s')]/preceding-sibling::div";
    private static final String ENTER_VALUE =  "//input[contains(@id,'%s')]/preceding-sibling::div[text()='%s']/../../../../../../..//div/input[contains(@id,'value-')]";
    public void setThirdParameter(String dropdown,String parameter) {
        waitABit(500);
        findBy(format(CLICK_HIDDEN_DROPDOWN3,dropdown)).click();
        scrollToElement(format(PARAMETER,parameter));
        waitABit(500);
        findBy(format(PARAMETER,parameter)).click();
        waitABit(500);
    }
    public void fillValue(String parameter,String name,String value){
        waitAbit(3000);
    jsClick(ENTER_VALUE);
    waitAbit(2000);
        findBy(ENTER_VALUE).type(value);
    }

    public void clickOnDropdown() {
        findBy(CLICK_HIDDEN_DROPDOWN).click();
       // findBy(CLICK_HIDDEN_DROPDOWN).waitUntilClickable().click();
        // jsClick(CLICK_HIDDEN_DROPDOWN);
    }

    public void selectCondtions(String condition) {
     //   scrollToElement(SELECT_CONDITONS);
        waitAbit(500);
        findBy(format(SELECT_CONDITONS,condition)).click();
        waitAbit(500);
    }

    public void clickOnSaveOrCancelButton(String saveOrCancel) {
        scrollToElement(format(CLICK_SAVE_OR_CANCEL_BUTTON,saveOrCancel));
        waitAbit(500);
        findBy(format(CLICK_SAVE_OR_CANCEL_BUTTON,saveOrCancel)).click();
    }

    private static final String CLICK_SEACH_RULE = ".//div[contains(@class,'search-button_ico_')]";
    private static final String SEARCH_RULE = ".//div/input[@id='inbox-search']";
    private static final String RULE_ACTION_MENU = ".//div[contains(@class,'auto-assign_aa-list-item')]//div/button";

    public void seachByRuleName(String ruleName){
        scrollToElement(CLICK_SEACH_RULE);
        //sp44.2
        jsClick(CLICK_SEACH_RULE);
        //findBy(CLICK_SEACH_RULE).click();
        findBy(SEARCH_RULE).type(ruleName);
        findBy(SEARCH_RULE).sendKeys(Keys.ENTER);
    }
    protected static final String DROP_DOWN_OPTION = ".//ul/li[text() = '%s']";
    public void selectRemoveOption(String action){
        waitAbit(3000);
        scrollToElement(RULE_ACTION_MENU);
//        waitAbit(500);
        findBy(RULE_ACTION_MENU).click();
        findBy(RULE_ACTION_MENU).click();
          waitABit(5000);
        action().moveToElement(findBy(String.format(DROP_DOWN_OPTION, action))).click().build().perform();
        waitAbit(500);
    }

    private static final String CLICK_OK = ".//button/span[text()='OK']";

    public void removeRuleFromRuleList(){
        findBy(CLICK_OK).click();
    }

    private static final String EFFECTIVE_FROM_DATE = ".//label[contains(text(),'Effective From')]/..//div/input[@placeholder='MM/DD/YYYY']";
    private static final String EFFECTIVE_END_DATE = ".//label[contains(text(),'Effective End')]/..//div/input[@placeholder='MM/DD/YYYY']";


    public void fillEffecteDates(String dateFrom,String dateEnd){

        jsClick(EFFECTIVE_FROM_DATE);
        findBy(EFFECTIVE_FROM_DATE).click();
        findBy(format(EFFECTIVE_FROM_DATE,dateFrom)).clear();
        findBy(EFFECTIVE_FROM_DATE).type(dateFrom);
        jsClick(EFFECTIVE_END_DATE);
        findBy(EFFECTIVE_END_DATE).click();
        findBy(format(EFFECTIVE_END_DATE,dateEnd)).clear();
        findBy(EFFECTIVE_END_DATE).type(dateEnd);
    }
    private static final String PROVIDER_NAME= "(.//div/input[contains(@id,'value-')])[2]";
    public void typeProviderName(String providerName) {findBy(PROVIDER_NAME).type(providerName);}

    private static final String CONDITION= ".//div/div[contains(text(),'%s')]";
    public void setConditon(String condition) {
        findBy(format(CONDITION,condition)).click();
    }

    //sp23
    private static final String AUTOASSIGN_PANEL = ".//div[contains(@class,'auto-assign_aa-list-head_')]/div/../..";
    public AutoAssignSearchPanel getAutoAssignPanel() {
        return new AutoAssignSearchPanel(findBy(AUTOASSIGN_PANEL), this);
    }
//sp24
    private static final String CLICK_AUTOASSIGN_RULE= ".//div[contains(@class,'auto-assign_aa-list-itme-inner_')]";
    public void clickRuleFromRuleList(){
        waitAbit(500);
        jsClick(CLICK_AUTOASSIGN_RULE);
        waitAbit(1000);
    }

    private static final String   CLICK_BACK_TO_LIST= ".//div/span";
    public  void clickOnBckToList(String button) {
        waitAbit(500);
        jsClick(CLICK_BACK_TO_LIST);
    }

    private static final String VIEW_HISTORY_BUTTON = ".//div[contains(@class,'auto-assign_history-outer_')]/div[contains(@class,'auto-assign_history-btn_')]//*[local-name() = 'svg' and @aria-hidden='true' ]/..";
    public boolean verifyViewHistorytButton() {
        waitAbit(500);
        return findBy(VIEW_HISTORY_BUTTON).isDisplayed();
    }

    public void clickVeiwHistoryButton() {
        waitAbit(200);
        scrollToElement(VIEW_HISTORY_BUTTON);
        waitAbit(200);
        jsClick(VIEW_HISTORY_BUTTON);
        waitAbit(500);
    }

    private static final String ClICK_EFFECTIVE_DATES=".//div[contains(@class,'auto-assign_content_')]";
    public void clickEffectiveDates() {
        waitAbit(200);
        scrollToElement(ClICK_EFFECTIVE_DATES);
        waitAbit(200);
        findBy(ClICK_EFFECTIVE_DATES).click();
        waitAbit(1000);
    }

    private static final String ClICK_BACK_TO_HISTORY_RECORDS=".//div[contains(@class,'breadcrumb_breadcrumb_')]/span";
    public void clickBackToHistoryRecords(String button) {
        waitAbit(200);
        scrollToElement(ClICK_BACK_TO_HISTORY_RECORDS);
        waitAbit(200);
        findBy(ClICK_BACK_TO_HISTORY_RECORDS).click();
        waitAbit(500);
    }

    private static final String VEIW_HISTORY_PANEL = ".//div[contains(@class,'auto-assign_site-visit-view-istory-table_')]/..";
    public AutoAssignSearchPanel getViewhistoryPanel() {
        return new AutoAssignSearchPanel(findBy(VEIW_HISTORY_PANEL), this);
    }
    private static final String EDIT_BUTTON = ".//button/span[text()='Edit']";
    public void clickEditButton() {
        waitAbit(200);
        scrollToElement(EDIT_BUTTON);
        waitAbit(200);
        findBy(EDIT_BUTTON).click();
        waitAbit(500);
    }

    private static final String EXIT_BUTTON=".//div[contains(@class,'auto-assign_history-title-with-edit_')]/div/button/Span/../..";
    public void clickExitButton(String eixt) {
        waitAbit(200);
        scrollToElement(EXIT_BUTTON);
        waitAbit(200);
        findBy(EXIT_BUTTON).click();
        waitAbit(500);
    }

    //sp37
    private static final String RISK_LEVEL_VALUE=".//label[contains(text(),'value')]/..//div/input[@type='text']";
    public void typerisklevelvalue(String value) {
        waitAbit(200);
        findBy(RISK_LEVEL_VALUE).click();
        findBy(RISK_LEVEL_VALUE).type(value);
        waitAbit(500);
    }

    private static final String CLICK_HIDDEN_DROPDOWN4 =  "//input[contains(@id,'%s')]/preceding-sibling::div";
    private static final String PARAMETER4 = ".//ul[@role='listbox']//li[contains(text(),'%s')]";
    public void setstatusParameter(String dropdown3,String parameter3) {
        waitABit(500);
        jsClick(format(CLICK_HIDDEN_DROPDOWN4,dropdown3));
        waitABit(2000);
        jsClick(format(PARAMETER4,parameter3));
        waitABit(1000);
    }

    //in SP-73 Adding click for new rules section

    private static final String RULE=".//p[contains(text(),'%s')]//parent::div/../../..";
    public void clickOnRules(String action){
        waitABit(500);
        jsClick(format(RULE,action));
        waitABit(2000);
    }

    private static final String ACTION_RULE_DROPDOWN =  "//div[contains(@class, 'rule-editor_aa-item-action')]//input[contains(@id,'%s')]/preceding-sibling::div";
    public void setActionParameter(String dropdown,String parameter) {
        waitABit(500);
        findBy(format(ACTION_RULE_DROPDOWN,dropdown)).click();
        scrollToElement(format(PARAMETER,parameter));
        waitABit(500);
        findBy(format(PARAMETER,parameter)).click();
        waitABit(500);
    }

}

