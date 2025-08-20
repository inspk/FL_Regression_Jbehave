package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.peportalpages.ReconsiderationSteps;
import com.hhstechgroup.ui.pages.peportal.ReconsiderationPage;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReconsiderationScenario {

    @Steps
    ReconsiderationSteps reconsiderationSteps;

    @When("click Reconsideration button on enrollment section")
    @Alias("click Reconsideration button")
    public void clickReconsideration() {
        reconsiderationSteps.clickReconsideration();
    }

    @When("verify upload button is present in Reconsideration section")
    public void isUploadFieldPresent() {
        assertTrue(reconsiderationSteps.isUploadFieldPresent());
    }

    @When("{fill|edit} Reconsideration application with: $table")
    public void fillAppeal(ExamplesTable table) {
        Map<String, String> appealInfo = table.getRow(0);
        Optional.ofNullable(appealInfo.get("reason")).ifPresent(reason -> reconsiderationSteps.setAppealReason(reason));
        Optional.ofNullable(appealInfo.get("firstName")).ifPresent(firstName -> reconsiderationSteps.setAppealFirstName(firstName));
        Optional.ofNullable(appealInfo.get("lastName")).ifPresent(lastName -> reconsiderationSteps.setAppealLastName(lastName));
    }

    @When("upload new Reconsideration document $path")
    public void uploadAppealDoc1(String path) {
        reconsiderationSteps.uploadAppealDoc1(path);
    }

    @When("sign Reconsideration application")
    public void signReconsideration() {
        reconsiderationSteps.signReconsideration();
    }

    @When("submit Reconsideration application")
    public void submitReconsideration() {
        reconsiderationSteps.submitReconsideration();
    }

    @Then("success message with - $text should be displayed")
    public void isMessageDisplayed(String text) {
        assertEquals(text, reconsiderationSteps.getSuccessMessage());
    }

}
