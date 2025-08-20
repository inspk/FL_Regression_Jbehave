package com.hhstechgroup.steps.serenity.systemoption;

import com.hhstechgroup.beans.application.LicensureBean;
import com.hhstechgroup.beans.application.TaxonomyBean;
import com.hhstechgroup.ui.pages.systemoptions.LicensurePage;
import com.hhstechgroup.ui.panels.systemoptions.ExternalizationPanel;
import com.hhstechgroup.ui.panels.systemoptions.LicensurePanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LicensureSteps extends ScenarioSteps {

    LicensurePage licensurePage;

    @Step
    public void setLicensureInfo(LicensureBean notifications) {
        LicensurePanel panel = licensurePage.getLicensureInfo();
        waitABit(500);
        BeanUtils.copyPropertiesInOrder(panel, notifications);
    }

    @Step
    public void clickSave() {
        licensurePage.clickSaveButton();
    }
}
