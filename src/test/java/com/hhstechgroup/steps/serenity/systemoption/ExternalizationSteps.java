package com.hhstechgroup.steps.serenity.systemoption;


import com.hhstechgroup.beans.application.TaxonomyBean;
import com.hhstechgroup.ui.pages.ExternalizationPage;
import com.hhstechgroup.ui.panels.systemoptions.ExternalizationPanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ExternalizationSteps extends ScenarioSteps {
    //adding Taxonomy in sp21

    ExternalizationPage externalizationPage;
    ExternalizationPanel externalizationPanel;


    @Step
    public void setTaxonomyInfo(TaxonomyBean newTaxnomyBeans) {
        ExternalizationPanel panel = externalizationPage.getTaxonomyInfo();
        waitABit(500);
        BeanUtils.copyPropertiesInOrder(panel, newTaxnomyBeans);
    }

    @Step
    public void clickOnAddTaxonomyButton(){
        externalizationPage.clickOnAddTaxonomyButton();
    }

    @Step
    public void saveTaxonomy(){
        externalizationPage.saveTaxonomy();
    }

    //SD-10 fild validation

    @Step
    public boolean isSaveButtonEnabled(){
        return externalizationPage.isSaveButtonEnabled();
    }
}
