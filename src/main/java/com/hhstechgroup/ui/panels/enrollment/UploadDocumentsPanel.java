package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import static java.lang.String.format;

public class UploadDocumentsPanel extends BaseEnrollmentPanel {

    private static final String UPLOAD_BUTTON = ".//h4[text() = '%s']/../../div[contains(@class, 'upload_upload-controls')]/input";
    private static final String UPLOADED_DOCUMENT = ".//h4[text() = '%s']/ancestor::div[contains(@class, 'upload-body')]/following-sibling::div//div[text() = '%s']";
    private static final String UPLOAD_ERROR = "//div[contains(@class, 'upload-files-box') and contains (.//h4, '%s')]//div[contains(@class, 'utils_field-errors')]";
    private static final String DELETE_BUTTON = ".//h4[text() = '%s']/ancestor::div[contains(@class, 'upload-body')]/following-sibling::div//div[text() = '%s']/following-sibling::button[@aria-label='Remove Upload']";
    private static final String COMMENT="//input[contains(@id,'comment')]";
    private static final String ADD_FILES="(//span[contains(text(),'Add File')])[2]";
    public UploadDocumentsPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    //new
    private static final String UPLOAD_INPUT = ".//input[@type=\'file\']";
    public void uploadDoc(String path) {
        WebElement element = findBy(UPLOAD_INPUT);
        getBasePage().evaluateJavascript("arguments[0].style = \"\"; arguments[0].style.display = \"block\"; arguments[0].style.visibility = \"visible\";", element);
        waitABit(1000);
        getBasePage().upload(path).to(element);
        waitABit(1000);
    }

    public void uploadDocument(String type, String path) {
        scrollToElement(format(UPLOAD_BUTTON,type));
        WebElement element = findBy(String.format(UPLOAD_BUTTON, type));
        upload(element, path);
    }

    public void uploadFile(String element,String path){
        scrollToElement(format(UPLOAD_FILE,element));
        WebElement upload = findBy(String.format(UPLOAD_FILE,element));
        upload(upload, path);
        waitABit(1000);
        findBy(COMMENT).sendKeys("Uploaded File Successfully");
        waitABit(1000);
        findBy(ADD_FILES).click();
        waitABit(500);
    }

    public void deleteDocument(String type, String documentName) {
        clickOn(String.format(DELETE_BUTTON, type, documentName));
        waitForAbsenceOf(String.format(DELETE_BUTTON, type, documentName));
    }

    public boolean isDocumentUploaded(String documentName, String type) {
        return isElementPresent(String.format(UPLOADED_DOCUMENT, type, documentName));
    }

    public void waitForDocumentDeleted(String documentName, String type) {
        waitForAbsenceOf(String.format(UPLOADED_DOCUMENT, type, documentName));
    }

    public String getErrorDisplayed(String field) {
        return findBy(String.format(UPLOAD_ERROR, field)).getText();
    }

    //wy-63 adding new code for wyomi
    private static final String UPLOAD_BUTTON3 = ".//*[text() = '%s']/../../div[contains(@class, 'upload-controls')]//span";
    public void uploadDocument3(String type, String path) {
        scrollToElement(format(UPLOAD_BUTTON3,type));
        WebElement element = findBy(String.format(UPLOAD_BUTTON3, type));
        upload(element, path);
    }
    private static final String ADD_FILE="//button//span[contains(text(),'%s')]";
    private static final String SELECT_SECTION="//input[contains(@id,'section')]/..//div";
    private static final String FIELD="//label[contains(text(),'Select Field')]/..//div//div";
    private static final String SELECT_FIELD="//div//ul[@role='listbox']//li[contains(text(),'Perioperative Nursing')]";
    private static final String UPLOAD_FILE="//span[contains(text(),'%s')]";
    public void verifyAndUploadDoc(String fileName){
            findBy(String.format(ADD_FILE,fileName)).isDisplayed();
            System.out.println("Add file button is present and uploading document");
            findBy(String.format(ADD_FILE,fileName)).click();
            waitABit(500);
            findBy(SELECT_SECTION).click();
            waitABit(500);
            selectFromDropDown("Upload Documents");
            waitABit(500);
            findBy(FIELD).click();
            waitABit(500);
            findBy(SELECT_FIELD).click();
            waitABit(500);
            selectFromDropDown("Perioperative Nursing");
            waitABit(1000);
    }

    public static final String UPLOAD_REQUEST_TERMINATION = ".//div[contains(@class, 'upload-controls')]/input";
    public void uploadDocForRequestTermination(String path) {
        scrollToElement(UPLOAD_REQUEST_TERMINATION);
        waitABit(500);
        WebElement element = findBy(UPLOAD_REQUEST_TERMINATION);
        upload(element, path);
    }

}
