package com.hhstechgroup.steps.serenity.sitevisit;

import com.hhstechgroup.ui.pages.sitevisit.SitiVistShedulePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;

public class SiteVisitSteps {

    @Page SitiVistShedulePage sitiVistShedulePage;

    @Step
    public void clickCreateSiteVisitButton(){sitiVistShedulePage.clickCreateSiteVisitButton();}

    @Step
    public void fillSiteVisitDate(String sitevisitDate) {sitiVistShedulePage.fillSiteVisitDate(sitevisitDate);}

    @Step
    public void fillSiteVisitDate1(String sitevisitDate) {sitiVistShedulePage.fillSiteVisitDate1(sitevisitDate);}

    @Step
    public void setSiteVisitReason(String reason,String note) {sitiVistShedulePage.setSiteVisitReason(reason,note);}

    @Step
    public void setSiteVisitReason1(String reason,String note) {sitiVistShedulePage.setSiteVisitReason1(reason,note);}

    @Step
    public void clickOnActionMenuFromSiteVisitrecordsList(String action){sitiVistShedulePage.clickOnActionMenuFromSiteVisitrecordsList(action);}

    @Step
    public void clickGoToSiteVisitButton(){sitiVistShedulePage.clickGoToSiteVisitButton();}

    //sp45.3
    @Step
    public void clickPlusiteVisitButton() {
        sitiVistShedulePage.clickPlusiteVisitButton();
    }
    @Step
    public void searchNPIfield(String searchnpifield) {
        sitiVistShedulePage.searchNPIfield(searchnpifield);
    }
    @Step
    public void clickonCreateButton() {
        sitiVistShedulePage.clickonCreateButton();
    }

    //SD-05

    @Step
    public void clickYesInRetroApprovalButton(String button){
        sitiVistShedulePage.clickYesInRetroApprovalButton(button);
    }

    @Step
    public void selectLocationsToCreateSiteVisit(String locations){
        sitiVistShedulePage.selectLocationsToCreateSiteVisit(locations);
    }
}
