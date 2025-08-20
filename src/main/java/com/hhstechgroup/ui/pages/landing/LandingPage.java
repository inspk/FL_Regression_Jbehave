package com.hhstechgroup.ui.pages.landing;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.landing.LandingHeaderPanel;
import com.hhstechgroup.ui.panels.registration.RegistrationSuccessfullPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;

import static java.lang.String.format;

public class LandingPage extends ProviderManagementBasePage {

    private static final String LANDING_HEADER_PANEL = "//div[contains(@class, 'landing')]";
    private static final String LANDING_REGISTRATION_SUCCESSFULL = "//h1[contains(text(), 'Registration successful')]/../parent::*";
    private static final String REGISTER_BUTTON = ".//span[text() = 'Register']";
    //newsp19
    private static final String AGREE_BUTTON = ".//div/button/span[contains(text(),'%s')]";
    private static final String CLOSE_BUTTON = ".//button[contains(@aria-label,'Close')]";
    public LandingHeaderPanel getLandingHeaderPanel() {
        return new LandingHeaderPanel(findBy(LANDING_HEADER_PANEL), this);
    }

    public RegistrationSuccessfullPanel getRegistrationSuccessfullPanel() {
        return new RegistrationSuccessfullPanel(findBy(LANDING_REGISTRATION_SUCCESSFULL), this);
    }

    public void waitForLandingPageLoaded() {
        waitForPresenceOf(LANDING_HEADER_PANEL);
    }

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegisterInJoinBlockButton() {
        WebElement element = getDriver().findElement(By.xpath(REGISTER_BUTTON));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element);
        actions.perform();
        findBy(REGISTER_BUTTON).click();
    }
    //new
    public void clickAgreeButton(String button) {
        waitAbit(100);
        jsClick(format(AGREE_BUTTON, button));
        waitAbit(100);
        //Everytime close pop up not comming so adding try catch
        try {
            withTimeoutOf(Duration.ofSeconds(3)).waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(CLOSE_BUTTON)));
            jsClick(CLOSE_BUTTON);

        }catch (Exception e){

        }

    }

    //new sp54
    private static final String NEW_AGREE_BUTTON = "//div//button//span[contains(text(),'%s')]";
    private static final String NEW_CLOSE_BUTTON = ".//button[contains(@aria-label,'Close')]";
    public void clickNewAgreeButton(String button) {
        waitAbit(100);
//        jsClick(format(NEW_AGREE_BUTTON, button));
        findBy(format(NEW_AGREE_BUTTON, button)).click();
        waitAbit(100);
        //Everytime close pop up not comming so adding try catch
        try {
            withTimeoutOf(Duration.ofSeconds(3)).waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(CLOSE_BUTTON)));
            jsClick(NEW_CLOSE_BUTTON);

        }catch (Exception e){

        }

    }

    //SD- sprint 01

    private static final String LOGO_VALIDATION = ".//a//img[contains(@alt,'%s')]";

    public boolean logoIsDisplayed(String text){
        return findBy(format(LOGO_VALIDATION,text)).isDisplayed();
    }
    private static final String LINKS=".//ul//li//a[contains(text(),'%s')]";
    public boolean verifyTextInLandingPage(String text){
        return findBy(String.format(LINKS,text)).isDisplayed();
    }

    public void clickOnLink(String link){
        waitAbit(400);
        findBy(String.format(LINKS,link)).click();
        waitAbit(400);
    }
    private static final String MAPS="//button[@value='map']";
    public void verifyMaps(){
        waitAbit(500);
        try{
            findBy(MAPS).isDisplayed();
        }
        catch (Exception e){
            System.err.println("====Map is not displayed====");
        }
    }

    private static final String PRIVACY_POLICY = ".//div//a[text()='%s']";

    public boolean isPrivacyPolicyLinkdisplayed(String text){
        scrollToElement(format(PRIVACY_POLICY,text));
        waitAbit(500);
        return findBy(format(PRIVACY_POLICY,text)).isDisplayed();
    }

    private static final String PRIVACY_POLICY_LINK = ".//div//a[text()='Privacy Policy']";

    public void clickOnprivacyPolicyLink() {
        findBy(PRIVACY_POLICY_LINK).click();
        waitAbit(3000);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        waitAbit(2000);

    }
    private static final String SOUTH_DAKOTA_ONLINE__PRIVATE_POLICY = ".//div[contains(text(),'South Dakota Online Privacy Policy')]";

    public void verifyPrivatePolicyPageIsDisplaying(){
        waitAbit(500);
        findBy(SOUTH_DAKOTA_ONLINE__PRIVATE_POLICY).isDisplayed();
    }

    private static final String SDGOV_ICON = ".//div[@id='sdicon']" ;

    public void verifySdGovtIconIsDisplaying(){
        waitAbit(500);
        findBy(SDGOV_ICON).isDisplayed();
    }

    private static final String SOUTH_DAKOTA_OFFICIAL_WEBSITE_TEXT = ".//div//a/h1[contains(text(),'Welcome To The Official South Dakota State Government Website')]" ;

    public void verifySouthDakotaOfficialWebsiteIsDisplaying(){
        waitAbit(500);
        findBy(SOUTH_DAKOTA_OFFICIAL_WEBSITE_TEXT).isDisplayed();
    }

    private static final String TERMS_AND_CONDITION = ".//div//a[text()='%s']";

    public boolean isTermsAndConditionsLinkdisplayed(String text){
        scrollToElement(format(TERMS_AND_CONDITION,text));
        waitAbit(500);
        return findBy(format(TERMS_AND_CONDITION,text)).isDisplayed();
    }
    private static final String TERMS_AND_CONDITION_LINK = ".//div//a[text()='Terms & Conditions']";

    public void clickOnTermsAndConditionLink() {
        findBy(TERMS_AND_CONDITION_LINK).click();
        waitAbit(3000);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        waitAbit(2000);

    }
    private static final String SOUTH_DAKOTA_DISCLAIMER_AND_LIMITATION_TEXT = ".//div[contains(text(),'South Dakota Online Disclaimer and Limitation of Liability')]" ;

    public void verifySouthDakotaDisclaimerAndLimitationIsDisplaying(){
        waitAbit(500);
        findBy(SOUTH_DAKOTA_DISCLAIMER_AND_LIMITATION_TEXT).isDisplayed();
    }

    private static final String SOUTH_DOKOTA_MEDICAID_HOME = ".//div//a[text()='%s']";

    public boolean isSDMedicaidHomeLinkIsDisplaying(String text){
        scrollToElement(format(SOUTH_DOKOTA_MEDICAID_HOME,text));
        waitAbit(500);
        return findBy(format(SOUTH_DOKOTA_MEDICAID_HOME,text)).isDisplayed();
    }

    private static final String SOUTH_DOKOTA_MEDICAID_HOME_LINK = ".//div//a[text()='South Dakota Medicaid Home']";

    public void clickSDMedicaidHomeLink() {
        findBy(SOUTH_DOKOTA_MEDICAID_HOME_LINK).click();
        waitAbit(3000);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        waitAbit(2000);

    }
    private static final String GENERAL_INFORMATION = ".//div/h3[contains(text(),'General Information')]";

    public void verifyGeneralInformationIsDisplaying(){
        waitAbit(500);
        findBy(GENERAL_INFORMATION).isDisplayed();
    }


    private static final String GENERAL_INFORMATION_CONTENT = ".//div//a[text()='General Information']";

    public void verifyGeneralInformationContentIsDisplaying(){
        waitAbit(1000);
        findBy(GENERAL_INFORMATION_CONTENT).isDisplayed();
    }

    private static final String SD_MEDICAID_PROVIDER_ENROLLMENT_HOME = ".//div//a[text()='%s']";

    public boolean isSDMedicaidProviderEnrollmentHomeLinkIsDisplaying(String text){
        scrollToElement(format(SD_MEDICAID_PROVIDER_ENROLLMENT_HOME,text));
        waitAbit(500);
        return findBy(format(SD_MEDICAID_PROVIDER_ENROLLMENT_HOME,text)).isDisplayed();
    }

    private static final String SD_MEDICAID_PROVIDER_ENROLLMENT_HOME_LINK = ".//div//a[text()='SD Medicaid Provider Enrollment Home']";

    public void clickSDMedicaidProviderEnrollmentHomeLink() {
        findBy(SD_MEDICAID_PROVIDER_ENROLLMENT_HOME_LINK).click();
        waitAbit(3000);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        waitAbit(2000);

    }
    private static final String PROVIDER_ENROLLMENT_AND_MAINTENANCE = ".//div/h1[contains(text(),'Provider Enrollment & Maintenance')]";

    public void verifyProviderEnrollmentAndMaintenanceIsDisplaying(){
        waitAbit(500);
        findBy(PROVIDER_ENROLLMENT_AND_MAINTENANCE).isDisplayed();
    }


    private static final String PROVIDER_ENROLLMENT_AND_MAINTENANCE_CONTENT = ".//div/h3[contains(text(),'Providers')]";

    public void verifyProviderEnrollmentAndMaintenanceContentIsDisplaying(){
        waitAbit(500);
        findBy(PROVIDER_ENROLLMENT_AND_MAINTENANCE_CONTENT).isDisplayed();
    }


    private static final String PROVIDER_FEE_SCHEDULES = ".//div//a[text()='%s']";

    public boolean isProviderFeeSchedulesLinkIsDisplaying(String text){
        scrollToElement(format(PROVIDER_FEE_SCHEDULES,text));
        waitAbit(500);
        return findBy(format(PROVIDER_FEE_SCHEDULES,text)).isDisplayed();
    }

    private static final String PROVIDER_FEE_SCHEDULES_LINK = ".//div//a[text()='Provider Fee Schedules']";

    public void clickProviderFeeSchedulesLink() {
        findBy(PROVIDER_FEE_SCHEDULES_LINK).click();
        waitAbit(3000);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        waitAbit(2000);

    }
    private static final String PROVIDER_FEE_SCHEDULES_GENERAL_INFORMATION = ".//div/h3[contains(text(),'General Information')]";

    public void verifyProviderFeeSchedulesGeneralInformationIsDisplaying(){
        waitAbit(500);
        findBy(PROVIDER_FEE_SCHEDULES_GENERAL_INFORMATION).isDisplayed();
    }


    private static final String PROVIDER_FEE_SCHEDULES_GENERAL_INFORMATION_CONTENT = ".//div//a[text()='Constituent Liaison']";

    public void verifyProviderFeeSchedulesGeneralInformationContentIsDisplaying(){
        waitAbit(500);
        findBy(PROVIDER_FEE_SCHEDULES_GENERAL_INFORMATION_CONTENT).isDisplayed();
    }

    private static final String PROVIDER_BILLING_MANUALS = ".//div//a[text()='%s']";

    public boolean isProviderBillingManualsLinkIsDisplaying(String text){
        scrollToElement(format(PROVIDER_BILLING_MANUALS,text));
        waitAbit(500);
        return findBy(format(PROVIDER_BILLING_MANUALS,text)).isDisplayed();
    }

    private static final String PROVIDER_BILLING_MANUALS_LINK = ".//div//a[text()='Provider Billing Manuals']";
    private static final String PROVIDER_BILLING_MANUALS_AGREE = ".//div//button[text()='I Accept']";

    public void clickProviderBillingManualsLink() {
        findBy(PROVIDER_BILLING_MANUALS_LINK).click();
        waitAbit(3000);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        waitAbit(2000);

        try {
            findBy(PROVIDER_BILLING_MANUALS_AGREE).click();
        }

        catch(Exception e){

        }

    }

    private static final String PROVIDER_BILLING_MANUALS_HEADING = ".//div/h1[contains(text(),'Provider Manuals')]";

    public void verifyProviderBillingManualsHeadingIsDisplaying(){
        waitAbit(500);
        findBy(PROVIDER_BILLING_MANUALS_HEADING).isDisplayed();
    }


    private static final String PROVIDER_BILLING_MANUALS_CONTENT = ".//div//a[text()='Billing a Recipient']";

    public void verifyProviderBillingManualsHeadingContentIsDisplaying(){
        waitAbit(500);
        findBy(PROVIDER_BILLING_MANUALS_CONTENT).isDisplayed();
    }

    private static final String MEDICAID_ONLINE_PORTAL = ".//div//a[text()='%s']";

    public boolean isMedicaidOnlinePortalLinkIsDisplaying(String text){
        scrollToElement(format(MEDICAID_ONLINE_PORTAL,text));
        waitAbit(500);
        return findBy(format(MEDICAID_ONLINE_PORTAL,text)).isDisplayed();
    }

    private static final String MEDICAID_ONLINE_PORTAL_LINK = ".//div//a[text()='Medicaid Online Portal (Look-up for remits, recipient eligibility, and claim entry)']";

    public void clickMedicaidOnlinePortalLink() {
        findBy(MEDICAID_ONLINE_PORTAL_LINK).click();
        waitAbit(3000);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        waitAbit(2000);

    }
    private static final String MEDICAID_ONLINE_PORTAL_EMAIL = ".//input[contains(@id,'UserName')]";

    public void verifyMedicaidOnlinePortalEmailField(){
        waitAbit(500);
        findBy(MEDICAID_ONLINE_PORTAL_EMAIL).isDisplayed();
    }


    private static final String MEDICAID_ONLINE_PORTAL_PASSWORD = ".//input[contains(@id,'Password')]";

    public void verifyMedicaidOnlinePortalPasswordField(){
        waitAbit(500);
        findBy(MEDICAID_ONLINE_PORTAL_PASSWORD).isDisplayed();
    }


    private static final String LISTSERV_SIGN_UP = ".//div//a[text()='%s']";

    public boolean isListServSignUpLinkIsDisplaying(String text){
        scrollToElement(format(LISTSERV_SIGN_UP,text));
        waitAbit(500);
        return findBy(format(LISTSERV_SIGN_UP,text)).isDisplayed();
    }

    private static final String LISTSERV_SIGN_UP_LINK = ".//div//a[text()='ListServ sign-up']";

    public void clickListServSignUpLink() {
        findBy(LISTSERV_SIGN_UP_LINK).click();
        waitAbit(3000);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        waitAbit(2000);

    }
    private static final String LIST_SERV_SIGN_UP_HEADING = ".//div/h2[contains(text(),'Join Our ListServ')]";

    public void verifyListServSignUpHeadingIsDisplaying(){
        waitAbit(500);
        findBy(LIST_SERV_SIGN_UP_HEADING).isDisplayed();
    }


    private static final String LIST_SERV_SIGN_UP_CONTENT = ".//div/h3[contains(text(),'Other Links')]";

    public void verifyListServSignUpContentIsDisplaying(){
        waitAbit(500);
        findBy(LIST_SERV_SIGN_UP_CONTENT).isDisplayed();
    }

   private static final String SD_PROVIDER_COMMUNICATION = ".//div//a[text()='%s']";

    public boolean isSDProviderCommunicationIsDisplaying(String text){
        scrollToElement(format(SD_PROVIDER_COMMUNICATION,text));
        waitAbit(500);
        return findBy(format(SD_PROVIDER_COMMUNICATION,text)).isDisplayed();
    }

    private static final String SD_PROVIDER_COMMUNICATION_LINK = ".//div//a[text()='SD Provider Communication']";

    public void clickSDProviderCommunicationLink() {
        findBy(SD_PROVIDER_COMMUNICATION_LINK).click();
        waitAbit(3000);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        waitAbit(3000);
        try {
            findBy(PROVIDER_BILLING_MANUALS_AGREE).click();
        }

        catch(Exception e){

        }
        waitAbit(500);
    }

    private static final String SD_PROVIDER_COMMUNICATION_HEADING = ".//div/h2[contains(text(),'Provider Communication')]";

    public void verifyProviderCommunicationHeadingIsDisplaying(){
        waitAbit(1000);
        findBy(SD_PROVIDER_COMMUNICATION_HEADING).isDisplayed();
    }

    private static final String SD_PROVIDER_COMMUNICATION_COVID_HEADING = ".//div/h3[contains(text(),'COVID-19 Provider Communications')]";

    public void verifyProviderCommunicationCovidHeadingContentIsDisplaying(){
        waitAbit(1000);
        findBy(SD_PROVIDER_COMMUNICATION_COVID_HEADING).isDisplayed();
    }

    private static final String SD_ADMINISTRATIVE_RULE = ".//div//a[text()='%s']";

    public boolean isSDAdministrativeRuleIsDisplaying(String text){
        scrollToElement(format(SD_ADMINISTRATIVE_RULE,text));
        waitAbit(500);
        return findBy(format(SD_ADMINISTRATIVE_RULE,text)).isDisplayed();
    }

    private static final String SD_ADMINISTRATIVE_RULE_LINK = ".//div//a[text()='SD Administrative Rules']";

    public void clickSDAdministrativeRuleLink() {
        findBy(SD_ADMINISTRATIVE_RULE_LINK).click();
        waitAbit(3000);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        waitAbit(2000);
    }

    private static final String SD_ADMINISTRATIVE_RULE_HEADING = ".//div/span[contains(text(),'Administrative Rules')]";

    public void verifySDAdministrativeRuleHeadingIsDisplaying(){
        waitAbit(500);
        findBy(SD_ADMINISTRATIVE_RULE_HEADING).isDisplayed();
    }

    private static final String SD_PROVIDER_COMMUNICATION_HOME_LINK = ".//div//a[text()='Home']";

    public void verifySDAdministrativeRuleHomeLinkIsDisplaying(){
        waitAbit(500);
        findBy(SD_PROVIDER_COMMUNICATION_HOME_LINK).isDisplayed();
    }

    private static final String SD_CODIFIED_LAWS = ".//div//a[text()='%s']";

    public boolean isSDCodifiedLawsIsDisplaying(String text){
        scrollToElement(format(SD_CODIFIED_LAWS,text));
        waitAbit(500);
        return findBy(format(SD_CODIFIED_LAWS,text)).isDisplayed();
    }

    private static final String SD_CODIFIED_LAWS_LINK = ".//div//a[text()='SD Codified Laws']";

    public void clickSDCodifiedLawsLink() {
        findBy(SD_CODIFIED_LAWS_LINK).click();
        waitAbit(3000);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        waitAbit(2000);
    }

    private static final String SD_CODIFIED_LAWS_HEADING = ".//div/span[contains(text(),'Codified Laws')]";

    public void verifySDCodifiedLawsHeadingIsDisplaying(){
        waitAbit(500);
        findBy(SD_CODIFIED_LAWS_HEADING).isDisplayed();
    }

    private static final String SD_CODIFIED_LAWS_SEARCH_BAR = ".//div//span[contains(text(),'Search')]";

    public void verifySDAdministrativeRuleSearchBarIsDisplaying(){
        waitAbit(500);
        findBy(SD_CODIFIED_LAWS_SEARCH_BAR).isDisplayed();
    }

    //SD-05 FAQ validation

    private static final String FAQ_QUESTION1 = "//div[contains(@class,'faq')]//div/p[text()='%s']";
    public boolean isFAQQuestion1IsDisplaying(String text){
        scrollToElement(format(FAQ_QUESTION1,text));
        waitAbit(500);
        findBy(format(FAQ_QUESTION1,text)).click();
        waitAbit(2000);
        return findBy(format(FAQ_QUESTION1,text)).isDisplayed();
    }

    private static final String FAQ_ANSWER1 = "//p[contains(text(),'%s')]";
    public String isFAQAnswer1IsDisplaying(String field) {
        waitAbit(2000);
        return findBy(format(FAQ_ANSWER1, field)).getText();

    }

    private static final String FAQ_QUESTION2 = "//div[contains(@class,'faq')]//div/p[text()='%s']";
    public boolean isFAQQuestion2IsDisplaying(String text){
        scrollToElement(format(FAQ_QUESTION2,text));
        waitAbit(500);
        findBy(format(FAQ_QUESTION2,text)).click();
        waitAbit(2000);
        return findBy(format(FAQ_QUESTION2,text)).isDisplayed();
    }

    private static final String FAQ_ANSWER2 = "//p[contains(text(),'%s')]";
    public String isFAQAnswer2IsDisplaying(String field) {
        waitAbit(2000);
        return findBy(format(FAQ_ANSWER2, field)).getText();

    }

    private static final String FAQ_QUESTION3 = "//div[contains(@class,'faq')]//div/p[text()='%s']";
    public boolean isFAQQuestion3IsDisplaying(String text){
        scrollToElement(format(FAQ_QUESTION3,text));
        waitAbit(500);
        findBy(format(FAQ_QUESTION3,text)).click();
        waitAbit(2000);
        return findBy(format(FAQ_QUESTION3,text)).isDisplayed();
    }

    private static final String FAQ_ANSWER3 = "//p[contains(text(),'%s')]";
    public String isFAQAnswer3IsDisplaying(String field) {
        waitAbit(2000);
        return findBy(format(FAQ_ANSWER3, field)).getText();
    }

    private static final String FAQ_QUESTION4 = "//div[contains(@class,'faq')]//div/p[text()='%s']";
    public boolean isFAQQuestion4IsDisplaying(String text){
        scrollToElement(format(FAQ_QUESTION4,text));
        waitAbit(500);
        findBy(format(FAQ_QUESTION4,text)).click();
        waitAbit(2000);
        return findBy(format(FAQ_QUESTION4,text)).isDisplayed();
    }

    private static final String FAQ_ANSWER4 = "//p[contains(text(),'%s')]";
    public String isFAQAnswer4IsDisplaying(String field) {
        waitAbit(2000);
        return findBy(format(FAQ_ANSWER4, field)).getText();
    }

    private static final String FAQ_QUESTION5 = "//div[contains(@class,'faq')]//div/p[text()='%s']";
    public boolean isFAQQuestion5IsDisplaying(String text){
        scrollToElement(format(FAQ_QUESTION5,text));
        waitAbit(500);
        findBy(format(FAQ_QUESTION5,text)).click();
        waitAbit(2000);
        return findBy(format(FAQ_QUESTION5,text)).isDisplayed();
    }

    private static final String FAQ_ANSWER5 = "//p[contains(text(),'%s')]";
    public String isFAQAnswer5IsDisplaying(String field) {
        waitAbit(2000);
        return findBy(format(FAQ_ANSWER5, field)).getText();
    }

    private static final String PROVIDER_MODULE_DETAILES_TABS = ".//div[contains(@class,'details_tabs-wrapper')]/div/div/div/div//span[contains(text(),'%s')]";
    public void verifyProviderModuleTab(String field){
        waitAbit(1000);
        findBy(format(PROVIDER_MODULE_DETAILES_TABS, field)).click();
    }

    private static final String PROVIDER_MODULE_DETAILES_TAB = ".//div[contains(@class,'details_tabs-wrapper')]/div/div/div/div//span[contains(text(),'%s')]";
    public void clickProviderModuleTab(String field){
        waitAbit(1000);
        findBy(format(PROVIDER_MODULE_DETAILES_TAB, field)).click();
    }

    private static final String SERVICE_LOCATION_HEADER_TAB = ".//div[contains(@class,'tile-table-head sc-kTUwUJ kiJYLh')]/div//span[contains(text(),'%s')]";
    public void verifyServiceLocationHeaderTab(String field){
        waitAbit(1000);
        findBy(format(SERVICE_LOCATION_HEADER_TAB, field)).click();
    }

}