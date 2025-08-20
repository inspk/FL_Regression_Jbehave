package com.hhstechgroup.steps.serenity.individualenrollment;

import com.hhstechgroup.ui.pages.enrollment.EnrollmentPage;
import com.hhstechgroup.util.common.FileUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UploadDocumentsSteps extends ScenarioSteps {

    EnrollmentPage enrollmentPage;

    @Step
    public void upload(String type, String filePath) {
        //enrollmentPage.getUploadDocumentsPanel().waitForSectionPulledUp();
        enrollmentPage.getUpLoadDocInfo().uploadDocument(type, FileUtils.getAbsolutePath(filePath));
    }
    @Step
    public void uploadFile(String element,String path){
        enrollmentPage.getUpLoadDocInFilesAndDocuments().uploadFile(element,FileUtils.getAbsolutePath(path));
    }
    @Step
    public void clickUploadButton() {
        enrollmentPage.clickUploadButton();}

    @Step
    public void uploadDoc(String filePath) {
       enrollmentPage.getUpLoadDocInfo().uploadDoc(FileUtils.getAbsolutePath(filePath));
    }

    @Step
    public void delete(String type, String fileName) {
        enrollmentPage.getUploadDocumentsPanel().waitForSectionPulledUp();
        enrollmentPage.getUploadDocumentsPanel().deleteDocument(type, fileName);
    }

    @Step
    public boolean isDocumentUploaded(String documentName, String type) {
        return enrollmentPage.getUploadDocumentsPanel().isDocumentUploaded(documentName, type);
    }
    @Step
    public boolean isCocDocumentUploaded(String documentName, String type) {
        return enrollmentPage.getCocUploadDocumentsPanel().isDocumentUploaded(documentName, type);
    }

    @Step
    public void waitForDocumentDeleted(String documentName, String type) {
        enrollmentPage.getUploadDocumentsPanel().isDocumentUploaded(documentName, type);
    }

    @Step
    public String getErrorDisplayed(String field) {
        return enrollmentPage.getUploadDocumentsPanel().getErrorDisplayed(field);
    }

    //wy-63 adding new code for wyomi
    @Step
    public void upload3(String type, String filePath) {
        //enrollmentPage.getUploadDocumentsPanel().waitForSectionPulledUp();
        enrollmentPage.getUpLoadDocInfo().uploadDocument3(type, FileUtils.getAbsolutePath(filePath));
    }
    @Step
    public void uploadEFTDoc(String eftDoc, String path){
        enrollmentPage.getEFTInfo().uploadEFTDoc(eftDoc, FileUtils.getAbsolutePath(path));
    }
    @Step
    public void  verifyAndUploadDoc(String fileName){
        enrollmentPage.getUpLoadDocInFilesAndDocuments().verifyAndUploadDoc(fileName);
    }
    @Step
    public void uploadDocForRequestTermination(String filePath) {
        enrollmentPage.getRequestTerminationPopup().uploadDocForRequestTermination(FileUtils.getAbsolutePath(filePath));
    }

}
