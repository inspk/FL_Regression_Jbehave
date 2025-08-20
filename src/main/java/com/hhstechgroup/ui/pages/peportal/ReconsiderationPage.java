package com.hhstechgroup.ui.pages.peportal;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.appeal.AppealPanel;
import com.hhstechgroup.ui.panels.appeal.ReconsiderationPanel;
import com.hhstechgroup.ui.panels.pedashboard.SuccessPanel;
import org.openqa.selenium.WebDriver;

public class ReconsiderationPage extends ProviderManagementBasePage {

    private static final String RECONSIDERATION_PANEL = ".//h3[contains(text(), 'Reconsideration Request')]/parent::div/..";
    private static final String RECONSIDERATION = "//button[span[contains(text(), 'Reconsideration')]]";
    private static final String SUBMIT_BUTTON = "//span[contains(text(), 'Submit')]";
    private static final String SUCCESS_PANEL = ".//p[text() = 'Success!']/parent::div";


    public ReconsiderationPage(WebDriver driver) {
        super(driver);
    }

    public void clickReconsideration() {
        findBy(RECONSIDERATION).click();
    }

    public ReconsiderationPanel getReconsiderationPanel() {
        return new ReconsiderationPanel(findBy(RECONSIDERATION_PANEL), this);
    }

    public void submitReconsideration() {
        waitAbit(1500);
        jsClick(SUBMIT_BUTTON);
        waitAbit(1500);
        //findBy(SUBMIT_BUTTON).click();
    }

    public SuccessPanel getSuccessPanel() {
        return new SuccessPanel(findBy(SUCCESS_PANEL), this);
    }

}
