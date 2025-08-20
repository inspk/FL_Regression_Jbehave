package com.hhstechgroup.ui.pages;

import com.hhstechgroup.ui.panels.builder.BuilderBody;
import com.hhstechgroup.ui.panels.builder.HeaderBuilder;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.webdriver.Configuration;
import org.openqa.selenium.WebDriver;

import static com.hhstechgroup.util.properties.SystemProperties.BUILDER_BASE_URL;

public class BuilderMainPage extends AbstractPage {

    private static final String HEADER = "//div[contains(@class,'header_header_')]";
    private static final String BODY = "//div[contains(@class,'content_content')]";

    public BuilderMainPage(WebDriver driver) {
        super(driver);
        setLandingUrl();
    }

    public HeaderBuilder getHeader() {
        return new HeaderBuilder(findBy(HEADER), this);
    }

    public BuilderBody getBody() {
        return new BuilderBody(findBy(BODY), this);
    }

    private void setLandingUrl() {
        final Configuration configuration = Injectors.getInjector().getInstance(Configuration.class);
        configuration.setDefaultBaseUrl(
                BUILDER_BASE_URL.getProperty());
    }
}