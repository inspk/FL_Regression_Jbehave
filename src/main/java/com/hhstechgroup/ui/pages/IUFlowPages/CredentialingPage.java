package com.hhstechgroup.ui.pages.IUFlowPages;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.pages.providerData.ProviderDataSearchPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.hhstechgroup.ui.pages.IUFlowPages.RateSettingPages.APPROVALS_EDIT_BUTTON;
import static java.lang.String.format;

public class CredentialingPage extends AbstractPage {

    ProviderDataSearchPage providerDataSearchPage;
    String requestId;

    // Credentialing locators
    private static final String ADD_CREDENTIALING = "(//*[contains(text(),'Credentialing')])[3]";
    private static final String SEARCH_WITH_NPI = "//input[@id='provider']";
    private static final String NPI_SEARCH_BUTTON = "(//*[contains(@class, 'MuiButtonBase-root MuiIconButton-root jss')])[2]";
    private static final String CREATE_BUTTON = "//span[contains(text(),' Create')]";
    private static final String CANCEL_BUTTON = "//span[contains(text(),'Cancel')]";
    private static final String SECTION_CREDENTIALING_DETAILS = "//*[@class='menu-item active']";
    private static final String SECTION_UPLOAD_CREDENTIALING_DOCUMENTS = "//span[contains(text(),'Upload Credentialing Documents')]";
    private static final String LINK_CREDENTIALING = "//span[contains(text(),'Go to Credentialing')]";
    private static final String SubmitButton = ".//button//span[.='Submit']";

    // Radio button locators for credentialing questions
    private static final String RADIOBUTTON_LICENSE_VALIDITY = "//input[contains(@name, '1. Is the provider')][@value='%s']";
    private static final String RADIOBUTTON_MEDICARE_MEDICAID_ENROLLMENT = "//input[contains(@name, '2. Is the provider currently enrolled and active in Medicare and Medicaid programs')][@value='%s']";
    private static final String RADIOBUTTON_EDUCATION_TRAINING_VERIFICATION = "//input[contains(@name, '3. Have all required education, training')][@value='%s']";
    private static final String RADIOBUTTON_HOSPITAL_PRIVILEGES = "//input[contains(@name, '4. Does the provider have verified hospital privileges')][@value='%s']";
    private static final String RADIOBUTTON_MALPRACTICE_INSURANCE = "//input[contains(@name, '5. Has the provider maintained adequate and continuous')][@value='%s']";
    private static final String RADIOBUTTON_DISCIPLINARY_ACTIONS = "//input[contains(@name, '6. Are there any final orders, disciplinary actions,')][@value='%s']";
    private static final String RADIOBUTTON_PENDING_INVESTIGATIONS = "//input[contains(@name, '7. Are there any pending investigations,')][@value='%s']";
    private static final String RADIOBUTTON_HISTORY_DISCLOSURE = "//input[contains(@name, '8. Has the provider truthfully disclosed all history related to sanctions,')][@value='%s']";
    private static final String RADIOBUTTON_PEER_REFERENCES = "//input[contains(@name, '9. Are professional peer references available and do they support the provider')][@value='%s']";
    private static final String RADIOBUTTON_ESCALATION_MECHANISM = "//input[contains(@name, '10. Is there an internal mechanism to escalate any ambiguous or incomplete')][@value='%s']";

    // Assigning credential locators
    private static final String NPI_SEARCH = "//input[@id='NPI']";
    private static final String SEARCH_BUTTON = "//span[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'search']";
    private static final String SELECT_UNASSIGNED = "(//p[text()='Unassigned'])[1]";
    private static final String SELECT_CVO_REVIEW_COMMITTEE = "//div[contains(p/text(), 'CVO REVIEW COMMITTEE')]/span";
//    private static final String CVO_MEDICAL_DIRECTOR = "//div[p[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'cvo medical director')]]";
private static final String CVO_MEDICAL_DIRECTOR = "//div[contains(p/text(), 'CVO MEDICAL DIRECTOR')]/span";
    private static final String CLICK_ON_ASSIGN = "//*[@class='MuiButton-label'][text()='Assign']";

    // Approving credentials locators
    private static final String CLICK_AGREE = "//span[contains(text(), 'Agree')]";
    private static final String CLICK_CREDENTIALING = "//a[contains(@href, 'credentialing')]";
    private static final String NPI_SEARCH_CREDENTIALING = "//input[@id='NPI']";
    private static final String Request_ID_Search = "//input[@id='RequestID']";
    private static final String SEARCH_BUTTON_CREDENTIALING = "//span[contains(text(), 'Search')]";
    private static final String CLICK_ON_NEW = "(//p[contains(text(), 'NEW')])[1]";
//    private static final String CLICK_ON_UNASSIGN = "(//span[text()='Unassigned'])[1]";
private static final String CLICK_ON_UNASSIGN = "//div[contains(@class,'table-body')]//div/div[contains(@class,'table-column')]//p[.='Unassigned']";
    private static final String SELECT_CVO_REVIEW_COMMITTEES = "(//p[text()='Cvo review committee'])";
    private static final String CLICK_ON_ASSIGN_G = "//*[@class='MuiButton-label'][text()='Assign']";

    private static final String CLICK_ON_CHANGE_STATUS = "//button[span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'change status')]]";
    private static final String CLICK_ON_NEW_POPUP = "//*[contains(@class, 'MuiSvgIcon-root MuiSelect-icon MuiSelect-iconOutlined')]";
    private static final String CLICK_ON_CREDENTIALING_FINAL = "//li[contains(text(), 'Flag To CVO Medical Director')]";
    private static final String CLICK_ON_REASON = "//div[contains(@class, 'MuiSelect-root') and contains(@id, 'Reason-')]";
    private static final String REASON_DROP_DOWN = "//*[contains(text(), 'Need Review from CVO Medical Director')]";
    private static final String CLICK_ON_RESULT = "//div[contains(@class, 'MuiSelect-root') and contains(@id, 'Result-')]";
    private static final String CLICK_ON_PASSED = "//li[contains(@data-value, 'PASSED')]";
    private static final String CLICK_ON_APPLY = "//span[contains(@class, 'MuiButton-label') and contains(text(), 'Apply')]";
    private static final String COMPLETED_SUCCESSFUL = "//p[contains(@class, 'MuiTypography-root') and contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'saved changes successfully')]";

//    private static final String ASSIGNEE = "(//div[.//span[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'assignee')]]      //div[@class='details_action_1A_jL']/span)[1]";
private static final String ASSIGNEE = "//div[contains(@class,'table-body')]//div/div[contains(@class,'table-column')][8]//p";
    private static final String CREDENTIALING_REQ_ID = "//div[@class='MuiCardHeader-content']//span[contains(text(),'Credentialing request')]";
    private static final String REQ_ID_SEARCH = "//input[translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'requestid']";
    private static final String FLAG_TO_MEDICAL_DIRECTOR = "//div[@role='button' and contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'flag to cvo medical director')]";
    private static final String ASSIGN_BUTTON_CVORC = "//span[@class='MuiButton-label' and translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'assign']";
    private static final String CHANGE_STATUS_DROP_DOWN_Option = "//li[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'credentialing completed with findings']";
private static final String CHANGE_STATUS_DROP_DOWN = "//div[@role='dialog']//div[contains(@class,'MuiDialogContent')]//div[contains(@aria-labelledby,'Status')]";
    private static final String REASON_DROPDOWN = "//li[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'positive']";
    private static final String RESULT_DROPDOWN = "//li[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'passed']";

    private static final String Credentialing_Toggle = "//div[contains(@class,'header-new-switch')]//h3[contains(text(),'Credentialing')]//following::label[1]/span[contains(@class,'MuiSwitch')]";
    public static final String APPROVALS_SAVE_CHANGES_BUTTON =("//span[contains(.,'Save Changes')]");


    public CredentialingPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddCredentialing() {
        waitForPresenceOf(ADD_CREDENTIALING);
        findBy(ADD_CREDENTIALING).click();
    }

    public void searchWithNPI(String npi) {
        waitForPresenceOf(SEARCH_WITH_NPI);
        WebElementFacade inputField = findBy(SEARCH_WITH_NPI);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].focus();", inputField);
        inputField.type(npi);
    }

    public void clickNPISearchButton() {
        findBy(NPI_SEARCH_BUTTON).click();
    }

    public void clickCreateButton() {
        findBy(CREATE_BUTTON).click();
    }

    public void clickSectionCredentialingDetails() {
        findBy(SECTION_CREDENTIALING_DETAILS).click();
    }

    public void clickSectionUploadCredentialingDocuments() {
        findBy(SECTION_UPLOAD_CREDENTIALING_DOCUMENTS).click();
    }

    public void clickLinkCredentialing() {
        findBy(LINK_CREDENTIALING).click();
    }

    public void clickSubmitButton() {
        findBy(SubmitButton).click();
    }

    public void selectAllRadioButtonsForCredentialingDetails(String radioButtonValue) {
        findBy(format(RADIOBUTTON_LICENSE_VALIDITY, radioButtonValue)).click();
        findBy(format(RADIOBUTTON_MEDICARE_MEDICAID_ENROLLMENT, radioButtonValue)).click();
        findBy(format(RADIOBUTTON_EDUCATION_TRAINING_VERIFICATION, radioButtonValue)).click();
        findBy(format(RADIOBUTTON_HOSPITAL_PRIVILEGES, radioButtonValue)).click();
        findBy(format(RADIOBUTTON_MALPRACTICE_INSURANCE, radioButtonValue)).click();
        findBy(format(RADIOBUTTON_DISCIPLINARY_ACTIONS, radioButtonValue)).click();
        findBy(format(RADIOBUTTON_PENDING_INVESTIGATIONS, radioButtonValue)).click();
        findBy(format(RADIOBUTTON_HISTORY_DISCLOSURE, radioButtonValue)).click();
        findBy(format(RADIOBUTTON_PEER_REFERENCES, radioButtonValue)).click();
        findBy(format(RADIOBUTTON_ESCALATION_MECHANISM, radioButtonValue)).click();
    }

    public void searchNPICredentialing(String npi) {
        findBy(NPI_SEARCH_CREDENTIALING).type(npi);
    }

    public void searchwithRequestID(){
        findBy(Request_ID_Search).sendKeys(requestId);
    }

    public void clickSearchButtonCredentialing() {
        findBy(SEARCH_BUTTON_CREDENTIALING).click();
    }

    public void clickOnNew() {
        findBy(CLICK_ON_NEW).click();
    }

    public void ChangeStatusFlagToMedicalDirector(String enrolltype){
        waitAbit(8000);
//        providerDataSearchPage.clickOnEnrollmentType(enrolltype);
        waitAbit(8000);
        clickOnChangeStatus();
        waitAbit(1000);
        clickChangeStatusDropdown();
        waitAbit(1000);
        selectFromDropDown("Flag To CVO Medical Director");
        waitAbit(1000);
        clickOnReason();
        waitAbit(1000);
        selectFromDropDown("Need Review from CVO Medical Director");
        waitAbit(1000);
        clickOnApply();
       waitAbit(1000);
    }

    public void clickOnUnassigned() {
        findBy(CLICK_ON_UNASSIGN).click();
    }

    public void selectCVOReviewCommittee() {
        findBy(SELECT_CVO_REVIEW_COMMITTEE).click();
    }

    public void clickOnAssign() {
        findBy(CLICK_ON_ASSIGN).click();
    }

    public void clickCredentialing() {
        findBy(CLICK_CREDENTIALING).click();
    }

    public void clickAssignee() {
        findBy(ASSIGNEE).click();
    }

    public void clickCVOMedicalDirector() {
        findBy(CVO_MEDICAL_DIRECTOR).click();
    }

    public void clickAssignButtonCVORC() {
        findBy(ASSIGN_BUTTON_CVORC).click();
    }

    public String getCredentialingRequestId() {
        String fullText = findBy(CREDENTIALING_REQ_ID).getText();
        requestId = fullText.replace("Credentialing request #", "").trim();
        return requestId.replaceAll("-", "").trim();
    }

    public String ReturnCredentialingRequestID(){
        return requestId.replaceAll("-", "").trim();
    }

    public void searchRequestId(String requestId) {
        findBy(REQ_ID_SEARCH).type(requestId);
    }

    public void clickSearchButton() {
        waitAbit(3000);
        findBy(SEARCH_BUTTON).click();
    }

    public void clickOnRequestIdRow(String lastThreeDigits) {
        String dynamicXPath = "//div[contains(@class,'tile-table-row-summary')]//p[normalize-space(text())='" + lastThreeDigits + "']";
        findBy(dynamicXPath).click();
    }

    public void clickOnChangeStatus() {
        findBy(CLICK_ON_CHANGE_STATUS).click();
    }

    public void clickFlagToMedicalDirector() {
        findBy(FLAG_TO_MEDICAL_DIRECTOR).click();
    }

    public void clickChangeStatusDropdown() {
        findBy(CHANGE_STATUS_DROP_DOWN).click();
    }

    public void clickCHANGESTATUSDROPDOWNOption(){
        findBy(CHANGE_STATUS_DROP_DOWN_Option).click();
    }

    public void clickOnReason() {
        findBy(CLICK_ON_REASON).click();
    }

    public void clickReasonDropdown() {
        findBy(REASON_DROPDOWN).click();
    }

    public void clickOnResult() {
        findBy(CLICK_ON_RESULT).click();
    }

    public void clickResultDropdown() {
        findBy(RESULT_DROPDOWN).click();
    }

    public void clickOnApply() {
        findBy(CLICK_ON_APPLY).click();
    }

    public boolean isCompletedSuccessfulDisplayed() {
        return findBy(COMPLETED_SUCCESSFUL).isDisplayed();
    }

    public void waitForElement(String locator) {
        waitForPresenceOf(locator);
    }

    public void verifyCredentialing(){
        waitAbit(10000);
//        ajaxScroll(RATE_SETTING_TOGGLE);
        scrollToElement(Credentialing_Toggle);
        System.out.println("Scroll down to Rate Setting ");
        waitAbit(10000);
        String state = findBy("//div[contains(@class,'header-new-switch')]//h3[contains(text(),'Credentialing')]//following::label[1]/span[contains(@class,'MuiSwitch')]").getAttribute("aria-disabled");
        if ("false".equals(state)) {
            System.out.println("Toggle is OFF");
        }
        else {
            waitAbit(5000);
            System.out.println("Toggle button is disabled");
            scrollToElement(APPROVALS_EDIT_BUTTON);
            waitAbit(5000);
            findBy(APPROVALS_EDIT_BUTTON).click();
            System.out.println("Clicked on Edit button");
            waitAbit(5000);
            scrollToElement(Credentialing_Toggle);
            waitAbit(5000);
            findBy(Credentialing_Toggle).click();
            System.out.println("credentialing Enabled");
            waitAbit(5000);
            scrollToElement(APPROVALS_SAVE_CHANGES_BUTTON);
            waitAbit(5000);
            findBy(APPROVALS_SAVE_CHANGES_BUTTON).click();
            System.out.println("Clicked on Save");
        }
    }

} 