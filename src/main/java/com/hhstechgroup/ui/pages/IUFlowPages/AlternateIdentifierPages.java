package com.hhstechgroup.ui.pages.IUFlowPages;

import com.hhstechgroup.beans.application.AddressBean;
import com.hhstechgroup.ui.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.hhstechgroup.ui.pages.peportal.DashboardPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlternateIdentifierPages extends AbstractPage {

    public AlternateIdentifierPages(WebDriver driver){
        super(driver);
    }

    DashboardPage dashboardPage;
    AddressBean addressBean;

    public static final String RightArrowButton = ("(//div[contains(@class,'MuiTabs-scrollButtons')])[2]");
    public static final String AlternateIdentifierTab = ("//button[contains(@class,'MuiButtonBase-root')]//span[.='Alternate Identifier']");
    public static final String AlternateIdentifierButton = ("//button[contains(@class,'MuiButtonBase-root')]//span[.='+Add Alternate Identifier']");
    public static final String IdentifierLevelDropdown = ("//div[contains(@class,'MuiDialog')]//div[@id='identifierlevel']");
    public static final String IdentifierNameDropdown = ("//div[contains(@class,'MuiDialog')]//div[@id='identifiername']");
    public static final String IdentifierTypeDropdown = ("//div[contains(@class,'MuiDialog')]//div[@id='identifiertype']");
    public static final String IdentifierValueTextField = ("//div[contains(@class,'MuiDialog')]//input[@name='identifierValue']");
    public static final String ReasonCOdeDropdown = ("//div[contains(@class,'MuiDialog')]//div[@id='reasoncode']");
    public static final String SaveButton = ("//div[contains(@class,'MuiDialog')]//span[.='Save']");
    public static final String AddConfirmationPopup = ("(//div[.='Alternate Identifier has been added successfully.'])[1]");

    public static final String ActionMenu = ("(//div[contains(@class,'expansion-panel')]//span[contains(@class,'MuiIconButton')])[2]");
    public static final String EditOption = ("//ul[contains(@class,MuiList)]//li[.='Edit']");
    public static final String StatusDropdown = ("//div[contains(@class,'MuiDialog')]//div[.='Active']");
    public static final String NotesField = ("//div[contains(@class,'MuiInputBase')]//textarea[@name='notes']");
    public static final String EditConfirmationPopup = ("(//div[.='Alternate Identifier has been updated successfully.'])[1]");
    public static final String IdentifierNameOption = ("(//ul[@role='listbox']//li)[2]");

    public static final String phonenumber = "9876543287";

    public static final String START_DATE=(".//label[contains(text(), 'Start Date')]/parent::div//input");
    public static final String END_DATE = (".//label[contains(text(), 'End Date')]/parent::div//input");
   public static final String Alternate_identifier_Tab = "Alternate Identifier";

    public void openAddAlternateIdentifierDialog() {
        waitAbit(1500);
//        getDriver().navigate().refresh();
        System.out.println("Page refreshed");
        waitAbit(2000);
        findBy(RightArrowButton).click();
        waitAbit(3000);
        findBy(AlternateIdentifierTab).click();
        dashboardPage.clickTabOnProvidersTab(Alternate_identifier_Tab);
        waitAbit(1500);
        findBy(AlternateIdentifierButton).click();
        waitAbit(1500);
    }

    public void openAddAlternateIdentifierDialog_ProvidersTab() {
        waitAbit(2000);
        findBy(RightArrowButton).click();
        waitAbit(500);
        findBy(RightArrowButton).click();
        waitAbit(500);
        findBy(RightArrowButton).click();
        waitAbit(500);
        findBy(AlternateIdentifierTab).click();
        waitAbit(500);
        dashboardPage.clickTabOnProvidersTab(Alternate_identifier_Tab);
        waitAbit(1500);
        findBy(AlternateIdentifierButton).click();
        waitAbit(1500);
    }

    public void fillIdentifierForm(String level, String type, String reason) {
        findBy(IdentifierLevelDropdown).click();
        waitAbit(1500);
        selectFromDropDown(level);
        waitAbit(1500);
        findBy(IdentifierNameDropdown).click();
        waitAbit(1500);
        findBy(IdentifierNameOption).click();
//        clickAnyOptionInList(1);
//        ajaxClick(setSpecificOptionInListbox(name));
        waitAbit(1500);
        findBy(IdentifierTypeDropdown).click();
        waitAbit(1500);
        selectFromDropDown(type);
        waitAbit(1500);
        findBy(IdentifierValueTextField).click();
        waitAbit(1500);
        findBy(IdentifierValueTextField).type(phonenumber);
        waitAbit(1500);
        findBy(ReasonCOdeDropdown).click();
        waitAbit(1500);
        selectFromDropDown(reason);
        waitABit(300);
        findBy(START_DATE).click();
        waitAbit(1500);
        findBy(START_DATE).sendKeys(getCurrentDate());
        waitABit(2000);
        jsClick(SaveButton);
//        findBy(SaveButton).click();
    }

    public void verifyAddConfirmation(String expected) {
//        waitAbit(2000);
//        waitFor(ExpectedConditions.visibilityOfElementLocated(findBy(AddConfirmationPopup)));
         waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[.='Alternate Identifier has been added successfully.'])[1]")));
        String Confirmation_message = findBy(AddConfirmationPopup).getText();
        Assert.assertEquals(Confirmation_message, expected);
        System.out.println("The Confirmation Message received is :" + Confirmation_message);
    }
//
    public void openEditIdentifierDialog() {
        waitAbit(1000);
        jsClick(ActionMenu);
        waitAbit(1000);
        jsClick(EditOption);
        waitAbit(1000);
    }

    public void fillEditForm(String reason, String status) {
       findBy(ReasonCOdeDropdown).click();
       waitAbit(1000);
        selectFromDropDown(reason);
        waitAbit(1000);
        findBy(StatusDropdown).click();
        waitAbit(1000);
        selectFromDropDown(status);
        waitAbit(1000);
        findBy(END_DATE).click();
        waitAbit(1000);
        findBy(END_DATE).sendKeys(getCurrentDate());
        waitAbit(1000);
        findBy(NotesField).click();
        waitAbit(1000);
        findBy(NotesField).sendKeys(generateRandomString());
        waitAbit(1000);
        findBy(SaveButton).click();
        waitAbit(1000);
    }

    public void verifyEditConfirmation(String expected) {
//        waitAbit(200);
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[.='Alternate Identifier has been updated successfully.'])[1]")));
        String Confirmation_message = findBy(EditConfirmationPopup).getText();
        Assert.assertEquals(Confirmation_message, expected);
        System.out.println("The Confirmation Message received is :" + Confirmation_message);
    }

}
