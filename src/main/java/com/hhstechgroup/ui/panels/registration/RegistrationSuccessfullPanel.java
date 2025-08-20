package com.hhstechgroup.ui.panels.registration;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegistrationSuccessfullPanel extends AbstractPanel {

    private static final String TEXT = ".//p";

    public RegistrationSuccessfullPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public String getText() {
        StringBuilder resultText = new StringBuilder();
        findAll(TEXT).forEach(element -> resultText.append(element.getText()));
        return resultText.toString();
    }


}
