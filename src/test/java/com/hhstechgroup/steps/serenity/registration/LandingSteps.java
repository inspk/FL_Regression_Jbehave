package com.hhstechgroup.steps.serenity.registration;

import com.hhstechgroup.ui.pages.landing.LandingPage;
import com.hhstechgroup.ui.pages.login.LoginPage;
import com.hhstechgroup.ui.panels.landing.LandingHeaderPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static java.lang.String.format;

public class LandingSteps extends ScenarioSteps {

    LandingPage landingPage;
    LoginPage loginPage;

    @Step
    public void openLandingPage() {
        waitABit(500);
       landingPage.open();
    }

    @Step
    public void clickSignRegisterButton() {
        LandingHeaderPanel panel = landingPage.getLandingHeaderPanel();
        panel.clickSignRegisterButton();
    }

    @Step
    public void clickRegisterButtonInJoinBlock() {
        landingPage.clickRegisterInJoinBlockButton();
    }

    @Step
    public void waitForLandingPageDisplayed() {
        landingPage.waitForLandingPageLoaded();
    }

    @Step
    public void clickOnTab(String tab) {
        landingPage.getLandingHeaderPanel().clickOnTab(tab);
    }
    //newsp19
    @Step
    public void clickAgreeButton(String button) {
        landingPage.clickAgreeButton(button);
        //loginPage.waitForLoginCompleted();       //after warning message update user pop up dispaying in sp20
    }
    //sp21
    @Step
    public void clickDisAgreeButton(String button) {
        landingPage.clickAgreeButton(button);
    }

    //newsp54
    @Step
    public void clickNewAgreeButton(String button) {
        landingPage.clickNewAgreeButton(button);
        //loginPage.waitForLoginCompleted();       //after warning message update user pop up dispaying in sp20
    }



    //SD- sprint 01

    @Step
    public boolean logoIsDisplayed(String text){
        return landingPage.logoIsDisplayed(text);
    }
    @Step
    public boolean verifyTextInLandingPage(String text){
        return landingPage.verifyTextInLandingPage(text);
    }
    @Step
    public void clickOnLink(String link){
        landingPage.clickOnLink(link);
    }

    @Step
    public void verifyMaps(){
        landingPage.verifyMaps();
    }

    @Step
    public boolean isPrivacyPolicyLinkdisplayed(String text){
        return landingPage.isPrivacyPolicyLinkdisplayed(text);
    }

    @Step
    public boolean isTermsAndConditionsLinkdisplayed(String text){
        return landingPage.isTermsAndConditionsLinkdisplayed(text);
    }

    @Step
    public void clickOnprivacyPolicyLink(){
        landingPage.clickOnprivacyPolicyLink();
    }

    @Step
    public void verifyPrivatePolicyPageIsDisplaying(){
        landingPage.verifyPrivatePolicyPageIsDisplaying();
    }

    @Step
    public void verifySdGovtIconIsDisplaying(){
        landingPage.verifySdGovtIconIsDisplaying();
    }


    @Step
    public void verifySouthDakotaOfficialWebsiteIsDisplaying(){
        landingPage.verifySouthDakotaOfficialWebsiteIsDisplaying();
    }

    @Step
    public void clickOnTermsAndConditionLink() {
        landingPage.clickOnTermsAndConditionLink();
    }

    @Step
    public void verifySouthDakotaDisclaimerAndLimitationIsDisplaying(){
        landingPage.verifySouthDakotaDisclaimerAndLimitationIsDisplaying();
    }

    @Step
    public boolean isSDMedicaidHomeLinkIsDisplaying(String text){
        return landingPage.isSDMedicaidHomeLinkIsDisplaying(text);
    }

    @Step
    public void clickSDMedicaidHomeLink(){
        landingPage.clickSDMedicaidHomeLink();
    }

    @Step
    public void verifyGeneralInformationIsDisplaying(){
        landingPage.verifyGeneralInformationIsDisplaying();
    }

    @Step
    public void verifyGeneralInformationContentIsDisplaying(){
        landingPage.verifyGeneralInformationContentIsDisplaying();
    }

    @Step
    public boolean isSDMedicaidProviderEnrollmentHomeLinkIsDisplaying(String text){
        return landingPage.isSDMedicaidProviderEnrollmentHomeLinkIsDisplaying(text);
    }

    @Step
    public void clickSDMedicaidProviderEnrollmentHomeLink(){
        landingPage.clickSDMedicaidProviderEnrollmentHomeLink();
    }

    @Step
    public void verifyProviderEnrollmentAndMaintenanceIsDisplaying(){
        landingPage.verifyProviderEnrollmentAndMaintenanceIsDisplaying();
    }

    @Step
    public void verifyProviderEnrollmentAndMaintenanceContentIsDisplaying(){
        landingPage.verifyProviderEnrollmentAndMaintenanceContentIsDisplaying();
    }

    @Step
    public boolean isProviderFeeSchedulesLinkIsDisplaying(String text){
        return landingPage.isProviderFeeSchedulesLinkIsDisplaying(text);
    }

    @Step
    public void clickProviderFeeSchedulesLink(){
        landingPage.clickProviderFeeSchedulesLink();
    }

    @Step
    public void verifyProviderFeeSchedulesGeneralInformationIsDisplaying(){
        landingPage.verifyProviderFeeSchedulesGeneralInformationIsDisplaying();
    }

    @Step
    public void verifyProviderFeeSchedulesGeneralInformationContentIsDisplaying(){
        landingPage.verifyProviderFeeSchedulesGeneralInformationContentIsDisplaying();
    }

    @Step
    public boolean isProviderBillingManualsLinkIsDisplaying(String text){
        return landingPage.isProviderBillingManualsLinkIsDisplaying(text);
    }

    @Step
    public void clickProviderBillingManualsLink(){
        landingPage.clickProviderBillingManualsLink();
    }


    @Step
    public void verifyProviderBillingManualsHeadingIsDisplaying(){
        landingPage.verifyProviderBillingManualsHeadingIsDisplaying();
    }

    @Step
    public void verifyProviderBillingManualsHeadingContentIsDisplaying(){
        landingPage.verifyProviderBillingManualsHeadingContentIsDisplaying();
    }

    @Step
    public boolean isMedicaidOnlinePortalLinkIsDisplaying(String text){
        return landingPage.isProviderBillingManualsLinkIsDisplaying(text);
    }

    @Step
    public void clickMedicaidOnlinePortalLink(){
        landingPage.clickMedicaidOnlinePortalLink();
    }

    @Step
    public void verifyMedicaidOnlinePortalEmailField(){
        landingPage.verifyMedicaidOnlinePortalEmailField();
    }

    @Step
    public void verifyMedicaidOnlinePortalPasswordField(){
        landingPage.verifyMedicaidOnlinePortalPasswordField();
    }

    @Step
    public boolean isListServSignUpLinkIsDisplaying(String text){
        return landingPage.isListServSignUpLinkIsDisplaying(text);
    }

    @Step
    public void clickListServSignUpLink(){
        landingPage.clickListServSignUpLink();
    }

    @Step
    public void verifyListServSignUpHeadingIsDisplaying(){
        landingPage.verifyListServSignUpHeadingIsDisplaying();
    }

    @Step
    public void verifyListServSignUpContentIsDisplaying(){
        landingPage.verifyListServSignUpContentIsDisplaying();
    }

    @Step
    public boolean isSDProviderCommunicationIsDisplaying(String text){
        return landingPage.isSDProviderCommunicationIsDisplaying(text);
    }

    @Step
    public void clickSDProviderCommunicationLink(){
        landingPage.clickSDProviderCommunicationLink();
    }

    @Step
    public void verifyProviderCommunicationHeadingIsDisplaying(){
        landingPage.verifyProviderCommunicationHeadingIsDisplaying();
    }

    @Step
    public void verifyProviderCommunicationCovidHeadingContentIsDisplaying(){
        landingPage.verifyProviderCommunicationCovidHeadingContentIsDisplaying();
    }

    @Step
    public boolean isSDAdministrativeRuleIsDisplaying(String text){
        return landingPage.isSDAdministrativeRuleIsDisplaying(text);
    }
    @Step
    public void clickSDAdministrativeRuleLink(){
        landingPage.clickSDAdministrativeRuleLink();
    }

    @Step
    public void verifySDAdministrativeRuleHeadingIsDisplaying(){
        landingPage.verifySDAdministrativeRuleHeadingIsDisplaying();
    }

    @Step
    public void verifySDAdministrativeRuleHomeLinkIsDisplaying(){
        landingPage.verifySDAdministrativeRuleHomeLinkIsDisplaying();
    }

    @Step
    public boolean isSDCodifiedLawsIsDisplaying(String text){
        return landingPage.isSDCodifiedLawsIsDisplaying(text);
    }
    @Step
    public void clickSDCodifiedLawsLink(){
        landingPage.clickSDCodifiedLawsLink();
    }

    @Step
    public void verifySDCodifiedLawsHeadingIsDisplaying(){
        landingPage.verifySDCodifiedLawsHeadingIsDisplaying();
    }

    @Step
    public void verifySDAdministrativeRuleSearchBarIsDisplaying(){
        landingPage.verifySDAdministrativeRuleSearchBarIsDisplaying();
    }

    //SD-05

    @Step
    public boolean isFAQQuestion1IsDisplaying(String text){

        return landingPage.isFAQQuestion1IsDisplaying(text);
    }

    @Step
    public String isFAQAnswer1IsDisplaying(String field) {
        return landingPage.isFAQAnswer1IsDisplaying(field);
    }

    @Step
    public boolean isFAQQuestion2IsDisplaying(String text){

        return landingPage.isFAQQuestion2IsDisplaying(text);
    }

    @Step
    public String isFAQAnswer2IsDisplaying(String field) {
        return landingPage.isFAQAnswer2IsDisplaying(field);
    }

    @Step
    public boolean isFAQQuestion3IsDisplaying(String text){

        return landingPage.isFAQQuestion3IsDisplaying(text);
    }

    @Step
    public String isFAQAnswer3IsDisplaying(String field) {
        return landingPage.isFAQAnswer3IsDisplaying(field);
    }

    @Step
    public boolean isFAQQuestion4IsDisplaying(String text){

        return landingPage.isFAQQuestion4IsDisplaying(text);
    }

    @Step
    public String isFAQAnswer4IsDisplaying(String field) {
        return landingPage.isFAQAnswer4IsDisplaying(field);
    }

    @Step
    public boolean isFAQQuestion5IsDisplaying(String text){

        return landingPage.isFAQQuestion5IsDisplaying(text);
    }

    @Step
    public String isFAQAnswer5IsDisplaying(String field) {
        return landingPage.isFAQAnswer5IsDisplaying(field);
    }

    @Step
    public void verifyProviderModuleTab(String field){
        landingPage.verifyProviderModuleTab(field);
    }

    @Step
    public void clickProviderModuleTab(String field){
        landingPage.clickProviderModuleTab(field);
    }

    @Step
    public void verifyServiceLocationHeaderTab(String field){
        landingPage.verifyServiceLocationHeaderTab(field);
    }
}