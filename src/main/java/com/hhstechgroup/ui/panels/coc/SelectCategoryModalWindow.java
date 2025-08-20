package com.hhstechgroup.ui.panels.coc;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

import static java.lang.String.format;

public class SelectCategoryModalWindow extends BaseModalPanel {

    private static final String CATEGORY = ".//span[text() = '%s']/preceding-sibling::span//input";
    private static final String CREATE_COC_BUTTON = ".//button[span[text() = 'Create CoC']]";
    //latest
    private static final String CREATE_COC_GROUP = ".//button[span[text() = 'Create']]";
    public SelectCategoryModalWindow(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void selectCategories(List<String> categories) {
        waitABit(1000);
        categories.forEach(category ->
                findBy(format(CATEGORY, category)).click());
    }

    public void selectCategory(String category) {
        findBy(format(CATEGORY, category)).click();
    }

    public void clickCreateCocButton() {
        findBy(CREATE_COC_GROUP).click();
        waitForPopUpClosed();
    }
    //latest
    public void clickCreateCocGroup() {
        //findBy(CREATE_COC_GROUP).click();
        // waitABit(1000);
        scrollToElement(CREATE_COC_GROUP);
        jsClick(CREATE_COC_GROUP);
//        waitForPopUpClosed();
    }

    //sp22
    private static final String CREATE_COC_BUTTON2 = ".//button/span[contains(text(),'Create CoC')]";

    public void clickCreateCocButtonOwn() {
        scrollToElement(CREATE_COC_BUTTON2);
        findBy(CREATE_COC_BUTTON2).click();

    }

    private static final String CREATE_COC_BUTTON3 = ".//button/span[contains(text(),'Create')]";

    public void clickGroupCreateCocButtonOwn() {
        scrollToElement(CREATE_COC_BUTTON3);
        findBy(CREATE_COC_BUTTON3).click();

    }

    //sp26

    public void clickCreateCocGroup1() {
        //findBy(CREATE_COC_GROUP).click();
        // waitABit(1000);
        scrollToElement(CREATE_COC_GROUP);
        jsClick(CREATE_COC_GROUP);
        waitABit(200);
    }

    private static final String PROVIDER_NAME = "//input[@id='providerName']";
    private static final String SEARCH_ICOC = "//div[@aria-label='responsive-dialog-title']//button/span[text()='Search']";
//    private static final String PROVIDER_RADIO_BUTTON = "//input[@name='radio-buttons']";
private static final String PROVIDER_RADIO_BUTTON = "(//input[@name='radio-buttons'])[1]";
    private static final String NEXT_BUTTON = "//button[span[normalize-space()='Next']]";
    private static final String ICOC_ENROLLMENT_TYPE = "//div[contains(text(),'Enrollment Type')]";
    private static final String ICOC_ENROLLMENT_OPTIONS = "//div[contains(@class, 'option')][text()='%s']";
//    private static final String ICOC_PROVIDER_NAME = "//div[contains(@class,'MuiDialog')]//span[contains(text(),'PES ID')]";
    private static final String ICOC_PROVIDER_NAME = "//input[contains(@id,'providerName')]";

    public void fillProviderName(String providername) {
        waitABit(1000);
        findBy(PROVIDER_NAME).type(providername);
        waitABit(1000);
    }

    public void selectEnrollmentType(String enrollmentType) {
        waitABit(500);
        findBy(ICOC_ENROLLMENT_TYPE).click();
        waitABit(500);
        findBy(format(ICOC_ENROLLMENT_OPTIONS, enrollmentType)).click();
        waitABit(500);
    }

    public void searchproviderID(String providerid){
        waitABit(2000);
        jsClick(ICOC_PROVIDER_NAME);
        waitABit(2000);
//        findBy(ICOC_PROVIDER_NAME).type(providerid);
        findBy(ICOC_PROVIDER_NAME).sendKeys(providerid);
        waitABit(2000);
    }

    public void clickSearchICoc() {
        waitABit(500);
        findBy(SEARCH_ICOC).click();
        waitABit(500);
    }

    public void selectProvider() {
        waitABit(500);
        findBy(PROVIDER_RADIO_BUTTON).click();
        waitABit(500);
    }

    public void clickNext() {
        waitABit(500);
        scrollToElement(NEXT_BUTTON);
        waitABit(500);
        findBy(NEXT_BUTTON).click();
        waitABit(500);
    }



}

