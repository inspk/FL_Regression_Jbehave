package com.hhstechgroup.steps.jbehave.scenarios.systemoptions;

import com.hhstechgroup.beans.application.LicensureBean;
import com.hhstechgroup.beans.application.TaxonomyBean;
import com.hhstechgroup.steps.serenity.systemoption.LicensureSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class LicensureScenario {
    @Steps
    LicensureSteps licensureSteps;

    @When("set the Licensure Remainders notifications info: $table")
    public  void setLicensureInfo(ExamplesTable user){
        licensureSteps.setLicensureInfo(ExamplesTableUtil.parseTableToClass(user, LicensureBean.class).get(0));
    }
    @When("click on save changes button in Licensure page")
    public void clickOnSave() {
        licensureSteps.clickSave();
    }
}
