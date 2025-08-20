package com.hhstechgroup.ui.panels.peportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class ClaimsBlock extends AbstractPanel {

    private static final String TABLE = ".//table";
    private static final String TCN = ".//a[contains(@href, 'claims') and text() = '%s']";
    private static final String PROVIDER_NAME_ID = ".//a[contains(@href, 'provider') and contains(text(), '%s')]";

    public ClaimsBlock(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public List<Map<String, String>> getClaimsTable() {
       return new Table(findBy(TABLE), getBasePage()).getListOfMappedValues();
    }

    public void clickOnClaimWithTcn(String tcn) {
        findBy(format(TCN, tcn)).click();
    }

    public void clickOnProviderWithId(String id) {
        findBy(format(PROVIDER_NAME_ID, id)).click();
    }
}
