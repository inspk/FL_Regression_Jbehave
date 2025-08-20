package com.hhstechgroup.ui.pages.systemoptions;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.systemoptions.RequestAddtionalInformationPanel;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class RequestAddtionalInformationPage extends AbstractPage {
    //sp29
    private static final String ENABLE_AUTO_DENY=".//div/span[contains(text(),'%s')]/../..//span/input[@type='checkbox']";
    private static final String EDIT_BUTTON = ".//button/span[contains(text(), 'Edit')]";
    private static final String SAVE=".//button/span[contains(text(), 'Save')]";
    public static final String  REQUESTADDTIONALINFORMATION_PANEL= ".//div[contains(@class,'system-options_system-content_')]";
    private static final String OK =".//button/span[contains(text(), 'OK')]";

    public RequestAddtionalInformationPage(WebDriver driver) {
        super(driver);
    }

    public void clickEditButton(){
        scrollToElement(EDIT_BUTTON);
        findBy(EDIT_BUTTON).click();
    }
    public void clickOnEnableAutoDeny(String enableautodeny){
       findBy(format(ENABLE_AUTO_DENY, enableautodeny)).click();
        waitAbit(1000);
    }
    public void clickSaveButton(){
        scrollToElement(SAVE);
        waitABit(500);
        jsClick(SAVE);
        waitABit(500);
        findBy(OK).click();
        waitABit(500);
    }
    public RequestAddtionalInformationPanel getRequestAdditonalInfo(){
        return  new RequestAddtionalInformationPanel(
                findBy(REQUESTADDTIONALINFORMATION_PANEL),this);
    }

}
