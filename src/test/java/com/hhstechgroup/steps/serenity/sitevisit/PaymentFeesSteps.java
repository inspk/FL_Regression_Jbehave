package com.hhstechgroup.steps.serenity.sitevisit;

import com.hhstechgroup.beans.application.PaymentConfigarationBean;
import com.hhstechgroup.ui.pages.peportal.PaymentsPage;
import com.hhstechgroup.ui.pages.sitevisit.UserPage;
import com.hhstechgroup.ui.panels.systemoptions.PaymentFeesPanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;

public class PaymentFeesSteps extends ScenarioSteps {


    @Page
    UserPage userPage;
    PaymentsPage paymentsPage;

    @Step
    public  void setPaymentFeesInfor(PaymentConfigarationBean newPaymentFeesInfo) {
        PaymentFeesPanel panel = userPage.getPaymentFeesfor();
        waitABit(2000);
        BeanUtils.copyPropertiesInOrder(panel, newPaymentFeesInfo);
    }

    //adding sp21 to Verify instate and Outstate Payment

    public boolean validatePayment(String payment) {
        return paymentsPage.validatePayment(payment);
    }

    //sp23
    @Step
    public void enableAndDisablePaymentCheckbox(String checkbox){
        paymentsPage.enableAndDisablePaymentCheckbox(checkbox);
    }
    @Step
    public void enableAndDisableInstatePaymentCheckbox(){
     paymentsPage.enableAndDisableInstatePaymentCheckbox();
    }

    @Step
    public void enableAndDisableOutstatePaymentCheckbox(){
        paymentsPage.enableAndDisableOutstatePaymentCheckbox();
    }

    @Step
    public boolean validateInvoicePayment(String invoicepayment) {
        return  paymentsPage.validateInvoicePayment(invoicepayment);}


        //sp28

    @Step
    public void setIndividualProviderDate(String individualProviderDate) {paymentsPage.setIndividualProviderDate(individualProviderDate);}

    @Step
    public void setGroupProviderDate(String groupProviderDate) {paymentsPage.setGroupProviderDate(groupProviderDate);}

    @Step
    public void setOrpProviderDate(String orpProviderDate) {paymentsPage.setOrpProviderDate(orpProviderDate);}

    @Step
    public void setPemProviderDate(String pemProviderDate) {paymentsPage.setPemProviderDate(pemProviderDate);}

    @Step
    public void setPharmacyProviderDate(String pharmacyProviderDate) {paymentsPage.setPharmacyProviderDate(pharmacyProviderDate);}

    @Step
    public void setFacilityProviderDate(String facilityProviderDate) {paymentsPage.setFacilityProviderDate(facilityProviderDate);}

    @Step
    public void setInstitutionalProviderDate(String institutionalProviderDate) {paymentsPage.setInstitutionalProviderDate(institutionalProviderDate);}

    //sp43
    @Step
    public void clickPaymentFeesEditButton(String editbutton) {
        paymentsPage.clickPaymentFeesEditButton(editbutton);
    }
    @Step
    public void setEffectiveStartDate(String effectiveStartDate) {
        paymentsPage.setEffectiveStartDate(effectiveStartDate);
    }
}
