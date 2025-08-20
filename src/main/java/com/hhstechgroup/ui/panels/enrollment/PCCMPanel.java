package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class PCCMPanel extends BaseEnrollmentPanel {

    private static final String PARTICIPATE_PCCM = "participate in the PCCM";
    private static final String TYPE = ".//span[contains(text(), '%s')]/preceding-sibling::span//input";
    private static final String COUNT_OF_CLIENTS = "clients";
    private static final String PHONE = "24-Hour";
    private static final String CALL_TO_MEMBER = "prior to member";
    private static final String GROUP_NPI = "NPI";

    public PCCMPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setParticipatePCCM(String participatePCCM) {
        selectRadionButton(PARTICIPATE_PCCM, participatePCCM);
    }

    public void setType(String type) {
        clickOn(String.format(TYPE, type));
    }

    public void setCountOfClients(String countOfClients) {
        fillField(COUNT_OF_CLIENTS, countOfClients);
    }

    public void setPhone(String phone) {
        fillField(PHONE, phone);
    }

    public void setCallToMember(String callToMember) {
        selectRadionButton(CALL_TO_MEMBER, callToMember);
    }

    public void setGroupNpi(String groupNpi) {
        fillField(GROUP_NPI, groupNpi);
    }

}
