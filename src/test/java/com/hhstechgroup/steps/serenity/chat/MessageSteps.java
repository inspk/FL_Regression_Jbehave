package com.hhstechgroup.steps.serenity.chat;

import com.hhstechgroup.ui.pages.chat.MessagePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MessageSteps extends ScenarioSteps {

    MessagePage messagePage;

    @Step
    public void clickOnMessageBox() {
        messagePage.clickOnMessageBox();
    }

    @Step
    public void clickOnNewMessage() {
        messagePage.clickOnNewMessage();
    }

    @Step
    public void enterEmail(String email) {
        messagePage.enterEmail(email);
    }

    @Step
    public void selectRequestId() {
        messagePage.clickOnRequestId();
        waitABit(200);
        messagePage.selectRequestId();
    }

    @Step
    public void enterSubject() {
        messagePage.enterSubject();
    }

    @Step
    public void verifyProviderNameAndNPI() {
        messagePage.getProviderName();
        waitABit(200);
        messagePage.getProviderNPI();
    }

    @Step
    public void sendMessage() {
        messagePage.sendMessage();
    }

}
