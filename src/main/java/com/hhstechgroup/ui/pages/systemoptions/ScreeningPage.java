package com.hhstechgroup.ui.pages.systemoptions;

import com.hhstechgroup.ui.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class ScreeningPage extends AbstractPage {
    private static final String SCREENING_PROVIDER_NAME = ".//div[contains(text(),'%s')]" ;

    public ScreeningPage(WebDriver driver) {
        super(driver);
    }

    public void clickScreeningProviderName(String name){
        scrollToElement(format(SCREENING_PROVIDER_NAME,name));
        findBy(format(SCREENING_PROVIDER_NAME,name)).click();
    }
    //sp24
    private static final String OPTION_RADIO_BUTTON_CUSTOM_SCREENING = "//span[text()='Custom Screening Thresholds']/../span//input" ;
    private static final String SCREENING_TYPE_PARAMETER = "//div[contains(@class, 'content_content-summary')]//div[text()='%s']" ;

    public void selectCustomScreening(){
        findBy(OPTION_RADIO_BUTTON_CUSTOM_SCREENING).click();
    }
    public void clickScreeningTypeParameter(String typeEnrollment){
        findBy(format(SCREENING_TYPE_PARAMETER, typeEnrollment)).click();
    }
    //sp29
    //private static final String SCREEING_EDIT = ".//div[contains(text(),'Monitoring Frequency')]/div//button";
    //sp66
    private static final String SCREEING_EDIT = ".//div[contains(text(),'Monitoring Frequency')]//span[text()='Edit']";
    public void clickMonitoringEdit(){
        waitAbit(200);
        scrollToElement(SCREEING_EDIT);
        findBy(SCREEING_EDIT).click();
        waitAbit(200);
    }
    private static final String ALLOW_PERIODIC_MONITORING=".//div/h3[contains(text(),'%s')]/../../..//span/input[@type='checkbox']";
    public void clickOnEnablePeriodicMonitoring(String enablperiodicmonitoring){
        findBy(format(ALLOW_PERIODIC_MONITORING,enablperiodicmonitoring)).click();
        waitAbit(1000);
    }

    private static final String SAVE_BUTTON = ".//button/span[contains(text(), 'Save')]" ;
    //sp32
    private static final String OK_BUTTON = ".//button/span[contains(text(), 'Ok')]" ;
    public void clickSaveButton() {
        scrollToElement(SAVE_BUTTON);
        waitAbit(500);
        findBy(SAVE_BUTTON).click();
        waitAbit(500);
        findBy(OK_BUTTON).click();
    }

    private static final String OPTION_RADIO_BUTTON_DEFAULT_SCREENING = ".//span[text()='Default Screening Thresholds']/../span//input" ;
    public void selectDefaultScreening(){
        waitAbit(100);
        findBy(OPTION_RADIO_BUTTON_DEFAULT_SCREENING).click();
    }
    //sp43.2
    private static final String EFFECTIVE_START_DATE = ".//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;
    public void setEffectiveStartDate(String effectiveStartDate) {
        scrollToElement(EFFECTIVE_START_DATE);
        jsClick(EFFECTIVE_START_DATE);
        findBy(format(EFFECTIVE_START_DATE,effectiveStartDate)).sendKeys(effectiveStartDate);
    }

    //sp68

    private static final String SIGN_FOR_AFFI =".//div/div[contains(text(),'%s')]/../../..//span/input[@type='checkbox']";
    public void clickOnEnablePeriodicMonitoring2(String enablperiodicmonitoring){
        scrollToElement(format(SIGN_FOR_AFFI,enablperiodicmonitoring));
        waitAbit(500);
        findBy(format(SIGN_FOR_AFFI,enablperiodicmonitoring)).click();
        waitAbit(1000);
    }

    //68
    private static final String SAVE_BUTTON1 = ".//button/span[contains(text(), 'Save')]" ;

    private static final String OK_BUTTON1 = ".//button/span[contains(text(), 'OK')]" ;
    public void clickSaveButton1() {
        scrollToElement(SAVE_BUTTON1);
        waitAbit(500);
        findBy(SAVE_BUTTON1).click();
        waitAbit(500);
        findBy(OK_BUTTON1).click();
    }

    //SD-05

    private static final String AFFILIATION_PAGE_TITLE = "//div[text()='%s' and contains(@class,'title')]" ;
    private static final String AFFILIATION_PAGE_VALUE = "//div[text()='%s' and contains(@class,'title')]/../div[contains(@class,'value')]" ;

    public boolean verifyAffiliationPage(String str){
        boolean bool = isElementPresent(format(AFFILIATION_PAGE_TITLE,str));
        System.out.println(str+": "+findBy(format(AFFILIATION_PAGE_VALUE,str)).getText());
        return bool;
    }

    private static final String DOWNLOAD_EXCEL = "//div[text()='View History']" ;
    public boolean verifyDownloadExcelButton(){
        return isElementPresent(DOWNLOAD_EXCEL);
    }

    private static final String VIEW_HISTORY = "//button[@title='Download as Excel']" ;
    public boolean verifyViewHistory(){
        return isElementPresent(VIEW_HISTORY);
    }

    public boolean verifyButtonEnabled(String button){
        return findBy(format(SIGN_FOR_AFFI,button)).isSelected();
    }


    private static final String ALLOWED_AFFILIATION ="(.//div/div[contains(text(),'%s')]/../../..//span/input[@type='checkbox'])[1]";
    private static final String SIGNATURE_REQUIRED ="(.//div/div[contains(text(),'%s')]/../../..//span/input[@type='checkbox'])[2]";
    public void selectAllowedAffiliationAndSign(String enablperiodicmonitoring){
        scrollToElement(format(ALLOWED_AFFILIATION, enablperiodicmonitoring));
        findBy(format(ALLOWED_AFFILIATION,enablperiodicmonitoring)).click();
        waitAbit(1000);
        findBy(format(SIGNATURE_REQUIRED,enablperiodicmonitoring)).click();
        waitAbit(1000);
    }


    public void enableAffiliation(String enablperiodicmonitoring){
        scrollToElement(format(ALLOWED_AFFILIATION, enablperiodicmonitoring));
        if(!findBy(format(ALLOWED_AFFILIATION, enablperiodicmonitoring)).isSelected()) {
            waitAbit(1000);
            findBy(format(ALLOWED_AFFILIATION,enablperiodicmonitoring)).click();
            waitAbit(1000);
        }
    }

    public void disableAffiliation(String enablperiodicmonitoring){
        scrollToElement(format(ALLOWED_AFFILIATION, enablperiodicmonitoring));
        if(findBy(format(ALLOWED_AFFILIATION, enablperiodicmonitoring)).isSelected()) {
            waitAbit(1000);
            findBy(format(ALLOWED_AFFILIATION,enablperiodicmonitoring)).click();
            waitAbit(1000);
        }
    }

    public void enableAffiliationSign(String enablperiodicmonitoring){
        scrollToElement(format(SIGNATURE_REQUIRED, enablperiodicmonitoring));
        if(!findBy(format(SIGNATURE_REQUIRED, enablperiodicmonitoring)).isSelected()) {
            waitAbit(1000);
            findBy(format(SIGNATURE_REQUIRED,enablperiodicmonitoring)).click();
            waitAbit(1000);
        }
    }

    public void disableAffiliationSign(String enablperiodicmonitoring){
        scrollToElement(format(SIGNATURE_REQUIRED, enablperiodicmonitoring));
        if(findBy(format(SIGNATURE_REQUIRED, enablperiodicmonitoring)).isSelected()) {
            waitAbit(1000);
            findBy(format(SIGNATURE_REQUIRED,enablperiodicmonitoring)).click();
            waitAbit(1000);
        }
    }

}
