package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.testautomationguru.utility.PDFUtil;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.util.Optional;

import static java.lang.String.format;

public class FilesDocumentsPanel extends AbstractPanel {

    private static final String DOCUMENT = ".//h2[span[text() = '%s']]/following-sibling::div//div[contains(@class, 'file-details_')]/p[text() = '%s']";
    private static final String DOWNLOAD_DOCUMENT = "/parent::div/following-sibling::div//a";
    private static final String PRINT_DOCUMENT = "/parent::div/following-sibling::div//span[contains(@class, 'documents_print_')]";
    private static final String ADD_FILE = ".//button[span[text() = 'Add File']]";
    private static final String UPDATE_DOCUMENT = "/ancestor-or-self::div[contains(@class, 'item')]//span[text() = 'Update']";
    private static final String VIEW_OUTDATED_VERSION_BY_TYPE = ".//span[contains(text(), '%s')]/ancestor-or-self::div[contains(@class, 'field')]//span[text() = ' outdated versions']";
    private static final String COMMENT = ".//span[contains(text(), '%s')]//ancestor-or-self::div[contains(@class, 'field')]//p[contains(text(), '%s')]/following-sibling::div/p[2]";
    private static String tab;


    public FilesDocumentsPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public boolean isDocumentPresent(String documentName, String type) {
        return isElementPresent(String.format(DOCUMENT, type, documentName));
    }

    public void clickDownloadButton(String documentName, String type) {
        selectDocumentAction(documentName,type, DOWNLOAD_DOCUMENT);
    }

    public String getDownloadUrl(String documentName, String type) {
        return findBy(String.format(DOCUMENT, type, documentName).concat(DOWNLOAD_DOCUMENT)).getAttribute("href");
    }

    public String getDownloadPageUrl() {
        String downloadWindow = getDriver().getWindowHandles().stream().filter(window -> !window.equals(tab)).findFirst().orElse(null);
        String url = downloadWindow != null ? getDriver().switchTo().window(downloadWindow).getCurrentUrl() : null;
        getDriver().switchTo().window(tab);
        return url;
    }

    public boolean isPrintButtonPresent(String documentName, String type) {
        return isElementPresent(String.format(DOCUMENT, type, documentName).concat(PRINT_DOCUMENT));
    }

    public void clickAddFileButton() {
        findBy(ADD_FILE).click();
        //sp32
        //waitForPopUpOpened();
    }

    public void clickViewOutdatedVersionByType (String section) {
        findBy(format(VIEW_OUTDATED_VERSION_BY_TYPE, section)).click();
    }

    public String getCommentTextInDocument(String section, String document) {
        return (findBy(format(COMMENT, section, document))).getText();
    }

    public void clickUpdateButton(String documentName, String type) {
        selectDocumentAction(documentName,type, UPDATE_DOCUMENT );
    }

    public void selectDocumentAction(String document, String type, String action) {
        tab = getDriver().getWindowHandle();
        jsClick(String.format(DOCUMENT, type, document).concat(action));
    }
    //sp32
    private static final String CLICK_SEARCH=".//div[contains(@class,'layout_search-wrap_')]/../..//button//*[local-name() = 'svg' and @aria-hidden='true']";
    private static final String SEARCH_DOCUMENT = ".//label[contains(@for,'inbox-search')]/../div/input[@id='inbox-search']";

    public void  clicksearch(String documentname){
        scrollToElement(CLICK_SEARCH);
        findBy(CLICK_SEARCH).click();
        findBy(SEARCH_DOCUMENT).type(documentname);
        findBy(SEARCH_DOCUMENT).sendKeys(Keys.ENTER);
    }

    private static final String CLICK_FILTERS=".//div[contains(@class,'layout_app-details-filter_')]/../..//*[local-name() = 'svg' and @aria-hidden='true']";
    public  void clickfilters() {
       scrollToElement(CLICK_FILTERS);
       findBy(CLICK_FILTERS).click();
       waitABit(1000);
   }
}
