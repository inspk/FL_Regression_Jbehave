package com.hhstechgroup.steps.jbehave.scenarios.screning;

import com.hhstechgroup.steps.serenity.screening.ScreeningSteps;
import com.hhstechgroup.util.properties.ProviderProperties;
import com.hhstechgroup.util.properties.SystemProperties;
import io.appium.java_client.pagefactory.AndroidBy;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ScreeningScenario {

    @Steps
    ScreeningSteps screeningSteps;

    @When("move to screening section with name '$sectionName'")
    public void clickSectionWithName(String sectionName) {
        screeningSteps.clickScreeningSectionWithName(sectionName);
    }

    @Then("screening risk score text should be displayed")
    public void verifyTextRiskScoreDisplayed() {
        Assert.assertTrue(screeningSteps.isTextRiskScoreDisplayed());
    }
    @Then("verify screening risk score should be displayed")
    public void screeningRiskScore(){
        screeningSteps.screeningRiskScore();
    }

    @Then("screening risk score sum is equals to '$sum'")
    public void verifyRiskScoreSumDisplayed(String sum) {
        assertTrue(screeningSteps.isRiskScoreSumDisplayed(sum));
    }

    @Then("screening risk score for section is equals to '$riskScore'")
    public void verifyRiskScoreDisplayed(String riskScore) {
        assertTrue(screeningSteps.isRiskScoreDisplayed(riskScore));
    }

    @Then("screening risk issue with name is displayed '$riskName'")
    public void verifyFoundIssueWithNameDisplayed(String riskName) {
        assertTrue(screeningSteps.isFoundIssueWithNameDisplayed(riskName));
    }
    //New Scenarios
    @When("replace request id '$requestId' screening file '$screeningFilePath'")
    public void replaceRequestIdInXml(String requestId, String screeningFile){
        screeningSteps.replaceRequestIdScreeningFile(requestId, screeningFile);
    }

    @When("send screening request 1 with file '$screeningFilePath' with '$cookies'")
    public void sendApiScreeningRequests1(String screeningFile, String screeningEndpoint, String cookies){
        screeningSteps.sendScreeningApiRequests(screeningFile, SystemProperties.SCREENING_WS_URL.getProperty(), cookies);
    }

    @When("get authorization user '$variable'")
    public void collectApiCookies(String variable){
        Serenity.setSessionVariable(variable).to(screeningSteps.getCookies());
    }

    //sp33
    @Then("verify the 'View Screening Proof Document' is displaying")
    public void verifyViewScreeingProofDocumentDispalying()  {
        System.out.println("View screeing proof document is displaying");
        assertTrue(screeningSteps.verifyViewScreeingProofDocumentDispalying());
    }
    @Then("click on the 'View Screening Proof Document' in the screening page")
    public void clickonviewscreeningproofdoc(){
        screeningSteps.clickonviewscreeningproofdoc();
    }

    @Then("verify the 'Download Screening Proof Document' is displaying")
    public void verifyDownloadScreeingProofDocumentDispalying()  {
        System.out.println("Download screeing proof document is displaying");
        assertTrue(screeningSteps.verifyDownloadScreeingProofDocumentDispalying());
    }

    @Then("click on the 'Download Screening Proof Document' in the screening page")
    public void clickondownloadscreeningproofdoc(){
        screeningSteps.clickondownloadscreeningproofdoc();
    }

    @When("verify Download Excel button present for '$header' in Screening page")
    public void verifyDownloadExcelButtonInScreeningPage(String header){
        assertTrue("Download Excel button not presents!",screeningSteps.verifyScreeningDownloadExcel(header));
    }

    @When("verify View History button present for '$header' in Screening page")
    public void verifyViewHistoryButtonInScreeningPage(String header){
        assertTrue("View History button not presents!",screeningSteps.verifyScreeningViewHistory(header));
    }

    @When("verify Effective Start Date present for '$header' in Screening page")
    public void verifyEffectiveStart(String header){
        assertTrue("View History button not presents!",screeningSteps.verifyEffectiveStart(header));
    }

    @Then("click on 'Screening Issues Ranking' in the Screening page")
    public void clickScreeningIssuesRankingEdit(){
        screeningSteps.clickScreeningIssuesRankingEdit();
    }

    @When("click Auto Deny in Screening page:$listAutoDeny")
    public void clickAutoDeny(ExamplesTable listAutoDeny){
        for (Map<String,String> row : listAutoDeny.getRows()) {
            String autoDeny = row.get(listAutoDeny.getHeaders().get(0));
            screeningSteps.clickAutoDeny(autoDeny);
        }
    }

    @When("click Manual Review in Screening page:$listAutoDeny")
    public void clickManualReview(ExamplesTable $listAutoDeny){
        for (Map<String,String> row : $listAutoDeny.getRows()) {
            screeningSteps.clickManualReview(row.get($listAutoDeny.getHeaders().get(0)));
        }
    }

}
