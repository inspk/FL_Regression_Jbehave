package com.hhstechgroup.util.webdriver;

import net.thucydides.core.webdriver.SupportedWebDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import net.thucydides.core.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateWebDriver extends WebDriverFactory {

    private static final String PRIVATE_MODE = "--incognito";

    private static PrivateWebDriver PRIVATE_WEB_DRIVER;


    public static synchronized PrivateWebDriver getInstance() {
        if (PRIVATE_WEB_DRIVER == null) {
            PRIVATE_WEB_DRIVER = new PrivateWebDriver();
        }
        return PRIVATE_WEB_DRIVER;
    }

    public WebDriver runInPrivateMode(WebDriver driver) {
        try {
            Method m = WebDriverFactory.class.getDeclaredMethod("newWebdriverInstance", Class.class, String.class);
            m.setAccessible(true);

            WebDriverFacade webDriverFacade = ((WebDriverFacade) driver).withOptions(PRIVATE_MODE);
            return (WebDriver) m.invoke(this, SupportedWebDriver.valueOrSynonymOf(webDriverFacade.getDriverName()).getWebdriverClass(), PRIVATE_MODE);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
