package com.hhstechgroup.steps.serenity.helpCenter;


import com.hhstechgroup.ui.pages.helpCenter.HelpCenterPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HelpCenterSteps extends ScenarioSteps{

    HelpCenterPage helpCenterPage;

    @Step
    public void navigateToHelpCenter(){
        helpCenterPage.navigateToHelpCenter();
    }

    @Step
    public void searchByWord(String searchWord){
        helpCenterPage.searchByWord(searchWord);
    }

    @Step
    public boolean isSearchResultDisplayed(String searchResult){
        return helpCenterPage.isSearchResultDisplayed(searchResult);
    }

    @Step
    public void goBackToProviderPortal(){
        helpCenterPage.goBackToProviderPortal();
    }

    //sp22

    @Step
    public void selectCategoryType(String categoryType){
        helpCenterPage.selectCategoryType(categoryType);
    }

    @Step
    public void clickOnType(String type){
        helpCenterPage.clickOnType(type);
    }

    @Step
    public void scrollToWriteSuggestion(String writesuggestion){
       helpCenterPage.scrollToWriteSuggestion(writesuggestion);
    }

    @Step
    public boolean isVerifyWriteSuggestion(String writeSuggestion) {

        return helpCenterPage.isVerifyWriteSuggestion(writeSuggestion);
    }

    @Step
    public void scrollToPostSuggestion(String postSuggestion){
       helpCenterPage.scrollToPostSuggestion(postSuggestion);
    }

    @Step
    public boolean isVerifyPostSuggestion(String postSuggestion) {
        return helpCenterPage.isVerifyPostSuggestion(postSuggestion);
    }

    @Step
    public void scrollToDownloadTrainingMaterial(String downloadTrainingMaterial){
        helpCenterPage.scrollToDownloadTrainingMaterial(downloadTrainingMaterial);
    }

    @Step
    public boolean isVerifyDownloadTrainingMaterial(String downloadTrainingMaterial) {
        return helpCenterPage.isVerifyDownloadTrainingMaterial(downloadTrainingMaterial);
    }

    @Step
    public void clickOnCategory(String category){
        helpCenterPage.clickOnCategory(category);
    }
    @Step
    public void clickOnCategoryQuestion(String question){
        helpCenterPage.clickOnCategoryQuestion(question);
    }
    @Step
    public boolean verifyText(String text){
        return  helpCenterPage.verifyText(text);
    }
    @Step
    public void navigateToHome(String home){
        helpCenterPage.navigateToHome(home);
    }
}