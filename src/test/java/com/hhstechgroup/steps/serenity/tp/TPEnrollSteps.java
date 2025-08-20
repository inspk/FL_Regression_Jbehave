package com.hhstechgroup.steps.serenity.tp;


import com.hhstechgroup.beans.application.SoftwareVendorDetailsBean;
import com.hhstechgroup.ui.pages.enrollment.EnrollmentPage;
import com.hhstechgroup.ui.pages.tp.TPEnrollPage;
import com.hhstechgroup.ui.panels.enrollment.SoftwareVendorDetailsPanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;

public class TPEnrollSteps extends ScenarioSteps {
    @Page
    TPEnrollPage tpenrollPage;
    EnrollmentPage enrollmentPage;

    @Step
    public  void  setAppContactEmail(String email){ tpenrollPage.setAppContactEmail(email);}
    @Step
    public  void clickOnNextButton(){tpenrollPage.clickOnNextButton();}

    //latest
    @Step
    public void getSoftwareVendorPanel(SoftwareVendorDetailsBean criteria) {
        SoftwareVendorDetailsPanel panel = enrollmentPage.getSoftwareVendorPanel();
        waitABit(1000);
        BeanUtils.copyPropertiesInOrder(panel, criteria);
    }
}
