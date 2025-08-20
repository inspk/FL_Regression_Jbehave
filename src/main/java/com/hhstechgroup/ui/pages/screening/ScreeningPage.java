package com.hhstechgroup.ui.pages.screening;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.util.properties.SystemProperties;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class ScreeningPage extends AbstractPage {

    private static final String RISK_SCORE_TEXT = "//div[contains(@class, 'progress-wrapper')]//p[text() = 'Risk score']";
    private static final String RISK_SCORE_SUM = "//div[contains(@class, 'progress-wrapper')]/div/div/div[2][text() = '%s']";
    private static final String FOUND_ISSUE_NAME = "//ul[contains(@class, 'details_issues-list')]/li/h3[contains(text(), '%s')]";
    private static final String RISK_SCORE = "//div[@role='progressbar']/parent::div//div[contains(text(),'%s')]";
    private static final String SECTION_NAME = ".//div[span[text() = '%s']]";

    public ScreeningPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTextRiskScoreDisplayed() {
        return isElementPresent(RISK_SCORE_TEXT);
    }
    private static final String RISK_SCORE_SCRENING="(//div[contains(@class,'progress-wrapper')]//div)[4]";
    public void screeningRiskScore(){
        try {
            findBy(RISK_SCORE_SCRENING).isDisplayed();
            System.out.println("Risk Score is displaying");
            String riskScore = findBy(RISK_SCORE_SCRENING).getText();
            System.out.println("Risk score is displayed"+riskScore);
        }
        catch (Exception e){
            System.err.println("====RISK SCORE IS NOT DISPLAYING====");
        }
    }
    public boolean isRiskScoreSumDisplayed(String riskScoreSum) {
        return isElementPresent(format(RISK_SCORE_SUM, riskScoreSum));
    }
    public boolean isFoundIssueWithNameDisplayed(String foundIssueName) {
        return isElementPresent(format(FOUND_ISSUE_NAME, foundIssueName));
    }
    public boolean isRiskScoreDisplayed(String riskScore) {
        return isElementPresent(format(RISK_SCORE, riskScore));
    }

    public void clickScreeningSectionWithName(String sectionName) {
        String element = String.format(SECTION_NAME, sectionName);
        scrollToElement(element);
        findBy(element).click();

    }
    String cookies;


    public void replaceRequestIdInScreeningFile(String requestId, String screeningFile) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(screeningFile));
            for (int i = 0; i < allLines.size(); i++) {
                if (allLines.get(i).contains("<Request id=")) {
                    allLines.set(i, "        <Request id=\"" + requestId + "\">");
                }
            }
            waitAbit(300);
            BufferedWriter out = new BufferedWriter(new FileWriter(screeningFile));
            for (int i = 0; i < allLines.size(); i++) {
                if (i > 0) {
                    out.newLine();
                }
                out.write(allLines.get(i));
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void screeningApi(String screeningFile, String screeningEndpoint, String cookies) {
//        System.out.println("SCREENING API REQUEST:" + SystemProperties.PROVIDER_MANAGEMENT_URL.getProperty()+ screeningEndpoint);
//        String fullCookies = "auth_token="+ cookies;
//        System.out.println(fullCookies);
//        given()
//                .relaxedHTTPSValidation()
//                .cookie(fullCookies)
//                .multiPart(new File(screeningFile)).
//                when().
//                post(SystemProperties.PROVIDER_MANAGEMENT_URL.getProperty() + screeningEndpoint).
//                then().
//                statusCode(200);
//    }
//    public String collectCookies(){
//        try (BufferedWriter bwrite = new BufferedWriter(new FileWriter(new File("Cookies.txt"), false))) {
//            for (Cookie ck : getDriver().manage().getCookies()) {
//                bwrite.write(ck.getName() + "=" + ck.getValue() + "\n");
//
//                if (ck.getName().contains("auth_token")) {
//                    cookies = ck.getValue() + "; path=/; domain=."+ setDomainName() + ";";
//                    break;
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        System.out.println("COOKIE: " + cookies);
//        return cookies;
//    }

    public void screeningApi(String screeningFile, String screeningEndpoint, String cookies) {
        String baseUrl = SystemProperties.PROVIDER_MANAGEMENT_URL.getProperty().replaceAll("/+$", "");
        String tokenValue = cookies.replace("auth_token=", "").trim();
        String url = baseUrl + "/" + screeningEndpoint.replaceAll("^/+", "");

        System.out.println("SCREENING API REQUEST: " + url);
        System.out.println("Using Cookie: auth_token=" + tokenValue);

        given()
                .relaxedHTTPSValidation()
                .cookie("auth_token", tokenValue)
                .multiPart("file", new File(screeningFile))
                .when()
                .post("https://fl-htgqa-dyp-sb-01.hhstechgroup.com/api/screening/import/medversantScreening")
                .then()
                .statusCode(200);
    }


    public String collectCookies() {
        try (BufferedWriter bwrite = new BufferedWriter(new FileWriter(new File("Cookies.txt"), false))) {
            for (Cookie ck : getDriver().manage().getCookies()) {
                bwrite.write(ck.getName() + "=" + ck.getValue() + "\n");

                if (ck.getName().contains("auth_token")) {
                    // Return cookie in the format auth_token=<value>
                    cookies = ck.getName() + "=" + ck.getValue();
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("COOKIE: " + cookies);
        return cookies;
    }

    public String setDomainName(){
        String domain = SystemProperties.PROVIDER_MANAGEMENT_URL.getProperty().replace("https://", "");
        return domain;

    }
    //sp33
    private static final String VIEW_SCREENING_PROOF_DOCUMENT = ".//div[contains(@class,'details_header-actions')]/a[contains(text(),' View Screening Proof Document')]" ;
    public boolean verifyViewScreeingProofDocumentDispalying() {
        waitAbit(500);
        scrollToElement(VIEW_SCREENING_PROOF_DOCUMENT);
        return findBy(format(VIEW_SCREENING_PROOF_DOCUMENT)).isDisplayed(); }

        public void clickonviewscreeningproofdoc(){
        scrollToElement(VIEW_SCREENING_PROOF_DOCUMENT);
        findBy(VIEW_SCREENING_PROOF_DOCUMENT).click();
    }

    private static final String DOWNLOAD_SCREENING_PROOF_DOCUMENT = ".//div[contains(@class,'details_header-actions')]/a[contains(text(),' Download Screening Proof Document')]" ;
    public boolean verifyDownloadScreeingProofDocumentDispalying() {
        waitAbit(500);
        scrollToElement(DOWNLOAD_SCREENING_PROOF_DOCUMENT);
        return findBy(format(DOWNLOAD_SCREENING_PROOF_DOCUMENT)).isDisplayed(); }

    public void clickondownloadscreeningproofdoc(){
        scrollToElement(DOWNLOAD_SCREENING_PROOF_DOCUMENT);
        findBy(DOWNLOAD_SCREENING_PROOF_DOCUMENT).click();
    }

    private static final String SCREENING_ISSUES_RANKING_EDIT = ".//div[contains(text(),'Screening Issues Ranking')]//span[text()='Edit']";
    public void clickScreeningIssuesRankingEdit(){
        waitAbit(200);
        scrollToElement(SCREENING_ISSUES_RANKING_EDIT);
        findBy(SCREENING_ISSUES_RANKING_EDIT).click();
        waitAbit(200);
    }

    private static final String AUTO_DENY_CHECKBOX = "//div[text()='%s']/..//label[1]//span/input";
    public void clickAutoDeny(String autoDenyCheckbox){
        String element = format(AUTO_DENY_CHECKBOX, autoDenyCheckbox);
        scrollToElement(element);
        findBy(element).click();
    }

    private static final String MANUAL_REVIEW_CHECKBOX = "//div[text()='%s']/..//label[2]//span/input";
    public void clickManualReview(String manualReviewCheckbox){
        String element = format(MANUAL_REVIEW_CHECKBOX, manualReviewCheckbox);
        scrollToElement(element);
        findBy(element).click();
    }

    private static final String SCREENING_VIEW_HISTORY = "//div[text()='%s']//div[text()='View History']";
    public boolean verifyScreeningViewHistory(String header){
        return isElementPresent(format(SCREENING_VIEW_HISTORY, header));
    }

    private static final String SCREENING_DOWNLOAD_EXCEL = "//div[text()='%s']//button[@title='Download as Excel']";
    public boolean verifyScreeningDownloadExcel(String header){
        return isElementPresent(format(SCREENING_DOWNLOAD_EXCEL, header));
    }

    private static final String EFFECTIVE_START = "//div[text()='%s']//div/p[text()='Effective start']/following-sibling::p[not(text()='-')]";
    public boolean verifyEffectiveStart(String header){
        System.out.println(findBy(format(EFFECTIVE_START, header)).getText());
        return isElementPresent(format(EFFECTIVE_START, header));
    }
}
