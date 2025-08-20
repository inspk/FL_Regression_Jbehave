package com.hhstechgroup.ui.panels.appeal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;


public class ReconsiderationPanel extends BaseEnrollmentPanel {

    private static final String REASON = "//div[label[(text()='Reason/Explanation for Reconsideration')]]//input";
    private static final String FIRST_NAME = "//div[label[(text()='First name')]]//input";
    private static final String LAST_NAME = "//div[label[(text()='Last name')]]//input";
    private static final String SIGN = ".//input[@type='checkbox']";
    private static final String UPLOAD_BUTTON = ".//span[contains(text(), 'Upload Files')]";
    private static final String UPLOAD_INPUT = ".//input[@type=\'file\']";
    private static final String UPLOADED_DOCUMENT = ".//div[contains(@class, 'progress')]//div[contains(text(), '%s')]";
    private static final String ATTACH_LABEL = ".//h4[contains(text(), 'Attach documents')]";
    private static final String VALUE = ".//h4[text() = '%s']/following-sibling::div";
    private static final String DOCUMENT = ".//h1/span[text() = '%s']/parent::h1/following-sibling::div//div[contains(@class, 'file-details_')]/p[text() = '%s']";



    public ReconsiderationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }


    public void setReason(String reason) {
        findBy(REASON).type(reason);

    }

    public void setFirstName(String firstName) {
        findBy(FIRST_NAME).type(firstName);
    }

    public void setLastName(String lastName) {
        findBy(LAST_NAME).type(lastName);
    }


    public void uploadReconsiderationDoc(String path) {
        WebElement element = findBy(UPLOAD_INPUT);
        getBasePage().evaluateJavascript("arguments[0].style = \"\"; arguments[0].style.display = \"block\"; arguments[0].style.visibility = \"visible\";", element);
        getBasePage().upload(path).to(element);
    }

    public boolean isUploadButtonPresent() {
        return isElementPresent(UPLOAD_BUTTON);
    }

    public void signReconsideration() {
        findBy(SIGN).click();
    }

}

