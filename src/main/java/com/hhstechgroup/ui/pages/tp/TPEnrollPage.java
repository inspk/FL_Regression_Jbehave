package com.hhstechgroup.ui.pages.tp;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.SoftwareVendorDetailsPanel;
import org.openqa.selenium.WebDriver;

public class TPEnrollPage extends AbstractPage {

    private static final String APP_CONTACT_EMAIL= ".//div/input[contains(@id,'Application contact email-')]";
    private static final String NEXT_BUTTON=".//div/button/span[contains(text(),'Next')]";

    public TPEnrollPage(WebDriver driver) {
        super(driver);
    }
    public void setAppContactEmail(String email) {
        scrollToElement(APP_CONTACT_EMAIL);
        waitAbit(500);
        findBy(APP_CONTACT_EMAIL).type(email);
        waitAbit(1000);
    }
    public  void clickOnNextButton(){
        findBy(NEXT_BUTTON).click();}

}
