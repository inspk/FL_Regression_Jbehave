package com.hhstechgroup.ui.panels.sitevisit;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class AdditionalQuestionsPanel extends BaseEnrollmentPanel {

    private static final String UPLOAD_PHOTOGRAPHS = ".//h4[text() = 'Photographs']/../../div[contains(@class, 'upload_upload-controls')]/input";
    private static final String SUBMIT_BUTTON = ".//button[span[contains(text(), 'Submit')]]";

    public AdditionalQuestionsPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void uploadPhotographs(String path) {
        WebElement element = findBy(UPLOAD_PHOTOGRAPHS);
        upload(element, path);
    }

    public void clickSubmit() {
        scrollToElement(SUBMIT_BUTTON);
        findBy(SUBMIT_BUTTON).waitUntilClickable().click();
        waitForAbsenceOf(SUBMIT_BUTTON);
    }
}
