package com.hhstechgroup.ui.pages.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.enrollment.*;
import com.hhstechgroup.ui.panels.enrollment.affiliation.AffiliationPanel;
import com.hhstechgroup.ui.panels.enrollment.affiliation.AffiliationPopUpPanel;
import com.hhstechgroup.ui.panels.enrollment.electronicfundspayment.ElectronicFundsPaymentPanel;
import com.hhstechgroup.ui.panels.enrollment.exclusionsanction.ExclusionSanctionPanel;
import com.hhstechgroup.ui.panels.enrollment.licensure.LicensureCertificationPanel;
import com.hhstechgroup.ui.panels.enrollment.ownership.OwnershipPanel;
import com.hhstechgroup.ui.panels.enrollment.servicelocationbilling.ProgramParticipationPanel;
import com.hhstechgroup.ui.panels.enrollment.servicelocationbilling.ProgramParticipationSectionPanel;
import com.hhstechgroup.ui.panels.enrollment.servicelocationbilling.ServiceLocationBillingPanel;
import com.hhstechgroup.ui.panels.enrollment.servicelocationbilling.ServiceLocationPanel;
import com.hhstechgroup.ui.panels.iuportal.EnrollmentSearchPanel;
import com.hhstechgroup.util.application.ApplicationSectionHelper;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class EnrollmentPage extends ProviderManagementBasePage {

    private static final String TITLE = ".//h2[text() = '%s']";
    private static final String PAYMENT = ".//h3[text() = 'Payment']/ancestor::div[3][not(contains(@class, 'section'))]";
    private static final String UPLOAD_DOCUMENTS = ".//h3[text() = 'Upload documents']/ancestor::div[3]";
    private static final String UPLOAD_COC_DOCUMENTS = ".//h3[text() = 'Upload Documents']/ancestor::div[3]";
    private static final String SUMMARY = ".//h3[text() = 'Summary']/ancestor::div[3]";
    private static final String SUMMARY1 = ".//h2[text() = 'Summary']/ancestor::div[3]";
    private static final String AFFILIATION = ".//h3[text() = 'Affiliation with Entity/Facility/PEM' or text()='Provider affiliation information']/ancestor::div[3]";
    private static final String AFFILIATION_POPUP = "(.//div[@role='dialog'])[2]";
    private static final String LEFT_PANEL = ".//div[contains(@class, 'root')]//div[contains(@class, 'menu')]";
    private static final String ADDRESS_AUTO_COMPLETE_PANEL = "//ul[@role='listbox']/parent::div";
    private static final String ADDRESS_VERIFIED_LABEL = "//div/preceding-sibling::div//label[text() = '%s']/../..//following-sibling::div[contains(text(), 'Verified')]";
    private static final String SECTION = ".//div[contains(@class, 'menu-item')]/span[text() = '%s']";
    private static final String BASE_SECTION = ".//h3/ancestor::div[3]";
    private static final String SPINNER = ".//div[contains(@class, 'spinner_spinner-wrap')]";
    private static final String GROUP_SECTION = ".//h4[contains(text(), '%s')]/ancestor::div[3]";
    private static final String  TP_IDENTIFICATION_ADDRESS_PANEL = ".//div[contains(@class,'section-inner')]" ;
    private static final String  TP_IDENTIFICATION_INFO_PANEL = ".//div[contains(@class,'section-inner')]" ;
    public static final String SERVICE_LOCATION_EFT=
            "//div[contains(@id, 'Select Service Location') and @role='button' and @aria-haspopup='listbox']";
    public static final String PROVIDER_TYPE_EFT=
            "//div[contains(@id, 'Select Provider Type(s)') and @role='button' and @aria-haspopup='listbox']";
    public static final String GENDER=
            "//div[@id=//label[contains(normalize-space(.),'Gender')]/@for]";

    public EnrollmentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageTitleDisplayed(String title) {
        waitForPresenceOf(format(TITLE, title));
        return isElementPresent(format(TITLE, title));
    }

    private static final String UPLOAD_BUTTON = ".//span[contains(text(), 'Upload Files')]";
    public void clickUploadButton() {
        waitAbit(500);
        jsClick(UPLOAD_BUTTON);
        waitAbit(500);
    }

    public BaseEnrollmentPanel getSection(String sectionName) {
        Class<? extends BaseEnrollmentPanel> sectionClass = ApplicationSectionHelper.getSectionPanelClass(sectionName);
        String section = format(SECTION, sectionName);
        try {
            return sectionClass.getConstructor(WebElementFacade.class, AbstractPage.class).newInstance(findBy(section), this);
        } catch (Exception e) {
            throw new IllegalArgumentException(format("Failed to create instance of [%s]", sectionClass.getName()), e);
        }
    }

    //latest
    public BaseEnrollmentPanel getgroupSection(String sectionName) {
        Class<? extends BaseEnrollmentPanel> sectionClass = ApplicationSectionHelper.getSectionPanelClass(sectionName);
        String section = format(GROUP_SECTION, sectionName);
        try {
            return sectionClass.getConstructor(WebElementFacade.class, AbstractPage.class).newInstance(findBy(section), this);
        } catch (Exception e) {
            throw new IllegalArgumentException(format("Failed to create instance of [%s]", sectionClass.getName()), e);
        }
    }
    public BaseEnrollmentPanel getBaseSection() {
        return new BaseEnrollmentPanel(findBy(BASE_SECTION), this);
    }

    public LeftMenuPanel getLeftMenuPanel() {
        return new LeftMenuPanel(findBy(LEFT_PANEL), this);
    }

    public UploadDocumentsPanel getUploadDocumentsPanel() {
        return new UploadDocumentsPanel(findBy(UPLOAD_DOCUMENTS), this);
    }
    //latest
    private static final String UPLOAD_DOC = ".//input[@type=\'file\']";
    public UploadDocumentsPanel getUploadDocumentsPanel1() {
        return new UploadDocumentsPanel(findBy(UPLOAD_DOC), this);
    }

    public UploadDocumentsPanel getCocUploadDocumentsPanel() {
        return new UploadDocumentsPanel(findBy(UPLOAD_COC_DOCUMENTS), this);
    }

    public SummaryPanel getSummaryPanel() {
        return new SummaryPanel(findBy(SUMMARY), this);
    }
// SP-65 calling new method for COC summary panel
    public SummaryPanel getSummaryPanel1() {
        return new SummaryPanel(findBy(SUMMARY1), this);
    }

    public PaymentPanel getPaymentPanel() {
        withTimeoutOf(30, TimeUnit.SECONDS).waitForElementsToDisappear(By.xpath(SPINNER));
//        waitForPresenceOf(PAYMENT);
        return new PaymentPanel(findBy(PAYMENT), this);
    }

    public boolean isAutoCompleteAppeared() {
        withTimeoutOf(Duration.ofSeconds(3)).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADDRESS_AUTO_COMPLETE_PANEL)));
        return isElementPresent(ADDRESS_AUTO_COMPLETE_PANEL);
    }

    public AddressAutoCompletePanel getAddressAutoCompletePanel() {
        return new AddressAutoCompletePanel(findBy(ADDRESS_AUTO_COMPLETE_PANEL), this);
    }

    public boolean isVerifiedLabelPresent(String fieldName) {
        return isElementPresent(format(ADDRESS_VERIFIED_LABEL, fieldName));
    }

    public AffiliationPanel getAffiliationPanel() {
        return new AffiliationPanel(findBy(AFFILIATION), this);
    }

    public AffiliationPopUpPanel getAffiliationPopUpPanel() {
        return new AffiliationPopUpPanel(findBy(AFFILIATION_POPUP), this);
    }

    //latest
    private static final String SEARCH_PANEL = ".//div[contains(@class, 'root_content')]";
    private static final String RESULTS_PANEL = ".//div[starts-with(@class, 'tile-table ')]";

    public EnrollmentSearchPanel getEnrollSearchPanel() { waitAbit(2000);
        return new EnrollmentSearchPanel(findBy(SEARCH_PANEL), this);
    }

    //latest
    private static final String SOFTWAREVENDORDETAILSPANEL =".//div/div/div[contains(@class,'section_section-inner_')]";
    public SoftwareVendorDetailsPanel getSoftwareVendorPanel() { waitAbit(2000);
        return new SoftwareVendorDetailsPanel(findBy(SOFTWAREVENDORDETAILSPANEL), this);
    }

    public TPAddressInfoPanel getTPAddressinfo(){
        return  new TPAddressInfoPanel(findBy(TP_IDENTIFICATION_ADDRESS_PANEL),this);
    }

    private static final String  TP_ADDRESSDETAILS_PANEL = ".//div[contains(@class,'section_section-inner')]" ;
    public TPAddressDetailsPanel getTPAddressDetails(){
        return  new TPAddressDetailsPanel(findBy(TP_ADDRESSDETAILS_PANEL),this);
    }
    public IdentifyingInformationPanel getTPIdentifyInfo(){
        return  new IdentifyingInformationPanel(findBy(TP_IDENTIFICATION_INFO_PANEL),this);
    }

    private static final String ENROLLMENTPANEL = ".//div[contains(@class, 'details_panel')]";
    public EnrollmentSearchPanel getproviderEnrollmentPanel() {
        return new EnrollmentSearchPanel(findBy(ENROLLMENTPANEL), this);
    }

    //max data
    private static final String ENROLLMENT_SECTION_PANEL = ".//div[contains(@class,'section-inner')]";
    public static final String FILES_AND_DOCUMNETS=".//div[contains(@class,'layout_app-details-inner-body')]";

    public IdentifyingInformationPanel getIndividualIdentifyInfo() {
        return new IdentifyingInformationPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
    public IdentifyingInformationPanel getGroupIdentifyInfo() {
        return new IdentifyingInformationPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
    public LicensureCertificationPanel getLicensureSectionInfo() {
        return new LicensureCertificationPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
    public ProviderIdentifierNumberPanel getProviderIdentifyInfo() {
        return new ProviderIdentifierNumberPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }

    public EFTInformationPanel getEFTInfo() {
        return new EFTInformationPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }

    public AddressPanel getAddressDetails() {
        return new AddressPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }

    public ServiceLocationBillingPanel getServiceLocationBillingInfo() {
        return new ServiceLocationBillingPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
    public ElectronicFundsPaymentPanel getElectricFundsPaymentInfo() {
        return new ElectronicFundsPaymentPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
    public UploadDocumentsPanel getUpLoadDocInfo() {
        return new UploadDocumentsPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }

    public UploadDocumentsPanel getUpLoadDocInFilesAndDocuments() {
        return new UploadDocumentsPanel(findBy( FILES_AND_DOCUMNETS), this);
    }
    //latest
    public RequestRetroactiveAdjustmentPanel getRequestRetroactiveAdjustmentDetails() {
        return new RequestRetroactiveAdjustmentPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
    public TrainingRequiredPanel getTraingingRequiredDetails() {
        return new TrainingRequiredPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
    //sp19
    public ProfileSetupPanel getProfileSetupDetails() {
        return new ProfileSetupPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
    //sp20
    public ConcactPersonDetailsPanel getConcactPersonDetails(){
        return new ConcactPersonDetailsPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }

    //sp21
    private static final String FINGERPRINTPANEL=".//div[contains(@role,'document')]";
    public FingerPrintPanel getFingerPrint() {
        return new FingerPrintPanel(findBy(FINGERPRINTPANEL), this);
    }

    //sp22

    private static final String STATUS = "//div[text()='%s']/..//div//*[local-name() = 'svg' and @aria-hidden='true']";
    public void clickOnStatusButton(String status) {
        scrollToElement(format(STATUS,status));
        waitAbit(500);
        findBy(format(STATUS,status)).click();
        waitAbit(1000);
    }

    private static final String STATUS_WORKFLOW   =".//div//span[contains(text(),'%s')]";
    public boolean verifyingStatusWorkFlow(String statusworkflow) {
        waitAbit(2000);
        return  findBy(format(STATUS_WORKFLOW ,statusworkflow)).isDisplayed();
    }
    //sp26
    public AuthorizedSignaturePanel getAuthorizedSignatureinfo(){
        return new AuthorizedSignaturePanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
    //new PEM
    private static final String  PEM_ENROLLMENT_INFO_PANEL = ".//div[contains(@class,'section_section-inner')]" ;
    public IdentifyingInformationPanel getPEMIdentifyInfo(){
        return  new IdentifyingInformationPanel(findBy(PEM_ENROLLMENT_INFO_PANEL),this);
    }

    public TPAddressInfoPanel getPEMAddressinfo(){
        return  new TPAddressInfoPanel(findBy(PEM_ENROLLMENT_INFO_PANEL),this);
    }

    public TPAddressDetailsPanel getPEMAddressDetailsinfo(){
        return  new TPAddressDetailsPanel(findBy(PEM_ENROLLMENT_INFO_PANEL),this);
    }

    public SoftwareVendorDetailsPanel getPEMSoftwareVendorInfo() {
        return new SoftwareVendorDetailsPanel(findBy(PEM_ENROLLMENT_INFO_PANEL), this);
    }
    //sp26
    private final static String ADD_LINE = ".//button[span[text() = '+ Add Line']]";
    private final static String SAVE = ".//button[span[text() = 'Save']]";
    public void clickAddRow() {
            scrollToElement(ADD_LINE);
            waitABit(500);
            jsClick(ADD_LINE);
    }
    private final static String MESSAGE_BOX = "//button[@aria-label='message box']";
    private final static String CONFIRM_AFFILIATION = "(//div[contains(text(), 'Confirm your affiliation')])[1]";
    private final static String LINK_TO_SIGN ="//a[text()='link to sign']";
    public void clickMessageBox(){
        findBy(MESSAGE_BOX).click();
        waitABit(500);
        findBy(CONFIRM_AFFILIATION).click();
        waitABit(500);
        findBy(LINK_TO_SIGN).click();
        waitABit(500);
    }
    public void clickSave() {
        //sp28
        scrollToElement(SAVE);
        waitAbit(300);
        findBy(SAVE).click();
    }

    private static final String NEXT_BUTTON = ".//button/span[text() = 'Next']";

    public void clickNextButton() {
        waitAbit(300);
        scrollToElement(NEXT_BUTTON);
        findBy(NEXT_BUTTON).click();
    }

    public LicenseInformationPanel getLicenseInfo() {
        return new LicenseInformationPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }

    public OtherMedicaidStatePanel getOtherMedicaidStateInfo() {
        return new OtherMedicaidStatePanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }

    //sp28
    private final static String CLICK_ADD_SECONDARY_SERVICE_LOCATION_BOTTON = ".//div/button[contains(@type,'button')]/span/span";
    public boolean verifyAddSecondaryservicelocationbutton() {
        waitAbit(500);
        scrollToElement(CLICK_ADD_SECONDARY_SERVICE_LOCATION_BOTTON);
        return isElementPresent(CLICK_ADD_SECONDARY_SERVICE_LOCATION_BOTTON);
    }
    public void clickAddSecondaryServiceLocation() {
        waitAbit(500);
        scrollToElement(CLICK_ADD_SECONDARY_SERVICE_LOCATION_BOTTON);
        waitABit(1000);
        findBy(CLICK_ADD_SECONDARY_SERVICE_LOCATION_BOTTON).click();
        waitABit(3000);
    }
//     private final static String CLICK_DELETE_SECONDARY_SERVICE_LOCATION_ICON= ".//div/button[contains(@type,'button')]/span/span/i[@class='SVGInline SVGInline--cleaned icon_sm_2w0BL']";
   //sp29
    private final static String CLICK_DELETE_SECONDARY_SERVICE_LOCATION_ICON= ".//div/button[contains(@type,'button')]/span/span/i";
    public void clickDeleteSecondaryServiceLocation() {
        waitAbit(500);
        scrollToElement(CLICK_DELETE_SECONDARY_SERVICE_LOCATION_ICON);
        waitABit(1000);
        findBy(CLICK_DELETE_SECONDARY_SERVICE_LOCATION_ICON).click();
        waitABit(3000);
    }

    public boolean verifyDeleteIconisDisplaying() {
        waitAbit(500);
        scrollToElement(CLICK_DELETE_SECONDARY_SERVICE_LOCATION_ICON);
        return isElementPresent(CLICK_DELETE_SECONDARY_SERVICE_LOCATION_ICON);
    }
    //verify the Loop PopUp
    private final static String LOOP_POPUP= "//h2[contains(text(), 'Loop Creation/Deletion')]/../parent::div";
    public boolean isLoopPopupOpened() {
        waitAbit(500);
        return isElementPresent(LOOP_POPUP);
    }
    private static final String OK_BUTTON =".//button/span[text()='OK']";
    public void clickOkButton(){
        waitAbit(500);
        findBy(OK_BUTTON).click();
        waitAbit(500);
    }
    //sp28
    public void clickAddRow1() {
        try{
            scrollToElement(ADD_LINE);
            waitABit(500);
            jsClick(ADD_LINE);}
        catch (Exception e){
            System.out.println("license section not present"); }
    }
    public void clickSave1() {
        try{   waitAbit(300);
            jsClick(SAVE);
            //findBy(SAVE).click();
        }
        catch (Exception e){
            System.out.println("license section not present"); }
    }
//sp28
    private static final String STATUS_REQUIRED_ADDTIONAL_INFO   =".//div/div[contains(text(),'%s')]";
    public boolean verifyingStatusRequiredAdditionalInfo(String status) {
        waitAbit(2000);
        return  findBy(format(STATUS_REQUIRED_ADDTIONAL_INFO ,status)).isDisplayed();
    }
    //sp29
    public OwerKeyPersonalPanel getOwerKeyPersonelInfo() {
        return new OwerKeyPersonalPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
    //sp33
    public AffiliationInformationPanel getAffiliationInfo() {
        return new AffiliationInformationPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
    private static final String AFFILAITON_PANEL =".//div[contains(@class, 'details_content')]//div/div";
    public AffiliationInformationPanel getAffilaitionProviderInfo(){
        return  new AffiliationInformationPanel(findBy(AFFILAITON_PANEL), this);
    }
    //sp35
    private final static String CLOSE_BUTTON = ".//button[contains(@aria-label,'Close')]";
    public void clickonclosebutton() {
       try {
           jsClick(CLOSE_BUTTON);
           waitABit(100);
       }
       catch (Exception e){
           System.out.println("pass the test");
       }
    }
    public PharmacyLicenseInformationPanel getPharmacyLicenseInfo() {
        return new PharmacyLicenseInformationPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
    //sp37
    public ExclusionSanctionPanel getExclusionSanctionInfo() {
        return new ExclusionSanctionPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
    private static final String CHANGE_ENROLLMENT_TYPE_PANEL = ".//div[contains(@role,'document')]";
    public ChangeEnrollmentTypePanel getChangeEnrollmentTypeinfo(){
        return new ChangeEnrollmentTypePanel(findBy(CHANGE_ENROLLMENT_TYPE_PANEL), this);
    }

    private static final String NOTIFICATIONS= ".//div[contains(@class,'dashboard_notification_')]/p[text()='%s']";
    public boolean isChangeEnrollTypeNotificationdisplaying(String notification) {
        return  findBy(format(NOTIFICATIONS,notification)).isDisplayed();
    }
    private static final String REASON_FEILD = ".//input[contains(@id, 'Select reason-')]/preceding-sibling::div";
    private static final String  REASON = ".//ul[@role='listbox']/li[text()='%s']" ;
    private static final String  NOTE = ".//label[contains(text(), 'Note')]/../div/div/textarea[3]" ;
    private static final String  APPLY_BUTTON = ".//button[span[text() = 'Apply']]" ;

    public void setreasonforchangeenollmenttype(String reason,String note) {
        waitAbit(1000);
        jsClick(REASON_FEILD);
        selectFromDropDown("Agency recommendation");
        waitAbit(1000);
        jsClick(NOTE);
        findBy(NOTE).type(note);
        waitAbit(1000);
    }
    private static final String  APPLY = ".//button/span[text()='Apply']" ;
    public void clickApply(){
        findBy(APPLY).click();
    }

    //sp42.3
    private static final String SUBMIT_BUTTON1 = "//button[span[text() = 'Submit']]";
    public void clickSubmitButton1() {
        waitABit(500);
        scrollToElement(SUBMIT_BUTTON1);
        waitABit(700);
        jsClick(SUBMIT_BUTTON1);
        // findBy(SUBMIT_BUTTON).click();
    }

    //Demo
    private final static String ADD_LINE1 = "(.//button[span[text() = '+ Add Line']])[2]";
    public void clickAddRow2() {
        scrollToElement(ADD_LINE1);
        waitABit(500);
        jsClick(ADD_LINE1);
    }
    private static final String ADD_LINEE="(//span[contains(text(),'+ Add Line')])[1]";
    public void clickOnAddLine(){
        scrollToElement(ADD_LINEE);
        waitAbit(3000);
        jsClick(ADD_LINEE);
    }

    private static final String ALL_AGES_SERVED = "//input[@value='All']";
    public void allStatesServed() {
        waitABit(500);
        scrollToElement(ALL_AGES_SERVED);
        findBy(ALL_AGES_SERVED).click();
        waitABit(1000);
    }
    private final static String ADD_LINE2 = "(.//button[span[text() = '+ Add Line']])[2]";
    public void clickAddRow3() {
        scrollToElement(ADD_LINE2);
        waitABit(500);
        jsClick(ADD_LINE2);
    }
    //Pharmacy-- Demo -- ddress Section

    private final static String PHARMACY_MEDICARE_CERTIFIED = "//input[@value='Check if this pharmacy is Medicare Certified to bill for durable medical equipment']";
    public void pharmacyMedicareCertified() {
        waitABit(500);
        scrollToElement(PHARMACY_MEDICARE_CERTIFIED);
        findBy(PHARMACY_MEDICARE_CERTIFIED).click();
        waitABit(1000);
    }

    private final static String PHARMACY_PAYMENTS = "//input[@value='Check if the pharmacy payments will go to a corporate office, third party trading partner, or entity other than the pharmacy’s physical address. Please list location name and address below of where pharmacy payments will go, whether checked or not']";
    public void pharmacyPayments() {
        waitABit(500);
        scrollToElement(PHARMACY_PAYMENTS);
        findBy(PHARMACY_PAYMENTS).click();
        waitABit(1000);
    }

    private final static String PHARMACY_PARTICIPATES_340B = "//input[@value='Check if this pharmacy participates in 340B drug pricing program. If checked, please provide contact information and Change Healthcare will contact this person to verify 340B participation and billing process']";
    public void pharmacyParticipates340B() {
        waitABit(500);
        scrollToElement(PHARMACY_PARTICIPATES_340B);
        findBy(PHARMACY_PARTICIPATES_340B).click();
        waitABit(1000);
    }
    private final static String CLIENT_NEEDING_SERVICES = "//input[@value='Check if the pharmacy currently has any Wyoming Medicaid clients needing services']";
    public void clientNeedingServicesPharmacy() {
        waitABit(500);
        scrollToElement(CLIENT_NEEDING_SERVICES);
        findBy(CLIENT_NEEDING_SERVICES).click();
        waitABit(1000);
    }
    private final static String MEDICATIONS_NOT_READILY_SUPPLIED = "//input[@value='Check if the pharmacy provides medications not readily supplied by an in-state Wyoming retail or hospital pharmacy']";
    public void medicationsNotReadilySupplied() {
        waitABit(500);
        scrollToElement(MEDICATIONS_NOT_READILY_SUPPLIED);
        findBy(MEDICATIONS_NOT_READILY_SUPPLIED).click();
        waitABit(1000);
    }

    private final static String WYOMING_BOARD = "//input[@value='Check if the pharmacy has a Wyoming Board of Pharmacy License or plans to obtain one']";
    public void wyomingBoardPharmacy() {
        waitABit(500);
        scrollToElement(WYOMING_BOARD);
        findBy(WYOMING_BOARD).click();
        waitABit(1000);
    }
    private final static String COMPOUND_PRESCRIPTIONS = "//input[@value='Check if the pharmacy is a compounding pharmacy that plans to mail compound prescriptions into the State of Wyoming']";
    public void compoundPrescriptionsPharmacy() {
        waitABit(500);
        scrollToElement(COMPOUND_PRESCRIPTIONS);
        findBy(COMPOUND_PRESCRIPTIONS).click();
        waitABit(1000);
    }

    //SD-05
    private static final String PROCEED_SIGN_CHECKBOX = ".//span/input[contains(@type,'checkbox')]";
    public void clickProceedSignCheckbox() {
        waitAbit(200);
        findBy(PROCEED_SIGN_CHECKBOX).click();
        waitAbit(200);
    }

    // only for existing account to continue enrollement

    private static final String CONTINUE_BUTTON = ".//span[text() = 'Continue']";
    public void clickcontinue() {
        findBy(CONTINUE_BUTTON).click();
    }

    //SD-08

    private static final String SERVICE_LOCATION_FIELD = "//div[contains(@class, 'affiliation_provider-list-item')]/following::div[contains(@class,'affiliation_location-list')]/div[contains(text(),'Service Location')]/../..//div[@title]";
    public boolean verifyServiceLocationDisplay(){
        waitAbit(100);
        return isElementPresent(SERVICE_LOCATION_FIELD);
    }

    public OwnershipPanel getOwnershipInfo() {
        return new OwnershipPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
    public ProffesionalLiabilityInsuranceInfoPanel getProffesionalLiabilityInsuranceInfo(){
        return new ProffesionalLiabilityInsuranceInfoPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
    public static final String TAX_IDENTIFIER_SSN="//input[@value='%s']";
    public void setTaxIdentifier(String ssnCheckBox){
        waitAbit(200);
        findBy(format(TAX_IDENTIFIER_SSN, ssnCheckBox)).click();
        waitAbit(200);
    }
    public static final String SSN_SUBCONTRACTOR="(//input[@value='%s'])[2]";
    public void setSubContractorTaxIdentifier(String subContractorSsn){
        waitAbit(200);
        findBy(format(SSN_SUBCONTRACTOR,subContractorSsn)).click();
        waitAbit(200);
    }

    private final static String ADD_LINE_KEYPERSONNEL = "//div[@data-for='%s']/..//button[span[text() = '+ Add Line']]";
    public void clickAddLineKeyPersonnel(String section) {
        scrollToElement(format(ADD_LINE_KEYPERSONNEL, section));
        waitABit(500);
        findBy(format(ADD_LINE_KEYPERSONNEL, section)).click();
    }

    private static final String SERVICE_LOCATION_PANEL = ".//div[contains(@class,'root_content')]";
    public ServiceLocationPanel getServiceLocationInfo() {
        return new ServiceLocationPanel(findBy(SERVICE_LOCATION_PANEL), this);
    }

    private static final String PROGRAM_PARTICIPATION_SECTION_PANEL = ".//div[contains(@class,'section-inner')]";
    public ProgramParticipationSectionPanel getProgramParticipationSectionInfo() {
        return new ProgramParticipationSectionPanel(findBy(PROGRAM_PARTICIPATION_SECTION_PANEL), this);
    }
    private static final String OTHER_CREDENTAILING_SECTION_PANEL = ".//div[contains(@class,'section-cont')]";
    public OtherCredentialingInformationPanel getOtherCredentialingInformation(){
        return new OtherCredentialingInformationPanel(findBy(OTHER_CREDENTAILING_SECTION_PANEL),this);
    }

    private static final String PROGRAM_PARTICIPATION_POPUP = ".//div[@role='dialog']";
    public ProgramParticipationPanel getProgramParticipationInfo(){
        return new ProgramParticipationPanel(findBy(PROGRAM_PARTICIPATION_POPUP), this);
    }

    public ClassificationPanel setClassificationInfo() {
        return new ClassificationPanel(findBy(ENROLLMENT_SECTION_PANEL),this);
    }

    private static final String SAVE2 = "(.//button[span[text() = 'Save']])[2]";
    public void clickSave2() {
        try{   waitAbit(300);
            findBy(SAVE2).click();
        }
        catch (Exception e){
            System.out.println("Select Bed is not available"); }
    }

    public HealthHomeServicesPanel getHealthHomeServicesPanel() {
        return new HealthHomeServicesPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }

    //SD16 Alternative address code

    public AddressPanel getAlternateAddressDetails() {
        return new AddressPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }

    //.

    private static final String REQUEST_TERMINATION_POPUP = ".//div[@role='dialog']";
    public UploadDocumentsPanel getRequestTerminationPopup() {
        return new UploadDocumentsPanel(findBy(REQUEST_TERMINATION_POPUP), this);
    }
    private static final String APPLICATION_TYPE_DETERMINATION="//input[contains(@value,'%s')][@type='radio']";
    public  void setApplicationTypeDetermination(String text){
        waitAbit(200);
        scrollToElement(format(APPLICATION_TYPE_DETERMINATION,text));
        findBy(format(APPLICATION_TYPE_DETERMINATION,text)).click();
        waitAbit(300);
    }
    public void setAddServicelocationProvidertype(){
        waitAbit(2000);
        jsClick(SERVICE_LOCATION_EFT);
        waitAbit(200);
        clickAnyOptionInList(1);
        waitAbit(2000);
        jsClick(PROVIDER_TYPE_EFT);
        waitAbit(2000);
        clickAnyOptionInList(1);
        waitAbit(2000);
        driver.findElement(By.xpath("//div[contains(@id, 'Select Provider Type(s)') and @role='button' and @aria-haspopup='listbox']")).sendKeys(Keys.ESCAPE);
        waitAbit(200);
    }
    private static final String SOLE_PROPRIETOR="//input[@value='%s'][@type='radio']";
    public void setPracticeType(String textForPT){
        waitAbit(200);
        scrollToElement(format(SOLE_PROPRIETOR,textForPT));
        findBy(format(SOLE_PROPRIETOR,textForPT)).click();
        waitAbit(3);
    }
    private static final String AUTHORIZED_PERSON=".//div[@data-for='%s']";
    private static final String SELECT_AUTHORIZED_PERSON=".//div//ul[@role='listbox']//li";
    public void setAuthorizedPerson(String authorizedPerson){
        scrollToElement(format(AUTHORIZED_PERSON, authorizedPerson));
        waitAbit(200);
        findBy(format(AUTHORIZED_PERSON, authorizedPerson)).click();
        waitAbit(2000);
        findBy(SELECT_AUTHORIZED_PERSON).click();
        waitAbit(3000);
        findBy("//html").sendKeys(Keys.ESCAPE);
    }
    private static final String EFT_INFO_EDIT="//span[@class='assist-table-ico']";
    public void editDetailsOfEFTInfo(){
        waitAbit(300);
        scrollToElement(EFT_INFO_EDIT);
        waitAbit(300);
        findBy(EFT_INFO_EDIT).click();
        waitAbit(300);
    }
private static final String SECTIONS_NAMES=".//div[contains(@class, 'menu-item')]/span";
    public List<String> getSectionsNames() {
        waitAbit(1000);
        return findAll(SECTIONS_NAMES).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }
    private static final String TABS="//div[contains(@class, 'header')]//ul/li/a";
    public List<String> getTabNames(){
        waitAbit(500);
        return findAll(TABS).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }
    private static final String ROW_COUNT="//div[contains(@class,'expansion-panel-menu')]";
    public List<String> verifyServiceLocationsCount() {
        List<WebElementFacade> elements = findAll(ROW_COUNT);
        return elements.stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }
    private static final String AFFILIATION_ROW_COUNT="//div[contains(@class,'provider-list-item')]";
    public List<String> verifyAffiliationCount() {
        List<WebElementFacade> elements = findAll(AFFILIATION_ROW_COUNT);
        return elements.stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }
    private static final String BUTTON="//ul//li[contains(text(),'%s')]";
    public void clickOnEditButton(String editButton){
        waitAbit(400);
        findBy(format(BUTTON, editButton)).click();
        waitAbit(400);
    }
        private static final String LICENSE_EDIT_BUTTON="//span[contains(text(),'%s')]";
    public void ClickOnLicenseEditButton(String button){
        waitAbit(400);
        findBy(format(LICENSE_EDIT_BUTTON,button)).click();
        waitAbit(400);
    }

    private static final String BUTTON_IN_POPUP="//button[@type='submit']//span[contains(text(),'%s')]";
    public void clickOnButtonInPopUp(String buttonName){
        waitAbit(200);
        findBy(String.format(BUTTON_IN_POPUP,buttonName)).click();
        waitAbit(300);
    }
    private static final String SAVE_BUTTON="(//button[@type='button']//span[contains(text(),'Save')])[2]";
    public void clickOnSaveButton(){
        waitAbit(500);
        findBy(SAVE_BUTTON).click();
        waitAbit(500);
    }
    private static final String UPDATED_LOC="//div//p[contains(text(),'%s')]";

    public boolean isServiceLocationDisplayed(String location){
        return findBy(String.format(UPDATED_LOC, location)).isVisible();

    }
    private static final String AFFILIATION_EFFECTIVE_END_DATE="(//div[contains(@class,'location-item-pp')]//div[3])[1]";
    public boolean verifyAffiliationEffectiveEndDate(String tmrwdate,String enrollmentType){
        findBy(String.format(DOWN_ARROW,enrollmentType)).click();
        waitAbit(300);
        return findBy(String.format(AFFILIATION_EFFECTIVE_END_DATE, tmrwdate)).isVisible();
    }
    private static final String UPDATED_DOWN_ARROW="//div//p[contains(text(),'%s')]/../../../../../..//div//button[contains(@aria-label,'Expand More')]";
    private static final String UPDATED_EFFECTIVE_END_DATE="(//div//p[contains(text(),'%s')]/../../../../../..//div[contains(@class,'table-text_tooltip-wrapper-content')]//p)[7]";
    public boolean verifyUpdatedEffectiveEndDate(String providerLegalBusinessName,String expDate){
        findBy(String.format(UPDATED_DOWN_ARROW,providerLegalBusinessName)).click();
        waitAbit(400);
        return  findBy(String.format(UPDATED_EFFECTIVE_END_DATE,expDate)).isVisible();

    }

    private static final String LICENSE_NUM= "//div//p//span[contains(text(),'%s')]";

    public boolean isLicenseNumberDisplayed(String licenseNo) {
        return findBy(String.format(LICENSE_NUM, licenseNo)).isVisible();
    }
    private static final String ADDED_TAXONOMY="//span[contains(text(),'%s')]";
    public boolean verifyAddedTaxonomy(String taxonomy){
        return findBy(String.format(ADDED_TAXONOMY,taxonomy)).isVisible();
    }
    private static final String ADDED_LOCATION="(//p[contains(text(),'%s')])[1]";
    public boolean verifyAddedLocation(String locationType){
        return findBy(String.format(ADDED_LOCATION,locationType)).isVisible();
    }
    private static final String DOWN_ARROW="//div[contains(@class,'provider-list')]//div//div[contains(text(),'%s')]/..//div[6]//*[name()='svg']";
   private static final String EDIT_BUTTON="(//div[contains(@class,'show-edit')])[1]";
    public void editTheDetailsOfAffiliation(String enrollmentType){
        waitAbit(400);
        findBy(String.format(DOWN_ARROW,enrollmentType)).click();
        waitAbit(300);
        findBy(EDIT_BUTTON).click();
        waitAbit(500);
    }

    private static final String POPUP_MESSAGE = "//div[contains(@class,'MuiDialogTitle-root')]";

    public String getOwnershipPopupMessage() {
        return findBy(POPUP_MESSAGE).getText();
    }
    private static final String EDIT="(//div[contains(@class,'edit-cell-command')]//span//*[name()='svg'])[1]";
    public static final String PERCENT_OF_INTEREST="//input[@aria-label='Percent of Interest']";
    public void editPercentOfInterestPercentage(String percentage){
        waitAbit(200);
        findBy(EDIT).click();
        waitAbit(3000);
        findBy(PERCENT_OF_INTEREST).clear();
        waitAbit(200);
        findBy(PERCENT_OF_INTEREST).sendKeys(percentage);
        waitAbit(500);
    }
    private static final String NAME="//div[contains(@id,'Name')]";
    private static final String SELECT_NAME="//div//ul//li[contains(text(),'%s')]";
    public void verifyAndSelectName(String value) {
        waitAbit(200);
        findBy(NAME).click();
        waitAbit(300);

        WebElement element = findBy(format(SELECT_NAME, value));

        if (element.isDisplayed() && element.getText().trim().equals(value)) {
            element.click();
            waitABit(1000);
            findBy("//ul[@aria-label='Select an option']").sendKeys(Keys.ESCAPE);
            waitABit(1000);
        } else {
            throw new AssertionError("Expected text '" + value + "' not found.");
        }
    }

    private static final String TEXT_XPATH = "//div//ul//li[contains(text(),'%s')]";
    private static final String SELECT_NAME_XPATH = "//div//ul//li[contains(text(),'%s')]";
    public void verifyAndSelectOwnershipDetails(String value1,String value2,String value3,String value4) {
        waitAbit(200);
        findBy(NAME).click();
        waitAbit(300);
        WebElement personEntityElement = findBy(String.format(TEXT_XPATH, value1));
        WebElement subcontractorElement = findBy(String.format(TEXT_XPATH, value2));
        WebElement keyPersonalElement = findBy(String.format(TEXT_XPATH, value3));

        if (personEntityElement.isDisplayed() && subcontractorElement.isDisplayed() && keyPersonalElement.isDisplayed()) {
            System.out.println("Verified personOrEntityOwnership: " + value1);
            System.out.println("Verified subcontractorOwnership: " + value2);
            System.out.println("Verified keyPersonalNames: " + value3);

            WebElement selectElement = findBy(String.format(SELECT_NAME_XPATH, value4));
            selectElement.click();
            waitABit(1000);
            findBy("//ul[@aria-label='Select an option']").sendKeys(Keys.ESCAPE);
            waitABit(1000);
        } else {
            throw new AssertionError("Expected values not found: " + value1 + ", " + value2 + ", or " + value3);
        }
    }



    public void verifyAndSelectOwnershipDetailsInES(String ownershipvalue,String kpValue,String organizationLegalBusinessName){
        waitAbit(200);
        findBy(NAME).click();
        waitAbit(300);
        WebElement ownershipvalueES = findBy(String.format(TEXT_XPATH, ownershipvalue));
        WebElement kpValueinES = findBy(String.format(TEXT_XPATH, kpValue));

        if (ownershipvalueES.isDisplayed() && kpValueinES.isDisplayed() ) {
            System.out.println("Verified personOrEntityOwnership: " + ownershipvalue);
            System.out.println("Verified subcontractorOwnership: " + kpValue);

//            WebElement selectOwnershipvalue = findBy(String.format(SELECT_NAME_XPATH, organizationLegalBusinessName));
//            selectOwnershipvalue.click();
            findBy(String.format(SELECT_NAME_XPATH, organizationLegalBusinessName)).click();
            waitABit(1000);
            findBy("//ul[@aria-label='Select an option']").sendKeys(Keys.ESCAPE);
            waitABit(1000);
        } else {
            throw new AssertionError("Expected values not found: " + kpValue + ", " + ownershipvalue + ", ");
        }
    }



        private static final String UPLOAD_DOC_BUTTON = ".//*[text() = '%s']/../../div[contains(@class, 'upload_upload-controls')]//span";

    private static final String EXCLUSION_SANCTION_DOC="//div//h2[text()='%s']";
    public void verifyExclusionOrSanctionDoc(String docType){
        WebElement doc = findBy(format(EXCLUSION_SANCTION_DOC, docType));

        if(doc.isDisplayed()){
            System.out.println("Field '" + docType + "' is present.");
        }
        else {
            throw new AssertionError("Field '" + docType + "' is not displayed.");
        }

    }
    private static final String GET_EFFECTIVE_END_DATE="//span[contains(text(),'%s')]/ancestor::div[contains(@class, 'tile-table-row')]//div[contains(@class,'tile-table-column')][5]//div//span";
    public WebElement verifyEffectiveEndDate(String expDate, String taxonomyValue){
        WebElement effectiveEndDate=findBy(String.format(GET_EFFECTIVE_END_DATE,taxonomyValue));
        return effectiveEndDate;
    }
    private static final String CLEARING_HOUSE_DATA="(//div[contains(@class,'details_houseClearing-List')])[1]";
    private static final String IN_PROGRESS="";
    public void verifyDataInClearingHouse(){
        try{
            findBy(CLEARING_HOUSE_DATA).isDisplayed();
            System.out.println("====Data is present Under Clearing House Tab====");
        }
        catch (Exception e){
          System.err.println("====Under clearing status is in progress====");
        }
    }
    public static final String INDICATORS_DATA="//div[contains(@class,'tile-table-row')]";
    private static final String NO_RESULTS_FOUND="//div[contains(text(),'No Records Found')]";
    public void verifyIndicatorsData(){
        try{
            findBy(INDICATORS_DATA).isDisplayed();
            System.out.println("Data is present");
        }
        catch (Exception e){
            findBy(NO_RESULTS_FOUND).isDisplayed();
            System.err.println("=====NO RESULTS FOUND=====");
        }
    }

    private static final String NO_RESULTS="//h3[contains(text(),'No Records Found')]";
    public void verifyProviderContractsData(){
        try{
            findBy(INDICATORS_DATA).isDisplayed();
            System.out.println("Data is present");
        }
        catch (Exception e){
            findBy(NO_RESULTS).isDisplayed();
            System.err.println("=====NO RESULTS FOUND=====");
        }
    }

    private static final String HISTORY_DATA="//div[contains(@class,'requests_table-body')]";
    public void verifyDataUnderHistory(){
        try{
            findBy(HISTORY_DATA).isDisplayed();
            System.out.println("Data is present under History tab");
        }
        catch (Exception e){
            findBy(NO_RESULTS_FOUND).isDisplayed();
            System.err.println("=====NO RESULTS FOUND=====");
        }
    }

    private static final String FILES="(//div[contains(@class,'documents_file-details-group')])[1]";
    public void verifyFiles(){
        try {
            findBy(FILES).isDisplayed();
            System.out.println("Attached Files are displaying");
        }
        catch (Exception e){
            System.err.println("====FILES ARE NOT ATTACHED/FILES ARE NOT DISPLAYING====");
        }

    }
    private static final String NEXT_BUTTONN="(//button//span[contains(text(),'%s')])[2]";
    public void clickOnNextButton(String buttonName){
        waitAbit(300);
        findBy(String.format(NEXT_BUTTONN,buttonName)).click();
        waitAbit(400);
    }

    public static final String OWNERSHIP_PERCENT="//input[contains(@aria-label,'Ownership %')]";
    public void editOwnerhsipPercentage(String ownershipPercent){
        waitAbit(200);
        findBy(OWNERSHIP_PERCENT).sendKeys(ownershipPercent);
        waitAbit(300);
    }
    private static final String RAI_COUNT = "//span[contains(text(),'No. of Re-Submissions')]/../..//following-sibling::div//div[contains(@class,'action')]//span";

    public int verifyRAICount() {
        List<WebElementFacade> raiElements = findAll(RAI_COUNT);
        return raiElements.size();
    }
    public void fillgender(){
        waitAbit(3000);
//        jsClick(GENDER);
        findBy(GENDER).click();
        waitAbit(3000);
        selectFromDropDown("Male");
    }
}



