package com.hhstechgroup.ui.panels.enrollment.electronictransactionsubmission;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class ElectronicTransactionSubmissionPanel extends BaseEnrollmentPanel {

    private static final String IS_THIRD_PARTY_SUBMIT_CLAIMS = "hird party billing";
    private static final String SUBMIT_RECEIVE = ".//div[h4[contains(text() , 'Billing software')]]/following-sibling::div//div//fieldset//span[text() = '%s']/preceding-sibling::span//input";
    private static final String SOFTWARE_SUBMIT_RECEIVE = ".//div[h4[contains(text() , 'Clearing house')]]/following-sibling::div//div//fieldset//span[text() = '%s']/preceding-sibling::span//input";
    private static final String BILLNG_SOFTWARE_TABLE = ".//div[h4[contains(text() , 'Billing software')]]/following-sibling::div//div[table]/ancestor::div[2]";
    private static final String CLEARING_HOUSE_TABLE = ".//div[h4[contains(text() , 'Clearing house')]]/following-sibling::div//div[table]/ancestor::div[2]";

    public ElectronicTransactionSubmissionPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public BillingAddressTable getBillingAddressTable() {
        scrollToElement(BILLNG_SOFTWARE_TABLE);
        return new BillingAddressTable(findBy(BILLNG_SOFTWARE_TABLE), getBasePage());
    }

    public ClearingHouseTable getClearingHouseTable() {
        scrollToElement(CLEARING_HOUSE_TABLE);
        return new ClearingHouseTable(findBy(CLEARING_HOUSE_TABLE), getBasePage());
    }

    public void setIsThirdPartySubmitClaims(String isThirdPartySubmitClaims) {
        selectRadionButton(IS_THIRD_PARTY_SUBMIT_CLAIMS, isThirdPartySubmitClaims);
    }

    public void setSubmit(String submit) {
        clickOn(String.format(SUBMIT_RECEIVE, submit));
    }

    public void setReceive(String receive) {
        clickOn(String.format(SUBMIT_RECEIVE, receive));
    }

    public void setSoftwareSubmit(String softwareSubmit) {
        clickOn(String.format(SOFTWARE_SUBMIT_RECEIVE, softwareSubmit));
    }

    public void setSoftwareReceive(String softwareReceive) {
        clickOn(String.format(SOFTWARE_SUBMIT_RECEIVE, softwareReceive));
    }
}
