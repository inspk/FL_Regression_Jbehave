package com.hhstechgroup.steps.serenity.rolespermissions;

import com.hhstechgroup.ui.pages.rolespermssions.RolePermissionPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class RolePermissionSteps {

    @Page
    RolePermissionPage rolePermissionPage ;

    @Step
    public void clickOnEditButtonInRolesDetailsPage() {rolePermissionPage.clickOnEditButtonInRolesDetailsPage();}

    @Step
    public void desableAlltheSwitches(){rolePermissionPage.desableAlltheSwitches();}

    @Step
    public void enableDashboardPermissionSwitch(String tab){rolePermissionPage.enableDashboardPermissionSwitch(tab);}

    @Step
    public void selectDashboardDisplayPageSection() {rolePermissionPage.selectDashboardDisplayPageSection();}

    @Step
    public void selectReadOptionInDashboardDisplayPageSection(){rolePermissionPage.selectReadOptionInDashboardDisplayPageSection();}

    @Step
    public void clickOnSaveChangesButton() {rolePermissionPage.clickOnSaveChangesButton();}

    @Step
    public void clickbackToDashboardButton() {rolePermissionPage.clickbackToDashboardButton();}

    @Step
    public String getAlltheSectionsListInDashBoard(){ return rolePermissionPage.getAlltheSectionsListInDashBoard();}


    @Step
    public String getAllrequestTab(String requestname){return rolePermissionPage.getAllrequestTab(requestname);}

    @Step
    public String getEnrollmentTab(String enrollmentname){return rolePermissionPage.getEnrollmentTab(enrollmentname);}

    @Step
    public String getAppealTab(String appealname){return rolePermissionPage.getAppealTab(appealname);}

    @Step
    public String getCocTab(String cocname){return rolePermissionPage.getCocTab(cocname);}


    @Step
    public void selectClaimsDisplayPageSection(){rolePermissionPage.selectClaimsDisplayPageSection();}
    @Step
    public void selectReadOptionInClaimsDisplayPageSection(){rolePermissionPage.selectReadOptionInClaimsDisplayPageSection();}

    //TC-02 - Claims

    @Step
    public void enableClaimsPermissionSwitch(String tab){rolePermissionPage.enableClaimsPermissionSwitch(tab);

    }
    //form 1099
    @Step
    public void enable1099PermissionSwitch(String tab) { rolePermissionPage.enable1099PermissionSwitch(tab);}

    //Coc
    @Step
    public void enableCocPermissionSwitch(String tab){rolePermissionPage.enableCocPermissionSwitch(tab);}

    //Appeal
    @Step
    public void enableAppealPermissionSwitch(String tab){rolePermissionPage.enableAppealPermissionSwitch(tab);}

    //Reports
    @Step
    public void enableReportsPermissionSwitch(String tab){rolePermissionPage.enableReportsPermissionSwitch(tab); }

    @Step
    public void isReportsNamesDisplaying(String canned,String letter,String adhoc){rolePermissionPage.isReportsNamesDisplaying(canned, letter, adhoc);}

    //General

    @Step
    public void enableGeneralPermissionSwitch(String tab){rolePermissionPage.enableGeneralPermissionSwitch(tab);}

    //System Options

    @Step
    public void enableSystemOptionsPermissionSwitch(String tab){rolePermissionPage.enableSystemOptionsPermissionSwitch(tab);}

    // Enrollment

    @Step
    public void enableEnrollmentPermissionSwitch(String tab){rolePermissionPage.enableEnrollmentPermissionSwitch(tab);}

    //Payment

    @Step
    public void enablePaymentPermissionSwitch(String tab){rolePermissionPage.enablePaymentPermissionSwitch(tab);}

    //Provider

    @Step
    public void enableProviderPermissionSwitch(String tab){rolePermissionPage.enableProviderPermissionSwitch(tab);}

    //Message Box

    @Step
    public void enableMessageBoxPermissionSwitch(String tab){rolePermissionPage.enableMessageBoxPermissionSwitch(tab);}

    //Authourization

    @Step
    public void enableAuthorizationPermissionSwitch(String tab){rolePermissionPage.enableAuthorizationPermissionSwitch(tab);}

   //Chat

    @Step
    public void enableChatPermissionSwitch(String tab){rolePermissionPage.enableChatPermissionSwitch(tab);}

    //Help Centre

    @Step
    public void enableHelpCentrePermissionSwitch(String tab){rolePermissionPage.enableHelpCentrePermissionSwitch(tab);}

    //Sitevisit
    @Step
    public void enableSitevisitPermissionSwitch(String tab){rolePermissionPage.enableSitevisitPermissionSwitch(tab);}

}
