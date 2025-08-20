package com.hhstechgroup.ui.pages.sitevisit;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

import static java.lang.String.format;

public class SitiVistShedulePage extends ProviderManagementBasePage {
    public SitiVistShedulePage(WebDriver driver) {
        super(driver);
    }

    //sp42.3

        private static final String SITEVISIT_DATE = ".//label[contains(text(),'Date of Site Visit ')]/..//div/input[@placeholder='MM/DD/YYYY']" ;
    private static final String CREATE_SITEVISIT_BUTTON = ".//span[contains(text(), 'Create Site Visit')]" ;

    public void clickCreateSiteVisitButton(){
        waitAbit(200);
        jsClick(CREATE_SITEVISIT_BUTTON);
        waitAbit(200);
    }

    public void fillSiteVisitDate(String sitevisitDate) {
        jsClick(SITEVISIT_DATE);
        findBy(SITEVISIT_DATE).click();
        findBy(format(SITEVISIT_DATE, sitevisitDate)).clear();
        waitAbit(2000);
        findBy(format(SITEVISIT_DATE, sitevisitDate)).type(sitevisitDate);
        waitAbit(2000);
    }

    private static final String SITEVISIT_DATE1 = ".//label[contains(text(),'Select Date ')]/..//div/input[@placeholder='MM/DD/YYYY']" ;

    public void fillSiteVisitDate1(String sitevisitDate) {
        jsClick(SITEVISIT_DATE1);
        findBy(SITEVISIT_DATE1).click();
        findBy(format(SITEVISIT_DATE1, sitevisitDate)).clear();
        waitAbit(2000);
        findBy(format(SITEVISIT_DATE1, sitevisitDate)).type(sitevisitDate);
        waitAbit(2000);
    }

    private static final String REASON_FIELD = ".//input[contains(@id, 'Select reason')]/preceding-sibling::div" ;
    private static final String  REASON = ".//ul/li[contains(text(),'%s')]" ;
    private static final String  NOTE = ".//label[contains(text(), 'Note')]/../div/textarea[1]" ;
    private static final String  OK = ".//button/span[text()='Ok']" ;

    public void setSiteVisitReason(String reason,String note) {
        waitAbit(1000);
   //     jsClick(REASON_FIELD);
        findBy(REASON_FIELD).click();
        scrollToElement(format(REASON,reason));
        waitAbit(1000);
        findBy(format(REASON, reason)).click();
        waitAbit(1000);
        findBy(NOTE).click();
        findBy(NOTE).type(note);
        waitAbit(1000);
        findBy(OK).click();

    }

    private static final String  CONFIRM_RESCHEDULE = ".//button/span[text()='Confirm/Reschedule']" ;
    public void setSiteVisitReason1(String reason,String note) {
        waitAbit(1000);
        jsClick(REASON_FIELD);
        scrollToElement(format(REASON,reason));
        waitAbit(1000);
        findBy(format(REASON, reason)).click();
        waitAbit(1000);
        findBy(NOTE).click();
        findBy(NOTE).type(note);
        waitAbit(1000);
        findBy(CONFIRM_RESCHEDULE).click();

    }

    private static final String  SITEVISIT_ACTION_MENU = ".//div[contains(@class,'expansion-panel-menu')]/../..//div//button" ;
    private static final String  DROP_DOWN_OPTION = ".//ul/li[text() = '%s']";

    public void clickOnActionMenuFromSiteVisitrecordsList(String action){
        waitAbit(200);
        scrollToElement(SITEVISIT_ACTION_MENU);
        waitAbit(200);
        findBy(SITEVISIT_ACTION_MENU).click();
        waitABit(200);
        action().moveToElement(findBy(String.format(DROP_DOWN_OPTION, action))).click().build().perform();
        waitAbit(200);
    }

    private static final String GOTO_SITEVISIT_BUTTON = ".//span[contains(text(), 'Go to Site visits')]" ;
    public void clickGoToSiteVisitButton(){
        waitAbit(200);
        jsClick(GOTO_SITEVISIT_BUTTON);
        waitAbit(200);
    }
    //sp45.3
    private static final String PLUS_SITEVISIT_BUTTON = ".//div/button[contains(@type,'button')]/span/i/../.." ;
    public void clickPlusiteVisitButton() {
        waitAbit(200);
        jsClick(PLUS_SITEVISIT_BUTTON);
        waitAbit(200);
    }

    private static final String SEARCH_NPI_FIELD= ".//div//input[@id='provider']";
    public void searchNPIfield(String searchnpifield) {
        waitABit(500);
        findBy(SEARCH_NPI_FIELD).type(searchnpifield);
        waitABit(1000);
        action().sendKeys(Keys.TAB).build().perform();
        waitABit(500);
    }
    private static final String CREATE_BUTTON = ".//button//span[text()=' Create']";
    public void clickonCreateButton() {
        findBy(CREATE_BUTTON).click();
        waitAbit(500);
    }

    //SD-05

    private static final String YES_NO_BUTTON = ".//span[text()='%s']/..//input[contains(@type,'radio')]" ;
    public void  clickYesInRetroApprovalButton(String button){
        waitABit(100);
        findBy(format(YES_NO_BUTTON,button)).click();
        waitABit(100);
    }

    private static final String SITE_VISIT_LOCATIONS = "//div[label[text()='Please select locations to create site visit']]//div[input]";
    public void selectLocationsToCreateSiteVisit(String locations){
        waitAbit(500);
        findBy(SITE_VISIT_LOCATIONS).click();
        waitAbit(500);
        try {
            findBy(format(DROP_DOWN_OPTION, locations)).click();
        }
        catch (NoSuchElementException e){
            System.out.println(locations + " option not presents");
            findBy("(//ul/li[@role='option'])[1]").click();
        }
        waitAbit(500);
        findBy("//html").click();
        waitAbit(500);
    }

}
