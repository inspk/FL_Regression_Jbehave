package com.hhstechgroup.steps.serenity.individualenrollment;

import com.hhstechgroup.beans.PaymentBillingInformation;
import com.hhstechgroup.ui.pages.Payment2CheckoutPage;
import com.hhstechgroup.ui.pages.enrollment.EnrollmentPage;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


import java.util.Map;

import static com.hhstechgroup.util.properties.SystemProperties.*;

public class PaymentSteps extends ScenarioSteps {

    EnrollmentPage enrollmentPage;
    Payment2CheckoutPage payment2CheckoutPage;

    @Step
    public Map<String, String> getPaymentDetails() {
        return enrollmentPage.getPaymentPanel().getMappedValues();
    }

    @Step
    public void clickSubmitPayment() {
        enrollmentPage.getPaymentPanel().waitForSectionPulledUp();
        enrollmentPage.getPaymentPanel().clickSubmitPaymentButton();
//        waitForPaymentCondition(2000);
    }

    @Step
    public PaymentBillingInformation getBillingInfo() {
        PaymentBillingInformation information = new PaymentBillingInformation();
        BeanUtils.copyProperties(information, payment2CheckoutPage);
        return information;
    }

    @Step
    public void clickContinueToBilling() {
        payment2CheckoutPage.clickContinueToBillingInfo();
    }

    @Step
    public void setPaymentDetails(String card, String expMonth, String expYear, String cvv) {
        payment2CheckoutPage.clickContinueToPayment();
        payment2CheckoutPage.setCreditCardNumber(card);
        payment2CheckoutPage.setExpirationMonth(expMonth);
        payment2CheckoutPage.setExpirationYear(expYear);
        payment2CheckoutPage.setCvv(cvv);
        payment2CheckoutPage.clickSubmitPayment();
        waitForPaymentCondition(2000);
    }

    @Step
    public String getPaymentConfirmationMessage() {
        return enrollmentPage.getPaymentPanel().getPymentAcceptedMessage();
    }

    @Step
    public boolean paymentConfirmationMessageDisplayed() {
        return enrollmentPage.getPaymentPanel().isPaymentAccepted();
    }

    @Step
    public boolean isDownloadPaymentPresent() {
        return enrollmentPage.getPaymentPanel().isDownloadPaymentPresent();
    }

    @Step
    public boolean isNextButtonDisplayed() {
        return enrollmentPage.getPaymentPanel().isNextButtonPresent();
    }

    @Step
    public void setBillingInfo(PaymentBillingInformation info) {
        BeanUtils.copyPropertiesInOrder(payment2CheckoutPage, info);
    }

    @Step
    public void setBillingInfoWithDefaultValues() {
        payment2CheckoutPage.setCountry(BILLING_COUNTRY.getProperty());
        payment2CheckoutPage.setFullName(BILLING_FULLNAME.getProperty());
        payment2CheckoutPage.setFirstAddress(BILLING_FIRST_ADDRESS.getProperty());
        payment2CheckoutPage.setSecondAddress(BILLING_SECOND_ADDRESS.getProperty());
        payment2CheckoutPage.setCity(BILLING_CITY.getProperty());
        payment2CheckoutPage.setState(BILLING_STATE.getProperty());
        payment2CheckoutPage.setZip(BILLING_ZIP.getProperty());
        payment2CheckoutPage.setPhone(BILLING_PHONE.getProperty());
        payment2CheckoutPage.setEmail(BILLING_EMAIL.getProperty());
    }

    private void waitForPaymentCondition(long delayInMilliseconds) {
        try {
            Thread.sleep(delayInMilliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //sp23

    @Step
    public void clickSubmitInvoicePayment() {
        enrollmentPage.getPaymentPanel().waitForSectionPulledUp();
        enrollmentPage.getPaymentPanel().clickSubmitInvoicePaymentButton();
        waitForPaymentCondition(2000);
    }


    // before sp 35
    @Step
    public void setPersonalBillingInfoWithDefaultValues3() {
        payment2CheckoutPage.setNewCity(BILLING_CITY.getProperty());
        payment2CheckoutPage.setNewZip(BILLING_ZIP.getProperty());
        payment2CheckoutPage.setNewEmail(BILLING_EMAIL.getProperty());
        //adding state details in new payment sanbox section
        payment2CheckoutPage.setNewCountry(BILLING_COUNTRY.getProperty());
        payment2CheckoutPage.setNewStatedetails(BILLING_STATE.getProperty());
    }

    @Step
    public void setPersonalPaymentDetails(String card, String expDate,String cvv, String fullName) {
        payment2CheckoutPage.setCreditCardDetails(card);
        payment2CheckoutPage.setExpirationDate(expDate);
        payment2CheckoutPage.setSecurityCode(cvv);
        payment2CheckoutPage.setFullNameInCard(fullName);
        payment2CheckoutPage.clickPlaceOrderButton();
        waitForPaymentCondition(2000);
    }




//sp 35 updationg 3rd party payment tool

    @Step
    public void setPersonalBillingInfoWithDefaultValues() {
        //payment2CheckoutPage.setNewCity(BILLING_CITY.getProperty());
        payment2CheckoutPage.setNewEmail(BILLING_EMAIL.getProperty());
         payment2CheckoutPage.setNewStatedetails(BILLING_STATE.getProperty());
        payment2CheckoutPage.setNewZip(BILLING_ZIP.getProperty());

    }

    //sp35
    @Step
    public void clickOnAgreeAndSignButton() {payment2CheckoutPage.clickOnAgreeAndSignButton();}

    //45
    @Step
    public void clickOnAgreeAndSignButton1() {payment2CheckoutPage.clickOnAgreeAndSignButton1();}
    @Step
    public void ClickOnDownloadInvoice(){
        payment2CheckoutPage.ClickOnDownloadInvoice();
    }
}
