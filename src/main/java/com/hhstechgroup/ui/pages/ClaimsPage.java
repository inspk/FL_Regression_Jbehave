package com.hhstechgroup.ui.pages;

import com.hhstechgroup.ui.panels.peportal.*;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class ClaimsPage extends ProviderManagementBasePage {

    private static final String CLAIMS_SEARCH = ".//div[contains(@class, 'search-box')]";
    private static final String CLAIM_DETAILS = ".//div[contains(@class, 'details_panel')]";
    private static final String RECORDS = ".//div[contains(@class, 'tile-table-head')]/parent::div";
    private static final String LEFT_MENU_SECTION = ".//*[contains(@class, 'details_claim-nav')]//a[text() = '%s']";
    private static final String MEMBER_DATA = ".//div[text() = 'Member Data']/following-sibling::div";
    private static final String PROVIDER_DATA = ".//div[text() = 'Provider Data']/following-sibling::div";
    private static final String PAYMENT_DATA = ".//div[text() = 'Payment Data']/following-sibling::div";
    private static final String PAYER_DATA = ".//div[text() = 'Payer Data']/following-sibling::div";
    private static final String RECEIVER_DATA = ".//div[contains(text(), 'Receiver Data')]/following-sibling::div";

    public ClaimsPage(WebDriver driver) {
        super(driver);
    }

    public Map<String, String> getClaimDetails() {
        return new MainInfoBlock(findBy(CLAIM_DETAILS), this).getClaimMappedValues();
    }

    public boolean isSearchPanelPresent() {
        return isElementPresent(CLAIMS_SEARCH);
    }

    public SearchForRecordPanel getSearchPanel() {
        return new SearchForRecordPanel(findBy(CLAIMS_SEARCH), this);
    }

    public RecordsPanel getRecords() {waitAbit(8000);
        return new RecordsPanel(findBy(RECORDS), this);
    }

    public void clickOnLeftMenuSection(String section) {
        findBy(String.format(LEFT_MENU_SECTION, section)).click();
    }

    public Map<String, String> getMemberData() {
        waitForPresenceOf(MEMBER_DATA);
        waitAbit(2000);
        return new FieldsValues(findBy(MEMBER_DATA), this).getMappedValues();
    }

    public Map<String, String> getProviderData() {
        return new FieldsValues(findBy(PROVIDER_DATA), this).getMappedValues();
    }

    public Map<String, String> getPaymentData() {
        return new FieldsValues(findBy(PAYMENT_DATA), this).getMappedValues();
    }

    public Map<String, String> getPayerData() {
        return new FieldsValues(findBy(PAYER_DATA), this).getMappedValues();
    }

    public Map<String, String> getReceiverData() {
        return new FieldsValues(findBy(RECEIVER_DATA), this).getMappedValues();
    }
}
