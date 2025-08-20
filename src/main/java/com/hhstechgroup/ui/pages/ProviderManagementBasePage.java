package com.hhstechgroup.ui.pages;

import net.thucydides.core.guice.Injectors;

import net.thucydides.core.webdriver.Configuration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static com.hhstechgroup.util.properties.SystemProperties.PROVIDER_MANAGEMENT_URL;

public class ProviderManagementBasePage extends AbstractPage {

    private static final int HEADER_HEIGHT = 180;
    private static final String BACK_TO_SEARCH_RESULTS = ".//div[contains(@class, 'breadcrumb_breadcrumb')]/span";

    public ProviderManagementBasePage(WebDriver driver) {
        super(driver);
        setLandingUrl();
    }

    private void setLandingUrl() {
        final Configuration configuration = Injectors.getInjector().getInstance(Configuration.class);
        configuration.setDefaultBaseUrl(
                PROVIDER_MANAGEMENT_URL.getProperty());
    }

    public void scrollToElement(final String locator) {
        WebElement element = findBy(locator);
        ((JavascriptExecutor) getDriver()).executeScript(String.format("window.scrollTo(0, %d)", element.getLocation().getY() - element.getSize().getHeight() - HEADER_HEIGHT));
    }

    public void clickBackToSearchResults() {
        scrollToElement(BACK_TO_SEARCH_RESULTS);
        findBy(BACK_TO_SEARCH_RESULTS).click();
    }
}
