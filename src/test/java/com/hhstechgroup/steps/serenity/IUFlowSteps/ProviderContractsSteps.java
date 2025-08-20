package com.hhstechgroup.steps.serenity.IUFlowSteps;

import com.hhstechgroup.ui.pages.IUFlowPages.ProviderContractsPages;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;

public class ProviderContractsSteps extends ScenarioSteps {

    @Page
    ProviderContractsPages providerContractsPages;
    public void verifyProviderContracts(){
        providerContractsPages.verifyProvidercontract();
    }

}
