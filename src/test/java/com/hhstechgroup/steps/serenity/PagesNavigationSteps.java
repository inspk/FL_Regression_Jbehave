package com.hhstechgroup.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagesNavigationSteps extends ScenarioSteps {

    @Step
    public boolean isUrlEndsWith(String url) {
        WebDriver driver = getDriver();
        return new WebDriverWait(driver, 20).until(wdriver -> wdriver.getCurrentUrl().endsWith(url));
    }
    @Step
    public boolean isUserNavigated(String url){
        WebDriver driver = getDriver();
        return new WebDriverWait(driver, 20).until(wdriver -> wdriver.getCurrentUrl().endsWith(url));
    }

    @Step
    public boolean isUrlContains(String url) {
        WebDriver driver = getDriver();
        return new WebDriverWait(driver, 10).until(wdriver -> wdriver.getCurrentUrl().contains(url));
    }

    @Step
    public boolean isUrlStartsWith(String url) {
        WebDriver driver = getDriver();
        return new WebDriverWait(driver, 10).until(wdriver -> wdriver.getCurrentUrl().startsWith(url));
    }

    @Step
    public void waitForRedirectedFrom(String url) {
        WebDriver driver = getDriver();
        new WebDriverWait(driver, 30).until(wdriver -> !wdriver.getCurrentUrl().equals(url));
    }

    @Step
    public void waitForRedirectedTo(String url) {
        WebDriver driver = getDriver();
        new WebDriverWait(driver, 10).until(wdriver -> wdriver.getCurrentUrl().equals(url));
    }
}
