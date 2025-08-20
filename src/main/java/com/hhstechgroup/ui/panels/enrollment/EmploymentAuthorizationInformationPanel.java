package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

public class EmploymentAuthorizationInformationPanel extends BaseEnrollmentPanel{

    public EmploymentAuthorizationInformationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    private static final String US_CITIZEN="Are you a U.S. citizen or lawful permanent resident?";

    public void setUsCitizen(String usCitizen){
        waitABit(200);
        selectRadionButton(US_CITIZEN,usCitizen);
        waitABit(200);
    }


}
