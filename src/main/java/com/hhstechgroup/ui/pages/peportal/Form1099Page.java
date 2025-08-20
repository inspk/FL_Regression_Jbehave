package com.hhstechgroup.ui.pages.peportal;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.peportal.Form1099;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class Form1099Page extends ProviderManagementBasePage {

    private static final String FORM = ".//div[contains(@class, '_year_') and text() = '%s']/parent::div";
    private static final String FORMS = ".//div/div[contains(@class, '_year_')]";
    private static final String DETAILS = ".//div[contains(@class, 'details_form')]/img";

    public Form1099Page(WebDriver driver) {
        super(driver);
    }

    public List<String> getFroms() {
        return findAll(FORMS).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    public Form1099 getForm1099(String formYear) {
        return new Form1099(findBy(String.format(FORM, formYear)), this);
    }

    public boolean isFormImageDisplayed() {
        return isElementPresent(DETAILS);
    }

}
