package com.hhstechgroup.ui.pages.peportal;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.peportal.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class PaymentsPage extends ProviderManagementBasePage {

    private static final String PAYMENTS_SEARCH = ".//div[contains(@class, 'search-box')]";
    private static final String RECORDS = ".//div[contains(@class, 'tile-table-head')]/parent::div";
    private static final String PAYMENT_ID_BLOCK = "//div[contains(@class, 'details_panel')]";
    private static final String CLAIMS_BLOCK = ".//div[contains(@class, 'white-box-title') and  text() = 'Claims']/parent::div";
    private static final String FINANCIAL_INFORMATION_BLOCK = ".//div[contains(@class, 'white-box-title') and  text() = 'Financial information']/parent::div";
    private static final String ORIGINATING_INSTITUTION_BLOCK = ".//div[contains(@class, 'white-box-title') and  text() = 'Originating institution']/parent::div";

    public PaymentsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchPanelPresent() {
        return isElementPresent(PAYMENTS_SEARCH);
    }

    public SearchForRecordPanel getSearchPanel() {
        return new SearchForRecordPanel(findBy(PAYMENTS_SEARCH), this);
    }

    public RecordsPanel getRecords() {
        return new RecordsPanel(findBy(RECORDS), this);
    }

    public MainInfoBlock getPaymentIdBlock() {
        return new MainInfoBlock(findBy(PAYMENT_ID_BLOCK), this);
    }

    public ClaimsBlock getClaimsBlock() {
        return new ClaimsBlock(findBy(CLAIMS_BLOCK), this);
    }

    public FinancialInformationBlock getFinancialInformationBlock() {
        return new FinancialInformationBlock(findBy(FINANCIAL_INFORMATION_BLOCK), this);
    }

    public OriginatingInstitutionBlock getOriginatingInstitutionBlock() {
        return new OriginatingInstitutionBlock(findBy(ORIGINATING_INSTITUTION_BLOCK), this);
    }

    //adding sp21 to Verify instate and Outstate Payment
    //private static final String PAYMENT = ".//div[@class='price']//span[contains(text(),'%s')]";

    //adding sp35 to Verify instate and Outstate  for new Payment tool
    private static final String PAYMENT = ".//div[contains(@class,'ProductSummary')]//span[contains(text(),'%s')]";

//sp26
    //private static final String PAYMENT =  ".//h3[contains(text(),'Payment')]/..//b[contains(text(),'')]" ;

    public boolean validatePayment(String payment) {
        waitAbit(200);
        scrollToElement(format(PAYMENT, payment));
        waitAbit(200);
       return isElementPresent(format(PAYMENT, payment));
    }

    //sp23

    //private static final String ENABLE_AND_DISABLE_PAYMENT_CHECKBOX = ".//h3[contains(text(),'%s')]/../../../..//input[contains(@aria-label,'Enable Online Payment')]";
      private static final String ENABLE_AND_DISABLE_PAYMENT_CHECKBOX = ".//h3[contains(text(),'%s')]/../../../../..//input[contains(@aria-label,'Enable Online Payment')]" ;

    public void enableAndDisablePaymentCheckbox(String checkbox){
        scrollToElement(format(ENABLE_AND_DISABLE_PAYMENT_CHECKBOX,checkbox));
        waitAbit(100);
        jsClick(format(ENABLE_AND_DISABLE_PAYMENT_CHECKBOX,checkbox));
        waitAbit(100);
    }

    private static final String ENABLE_AND_DISABLE_INSTATE_PAYMENT_CHECKBOX = "(.//h3[contains(text(),'In-State')]/../../../..//input[contains(@aria-label,'Enable Online Payment')])[1]";

    public void enableAndDisableInstatePaymentCheckbox(){
        scrollToElement(ENABLE_AND_DISABLE_INSTATE_PAYMENT_CHECKBOX);
        waitAbit(100);
        jsClick(format(ENABLE_AND_DISABLE_INSTATE_PAYMENT_CHECKBOX));
        waitAbit(100);
    }


    private static final String ENABLE_AND_DISABLE_OUTSTATE_PAYMENT_CHECKBOX = "(.//h3[contains(text(),'Out-State')]/../../../..//input[contains(@aria-label,'Enable Online Payment')])[2]";

    public void enableAndDisableOutstatePaymentCheckbox(){
        scrollToElement(ENABLE_AND_DISABLE_OUTSTATE_PAYMENT_CHECKBOX);
        waitAbit(100);
        jsClick(format(ENABLE_AND_DISABLE_OUTSTATE_PAYMENT_CHECKBOX));
        waitAbit(100);
    }

    private static final String INVOICE_PAYMENT = ".//form//button/span[text() = '%s']";

    public boolean validateInvoicePayment(String invoicepayment) {
        waitAbit(200);
        scrollToElement(format(INVOICE_PAYMENT,invoicepayment));
        waitAbit(200);
        return isElementPresent(format(INVOICE_PAYMENT,invoicepayment));
    }

//sp28

    private static final String INDIVIDUAL_PROVIDER_DATE = ".//span[contains(text(),'Collect Fees For Individual Provider Enrollment')]/../..//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;
    private static final String GROUP_PROVIDER_DATE = ".//span[contains(text(),'Collect Fees For Group Provider Enrollment')]/../..//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;
    private static final String ORP_PROVIDER_DATE = ".//span[contains(text(),'Collect Fees For Ordering/Referring/Prescribing Provider Enrollment')]/../..//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;
    private static final String PEM_PROVIDER_DATE = ".//span[contains(text(),'Collect Fees For Provider Enrollment Manager Enrollment')]/../..//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;
   // private static final String PHARMACY_PROVIDER_DATE = ".//span[contains(text(),'Collect Fees For Pharmacy Provider Enrollment')]/../..//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;
    //sp39.2
    private static final String PHARMACY_PROVIDER_DATE = ".//span[contains(text(),'Collect Fees For Pharmacy Enrollment')]/../..//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;
    private static final String FACILITY_PROVIDER_DATE = ".//span[contains(text(),'Collect Fees For Facility Provider Enrollment')]/../..//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;
    private static final String INSTITUTIONAL_PROVIDER_DATE = ".//span[contains(text(),'Collect Fees For Institutional Provider Enrollment')]/../..//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;

    public void setIndividualProviderDate(String individualProviderDate) {
        scrollToElement(INDIVIDUAL_PROVIDER_DATE);
        jsClick(INDIVIDUAL_PROVIDER_DATE);
        findBy(format(INDIVIDUAL_PROVIDER_DATE,individualProviderDate)).sendKeys(individualProviderDate);

    }

    public void setGroupProviderDate(String groupProviderDate) {
        scrollToElement(GROUP_PROVIDER_DATE);
        jsClick(GROUP_PROVIDER_DATE);
        findBy(format(GROUP_PROVIDER_DATE,groupProviderDate)).sendKeys(groupProviderDate);

    }

    public void setOrpProviderDate(String orpProviderDate) {
        scrollToElement(ORP_PROVIDER_DATE);
        jsClick(ORP_PROVIDER_DATE);
        findBy(format(ORP_PROVIDER_DATE,orpProviderDate)).sendKeys(orpProviderDate);

    }

    public void setPemProviderDate(String pemProviderDate) {
        scrollToElement(PEM_PROVIDER_DATE);
        jsClick(PEM_PROVIDER_DATE);
        findBy(format(PEM_PROVIDER_DATE,pemProviderDate)).sendKeys(pemProviderDate);

    }

    public void setPharmacyProviderDate(String pharmacyProviderDate) {
        scrollToElement(PHARMACY_PROVIDER_DATE);
        jsClick(PHARMACY_PROVIDER_DATE);
        findBy(format(PHARMACY_PROVIDER_DATE,pharmacyProviderDate)).sendKeys(pharmacyProviderDate);

    }

    public void setFacilityProviderDate(String facilityProviderDate) {
        scrollToElement(FACILITY_PROVIDER_DATE);
        jsClick(FACILITY_PROVIDER_DATE);
        findBy(format(FACILITY_PROVIDER_DATE,facilityProviderDate)).sendKeys(facilityProviderDate);

    }

    public void setInstitutionalProviderDate(String institutionalProviderDate) {
        scrollToElement(INSTITUTIONAL_PROVIDER_DATE);
        jsClick(INSTITUTIONAL_PROVIDER_DATE);
        findBy(format(INSTITUTIONAL_PROVIDER_DATE,institutionalProviderDate)).sendKeys(institutionalProviderDate);

    }
    //sp43
    private static final String CLICK_EDIT_BUTTON = ".//div//span[text()='%s']/../../..//following-sibling::div[2]//span[text()='Edit']" ;
    public void clickPaymentFeesEditButton(String editbutton) {
        scrollToElement(format(CLICK_EDIT_BUTTON,editbutton));
        waitAbit(200);
        findBy(format(CLICK_EDIT_BUTTON,editbutton)).click();
    }
    private static final String EFFECTIVE_START_DATE = ".//label[text()='Effective start *']//ancestor::div[contains(@class, 'effectivedatepicker')]//input" ;
    public void setEffectiveStartDate(String effectiveStartDate) {
        scrollToElement(EFFECTIVE_START_DATE);
        jsClick(EFFECTIVE_START_DATE);
        findBy(format(EFFECTIVE_START_DATE,effectiveStartDate)).sendKeys(effectiveStartDate);
    }
}
