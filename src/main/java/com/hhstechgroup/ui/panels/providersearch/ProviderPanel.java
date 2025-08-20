package com.hhstechgroup.ui.panels.providersearch;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class ProviderPanel extends AbstractPanel {

    private static final String NAME = ".//div[contains(@class, 'provider-name')]/a";
    private static final String DISTANCE = ".//div[contains(@class, '__header')]/span";
    private static final String SPECIALTY = ".//div[contains(@class, 'provider-type')]";
    private static final String ADDRESS = ".//div[contains(@class, 'provider-address')]";
    private static final String PHONE = ".//div[contains(@class, 'provider-phone')]";
    private static final String LANGUAGES = ".//div[span[text() = 'SUPPORTED LANGUAGES']]/following-sibling::div/span";
    private static final String AGES = ".//div[span[text() = 'AGES OF PATIENS']]/following-sibling::div/span";
    private static final String GENDER = ".//div[span[text() = 'GENDER']]/following-sibling::div";
    private static final String NPI = ".//div[span[text() = 'NPI']]/following-sibling::div";
    private static final String WORKING_HOURS = ".//div[span[text() = 'WORKING HOURS']]/following-sibling::div/span";
    private static final String PAYER = ".//div[contains(@class, 'payer')]";

    public ProviderPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public String getPayer() {
        return findBy(PAYER).getText();
    }

    public String getName() {
        return findBy(NAME).getText();
    }

    public String getDistance() {
        return findBy(DISTANCE).getText();
    }

    public String getSpecialty() {
        return findBy(SPECIALTY).getText();
    }

    public String getAddress() {
        return findBy(ADDRESS).getText();
    }

    public String getPhone() {
        return findBy(PHONE).getText();
    }

    public List<String> getLanguages() {
        return findAll(LANGUAGES).stream().map(element -> element.getAttribute("innerText")).collect(Collectors.toList());
    }

    public List<String> getAges() {
        return findAll(AGES).stream().map(element -> element.getAttribute("innerText")).collect(Collectors.toList());
    }

    public String getGender() {
        return findBy(GENDER).getAttribute("innerText");
    }

    public String getNpi() {
        return findBy(NPI).getAttribute("innerText");
    }

    public String getOpenHours() {
        return findBy(WORKING_HOURS).getAttribute("innerText");
    }
}
