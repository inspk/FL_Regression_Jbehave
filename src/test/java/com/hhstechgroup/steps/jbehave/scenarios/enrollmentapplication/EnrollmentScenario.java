package com.hhstechgroup.steps.jbehave.scenarios.enrollmentapplication;

import com.hhstechgroup.beans.application.EnrollmentIUBean;
import com.hhstechgroup.steps.serenity.individualenrollment.EnrollmentApplicationSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.core.Is;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.yecht.Data;

import java.util.Map;
import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;


public class EnrollmentScenario {

    @Steps
    EnrollmentApplicationSteps enrollmentApplicationSteps;

    @When("search for enrollment data on IU portal by next parameters: $table")
    public void searchByEnrollParameters(ExamplesTable table) {
        EnrollmentIUBean parameters = ExamplesTableUtil.parseTableToClass(table, EnrollmentIUBean.class).get(0);
       enrollmentApplicationSteps.setEnrollSearchCriteria(parameters);
       enrollmentApplicationSteps.clickSearch();
    }
    @Then("verify the enrollment data by next parameters: $table")
    public void verifyByEnrollParameters(ExamplesTable table) {
        EnrollmentIUBean parameters = ExamplesTableUtil.parseTableToClass(table, EnrollmentIUBean.class).get(0);
        enrollmentApplicationSteps.setEnrollSearchCriteria(parameters);
    }
    @Then("verify the data in Clearing house tab")
    public void verifyDataInClearingHouse(){
        enrollmentApplicationSteps.verifyDataInClearingHouse();
    }
    @Then("verify the data under the tab")
    public void verifyIndicatorsData(){
        enrollmentApplicationSteps.verifyIndicatorsData();
    }

    @Then("verify the data in Provider Contracts tab")
    public void verifyProviderContractsData(){
        enrollmentApplicationSteps.verifyProviderContractsData();
    }

    @Then("verify the data under history tab")
    public void verifyDataUnderHistory(){
        enrollmentApplicationSteps.verifyDataUnderHistory();
    }

    @Then("verify the files and documents under the Files and documents tab")
    public void verifyFiles(){
        enrollmentApplicationSteps.verifyFiles();
    }

    //newly added
    @Then("Verifying Enrollment records details: $table")
    public void checkEnrollmentValuesForRecordWithNumber(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(enrollmentApplicationSteps.getMappedEnrollmentValuesForRecord(), Is.is(expectedInfo));
    }

    @Then("Verifying Enrollment records details with denied status: $table")
    public void checkEnrollmentValuesForRecordWithNumber1(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(enrollmentApplicationSteps.getMappedEnrollmentValuesForRecord1(), Is.is(expectedInfo));
    }

    @When("click On status as '$status' to verify the work flow")
    public void clickOnStatusButton(String status) {
        System.out.println("Status " +status + " Displaying");
        enrollmentApplicationSteps.clickOnStatusButton(status);
    }

    @When("Verifying work flow '$statusworkflow' is displaying")
    public boolean verifyingStatusWorkFlow(String statusworkflow) {
        System.out.println("Work flow " +statusworkflow + " Displaying");
        return enrollmentApplicationSteps.verifyingStatusWorkFlow(statusworkflow);}

     //sp23
     @Then("verifying Enrollment records with Assignee details: $table")
     public void checkEnrollmentValuesForRecordWithAssinee(ExamplesTable table) {
         Map<String, String> expectedInfo = table.getRow(0);
         assertThat(enrollmentApplicationSteps.getMappedEnrollmentValuesForAssignee(), Is.is(expectedInfo));
     }
     //sp28
     @Then("Verify the '$status' is displaying in Provider Portal Page")
     public void verifyingStatusRequiredAdditionalInfo(String status) {
         System.out.println("Status " +status + " Displaying");
         enrollmentApplicationSteps.verifyingStatusRequiredAdditionalInfo(status);
     }

    // only for existing account to continue enrollement
    @When("click on continue for existing enrollement")
    public void clickcontinue() {
        enrollmentApplicationSteps.clickcontinue();
    }

}
