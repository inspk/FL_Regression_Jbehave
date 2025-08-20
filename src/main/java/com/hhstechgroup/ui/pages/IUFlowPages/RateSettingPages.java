package com.hhstechgroup.ui.pages.IUFlowPages;

import com.hhstechgroup.ui.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class RateSettingPages extends AbstractPage {
    public RateSettingPages(WebDriver driver){
        super(driver);
    }


    //    public static final String RATE_SETTING_TOGGLE= ("//div[contains(@class, 'styles_approval-section-header-new-switch')][.//h3[contains(text(), 'Rate Settings')]]//span[contains(@class, 'Mui-checked')]");
    public static final String RATE_SETTING_TOGGLE= ("//div[contains(@class,'header-new-switch')]//h3[contains(text(),'Rate Settings')]//following::label[1]/span[contains(@class,'MuiSwitch')]");
    public static final String Rate_Setting_status = "//div[contains(@class,'header-new-switch')]//h3[contains(text(),'Rate Setting')]//following::div[@id='providerMedicaidIdGenerateStatus']";
    public static final String APPROVALS_EDIT_BUTTON =("//span[contains(.,'Edit')]");
    public static final String RATE_SETTING_ON=("//div[h3[text()='Rate Settings']]/following-sibling::div//span[contains(@class,'MuiSwitch-thumb')]");
    public static final String APPROVALS_SAVE_CHANGES_BUTTON =("//span[contains(.,'Save Changes')]");
    public static final String MANUAL_RATE_SETTING_MODE= ("//div[contains(@class, 'MuiSelect-root') and text()='Manual']");
    public static final String AUTO_RATE_SETTING_MODE=
            ("//div[contains(@class, 'MuiSelect-root') and text()='Auto']");
    public static final String TOGGLE_BUTTON_OFF_STATE=
            ("//div[contains(@class, 'styles_approval-section-header-new-switch')][.//h3[contains(text(), 'Rate Settings')]]//span[contains(@class, 'Mui-checked')]");
    public static final String MODE_DROPDOWN=
            ("//div[@id='providerMedicaidIdGenerateStatus' and contains(@class, 'MuiSelect-root')]");


    public void verifyRateSettings_Manual(){
        waitAbit(10000);
//        ajaxScroll(RATE_SETTING_TOGGLE);
        scrollToElement(RATE_SETTING_TOGGLE);
        System.out.println("Scroll down to Rate Setting ");
//        if (driver.findElement(By.xpath("//div[contains(@class, 'styles_approval-section-header-new-switch')][.//h3[contains(text(), 'Rate Settings')]]//span[contains(@class, 'Mui-checked')]")).isDisplayed()) {
//        if (!driver.findElement(By.xpath("//div[contains(@class,'header-new-switch')]//h3[contains(text(),'Rate Settings')]//following::label[1]/span[contains(@class,'MuiSwitch')]")).isEnabled()) {
//            System.out.println("RATE_SETTING_TOGGLE is visible");
//        }
        waitAbit(10000);
//        String state = findBy("//div[contains(@class,'header-new-switch')]//h3[contains(text(),'Rate Settings')]//following::label[1]/span[contains(@class,'MuiSwitch')]").getAttribute("aria-disabled");
//        if ("false".equals(state)) {
//            System.out.println("Toggle is OFF");
//        }
//        if(findBy(TOGGLE_BUTTON_OFF_STATE).isDisplayed()){
//            System.out.println("Toggle is ON");
//        }
        if (getDriver().findElements(By.xpath("//div[contains(@class, 'styles_approval-section-header-new-switch')][.//h3[contains(text(), 'Rate Settings')]]//span[contains(@class, 'Mui-checked')]")).size() > 0) {
            // Found element → Auto is set
            System.out.println("Toggle is ON");
        }
        else {
            waitAbit(5000);
            System.out.println("Toggle button is disabled");
            scrollToElement(APPROVALS_EDIT_BUTTON);
            waitAbit(5000);
            findBy(APPROVALS_EDIT_BUTTON).click();
            System.out.println("Clicked on Edit button");
            waitAbit(5000);
            scrollToElement(RATE_SETTING_TOGGLE);
            waitAbit(5000);
            findBy(RATE_SETTING_TOGGLE).click();
            System.out.println("Rate Setting Enabled");
            waitAbit(5000);
            String Status = findBy(Rate_Setting_status).getText();
            scrollToElement(APPROVALS_SAVE_CHANGES_BUTTON);
            waitAbit(5000);
            findBy(APPROVALS_SAVE_CHANGES_BUTTON).click();
            System.out.println("Clicked on Save");
        }
        if (getDriver().findElements(By.xpath("//div[contains(@class, 'MuiSelect-root') and text()='Manual']")).size() > 0) {
            // Found element → Auto is set
            System.out.println("Status is set to Manual");
        } else {
            // Element not found → do your update flow
            waitAbit(5000);
            System.out.println("Toggle button is disabled");
            scrollToElement(APPROVALS_EDIT_BUTTON);
            waitAbit(5000);
            findBy(APPROVALS_EDIT_BUTTON).click();
            System.out.println("Clicked on Edit button");
            findBy(MODE_DROPDOWN).click();
            waitAbit(5000);
            selectFromDropDown("Manual");
            scrollToElement(APPROVALS_SAVE_CHANGES_BUTTON);
            waitAbit(5000);
            findBy(APPROVALS_SAVE_CHANGES_BUTTON).click();
            System.out.println("Clicked on Save");
        }
    }

    public void verifyRateSettings_Auto(){
        waitAbit(10000);
        scrollToElement(RATE_SETTING_TOGGLE);
        System.out.println("Scroll down to Rate Setting ");
        waitAbit(10000);
//        String state = findBy("//div[contains(@class,'header-new-switch')]//h3[contains(text(),'Rate Settings')]//following::label[1]/span[contains(@class,'MuiSwitch')]").getAttribute("aria-disabled");
//        if ("false".equals(state)) {
//            System.out.println("Toggle is OFF");
//        }
        if(findBy(TOGGLE_BUTTON_OFF_STATE).isDisplayed()){
            System.out.println("Toggle is ON");
        }
        else {
            waitAbit(5000);
            System.out.println("Toggle button is disabled");
            scrollToElement(APPROVALS_EDIT_BUTTON);
            waitAbit(5000);
            findBy(APPROVALS_EDIT_BUTTON).click();
            System.out.println("Clicked on Edit button");
            waitAbit(5000);
            scrollToElement(RATE_SETTING_TOGGLE);
            waitAbit(5000);
            findBy(RATE_SETTING_TOGGLE).click();
            System.out.println("Rate Setting Enabled");
            waitAbit(5000);
            scrollToElement(APPROVALS_SAVE_CHANGES_BUTTON);
            waitAbit(5000);
            findBy(APPROVALS_SAVE_CHANGES_BUTTON).click();
            System.out.println("Clicked on Save");
        }
        if (getDriver().findElements(By.xpath("//div[contains(@class, 'MuiSelect-root') and text()='Auto']")).size() > 0) {
            // Found element → Auto is set
            System.out.println("Status is set to Auto");
        } else {
            // Element not found → do your update flow
            waitAbit(5000);
            System.out.println("Toggle button is disabled");
            scrollToElement(APPROVALS_EDIT_BUTTON);
            waitAbit(5000);
            findBy(APPROVALS_EDIT_BUTTON).click();
            System.out.println("Clicked on Edit button");
            findBy(MODE_DROPDOWN).click();
            waitAbit(5000);
            selectFromDropDown("Auto");
            scrollToElement(APPROVALS_SAVE_CHANGES_BUTTON);
            waitAbit(5000);
            findBy(APPROVALS_SAVE_CHANGES_BUTTON).click();
            System.out.println("Clicked on Save");
        }
    }

    public static final String RATE_SETTING_MODE="//div[contains(@class, 'MuiSelect-root') and text()='%s']";
    public void verifyRateSettings(String status){
        waitAbit(10000);
        scrollToElement(RATE_SETTING_TOGGLE);
        System.out.println("Scroll down to Rate Setting ");
        waitAbit(10000);

//        try {
        // Step 1: Check if toggle is ON
        if (!findBy(TOGGLE_BUTTON_OFF_STATE).isDisplayed()) {
            waitABit(3000);
            System.out.println("Toggle button is disabled");

            scrollToElement(APPROVALS_EDIT_BUTTON);
            waitABit(3000);
            findBy(APPROVALS_EDIT_BUTTON).click();
            System.out.println("Clicked on Edit button");

            waitABit(3000);
            scrollToElement(RATE_SETTING_TOGGLE);
            findBy(RATE_SETTING_TOGGLE).click();
            System.out.println("Rate Setting Enabled");
            waitABit(3000);
        }

        // Step 2: Check if "Auto" is selected
        if (!findBy(format(RATE_SETTING_MODE, status)).isDisplayed()) {
            waitABit(3000);
            System.out.println("Auto Mode is Enabled");
        }
        else {
            System.out.println("Auto Mode is Disabled");
            scrollToElement(APPROVALS_EDIT_BUTTON);
            waitABit(3000);
            findBy(APPROVALS_EDIT_BUTTON).click();
            waitAbit(3000);
            System.out.println("Clicked on Edit button");
            System.out.println("'Auto' is not selected. Selecting now...");
            findBy(MODE_DROPDOWN).click();
            waitABit(2000);
            selectFromDropDown(status);
            waitABit(3000);
        }
        if (!findBy(format(RATE_SETTING_MODE, status)).isDisplayed()) {
            throw new AssertionError("'Auto' is still not selected after trying to update.");
        }

        // Step 3: Save changes
        scrollToElement(APPROVALS_SAVE_CHANGES_BUTTON);
        waitABit(3000);
        findBy(APPROVALS_SAVE_CHANGES_BUTTON).click();
        System.out.println("Clicked on Save");

//        } catch (NoSuchElementException e) {
//            throw new AssertionError("Required element not found during Rate Settings verification: " + e.getMessage(), e);
//        } catch (Exception e) {
//            throw new AssertionError("Unexpected error during Rate Settings update: " + e.getMessage(), e);
//        }
    }


    public static final String RequestID = "//input[@id='RequestID']";
    public static final String SearchButton = "//button//span[.='Search']";
    public void SearchWithProviderID(String id){
        waitAbit(2000);
        findBy(RequestID).type(id);
        waitAbit(1000);
        findBy(SearchButton).click();
    }

}
