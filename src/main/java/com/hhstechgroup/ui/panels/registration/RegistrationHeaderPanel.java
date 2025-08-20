package com.hhstechgroup.ui.panels.registration;


import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegistrationHeaderPanel extends AbstractPanel{

    private static final String PAGE_TITLE = ".//span[contains(@class, 'header-wrapper_header-heading_')]";

    public RegistrationHeaderPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public boolean isPageTitleCorrect(String pageTitle){
        return findBy(PAGE_TITLE).getText().contains(pageTitle);
    }
}
