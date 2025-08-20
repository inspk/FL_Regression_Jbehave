package com.hhstechgroup.ui.pages.peportal;

import com.hhstechgroup.ui.pages.ClaimsPage;
import com.hhstechgroup.ui.panels.claim.BasicLineItemInformationPanel;
import com.hhstechgroup.ui.panels.pedashboard.SuccessPanel;
import com.hhstechgroup.ui.panels.peportal.*;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class ClaimsPagePe extends ClaimsPage {

    private static final String ADJUSTMENT_REASON_CODES = ".//div[contains(text(),  'Adjustment')]/following-sibling::table";
    private static final String REMARK_CODES = ".//div[contains(text(),  'Remark ')]/following-sibling::table";
    private static final String LINE_ITEM = ".//h2[text() = 'Line item']/following-sibling::div";
    private static final String LINE_ITEM_HEADER = ".//div[contains(@class, '_head_')]//div[span]";
    private static final String LINE_ITEM_ROWS = ".//ul[contains(@class, 'details_table-body')]/div//div[contains(@class, 'details_row_')]";
    private static final String LINE_ITEM_CELLS = "div[span]";
    private static final String CLAIMS = ".//div[contains(@class, 'list-table_')]";
    private static final String CLAIMS_COLUMNS = ".//div[contains(@class, 'head_')]//div[span[string-length(text()) > 0]]";
    private static final String CLAIMS_ROWS = ".//div[contains(@class, 'table-body')]//div[contains(@class, 'row')]";
    private static final String CLAIMS_CELLS = ".//div/following-sibling::span";
    private static final String CREATE_CLAIM = ".//button[span[text() = 'Create claim']]";
    private static final String CONTINUE_BUTTON = ".//button[span[text() = 'CONTINUE']]";
    private static final String PROFESSIONAL_CLAIM = "Professional claim";
    private static final String SECTION = ".//div[contains(@class, 'menu_side-bar')]";
    private static final String SUCCESS_PANEL = ".//p[text() = 'Success!']/parent::div";
    private static final String BASIC_LINE_ITEM_INFORMATION_PANEL = "//h3[contains(text(), 'Basic line item information')]/ancestor::div[3]";

    public ClaimsPagePe(WebDriver driver) {
        super(driver);
    }

    public List<Map<String, String>> getAdjustmentReasonCodes() {
        return new Table(findBy(ADJUSTMENT_REASON_CODES), this).getListOfMappedValues();
    }

    public List<Map<String, String>> getRemarkCodes() {
        return new Table(findBy(REMARK_CODES), this).getListOfMappedValues();
    }

    public List<Map<String, String>> getLineItems() {
        return new Table(findBy(LINE_ITEM), this, LINE_ITEM_HEADER, LINE_ITEM_ROWS, LINE_ITEM_CELLS).getListOfMappedValues();
    }

    public List<Map<String, String>> getClaim() {
        return new Table(findBy(CLAIMS), this, CLAIMS_COLUMNS, CLAIMS_ROWS, CLAIMS_CELLS).getListOfMappedValues();
    }

    public void clickCreateProfessionalClaimButton() {
        findBy(CREATE_CLAIM).click();
        selectFromDropDown(PROFESSIONAL_CLAIM);
        waitForPresenceOf(SECTION);
    }

    public void clickContinueButton() {
        findBy(CONTINUE_BUTTON).click();
        waitForPresenceOf(SECTION);
    }

    public SuccessPanel getSuccessPanel() {
        return new SuccessPanel(findBy(SUCCESS_PANEL), this);
    }

    public BasicLineItemInformationPanel getBasicLineItemInformationPanel() {
        return new BasicLineItemInformationPanel(findBy(BASIC_LINE_ITEM_INFORMATION_PANEL), this);
    }
}
