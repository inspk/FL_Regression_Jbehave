package com.hhstechgroup.steps.jbehave.scenarios;


import com.hhstechgroup.steps.serenity.peportalpages.EDISteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;



import static org.junit.Assert.assertTrue;

public class EDIScenario {

    @Steps
    EDISteps ediSteps;

    @Then("page has title '$title'")
    public void pageHasTitle (String title){
        assertTrue(ediSteps.pageHasTitle(title));
    }

    @When("click on Add Document button")
    public void clickButton (){
        ediSteps.clickAddDocument();
    }

    @When("upload file $path in Upload EDI Documents section")
    public void uploadFile(String path) {
        ediSteps.uploadFile(path);
        ediSteps.clickUploadFile();
    }
    @When("click on '$value' button")
    public void clickOnAddFileButton(String button){ediSteps.clickOnAddFileButton(button);}
}
