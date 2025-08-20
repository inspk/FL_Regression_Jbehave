package com.hhstechgroup.steps.jbehave.scenarios.revalidation;

import com.hhstechgroup.steps.serenity.ReportsCannedSteps;
import com.hhstechgroup.steps.serenity.revalidation.RevalidationSteps;
import com.hhstechgroup.util.properties.ProviderProperties;
import com.hhstechgroup.util.properties.SystemProperties;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static com.hhstechgroup.util.properties.SystemProperties.PROVIDER_MANAGEMENT_URL;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RevalidationScenario {

    @Steps
    RevalidationSteps revalidationSteps;


    @When("send API request get public providers and find provider data id '$variable' with first name '$firstName' and last name '$lastName'")
    public void sendRequestGetProviderByName(String variable, String firstName, String lastName) {
        Serenity.setSessionVariable(variable).to(revalidationSteps.getDataProviderIdByName(firstName, lastName));
    }

    @When("send revalidation request with '$cookies', providerData '$providerData' and time to revalidation '$days'")
    public void activateRevalidation(String cookies, String providerDataId, String days){
        revalidationSteps.sendRevalidationRequest(cookies, providerDataId, days);
    }
    @Then("check that red revalidation message is displayed")
    public void checkRedRevalidationMessage(){
        assertTrue("Error isn't displayed", revalidationSteps.checkRedRevalidationMessage());
    }


    @Then("check that valid number of revalidation hours '$hours' are displayed")
    public void checkValidNumberOfDays(String hours){
        assertTrue("Revalitidation time are not same", revalidationSteps.getTextFromRevalidationRedMessage().contains(hours));
    }

    @Then("check that termination message text is displayed: '$terminationMessage'")
    public void verifyThatTerminationMessageIsDisplayed(String terminationMessage){
        assertTrue(revalidationSteps.getTextFromRevalidationRedMessage().contains(terminationMessage));
    }

    @Then("check that revalidation message is displayed")
    public void checkRevalidationMessage(){
        assertTrue("Error isn't displayed", revalidationSteps.checkRevalidationMessage());
    }


    @Then("check that enrollment message is displayed")
    public void checkEnrollmentMessage(){
        assertTrue("Enrollment message isn't displayed", revalidationSteps.checkEnrollmentMessage());
    }


    @Then("check that revalidation message text is displayed: '$revalidationMessage'")
    public void verifyThatRevalidationMessageIsDisplayed(String revalidationMessage){
        assertTrue(revalidationSteps.getTextFromSimpleRevalidationMessage().contains(revalidationMessage));
    }

    @Then("check that valid revalidation term '$term' is displayed")
    public void checkValidRevalidationTime(String term){
        assertTrue("Revalitidation term is not same", revalidationSteps.getTextFromSimpleRevalidationMessage().contains(term));
    }

    //sp45

    @When("save the provider id")
    public void isLandingPageOpened1 () {
        String url = getDriver().getCurrentUrl() ;
        System.out.println(url) ;
        String  Env = SystemProperties.PROVIDER_MANAGEMENT_URL.getProperty();
        String providerDataId = url.replaceAll(Env+"/providers/","");
        ProviderProperties.save("providerDataId", providerDataId);
    }

    @When("send revalidation request with '$cookies' and time to revalidation '$days'")
    public void activateRevalidation1(String cookies,String days){
        //Serenity.setSessionVariable("providerDataId").to(ProviderProperties.getData("providerDataId"));
        revalidationSteps.sendRevalidationRequest1(cookies,days);
    }



}
