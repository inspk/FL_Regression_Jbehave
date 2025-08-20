package com.hhstechgroup.steps.jbehave.scenarios.enrollmentapplication;

import com.hhstechgroup.steps.serenity.individualenrollment.UploadDocumentsSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UploadDocumentsScenario {

    @Steps
    UploadDocumentsSteps uploadDocumentsSteps;

    @When("upload '$type' document $path")
    public void uploadDocument(String document, String path) {
        uploadDocumentsSteps.upload(document, path);
    }

    @When("upload the '$element' document $path")
    public void uploadFile(String element,String path){
     uploadDocumentsSteps.uploadFile(element,path);
    }

    @When("click on upload button")
    public void clickuploadbutton() {
        uploadDocumentsSteps.clickUploadButton();
    }

    @When("upload the Enrollment document $path")
    public void uploadDoc(String path) {
        uploadDocumentsSteps.uploadDoc(path);
    }

    @When("delete '$type' document '$name'")
    public void deleteDocument(String field, String documentName) {
        uploadDocumentsSteps.delete(field, documentName);
    }

    @Then("document $document should be uploaded to '$type'")
    public void checkDocumentUploaded(String document, String type) {
        assertTrue(uploadDocumentsSteps.isDocumentUploaded(document, type));
    }

    @Then("document '$document' should not be displayed in '$type'")
    public void checkDocumentNotPresent(String document, String type) {
        uploadDocumentsSteps.waitForDocumentDeleted(document, type);
        assertFalse(uploadDocumentsSteps.isDocumentUploaded(document, type));
    }

    @Then("coc document $document should be uploaded to '$type'")
    public void checkCocDcumentUploaded(String document, String type) {
        assertTrue(uploadDocumentsSteps.isCocDocumentUploaded(document, type));
    }

    @Then("validation error '$error' should be displayed for field '$field'")
    public void checkUploadError(String error, String field) {
        assertEquals("Error not present or incorrect", error, uploadDocumentsSteps.getErrorDisplayed(field));
    }

    //wy-63 adding new code for wyomi

    @When("upload new '$type' document $path")
    public void uploadDocument3(String document, String path) {
        uploadDocumentsSteps.upload3(document, path);
    }
    @When("upload file '$eftDoc' document $path")
    public void uploadEFTDoc(String eftDoc, String path){
        uploadDocumentsSteps.uploadEFTDoc(eftDoc, path);
    }
    @Then("verify '$fileName' button and select upload file section")
    public void verifyAndUploadDoc(String fileName){
        uploadDocumentsSteps.verifyAndUploadDoc(fileName);
    }

    @When("upload file $path in request termination popup")
    public void uploadDocForRequestTermination(String path) {
        uploadDocumentsSteps.uploadDocForRequestTermination(path);
    }

}
