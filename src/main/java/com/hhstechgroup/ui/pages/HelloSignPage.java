package com.hhstechgroup.ui.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static java.lang.String.format;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class HelloSignPage extends AbstractPage {

    private static final String FRAME_ID = "hsEmbeddedFrame";
    private static final String SIGN_FRAME = ".//iframe[@id = 'hsEmbeddedFrame']";
    private static final String OK_BUTTON = ".//div[contains(@class, '-warning--content')]//button";
    private static final String FULL_NAME = ".//div[contains(@class, '-field text')]//div[contains(@class, '-text-input-field required')]/textarea";
    private static final String FULL_NAME_FOCUSED = ".//div[contains(@class, '-field focus text')]//div[contains(@class, '-text-input-field required')]/textarea";
    private static final String CLICK_TO_SIGN = ".//div[contains(@class, 'document-signature-field input')]/span";
    private static final String TYPE_IT_IN = ".//div[contains(@class, '-common-modal-')]//div[contains(@class, '-signature-modal-tab')]//span[text() = 'Type it in']/parent::span";
    // private static final String INSERT = ".//div[contains(@class, 'sign-modal--action-bar')]//button";
    private static final String CONTINUE = "(//div[contains(@class, 'signature-request--header')]//button/span)[5]";
    private static final String AGREE = "//div[contains(@class, 'signature-request-confirm-')]/button";
    private static final String CONFIRMATION_POP_UP = ".//h1[contains(text(), 'Done')]/parent::div";
    private static final String SIGN_BUTTON = ".//span[contains(text(), 'Sign')]";

    public HelloSignPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignButton(){
        findBy(SIGN_BUTTON).click();
    }

    private void closeAlert() {
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public void switchToFrame() {
        waitAbit(5000);
        withTimeoutOf(Duration.ofMinutes(6)).waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(SIGN_FRAME)));
        getDriver().switchTo().frame(FRAME_ID);
    }
    private static final String YES="//button[1]/span[text()='YES']";
    public void clickOnYes(){
        try {
            waitAbit(300);
            findBy(YES).click();
            waitAbit(1000);
        }
        catch (Exception e){

        }
    }

    public void closeWarningModal() {
        withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(OK_BUTTON)));
        WebElementFacade el = findBy(OK_BUTTON);
        evaluateJavascript("arguments[0].click();", el);
    }

    private static final String FULL_NAME1 = ".//textarea[contains(@placeholder,'Full Name')]";
    private static final String FULL_NAME3 =".//textarea[@placeholder = 'Full Name')]";

    public void setFullName(String fullName) {
        withTimeoutOf(Duration.ofSeconds(40)).waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(FULL_NAME1)));
        waitAbit(2000);
        //withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(SIGN_FRAME)));
        //jsClick();\
        // SP-64 and WY-65 new hello sign changes
        findBy(FULL_NAME1).click();
       findBy(FULL_NAME1).sendKeys(fullName);
       waitAbit(1000);
    }

    public void clickClickToSign() {
        WebElementFacade el = findBy(CLICK_TO_SIGN);
        evaluateJavascript("arguments[0].click();", el);
    }

    public void createSignature() {
        waitForPresenceOf(TYPE_IT_IN);
        WebElementFacade type = findBy(TYPE_IT_IN);
        evaluateJavascript("arguments[0].click();", type);
        WebElementFacade insert = findBy(INSERT);
        evaluateJavascript("arguments[0].click();", insert);
        waitAbit(200);
        if (isElementPresent(INSERT)) {
            findBy(INSERT).click();
        }
        waitForAbsenceOf(INSERT);
    }

    public void clickContinue() {
        waitAbit(500);
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(findBy(CONTINUE)));
        withAction().moveToElement(findBy(CONTINUE)).click().build().perform();
        // waitForAbsenceOf(CONTINUE);
    }

    public void clickAgree() {
        waitAbit(500);
        WebElementFacade type = findBy(AGREE);
        evaluateJavascript("arguments[0].click();", type);
//        waitForAbsenceOf(AGREE);
    }

    public void waitForDocumentSigned() {
        withTimeoutOf(Duration.ofSeconds(20)).waitFor(ExpectedConditions.visibilityOf(findBy(CONFIRMATION_POP_UP)));
        waitAbit(16000);
    }

    //Newly Added
    private static final String INSERT ="//button[@data-qa-ref='singing-modal--insert-btn']" ;
    public static final String TXT_BOX_TITLE = ".//div[@ data-field='Title']//textarea[@placeholder='Title']";

    private static final String TYPE_IT_IN2 = ".//div[contains(@class,'dig-Tabs-tabs')]//li[@aria-label='Type in your signature']";
    public void createSignature1() {
        waitForPresenceOf(TYPE_IT_IN2);
        WebElementFacade type = findBy(TYPE_IT_IN2);
        evaluateJavascript("arguments[0].click();", type);
        WebElementFacade insert = findBy(INSERT);
        evaluateJavascript("arguments[0].click();", insert);
        waitAbit(1000);
        if (isElementPresent(INSERT)) {
            waitAbit(500);
            findBy(INSERT).click();
            waitAbit(1000);
        }
        //  waitForAbsenceOf(INSERT);
    }
    //Newly Added
    private static final String CLICK_TO_SIGN1 = ".//div[contains(text(), 'Click to sign')]";
    public void clickClickToSign1() {
        waitAbit(2000);
        WebElementFacade el = findBy(CLICK_TO_SIGN1);
//        scrollToElement(CLICK_TO_SIGN1);
//        findBy(CLICK_TO_SIGN1).click();
        evaluateJavascript("arguments[0].click();", el);
    }

    private static final String AFFILIATION_CLICK_TO_SIGN = ".//div[contains(text(),'Click to sign')]";
    public void clickAffiliationSign() {
        WebElementFacade el = findBy(AFFILIATION_CLICK_TO_SIGN);
        evaluateJavascript("arguments[0].click();", el);
    }

    //sp34 after new signature tool  upated
    private static final String YOUR_NAME = ".//input[contains(@placeholder,'Your name')]";
    public void createSignature2(String yourName) {
        waitForPresenceOf(TYPE_IT_IN2);
        WebElementFacade type = findBy(TYPE_IT_IN2);
        evaluateJavascript("arguments[0].click();", type);
        findBy(YOUR_NAME).type(yourName);
        WebElementFacade insert = findBy(INSERT);
        evaluateJavascript("arguments[0].click();", insert);
        waitAbit(1000);
        if (isElementPresent(INSERT)) {
            waitAbit(500);
            // findBy(INSERT).click();
            waitAbit(2000);
        }
        if(isElementPresent(TXT_BOX_TITLE)){
            findBy(TXT_BOX_TITLE).sendKeys("Mr");
        }

    }

    //Newly Added 41.3
    private static final String CLICK_GET_STARTED = ".//button//span[contains(text(),'Get started')]";
    public void clickGetStarted() {
        WebElementFacade el = findBy(CLICK_GET_STARTED);
        evaluateJavascript("arguments[0].click();", el);
        waitAbit(1000);
    }

    private static final String SIGN_TITLE = ".//textarea[contains(@placeholder,'Title')]";
    public void enterSignTitel() {
        findBy(SIGN_TITLE).sendKeys("MD");
    }

    private static final String FULL_NAME2 = ".//textarea[contains(@placeholder,'Title')]";
    public void setFullName1(String fullName) {
        withTimeoutOf(Duration.ofSeconds(40)).waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(FULL_NAME2)));
        waitAbit(200);
        jsClick(FULL_NAME2);
        //  findBy(FULL_NAME1).click();
        findBy(FULL_NAME2).sendKeys(fullName);
        // findBy(FULL_NAME_FOCUSED).sendKeys(fullName);
        waitAbit(100);
    }

    private static final String NPI = "(//span/span[text()])[1]";
    private static final String PROVIDER_NAME = "(//span/span[text()])[2]";
    public String getAgreementNPI() {
        return findBy(NPI).getText();
    }

    public String getAgreementProvidername() {
        return findBy(PROVIDER_NAME).getText();
    }

}
