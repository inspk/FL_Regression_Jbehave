package com.hhstechgroup.ui.pages.systemoptions;

import com.hhstechgroup.ui.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class AutoArchivePage extends AbstractPage {

    private static final String EDIT_BUTTON =".//h3[contains(text(),'%s')]/../../../../../..//button/span[contains(text(),'Edit')]" ;

    public AutoArchivePage(WebDriver driver) {
        super(driver);
    }
    public void clickOnEditButton(String button){
        scrollToElement(format(EDIT_BUTTON,button));
        //findBy(format(EDIT_BUTTON,button)).click();
        jsClick(format(EDIT_BUTTON,button));
    }

    private static final String SAVE_BUTTON =".//h3[contains(text(),'%s')]/../../../../../..//button/span[contains(text(),'Save')]" ;
    private static final String OK_BUTTON =".//button/span[contains(text(),'Ok')]";
    public void clickOnSaveButton(String button){
        scrollToElement(format(SAVE_BUTTON,button));
        jsClick(format(SAVE_BUTTON,button));
        jsClick(OK_BUTTON);
    }
    //sp43.2
    private static final String EFFECTIVE_START_DATE = ".//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;
    public void setEffectiveStartDate(String effectiveStartDate) {
        scrollToElement(EFFECTIVE_START_DATE);
        jsClick(EFFECTIVE_START_DATE);
        findBy(format(EFFECTIVE_START_DATE,effectiveStartDate)).sendKeys(effectiveStartDate);
    }

    //sp59

    private static final String CANCEL_BUTTON = ".//button/span[contains(text(),'Cancel')]" ;
    private static final String OK_BUTTON1 =".//button/span[contains(text(),'OK')]";
    public void clickOnCancelButtton(){
        scrollToElement(CANCEL_BUTTON);
        jsClick(CANCEL_BUTTON);
        jsClick(OK_BUTTON1);

    }
}
