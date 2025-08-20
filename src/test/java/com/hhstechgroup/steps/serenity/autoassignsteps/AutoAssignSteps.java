package com.hhstechgroup.steps.serenity.autoassignsteps;

import com.hhstechgroup.ui.pages.autoassign.AutoAssignRulePage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.Map;

public class AutoAssignSteps {

    @Page
    AutoAssignRulePage autoAssignRulePage;

    @Step
    public void clickOnCreateRuleButton() {
        autoAssignRulePage.clickOnCreateRuleButton();
    }

    @Step
    public void fillRuleName(String ruleName) {
        autoAssignRulePage.fillRuleName(ruleName);
    }

    @Step
    public void clickOnAddConditionLink() {
        autoAssignRulePage.clickOnAddConditionLink();
    }

    @Step
    public void clickOnDropdown() {
        autoAssignRulePage.clickOnDropdown();
    }

    @Step
    public void setParameter(String dropdown, String parameter) {
        autoAssignRulePage.setParameter(dropdown, parameter);
    }

    @Step
    public void setsecondParameter(String dropdown2, String parameter2) {
        autoAssignRulePage.setsecondParameter(dropdown2, parameter2);
    }
  //sp22
   @Step
   public void setDocumentReviewParameter(String dropdown3, String parameter3) {
      autoAssignRulePage.setDocumentReviewParameter(dropdown3, parameter3);
   }
   @Step
    public void selectCondtions(String condition) {
        autoAssignRulePage.selectCondtions(condition);
    }

    @Step
    public void clickOnSaveOrCancelButton(String saveOrCancel) {
        autoAssignRulePage.clickOnSaveOrCancelButton(saveOrCancel);
    }

    @Step
    public void seachByRuleName(String ruleName) {
        autoAssignRulePage.seachByRuleName(ruleName);
    }

    @Step
    public void selectRemoveOption(String action) {
        autoAssignRulePage.selectRemoveOption(action);
    }

    @Step
    public void removeRuleFromRuleList() {
        autoAssignRulePage.removeRuleFromRuleList();
    }

    @Step
    public void fillEffecteDates(String dateFrom, String dateEnd) {
        autoAssignRulePage.fillEffecteDates(dateFrom, dateEnd);
    }

    @Step
    public void fillValue(String parameter, String name, String value) {
        autoAssignRulePage.fillValue(parameter,name,value);
    }

    @Step
    public void typeProviderName(String providerName){autoAssignRulePage.typeProviderName(providerName);}

    @Step
    public void setConditon(String condition) {autoAssignRulePage.setConditon(condition);}

    //sp23
    @Step
    public Map<String, String> getMappedDateValues() {
        return autoAssignRulePage.getAutoAssignPanel().getMappedDateValues();
    }
//sp24
    @Step
    public void clickRuleFromRuleList(){
        autoAssignRulePage.clickRuleFromRuleList();
    }

    @Step
    public  void clickOnBckToList(String button) {
    autoAssignRulePage.clickOnBckToList(button);
    }

    @Step
    public boolean verifyViewHistorytButton(){
        return autoAssignRulePage.verifyViewHistorytButton();
    }

    @Step
    public void clickVeiwHistoryButton(){
        autoAssignRulePage.clickVeiwHistoryButton();
    }

    @Step
    public void clickEffectiveDates() {
        autoAssignRulePage.clickEffectiveDates();
    }

    @Step
    public void clickBackToHistoryRecords(String button) {
    autoAssignRulePage.clickBackToHistoryRecords(button);
    }

    @Step
    public void clickEditButton(){
        autoAssignRulePage.clickEditButton();
    }

    @Step
    public void clickExitButton(String exit) {
        autoAssignRulePage.clickExitButton(exit);
    }

    @Step
    public Map<String, String> getMappedEffectiveDateValues() {
        return autoAssignRulePage.getViewhistoryPanel().getMappedEffectiveDateValues();
    }

    @Step
    public Map<String, String> getMappedUpdatedDateValues() {
        return autoAssignRulePage.getViewhistoryPanel().getMappedUpdatedDateValues();
    }
    //sp37
    @Step
    public void typerisklevelvalue(String value) {
        autoAssignRulePage.typerisklevelvalue(value);
    }
    @Step
    public void setstatusParameter(String dropdown3, String parameter3) {
        autoAssignRulePage.setstatusParameter(dropdown3, parameter3);
    }

    //in SP-73 Adding click for new rules section
    @Step
    public void clickOnRules(String action){
        autoAssignRulePage.clickOnRules(action);
    }

    @Step
    public void setActionParameter(String dropdown, String parameter) {
        autoAssignRulePage.setActionParameter(dropdown, parameter);
    }

}

