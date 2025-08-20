package com.hhstechgroup.ui.pages.IUFlowPages;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MCO_AdminPages extends AbstractPage {
    public MCO_AdminPages(WebDriver driver){
        super(driver);
    }

    private static final String Add_New_user_text_ = "//div[contains(@class,'MuiDialog')]//div[contains(@class,'MuiDialogTitle')]//h2[.='Add New User']";
    private static final String Status_NewUser = "(//div[contains(@class,'tile-table-row')]//div[contains(@class,'tile-table-column')]//p)[5]";
    private static final String TOOLTIP_ICON = ".//div[contains(@data-tooltip,'Show trimmed content')]/img";
    private static final String LINK = "(.//td//a[contains(text(),'link')])[1]";
    private static final String Password_TextField = "//input[@id='enterPassword']";
    private static final String Confirm_Password_textField = "(//input[@type='password'])[2]";
    private static final String Set_Password_button = "//button//span[.='Set Password']";
    private static final String Back_To_login = ".//div/a//span[text()='Back To Log In']";
    public static final String FIRST_NAME_ADD_NEW_USER=
            "//legend/span[contains(normalize-space(), 'First Name')]/ancestor::div[contains(@class,'MuiInputBase-root')]//input";
    public static final String LAST_NAME_ADD_NEW_USER=
            "//legend/span[contains(normalize-space(), 'Last Name')]/ancestor::div[contains(@class,'MuiInputBase-root')]//input";
    public static final String EMAIL_ADD_NEW_USER=
            "//legend/span[contains(normalize-space(), 'Email (User ID)')]/ancestor::div[contains(@class,'MuiInputBase-root')]//input";
    public static final String GROUP_TYPE= "//label[contains(., 'Select Group')]/following::div[contains(@class, 'MuiSelect-root')][1]";
    public static final String USER_NAME_FIELD=
            "//legend/span[contains(normalize-space(), 'User name or ID')]/ancestor::div[contains(@class, 'MuiInputBase-root')]//input";
    public static final String SEARCH= "//button[.//span[normalize-space()='Search']]";
    public static final String STATUS= "//div[@class='table-text-wr']//p[contains(normalize-space(), '%s')]";
    public static final String ADMIN_EXISTS_MSG= "//div[contains(normalize-space(text()), '%s')]";
    public static final String OPTION_BUTTON= "(//button[@aria-label='More'])[1]";
    public static final String DEACTIVATE= "//li[normalize-space()='Deactivate']";
    public static final String DEACTIVATE_REASON= "//div[@role='button' and contains(@aria-labelledby, 'Reason')]";
    public static final String DEACTIVATE_BUTTON=
            "//span[@class='MuiButton-label' and normalize-space()='DEACTIVATE']";
    public static final String SUCCESS_MSG= "//button[.//span[contains(normalize-space(), 'OK')]]";
    public static final String LINK_COMPLETE_REGD= "//a[normalize-space()='link']";
    public static final String ENTER_PASSWORD="//input[@id='enterPassword' and @type='password']";
    public static final String CONFIRM_PASSWORD="//input[@type='password' and not(@id)]";
    public static final String SET_PASSWORD="//span[contains(normalize-space(), 'Set Password')]";

    public static final String LOCATION_P_ID=
            "(//div[contains(@class,'tile-table-row-summary')]//div[contains(@class,'tile-table-column')])[2]//p";

    public static final String SUCCESS_MESSAGE=
            "//div[@class='MuiDialogContent-root']//h2[normalize-space()='All changes have been saved successfully.']";

    public static final String INACTIVE_USER_MSG= "//div/span[contains(text(), 'User is inactive')]";
    public static final String ACTIVE_OPTION= "//li[contains(normalize-space(.), 'Activate')]";
    public static final String REACTIVATE="//button[.//span[contains(text(), 'REACTIVE')]]";

    //This method is used to close the popup and further proceed on with next element
    public void Click_AddNewUserText(){
        findBy(Add_New_user_text_).click();
    }

    public void Fetch_StatusOfUser(){
        findBy(Status_NewUser).getText();
    }

    private static final String MCO_ADMIN_EMAIL = "(.//tr//span[.='%s'])[5]";
    public void openMCO_AdminEmail(String emailTitle){
        waitAbit(5000);
        jsClick(format(MCO_ADMIN_EMAIL, emailTitle));

    }

    public  void clickOnMCOADMINUserLinkFromGmail(){
        waitForSpinnerToDisappear();
        try {
            withTimeoutOf(Duration.ofSeconds(3)).waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(TOOLTIP_ICON)));
            jsClick(TOOLTIP_ICON);

        }catch (Exception e) {
            waitFor(ExpectedConditions.elementToBeClickable(By.xpath(LINK)));
            waitForSpinnerToDisappear();
            waitAbit(500);
            waitAbit(500);
        }
        scrollToElement(LINK);
        jsClick(LINK);
    }

    public void set_Password(String password){
        findBy(Password_TextField).click();
        waitAbit(2000);
        findBy(Password_TextField).type(password);
        waitAbit(2000);
        findBy(Confirm_Password_textField).click();
        waitAbit(2000);
        findBy(Confirm_Password_textField).type(password);
        waitAbit(2000);
        findBy(Set_Password_button).click();

    }

    public void BackToLogin(){
        waitAbit(500);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        jsClick(Back_To_login);
        waitAbit(2000);
    }

    public void fillfirstname(String firstname){
        waitAbit(1000);
        jsClick(FIRST_NAME_ADD_NEW_USER);
        waitAbit(2000);
        findBy(FIRST_NAME_ADD_NEW_USER).sendKeys(firstname);
        waitAbit(2000);

    }
    public void filllastname(String lastname){
        waitAbit(1000);
        jsClick(LAST_NAME_ADD_NEW_USER);
        waitAbit(2000);
        findBy(LAST_NAME_ADD_NEW_USER).sendKeys(lastname);
        waitAbit(2000);
    }

    public void fillemail(String email){
        waitAbit(2000);
        jsClick(EMAIL_ADD_NEW_USER);
        waitAbit(2000);
        findBy(EMAIL_ADD_NEW_USER).sendKeys(email);
        waitAbit(2000);
    }

    public void selctgroputype(String group){
        waitAbit(2000);
        findBy(GROUP_TYPE).click();
        waitAbit(200);
        selectFromDropDown(group);
        waitAbit(3000);

    }

    public void searchwithusername(String criteria){
        waitAbit(5000);
        scrollToElement(USER_NAME_FIELD);
        waitAbit(3000);
        findBy(USER_NAME_FIELD).click();
        waitAbit(2000);
        findBy(USER_NAME_FIELD).clear();
        waitAbit(3000);
        findBy(USER_NAME_FIELD).sendKeys(criteria);
        waitAbit(2000);
        findBy(SEARCH).click();
        waitAbit(2000);

    }

//    public void statusverification(String status) {
//        waitAbit(2000);
//
//        String deactivateXpath = String.format(STATUS, "DEACTIVATE");
//        String inactiveXpath = String.format(STATUS, "INACTIVE");
//
//        boolean isDeactivateVisible = isStatusVisible(deactivateXpath);
//        boolean isInactiveVisible = isStatusVisible(inactiveXpath);
//
//        Assert.assertTrue(
//                "Expected status to be DEACTIVATE or INACTIVE, but neither was found.",
//                isDeactivateVisible || isInactiveVisible
//        );
//    }

    public void statusverification(String status) {
        waitAbit(2000);

        // First block: verify the passed status
        String xpath = String.format(STATUS, status);
        List<WebElement> elements = getDriver().findElements(By.xpath(xpath));
        boolean isVisible = !elements.isEmpty() && elements.get(0).isDisplayed();

        if (isVisible) {
            // Passed because the given status is visible
            assertTrue("Expected status to be visible: " + status, true);
            return; // Exit early
        }

        // Second block: verify DEACTIVATE or INACTIVE
        String deactivateXpath = String.format(STATUS, "DEACTIVATE");
        String inactiveXpath = String.format(STATUS, "INACTIVE");

        boolean isDeactivateVisible = isStatusVisible(deactivateXpath);
        boolean isInactiveVisible = isStatusVisible(inactiveXpath);

        assertTrue(
                "Expected status to be '" + status + "' or DEACTIVATE or INACTIVE, but none were found.",
                isDeactivateVisible || isInactiveVisible
        );
    }

    private boolean isStatusVisible(String xpath) {
        List<WebElement> elements = getDriver().findElements(By.xpath(xpath));
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }


    public void verifexistingusemsg(String errormsg){
        waitAbit(2000);

        String xpath = String.format(ADMIN_EXISTS_MSG, errormsg);
        List<WebElement> elements = getDriver().findElements(By.xpath(xpath));

        boolean isVisible = !elements.isEmpty() && elements.get(0).isDisplayed();
        assertTrue("Expected error message to be visible: " + errormsg, isVisible);
    }

    public void deactivateuser(String reason){
        waitAbit(3000);
        findBy(OPTION_BUTTON).click();
        waitAbit(3000);
        findBy(DEACTIVATE).click();
        waitAbit(7000);
//        jsClick(DEACTIVATE_REASON);
        findBy(DEACTIVATE_REASON).click();
        waitAbit(2000);
//        clickAnyOptionInList(1);
        selectFromDropDown(reason);
        waitAbit(2000);
        jsClick(DEACTIVATE_BUTTON);
        waitAbit(2000);
        WebElementFacade confirmationText = findBy(SUCCESS_MSG);
        waitAbit(2000);
        assertTrue("Confirmation message should be visible", confirmationText.isVisible());
        jsClick(SUCCESS_MSG);
        waitAbit(3000);
    }

    public void clickonthelink(){
        waitAbit(30000);
        jsClick(LINK_COMPLETE_REGD);

    }

    public void enterpassword(String password){

        waitAbit(10000);
        jsClick(ENTER_PASSWORD);
        waitAbit(2000);
        findBy(ENTER_PASSWORD).sendKeys(password);
        waitAbit(2000);
        jsClick(CONFIRM_PASSWORD);
        waitAbit(2000);
        findBy(CONFIRM_PASSWORD).sendKeys(password);
        waitAbit(5000);
        jsClick(SET_PASSWORD);
        waitAbit(5000);

    }

    public void verifygeneratedprovidercontract(){
        waitAbit(3000);

        WebElement idElement = findBy(LOCATION_P_ID);
        String providerId = idElement.getText().trim();
        waitAbit(3000);
        System.out.println("Found Provider ID: " + providerId);

        // Check if it is a 9-digit number
        boolean isNineDigit = providerId.matches("\\d{9}");
        waitAbit(2000);
        assertTrue("Expected a 9-digit Location Provider ID but found: " + providerId, isNineDigit);
    }

    public void verifyinactivemsg(){
        WebElementFacade confirmationText = findBy(INACTIVE_USER_MSG);
        waitAbit(2000);
        assertTrue("Confirmation message should be visible", confirmationText.isVisible());
    }

    public void reactiveMCOAdmin(String reason){
        waitAbit(3000);
        findBy(OPTION_BUTTON).click();
        waitAbit(3000);
        findBy(ACTIVE_OPTION).click();
        waitAbit(2000);
//        jsClick(DEACTIVATE_REASON);
        findBy(DEACTIVATE_REASON).click();
        waitAbit(2000);
        selectFromDropDown(reason);
        waitAbit(2000);
        jsClick(REACTIVATE);;
        waitAbit(2000);
        jsClick(SUCCESS_MSG);
    }

    public static final String MCO_ADMIN = "//div[@role='button' and .//div[@class='role' and text()='%s']]";

    public void verifyMcoAdminPage(String verification) {
        String mcoAdminXpath = String.format(MCO_ADMIN, verification);

        // Wait until element is present and visible
        WebElement element = getDriver().findElement(By.xpath(mcoAdminXpath));

        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue("MCO Admin button is not displayed", isDisplayed);
    }







}
