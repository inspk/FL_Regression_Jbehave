package com.hhstechgroup.steps.serenity.peportalpages;

import com.hhstechgroup.ui.pages.iuportal.Lists1099;
import com.hhstechgroup.ui.pages.peportal.Form1099Page;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class Form1099Steps extends ScenarioSteps {

    Form1099Page form1099Page;
    Lists1099 lists1099;

    @Step
    public List<String> get1099Blocks() {
        return form1099Page.getFroms();
    }

    @Step
    public void clickViewDetails(String year) {
        form1099Page.getForm1099(year).clickViewDetails();
    }

    @Step
    public boolean isFormDisplayed() {
        return form1099Page.isFormImageDisplayed();
    }

    @Step
    public void clickOnRecordWithValue(String providerId) {
        lists1099.getRecords().clickOnRecordWithValue(providerId);
    }

    @Step
    public boolean isSearchBlockPresent() {
        return lists1099.isSearchPanelPresent();
    }

    @Step
    public String getFormName() {
        return lists1099.getFormName();
    }

    @Step
    public String getNPI() {
        return lists1099.getNPI();
    }

    @Step
    public String getProviderId() {
        return lists1099.getProviderId();
    }

    @Step
    public void clickSearch() {
        lists1099.clickSearch();
    }

}
