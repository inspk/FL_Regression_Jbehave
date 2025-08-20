package com.hhstechgroup.steps.serenity.registration;

import com.hhstechgroup.ui.pages.landing.LandingPage;
import com.hhstechgroup.ui.pages.registration.RegistrationPage;
import com.hhstechgroup.ui.panels.registration.RegistrationSuccessfullPanel;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;


public class RegistrationSteps {
    @Page
    RegistrationPage registrationPage;
    LandingPage landingPage;

    @Step
    public String getRegistrationSuccessfulText() {
        RegistrationSuccessfullPanel panel = landingPage.getRegistrationSuccessfullPanel();
        return panel.getText();
    }

    @Step
    public boolean isAlreadyHaveAccountLinkPresent() {
        return registrationPage.isAlreadyHAveAccountLinkPresent();
    }

    @Step
    public void fillEmail(String email) {
        registrationPage.fillEmail(email);
    }

    @Step
    public void fillPassword(String password) {
        registrationPage.fillPassword(password);
    }

    @Step
    public void fillValidatePassword(String validatePassword) {
        registrationPage.fillValidatePassword(validatePassword);
    }

    @Step
    public void fillOrgName(String orgName) {
        registrationPage.fillOrgName(orgName);
    }

    @Step
    public void fillOrgDescription(String orgDescription) {
        registrationPage.fillOrgDescription(orgDescription);
    }

    @Step
    public void selectPrefix(String option) {
        registrationPage.selectPrefix(option);
    }

    @Step
    public void selectSuffix(String option) {
        registrationPage.selectSuffix(option);
    }

    @Step
    public void fillFirstName(String firstName) {
        registrationPage.fillFirstName(firstName);
    }

    @Step
    public void fillLastName(String lastName) {
        registrationPage.fillLastName(lastName);
    }

    @Step
    public void fillMiddleName(String middleName) {
        registrationPage.fillMiddleName(middleName);
    }

    @Step
    public void fillPhone(String phone) {
        registrationPage.fillPhone(phone);
    }

    @Step
    public void fillExtension(String extension) {
        registrationPage.fillExtension(extension);
    }

    @Step
    public void clickRegisterButtonOnRegistrationPage() {
        registrationPage.clickRegisterButtonOnRegistrationPage();
    }

    @Step
    public void clickAlreadyHaveAccountLink() {
        registrationPage.clickAlreadyHaveAccountLink();
    }

    @Step
    public String getValidationMessage(String field) {
        return registrationPage.getValidationMessage(field);
    }

    @Step
    public boolean isPassTooltipPresent() {
        return registrationPage.isPassTooltipPresent();
    }

    @Step
    public String generateEmail(String email){
        return registrationPage.generateEmail(email);
    }

    //sp34
    @Step
    public void selectCapchaCheckbox() {
        registrationPage.selectCapchaCheckbox();
    }


    // sp54 new product ui

    @Step
    public void clickCreateAccountLink(){
        registrationPage.clickCreateAccountLink();
    }


    @Step
    public void clickContinueButton(){
        registrationPage.clickContinueButton();
    }


    @Step
    public void clickCreateAccountButton(){
        registrationPage.clickCreateAccountButton();
    }


}

