package com.hhstechgroup.ui.panels.iuportal;
import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProviderDataSearchPanel extends AbstractPanel {
    private static final String NPI = ".//input[contains(@id, 'npi')]";
    private static final String ENROLLMENT_TYPE = ".//input[contains(@id, 'Enrollment type')]/preceding-sibling::div";
    private static final String ADDRESS = ".//input[contains(@id, 'address')]";
    private static final String SPECIALITY = ".//input[contains(@id, 'specialty')]";
    private static final String PROVIDER_NAME_AND_ID = ".//input[contains(@id, 'providerName')]";
    private static final String ZIP = ".//input[contains(@id, 'zip')]";
    private static final String SEARCH_BUTTON = ".//button[span[text() = 'Search']]";
    private static final String RESET_FILTERS = ".//a/span";
    private static final String SEARCH_RESULTS_LABLE = ".//div/h3[contains (text(), 'Search results')]";

    public ProviderDataSearchPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setNpi(String npi) {
        findBy(NPI).type(npi);
    }

    public void setEnrollmentType(String enrollmentType) {
        findBy(ENROLLMENT_TYPE).click();
        selectFromDropDown(enrollmentType);
    }

    public void setAddress(String address) {
        findBy(ADDRESS).type(address);
    }

    public void setSpeciality(String speciality) {
        findBy(SPECIALITY).type(speciality);
    }

    public void setProviderNameAndId(String providerNameAndId) {
        findBy(PROVIDER_NAME_AND_ID).type(providerNameAndId);
    }

    public void setZip(String zip) {
        findBy(ZIP).type(zip);
    }

    public void clickSearch() {  scrollToElement(SEARCH_BUTTON);
        findBy(SEARCH_BUTTON).waitUntilEnabled();
        findBy(SEARCH_BUTTON).click();
        waitForAbsenceOf(SPINNER);
        //waitForPresenceOf(SEARCH_RESULTS_LABLE);
    }

    public void clickResetFilters() {
//        findBy(RESET_FILTERS).click();
//        waitForAbsenceOf(SPINNER);
        scrollToElement(RESET_FILTERS);
        waitABit(2000);
        jsClick(RESET_FILTERS);
    }

    //sp43
    private static final String SITEVISIT_PROVIDER_NAME_AND_ID = ".//input[contains(@id, 'ProviderSiteVisit')]";
    public void setSitevisitProviderNameAndId(String sitevisitProviderNameAndId) {
      findBy(SITEVISIT_PROVIDER_NAME_AND_ID).type(sitevisitProviderNameAndId);
    }

}
