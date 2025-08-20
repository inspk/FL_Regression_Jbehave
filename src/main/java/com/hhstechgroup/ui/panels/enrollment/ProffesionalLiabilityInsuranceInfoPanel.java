package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProffesionalLiabilityInsuranceInfoPanel extends BaseEnrollmentPanel {
    public ProffesionalLiabilityInsuranceInfoPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    public static final String DENIED_PROFFESIONAL_LIABILITY_INSURANCE="1. Have you ever been denied professional liability insurance?";

        public void setDeniedProffesionalLiabilityInsurance(String deniedProffesionalLiabilityInsurance){
            waitABit(200);
        selectRadionButton(DENIED_PROFFESIONAL_LIABILITY_INSURANCE, deniedProffesionalLiabilityInsurance);
            waitABit(300);
        }
public static final String DENIED_RENEWAL="2. Have your professional liability insurance ever been canceled, denied renewal or subject to restriction (e.g. reduced limits, surcharged)?";

        public void setDeniedRenewal(String deniedRenewal){
            waitABit(200);
            selectRadionButton(DENIED_RENEWAL, deniedRenewal);
        waitABit(200);
        }
        public static final String MALPRACTICE1="3. Within the past seven years have you been a party to any malpractice actions?";

        public void setMalpractice1(String malpractice1){
            waitABit(200);
            selectRadionButton(MALPRACTICE1, malpractice1);
            waitABit(200);
        }
        public static final String UNFAVOURABLE_JUDGEMENT="4. Within the past seven years has any malpractice action been settled or has there been an unfavorable judgment(s) against you in a malpractice action?";
    public void setUnfavourableJudgement(String unfavourableJudgement){
        waitABit(200);
        selectRadionButton(UNFAVOURABLE_JUDGEMENT, unfavourableJudgement);
        waitABit(200);

    }
    public static final String MALPRACTICE_CURRENTLY_PENDING="5. To your knowledge, is any malpractice action against you currently pending?";
    public void setMalpracticeCurrentlyPending(String malpracticeCurrentlyPending) {
        waitABit(200);
        selectRadionButton(MALPRACTICE_CURRENTLY_PENDING, malpracticeCurrentlyPending);
        waitABit(200);

    }
    public static final String MENTAL_OR_PHYSICAL_HEALTH_CONDITION="6. Do you have a mental or physical health condition (including alcohol or substance use) that currently impairs your judgment or would otherwise adversely affect your inability to practice medicine in a competent";
    public void setMentalOrPhysicalHealthCondition(String mentalOrPhysicalHealthCondition){
        waitABit(200);
        selectRadionButton(MENTAL_OR_PHYSICAL_HEALTH_CONDITION, mentalOrPhysicalHealthCondition);
        waitABit(200);
    }
    public static final String MALPRACTICE_HEALTH_INFO="Do you ever have Malpractice insurance history?";

    public void setMalPracticeHealthInfo(String malPracticeHealthInfo){
        waitABit(200);
        selectRadionButton(MALPRACTICE_HEALTH_INFO, malPracticeHealthInfo);
        waitABit(200);
    }

    public static final String MALPRACTICE_INFO="Do you have malpractice or general liability insurance?";
    public void  setMalPracticeInfo(String malPracticeInfo){
        waitABit(200);
        selectRadionButton(MALPRACTICE_INFO, malPracticeInfo);
        waitABit(200);
    }

}
