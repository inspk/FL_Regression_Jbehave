package com.hhstechgroup.steps.serenity.peportalpages;

import com.hhstechgroup.ui.pages.peportal.EligibilityPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;
import java.util.Map;

public class EligibilityUISteps extends ScenarioSteps {

    EligibilityPage eligibilityPage;

    @Step
    public boolean isSearchBlockPresent() {
        return eligibilityPage.isSearchPanelPresent();
    }

    @Step
    public void clickOnRowByMemberId(String memberId) {
        eligibilityPage.getRecords().clickOnRecordWithValue(memberId);
    }

    @Step
    public Map<String, String> getEligibilityConfirmation() {
        return eligibilityPage.getEligibilityConfirmation().getMappedValues();
    }

    @Step
    public boolean isSectionOpened(String section) {
        return eligibilityPage.isSectionOpened(section);
    }

    @Step
    public boolean isServiceDateCorrect(String dateFrom, String dateTo){
        return eligibilityPage.isServiceDateCorrect(dateFrom, dateTo);
    }

    @Step
    public void clickViewAddress() {
       eligibilityPage.clickViewAddress();
    }

    @Step
    public void clickBackToSearch(){
        eligibilityPage.clickBackToSearchResults();
    }

    @Step
    public void navigateToSection(String sectionName){
        eligibilityPage.navigateToSection(sectionName);
    }

    @Step
    public List<Map<String, String>> getEligibilityInfo() {
        return eligibilityPage.getEligibilityInfo();
    }

    @Step
    public void clickRowWithEligibilityType(String type){
        eligibilityPage.clickRowWithEligibilityType(type);
    }

    @Step
    public void clickRowWithCarrierName(String name){
        eligibilityPage.clickRowWithCarrierName(name);
    }

    @Step
    public Map<String, String> getAccordionInfo() {
        return eligibilityPage.getAccordionInfo();
    }

    @Step
    public void setMemberId(String id) {
        eligibilityPage.getSearchPanel().setMemberId(id);
    }

    @Step
    public void clickSearch() {
        eligibilityPage.getSearchPanel().clickSearch();
    }
}
