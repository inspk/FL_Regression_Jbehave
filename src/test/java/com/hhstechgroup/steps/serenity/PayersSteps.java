package com.hhstechgroup.steps.serenity;

import com.hhstechgroup.ui.pages.iuportal.EnrollmentCocPage;
import com.hhstechgroup.ui.pages.iuportal.ViewRequestPage;
import com.hhstechgroup.ui.pages.peportal.PayersPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;
import java.util.Map;

public class PayersSteps extends ScenarioSteps {

    PayersPage payersPage;
    EnrollmentCocPage enrollmentCocPage;
    ViewRequestPage viewRequestPage;



    @Step
    public void clickAddPayer() {
        payersPage.clickAddPayer();
    }

    @Step
    public void selectPayer(String payer) {
        payersPage.getAddPayerPopUp().selectPayer(payer);
    }

    @Step
    public void addPayer() {
        payersPage.getAddPayerPopUp().clickAdd();
    }

    @Step
    public void clickExpandPayer(String payer) {
        payersPage.openPayer(payer);
    }

    @Step
    public List<Map<String, String>> getRequestDetails() {
        return enrollmentCocPage.getRequestsPanel().getListOfMappedValues();
    }

    @Step
    public List<Map<String, String>> getCocAffiliationDetails() {
        return enrollmentCocPage.getRequestsPanel().getListOfMappedValuesInCoCDetails();
    }

    @Step
    public void selectRequestAction(String id, String action) {
        enrollmentCocPage.getRequestsPanel().getRequestById(id).selectAction(action);
    }


    @Step
    public void moveToSection(String section) {
        viewRequestPage.clickOnSection(section);
    }

    @Step
    public boolean isDocumentPresent(String field, String documentName) {
        return viewRequestPage.getFilesDocumentsPanel().isDocumentPresent(field, documentName);
    }


    @Step
    public void clickOnActionLink(String id, String linkText) {
        enrollmentCocPage.getRequestsPanel().getRequestById(id).clickOnActionLink(linkText);
    }


    @Step
    public void closeActionsPopUp(String id) {
        enrollmentCocPage.getRequestsPanel().getRequestById(id).closeActionsPopUp();
    }

    @Step
    public Map<String, String> getRequestInformation() {
        return viewRequestPage.getEnrollmentCardPanel().getMappedValues();
    }

    @Step
    public void clickDownloadDocument(String field, String documentName) {
        viewRequestPage.getFilesDocumentsPanel().clickDownloadButton(field, documentName);
    }

    @Step
    public String getDownloadDocumentUrl(String field, String documentName) {
        return viewRequestPage.getFilesDocumentsPanel().getDownloadUrl(field, documentName);
    }

    @Step
    public String getDownloadPageUrl() {
        return viewRequestPage.getFilesDocumentsPanel().getDownloadPageUrl();
    }

    @Step
    public boolean isPrintDocumentButtonPresent(String field, String documentName) {
        return viewRequestPage.getFilesDocumentsPanel().isPrintButtonPresent(field, documentName);
    }

    @Step
    public void clickSign() {
        payersPage.clickSign();
    }
    @Step
    public void clickNavigateToPayers() {
        payersPage.clickNavigateToPayers();
    }

}
