package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.HelpTourSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HelpTourScenario {

    @Steps
    HelpTourSteps helpTourSteps;

    @When("skip help tour")
    public void skipHelpTour() {
        helpTourSteps.skipHelpTour();
    }

    @When("skip help tour if exists")
    public void skipHelpTourIfExists() {
        helpTourSteps.skipTooltipIfExists();
    }

    @When("wait for help tour and skip")
    public void skipHelpTourWithWait() {
        helpTourSteps.waitForHelpTour();
        helpTourSteps.skipHelpTour();
    }

    @Then("help tour tooltip is displayed with title '$title' and description '$description'")
    public void verifyHelpTourTooltip(String title, String description){
        assertTrue(helpTourSteps.isHelpTourTooltipDisplayedCorrectly(title, description));
    }

    @When("close help tour")
    public void closeHelpTour(){
        helpTourSteps.closeHelpTour();
    }

    @When("navigate to next step of help tour")
    @Alias("finish help tour")
    public void navigateToNextStep(){
        helpTourSteps.clickNext();
    }

    @When("navigate to previous step of help tour")
    public void navigateToPreviousStep(){
        helpTourSteps.clickBackButton();
    }

    @Then("help tour is closed")
    public void isHelpTourClosed(){
        assertFalse("Help tour is not closed", helpTourSteps.isHelpTourOpened());
    }
}
