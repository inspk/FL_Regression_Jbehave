package com.hhstechgroup.steps.jbehave.scenarios.systemoptions;

import com.hhstechgroup.steps.serenity.systemoption.DataChangeSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class DataChangeScenario {
    @Steps
    DataChangeSteps dataChangeSteps;

    @Then("click on 'Edit Button' in the datachange page")
    public void clickoneditbutton() { dataChangeSteps.clickoneditbutton(); }

    @Then("{Enable|Disable} the '$value' Notification in the data change page")
    public void clickOnNotification(String infoType){dataChangeSteps.clickOnNotification(infoType);}

    @Then("click on the save button in the data change page")
    public void clickOnSaveButton() {dataChangeSteps.clickOnSaveButton();}

    @Then("{Enable|Disable} the '$value' Corfimation in the data change page")
    public void clickOnConfirmation(String confirmation){dataChangeSteps.clickOnConfirmation(confirmation);}

    @Then("click on close data change popup")
    public void   clickOnClosepopup(){dataChangeSteps.clickOnClosepopup();}

    @When("click the datachange notification banner '$banner' in the PE")
    public void clickDataChangeNotificationBanner(String banner){
        dataChangeSteps.clickDataChangeNotificationBanner(banner);}

        @Then("click the datachange review '$dicardall' in the PE")
        public void clickDataChangeReviewDiscardAll(String discardall){dataChangeSteps.clickDataChangeReviewDiscardAll(discardall);}

     @Then("click submit button in the datachange review in the PE/IU")
     public void clickSubmitButton(){dataChangeSteps.clickSubmitButton();}

     @Then("click on the override icon in the IU")
     public void clickOnOverideIcon(){dataChangeSteps.clickOnOverideIcon();}

     @Then("click on the overide option in the datachange review in IU")
     public void clickOnOverideOption(){dataChangeSteps.clickOnOverideOption();}

    @When("select datachange override reason '$reason' and '$note' Provider in IU")
    public void setReasonForDataChangeOverride(String reason,String note){
        dataChangeSteps.setReasonForDataChangeOverride(reason,note);}
    //sp37
    @Then("click on close enrollment type popup")
    public void   clickOnClosep(){dataChangeSteps.clickOnClosepopup();}

    //sp44.2
    @When("set the effective start date '$effectivestartDate' in data change page")
    public void setEffectiveStartDate(String effectiveStartDate) {
        dataChangeSteps.setEffectiveStartDate(effectiveStartDate);
    }
}
