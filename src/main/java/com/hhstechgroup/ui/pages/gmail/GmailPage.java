package com.hhstechgroup.ui.pages.gmail;


import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.util.common.Wait;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.log4j.Logger;
import org.joda.time.LocalTime;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.hhstechgroup.util.properties.SystemProperties.*;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.substringAfter;

public class GmailPage extends AbstractPage {

    private static final String EMAIL = ".//input[contains(@id, 'identifierId')]";
    private static final String EMAIL_NEXT_BUTTON = ".//div[contains(@id, 'identifierNext')]";
    private static final String PASSWORD = ".//input[contains(@name, 'Passwd')]";
    private static final String PASSWORD_NEXT_BUTTON = ".//div[contains(@id, 'passwordNext')]";
    private static final String GMAIL_ICON = ".//a[@aria-label = 'Mail']";
    private static final String INBOX_EMAIL = ".//div[contains(@role, 'main')]//table/tbody/tr";
    private static final String EMAIL_TIME = ".//td[9]/span";
    private static final String UNREAD_EMAIL_TITLE = "(.//td[6]//span)[12]";
    //    private static final String UNREAD_EMAIL_TITLE = ".//td[6]//span[contains(text(),'Registration in IU Portal')]";
//    private static final String UNREAD_EMAIL_TITLE = "(.//td[6]//span[@class='bqe'])[1]" ;
    private static final String EMAIL_BODY = "(//div[@class='gs']//table)[4]";
    private static final String EMAIL_LINK = ".//center//h3/a";
    private static final String EMAIL_BUTTON = ".//center//h3/ancestor::td//td/a";
    private static final String EMAIL_DETAILS = ".//*[contains(@aria-label, 'Show details')]";
    private static final String UNREAD_MESSAGE_COLOR = "rgba(255, 255, 255, 0.9)";
    private static final String RECEIVER_EMAIL = ".//table//tr/td[span[text() = 'to:']]/following-sibling::td";
    private static final String SEARCH_INPUT = ".//form[@role='search']//input[@type='text']/../input";  //recently xpath modified
    //    private static final String SEARCH_BUTTON = ".//button[@aria-label='Search Mail']";
    //sp29
    private static final String SEARCH_BUTTON = ".//button[@aria-label='Search mail']";
    private static final String INBOX_LINK = ".//a[contains(@title, 'Inbox')]";

    private Logger logger = Logger.getLogger(GmailPage.class);

    public GmailPage(WebDriver driver) {
        super(driver);
    }

    public void returnToInbox() {
        findBy(INBOX_LINK).click();
    }

    public void openPage() {
        getDriver().navigate().to(GMAIL_SIGN_IN_URL.getProperty());
    }

    public void typeEmail(){
        findBy(EMAIL).type(GMAIL_LOGIN.getProperty());
    }
    //latest
    public void typeSupervisorEmail(){ findBy(EMAIL).type(SGMAIL_LOGIN.getProperty()); }
    public void typeSupervisorPassword(){
        findBy(PASSWORD).type(SGMAIL_PASSWORD.getProperty());
    }

    public void clickEmailNext(){
        findBy(EMAIL_NEXT_BUTTON).click();
        waitAbit(1000);
    }

    public void typePassword(){
        findBy(PASSWORD).type(GMAIL_PASSWORD.getProperty());
    }

    public void clickPasswordNext(){
        findBy(PASSWORD_NEXT_BUTTON).click();
        waitAbit(1000);
    }

    public void selectGmail(){
        jsClick(GMAIL_ICON);
        // findBy(GMAIL_ICON).click();
        waitAbit(2000);
    }

    public String getReceiverEmail(){
        return findBy(RECEIVER_EMAIL).getText();
    }

    public void openCloseEmailDetais() {
        findBy(EMAIL_DETAILS).click();
    }

    public boolean isEmailTextCorrect(String text){
        String emailText = findBy(EMAIL_BODY).getText();
        logger.info("Expected email text: " + text);
        logger.info("Email text is: " + emailText);
        return emailText.contains(text);
    }

    public boolean isLinkTextCorrect(String text){
        String linkText = findBy(EMAIL_LINK).getText();
        logger.info("Link text is: " + linkText);
        return linkText.contains(text);
    }

    public boolean isButtonTextCorrect(String button) {
        return findBy(EMAIL_BUTTON).getText().contains(button);
    }

    public boolean isLinkCorrect (String expectedRelativeURI){
        String uri = findBy(EMAIL_LINK).getAttribute("data-saferedirecturl");
        logger.info("Relative uri text is: " + uri);
        return uri.contains(expectedRelativeURI);
    }
    //latest
    private static final String SWITCH_TO_FRAME = "//link[@id = 'embedded_data_iframe']";
    public void clickOnEmailLink(){
        waitAbit(1000);
        jsClick(EMAIL_LINK);
        waitAbit(3000);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));

    }
    public boolean isNewEmailPresent(String emailTitle){
        String creationTime = Serenity.sessionVariableCalled(emailTitle);
        logger.info(format("Email received time is %s", creationTime));
        LocalTime timeAfter = LocalTime.parse(DateConverter.to24HFormat(creationTime));
        waitAbit(3000);
        Wait wait = new Wait(15);
        wait.waitForCondition(isOneMessageFound, getUnreadMessage(emailTitle, timeAfter));
        if (isOneMessageFound.test(getUnreadMessage(emailTitle, timeAfter))) {
            return true;
        }
        return false;
    }

//    private static final String TITLE = ".//td[6]";
    private static final String TITLE = "(.//td[4])[2]";
    public void openNewEmail(String emailTitle){
        //String creationTime = Serenity.sessionVariableCalled(emailTitle);
        //logger.info(format("Email received time is %s", creationTime));
       // LocalTime timeAfter = LocalTime.parse(DateConverter.to24HFormat(creationTime));
        waitAbit(5000);
        jsClick(format(TITLE,emailTitle));

    }

    private static final String EMAIL_TITLE = "//td//*[text()='%s']";
    public void openEmail(String emailTitle){
        waitAbit(5000);
        jsClick(format(EMAIL_TITLE, emailTitle));

    }

    public void searchForMessage(String criteria) { waitAbit(1000);
        waitAbit(3000);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        waitAbit(2000);
        jsClick(SEARCH_INPUT);                                 //recently added
        findBy(SEARCH_INPUT).type(criteria);
        findBy(SEARCH_INPUT).sendKeys(Keys.ENTER);
        //sp29
        waitAbit(2000);
        //findBy(SEARCH_BUTTON).click();
        waitForAbsenceOf(".//tr[@role='tablist']");
    }

    private Predicate<List<WebElementFacade>> isOneMessageFound = messages -> messages.size() == 1;

    private List<WebElementFacade> getUnreadMessage(String title, LocalTime timeAfter) {
        return findAll(INBOX_EMAIL).stream().filter(mail -> mail.getCssValue("background-color").equals(UNREAD_MESSAGE_COLOR))
                .filter(mail -> {
                    waitAbit(3000);
                    return mail.findBy(TITLE).getText().equals(title);
                })
                .filter(unread -> checkReceivedTime.test(unread, timeAfter))
                .collect(Collectors.toList());
    }

    private BiPredicate<WebElementFacade, LocalTime> checkReceivedTime = (message, timeAfter) -> {
        String currentDate = DateConverter.convert(LocalDateTime.now(), "MMM d");
        String title = message.findBy(EMAIL_TIME).getAttribute("title");
        if (title.contains(currentDate)) {
            LocalTime receivedTime = LocalTime.parse(DateConverter.to24HFormat(substringAfter(title, "2019, ").toUpperCase()));
            return receivedTime.isEqual(timeAfter) || receivedTime.isAfter(timeAfter);
        }
        return false;
    };

    //sp21
    public void openNewEmail1(String emailTitle){
        String creationTime = Serenity.sessionVariableCalled(emailTitle);
        logger.info(format("Email received time is %s", creationTime));
        waitAbit(5000);
        jsClick(format(TITLE,emailTitle));

    }

    //sp23
    public void typeEmailUserName(){
        findBy(EMAIL).type(GMAIL_USER_LOGIN.getProperty());
    }

    public void typeUserPassword(){
        findBy(PASSWORD).type(GMAIL_USER_PASSWORD.getProperty());
    }

    private static final String SELECT_CHECKBOX = ".//div[contains(@aria-label,'Select')]//span[contains(@role,'checkbox')]";
    private static final String DELETE_BUTTON =".//div[contains(@aria-label,'Delete')]";
    public void selectDeleteCheckboxInGmail(){
        waitAbit(3000);
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        waitAbit(2000);
        try {
            jsClick(SELECT_CHECKBOX);
            waitAbit(1000);
            findBy(DELETE_BUTTON).click();
        }
        catch (Exception e){
            System.out.println("Already Existing Gmails are Deleted"); }
    }
    //sp24
    public void openCollemail(String emailTitle){
        String creationTime = Serenity.sessionVariableCalled(emailTitle);
        logger.info(format("Email received time is %s", creationTime));
        waitAbit(5000);
        jsClick(format(TITLE,emailTitle));
    }

    //sp 59 random npi from the list

    public String getNpiFromList(String file){
        try {
            List<String> values = Files.readAllLines(Paths.get("integration", file + ".csv"));
            return values.get((int) (Math.random() * values.size()));
        } catch (IOException e) {
            throw new RuntimeException("Not possible to read String in file");
        }
    }
}