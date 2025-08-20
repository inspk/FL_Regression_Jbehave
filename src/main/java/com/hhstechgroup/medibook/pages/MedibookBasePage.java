package com.hhstechgroup.medibook.pages;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.webdriver.Configuration;
import org.openqa.selenium.WebDriver;

import static com.hhstechgroup.util.properties.SystemProperties.MEDIBOOK_BASE_URL;

public class MedibookBasePage extends AbstractPage {

    public MedibookBasePage(WebDriver driver) {
        super(driver);
        setLandingUrl();
    }

    private void setLandingUrl() {
        final Configuration configuration = Injectors.getInjector().getInstance(Configuration.class);
        configuration.setDefaultBaseUrl(
                MEDIBOOK_BASE_URL.getProperty());
    }
}