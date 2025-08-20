package com.hhstechgroup.steps.serenity.systemoption;

import com.hhstechgroup.beans.application.ContactInformationBean;
import com.hhstechgroup.ui.pages.systemoptions.UserProfilePage;
import com.hhstechgroup.ui.panels.systemoptions.ContactInformationPanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UserProfileSteps extends ScenarioSteps {

    UserProfilePage userProfilePage;

    @Step
    public void clickOnContactInfo(String contactinfo){userProfilePage.clickOnContactInfo(contactinfo);}

    @Step
    public void clickoneditbutton() {userProfilePage.clickoneditbutton(); }

    @Step
    public void clickOnEnableUserUpdateProfile(){userProfilePage.clickOnEnableUserUpdateProfile();}

    @Step
    public void clickOnSaveButton() {userProfilePage.clickOnSaveButton();}

    @Step
    public void setUserProfileUpdateDays(String days){userProfilePage.setUserProfileUpdateDays(days);}

    @Step
    public  void setUserUpdateProfile(ContactInformationBean contactInfo) {
        ContactInformationPanel panel = userProfilePage.getUserUpdateProfile();
        waitABit(2000);
        BeanUtils.copyPropertiesInOrder(panel, contactInfo);
    }
    @Step
    public void clickOnUpdateButton() {userProfilePage.clickOnUpdateButton();}

    @Step
    public void clickOKButton(){userProfilePage.clickOKButton();}
}
