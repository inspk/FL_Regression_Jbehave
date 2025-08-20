package com.hhstechgroup.steps.jbehave;


import org.jbehave.core.annotations.*;
import org.openqa.selenium.Dimension;


import java.util.concurrent.TimeUnit;

import static java.util.Objects.nonNull;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class BeforeAfterScenario {

    private static final String ADD_RESULTS_TO_JIRA_PROPERTY = "publish.test.results";

//    @BeforeStories
//    public void beforeStories() {
//        if (nonNull(System.getProperty(ADD_RESULTS_TO_JIRA_PROPERTY))) {
//            JiraTestResultsCollector.getInstance().createTestResultsFile();
//        }
//    }

    @BeforeScenario(uponType = ScenarioType.ANY)
    public void beforeEachScenario() {
      //  getDriver().manage().window().setSize(new Dimension(1920, 1080));
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }



    @Given("Next @BUG: $bug")
    @When("Next @BUG: $bug")
    @Then("Next @BUG: $bug")
    public void mockBugStep(String bug) {}
}
