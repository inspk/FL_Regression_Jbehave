package com.hhstechgroup.ui.panels.claim;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class ClaimDataPanel extends BaseEnrollmentPanel {

    private static final String DIAGNOSIS_1 = "1.";
    private static final String DIAGNOSIS_2 = "2.";
    private static final String DIAGNOSIS_3 = "3.";
    private static final String DIAGNOSIS_4 = "4.";
    private static final String DIAGNOSIS_5 = "5.";
    private static final String DIAGNOSIS_6 = "6.";
    private static final String DIAGNOSIS_7 = "7.";


    public ClaimDataPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setDiagnosis1(String diagnosis) {
        fillField(DIAGNOSIS_1, diagnosis);
    }

    public void setDiagnosis2(String diagnosis) {
        fillField(DIAGNOSIS_2, diagnosis);
    }

    public void setDiagnosis3(String diagnosis) {
        fillField(DIAGNOSIS_3, diagnosis);
    }

    public void setDiagnosis4(String diagnosis) {
        fillField(DIAGNOSIS_4, diagnosis);
    }

    public void setDiagnosis5(String diagnosis) {
        fillField(DIAGNOSIS_5, diagnosis);
    }

    public void setDiagnosis6(String diagnosis) {
        fillField(DIAGNOSIS_6, diagnosis);
    }

    public void setDiagnosis7(String diagnosis) {
        fillField(DIAGNOSIS_7, diagnosis);
    }

}
