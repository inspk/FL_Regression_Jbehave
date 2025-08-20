package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.KeyValueMapper;
import com.hhstechgroup.util.common.Wait;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringBefore;

public class PaymentPanel extends BaseEnrollmentPanel implements KeyValueMapper {

    private static final String DETAILS = ".//div[contains(@class, 'section_section-cont')]//div[count(div) = 2]";
    private static final String SEPARATOR = "\n";
    //    private static final String SUBMIT_PYMENT = ".//form//button/span[text() = 'Go To Payment']";
    private static final String SUBMIT_PYMENT = ".//button/span[text() = 'Go To Payment']";
    private static final String PYMENT_ACCEPTED_MESSAGE = ".//h3[text() = 'Payment successful']/following-sibling::p";
    private static final String PYMENT_ACCEPTED = ".//h3[text() = 'Payment successful']";
    private static final String NEXT_BUTTON = "//button/span[text() = 'Next']";
    private static final String DOWNLOAD_PYMENT = "//div[contains(@class, 'section_actions')]//span[text() = 'Download']";

    public PaymentPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public Map<String, String> getMappedValues() {
        Map<String, String> paymentDetails = new HashMap<>();
        findAll(DETAILS).forEach(detail -> paymentDetails.put(substringBefore(detail.getText(), SEPARATOR), substringAfter(detail.getText(), SEPARATOR)));
        return paymentDetails;
    }

    public void clickSubmitPaymentButton() {
        waitABit(2000);
        findBy(SUBMIT_PYMENT).click();
        waitForAbsenceOf(SUBMIT_PYMENT);
    }

    public String getPymentAcceptedMessage() {
        waitForPresenceOf(PYMENT_ACCEPTED_MESSAGE);
        return findBy(PYMENT_ACCEPTED_MESSAGE).getText();
    }

    public boolean isPaymentAccepted() {
        waitForPresenceOf(PYMENT_ACCEPTED);
        return isElementPresent(PYMENT_ACCEPTED);
    }

    public boolean isDownloadPaymentPresent() {
        waitForPresenceOf(DOWNLOAD_PYMENT);
        return isElementPresent(DOWNLOAD_PYMENT);
    }

    public boolean isNextButtonPresent() {
        return isElementPresent(NEXT_BUTTON);
    }

    //sp23

    private static final String SUBMIT_INVOICE_PAYMENT = ".//button/span[text() = 'Download Invoice *']";

    public void clickSubmitInvoicePaymentButton() {
        waitABit(2000);
        scrollToElement(SUBMIT_INVOICE_PAYMENT);
        findBy(SUBMIT_INVOICE_PAYMENT).click();
        waitABit(200);
    }
}
