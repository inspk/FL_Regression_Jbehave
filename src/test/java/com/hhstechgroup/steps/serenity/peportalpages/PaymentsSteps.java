package com.hhstechgroup.steps.serenity.peportalpages;

import com.hhstechgroup.ui.pages.peportal.PaymentsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;
import java.util.Map;

public class PaymentsSteps extends ScenarioSteps {

    PaymentsPage paymentsPage;

    @Step
    public boolean isSearchBlockPresent() {
        return paymentsPage.isSearchPanelPresent();
    }

    @Step
    public void clickOnRecordWithValue(String paymentId) {
        paymentsPage.getRecords().clickOnRecordWithValue(paymentId);
    }

    @Step
    public Map<String, String> getPaymentIdInformation() {
        return paymentsPage.getPaymentIdBlock().getMappedValues();
    }

    @Step
    public String getPaymentIdTitle() {
        return paymentsPage.getPaymentIdBlock().getTitle();
    }

    @Step
    public List<Map<String, String>> getClaimsInfo() {
        return paymentsPage.getClaimsBlock().getClaimsTable();
    }

    @Step
    public Map<String, String> getFinancialInformation() {
        return paymentsPage.getFinancialInformationBlock().getFinancialInformation();
    }

    @Step
    public Map<String, String> getOriginatingInstitutionInformation() {
        return paymentsPage.getOriginatingInstitutionBlock().getOriginatingInstitutionInformation();
    }

    @Step
    public void setPaymentID(String id) {
        paymentsPage.getSearchPanel().setPaymentId(id);
    }

    @Step
    public void clickSearch() {
        paymentsPage.getSearchPanel().clickSearch();
    }

    @Step
    public void clickBackToSearchResults() {
        paymentsPage.clickBackToSearchResults();
    }

    @Step
    public void clickOnClaimWithTcn(String tcn) {
        paymentsPage.getClaimsBlock().clickOnClaimWithTcn(tcn);
    }

    @Step
    public void clickOnClaimWithProviderId(String id) {
        paymentsPage.getClaimsBlock().clickOnProviderWithId(id);
    }
}
