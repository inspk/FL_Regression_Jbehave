package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.pages.enrollment.EnrollmentPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class EFTInformationPanel extends BaseEnrollmentPanel {


    public EFTInformationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    private static final String FINANCIAL_INSTITUTION = ".//label[contains(text(), 'Name of the Financial Institution')]/following-sibling::div//input";
    public void setFinancialInstitution(String financialInstitution) {
        waitABit(200);
        findBy(FINANCIAL_INSTITUTION).clear();
        findBy(FINANCIAL_INSTITUTION).type(financialInstitution);
        waitABit(200);
    }

    private static final String ROUTING_NUMBER = ".//label[contains(text(), 'Routing Number of EFT')]/following-sibling::div//input";
    public void setEFTRoutingNumber(String EFTRoutingNumber) {
        waitABit(200);
        findBy(ROUTING_NUMBER).type(EFTRoutingNumber);
        waitABit(200);
    }

    private static final String ACCOUNT_NUMBER = ".//label[contains(text(), 'Account Number')]/following-sibling::div//input";
    public void setAccountNumber(String accountNumber) {
        waitABit(200);
        findBy(ACCOUNT_NUMBER).sendKeys(accountNumber);
        waitABit(200);
    }

    private static final String ACCOUNT_TYPE = ".//div[@data-for='Account Type']";
    private static final String SELECT_ACCOUNT_TYPE = "//div//ul//li[@data-value='%s']";
    public void setAccountType(String accountType) {
        waitABit(100);
        findBy(ACCOUNT_TYPE).click();
        waitABit(1000);
        scrollToElement(format(SELECT_ACCOUNT_TYPE, accountType));
        findBy(format(SELECT_ACCOUNT_TYPE, accountType)).click();
//        jsClick(format(SELECT_ACCOUNT_TYPE, accountType));
        waitABit(3000);
    }

    private static final String START_DATE = ".//label[contains(text() , 'Start Date')]/following-sibling::div/input";
    public void setStartDate(String startDate) {
        waitABit(2000);
        jsClick(START_DATE);
        findBy(START_DATE).clear();
        waitABit(3000);
        findBy(START_DATE).sendKeys(startDate);
        waitABit(2500);
    }
    private static final String ACCOUNT_HOLDER_NAME="//input[contains(@aria-label,'Name of the Account Holder')]";

    public void setAccountHolderName(String accountHolderName){
        waitABit(200);
        findBy(ACCOUNT_HOLDER_NAME).sendKeys(accountHolderName);
        waitABit(200);
    }
private static final String UPLOAD_EFT_DOC="//div[contains(@data-for,'Upload the EFT supporting Document')]//div//input";
    public void uploadEFTDoc(String eftDoc, String path) {
        scrollToElement(format(UPLOAD_EFT_DOC,eftDoc));
        WebElement element = findBy(String.format(UPLOAD_EFT_DOC, eftDoc));
        upload(element, path);
    }
}
