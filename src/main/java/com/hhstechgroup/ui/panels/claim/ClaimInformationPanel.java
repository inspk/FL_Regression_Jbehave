package com.hhstechgroup.ui.panels.claim;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class ClaimInformationPanel extends BaseEnrollmentPanel {

    private static final String PAYER = "Payer";



    public ClaimInformationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setPayer(String option) {
        selectRadionButton(PAYER, option);
    }



}
