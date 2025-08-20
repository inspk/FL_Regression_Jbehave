package com.hhstechgroup.steps.serenity.peportalpages;

import com.hhstechgroup.ui.pages.peportal.AuthorizationPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;
import java.util.Map;

public class AuthorizationSteps extends ScenarioSteps {

    AuthorizationPage authorizationPage;

    @Step
    public Map<String, String> getAuthorizationRequestInfo() {
        return authorizationPage.getAuthorizationRequestInfo();
    }

    @Step
    public boolean isSearchPanelPresent() {
        return authorizationPage.isSearchPanelPresent();
    }

    @Step
    public void clickOnRecordByMemberId(String memberId) {
        authorizationPage.getRecords().clickOnRecordWithValue(memberId);
    }

    @Step
    public void setMemberId(String id) {
        authorizationPage.getSearchPanel().setMemberId(id);
    }

    @Step
    public void setCPTCode(String cptCode){
        authorizationPage.getSearchPanel().setCPTCode(cptCode);
    }

    @Step
    public void selectStatus(String status){
        authorizationPage.getSearchPanel().selectStatus(status);
    }

    @Step
    public void resetFilters(){
        authorizationPage.getSearchPanel().resetFilters();
    }

    @Step
    public void clickSearch() {
        authorizationPage.getSearchPanel().clickSearch();
    }

    @Step
    public void expandSearchBox(){
        authorizationPage.expandSearchBox();
    }

    @Step
    public List<Map<String, String>> getAuthRequest() {
        return authorizationPage.getAuthRequest();
    }

    @Step
    public void navigateToRequestDetails(){
        authorizationPage.navigateToAuthRequestDetails();
    }

    @Step
    public boolean isTitleDisplayed(String title){
       return authorizationPage.isCorrectTitleDisplayed(title);
    }

    @Step
    public Map<String, String> getAuthInformation() {
        return authorizationPage.getAuthInformation().getMappedValues();
    }

    @Step
    public List<Map<String, String>> getProceduresAndServices() {
        return authorizationPage.getProceduresAndServices();
    }

    @Step
    public List<Map<String, String>> getProcedures() {
        return authorizationPage.getProcedures();
    }

    @Step
    public void expandService(String cptCode){
        authorizationPage.expandServicesDetails(cptCode);
    }

    @Step
    public Map<String, String> getServiceDetails() {
        return authorizationPage.getMappedValues();
    }
    @Step
    public void authorizedSignatoryName(String authorizedSignatoryName){
        authorizationPage.authorizedSignatoryName(authorizedSignatoryName);
    }
    @Step
    public void VerifyNameAndSelectauthorizedSignatoryName(String value,String authorizedSignatoryName){
        authorizationPage.VerifyNameAndSelectauthorizedSignatoryName(value,authorizedSignatoryName);
    }

}
