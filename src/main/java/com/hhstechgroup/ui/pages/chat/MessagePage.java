package com.hhstechgroup.ui.pages.chat;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class MessagePage extends PageObject {

    private static final String MESSAGE_BOX_ICON = "//button[contains(@aria-label, 'message box')]";
    public void clickOnMessageBox(){
        findBy(MESSAGE_BOX_ICON).click();
    }


    private static final String NEW_MESSAGE = "//span[contains(text(), 'NEW MESSAGE')]";
    public void clickOnNewMessage(){
        findBy(NEW_MESSAGE).click();
    }

    private static final String ENTER_EMAIL = "//input[contains(@id, 'To')]";
    public void enterEmail(String email){
        findBy(ENTER_EMAIL).sendKeys(email);
    }

    private static final String REQUEST_ID = "//input[contains(@id, 'Request ID')]";
    public void clickOnRequestId(){
        findBy(REQUEST_ID).click();
    }

    private static final String SELECT_REQUEST_ID = "//li[@tabindex ='0']";
    public void selectRequestId(){
        findBy(SELECT_REQUEST_ID).click();
    }

    private static final String SUBJECT = "//input[contains(@id, 'Subject')]";
    public void enterSubject(){
        findBy(SUBJECT).click();
        findBy(SUBJECT).sendKeys("WELCOME");
    }

    WebElement driver;
    private static final String PROVIDER_NAME = "/html/body/div[3]/div[2]/div[2]/div[2]/div[1]/p";
    public void getProviderName(){
        findBy(PROVIDER_NAME).getText();
        System.out.println(""+PROVIDER_NAME);
    }

    private static final String PROVIDER_NPI = "/html/body/div[3]/div[2]/div[2]/div[2]/div[2]/p";
    public void getProviderNPI(){
        findBy(PROVIDER_NPI).getText();
        System.out.println(""+PROVIDER_NPI);
    }


    private static final String SEND_MESSAGE = "//button[span[text() = 'Send']]";
    public void sendMessage(){
        findBy(SEND_MESSAGE).click();
    }



}
