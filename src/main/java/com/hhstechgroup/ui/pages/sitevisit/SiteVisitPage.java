package com.hhstechgroup.ui.pages.sitevisit;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import com.hhstechgroup.ui.panels.sitevisit.AdditionalQuestionsPanel;
import com.hhstechgroup.ui.panels.sitevisit.FacilityInspectionPanel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SiteVisitPage extends AbstractPage {

   // private static final String ADD_NEW_BUTTON = "//button[span[node() = 'Add New']]";
    //latest
    private static final String ADD_NEW_BUTTON = "//button[span[node() = 'Site visit']]" ;
    private static final String FACILITY_INSPECTION_PANEL = "//h3[contains(text(), 'Facility inspection')]/ancestor::div[3]";
    private static final String ADDITIONAL_QUESTIONS_PANEL = "//h3[contains(text(), 'Additional questions for inspector')]/ancestor::div[3]";

    public SiteVisitPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddNewButton() {
        findBy(ADD_NEW_BUTTON).click();
        //waitForAbsenceOf(ADD_NEW_BUTTON);
    }

    public FacilityInspectionPanel getFacilityInspectionPanel() {
        return new FacilityInspectionPanel(findBy(FACILITY_INSPECTION_PANEL), this);
    }

    public AdditionalQuestionsPanel getAdditionalQuestionsPanel() {
        return new AdditionalQuestionsPanel(findBy(ADDITIONAL_QUESTIONS_PANEL), this);
    }

    private static final String POP_UP = "//div[@role='document']";
    private static final String SELECT_PROVIDER = ".//p[text()='Select...']/.." ;
    private static final String DROPDOWN_LIST  = ".//div[contains(@class,'jss6850')]//p";
    public void selectsitevisitprovider(String siteProvider) {
        waitForPopUpOpened();
        scrollToElement(SELECT_PROVIDER);
        waitAbit(1000);
        findBy(SELECT_PROVIDER).click();
        BaseModalPanel dropDown = new BaseModalPanel(findBy(POP_UP), this);
        dropDown.selectFromMultiChoiceDropDown(siteProvider);
        action().sendKeys(Keys.TAB).build().perform();
        waitForAbsenceOf(DROPDOWN_LIST);
    }


}
