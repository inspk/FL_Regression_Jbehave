package com.hhstechgroup.steps.jbehave.scenarios.IUFlowScenarios;

import com.hhstechgroup.steps.serenity.IUFlowSteps.PlanType_GroupTypeSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;

public class PlanType_groupTypeScenarios {
    @Steps
    PlanType_GroupTypeSteps planTypeGroupTypeSteps;

    @Then("fill in plantype field with value '$plantype'")
    public void fillInPlanTypeField(String plantype){
        planTypeGroupTypeSteps.fillInplantypeField(plantype);
    }

    @Then("fill in grouptype field with value '$grouptype'")
    public void fillInGroupTypeField(String grouptype){
        planTypeGroupTypeSteps.fillIngrouptypeField(grouptype);
    }
}
