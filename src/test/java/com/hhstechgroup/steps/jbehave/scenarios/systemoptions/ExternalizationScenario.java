package com.hhstechgroup.steps.jbehave.scenarios.systemoptions;

import com.hhstechgroup.beans.application.IdentifyingInformationBean;
import com.hhstechgroup.beans.application.TaxonomyBean;
import com.hhstechgroup.steps.serenity.systemoption.ExternalizationSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExternalizationScenario {

    //adding Taxonomy in sp21

    @Steps
    ExternalizationSteps externalizationSteps;

    @When("set Taxonomy info: $table")
    public  void setTaxonomyInfo(ExamplesTable user){
        externalizationSteps.setTaxonomyInfo(ExamplesTableUtil.parseTableToClass(user, TaxonomyBean.class).get(0));
    }

    @When("click on add taxonomy button in the exteronalization")
    public void clickOnAddTaxonomyButton(){
        externalizationSteps.clickOnAddTaxonomyButton();
    }

    @When("save taxonomy from the exteronalization")
    public void saveTaxonomy(){
        externalizationSteps.saveTaxonomy();
    }

    //SD-10 fild validation

    @When("save button should be disabled")
    public void verifySaveButtonDisabled(){
        assertFalse("Save button not Disabled", externalizationSteps.isSaveButtonEnabled());
    }

    @When("save button should be enabled")
    public void verifySaveButtonEnabled(){
        assertTrue("Save button not Enabled", externalizationSteps.isSaveButtonEnabled());
    }


}
