package com.hhstechgroup.steps.serenity;

import com.hhstechgroup.ui.pages.HelloSignPage;
import net.thucydides.core.annotations.Step;

public class HelloSignSteps {

    HelloSignPage helloSignPage;

    @Step
    public void setFullName(String fullName) {
        helloSignPage.switchToFrame();
        helloSignPage.closeWarningModal();
        helloSignPage.setFullName(fullName);
    }

    @Step
    public void clickSign(){
        helloSignPage.clickSignButton();
    }

    @Step
    public void clickToSign() {
        helloSignPage.clickClickToSign();
    }

    @Step
    public void createSignature() {
        helloSignPage.createSignature();
    }

    @Step
    public void clickContinue() {
        helloSignPage.clickContinue();
    }

    @Step
    public void clickAgree() {
        helloSignPage.clickAgree();
    }

    @Step
    public void waitForDocumentSigned() {
        helloSignPage.waitForDocumentSigned();
    }

    //Newly Added
    @Step
    public void createSignature1() {
        helloSignPage.createSignature1();
    }

    @Step
    public void clickToSign1() {
        helloSignPage.clickClickToSign1();
    }

    @Step
    public void clickAffiliationSign() {helloSignPage.clickAffiliationSign();}


    //sp34 after new signature tool  upated
    @Step
    public void createSignature2(String yourName) {
        helloSignPage.createSignature2(yourName);
    }

    @Step
    public void enterSignTitel() {
        helloSignPage.enterSignTitel();
    }

    //41.3
    @Step
    public void clickYesAndGetStarted() {
        helloSignPage.clickOnYes();
        helloSignPage.switchToFrame();
        helloSignPage.closeWarningModal();
        helloSignPage.clickGetStarted();
    }

    @Step
    public void setFullName1(String fullName) {
        helloSignPage.setFullName1(fullName);
    }

    @Step
    public String getAgreementNPI() {
        return helloSignPage.getAgreementNPI();
    }

    @Step
    public String getAgreementProvidername() {
        return helloSignPage.getAgreementProvidername();
    }
    @Step
    public void clickGetStarted() {
        helloSignPage.switchToFrame();
        helloSignPage.closeWarningModal();
        helloSignPage.clickGetStarted();
    }

}
