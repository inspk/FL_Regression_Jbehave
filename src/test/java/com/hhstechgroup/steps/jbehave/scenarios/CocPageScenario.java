package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.enrollment.EnrollmentCocSteps;
import com.hhstechgroup.steps.serenity.peportalpages.CocSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.core.Is;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class CocPageScenario {

    @Steps
    CocSteps cocSteps;

    @Steps
    EnrollmentCocSteps enrollmentCocSteps;


    @When("click on Change request button on Coc page")
    public void clickAddChangeRequest() {
        cocSteps.clickAddChangeRequest();
    }

    @When("click on Revalidate button on Coc page")
    public void clickRevalidateButton() {
        cocSteps.clickRevalidateButton();
    }

    @When("click on Go to Change of Circumstance button")
    public void clickOnGoToCoc() {
        cocSteps.clickGoToCoc();
    }

    @When("select next Change of Circumstance categories: $table")
    public void selectCategories(ExamplesTable table) {
        cocSteps.selectCategories(ExamplesTableUtil.parseTableColumnAsList(table, 0));
    }


    @When("create Change of Circumstance request for next categories: $table")
    public void createCoc(ExamplesTable table) {
        selectCategories(table);
        clickCreateCoc();
    }

    //latest
    @When("click Create CoC  for group button  on categories modal window")
    public void clickCreateCocforGroup() {
        cocSteps.clickCreateCocGroup();
    }

    //latest
    @When("create Change of Circumstance request for group next categories: $table")
    public void createCocforGroup(ExamplesTable table) {
        selectCategories(table);
        clickCreateCocforGroup();
    }

    //latest
    @When("create Change of Circumstance for default upload document category")
    public void createCocforUploadDocument() {
        cocSteps.clickCreateCocGroup();
    }


    @When("create Change of Circumstance request for next category - '$category'")
    public void createCocForCategory(String category) {
        cocSteps.selectCategory(category);
        clickCreateCoc();
    }

    @When("click Create CoC button on categories modal window")
    public void clickCreateCoc() {
        cocSteps.clickCreateCocButton();
    }

    @When("click on Coc request with value '$value'")
    public void clickOnCocWithValue(String value) {
        cocSteps.clickOnRequestWithValue(value);
    }

    @When("click Back to Change of Circumstances")
    public void clickBackToCoc() {
        cocSteps.clickBackToCoC();
    }

    @Then("next Individual provider enrollment information should be displayed on CoC page: $table")
    @Alias("next general CoC information should be displayed: $table")
    public void checkProviderInfo(ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), cocSteps.getProviderInformation());
    }

    @Then("Change of Circumstance application should be opened with next sections: $table")
    public void checkSections(ExamplesTable table) {
        List<String> expectedSections = ExamplesTableUtil.parseTableColumnAsList(table, 0);
        assertReflectionEquals(expectedSections, cocSteps.getSections());
    }

    @Then("next requests should be displayed in Change of Circumstance requests history: $table")
    public void checkCocRequest(ExamplesTable table) {
        assertReflectionEquals(table.getRows(), cocSteps.getCocRequests());
    }

    @Then("$section Coc section should be displayed with fields: $table")
    public void checkSectionFields(String section, ExamplesTable table) {
        assertEquals(section, cocSteps.getSectionHeader());
        assertTrue(cocSteps.areFieldsPresent(ExamplesTableUtil.parseTableColumnAsList(table, 0)));
    }

    @Then("error '$error' should appear on Coc page")
    public void isErrorDisplayed() {
        //Should be implemented after PRMG-2285
    }

    @When("continue CoC with request id '$id'")
    public void continueCoC(String id){
        cocSteps.continueCoCWithId(id);
    }

    @When("select affiliation type in coc pop-up")
    public void selectAffiliationType(){
        cocSteps.selectAffiliationType();
    }

    @When("select enrollment data type in coc pop-up")
    public void selectEnrollmentDataType(){
        cocSteps.selectEnrollmentDataType();
    }

    @When("select taxonomy data type in coc pop-up")
    public void selectTaxonomyDataType(){
        cocSteps.selectTaxonomyDataType();
    }

    @When("select add affiliation data type in i-coc popup")
    public void selectAddAffiliationDataType(){
        cocSteps.selectAddAffiliationDataType();
    }

    @When("click next button in select coc type pop-up")
    public void clickNextButtonInSelectTypePopUp(){
        cocSteps.clickNextButtonInSelectTypePopUp();
    }

    @When("click create button in select coc type pop-up")
    public void clickCreateButtonInSelectTypePopUp(){
        cocSteps.clickCreateButtonInSelectTypePopUp();
    }

    @When("click on expand icon in coc details for coc with id '$id'")
    public void clickOnExpandButtonForCocWithId(String id) {
        cocSteps.clickOnExpandButtonForCocWithId(id);
    }

    //newly added
    @Then("Validating coc details: $table")
    public void checkCocValuesForRecordWithNumber(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(enrollmentCocSteps.getMappedCocValuesForRecord(), Is.is(expectedInfo));
    }

    @Then("Validating coc details with denied status: $table")
    public void checkCocValuesForRecordWithNumber1(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(enrollmentCocSteps.getMappedCocValuesForRecord1(), Is.is(expectedInfo));
    }


    //sp22

    @When("create Change of Circumstance request for next category: $table")
    public void createCocOwn(ExamplesTable table) {
        selectCategories(table);
        clickCreateCocButtonOwn();
    }


    @When("click Create CoC button on categories modal window in own")
    public void clickCreateCocButtonOwn() {
        cocSteps.clickCreateCocButtonOwn();
    }

    @When("create Group Change of Circumstance request for next category: $table")
    public void createGroupCocOwn(ExamplesTable table) {
        selectCategories(table);
        clickGroupCreateCocButtonOwn();
    }

    @When("click Create group CoC button on categories modal window in own")
    public void clickGroupCreateCocButtonOwn() {
        cocSteps.clickGroupCreateCocButtonOwn();
    }

    @Then("verify the Coc Pop ownership notification '$cocpopup' is displaying")
    public boolean isCocPopUp(String cocPopUp) {
        return cocSteps.isCocPopUp(cocPopUp);
    }

    @Then("click on Ok button in the coc page")
    public void clickOKButton() {cocSteps.clickOKButton();}

    //sp23

     @When("click on menu icon in the coc page")
     public void clickOnCocMenuIcon(){cocSteps.clickOnCocMenuIcon();}

     @When("Verifying in coc page button '$end' is displaying")
     public void isVerifyingEndButtonInCocDisplaying(String end){
         System.out.println("Verifying in Coc Page : " + end + " Button is Displaying");
         assertTrue(cocSteps.isVerifyingEndButtonInCocDisplaying(end));
     }

     @When("click on '$cocend' buttion in coc page")
     public void clickOnCocEndButton(String cocend){cocSteps.clickOnCocEndButton(cocend);}

     @When("Verifying in coc page '$endAffiliation' pop up displaying")
    public void isVerifyingCocEndAffiliationPopUpDisplaying(String endAffilation){
         System.out.println("Verifying in Coc Page : " + endAffilation + " Pop Up is Displaying");
         assertTrue(cocSteps.isVerifyingCocEndAffiliationPopUpDisplaying(endAffilation));
    }

    @When("select reason '$reason' and note '$note' in End Affilation Pop up")
    public void selectReasonCodeForEndCoc(String reason,String note) {cocSteps.selectReasonCodeForEndCoc(reason,note);}

    //sp23

    @When("Verifying the Button '$button' is Displaying")
    public void checkButton(String button) {
        assertTrue(cocSteps.checkButton(button));

    }

    //sp24

    @Then("verifying password popup message '$cocpopup' is displaying")
    public boolean isCocPopUp1(String cocPopUp) {
        return cocSteps.isCocPopUp(cocPopUp);
    }


    //sp26

    @When("click Create CoC  for for categories modal window")
    public void clickCreateCocforGroup1() {
        cocSteps.clickCreateCocGroup1();
    }

    @When("create COC request for group next categories: $table")
    public void createCocforGroup1(ExamplesTable table) {
        selectCategories(table);
        clickCreateCocforGroup1();
    }

    //sp30 PEM coc

    @When("create Change of Circumstance request for pem next categories: $table")
    public void createCocforPem(ExamplesTable table) {
        selectCategories(table);
        clickCreateCocforGroup();
    }

    //sp33

    @When("select affliation type '$type'")
    public void selectType(String type) {cocSteps.selectType(type);}

    @When("select add affiliation type in coc pop-up")
    public void selectAddAffiliationType(){
        cocSteps.selectAddAffiliationType();
    }


    @When("select end affiliation type in coc pop-up")
    public void selectEndAffiliationType(){
        cocSteps.selectEndAffiliationType();
    }

    @Then("validate the Coc Types as below in Coc page:$table")
    public void verifyCocTypes(ExamplesTable table) {
        assertEquals(ExamplesTableUtil.parseTableColumnAsList(table, 0), cocSteps.getCocTypes());
    }

    @When("select Program Participation / Taxonomy / License and Service location type in coc pop-up")
    public void selectProgramParticipationTaxonomyType(){
        cocSteps.selectProgramParticipationTaxonomyType();
    }

    @When("select edit affiliation type in coc pop-up")
    public void selectEditAffiliationType(){
        cocSteps.selectEditAffiliationType();
    }

    @When("expand '$text' service location in coc affiliation section")
    public void expandServiceLocation(String text) {
        cocSteps.expandAffiliation(text);
    }

    @When("click Edit service location in coc affiliation section")
    public void clickEditServiceLocation() {
        cocSteps.clickEditServiceLocationButton();
    }

    @When("click Add service location in coc affiliation section")
    public void clickAddServiceLocation() {
        cocSteps.clickAddServiceLocation();
    }

    @When("select '$mannerOfService' Manner of Sevice in coc affiliation section")
    public void setMannerOfService(String mannerOfService){
        cocSteps.setMannerOfService(mannerOfService);
    }

    @When("update service location in coc affiliation section")
    public void updateServiceLocation() {
        cocSteps.clickUpdateServiceLocation();
    }

    @When("click on 'Add I Coc'")
    public void clickAddICoc() {
        cocSteps.clickAddICoc();
    }

    @When("set provider name '$providername' in i-Coc popup")
    public void setProvidername(String providername) {
        cocSteps.fillAddICocProvidername(providername);
    }

    @When("set enrollment type '$enrollmentType' in i-Coc popup")
    public void selectEnrollmentType(String enrollmentType) {
        cocSteps.selectEnrollmentType(enrollmentType);
    }

    @When("set providerid '$providerid' in I-COC popup")
    public void searchproviderID(String providerid){
        cocSteps.searchproviderID(providerid);
    }

    @When("click search in I-Coc popup")
    public void clickSearchIcoc() {
        cocSteps.searchICOC();
    }

    @When("select provider in i-Coc popup")
    public void selectProvider() {
        cocSteps.selectProvider();
    }

    @When("click next in i-Coc popup")
    public void clickNext() {
        cocSteps.clickNext();
    }


    @Then("verify iCoC Popup Message '$message'")
    public void getPpIcocMessage(String message) {
        Assert.assertEquals(message, cocSteps.getPpIcocMessage());
        cocSteps.clickPopupOk();
    }

    @Then("click on ellipsis and End Affiliation for '$affiliationType' with reason '$reason'")
    public void endAffiliation(String affiliationType, String reason) {
        cocSteps.endAffiliation(affiliationType,reason);
    }

    @Then("verify the text for Approved taxonomy '$expectedText' and select '$option' option")
    public void verifyApprovedTaxonomyTextAndSelectOption(String expectedText, String option) {
        cocSteps.verifyApprovedTaxonomyTextAndSelectOption(expectedText, option);
    }
    @Then("verify Provider Name '$name' and Affiliation Type '$affiliationType' in Affiliation Tab")
    public void verifyActiveAffiliationProviderNameAndType(String name,String affiliationType){
        cocSteps.verifyActiveAffiliationProviderNameAndType(name,affiliationType);
    }
    @Then("click on '$text' in Affilaition tab")
    public void clickOnShowEndedAffiliation(String text){
        cocSteps.clickOnShowEndedAffiliation(text);
    }

    @Then("verify the status of the request should be '$status'")
    public void verifyTheStatus(String status){
        assertTrue("Expected status '" + status + "' not found within time limit.",
                cocSteps.verifyStatusWithRetry(status));
    }


}
