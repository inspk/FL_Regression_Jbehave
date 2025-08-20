package com.hhstechgroup.steps.serenity.IUFlowSteps;

import com.hhstechgroup.ui.pages.IUFlowPages.RateSettingPages;
import net.thucydides.core.steps.ScenarioSteps;

public class RateSettingSteps extends ScenarioSteps {

    RateSettingPages rateSettingPages;

    public void verifyRateSettingToggleSystemOption_Auto(){
        rateSettingPages.verifyRateSettings_Auto();
    }

    public void verifyRateSettingToggleSystemOption_Manual(){
        rateSettingPages.verifyRateSettings_Manual();
    }

    public void SearchWithProviderID(String id){
        rateSettingPages.SearchWithProviderID(id);
    }

}
