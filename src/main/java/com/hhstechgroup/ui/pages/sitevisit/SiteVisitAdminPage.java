package com.hhstechgroup.ui.pages.sitevisit;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.iuportal.AutoAssignSearchPanel;
import com.hhstechgroup.ui.panels.systemoptions.SiteVisitRiskLevelPanel;
import org.openqa.selenium.WebDriver;
import static java.lang.String.format;

public class SiteVisitAdminPage extends ProviderManagementBasePage {

    private static final String SITE_VISIT = "//div//h1[text()='Site Visit']";
    private static final String SITE_VISIT_PAGE = "//div[text()='Site Visit']";
    //private static final String EDIT_BUTTON = "//div//button[@type='button']";
    //sp66
    private static final String EDIT_BUTTON = ".//button[contains(@class,'edit')]";
    //private static final String ADD_BUTTON = "//div//span[text()='+ Add']";
    //private static final String ADD_BUTTON = "//button//span[text()=' + Add']";
    //sp20
    private static final String ADD_BUTTON = "//button//span[text()='Add']";
    private static final String RISK_LEVEL = "//input[@id='risklevelidentifier']";
    private static final String SCORE_MIN_VALUE = "//input[@id='minValue']";
    private static final String SCORE_MAX_VALUE = "//input[@id='maxValue']";


    private static final String SCHEDULE_MIN_VALUE = "//input[@id='minValue2']";
    private static final String SCHEDULE_MONTHS = "(.//div//div[@role='button'])[1]";
    private static final String SCHEDULE_MONTHS1 = "//div//ul[@role='listbox']//li[contains(@role,option) and @data-value='MONTH']";


//    private static final String REMAINDER_FIRST="//div[@style='display: block;'][3]//div//input[@id='first']";
//    private static final String REMAINDER_SECOND="//div[@style='display: block;'][3]//div//input[@id='second']";
//    private static final String REMAINDER_THIRD="//div[@style='display: block;'][3]//div//input[@id='third']";

//updating part of sp20

    private static final String REMAINDER_FIRST = "//div//input[@id='first']";
    private static final String REMAINDER_SECOND = "//div//input[@id='second']";
    private static final String REMAINDER_THIRD = "//div//input[@id='third']";


    private static final String SELECT_REMAINDER_FIRST_DAYS = "(//div[@role='button'])[2]";
    //private static final String CLICK_REMAINDER_FIRST_DAYS = "//ul[@role='listbox']//li[contains(@tabindex,'0') and @data-value='DAY']";
    //private static final String CLICK_REMAINDER_FIRST_DAYS = "//div[@id='menu-']//ul[@role='listbox']//li[text()='day(s)']";
    //sp39.2
    private static final String CLICK_REMAINDER_FIRST_DAYS = "//div//ul[@role='listbox']//li[contains(@role,option) and @data-value='DAY']";
    private static final String SELECT_REMAINDER_SECOND_DAYS = "(//div[@role='button'])[3]";
    //private static final String CLICK_REMAINDER_SECOND_DAYS = "//ul[@role='listbox']//li[contains(@tabindex,'-1') and @data-value='DAY']";
    // private static final String CLICK_REMAINDER_SECOND_DAYS = "//ul[@role='listbox']//li[contains(text(),'day(s)')]";
    private static final String CLICK_REMAINDER_SECOND_DAYS = "//div//ul[@role='listbox']//li[contains(@role,option) and @data-value='DAY']";
    private static final String SELECT_REMAINDER_THIRD_DAYS = "(//div[@role='button'])[4]";
    //private static final String CLICK_REMAINDER_THIRD_DAYS = "//ul[@role='listbox']//li[contains(text(),'day(s)')]";
    private static final String CLICK_REMAINDER_THIRD_DAYS = "//div//ul[@role='listbox']//li[contains(@role,option) and @data-value='DAY']";

//    private static final String CLICK_SAVE_BUTTON = "(//button[@type='button'])[9]/span[text()='Save']";
//    private static final String CLICK_CANCEL_BUTTON = "(//button[@type='button'])[8]/span[text()='Cancel']";

    //sp20 updating
    private static final String CLICK_SAVE_BUTTON = "(//button[@type='button']/span[text()='Save'])[2]";
    private static final String CLICK_CANCEL_BUTTON = "(//button[@type='button']/span[text()='Cancel'])[2]";

    public static final String DIALOGUE_BOX = "//div[@role='alertdialog']//div/span[text()='Risk Level Identifier Already Exist']";

    public SiteVisitAdminPage(WebDriver driver) {
        super(driver);
    }


    public void setFirst(String first) {
        findBy(REMAINDER_FIRST).type(first);
    }

    public void setSecond(String second) {
        findBy(REMAINDER_SECOND).type(second);
    }

    public void clickOnSiteVisit() {
        findBy(SITE_VISIT).click();
    }

    //verify the site visit page is displayed
    public boolean verifyThePage() {
        return findBy(SITE_VISIT_PAGE).isDisplayed();
    }

    //click on the edit button
    public void clickoneditbutton() {
        waitAbit(1000);
        scrollToElement(EDIT_BUTTON);
        waitAbit(1000);
        findBy(EDIT_BUTTON).click();
        waitAbit(5000);
    }

    // click on the add button
    public void clickonAddButton() {
        jsClick(ADD_BUTTON);
        waitAbit(5000);
    }

    //verify the Add risk level page
    public boolean verifyAddRiskLevelpage() {
        return findBy(RISK_LEVEL).isDisplayed();
    }

    public void fillRiskLevelIdetifier(String riskLevelIdetifier) {
        findBy(RISK_LEVEL).type(riskLevelIdetifier);
    }

    private static final String RISK_LEVEL1 = ".//input[@id='riskcategory']";

    public void editRiskLevelIdetifier(String riskLevelIdetifier) {
        findBy(RISK_LEVEL1).click();
        findBy(RISK_LEVEL1).clear();
        findBy(RISK_LEVEL1).type(riskLevelIdetifier);
    }

    private static final String SCORE_MIN_VALUE1 = ".//input[@id='minvalue']";

    public void editMinValue(String minValue) {
        findBy(SCORE_MIN_VALUE1).click();
        findBy(SCORE_MIN_VALUE1).clear();
        findBy(SCORE_MIN_VALUE1).type(minValue);
    }

    private static final String SCORE_MAX_VALUE1 = ".//input[@id='maxvalue']";

    public void editMaxValue(String maxValue) {
        findBy(SCORE_MAX_VALUE1).click();
        findBy(SCORE_MAX_VALUE1).clear();
        findBy(SCORE_MAX_VALUE1).type(maxValue);
    }

    private static final String SCHEDULE_MIN_VALUE1 = ".//input[@id='siteVisitScheduleTime']";

    public void editScheduleMinVale(String scheduleMinValue) {
        findBy(SCHEDULE_MIN_VALUE1).click();
        findBy(SCHEDULE_MIN_VALUE1).clear();
        findBy(SCHEDULE_MIN_VALUE1).type(scheduleMinValue);
    }

    private static final String EDIT_FIRST_REMAINDER = ".//input[@id='first']";
    private static final String EDIT_SECOND_REMAINDER = ".//input[@id='second']";
    private static final String EDIT_THIRD_REMAINDER = ".//input[@id='third']";


    public void editFirstRemainder(String firstvalue) {
        findBy(EDIT_FIRST_REMAINDER).click();
        findBy(EDIT_FIRST_REMAINDER).clear();
        findBy(EDIT_FIRST_REMAINDER).type(firstvalue);
    }

    public void editSecondRemainder(String secondvalue) {
        findBy(EDIT_SECOND_REMAINDER).click();
        findBy(EDIT_SECOND_REMAINDER).clear();
        findBy(EDIT_SECOND_REMAINDER).type(secondvalue);

    }

    public void editThirdRemainder(String thirdvalue) {
        findBy(EDIT_THIRD_REMAINDER).click();
        findBy(EDIT_THIRD_REMAINDER).clear();
        findBy(EDIT_THIRD_REMAINDER).type(thirdvalue);
        // waitAbit(2000);

    }


    public void fillScoreMinValue(String scoreminvalue) {
        //  findBy(SCORE_MIN_VALUE).clear();
        findBy(SCORE_MIN_VALUE).type(scoreminvalue);
        waitAbit(2000);
    }

    public void fillScoreMaxValue(String scoremaxvalue) {
        //   findBy(SCORE_MAX_VALUE).clear();
        findBy(SCORE_MAX_VALUE).type(scoremaxvalue);
    }

    public void fillSheduleMinValue(String sheduleminvalue) {
        //findBy(SCHEDULE_MIN_VALUE).clear();
        findBy(SCHEDULE_MIN_VALUE).type(sheduleminvalue);
    }

    public void clickSheduleMonths() {
        waitAbit(1000);
        findBy(SCHEDULE_MONTHS).click();
        waitAbit(1000);
    }

    public void clickSheduleMonths1() {
        findBy(SCHEDULE_MONTHS1).click();
        waitAbit(1000);
    }

    public void fillFirstRemainder(String firstvalue) {
        findBy(REMAINDER_FIRST).type(firstvalue);
        waitAbit(1000);
    }

    public void fillSecondRemainder(String secondvalue) {
        findBy(REMAINDER_SECOND).type(secondvalue);
        waitAbit(3000);
    }

    public void fillThirdRemainder(String thirdvalue) {
        findBy(REMAINDER_THIRD).type(thirdvalue);
        waitAbit(3000);
    }

    public void selectFirstRemainderDays() {
        findBy(SELECT_REMAINDER_FIRST_DAYS).click();
        waitAbit(1000);
    }

    public void selectSecondRemainderDays() {
        findBy(SELECT_REMAINDER_SECOND_DAYS).click();
        waitAbit(1000);
    }

    public void selectThirdRemainderDays() {
        findBy(SELECT_REMAINDER_THIRD_DAYS).click();
        waitAbit(1000);
    }

    public void clickFirstRemainderDays() {
        findBy(CLICK_REMAINDER_FIRST_DAYS).click();
        waitAbit(1000);
    }

    public void clickSecondRemainderDays() {
        findBy(CLICK_REMAINDER_SECOND_DAYS).click();
        waitAbit(1000);
    }

    public void clickThirdRemainderDays() {
        findBy(CLICK_REMAINDER_THIRD_DAYS).click();
        waitAbit(1000);
    }

    public void clickOnSaveButton() {
        jsClick(CLICK_SAVE_BUTTON);
        waitAbit(1000);
    }

    public void clickOnCancelButton() {
        //findBy(CLICK_CANCEL_BUTTON).click();
        jsClick(CLICK_CANCEL_BUTTON);
        waitAbit(1000);
    }

    private static final String CLICK_ON_CANCEL_BUTTON_IN_RISK_CATAGORY = "//div/button/span[text()='Cancel']";

    public void clickOnCanceleButtonInRiskCategory() {
        jsClick(CLICK_ON_CANCEL_BUTTON_IN_RISK_CATAGORY);
    }

    public String checkRegValidationForDuplicating(String field) {
        waitForPresenceOf(DIALOGUE_BOX);
        waitAbit(2000);
        return findBy(format(DIALOGUE_BOX, field)).getText();
    }

   /* public String getValidationMessage(String field) {
        return findBy(DIALOGUE_BOX).getText();


    }*/

    public boolean verifyingMinScheduleIsPresent() {
        return isElementPresent(SCHEDULE_MIN_VALUE);
    }

    public boolean verifyingScheduleDropdownIsPresent() {
        return isElementPresent(SCHEDULE_MONTHS);
    }


    //Tc 2.3
    private static final String FIRST_REMAINDER_ERROR = "//span[text()='First Reminder should be less than Site Visit Schedule']";
    private static final String SECOND_REMAINDER_ERROR = ".//form//div//span[text()='Second Reminder should be less than First Reminder']";
    private static final String THIRD_REMAINDER_ERROR = ".//form//div//span[text()='Third Reminder should be less than Second Reminder']";
    private static final String FIRST_REMAINDER_MONTH = "//div/ul/li[text()='month(s)']";

    public boolean verifyingFirstRemainderIsPresent() {
        return isElementPresent(REMAINDER_FIRST);
    }

    public boolean verifyingSecondRemainderIsPresent() {
        return isElementPresent(REMAINDER_SECOND);
    }

    public boolean verifyingThirdRemainderIsPresent() {
        return isElementPresent(REMAINDER_THIRD);
    }

    public boolean verifyingFirstRemainderDropdownIsPresent() {
        return isElementPresent(SELECT_REMAINDER_FIRST_DAYS);
    }

    public boolean verifyingSecondRemainderDropdownIsPresent() {
        return isElementPresent(SELECT_REMAINDER_SECOND_DAYS);
    }

    public boolean verifyingThirdRemainderDropdownIsPresent() {
        return isElementPresent(SELECT_REMAINDER_THIRD_DAYS);
    }

    public void clickFirstRemainderMonths() {
        findBy(FIRST_REMAINDER_MONTH).click();
    }

    public String verifyingFirstRemainderErrorMessageIsDisplaying(String error1) {
        waitForPresenceOf(FIRST_REMAINDER_ERROR);
        return findBy(format(FIRST_REMAINDER_ERROR, error1)).getText();
    }

    public String verifyingSecondRemainderErrorMessageIsDisplaying(String error1) {
        waitForPresenceOf(SECOND_REMAINDER_ERROR);
        waitAbit(3000);
        return findBy(format(SECOND_REMAINDER_ERROR, error1)).getText();
    }

    public String verifyingThirdRemainderErrorMessageIsDisplaying(String error1) {
        waitForPresenceOf(THIRD_REMAINDER_ERROR);
        waitAbit(3000);
        return findBy(format(THIRD_REMAINDER_ERROR, error1)).getText();
    }

    //error messages
    private static final String VERIFY_RISK_LEVEL_IDENTIFIER_FIELD_ERROR = "//div//form//div//input[@id='risklevelidentifier']";
    private static final String VERIFY_MIN_VALUE_FIELD_ERROR = ".//form//div//label[text()='Min Value*']";
    private static final String VERIFY_MAX_VALUE_FIELD_ERROR = ".//form//div//label[text()='Max Value*']";
    private static final String VERIFY_FIRST_SECTION_FIELD_ERROR = "//div//input[@id='first']";
    private static final String VERIFY_SECOND_SECTION_FIELD_ERROR = "//div//input[@id='second']";
    private static final String VERIFY_THIRD_SECTION_FIELD_ERROR = "//div//input[@id='third']";

    public String getValidationRiskLevelField(String error) {
        return findBy(format(VERIFY_RISK_LEVEL_IDENTIFIER_FIELD_ERROR, error)).getText();
    }

    private static final String MINIMUM_RISK_VALUE1 = ".//form//div//input[@id='minValue']";

    public void clickOnMinmumRiskValue() {
        findBy(MINIMUM_RISK_VALUE1).click();
    }

    public String getValidationMinValueField(String field) {
        waitForPresenceOf(VERIFY_MIN_VALUE_FIELD_ERROR);

        return findBy(format(VERIFY_MIN_VALUE_FIELD_ERROR, field)).getText();
    }

    public String getValidationMaxValueField(String field) {
        return findBy(format(VERIFY_MAX_VALUE_FIELD_ERROR, field)).getText();
    }

    public String getValidationFirstField(String field) {
        return findBy(format(VERIFY_FIRST_SECTION_FIELD_ERROR, field)).getText();
    }

    public String getValidationSecondField(String field) {
        return findBy(format(VERIFY_SECOND_SECTION_FIELD_ERROR, field)).getText();

    }

    public String getValidationThirdField(String field) {
        return findBy(format(VERIFY_THIRD_SECTION_FIELD_ERROR, field)).getText();

    }

    //Merging
    private static final String CLICK_CLOSE_BUTTON = "//div[@role='alertdialog']//button[@aria-label='Close']";

    public void clickOnCloseButton() {
        findBy(CLICK_CLOSE_BUTTON).click();
    }

    private static final String CLICK_ON_CLOSE_BUTTON_FROM_SCREENING_SCORE_DIALOG_BOX = "//div/button[@aria-label='Close']";

    public void clickOnCloseButtonFromScrreningScoreDialogBox() {
        waitAbit(2000);
        jsClick(CLICK_ON_CLOSE_BUTTON_FROM_SCREENING_SCORE_DIALOG_BOX);
    }

    //validation error messages
    private static final String MAX_VALUE = "//div[@style='display: block;'][1]/div[3]/label[text()='Max Value*']";

    //private static final String MAX_VALUE="//div[@style='display: block;'][1]/div[3]/div[@class='jss408 jss413 jss409 jss412']/input[@id='maxValue']";
    public void clickOnMaxValue() {
        jsClick(MAX_VALUE);
    }

    private static final String CLICK_FIRST_FIELD = "//div[@style='display: block;'][3]/div[2]/div[1]/label[text()='First']";
    private static final String CLICK_SECOND_FIELD = "//div[@style='display: block;'][3]/div[2]/div[3]/label[text()='Second']";
    private static final String CLICK_THIRD_FIELD = "//div[@style='display: block;'][3]/div[2]/div[5]/label[text()='Third']";
    private static final String CLICK_RISK_LEVEL_IDENTIFIER_FIELD = "//div//form//div//input[@id='risklevelidentifier']";

    public void clickOnFirstField() {
        jsClick(CLICK_FIRST_FIELD);
    }


    public void clickOnSecondField() {
        jsClick(CLICK_SECOND_FIELD);
    }


    public void clickOnThirdField() {
        jsClick(CLICK_THIRD_FIELD);
    }

    public void clickOnRiskLevelIdentifierField() {
        jsClick(CLICK_RISK_LEVEL_IDENTIFIER_FIELD);
    }

    private static final String DELETE = "(.//td//span[text()='%s']/../..//*[local-name() = 'svg' and @aria-hidden='true'])[2]";
    private static final String YES = ".//button/span[text()='Yes']";
    // private static final String EDIT = "(.//td//span[text()='%s']/../..//*[local-name() = 'svg' and @aria-hidden='true'])[1]";
    //new sp24
    private static final String EDIT = ".//td//*[local-name() = 'svg' and @aria-hidden='true'][1]";

    public void deleteSiteVisit(String riskname) {
        scrollToElement(format(DELETE, riskname));
        findBy(format(DELETE, riskname)).click();
        findBy(YES).click();
    }

    public void editSiteVisit(String riskname) {
        scrollToElement(format(EDIT, riskname));
        findBy(format(EDIT, riskname)).click();
        waitAbit(1000);
    }

    private static final String SCHEDULE_EDIT_BUTTON = ".//div[contains(text(),'Site Visit Schedule')]/..//button[@type='button']";

    public void clickeditbuttoninschedule() {
        scrollToElement(SCHEDULE_EDIT_BUTTON);
        findBy(SCHEDULE_EDIT_BUTTON).click();
        waitAbit(3000);
    }

    //sp24
    private static final String SITE_VISIT_DATE = ".//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input";

    public void setSiteVisitDate(String sitevisitDate) {
        scrollToElement(SITE_VISIT_DATE);
        jsClick(SITE_VISIT_DATE);
        findBy(SITE_VISIT_DATE).sendKeys(sitevisitDate);
        waitAbit(2000);

    }

    private static final String SITEVISIT_EFFECTIVE_END_DATE = ".//label[text()='Effective end']//ancestor::div[contains(@class, 'effectivedatepicker')]//input";

    public void setSiteVisitEffectiveEndDate(String effectiveEndDate) {
        scrollToElement(SITEVISIT_EFFECTIVE_END_DATE);
        jsClick(SITEVISIT_EFFECTIVE_END_DATE);
        findBy(SITEVISIT_EFFECTIVE_END_DATE).sendKeys(effectiveEndDate);
        waitAbit(1000);
    }

    private static final String VIEW_HISTORY_BUTTON = ".//div[contains(@class,'styles_history-btn_')]//*[local-name() = 'svg' and @aria-hidden='true' ]/..";

    public boolean verifyViewHistorytButton() {
        waitAbit(500);
        return findBy(VIEW_HISTORY_BUTTON).isDisplayed();
    }

    public void clickVeiwHistoryButton() {
        waitAbit(200);
        scrollToElement(VIEW_HISTORY_BUTTON);
        waitAbit(200);
        jsClick(VIEW_HISTORY_BUTTON);
    }

    private static final String CLICK_EXIT_BUTTON = ".//div[contains(@class,'styles_history-title-with-edit_')]/div/button/span/../..";

    public void clickOnExitButton(String eixt) {
        waitAbit(200);
        scrollToElement(format(CLICK_EXIT_BUTTON, eixt));
        waitAbit(200);
        findBy(format(CLICK_EXIT_BUTTON, eixt)).click();
        waitAbit(500);
    }

    private static final String CLICK_EDIT_BUTTON = ".//button/span[text()='Edit']";

    public void clickEditButton() {
        waitAbit(200);
        scrollToElement(CLICK_EDIT_BUTTON);
        waitAbit(200);
        findBy(CLICK_EDIT_BUTTON).click();
        waitAbit(500);
    }

    private static final String SAVE_BUTTON = "//button[@type='button']/span[text()='%s']";
    private static final String OK_BUTTON = "//button/span[text()='OK']/..";

    public void clickSaveButton(String savebutton) {
        waitAbit(200);
        scrollToElement(format(SAVE_BUTTON, savebutton));
        waitAbit(200);
        findBy(format(SAVE_BUTTON, savebutton)).click();
        waitAbit(600);
        findBy(OK_BUTTON).click();
        waitAbit(200);
    }

    private static final String VEIW_HISTORY_PANEL = ".//div[contains(@class,'styles_site-visit-view-istory-table_')]/..";

    public SiteVisitRiskLevelPanel getViewhistoryPanel() {
        return new SiteVisitRiskLevelPanel(findBy(VEIW_HISTORY_PANEL), this);
    }

    private static final String ClICK_EFFECTIVE_DATES = ".//div[contains(@class,'styles_content_')]";

    public void clickEffectiveDates() {
        waitAbit(200);
        scrollToElement(ClICK_EFFECTIVE_DATES);
        waitAbit(200);
        findBy(ClICK_EFFECTIVE_DATES).click();
        waitAbit(1000);
    }

    private static final String ClICK_BACK_TO_HISTORY_RECORDS = ".//div/h4[text()='←Back to History Records']";

    public void clickBackToHistoryRecords() {
        waitAbit(200);
        scrollToElement(ClICK_BACK_TO_HISTORY_RECORDS);
        waitAbit(200);
        jsClick(ClICK_BACK_TO_HISTORY_RECORDS);
        waitAbit(1000);
    }

    //sp41.4
    private static final String SCHEDULE_SITE_VISIT_BASED = ".//div[contains(@class,'MuiFormGroup-root')]/label//input[contains(@value,'basedOnTaxonomy')]";

    public void setScheduleSiteVisit() {
        waitAbit(200);
        scrollToElement(SCHEDULE_SITE_VISIT_BASED);
        waitAbit(200);
        findBy(SCHEDULE_SITE_VISIT_BASED).click();
    }

    private static final String CLICK_SAVE = ".//button/span[contains(text(), 'Save')]";
    private static final String CLICK_OK_BUTTON = ".//button/span[contains(text(),'OK')]";

    public void clickSaveChanges() {
        waitAbit(500);
        scrollToElement(CLICK_SAVE);
        jsClick(CLICK_SAVE);
        findBy(CLICK_OK_BUTTON).click();
        waitAbit(200);
    }

    private static final String SCHEDULE_SITE_VISIT_BASED_ON_STATE = ".//div[contains(@class,'MuiFormGroup-root')]/label//input[contains(@value,'instate')]";

    public void setScheduleSiteVisitBasedOnState() {
        waitAbit(200);
        scrollToElement(SCHEDULE_SITE_VISIT_BASED_ON_STATE);
        waitAbit(200);
        findBy(SCHEDULE_SITE_VISIT_BASED_ON_STATE).click();
    }
    private static final String SCHEDULE_SITE_VISIT_BASED_SCREENING_SCRORE = ".//div[contains(@class,'MuiFormGroup-root')]/label//input[contains(@value,'basedOnScreeningScore')]";
    public void setScheduleSiteVisitBasedOnScreeningScore() {
        waitAbit(200);
        scrollToElement(SCHEDULE_SITE_VISIT_BASED_SCREENING_SCRORE);
        waitAbit(200);
        findBy(SCHEDULE_SITE_VISIT_BASED_SCREENING_SCRORE).click();
    }


    private static final String RISK_LEVEL_BASED_ON_TAXONOMY = "//input[@value='basedOnTaxonomy']";
    private static final String RISK_LEVEL_BASED_ON_SCREENINGSCORE = "//input[@value='basedOnScreeningScore']";
    private static final String HIGHER_OF_TWO_RISK_LEVELS = "//input[@value='higherOftheTwoRiskLevels']";

    public void selectRiskLevelBasedOnTaxonomy() {
        scrollToElement(RISK_LEVEL_BASED_ON_TAXONOMY);
        waitAbit(1000);
        findBy(RISK_LEVEL_BASED_ON_TAXONOMY).click();
        waitAbit(1000);
    }

    public void selectRiskLevelBasedOnScreeningScore() {
        scrollToElement(RISK_LEVEL_BASED_ON_SCREENINGSCORE);
        waitAbit(1000);
        findBy(RISK_LEVEL_BASED_ON_SCREENINGSCORE).click();
        waitAbit(1000);
    }

    public void selectHigherofTowRiskLevels() {
        scrollToElement(HIGHER_OF_TWO_RISK_LEVELS);
        waitAbit(1000);
        findBy(HIGHER_OF_TWO_RISK_LEVELS).click();
        waitAbit(1000);
    }

    public boolean isRiskLevelBasedOnTaxonomySelected() {
        return findBy(RISK_LEVEL_BASED_ON_TAXONOMY).isSelected();
    }

    public boolean isRiskLevelBasedOnScreeningScoreSelected() {
        return findBy(RISK_LEVEL_BASED_ON_SCREENINGSCORE).isSelected();
    }

    public boolean isHigherOfTwoRiskLevelsSelected() {
        return findBy(HIGHER_OF_TWO_RISK_LEVELS).isSelected();
    }
}
