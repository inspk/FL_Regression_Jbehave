package com.hhstechgroup.steps.serenity.IUFlowSteps;

import com.hhstechgroup.ui.pages.IUFlowPages.AlternateIdentifierPages;
import net.thucydides.core.steps.ScenarioSteps;

public class AlternateIdentifierSteps extends ScenarioSteps {

    AlternateIdentifierPages alternateIdentifierPage;

    public void addAlternateIdentifier(String level, String type, String reason) {
        alternateIdentifierPage.openAddAlternateIdentifierDialog();
        alternateIdentifierPage.fillIdentifierForm(level,type, reason);
    }

    public void addAlternateIdentifier_Providerstab(String level, String type, String reason) {
        alternateIdentifierPage.openAddAlternateIdentifierDialog_ProvidersTab();
        alternateIdentifierPage.fillIdentifierForm(level,type, reason);
    }

    public void verifyAddedConfirmation(String expected) {
        alternateIdentifierPage.verifyAddConfirmation(expected);
    }

    public void editAlternateIdentifier(String reason, String status) {
        alternateIdentifierPage.openEditIdentifierDialog();
        alternateIdentifierPage.fillEditForm(reason, status);
    }

    public void verifyEditConfirmation(String expected) {
        alternateIdentifierPage.verifyEditConfirmation(expected);
    }

}
