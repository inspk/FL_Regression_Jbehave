package com.hhstechgroup.ui.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

public abstract class AbstractPage extends PageObject {
    private static final int HEADER_HEIGHT = 180;
    private static final String SPINNER = ".//div[contains(@class, 'spinner_spinner-wrap')]";
    private static final String POP_UP = ".//div[@role='dialog']";
    protected static final String DROP_DOWN_OPTION = ".//ul/li[node() = '%s']";

    public AbstractPage(WebDriver driver) {
        super(driver);
    }
    protected WebDriver driver;
    protected boolean isElementPresent(final String xpathOrCssSelector) {
        return isNotEmpty(findAll(xpathOrCssSelector));
    }

    public void waitAbit(long timeInMilliseconds) {
        waitABit(timeInMilliseconds);
    }

    protected void scrollToElement(String xpathOrCssSelector) {
        WebElementFacade element = findBy(xpathOrCssSelector);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript(String.format("window.scrollTo(0, %d)", element.getLocation().getY() - element.getSize().getHeight() - HEADER_HEIGHT));
    }

    protected void jsClick(String xpathOrCssSelector) {
        WebElementFacade el = findBy(xpathOrCssSelector);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].click();", el);
    }


    public void waitForSpinnerToDisappear() {
        withTimeoutOf(Duration.ofSeconds(30)).waitForElementsToDisappear(By.xpath(SPINNER));
    }

    public void waitForPopUpOpened() {
        waitAbit(3000);
        waitForPresenceOf(POP_UP);
    }

    protected Actions action() {
        WebDriver driver = ((WebDriverFacade)getDriver()).getProxiedDriver();
        return new Actions(driver);
    }

    protected void selectFromDropDown(String option) {
        selectOption(option, DROP_DOWN_OPTION);
        waitForAbsenceOf(DROP_DOWN_OPTION);
    }

    private void selectOption(String option, String locator) {
        waitABit(200);
        action().moveToElement(findBy(String.format(locator, option))).click().build().perform();
    }

    //sp21
    private static final String START_EFFECTIVE_DATE = "//label[text()='Effective start *']//ancestor::div[contains(@class, 'styles_effectivedatepicker')]//input" ;
    public void addEffectiveDate(String effectiveDate){
        jsClick(START_EFFECTIVE_DATE);
        findBy(START_EFFECTIVE_DATE).sendKeys(effectiveDate);
    }

    public static String generateRandomString() {
        return new BigInteger(120, new SecureRandom()).toString(32);
    }

    /**
     * This method clicks on an element using Actions class by passing a locator
     *
     * @param locator
     */
    public void performClick(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    /**
     * This method returns a webElement of a specific option in the list
     *
     * @param option
     * @return
     */
    public WebElement setSpecificOptionInListbox(String option) {
        return driver.findElement(By.xpath("//ul[@role='listbox']//li[text()='" + option + "']"));
    }

    /**
     * This method clicks on an element using JavascriptExecutor
     *
     * @param element
     */
    public void ajaxClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /**
     * This method clicks on specific option using the index
     *
     * @param index
     */
    public void clickAnyOptionInList(int index) {
        waitAbit(1000);
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
        ajaxClick(elements.get(index));
    }

    /**
     * This method gets a current date
     *
     * @return
     */
    public static String getCurrentDate() {
        LocalDateTime ldt = LocalDateTime.now();
        String formattedDate = ldt.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        return formattedDate;
    }

    /**
     * This method scrolls using JavascriptExecutor
     *
     * @param locator
     */
    public void ajaxScroll(By locator) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

}
