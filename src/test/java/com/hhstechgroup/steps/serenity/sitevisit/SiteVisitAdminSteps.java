package com.hhstechgroup.steps.serenity.sitevisit;

import com.hhstechgroup.ui.pages.sitevisit.SiteVisitAdminPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.Map;

public class SiteVisitAdminSteps {
    @Page
    SiteVisitAdminPage sitevisitadminpage;


   /* @Step
    public void setSearchCriteria(AuditEventsSearchBean criteria) {
        AuditSearchPanel panel = auditPage.getSearchPanel();

        BeanUtils.copyPropertiesInOrder(panel, criteria);
    }*/


    @Step
    public void clickOnSiteVisit(){ sitevisitadminpage.clickOnSiteVisit(); }
    @Step
    public boolean verifyThePage(){ return sitevisitadminpage.verifyThePage(); }
    @Step
    public void clickoneditbutton() { sitevisitadminpage.clickoneditbutton(); }
    @Step
    public void clickonAddButton() { sitevisitadminpage.clickonAddButton(); }
    @Step
    public boolean  verifyAddRiskLevelpage() { return sitevisitadminpage.verifyAddRiskLevelpage(); }
    @Step
    public void fillRiskLevelIdetifier(String riskLevelIdetifier){sitevisitadminpage.fillRiskLevelIdetifier(riskLevelIdetifier); }
    @Step
    public void fillScoreMinValue(String scoreminvalue){sitevisitadminpage.fillScoreMinValue(scoreminvalue);}
    @Step
    public void fillScoreMaxValue(String scoremaxvalue){sitevisitadminpage.fillScoreMaxValue(scoremaxvalue);}
    @Step
    public void fillSheduleMinValue(String sheduleminvalue){sitevisitadminpage.fillSheduleMinValue(sheduleminvalue);}
    @Step
    public void clickSheduleMonths(){sitevisitadminpage.clickSheduleMonths();}
    @Step
    public void clickSheduleMonths1(){sitevisitadminpage.clickSheduleMonths1();}
    @Step
    public void fillFirstRemainder(String firstvalue) {sitevisitadminpage.fillFirstRemainder(firstvalue); }
    @Step
    public void fillSecondRemainder(String secondvalue) {sitevisitadminpage.fillSecondRemainder(secondvalue); }
    @Step
    public void fillThirdRemainder(String thirdvalue) {sitevisitadminpage.fillThirdRemainder(thirdvalue); }
    @Step
    public void selectFirstRemainderDays() { sitevisitadminpage.selectFirstRemainderDays();   }
    @Step
    public void selectSecondRemainderDays() {  sitevisitadminpage.selectSecondRemainderDays();  }
    @Step
    public void selectThirdRemainderDays() { sitevisitadminpage.selectThirdRemainderDays();   }
    @Step
    public void clickFirstRemainderDays() { sitevisitadminpage.clickFirstRemainderDays();   }
    @Step
    public void clickSecondRemainderDays() {  sitevisitadminpage.clickSecondRemainderDays();  }
    @Step
    public void clickThirdRemainderDays() { sitevisitadminpage.clickThirdRemainderDays();   }
    @Step
    public void clickOnSaveButton() {  sitevisitadminpage.clickOnSaveButton();  }

    @Step
    public String  checkRegValidationForDuplicating(String field) {
        return  sitevisitadminpage. checkRegValidationForDuplicating(field);

    }

    @Step
    public void clickOnCanceleButton() {  sitevisitadminpage.clickOnCancelButton();  }

    @Step
    public  void clickOnCanceleButtonInRiskCategory(){sitevisitadminpage.clickOnCanceleButtonInRiskCategory();}


    @Step
    public boolean verifyingMinScheduleIsPresent() { return sitevisitadminpage.verifyingMinScheduleIsPresent(); }

    @Step
    public boolean verifyingScheduleDropdownIsPresent()  {return sitevisitadminpage.verifyingScheduleDropdownIsPresent(); }


    //TC  2.3 Configure Remainder for Site Visit
    @Step
    public boolean verifyingFirstRemainderIsPresent() { return sitevisitadminpage.verifyingFirstRemainderIsPresent(); }

    @Step
    public boolean verifyingSecondRemainderIsPresent() { return sitevisitadminpage.verifyingSecondRemainderIsPresent(); }

    @Step
    public boolean verifyingThirdRemainderIsPresent() { return sitevisitadminpage.verifyingThirdRemainderIsPresent(); }

    @Step
    public boolean verifyingFirstRemainderDropdownIsPresent() { return sitevisitadminpage.verifyingFirstRemainderDropdownIsPresent();}

    @Step
    public boolean verifyingSecondRemainderDropdownIsPresent() { return sitevisitadminpage.verifyingSecondRemainderDropdownIsPresent();}

    @Step
    public boolean verifyingThirdRemainderDropdownIsPresent() { return sitevisitadminpage.verifyingThirdRemainderDropdownIsPresent();}

    @Step
    public String verifyingFirstRemainderErrorMessageIsDisplaying(String error1) { return sitevisitadminpage.verifyingFirstRemainderErrorMessageIsDisplaying(error1);}

    @Step
    public void clickFirstRemainderMonths() {  sitevisitadminpage.clickFirstRemainderMonths(); }
    @Step
    public String verifyingSecondRemainderErrorMessageIsDisplaying(String error1) { return sitevisitadminpage.verifyingSecondRemainderErrorMessageIsDisplaying(error1);}

    @Step
    public String verifyingThirdRemainderErrorMessageIsDisplaying(String error1) {return sitevisitadminpage.verifyingThirdRemainderErrorMessageIsDisplaying(error1); }

    @Step
    public  void clickOnCloseButton() {sitevisitadminpage.clickOnCloseButton(); }

    @Step
    public void  clickOnCloseButtonFromScrreningScoreDialogBox(){sitevisitadminpage.clickOnCloseButtonFromScrreningScoreDialogBox();}

    @Step
      public String getValidationRiskLevelField(String error) { return sitevisitadminpage.getValidationRiskLevelField(error); }
      @Step
    public void clickOnMinmumRiskValue() {sitevisitadminpage.clickOnMinmumRiskValue();}

    @Step
    public String getValidationMinValueField(String field){return sitevisitadminpage.getValidationMinValueField(field);}

    @Step
    public String getValidationMaxValueField(String field){return sitevisitadminpage.getValidationMaxValueField(field);}
    @Step
    public String getValidationFirstField(String field){return sitevisitadminpage.getValidationFirstField(field);}
    @Step
    public String getValidationSecondField(String field){return sitevisitadminpage.getValidationSecondField(field);}

  @Step
    public String getValidationThirdField(String field){return sitevisitadminpage.getValidationThirdField(field);}

//ERROR VALIDATION

    @Step
    public void clickOnMaxValue() {sitevisitadminpage.clickOnMaxValue();}

    @Step
    public void clickOnFirstField() { sitevisitadminpage.clickOnFirstField();}

    @Step
    public void clickOnSecondField() { sitevisitadminpage.clickOnSecondField();}

    @Step
    public void clickOnThirdField() {sitevisitadminpage.clickOnThirdField(); }

    @Step
    public void clickOnRiskLevelIdentifierField() {sitevisitadminpage.clickOnRiskLevelIdentifierField();}

    @Step
    public void deleteSiteVisit(String riskname) {sitevisitadminpage.deleteSiteVisit(riskname);}

    @Step
    public void editSiteVisit(String riskname){sitevisitadminpage.editSiteVisit(riskname);}

    @Step
    public void editRiskLevelIdetifier(String riskLevelIdetifier){sitevisitadminpage.editRiskLevelIdetifier(riskLevelIdetifier);}

    @Step
    public void editMinValue(String minValue){sitevisitadminpage.editMinValue(minValue);}

    @Step
    public void editMaxValue(String maxValue){sitevisitadminpage.editMaxValue(maxValue);}

    @Step
    public void editScheduleMinVale(String scheduleMinValue){sitevisitadminpage.editScheduleMinVale(scheduleMinValue);}

    @Step
    public void editFirstRemainder(String firstvalue){sitevisitadminpage.editFirstRemainder(firstvalue);}

    @Step
    public void editSecondRemainder(String secondvalue){sitevisitadminpage.editSecondRemainder(secondvalue);}

    @Step
    public void editThirdRemainder(String thirdvalue){sitevisitadminpage.editThirdRemainder(thirdvalue);}

    @Step
    public void clickeditbuttoninschedule() {sitevisitadminpage.clickeditbuttoninschedule();}

    //sp24
    @Step
    public void setSiteVisitDate(String sitevisitDate) {
        sitevisitadminpage.setSiteVisitDate(sitevisitDate);
    }
    @Step
    public void setSiteVisitEffectiveEndDate(String effectiveEndDate){
        sitevisitadminpage.setSiteVisitEffectiveEndDate(effectiveEndDate);
    }
    @Step
    public boolean verifyViewHistorytButton(){
        return sitevisitadminpage.verifyViewHistorytButton();
    }
    @Step
    public void clickVeiwHistoryButton(){
        sitevisitadminpage.clickVeiwHistoryButton();
    }
    @Step
    public void clickOnExitButton(String exit) {
        sitevisitadminpage.clickOnExitButton(exit);
    }
    @Step
    public void clickEditButton(){
        sitevisitadminpage.clickEditButton();
    }
    @Step
    public void clickSaveButton(String savebutton){
        sitevisitadminpage.clickSaveButton(savebutton);
    }

    @Step
    public Map<String, String> getMappedEffectiveDateValues() {
        return sitevisitadminpage.getViewhistoryPanel().getMappedEffectiveDateValues();
    }
    @Step
    public Map<String, String> getMappedUpdatedDateValues() {
        return sitevisitadminpage.getViewhistoryPanel().getMappedUpdatedDateValues();
    }
    @Step
    public void clickEffectiveDates() {
        sitevisitadminpage.clickEffectiveDates();
    }
    @Step
    public void clickBackToHistoryRecords() {
        sitevisitadminpage.clickBackToHistoryRecords();
    }
    //sp41.4
    @Step
    public void setScheduleSiteVisit(){
        sitevisitadminpage.setScheduleSiteVisit();
    }
    @Step
    public void clickSaveChanges() {
        sitevisitadminpage.clickSaveChanges();
    }
    @Step
    public void setScheduleSiteVisitBasedOnState(){
        sitevisitadminpage.setScheduleSiteVisitBasedOnState();
    }
    @Step
    public void setScheduleSiteVisitBasedOnScreeningScore() {
        sitevisitadminpage.setScheduleSiteVisitBasedOnScreeningScore();
    }

    @Step
    public void selectRiskLevelBasedOnTaxonomy(){
        sitevisitadminpage.selectRiskLevelBasedOnTaxonomy();
    }
    @Step
    public void selectRiskLevelBasedOnScreeningScore(){
        sitevisitadminpage.selectRiskLevelBasedOnScreeningScore();
    }
    @Step
    public void selectHigherofTowRiskLevels(){
        sitevisitadminpage.selectHigherofTowRiskLevels();
    }
    @Step
    public boolean isRiskLevelBasedOnTaxonomySelected(){
        return sitevisitadminpage.isRiskLevelBasedOnTaxonomySelected();
    }
    @Step
    public boolean isRiskLevelBasedOnScreeningScoreSelected(){
        return sitevisitadminpage.isRiskLevelBasedOnScreeningScoreSelected();
    }
    @Step
    public boolean isHigherOfTwoRiskLevelsSelected(){
        return sitevisitadminpage.isHigherOfTwoRiskLevelsSelected();
    }

}
