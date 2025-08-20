package com.hhstechgroup.ui.pages.systemoptions;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.util.properties.ProviderProperties;
import com.hhstechgroup.util.properties.SystemProperties;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.URI;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class RevalidationConfigurationPage extends AbstractPage {

    public RevalidationConfigurationPage(WebDriver driver) {
        super(driver);
    }

    private static final String REVALIDATION_SETTINGS = "//div[text() = '%s']/parent::div/following-sibling::div//div[text() = '%s']/parent::div//input[@type = 'hidden']";
    private static final String SET_REVALIDATION_SETTINGS = "//div[text() = '%s']/parent::div/following-sibling::div//div[text() = '%s']/parent::div//div[@role = 'button']";
    private static final String DROPDOWN_LIST = "//div[@role='document']/ul";
    private static final String WINDOW_REVALIDATION= "//div[contains(@class, 'styles_revalidation')]";
    private static final String RED_WINDOW_REVALIDATION= "//div[contains(@class, 'styles_red')]";
    public static final String  MODAL_WINDOW_ENROLLMENT= "//div[contains(@class, 'styles_enrollment-info')]";

    public String getRevalidationConfiguration (String section, String notification) {
        String getRevalidationSetting = format(REVALIDATION_SETTINGS, section, notification);
        waitForPresenceOf(getRevalidationSetting);
        return findBy(getRevalidationSetting).getAttribute("value");
    }

    public void setRevalidationConfiguration (String section, String notification, String value) {
        String setRevalidationSetting = format(SET_REVALIDATION_SETTINGS, section, notification);
        waitFor(ExpectedConditions.elementToBeClickable(By.xpath(setRevalidationSetting)));
     //   findBy(setRevalidationSetting).click();
        jsClick(setRevalidationSetting);
        selectFromDropDown(value);
        waitForAbsenceOf(DROPDOWN_LIST);
    }


    public String getProviderDataId(String firstName, String lastName) {
        RestAssured.baseURI = SystemProperties.PROVIDER_MANAGEMENT_URL.getProperty();
        String uri = "/api/hummingbird/public/providers?" + "firstName=" + firstName + "&lastName=" + lastName;
        String endpoint = RestAssured.baseURI + uri;
        System.out.println(endpoint);

        RequestSpecification httpRequest = RestAssured.given()
                .header("Content-Type", "application/json;charset=UTF-8")
                .relaxedHTTPSValidation();
        Response response = httpRequest.get(uri);
        // System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals(200, response.getStatusCode());
        List<Map<String, String>> jsonResponse = response.jsonPath().getList("$");
        String providerDataId = jsonResponse.get(0).get("id");

        return providerDataId;

    }

    public void revalidationRequest(String cookies, String providerDataId, String timeToRevalidationPlus30d) {
        RestAssured.baseURI = SystemProperties.PROVIDER_MANAGEMENT_URL.getProperty();
        String uri = SystemProperties.REVALIDATION_WS_URL.getProperty();
        String payload = "{ \"providerDataId\" : \""+ providerDataId+ "\", \"timeToRevalidation\": \""+ timeToRevalidationPlus30d+"\" }";
        String endpoint = RestAssured.baseURI + uri;
        System.out.println(endpoint);

        RequestSpecification httpRequest = RestAssured.given()
                .relaxedHTTPSValidation()
                .cookie("auth_token", cookies)
                .header("Content-Type", "application/json")
                .body(payload)
                .when();
        Response response = httpRequest.post(endpoint);
        Assert.assertEquals(200, response.getStatusCode());

    }

    public boolean revalidationMessageIsDisplayed() {
        jsClick(WINDOW_REVALIDATION);
        return isElementPresent(WINDOW_REVALIDATION);
    }

    public boolean enrollmentMessageIsDisplayed() {
        jsClick(MODAL_WINDOW_ENROLLMENT);
        return isElementPresent(MODAL_WINDOW_ENROLLMENT);
    }

    public boolean redRevalidationMessageIsDisplayed() {
        jsClick(RED_WINDOW_REVALIDATION);
        return isElementPresent(RED_WINDOW_REVALIDATION);
    }

    public String getTextFromRedRevalidationMessage(){
        waitFor(ExpectedConditions.visibilityOf(findBy(RED_WINDOW_REVALIDATION)));
        String revalidationMessage = findBy(RED_WINDOW_REVALIDATION).getText();
        return revalidationMessage;
    }

    public String getTextFromRevalidationMessage(){
        waitFor(ExpectedConditions.visibilityOf(findBy(WINDOW_REVALIDATION)));
        String revalidationMessage = findBy(WINDOW_REVALIDATION).getText();
        System.out.println("!!!!" +revalidationMessage);
        return revalidationMessage;
    }


    public void revalidationRequest1(String cookies,String timeToRevalidationPlus30d) {
        RestAssured.baseURI = SystemProperties.PROVIDER_MANAGEMENT_URL.getProperty();
        String uri = SystemProperties.REVALIDATION_WS_URL.getProperty();
        String providerDataId =  ProviderProperties.getData("providerDataId") ;
        String payload = "{ \"providerDataId\" : \""+ providerDataId+ "\", \"timeToRevalidation\": \""+ timeToRevalidationPlus30d+"\" }";
        String endpoint = RestAssured.baseURI + uri;
        System.out.println(endpoint);

        RequestSpecification httpRequest = RestAssured.given()
                .relaxedHTTPSValidation()
                .cookie("auth_token", cookies)
                .header("Content-Type", "application/json")
                .body(payload)
                .when();
        Response response = httpRequest.post(endpoint);
        Assert.assertEquals(200, response.getStatusCode());

    }

    private static final String REMAINDER_NOTIFICATION = "//div[text()='%s']/parent::div//input";

    public void setRemindersForReviewersSettings(String notification, String days) {
        scrollToElement(format(REMAINDER_NOTIFICATION, notification));
        waitAbit(500);
        findBy(format(REMAINDER_NOTIFICATION, notification)).clear();
        waitAbit(500);
        findBy(format(REMAINDER_NOTIFICATION, notification)).type(days);
        waitAbit(500);
    }

    public String getRemainderNotification(String notification){
        return findBy(format(REMAINDER_NOTIFICATION, notification)).getValue();
    }

    public void revalidationRequestForFirstNotification(String cookies,String timeToRevalidationPlus90d) {
        RestAssured.baseURI = SystemProperties.PROVIDER_MANAGEMENT_URL.getProperty();
        String uri = SystemProperties.REVALIDATION_WS_URL1.getProperty();
        String providerDataId =  ProviderProperties.getData("providerDataId") ;
        String payload = "{ \"providerDataId\" : \""+ providerDataId+ "\", \"timeToRevalidation\": \""+ timeToRevalidationPlus90d+"\" }";
        String endpoint = RestAssured.baseURI + uri;
        System.out.println(endpoint);

        RequestSpecification httpRequest = RestAssured.given()
                .relaxedHTTPSValidation()
                .cookie("auth_token", cookies)
                .header("Content-Type", "application/json")
                .body(payload)
                .when();
        Response response = httpRequest.post(endpoint);
        Assert.assertEquals(200, response.getStatusCode());

    }
    public void revalidationRequestForSecondNotification(String cookies,String timeToRevalidationPlus60d) {
        RestAssured.baseURI = SystemProperties.PROVIDER_MANAGEMENT_URL.getProperty();
        String uri = SystemProperties.REVALIDATION_WS_URL2.getProperty();
        String providerDataId =  ProviderProperties.getData("providerDataId") ;
        String payload = "{ \"providerDataId\" : \""+ providerDataId+ "\", \"timeToRevalidation\": \""+ timeToRevalidationPlus60d+"\" }";
        String endpoint = RestAssured.baseURI + uri;
        System.out.println(endpoint);

        RequestSpecification httpRequest = RestAssured.given()
                .relaxedHTTPSValidation()
                .cookie("auth_token", cookies)
                .header("Content-Type", "application/json")
                .body(payload)
                .when();
        Response response = httpRequest.post(endpoint);
        Assert.assertEquals(200, response.getStatusCode());

    }
    public void revalidationRequestForThirdNotification(String cookies,String timeToRevalidationPlus30d) {
        RestAssured.baseURI = SystemProperties.PROVIDER_MANAGEMENT_URL.getProperty();
        String uri = SystemProperties.REVALIDATION_WS_URL3.getProperty();
        String providerDataId =  ProviderProperties.getData("providerDataId") ;
        String payload = "{ \"providerDataId\" : \""+ providerDataId+ "\", \"timeToRevalidation\": \""+ timeToRevalidationPlus30d+"\" }";
        String endpoint = RestAssured.baseURI + uri;
        System.out.println(endpoint);

        RequestSpecification httpRequest = RestAssured.given()
                .relaxedHTTPSValidation()
                .cookie("auth_token", cookies)
                .header("Content-Type", "application/json")
                .body(payload)
                .when();
        Response response = httpRequest.post(endpoint);
        Assert.assertEquals(200, response.getStatusCode());

    }
    private static final String REVALIDATION_TEXT="//p[text()='%s']";

    public boolean verifyTheRevalidationText(String months){
        waitAbit(500);
        return isElementPresent(String.format(REVALIDATION_TEXT,months));
    }
public String getProviderDataID(){
    String currentURL = getDriver().getCurrentUrl();
    System.out.println("Current URL: " + getDriver().getCurrentUrl());
    String uriStr = currentURL;
    URI uri = URI.create(uriStr);
    String query = uri.getPath();
    String providerDataId = query.substring(query.lastIndexOf('/') + 1);
    System.out.println("ProviderId: " + providerDataId);
    return providerDataId;
}

    private static final String NEXT_REVALIDATION_DATE="(//div[contains(@class,'revalidation_col-item')]//p)[3]";
    public void verifyAndGetNextRevalidationDate(){
        try{
            findBy(NEXT_REVALIDATION_DATE).isDisplayed();
            System.out.println("Next Revalidation date field is present");
            String revalidationDate=findBy(NEXT_REVALIDATION_DATE).getText();
            System.out.println("Next Revalidation date is:"+ revalidationDate);
        }
        catch (Exception e){
            System.err.println("====NEXT REVALIDATION DATE FIELD IS NOT DISPLAYED====");
        }

    }




}
