package com.hhstechgroup.steps.jbehave.scenarios.sitevisit;

import com.hhstechgroup.steps.serenity.peportalpages.DashboardSteps;
import com.hhstechgroup.steps.serenity.sitevisit.SiteVisitAdminSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.core.Is;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;


import java.util.Map;

import static org.junit.Assert.*;


public class SiteVisitAdminScenario {
    //private static final String SYSTEM_OPTIONS = "System Options";
    @Steps
    SiteVisitAdminSteps sitevisitadminsteps;

    @Steps
    DashboardSteps dashboardSteps;

    /* @When("search for event by next parameters: $table")
    public void searchByParameters(ExamplesTable table) {
        SiteVisitAddRiskLevelBean parameters = ExamplesTableUtil.parseTableToClass(table, SiteVisitAddRiskLevelBean.class).get(0);
        auditSteps.setSearchCriteria(parameters);
        auditSteps.clickSearch();
    }
*/

    /*@When("navigate to 'System Options' page from user pop-up")
    public void navigateToSystemOptions() {
        dashboardSteps.clickOnUserEmail();
        dashboardSteps.selectOptionOnUserPopUp(SYSTEM_OPTIONS);
    }
*/
    @Then("click on 'Site Visit' link")
    public void clickOnSiteVisit(){
        sitevisitadminsteps.clickOnSiteVisit();
    }

    @Then("Verifying Site Visit is displaying")
    public void verifyThePage(){
        assertTrue("Site visit page should displayed",sitevisitadminsteps.verifyThePage());
        System.out.println("Site Visit page should be displayed");
    }
    @Then("click on 'Edit Button' in the sitevisit page")
    public void clickoneditbutton() { sitevisitadminsteps.clickoneditbutton(); }

    @Then("click on 'Add Button' in the risk Categories page")
    public void clickonAddButton() {
        sitevisitadminsteps.clickonAddButton();
    }

    @When("the user is  navigate to 'Add Risk Level' page")
    public void  verifyAddRiskLevelpage() {
        assertTrue("Add Risk Level page",sitevisitadminsteps.verifyAddRiskLevelpage()); }

    @Then("fill the Risk Level identifier with value '$value'")
    public void fillRiskLevelIdetifier(String riskLevelIdetifier){
        sitevisitadminsteps.fillRiskLevelIdetifier(riskLevelIdetifier); }

    @Then("fill the Score Min no with value '$value'")
    public void fillScoreMinValue(String scoreminvalue){
        sitevisitadminsteps.fillScoreMinValue(scoreminvalue);}

    @Then("fill the Score Max no with value '$value'")
    public void fillScoreMaxValue(String scoremaxvalue){
        sitevisitadminsteps.fillScoreMaxValue(scoremaxvalue);}

    @Then("fill the Shedule no with value '$value'")
    public void fillSheduleMinValue(String sheduleminvalue){
        sitevisitadminsteps.fillSheduleMinValue(sheduleminvalue);}

    @Then("Verifying Schedule  Field is Displayed")
    public void verifyingMinScheduleIsPresent() {
        assertTrue(sitevisitadminsteps.verifyingMinScheduleIsPresent());
    }
    @Then("click on 'Shedule months or Year'")
    public void clickSheduleMonths(){sitevisitadminsteps.clickSheduleMonths();}

    @Then("Verifying Schedule Dropdown field is Displayed")
    public void verifyingScheduleDropdownIsPresent() {
        assertTrue(sitevisitadminsteps.verifyingScheduleDropdownIsPresent());
    }


    @Then("click on the 'Months'")
    public void clickSheduleMonths1(){sitevisitadminsteps.clickSheduleMonths1();}

    @Then("send the value to the first remainder '$value'")
    public void fillFirstRemainder(String value) {sitevisitadminsteps.fillFirstRemainder(value); }

    @Then("send the value to the second remainder '$value'")
    public void fillSecondRemainder(String value) {sitevisitadminsteps.fillSecondRemainder(value); }

    @Then("send the value to the third remainder '$value'")
    public void fillThirdRemainder(String value) {sitevisitadminsteps.fillThirdRemainder(value); }

    @Then("select the first remainder drop drown")
    public void selectFirstRemainderDays() {  sitevisitadminsteps.selectFirstRemainderDays();  }

    @Then("select the second remainder drop drown")
    public void selectSecondRemainderDays() {  sitevisitadminsteps.selectSecondRemainderDays();  }

    @Then("select the third remainder drop drown")
    public void selectThirdRemainderDays() { sitevisitadminsteps.selectThirdRemainderDays();   }

    @Then("click the first remainder days")
    public void clickFirstRemainderDays() { sitevisitadminsteps.clickFirstRemainderDays();   }

    @Then("click the second remainder days")
    public void clickSecondRemainderDays() { sitevisitadminsteps.clickSecondRemainderDays();   }

    @Then("click the third remainder days")
    public void clickThirdRemainderDays() {  sitevisitadminsteps.clickThirdRemainderDays();  }

    //Merging

@Then("click on close button from the dialox box")
public  void clickOnCloseButton() { sitevisitadminsteps.clickOnCloseButton();}

    @Then("click on close button from the screening score dialox box")
    public  void clickOnCloseButtonFromScrreningScoreDialogBox() { sitevisitadminsteps.clickOnCloseButtonFromScrreningScoreDialogBox();}


//TC  2.3 Configure Remainder for Site Visit

    @Then("Verifying First Remainder Section is Displayed")
    public void verifyingFirstRemainderIsPresent() {
        assertTrue(sitevisitadminsteps.verifyingFirstRemainderIsPresent());
    }

    @Then("Verifying Second Remainder Section is Displayed")
    public void verifyingSecondRemainderIsPresent() {
        assertTrue(sitevisitadminsteps.verifyingSecondRemainderIsPresent());
    }

    @Then("Verifying Third Remainder  Section is Displayed")
    public void verifyingThirdRemainderIsPresent() {
        assertTrue(sitevisitadminsteps.verifyingThirdRemainderIsPresent());
    }

    @Then("Verifying First Remainder  Dropdown is Displayed")
    public void verifyingFirstRemainderDropdownIsPresent() {
        assertTrue(sitevisitadminsteps.verifyingFirstRemainderDropdownIsPresent());
    }


    @Then("Verifying Second Remainder  Dropdown is Displayed")
    public void verifyingSecondRemainderDropdownIsPresent() {
        assertTrue(sitevisitadminsteps.verifyingSecondRemainderDropdownIsPresent());
    }

    @Then("Verifying Third Remainder  Dropdown is Displayed")
    public void verifyingThirdRemainderDropdownIsPresent() {
        assertTrue(sitevisitadminsteps.verifyingThirdRemainderDropdownIsPresent());
    }
    @Then("click the first remainder months")
    public void clickFirstRemainderMonths() { sitevisitadminsteps.clickFirstRemainderMonths();  }

    @Then("Validation First Remainder '$tex' should be displayed-'$error1'")
    public void verifyingFirstRemainderErrorMessageIsDisplaying(String message, String error1) {
        assertEquals("Validating First Remainder Error message",message,sitevisitadminsteps.verifyingFirstRemainderErrorMessageIsDisplaying(error1));
    }

    @Then("Validation Second Remainder '$tex' should be displayed-'$error2'")
    public void verifyingSecondRemainderErrorMessageIsDisplaying(String tex, String error1) {
        assertEquals("Validating Second Remainder Error message ",tex,sitevisitadminsteps.verifyingSecondRemainderErrorMessageIsDisplaying(error1));
    }

    @Then("Validation Third Remainder '$tex' should be displayed-'$error3'")
    public void verifyingThirdRemainderErrorMessageIsDisplaying(String tex, String error1) {
        assertEquals("Validating Third Remainder Error message ",tex,sitevisitadminsteps.verifyingThirdRemainderErrorMessageIsDisplaying(error1)); }


    @Then("click on save button to add the Risk level")
    public void clickOnSaveButton() { sitevisitadminsteps.clickOnSaveButton();   }

    @Then("click on cancel button to cancel the Risk level")
    public void clickOnCanceleButton() {  sitevisitadminsteps.clickOnCanceleButton();  }

    @Then("click on cancel button from  the Risk Category page")
    public void clickOnCanceleButtonInRiskCategory() {  sitevisitadminsteps.clickOnCanceleButtonInRiskCategory();  }

    @Then("validation message '$message' should be displayed for field-'$msg'")
    public void checkRegValidationForDuplicating(String message, String field) {
        assertEquals("Validating Risk Level already Duplicated",message, sitevisitadminsteps.checkRegValidationForDuplicating(field));


    }



    //erroe messages

     @Then("validating risk level identifier message '$message' should be displayed for field - '$field'")
      public void verifyRiskLevelError(String message, String error) {
          assertNotEquals("Validation message is incorrect or it is incorrect", message, sitevisitadminsteps.getValidationRiskLevelField(error));
      }
    @Then("Click on minimum value field")
    public void clickOnMinmumRiskValue() {sitevisitadminsteps.clickOnMinmumRiskValue();}

    @Then("Click on maximum value field")
    public void clickOnMaxValue(){ sitevisitadminsteps.clickOnMaxValue();}

    @Then("Click on First Remainder visit field")
    public void clickOnFirstField() {sitevisitadminsteps.clickOnFirstField();}

    @Then("Click on Second Remainder visit field")
    public void clickOnSecondField() { sitevisitadminsteps.clickOnSecondField();}

    @Then("Click on Third Remainder visit field")
    public void clickOnThirdField() {sitevisitadminsteps.clickOnThirdField(); }

    @Then("Click on Risk Level Identifier Field")
    public void clickOnRiskLevelIdentifierField() {sitevisitadminsteps.clickOnRiskLevelIdentifierField();}


   /* @Then("validation message '$message' should be displayed for field scbj EDHFCEHsf  - '$error'")
    public void verifyMinvalueError(String message, String error) {
        assertEquals("Min Value*", sitevisitadminsteps.getValidationMinValueField(error));
       // System.out.println(error);

    }*/

    @Then("validation message '$text' should be displayed - '$field5'")
    public void verifyMinvalueError(String text, String error) {
        String actual = sitevisitadminsteps.getValidationMinValueField(error);
       // System.out.println(actual);
        assertEquals("Mesge should display",text,actual);

    }
    @Then("validating maxmium screening message '$message' should be displayed for field - '$field1'")
    public void verifyMaxvalueError(String message, String field) {
        assertEquals("Validation message should be display", message, sitevisitadminsteps.getValidationMaxValueField(field));
    }

    @Then("validating first remainder  message '$message' should be displayed for field - '$field2'")
    public void verifyFirstSectionError(String message, String field) {
        assertNotEquals("Validation message is incorrect or it is incorrect", message, sitevisitadminsteps.getValidationFirstField(field));
    }
    @Then("validating third remainder message '$message' should be displayed for field - '$field4'")
    public void verifyThirdsectionError(String message, String field) {
        assertNotEquals("Validation message is incorrect or it is incorrect", message, sitevisitadminsteps.getValidationThirdField(field));
    }
    @Then("validating second remainder message '$message' should be displayed for field - '$field3'")
    public void verifySecondsectionError(String message, String field) {
        assertNotEquals("Validation message is incorrect or it is incorrect", message, sitevisitadminsteps.getValidationSecondField(field));
    }

    @When("delete the site visit based on '$riskName' from the risk level page")
    public void deleteSiteVisit(String riskname) {sitevisitadminsteps.deleteSiteVisit(riskname);
    }

    @When("edit the site visit based on '$riskName' from the risklevel page")
    public void editSiteVisit(String riskname){sitevisitadminsteps.editSiteVisit(riskname);}

    @When("edit risk level name as '$riskLevelName' from the risk level page")
    public void editRiskLevelIdetifier(String riskLevelIdetifier){sitevisitadminsteps.editRiskLevelIdetifier(riskLevelIdetifier);}

    @When("edit minimum value as '$minValue' from the risk level page")
    public void editMinValue(String minValue){sitevisitadminsteps.editMinValue(minValue);}

    @When("edit maximum value as '$maxValue' from the risk level page")
    public void editMaxValue(String maxValue){sitevisitadminsteps.editMaxValue(maxValue);}

    @When("edit schedule minimum value as '$scheduleMinValue' from the risk level page")
    public void editScheduleMinVale(String scheduleMinValue){sitevisitadminsteps.editScheduleMinVale(scheduleMinValue);}

    @When("edit first remainder value as '$firstvalue' from the risk level page")
    public void editFirstRemainder(String firstvalue){sitevisitadminsteps.editFirstRemainder(firstvalue);}

    @When("edit second remainder value as '$secondvalue' from the risk level page")
    public void editSecondRemainder(String secondvalue){sitevisitadminsteps.editSecondRemainder(secondvalue);}

    @When("edit third remainder value as '$thirdvalue' from the risk level page")
    public void editThirdRemainder(String thirdvalue){sitevisitadminsteps.editThirdRemainder(thirdvalue);}

    @When("click on schedule edit button in the sitevisit page")
    public void clickeditbuttoninschedule(){sitevisitadminsteps.clickeditbuttoninschedule();}

   //sp24
    @When("Set the Site Visit Effective Start Date '$sitevisitDate'")
    public void setSiteVisitDate(String sitevisitDate) {
        sitevisitadminsteps.setSiteVisitDate(sitevisitDate);
    }

    @When("Set the Site Visit Effective End Date '$sitevisitDate'")
    public  void setSiteVisitEffectiveEndDate(String effectiveEndDate){
        sitevisitadminsteps.setSiteVisitEffectiveEndDate(effectiveEndDate);
    }
    @When("verify the veiw history button is displaying in the Site Visit Risk Level Page")
    public void  verifyViewHistorytButton() {
       System.out.println("Veiw History Button is Displaying");
       assertTrue(sitevisitadminsteps.verifyViewHistorytButton());
    }

    @Then("click on the veiw history button in the Site Visit Risk Level Page")
    public void clickVeiwHistoryButton(){
        sitevisitadminsteps.clickVeiwHistoryButton();
    }

    @Then("click on the '$exit' Button in the Site visit veiwing history page")
    public void clickOnExitButton(String exit){
        sitevisitadminsteps.clickOnExitButton(exit);
    }

    @Then("click on the Edit Button in the site visit list page")
    public void clickEditButton(){
        sitevisitadminsteps.clickEditButton();
    }

    @Then("click on the '$savebutton' in the site visit risk level page")
    public void clickSaveButton(String savebutton){
        sitevisitadminsteps.clickSaveButton(savebutton);
    }

    @Then("verifying the updated dates in site visit veiwing history page: $table")
    public void getMappedUpdatedDateValues(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(sitevisitadminsteps.getMappedUpdatedDateValues(), Is.is(expectedInfo));
    }
    @Then("verifying the effective dates in site visit the veiwing history page: $table")
    public void getMappedEffectiveDateValues(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(sitevisitadminsteps.getMappedEffectiveDateValues(), Is.is(expectedInfo));
    }

    @Then("click on the effective dates in site visit the veiwing history page")
    public void clickEffectiveDates(){
        sitevisitadminsteps.clickEffectiveDates();
    }

    @Then("to click 'Back to History Records' in the site visit risk level page")
    public void clickBackToHistoryRecords() {
        sitevisitadminsteps.clickBackToHistoryRecords();
    }

    //sp41.4
    @Then("select on the schedule site visit based on 'Risk level based on Taxonomy' in the site visit risk level page")
    public void setScheduleSiteVisit(){
        sitevisitadminsteps.setScheduleSiteVisit();
    }
    @When("click on save changes button in site visit risk level page")
    public void clickSaveChanges() {
        sitevisitadminsteps.clickSaveChanges();
    }
    @Then("select on the schedule site visit based on 'Instate Providers' in the site visit risk level page")
    public void setScheduleSiteVisitBasedOnState(){
        sitevisitadminsteps.setScheduleSiteVisitBasedOnState();
    }

    @Then("select on the schedule site visit based on 'Risk level based on Screening score' in the site visit risk level page")
    public void setScheduleSiteVisitBasedOnScreeningScore(){
        sitevisitadminsteps.setScheduleSiteVisitBasedOnScreeningScore();
    }

    @Then("select Risk level based on Taxonomy")
    public void selectRiskLevelBasedOnTaxonomy(){
        sitevisitadminsteps.selectRiskLevelBasedOnTaxonomy();
    }
    @Then("select Risk level based on Screening score")
    public void selectRiskLevelBasedOnScreeningScore(){
        sitevisitadminsteps.selectRiskLevelBasedOnScreeningScore();
    }
    @Then("select Higher of the two Risk Levels")
    public void selectHigherofTowRiskLevels(){
        sitevisitadminsteps.selectHigherofTowRiskLevels();
    }

    @Then("verify Schedule Site Visit Based on:$table")
    public void verifyScheduleSiteVisitBasedOnTable(ExamplesTable table) {
        Map<String, String> row = table.getRow(0);
        String taxonomy = row.get("Risk level based on Taxonomy");
        String screeningscore = row.get("Risk level based on Screening score");
        String higheroftwo = row.get("Higher of the two Risk Levels");
        assertEquals(Boolean.parseBoolean(taxonomy), sitevisitadminsteps.isRiskLevelBasedOnTaxonomySelected());
        assertEquals(Boolean.parseBoolean(screeningscore), sitevisitadminsteps.isRiskLevelBasedOnScreeningScoreSelected());
        assertEquals(Boolean.parseBoolean(higheroftwo), sitevisitadminsteps.isHigherOfTwoRiskLevelsSelected());
    }
}
