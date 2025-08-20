package com.hhstechgroup.steps.serenity;

import com.hhstechgroup.beans.application.OtherCredentialingInformationBean;
import com.hhstechgroup.ui.pages.OtherCredentialingInformationPage;
import com.hhstechgroup.ui.panels.enrollment.OtherCredentialingInformationPanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;

public class OtherCredentialingInformationSteps {
    OtherCredentialingInformationPage otherCredentialingInformationPage;

    public void setOtherCredentialingInformationInfo(OtherCredentialingInformationBean otherCredentialingInformationBean) {
        OtherCredentialingInformationPanel panel = otherCredentialingInformationPage.getOtherCredentialingInformation();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, otherCredentialingInformationBean);
    }

}
