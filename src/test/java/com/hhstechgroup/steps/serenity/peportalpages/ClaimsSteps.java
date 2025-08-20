package com.hhstechgroup.steps.serenity.peportalpages;

import com.hhstechgroup.ui.pages.iuportal.ClaimsPageIu;
import com.hhstechgroup.ui.pages.peportal.ClaimsPagePe;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;
import java.util.Map;

public class ClaimsSteps extends ScenarioSteps {

    ClaimsPagePe claimsPagePe;
    ClaimsPageIu claimsPageIu;

    @Step
    public Map<String, String> getClaimDetails() {
        return claimsPagePe.getClaimDetails();
    }

    @Step
    public boolean isSearchPanelPresent() {
        return claimsPagePe.isSearchPanelPresent();
    }

    @Step
    public void clickOnRecordWithValue(String tcn) {
        claimsPagePe.getRecords().clickOnRecordWithValue(tcn);
    }

    @Step
    public void openSection(String section) {
        claimsPagePe.clickOnLeftMenuSection(section);
    }

    @Step
    public List<Map<String, String>> getAdjustmentReasonCodes() {
        return claimsPagePe.getAdjustmentReasonCodes();
    }

    @Step
    public List<Map<String, String>> getRemarkCodes() {
        return claimsPagePe.getRemarkCodes();
    }

    @Step
    public Map<String, String> getMemberData() {
        return claimsPagePe.getMemberData();
    }

    @Step
    public Map<String, String> getProviderData() {
        return claimsPagePe.getProviderData();
    }

    @Step
    public Map<String, String> getPaymentData() {
        return claimsPagePe.getPaymentData();
    }

    @Step
    public Map<String, String> getPayerData() {
        return claimsPagePe.getPayerData();
    }

    @Step
    public Map<String, String> getReceiverData() {
        return claimsPagePe.getReceiverData();
    }

    @Step
    public List<Map<String, String>> getLineItems() {
        return claimsPagePe.getLineItems();
    }

    @Step
    public List<Map<String, String>> getClaim() {
        return claimsPagePe.getClaim();
    }

    @Step
    public void setTcn(String tcn) {
        claimsPagePe.getSearchPanel().setTcn(tcn);
    }

    @Step
    public void setMemberName(String memberName) {
        claimsPagePe.getSearchPanel().setMemberName(memberName);
    }

    @Step
    public void setServicePeriod(String dateFrom, String dateTo) {
        claimsPagePe.getSearchPanel().setDateFrom(dateFrom);
        claimsPagePe.getSearchPanel().setDateTo(dateTo);
    }

    @Step
    public void setStatus(String status) {
        claimsPagePe.getSearchPanel().selectStatus(status);

    }

    @Step
    public void setMemberId(String memberId) {
        claimsPagePe.getSearchPanel().setMemberId(memberId);
    }

    @Step
    public void clickSearch() {
        claimsPagePe.getSearchPanel().clickSearch();
    }

    @Step
    public List<Map<String, String>> getAdjustmentReasonCodesIu() {
        return claimsPageIu.getAdjustmentReasonCodes();
    }

    @Step
    public List<Map<String, String>> getRemarkCodesIu() {
        return claimsPageIu.getRemarkCodes();
    }

    @Step
    public List<Map<String, String>> getLineItemsIu() {
        return claimsPageIu.getLineItems();
    }

    @Step
    public void clickBackToSearch() {
        claimsPageIu.clickBackToSearchResults();
    }

    @Step
    public void clickCreateClaim() {
        claimsPagePe.clickCreateProfessionalClaimButton();
    }

    @Step
    public void clickContinue() {
        claimsPagePe.clickContinueButton();
    }

    @Step
    public void clickGoToClaims() {
        claimsPagePe.getSuccessPanel().clickGoToClaims();
    }

    @Step
    public void clickSubmit() {
        claimsPagePe.getBasicLineItemInformationPanel().clickSubmit();
    }

}
