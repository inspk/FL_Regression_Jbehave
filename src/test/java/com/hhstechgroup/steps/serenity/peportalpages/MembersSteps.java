package com.hhstechgroup.steps.serenity.peportalpages;


import com.hhstechgroup.ui.pages.peportal.MembersPage;
import com.hhstechgroup.util.common.FileUtils;
import com.hhstechgroup.util.converters.StringConverter;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MembersSteps extends ScenarioSteps{

    MembersPage membersPage;

    @Step
    public boolean isSearchTitlePresent(){
        return membersPage.searchTitleIsDisplayed();
    }

    @Step
    public void searchMember(String firstName, String lastName){
        membersPage.typeMemberFirstName(firstName);
        membersPage.typeMemberLastName(lastName);
        membersPage.clickSearchButton();
    }
    @Step
    public void searchMemberByField(String searchField,String fieldValue){
        membersPage.getSearchPanel().setMemberSearchField(searchField, fieldValue);
        membersPage.getSearchPanel().clickSearch();
    }
    @Step
    public List<Map<String, String>>  getMemberDetailsInfo() {
        return membersPage.getMemberDetailsInfo();
    }
    @Step
    public boolean isMemberRecordPresent(String memberId){
        return membersPage.isMemberPresent(memberId);
    }
    @Step
    public boolean checkMemberSearchResultsNotFound() {
        return membersPage.checkResultsNotFoundTextPresent();
    }

    @Step
    public void goToMemberDetails(){
        membersPage.goToMemberDetails();
    }

    @Step
    public void memberDetailsById(String memberId){
        membersPage.clickOnMemberWithId(memberId);
    }
    @Step
    public void clickRequestAccessByMemberId (String memberId) {
        membersPage.clickOnRequestAccessWithMemberId(memberId);
    }

    @Step
    public Map<String, String> getMemberMainInfo() {
        return membersPage.getMemberMainInfo();
    }

    @Step
    public void clickOnContactInfo(){
        membersPage.clickContactInfo();
    }

    @Step
    public Map<String, String> getContactInfo() {
        return membersPage.getContactInfo();
    }

    @Step
    public List<Map<String, String>> getVitalSigns() {
        return membersPage.getVitalSigns();
    }

    @Step
    public boolean isTabActive(String tabName){
        return membersPage.isTabActive(tabName);
    }

    @Step
    public void expandSignHistory(String sign){
        membersPage.expandHistoryForSign(sign);
    }

    @Step
    public void hideSignHistory(String sign){
        membersPage.hideHistoryForSign(sign);
    }

    @Step
    public boolean isSectionDisplayed(String sectionName){
        return membersPage.isSectionDisplayed(sectionName);
    }

    @Step
    public void navigateToTab(String tabName){
        membersPage.navigateToTab(tabName);
    }

    @Step
    public boolean isSectionVisible(String sectionName){
        return membersPage.isSectionVisible(sectionName);
    }

    @Step
    public List<Map<String, String>> getActualInfo() {
        return membersPage.getActualInfo();
    }

    @Step
    public Map<String, String> getAllergiesAndImmunizations() {
        return membersPage.getAllergiesAndImmunizations();
    }

    @Step
    public boolean isPccmSectionWithListPresent(String sectionName, String listName) {
        return membersPage.isPccmSectionDisplayed(sectionName, listName);
    }

    @Step
    public List<Map<String, String>> getPccmRowsList(String listName) {
        return membersPage.getPccmRowsList(listName);
    }

    @Step
    public void clickOnSectionRow(String section, String rowValue) {
        membersPage.clickOnPccmRow(section, rowValue);
    }

    @Step
    public Map<String, String> getExpandedPccmRowInformation(String section) {
        return membersPage.getExpandedPccmRowInformation(section);
    }

    @Step
    public Map<String, String> getPccmMemberDetails() {
        return membersPage.getPccmMemberDetails();
    }

    @Step
    public void saveFile (String filePath, String writePath) throws IOException {
        String changedText = StringConverter.convertString(FileUtils.fileToString(filePath));
        InputStream in = IOUtils.toInputStream(changedText, "UTF-8");
        FileUtils.writeZIP(in, writePath);
    }

    @Step
    public void saveFilesFromFolder (String membersFolder, String writePath) throws IOException {
        List<String> folderList = FileUtils.getFolderFiles(membersFolder);
        for(int fileIndex = 0; fileIndex < folderList.size(); fileIndex++) {
            String filePath = membersFolder + "/" + folderList.get(fileIndex);
            String changedText = StringConverter.convertString(FileUtils.readFileFromResources(filePath));
            InputStream in = IOUtils.toInputStream(changedText, "UTF-8");
            String generatedWritePath = writePath + folderList.get(fileIndex);
            FileUtils.writeZIP(in, generatedWritePath);
        }

    }

    //duplicity

    @Step
    public void compareDuplicityInfo(String index) {
        membersPage.collectAndCompareDuplicityInfo(index);
    }

    @Step
    public void testPercentageOfDuplicity(String percentage, String index) {
        membersPage.verifyPercentageOfDuplicity(percentage,index);
    }
}
