package com.hhstechgroup.steps.jbehave.scenarios.IUFlowScenarios;

import com.hhstechgroup.steps.serenity.IUFlowSteps.RateSettingSteps;
import com.hhstechgroup.ui.panels.iuportal.ChangeStatusPopUp;
import com.hhstechgroup.util.common.ExternalEmails;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.time.LocalDateTime;

public class RateSettingScenario {
    @Steps
    RateSettingSteps rateSettingSteps;
    ChangeStatusPopUp changeStatusPopUp;



    @Then("verify ratesetting toggle in SystemOption for Auto")
    public void verifyRateSettingToggleSystemoption(){
        rateSettingSteps.verifyRateSettingToggleSystemOption_Auto();
    }

    @Then("verify ratesetting toggle in SystemOption for Manual")
    public void verifyRateSettingToggleSystemoption_Manual(){
        rateSettingSteps.verifyRateSettingToggleSystemOption_Manual();
    }

    @When("set {appeal|coc|enrollment} request Rate Setting In Progress status to - $status")
    public void setRateSettingStatus(String status){
        changeStatusPopUp.setRateSettingStatus(status);
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }
    @Then("search with RequestID '$id'")
    public void SearchWithProviderID(String id){
        rateSettingSteps.SearchWithProviderID(id);
    }


//@Steps
//RateSettingSteps rateSettingSteps;
//
//    @Then("verify ratesetting toggle in SystemOption for Auto")
//    public void verifyRateSettingToggleSystemoption() {
//        rateSettingSteps.verifyRateSettingToggleSystemOption();
//    }
//
//    @Then("verify ratesetting toggle in SystemOption for Manual")
//    public void verifyRateSettingToggleSystemoption_Manual() {
//        rateSettingSteps.verifyRateSettingToggleSystemOption_Manual();
//    }
//
//    @When("set {appeal|coc|enrollment} request Rate Setting In Progress status to - $status")
//    public void setRateSettingStatus(String status) {
//        // Delegate to steps class
//        rateSettingSteps.setRateSettingStatus(status);
//
//        // Save time of status change in Serenity session
//        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue())
//                .to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
//    }
//
//    @Then("search with RequestID '$id'")
//    public void SearchWithProviderID(String id) {
//        rateSettingSteps.SearchWithProviderID(id);
//    }

}
