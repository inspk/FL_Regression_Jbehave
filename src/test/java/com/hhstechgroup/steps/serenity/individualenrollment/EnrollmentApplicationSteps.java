package com.hhstechgroup.steps.serenity.individualenrollment;

import com.hhstechgroup.beans.application.*;
import com.hhstechgroup.ui.pages.enrollment.EnrollmentPage;
import com.hhstechgroup.ui.panels.claim.MemberInformationPanel;
import com.hhstechgroup.ui.panels.enrollment.*;
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
import com.hhstechgroup.util.common.BeanUtils;
import com.hhstechgroup.util.common.FileUtils;
import net.thucydides.core.annotations.Step;
import org.yecht.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class EnrollmentApplicationSteps {

    EnrollmentPage enrollmentPage;
    EnrollmentSearchPanel enrollmentSearchPanel;
    MemberInformationPanel memberInformationPanel;


    @Step
    public void setSectionInfo(String section, ApplicationSectionData info) {
        BaseEnrollmentPanel panel = enrollmentPage.getSection(section);
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, info);
    }

    @Step
    public ApplicationSectionData getSectionInfoInWriteMode(String section, ApplicationSectionData data) {
        BaseEnrollmentPanel panel = enrollmentPage.getSection(section);
        panel.waitForSectionPulledUp();
        BeanUtils.copyProperties(data, panel);
        return data;
    }
    @Step
    public  void setTPIdentifyInfo(IdentifyingInformationBean identifyinfo) {
        IdentifyingInformationPanel panel = enrollmentPage.getTPIdentifyInfo();
        BeanUtils.copyPropertiesInOrder(panel, identifyinfo);
    }

    @Step
    public void setTableInfo(String tableName, String section, ApplicationSectionData info) {
        BaseEnrollmentPanel panel = enrollmentPage.getSection(section);
        BaseTable table = getTable(panel, tableName);
        table.clickAddRow();
        BeanUtils.copyPropertiesInOrder(table, info);
        table.clickSave();
    }

    @Step
    public List<String> getTableHeaders(String tableName, String section) {
        BaseEnrollmentPanel panel = enrollmentPage.getSection(section);
        BaseTable table = getTable(panel, tableName);
        return table.getHeaders();
    }

    @Step
    public void clickOnTableHeader(String tableName, String section, String header) {
        BaseEnrollmentPanel panel = enrollmentPage.getSection(section);
        BaseTable table = getTable(panel, tableName);
        table.clickOnHeader(header);
    }

    @Step
    public void clickAddTableRow(String tableName, String section) {
        BaseEnrollmentPanel panel = enrollmentPage.getSection(section);
        BaseTable table = getTable(panel, tableName);
        table.clickAddRow();
    }

    @Step
    public void clickSaveTableRow(String tableName, String section) {
        BaseEnrollmentPanel panel = enrollmentPage.getSection(section);
        BaseTable table = getTable(panel, tableName);
        table.clickSave();
    }

    @Step
    public void showTableColumn(String tableName, String columnName, String section) {
        BaseEnrollmentPanel panel = enrollmentPage.getSection(section);
        BaseTable table = getTable(panel, tableName);
        table.showTableColumn(columnName);
    }

    @Step
    public void setTableField(String tableName, String section, String fieldName, String value) {
        BaseEnrollmentPanel panel = enrollmentPage.getSection(section);
        BaseTable table = getTable(panel, tableName);
        table.setField(fieldName, value);
    }

    @Step
    public void selectFromDropDownTable(String tableName, String section, String fieldName, String value) {
        BaseEnrollmentPanel panel = enrollmentPage.getSection(section);
        BaseTable table = getTable(panel, tableName);
        table.select(fieldName, value);
    }

    @Step
    public List<Map<String, String>> getTableData(String tableName, String section) {
        BaseEnrollmentPanel panel = enrollmentPage.getSection(section);
        BaseTable table = getTable(panel, tableName);
        return table.getTableData();
    }

    private BaseTable getTable(BaseEnrollmentPanel panel, String tableName) {
        Class<? extends BaseTable> tableClass = ApplicationSectionHelper.getTablePanelClass(tableName);
        for (Method m : panel.getClass().getMethods()) {
            if (m.getReturnType().equals(tableClass)) {
                try {
                    return (BaseTable) m.invoke(panel);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return new BaseTable(enrollmentPage);
    }

    @Step
    public void clickNext(String section) {
        enrollmentPage.clickNextButton();
    }

    @Step
    public void editField(String section, String field) {
        BaseEnrollmentPanel panel = enrollmentPage.getSection(section);
        panel.waitForSectionPulledUp();
        panel.editField(field);
    }
    //latest
    @Step
    public void editgroupField(String section, String field) {
        BaseEnrollmentPanel panel = enrollmentPage.getgroupSection(section);
        panel.waitForSectionPulledUp();
        panel.editField(field);
    }

    @Step
    public void editInfoOnIUPortal(String section, ApplicationSectionData info) {
        BaseEnrollmentPanel panel = enrollmentPage.getSection(section);
        BeanUtils.copyPropertiesInOrder(panel, info);
    }

    @Step
    public Map<String, String> getFieldsValuesReadMode(String section, List<String> fields) {
        return enrollmentPage.getSection(section).getFieldsValuesReadMode(fields);
    }

    @Step
    public boolean areFieldsReadOnly(String section, List<String> fields) {
        return enrollmentPage.getSection(section).areFieldsReadOnly(fields);
    }

    @Step
    public boolean isPageWithTitleOpened(String title) {
        return enrollmentPage.isPageTitleDisplayed(title);
    }


    @Step
    public void moveToSection(String section) {
        enrollmentPage.getLeftMenuPanel().clickOnSection(section);
    }

    //sp29
    @Step
    public void moveToSection1(String section) {
        enrollmentPage.getLeftMenuPanel().clickOnSection1(section);
    }

    @Step
    public boolean isSectionDisabled(String title) {
        return enrollmentPage.getLeftMenuPanel().isSectionDisabled(title);
    }

    @Step
    public boolean isSectionActive(String title) {
        return enrollmentPage.getLeftMenuPanel().isSectionActive(title);
    }

    @Step
    public boolean areFieldsHighlighted(String section, List<String> fields) {
        return enrollmentPage.getSection(section).areFieldsHighlighted(fields);
    }

    @Step
    public boolean areReadOnlyValuesHighlighted(String section, List<String> fields) {
        return enrollmentPage.getSection(section).areReadOnlyValuesHighlighted(fields);
    }

    @Step
    public boolean isSectionPresent(String sectionName) {
        return enrollmentPage.getLeftMenuPanel().isSectionPresent(sectionName);
    }

    @Step
    public boolean isSectionDisplayedInSummary(String section) {
        return enrollmentPage.getSummaryPanel().isSectionDisplayed(section);
    }

    @Step
    public String getFieldNewValue(String field) {
        return enrollmentPage.getSummaryPanel().getFieldNewValue(field);
    }

    @Step
    public String getFieldOldValue(String field) {
        return enrollmentPage.getSummaryPanel().getFieldOldValue(field);
    }

    @Step
    public String getPrepopulatedData(String field) {
        return enrollmentPage.getSummaryPanel().getPrepopulatedData(field);
    }

    @Step
    public boolean isSummaryContainAnySection() {
        return enrollmentPage.getSummaryPanel().isSectionPresent();
    }

    @Step
    public List<List<String>> getOptionsInDisplayedOrder(String sctionName, String fieldName, int optionsColumnsCount) {
        return enrollmentPage.getSection(sctionName).getOptionsInDisplayedOrder(fieldName, optionsColumnsCount);
    }

    @Step
    public void fillField(String sctionName, String fieldName, String value) {
        enrollmentPage.getSection(sctionName).fillField(fieldName, value);
    }

    @Step
    public String getFieldValue(String sctionName, String fieldName) {
        return enrollmentPage.getSection(sctionName).getFieldValue(fieldName);
    }

    @Step
    public void clearField(String sctionName, String fieldName) {
        enrollmentPage.getSection(sctionName).clearField(fieldName);
    }

    @Step
    public void saveChanges(String sctionName) {
        enrollmentPage.getSection(sctionName).clickOnTitle();
    }

    @Step
    public void selectRadionButton(String sctionName, String fieldName, String value) {
        enrollmentPage.getSection(sctionName).selectRadionButton(fieldName, value);
    }

    @Step
    public String getRadioButtonValue(String sctionName, String fieldName) {
        return enrollmentPage.getSection(sctionName).getRadioButtonValue(fieldName);
    }
    @Step
    public void setValueToNpiSearchField(String value) {
        enrollmentPage.getAffiliationPanel().setAffiliationField(value);
    }
    @Step
    public void clickAffiliationSearchByNpi() {
        enrollmentPage.getAffiliationPanel().clickSearchAffiliationButton();

    }
    @Step
    public void clickAddAffiliationButton() {
        enrollmentPage.getAffiliationPanel().clickAddAffiliationButton();
    }

    @Step
    public void clickAddAffiliationButtonInPopup () {
        enrollmentPage.getAffiliationPopUpPanel().clickAddAffiliationButtonInPopup();
    }

    @Step
    public void waitForEnrollmentSectionAppeared() {
        enrollmentPage.getBaseSection().waitForSectionTitleAppeared();
        enrollmentPage.getBaseSection().waitForSectionPulledUp();
    }

    @Step
    public List<Map<String, String>> checkAffiliationData() {
      return  enrollmentPage.getAffiliationPanel().getListOfMappedValues();
    }

    @Step
    public void setEnrollSearchCriteria(EnrollmentIUBean criteria) {
        EnrollmentSearchPanel panel = enrollmentPage.getEnrollSearchPanel();
        BeanUtils.copyPropertiesInOrder(panel, criteria);
    }
    @Step
    public void verifyDataInClearingHouse(){
        enrollmentPage.verifyDataInClearingHouse();
    }
    @Step
    public void verifyIndicatorsData(){
        enrollmentPage.verifyIndicatorsData();
    }
    @Step
    public void verifyProviderContractsData(){
        enrollmentPage.verifyProviderContractsData();
    }
    @Step
    public void verifyDataUnderHistory(){
        enrollmentPage.verifyDataUnderHistory();
    }

    @Step
    public void verifyFiles(){
        enrollmentPage.verifyFiles();
    }

    @Step
    public void clickSearch() {
        enrollmentPage.getEnrollSearchPanel().clickSearch();
    }

    //newly adding
    @Step
    public Map<String, String> getMappedEnrollmentValuesForRecord() {
        return enrollmentPage.getproviderEnrollmentPanel().getMappedEnrollmentValuesForRecord();
    }

    @Step
    public Map<String, String> getMappedEnrollmentValuesForRecord1() {
        return enrollmentPage.getproviderEnrollmentPanel().getMappedEnrollmentValuesForRecord1();
    }

    @Step
    public void changeGender(String gender){
    memberInformationPanel.setGender(gender);
}

    //max data
    @Step
    public  void setIndividualIdentifyInfo(IdentifyingInformationBean identifyinfo) {
        IdentifyingInformationPanel panel = enrollmentPage.getIndividualIdentifyInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, identifyinfo);
    }
    @Step
    public void fillinggender(){
        enrollmentPage.fillgender();
    }
    @Step
    public void setApplicationTypeDetermination(String text){
        enrollmentPage.setApplicationTypeDetermination(text);
    }

    @Step
    public void add_servicelocation_providertype(){
        enrollmentPage.setAddServicelocationProvidertype();
    }

    @Step
    public  void setGroupIdentifyInfo(IdentifyingInformationBean identifyinfo) {
        IdentifyingInformationPanel panel = enrollmentPage.getGroupIdentifyInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, identifyinfo);
    }

    @Step
    public  void setLicensureSectionInfo(LicensureCertificationBean newLicensuresection) {
        LicensureCertificationPanel panel = enrollmentPage.getLicensureSectionInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, newLicensuresection);
    }

    @Step
    public  void setProviderIdentifyInfo(ProviderIdentifierNumberBean providernpi) {
        ProviderIdentifierNumberPanel panel = enrollmentPage.getProviderIdentifyInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, providernpi);
    }

    @Step
    public  void setEFTInfo(EFTInformationBean efiInfo) {
        EFTInformationPanel panel = enrollmentPage.getEFTInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, efiInfo);
    }

    @Step
    public  void setAddressDetails(AddressBean newAddressDetails) {
        AddressPanel panel = enrollmentPage.getAddressDetails();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, newAddressDetails);
    }

    @Step
    public  void setServiceLocationInfo(ServiceLocationBillingBean serviceLocationInfo) {
        ServiceLocationBillingPanel panel = enrollmentPage.getServiceLocationBillingInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, serviceLocationInfo);
    }

    @Step
    public  void setElectricFundsPaymentInfo(ElectronicFundsPaymentBean electricFundsPaymentInfo) {
        ElectronicFundsPaymentPanel panel = enrollmentPage.getElectricFundsPaymentInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, electricFundsPaymentInfo);
    }

    @Step
    public void setTPAddressInfo(AddressBean newAddressBeans) {
        TPAddressInfoPanel panel = enrollmentPage.getTPAddressinfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, newAddressBeans);
    }

    @Step
    public void setTPAddressDetails(AddressBean newAddressBeans) {
        TPAddressDetailsPanel panel = enrollmentPage.getTPAddressDetails();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, newAddressBeans);
    }
   //latest
    @Step
    public  void setRequestRetroactiveAdjustmentDetails(RequestRetroactiveAdjustmentBean requestRetroactiveAdjustmentDetails) {
        RequestRetroactiveAdjustmentPanel panel = enrollmentPage.getRequestRetroactiveAdjustmentDetails();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, requestRetroactiveAdjustmentDetails);
    }
    public  void setTraingingRequiredDetails(TrainingRequiredBean traingingRequiredDetails) {
        TrainingRequiredPanel panel = enrollmentPage.getTraingingRequiredDetails();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, traingingRequiredDetails);
    }
//sp19
    public  void setProfileSetupDetails(ProfileSetupBean profileSetupDetails) {
        ProfileSetupPanel panel = enrollmentPage.getProfileSetupDetails();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, profileSetupDetails);
    }
    //new sp20
    @Step
    public  void setConcactPersonDetails(LocationContactPersonBean concactPersonDetails) {
        ConcactPersonDetailsPanel panel = enrollmentPage.getConcactPersonDetails();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, concactPersonDetails);
    }

    //sp21
    @Step
    public  void setVerifyFingerPrint(FingerPrintBean fingerPrint) {
        FingerPrintPanel panel = enrollmentPage.getFingerPrint();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, fingerPrint);
    }

    //sp22
    @Step
    public void clickOnStatusButton(String status) {
        enrollmentPage.clickOnStatusButton(status);
    }

    @Step
    public boolean verifyingStatusWorkFlow(String statusworkflow) {
        return enrollmentPage.verifyingStatusWorkFlow(statusworkflow);}

     //sp23
    @Step
    public Map<String, String> getMappedEnrollmentValuesForAssignee() {
        return enrollmentPage.getproviderEnrollmentPanel().getMappedEnrollmentValuesForAssinee();
    }
    //sp26
    @Step
    public  void setAuthorizedSignatureinfo(AuthorizedSignatureBean authorizedSignatureinfo) {
        AuthorizedSignaturePanel panel = enrollmentPage.getAuthorizedSignatureinfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, authorizedSignatureinfo);
    }
   //new PEM
    @Step
    public  void setPEMIdentifyInfo(IdentifyingInformationBean identifyinfo) {
        IdentifyingInformationPanel panel = enrollmentPage.getPEMIdentifyInfo();
        BeanUtils.copyPropertiesInOrder(panel, identifyinfo);
    }

    @Step
    public void setPEMAddressInfo(AddressBean newAddressBeans) {
        TPAddressInfoPanel panel = enrollmentPage.getPEMAddressinfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, newAddressBeans);
    }

    @Step
    public void setPEMAddressDetailsInfo(AddressBean newAddressBeans) {
        TPAddressDetailsPanel panel = enrollmentPage.getPEMAddressDetailsinfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, newAddressBeans);
    }

    @Step
    public  void setconcactEmailInfo(IdentifyingInformationBean identifyinfo) {
        IdentifyingInformationPanel panel = enrollmentPage.getPEMIdentifyInfo();
        BeanUtils.copyPropertiesInOrder(panel, identifyinfo);
    }

    @Step
    public void setPEMSoftwareVendorInfo(SoftwareVendorDetailsBean vendorDetails) {
        SoftwareVendorDetailsPanel panel = enrollmentPage.getPEMSoftwareVendorInfo();
        BeanUtils.copyPropertiesInOrder(panel, vendorDetails);
    }

    //sp26
    @Step
    public void clickAddRow(){
        enrollmentPage.clickAddRow();
    }
    @Step
    public void clickMessageBox(){
        enrollmentPage.clickMessageBox();
    }
    @Step
    public  void setLicenseInfo(LicenseInformationBean licenseInformationBean) {
        LicenseInformationPanel panel = enrollmentPage.getLicenseInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, licenseInformationBean);
    }
    @Step
    public void clickSave() {
    enrollmentPage.clickSave();
    }

    @Step
    public void clickSaveinKeyPersonel() {
        enrollmentPage.clickSave();
//        enrollmentPage.clickNextButton();
    }

    @Step
    public void clickSaveinAddressDetails() {
        enrollmentPage.clickNextButton();
    }

    @Step
    public  void setOtherMedicaidStateInfo(OtherMedicaidStateBean otherMedicaidStateInfo) {
        OtherMedicaidStatePanel panel = enrollmentPage.getOtherMedicaidStateInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, otherMedicaidStateInfo);
    }
    //sp28
    @Step
    public boolean verifyAddSecondaryservicelocationbutton() {
        return enrollmentPage.verifyAddSecondaryservicelocationbutton();
    }
    @Step
    public void clickAddSecondaryServiceLocation(){
        enrollmentPage.clickAddSecondaryServiceLocation();
    }
    @Step
    public void clickDeleteSecondaryServiceLocation(){
        enrollmentPage.clickDeleteSecondaryServiceLocation();
    }
    @Step
    public boolean verifyDeleteIconisDisplaying() {
      return enrollmentPage.verifyDeleteIconisDisplaying();
    }
    @Step
    public boolean isLoopPopupOpened() {
        return enrollmentPage.isLoopPopupOpened();
    }
    @Step
    public void clickOkButton(){
        enrollmentPage.clickOkButton();
    }

    //sp28
    @Step
    public void clickAddRow1(){
        enrollmentPage.clickAddRow1();
    }

    @Step
    public void clickSave1() {
        enrollmentPage.clickSave1();
    }

    @Step
    public boolean verifyingStatusRequiredAdditionalInfo(String status) {
        return enrollmentPage.verifyingStatusRequiredAdditionalInfo(status);}
    //sp29
    @Step
    public  void setOwerKeyPersonelInfo(OwerKeyPersonelBean owerKeyPersonelBean) {
        OwerKeyPersonalPanel panel=enrollmentPage.getOwerKeyPersonelInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel,owerKeyPersonelBean);
    }
    //sp33
    @Step
    public  void setAffiliationInfo(AffilitionInformationBean affilitionInformationBean) {
        AffiliationInformationPanel panel = enrollmentPage.getAffiliationInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, affilitionInformationBean);
    }

    @Step
    public Map<String, String> getAffilaitionProviderInfo() {
        return enrollmentPage.getAffilaitionProviderInfo().getMappedProviderValuesForAffilaition();
    }
    @Step
    public  void clickonclosebutton() {
        enrollmentPage.clickonclosebutton();
    }
    //sp35
    @Step
    public  void setPharmacyLicenseInfo(PharmacyLicenseInformationBean pharmacyLicenseInformationBean) {
        PharmacyLicenseInformationPanel panel = enrollmentPage.getPharmacyLicenseInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, pharmacyLicenseInformationBean);
    }
    @Step
    public  void setExclusionSanctionInfo(ExclusionSanctionBean provider) {
        ExclusionSanctionPanel panel = enrollmentPage.getExclusionSanctionInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, provider);
    }
    //sp37
    @Step
    public  void setChangeEnrollmentTypeinfo(ChangeEnrollmentTypeBean changeEnrollmentTypeBean) {
        ChangeEnrollmentTypePanel panel = enrollmentPage.getChangeEnrollmentTypeinfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, changeEnrollmentTypeBean);
    }
    @Step
    public boolean isChangeEnrollTypeNotificationdisplaying(String notification) {
        return enrollmentPage.isChangeEnrollTypeNotificationdisplaying(notification);
    }
    @Step
    public void setreasonforchangeenollmenttype(String reason,String note) {
        enrollmentPage.setreasonforchangeenollmenttype(reason, note);
    }
    @Step
    public void clickApply(){
        enrollmentPage.clickApply();
    }

    //sp41.4
    @Step
    public Map<String, String> getMappedZipValues() {
        return enrollmentPage.getAddressDetails().getMappedZipValues();
    }

    //sp42.3
    @Step
    public void moveToSection2(String section) {
        enrollmentPage.getLeftMenuPanel().clickOnSection2(section);
    }

    //Demo
    @Step
    public void clickAddRow2(){
        enrollmentPage.clickAddRow2();
    }
    @Step
    public void clickOnAddLine(){
        enrollmentPage.clickOnAddLine();
    }

    @Step
    public void allStatesServed() {
        enrollmentPage.allStatesServed();
    }
    @Step
    public void clickAddRow3(){
        enrollmentPage.clickAddRow3();
    }

    // Demo - Pharmacy - Address
    @Step
    public void pharmacyMedicareCertified() {
        enrollmentPage.pharmacyMedicareCertified();
    }
    @Step
    public void pharmacyPayments() {
        enrollmentPage.pharmacyPayments();
    }
    @Step
    public void pharmacyParticipates340B() {
        enrollmentPage.pharmacyParticipates340B();
    }

    @Step
    public void clientNeedingServices() {
        enrollmentPage.clientNeedingServicesPharmacy();
    }

    @Step
    public void medicationsNotReadilySupplied() {
        enrollmentPage.medicationsNotReadilySupplied();
    }
    @Step
    public void wyomingBoardPharmacy() {
        enrollmentPage.wyomingBoardPharmacy();
    }

    @Step
    public void compoundPrescriptionsPharmacy() {
        enrollmentPage.compoundPrescriptionsPharmacy();
    }

    //WY-65
    @Step
    public void editField1(String section, String field) {
        BaseEnrollmentPanel panel = enrollmentPage.getSection(section);
        panel.waitForSectionPulledUp();
        panel.editField1(field);
    }

    //SD-05
    @Step
    public void clickProceedSignCheckbox() {
        enrollmentPage.clickProceedSignCheckbox();
    }

    // only for existing account to continue enrollement

    @Step
    public void clickcontinue() {
        enrollmentPage.clickcontinue();
    }


    //SD-08

    @Step
    public void setTypeAffiliationDropdownValue(String value) {
        enrollmentPage.getAffiliationPanel().setTypeAffiliationDropdownValue(value);
    }

    @Step
    public void addAffiliation(){
        enrollmentPage.getAffiliationPanel().addAffiliation();
    }
    @Step
    public void addAffiliationgroup(){
        enrollmentPage.getAffiliationPanel().addAffiliationgroup();
    }

    @Step
    public void setProviderIDValueSearchField(String providerId){
        enrollmentPage.getAffiliationPanel().setProviderIDValueSearchField(providerId);
    }

    @Step
    public boolean verifyServiceLocationDisplay(){
        return enrollmentPage.verifyServiceLocationDisplay();
    }

    @Step
    public  void setOwnershipInfo(OwnershipBean ownershipBean) {
        OwnershipPanel panel = enrollmentPage.getOwnershipInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, ownershipBean);
    }
@Step
public void setProffesionalLiabilityInsuranceInfo(ProffesionalLiabilityInsuranceInfoBean proffesionalLiabilityInsuranceInfo){
    ProffesionalLiabilityInsuranceInfoPanel panel=enrollmentPage.getProffesionalLiabilityInsuranceInfo();
    panel.waitForSectionPulledUp();
    BeanUtils.copyPropertiesInOrder(panel, proffesionalLiabilityInsuranceInfo);

}
@Step
public void setTaxIdentifier(String ssnCheckBox){
        enrollmentPage.setTaxIdentifier(ssnCheckBox);
}
@Step
public void setSubContractorTaxIdentifier(String subContractorSsn){
        enrollmentPage.setSubContractorTaxIdentifier(subContractorSsn);
}
    @Step
    public void clickAddLineKeyPersonnel(String section){
        enrollmentPage.clickAddLineKeyPersonnel(section);
    }


    @Step
    public void clickAddLocation() {
        enrollmentPage.getServiceLocationInfo().clickAddLocation();
    }

    @Step
    public void clickAddTaxonomyOrSpeciality(){
        enrollmentPage.getServiceLocationInfo().clickAddTaxonomyOrSpeciality();
    }
    @Step
    public void clickOnAddRegion(String addregion){
        enrollmentPage.getServiceLocationInfo().clickOnAddRegion(addregion);
    }

    @Step
    public void clickAddTaxonomyButton(){
        enrollmentPage.getProgramParticipationSectionInfo().clickAddTaxonomyButton();
    }


    @Step
    public void clickButtonInProgramParticipation(String button){
        enrollmentPage.getProgramParticipationInfo().clickButton(button);
    }

    @Step
    public void clickButtonInProgramParticipationSection(String button){
        enrollmentPage.getProgramParticipationSectionInfo().clickButton(button);
    }

    @Step
    public void clickServiceLocationButton(String button){
        enrollmentPage.getServiceLocationInfo().clickButton(button);
    }

    @Step
    public void uploadDocument1(String type, String filePath) {
        enrollmentPage.getServiceLocationInfo().uploadDocument(type, FileUtils.getAbsolutePath(filePath));
    }

    @Step
    public void uploadClaimDocument(String type, String filePath) {
        enrollmentPage.getServiceLocationInfo().uploadClaimDocument(type, FileUtils.getAbsolutePath(filePath));
    }

    @Step
    public void uploadDocument2(String type, String filePath) {
        enrollmentPage.getProgramParticipationInfo().uploadDocument(type, FileUtils.getAbsolutePath(filePath));
    }

    @Step
    public void uploadDocument3(String type, String filePath) {
        enrollmentPage.getProgramParticipationSectionInfo().uploadDocument(type, FileUtils.getAbsolutePath(filePath));
    }

    @Step
    public void uploadDoc(String docType,String path){
        enrollmentPage.getOtherCredentialingInformation().uploadDoc(docType,FileUtils.getAbsolutePath(path));
    }

    @Step
    public void saveProgramParticipation() {
        enrollmentPage.getProgramParticipationInfo().saveProgramParticipation();
    }

    @Step
    public void saveProgramParticipationSection() {
        enrollmentPage.getProgramParticipationSectionInfo().saveProgramParticipation();
    }

    @Step
    public void selectTaxonomy() {
        enrollmentPage.getProgramParticipationInfo().selectTaxonomy();
    }
    @Step
    public void selectTaxonomyInServiceLocation(String taxonomy){
        enrollmentPage.getProgramParticipationInfo().selectTaxonomyInServiceLocation(taxonomy);
    }

    @Step
    public void saveTaxonomy() {
        enrollmentPage.getProgramParticipationInfo().saveTaxonomy();
    }

    @Step
    public void setServiceLocationInfo(ServiceLocationBean serviceLocationInfo) {
        ServiceLocationPanel panel = enrollmentPage.getServiceLocationInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, serviceLocationInfo);
    }

    @Step
    public void setProgramParticipationInfo(ProgramParticipationBean programParticipationInfo) {
        ProgramParticipationPanel panel = enrollmentPage.getProgramParticipationInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, programParticipationInfo);
    }

    @Step
    public void setProgramParticipationSectionInfo(ProgramParticipationSectionBean programParticipationSectionInfo) {
        ProgramParticipationSectionPanel panel = enrollmentPage.getProgramParticipationSectionInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, programParticipationSectionInfo);
    }


    @Step
    public  void setTPProviderIdentifyInfo(ProviderIdentifierNumberBean providernpi) {
        ProviderIdentifierNumberPanel panel = enrollmentPage.getProviderIdentifyInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, providernpi);
    }

    @Step
    public  void setClassificationInfo(ClassificationBean provider) {
        ClassificationPanel panel = enrollmentPage.setClassificationInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, provider);
    }

    @Step
    public void selectAffiliationByRowText(String text){
        enrollmentPage.getAffiliationPanel().selectAffiliationByRowText(text);
    }

    @Step
    public void selectAllAffiliations(){
        enrollmentPage.getAffiliationPanel().selectAllAffiliations();
    }

    @Step
    public void clickAddBulkAffiliationButton(){
        enrollmentPage.getAffiliationPanel().clickAddBulkAffiliationButton();
    }

    @Step
    public void clickSave2() {
        enrollmentPage.clickSave2();
    }


    public void clickOptionToQuestion(String option, String question){
        enrollmentPage.getAffiliationPanel().clickOptionToQuestion(option, question);
    }

    @Step
    public void setSsnAffiliationDropdownValue(String value) {
        enrollmentPage.getAffiliationPanel().setSsnAffiliationDropdownValue(value);
    }

    @Step
    public void setDobAffiliationDropdownValue(String value) {
        enrollmentPage.getAffiliationPanel().setDobAffiliationDropdownValue(value);
    }


    //SD16 Alternative address code

    @Step
    public  void setAlternateAddressDetails(AddressBean newAddressDetails) {
        AddressPanel panel = enrollmentPage.getAlternateAddressDetails();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, newAddressDetails);
    }

    //.

    @Step
    public String getEnrollmentDate(){
        return enrollmentPage.getIndividualIdentifyInfo().getEnrollmentDate();
    }

    @Step
    public String getReasonCode(){
        return enrollmentPage.getIndividualIdentifyInfo().getReasonCode();
    }

    @Step
    public boolean isEnrollmentDateMandatory(){
        return enrollmentPage.getIndividualIdentifyInfo().isEnrollmentDateMandatory();
    }

    @Step
    public boolean isReasonCodeMandatory(){
        return enrollmentPage.getIndividualIdentifyInfo().isReasonCodeMandatory();
    }

    @Step
    public void setAffiliatePrimaryLocation(String question, String option){
        enrollmentPage.getAffiliationPopUpPanel().setAffiliatePrimaryLocation(question, option);
    }

    @Step
    public void setConfirmAffiliationWithIndi(String question, String  option){
        enrollmentPage.getAffiliationPopUpPanel().setConfirmAffiliationWithIndi(question, option);
    }
    @Step
    public void setLocationEffectiveDates(String dateStart,String dateEnd) {
        enrollmentPage.getAffiliationPopUpPanel().setLocationEffectiveDates(dateStart,dateEnd);
    }

    @Step
    public void setLocationEffectiveDate(String dateStart,String dateEnd){
        enrollmentPage.getAffiliationPopUpPanel().setLocationEffectiveDate(dateStart,dateEnd);
    }

    @Step
    public int verifyRAICount() {
        return enrollmentPage.verifyRAICount();
    }
    @Step
    public void editOwnerhsipPercentage(String ownershipPercent){
        enrollmentPage.editOwnerhsipPercentage(ownershipPercent);
    }

    @Step
    public void selectProgramParticipation(String programparticipation, String startdate, String enddate){
        enrollmentPage.getAffiliationPopUpPanel().selectProgramParticipation(programparticipation, startdate, enddate);
    }

    @Step
    public void setHomeLocation(String homeLocation){
        enrollmentPage.getAffiliationPopUpPanel().setHomeLocation(homeLocation);
    }

    @Step
    public void addServiceLocation(String text){
        enrollmentPage.getAffiliationPopUpPanel().addServiceLocation(text);
    }

    @Step
    public void setAffiliationPopupCriteria(AffiliationPoupBean criteria) {
        AffiliationPopUpPanel panel = enrollmentPage.getAffiliationPopUpPanel();
        BeanUtils.copyPropertiesInOrder(panel, criteria);
    }

    @Step
    public void searchSecondaryServiceLocation(){
        enrollmentPage.getAffiliationPopUpPanel().searchSecondaryServiceLocation();
    }

    @Step
    public boolean isDuplicateNpiMessagePresents(String npi){
        return enrollmentPage.getProviderIdentifyInfo().isDuplicateNpiMessagePresents(npi);
    }

    @Step
    public String getPopupMessage() {
        return enrollmentPage.getAffiliationPopUpPanel().getPopupMessage();
    }

    @Step
    public void searchServiceLocationByCriteria(ServiceLocationBean serviceLocationInfo) {
        enrollmentPage.getServiceLocationInfo().expandSearchCriteria();
        ServiceLocationPanel panel = enrollmentPage.getServiceLocationInfo();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, serviceLocationInfo);
        enrollmentPage.getServiceLocationInfo().clickSearch();
    }

    public void setHealthHomeServicesInfo(HealthHomeServicesBean healthHomeServicesBean) {
        HealthHomeServicesPanel panel = enrollmentPage.getHealthHomeServicesPanel();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, healthHomeServicesBean);
    }

    @Step
    public boolean isDataPresents(String data) {
        return enrollmentPage.getServiceLocationInfo().isDataPresents(data);
    }

    @Step
    public void editTaxonomy(String taxonomy) {
        enrollmentPage.getProgramParticipationSectionInfo().editTaxonomy(taxonomy);
    }
    @Step
    public  String verifyEffectiveEndDate(String expDate,String taxonomyValue){
        enrollmentPage.verifyEffectiveEndDate(expDate,taxonomyValue);
        return expDate;
    }

    @Step
    public void removeTaxonomy(String taxonomy) {
        enrollmentPage.getProgramParticipationSectionInfo().removeTaxonomy(taxonomy);
    }

    @Step
    public void editServiceLocation(String location) {
        enrollmentPage.getServiceLocationInfo().editServiceLocation(location);
    }

    @Step
    public void removeServiceLocation(String location) {
        enrollmentPage.getServiceLocationInfo().removeServiceLocation(location);
    }

    @Step
    public void endAffiliation(String affiliationType){
        enrollmentPage.getAffiliationPanel().endAffiliation(affiliationType);


    }

    @Step
    public void saveDesignatedProviders(){
        enrollmentPage.getServiceLocationInfo().saveDesignatedproviders();
    }

    @Step
    public void editCocServiceLocation(String location) {
        enrollmentPage.getServiceLocationInfo().editCocServiceLocation(location);
    }

    @Step
    public void removeCocSecondaryServiceLocation(String location, String reason, String note) {
        enrollmentPage.getServiceLocationInfo().removeCocSecondaryServiceLocation(location, reason, note);
    }

    @Step
    public void removeCocPrimaryServiceLocation(String location, String reason, String note) {
        enrollmentPage.getServiceLocationInfo().removeCocPrimaryServiceLocation(location, reason, note);
    }

    @Step
    public void editCocProgramParticipation(String taxonomy) {
        enrollmentPage.getProgramParticipationSectionInfo().editCocProgramParticipation(taxonomy);
    }

    @Step
    public void removeCocProgramParticipation(String taxonomy) {
        enrollmentPage.getProgramParticipationSectionInfo().removeCocProgramParticipation(taxonomy);
    }

    @Step
    public void clickPopupOption(String description, String value){
        enrollmentPage.getServiceLocationInfo().clickPopupOption(description, value);
    }

    @Step
    public void selectPrimaryLocationName(String primaryLocationName){
        enrollmentPage.getServiceLocationInfo().selectPrimaryLocationName(primaryLocationName);
    }

    @Step
    public void setMannerOfService(String mannerOfService){
        enrollmentPage.getAffiliationPopUpPanel().setMannerOfService(mannerOfService);
    }
    @Step
    public void setAcceptingNewPatients(String acceptingNewPatients){
        enrollmentPage.getAffiliationPopUpPanel().setAcceptingNewPatients(acceptingNewPatients);
    }
    @Step
    public void setPracticeType(String textForPT){
        enrollmentPage.setPracticeType(textForPT);
    }
    @Step
    public void setAuthorizedPerson(String authorizedPerson){
        enrollmentPage.setAuthorizedPerson(authorizedPerson);
    }
    @Step
    public void editDetailsOfEFTInfo(){
        enrollmentPage.editDetailsOfEFTInfo();
    }

    @Step
    public List<String> getSectionsNames(){
            return enrollmentPage.getSectionsNames();
        }

        @Step
        public List<String> getTabNames(){
        return enrollmentPage.getTabNames();
        }

    @Step
    public List<String> verifyServiceLocationsCount() {
        return enrollmentPage.verifyServiceLocationsCount();
    }
    @Step
    public List<String> verifyAffiliationCount() {
        return enrollmentPage.verifyAffiliationCount();
    }
    @Step
    public void clickOnEditButton(String editButton){
        enrollmentPage.clickOnEditButton(editButton);
    }

    @Step
    public void ClickOnLicenseEditButton(String button){
        enrollmentPage.ClickOnLicenseEditButton(button);
    }
    @Step
    public void clickOnButtonInPopUp(String buttonName){
        enrollmentPage.clickOnButtonInPopUp(buttonName);
    }
    @Step
    public void clickOnSaveButton(){
        enrollmentPage.clickOnSaveButton();
    }
    @Step
    public boolean isServiceLocationDisplayed(String location) {
        return enrollmentPage.isServiceLocationDisplayed(location);
    }
    @Step
    public boolean verifyAffiliationEffectiveEndDate(String tmrwDate,String enrollmentType) {
        return enrollmentPage.verifyAffiliationEffectiveEndDate(tmrwDate,enrollmentType);
    }
    @Step
    public boolean verifyUpdatedEffectiveEndDate(String providerLegalBusinessName,String expDate){
        return enrollmentPage.verifyUpdatedEffectiveEndDate(providerLegalBusinessName,expDate);
    }

    @Step
    public boolean isLicenseNumberDisplayed(String licenseNo) {
        return enrollmentPage.isLicenseNumberDisplayed(licenseNo);
    }
    @Step
    public boolean verifyAddedTaxonomy(String taxonomy){
        return  enrollmentPage.verifyAddedTaxonomy(taxonomy);
    }
    @Step
    public boolean verifyAddedLocation(String locationType){
        return enrollmentPage.verifyAddedLocation(locationType);
    }
    @Step
    public void editTheDetailsOfAffiliation(String enrollmentType){
        enrollmentPage.editTheDetailsOfAffiliation(enrollmentType);
    }

    @Step
    public String getOwnershipPopupMessage() {
        return enrollmentPage.getOwnershipPopupMessage();
    }
    @Step
    public void editPercentOfInterestPercentage(String percentage){
        enrollmentPage.editPercentOfInterestPercentage(percentage);
    }

    @Step
    public void verifyAndSelectName(String value){
        enrollmentPage.verifyAndSelectName(value);
    }
    @Step
    public void verifyAndSelectOwnershipDetails(String value1,String value2,String value3,String value4){
        enrollmentPage.verifyAndSelectOwnershipDetails(value1, value2, value3, value4);
    }
    @Step
    public void verifyAndSelectOwnershipDetailsInES(String ownershipvalue,String kpValue,String organizationLegalBusinessName){
        enrollmentPage.verifyAndSelectOwnershipDetailsInES(ownershipvalue,kpValue,organizationLegalBusinessName);
    }
    @Step
    public void verifyExclusionOrSanctionDoc(String docType){
        enrollmentPage.verifyExclusionOrSanctionDoc(docType);
    }
    @Step
    public void clickOnTaxonomyAndProviderType(){
        enrollmentPage.getAffiliationPanel().clickOnTaxonomyAndProviderType();
    }
    @Step
    public void clickOnNextButton(String buttonName){
        enrollmentPage.clickOnNextButton(buttonName);
    }

}

