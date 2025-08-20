package com.hhstechgroup.steps.jbehave.scenarios.systemoptions;
import com.hhstechgroup.beans.application.RequestAddtionalInformationBean;
import com.hhstechgroup.steps.serenity.systemoption.RequestAddtionalInformationSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class RequestAddtionalinformationScenario {

    @Steps
    RequestAddtionalInformationSteps requestAddtionalInformationSteps;

    @Then("click on the edit button in the RequestAddtionalInfo page")
    public void clickEditButton() {
        requestAddtionalInformationSteps.clickEditButton();
    }

    @Then("{Enable|Disable} the '$value' switch in RequestAddtionalInfo page")
    public void clickOnEnableAutoDeny(String enableautodeny){
        requestAddtionalInformationSteps.clickOnEnableAutoDeny(enableautodeny);
    }

    @When("set the RequestAddtionalInfomation Remainders notifications info: $table")
    public  void setRequestAddtionalInfo(ExamplesTable user){
        requestAddtionalInformationSteps.setRequestAddtionalInfo(ExamplesTableUtil.parseTableToClass(user, RequestAddtionalInformationBean.class).get(0));
    }
    @When("click on save changes button in requestAddtionalInfo page")
    public void clickOnSave() {
        requestAddtionalInformationSteps.clickSave();
    }
}
