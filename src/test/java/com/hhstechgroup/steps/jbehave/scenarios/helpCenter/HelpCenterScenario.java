package com.hhstechgroup.steps.jbehave.scenarios.helpCenter;


import com.hhstechgroup.steps.serenity.helpCenter.HelpCenterSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.yecht.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertTrue;

public class HelpCenterScenario {

    @Steps
    HelpCenterSteps helpCenterSteps;

    @When("navigate to Help Center")
    public void navigateToHelpCenter(){
        helpCenterSteps.navigateToHelpCenter();
    }

    @When("search in knowledge base by word '$word'")
    public void searchByWord(String searchWord){
        helpCenterSteps.searchByWord(searchWord);
    }

    @Then("search result '$result' is displayed")
    public void isSearchResultDisplayed(String searchResult){
        assertTrue(helpCenterSteps.isSearchResultDisplayed(searchResult));
    }

    @When("go back to Provider Portal page")
    public void goBackToProviderPoratl(){
        helpCenterSteps.goBackToProviderPortal();
    }

    //sp22

    @When("select the Category Type '$categoryType' in the Help Center Page")
    public void selectCategoryType(String categoryType){
        helpCenterSteps.selectCategoryType(categoryType);
        System.out.println("Category Type is :" + categoryType);
    }

    @When("click on type '$type' in the help center page")
    public void clickOnType(String type){
        helpCenterSteps.clickOnType(type);
        System.out.println("Application Type is :" + type);
    }

    @When("Scroll to '$writesuggestion' in the help center page")
    public void scrollToWriteSuggestion(String writesuggestion){
       helpCenterSteps.scrollToWriteSuggestion(writesuggestion);

    }

    @When("Verifying name '$writesuggestion' is Displaying in help center page")
    public boolean isVerifyWriteSuggestion(String writeSuggestion) {
        System.out.println("Verifying name :" + writeSuggestion + "is displaying in help center page");
        return helpCenterSteps.isVerifyWriteSuggestion(writeSuggestion);

    }

    @When("Scroll '$postSuggestion' in the help center page")
    public void scrollToPostSuggestion(String postSuggestion){
        helpCenterSteps.scrollToPostSuggestion(postSuggestion);
    }

    @When("Verifying '$postSuggestion' name Displaying in help center page")
    public boolean isVerifyPostSuggestion(String postSuggestion) {
        System.out.println("Verifying name :" + postSuggestion + "is displaying in help center page");
        return helpCenterSteps.isVerifyPostSuggestion(postSuggestion);
    }

    @When("Scroll to button '$downloadTrainingMaterial' in the help center page")
    public void scrollToDownloadTrainingMaterial(String downloadTrainingMaterial){
        helpCenterSteps.scrollToDownloadTrainingMaterial(downloadTrainingMaterial);
    }

    @When("Verifying '$downloadTrainingMaterial' button Displaying in help center page")
    public boolean isVerifyDownloadTrainingMaterial(String downloadTrainingMaterial) {
        System.out.println("Verifying button :" + downloadTrainingMaterial + "is displaying in help center page");
        return helpCenterSteps.isVerifyDownloadTrainingMaterial(downloadTrainingMaterial);
    }
    @Then("click on $category category in  help center")
    public void clickOnCategory(String category){
//        Set<String> windows = getDriver().getWindowHandles();
//      ArrayList<String> window = new ArrayList<String>(getDriver().getWindowHandles());
//        Iterator it=windows.iterator();
//        String pid=(String) it.next();
//        String cid=(String) it.next();
//        getDriver().switchTo().window(cid);
        helpCenterSteps.clickOnCategory(category);
    }
    @Then("click on $question in $category category")
    public void clickOnCategoryQuestion(String question){
       helpCenterSteps.clickOnCategoryQuestion(question);
    }
    @Then("validate '$text' text is displayed")
    public void verifyText(String text){
        assertTrue( helpCenterSteps.verifyText(text));
    }
    @Then("click on '$home' to navigate back")
    public void navigateToHome(String home){
        helpCenterSteps.navigateToHome(home);
    }
}
