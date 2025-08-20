package com.hhstechgroup.steps.serenity.providerData;
import com.hhstechgroup.beans.ProviderDataSearchResultBean;
import com.hhstechgroup.ui.pages.iuportal.ViewRequestPage;
import com.hhstechgroup.ui.pages.providerData.ProviderDataPage;
import com.hhstechgroup.ui.pages.providerData.ProviderDataSearchPage;
import com.hhstechgroup.ui.panels.iuportal.ProviderDataSearchPanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import java.util.List;
import java.util.Map;


public class ProviderDataSteps extends ScenarioSteps {

    private static final String PROVIDERS_DATA_COLLECTION = "providersData";

    ProviderDataPage providerDataPage;
    ProviderDataSearchPage providerDataSearchPage;
    ViewRequestPage viewRequestPage;

    @Step
    public Map<String, String> getProviderInformation() {
        return providerDataPage.getProviderInformation().getMappedValues();
    }

    @Step
    public Map<String, String> getProviderInformationOnIUPortal() {
        return providerDataPage.getProviderInformationOnIuPortal().getMappedValuesOnIuPortal();
    }
    //new
    @Step
    public List<Map<String, String>> getResults() {
        return providerDataPage.getProviderResultsPanel().getResults();
    }

    @Step
    public List<Map<String, String>> getSummaryRequests(String type) {
        return providerDataPage.getSummaryRequests(type);
    }

    @Step
    public List<Map<String, String>> getProviderDataHistoryList() {
        return providerDataPage.getProviderDataHistoryPanel().getProviderDataHistoryList();
    }

    @Step
    public void clickToTabWithName(String tabName) {
        providerDataPage.clickTabWithName(tabName);
    }

    @Step
    public boolean checkProviderNameOnProviderDetails(String providerName) {
        return providerDataPage.checkProviderNameOnProviderDetails(providerName);
    }

    @Step
    public boolean checkProviderNameStatusOnProviderDetailsIU(String providerName, String providerStatus) {
        return providerDataPage.checkProviderNameStatusOnProviderDetailsIU(providerName, providerStatus);
    }

    @Step
    public void clickViewDetailsForRowWithText (String text) {
        providerDataSearchPage.getProviderDataSearchResultsPanel().clickProviderDataRowWithText(text);
    }

    @Step
    public Map<String, String> getViewDetailsRowInfo() {
        return providerDataPage.getProviderDataHistoryPanel().getViewDetailsRowInfo();
    }

    @Step
    public void setProviderDataSearchCriteriaAndClickSearch(ProviderDataSearchResultBean criteria) {
        ProviderDataSearchPanel panel = providerDataSearchPage.getProviderDataSearchPanel();
        BeanUtils.copyPropertiesInOrder(panel, criteria);
        providerDataSearchPage.getProviderDataSearchPanel().clickSearch();
    }


    @Step
    public void resetFiltersOnProviderSearch() {
        providerDataSearchPage.getProviderDataSearchPanel().clickResetFilters();
    }

    @Step
    public List<Map<String, String>> getProviderDataSearchResults() {
        return providerDataSearchPage.getProviderDataSearchResultsPanel().getProviderDataSearchResults();
    }

    @Step
    public boolean checkProviderSearchResultsNotFound() {
        return providerDataSearchPage.checkResultsNotFoundTextPresent();
    }

    @Step
    public Map<String, String> getRevalidationDetails() {
        return providerDataPage.getRevalidationPanel().getMappedValues();
    }

    @Step
    public List<Map<String, String>> getExpandedRevalidationDetails() {
        return providerDataPage.getRevalidationPanel().getExpandedDetails();
    }

    @Step
    public void clickOnViewRevalidationDetails() {
        providerDataPage.getRevalidationPanel().clickViewDetails();
    }

    @Step
    public void clickOnViewRevalidationHistory() {
        providerDataPage.getRevalidationPanel().clickViewHistory();
    }

    @Step
    public void clickViewHistoryByType(String enrollmentType) {
        providerDataPage.getProviderDataHistoryPanel().clickViewDetails(enrollmentType);
    }

    @Step
    public Map<String, String> getMappedTimelineValuesForRecord(String record) {
        return providerDataPage.getproviderTimelinePanel().getMappedTimelineValuesForRecord(record);
    }

    @Step
    public void clickOnRequestLinkInTimeline(String record) {
        providerDataPage.getproviderTimelinePanel().clickOnRequestLinkInTimeline(record);
    }
    @Step
    public void clickOnTimelineRecordWithNumber(String record) {
        providerDataPage.getproviderTimelinePanel().clickOnTimelineRecordWithNumber(record);
    }

    @Step
    public void clickReactivation () {
        providerDataPage.clickOnReactivationButton();
    }
    @Step
    public void setReasonForReactivation(String reason) {
        viewRequestPage.getReactivationPopup().setReason(reason);
    }

    @Step
    public void clickReactivateButtonInPopup() {
        viewRequestPage.getReactivationPopup().clickReactivate();
    }

    @Step
    public boolean isReactivateButtonAbsent () {
        return providerDataPage.isReactivateAbsent();
    }

    //latest
    @Step
    public boolean isDulpicateNPIMessagedisplaying(String npi) {return providerDataPage.isDulpicateNPIMessagedisplaying(npi);}

    @Step
    public boolean isDataChangeNotificationdisplaying(String notification) {
        return providerDataPage.isDataChangeNotificationdisplaying(notification);
    }

    @Step
    public void clickOnBackToTPPortalButton (){providerDataPage.clickOnBackToTPPortalButton();}

    @Step
    public boolean isPEDataChangeNotificationdisplaying(String penotification) {
        return   providerDataPage.isPEDataChangeNotificationdisplaying(penotification);}

    @Step
    public Map<String, String> getExpandedRowInfo() {
        return providerDataPage.getProviderResultsPanel().getExpandedRowInfo();
    }


    @Step
    public boolean checkStatus(String status) {return providerDataPage.checkStatus(status);}
    @Step
    public boolean checkProviderStatus(String providerStatus){
        return providerDataPage.checkProviderStatus(providerStatus);
    }
    @Step
    public boolean checkSectionName(String sectionName){
        return providerDataPage.checkSectionName(sectionName);
    }

    @Step
    public void checkScreeningDocument(String screeningDoc){
        providerDataPage.checkScreeningDocument(screeningDoc);
    }

    @Step
    public boolean checkCOCButton(String cocButton){
        return providerDataPage.checkCOCButton(cocButton);
    }
    @Step
    public boolean checkTpStatus(String status) {return providerDataPage.checkTpStatus(status);}

    //sp23

    @Step
    public void clickOnSearchIcon(){
        providerDataSearchPage.clickOnSearchIcon();
    }

    @Step
    public void selectEndAffiliationCheckboxAndSearch(String checkbox){
        providerDataSearchPage.selectEndAffiliationCheckboxAndSearch(checkbox);
    }
    @Step
    public void selectShowEndedAffiliationCheckboxAndSearch(String checkbox){
        providerDataSearchPage.selectShowEndedAffiliationCheckboxAndSearch(checkbox);
    }
    @Step
    public void clickOnSearch(){
        providerDataSearchPage.clickOnSearch();
    }
    @Step
    public void clickReconsiderationTypeAndSelectTypeAndSearch(String reconsiderationType){
        providerDataPage.clickReconsiderationTypeAndSelectTypeAndSearch(reconsiderationType);
    }


    @Step
    public boolean verifySiteVisitFaqAnswer(String answer){
        return providerDataPage.verifySiteVisitFaqAnswer(answer);
    }
    @Step
    public void checkSearchResult(){
        providerDataSearchPage.checkSearchResult();
    }
    @Step
    public void fetchPESID(){
        providerDataSearchPage.fetchPESID();
    }

    @Step
    public void clickOnEnrollmentType(String enrollmentType){
        providerDataSearchPage.clickOnEnrollmentType(enrollmentType);
    }
    @Step
    public void clickonpemenrollmenttype(){
        providerDataSearchPage.clickonpemenrollmenttype1();
    }

    @Step
    public void editField(String fieldName,String changedata) {providerDataPage.editField(fieldName,changedata);}

    // sp30 pem status
    @Step
    public boolean checkPemStatus(String status) {return providerDataPage.checkPemStatus(status);}

    //WY-65
    @Step
    public void clickViewDetailsForRowWithText1(String text) {
        providerDataSearchPage.getProviderDataSearchResultsPanel().clickProviderDataRowWithText1(text);
    }

    @Step
    public void verifyStyleColor(String color){
        providerDataSearchPage.getProviderDataSearchResultsPanel().verifyStyleColor(color);
    }

    @Step
    public boolean isReEnrollmentButtonPresents(){
        return providerDataPage.isReEnrollmentButtonPresents();
    }

    @Step
    public List<String> getScreeningParameters() {
        return providerDataPage.getScreeningParameters();
    }

    @Step
    public void clickPopupOk(){
        providerDataPage.clickPopupOk();
    }

    @Step
    public void clickEditField(String header) {
        providerDataPage.clickEditField(header);
    }

    @Step
    public void setNewDeathDate(String deathDate, String reasonCode){
        providerDataPage.clickEditDeathDate();
        providerDataPage.setDeathDate(deathDate);
        providerDataPage.setReasonCode(reasonCode);
        providerDataPage.clickUpdate();
    }

    @Step
    public void setNewAgentId(String newAgentId, String reasonCode){
        providerDataPage.clickEditAgentId();
        providerDataPage.setTradingPartnerAgentid(newAgentId);
        providerDataPage.setReasonCode(reasonCode);
        providerDataPage.clickUpdate();
    }

    @Step
    public List<String> getMonitoringTabParameters(){
        return providerDataPage.getMonitoringTabParameters();
    }
    @Step
    public void clickMonitoringTab(String tab){
        providerDataPage.clickMonitoringTab(tab);
    }
    @Step
    public List<String> getMonitoringColoumns(){
        return providerDataPage.getMonitoringColoumns();
    }

    @Step
    public String getSitevisitData(String text){
        return providerDataPage.getSitevisitData(text);
    }
    @Step
    public void searchWithProviderIDInProviderTab(){
        providerDataPage.searchWithProviderIDInProviderTab();

    }


    @Step
    public void searchWithTrackingNum(){
        providerDataPage.searchWithTrackingNum();
    }
    @Step
    public void searchWithReconsiderationRequestID(){
        providerDataPage.searchWithReconsiderationRequestID();
    }
    @Step
    public void searchWithCOCIDToApprove(){
        providerDataPage.searchWithCOCIDToApprove();
    }

    @Step
    public void searchWithCOCIDToDeny(){
        providerDataPage.searchWithCOCIDToDeny();
    }
    @Step
    public void searchWithReenrollmentRequestIDToApprove(){
        providerDataPage.searchWithReenrollmentRequestIDToApprove();
    }

    @Step
    public void searchWithReenrollmentRequestIDToDeny(){
        providerDataPage.searchWithReenrollmentRequestIDToDeny();

    }
    @Step
    public void searchWithRevalidationRequestID(){
        providerDataPage.searchWithRevalidationRequestID();
    }

}


