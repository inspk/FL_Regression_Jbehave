package com.hhstechgroup.steps.jbehave.scenarios.systemoptions;


import com.hhstechgroup.beans.application.SecurityPolicyBean;
import com.hhstechgroup.steps.serenity.systemoption.PasswordPolicyStep;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class PasswordPolicyScenario {
   @Steps
   PasswordPolicyStep passwordPolicyStep;

   @When("click on close popup from the password policy")
   public void clickOnClosePopup() {
      passwordPolicyStep.clickOnClosePopup();
   }

   @When("user is fill the password policy info: $table")
   public void setPasswordPolicyInfor(ExamplesTable password) {
      passwordPolicyStep.setPasswordInfor(ExamplesTableUtil.parseTableToClass(password, SecurityPolicyBean.class).get(0));
   }

   @When("click on edit button in password policy page")
   public void clickOnEditButtonFromPasswordPolicy(){passwordPolicyStep.clickOnEditButtonFromPasswordPolicy();}

   @When("set up start date '$date' in password policy")
   public void fillInEffectiveDatesInPasswordPolicy(String effectiveDate){
      passwordPolicyStep.typeEffectiveDates(effectiveDate);
   }

   @When("click on save button in password policy page")
   public void clickOnSaveButtonFromPasswordPolicy(){
      passwordPolicyStep.clickOnSaveButtonFromPasswordPolicy();}

   //sp25
   @Then("{Enable|Disable} the '$value' switch in password policy page")
   public void clickOnEnableAutoTerminate(String enableautoterminate){
      passwordPolicyStep.clickOnEnableAutoTerminate(enableautoterminate);
   }
   @Then("click on Auto terminate edit button in password policy page")
   public void clickOnEditButtoninAutoTermainate(){
      passwordPolicyStep.clickOnEditButtoninAutoTermainate(); }

   @When("set the remainder  notification Period After which suspended Providers will be terminated: $table")
   public void setsuspendedProvidersTerminatedRemainders(ExamplesTable password) {
      passwordPolicyStep.setsuspendedProvidersTerminatedRemainders(ExamplesTableUtil.parseTableToClass(password, SecurityPolicyBean.class).get(0));
   }

   @Then("click on Auto Terminate save button in the password policy page")
   public void clickOnAutoTerminateSaveButton(){
      passwordPolicyStep.clickOnAutoTerminateSaveButton();
   }

   //sp37
   @Then("disable the '$value' button for provider registration switch in password policy page")
   public void clickOnDisableCaptchaVerificationButton(String disablecaptchabutton) {
      passwordPolicyStep.clickOnDisableCaptchaVerificationButton(disablecaptchabutton);
   }

   @Then("disable the '$value' button for OTP switch in password policy page")
   public void clickOnDisableMultiFactorAuthenticationButton(String disableauthenticationbutton){
      passwordPolicyStep.clickOnDisableMultiFactorAuthenticationButton(disableauthenticationbutton);
   }

   @When("{enable|disable} the '$text' checkbox in configure password policy page")
   public void clickPasswordPolicyCheckbox(String text) {
      passwordPolicyStep.clickPasswordPolicyCheckbox(text);
   }

   @Then("enable the '$value' button for provider registration switch in password policy page")
   public void clickOnEnableCaptchaVerificationButton(String enablecaptchabutton) {
      passwordPolicyStep.clickOnEnableCaptchaVerificationButton(enablecaptchabutton);
   }

   @Then("turn $onoff the '$value' switch in password policy page")
   public void clickOnEnableAutoTerminate(String onoff, String enableautoterminate){

      if(onoff.equalsIgnoreCase("off")) {
         if(passwordPolicyStep.isAutoTerminateEnabled(enableautoterminate)){
            passwordPolicyStep.clickOnEnableAutoTerminate(enableautoterminate);
         }
         else {
            System.out.println("Already turned off!");
         }
      }
      else if(onoff.equalsIgnoreCase("on")){
         if(passwordPolicyStep.isAutoTerminateEnabled(enableautoterminate)) {
            System.out.println("Already turned on!");
         }
         else {
            passwordPolicyStep.clickOnEnableAutoTerminate(enableautoterminate);
         }
      }

   }

}

