package com.hhstechgroup.ui.panels;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.util.common.Wait;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

public abstract class AbstractPanel {

    protected static final String HIDDEN_ROOT_ELEMENT = ".//div[@id = 'root' and @aria-hidden='true']";
    private static final int HEADER_HEIGHT = 180;
    protected static final String DROP_DOWN_OPTION = "//div//ul[@role='listbox']//li[text()='%s']";
    private static final String PRECEDING_SIBLING_ELEMENT = "/preceding-sibling::*";
    private static final String PRECEDING_ELEMENT = "preceding-sibling::*";
    protected static final String POP_UP = "//div[@id='root']";
    protected static final String POP_UP_APPROVE = "(//div[@role='dialog'])[2]";
    protected static final String CALENDAR_POP_UP = ".//div[@role='document']";
    protected static final String SPINNER = ".//div[contains(@class, 'spinner_spinner-wrap')]";
    protected static final String DEFAULT_PANEL = ".//*";
    protected static final String PAYMENT_POPUP="//div[@id='dialog-title']/..";

    private AbstractPage basePage;
    private WebElementFacade panelBaseLocation;

    public AbstractPanel(final WebElementFacade panelBaseLocation, final AbstractPage basePage) {
        this.basePage = basePage;
        this.panelBaseLocation = panelBaseLocation;
    }

    protected AbstractPanel(final String panelBaseLocation, final AbstractPage basePage) {
        this.basePage = basePage;
        this.panelBaseLocation = basePage.findBy(panelBaseLocation);
    }

    protected WebDriver getDriver() {
        return basePage.getDriver();
    }

    protected AbstractPage getBasePage() {
        return basePage;
    }

    protected WebElementFacade getPanelBaseLocation() {
        return panelBaseLocation;
    }

    protected Actions action() {
        WebDriver driver = ((WebDriverFacade)getDriver()).getProxiedDriver();
        return new Actions(driver);
    }

    protected WebElementFacade findBy(final String xpathOrCssSelector) {
        return panelBaseLocation.findBy(xpathOrCssSelector);
    }

    protected List<WebElementFacade> findAll(final String xpathOrCssSelector) {
        return panelBaseLocation.thenFindAll(xpathOrCssSelector);
    }

    protected boolean isElementPresent(final String xpathOrCssSelector) {
        return isNotEmpty(findAll(xpathOrCssSelector));
    }

    private void selectOption(String option, String locator) {
        waitABit(200);
        action().moveToElement(basePage.findBy(String.format(locator, option))).click().build().perform();
        basePage.waitForAbsenceOf(HIDDEN_ROOT_ELEMENT);
    }

    protected void selectFromDropDown(String option, String optionLocator) {
        selectOption(option, optionLocator);
    }

    protected void selectFromDropDown(String option) {
        selectOption(option, DROP_DOWN_OPTION);
    }

    protected void scrollToElement(String xpathOrCssSelector) {
        WebElementFacade element = findBy(xpathOrCssSelector);
        JavascriptExecutor jsExecutor = (JavascriptExecutor)basePage.getDriver();
        jsExecutor.executeScript(String.format("window.scrollTo(0, %d)", element.getLocation().getY() - element.getSize().getHeight() - HEADER_HEIGHT));
    }

    protected void waitForElementPulledUp(String element, int expectedLocation) {
        basePage.waitForCondition().until(webDriver -> findBy(element).getLocation().getY() == expectedLocation);
    }

    protected void waitForPresenceOf(String xpathOrCssSelector) {
        basePage.waitForPresenceOf(xpathOrCssSelector);
    }

    protected void waitForAbsenceOf(String xpathOrCssSelector) {
        basePage.waitForAbsenceOf(xpathOrCssSelector);
    }

    protected int getPositionRelatedToSibling(String xpathOrCssSelector) {
        return findAll(xpathOrCssSelector.concat(PRECEDING_SIBLING_ELEMENT)).size() + 1;
    }

    protected int getPositionRelatedToSibling(WebElementFacade xpathOrCssSelector) {
        return xpathOrCssSelector.thenFindAll(PRECEDING_ELEMENT).size() + 1;
    }

    protected void waitABit(long timeInMilliseconds) {
        basePage.waitAbit(timeInMilliseconds);
    }

    protected void waitFor(ExpectedCondition condition) {
        getBasePage().waitFor(condition);
    }

    public void waitForPopUpOpened() {
        waitForPresenceOf(POP_UP);
    }

    public void waitForCalendarPopUpOpened() {
        waitForPresenceOf(CALENDAR_POP_UP);
    }

    protected void jsClick(String xpathOrCssSelector) {
        WebElementFacade el = findBy(xpathOrCssSelector);
        JavascriptExecutor jsExecutor = (JavascriptExecutor)basePage.getDriver();
        jsExecutor.executeScript("arguments[0].click();", el);
    }

    protected void upload(WebElement element, String path) {
        getBasePage().evaluateJavascript("arguments[0].style = \"\"; arguments[0].style.display = \"block\"; arguments[0].style.visibility = \"visible\";", element);
        getBasePage().upload(path).to(element);
    }

    protected void waitForPopUpAttributeAppear() {
        Wait wait = new Wait();
        wait.waitForCondition(isHiddenAttributePresent, POP_UP, POP_UP_APPROVE);
    }

    private BiPredicate<String, String> isHiddenAttributePresent = (locator1, locator2) -> isHidden(locator1)||isHidden(locator2);

    private boolean isHidden(String locator){
        return findBy(locator).getAttribute("aria-hidden") != null;
    }


}
