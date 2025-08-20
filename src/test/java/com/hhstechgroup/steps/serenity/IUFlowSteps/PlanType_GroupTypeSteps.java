package com.hhstechgroup.steps.serenity.IUFlowSteps;

import com.hhstechgroup.ui.pages.IUFlowPages.PlanType_GroupTypePages;
import net.thucydides.core.steps.ScenarioSteps;

public class PlanType_GroupTypeSteps extends ScenarioSteps {

    PlanType_GroupTypePages planTypeGroupTypePages;

    public void fillInplantypeField(String plantype){
        planTypeGroupTypePages.setPlanTypefield(plantype);
    }

    public void fillIngrouptypeField(String grouptype){
        planTypeGroupTypePages.setGroupTypefield(grouptype);
    }
}
