package com.hhstechgroup.ui.panels.providersearch;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPanel extends AbstractPanel {

    private static final String ADDRESS = ".//input[@title = 'Enter address']";
    private static final String ADDRESS_DROP_DOWNlIST = ".//ul[@class = 'geocoder-control-list']/li[text()='%s']";
    private static final String PROVIDER_NAME = ".//input[@placeholder='Provider name']";
    private static final String AGES = ".//div[@title='Ages']/button";
    private static final String SPECIALTY = ".//div[@title='Specialty']/button";
    private static final String GENDER = ".//div[@title='Gender']/button";
    private static final String LANGUAGE = ".//div[@title='Language']/button";
    private static final String DROP_DOWN_OPTION = ".//ul//label[starts-with(normalize-space(text()), '%s')]/parent::div";
    private static final String LOADING_SPINNER_BAR = ".//div[@id = 'loading-bar-spinner']";
    private static final String LOADING_BAR = ".//div[@id = 'loading-bar']";
    private static final String PAYER = ".//div[@title='facilities.payers']/button";
    private static final String GENDER_DROP_DOWN = ".//div[@title='Gender']//ul//label[starts-with(normalize-space(text()), '%s')]/parent::div";

    public SearchPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setAddress(String address) {
        waitForAbsenceOf(LOADING_SPINNER_BAR);
        if (!address.isEmpty()) {
            String dropDownOption = String.format(ADDRESS_DROP_DOWNlIST, address);
            waitForAbsenceOf(LOADING_SPINNER_BAR);
            findBy(ADDRESS).type(address);
            waitFor(ExpectedConditions.visibilityOf(findBy(dropDownOption)));
            findBy(dropDownOption).click();
            waitForAbsenceOf(dropDownOption);
            waitForAbsenceOf(LOADING_BAR);
            waitForAbsenceOf(LOADING_SPINNER_BAR);
        }
    }

    public void setProviderName(String providerName) {
        waitForAbsenceOf(LOADING_SPINNER_BAR);
        if (!providerName.isEmpty()) {
            waitForAbsenceOf(LOADING_SPINNER_BAR);
            findBy(PROVIDER_NAME).type(providerName);
            waitForAbsenceOf(LOADING_BAR);
            waitForAbsenceOf(LOADING_SPINNER_BAR);
        }
    }

    public void setAges(String ages) {
        waitForAbsenceOf(LOADING_SPINNER_BAR);
        if (!ages.isEmpty()) {
            waitForAbsenceOf(LOADING_SPINNER_BAR);
            waitFor(ExpectedConditions.visibilityOf(findBy(AGES)));
            findBy(AGES).click();
            selectFromDropDown(ages, DROP_DOWN_OPTION);
            action().moveToElement(findBy(AGES)).build().perform();
            waitForAbsenceOf(LOADING_BAR);
            waitForAbsenceOf(LOADING_SPINNER_BAR);
        }
    }

    public void setSpecialty(String specialty) {
        waitForAbsenceOf(LOADING_SPINNER_BAR);
        if (!specialty.isEmpty()) {
            waitForAbsenceOf(LOADING_SPINNER_BAR);
            waitFor(ExpectedConditions.visibilityOf(findBy(SPECIALTY)));
            findBy(SPECIALTY).click();
            selectFromDropDown(specialty, DROP_DOWN_OPTION);
            action().moveToElement(findBy(SPECIALTY)).build().perform();
            waitForAbsenceOf(LOADING_BAR);
            waitForAbsenceOf(LOADING_SPINNER_BAR);
        }
    }

    public void setPayer(String payer) {
        waitForAbsenceOf(LOADING_SPINNER_BAR);
        if (!payer.isEmpty()) {
            waitForAbsenceOf(LOADING_SPINNER_BAR);
            findBy(PAYER).click();
            selectFromDropDown(payer, DROP_DOWN_OPTION);
            action().moveToElement(findBy(PAYER)).build().perform();
            waitForAbsenceOf(LOADING_BAR);
            waitForAbsenceOf(LOADING_SPINNER_BAR);
        }
    }

    public void setGender(String gender) {
        waitForAbsenceOf(LOADING_SPINNER_BAR);
        if (!gender.isEmpty()) {
            String dropDownOption = String.format(GENDER_DROP_DOWN, gender);
            waitForAbsenceOf(LOADING_SPINNER_BAR);
            waitFor(ExpectedConditions.visibilityOf(findBy(GENDER)));
            findBy(GENDER).click();
            waitFor(ExpectedConditions.visibilityOf(findBy(dropDownOption)));
            selectFromDropDown(gender, GENDER_DROP_DOWN);
            action().moveToElement(findBy(GENDER)).build().perform();
            waitForAbsenceOf(LOADING_BAR);
            waitForAbsenceOf(LOADING_SPINNER_BAR);
        }
    }

    public void setLanguage(String language) {
        waitForAbsenceOf(LOADING_SPINNER_BAR);
        if (!language.isEmpty()) {
            waitForAbsenceOf(LOADING_SPINNER_BAR);
            findBy(LANGUAGE).click();
            selectFromDropDown(language, DROP_DOWN_OPTION);
            action().moveToElement(findBy(LANGUAGE)).build().perform();
            waitForAbsenceOf(LOADING_BAR);
            waitForAbsenceOf(LOADING_SPINNER_BAR);
        }
    }
}

