package com.hhstechgroup.steps.jbehave.scenarios.medibook;


import com.hhstechgroup.steps.serenity.PagesNavigationSteps;
import com.hhstechgroup.steps.serenity.medibook.MedibookLandingSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static com.hhstechgroup.util.properties.SystemProperties.MEDIBOOK_BASE_URL;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MedibookLandingScenario {

    @Steps
    MedibookLandingSteps medibookLandingSteps;

    @Steps
    PagesNavigationSteps pagesNavigationSteps;

    @Given("user navigated to medibook landing page")
    @When("user navigated to medibook page")
    public void openProviderLandingPage ()  {
        medibookLandingSteps.openLandingPage();
    }

    @Then("medibook landing page should be opened")
    public void isLandingPageOpened () {
        System.out.println(getDriver().getCurrentUrl());
        assertTrue("Medibook landing page should be opened", getDriver().getCurrentUrl().equals(MEDIBOOK_BASE_URL.getProperty() + "/login"));
    }

    @When("click on button '$button' on medibook landing page")
    public void clickOnButton(String button) {
        medibookLandingSteps.clickOnButton(button);
    }

    @When ("fill medibook username field with value '$value'")
    public void fillUsername (String value) {
        medibookLandingSteps.fillUsername(value);
    }

    @When ("fill medibook password field with value '$value'")
    public void fillPassword (String value) {
        medibookLandingSteps.fillPassword(value);
    }

    @Then("value '$email' should be displayed in medibook username field")
    public void isEmailFilled(String email) {
        assertEquals("Wrong value is displayed", email, medibookLandingSteps.getUsernameValue());
    }

    @Then("value '$password' should be displayed in medibook password field")
    public void isPasswordFilled(String password) {
        assertEquals("Wrong value is displayed", password, medibookLandingSteps.getPasswordValue());
    }

    @Then("error message '$error' for medibook username is displayed")
    public void usernameErrorIsDisplayed(String error){
        assertTrue("Error message for username field is not displayed", medibookLandingSteps.usernameErrorIsDisplayed(error));
    }

    @Then("error message '$error' for medibook password is displayed")
    public void passwordErrorIsDisplayed(String error){
        assertTrue("Error message for password field is not displayed", medibookLandingSteps.passwordErrorIsDisplayed(error));
    }

    @Then("error message '$error' is displayed in medibook")
    public void commonErrorIsDisplayed(String error){
        assertTrue("This field is required for password error message is not displayed", medibookLandingSteps.incorrectLoginPassErrorIsDisplayed(error));
    }

    @When("user logs to medibook portal with username - '$email' and password - '$password' by click on '$button'")
    public void logIn(String email, String password, String button) {
        fillUsername(email);
        fillPassword(password);
        clickOnButton(button);
    }

    @When("log out as user '$user' from medibook portal")
    public void logOutFromMedibook(String name) {
        String currentUrl = getDriver().getCurrentUrl();
        medibookLandingSteps.logOutAs(name);
        pagesNavigationSteps.waitForRedirectedFrom(currentUrl);
    }
}