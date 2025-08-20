package com.hhstechgroup.steps.serenity.peportalpages;

import com.hhstechgroup.ui.pages.peportal.AppealPage;
import com.hhstechgroup.ui.pages.peportal.ReconsiderationPage;
import com.hhstechgroup.util.common.FileUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ReconsiderationSteps extends ScenarioSteps {

    ReconsiderationPage reconsiderationPage;
    @Step
    public void clickReconsideration() {
        reconsiderationPage.clickReconsideration();
    }

    @Step
    public boolean isUploadFieldPresent() {
        return reconsiderationPage.getReconsiderationPanel().isUploadButtonPresent();
    }

    @Step
    public void setAppealReason(String reason) {
        reconsiderationPage.getReconsiderationPanel().setReason(reason);
    }

    @Step
    public void setAppealFirstName(String firstName) {
        reconsiderationPage.getReconsiderationPanel().setFirstName(firstName);
    }

    @Step
    public void setAppealLastName(String lastName) {
        reconsiderationPage.getReconsiderationPanel().setLastName(lastName);
    }

    @Step
    public void uploadAppealDoc1(String filePath) {
        reconsiderationPage.getReconsiderationPanel().uploadReconsiderationDoc(FileUtils.getAbsolutePath(filePath));
    }

    @Step
        public void signReconsideration() {
            reconsiderationPage.getReconsiderationPanel().signReconsideration();
        }

    @Step
    public void submitReconsideration() {
        reconsiderationPage.submitReconsideration();
    }

    @Step
    public String getSuccessMessage() {
        return reconsiderationPage.getSuccessPanel().getTitle();
    }

}

