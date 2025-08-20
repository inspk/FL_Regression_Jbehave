package com.hhstechgroup.steps.jbehave.scenarios.registration;

import com.hhstechgroup.steps.serenity.registration.LandingSteps;
import com.hhstechgroup.steps.serenity.registration.RegistrationConfirmationSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationConfirmationScenario {
    @Steps
    RegistrationConfirmationSteps registrationConfirmationSteps;

    @Steps
    LandingSteps landingStep ;

    @Then("registration confirmation text '$text' is displayed")
    public void registrationConfirmationTextIsDisplayed(String text){
        assertTrue("Your registration wasn't confirmed text is not displayed", registrationConfirmationSteps.registrationNotConfirmedTextIsDisplayed(text));
    }

    @Then("registration confirmation page is displayed")
    public void registrationConfirmationPageIsDisplayed(){
        assertTrue("Registration confirmation page should be displayed", registrationConfirmationSteps.isRegistrationConfirmationPageDisplayed());
    }

    //SD-SP-03

    @Then("validation message '$field' should be displayed in agree page")
    public  void getValidationLegalDisclaimerMessage(String field){
        assertEquals("This system contains U.S. Government and State of Florida information. By accessing and using this computer system you are consenting to system monitoring for law enforcement, auditing, and other purposes. Unauthorized use of, or access to, this computer system may subject your to state and federal. criminal prosecution and penalties, as well as civil penalties. Unauthorized use of the system is prohibited.", registrationConfirmationSteps.getValidationLegalDisclaimerMessage(field));
    }

    @Then("validate first privacy link in landing page for '$field' field")
    public void getValidateFirstLinkInLandingPage(String field){
        assertEquals("Privacy Policy" , registrationConfirmationSteps.getValidationLinks(field));
        System.out.println(registrationConfirmationSteps.getValidationLinks(field));
//        registrationConfirmationSteps.clickOnLegalPrivacyLinks(field);
    }

    @Then("validate second privacy link in landing page for '$field' field")
    public void getValidateSecondLinkInLandingPage(String field){
        assertEquals("Terms & Conditions" , registrationConfirmationSteps.getValidationLinks(field));
        System.out.println(registrationConfirmationSteps.getValidationLinks(field));
//        registrationConfirmationSteps.clickOnLegalPrivacyLinks(field);

//        landingStep.verifySdGovtIconIsDisplaying();
//        System.out.println("Verifying South Dakota Icon is displaying");
//        landingStep.verifySouthDakotaOfficialWebsiteIsDisplaying();
//        System.out.println("Verifying South Dakota Online Official Website is displaying");
    }

    @Then("validate third privacy link in landing page for '$field' field")
    public void getValidateThirdLinkInLandingPage(String field){
        assertEquals("Accessibility" , registrationConfirmationSteps.getValidationLinks(field));
        System.out.println(registrationConfirmationSteps.getValidationLinks(field));
        registrationConfirmationSteps.clickOnLegalPrivacyLinks(field);

        landingStep.verifySdGovtIconIsDisplaying();
        System.out.println("Verifying South Dakota Icon is displaying");
        landingStep.verifySouthDakotaOfficialWebsiteIsDisplaying();
        System.out.println("Verifying South Dakota Online Official Website is displaying");
    }

    @Then("validate fourth privacy link in landing page for '$field' field")
    public void getValidateFourthLinkInLandingPage(String field){
        assertEquals("Privacy" , registrationConfirmationSteps.getValidationLinks(field));
        System.out.println(registrationConfirmationSteps.getValidationLinks(field));
        registrationConfirmationSteps.clickOnLegalPrivacyLinks(field);
        landingStep.verifyPrivatePolicyPageIsDisplaying();
        System.out.println("Verifying South Dakota Online Private Policy is displaying");
        landingStep.verifySdGovtIconIsDisplaying();
        System.out.println("Verifying South Dakota Icon is displaying");
        landingStep.verifySouthDakotaOfficialWebsiteIsDisplaying();
        System.out.println("Verifying South Dakota Online Official Website is displaying");
    }

    @Then("validate fifth privacy link in landing page for '$field' field")
    public void getValidateFifthLinkInLandingPage(String field){
        assertEquals("HIPAA" , registrationConfirmationSteps.getValidationLinks(field));
        System.out.println(registrationConfirmationSteps.getValidationLinks(field));
        registrationConfirmationSteps.clickOnLegalPrivacyLinks(field);
    }

    @Then("validate sixth privacy link in landing page for '$field' field")
    public void getValidateSixthLinkInLandingPage(String field){
        assertEquals("Contact Us" , registrationConfirmationSteps.getValidationLinks(field));
        System.out.println(registrationConfirmationSteps.getValidationLinks(field));
    }


}
