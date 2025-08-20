package com.hhstechgroup.ui.pages.rolespermssions;

import com.hhstechgroup.ui.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import static java.lang.String.format;

public class RolePermissionPage extends AbstractPage {

//latest
    private static final String EDIT_BUTTON  = "//button/span[contains(text(), 'Edit')]";
    //latest
   // private static final String  SELECT_SWITCH_IN_DASHBOARD = "//div[@class='edit-view_menu_3pP2k']/../../../../div[2]/../div/div/div/div/div/label[1]";
   // private static final String  SELECT_READ_IN_DASHBOARD = "//div[contains(@class,'edit-view_action')][1]/span//following-sibling::input";
    private static final String  SELECT_READ_IN_DASHBOARD =  "//div[contains(@class,'edit-view_menu')]/../../../../div[2]/div[1]/div/div/div[2]/div[1]";
    private static final String   SAVE_CHANGES = "//span[text()='Save changes']/parent::button";
    private static final String   DASHBOARD_BUTTON = ".//div//ul//li//a[text()='←Back to dashboard']";
    private static final String    DASHBOARD_TAB_LIST = ".//div//div[@role='tablist']";
//old
    private static final String  SELECT_SWITCH_IN_DASHBOARD =  "//div[contains(@class,'edit-view_controls')]/../../../../../div[2]/div[@role='button']//label";
    private static final String  DESABLE_ALL_SWITCHES= "//div[contains(@class,'edit-view_expansionPanel')]/div//label/span[1]/span[contains(@class,'edit-view_switch')]";
   // private static final String  DESABLE_ALL_SWITCHES= "//span[contains(@class,'edit-view_switch')]";
    private static final String  ENABLE_ANY_SWITCH = "//div[contains(@class,'edit-view_controls')]/span[contains(text(),'%s')]";



    public RolePermissionPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnEditButtonInRolesDetailsPage() {jsClick(EDIT_BUTTON); waitAbit(2000);}

    public void desableAlltheSwitches(){
        while(isElementPresent(DESABLE_ALL_SWITCHES))
        {
            scrollToElement(DESABLE_ALL_SWITCHES);
            findBy(DESABLE_ALL_SWITCHES).click();
            waitAbit(500);
        }

    }
    /*public void enableAnyPermissionSwitch(String tab){
        while (isElementPresent(ENABLE_ANY_SWITCH)) {
           // scrollToElement(format(ENABLE_ANY_SWITCH, tab));
           // waitAbit(1000);
            findBy(SELECT_READ_IN_DASHBOARD).click();
            waitAbit(3000);
        }

    }*/


    public void enableDashboardPermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_READ_IN_DASHBOARD).click();
       // findBy(format(ENABLE_ANY_SWITCH, tab)).click();
        waitAbit(1000);


    }



    public void selectDashboardDisplayPageSection() {jsClick(SELECT_SWITCH_IN_DASHBOARD );waitAbit(2000);}
    public void selectReadOptionInDashboardDisplayPageSection(){jsClick(SELECT_READ_IN_DASHBOARD ); waitAbit(3000);}
    public void clickOnSaveChangesButton() {waitAbit(2000);jsClick(SAVE_CHANGES);}
    public void clickbackToDashboardButton() {waitAbit(2000);jsClick(DASHBOARD_BUTTON );
      // getDriver().navigate().refresh();
       waitAbit(10000);}
    public String getAlltheSectionsListInDashBoard(){return findBy(DASHBOARD_TAB_LIST).getText();}

    private static final String ALL_REQUESTS = ".//div[@role='tablist']/div/button//span[text()='All Requests']";
    private static final String ENROLLMENT = ".//div[@role='tablist']/div/button//span[text()='Enrollment']";
    private static final String APPEAL = ".//div[@role='tablist']/div/button//span[text()='Appeals']";
    private static final String COC = ".//div[@role='tablist']/div/button//span[text()='COC']";

    public String getAllrequestTab(String requestname){waitForPresenceOf(ALL_REQUESTS);return findBy(format(ALL_REQUESTS,requestname)).getText();}
    public String getEnrollmentTab(String enrollmentname){return findBy(format(ENROLLMENT,enrollmentname)).getText();}
    public String getAppealTab(String appealname){return findBy(format(APPEAL,appealname)).getText();}
    public String getCocTab(String cocname){return findBy(format(COC,cocname)).getText();}

    public static final String SELECT_SWITCH_IN_CLAIMS = "//div[contains(@class,'edit-view_controls')]/../../../../../div[9]/div[@role='button']//label";



    public void selectClaimsDisplayPageSection() {jsClick(SELECT_SWITCH_IN_CLAIMS);}
    public void selectReadOptionInClaimsDisplayPageSection(){jsClick(SELECT_READ_IN_CLAIMS);waitAbit(3000);}

//claims permissions
    private static final String  SELECT_READ_IN_CLAIMS = "//div[contains(@class,'edit-view_menu')]/../../../../div[9]/div[1]/div/div/div[2]/div[1]";

    public void enableClaimsPermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_SWITCH_IN_CLAIMS).click();
        waitAbit(1000);
    }
//form 1099 permissions
    private static final String  SELECT_READ_IN_1099 = "//div[contains(@class,'edit-view_menu')]/../../../../div[10]/div[1]/div/div/div[2]/div[1]";

    public void enable1099PermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_READ_IN_1099).click();
        waitAbit(1000);
    }

//Coc permissions

    private static final String  SELECT_READ_IN_COC = "//div[contains(@class,'edit-view_menu')]/../../../../div[5]/div[1]/div/div/div[2]/div[1]";
    private static final String  SELECT_EDIT_IN_COC = "//div[contains(@class,'edit-view_menu')]/../../../../div[5]/div[1]/div/div/div[2]/div[2]";
    private static final String  SELECT_CREATE_IN_COC = "//div[contains(@class,'edit-view_menu')]/../../../../div[5]/div[1]/div/div/div[2]/div[3]";
    private static final String  SELECT_DELETE_IN_COC = "//div[contains(@class,'edit-view_menu')]/../../../../div[5]/div[1]/div/div/div[2]/div[4]";


    public void enableCocPermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_READ_IN_COC).click();
        findBy(SELECT_EDIT_IN_COC).click();
        findBy(SELECT_CREATE_IN_COC).click();
        findBy(SELECT_DELETE_IN_COC).click();
        waitAbit(1000);
    }


    //Appeal permissions

    private static final String  SELECT_READ_IN_APPEAL = "//div[contains(@class,'edit-view_menu')]/../../../../div[7]/div[1]/div/div/div[2]/div[1]";
    private static final String  SELECT_EDIT_IN_APPEAL = "//div[contains(@class,'edit-view_menu')]/../../../../div[7]/div[1]/div/div/div[2]/div[2]";
    private static final String  SELECT_CREATE_IN_APPEAL = "//div[contains(@class,'edit-view_menu')]/../../../../div[7]/div[1]/div/div/div[2]/div[3]";
    private static final String  SELECT_DELETE_IN_APPEAL = "//div[contains(@class,'edit-view_menu')]/../../../../div[7]/div[1]/div/div/div[2]/div[4]";


    public void enableAppealPermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_READ_IN_APPEAL).click();
        findBy(SELECT_EDIT_IN_APPEAL).click();
        findBy(SELECT_CREATE_IN_APPEAL).click();
        findBy(SELECT_DELETE_IN_APPEAL).click();
        waitAbit(1000);
    }

    //Reports permissions

    private static final String  SELECT_READ_IN_REPORTS = "//div[contains(@class,'edit-view_menu')]/../../../../div[12]/div[1]/div/div/div[2]/div[1]";
    private static final String  REPORTS_NAMES = ".//div/button[contains(@type,'button')]";

    public void enableReportsPermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_READ_IN_REPORTS).click();
        waitAbit(1000);
    }
    public void isReportsNamesDisplaying(String canned,String letter,String adhoc) {
        findBy(format(REPORTS_NAMES)).isDisplayed();
    }


    //General permissions

    private static final String  SELECT_READ_IN_GENERAL = "//div[contains(@class,'edit-view_menu')]/../../../../div[1]/div[1]/div/div/div[2]/div[1]";
    private static final String  SELECT_EDIT_IN_GENERAL = "//div[contains(@class,'edit-view_menu')]/../../../../div[1]/div[1]/div/div/div[2]/div[2]";

    public void enableGeneralPermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_READ_IN_GENERAL).click();
        findBy(SELECT_EDIT_IN_GENERAL).click();
        waitAbit(1000);
    }


    //System Options permissions

    private static final String  SELECT_READ_IN_SYSTEM_OPTIONS = "//div[contains(@class,'edit-view_menu')]/../../../../div[16]/div[1]/div/div/div[2]/div[1]";
    private static final String  SELECT_EDIT_IN_SYSTEM_OPTIONS  = "//div[contains(@class,'edit-view_menu')]/../../../../div[16]/div[1]/div/div/div[2]/div[2]";
    private static final String  SELECT_CREATE_IN_SYSTEM_OPTIONS  = "//div[contains(@class,'edit-view_menu')]/../../../../div[16]/div[1]/div/div/div[2]/div[3]";
    private static final String  SELECT_DELETE_IN_SYSTEM_OPTIONS  = "//div[contains(@class,'edit-view_menu')]/../../../../div[16]/div[1]/div/div/div[2]/div[4]";


    public void enableSystemOptionsPermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_READ_IN_SYSTEM_OPTIONS).click();
        findBy(SELECT_EDIT_IN_SYSTEM_OPTIONS).click();
        findBy(SELECT_CREATE_IN_SYSTEM_OPTIONS).click();
        findBy(SELECT_DELETE_IN_SYSTEM_OPTIONS).click();
        waitAbit(1000);
    }

    //Enrollment permissions

    private static final String  SELECT_READ_IN_ENROLLMENT = "//div[contains(@class,'edit-view_menu')]/../../../../div[4]/div[1]/div/div/div[2]/div[1]";
    private static final String  SELECT_EDIT_IN_ENROLLMENT  = "//div[contains(@class,'edit-view_menu')]/../../../../div[4]/div[1]/div/div/div[2]/div[2]";
    private static final String  SELECT_CREATE_IN_ENROLLMENT = "//div[contains(@class,'edit-view_menu')]/../../../../div[4]/div[1]/div/div/div[2]/div[3]";
    private static final String  SELECT_DELETE_IN_ENROLLMENT  = "//div[contains(@class,'edit-view_menu')]/../../../../div[4]/div[1]/div/div/div[2]/div[4]";



    public void enableEnrollmentPermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_READ_IN_ENROLLMENT).click();
        findBy(SELECT_EDIT_IN_ENROLLMENT).click();
        findBy(SELECT_CREATE_IN_ENROLLMENT).click();
        findBy(SELECT_DELETE_IN_ENROLLMENT).click();
        waitAbit(1000);
    }


    //Payment permissions

    private static final String  SELECT_READ_IN_PAYMENT = "//div[contains(@class,'edit-view_menu')]/../../../../div[8]/div[1]/div/div/div[2]/div[1]";

    public void enablePaymentPermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_READ_IN_PAYMENT).click();
        waitAbit(1000);
    }

   //Provider permissions

    private static final String  SELECT_READ_IN_PROVIDER = "//div[contains(@class,'edit-view_menu')]/../../../../div[3]/div[1]/div/div/div[2]/div[1]";
    private static final String  SELECT_EDIT_IN_PROVIDER  = "//div[contains(@class,'edit-view_menu')]/../../../../div[3]/div[1]/div/div/div[2]/div[2]";

    public void enableProviderPermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_READ_IN_PROVIDER).click();
        findBy(SELECT_EDIT_IN_PROVIDER).click();
        waitAbit(1000);
    }

    //MessageBox permissions

    private static final String  SELECT_READ_IN_MESSAGEBOX = "//div[contains(@class,'edit-view_menu')]/../../../../div[11]/div[1]/div/div/div[2]/div[1]";

    public void enableMessageBoxPermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_READ_IN_MESSAGEBOX).click();
        waitAbit(1000);
    }


    //Authorization permissions

    private static final String  SELECT_READ_IN_AUTHORIZATION = "//div[contains(@class,'edit-view_menu')]/../../../../div[6]/div[1]/div/div/div[2]/div[1]";
    private static final String  SELECT_EDIT_IN_AUTHORIZATION   = "//div[contains(@class,'edit-view_menu')]/../../../../div[6]/div[1]/div/div/div[2]/div[2]";

    public void enableAuthorizationPermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_READ_IN_AUTHORIZATION ).click();
        findBy(SELECT_EDIT_IN_AUTHORIZATION ).click();
        waitAbit(1000);
    }

    //Chat permissions

    private static final String  SELECT_READ_IN_CHAT = "//div[contains(@class,'edit-view_menu')]/../../../../div[15]/div[1]/div/div/div[2]/div[1]";

    public void enableChatPermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_READ_IN_CHAT).click();
        waitAbit(1000);
    }

    //HelpCentre permissions

    private static final String  SELECT_READ_IN_HELP_CENTRE = "//div[contains(@class,'edit-view_menu')]/../../../../div[14]/div[1]/div/div/div[2]/div[1]";

    public void enableHelpCentrePermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_READ_IN_HELP_CENTRE).click();
        waitAbit(1000);
    }

    //SiteVisit permissions

    private static final String  SELECT_READ_IN_SITEVISIT = "//div[contains(@class,'edit-view_menu')]/../../../../div[13]/div[1]/div/div/div[2]/div[1]";
    private static final String  SELECT_EDIT_IN_SITEVISIT  = "//div[contains(@class,'edit-view_menu')]/../../../../div[13]/div[1]/div/div/div[2]/div[2]";
    private static final String  SELECT_CREATE_IN_SITEVISIT  = "//div[contains(@class,'edit-view_menu')]/../../../../div[13]/div[1]/div/div/div[2]/div[3]";
    private static final String  SELECT_DELETE_IN_SITEVISIT  = "//div[contains(@class,'edit-view_menu')]/../../../../div[13]/div[1]/div/div/div[2]/div[4]";

    public void enableSitevisitPermissionSwitch(String tab){
        scrollToElement(format(ENABLE_ANY_SWITCH, tab));
        findBy(SELECT_READ_IN_SITEVISIT).click();
        findBy(SELECT_EDIT_IN_SITEVISIT).click();
        findBy(SELECT_CREATE_IN_SITEVISIT).click();
        findBy(SELECT_DELETE_IN_SITEVISIT).click();
        waitAbit(1000);
    }
}


