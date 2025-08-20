package com.hhstechgroup.steps.jbehave.scenarios.IUFlowScenarios;

import com.hhstechgroup.steps.serenity.IUFlowSteps.ProviderContractsSteps;
import com.hhstechgroup.steps.serenity.IUFlowSteps.ProviderIndicatorSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;

public class ProviderContractsScenario {
    @Steps
    ProviderContractsSteps providerContractsSteps;

//    @Then("verify Provider Contracts in IU")
//    public void verifyProviderContracts(){
//        providerContractsSteps.verifyProviderContracts();
//    }
    @Then("verify Provider Contracts in IU")
    public void verifyProviderContracts(){
        providerContractsSteps.verifyProviderContracts();
    }

}
