package com.hhstechgroup.ui.pages.systemoptions;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.systemoptions.LicensurePanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LicensurePage extends AbstractPage {

    public LicensurePage(WebDriver driver) {
        super(driver);
    }

    public static final String  LICENSURE_PANEL= ".//div[contains(@class,'system-content fl')]";
    private static final String SAVE_BUTTON = "//button/span[contains(text(), 'Save')]";
    private static final String OK_BUTTON ="//button/span[contains(text(), 'Ok')]";
    public void clickSaveButton() {
        scrollToElement(SAVE_BUTTON);
        waitABit(500);
        findBy(SAVE_BUTTON).click();
        waitABit(500);
        findBy(OK_BUTTON).click();
        waitABit(500);
    }

    public LicensurePanel getLicensureInfo(){
        return  new LicensurePanel(
                findBy(LICENSURE_PANEL),this);
    }
}
