package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class ConcactPersonDetailsPanel extends BaseEnrollmentPanel{
private static final String BILLING_COONTACT_DETAILS="//label[contains(text(),'Is Billing Address Contact Person Details')]/../..//div//input[@value='%s']";
    private final static String FIRST_NAME = ".//label[contains(text(), 'First Name')]/parent::div//input";
    private final static String MI = ".//label[contains(text(), 'Middle Name')]/parent::div//input";
    private final static String LAST_NAME = ".//label[contains(text(), 'Last Name')]/parent::div//input";
    private final static String PHONE = ".//label[contains(text(), 'Phone')]/parent::div//input";
    private final static String EXT = ".//label[contains(text(), 'Ext')]/parent::div//input";
    private final static String FAX = ".//label[contains(text(), 'Fax')]/parent::div//input";
    private final static String EMAIL = ".//label[contains(text(), 'Email')]/parent::div//input";
    //sp20
    private final static String POSITION = ".//label[contains(text(), 'Position')]/parent::div//input";

    public ConcactPersonDetailsPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    public void setPhone(String phone) {
        waitABit(200);
        findBy(PHONE).type(phone);
        findBy(PHONE).type(phone);
        waitABit(200);
    }
    public void setFirstName(String firstName) {
        waitABit(200);
        findBy(FIRST_NAME).type(firstName);
        findBy(FIRST_NAME).type(firstName);
        waitABit(200);

    }
    public void billingContactDetails(String billingContactDetails){
        waitABit(500);
//        selectRadionButton(BILLING_COONTACT_DETAILS,billingContactDetails);
        scrollToElement(format(BILLING_COONTACT_DETAILS, billingContactDetails));
        waitABit(500);
        findBy(format(BILLING_COONTACT_DETAILS, billingContactDetails)).click();
        waitABit(500);
    }

    public void setMi(String mi) {
        findBy(MI).type(mi);
    }

    public void setLastName(String lastName) {
        waitABit(200);
        findBy(LAST_NAME).type(lastName);
        findBy(LAST_NAME).type(lastName);
        waitABit(200);
    }
   //sp20
    public void setExt(String ext) {
        findBy(EXT).type(ext);
        waitABit(200);
    }

    public void setFax(String fax) {
        findBy(FAX).type(fax);
        waitABit(200);
    }

    public void setEmail(String email) {
        waitABit(200);
        findBy(EMAIL).sendKeys(email);
        waitABit(200);
        findBy("//*").click();
    }

    public void setPosition(String position) {
        findBy(POSITION).click();
        selectFromDropDown(position);
    }

    private static final String ATTENTION_LINE = ".//label[contains(text(), 'Attention Line')]/parent::div//input";

    public void setAttentionLine(String attentionLine) {
        waitABit(200);
        findBy(ATTENTION_LINE).sendKeys(attentionLine);
        waitABit(1000);
    }

}
