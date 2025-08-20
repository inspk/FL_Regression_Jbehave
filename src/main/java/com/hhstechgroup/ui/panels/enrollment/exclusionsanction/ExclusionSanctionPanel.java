package com.hhstechgroup.ui.panels.enrollment.exclusionsanction;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class ExclusionSanctionPanel extends BaseEnrollmentPanel {

    private static final String PREVIOUSLY_EXCLUDED_FROM_PROGRAM = "convicted or excluded from";
    private static final String HAS_OUTSTANDING_OVERPAYMENTS = "outstanding overpayments";
    private static final String CONVICTED_OF_FELONY = "convicted of a felony";
    private static final String ADMINISTRATIVE_SANCTION = "Administrative sanction";
    private static final String BOARD_DISCIPLINARY_ACTION = "board disciplinary";
    private static final String PROGRAM_EXCLUSIONS = "Program exclusions";
    private static final String SUSPENSION_OF_PAYMENTS = "Suspension of payments";
    private static final String CIVIL_MONETARY_PENALTY = "Civil monetary";
    private static final String ASSESSMENT = "Assessment";
    private static final String PROGRAM_DEBARMENT = "Program debarment";
    private static final String CRIMINAL_FINE = "Criminal fine";
    private static final String RESTITUTION_ORDER = "Restitution order";
    private static final String PENDING_CIVIL_JUDGMENT = "civil judgment";
    private static final String PENDING_CRIMINAL_JUDGMENT = "criminal judgment";
    private static final String JUDGMENT_UNDER_FALSE_CLAIMS_ACT = "false claims act";
    private static final String NAME_TABLE = ".//span[contains(text(), 'Name')]/ancestor::div[contains(@class, 'rdw-editor-main')]/ancestor::div[5]/following-sibling::div[1]//table/ancestor::div[2]";
    private static final String FEDERAL_PROGRAM_TABLE = ".//span[contains(text(), 'Federal program')]/ancestor::div[contains(@class, 'rdw-editor-main')]/ancestor::div[5]/following-sibling::div[1]//table/ancestor::div[2]";

    public ExclusionSanctionPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public NameTable getNameTable() {
        scrollToElement(NAME_TABLE);
        return new NameTable(findBy(NAME_TABLE), getBasePage());
    }

    public FederalProgramTable getFederalProgramTable() {
        scrollToElement(FEDERAL_PROGRAM_TABLE);
        return new FederalProgramTable(findBy(FEDERAL_PROGRAM_TABLE), getBasePage());
    }

    public void setPreviouslyExcludedFromProgram(String previouslyExcludedFromProgram) {
        selectRadionButton(PREVIOUSLY_EXCLUDED_FROM_PROGRAM, previouslyExcludedFromProgram);
    }

    public void setHasOutstandingOverpayments(String hasOutstandingOverpayments) {
        selectRadionButton(HAS_OUTSTANDING_OVERPAYMENTS, hasOutstandingOverpayments);
    }

    public void setConvictedOfFelony(String convictedOfFelony) {
        selectRadionButton(CONVICTED_OF_FELONY, convictedOfFelony);
    }

    public void setAdministrativeSanction(String administrativeSanction) {
        selectRadionButton(ADMINISTRATIVE_SANCTION, administrativeSanction);
    }

    public void setBoardDisciplinaryAction(String boardDisciplinaryAction) {
        selectRadionButton(BOARD_DISCIPLINARY_ACTION, boardDisciplinaryAction);
    }

    public void setProgramExclusions(String programExclusions) {
        selectRadionButton(PROGRAM_EXCLUSIONS, programExclusions);
    }

    public void setSuspensionOfPayments(String suspensionOfPayments) {
        selectRadionButton(SUSPENSION_OF_PAYMENTS, suspensionOfPayments);
    }

    public void setCivilMonetaryPenalty(String civilMonetaryPenalty) {
        selectRadionButton(CIVIL_MONETARY_PENALTY, civilMonetaryPenalty);
    }

    public void setAssessment(String assessment) {
        selectRadionButton(ASSESSMENT, assessment);
    }

    public void setProgramDebarment(String programDebarment) {
        selectRadionButton(PROGRAM_DEBARMENT, programDebarment);
    }

    public void setCriminalFine(String criminalFine) {
        selectRadionButton(CRIMINAL_FINE, criminalFine);
    }

    public void setRestitutionOrder(String restitutionOrder) {
        selectRadionButton(RESTITUTION_ORDER, restitutionOrder);
    }

    public void setPendingCivilJudgment(String pendingCivilJudgment) {
        selectRadionButton(PENDING_CIVIL_JUDGMENT, pendingCivilJudgment);
    }

    public void setPendingCriminalJudgment(String pendingCriminalJudgment) {
        selectRadionButton(PENDING_CRIMINAL_JUDGMENT, pendingCriminalJudgment);
    }

    public void setJudgmentUnderFalseClaimsAct(String judgmentUnderFalseClaimsAct) {
        selectRadionButton(JUDGMENT_UNDER_FALSE_CLAIMS_ACT, judgmentUnderFalseClaimsAct);
    }

    //sp37

    private static final String CRIMINAL_OFFENSE_IN_ANY_STATE ="Have you ever been convicted of a criminal offense in any State?";
    private static final String LICENSE_SANCTIONED_REVOKED_IN_ANY_STATE ="Have you ever had your license sanctioned, suspended or revoked in any State?";
    private static final String CIVIL_MONEY_UNDER_ANY_STATE ="Have you ever been fined or had civil money penalties under any State or Federal Program?";
    private static final String SANCTIONED_EXCLUDED_ANY_STATE ="Have you ever been sanctioned, debarred, suspended, or excluded from any State or Federal Program?";

    public void setCriminalOffenseInAnyState(String criminalOffenseInAnyState) {
        waitABit(500);
        selectRadionButton(CRIMINAL_OFFENSE_IN_ANY_STATE,criminalOffenseInAnyState);
        waitABit(1000);

    }

    public void setLincenseSanctionedRevokedInAnyState(String lincenseSanctionedRevokedInAnyState) {
        waitABit(500);
        selectRadionButton(LICENSE_SANCTIONED_REVOKED_IN_ANY_STATE,lincenseSanctionedRevokedInAnyState);
        waitABit(1000);

    }

    public void setCivilMoneyUnderAnyState(String civilMoneyUnderAnyState) {
        waitABit(500);
        selectRadionButton(CIVIL_MONEY_UNDER_ANY_STATE,civilMoneyUnderAnyState);
        waitABit(1000);

    }

    public void setSanctionedExcludedAnyState(String sanctionedExcludedAnyState) {
        waitABit(500);
        selectRadionButton(SANCTIONED_EXCLUDED_ANY_STATE,sanctionedExcludedAnyState);
        waitABit(1000);

    }

    //sp37 for pharmacy

    private static final String KEY_MAPPED_CRIMINAL_OFFENSE_IN_ANY_STATE ="Has this entity or any owner or managing or Key employee ever been convicted of a criminal offense?";
    private static final String KEY_MAPPED_LICENSE_SANCTIONED_REVOKED_IN_ANY_STATE ="Has this entity or any owner or managing or Key employee ever had your license sanctioned, suspended or revoked in any State?";
    private static final String KEY_MAPPED_CIVIL_MONEY_UNDER_ANY_STATE ="Has this entity or any owner or managing or Key employee ever been fined or had civil money penalties under any State or Federal Program?";
    private static final String KEY_MAPPED_SANCTIONED_EXCLUDED_ANY_STATE ="Has this entity or any owner or managing or Key employee ever been sanctioned, debarred, suspended, or excluded from any State or Federal Program?";


    public void setKeyEmployeeCriminalOffenseInAnyState(String keyEmployeeCriminalOffenseInAnyState) {
        waitABit(500);
        selectRadionButton(KEY_MAPPED_CRIMINAL_OFFENSE_IN_ANY_STATE,keyEmployeeCriminalOffenseInAnyState);
        waitABit(1000);
    }

    public void setKeyEmployeeLincenseSanctionedRevokedInAnyState(String keyEmployeeLincenseSanctionedRevokedInAnyState) {
        waitABit(500);
        selectRadionButton(KEY_MAPPED_LICENSE_SANCTIONED_REVOKED_IN_ANY_STATE,keyEmployeeLincenseSanctionedRevokedInAnyState);
        waitABit(1000);
    }

    public void setKeyEmployeeCivilMoneyUnderAnyState(String keyEmployeeCivilMoneyUnderAnyState) {
        waitABit(500);
        selectRadionButton(KEY_MAPPED_CIVIL_MONEY_UNDER_ANY_STATE,keyEmployeeCivilMoneyUnderAnyState);
        waitABit(1000);
    }

    public void setKeyEmployeeSanctionedExcludedAnyState(String keyEmployeeSanctionedExcludedAnyState) {
        waitABit(500);
        selectRadionButton(KEY_MAPPED_SANCTIONED_EXCLUDED_ANY_STATE,keyEmployeeSanctionedExcludedAnyState);
        waitABit(1000);
    }

    private static final String FRAUD_ALLIGATIONS ="1. Fraud, theft, embezzlement, extortion, income tax evasion, or insurance fraud";

    public void setFraudAlligations(String fraudAlligations) {
        waitABit(500);
        selectRadionButton(FRAUD_ALLIGATIONS,fraudAlligations);
        waitABit(500);
    }

    private static final String FIDUCIARY_RESPONSIBILITY ="2. Financial misconduct tied to delivery of health care not otherwise noted or breach of fiduciary responsibility";

    public void setFiduciaryResponsibility(String fiduciaryResponsibility) {
        waitABit(500);
        selectRadionButton(FIDUCIARY_RESPONSIBILITY,fiduciaryResponsibility);
        waitABit(500);
    }

    private static final String PERJURY ="3. Perjury";

    public void setPerjury(String perjury) {
        waitABit(500);
        selectRadionButton(PERJURY,perjury);
        waitABit(500);
    }

    private static final String SERVICE_ABUSE ="4. Abuse or neglect of a patient, child, or elderly adult";

    public void setServiceAbuse(String serviceAbuse) {
        waitABit(500);
        selectRadionButton(SERVICE_ABUSE,serviceAbuse);
        waitABit(500);
    }

    private static final String CRIMINAL_INVESTIGATION ="5. Obstruction of a criminal investigation";

    public void setCriminalInvestigation(String criminalInvestigation) {
        waitABit(500);
        selectRadionButton(CRIMINAL_INVESTIGATION,criminalInvestigation);
        waitABit(500);
    }

    private static final String UNLAWFUL_SUBSTANCES ="6. Unlawful manufacture, distribution, prescription, or dispensing of any controlled substances";

    public void setUnlawfulSubstances(String unlawfulSubstances) {
        waitABit(500);
        selectRadionButton(UNLAWFUL_SUBSTANCES,unlawfulSubstances);
        waitABit(500);
    }

    private static final String HEALTH_CARE_CRIME ="7. Health care related crime, not otherwise listed";

    public void setHealthCareCrime(String healthCareCrime) {
        waitABit(500);
        selectRadionButton(HEALTH_CARE_CRIME,healthCareCrime);
        waitABit(500);
    }

    private static final String PAYMENT_INFORMATION ="1. Failed to grant immediate access and/or provide payment information";
    public void setPaymentInformation(String paymentInformation) {
        waitABit(500);
        selectRadionButton(PAYMENT_INFORMATION,paymentInformation);
        waitABit(500);
    }

    private static final String DISCLOSURE_INFORMATION ="2. Failed to provide disclosure information";
    public void setDisclosureInformation(String disclosureInformation) {
        waitABit(500);
        selectRadionButton(DISCLOSURE_INFORMATION,disclosureInformation);
        waitABit(500);
    }

    private static final String SUSPENSION_OF_LICENSE ="3. Revocation or suspension of a license to provide health care, including any license surrender while formal disciplinary actions were pending";
    public void setSuspensionOfLicense(String suspensionOfLicense) {
        waitABit(500);
        selectRadionButton(SUSPENSION_OF_LICENSE,suspensionOfLicense);
        waitABit(500);
    }
    private static final String OWES_MONEY_TO_MEDICAID="Owes money to Medicaid or Medicare that has not been paid";
    public void setOwesMoneyToMedicaid(String owesMoneyToMedicaid){
        waitABit(500);
        selectRadionButton(OWES_MONEY_TO_MEDICAID, owesMoneyToMedicaid);
        waitABit(500);
    }

    private static final String SUSPENSION_OF_ACCREDITATION ="4. Revocation or suspension of accreditation";
    public void setSuspensionOfAccreditation(String suspensionOfAccreditation) {
        waitABit(500);
        selectRadionButton(SUSPENSION_OF_ACCREDITATION,suspensionOfAccreditation);
        waitABit(500);
    }
    private static final String SUSPENSION_EXCLUSION="Suspension, exclusion, debarment, or sanction from participation by a Federal";
    public void setSuspensionExclusion(String suspensionExclusion){
        waitABit(200);
        selectRadionButton(SUSPENSION_EXCLUSION, suspensionExclusion);
        waitABit(500);
    }


    private static final String SUSPENDED_OR_EXCLUDED ="Been denied enrollment, been suspended";
    public void setSuspendedOrExcluded(String suspendedOrExcluded) {
        waitABit(500);
        selectRadionButton(SUSPENDED_OR_EXCLUDED, suspendedOrExcluded);
        waitABit(500);
    }


    private static final String PAYMENT_SUSPENSION ="6. Had suspended payments from Medicare or Medicaid in any state, or been employed by a corporation";
    public void setPaymentSuspension(String paymentSuspension) {
        waitABit(500);
        selectRadionButton(PAYMENT_SUSPENSION,paymentSuspension);
        waitABit(500);
    }

    private static final String FALSE_CLAIMS_ACT ="7. Judgment under the False Claims Act";
    public void setFalseClaimsAct(String falseClaimsAct) {
        waitABit(500);
        selectRadionButton(FALSE_CLAIMS_ACT,falseClaimsAct);
        waitABit(500);
    }
    private static final String CURRENT_PAYMENT="Current payment suspension with Medicare or another State Medicaid agency";
    public void setCurrentPayment(String currentPayment){
        waitABit(500);
        selectRadionButton(CURRENT_PAYMENT, currentPayment);
        waitABit(500);
    }

    private static final String CURRENT_OVERPAYMENT ="Current overpayment with Medicare or another State Medicaid";
    public void setCurrentOverpayment(String currentOverpayment) {
        waitABit(500);
        selectRadionButton(CURRENT_OVERPAYMENT,currentOverpayment);
        waitABit(500);
    }
    private static final String CONVICTED_FELONY="8. Been convicted of a felony, had adjudication withheld on a felony, pled nolo contendere to a felony";
    public void setConvictedFelony(String convictedFelony)
    {
        waitABit(200);
        selectRadionButton(CONVICTED_FELONY, convictedFelony);
        waitABit(200);

    }
   private static final  String BUSSINESS_PROFEESIONAL_LICENSE="Had any disciplinary action taken against any business or professional license held in this or any other state or surrendered a license in this or any state";
    public void setBusinessOrProffesionalLicense(String businessOrProffesionalLicense){
        waitABit(500);
        selectRadionButton(BUSSINESS_PROFEESIONAL_LICENSE, businessOrProffesionalLicense);
        waitABit(500);
    }
}
