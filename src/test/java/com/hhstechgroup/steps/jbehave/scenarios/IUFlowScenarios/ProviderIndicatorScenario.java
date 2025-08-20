package com.hhstechgroup.steps.jbehave.scenarios.IUFlowScenarios;

import com.hhstechgroup.steps.serenity.IUFlowSteps.ProviderIndicatorSteps;
import com.hhstechgroup.steps.serenity.providerData.ProviderDataSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

public class ProviderIndicatorScenario {

    @Steps
    ProviderIndicatorSteps providerIndicatorSteps;
    @Steps
    ProviderDataSteps providerDataSteps;

    @When("user calls Provider Indicator API")
    public void userCallsProviderIndicatorAPI() {
        providerIndicatorSteps.callProviderIndicatorAPI();
    }

    @When("user clicks on Providers tab")
    public void userClicksOnProvidersTab() {
        providerIndicatorSteps.clickProvidersTab();
    }

    @When("search with providerID in provider tab")
    public void searchWithProviderIDInProviderTab() {
        providerDataSteps.searchWithProviderIDInProviderTab();
    }

    @When("user navigates to Provider Indicator tab")
    public void userNavigatesToProviderIndicatorTab() {
        providerIndicatorSteps.navigateToProviderIndicator();
    }
    @When("searchAndVerifyIndicatorsForAllPES_IDs")
    public void searchAndVerifyIndicatorsForAllPES_IDs(){
        providerIndicatorSteps.searchAndVerifyIndicatorsForAllPES_IDs();
    }

    @When("user verifies indicators tab")
    public void userVerifiesIndicatorsTab() {
        providerIndicatorSteps.verifyIndicatorsTab();
    }

    @When("user verifies inactive status")
    public void userVerifiesInactiveStatus() {
        providerIndicatorSteps.verifyInactiveStatus();
    }
} 