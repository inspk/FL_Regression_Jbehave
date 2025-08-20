package com.hhstechgroup.steps.serenity.registration;

import com.hhstechgroup.ui.pages.login.RegistrationConfirmationPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class RegistrationConfirmationSteps {
    @Page
    RegistrationConfirmationPage registrationConfirmationPage;

    @Step
    public boolean isRegistrationConfirmationPageDisplayed() {
        return registrationConfirmationPage.isRegistrationConfirmationPageDisplayed();

    }



    @Step
    public boolean registrationNotConfirmedTextIsDisplayed(String text) {
        return registrationConfirmationPage.registrationNotConfirmedTextIsDisplayed(text);
    }

    //SD-SP-03

    @Step
    public String getValidationLegalDisclaimerMessage(String field) {
        return registrationConfirmationPage.getValidationLegalDisclaimerMessage(field);
    }

    @Step
    public String getValidationLinks(String field) {

        return registrationConfirmationPage.getValidationLinks(field);
    }

    @Step
    public void clickOnLegalPrivacyLinks( String field){
        registrationConfirmationPage.clickOnLegalPrivacyLinks(field);
    }

}
