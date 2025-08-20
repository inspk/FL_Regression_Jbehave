package com.hhstechgroup.ui.panels.peportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class RecordsPanel extends AbstractPanel {

    private static final String RECORD_BY_VALUE = ".//p[text() = '%s']";

    public RecordsPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void clickOnRecordWithValue(String value) {waitABit(5000);
        scrollToElement(format(RECORD_BY_VALUE, value));
        findBy(format(RECORD_BY_VALUE, value)).click();
    }
}
