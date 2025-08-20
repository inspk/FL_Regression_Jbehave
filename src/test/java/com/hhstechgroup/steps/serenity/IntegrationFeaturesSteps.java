package com.hhstechgroup.steps.serenity;

import com.hhstechgroup.ui.pages.IntegrationFeatures;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class IntegrationFeaturesSteps {
    IntegrationFeatures integrationFeatures ;
    private Object String;


    //sp 59 random npi from the list

    @Step
    public String getRandomStringFromFile(String fileName) {
        return  integrationFeatures.getRandomStringFromFile(fileName);
    }
}
