package com.hhstechgroup.steps.jbehave.scenarios.enrollmentapplication;


import com.hhstechgroup.steps.serenity.individualenrollment.PaymentSteps;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import static com.hhstechgroup.util.converters.DateConverter.SUBMIT_TIME;
import static com.hhstechgroup.util.properties.SystemProperties.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PaymentScenario {

    private static final String PAYMENT_SUBMISSION = "paymentSubmission";

    @Steps
    PaymentSteps paymentSteps;

    @When("click submit payment on Payment section")
    public void clickSubmitPayment() {
        paymentSteps.clickSubmitPayment();
    }

    @When("perform payment")
    public void performPaymet() {
        clickSubmitPayment();
//       checkPaymentSystemOpened();
        clickContinueToBilling();
        paymentSteps.setBillingInfoWithDefaultValues();
        setPaymentDetails(CARD_NUMBER.getProperty(), EXPIRATION_MONTH.getProperty(), EXPIRATION_YEAR.getProperty(), CVV.getProperty());
    }
//adding to sp21
    @When("click On Go to Payment button")
    public void clickOnGotoPayment() {
        clickSubmitPayment();
    }
    //adding to sp21
    @When("perform provider payment")
    public void performPayment() {
//        clickSubmitPayment();
//        checkPaymentSystemOpened();
        clickContinueToBilling();
        paymentSteps.setBillingInfoWithDefaultValues();
        setPaymentDetails(CARD_NUMBER.getProperty(), EXPIRATION_MONTH.getProperty(), EXPIRATION_YEAR.getProperty(), CVV.getProperty());
    }


    @When("submit payment with card number- $card, expiration month - $expMonth, expiration year - $expYear and cvv - $cvv")
    public void setPaymentDetails(String card, String expMonth, String expYear, String cvv) {
        paymentSteps.setPaymentDetails(card, expMonth, expYear, cvv);
        Serenity.setSessionVariable(SUBMIT_TIME).to(DateConverter.getSubmissionDate());
    }

    @When("click Continue to Billing Info")
    public void clickContinueToBilling() {
        paymentSteps.clickContinueToBilling();
    }

    @Then("2checkout payment system should be opened")
    public void checkPaymentSystemOpened() {
        assertEquals("Payment system should be opened!", PAYMENT_URL.getProperty(), getDriver().getCurrentUrl());
    }



    @Then("'$message' - message should be displayed on Payment section")
    public void checkConfirmationMessage(String message) {
        String formattedMessage = message.replaceAll("\\\\n", "\n");
        assertEquals(formattedMessage, paymentSteps.getPaymentConfirmationMessage());
    }

    @Then("success message should be displayed on Payment section")
    public void checkSuccessMessageDisplayed() {
        assertTrue(paymentSteps.paymentConfirmationMessageDisplayed());
    }

    @Then("download option should be displayed in payment section")
    public void isDownloadOptionPresent() {
        assertTrue("Download option is not present", paymentSteps.isDownloadPaymentPresent());
    }

    @Then("Next button should be displayed on Payment section")
    public void isNextButtonDisplayed() {
        assertTrue(paymentSteps.isNextButtonDisplayed());
    }

    //sp23

    @When("click submit invoice payment on Payment section")
    public void clickSubmitInvoicePayment() {
        paymentSteps.clickSubmitInvoicePayment();
    }


    //sp25 updating payment 3rd party tool

    @When("perform personal payment")
    public void performPersonalPayment() {
        paymentSteps.setPersonalBillingInfoWithDefaultValues();
        setPersonalPaymentDetails(CARD_NUMBER.getProperty(), EXPIRATION_DATE.getProperty(), FULL_NAME_IN_CARD.getProperty(), CVV.getProperty());
    }
    @When("click on '$option' in payment section")
    public void clickOnDownloadInvoice(){
        paymentSteps.ClickOnDownloadInvoice();

    }


    @When("submit payment with card number- $card, expiration date - $expDate, name in card - $fullName and cvv - $cvv")
    public void setPersonalPaymentDetails(String card, String expDate,String cvv, String fullName) {
        paymentSteps.setPersonalPaymentDetails(card, expDate, fullName, cvv);
        Serenity.setSessionVariable(SUBMIT_TIME).to(DateConverter.getSubmissionDate());
    }

    // Sp30 Instate Payment Verifcation scenario

    @When("go to new personal payment page")
    public void performPersonalPayment2() {
        clickSubmitPayment();

    }
    //sp35

    @When("click on sign button in the provider agreement section")
    public void clickOnAgreeAndSignButton(){paymentSteps.clickOnAgreeAndSignButton();}

    //sp35

    @When("click on sign1 button in the provider agreement section")
    public void clickOnAgreeAndSignButton1(){paymentSteps.clickOnAgreeAndSignButton1();}

}
