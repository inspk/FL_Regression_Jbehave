package com.hhstechgroup.ui.pages.registration;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.registration.RegistrationHeaderPanel;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static java.lang.String.format;

@DefaultUrl("/registration")
public class RegistrationPage extends ProviderManagementBasePage {
    private static final String EMAIL = ".//form//input[@id='email']";
    private static final String PASSWORD = ".//form//input[@id='password']";
    private static final String VALIDATE_PASSWORD = ".//form//input[@id='passwordToCompare']";
    private static final String ORG_NAME = ".//form//input[@id='orgName']";
    private static final String ORG_DESC = ".//form//input[@id='orgDescription']";
    private static final String FIRST_NAME = ".//form//input[@id='firstName']";
    private static final String MIDDLE_NAME = ".//form//input[@id='midName']";
    private static final String LAST_NAME = ".//form//input[@id='lastName']";
    private static final String PREFIX = ".//form//select[@id='selectPrefix']/option[@value='%s']";
    private static final String SUFFIX = ".//form//select[@id='select-suffix']/option[@value='%s']";
    private static final String PHONE = ".//form//input[@id='phone']";
    private static final String EXTENSION = ".//form//input[@id='extension']";
    private static final String REGISTER_BUTTON = ".//div[contains(@class, 'registration-form')]//button//span[contains(text(), 'Register')]";
    private static final String ALREADY_HAVE_ACCOUNT_LINK = ".//a[text() = 'Already have an account? Log in']";
    private static final String HEADER = ".//div[contains(@class, 'header-wrapper__header__')]";
    private static final String VALIDATION_MESSAGE = "//label[contains(text(), '%s')]/parent::div/following-sibling::div/div";
    private static final String PASS_TOOLTIP = "//div[contains(@class, 'password-errors')]/parent::div";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationHeaderPanel getHeaderPanel() {
        return new RegistrationHeaderPanel(findBy(HEADER), this);
    }

    public boolean isAlreadyHAveAccountLinkPresent() {
        return isElementPresent(ALREADY_HAVE_ACCOUNT_LINK);
    }

    public void fillEmail(String email) {
        waitAbit(500);
        findBy(EMAIL).type(email);
    }

    public void fillPassword(String password) {
        findBy(PASSWORD).type(password);
    }

    public void fillValidatePassword(String validatePassword) {
        findBy(VALIDATE_PASSWORD).type(validatePassword);
    }

    public void fillOrgName(String orgName) {
        findBy(ORG_NAME).type(orgName);
    }

    public void fillOrgDescription(String orgDescription) {
        findBy(ORG_DESC).type(orgDescription);
    }

    public void fillFirstName(String firstName) {
        findBy(FIRST_NAME).type(firstName);
    }

    public void fillLastName(String lastName) {
        findBy(LAST_NAME).type(lastName);
    }

    public void fillMiddleName(String middleName) {
        findBy(MIDDLE_NAME).type(middleName);
    }

    public void fillPhone(String phone) {
//        findBy(PHONE).type(phone);
        findBy(PHONE).sendKeys(phone);
    }

    public void fillExtension(String extension) {
        findBy(EXTENSION).type(extension);
    }

    public void selectPrefix(String option) {
        findBy(format(PREFIX, option)).click();
    }

    public void selectSuffix(String option) {
        findBy(format(SUFFIX, option)).click();
    }

    public void clickRegisterButtonOnRegistrationPage() {
        findBy(REGISTER_BUTTON).click();
    }

    public void clickAlreadyHaveAccountLink() {
        findBy(ALREADY_HAVE_ACCOUNT_LINK).click();
    }

    public String getValidationMessage(String field) {
        return findBy(format(VALIDATION_MESSAGE, field)).getText();
    }

    public boolean isPassTooltipPresent() {
        return isElementPresent(PASS_TOOLTIP);
    }

    public static String generateEmail(String domain){
        String emailNumber = Integer.toString(generateRandomNumberForEmail(1,10000));
        return "tuser7289+" + emailNumber + "@" + domain;
    }
    public static int generateRandomNumberForEmail (int min, int max){
        int spread = max - min;
        return new Random().nextInt(spread + 1) + min;
    }


    //sp34
    private static final String SELECT_CAPCHA_CHECKBOX = ".//div//span[contains(@class,'recaptcha-checkbox')]";
    private static final By CAPCHA_IFRAME = By.xpath ("//iframe[contains(@role,'presentation')]");
    public void selectCapchaCheckbox() {
        waitAbit(200);
        WebElement iframe = getDriver().findElement(CAPCHA_IFRAME);
        getDriver().switchTo().frame(iframe);
        waitAbit(200);
        scrollToElement(SELECT_CAPCHA_CHECKBOX);
        jsClick(SELECT_CAPCHA_CHECKBOX);
        waitAbit(200);
    }

    // sp54 new product ui

    private static final String CREATE_ACCOUNT_LINK = ".//li//a[text()='Create Account']";
    private static final String CONTINUE_BUTTON = ".//span[text()='CONTINUE']";
    private static final String CREATE_ACCOUNT_BUTTON =".//span[text()='CREATE ACCOUNT']" ;

    public void clickCreateAccountLink(){
        waitAbit(100);
        scrollToElement(CREATE_ACCOUNT_LINK);
        waitAbit(100);
        findBy(CREATE_ACCOUNT_LINK).click();
        waitAbit(100);
    }

    public void clickContinueButton(){
        waitAbit(100);
        findBy(CONTINUE_BUTTON).click();
        waitAbit(100);
    }

    public void clickCreateAccountButton(){
        waitAbit(100);
        scrollToElement(CREATE_ACCOUNT_BUTTON);
        waitAbit(100);
        findBy(CREATE_ACCOUNT_BUTTON).click();
        waitAbit(100);
    }

}
