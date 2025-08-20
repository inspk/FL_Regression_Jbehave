package com.hhstechgroup.steps.serenity.peportalpages;

import com.hhstechgroup.ui.pages.peportal.AppealPage;
import com.hhstechgroup.ui.pages.peportal.DashboardPage;
import com.hhstechgroup.util.common.FileUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;
import java.util.Map;

public class AppealSteps extends ScenarioSteps {

    AppealPage appealPage;
    DashboardPage dashboardPage;

    @Step
    public void clickAppeal() {
        appealPage.clickAppeal();
    }

    @Step
    public void clickAppealFromAppeals() {
        appealPage.clickAppealFromAppeals();
    }

    @Step
    public void clickAppealWithId(String requestId){
        appealPage.clickAppealWithId(requestId);
    }

    @Step
    public void clickAppealClaim() {
        appealPage.clickAppealClaim();
    }

    @Step
    public void isAppealButtonPresent() {
        appealPage.isAppealButtonPresent();
    }

    @Step
    public void waitForAppealPanel() {
        appealPage.waitForAppealPanel();
    }

    @Step
    public void setAppealReason(String reason) {
        appealPage.getAppealPanel().setReason(reason);
    }

    @Step
    public void setAppealFirstName(String firstName) {
        appealPage.getAppealPanel().setFirstName(firstName);
    }

    @Step
    public void setAppealLastName(String lastName) {
        appealPage.getAppealPanel().setLastName(lastName);
    }

    @Step
    public void uploadAppealDoc(String filePath) {
        appealPage.getAppealPanel().uploadAppealDoc(FileUtils.getAbsolutePath(filePath));
    }

    @Step
    public boolean isAppealDocUploaded(String document) {
        return appealPage.getAppealPanel().isAppealDocUploaded(document);
    }

    @Step
    public void signAppeal() {
        appealPage.getAppealPanel1().signAppeal();
    }

    @Step
    public void submitAppeal() {
        appealPage.submitAppeal();
    }

    @Step
    public boolean isUploadButtonPresent() {
        return appealPage.getAppealPanel().isUploadButtonPresent();
    }

    @Step
    public String getSuccessMessage() {
        return appealPage.getSuccessPanel().getTitle();
    }

    @Step
    public void goToAppeals() {
        appealPage.getSuccessPanel().clickGoToAppeals();
    }

    @Step
    public Map<String, String> getAppealInfo() {
        return dashboardPage.getBodyPanel().getAppealBlock().getMappedValues();
    }

    @Step
    public void continueAppealRequest(){
        dashboardPage.getBodyPanel().getAppealBlock().clickOnButton();
    }

    @Step
    public void editAppealField(String fieldName) {
        appealPage.getAppealPanel().waitForSectionPulledUp();
        appealPage.getAppealPanel().editField(fieldName);
    }

    @Step
    public Map<String, String> getFieldsValues(List<String> fields) {
        return appealPage.getAppealPanel().getFieldsValuesReadMode(fields);
    }

    @Step
    public boolean isAppealFormPresent() {
        return appealPage.isAppealFormPresent();
    }

    @Step
    public void createAppealForId(String id) {
        appealPage.createAppealForId(id);
    }

    @Step
    public void appealDetailsById(String memberId){
        appealPage.clickOnAppealWithId(memberId);
    }

    @Step
    public Map<String, String> getAppealMainInfo() {
        return appealPage.getAppealMainInfo();
    }

    @Step
    public Map<String, String>  getAppealAppTabInfoIU() {
        return appealPage.getAppTabInfoIU();
    }

    @Step
    public void appTabInAppealDetails(String appTab){
        appealPage.clickTabInAppealDetails(appTab);
    }

    @Step
    public Map<String, String>  getAppealHearingInfo(String blockNumber) {
        return appealPage.getHearingBlock(blockNumber);
    }

    @Step
    public Map<String, String> getAppFieldsValues(List<String> fields) {
        return appealPage.getAppealPanel().getFieldsValues(fields);
    }

    @Step
    public boolean isDocumentPresent(String field, String documentName) {
        return appealPage.getAppealFilesDocumentsPanel().isAppealDocumentPresent(field, documentName);
    }

    //wyomi WY-63 updating appeal
    @Step
    public void setAppealReason1(String reason) {
        appealPage.getAppealPanel1().setReason(reason);
    }

    @Step
    public void setAppealFirstName1(String firstName) {
        appealPage.getAppealPanel1().setFirstName(firstName);
    }

    @Step
    public void setAppealLastName1(String lastName) {

        appealPage.getAppealPanel1().setLastName(lastName);
    }

    @Step
    public void uploadAppealDoc1(String filePath) {
        appealPage.getAppealPanel1().uploadAppealDoc(FileUtils.getAbsolutePath(filePath));
    }

    @Step
    public void signAppeal1() {
        appealPage.getAppealPanel1().signAppeal();
    }
}
