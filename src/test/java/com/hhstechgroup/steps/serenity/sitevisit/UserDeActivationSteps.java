package com.hhstechgroup.steps.serenity.sitevisit;

import com.hhstechgroup.ui.pages.sitevisit.UserDeactivationPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class UserDeActivationSteps {
    @Page
    UserDeactivationPage userDeactivationPage;

    @Step
    public void clickOnEdit(){userDeactivationPage.clickOnEdit();}

    @Step
    public void setInactiveDays1(String days) {userDeactivationPage.setInactiveDays1(days); }

    @Step
    public void setInvitationNotAcceptableDays1(String days) {userDeactivationPage.setInvitationNotAcceptableDays1(days);}

    @Step
    public void setInactiveDays2(String days) {userDeactivationPage.setInactiveDays2(days); }

    @Step
    public void setInvitationNotAcceptableDays2(String days) {userDeactivationPage.setInvitationNotAcceptableDays2(days);}


    @Step
    public void clickOnSave(){userDeactivationPage.clickOnSave();}

    //sp23

    @Step
    public void setUserDeactivationDate(String userDeactivationDate) {
        userDeactivationPage.setUserDeactivationDate(userDeactivationDate);
    }

    //sp 25

    @Step
    public void setEffectiveEndDate(String endDate) {userDeactivationPage.setEffectiveEndDate(endDate);}

    //sp 26

    @Step
    public void clickOnCancel(){userDeactivationPage.clickOnCancel();}


}
