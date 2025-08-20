package com.hhstechgroup.ui.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.webdriver.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static com.hhstechgroup.util.properties.SystemProperties.PAYMENT_URL;
import static java.lang.String.format;

public class Payment2CheckoutPage extends AbstractPage {

    private static final String CONTINUE_TO_BILLING_BUTTON = ".//form//button[@type = 'submit' and span[contains(text(), 'Continue to Billing')]]";
    private static final String CONTINUE_TO_PAYMENT_BUTTON = ".//form//button[@type = 'submit' and span[contains(text(), 'Continue to Payment')]]";
    private static final String SUBMIT_PAYMENT_BUTTON = ".//form//button[@type = 'submit' and span[contains(text(), 'Submit Payment')]]";
    private static final String COUNTRY = "//select[@name = 'country']/option";
    //  private static final String FULL_NAME = ".//input[contains(@id, 'full-name')]";
    private static final String FIRST_ADDRESS = ".//input[contains(@id, 'address-1')]";
    private static final String SECOND_ADDRESS = ".//input[contains(@id, 'address-2')]";
    //    private static final String CITY = ".//input[contains(@id, 'city')]";
    private static final String STATE = ".//select[@name = 'state']/option";
    private static final String STATE_DROP_DOWN = ".//select[@name = 'state']";
    //    private static final String ZIP = ".//input[contains(@id, 'postal')]";
    private static final String PHONE = ".//input[@id = 'phone']";
    //    private static final String EMAIL = ".//input[contains(@id, 'email')]";
//    private static final String CREDIT_CARD_NUMBER = ".//input[contains(@id, 'card-number')]";
    private static final String EXPIRATION_MONTH = ".//select[@id = 'exp-month']";
    private static final String EXPIRATION_YEAR = ".//select[@id = 'exp-year']";
    private static final String OPTION = ".//option[text() = '%s']";
    //  private static final String CVV = ".//input[@id = 'cvv']";
//    private static final String COUNTRY_DROP_DOWN = ".//select[@name = 'country']";
    private static final String CHECKOUT_TITLE = ".//h1[contains(text(), 'Checkout')]";


    public Payment2CheckoutPage(WebDriver driver) {
        super(driver);
        setPaymentSystemUrl();
    }

    private void setPaymentSystemUrl() {
        final Configuration configuration = Injectors.getInjector().getInstance(Configuration.class);
        configuration.setDefaultBaseUrl(
                PAYMENT_URL.getProperty());
    }

    public void clickContinueToBillingInfo() {
        waitForPresenceOf(CHECKOUT_TITLE);
        findBy(CONTINUE_TO_BILLING_BUTTON).click();
        waitForAbsenceOf(CONTINUE_TO_BILLING_BUTTON);
    }

    public void clickContinueToPayment() {
        new Actions(getDriver()).moveToElement(findBy(CONTINUE_TO_PAYMENT_BUTTON)).click().build().perform();
        waitForAbsenceOf(CONTINUE_TO_PAYMENT_BUTTON);
    }

    public void clickSubmitPayment() {
        waitAbit(500);
        jsClick(SUBMIT_PAYMENT_BUTTON);
        waitAbit(2000);
        //  findBy(SUBMIT_PAYMENT_BUTTON).click();
        // waitForAbsenceOf(SUBMIT_PAYMENT_BUTTON);
    }

    public String getCountry() {
        return findAll(COUNTRY).stream()
                .filter(el -> el.getAttribute("selected") != null)
                .findFirst()
                .get()
                .getText();
    }

    public String getCity() {
        return findBy(CITY).getAttribute("value");
    }

    public String getFullName() {
        return findBy(FULL_NAME).getAttribute("value");
    }

    public String getFirstAddress() {
        return findBy(FIRST_ADDRESS).getAttribute("value");
    }

    public String getSecondAddress() {
        return findBy(SECOND_ADDRESS).getAttribute("value");
    }

    public String getState() {
        return findAll(STATE).stream()
                .filter(el -> el.getAttribute("selected") != null)
                .findFirst()
                .get()
                .getText();
    }

    public String getZip() {
        return findBy(ZIP).getAttribute("value");
    }

    public String getPhone() {
        return findBy(PHONE).getAttribute("value");
    }

    public String getEmail() {
        return findBy(EMAIL).getAttribute("value");
    }

    public void setCreditCardNumber(String number) {
        findBy(CREDIT_CARD_NUMBER).type(number);
    }

    public void setExpirationMonth(String expirationMonth) {
        selectFromDropdown(findBy(EXPIRATION_MONTH), expirationMonth);
    }

    public void setExpirationYear(String expirationYear) {
        selectFromDropdown(findBy(EXPIRATION_YEAR), expirationYear);
    }

    public void setCvv(String cvv) {
        findBy(CVV).type(cvv);
    }

    public void setCity(String city) {
        findBy(CITY).type(city);
    }

    public void setState(String state) {
        selectFromDropdown(findBy(STATE_DROP_DOWN), state);
    }

    public void setCountry(String country) {
        selectFromDropdown(findBy(COUNTRY_DROP_DOWN), country);
    }

    public void setFullName(String fullName) {
        findBy(FULL_NAME).type(fullName);
    }

    public void setFirstAddress(String firstAddress) {
        findBy(FIRST_ADDRESS).type(firstAddress);
    }

    public void setSecondAddress(String secondAddress) {
        findBy(SECOND_ADDRESS).type(secondAddress);
    }

    public void setZip(String zip) {
        findBy(ZIP).type(zip);
    }

    public void setEmail(String email) {
        findBy(EMAIL).type(email);
    }

    public void setPhone(String phone) {
        findBy(PHONE).type(phone)
        ;
    }

    //new payment third party tool feilds adding

//    private static final String COUNTRY_DROP_DOWN = ".//select[@name = 'country']";
//    private static final String CITY = ".//input[contains(@id, 'city')]";
//    private static final String ZIP = ".//input[contains(@id, 'zip')]";
//    private static final String EMAIL = ".//input[contains(@id, 'email')]";

    private static final String COUNTRY_DROP_DOWN = ".//select[@name = 'country']";
    private static final String CITY = ".//input[contains(@name, 'city')]";
    private static final String ZIP =  ".//input[contains(@name, 'billingPostalCode')]" ;
    private static final String EMAIL = ".//input[contains(@name, 'email')]";

    public void setNewCity(String city) {
        waitAbit(200);
        findBy(CITY).type(city);
    }

    public void setNewZip(String zip)
    {
        waitAbit(200);
        findBy(ZIP).type(zip);
    }

    public void setNewEmail(String email) {
        findBy(EMAIL).type(email);
    }

    private static final String CLICK_COUNTRY = ".//span[contains(text(),'Country')]/../..//div[contains(@class,'multiselect__select')]" ;
    private static final String CLICK_SEARCH_IN_COUNTRY =".//input[contains(@id,'dropdown-multiselect-country')]" ;
    private static final String SELECT_COUNTRY =".//li//span[contains(text(),'%s')]" ;

    public void setNewCountry(String country) {
        waitAbit(200);
        findBy(CLICK_COUNTRY).click();
        //findBy(CLICK_SEARCH_IN_COUNTRY).sendKeys(country);
        waitAbit(200);
        findBy(format(SELECT_COUNTRY,country)).click();
        waitAbit(2000);
        waitForSpinnerToDisappear();

    }

    //new card details

//    private static final String CREDIT_CARD_NUMBER = ".//input[contains(@id, 'card')]";
//    private static final String EXPIRATION_DATE = ".//input[contains(@id, 'date')]";
//    private static final String CVV = ".//input[@id = 'cvv']";
//    private static final String FULL_NAME = ".//input[contains(@id, 'name')]";

    //private static final String CREDIT_CARD_NUMBER = ".//input[contains(@name, 'card')]";
//    private static final String EXPIRATION_DATE = ".//input[contains(@name, 'date')]";
//    private static final String CVV = ".//input[@name = 'cvv']";
//    private static final String FULL_NAME = ".//input[contains(@name, 'name')]";

    //sp35

    private static final String CREDIT_CARD_NUMBER = ".//input[contains(@name, 'cardNumber')]";
    private static final String EXPIRATION_DATE = ".//input[contains(@name, 'cardExpiry')]";
    private static final String CVV = ".//input[@name = 'cardCvc']";
    private static final String FULL_NAME = ".//input[contains(@name, 'billingName')]";

    public void setCreditCardDetails(String number) {
        findBy(CREDIT_CARD_NUMBER).type(number);
    }

    public void setExpirationDate(String expirationDate) {
        findBy(EXPIRATION_DATE).type(expirationDate);
    }

    public void setSecurityCode(String cvv) {
        findBy(CVV).type(cvv);
    }

    public void setFullNameInCard(String fullName) {
        findBy(FULL_NAME).type(fullName);
    }

    //private static final String PLACE_ORDER = ".//form//button[@type = 'submit' and span[contains(text(), 'Place order')]]" ;
    private static final String PLACE_ORDER = ".//div[@class='SubmitButton-IconContainer']";

    public void clickPlaceOrderButton() {
        waitAbit(500);
        scrollToElement(PLACE_ORDER);
        waitAbit(200);
        jsClick(PLACE_ORDER);
        waitAbit(10000);
        waitForSpinnerToDisappear();
    }

    //adding state details in new payment sanbox section

    private static final String CLICK_STATE = ".//span[text()='State']/../..//div[contains(@class,'multiselect__select')]";
   // private static final String SELECT_STATE_IN_DROPDOWN = ".//span[contains(text(),'%s')]";
    //sp35
    private static final String SELECT_STATE_IN_DROPDOWN = ".//select//option[@value='%s']";
    public void setNewStatedetails(String state) {
        waitAbit(2000);
       // findBy(CLICK_STATE).click();
        waitAbit(500);
        findBy(format(SELECT_STATE_IN_DROPDOWN,state)).click();
        waitAbit(1000);
        waitForSpinnerToDisappear();
    }

    //sp35
    private static final String AGREE_AND_SIGN = ".//button/span[text()='AGREE AND SIGN']";
    public void clickOnAgreeAndSignButton() {
        scrollToElement(AGREE_AND_SIGN);
        waitAbit(3000);
        try {
            withTimeoutOf(Duration.ofSeconds(20)).waitFor(ExpectedConditions.visibilityOf(findBy(AGREE_AND_SIGN)));
            waitAbit(16000);
            findBy(AGREE_AND_SIGN).click();
            waitAbit(3000);
        } catch (Exception e) { }
        waitForSpinnerToDisappear();
    }
//sp45
    public void clickOnAgreeAndSignButton1() {
        scrollToElement(AGREE_AND_SIGN);
        waitAbit(3000);
        try {
            withTimeoutOf(Duration.ofSeconds(20)).waitFor(ExpectedConditions.visibilityOf(findBy(AGREE_AND_SIGN)));
            waitAbit(16000);
            findBy(AGREE_AND_SIGN).click();

        } catch (Exception e) { }

        waitAbit(3000);
        try {
            scrollToElement(AGREE_AND_SIGN);
            withTimeoutOf(Duration.ofSeconds(20)).waitFor(ExpectedConditions.visibilityOf(findBy(AGREE_AND_SIGN)));
            waitAbit(16000);
            findBy(AGREE_AND_SIGN).click();
            waitAbit(3000);
        } catch (Exception e) { }
        waitForSpinnerToDisappear();
    }

    private static final String DOWNLOAD_INVOICE="//span[text()='Download Invoice *']";
    public void ClickOnDownloadInvoice(){
        waitAbit(200);
        findBy(DOWNLOAD_INVOICE).click();
        waitAbit(2000);

    }
}
