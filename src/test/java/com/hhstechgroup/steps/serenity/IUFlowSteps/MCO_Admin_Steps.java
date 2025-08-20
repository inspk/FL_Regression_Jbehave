package com.hhstechgroup.steps.serenity.IUFlowSteps;

import com.hhstechgroup.ui.pages.IUFlowPages.MCO_AdminPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;
import org.yecht.Data;

public class MCO_Admin_Steps extends ScenarioSteps {

    @Page
    MCO_AdminPages mcoAdminPages;

    public void Click_AddNewUserText(){
        mcoAdminPages.Click_AddNewUserText();
    }
    public void Fetch_StatusOfUser(){
        mcoAdminPages.Fetch_StatusOfUser();
    }
    public void openMCO_AdminEmail(String text){
        mcoAdminPages.openMCO_AdminEmail(text);
    }
    public void clickOnMCOADMINUserLinkFromGmail(){
        mcoAdminPages.clickOnMCOADMINUserLinkFromGmail();
    }

    public void set_Password(String password){
        mcoAdminPages.set_Password(password);
    }

    public void BackToLogin(){
        mcoAdminPages.BackToLogin();
    }

    public void setemail(String email){
        mcoAdminPages.fillemail(email);
    }

    public void setfirst_name(String firstname){
        mcoAdminPages.fillfirstname(firstname);
    }

    public void setlast_name(String lastname){
        mcoAdminPages.filllastname(lastname);
    }

    public void set_selctgroputype(String group){
        mcoAdminPages.selctgroputype(group);
    }

    public void searchwithusername(String criteria){
        mcoAdminPages.searchwithusername(criteria);
    }

    public void statusverification(String status){
        mcoAdminPages.statusverification(status);
    }

    public void verifexistingusemsg(String errormsg){
        mcoAdminPages.verifexistingusemsg(errormsg);
    }

    public void deactivateuser(String reason){
        mcoAdminPages.deactivateuser(reason);
    }

    public void clickonthelink(){
        mcoAdminPages.clickonthelink();
    }

    public void enterpassword(String password){
        mcoAdminPages.enterpassword(password);
    }

    public void verifygeneratedprovidercontract(){
        mcoAdminPages.verifygeneratedprovidercontract();
    }

    public void verifyinactivemsg(){
        mcoAdminPages.verifyinactivemsg();
    }

    public void reactiveMCOAdmin(String reason){
        mcoAdminPages.reactiveMCOAdmin(reason);
    }

    public void verifymcoadminpage(String verification){
        mcoAdminPages.verifyMcoAdminPage(verification);
    }


}
