package com.hhstechgroup.ui.pages.IUFlowPages;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.util.properties.LocationProviderProperties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FloridaMedicaidPages extends AbstractPage {

    public FloridaMedicaidPages(WebDriver driver) {
        super(driver);
    }

    // XPATHS
    public static final String RightArrowButton = ("(//div[contains(@class,'MuiTabs-scrollButtons')])[2]");
    public static final String FloridaMedicaidProviderIdTab = ("//button[contains(@class,'MuiButtonBase-root')]//span[.='Florida Medicaid Provider ID']");
    public static final String BaseProviderId = ("(//div[contains(@class,'tile-table-head-component')]/following-sibling::div[1]//div[contains(@class,'tile-table-row-summary')]//div[1]//p[1])[1]");
    public static final String LocationProviderID = ("(//div[contains(@class,'tile-table-head-component')]/following-sibling::div[1]//div[contains(@class,'tile-table-row-summary')]//div[1]//p[1])[2]");
    public static final String StatusOfApplication = ("(//div[contains(@class,'tile-table-head-component')]/following-sibling::div[1]//div[contains(@class,'tile-table-row-summary')]//div[1]//p[1])[7]");
    public static final String MenuButton = ("//div[@class='expansion-panel-menu sc-eqIVtm gfpXD']//button");
    public static final String EditButton = ("//li[text()='Edit']");
    public static final String updateBtn = ("//span[text()='Update']");
    public static final String confmMessage = ("(//div[.='Medicaid Provider has been updated successfully.'])[1]");
    public static final String EFFECTIVE_START_DATE = ("//label[text()[contains(., 'Effective Start Date')]]/following-sibling::div//input[@placeholder='MM/DD/YYYY']");
    public static final String  SAVE_CHANGES_BUTTON = ("//span[contains(.,'Save Changes')]");


    //    public static final By Florida_Medicaid_SUbmitted = By.xpath("//div[contains(@class,'styles_approval-section-header')][.//h3[contains(text(),'Configure Florida Medicaid Provider Id')]][.//div[contains(@class,'MuiFormControl')] and .//div[contains(text(),'Submitted')]]");
    public static final String Florida_Medicaid_SUbmitted =("//div//h3[contains(text(),'Configure Florida Medicaid Provider Id')]/following::div[contains(text(),'Submitted')]");
    public static final String BackToDashBoardButton= ("//a[text()='←Back to dashboard']");
    public static final By Status_dropDown= By.xpath("//div[contains(@class,'styles_approval-section-header')][.//h3[contains(text(),'Configure Florida Medicaid Provider Id')]]//div[contains(@id,'Status') and @role='button']");
    public static final By  APPROVALS_SAVE_CHANGES_BUTTON = By.xpath("//span[contains(.,'Save Changes')]");

    public static final String successMsg = "Medicaid Provider has been updated successfully.";


    public void verifyAndSetFloridaMedicaidProviderIdStatus() {
        waitAbit(1000);
        System.out.println("Checking 'Configure Florida Medicaid Provider Id' status");

        // Common XPath that identifies current status (Submitted / Approved / Pending Approval)
//        ajaxScroll(Florida_Medicaid_SUbmitted);
        scrollToElement(Florida_Medicaid_SUbmitted);

        // If current status is 'Submitted', no action needed
//        boolean isSubmitted = driver.findElements(Florida_Medicaid_SUbmitted).size() > 0;
        String isSubmitted = findBy(Florida_Medicaid_SUbmitted).getText();
//        String isSubmitted = driver.findElement(By.xpath(Florida_Medicaid_SUbmitted)).getText();
        waitAbit(1000);

        if (isSubmitted.equalsIgnoreCase("Submitted")) {
            System.out.println("Status is already 'Submitted'. Proceeding to the next step.");
        } else {
            System.out.println("Status is not 'Submitted'. Updating it now...");

            // Step 1: Click on the status dropdown
            WebElement statusDropdown = driver.findElement(Status_dropDown);
            ajaxClick(statusDropdown);
            waitAbit(1000);

            // Step 2: Select 'Submitted' option
            WebElement submittedOption = driver.findElement(By.xpath("//div[contains(text(),'Submitted')]"));
            ajaxClick(submittedOption);
            System.out.println("Status changed to 'Submitted'");

            // Step 3: Click Save Changes
            waitAbit(1000);
            ajaxScroll(APPROVALS_SAVE_CHANGES_BUTTON);
            findBy(SAVE_CHANGES_BUTTON).click();
            System.out.println("Clicked on Save after status update");
        }
    }

    public void navigateToProviderMedicaid() {
        waitAbit(10000);
        findBy(RightArrowButton).click();
        waitAbit(20000);
        findBy(FloridaMedicaidProviderIdTab).click();
        waitAbit(10000);
    }

    public void VerifYFloridaMedicaid(){
        String baseproviderId = findBy(BaseProviderId).getText();
        System.out.println(baseproviderId);
        String locationproviderID = findBy(LocationProviderID).getText();
        System.out.println(locationproviderID);
        String status = findBy(StatusOfApplication).getText();
        System.out.println(status);
        LocationProviderProperties.appendLocationProviderId(locationproviderID);
    }
    public void VerifYFloridaMedicaidProviderTab(){
        String baseproviderId = findBy(BaseProviderId).getText();
        System.out.println(baseproviderId);
        String locationproviderID = findBy(LocationProviderID).getText();
        System.out.println(locationproviderID);
        String status = findBy(StatusOfApplication).getText();
        System.out.println(status);
    }


    public void editDateAndStatus() {
        waitAbit(1000);
        findBy(MenuButton).click();
        waitAbit(1000);
        findBy(EditButton).click();
        waitAbit(1000);
//        findBy(EFFECTIVE_START_DATE).sendKeys(getCurrentDate());
        WebElement dateField = findBy(EFFECTIVE_START_DATE);
        waitAbit(1000);
        dateField.clear();
        waitAbit(1000);
        dateField.sendKeys(getCurrentDate());
        waitAbit(1000);
        findBy(updateBtn).click();
        waitAbit(1000);
    }

    public void verifyEditConfirmation(String expected) {
//        waitAbit(200);
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[.='Medicaid Provider has been updated successfully.'])[1]")));
        String Confirmation_message = findBy(confmMessage).getText();
        Assert.assertEquals(Confirmation_message, expected);
        System.out.println("The Confirmation Message received is :" + Confirmation_message);
    }

    public void clickBackToDashBoardButton(){
        waitAbit(200);
        findBy(BackToDashBoardButton).click();
    }

}
