package com.hhstechgroup.steps.serenity.peportalpages;

import com.hhstechgroup.ui.pages.peportal.CocPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import java.util.List;
import java.util.Map;


public class CocSteps extends ScenarioSteps {


    CocPage cocPage;



    @Step
    public Map<String, String> getProviderInformation() {
        return cocPage.getProviderInformation().getMappedValues();
    }

    @Step
    public void clickAddChangeRequest() {
        cocPage.clickChangeRequestButton();
    }

    @Step
    public void clickRevalidateButton() {
        cocPage.clickRevalidateButton();
    }

    @Step
    public List<String> getSections() {
        cocPage.getSection().waitForSectionAppeared();
        return cocPage.getLeftMenuPanel().getSections();
    }

    @Step
    public void clickGoToCoc() {
        cocPage.getSuccessPanel().clickGoToCoc();
    }

    @Step
    public List<Map<String, String>> getCocRequests() {
        return cocPage.getCocRequests();
    }

    @Step
    public void selectCategories(List<String> categories) {
        cocPage.getSelectCategoryModalWindow().selectCategories(categories);
    }

    @Step
    public void selectCategory(String category) {
        cocPage.getSelectCategoryModalWindow().selectCategory(category);
    }

    @Step
    public void clickCreateCocButton() {
        cocPage.getSelectCategoryModalWindow().clickCreateCocButtonOwn();
    }

    @Step
    public void clickOnRequestWithValue(String value) {
        cocPage.clickOnRequestWithValue(value);
    }

    @Step
    public void clickBackToCoC() {
        cocPage.clickBackToSearchResults();
    }

    @Step
    public String getSectionHeader() {
        return cocPage.getSection().getSectionHeader();
    }

    @Step
    public boolean areFieldsPresent(List<String> fields) {
        return cocPage.getSection().areFieldsPresent(fields);
    }

    @Step
    public void continueCoCWithId(String id){
        cocPage.continueCoCWithId(id);
    }

    @Step
    public void selectAffiliationType() {
        cocPage.getSelectCoCTypeModalWindow().selectAffiliationType();
    }

    //latest
    @Step
    public void clickCreateCocGroup() {
        cocPage.getSelectCategoryModalWindow().clickCreateCocGroup();
    }
    @Step
    public void selectEnrollmentDataType() {
        cocPage.getSelectCoCTypeModalWindow().selectEnrollmentDataType();
    }

    public void selectTaxonomyDataType() {
        cocPage.getSelectCoCTypeModalWindow().selectTaxonomyDataType();
    }

    public void selectAddAffiliationDataType(){
        cocPage.getSelectCoCTypeModalWindow().selectAddAffiliationDataType();
    }

    @Step
    public void clickCreateButtonInSelectTypePopUp() {
        cocPage.getSelectCoCTypeModalWindow().clickCreateButtonInSelectTypePopUp();
    }
    @Step
    public void clickNextButtonInSelectTypePopUp() {
        cocPage.getSelectCoCTypeModalWindow().clickNextButtonInSelectTypePopUp();
    }
    @Step
    public void clickOnExpandButtonForCocWithId(String id) {
        cocPage.clickOnExpandButtonForCocWithId(id);
    }

    //sp22

    @Step
    public void clickCreateCocButtonOwn() {
        cocPage.getSelectCategoryModalWindow().clickCreateCocButtonOwn();
    }

    @Step
    public void clickGroupCreateCocButtonOwn() {
        cocPage.getSelectCategoryModalWindow().clickGroupCreateCocButtonOwn();
    }

    public boolean isCocPopUp(String cocPopUp) {
        return cocPage.isCocPopUp(cocPopUp);
    }

    @Step
    public void clickOKButton(){cocPage.clickOKButton();}

    //sp23
    @Step
    public void clickOnCocMenuIcon(){cocPage.clickOnCocMenuIcon();}

    @Step
    public boolean isVerifyingEndButtonInCocDisplaying(String end){return cocPage.isVerifyingEndButtonInCocDisplaying(end);}

    @Step
    public void clickOnCocEndButton(String cocend){cocPage.clickOnCocEndButton(cocend);}

    @Step
    public boolean isVerifyingCocEndAffiliationPopUpDisplaying(String endAffilation){
        return cocPage.isVerifyingCocEndAffiliationPopUpDisplaying(endAffilation);
    }

    @Step
    public void selectReasonCodeForEndCoc(String reason,String note) {cocPage.selectReasonCodeForEndCoc(reason,note);}

    //sp23

    @Step
    public boolean checkButton(String button) {
        return cocPage.checkButton(button);
    }

    //sp26
    @Step
    public void clickCreateCocGroup1() {
        cocPage.getSelectCategoryModalWindow().clickCreateCocGroup1();
    }

    //sp33

    @Step
    public void selectType(String type) {cocPage.selectType(type);}

    @Step
    public void selectAddAffiliationType() {
        cocPage.getSelectCoCTypeModalWindow().selectAddAffiliationType();
    }

    @Step
    public void selectEndAffiliationType() {
        cocPage.getSelectCoCTypeModalWindow().selectEndAffiliationType();
    }

    @Step
    public List<String> getCocTypes() {
        return cocPage.getCocTypes();
    }

    @Step
    public void selectProgramParticipationTaxonomyType() {
        cocPage.getSelectCoCTypeModalWindow().selectProgramParticipationTaxonomyType();
    }

    @Step
    public void selectEditAffiliationType() {
        cocPage.getSelectCoCTypeModalWindow().selectEditAffiliationType();
    }

    @Step
    public void expandAffiliation(String type) {
        cocPage.expandAffiliation(type);
    }

    @Step
    public void clickEditServiceLocationButton() {
        cocPage.clickEditServiceLocationButton();
    }

    @Step
    public void clickAddServiceLocation() {
        cocPage.clickAddServiceLocationButton();
    }

    @Step
    public void setMannerOfService(String mannerOfService){
        cocPage.setMannerOfService(mannerOfService);
    }

    @Step
    public void clickUpdateServiceLocation() {
        cocPage.clickUpdateServiceLocation();
    }


    @Step
    public void clickAddICoc() {
        cocPage.clickAddICoc();
    }

    @Step
    public void selectEnrollmentType(String enrollmentType){
        cocPage.getAddICoC().selectEnrollmentType(enrollmentType);
    }

     public void searchproviderID(String providerid){
        cocPage.getAddICoC().searchproviderID(providerid);
     }

    @Step
    public void searchICOC(){
        cocPage.getAddICoC().clickSearchICoc();
    }

    @Step
    public void fillAddICocProvidername(String providername) {
        cocPage.getAddICoC().fillProviderName(providername);
    }

    @Step
    public void selectProvider() {
        cocPage.getAddICoC().selectProvider();
    }
    @Step
    public void clickNext() {
        cocPage.getAddICoC().clickNext();
    }

    @Step
    public String getPpIcocMessage(){
        return cocPage.getPpIcocMessage();
    }

    @Step
    public void clickPopupOk(){
        cocPage.clickPopupOk();
    }

    @Step
    public void endAffiliation(String affiliationType, String reason){
        cocPage.endAffiliation(affiliationType,reason);
    }

    @Step
    public void verifyApprovedTaxonomyTextAndSelectOption(String expectedText,String option){
        cocPage.verifyApprovedTaxonomyTextAndSelectOption(expectedText, option);
    }
    @Step
    public void verifyActiveAffiliationProviderNameAndType(String name,String affiliationType){
        cocPage.verifyActiveAffiliationProviderNameAndType(name, affiliationType);
    }
    @Step
    public void clickOnShowEndedAffiliation(String text){
        cocPage.clickOnShowEndedAffiliation(text);
    }

    @Step
    public boolean verifyStatusWithRetry(String status){
        return cocPage.verifyStatusWithRetry(status, 60); }

}
