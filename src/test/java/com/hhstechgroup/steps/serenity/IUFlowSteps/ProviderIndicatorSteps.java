package com.hhstechgroup.steps.serenity.IUFlowSteps;

import com.hhstechgroup.ui.pages.IUFlowPages.ProviderIndicatorPage;
import com.hhstechgroup.ui.pages.peportal.DashboardPage;
import com.hhstechgroup.util.properties.LocationProviderProperties;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class ProviderIndicatorSteps extends ScenarioSteps {

    public ProviderIndicatorPage providerIndicatorPage;
    public DashboardPage dashboardPage;

    @Step
    public void callProviderIndicatorAPI() {
        providerIndicatorPage.callProviderIndicatorAPI();
    }

    @Step
    public void clickProvidersTab() {
        dashboardPage.getHeaderPanel().clickOnTab("Providers");
    }

    @Step
    public void navigateToProviderIndicator() {
        providerIndicatorPage.navigateToProviderIndicator();
    }
    @Step
    public void searchAndVerifyIndicatorsForAllPES_IDs() {
        List<String> providerIds = LocationProviderProperties.getPES_Id();

        for (String providerId : providerIds) {
            System.out.println("Processing Provider ID: " + providerId);
            clickProvidersTab();
            providerIndicatorPage.clearproviderid();
            providerIndicatorPage.searchWithProviderId(providerId);
            providerIndicatorPage.clickonenrollment(providerId);
            providerIndicatorPage.navigateToProviderIndicator();
            providerIndicatorPage.verifyindicatorstab();
        }

    }


    @Step
    public void verifyIndicatorsTab() {
        providerIndicatorPage.verifyindicatorstab();
    }

    @Step
    public void verifyInactiveStatus() {
        providerIndicatorPage.verifyinactivestatus();
    }
//
//    @Step
//    public void searchWithProviderId() {
//        providerIndicatorPage.searchWithProviderId();
//    }
} 