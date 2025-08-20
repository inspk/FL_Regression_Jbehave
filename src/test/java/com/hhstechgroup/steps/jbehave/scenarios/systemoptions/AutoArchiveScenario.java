package com.hhstechgroup.steps.jbehave.scenarios.systemoptions;

import com.hhstechgroup.beans.application.AutoArchiveBean;
import com.hhstechgroup.beans.application.PaymentConfigarationBean;
import com.hhstechgroup.steps.serenity.systemoption.AutoArchiveSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class AutoArchiveScenario {
    @Steps
    AutoArchiveSteps autoArchiveSteps;


    @When("user fill auto archive info: $table")
    public void setAutoArchiveInfor(ExamplesTable autoArchive) {
        autoArchiveSteps.setAutoArchiveInfor(ExamplesTableUtil.parseTableToClass(autoArchive, AutoArchiveBean.class).get(0));
    }
    @When("click on edit '$button' page")
    public void clickOnEditButton(String button){autoArchiveSteps.clickOnEditButton(button);}

    @When("click on save '$button' page")
    public void clickOnSaveButton(String button){autoArchiveSteps.clickOnSaveButton(button);}

    //sp43.2
    @When("set the effective start date '$effectivestartDate' in auto archive page")
    public void setEffectiveStartDate(String effectiveStartDate) {
        autoArchiveSteps.setEffectiveStartDate(effectiveStartDate);
    }

    //sp59

    @When("click on cancel button in auto archive page")
    public void clickOnCancelButtton(){autoArchiveSteps.clickOnCancelButtton();}
}
