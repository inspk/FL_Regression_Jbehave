package com.hhstechgroup.ui.pages.providerData;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.iuportal.ProviderDataSearchPanel;
import com.hhstechgroup.ui.panels.iuportal.ProviderDataSearchResultsPanel;
import com.hhstechgroup.util.properties.LocationProviderProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;


public class ProviderDataSearchPage extends AbstractPage {
    private static final String SEARCH_PANEL = ".//div[contains(@class, 'search-box')]";
    private static final String RESULTS_PANEL = ".//div[contains(@class, 'tile')]";
    private static final String RESULTS_NOT_FOUND = ".//p[contains(text(),'There are no records by selected search parameters')]";



    public ProviderDataSearchPage(WebDriver driver) {
        super(driver);
    }

    public ProviderDataSearchPanel getProviderDataSearchPanel() {
        return new ProviderDataSearchPanel(findBy(SEARCH_PANEL), this);
    }

    public ProviderDataSearchResultsPanel getProviderDataSearchResultsPanel() {
        waitForPresenceOf(RESULTS_PANEL);
        waitAbit(3000);
        return new ProviderDataSearchResultsPanel(findBy(RESULTS_PANEL), this);
    }
    public boolean checkResultsNotFoundTextPresent() {
        return isElementPresent(RESULTS_NOT_FOUND);
    }

    //sp23

    private static final String SEARCH_ICON = "(.//div[contains(@class,'search-box')]//span[text()='Search'])[1]";

    public void clickOnSearchIcon(){
        waitAbit(100);
        scrollToElement(SEARCH_ICON);
        waitAbit(100);
        findBy(SEARCH_ICON).click();
        waitAbit(200);
    }

    private static final String ENDED_AFFILIATION_CHECKBOX = ".//label//span[contains(text(),'%s')]/..//input[contains(@type,'checkbox')]" ;
    private static final String SEARCH_RESULT = ".//button/span[contains(text(),'Search')]" ;

    public void selectEndAffiliationCheckboxAndSearch(String checkbox){
        waitAbit(100);
        scrollToElement(format(ENDED_AFFILIATION_CHECKBOX,checkbox));
        waitAbit(100);
        findBy(format(ENDED_AFFILIATION_CHECKBOX,checkbox)).click();
        waitAbit(100);
        findBy(SEARCH_RESULT).click();
        waitAbit(100);
    }
    public void selectShowEndedAffiliationCheckboxAndSearch(String checkbox){
        waitAbit(100);
        scrollToElement(format(ENDED_AFFILIATION_CHECKBOX,checkbox));
        waitAbit(100);
        findBy(format(ENDED_AFFILIATION_CHECKBOX,checkbox)).click();
        waitAbit(100);
    }

    public void selectEndAffiliationCheckbox(String checkbox){
        waitAbit(100);
        scrollToElement(format(ENDED_AFFILIATION_CHECKBOX,checkbox));
        waitAbit(100);
        findBy(format(ENDED_AFFILIATION_CHECKBOX,checkbox)).click();
        waitAbit(100);

    }

    private static final String SEARCH="//div[contains(@class,'styles_search-box-expand')]//span[text()='Search']";
    public void clickOnSearch(){
        waitAbit(300);
        findBy(SEARCH).click();
        waitAbit(1000);
    }
    private static final String SERACH_RESULT1="//h2[contains(text(),'Search results (')]";
    private static final String FETCH_PES_ID="(//div[contains(@class,'tile-table-row')]//div[contains(@class,'tile-table-column')][3]//p)[2]";
    public static final String FIRST_ROW_SEARCH_RESULT="(//div[contains(@class,'tile-table-row')])[1]";
    private static final String NO_RESULTS_FOUND="//p[contains(text(),'No Results Found')]";
    public void checkSearchResult(){
        waitAbit(200);
        if(findBy(SERACH_RESULT1).isDisplayed()){
            String result = findBy(SERACH_RESULT1).getText();
            System.out.println("Found Search result:" + result);
        }

        else {
            findBy(NO_RESULTS_FOUND).isDisplayed();
            System.err.println("=====No Results Found=====");
        }

        try{
            findBy(FIRST_ROW_SEARCH_RESULT).isDisplayed();
            String result = findBy(SERACH_RESULT1).getText();
            System.out.println("Found Search result:" + result);
        }
        catch (Exception e){
            findBy(NO_RESULTS_FOUND).isDisplayed();
            System.err.println("=====NO RESULTS FOUND=====");
        }


    }
    public void fetchPESID(){
        findBy(FIRST_ROW_SEARCH_RESULT).isDisplayed();
        String result = findBy(SERACH_RESULT1).getText();
        String PES_ID= findBy(FETCH_PES_ID).getText();
        LocationProviderProperties.appendBasePES_Id(PES_ID);
        System.out.println("Found Search result:" + result);
    }

    private static final String CLICK_ON_ENROLLMENT_TYPE="(//div[contains(@class,'table-text')]//p[contains(text(),'%s')])[1]";
    public void clickOnEnrollmentType(String enrollmentType){
        waitAbit(400);
        findBy(String.format(CLICK_ON_ENROLLMENT_TYPE,enrollmentType)).click();
        waitAbit(600);
    }
    public void clickonpemenrollmenttype1(){
        waitAbit(4000);
        findBy("//input[@aria-label='Select any Enrollment type']").click();
        waitAbit(3000);
        findBy("//input[@aria-label='Select any Enrollment type']").sendKeys("PEM", Keys.ENTER);



    }

}