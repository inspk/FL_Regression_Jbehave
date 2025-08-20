package com.hhstechgroup.ui.panels.enrollment.ownership;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import static java.lang.String.format;

public class OwnershipPanel extends BaseEnrollmentPanel {

    private static final String HAD_OWNERSHIP_IN_ANY_ORGANIZATION = "had ownership in any organization";
    private static final String PREVIOUSLY_MANAGED_ORGANIZATIONS = "managed or directed any organization";
    private static final String HAS_OWNERSHIP_INTEREST = "ownership interest of 5";
    private static final String HAS_FAMILY_OWNERSHIP_INTEREST = "members of your immediate family";
    private static final String OWNERSHIP_INFORMATION_TABLE = ".//span[text() = 'Ownership information ']/ancestor::div[contains(@class, 'rdw-editor-main')]/ancestor::div[4]/following-sibling::div[1]//table/ancestor::div[3]";
    private static final String MANAGING_DIRECTING_INFORMATION_TABLE = ".//span[contains(text(), 'Managing')]/ancestor::div[contains(@class, 'rdw-editor-main')]/ancestor::div[4]/following-sibling::div[1]//table/ancestor::div[3]";
    private static final String SUBCONTRACTOR_INFORMATION_TABLE = ".//span[contains(text(), 'Subcontractor')]/ancestor::div[contains(@class, 'rdw-editor-main')]/ancestor::div[4]/following-sibling::div[1]//table/ancestor::div[3]";
    private static final String RELATIVE_INFORMATION_TABLE = ".//span[contains(text(), 'Relative')]/ancestor::div[contains(@class, 'rdw-editor-main')]/ancestor::div[4]/following-sibling::div[1]//table/ancestor::div[3]";
    private static final String MIDDLE_NAME = "Middle Name";

    public void setMiddleName(String middleName) {
        waitABit(500);
        fillModifiedField(MIDDLE_NAME, middleName);
        waitABit(500);
    }
    private static final String TYPE_OF_CONTRACT="//div[contains(@id,'Type of Contract')]";
    private static final String SELECT_TYPE_OF_CONTRACT="//div//ul//li[contains(text(),'%s')]";
    public void setTypeOfContract(String typeOfContract){
        waitABit(200);
        findBy(TYPE_OF_CONTRACT).click();
        waitABit(500);
        findBy(format(SELECT_TYPE_OF_CONTRACT, typeOfContract)).click();
        waitABit(300);
    }
    public OwnershipPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public OwnershipCommonInformationTable getOwnershipInformationTable() {
        scrollToElement(OWNERSHIP_INFORMATION_TABLE);
        return new OwnershipCommonInformationTable(findBy(OWNERSHIP_INFORMATION_TABLE), getBasePage());
    }

    public OwnershipCommonInformationTable getManagingDirectingInformationTable() {
        scrollToElement(MANAGING_DIRECTING_INFORMATION_TABLE);
        return new OwnershipCommonInformationTable(findBy(MANAGING_DIRECTING_INFORMATION_TABLE), getBasePage());
    }

    public OwnershipCommonInformationTable getSubcontractorInformationTable() {
        scrollToElement(SUBCONTRACTOR_INFORMATION_TABLE);
        return new OwnershipCommonInformationTable(findBy(SUBCONTRACTOR_INFORMATION_TABLE), getBasePage());
    }

    public RelativeInformationTable getRelativeInformationTable() {
        scrollToElement(RELATIVE_INFORMATION_TABLE);
        return new RelativeInformationTable(findBy(RELATIVE_INFORMATION_TABLE), getBasePage());
    }

    public void setHadOwnershipInAnyOrganization(String hadOwnershipInAnyOrganization) {
        selectRadionButton(HAD_OWNERSHIP_IN_ANY_ORGANIZATION, hadOwnershipInAnyOrganization);
    }

    public void setPreviouslyManagedOrganizations(String previouslyManagedOrganizations) {
        selectRadionButton(PREVIOUSLY_MANAGED_ORGANIZATIONS, previouslyManagedOrganizations);
    }

    public void setHasOwnershipInterest(String hasOwnershipInterest) {
        selectRadionButton(HAS_OWNERSHIP_INTEREST, hasOwnershipInterest);
    }

    public void setHasFamilyOwnershipInterest(String hasFamilyOwnershipInterest) {
        selectRadionButton(HAS_FAMILY_OWNERSHIP_INTEREST, hasFamilyOwnershipInterest);
    }
    private static final String FEIN="//div[contains(@data-for,'FEIN')]//div//input";
    public void setFein(String fein){
        waitABit(300);
        findBy(FEIN).sendKeys(fein);
        waitABit(300);
    }

    private static final String OWNERSHIP_CODE = "//div/input[@name='1. Select Ownership Code']";
    private static final String OWNERSHIP_CODE_DROPDOWN = "//div[@role='menuitem']//strong[text()='%s']";
    public void setOwnershipCode(String ownershipCode){
        waitABit(500);
        findBy(OWNERSHIP_CODE).click();
        waitABit(500);
        findBy(format(OWNERSHIP_CODE_DROPDOWN,ownershipCode)).click();
//        selectFromDropDown(ownershipCode);
        waitABit(500);
    }

    private static final String PERSON_OWNERSHIP = "Does any person have a 5% or greater ownership or control interest, whether direct or indirect, in this provider?";
    public void setPersonOwnership(String personOwnership) {
        selectRadionButton(PERSON_OWNERSHIP, personOwnership);
    }

    private static final String ENTITY_OWNERSHIP = "Does any entity have a 5% or greater ownership or control interest, whether direct or indirect, in this provider";
    public void setEntityOwnership(String entityOwnership) {
        selectRadionButton(ENTITY_OWNERSHIP, entityOwnership);
    }

    private static final String PERSON_OR_ENTITY_OWNERSHIP = "Does any person or entity have a 5% or more interest in any mortgage, deed of trust, note, or other obligation secured by the enrolling provider where that interest equals at least 5% of the value of the property or assets of the enrolling provider";
    public void setPersonOrEntityOwnership(String personOrEntityOwnership) {
        selectRadionButton(PERSON_OR_ENTITY_OWNERSHIP, personOrEntityOwnership);
    }

    private static final String CORPORATION_OWNERSHIP = "For an enrolling provider organized as a corporation, is there any officer or director";
    public void setCorporationOwnership(String corporationOwnership) {
        selectRadionButton(CORPORATION_OWNERSHIP, corporationOwnership);
    }

    private static final String PARTNERSHIP_OWNERSHIP = "For an enrolling provider organized as a partnership, is there any partner";
    public void setPartnershipOwnership(String partnershipOwnership) {
        selectRadionButton(PARTNERSHIP_OWNERSHIP, partnershipOwnership);
    }

    private static final String SUBCONTRACTOR_OWNERSHIP = "Has the enrolling provider contracted or delegated any of its management functions to another person, agency, or organization (i.e., subcontractor)";
    public void setSubcontractorOwnership(String subcontractorOwnership) {
        selectRadionButton(SUBCONTRACTOR_OWNERSHIP, subcontractorOwnership);
    }

    private static final String FAMILYMEMBERS_OWNERSHIP = "Do any immediate family members of the provider or owner(s) have ownership of 5%";
    public void setFamilymembersOwnership(String familymembersOwnership) {
        selectRadionButton(FAMILYMEMBERS_OWNERSHIP, familymembersOwnership);
    }

    private static final String OWNERS_OWNERSHIP = "Does the enrolling provider or its owners have any ownership or control interest in any entity that is currently billing or has billed Medicare, any State Medicaid Agency, or another public health program in any state";
    public void setOwnersOwnership(String ownersOwnership) {
        selectRadionButton(OWNERS_OWNERSHIP, ownersOwnership);
    }

    private static final String PERSON_OWNERSHIP1 = "Have you ever had ownership in any entity that has billed or is currently billing Medicare, any State Medicaid Agency, or another public health program in any state";
    public void setPersonOwnership1(String personOwnership1) {
        selectRadionButton(PERSON_OWNERSHIP1, personOwnership1);
    }
    private static final String BILLED_ENTITY_OWNERSHIP = "Have you ever managed, directed, or controlled any entity that has billed or is currently billing Medicare, any State Medicaid Agency, or another public health program in any state";
    public void setBilledEntityOwnership(String billedEntityOwnership) {
        selectRadionButton(BILLED_ENTITY_OWNERSHIP, billedEntityOwnership);
    }
    private static final String OWNERS_LESS_THAN_FIVEPERCENT="Are there any owners with less than 5% (All owners not equal to 100%)?";
public void setAnyOwnersLessThanFivePercent(String lessThanFivePercent){
        waitABit(500);
        selectRadionButton(OWNERS_LESS_THAN_FIVEPERCENT,lessThanFivePercent);
        waitABit(500);
}

    private static final String SSN = ".//label[contains(text(), 'SSN')]/parent::div//input";

    public void setFillSsn(String fillSsn) {
        waitABit(200);
     findBy(SSN).sendKeys(fillSsn);
        waitABit(200);
    }
    public static final String ORGANIZATION_LEGAL_BUSINESS_NAME="//input[contains(@aria-label,'Organization Legal Business Name')]";
    public void setOrganizationLegalBusinessName(String organizationLegalBusinessName){
        waitABit(200);
        findBy(ORGANIZATION_LEGAL_BUSINESS_NAME).sendKeys(organizationLegalBusinessName);
        waitABit(200);
    }
    public static final String DBA="//input[contains(@aria-label,'Doing Business as')]";
    public void setDbaName(String dbaName){
        waitABit(200);
        findBy(DBA).sendKeys(dbaName);
        waitABit(200);
    }
    private static final String FIRST_NAME = "First Name";
    private static final String LAST_NAME = "Last Name";
    public void setFirstName(String firstName) {
        waitABit(1000);
        fillModifiedField(FIRST_NAME, firstName);
        fillModifiedField(FIRST_NAME, firstName);
//        waitABit(1000);
//        fillField(FIRST_NAME, firstName);
        waitABit(2000);
    }

    public void setLastName(String lastName) {
        waitABit(1000);
        fillModifiedField(LAST_NAME, lastName);
        fillModifiedField(LAST_NAME, lastName);
        waitABit(2000);
//        fillField(LAST_NAME, lastName);
//        waitABit(500);
    }

    private static final String EFFECTIVE_START_DATE = ".//label[contains(text(), 'Effective Start Date')]/parent::div//input";

    public void setEffectiveStartDate(String effectiveStartDate) {
        waitABit(500);
        findBy(EFFECTIVE_START_DATE).type(effectiveStartDate);
        waitABit(200);
    }
    private static final String EFFECTIVE_END_DATE = "//label[contains(text(), 'Effective End date')]/parent::div//input";


    public void setEffectiveEndDate(String effectiveEndDate) {
        waitABit(500);
        jsClick(EFFECTIVE_END_DATE);
        findBy(EFFECTIVE_END_DATE).sendKeys(effectiveEndDate);}
    private static final String ADDRESS_LINE1 = "Address line";
    private static final String SELECT_ADDRESS = ".//div[contains(@role,'menuitem')]";
    public void setAddressLine1(String addressLine1) {
        waitABit(500);
        fillModifiedField(ADDRESS_LINE1, addressLine1);
        waitABit(2000);
        findBy(SELECT_ADDRESS).click();
        waitABit(1000);
    }
    private static final String PROGRAM="//div[contains(@aria-labelledby,'Select Program')]";
    private static final String SELECT_PROGRAM="//div//ul//li[contains(text(),'%s')]";
    public void setSelectProgram(String selectProgram){
        waitABit(300);
        findBy(PROGRAM).click();
        waitABit(400);
        findBy(format(SELECT_PROGRAM,selectProgram)).click();
        waitABit(300);

    }
    private static final String NPI="//div[contains(@data-for,'NPI')]//div//input";
    private void setNPI(String npi){
        waitABit(200);
//        findBy(NPI).type(npi);
        getDriver().findElement(By.xpath(NPI)).sendKeys(npi);
        waitABit(200);
    }
    public static final String TYPE_OF_INTEREST="//div[contains(@id,'Types of Interest')]";
    public static final String SELECT_TYPE_OF_INTEREST="//div//ul//li[text()='%s']";
    public void setTypeOfInterest(String typeOfInterest){
    waitABit(2000);
    findBy(TYPE_OF_INTEREST).click();
    waitABit(200);
    findBy(String.format(SELECT_TYPE_OF_INTEREST,typeOfInterest)).click();
    waitABit(1000);
    }
    public static final String PERCENT_OF_INTEREST="//input[@aria-label='Percent of Interest']";
    public void setPercentOfInterest(String percentOfInterest){
        waitABit(200);
        findBy(PERCENT_OF_INTEREST).sendKeys(percentOfInterest);
        waitABit(200);
    }
    public static final String OWNERHSIP_TYPE="//div[contains(@id,'Ownership Type')]";
    public static final String SELECT_VALUE="//div//ul//li[text()='%s']";
    public void setOwnershipType(String ownershipType){
        waitABit(200);
        findBy(OWNERHSIP_TYPE).click();
        waitABit(500);
        findBy(String.format(SELECT_VALUE,ownershipType)).click();
        waitABit(600);
    }
    public static final String RELATIONSHIP_TO_PROVIDER="//div[contains(@id,'Relationship to Provider')]";
    public void setRelationshipToProvider(String relationshipToProvider){
        waitABit(200);
        findBy(RELATIONSHIP_TO_PROVIDER).click();
        waitABit(600);
        findBy(String.format(SELECT_VALUE,relationshipToProvider)).click();
        waitABit(300);
    }
    private static final String OWNERSHIP_PERCENT="//input[contains(@aria-label,'Ownership %')]";
    public void setOwnershipPercent(String ownershipPercent){
        waitABit(200);
        findBy(OWNERSHIP_PERCENT).sendKeys(ownershipPercent);
        waitABit(300);
    }
    private static final String DATE_OF_BIRTH = "//label[text()='Date of Birth *']//ancestor::div[contains(@class, 'datepicker')]//input";

    public void setDateOfBirth(String dateOfBirth) {
        waitABit(2000);
        jsClick(DATE_OF_BIRTH);
        findBy(DATE_OF_BIRTH).sendKeys(dateOfBirth);
        waitABit(2500);
    }

}
