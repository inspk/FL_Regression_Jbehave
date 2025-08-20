package com.hhstechgroup.steps.jbehave.scenarios;



import com.hhstechgroup.steps.serenity.peportalpages.MembersSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class MembersScenario {

    @Steps
    MembersSteps membersSteps;




    @Then("member search title is displayed")
    public void searchTitleDisplayed(){
        assertTrue("Member search title is not displayed", membersSteps.isSearchTitlePresent());
    }

    @When("search member by first name '$firstName' and last name '$lastName'")
    public void searchMember(String firstName, String lastName){
        membersSteps.searchMember(firstName, lastName);
    }
    @When("search member by '$field' field with value - '$fieldValue'")
    public void searchField(String searchField, String searchFieldValue){
        membersSteps.searchMemberByField(searchField, searchFieldValue);
    }
    @Then("next member should be displayed with next information : $table")
    public void checkMembersDetails(ExamplesTable table) {
        assertReflectionEquals(table.getRows(), membersSteps.getMemberDetailsInfo());
    }
    @Then("member record with next ID '$memberId' should be present")
    public void searchMemberById(String memberId){
        assertTrue( "Member record is not displayed",membersSteps.isMemberRecordPresent(memberId));
    }
    @Then("members search results should not be found")
    public void checkMemberDataNotFound() {
        assertTrue(membersSteps.checkMemberSearchResultsNotFound());
    }

    @When("navigate to member details")
    public void goToProviderDetails(){
        membersSteps.goToMemberDetails();
    }

    @When("click on member with '$memberId'")
    public void clickMemberDetails(String memberId){
        membersSteps.memberDetailsById(memberId);
    }

    @When("click request access on member record with '$memberId'")
    public void clickRequestAccess(String memberId) {
        membersSteps.clickRequestAccessByMemberId(memberId);
    }

    @Then("main information about member is displayed: $table")
    public void checkMemberMainInfo(ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), membersSteps.getMemberMainInfo());
    }

    @When("{expand|hide} contact information")
    public void expandContactInfo(){
        membersSteps.clickOnContactInfo();
    }

    @Then("contact information is present: $table")
    public void checkAccordionInfo(ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), membersSteps.getContactInfo());
    }

    @Then("'vital signs block' should be present with next information: $table")
    public void checkSignInfo(ExamplesTable table) {
        assertReflectionEquals(table.getRows(), membersSteps.getVitalSigns());
    }

    @Then("verify tab '$tab' is active")
    public void verifyTabActive(String tabName){
        assertTrue("Tab is not active.", membersSteps.isTabActive(tabName));
    }

    @When("expand history for sign '$sign'")
    public void expandSignHistory(String sign){
        membersSteps.expandSignHistory(sign);
    }

    @When("hide history for sign '$sign'")
    public void hideSignHistory(String sign){
        membersSteps.hideSignHistory(sign);
    }

    @Then("verify section '$sectionName' is displayed")
    public void verifySectionDisplayed(String sectionName){
        assertTrue("Section title is not displayed", membersSteps.isSectionDisplayed(sectionName));
    }

    @When("navigate to tab '$tab' Members page")
    public void navigateToTab(String tabName){
        membersSteps.navigateToTab(tabName);
    }

    @When("expand '$section' row - '$row'")
    public void expandPccmRow(String section, String row) {
        membersSteps.clickOnSectionRow(section, row);
    }

    @Then("verify '$sectionName' section is visible")
    public void isConditionsSectionVisible(String sectionName){
        assertTrue("Section is not visible or title is incorrect", membersSteps.isSectionVisible(sectionName));
    }

    @Then("condition table should have next information: $table")
    @Alias("medications table should have next information: $table")
    public void checkConditions(ExamplesTable table) {
        assertReflectionEquals(table.getRows(), membersSteps.getActualInfo());
    }

    @Then("next information on Allergies and Immunizations should be present: $table")
    public void checkReceiverData(ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), membersSteps.getAllergiesAndImmunizations());
    }

    @Then("'$section' section with '$list' list sohuld be present on PCCM tab on Member details page")
    public void checkSection(String section, String listName) {
        assertTrue(membersSteps.isPccmSectionWithListPresent(section, listName));
    }

    @Then("'$pccmList' should have next rows on PCCM tab on Member details page: $table")
    public void checkPccmRows(String listName, ExamplesTable table) {
        assertReflectionEquals(table.getRows(), membersSteps.getPccmRowsList(listName));
    }

    @Then("expanded '$section' row should have next information: $table")
    public void checkExpandedRow(String section, ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), membersSteps.getExpandedPccmRowInformation(section));
    }

    @Then("Member details section should have next information on PCCM tab on Member details page: $table")
    public void checkPccmMemberDetails(ExamplesTable table) {
        assertReflectionEquals(table.getRow(0), membersSteps.getPccmMemberDetails());
    }

    @When("generate CCD file from '$memberFilePath' and save it to '$memberFilePath2'")
    public void saveResponseFile(String filePath, String writePath) throws IOException {
        membersSteps.saveFile(filePath, writePath);
    }

    @When("generate CCD files from folder '$filePath' and save it to '$writePath'")
    public void saveFileFromFolder(String filePath, String writePath) throws IOException {
        membersSteps.saveFilesFromFolder(filePath, writePath);
    }

   //duplicity

    @Then("collect and compare duplicity info for '$index'")
    public void collectAndCompareDuplicityInfo(String index) {
        membersSteps.compareDuplicityInfo(index);
    }

    @Then("collect and compare duplicity percentage '$percantage' info for '$index'")
    public void collectAndCompareDuplicityInfo(String percentage, String index) {
        membersSteps.testPercentageOfDuplicity(percentage,index) ;
    }


}
