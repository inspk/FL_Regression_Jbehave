package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.providerData.ProviderDataSteps;
import com.hhstechgroup.steps.serenity.revalidation.RevalidationSteps;

import com.hhstechgroup.util.properties.ProviderProperties;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class RevalidationScenario {

    @Steps
    ProviderDataSteps providerDataSteps;

    @Steps
    RevalidationSteps revalidationSteps;


    @Then("revalidation sections in system options should be displayed: $table")
    public void verifyRevalidationBlock( ExamplesTable table) {
        table.getRows().forEach(row -> assertReflectionEquals(row.get("revalidationSettings"),
                revalidationSteps.getRevalidationSectionsAndSettings(row.get("section"), row.get("notification"))));
    }

    @When("set next revalidation settings in System Options: $table")
    public void setRevalidationSettings( ExamplesTable table) {
        table.getRows().forEach(row -> revalidationSteps.setRevalidationSectionsAndSettings(row.get("section"), row.get("notification"), row.get("revalidationSettings")));
    }

    @When("set next reminders for reviewers settings in System Options: $table")
    public void setRemindersForReviewersSettings( ExamplesTable table) {
        table.getRows().forEach(row -> revalidationSteps.setRemindersForReviewersSettings(row.get("notification"), row.get("days")));
    }
    @When("verify next reminders for reviewers settings in System Options: $table")
    public  void verifyRequestAddtionalInfo(ExamplesTable table){

        for (Map<String,String> row : table.getRows()) {
            String expected_days = row.get("days");
            String actual_days = revalidationSteps.getRemainderNotification(row.get("notification"));
            System.out.println("|Expected: "+expected_days+" Actual: "+actual_days +"|");
            assertEquals(expected_days, actual_days);
        }
    }

    @When("send revalidation request with '$cookies' and time to revalidation for first notification '$days'")
    public void activateRevalidation1(String cookies,String days){
        revalidationSteps.revalidationRequestForFirstNotification(cookies,days);
    }
    @When("send revalidation request with '$cookies' and time to revalidation for second notification '$days'")
    public void activateRevalidation2(String cookies,String days){
        revalidationSteps.revalidationRequestForSecondNotification(cookies,days);
    }
    @When("send revalidation request with '$cookies' and time to revalidation for third notification '$days'")
    public void activateRevalidation3(String cookies,String days){
        String providerDataId=revalidationSteps.getProviderDataID();
        ProviderProperties.save("providerDataId", providerDataId);
        revalidationSteps.revalidationRequestForThirdNotification(cookies,days);
    }

    @Then("verify the revalidation '$months' text is displaying in the dashboard")
    public void verifyTheRevalidationText(String months){
        assertTrue(revalidationSteps.verifyTheRevalidationText(months));
    }

    @Then("verify and get the Next Revalidation Date")
    public void verifyAndGetNextRevalidationDate(){
        revalidationSteps.verifyAndGetNextRevalidationDate();
    }

}
