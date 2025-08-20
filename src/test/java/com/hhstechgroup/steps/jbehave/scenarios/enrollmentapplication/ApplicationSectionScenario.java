package com.hhstechgroup.steps.jbehave.scenarios.enrollmentapplication;


import com.hhstechgroup.beans.application.*;
import com.hhstechgroup.steps.serenity.individualenrollment.EnrollmentApplicationSteps;
import com.hhstechgroup.ui.panels.enrollment.ChangeEnrollmentTypePanel;
import com.hhstechgroup.util.application.ApplicationSectionHelper;
import com.hhstechgroup.util.common.FieldUtils;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.core.Is;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class ApplicationSectionScenario {

    @Steps
    EnrollmentApplicationSteps enrollmentApplicationSteps;

    @When("set next information to $section section: $table")
    public void setIdentifyingInformation(String section, ExamplesTable information) {
        ApplicationSectionData identifyingInformation = ExamplesTableUtil.parseTableToClass(information, ApplicationSectionHelper.getSectionClass(section)).get(0);
        enrollmentApplicationSteps.setSectionInfo(section, identifyingInformation);
    }

    //latest for TP
    @When("To fill the identify info in the identification section for TP: $table")
    public void setTPIdentifyInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setTPIdentifyInfo(ExamplesTableUtil.parseTableToClass(user, IdentifyingInformationBean.class).get(0));
    }


    @When("To fill the email in the classification section for TP: $table")
    public void setEmailInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setTPIdentifyInfo(ExamplesTableUtil.parseTableToClass(user, IdentifyingInformationBean.class).get(0));
    }

    @When("set next information to '$section' section1: $table")
    public void setIdentifyingInformation1(String section, ExamplesTable information) {
        ApplicationSectionData identifyingInformation = ExamplesTableUtil.parseTableToClass(information, ApplicationSectionHelper.getSectionClass(section)).get(0);
        enrollmentApplicationSteps.setSectionInfo(section, identifyingInformation);
    }

    @When("add $table row in $section section with values: $table")
    public void addTableRow(String table, String section, ExamplesTable tableValues) {
        ApplicationSectionData tableInfo = ExamplesTableUtil.parseTableToClass(tableValues, ApplicationSectionHelper.getTableClass(table)).get(0);
        enrollmentApplicationSteps.setTableInfo(table, section, tableInfo);
    }

    @When("click Next button on $section section")
    public void clickNext(String section) {
        enrollmentApplicationSteps.clickNext(section);
    }

    @When("edit field '$field' on '$section' section")
    public void edit(String field, String section) {
        enrollmentApplicationSteps.editField(section, field);
    }

    @When("set new information to field in $section section: $table")
    public void editInfoOnIUPortal(String section, ExamplesTable information) {
        ApplicationSectionData identifyingInformation = ExamplesTableUtil.parseTableToClass(information, ApplicationSectionHelper.getSectionClass(section)).get(0);
        enrollmentApplicationSteps.editInfoOnIUPortal(section, identifyingInformation);
    }

    @When("move to '$section' section")
    public void moveToSection(String section) {
        enrollmentApplicationSteps.moveToSection(section);
    }

    //sp29

    @When("move to new '$section' section")
    public void moveToSection1(String section) {
        enrollmentApplicationSteps.moveToSection1(section);
    }
    @When("display $table column $column in $section")
    public void moveToSection(String table, String column, String section) {
        enrollmentApplicationSteps.showTableColumn(table, column, section);
    }

    @When("click on header '$header' in $tableName table in $section")
    public void clickOnTableHeader(String header, String table, String section) {
        enrollmentApplicationSteps.clickOnTableHeader(table, section, header);
    }

    @When("set field '$field' value to '$value' in $section")
    public void setFieldValue(String field, String value, String section) {
        enrollmentApplicationSteps.fillField(section, field, value);
        enrollmentApplicationSteps.saveChanges(section);
    }

    @When("set radio button '$field' value to '$value' in $section")
    public void selectRadionButton(String field, String value, String section) {
        enrollmentApplicationSteps.selectRadionButton(section, field, value);
    }

    @When("clear field '$field' in $section")
    public void clearField(String field, String section) {
        enrollmentApplicationSteps.clearField(section, field);
        enrollmentApplicationSteps.saveChanges(section);
    }

    @When("add next rows to test table '$tableName' in $section section: $table")
    public void fillTestTable(String tableName, String section, ExamplesTable table) {
        table.getRowsAsParameters().forEach(row -> {
            enrollmentApplicationSteps.clickAddTableRow(tableName, section);
            Optional.ofNullable(row.values().get("Id")).ifPresent(el -> enrollmentApplicationSteps.setTableField(tableName, section, "Id", el));
            Optional.ofNullable(row.values().get("DropDown")).ifPresent(el -> enrollmentApplicationSteps.selectFromDropDownTable(tableName, section, "DropDown", el));
            Optional.ofNullable(row.values().get("Text")).ifPresent(el -> enrollmentApplicationSteps.setTableField(tableName, section, "Text", el));
            enrollmentApplicationSteps.clickSaveTableRow(tableName, section);
        });
    }

    @When("set npi search value '$npi' in affiliation section")
    public void setNpiAffiliationFieldValue(String npi) {
        enrollmentApplicationSteps.setValueToNpiSearchField(npi);
    }

    @When("click search by npi in affiliation section")
    public void clickAffiliationSearchByNpi() {
        enrollmentApplicationSteps.clickAffiliationSearchByNpi();
    }

    @When("click add button in affiliation section")
    public void clickAddAffiliationButton() {
        enrollmentApplicationSteps.clickAddAffiliationButton();
    }

    @When("click add button in affiliation pop-up")
    public void clickAddAffiliationButtonInPopup() {
        enrollmentApplicationSteps.clickAddAffiliationButtonInPopup();
    }

    @When("wait for Coc application appeared")
    public void waitForAppAppeared() {
        enrollmentApplicationSteps.waitForEnrollmentSectionAppeared();
    }

    @Then("Provider Enrollment page with title '$title' should be opened")
    public void isProviderEnrollmentPageOpened(String expectedTitle) {
        assertTrue("Provider Enrollment page should be opened", enrollmentApplicationSteps.isPageWithTitleOpened(expectedTitle));
    }

    @Then("section with title '$title' should be disabled")
    public void isSectionDisabled(String title) {
        assertTrue("Section is not disabled", enrollmentApplicationSteps.isSectionDisabled(title));
    }

    @Then("section with title '$title' should be enabled")
    public void isSectionEnabled(String title) {
        assertFalse("Section is disabled", enrollmentApplicationSteps.isSectionDisabled(title));
    }

    @Then("section with title '$title' should be active")
    public void isSectionActive(String title) {
        assertTrue("Section is not active", enrollmentApplicationSteps.isSectionActive(title));
    }

    @Then("next $section section fields should contain values in {read|edit} mode: $table")
    public void checkFields(String section, ExamplesTable table) {
        Map<String, String> expectedFields = table.getRows().get(0);
        assertEquals(expectedFields, enrollmentApplicationSteps.getFieldsValuesReadMode(section, table.getHeaders()));
    }

    @Then("next $section section fields should contain values in write mode: $table")
    public void checkFieldsPEPortal(String section, ExamplesTable table) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<? extends ApplicationSectionData> sectionClass = ApplicationSectionHelper.getSectionClass(section);
        ApplicationSectionData expectedInformation = ExamplesTableUtil.parseTableToClass(table, sectionClass).get(0);
        ApplicationSectionData actualInformation = ExamplesTableUtil.replaceByHeaders(table.getHeaders(), enrollmentApplicationSteps.getSectionInfoInWriteMode(section, sectionClass.getDeclaredConstructor().newInstance()));
        assertReflectionEquals(expectedInformation, actualInformation);
    }

    @Then("next $section section fields should be read-only: $table")
    public void readOnlyFields(String section, ExamplesTable table) {
        List<String> readOnlyFields = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertTrue(enrollmentApplicationSteps.areFieldsReadOnly(section, readOnlyFields));
    }

    @Then("next $section fields should be highlighted: $table")
    public void areFieldsHighLighted(String section, ExamplesTable table) {
        assertTrue(enrollmentApplicationSteps.areFieldsHighlighted(section, ExamplesTableUtil.parseTableColumnAsList(table, 0)));
    }

    @Then("next '$section' values should be highlighted: $table")
    public void areReadOnlyValuesHighLighted(String section, ExamplesTable table) {
        assertTrue(enrollmentApplicationSteps.areReadOnlyValuesHighlighted(section, ExamplesTableUtil.parseTableColumnAsList(table, 0)));
    }

    @Then("section '$section' should not be present in application")
    public void isSectionAbsent(String sectionName) {
        assertFalse(enrollmentApplicationSteps.isSectionPresent(sectionName));
    }

    @Then("'$section' section should be displayed in Summary")
    public void isSectionPresent(String section) {
        assertTrue(enrollmentApplicationSteps.isSectionDisplayedInSummary(section));
    }

    @Then("'$field' field should have new value - '$newValue' and old value - '$oldValue'")
    public void checkValues(String fieldName, String newValue, String oldValue) {
        assertEquals(newValue, enrollmentApplicationSteps.getFieldNewValue(fieldName));
        assertEquals(oldValue, enrollmentApplicationSteps.getFieldOldValue(fieldName));
    }

    @Then("Summary section should be empty")
    public void isSummaryEmpty() {
        assertFalse("Summary section shouldn't have sections", enrollmentApplicationSteps.isSummaryContainAnySection());
    }

    @Then("section '$section' field - '$field' should contain value - '$value'")
    public void isFieldContainValue(String section, String fieldName, String value) throws IllegalAccessException, InstantiationException {
        ApplicationSectionData actualInformation = enrollmentApplicationSteps.getSectionInfoInWriteMode(section, ApplicationSectionHelper.getSectionClass(section).newInstance());
        assertTrue(FieldUtils.readField(actualInformation, fieldName).toString().contains(value));
    }

    @Then("field '$field' with next {checkboxes|radio buttons} should be displayed in section '$section': $table")
    public void getOptionsInDisplayedOrder(String fieldName, String section, ExamplesTable table) throws IllegalAccessException, InstantiationException {
        List<List<String>> expectedOptionsInOrder = new ArrayList<>();
        for (int i = 0; i < table.getHeaders().size(); i++) {
            expectedOptionsInOrder.add(ExamplesTableUtil.parseTableColumnAsList(table, i).stream().filter(el -> !el.isEmpty()).collect(Collectors.toList()));
        }
        assertReflectionEquals(expectedOptionsInOrder, enrollmentApplicationSteps.getOptionsInDisplayedOrder(section, fieldName, table.getHeaders().size()));
    }

    @Then("table '$tableName' in '$section' should have next headers: $table")
    public void getTableHeaders(String tableName, String section, ExamplesTable table) {
        assertReflectionEquals(ExamplesTableUtil.parseTableColumnAsList(table, 0), enrollmentApplicationSteps.getTableHeaders(tableName, section));
    }

    @Then("table '$tableName' in '$section' should have next data: $table")
    public void getTableData(String tableName, String section, ExamplesTable table) {
        assertReflectionEquals(table.getRows(), enrollmentApplicationSteps.getTableData(tableName, section));
    }

    @Then("field '$field' should have next value '$value' in $section")
    public void checkFieldValue(String field, String expectedValue, String section) {
        assertEquals(expectedValue, enrollmentApplicationSteps.getFieldValue(section, field));
    }

    @Then("next radio button '$field' value '$value' should be selected in $section")
    public void checkRadioButtonValue(String field, String expectedValue, String section) {
        assertEquals(expectedValue, enrollmentApplicationSteps.getRadioButtonValue(section, field));
    }

    @Then("data should be prepopulated for '$field' field and contain value - '$value'")
    public void isSummaryDataPrepopulated(String value, String field) {
        assertEquals(value, enrollmentApplicationSteps.getPrepopulatedData(field));
    }

    @Then("affiliation section should contain next data: $table")
    public void checkAffiliationData(ExamplesTable table) {
        ReflectionAssert.assertReflectionEquals(table.getRows(), enrollmentApplicationSteps.checkAffiliationData(), ReflectionComparatorMode.LENIENT_ORDER);
    }

    @When("change gender to '$gender'")
    public void changeGenderInEnrollment(String gender) {
        enrollmentApplicationSteps.changeGender(gender);
    }

    //maxdata
    @When("To fill the identifying information section for Enrollment: $table")
    public void setIndividualIdentifyInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setIndividualIdentifyInfo(ExamplesTableUtil.parseTableToClass(user, IdentifyingInformationBean.class).get(0));
    }
    @When("fill the Gender")
    public void fillingender(){
        enrollmentApplicationSteps.fillinggender();
    }
    @When("select '$text' for Applicatiion type determination")
    public void setApplicationTypeDetermination(String text)
    {
        enrollmentApplicationSteps.setApplicationTypeDetermination(text);
    }

    @When("To fill the identifying information section for Group Enrollment: $table")
    public void setGroupIdentifyInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setGroupIdentifyInfo(ExamplesTableUtil.parseTableToClass(user, IdentifyingInformationBean.class).get(0));
    }

    @When("To fill the Licensure Section for Enrollment: $table")
    public void setLicensureSectionInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setLicensureSectionInfo(ExamplesTableUtil.parseTableToClass(user, LicensureCertificationBean.class).get(0));
    }

    @When("To fill the Provider Identification Number: $table")
    public void setProviderIdentifyInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setProviderIdentifyInfo(ExamplesTableUtil.parseTableToClass(user, ProviderIdentifierNumberBean.class).get(0));
    }

    @When("add servicelocation providertype")
    public void add_servicelocatio_providertype(){
        enrollmentApplicationSteps.add_servicelocation_providertype();
    }
    @Then("To fill the EFT Information: $table")
    public void setEFTInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setEFTInfo(ExamplesTableUtil.parseTableToClass(user, EFTInformationBean.class).get(0));
    }

    @When("To fill the Address Details: $table")
    public void setAddressDetails(ExamplesTable user) {
        enrollmentApplicationSteps.setAddressDetails(ExamplesTableUtil.parseTableToClass(user, AddressBean.class).get(0));
    }

    @When("To fill the Service Location Billing info: $table")
    public void setServiceLocationInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setServiceLocationInfo(ExamplesTableUtil.parseTableToClass(user, ServiceLocationBillingBean.class).get(0));
    }

    @When("To fill the Electroic funds payment info: $table")
    public void setElectricFundsPaymentInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setElectricFundsPaymentInfo(ExamplesTableUtil.parseTableToClass(user, ElectronicFundsPaymentBean.class).get(0));
    }

    @When("To fill the address details in the identification section for TP: $table")
    public void setTPAddressInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setTPAddressInfo(ExamplesTableUtil.parseTableToClass(user, AddressBean.class).get(0));
    }

    @When("To fill the Address details for TP: $table")
    public void setTPAddressDetails(ExamplesTable user) {
        enrollmentApplicationSteps.setTPAddressDetails(ExamplesTableUtil.parseTableToClass(user, AddressBean.class).get(0));
    }

    //latest
    @When("To fill the Request Retroactive Adjustment info: $table")
    public void setRequestRetroactiveAdjustmentDetails(ExamplesTable user) {
        enrollmentApplicationSteps.setRequestRetroactiveAdjustmentDetails(ExamplesTableUtil.parseTableToClass(user, RequestRetroactiveAdjustmentBean.class).get(0));
    }

    @When("To fill the Training Required info: $table")
    public void setTraingingRequiredDetails(ExamplesTable user) {
        enrollmentApplicationSteps.setTraingingRequiredDetails(ExamplesTableUtil.parseTableToClass(user, TrainingRequiredBean.class).get(0));
    }


    @When("To fill the Profile Setup info: $table")
    public void setProfileSetupDetails(ExamplesTable user) {
        enrollmentApplicationSteps.setProfileSetupDetails(ExamplesTableUtil.parseTableToClass(user, ProfileSetupBean.class).get(0));
    }

    @When("To fill the Pharmacy Contact info: $table")
    public void setPharmacyContactDetails(ExamplesTable user) {
        enrollmentApplicationSteps.setProfileSetupDetails(ExamplesTableUtil.parseTableToClass(user, ProfileSetupBean.class).get(0));
    }

    @When("To fill the Pharmacy Information info: $table")
    public void setPharmacyInformationDetails(ExamplesTable user) {
        enrollmentApplicationSteps.setProfileSetupDetails(ExamplesTableUtil.parseTableToClass(user, ProfileSetupBean.class).get(0));
    }

    //new sp20
    @When("To fill the Concact Person Details: $table")
    public void setConcactPersonDetails(ExamplesTable user) {
        enrollmentApplicationSteps.setConcactPersonDetails(ExamplesTableUtil.parseTableToClass(user, LocationContactPersonBean.class).get(0));
    }

    //sp20
    @When("edit the zip field in Address details: $table")
    public void setAddressInfo1(ExamplesTable user) {
        enrollmentApplicationSteps.setAddressDetails(ExamplesTableUtil.parseTableToClass(user, AddressBean.class).get(0));
    }

    //sp21
    @When("To click on the finger print: $table")
    public void setVerifyFingerPrint(ExamplesTable user) {
        enrollmentApplicationSteps.setVerifyFingerPrint(ExamplesTableUtil.parseTableToClass(user, FingerPrintBean.class).get(0));
    }

    //sp26
    @When("to fill the Title of Person Submitting Enrollment: $table")
    public void setAuthorizedSignatureinfo(ExamplesTable user) {
        enrollmentApplicationSteps.setAuthorizedSignatureinfo(ExamplesTableUtil.parseTableToClass(user, AuthorizedSignatureBean.class).get(0));
    }

    //new PEM
    @When("To fill the identify info in the identification section for PEM: $table")
    public void setPEMIdentifyInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setPEMIdentifyInfo(ExamplesTableUtil.parseTableToClass(user, IdentifyingInformationBean.class).get(0));
    }

    @When("To fill the address details in the identification section for PEM: $table")
    public void setPEMAddressInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setPEMAddressInfo(ExamplesTableUtil.parseTableToClass(user, AddressBean.class).get(0));
    }

    @When("To fill the Address details for PEM: $table")
    public void setPEMAddressDetailsInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setPEMAddressDetailsInfo(ExamplesTableUtil.parseTableToClass(user, AddressBean.class).get(0));
    }

    @When("To fill the email in the classification section for PEM: $table")
    public void setconcactEmailInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setconcactEmailInfo(ExamplesTableUtil.parseTableToClass(user, IdentifyingInformationBean.class).get(0));
    }

    @When("To fill the data for software vendor details section for PEM: $table")
    public void setPEMSoftwareVendorInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setPEMSoftwareVendorInfo(ExamplesTableUtil.parseTableToClass(user, SoftwareVendorDetailsBean.class).get(0));
    }

    //sp26
    @Then("click on the Addline in License information")
    public void clickAddRow() {
        enrollmentApplicationSteps.clickAddRow();
    }

    @Then("click on the Message Box in provider enrollment")
    public void clickMessageBox() {
        enrollmentApplicationSteps.clickMessageBox();
    }
    @Then("click on the Addline")
    public void clickAddLine() {
        enrollmentApplicationSteps.clickAddRow();
    }

    @When("To fill the License Information for Enrollment: $table")
    public void setLicenseInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setLicenseInfo(ExamplesTableUtil.parseTableToClass(user, LicenseInformationBean.class).get(0));
    }

    @Then("click on the Save button")
    public void clickSave() {
        enrollmentApplicationSteps.clickSave();
    }

    @Then("click on the Save button in Key Personel")
    public void clickSaveinKeyPersonel() {
        enrollmentApplicationSteps.clickSaveinKeyPersonel();
    }

    @Then("click Next button in Address Details")
    @When("click Next button in Address Details")
    public void clickSaveinAddressDetails() {
        enrollmentApplicationSteps.clickSaveinAddressDetails();
    }

    @Then("click on the Addline in Enrollment information")
    public void clickAddRowtable() {
        enrollmentApplicationSteps.clickAddRow();
    }

    @Then("To fill the Other Medicaid State Enrollment info: $table")
    public void setOtherMedicaidStateInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setOtherMedicaidStateInfo(ExamplesTableUtil.parseTableToClass(user, OtherMedicaidStateBean.class).get(0));
    }

    //sp28
    @Then("verify the 'Add Secondary Service Location' button is displaying")
    public void verifyAddSecondaryservicelocationbutton() {
        System.out.println("Add Secondary Service Location Button is displaying");
        assertTrue(enrollmentApplicationSteps.verifyAddSecondaryservicelocationbutton());
    }

    @Then("click on the Add Secondary Service Location button")
    public void clickAddSecondaryServiceLocation() {
        enrollmentApplicationSteps.clickAddSecondaryServiceLocation();
    }

    @Then("click on the Delete Secondary Service Location button")
    public void clickDeleteSecondaryServiceLocation() {
        enrollmentApplicationSteps.clickDeleteSecondaryServiceLocation();
    }

    @Then("verify the 'Delete Secondary Service Location' Icon is displaying")
    public void verifyDeleteIconisDisplaying() {
        System.out.println("Delete Secondary Service Location Icon is displaying");
        assertTrue(enrollmentApplicationSteps.verifyDeleteIconisDisplaying());
    }

    @Then("verifying the Loop Creation pop-up is opened")
    public void isLoopPopupOpened() {
        assertTrue(enrollmentApplicationSteps.isLoopPopupOpened());
    }

    @Then("click on 'Ok' button in popup page")
    public void clickOkButton() {
        enrollmentApplicationSteps.clickOkButton();
    }

    //sp28
    @Then("click on new Addline in License information")
    public void clickAddRow1() {
        enrollmentApplicationSteps.clickAddRow1();
    }

    @Then("click on new Save button")
    public void clickSave1() {
        enrollmentApplicationSteps.clickSave1();
    }

    //sp29
    @When("To fill the OwerKeyPersonel Information for Enrollment: $table")
    public void setOwerKeyPersonelInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setOwerKeyPersonelInfo(ExamplesTableUtil.parseTableToClass(user, OwerKeyPersonelBean.class).get(0));
    }
    //sp33
    @When("To fill the Affialition Information for Enrollment: $table")
    public void setAffiliationInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setAffiliationInfo(ExamplesTableUtil.parseTableToClass(user, AffilitionInformationBean.class).get(0));
    }
    @Then("verifying the affilaition provider record details: $table")
    public void checkMappedProviderValuesForAffilaition(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(enrollmentApplicationSteps.getAffilaitionProviderInfo(), Is.is(expectedInfo));
    }
    @Then("click on the close popup")
    public  void clickonclosebutton() {
        enrollmentApplicationSteps.clickonclosebutton();
    }
    //sp35
    @When("To fill the Pharmacy License Information for Enrollment: $table")
    public void setPharmacyLicenseInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setPharmacyLicenseInfo(ExamplesTableUtil.parseTableToClass(user, PharmacyLicenseInformationBean.class).get(0));
    }

    //sp37
    @When("To fill the Exclusion Sanction Section: $table")
    public void setExclusionSanctionInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setExclusionSanctionInfo(ExamplesTableUtil.parseTableToClass(user, ExclusionSanctionBean.class).get(0));
    }
    @Then("to change the enrollment type: $table")
    public void setChangeEnrollmentTypeinfo(ExamplesTable user) {
        enrollmentApplicationSteps.setChangeEnrollmentTypeinfo(ExamplesTableUtil.parseTableToClass(user, ChangeEnrollmentTypeBean.class).get(0));
    }

    @Then("verify the Change Enrollment Type Notification is '$notification' is displaying")
    public boolean isChangeEnrollTypeNotificationdisplaying(String notification) {
        return enrollmentApplicationSteps.isChangeEnrollTypeNotificationdisplaying(notification);
    }

    @When("select reason '$reason' and '$note' the change type enrollment popup")
    public void setreasonforchangeenollmenttype(String reason,String note) {
        enrollmentApplicationSteps.setreasonforchangeenollmenttype(reason,note);
    }
    @Then("click on the Apply button")
    public void clickApply(){
        enrollmentApplicationSteps.clickApply();
    }

    //sp41.4
    @Then("verifying the Mailing Address Zip in Provider record details: $table")
    public void getMappedZipValues(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(enrollmentApplicationSteps.getMappedZipValues(), Is.is(expectedInfo));
    }

    //sp42.3

    @When("move to site visit '$section' section")
    public void moveToSection2(String section) {
        enrollmentApplicationSteps.moveToSection2(section);
    }

    //Demo
    @When("click on the Addline in Ownership")
    @Then("click on the Addline in Affiliation in License Section")
    public void clickAddRow2() {
        enrollmentApplicationSteps.clickAddRow2();
    }

    @Then("click on the Add Line")
    public void clickOnAddLine(){
        enrollmentApplicationSteps.clickOnAddLine();
    }

    @Then("click on ALL in All Ages Served")
    public void allAgesServed(){
        enrollmentApplicationSteps.allStatesServed();
    }
    @When("click on the Add line")

    @Then("click on the Addline in Certification in License Section")
    public void clickAddRow3() {
        enrollmentApplicationSteps.clickAddRow3();
    }

    @Then("click on NO in Pharmacy Medicare Certified")
    public void pharmacyMedicareCertified(){
        enrollmentApplicationSteps.pharmacyMedicareCertified();
    }

    @Then("click on NO in Pharmacy Payments")
    public void pharmacyPayments(){
        enrollmentApplicationSteps.pharmacyPayments();
    }

    @Then("click Pharmacy Participates in 340B drug Pricing Progrm")
    public void pharmacyPARTICIPATES340B(){
        enrollmentApplicationSteps.pharmacyParticipates340B();
    }

    @Then("click on pharmacy currently has any Wyoming Medicaid clients needing services")
    public void clientNeedingServices(){
        enrollmentApplicationSteps.clientNeedingServices();
    }

    @Then("click on pharmacy provides medications not readily supplied by an in-state Wyoming retail or hospital pharmacy")
    public void medicationsNotReadilySupplied(){
        enrollmentApplicationSteps.medicationsNotReadilySupplied();
    }

    @Then("click on pharmacy has a Wyoming Board of Pharmacy License or plans to obtain one")
    public void wyomingBoardPharmacy(){
        enrollmentApplicationSteps.wyomingBoardPharmacy();
    }

    @Then("click on pharmacy is a compounding pharmacy that plans to mail compound prescriptions into the State of Wyoming")
    public void compoundPrescriptionsPharmacy(){
        enrollmentApplicationSteps.compoundPrescriptionsPharmacy();
    }

    //wyomi WY-SP63

    @When("edit new field $field on $section section")
    public void edit1(String field, String section) {
        enrollmentApplicationSteps.editField(section, field);
    }

    // WY-65
    @When("edit the new field $field on $section section")
    public void edit2(String field, String section) {
        enrollmentApplicationSteps.editField1(section, field);
    }

    // SD-05
    @Then("Agree Term and conditions to Sign")
    public  void clickProceedSignCheckbox(){
        enrollmentApplicationSteps.clickProceedSignCheckbox();
    }

    //SD-08

    @When("click Add Affiliation button in affiliation section")
    public void addAffiliation() {
        enrollmentApplicationSteps.addAffiliation();
    }
    @When("set providerid search value '$providerid' in affiliation section")
    public void setProviderIdAffiliationFieldValue(String providerId){
        enrollmentApplicationSteps.setProviderIDValueSearchField(providerId);
    }

    @When("click Add Affiliation for group button in affiliation section")
    public void addAffiliationgroup() {
        enrollmentApplicationSteps.addAffiliationgroup();
    }

    @When("set type search value '$type' in affiliation section")
    public void setTypeAffiliationDropdownValue(String type) {
        enrollmentApplicationSteps.setTypeAffiliationDropdownValue(type);
    }

    @When("verify system should not display service locations under affiliations tab")
    public void verifyServiceLocationDisplay() {
        if(enrollmentApplicationSteps.verifyServiceLocationDisplay())
            System.out.println("Service location presents!");
        else
            System.out.println("Service location not presents!");
    }

    @When("To fill the Ownership Section for Enrollment: $table")
    public void setOwnershipInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setOwnershipInfo(ExamplesTableUtil.parseTableToClass(user, OwnershipBean.class).get(0));
    }
    @Then("select tax identifier '$value' in Ownership")
        public void setTaxIdentifier(String ssnCheckBox) {
        enrollmentApplicationSteps.setTaxIdentifier(ssnCheckBox);
    }
    @Then("select SubContractor '$value' Tax Identifier in Ownership")
    public void setSubContractorTaxIdentifier(String subContractorSsn){
        enrollmentApplicationSteps.setSubContractorTaxIdentifier(subContractorSsn);
    }
    @When("To fill the Proffesional Liability Insurance Info for Enrollment: $table")
    public void setProffesionalLiabilityInsuranceInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setProffesionalLiabilityInsuranceInfo(ExamplesTableUtil.parseTableToClass(user, ProffesionalLiabilityInsuranceInfoBean.class).get(0));
    }

    @Then("click on Addline for '$section' in Key Personnel section")
    public void clickAddLineKeyPersonnel(String section) {
        enrollmentApplicationSteps.clickAddLineKeyPersonnel(section);
    }

    @When("click on Add Taxonomy/Speciality in Service Location section")
    public void clickAddTaxonomyOrSpeciality() {
        enrollmentApplicationSteps.clickAddTaxonomyOrSpeciality();
    }
    @When("click on '$addregion' in Service Location Section")
    public void clickOnAddRegion(String addregion){
        enrollmentApplicationSteps.clickOnAddRegion(addregion);
    }

    @When("click on Add Taxonomy in Taxonomy Info section")
    public void clickAddTaxonomyButton() {
        enrollmentApplicationSteps.clickAddTaxonomyButton();
    }

    @When("click on Add Location in Service Location section")
    public void clickAddLocation() {
        enrollmentApplicationSteps.clickAddLocation();
    }

    @When("click on '$button' in Service Location section")
    public void clickServiceLocationButton(String button) {
        enrollmentApplicationSteps.clickServiceLocationButton(button);
    }

    @When("upload document '$type' document $path in Service Location Section")
    public void uploadDocument1(String document, String path) {
        enrollmentApplicationSteps.uploadDocument1(document, path);
    }

    @When("upload document '$type' document $path in Service Location Claim Section")
    public void uploadClaimDocument(String document, String path) {
        enrollmentApplicationSteps.uploadClaimDocument(document, path);
    }

    @When("upload document '$type' document $path in Program Participation dialog")
    public void uploadDocument2(String document, String path) {
        enrollmentApplicationSteps.uploadDocument2(document, path);
    }

    @When("upload document '$type' document $path in Taxonomy/Speciality/License Certification Info section")
    public void uploadDocument3(String document, String path) {
        enrollmentApplicationSteps.uploadDocument3(document, path);
    }

    @When("upload document '$type' document $path in Other Credentialing Information Info section")
    public void uploadDoc(String docType,String path){
        enrollmentApplicationSteps.uploadDoc(docType,path);
    }
    @When("save Program Participation in Service Location Section")
    public void saveProgramParticipation(){
        enrollmentApplicationSteps.saveProgramParticipation();
    }

    @Then("save the details of Taxonomy/Speciality/License Certification section info")
    public void saveProgramParticipationSection(){
        enrollmentApplicationSteps.saveProgramParticipationSection();
    }


    @Then("select Taxonomy in Program Participation")
    public void selectTaxonomy(){
        enrollmentApplicationSteps.selectTaxonomy();
    }

    @Then("save Taxonomy in Taxonomy/Speciality")
    public void saveTaxonomy(){
        enrollmentApplicationSteps.saveTaxonomy();
    }
    @Then("select Taxonomy '$taxonomy'")
    public void selectTaxonomyInServiceLocation(String taxonomy){
        enrollmentApplicationSteps.selectTaxonomyInServiceLocation(taxonomy);
    }

    @Then("to fill the Taxonomy/Speciality/License Certification section info in Service Location: $table")
    @When("To fill the Service Location info: $table")
    public void setServiceLocationInfo1(ExamplesTable user) {
        enrollmentApplicationSteps.setServiceLocationInfo(ExamplesTableUtil.parseTableToClass(user, ServiceLocationBean.class).get(0));
    }


    @When("To fill the Program Participation info: $table")
    public void setProgramParticipationInfo(ExamplesTable user) throws InvocationTargetException {
        enrollmentApplicationSteps.setProgramParticipationInfo(ExamplesTableUtil.parseTableToClass(user, ProgramParticipationBean.class).get(0));
    }


    @When("To fill the Taxonomy/Speciality/License Certification section info: $table")
    public void setProgramParticipationSectionInfo(ExamplesTable user) throws InvocationTargetException {
        enrollmentApplicationSteps.setProgramParticipationSectionInfo(ExamplesTableUtil.parseTableToClass(user, ProgramParticipationSectionBean.class).get(0));
    }

    @When("click on '$button' in Program participation dialog")
    public void clickButtonInProgramParticipation(String button) {
        enrollmentApplicationSteps.clickButtonInProgramParticipation(button);
    }

    @When("click on '$button' in Taxonomy/Speciality/License Certification Info section")
    public void clickButtonInProgramParticipationSection(String button) {
        enrollmentApplicationSteps.clickButtonInProgramParticipationSection(button);
    }



    @When("To fill TP Provider Identification Number: $table")
    public void setTPProviderIdentifyInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setTPProviderIdentifyInfo(ExamplesTableUtil.parseTableToClass(user, ProviderIdentifierNumberBean.class).get(0));
    }

    @When("To fill the Classification Section: $table")
    public void setClassificationInfo(ExamplesTable user) {
        enrollmentApplicationSteps.setClassificationInfo(ExamplesTableUtil.parseTableToClass(user, ClassificationBean.class).get(0));
    }

    @When("select affiliation row by '$text' in affiliation section")
    public void selectAffiliationByRowText(String text){
        enrollmentApplicationSteps.selectAffiliationByRowText(text);
    }

    @When("select all affiliations in affiliation section")
    public void selectAllAffiliations(){
        enrollmentApplicationSteps.selectAllAffiliations();
    }

    @When("click Bulk Add Affiliations in affiliation section")
    public void clickAddBulkAffiliationButton(){
        enrollmentApplicationSteps.clickAddBulkAffiliationButton();
    }

    @Then("click on new Addline in Service Location")
    public void clickAddRow4() {
        enrollmentApplicationSteps.clickAddRow1();
    }

    @Then("click new Save button")
    public void clickSave2() {
        enrollmentApplicationSteps.clickSave2();
    }

    @When("click on '$option' to the question '$question'")
    public void clickOptionToQuestion(String option, String question){
        enrollmentApplicationSteps.clickOptionToQuestion(option, question);
    }


    @When("set SSN search value '$value' in affiliation section")
    public void setSsnAffiliationDropdownValue(String value) {
        enrollmentApplicationSteps.setSsnAffiliationDropdownValue(value);
    }

    @When("set DOB search value '$value' in affiliation section")
    public void setDobAffiliationDropdownValue(String value) {
        enrollmentApplicationSteps.setDobAffiliationDropdownValue(value);
    }

    //SD16 Alternative address code

    @When("To fill the Alternate Address Details: $table")
    public void setAlternateAddressDetails(ExamplesTable user) {
        enrollmentApplicationSteps.setAlternateAddressDetails(ExamplesTableUtil.parseTableToClass(user, AddressBean.class).get(0));
    }

    //.

    @When("verify that Enrollment Date is empty")
    public void verifyEnrollmentDateEmpty(){
        assertTrue("Not empty!", enrollmentApplicationSteps.getEnrollmentDate().isEmpty());
    }

    @When("verify that Reason Code is empty")
    public void verifyReasonCodeEmpty(){
        assertTrue("Not empty!", enrollmentApplicationSteps.getReasonCode().isEmpty());
    }

    @When("verify that Enrollment Date is mandatory")
    public void isEnrollmentDateMandatory(){
        assertTrue("Not mandatory", enrollmentApplicationSteps.isEnrollmentDateMandatory());
    }

    @When("verify that Reason Code is mandatory")
    public void isReasonCodeMandatory(){
        assertTrue("Not mandatory", enrollmentApplicationSteps.isReasonCodeMandatory());
    }

    @When("click on '$option' to '$question' in affiliation popup")
    public void setAffiliatePrimaryLocation(String option, String question){
        enrollmentApplicationSteps.setAffiliatePrimaryLocation(option, question);
    }

    @When("click on '$option' for the question '$question' in affiliation")
    public void setConfirmAffiliationWithIndi(String question, String option){
        enrollmentApplicationSteps.setConfirmAffiliationWithIndi(question , option);
    }
    @When("fill the location effective start '$date' and location effective end '$date' in affiliation popup")
    public void setLocationEffectiveDates(String dateStart,String dateEnd){
        enrollmentApplicationSteps.setLocationEffectiveDates(dateStart,dateEnd);
    }

    @When("select '$programparticipation' with '$startdate' and '$enddate' in affiliation popup")
    public void selectProgramParticipation(String programparticipation, String startdate, String enddate){
        enrollmentApplicationSteps.selectProgramParticipation(programparticipation, startdate, enddate);
    }

    @When("click on '$button' for homelocation in afffiliation popup")
    public void setHomeLocation(String homeLocation){
        enrollmentApplicationSteps.setHomeLocation(homeLocation);
    }

    @Then("To fill the Health Home Services Details: $table")
    public void setHealthHomeServiceDetails(ExamplesTable user) {
        enrollmentApplicationSteps.setHealthHomeServicesInfo(ExamplesTableUtil.parseTableToClass(user, HealthHomeServicesBean.class).get(0));
    }

    @When("add service location with '$text'")
    public void addServiceLocation(String text){
        enrollmentApplicationSteps.addServiceLocation(text);
    }

    @When("search for service location data on affiliation popup by next parameters: $table")
    public void searchByEnrollParameters(ExamplesTable table) {
        AffiliationPoupBean parameters = ExamplesTableUtil.parseTableToClass(table, AffiliationPoupBean.class).get(0);
        enrollmentApplicationSteps.setAffiliationPopupCriteria(parameters);
        enrollmentApplicationSteps.searchSecondaryServiceLocation();
    }

    @Then("verify duplicate npi message for '$npi'")
    public void verifyDuplicateNpiMessagePresents(String npi){
        assertTrue("Duplicate NPI Message not presents", enrollmentApplicationSteps.isDuplicateNpiMessagePresents(npi));
    }

    @Then("verify popup message as '$message'")
    public void verifyPopupMessage(String message) {
        assertEquals(message, enrollmentApplicationSteps.getPopupMessage());
    }

    @When("To search the Service Location info: $table")
    public void searchServiceLocationByCriteria(ExamplesTable user) {
        enrollmentApplicationSteps.searchServiceLocationByCriteria(ExamplesTableUtil.parseTableToClass(user, ServiceLocationBean.class).get(0));
    }

    @Then("verify that the system is showing the '$effectivestartdate' and '$effectiveenddate' in the Service location result")
    public void verifyEffectiveStartDateEndDate(String start, String end){
        assertTrue(enrollmentApplicationSteps.isDataPresents(start));
        assertTrue(enrollmentApplicationSteps.isDataPresents(end));
    }

    @Then("Edit taxonomy for '$taxonomy'")
    public void editTaxonomy(String taxonomy) {
        enrollmentApplicationSteps.editTaxonomy(taxonomy);
    }
    @Then("verify the effective end date '$expDate' for the Taxonomy '$taxonomyValue")
    public void verifyEffectiveEndDate(String expDate,String taxonomyValue){
//        enrollmentApplicationSteps.verifyEffectiveEndDate(expDate,taxonomyValue);
        assertEquals(expDate,enrollmentApplicationSteps.verifyEffectiveEndDate(expDate,taxonomyValue));
    }

    @Then("Remove/End taxonomy for '$taxonomy'")
    public void removeTaxonomy(String taxonomy) {
        enrollmentApplicationSteps.removeTaxonomy(taxonomy);
    }

    @Then("Edit Service ELocation for '$location'")
    public void editServiceLocation(String location) {
        enrollmentApplicationSteps.editServiceLocation(location);
    }

    @Then("Remove/End Service Location for '$location'")
    public void removeServiceLocation(String location) {
        enrollmentApplicationSteps.removeServiceLocation(location);
    }

    @Then("End Affiliation for '$affiliationType'")
    public void endAffiliation(String affiliationType) {
        enrollmentApplicationSteps.endAffiliation(affiliationType);
    }

    @Then("save designated providers")
    public void saveDesignatedProviders() {
        enrollmentApplicationSteps.saveDesignatedProviders();
    }
    @When("Edit Service Location for '$location'")
    @Then("Edit Service Location for '$location' in COC page")
    public void editCocServiceLocation(String location) {
        enrollmentApplicationSteps.editCocServiceLocation(location);
    }

    @Then("Remove/End Primary Service Location for '$location' with reason '$reason' note '$note' in COC page")
    public void removeCocPrimaryServiceLocation(String location, String reason, String note) {
        enrollmentApplicationSteps.removeCocPrimaryServiceLocation(location, reason, note);
    }

    @Then("Remove/End Secondary Service Location for '$location' with reason '$reason' note '$note' in COC page")
    public void removeCocSecondaryServiceLocation(String location, String reason, String note) {
        enrollmentApplicationSteps.removeCocSecondaryServiceLocation(location, reason, note);
    }

    @Then("Edit Program Participation for '$taxonomy' in Coc page")
    public void editCocProgramParticipation(String taxonomy) {
        enrollmentApplicationSteps.editCocProgramParticipation(taxonomy);
    }

    @Then("Remove/End Program Participation for '$taxonomy' in Coc page")
    public void removeCocProgramParticipation(String taxonomy) {
        enrollmentApplicationSteps.removeCocProgramParticipation(taxonomy);
    }

    @Then("click '$option' for the popup '$popup'")
    public void clickPopupOption(String option, String popup){
        enrollmentApplicationSteps.clickPopupOption(popup, option);
    }

    @Then("select secondary location '$location' as primary location")
    public void selectPrimaryLocation(String location){
        enrollmentApplicationSteps.selectPrimaryLocationName(location);
    }

    @When("select '$mannerOfService' for Manner of Service in affiliation popup")
    public void setMannerOfService(String mannerOfService){
        enrollmentApplicationSteps.setMannerOfService(mannerOfService);
    }
    @When("click '$option' for Accepting New Patients in affiliation popup")
    public void setAcceptingNewPatients(String acceptingNewPatients){
        enrollmentApplicationSteps.setAcceptingNewPatients(acceptingNewPatients);
    }
    @Then("select '$textforPT' for practice type")
    public void setPracticeType(String textForPT){
        enrollmentApplicationSteps.setPracticeType(textForPT);
    }
    @Then("select '$authorizedPerson' in EFT Information Section")
    public void setAuthorizedPerson(String authorizedPerson){
        enrollmentApplicationSteps.setAuthorizedPerson(authorizedPerson);

    }
    @Then("edit the details of the EFT Information")
    public void editDetailsOfEFTInfo(){
        enrollmentApplicationSteps.editDetailsOfEFTInfo();
    }

    @Then("Validating all the sections should be displayed: $table")
    public void checkFilters(ExamplesTable table) {
        List<String> expectedNames = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertEquals(expectedNames, enrollmentApplicationSteps.getSectionsNames());
    }
    @Then("verify all the tabs should be displayed: $table")
    public void checkTabsInHeader(ExamplesTable table){
        List<String> expectedTabs = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertEquals(expectedTabs, enrollmentApplicationSteps.getTabNames());
    }

    @Then("verify the '$count' taxonomies in Taxonomy/Speciality/License Certification section info")
    @When("verify the '$count' Service locations in Service Location Section")
    public void verifyServiceLocationsCount(int expectedCount){
        List<String> seriveLocationsRows = enrollmentApplicationSteps.verifyServiceLocationsCount();
        assertEquals("Expected " + expectedCount + " taxonomies, but found " + seriveLocationsRows.size(),
                expectedCount, seriveLocationsRows.size());
    }

    @Then("verify the count of the RAI should be '$raiCount'")
    public void verifyRAICount(int expectedRAICount) {
        int actualRAICount = enrollmentApplicationSteps.verifyRAICount();
        assertEquals("Expected RAI count is " + expectedRAICount + " but found " + actualRAICount,
                expectedRAICount, actualRAICount);
    }


    @Then("verify the '$count' Affiliations in Affiliation Section")
    public void verifyAffiliationCount(int expectedCount){
        List<String> affiliationRows = enrollmentApplicationSteps.verifyAffiliationCount();
        assertEquals("Expected " + expectedCount + " taxonomies, but found " + affiliationRows.size(),
                expectedCount, affiliationRows.size());
    }
    @Then("click on the '$button' button")
    public void clickOnEditButton(String editOrRemoveButton){
        enrollmentApplicationSteps.clickOnEditButton(editOrRemoveButton);
    }
    @Then("click on the '$button'")
    public void ClickOnLicenseEditButton(String button){
        enrollmentApplicationSteps.ClickOnLicenseEditButton(button);
    }

    @Then("click on the '$buttonName' button in the popup")
    public void clickOnButtonInPopUp(String buttonName){
        enrollmentApplicationSteps.clickOnButtonInPopUp(buttonName);
    }
    @Then("click on Save Button")
    public void clickOnSaveButton(){
        enrollmentApplicationSteps.clickOnSaveButton();
    }

    @Then("verify whether the updated Location '$location' is displayed in Service Location")
    public void verifyUpdatedServiceLocation(String location) {
        boolean isDisplayed = enrollmentApplicationSteps.isServiceLocationDisplayed(location);
        assertTrue("The updated location '" + location + "' is not displayed.", isDisplayed);
    }
    @Then("verify whether '$enrollmentType' provider Affiliation Effective end date '$expDate' is displayed")
    public void verifyAffiliationEffectiveEndDate(String expDate,String enrollmentType) {
        boolean isDisplayed = enrollmentApplicationSteps.verifyAffiliationEffectiveEndDate(expDate,enrollmentType);
        assertTrue("The updated location '" + expDate + "' is not displayed.", isDisplayed);
    }
    @Then("verify whether '$providerLegalBusinessName' provider Affiliation Effective end date '$expDate' is updated")
    public void verifyUpdatedEffectiveEndDate(String providerLegalBusinessName,String expDate ){
        boolean isUpdated=enrollmentApplicationSteps.verifyUpdatedEffectiveEndDate(providerLegalBusinessName,expDate);
        assertTrue("The updated location '" + expDate + "' is not displayed.", isUpdated);
    }
    @Then("verify whether the updated License No '$licenseNo' is displayed in Taxonomy Section")
    public void verifyUpdatedLicenseNum(String licenseNo) {
        boolean isDisplayed = enrollmentApplicationSteps.isLicenseNumberDisplayed(licenseNo);
        assertTrue("The updated License Number '" + licenseNo + "' is not displayed.", isDisplayed);
    }
    @Then("verify '$taxonomy' added in Taxonomy section")
    public void verifyAddedTaxonomy(String taxonomy){
        boolean isAddedtaxonomy=enrollmentApplicationSteps.verifyAddedTaxonomy(taxonomy);
        assertTrue("The added taxonomy '" + taxonomy + "' is not displayed.",isAddedtaxonomy);
    }
    @Then("verify '$locationType' Location type added in service location")
    public void verifyAddedLocation(String locationType){
        boolean isAddedLocation = enrollmentApplicationSteps.verifyAddedLocation(locationType);
        assertTrue("The added location '" + locationType + "' is not displayed.",isAddedLocation);

    }
    @Then("edit the details of the '$Entity' provider in Affiliation section")
    public void editTheDetailsOfAffiliation(String enrollmentType){
    enrollmentApplicationSteps.editTheDetailsOfAffiliation(enrollmentType);
    }
    @When("fill the location effective start '$date' and location effective end '$date' in affiliation")
    public void setLocationEffectiveDate(String dateStart,String dateEnd){
        enrollmentApplicationSteps.setLocationEffectiveDate(dateStart,dateEnd);
    }
    @Then("verify the popup message '$expectedMessage' is displayed")
    public void verifyOwnershipPopupMessage(String expectedMessage) {
        String actualMessage = enrollmentApplicationSteps.getOwnershipPopupMessage();
        Assert.assertEquals("Popup message does not match!", expectedMessage, actualMessage);
    }

    @Then("edit the Percent of Interest percentage to '$percent'")
    public void editPercentOfInterestPercentage(String percentage){
        enrollmentApplicationSteps.editPercentOfInterestPercentage(percentage);
    }
    @Then("edit the ownership percentage to '$percent'")
    public void editOwnerhsipPercentage(String ownershipPercent){
        enrollmentApplicationSteps.editOwnerhsipPercentage(ownershipPercent);
    }

    @Then("verify and select the name with text '$value'")
    public void verifyAndSelectNameInExclusionSanctionInfo(String value){
        enrollmentApplicationSteps.verifyAndSelectName(value);
    }
    @When("verify personOrEntityOwnership text '$value1', subcontractorOwnership '$value2' and keypersonal names '$value3' and select the name with text '$value4'")
    public void verifyAndSelectOwnershipDetails(String value1,String value2,String value3,String value4){
        enrollmentApplicationSteps.verifyAndSelectOwnershipDetails(value1, value2, value3, value4);
    }
    @When("verify personOwnership1 '$ownershipvalue' and keypersonal names '$kpValue' and select the name with text '$organizationLegalBusinessName'")
        public void verifyAndSelectOwnershipDetailsInES(String ownershipvalue,String kpValue,String organizationLegalBusinessName){
        enrollmentApplicationSteps.verifyAndSelectOwnershipDetailsInES(ownershipvalue,kpValue,organizationLegalBusinessName);
    }
    @Then("verify '$docType' field is Added in Upload Documents")
    public void verifyAndUploadExclusionOrSanctionDoc(String docType){
        enrollmentApplicationSteps.verifyExclusionOrSanctionDoc(docType);
    }

    @Then("select Taxonomy and Provider Type of Entity in Affiliation section")
    public void  clickOnTaxonomyAndProviderType(){
        enrollmentApplicationSteps.clickOnTaxonomyAndProviderType();
    }

    @Then("click on '$buttonName' button")
    public void clickOnNextButton(String buttonName){
        enrollmentApplicationSteps.clickOnNextButton(buttonName);
    }
}
