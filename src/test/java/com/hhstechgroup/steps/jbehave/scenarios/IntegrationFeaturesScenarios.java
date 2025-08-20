package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.IntegrationFeaturesSteps;
import com.hhstechgroup.ui.pages.gmail.GmailPage;
import net.serenitybdd.core.Serenity;
import org.jbehave.core.annotations.Given;

public class IntegrationFeaturesScenarios {
    IntegrationFeaturesSteps integrationFeaturesSteps ;
    GmailPage gmailPage ;

    //sp 59 random npi from the list

    @Given("get random npi from file '$file'")
    public void getNpiList(String file){
        Serenity.setSessionVariable("npi").to(gmailPage.getNpiFromList(file));
    }

}
