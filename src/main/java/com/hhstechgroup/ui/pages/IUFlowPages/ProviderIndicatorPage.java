package com.hhstechgroup.ui.pages.IUFlowPages;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.util.properties.LocationProviderProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class ProviderIndicatorPage extends AbstractPage {

    public static final String INDICATOR_TILE = "//button[@role='tab' and span[text()='Indicators']]";
    public static final String INDICATORS_TAB = "//div[contains(@class,'tile-table-row-summary')]";
    public static final String PANEL_MENU = "(//div[contains(@class,'tile-table-row-summary')])//following::div[contains(@class,\"expansion-panel\")][2]";
    public static final String REMOVE_END = "(//li[contains(text(),'Remove/End')])";
    public static final String INACTIVE_STATUS = "(//div[contains(@class,'tile-table-row-summary')])//following::p[contains(text(),\"INACTIVE\")]";
    public static final String RESET_FILTER="//div[contains(@class, 'search-box-actions')]//a[contains(text(), 'Reset filters')]";

    public static final List<String> indicatorTypes = Arrays.asList(
            "PMT_RES_UNDELIVERABLE_MAIL",
            "PMT_RES_FIRST_B_NOTICE_1099",
            "PMT_RES_UNDELIVERABLE_RE_ENROLLMENT_PACKET",
            "PMT_RES_UNDELIVERABLE_1099",
            "PMT_RES_B_NOTICE_1099",
            "PMT_RES_SECOND_B_NOTICE_1099",
            "PMT_RES_UNDELIVERABLE_CHECK"
    );
    //    "PMT_RES_UNDELIVERABLE_MAIL",
    List<String> providerIds = LocationProviderProperties.getLocationProviderIds();


    public ProviderIndicatorPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToProviderIndicator() {
        waitAbit(20000);
        jsClick(INDICATOR_TILE);
        waitAbit(4000);
    }

    public void callProviderIndicatorAPI() {
        // Print cleaned list of provider IDs without brackets
        System.out.println("LocationProviderIDs: " + String.join(", ", providerIds));

        String apiUrl = "https://htg-connect-qa.dev.hhstechgroup.com/htg-connect-api/api/v1/provider-indicators";

        // Disable SSL certificate validation (for QA environments only)
        RestAssured.useRelaxedHTTPSValidation();

        for (String providerId : providerIds) {
            for (String indicatorType : indicatorTypes) {

                String requestBody = String.format(
                        "{\n" +
                                "  \"indicatorLevel\": \"PROVIDER_ID\",\n" +
                                "  \"indicatorName\": \"%s\",\n" +
                                "  \"indicatorType\": \"%s\",\n" +
                                "  \"indicatorValue\": \"YES\",\n" +
                                "  \"reasonCode\": \"RC101\",\n" +
                                "  \"note\": \"External system flagged this provider as high risk\"\n" +
                                "}", providerId, indicatorType); // Confirm: is indicatorName = providerId intentional?

                // Debug logs
                System.out.println("\nCalling API for:");
                System.out.println("  ProviderID: " + providerId);
                System.out.println("  IndicatorType: " + indicatorType);
                System.out.println("  Request Body:\n" + requestBody);

                Response response = RestAssured
                        .given()
                        .header("apiKey", "e9a78d58-02d4-4f0e-8f8c-59bb174d59b8")
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post(apiUrl)
                        .then()
                        .extract()
                        .response();

                // Assert and response log
                int statusCode = response.getStatusCode();
                Assert.assertTrue(
                        "API call failed for Provider ID: " + providerId + " with status " + statusCode,
                        statusCode == 200 || statusCode == 201
                );
                System.out.println("Successfully called API for ProviderID: " + providerId + ", IndicatorType: " + indicatorType);
            }
        }
    }

//    curl --location 'https://htg-connect-qa.dev.hhstechgroup.com/htg-connect-api/api/v1/provider-indicators' \
//            --header 'apiKey: e9a78d58-02d4-4f0e-8f8c-59bb174d59b8' \
//            --header 'Content-Type: application/json' \
//            --data ' {
//            "indicatorLevel": "PROVIDER_ID",
//            "indicatorName": "100004800",
//            "indicatorType": "PMT_RES_UNDELIVERABLE_CHECK",
//            "indicatorValue": "YES",
//            "reasonCode": "RC101",
//            "note": "External system flagged this provider as high risk"
//}'


    public void verifyindicatorstab() {
        waitAbit(10000);
        List<WebElementFacade> rows = findAll(INDICATORS_TAB);
        Assert.assertTrue("Expected at least 7 provider summary rows, but found " + rows.size(), rows.size() >= 7);
    }

    public void verifyinactivestatus() {
        waitAbit(10000);
        getDriver().navigate().refresh();
        jsClick(PANEL_MENU);
        jsClick(REMOVE_END);
        waitAbit(10000);
        String statusText = findBy(INACTIVE_STATUS).getText().trim();
        Assert.assertEquals("Expected status to be INACTIVE, but found: " + statusText, "INACTIVE", statusText);
    }
    private static final String PROVIDER_NAME_AND_ID = ".//input[contains(@id, 'providerName')]";
    private static final String SEARCH_BUTTON="//button[.//span[text()='Search']]";
    public void searchWithProviderId(String providerId) {
        waitABit(3000);
        WebElement searchBox = findBy(PROVIDER_NAME_AND_ID);
        searchBox.clear();
        searchBox.sendKeys(providerId);
        searchBox.sendKeys(Keys.ENTER);// Or click search if there's a button
        jsClick(SEARCH_BUTTON);
    }
    public void clearproviderid(){
        waitAbit(3000);
        jsClick(RESET_FILTER);
        waitAbit(3000);

    }

    private static final String CLICKONPRO = "//div[contains(@class, 'expansion-panel-summary')][.//p[contains(text(), '%s')]]";
    public void clickonenrollment(String providerId){
        waitAbit(2000);
        findBy(String.format(CLICKONPRO, providerId)).click();
        waitAbit(3000);
    }


} 