package com.hhstechgroup.steps.serenity.IUFlowSteps;

import com.hhstechgroup.ui.pages.IUFlowPages.AffiliationPages;
import com.hhstechgroup.ui.pages.IUFlowPages.IUMCOPage;
import com.hhstechgroup.ui.pages.iuportal.IUDashboardPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class AddingMCOSteps extends ScenarioSteps {

    public IUMCOPage iuMCOPage;
    public AffiliationPages affiliationPages;

    @Step
    public void clickAddMCOButton() {
        iuMCOPage.clickAddMCOButton();
    }

    public void setAnyOwnersLessThanFivePercent(){
        iuMCOPage.setAnyOwnersLessThanFivePercent();
    }

    public void click_Go_TO_MCO(){
        iuMCOPage.click_GO_TO_MCO();
    }

    public void fillInAffiliationSectionwithMCO(String enrolltype,String plantype){
        affiliationPages.fillInAffiliationSectionwithMCO(enrolltype,plantype);
    }

    public void fillInAffiliationSectionforMCO(String enrolltype){
        affiliationPages.fillInAffiliationSectionforMCO(enrolltype);
    }
}
