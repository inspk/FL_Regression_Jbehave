package com.hhstechgroup.ui.panels.pedashboard;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

public class UserPopUp extends AbstractPanel {

    private static final String OPTION = ".//li[div/span[contains(text(), '%s')]]";

    public UserPopUp(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void clickOnOption(String opionName) {
        String element = String.format(OPTION, opionName);
        jsClick(element);
        try {
            jsClick(element);
            findBy("//div//ul[@role='menu']").sendKeys(Keys.ESCAPE);
        }
        catch (Exception e){
//            jsClick(element);
//            System.out.println(" clicked");
//            findBy("//div//ul[@role='menu']").sendKeys(Keys.ESCAPE);
        }
//        findBy(element).click();
        waitABit(6000);
//        waitForAbsenceOf(element);
    }
}
