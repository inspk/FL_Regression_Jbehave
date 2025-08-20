package com.hhstechgroup.steps.serenity.screening;

import com.hhstechgroup.ui.pages.screening.ScreeningPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class ScreeningSteps {
    @Page
    ScreeningPage screeningPage;

    @Step
    public boolean isTextRiskScoreDisplayed() {
        return screeningPage.isTextRiskScoreDisplayed();
    }
    @Step
    public void screeningRiskScore(){
        screeningPage.screeningRiskScore();
    }

    @Step
    public boolean isRiskScoreSumDisplayed(String riskScoreSum) {
        return screeningPage.isRiskScoreSumDisplayed(riskScoreSum);
    }

    @Step
    public boolean isFoundIssueWithNameDisplayed(String foundIssueName) {
        return screeningPage.isFoundIssueWithNameDisplayed(foundIssueName);
    }

    @Step
    public boolean isRiskScoreDisplayed(String riskScore) {
        return screeningPage.isRiskScoreDisplayed(riskScore);
    }

    @Step
    public void clickScreeningSectionWithName(String sectionName) {
         screeningPage.clickScreeningSectionWithName(sectionName);
    }

    @Step
    public String getCookies(){
        return screeningPage.collectCookies();
    }

    @Step
    public void replaceRequestIdScreeningFile(String requestId, String screeningFile){
       screeningPage.replaceRequestIdInScreeningFile(requestId, screeningFile);
    }

    @Step
    public void sendScreeningApiRequests(String screeningFile, String screeningEndpoint, String cookies){
        screeningPage.screeningApi(screeningFile, screeningEndpoint, cookies);
    }
    //sp33
    @Step
    public boolean verifyViewScreeingProofDocumentDispalying()  {
        return screeningPage.verifyViewScreeingProofDocumentDispalying();
    }
    @Step
    public void clickonviewscreeningproofdoc(){
        screeningPage.clickonviewscreeningproofdoc();
    }

    @Step
    public boolean verifyDownloadScreeingProofDocumentDispalying()  {
        return screeningPage.verifyDownloadScreeingProofDocumentDispalying();
    }
    @Step
    public void clickondownloadscreeningproofdoc(){
        screeningPage.clickondownloadscreeningproofdoc();
    }

    @Step
    public void clickScreeningIssuesRankingEdit(){
        screeningPage.clickScreeningIssuesRankingEdit();
    }

    @Step
    public void clickAutoDeny(String autoDeny){
        screeningPage.clickAutoDeny(autoDeny);
    }

    @Step
    public void clickManualReview(String manualReview){
        screeningPage.clickManualReview(manualReview);
    }

    @Step
    public boolean verifyScreeningViewHistory(String header) {
        return screeningPage.verifyScreeningViewHistory(header);
    }

    @Step
    public boolean verifyScreeningDownloadExcel(String header){
        return screeningPage.verifyScreeningDownloadExcel(header);
    }

    @Step
    public boolean verifyEffectiveStart(String header){
        return screeningPage.verifyEffectiveStart(header);
    }

}



