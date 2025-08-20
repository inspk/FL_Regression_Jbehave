package com.hhstechgroup.ui.pages.sitevisit;

import com.hhstechgroup.ui.pages.AbstractPage;

import com.hhstechgroup.ui.pages.sitevisit.AddNewUserPopup;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import com.hhstechgroup.ui.panels.enrollment.*;
import com.hhstechgroup.ui.panels.enrollment.licensure.LicensureCertificationPanel;
import com.hhstechgroup.ui.panels.systemoptions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.awt.dnd.DragSource;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public class UserPage extends AbstractPage{
    private static final String  CLICK_ADD_USER = "//span[contains(text(), 'Add User')]/parent::button";
    private static final String ADD_NEW_USER_PANEL = "//h2[contains(text(), 'Add New User')]/../parent::div";
    private static final String USER_FIRST_NAME = "//label[text()='First Name']/../div/input";
    private static final String USER_LAST_NAME = "//label[text()='Last Name']/../div/input";
    private static final String USER_EMAIL_ID = "//label[text()='Email (User ID)']/../div/input" ;
    private static final String ADD_BUTTON =  "//span[text()='Add']";
    protected static final String SPINNER = ".//div[contains(@class, 'spinner_spinner-wrap')]";
    private static final String ROLE_FIELD =  ".//div//div[@role='button']/parent::div[contains(@class,'jss751')]/../div/div/following-sibling::input[@id='select-multiple-chip']/..";
    private static final String ADD_GENERALINFORMATION_PANEL =".//div[contains(@class,'details_content_')]";
    private static final String PASSWORD_POLICY_PANEL ="//div[contains(@class,'system-content fl')]";
    public static final String COMBOBOX_TAXONOMY = "//label[text()='Taxonomy']//ancestor::div[@role='combobox']//input";
    public static final String COMBOBOX_TAXONOMY_DESCRIPTION = "//label[text()='Taxonomy Description']//ancestor::div[@role='combobox']//input";
    public static final String COMBOBOX_TAXONOMY_OPTION = "//ul[@role='listbox']//li//span[text()='%s']";
    public static final String COMBOBOX_TAXONOMY_OPTION1 = "//ul[@role='listbox']//li//strong[text()='%s']";

    public UserPage(WebDriver driver) { super(driver); }


    public void clickOnAddUser() { jsClick(CLICK_ADD_USER);}

    public AddNewUserPopup newUserPopup() {
        return new AddNewUserPopup(findBy(ADD_NEW_USER_PANEL), this);
    }

    public boolean isAddNewUserPopupOpened() {
        return isElementPresent(ADD_NEW_USER_PANEL);
    }

    public void clickUserFirstName() { findBy(USER_FIRST_NAME).click();waitAbit(2000);}

    public void fillUserFirstName(String username) {

        findBy(USER_FIRST_NAME).type(username);
    }

    public String getUserFirstNameValue() {
        return findBy(USER_FIRST_NAME).getAttribute("value");
    }

    public void clickUserLastName() { findBy(USER_LAST_NAME).click();waitAbit(2000);}

    public void fillUserLastName(String password) {
        findBy(USER_LAST_NAME).type(password);}

    public String getUserLastNameValue() {
        return findBy(USER_LAST_NAME).getAttribute("value");
    }

    public void fillUserEmailUserId(String useremail) {findBy(USER_EMAIL_ID).type(useremail);}

    public void clickAddbuttonFromUserPage(){jsClick(ADD_BUTTON);waitAbit(2000);}


    private static final String ROLE = "//ul/li[contains(text(), '%s')]";
    //latest

    private static final String ROLE_FIE=  "(.//input[contains(@id, 'select-multiple')]/preceding-sibling::div)[1]";
    private static final String ROLE2 = "//ul/li[contains(text(),'Provider Supervisor')]";
    //private static final String ROLE2 = "//ul/li[contains(text(),'Forensic Supervisor')]";

   private static final String Select_Group_Type = "(.//input[contains(@id, 'select-multiple')]/preceding-sibling::div)[1]//following::div[contains(@id,'Select Group')]";

    public void clickOnRoleField(){jsClick(ROLE_FIE);waitAbit(1000);}
    public void selectAnyRolefromUser() {
        waitAbit(1000);
        jsClick(ROLE_FIE);
        scrollToElement(ROLE2);
        waitAbit(1000);
        jsClick(ROLE2); waitAbit(1000);
    }

    public void selectAnyRolefromUser1(String role) {
        waitAbit(1000);
        scrollToElement(ROLE_FIE);
//        jsClick(ROLE_FIE);
        waitAbit(1000);
        findBy(ROLE_FIE).click();
        waitAbit(1000);
        scrollToElement(format(ROLE,role));
        waitAbit(1000);
        findBy(format(ROLE,role)).click();
        waitAbit(1000);
//        findBy("//html").sendKeys(Keys.ESCAPE);
        findBy("//body").click();
        waitAbit(500);
    }

    public void selectGroupForMCOAdminUser(String grouptype) {
        waitAbit(1000);
        scrollToElement(Select_Group_Type);
//        jsClick(ROLE_FIE);
        waitAbit(1000);
        findBy(Select_Group_Type).click();
        waitAbit(1000);
        scrollToElement(format(ROLE,grouptype));
        waitAbit(1000);
        findBy(format(ROLE,grouptype)).click();
        waitAbit(1000);
        findBy("//html").sendKeys(Keys.ESCAPE);
        waitAbit(500);
    }

    private static final String USEREMAIL  ="//div[text()='Email or phone']/../../div/input";
    private static final String USERPASSWORD ="";
    private static final String NEXT_BUTTON ="//span[text()='Next']/../../div";

    public void setUserEmailId(String emailId){findBy(USEREMAIL).type(emailId);}

    public void clickOnNextButton(){jsClick(NEXT_BUTTON);waitAbit(10000);}

    public void setUserEmailPw(String emailpw){findBy(USERPASSWORD).type(emailpw);}

    private static final String SET_PASSWORD =  "//div//label[text()='Enter password']/../div/input" ;
    private static final String CONFIRM_PASSWORD =  "//div//label[text()='Confirm password']/../div/input" ;
    private static final String SET_PASSWORD_BUTTON = "//div//button/span[text()='Set Password']/../span[1]" ;
    private static final String DASHBOARD_BUTTON ="//div//button/span[text()='Go to dashboard']/../span[1]";

    public void setUserPassword(String setpassword){findBy(SET_PASSWORD).type(setpassword);}
    public void setUserConfirmPassword(String confirmpassword){findBy(CONFIRM_PASSWORD).type(confirmpassword);}
    public void clickOnSetPasswordButton(){jsClick(SET_PASSWORD_BUTTON);}
    public void clickoOnDashboardButton() {jsClick(DASHBOARD_BUTTON);}

    //latest for  new gmail account
    // private static final String PARENT_MAIL = "//p[text()='shwethamc1594@gmail.com']/../p[2]";
    private static final String PARENT_MAIL = ".//div/p[contains(text(),'shwetha mc')]";
    private static final String YES_BUTTON = "//content[@class='CwaK9']/span[text()='Yes']/../span";
    private static final String GOOGLE_APPS  =  ".//a[@aria-label='Google apps']/../a" ;
   // private static final By GOOGLE_APPS_IFRAME  = By.xpath("//iframe[contains(@id, 'I0')]") ;
//    private static final By GOOGLE_APPS_IFRAME  = By.xpath ("//iframe[contains(@role,'presentation')]");
    //private static final String GMAIL_ICON  =  "//span[@pid='23']" ;
//   private static final String GMAIL_ICON  = "//a[@data-pid='23']" ;
   private static final By GOOGLE_APPS_IFRAME  = By.xpath ("//iframe[@name='app']");
    private static final String GMAIL_ICON  = "//a[span[normalize-space(text())='Gmail']]" ;

    private static final String EMAIL_LINK = ".//center//h3/a";
    public void selectParentMail(){jsClick(PARENT_MAIL); waitAbit(2000);}
    public void clickOnYesButton(){scrollToElement(YES_BUTTON); waitAbit(1000);jsClick(YES_BUTTON);}
    public void clickOnGmailIcon(){
        waitAbit(40000);
        jsClick(GOOGLE_APPS);
        WebElement iframe = getDriver().findElement(GOOGLE_APPS_IFRAME);
        getDriver().switchTo().frame(iframe);
        waitAbit(200);
        jsClick(GMAIL_ICON);
        waitAbit(200);



    }

    public void switchToGmailtab() {
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));}

    public  void clickOnUserLinkFromGmail(){
//        scrollToElement(EMAIL_LINK);
        waitForSpinnerToDisappear();
        waitFor(ExpectedConditions.elementToBeClickable(By.xpath(EMAIL_LINK)));
        waitForSpinnerToDisappear();
        waitAbit(500);
        jsClick(EMAIL_LINK);
        //sp29
        waitAbit(500);
       // findBy(EMAIL_LINK).waitUntilEnabled().click();
    }

    public void switchTosetPasswordWindow() {
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
    }
    private static final String USER_ENTER_PASSWORD = ".//div/input[@id='enterPassword']/../input";
    private static final String PASSWORD = "//label[text()='Confirm password']/following-sibling::div/input";
    private static final String USER_SET_PASSWORD = ".//div/button/span[text()='Set Password']/../span[1]";
    private static final String GO_TO_DASHBOARD = "//div/a/button/span[text()='Go to dashboard']/../span[1]";

    public void enterPasswordForUser(String userpassword) {
        String currentTab = getDriver().getWindowHandle();
        System.out.println(currentTab);
        findBy(USER_ENTER_PASSWORD).type(userpassword);
        waitAbit(2000);
    }
    public void clickOnConfirmPasswordField(){ findBy(PASSWORD).waitUntilClickable().click();}

    public void enterConfirmedPassword(String userconfirmpassword) {
        //   jsClick(PASSWORD); waitAbit(3000);
        findBy(PASSWORD).type(userconfirmpassword);
    }

    public void clickOnSetPasswordFromUser() {jsClick(USER_SET_PASSWORD);}
    public void clickOnDashboard() {jsClick(GO_TO_DASHBOARD); waitAbit(1000);}
    public void selectUserRole() {
        selectFromDropDown(ROLE2);
    }

    private static final String CANCEL_BUTTON = "//span[contains(text(),'Cancel')]";
    public void clickOnCancelButtonInAddUser(){jsClick(CANCEL_BUTTON);}

    //latest
    private static final String USER =  "//div/p[contains(text(), '%s')]" ;

    public void selectUser(String user) {
        scrollToElement(format(USER, user));
        findBy(format(USER, user)).click();
    }
    private static final String USER_NAME = ".//input[@id = 'name']" ;
    public void setUserName(String userName) {
        waitForAbsenceOf(SPINNER);
        findBy(USER_NAME).type(userName);
    }

    private static final String REASON_FIELD = ".//input[contains(@id, 'Reason')]/preceding-sibling::div" ;
    private static final String  REASON = ".//ul/li[contains(text(),'%s')]" ;
    private static final String  NOTE = ".//label[contains(text(), 'Note')]/../div/textarea[1]" ;
    private static final String  APPLY = ".//button/span[text()='Apply']" ;

    //sp21
    public void selectReasonDeactiveAndActiveUser(String reasonForDeactivate,String note) {
        waitAbit(1000);
        jsClick(REASON_FIELD);
        scrollToElement(format(REASON,reasonForDeactivate));
        waitAbit(1000);
        findBy(format(REASON, reasonForDeactivate)).click();
        waitAbit(1000);
        findBy(NOTE).click();
        findBy(NOTE).type(note);
        waitAbit(500);
    }
    private static final String CLICK_DEACTIVATION_AND_REACTIVATION_BUTTON = ".//button/span[contains(text(),'%s')]" ;
    private static final String CLICK_OK_BUTTON = ".//button/span[contains(text(),'OK')]" ;
    public void clickOnDectivationAndReactivationButton(String button){
        findBy(format(CLICK_DEACTIVATION_AND_REACTIVATION_BUTTON,button)).click();
        findBy(CLICK_OK_BUTTON).click();
    }

    private static final String USER_DEACTIVATION_POPUP   ="//h2/span[contains(text(), '%s')]/../../parent::div";
    public boolean isPopupisplaying(String popup) {
        waitAbit(500);
        return findBy(format(USER_DEACTIVATION_POPUP, popup)).isDisplayed();
    }

    public void selectReasonToActiveAndDeactiveTheUser(String reasonForDeactivate,String note) {
        waitAbit(1000);
        jsClick(REASON_FIELD);
        scrollToElement(format(REASON,reasonForDeactivate));
        waitAbit(1000);
        findBy(format(REASON, reasonForDeactivate)).click();
        waitAbit(1000);
        findBy(NOTE).click();
        findBy(NOTE).type(note);
        waitAbit(1000);
        findBy(APPLY).click();

    }

    private static final String  DETAILS = ".//p/b[text()='Details']" ;
    public void clickOnDeatils( ) {
        waitAbit(1000);
        scrollToElement(DETAILS);
        findBy(DETAILS).click();
    }

    public void scrollToDetailsField() {
        waitAbit(500);
        scrollToElement(DETAILS);
    waitAbit(300);}

    private static final String  EDIT_USERNAME = "//h1[text()='%s']/*[local-name() = 'svg' and @aria-hidden='true']" ;
    private static final String  CLICK_USERNAME =".//input[@id='name']";
    private static final String  EDIT_TIMEZONE = "//h2[text()='%s']/*[local-name() = 'svg' and @aria-hidden='true']" ;
    private static final String  EDIT_LANGUAGESPOKEN = "" ;
    public void editUserName(String userName,String field) {
        waitAbit(1000);
        scrollToElement(format(EDIT_USERNAME,userName));
        findBy(format(EDIT_USERNAME,userName)).click();
        waitAbit(1000);
        String field1 = format(CLICK_USERNAME,userName);
        findBy(field1).clear();
        findBy(format(field1)).type(field);
    }

    private static final String  CLICK_ON_TIMEZONE_DROPDOWN=".//input[contains(@id, 'Select')]/preceding-sibling::div" ;

    public void editTimeZone(String timeZone,String zone) {
        waitAbit(1000);
        findBy(format(EDIT_TIMEZONE,timeZone)).click();
        waitAbit(1000);
        findBy(format(CLICK_ON_TIMEZONE_DROPDOWN,timeZone)).click();
        scrollToElement(format(ROLE,zone));
        findBy(format(ROLE,zone)).click();


    }

    private static final String  EDIT_LANGUAGE_SPOKEN = "(//h2/*[local-name() = 'svg' and @aria-hidden='true'])[2]" ;
    public void editLaguageSpoken(String languageSpoken) {
        waitAbit(1000);
        findBy(EDIT_LANGUAGE_SPOKEN).click();
        waitAbit(1000);
        findBy(ROLE_FIE).click();
        scrollToElement(format(ROLE,languageSpoken));
        findBy(format(ROLE,languageSpoken)).click();

    }

    private static final String REMOVEBUTTON = "//div[contains(@class,'details_user-roles')]/../../..//tbody//tr[@class and .//td[text()='Provider Supervisor']]//button[@type='button']" ;

    public void removeRoleFromUserDetails(String remove) {
        waitAbit(1000);
        scrollToElement(format(REMOVEBUTTON,remove));
        findBy(format(REMOVEBUTTON,remove)).click();
    }

    private static final String ADD_BUTTON_USER_DETAILS =   ".//h1[contains(text(),'Roles')]/../..//button[span[text()=' ADD']]" ;
    public void clickOnAddbuttonFromUserDetails(){
        waitAbit(1000);
        scrollToElement(ADD_BUTTON_USER_DETAILS);
        findBy(ADD_BUTTON_USER_DETAILS).click();
    }
    private static final String SELECT_ROLE_FROM_USER_DETAILS = ".//input[contains(@id, 'Role')]/preceding-sibling::div" ;
    private static final String POP_UP = "//div[@role='document']";
    private static final String DROPDOWN_LIST = "//div[@role='document']/ul";
    public void selectAnyRoleFromUserDetaisPage(String role) {
        waitForPopUpOpened();
        scrollToElement(SELECT_ROLE_FROM_USER_DETAILS );
        waitAbit(1000);
        findBy(SELECT_ROLE_FROM_USER_DETAILS ).click();
        BaseModalPanel dropDown = new BaseModalPanel(findBy(POP_UP), this);
        dropDown.selectFromMultiChoiceDropDown(role);
        action().sendKeys(Keys.TAB).build().perform();
        waitForAbsenceOf(DROPDOWN_LIST);
    }
    public void getDeactiveUserDetails() {}


    public GeneralInformationPanel getGenaralInfo(){
        return  new GeneralInformationPanel(
                findBy(ADD_GENERALINFORMATION_PANEL),this);
    }

    public SecurityPalicyPanel getpasswordPolicyinfor(){
        return  new SecurityPalicyPanel(
                findBy(PASSWORD_POLICY_PANEL),this);
    }

    //private static final String PAYMENT_FEES_PANEL = ".//body[contains(@style,'margin')]";
    //sp57
    private static final String PAYMENT_FEES_PANEL = ".//body//div[@id='root']" ;

    public PaymentFeesPanel getPaymentFeesfor(){
        return  new PaymentFeesPanel(
                findBy(PAYMENT_FEES_PANEL),this);
    }

   // private static final String AUTO_ARCHIVE_PANEL = ".//body[contains(@style,'margin')]";

    //sp57

    private static final String AUTO_ARCHIVE_PANEL = ".//body//div[@id='root']";
    public AutoArchivePanel getAutoArchiveInfo(){
        return  new AutoArchivePanel(
                findBy(AUTO_ARCHIVE_PANEL),this);
    }

    //private static final String SCREENING_PANEL = ".//body[contains(@style,'margin')]";
    //sp57
    private static final String SCREENING_PANEL = ".//body//div[@id='root']" ;

    public ScreeningPanel getScreeningInfo(){
        return  new ScreeningPanel(
                findBy(SCREENING_PANEL),this);
    }

    public void scrollToGeneralInfor(){scrollToElement(ADD_GENERALINFORMATION_PANEL);}

    private static final String CLICK_PROVIDER_DETAILS_ACTION_MENU = ".//div[contains(@class, 'detailed-panel-menu')]//button" ;
    private static final String DROP_DOWN_OPTION = "//ul/li[text() = '%s']";


    public void selectActionFromProviderDetails(String action) {
        scrollToElement(CLICK_PROVIDER_DETAILS_ACTION_MENU);
        findBy(CLICK_PROVIDER_DETAILS_ACTION_MENU).click();
        waitABit(200);
        action().moveToElement(findBy(String.format(DROP_DOWN_OPTION, action))).click().build().perform();
    }

    public boolean isTerminationOrReactivationdisplaying(String action) {
        scrollToElement(CLICK_PROVIDER_DETAILS_ACTION_MENU);
        findBy(CLICK_PROVIDER_DETAILS_ACTION_MENU).click();
        waitABit(200);
        return  findBy(format(DROP_DOWN_OPTION,action)).isDisplayed();

    }

    //
    private static final String PROVIDER_TERMINATE = ".//p[contains(text(),'Your enrollment has been terminated.')]";
    public boolean prividerTerminated(){
        waitAbit(2000);
        return findBy(PROVIDER_TERMINATE).isDisplayed();}
    //
    private static final String BACK_FROM_TERMINATED_PROVIDER  = ".//button/span[text()='BACK']";
    public void backFromTerminatedProvider(){
        waitAbit(1000);
        jsClick(BACK_FROM_TERMINATED_PROVIDER);}

    public void isTerminationOrReactivationNotdisplaying(String action) {
        scrollToElement(CLICK_PROVIDER_DETAILS_ACTION_MENU);
        findBy(CLICK_PROVIDER_DETAILS_ACTION_MENU).click();
        waitABit(200);
        findBy(format(DROP_DOWN_OPTION,action)).shouldNotBePresent();

    }
    public void clickOnActionMenu(){
        scrollToElement(CLICK_PROVIDER_DETAILS_ACTION_MENU);
        findBy(CLICK_PROVIDER_DETAILS_ACTION_MENU).click();
        waitABit(200);

    }


    private static final String USER_ACTIVATION_POPUP= "//h2/div[contains(text(), 'Provider Termination')]/../../parent::div";

    public boolean isUserTerminationPopupOpened() {
        return isElementPresent(USER_ACTIVATION_POPUP);
    }

    private static final String TERMINATE_FROM_DATE = ".//label[contains(text(),'Terminate from')]/..//div/input[@placeholder='MM/DD/YYYY']" ;
    private static final String REACTIVATE_FROM_DATE = ".//label[contains(text(),'Reactivate from')]/..//div/input[@placeholder='MM/DD/YYYY']" ;

    public void fillProviderReactivateDate(String reactiveDate) {

        jsClick(REACTIVATE_FROM_DATE);
        findBy(REACTIVATE_FROM_DATE).click();
        findBy(format(REACTIVATE_FROM_DATE, reactiveDate)).clear();
        findBy(REACTIVATE_FROM_DATE).type(reactiveDate);
    }
    public void fillProviderTerminateDate(String terminateDate) {

        jsClick(TERMINATE_FROM_DATE);
        findBy(TERMINATE_FROM_DATE).click();
        findBy(format(TERMINATE_FROM_DATE, terminateDate)).clear();
        waitAbit(2000);
        findBy(format(TERMINATE_FROM_DATE, terminateDate)).type(terminateDate);

    }

    //sp21 adding
    private static final String SUSPENDED_FROM_DATE =".//label[contains(text(),'Suspended from')]/..//div/input[@placeholder='MM/DD/YYYY']";

    public void fillProviderSuspendedDate(String suspenedeDate) {

        jsClick(SUSPENDED_FROM_DATE);
        findBy(SUSPENDED_FROM_DATE).click();
        findBy(format(SUSPENDED_FROM_DATE, suspenedeDate)).clear();
        waitAbit(2000);
        findBy(format(SUSPENDED_FROM_DATE, suspenedeDate)).type(suspenedeDate);
    }

    private static final String CLICK_ON_TERMINATE_REACTIVATE_BUTTON = ".//button/span[contains(text(),'%s')]" ;
    private static final String CLICK_OK_BUTTON_TO_TERMINATE_REACTIVATE = ".//button/span[contains(text(),'OK')]" ;

    public void clickOnTerminationAndReactivationButton(String button){
        findBy(format(CLICK_ON_TERMINATE_REACTIVATE_BUTTON,button)).click();
        findBy(CLICK_OK_BUTTON_TO_TERMINATE_REACTIVATE).click();
    }

    public void setReason(String reason,String note) {
        waitAbit(1000);
  //      jsClick(REASON_FIELD);
        findBy(REASON_FIELD).click();
        scrollToElement(format(REASON,reason));
        waitAbit(1000);
        findBy(format(REASON, reason)).click();
        waitAbit(1000);
        findBy(NOTE).click();
        waitAbit(1000);
        findBy(NOTE).type(note);
        waitAbit(1000);
    }
    public void setReasonForProviderTermination(String reason,String note){
        waitAbit(1000);
        //      jsClick(REASON_FIELD);
        findBy(REASON_FIELD).click();
        scrollToElement(format(REASON,reason));
        waitAbit(1000);
        findBy(format(REASON, reason)).click();
        waitAbit(1000);
        findBy(NOTE).click();
        waitAbit(1000);
        findBy(NOTE).type(note);
        waitAbit(1000);
    }
    private static final String  CLICK_ON_PERMISSION_NAME = ".//span[contains(text(),'Provider - Display page')]";

    public void clickOnPermissionName(String name){
        scrollToElement(format(CLICK_ON_PERMISSION_NAME, name));
        findBy(format(CLICK_ON_PERMISSION_NAME, name)).click();
        waitAbit(1000);
    }

    private static final String  CLICK_ON_PROVIDER_TERMINATE_CHECKBOX = "//div[contains(@class,'edit-view_menu')]/../../../../div[3]//span[contains(text(),'Provider - Terminate provider')]/../../div[2]/div[1]/span[1]/span[1]/input" ;
    private static final String  CLICK_ON_PROVIDER_REACTVATE_CHECKBOX = "//div[contains(@class,'edit-view_menu')]/../../../../div[3]//span[contains(text(),'Provider - Reactivate provider')]/../../div[2]/div[1]/span[1]/span[1]/input" ;

    public void selectTerminateCheckbox(){jsClick(CLICK_ON_PROVIDER_TERMINATE_CHECKBOX);}
    public void selectReactivateCheckbox(){jsClick(CLICK_ON_PROVIDER_REACTVATE_CHECKBOX);}

    private static final String  ADD_IDENTIFICATION_PANEL = ".//div[contains(@class,'section_section-inner')]" ;

    public IdentifyingInformationPanel getIdentificationInfo(){
        return  new IdentifyingInformationPanel(
                findBy(ADD_IDENTIFICATION_PANEL),this); }

    public LicensureCertificationPanel getLicensureInfo(){
        return  new LicensureCertificationPanel(findBy(ADD_IDENTIFICATION_PANEL),this);
    }

    public void fillInTaxonomyInfo(String taxonomy, String taxonomyDescription){
        jsClick(COMBOBOX_TAXONOMY);
        findBy(COMBOBOX_TAXONOMY).sendKeys();
        String element1 = String.format(COMBOBOX_TAXONOMY_OPTION1, taxonomy);
        jsClick(element1);

        jsClick(COMBOBOX_TAXONOMY_DESCRIPTION);
        findBy(COMBOBOX_TAXONOMY_DESCRIPTION).sendKeys(taxonomyDescription);
        String element2 = String.format(COMBOBOX_TAXONOMY_OPTION, taxonomyDescription);
        //  jsClick(element2);

    }
    //new sp20
    public void fillInTaxonomyInfo1(String taxonomy) {
        waitAbit(1000);
        jsClick(COMBOBOX_TAXONOMY);
        findBy(COMBOBOX_TAXONOMY).sendKeys();
        String element1 = String.format(COMBOBOX_TAXONOMY_OPTION1, taxonomy);
        jsClick(element1);
    }

    public AddressPanel getAddressInfo(){
        return  new AddressPanel(findBy(ADD_IDENTIFICATION_PANEL),this); }

    private static final String  TP_ADDRESSDETAILS_PANEL = ".//div[contains(@class,'section_section-inner')]" ;
    public TPAddressDetailsPanel getAddressDetails(){
        return  new TPAddressDetailsPanel(findBy(TP_ADDRESSDETAILS_PANEL),this);
    }

    private static final String  TP_IDENTIFICATION_ADDRESS_PANEL = ".//div[contains(@class,'section_section-inner')]" ;
    public TPAddressInfoPanel getTPAddressinfo(){
        return  new TPAddressInfoPanel(findBy(TP_IDENTIFICATION_ADDRESS_PANEL),this);
    }
    public ProviderIdentifierNumberPanel getnpiInfo(){
        return  new ProviderIdentifierNumberPanel(findBy(ADD_IDENTIFICATION_PANEL),this); }


    public void fillInProviderEnrollment(String firstName, String lastName, String gender,
                                         String dateOfBirth, String email, String providerType,
                                         String speciality, String npi, String providerAddress,
                                         String building, String zip){

        clickOnSection("Identifying Information");
        getIdentificationInfo().setFirstName(firstName);
        getIdentificationInfo().setLastName(lastName);
        getIdentificationInfo().setGender(gender);
        getIdentificationInfo().setDateOfBirth(dateOfBirth);
        getIdentificationInfo().setEmail(email);
        clickOnSection("Licensure");
        waitAbit(3000);
        getLicensureInfo().setProviderType(providerType);
        getLicensureInfo().setSpeciality(speciality);
        clickOnSection("Provider Identifier Number");
        getnpiInfo().setNpi(npi);
        clickOnSection("Address Details");
        getAddressInfo().setProviderAddress(providerAddress);
        getAddressInfo().setBuilding(building);
        getAddressInfo().setZip(zip);
        clickOnSection("Communication Preference");
        getAddressInfo().setProviderAddress(providerAddress);
        getAddressInfo().setBuilding(building);
        getAddressInfo().setZip2(zip);
    }


    public void clickOnType() {
        findBy(BODY).click();
        waitForAbsenceOf(SPINNER);
    }

    public void clickOnSection(String section) {
        String element = String.format(SECTION, section);
        waitForPresenceOf(element);
        scrollToElement(element);
        findBy(element).click();
    }

    public void clickTrainingRequiredCheckbox(){
        withTimeoutOf(30, TimeUnit.SECONDS).waitForElementsToDisappear(By.xpath(SPINNER));
        waitForPresenceOf("//h3[text() = 'Training Required']");
        String element = "//span//input[@value='Training Required 1']";
        waitForPresenceOf(element);
        jsClick(element);

    }

    private static final String BODY =".//following-sibling::p";
    private static final String SECTION = ".//div[span[text() = '%s']]";
    //sp23
    private static final String REASSIGNROLE_PANEL = "//h2[contains(text(), 'Reassign Role')]/../parent::div";
    public boolean isReassignRolePopupOpened() {
        waitAbit(500);
        return isElementPresent(REASSIGNROLE_PANEL);
    }
    private static final String EMAIL_ID = "//label[text()='Email']/../div/input" ;
    public void fillEmailId(String email) {
        findBy(EMAIL_ID).type(email);
    }
    private static final String REASSIGN_BUTTON =  "//span[text()='Reassign']";
    private static final String OK_BUTTON =".//button/span[text()='OK']";
    public void clickReassignButton(){
        jsClick(REASSIGN_BUTTON);
        waitAbit(1000);
        findBy(OK_BUTTON).click();
        waitAbit(500);
    }

    public void clickReassignButtonForValidation(){
        jsClick(REASSIGN_BUTTON);
        waitAbit(500);
    }
    //sp25
    private static final String AUTO_TERMINATE_PASSWORD_POLICY_PANEL =".//div/h3[text()='Enable Auto Terminate']/../../..";
    public SecurityPalicyPanel getAutoTerminatepasswordPolicyinfo(){
        return  new SecurityPalicyPanel(
                findBy(AUTO_TERMINATE_PASSWORD_POLICY_PANEL),this);
    }
    //sp26
    private static final String PRIMARY_TAXONOMY = "//label[text()='Primary Taxonomy']//ancestor::div[@role='combobox']//input";
    private static final String PRIMARY_TAXONOMY_OPTION = "//ul[@role='listbox']//li/div/div/strong[text()='%s']";
    public void fillPrimaryTaxonomy(String taxonomy) {
        waitAbit(1000);
        jsClick(PRIMARY_TAXONOMY);
        findBy(PRIMARY_TAXONOMY).sendKeys();
        //sp28
        try {
            String element = String.format(PRIMARY_TAXONOMY_OPTION, taxonomy);
            jsClick(element);
            waitAbit(1000);
        }
        catch (Exception e){
            System.out.println("Pass the Primary Taxonomy Option");
        }
    }
    //sp29
    private static final String PHARMACY_PRIMARY_TAXONOMY_CODE = "//label[text()='Primary Taxonomy Code']//ancestor::div[@role='combobox']//input";
    public void fillPrimaryTaxonomyCode(String taxonomy) {
        waitAbit(1000);
        jsClick(PHARMACY_PRIMARY_TAXONOMY_CODE);
        findBy(PHARMACY_PRIMARY_TAXONOMY_CODE).sendKeys();
        try {
            String element = String.format(PRIMARY_TAXONOMY_OPTION, taxonomy);
            jsClick(element);
            waitAbit(1000);
        }
        catch (Exception e){
            System.out.println("Pass the Pharmacy Primary Taxonomy Option");
        }
    }
    private static final String MONITORING_PANEL = ".//div[contains(text(),'Monitoring Frequency')]/..";
    public ScreeningPanel getMonitoringScreeningInfo(){
        return  new ScreeningPanel(
                findBy(MONITORING_PANEL),this);
    }
    //sp34
    private static final String BACK_TO_LOGIN = ".//div/a//span[text()='Back to log in']";
    public void clickBacktoLogin() {
        waitAbit(500);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        jsClick(BACK_TO_LOGIN);
        waitAbit(2000);
    }

    public void clickBacktoLogin1() {
        waitAbit(500);
        jsClick(BACK_TO_LOGIN);
        waitAbit(2000);
    }

    //sp34
    private static final String BACK_TO_LOGIN2 = ".//div/a//span[text()='Back To Log In']";
    public void clickBacktoLogin2() {
        waitAbit(500);
//        ArrayList<String> tabs waitAbit(500);= new ArrayList<String>(getDriver().getWindowHandles());
//        getDriver().close();
//        getDriver().switchTo().window(tabs.get(1));
        //jsClick(BACK_TO_LOGIN2);
        findBy(BACK_TO_LOGIN2).click();
        waitAbit(2000);
    }

    //sp37
    private static final String PROVIDERFIRSTNAME = ".//label[contains(text(),'First Name')]";
    private static final String PROVIDERFIRSTNAMETEXTAREA = ".//label[contains(text(),'First Name')]/..//div//textarea[3]";
    private static final String PROVIDERLASTNAME = ".//label[contains(text(),'Last Name')]";
    private static final String PROVIDERLASTNAMETEXTAREA = ".//label[contains(text(),'Last Name')]/..//div//textarea[3]";
    private static final String PROVIDEREMAIL = ".//label[contains(text(),'Email')]";
    private static final String PROVIDEREMAILTEXTAREA = ".//label[contains(text(),'Email')]/..//div//textarea[3]";
    private static final String PROCCED = ".//button//span[text()='Proceed']";

    public void fillProviderDetails(String userEmail,String firstName,String lastName) {
        waitAbit(100);
        jsClick(PROVIDEREMAIL);
        findBy(PROVIDEREMAILTEXTAREA).sendKeys(userEmail);
        waitAbit(100);
        jsClick(PROVIDERFIRSTNAME);
        findBy(PROVIDERFIRSTNAMETEXTAREA).sendKeys(firstName);
        waitAbit(100);
        jsClick(PROVIDERLASTNAME);
        findBy(PROVIDERLASTNAMETEXTAREA).sendKeys(lastName);
        waitAbit(100);
        jsClick(PROCCED);
        waitAbit(100);
    }
    //sp37
    private static final String CONTINUE_BUTTON = ".//button//span[text()='Continue']";
    public void clickOnContinueButton() {
        waitAbit(100);
        jsClick(CONTINUE_BUTTON);
        waitAbit(100);

    }

    //Demo
    //sp60
    private static final String ADDITIONAL_TAXONOMY_DROPDOWN_FIELD =  ".//input[contains(@id, 'Additional Taxonomies (Select All that Applies)')]/preceding-sibling::div";
    private static final String ADDITIONAL_TAXONOMY = ".//ul/li[contains(text(), '%s')]";
    public void selectAdditionalTaxonomy(String additionalTaxonomy) {
        waitAbit(1000);
        jsClick(ADDITIONAL_TAXONOMY_DROPDOWN_FIELD);
//        scrollToElement(ADDITIONAL_TAXONOMY);
//        waitAbit(1000);
//        jsClick(ADDITIONAL_TAXONOMY); waitAbit(1000);
        scrollToElement(format(ADDITIONAL_TAXONOMY,additionalTaxonomy));
        waitAbit(1000);
        findBy(format(ADDITIONAL_TAXONOMY,additionalTaxonomy)).click();
        waitAbit(1000);
        action().sendKeys(Keys.TAB).build().perform();
        waitABit(500);
    }

//sp60
    private static final String LANGUAGE_DROPDOWN_FIELD =  ".//input[contains(@id, 'Language Supported (Select all that apply)')]/preceding-sibling::div";
    private static final String LANGUAGE = ".//ul/li[contains(text(), '%s')]";
    public void selectLanguage(String language) {
        waitAbit(1000);
        jsClick(LANGUAGE_DROPDOWN_FIELD);
        scrollToElement(format(LANGUAGE,language));
        waitAbit(1000);
        findBy(format(LANGUAGE,language)).click();
        waitAbit(1000);
        action().sendKeys(Keys.TAB).build().perform();
        waitABit(500);
    }

    //sp54 new ui  gmail link

    private static final String EMAIL_LIN = "(.//td//a[contains(text(),'Confirm Account')])[1]";

    private static final String TOOLTIP_ICON = ".//div[contains(@data-tooltip,'Show trimmed content')]/img";

    public  void clickOnNewUserLinkFromGmail(){
        waitForSpinnerToDisappear();
        try {
            withTimeoutOf(Duration.ofSeconds(3)).waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(TOOLTIP_ICON)));
            jsClick(TOOLTIP_ICON);

        }catch (Exception e) {
            waitFor(ExpectedConditions.elementToBeClickable(By.xpath(EMAIL_LIN)));
            waitForSpinnerToDisappear();
            waitAbit(500);
//            scrollToElement(EMAIL_LIN);
//            jsClick(EMAIL_LIN);
            //sp29
            waitAbit(500);
            // findBy(EMAIL_LINK).waitUntilEnabled().click();
        }
        scrollToElement(EMAIL_LIN);
        jsClick(EMAIL_LIN);
    }

   //sp57
    public void clickOnApplyButton(){
        waitAbit(200);
        jsClick(APPLY);
        waitAbit(200);
    }

    private static final String USER_LINK = ".//td//a[text()='link']";
    public void clickOnLinkInGmail(){
        try {
            withTimeoutOf(Duration.ofSeconds(3)).waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(TOOLTIP_ICON)));
            jsClick(TOOLTIP_ICON);

        }catch (Exception e) {}
        scrollToElement(USER_LINK);
        jsClick(USER_LINK);

    }

    //SD 07
    private static final String TOOLTIP = "//span[text()='%s']";
    private static final String TOOLTIP_BUTTON = "//span[text()='%s']/../div//span[text()='%s']/..";
    public void clickTooltip(String button, String tooltip){
        if(isElementPresent(format(TOOLTIP,tooltip)))
            System.out.println(tooltip +" presents");
        else
            System.out.println(tooltip +" not presents");
        findBy(format(TOOLTIP_BUTTON,tooltip,button)).click();
    }

    public void fillProviderDetails1(String firstName,String lastName) {
        waitAbit(100);
        jsClick(PROVIDERFIRSTNAME);
        findBy(PROVIDERFIRSTNAMETEXTAREA).sendKeys(firstName);
        waitAbit(100);
        jsClick(PROVIDERLASTNAME);
        findBy(PROVIDERLASTNAMETEXTAREA).sendKeys(lastName);
        waitAbit(100);
        jsClick(PROCCED);
        waitAbit(100);
    }


    private static final String DEATH_DATE = ".//label[contains(text(), 'Death Date')]/parent::div//input";
    public void setDeathDate(String deathDate){
        waitAbit(500);
        findBy(DEATH_DATE).type(deathDate);
        waitAbit(500);
        findBy(NOTE).click();
        waitAbit(500);
    }

    private static final String DEATH_DATE_MESSAGE = ".//label[contains(text(), 'Death Date')]/parent::div/../p[text()='%s']";
    public boolean isDeathDateMessagePresent(String message){
        return isElementPresent(format(DEATH_DATE_MESSAGE, message));
    }

    private static final String BUTTON = ".//button[span[normalize-space()='%s']]" ;
    public boolean isButtonEnabled(String button){
        return findBy(format(BUTTON, button)).isEnabled();
    }


    private static final String TIME_ZONE_DROPDOWN = "//input[contains(@id, 'Time Zone')]/preceding-sibling::div";
    private static final String LANGUAGE_DROPDOWN = "//div[contains(@id, 'Language')]";
    private static final String DISPLAY_NAME = "//label[text()='Display Name']/../div/input";
    private static final String COMPANY = "//label[text()='Company']/../div/input";
    private static final String JOB_TITLE = "//label[text()='Job Title']/../div/input";
    private static final String DEPARTMENT = "//label[text()='Department']/../div/input";
    private static final String LOCATION = "//label[text()='Location']/../div/input";
    private static final String MOBILE = "//label[text()='Mobile']/../div/input";
    private static final String PHONE = "//label[text()='Phone']/../div/input";
    private static final String EXT = "//label[text()='Ext']/../div/input";
    private static final String FAX = "//label[text()='Fax']/../div/input";

    public void setTimeZone(String timeZone) {
        scrollToElement(TIME_ZONE_DROPDOWN);
        waitAbit(500);
        jsClick(TIME_ZONE_DROPDOWN);
        waitAbit(500);
        scrollToElement(format(DROP_DOWN_OPTION, timeZone));
        waitAbit(500);
        findBy(format(DROP_DOWN_OPTION, timeZone)).click();
        waitAbit(500);
    }

    public void setLanguages(String languages)  {
        scrollToElement(LANGUAGE_DROPDOWN);
        waitAbit(500);
        jsClick(LANGUAGE_DROPDOWN);
        waitAbit(500);
        scrollToElement(format(DROP_DOWN_OPTION, languages));
        waitAbit(500);
        findBy(format(DROP_DOWN_OPTION, languages)).click();
        waitAbit(500);
        findBy("//html").click();
        waitAbit(500);
    }

    public void setDisplayName(String displayName)  {
        scrollToElement(DISPLAY_NAME);
        waitAbit(500);
        findBy(DISPLAY_NAME).type(displayName);
        waitAbit(500);
    }

    public void setCompany(String company) {
        scrollToElement(COMPANY);
        waitAbit(500);
        findBy(COMPANY).type(company);
        waitAbit(500);
    }

    public void setJobTitle(String jobTitle) {
        scrollToElement(JOB_TITLE);
        waitAbit(500);
        findBy(JOB_TITLE).type(jobTitle);
        waitAbit(500);
    }

    public void setDepartment(String department) {
        scrollToElement(DEPARTMENT);
        waitAbit(500);
        findBy(DEPARTMENT).type(department);
        waitAbit(500);
    }

    public void setLocation(String location) {
        scrollToElement(LOCATION);
        waitAbit(500);
        findBy(LOCATION).type(location);
        waitAbit(500);
    }

    public void setMobile(String mobile) {
        scrollToElement(MOBILE);
        waitAbit(500);
        findBy(MOBILE).type(mobile);
        waitAbit(500);
    }

    public void setFax(String fax) {
        scrollToElement(FAX);
        waitAbit(500);
        findBy(FAX).type(fax);
        waitAbit(500);
    }

    public void setPhone(String phone) {
        scrollToElement(PHONE);
        waitAbit(500);
        findBy(PHONE).type(phone);
        waitAbit(500);
    }

    public void setExt(String ext) {
        scrollToElement(EXT);
        waitAbit(500);
        findBy(EXT).type(ext);
        waitAbit(500);
    }

    private static final String PROVIDER_ID="//div[contains(@class,'expansion-panel-summary')]/div/div[3]/div/div[2]/p";
//    //div[contains(@class,'expansion-panel-summary')]//div[4]//div//div[2]//p
    public String getProviderID(){
        scrollToElement(PROVIDER_ID);
        waitAbit(10000);
        String providerID=getDriver().findElement(By.xpath(PROVIDER_ID)).getText();
        System.out.println(providerID);
        return providerID;
    }
    private static final String PROVIDER_ID_FROM_COC="//div[contains(@class,'expansion-panel-summary')]//div[4]//div//div[2]//p";

    public String getProviderId(){
        waitAbit(1000);
        String providerID=getDriver().findElement(By.xpath(PROVIDER_ID_FROM_COC)).getText();
        System.out.println(providerID);
        return providerID;
    }


}
