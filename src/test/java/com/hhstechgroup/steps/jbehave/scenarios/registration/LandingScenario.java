package com.hhstechgroup.steps.jbehave.scenarios.registration;

import com.hhstechgroup.steps.serenity.registration.LandingSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.yecht.Data;

import static com.hhstechgroup.util.properties.SystemProperties.PROVIDER_MANAGEMENT_URL;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LandingScenario   {

    @Steps
    LandingSteps landingStep;

    @Given("user navigated to landing page")
    @When("user navigated to landing page")
    public void openProviderLandingPage ()  {
        landingStep.openLandingPage();
    }

    @Then("landing page should be opened")
    public void isLandingPageOpened () {
        System.out.println(getDriver().getCurrentUrl());
        assertTrue("Landing page should be opened", getDriver().getCurrentUrl().equals(PROVIDER_MANAGEMENT_URL.getProperty()));
    }

    @When("click Register button in Join block on landing page")
    public void clickRegisterButtonOnLandingPage () {
        landingStep.clickRegisterButtonInJoinBlock();
    }

    @When ("click SignIn/Register button on landing page")
    public void clickSignInRegisterButtonOnLandingPage () {
        landingStep.clickSignRegisterButton();
    }

    @When("click on tab $tab on Landing page")
    public void clickOnTab(String tab) {
        landingStep.clickOnTab(tab);
    }
    //new sp19
    @When("click on '$button' button in the Portal page")
    public void clickAgreeButton(String button) {
        landingStep.clickAgreeButton(button);
    }
    //sp21
    @When("click on the '$button' button in the Portal page")
    public void clickDisAgreeButton(String button) {
        landingStep.clickDisAgreeButton(button);
    }

    //new sp54
    @When("click on new '$button' button in the Portal page")
    public void clickNewAgreeButton(String button) {
        landingStep.clickNewAgreeButton(button);
    }

    //SD- sprint 01

    @Then("validate logo '$text' is displayed")
    public void logoIsDisplayed(String text){
        landingStep.logoIsDisplayed(text);
    }

    @Then("verify '$text' is displayed in landing page")
    public void verifyTextInLandingPage(String text){
        landingStep.verifyTextInLandingPage(text);
    }

    @Then("click on '$link' in landing page")
    public void clickOnLink(String link){
        landingStep.clickOnLink(link);
    }
    @Then("verify the maps under Provider Search")
    public void verifyMaps(){
        landingStep.verifyMaps();
    }
    @Then("validate '$text' link is displayed")
    public void isPrivacyPolicyLinkdisplayed(String text){
        landingStep.isPrivacyPolicyLinkdisplayed(text);
    }

    @Then("validate '$text' displayed")
    public void isTermsAndConditionsLinkdisplayed(String text){
        landingStep.isTermsAndConditionsLinkdisplayed(text);
    }

    @When("click on privacy policy link in landing page")
    public void clickOnprivacyPolicyLink(){
        landingStep.clickOnprivacyPolicyLink();
    }

    @Then("validating fields in private policy page")
    public void verifyPrivatePolicyPageIsDisplaying(){
        landingStep.verifyPrivatePolicyPageIsDisplaying();
        System.out.println("Verifying South Dakota Online Private Policy is displaying");
        landingStep.verifySdGovtIconIsDisplaying();
        System.out.println("Verifying South Dakota Icon is displaying");
        landingStep.verifySouthDakotaOfficialWebsiteIsDisplaying();
        System.out.println("Verifying South Dakota Online Official Website is displaying");
    }

    @When("click on terms and condition link in landing page")
    public void clickOnTermsAndConditionLink() {
        landingStep.clickOnTermsAndConditionLink();
    }

    @Then("validating fields in terms and condition page")
    public void verifySouthDakotaDisclaimerAndLimitationIsDisplaying(){
        landingStep.verifySouthDakotaDisclaimerAndLimitationIsDisplaying();
        System.out.println("Verifying South Dakota Disclaimer And Limitation is displaying");
        landingStep.verifySdGovtIconIsDisplaying();
        System.out.println("Verifying South Dakota Icon is displaying");
        landingStep.verifySouthDakotaOfficialWebsiteIsDisplaying();
        System.out.println("Verifying South Dakota Online Official Website is displaying");
    }

    @Then("validate '$text' link1 is displayed")
    public void isSDMedicaidHomeLinkIsDisplaying(String text){
        landingStep.isSDMedicaidHomeLinkIsDisplaying(text);
    }

    @When("click on SD medicaid home page")
    public void clickSDMedicaidHomeLink(){
        landingStep.clickSDMedicaidHomeLink();
    }

    @Then("validating fields in SD medicaid home page")
    public void verifyGeneralInformationIsDisplaying(){
        landingStep.verifyGeneralInformationIsDisplaying();
        System.out.println("Verifying General Information is displaying");
        landingStep.verifyGeneralInformationContentIsDisplaying();
        System.out.println("Verifying General Information content is displaying");
    }

    @Then("validate '$text' link2 is displayed")
    public void isSDMedicaidProviderEnrollmentHomeLinkIsDisplaying(String text){
        landingStep.isSDMedicaidProviderEnrollmentHomeLinkIsDisplaying(text);
    }

    @When("click on SD medicaid Provider Enrollment & Maintenance home page")
    public void clickSDMedicaidProviderEnrollmentHomeLink(){
        landingStep.clickSDMedicaidProviderEnrollmentHomeLink();
    }

    @Then("validating fields in SD medicaid Provider Enrollment & Maintenance home page")
    public void verifyProviderEnrollmentAndMaintenanceIsDisplaying(){
        landingStep.verifyProviderEnrollmentAndMaintenanceIsDisplaying();
        System.out.println("Verifying Provider Enrollment & Maintenance is displaying");
        landingStep.verifyProviderEnrollmentAndMaintenanceContentIsDisplaying();
        System.out.println("Verifying Provider Enrollment & Maintenance content is displaying");
    }

    @Then("validate '$text' link3 is displayed")
    public void isProviderFeeSchedulesLinkIsDisplaying(String text){
        landingStep.isProviderFeeSchedulesLinkIsDisplaying(text);
    }

    @When("click on Provider Fee Schedules page")
    public void clickProviderFeeSchedulesLink(){
        landingStep.clickProviderFeeSchedulesLink();
    }

    @Then("validating fields in Provider Fee Schedules page")
    public void verifyProviderFeeSchedulesGeneralInformationIsDisplaying(){
        landingStep.verifyProviderFeeSchedulesGeneralInformationIsDisplaying();
        System.out.println("Verifying General Information is displaying");
        landingStep.verifyProviderFeeSchedulesGeneralInformationContentIsDisplaying();
        System.out.println("Verifying Constituent Liaison is displaying");
    }

    @Then("validate '$text' link4 is displayed")
    public void isProviderBillingManualsLinkIsDisplaying(String text){
        landingStep.isProviderBillingManualsLinkIsDisplaying(text);
    }

    @When("click on Provider Billing Manuals page")
    public void clickProviderBillingManualsLink(){
        landingStep.clickProviderBillingManualsLink();
    }

    @Then("validating fields in Provider Billing Manuals page")
    public void verifyProviderBillingManualsHeadingIsDisplaying(){
        landingStep.verifyProviderBillingManualsHeadingIsDisplaying();
        System.out.println("Verifying Heading Provider Manuals is displaying");
        landingStep.verifyProviderBillingManualsHeadingContentIsDisplaying();
        System.out.println("Verifying Billing a Recipient Option is displaying");
    }

    @Then("validate '$text' link5 is displayed")
    public void isMedicaidOnlinePortalLinkIsDisplaying(String text){
        landingStep.isMedicaidOnlinePortalLinkIsDisplaying(text);
    }

    @When("click on Medicaid Online Portal page")
    public void clickMedicaidOnlinePortalLink(){
        landingStep.clickMedicaidOnlinePortalLink();
    }

    @Then("validating fields in Medicaid Online Portal page")
    public void verifyMedicaidOnlinePortalEmailField() {
        landingStep.verifyMedicaidOnlinePortalEmailField();
        System.out.println("Verifying Email Field is displaying");
        landingStep.verifyMedicaidOnlinePortalPasswordField();
        System.out.println("Verifying Password Field is displaying");
    }

    @Then("validate '$text' link6 is displayed")
    public void isListServSignUpLinkIsDisplaying(String text){
        landingStep.isListServSignUpLinkIsDisplaying(text);
    }

    @When("click on ListServ SignUp page")
    public void clickListServSignUpLink(){
        landingStep.clickListServSignUpLink();
    }

    @Then("validating fields in ListServ SignUp page")
    public void verifyListServSignUpHeadingIsDisplaying() {
        landingStep.verifyListServSignUpHeadingIsDisplaying();
        System.out.println("Verifying Join Our ListServ Heading is displaying");
        landingStep.verifyListServSignUpContentIsDisplaying();
        System.out.println("Verifying Other Links option is displaying");
    }

    @Then("validate '$text' link7 is displayed")
    public void isSDProviderCommunicationIsDisplaying(String text){
        landingStep.isSDProviderCommunicationIsDisplaying(text);
    }

    @When("click on SD Provider Communication page")
    public void clickSDProviderCommunicationLink(){
        landingStep.clickSDProviderCommunicationLink();
    }

    @Then("validating fields in SD Provider Communication page")
    public void verifyProviderCommunicationHeadingIsDisplaying(){
        landingStep.verifyProviderCommunicationHeadingIsDisplaying();
        System.out.println("Verifying Heading Provider Communication is displaying");
        landingStep.verifyProviderCommunicationCovidHeadingContentIsDisplaying();
        System.out.println("Verifying COVID-19 Heading in Provider Communication is displaying");
    }

    @Then("validate '$text' link8 is displayed")
    public void isSDAdministrativeRuleIsDisplaying(String text){
        landingStep.isSDAdministrativeRuleIsDisplaying(text);
    }

    @When("click on SD Administrative Rule page")
    public void clickSDAdministrativeRuleLink(){
        landingStep.clickSDAdministrativeRuleLink();
    }

    @Then("validating fields in SD Administrative Rule page")
    public void verifySDAdministrativeRuleHeadingIsDisplaying() {
        landingStep.verifySDAdministrativeRuleHeadingIsDisplaying();
        System.out.println("Verifying SD Administrative Rule Heading is displaying");
        landingStep.verifySDAdministrativeRuleHomeLinkIsDisplaying();
        System.out.println("Verifying SD Administrative Rule Home Link is displaying");
    }

    @Then("validate '$text' link9 is displayed")
    public void isSDCodifiedLawsIsDisplaying(String text){
        landingStep.isSDCodifiedLawsIsDisplaying(text);
    }

    @When("click on SD Codified Laws page")
    public void clickSDCodifiedLawsLink(){
        landingStep.clickSDCodifiedLawsLink();
    }

    @Then("validating fields in SD Codified Laws page")
    public void verifySDCodifiedLawsHeadingIsDisplaying() {
        landingStep.verifySDCodifiedLawsHeadingIsDisplaying();
        System.out.println("Verifying SD Codified Laws Heading is displaying");
        landingStep.verifySDAdministrativeRuleSearchBarIsDisplaying();
        System.out.println("Verifying SD Codified Laws Search Bar is displaying");
    }

    //SD-05

    @When("in FAQ '$text' Question1 is displayed")
    public void isFAQQuestion1IsDisplaying(String text){
        landingStep.isFAQQuestion1IsDisplaying(text);
        System.out.println("FAQ Question1 is displaying");
    }

    @Then("validating Answer1 '$field' should be Present")
    public  void isFAQAnswer1IsDisplaying(String field){
        assertEquals("The Provider Enrollment & Credentialing System (PECS) captures data related to the enrollment and ongoing participation of individuals and entities providing health care services with SD Medicaid. Payment for eligible medical services rendered to SD Medicaid recipients cannot be made without enrollment.", landingStep.isFAQAnswer1IsDisplaying(field));
    }

    @When("in FAQ '$text' Question2 is displayed")
    public void isFAQQuestion2IsDisplaying(String text){
        landingStep.isFAQQuestion2IsDisplaying(text);
        System.out.println("FAQ Question2 is displaying");
    }

    @Then("validating Answer2 '$field' should be Present")
    public  void isFAQAnswer2IsDisplaying(String field){
        assertEquals("Any eligible entity or individual with an NPI that will be found on claims sent to SD Medicaid in a billing NPI or servicing NPI claim field and qualified individuals working at an IHS clinic should enroll. Trading partners who send or receive electronic HIPAA claims transactions with SD Medicaid and certain users who manage provider enrollment data for one or more BNPI will also be required to enroll.", landingStep.isFAQAnswer2IsDisplaying(field));
    }

    @When("in FAQ '$text' Question3 is displayed")
    public void isFAQQuestion3IsDisplaying(String text){
        landingStep.isFAQQuestion3IsDisplaying(text);
        System.out.println("FAQ Question3 is displaying");
    }

    @Then("validating Answer3 '$field' should be Present")
    public  void isFAQAnswer3IsDisplaying(String field){
        assertEquals("Refer to the Provider Enrollment Eligibility Chart to see specific eligibility requirements and enrollment expectations. Providers located outside of SD must have a claim for an eligible service rendered that meets timely filing and prior authorization requirements to be eligible.", landingStep.isFAQAnswer3IsDisplaying(field));
    }

    @When("in FAQ '$text' Question4 is displayed")
    public void isFAQQuestion4IsDisplaying(String text){
        landingStep.isFAQQuestion4IsDisplaying(text);
        System.out.println("FAQ Question4 is displaying");
    }

    @Then("validating Answer4 '$field' should be Present")
    public  void isFAQAnswer4IsDisplaying(String field){
        assertEquals("No, NPIs for individuals who will only be listed on a claim for services in an attending, ordering, referring, or prescribing field are subject to SD’s streamlined enrollment process. The submission of claims constitutes agreement with the SD Medicaid Provider Agreement but requires no enrollment action by the provider.", landingStep.isFAQAnswer4IsDisplaying(field));
    }

    @When("in FAQ '$text' Question5 is displayed")
    public void isFAQQuestion5IsDisplaying(String text){
        landingStep.isFAQQuestion5IsDisplaying(text);
        System.out.println("FAQ Question5 is displaying");
    }

    @Then("validating Answer5 '$field' should be Present")
    public  void isFAQAnswer5IsDisplaying(String field){
        assertEquals("To start using PECS, you must be registered. To register in the system, click the PECS link, then click “Sign In/Register” in the upper right corner and follow the displayed steps. Once registered you will be able to select enrolment forms to begin a new enrolment.", landingStep.isFAQAnswer5IsDisplaying(field));
    }

    @Then("validating '$field' Tab in SD Provider Module")
    public void verifyProviderModuleTab(String field){
        landingStep.verifyProviderModuleTab(field);
        System.out.println("Verifying Secondary Service Location Tab is displaying");
    }

    @When("click '$field' Tab in SD Provider Module")
    public void clickProviderModuleTab(String field){
        landingStep.clickProviderModuleTab(field);
    }

    @Then("validating '$field' Tab in Service location header")
    public void verifyServiceLocationHeaderTab(String field){
        landingStep.verifyServiceLocationHeaderTab(field);
        System.out.println("Verifying Location Type Tab is displaying");
    }
}