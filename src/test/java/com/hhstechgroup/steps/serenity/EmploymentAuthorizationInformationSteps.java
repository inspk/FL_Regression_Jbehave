package com.hhstechgroup.steps.serenity;

import com.hhstechgroup.beans.application.EmploymentAuthorizationInformationBean;
import com.hhstechgroup.ui.pages.EmploymentAuthorizationInformationPage;
import com.hhstechgroup.ui.panels.enrollment.EmploymentAuthorizationInformationPanel;
import com.hhstechgroup.util.common.BeanUtils;

public class EmploymentAuthorizationInformationSteps {
    EmploymentAuthorizationInformationPage employmentAuthorizationInformationPage;

    public void setEmploymentAuthorizationInformation(EmploymentAuthorizationInformationBean employmentAuthorizationInformationBean){
        EmploymentAuthorizationInformationPanel panel=employmentAuthorizationInformationPage.getEmploymentAuthorizationInformation();
        panel.waitForSectionPulledUp();
        BeanUtils.copyPropertiesInOrder(panel, employmentAuthorizationInformationBean);
    }

}
