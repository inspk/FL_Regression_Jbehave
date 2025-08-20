package com.hhstechgroup.steps.jbehave.scenarios.systemoptions;

import com.hhstechgroup.steps.serenity.systemoption.NotificationEngineSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NotificationEngineScenario {

    @Steps
    NotificationEngineSteps notificationEngineSteps;

    @When("click on 'Edit Button' in the notification engine page")
    public void clickoneditbutton() {
        notificationEngineSteps.clickoneditbutton();
    }

    @When("set the effective start date '${date}' in notification engine page")
    public void setEffectiveStartDate(String date){
        notificationEngineSteps.setEffectiveStartDate(date);
    }

    @When("set the effective end date '${date}' in notification engine page")
    public void setEffectiveEndDate(String date){
        notificationEngineSteps.setEffectiveEndDate(date);
    }

    @When("{Enable|Disable} the '$value' message notification in the notification engine page")
    public void clickOnMessageNotification(String infoType){
        notificationEngineSteps.clickOnMessageNotification(infoType);
    }

    @When("{Enable|Disable} the '$value' email notification in the notification engine page")
    public void clickOnEmailNotification(String infoType){
        notificationEngineSteps.clickOnEmailNotification(infoType);
    }

    @When("{Enable|Disable} trigger all the E-mail communications to registered E-mail ID button")
    public void clickRegisteredEmailSwitch(){
        notificationEngineSteps.clickOnRegisteredEmailTriggerButton();
    }

    @When("{Enable|Disable} trigger all the E-mail communications to application Contact E-mail ID button")
    public void clickApplicationContactEmailSwitch(){
        notificationEngineSteps.clickOnApplicationEmailTriggerButton();
    }

    @When("click on the save button in the notification engine page")
    public void clickSave(){
        notificationEngineSteps.clickSave();
        notificationEngineSteps.clickOk();
    }

    @When("verify the popup message '$message' on notification engine page")
    public void verifyPopup(String expected){
        String actual = notificationEngineSteps.verifyDialog();
        System.out.println("Alert message is " + actual);
        assertEquals(expected + " is not message not displayed!", actual, expected);
    }

    @Then("set the Custom Section Settings as:$table")
    public void setCustomSectionSettings(ExamplesTable table){
        for (Map<String,String> row : table.getRows()) {
            String section = row.get("Sections");
            String button = row.get("Switches");
            System.out.println("|"+section+"|"+button+"|");
            if(button.equalsIgnoreCase("on")) {
                if(notificationEngineSteps.isCustomSectionEnabled(section)){
                    System.out.println(section + " already enabled!");
                }
                else {
                    notificationEngineSteps.enableCustomSection(section);
                }
            }
            else {
                if(notificationEngineSteps.isCustomSectionEnabled(section)) {
                    notificationEngineSteps.enableCustomSection(section);
                }
                else {
                    System.out.println(section + " already disabled!");
                }
            }
        }
    }

    @Then("verify Notification Engine details:$table")
    public void verifyNotificationEngine(ExamplesTable table){
        for (Map<String,String> row : table.getRows()) {
            String info_type = row.get("Info type");
            String message_center = row.get("Message center");
            String email = row.get("Email");
            System.out.println("|"+info_type+"|"+message_center+"|"+email+"|");
            assertEquals(Boolean.parseBoolean(message_center), notificationEngineSteps.isMessageCenterEnabled(info_type));
            assertEquals(Boolean.parseBoolean(email), notificationEngineSteps.isEmailEnabled(info_type));
        }
    }

}
