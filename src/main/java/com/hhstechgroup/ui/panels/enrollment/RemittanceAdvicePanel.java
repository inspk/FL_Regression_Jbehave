package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class RemittanceAdvicePanel extends BaseEnrollmentPanel {

    private static final String PREFERENCE_FOR_REMITTANCE_DATA = "Preference";
    private static final String REMITTANCE_ADVICE_FREQUENCY = "advice frequency";
    private static final String OTHER_DETAILS = "Primary claims submission method";
    private static final String PROVIDER_NAME = "Provider name";

    public RemittanceAdvicePanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setPreferenceForRemittanceData(String preferenceForRemittanceData) {
        select(PREFERENCE_FOR_REMITTANCE_DATA, preferenceForRemittanceData);
    }

    public void setRemittanceAdviceFrequency(String remittanceAdviceFrequency) {
        select(REMITTANCE_ADVICE_FREQUENCY, remittanceAdviceFrequency);
    }

    public void setOtherDetails(String otherDetails) {
        select(OTHER_DETAILS, otherDetails);
    }

    public void setProviderName(String providerName) {
        fillField(PROVIDER_NAME, providerName);
    }

}
