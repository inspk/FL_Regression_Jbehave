package com.hhstechgroup.ui.pages.peportal;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.peportal.AddPayerPopUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.lang.String.format;


public class PayersPage extends ProviderManagementBasePage {

    private static final String ADD_PAYER = ".//button[span[text()='Payer']]";
    private static final String ADD_PAYER_POPUP = ".//div[@role='dialog']";
    private static final String OPEN_PAYER_DETAILS = ".//div[contains(@class, 'payers_row')]/h6[text()='%s']/../div[contains(@class, 'payers_btn-wrapper')]";
    private static final String SIGN = "//button[span[text() = 'Sign']]";
    private static final String NAVIGATE_TO_PAYERS = "//a[contains(text(), 'Navigate to payers')]";

    public PayersPage(WebDriver driver) {
        super(driver);
    }

    public AddPayerPopUp getAddPayerPopUp() {
        return new AddPayerPopUp(findBy(ADD_PAYER_POPUP), this);
    }

    public void clickAddPayer() {
        waitFor(ExpectedConditions.elementToBeClickable(By.xpath(ADD_PAYER)));
        findBy(ADD_PAYER).waitUntilEnabled().click();
    }

    public void openPayer(String payer) {
        waitFor(ExpectedConditions.elementToBeClickable(By.xpath(format(OPEN_PAYER_DETAILS, payer))));
        findBy(format(OPEN_PAYER_DETAILS, payer)).click();
    }

    public void clickSign() {
        findBy(SIGN).waitUntilClickable().click();
        waitForAbsenceOf(SIGN);
    }

    public void clickNavigateToPayers() {
        findBy(NAVIGATE_TO_PAYERS).waitUntilClickable().click();
        waitForAbsenceOf(NAVIGATE_TO_PAYERS);
    }


}
