package com.hhstechgroup.ui.panels.systemoptions;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class PaymentFeesPanel extends AbstractPanel {

    //private static final String IE_PAYMENT_FEES = ".//input[contains(@id,'provider-amount')]";
    //private static final String GE_PAYMENT_FEES = ".//input[contains(@id,'provider_group-amount')]";

    //sp43
    private static final String IE_PAYMENT_FEES = "(.//input[contains(@id,'provider-amount')])[1]";
    private static final String GE_PAYMENT_FEES = "(.//input[contains(@id,'provider_group-amount')])[1]";
    private static final String TP_PAYMENT_FEES = "(.//input[contains(@id,'trading_partner-amount')])[1]";

    public PaymentFeesPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setIndividualPaymentFees(String individualPaymentFees) {
        scrollToElement(IE_PAYMENT_FEES);
        findBy(IE_PAYMENT_FEES).click();
        findBy(IE_PAYMENT_FEES).clear();
        findBy(IE_PAYMENT_FEES).type(individualPaymentFees);
        waitABit(200);
    }

    public void setGroupPaymentFees(String groupPaymentFees) {
        waitABit(200);
        scrollToElement(GE_PAYMENT_FEES);
        findBy(GE_PAYMENT_FEES).click();
        findBy(GE_PAYMENT_FEES).clear();
        findBy(GE_PAYMENT_FEES).type(groupPaymentFees);
        waitABit(200);
    }

    public void setTpPaymentFees(String tpPaymentFees) {
        waitABit(200);
        scrollToElement(TP_PAYMENT_FEES);
        findBy(TP_PAYMENT_FEES).click();
        findBy(TP_PAYMENT_FEES).clear();
        findBy(TP_PAYMENT_FEES).type(tpPaymentFees);
        waitABit(200);
    }

    //sp20
//    private static final String INSTATE_PAYMENT_FEES = "(.//div/input[contains(@id,'institutional_provider-amount')])[1]";
    //sp43
    private static final String INDIVIDUAL_INSTATE_PAYMENT_FEES = "(.//input[contains(@id,'provider-amount')])[2]";

    public void setInStatePaymentFees(String inStatePaymentFees) {
        waitABit(200);
        scrollToElement(INDIVIDUAL_INSTATE_PAYMENT_FEES);
        findBy(INDIVIDUAL_INSTATE_PAYMENT_FEES).click();
        findBy(INDIVIDUAL_INSTATE_PAYMENT_FEES).clear();
        findBy(INDIVIDUAL_INSTATE_PAYMENT_FEES).type(inStatePaymentFees);
        waitABit(200);
    }

    // private static final String OUTSTATE_PAYMENT_FEES = "(.//div/input[contains(@id,'institutional_provider-amount')])[2]";
    //sp43
    private static final String INDIVIDUAL_OUTSTATE_PAYMENT_FEES = "(.//input[contains(@id,'provider-amount')])[3]";

    public void setOutStatePaymentFees(String outStatePaymentFees) {
        waitABit(200);
        scrollToElement(INDIVIDUAL_OUTSTATE_PAYMENT_FEES);
        findBy(INDIVIDUAL_OUTSTATE_PAYMENT_FEES).click();
        findBy(INDIVIDUAL_OUTSTATE_PAYMENT_FEES).clear();
        findBy(INDIVIDUAL_OUTSTATE_PAYMENT_FEES).type(outStatePaymentFees);
        waitABit(200);
    }

    //sp23

    private static final String PAYMENT_CHECKBOX = ".//span[contains(text(),'%s')]/..//input[contains(@type,'radio')]";
    private static final String PAYMENT_RECIEVED_TIME = ".//label[text()='Date Payment received']//ancestor::div[contains(@class, 'styles_datepicker')]//input";
    private static final String PAYMENT_NOTE = ".//label[contains(text(), 'Note')]/../div/div/textarea[3]";
    private static final String VERIFY_BUTTON = ".//div/button/span[text()='Verify']";

    public void setPaymentCheckbox(String paymentCheckbox) {
        waitABit(100);
        findBy(format(PAYMENT_CHECKBOX, paymentCheckbox)).click();
        waitABit(200);
    }


    public void setPaymentRecievedTime(String paymentRecievedTime) {
        jsClick(PAYMENT_RECIEVED_TIME);
        findBy(PAYMENT_RECIEVED_TIME).sendKeys(paymentRecievedTime);

    }

    public void setPaymentNote(String paymentNote) {
        waitABit(200);
        findBy(PAYMENT_NOTE).type(paymentNote);
        waitABit(500);
        jsClick(VERIFY_BUTTON);
    }

    //sp28

    private static final String ORP_PAYMENT_FEES = "(.//input[contains(@id,'orp-amount')])[1]";
    private static final String PHARMACY_PAYMENT_FEES = "(.//input[contains(@id,'pharmacy-amount')])[1]";
    private static final String PEM_PAYMENT_FEES = "(.//input[contains(@id,'provider_enrollment_manager-amount')])[1]";
    private static final String FACILITY_PAYMENT_FEES = "(.//input[contains(@id,'facility-amount')])[1]";


    public void setOrpPaymentFees(String orpPaymentFees) {
        scrollToElement(ORP_PAYMENT_FEES);
        findBy(ORP_PAYMENT_FEES).click();
        findBy(ORP_PAYMENT_FEES).clear();
        findBy(ORP_PAYMENT_FEES).type(orpPaymentFees);
        waitABit(200);

    }

    public void setPharmacyPaymentFees(String pharmacyPaymentFees) {
        scrollToElement(PHARMACY_PAYMENT_FEES);
        findBy(PHARMACY_PAYMENT_FEES).click();
        findBy(PHARMACY_PAYMENT_FEES).clear();
        findBy(PHARMACY_PAYMENT_FEES).type(pharmacyPaymentFees);
        waitABit(200);

    }

    public void setPemPaymentFees(String pemPaymentFees) {
        scrollToElement(PEM_PAYMENT_FEES);
        findBy(PEM_PAYMENT_FEES).click();
        findBy(PEM_PAYMENT_FEES).clear();
        findBy(PEM_PAYMENT_FEES).type(pemPaymentFees);
        waitABit(200);

    }

    public void setFacilityPaymentFees(String facilityPaymentFees) {
        scrollToElement(FACILITY_PAYMENT_FEES);
        findBy(FACILITY_PAYMENT_FEES).click();
        findBy(FACILITY_PAYMENT_FEES).clear();
        findBy(FACILITY_PAYMENT_FEES).type(facilityPaymentFees);
        waitABit(200);

    }

    //sp43
    private static final String GROUP_INSTATE_PAYMENT_FEES = "(.//input[contains(@id,'provider_group-amount')])[2]";
    private static final String GROUP_OUTSTATE_PAYMENT_FEES = "(.//input[contains(@id,'provider_group-amount')])[3]";
    public void setGroupinStatePaymentFees(String groupinStatePaymentFees) {
        waitABit(200);
        scrollToElement(GROUP_INSTATE_PAYMENT_FEES);
        findBy(GROUP_INSTATE_PAYMENT_FEES).click();
        findBy(GROUP_INSTATE_PAYMENT_FEES).clear();
        findBy(GROUP_INSTATE_PAYMENT_FEES).type(groupinStatePaymentFees);
        waitABit(200);
    }

    public void setGroupoutStatePaymentFees(String groupoutStatePaymentFees) {
        waitABit(200);
        scrollToElement(GROUP_OUTSTATE_PAYMENT_FEES);
        findBy(GROUP_OUTSTATE_PAYMENT_FEES).click();
        findBy(GROUP_OUTSTATE_PAYMENT_FEES).clear();
        findBy(GROUP_OUTSTATE_PAYMENT_FEES).type(groupoutStatePaymentFees);
        waitABit(200);

    }

    private static final String FACILITY_INSTATE_PAYMENT_FEES = "(.//input[contains(@id,'facility-amount')])[2]";
    private static final String FACILITY_OUTSTATE_PAYMENT_FEES = "(.//input[contains(@id,'facility-amount')])[3]";
    public void setFacilityinStatePaymentFees(String facilityinStatePaymentFees) {
        waitABit(200);
        scrollToElement(FACILITY_INSTATE_PAYMENT_FEES);
        findBy(FACILITY_INSTATE_PAYMENT_FEES).click();
        findBy(FACILITY_INSTATE_PAYMENT_FEES).clear();
        findBy(FACILITY_INSTATE_PAYMENT_FEES).type(facilityinStatePaymentFees);
    }
    public void setFacilityoutStatePaymentFees(String facilityoutStatePaymentFees) {
        waitABit(200);
        scrollToElement(FACILITY_OUTSTATE_PAYMENT_FEES);
        findBy(FACILITY_OUTSTATE_PAYMENT_FEES).click();
        findBy(FACILITY_OUTSTATE_PAYMENT_FEES).clear();
        findBy(FACILITY_OUTSTATE_PAYMENT_FEES).type(facilityoutStatePaymentFees);
    }
    private static final String PHARMACY_INSTATE_PAYMENT_FEES = "(.//input[contains(@id,'pharmacy-amount')])[2]";
    private static final String PHARMACY_OUTSTATE_PAYMENT_FEES = "(.//input[contains(@id,'pharmacy-amount')])[3]";
    public void setPharmacyinStatePaymentFees(String pharmacyinStatePaymentFees) {
        waitABit(200);
        scrollToElement(PHARMACY_INSTATE_PAYMENT_FEES);
        findBy(PHARMACY_INSTATE_PAYMENT_FEES).click();
        findBy(PHARMACY_INSTATE_PAYMENT_FEES).clear();
        findBy(PHARMACY_INSTATE_PAYMENT_FEES).type(pharmacyinStatePaymentFees);
    }
    public void setPharmacyoutStatePaymentFees(String pharmacyoutStatePaymentFees) {
        waitABit(200);
        scrollToElement(PHARMACY_OUTSTATE_PAYMENT_FEES);
        findBy(PHARMACY_OUTSTATE_PAYMENT_FEES).click();
        findBy(PHARMACY_OUTSTATE_PAYMENT_FEES).clear();
        findBy(PHARMACY_OUTSTATE_PAYMENT_FEES).type(pharmacyoutStatePaymentFees);
    }

    private static final String PEM_INSTATE_PAYMENT_FEES = "(.//input[contains(@id,'provider_enrollment_manager-amount')])[2]";
    private static final String PEM_OUTSTATE_PAYMENT_FEES = "(.//input[contains(@id,'provider_enrollment_manager-amount')])[3]";
    public void setPeminStatePaymentFees(String peminStatePaymentFees)  {
        waitABit(200);
        scrollToElement(PEM_INSTATE_PAYMENT_FEES);
        findBy(PEM_INSTATE_PAYMENT_FEES).click();
        findBy(PEM_INSTATE_PAYMENT_FEES).clear();
        findBy(PEM_INSTATE_PAYMENT_FEES).type(peminStatePaymentFees);
    }
    public void setPemoutStatePaymentFees(String pemoutStatePaymentFees) {
        waitABit(200);
        scrollToElement(PEM_OUTSTATE_PAYMENT_FEES);
        findBy(PEM_OUTSTATE_PAYMENT_FEES).click();
        findBy(PEM_OUTSTATE_PAYMENT_FEES).clear();
        findBy(PEM_OUTSTATE_PAYMENT_FEES).type(pemoutStatePaymentFees);
    }

    private static final String TP_INSTATE_PAYMENT_FEES = "(.//input[contains(@id,'trading_partner-amount')])[2]";
    private static final String TP_OUTSTATE_PAYMENT_FEES = "(.//input[contains(@id,'trading_partner-amount')])[3]";
    public void setOrpinStatePaymentFees(String tpinStatePaymentFees)  {
        waitABit(200);
        scrollToElement(TP_INSTATE_PAYMENT_FEES);
        findBy(TP_INSTATE_PAYMENT_FEES).click();
        findBy(TP_INSTATE_PAYMENT_FEES).clear();
        findBy(TP_INSTATE_PAYMENT_FEES).type(tpinStatePaymentFees);
    }
    public void setOrpoutStatePaymentFees(String tpoutStatePaymentFees) {
        waitABit(200);
        scrollToElement(PEM_OUTSTATE_PAYMENT_FEES);
        findBy(TP_OUTSTATE_PAYMENT_FEES).click();
        findBy(TP_OUTSTATE_PAYMENT_FEES).clear();
        findBy(TP_OUTSTATE_PAYMENT_FEES).type(tpoutStatePaymentFees);
    }
}
