package com.hhstechgroup.steps.jbehave.scenarios;


import com.hhstechgroup.beans.application.OtherCredentialingInformationBean;
import com.hhstechgroup.steps.serenity.OtherCredentialingInformationSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class OtherCredentialingInformationScenario {

    @Steps
    OtherCredentialingInformationSteps otherCredentialingInformationSteps;
    @When("To fill the Other Credentialing Information Info for Enrollment: $table")
    public void setOtherCredentialingInformationInfo(ExamplesTable user){
        otherCredentialingInformationSteps.setOtherCredentialingInformationInfo(ExamplesTableUtil.parseTableToClass(user, OtherCredentialingInformationBean.class).get(0));

    }

}
