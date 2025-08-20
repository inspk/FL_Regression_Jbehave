package com.hhstechgroup.ui.panels.appeal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.lang.String.format;

public class AppealPanel extends BaseEnrollmentPanel {

    private static final String REASON = ".//input[contains(@id, 'Reason')]";
    private static final String FIRST_NAME = ".//input[contains(@id, 'First name')]";
    private static final String LAST_NAME = ".//input[contains(@id, 'Last name')]";
    private static final String SIGN = ".//input[@type='checkbox']";
    private static final String UPLOAD_BUTTON = ".//span[contains(text(), 'Upload Files')]";
    private static final String UPLOAD_INPUT = ".//input[@type=\'file\']";
    private static final String UPLOADED_DOCUMENT = ".//div[contains(@class, 'progress')]//div[contains(text(), '%s')]";
    private static final String ATTACH_LABEL = ".//h4[contains(text(), 'Attach documents')]";
    private static final String VALUE = ".//h4[text() = '%s']/following-sibling::div";
    private static final String DOCUMENT = ".//h1/span[text() = '%s']/parent::h1/following-sibling::div//div[contains(@class, 'file-details_')]/p[text() = '%s']";

    public AppealPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setReason(String reason) {
        findBy(REASON).type(reason);
        //findBy(ATTACH_LABEL).click();
    }

    public void setFirstName(String firstName) {
        findBy(FIRST_NAME).type(firstName);
    }

    public void setLastName(String lastName) {
        findBy(LAST_NAME).type(lastName);
    }

    public boolean isUploadButtonPresent() {
        return isElementPresent(UPLOAD_BUTTON);
    }

    public void signAppeal() {
        findBy(SIGN).click();
    }

    public void uploadAppealDoc(String path) {
        WebElement element = findBy(UPLOAD_INPUT);
        getBasePage().evaluateJavascript("arguments[0].style = \"\"; arguments[0].style.display = \"block\"; arguments[0].style.visibility = \"visible\";", element);
        getBasePage().upload(path).to(element);
    }

    public boolean isAppealDocUploaded(String documentName) { waitABit(2000);
        return isElementPresent(format(UPLOADED_DOCUMENT, documentName));
    }

    public Map<String, String> getFieldsValues(List<String> fields) {
        Map<String, String> fieldsValues = new HashMap<>();
        fields.forEach(field -> { String element = format(VALUE, field);
            fieldsValues.put(field, findBy(element).getText());
        });
        return fieldsValues;
    }

    public boolean isAppealDocumentPresent(String documentName, String type) {
        return isElementPresent(String.format(DOCUMENT, type, documentName));
    }
}
