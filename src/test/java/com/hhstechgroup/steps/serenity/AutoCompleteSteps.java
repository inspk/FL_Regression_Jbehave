package com.hhstechgroup.steps.serenity;

import com.hhstechgroup.ui.pages.enrollment.EnrollmentPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AutoCompleteSteps extends ScenarioSteps {

    EnrollmentPage enrollmentPage;

    @Step
    public boolean isAddressAutocompleteListAppeared() {
        return enrollmentPage.isAutoCompleteAppeared();
    }


    @Step
    public void clickOnFirstAddress() {
        enrollmentPage.getAddressAutoCompletePanel().selectFirstAddress();
    }

    @Step
    public boolean isVerifiedLabelPresent(String field) {
        return enrollmentPage.isVerifiedLabelPresent(field);
    }

    @Step
    public boolean isNoMatchesFoundDisplayed(String message) {
        return enrollmentPage.getAddressAutoCompletePanel().isNoMatchesMessageDisplayed(message);
    }
}