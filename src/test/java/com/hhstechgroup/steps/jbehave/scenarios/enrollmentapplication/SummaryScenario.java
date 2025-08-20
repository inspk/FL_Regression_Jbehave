package com.hhstechgroup.steps.jbehave.scenarios.enrollmentapplication;

import com.hhstechgroup.beans.application.SummaryBean;
import com.hhstechgroup.steps.serenity.individualenrollment.SummarySteps;
import com.hhstechgroup.util.common.ExternalEmails;
import com.hhstechgroup.util.converters.DateConverter;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.time.LocalDateTime;

import static com.hhstechgroup.util.converters.DateConverter.*;
import static org.junit.Assert.assertTrue;

public class SummaryScenario {


    @Steps
    SummarySteps summarySteps;

    @When("set next information to Summary section: $table")
    public void setSummary(ExamplesTable table) {
        SummaryBean info = ExamplesTableUtil.parseTableToClass(table, SummaryBean.class).get(0);
        summarySteps.setSummary(info);
    }

    @When("proceed to sign")
    public void clickProceedToSign() {
        summarySteps.clickProceed();
        Serenity.setSessionVariable(SUBMIT_TIME).to(DateConverter.getSubmissionDate());
        Serenity.setSessionVariable(FILE_GENERATION_DATE_TIME).to(getFileGenerationDateTime());
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(convert(LocalDateTime.now(), "h:mm a"));
    }


    @When("click on sign button in summary section")
    public void clickProceedToSign1() {
        summarySteps.clickProceed1();}

    @When("submit application")
    public void submitApp(){
        summarySteps.clickSubmit();
        Serenity.setSessionVariable(SUBMIT_TIME).to(DateConverter.getSubmissionDate());
        Serenity.setSessionVariable(FILE_GENERATION_DATE_TIME).to(getFileGenerationDateTime());
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(convert(LocalDateTime.now(), "h:mm a"));
    }

    @Then("verify '$button' button is disabled")
    public void buttonDisabled(String button){
        assertTrue(summarySteps.isButtonDisabled(button));
    }

    //sp42.3
    @When("submit sitevisit application")
    public void submitApp1(){
        summarySteps.clickSubmit1();
        Serenity.setSessionVariable(SUBMIT_TIME).to(DateConverter.getSubmissionDate());
        Serenity.setSessionVariable(FILE_GENERATION_DATE_TIME).to(getFileGenerationDateTime());
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(convert(LocalDateTime.now(), "h:mm a"));
    }

    //SD08

    @When("submit enrollment application")
    public void submitApplication(){
        summarySteps.submitApplication();
        Serenity.setSessionVariable(SUBMIT_TIME).to(DateConverter.getSubmissionDate());
        Serenity.setSessionVariable(FILE_GENERATION_DATE_TIME).to(getFileGenerationDateTime());
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(convert(LocalDateTime.now(), "h:mm a"));
    }

    @When("sign/submit application")
    public void signSubmitApp(){
        summarySteps.clickSignSubmit();
    }
}
