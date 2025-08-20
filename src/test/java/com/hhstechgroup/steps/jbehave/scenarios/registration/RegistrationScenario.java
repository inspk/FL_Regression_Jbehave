package com.hhstechgroup.steps.jbehave.scenarios.registration;

import com.hhstechgroup.steps.serenity.registration.RegistrationSteps;
import com.hhstechgroup.util.common.ExternalEmails;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RegistrationScenario {

    private Logger logger = Logger.getLogger(RegistrationScenario.class);

    @Steps
    RegistrationSteps registrationSteps;


    @When("fill Email with value '$value' on registration page")
    public void fillEmail(String value) {
        System.out.println(value);
        registrationSteps.fillEmail(value);
    }

    @When("fill Password with value '$value' on registration page")
    public void fillPassword(String value) {
        registrationSteps.fillPassword(value);
    }

    @When("fill Validate password with value '$value' on registration page")
    public void fillValidatePassword(String value) {
        registrationSteps.fillValidatePassword(value);
    }

    @When("fill Organization Name field with value '$value' on registration page")
    public void fillOrgName(String value) {
        registrationSteps.fillOrgName(value);
    }

    @When("fill Organization description with value '$value' on registration page")

    public void fillOrgDescription(String value) {
        registrationSteps.fillOrgDescription(value);
    }


    @When("fill First name with value '$value' on registration page")

    public void fillFirstName(String value) {
        registrationSteps.fillFirstName(value);
    }


    @When("fill Last name with value '$value' on registration page")

    public void fillLastName(String value) {
        registrationSteps.fillLastName(value);
    }


    @When("fill Middle name with value '$value' on registration page")

    public void fillMiddleName(String value) {
        registrationSteps.fillMiddleName(value);
    }

    @When("fill Phone with value '$value' on registration page")
    public void fillPhone(String value) {
        registrationSteps.fillPhone(value);
    }

    @When("fill Extension with value '$value' on registration page")
    public void fillExtension(String value) {
        registrationSteps.fillExtension(value);
    }

    @When("click Register button on registration page")
    public void clickRegisterButtonOnLoginPage() {
        registrationSteps.clickRegisterButtonOnRegistrationPage();
        String time = DateConverter.convert(LocalDateTime.now(), "h:mm a");
        logger.info(time);
        Serenity.setSessionVariable(ExternalEmails.REGISTRATION.getValue()).to(time);
        Serenity.setSessionVariable(ExternalEmails.WELCOME.getValue()).to(time);
    }

    @When("click Already Have Account link on registration page")
    public void clickAlreadyHaveAccountLink() {
        registrationSteps.clickAlreadyHaveAccountLink();
    }

    @When("select Prefix value '$value' on registration page")
    public void selectPrefix(String value) {
        registrationSteps.selectPrefix(value);
    }

    @When("select Suffix value '$value' on registration page")
    public void selectSuffix(String value) {
        registrationSteps.selectSuffix(value);
    }

    @When("perform registration with next information: $table")
    public void register(ExamplesTable table) {
        table.getRows().forEach(this::parseTableToRegistrationInfo);
        clickRegisterButtonOnLoginPage();
    }


    @Then("verify Already Have Account link is present")
    public void verifyAlreadyHaveAccountLinkPresent() {
        Assert.assertTrue(registrationSteps.isAlreadyHaveAccountLinkPresent());
    }

    @Then("'$text' text is displayed on Registration Successful panel")
    public void checkRegistrationSucessfulText(String text) {
        assertEquals("Wrong text is displayed on Registration Successful panel", text, registrationSteps.getRegistrationSuccessfulText());
    }

    @Then("validation message '$message' should be displayed for field - '$field'")
    public void checkRegValidation(String message, String field) {
        assertEquals("Validation message is incorrect or it is incorrect", message, registrationSteps.getValidationMessage(field));
    }

    @Then("tooltip with hints for password field is displayed")
    public void isPassTooltipPresent() {
        assertTrue(registrationSteps.isPassTooltipPresent());
    }

    private void parseTableToRegistrationInfo(Map<String, String> row) {
        Optional.ofNullable(row.get("email")).ifPresent(this::fillEmail);
        Optional.ofNullable(row.get("organizationName")).ifPresent(this::fillOrgName);
        Optional.ofNullable(row.get("organizationDescription")).ifPresent(this::fillOrgDescription);
        Optional.ofNullable(row.get("password")).ifPresent(this::fillPassword);
        Optional.ofNullable(row.get("validatePassword")).ifPresent(this::fillValidatePassword);
        Optional.ofNullable(row.get("firstName")).ifPresent(this::fillFirstName);
        Optional.ofNullable(row.get("lastName")).ifPresent(this::fillLastName);
        Optional.ofNullable(row.get("middleName")).ifPresent(this::fillMiddleName);
        Optional.ofNullable(row.get("extension")).ifPresent(this::fillExtension);
        Optional.ofNullable(row.get("phone")).ifPresent(this::fillPhone);
        Optional.ofNullable(row.get("prefix")).ifPresent(this::selectPrefix);
        Optional.ofNullable(row.get("suffix")).ifPresent(this::selectSuffix);
    }

    //sp34
    @When("select captcha check box in registration page")
    public void selectCapchaCheckbox() {
        registrationSteps.selectCapchaCheckbox();

    }


    // sp54 new product ui

    @When("click create account link in the landing page")
    public void clickCreateAccountLink(){
        registrationSteps.clickCreateAccountLink();
    }
    @When("click on continue button in the registartion page")
    public void clickContinueButton(){
        registrationSteps.clickContinueButton();
    }
    @When("click on create account link in the registartion page")
    public void clickCreateAccountButton(){
        registrationSteps.clickCreateAccountButton();
    }
}
