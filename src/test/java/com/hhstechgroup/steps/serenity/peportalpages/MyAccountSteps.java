package com.hhstechgroup.steps.serenity.peportalpages;

import com.hhstechgroup.ui.pages.iuportal.MyAccountPage;
import com.hhstechgroup.util.common.FileUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.Map;

public class MyAccountSteps extends ScenarioSteps{


    MyAccountPage myAccountPage;

    @Step
    public Map<String, String> getAccountInfo(String sectionHeader) {
        return myAccountPage.getMappedValues(sectionHeader);
    }

    @Step
    public void uploadUserPhoto(String path) {
        myAccountPage.uploadUserPhoto(FileUtils.getAbsolutePath(path));
    }

    @Step
    public String getErrorDisplayed() {
        return myAccountPage.getErrorDisplayed();
    }

    @Step
    public boolean isPhotoUploaded() {
        return myAccountPage.isPhotoUploaded();
    }
}
