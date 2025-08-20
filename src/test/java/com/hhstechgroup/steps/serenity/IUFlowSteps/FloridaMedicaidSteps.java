package com.hhstechgroup.steps.serenity.IUFlowSteps;

import com.hhstechgroup.ui.pages.IUFlowPages.FloridaMedicaidPages;
import net.thucydides.core.steps.ScenarioSteps;

public class FloridaMedicaidSteps extends ScenarioSteps {

    FloridaMedicaidPages floridaMedicaidPages;

    public void verifyConfigurationForFloridaMedicaid(){
        floridaMedicaidPages.verifyAndSetFloridaMedicaidProviderIdStatus();
    }

    public void verifyFloridaMedicaid(){
        floridaMedicaidPages.navigateToProviderMedicaid();
        floridaMedicaidPages.VerifYFloridaMedicaid();
    }

    public void verifyFloridaMedicaidProvider(){
        floridaMedicaidPages.navigateToProviderMedicaid();
        floridaMedicaidPages.VerifYFloridaMedicaidProviderTab();
    }

    public void EditFloridaMedicaid() {
        floridaMedicaidPages.editDateAndStatus();
    }

    public void VerifyConfirmationMessage(String expected)
    {
        floridaMedicaidPages.verifyEditConfirmation(expected);
    }

    public void verifyBackToDashboardButton(){
        floridaMedicaidPages.clickBackToDashBoardButton();
    }
}
