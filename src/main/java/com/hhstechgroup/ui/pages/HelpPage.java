package com.hhstechgroup.ui.pages;

import com.hhstechgroup.util.common.Wait;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.function.Predicate;


public class HelpPage extends AbstractPage {


    private static final String SKIP_TOOLTIP = ".//div[contains(@class, 'joyride-tooltip-')]//button[@data-type='skip' and text() = 'Skip']";
    private static final String CLOSE_TOOLTIP = ".//div[contains(@class, 'joyride-tooltip-')]//button[@data-type='close']";
    private static final String NEXT_BUTTON = ".//button[@data-type='next']";
    private static final String BACK_BUTTON = ".//button[@data-type='back' and text() = 'Back']";
    private static final String TOOLTIP_TEXT = ".//div[contains(text(), '%s')]";
    private static final String HELP_TOUR = ".//div[contains(@class, 'joyride-tooltip-')]";

    public HelpPage(WebDriver driver) {
        super(driver);
    }

    public void skipTooltipIfExists() {
        if (isElementPresent(SKIP_TOOLTIP))
        {
        WebElementFacade el = findBy(SKIP_TOOLTIP);
        evaluateJavascript("arguments[0].click();", el);
        waitForAbsenceOf(SKIP_TOOLTIP);
            try {
                withTimeoutOf(Duration.ofSeconds(3)).waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(CLOSE_BUTTON)));
                jsClick(CLOSE_BUTTON);

            }catch (Exception e){

            }
        }
        else {
            System.out.println("HELP TOUR TOOLTIP IS ABSENT");
        }
    }
    private static final String CLOSE_BUTTON = ".//button[contains(@aria-label,'Close')]";
    public void skipTooltip() {
        waitForPresenceOf(SKIP_TOOLTIP);
        WebElementFacade el = findBy(SKIP_TOOLTIP);
        evaluateJavascript("arguments[0].click();", el);
        waitForAbsenceOf(SKIP_TOOLTIP);
        try {
            withTimeoutOf(Duration.ofSeconds(3)).waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(CLOSE_BUTTON)));
            jsClick(CLOSE_BUTTON);

        }catch (Exception e){

        }
    }

    public boolean isHelpTourTooltipDisplayedCorrectly (String title, String description){
        return isElementPresent(String.format(TOOLTIP_TEXT, title)) && isElementPresent(String.format(TOOLTIP_TEXT, description));
    }

    public void closeHelpTour(){
        waitAbit(500);
        waitForPresenceOf(CLOSE_TOOLTIP);
        WebElementFacade el = findBy(CLOSE_TOOLTIP);
        evaluateJavascript("arguments[0].click();", el);
        waitForAbsenceOf(CLOSE_TOOLTIP);
    }

    public void clickOnNextButton(){
        findBy(NEXT_BUTTON).click();
    }

    public void clickOnBackButton(){
        findBy(BACK_BUTTON).click();
    }

    public boolean isHelpTourOpened() {
        return isElementPresent(HELP_TOUR);
    }

    public void waitForHelpTour() {
        Predicate<String> isHelpTourPresent = helpTour -> isHelpTourOpened();
        Wait wait = new Wait();
        wait.waitForCondition(isHelpTourPresent, HELP_TOUR);
    }
}
