package com.hhstechgroup.steps.serenity.provider;

import com.hhstechgroup.beans.application.ProviderInquiryBean;
import com.hhstechgroup.ui.pages.iuportal.ProvidersInquiryPage;
import com.hhstechgroup.ui.panels.iuportal.ProviderInquiryPanel;
import com.hhstechgroup.util.common.BeanUtils;
import com.hhstechgroup.util.common.FileUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;
import java.util.Map;

public class ProvidersInquirySteps extends ScenarioSteps {

    ProvidersInquiryPage providersInquiryPage;

    @Step
    public boolean isSearchPanelPresent() {
        return providersInquiryPage.isSearchPanelPresent();
    }

    @Step
    public void clickOnRecordWithNpi(String npi) {
        providersInquiryPage.getRecords().clickOnRecordWithValue(npi);
    }

    @Step
    public Map<String, String> getProviderDetails() {
        return providersInquiryPage.getProviderDetails();
    }

    @Step
    public List<Map<String, String>> getRequests(String type) {
        return providersInquiryPage.getRequests(type);
    }

    //sp23
    @Step
    public void setProviderInquirySearchCriteriaAndClickSearch(ProviderInquiryBean criteria) {
        ProviderInquiryPanel panel = providersInquiryPage.getProviderInquiryinfoSearchPanel();
        waitABit(1000);
        BeanUtils.copyPropertiesInOrder(panel, criteria);
        providersInquiryPage.getProviderInquiryinfoSearchPanel().clickSearch();
    }

    //sp47.2.1
    @Step
    public void clickonMassUpdateButton() {
        providersInquiryPage.clickonMassUpdateButton();
    }

    @Step
    public void clickonnpicheckbox() {
        providersInquiryPage.clickonnpicheckbox();
    }

    @Step
    public void clickonBulkSuspensionButton() {
        providersInquiryPage.clickonBulkSuspensionButton();
    }

    @Step
    public void clickonTerminationButton() {
        providersInquiryPage.clickonBulkSTerminationButton();
    }

    @Step
    public void fillBulkTerminateDate(String bulkterminateDate) {
        providersInquiryPage.fillBulkTerminateDate(bulkterminateDate);
    }

    @Step
    public void setReasonForProviderBulkTermination(String reason, String note) {
        providersInquiryPage.setReasonForProviderBulkTermination(reason, note);
    }
    @Step
    public void clickOnUpdateButton(String button) {
        providersInquiryPage.clickOnUpdateButton(button);
    }

    @Step
    public void uploadExcel(String filePath) {
        providersInquiryPage.getProviderInquiryinfoSearchPanel().uploadExcel(FileUtils.getAbsolutePath(filePath));
    }
}


