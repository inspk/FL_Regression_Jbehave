package com.hhstechgroup.steps.serenity;

import com.hhstechgroup.ui.pages.HelpPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HelpTourSteps extends ScenarioSteps {

    HelpPage helpPage;

    @Step
    public void skipHelpTour() {
        helpPage.skipTooltip();
    }
    @Step
    public void skipTooltipIfExists() {
        helpPage.skipTooltipIfExists();
    }

    @Step
    public void waitForHelpTour() {
        helpPage.waitForHelpTour();
    }

    @Step
    public boolean isHelpTourTooltipDisplayedCorrectly(String title, String description){
        return helpPage.isHelpTourTooltipDisplayedCorrectly(title, description);
    }

    @Step
    public void closeHelpTour(){
        helpPage.closeHelpTour();
    }

    @Step
    public void clickNext(){
        helpPage.clickOnNextButton();
    }

    @Step
    public void clickBackButton(){
        helpPage.clickOnBackButton();
    }

    @Step
    public boolean isHelpTourOpened(){
        return helpPage.isHelpTourOpened();
    }
}
