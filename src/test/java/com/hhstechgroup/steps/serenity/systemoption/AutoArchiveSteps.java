package com.hhstechgroup.steps.serenity.systemoption;


import com.hhstechgroup.beans.application.AutoArchiveBean;
import com.hhstechgroup.ui.pages.sitevisit.UserPage;
import com.hhstechgroup.ui.pages.systemoptions.AutoArchivePage;
import com.hhstechgroup.ui.panels.systemoptions.AutoArchivePanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;

public class AutoArchiveSteps extends ScenarioSteps {
    @Page
    UserPage userPage;

    @Page
    AutoArchivePage autoArchivePage;

    @Step
    public  void setAutoArchiveInfor(AutoArchiveBean newAutoArchiveInfo) {
        AutoArchivePanel panel = userPage.getAutoArchiveInfo();
        waitABit(2000);
        BeanUtils.copyPropertiesInOrder(panel, newAutoArchiveInfo);
    }

    @Step
    public void clickOnEditButton(String button){autoArchivePage.clickOnEditButton(button);}

    @Step
    public void clickOnSaveButton(String button){autoArchivePage.clickOnSaveButton(button);}
    //sp43.2
    @Step
    public void setEffectiveStartDate(String effectiveStartDate) {
        autoArchivePage.setEffectiveStartDate(effectiveStartDate);
    }

    //sp59

    @Step
    public void clickOnCancelButtton(){autoArchivePage.clickOnCancelButtton();}
}
