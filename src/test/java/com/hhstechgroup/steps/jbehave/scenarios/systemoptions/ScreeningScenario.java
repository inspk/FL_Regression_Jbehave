package com.hhstechgroup.steps.jbehave.scenarios.systemoptions;

import com.hhstechgroup.beans.application.ScreeningBean;
import com.hhstechgroup.steps.serenity.systemoption.ScreeningSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScreeningScenario {
    @Steps
    ScreeningSteps screeningSteps;

    @When("user fill the screening info: $table")
    public void setScreeningInfor(ExamplesTable screenig) {
        screeningSteps.setScreeningInfor(ExamplesTableUtil.parseTableToClass(screenig, ScreeningBean.class).get(0));
    }
    @When("{expand|close} Screening '$name' provider name from the Screening Page")
    public void clickScreeningProviderName(String name){
        screeningSteps.clickScreeningProviderName(name);
    }
    //sp24
    @When("select custom screening  thresholds option")
    public void selectCustomScreeningOption(){
        screeningSteps.selectCustomScreening();
    }

    @When("click custom screening enrollment type '$enrollmentType'")
    public void clickCustomScreeningTypeOfEnrollment(String typeEnrollment){
        screeningSteps.clickTypeParameterInScreening(typeEnrollment);
    }
    //sp29
    @Then("click on 'Monitoring Frequency Edit Button' in the Screening page")
    public void clickMonitoringEdit(){
        screeningSteps.clickMonitoringEdit();
    }
    @Then("{Enable|Disable} the '$value' switch in Screening  page")
    public void clickOnEnablePeriodicMonitoring(String enablperiodicmonitoring){
        screeningSteps.clickOnEnablePeriodicMonitoring(enablperiodicmonitoring);
    }
    @When("user fill the monitoring frequency screening info: $table")
    public void setMonitoringScreeningInfo(ExamplesTable screenig) {
        screeningSteps.setMonitoringScreeningInfo(ExamplesTableUtil.parseTableToClass(screenig, ScreeningBean.class).get(0));
    }
    @Then("click on the Save button in the Screening page")
    public void clickSaveButton() {
        screeningSteps.clickSaveButton();
    }
    //sp32
    @When("select the 'Default Screeing Thresholds' option")
    public void selectDefaultScreening(){
        screeningSteps.selectDefaultScreening();
    }
    //sp43.2
    @When("set the effective start date '$effectivestartDate' in screening page")
    public void setEffectiveStartDate(String effectiveStartDate) {
        screeningSteps.setEffectiveStartDate(effectiveStartDate);
    }

    //sp68

    @Then("{Enable|Disable} the '$value' switch in Affiliation page")
    public void clickOnEnablePeriodicMonitoring2(String enablperiodicmonitoring){
        screeningSteps.clickOnEnablePeriodicMonitoring2(enablperiodicmonitoring);
    }

    //sp68

    @Then("click on the Save button in the Affiliation page")
    public void clickSaveButton1() {
        screeningSteps.clickSaveButton1();
    }

    //SD-05

    @When("verify that the $element present in Affiliation page")
    public void verifyAffiliationPage(String str) {
        assertTrue(str + " Not presents!",screeningSteps.verifyAffiliationPage(str));
    }

    @When("verify Download Excel button present in Affiliation page")
    public void verifyDownloadExcelButton(){
        assertTrue("Download Excel button not presents!",screeningSteps.verifyDownloadExcelButton());
    }

    @When("verify View History present in Affiliation page")
    public void verifyViewHistory(){
        assertTrue("View History not presents!",screeningSteps.verifyViewHistory());
    }

    @When("verify that the $button button is $on by default in Affiliation page")
    public void verifyButtonEnabled(String button, String on) {
        if(on.equalsIgnoreCase("on"))
            assertTrue(button + " is not enabled!",screeningSteps.verifyButtonEnabled(button));
        else
            assertFalse(button + " is enabled!",screeningSteps.verifyButtonEnabled(button));
    }

    @Then("{Enable|Disable} the '$value' switchs in Affiliation page")
    public void selectAllowedAffiliationAndSign(String enablperiodicmonitoring){
        screeningSteps.selectAllowedAffiliationAndSign(enablperiodicmonitoring);
    }

    @Then("Enable affiliation '$value' switchs in Affiliation page")
    public void enableAffiliation(String enablperiodicmonitoring){
        screeningSteps.enableAffiliation(enablperiodicmonitoring);
    }

    @Then("Disable affiliation '$value' switchs in Affiliation page")
    public void disableAffiliation(String enablperiodicmonitoring){
        screeningSteps.enableAffiliation(enablperiodicmonitoring);
    }

    @Then("Enable affiliation sign '$value' switchs in Affiliation page")
    public void enableAffiliationSign(String enablperiodicmonitoring){
        screeningSteps.enableAffiliationSign(enablperiodicmonitoring);
    }

    @Then("Disable affiliation sign '$value' switchs in Affiliation page")
    public void disableAffiliationSign(String enablperiodicmonitoring){
        screeningSteps.disableAffiliationSign(enablperiodicmonitoring);
    }

}
