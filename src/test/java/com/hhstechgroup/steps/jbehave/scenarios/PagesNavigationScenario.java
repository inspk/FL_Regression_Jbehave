package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.PagesNavigationSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import static com.hhstechgroup.util.properties.SystemProperties.PROVIDER_MANAGEMENT_URL;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertTrue;

public class PagesNavigationScenario {

    @Steps
    PagesNavigationSteps pagesNavigationSteps;

    @When("refresh {Audit|} page")
    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    @When("clear browser cookies")
    public void clearCookies() {
        getDriver().manage().deleteAllCookies();
    }

    @When("page with url '$url' should be opened")
    @Then("page with url '$url' should be opened")
    public void isPageOpened(String url) {
        assertTrue("Wrong page opened", pagesNavigationSteps.isUrlEndsWith(url));
    }
    @Then("user should redirected to tha page having the '$url'")
    public void isUserNavigated(String url){
      Set<String> windows = getDriver().getWindowHandles();
//      ArrayList<String> window = new ArrayList<String>(getDriver().getWindowHandles());
        Iterator it=windows.iterator();
        String pid=(String) it.next();
        String cid=(String) it.next();
      getDriver().switchTo().window(cid);
//        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
//        getDriver().switchTo().window(tabs.get(1));
      assertTrue("Wrong page opened", pagesNavigationSteps.isUserNavigated(url));
      
    }

    @Then("page should contain url '$url'")
    public void isUrlContains(String url) {
        assertTrue("Wrong page opened", pagesNavigationSteps.isUrlContains(url));
    }

    @Then("user should be redirected to page with url ending with '$url'")
    public void isPageEndsWith(String url) {
        assertTrue("Wrong page opened", pagesNavigationSteps.isUrlEndsWith(url));
    }
    @When("user should be redirected back to Provider portal")

    @Then("user should be redirected back to Provider portal")
    public void isProviderPortalOpened() {
        assertTrue("Provider portal should be opened", pagesNavigationSteps.isUrlStartsWith(PROVIDER_MANAGEMENT_URL.getProperty()));
    }
}
