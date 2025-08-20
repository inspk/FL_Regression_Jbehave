package com.hhstechgroup.ui.pages.iuportal;

import com.hhstechgroup.ui.pages.ClaimsPage;
import com.hhstechgroup.ui.panels.peportal.Table;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class ClaimsPageIu extends ClaimsPage {

    private static final String ADJUSTMENT_REASON_CODES = ".//div[contains(text(),  'Adjustment')]/following-sibling::table[contains(@class, 'details_claim-table_')]";
    private static final String REMARK_CODES = ".//div[contains(text(),  'Remark ')]/following-sibling::table[contains(@class, 'details_claim-table_')]";
    private static final String LINE_ITEM = ".//h2[text() = 'Line item']/following-sibling::div";
    private static final String LINE_ITEM_HEADER = ".//div[contains(@class, '_head_')]//div[span]";
    private static final String LINE_ITEM_ROWS = ".//ul[contains(@class, 'details_table-body')]/div//div[contains(@class, 'details_row_')]";
    private static final String LINE_ITEM_CELLS = "div[span]";

    public ClaimsPageIu(WebDriver driver) {
        super(driver);
    }

    public List<Map<String, String>> getLineItems() {
        waitAbit(2000);
        waitForPresenceOf(LINE_ITEM);
        return new Table(findBy(LINE_ITEM), this, LINE_ITEM_HEADER, LINE_ITEM_ROWS, LINE_ITEM_CELLS).getListOfMappedValues();
    }

    public List<Map<String, String>> getAdjustmentReasonCodes() { scrollToElement(ADJUSTMENT_REASON_CODES);
        return new Table(findBy(ADJUSTMENT_REASON_CODES), this).getListOfMappedValues();
    }

    public List<Map<String, String>> getRemarkCodes() { scrollToElement(REMARK_CODES);
        return new Table(findBy(REMARK_CODES), this).getListOfMappedValues();
    }
}
