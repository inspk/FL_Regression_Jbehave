package com.hhstechgroup.steps.serenity.systemoption;

import com.hhstechgroup.beans.application.RequestAddtionalInformationBean;
import com.hhstechgroup.ui.pages.systemoptions.RequestAddtionalInformationPage;
import com.hhstechgroup.ui.panels.systemoptions.RequestAddtionalInformationPanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;

public class RequestAddtionalInformationSteps extends ScenarioSteps {

    @Page
    RequestAddtionalInformationPage requestAddtionalInformationPage;

    @Step
    public void clickEditButton() {
        requestAddtionalInformationPage.clickEditButton();
    }

    @Step
    public void clickOnEnableAutoDeny(String enableautodeny){
        requestAddtionalInformationPage.clickOnEnableAutoDeny(enableautodeny);
    }
    @Step
    public void setRequestAddtionalInfo(RequestAddtionalInformationBean notifications) {
        RequestAddtionalInformationPanel panel=requestAddtionalInformationPage.getRequestAdditonalInfo();
        waitABit(3000);
        BeanUtils.copyPropertiesInOrder(panel, notifications);
    }
    @Step
    public void clickSave() {
        requestAddtionalInformationPage.clickSaveButton();
    }


    @Step
    public String getFirstNotification(){
        return requestAddtionalInformationPage.getRequestAdditonalInfo().getFirstNotification();
    }
    @Step
    public String getSecondNotification(){
        return requestAddtionalInformationPage.getRequestAdditonalInfo().getSecondNotification();
    }
    @Step
    public String getThirdNotification(){
        return requestAddtionalInformationPage.getRequestAdditonalInfo().getThirdNotification();
    }
}

