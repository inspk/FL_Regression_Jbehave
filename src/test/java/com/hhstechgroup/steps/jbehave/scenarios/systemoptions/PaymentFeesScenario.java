package com.hhstechgroup.steps.jbehave.scenarios.systemoptions;

import com.hhstechgroup.beans.application.PaymentConfigarationBean;
import com.hhstechgroup.beans.application.SecurityPolicyBean;
import com.hhstechgroup.steps.serenity.sitevisit.PaymentFeesSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import static org.junit.Assert.assertTrue;

public class PaymentFeesScenario {
    @Steps
    PaymentFeesSteps paymentFeesSteps;

    @When("user fill the payment fees info: $table")
    public void setPaymentFeesInfor(ExamplesTable paymentFees) {
        paymentFeesSteps.setPaymentFeesInfor(ExamplesTableUtil.parseTableToClass(paymentFees, PaymentConfigarationBean.class).get(0));

    }
    //adding sp21 to Verify instate and Outstate Payment


    @When("verify {instate|outstate} payment '$payment' displaying")
    public void validatePayment(String payment) {
        System.out.println(payment);
        assertTrue(paymentFeesSteps.validatePayment(payment));
    }

    @When("{Enable|Disable} '$checkbox' online Payment")
    public void enableAndDisablePaymentCheckbox(String checkbox){
        paymentFeesSteps.enableAndDisablePaymentCheckbox(checkbox);}

        @When("{Enable|Disable} Instate online Payment")
        public void enableAndDisableInstatePaymentCheckbox(){
        paymentFeesSteps.enableAndDisableInstatePaymentCheckbox();
        }

       @When("{Enable|Disable} Outstate online Payment")
      public void enableAndDisableOutstatePaymentCheckbox(){
           paymentFeesSteps.enableAndDisableOutstatePaymentCheckbox();
       }

       @When("Verifying '$invoicepayment' is Displaying")
       public void validateInvoicePayment(String invoicepayment) {
           System.out.println("Enrollment :" + invoicepayment + " is Displaying");
           assertTrue(paymentFeesSteps.validateInvoicePayment(invoicepayment));
       }

       //sp28

    @When("set individual provider effective date '$individualProviderDate' in payment fees page")
    public void setIndividualProviderDate(String individualProviderDate) {paymentFeesSteps.setIndividualProviderDate(individualProviderDate);}

    @When("set group provider effective date '$groupProviderDate' in payment fees page")
    public void setGroupProviderDate(String groupProviderDate) {paymentFeesSteps.setGroupProviderDate(groupProviderDate);}

    @When("set orp provider effective date '$orpProviderDate' in payment fees page")
    public void setOrpProviderDate(String orpProviderDate) {paymentFeesSteps.setOrpProviderDate(orpProviderDate);}

    @When("set pem provider effective date '$pemProviderDate' in payment fees page")
    public void setPemProviderDate(String pemProviderDate) {paymentFeesSteps.setPemProviderDate(pemProviderDate);}

    @When("set pharmacy provider effective date '$pharmacyProviderDate' in payment fees page")
    public void setPharmacyProviderDate(String pharmacyProviderDate) {paymentFeesSteps.setPharmacyProviderDate(pharmacyProviderDate);}

    @When("set facility provider effective date '$facilityProviderDate' in payment fees page")
    public void setFacilityProviderDate(String facilityProviderDate) {paymentFeesSteps.setFacilityProviderDate(facilityProviderDate);}

    @When("set institutional provider effective date '$institutionalProviderDate' in payment fees page")
    public void setInstitutionalProviderDate(String institutionalProviderDate) {paymentFeesSteps.setInstitutionalProviderDate(institutionalProviderDate);}

   //sp43
    @Then("click on the payment and fees '$editbutton' edit button")
    public void clickPaymentFeesEditButton(String editbutton){
        paymentFeesSteps.clickPaymentFeesEditButton(editbutton);
    }
    @When("set the effective start date '$effectivestartDate' in payment fees page")
    public void setEffectiveStartDate(String effectiveStartDate) {
        paymentFeesSteps.setEffectiveStartDate(effectiveStartDate);
    }
}
