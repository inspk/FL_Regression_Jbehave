package com.hhstechgroup.ui.pages.helpCenter;


import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;


public class HelpCenterPage extends ProviderManagementBasePage{

    private static final String HELP_CENTER = ".//a[text()='Help center']";
    private static final String SEARCH = ".//input[@value='Search the knowledge base...']";
    private static final String SEARCH_RESULT = ".//a[contains(text(), '%s')]";
    private static final String BACK_TO_PORTAL = ".//header//a[text()='Back to Provider portal']";

    public HelpCenterPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHelpCenter(){
        waitForSpinnerToDisappear();
        findBy(HELP_CENTER).click();
    }

    public void searchByWord(String searchWord){
        findBy(SEARCH).type(searchWord);
        findBy(SEARCH).sendKeys(Keys.ENTER);
    }

    public boolean isSearchResultDisplayed(String searchResult) {
        return isElementPresent(String.format(SEARCH_RESULT, searchResult));
    }

    public void goBackToProviderPortal(){
        scrollToElement(BACK_TO_PORTAL);
        findBy(BACK_TO_PORTAL).click();
    }

    //sp22

    private static final String CATEGORIES_TYPE = ".//ul/li/a[contains(text(),'%s')]";

    public void selectCategoryType(String categoryType){
        scrollToElement(format(CATEGORIES_TYPE,categoryType));
        jsClick(format(CATEGORIES_TYPE,categoryType));
    }

    private static final String TYPE = ".//h2[contains(@class,'entry-title')]/a[contains(text(),'%s')]";

    public void clickOnType(String type){
        scrollToElement(format(TYPE,type));
        jsClick(format(TYPE,type));
    }

    private static final String WRITE_SUGGESTIONS   =".//div/h3[contains(text(),'Write your suggestions')]";
    private static final String POST_SUGGESTION   =".//p/input[contains(@value,'%s')]";
    private static final String DOWNLOAD_TRAINING_MATERIAL   =".//p/a/button[contains(text(),'%s')]";


    public void scrollToWriteSuggestion(String writesuggestion){
        scrollToElement(format(WRITE_SUGGESTIONS,writesuggestion));
    }

    public boolean isVerifyWriteSuggestion(String writeSuggestion) {

        return findBy(format(WRITE_SUGGESTIONS ,writeSuggestion)).isDisplayed();
    }

    public void scrollToPostSuggestion(String postSuggestion){
        scrollToElement(format(POST_SUGGESTION,postSuggestion));
    }

    public boolean isVerifyPostSuggestion(String postSuggestion) {

        return findBy(format(POST_SUGGESTION ,postSuggestion)).isDisplayed();
    }

    public void scrollToDownloadTrainingMaterial(String downloadTrainingMaterial){
        scrollToElement(format(DOWNLOAD_TRAINING_MATERIAL,downloadTrainingMaterial));
    }

    public boolean isVerifyDownloadTrainingMaterial(String downloadTrainingMaterial) {

        return findBy(format(DOWNLOAD_TRAINING_MATERIAL ,downloadTrainingMaterial)).isDisplayed();
    }
    private static final String CATEGORY="//a[text()='%s']";
    public void clickOnCategory(String category){
        waitAbit(200);
        findBy(String.format(CATEGORY, category)).click();
    }
    private static final String CATEGORY_QUESTION="//a[contains(text(),'%s')]";
    public void clickOnCategoryQuestion(String question){
        waitAbit(200);
        findBy(String.format(CATEGORY_QUESTION,question)).click();
    }

    private static final String ANSWER="//p[contains(text(),'%s')]";
    public boolean verifyText(String text){
        scrollToElement(format(ANSWER,text));
        return isElementPresent(String.format(ANSWER,text));
    }

    private static final String HOME="//a[text()='%s']";

    public void navigateToHome(String home){
        waitAbit(100);
        findBy(String.format(HOME,home)).click();
    }

}