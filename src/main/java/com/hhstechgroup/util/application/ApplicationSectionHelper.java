package com.hhstechgroup.util.application;


import com.hhstechgroup.beans.application.*;
import com.hhstechgroup.beans.claim.*;
import com.hhstechgroup.beans.sitevisit.DatesAndReason;
import com.hhstechgroup.beans.sitevisit.FacilityInformation;
import com.hhstechgroup.ui.panels.claim.*;
import com.hhstechgroup.ui.panels.enrollment.*;
import com.hhstechgroup.ui.panels.enrollment.affiliation.AffiliationPanel;
import com.hhstechgroup.ui.panels.enrollment.affiliation.AffiliationTable;
import com.hhstechgroup.ui.panels.enrollment.electronicfundspayment.ElectronicFundsPaymentPanel;
import com.hhstechgroup.ui.panels.enrollment.electronictransactionsubmission.BillingAddressTable;
import com.hhstechgroup.ui.panels.enrollment.electronictransactionsubmission.ClearingHouseTable;
import com.hhstechgroup.ui.panels.enrollment.electronictransactionsubmission.ElectronicTransactionSubmissionPanel;
import com.hhstechgroup.ui.panels.enrollment.exclusionsanction.ExclusionSanctionPanel;
import com.hhstechgroup.ui.panels.enrollment.exclusionsanction.FederalProgramTable;
import com.hhstechgroup.ui.panels.enrollment.exclusionsanction.NameTable;
import com.hhstechgroup.ui.panels.enrollment.licensure.LicensureCertificationPanel;
import com.hhstechgroup.ui.panels.enrollment.licensure.LicensureTable;
import com.hhstechgroup.ui.panels.enrollment.ownership.OwnershipCommonInformationTable;
import com.hhstechgroup.ui.panels.enrollment.ownership.OwnershipPanel;
import com.hhstechgroup.ui.panels.enrollment.ownership.RelativeInformationTable;
import com.hhstechgroup.ui.panels.enrollment.servicelocationbilling.ContactPersonTable;
import com.hhstechgroup.ui.panels.enrollment.servicelocationbilling.EmailTable;
import com.hhstechgroup.ui.panels.enrollment.servicelocationbilling.PhoneFaxTable;
import com.hhstechgroup.ui.panels.enrollment.servicelocationbilling.ServiceLocationBillingPanel;
import com.hhstechgroup.ui.panels.sitevisit.DatesAndReasonPanel;
import com.hhstechgroup.ui.panels.sitevisit.FacilityInformationPanel;
import org.apache.log4j.Logger;

import static java.lang.String.format;

public class ApplicationSectionHelper {

    private static Logger logger = Logger.getLogger(ApplicationSectionHelper.class);

    public static Class<? extends BaseEnrollmentPanel> getSectionPanelClass(String sectionName) {
        switch (sectionName) {
            case "Identifying information":
                return IdentifyingInformationPanel.class;
            case "Licensure":
                return LicensureCertificationPanel.class;
            case "Provider identifier number":
                return ProviderIdentifierNumberPanel.class;
            case "Service location billing":
                return ServiceLocationBillingPanel.class;
            case "Electronic funds payment":
                return ElectronicFundsPaymentPanel.class;
            case "Remittance advice":
                return RemittanceAdvicePanel.class;
            case "Affiliation":
                return AffiliationPanel.class;
            case "Group Affiliation":
                return AffiliationPanel.class;
            case "Electronic transaction submission":
                return ElectronicTransactionSubmissionPanel.class;
            case "Ownership":
                return OwnershipPanel.class;
            case "Exclusion / Sanction":
                return ExclusionSanctionPanel.class;
            case "PCCM":
                return PCCMPanel.class;
            case "Summary":
                return SummaryPanel.class;
            case "Physical Address":
                return AddressPanel.class;
            case "Tel/Fax/Email":
                return IdentifyingInformationPanel.class;
            case "Membership / Operations":
                return MembershipOperationsPanel.class;
            case "Dates and reason for visit":
                return DatesAndReasonPanel.class;
            case "Facility information":
                return FacilityInformationPanel.class;
            case "Provider Information":
                return ProviderInformationPanel.class;
            case "Member information":
                return MemberInformationPanel.class;
            case "Claim data":
                return ClaimDataPanel.class;
            case "Claim information":
                return ClaimInformationPanel.class;
            case "Basic line item information":
                return BasicLineItemInformationPanel.class;

            case "Address Details":
                return ServiceLocationBillingPanel.class;
            default:
                logger.warn(format("Unable to identify section with name %s", sectionName));
                return BaseEnrollmentPanel.class;
        }
    }

    public static Class<? extends BaseTable> getTablePanelClass(String tableName) {
        switch (tableName) {
            case "Location contact person(s)":
                return ContactPersonTable.class;
            case "Licensure":
                return LicensureTable.class;
            case "Email":
                return EmailTable.class;
            case "Address Information":
                return PhoneFaxTable.class;
            case "Ownership information":
                return OwnershipCommonInformationTable.class;
            case "Managing/directing information":
                return OwnershipCommonInformationTable.class;
            case "Subcontractor information":
                return OwnershipCommonInformationTable.class;
            case "Relative information":
                return RelativeInformationTable.class;
            case "Federal program":
                return FederalProgramTable.class;
            case "Name":
                return NameTable.class;
            case "Billing software":
                return BillingAddressTable.class;
            case "Billing agent/Clearing house":
                return ClearingHouseTable.class;
            case "Affiliation":
                return AffiliationTable.class;
            case "Group Affiliation":
                return AffiliationTable.class;
            case "NPI":
                return AffiliationTable.class;
            case "Contact Information":
                return ContactPersonTable.class;
            case "Basic Line Item":
                return BasicLineItemTablePanel.class;
            default:
                logger.warn(format("Unable to identify table with name %s", tableName));
                return BaseTable.class;
        }
    }
    public static Class<? extends ApplicationSectionData> getSectionClass(String sectionName) {
        switch (sectionName) {
            case "Identifying information":
                return IdentifyingInformationBean.class;
            case "Licensure":
                return LicensureCertificationBean.class;
            case "Provider identifier number":
                return ProviderIdentifierNumberBean.class;
            case "Service location billing":
                return ServiceLocationBillingBean.class;
            case "Electronic funds payment":
                return ElectronicFundsPaymentBean.class;
            case "Remittance advice":
                return RemittanceAdviceBean.class;
            case "Affiliation":
                return AffiliationBean.class;
            case "Group Affiliation":
                return AffiliationBean.class;
            case "Electronic transaction submission":
                return ElectronicTransactionSubmissionBean.class;
            case "Ownership":
                return OwnershipBean.class;
            case "Exclusion / Sanction":
                return ExclusionSanctionBean.class;
            case "PCCM":
                return PCCMBean.class;
            case "Summary":
                return SummaryBean.class;
            case "Physical Address":
                return AddressBean.class;
            case "Tel/Fax/Email":
                return IdentifyingInformationBean.class;
            case "Membership / Operations":
                return ServiceLocationBillingBean.class;
            case "Dates and reason for visit":
                return DatesAndReason.class;
            case "Facility information":
                return FacilityInformation.class;
            case "Provider Information":
                return ProviderInformation.class;
            case "Member information":
                return MemberInformation.class;
            case "Claim data":
                return ClaimData.class;
            case "Claim information":
                return ClaimInformation.class;
            case "Basic line item information":
                return BasicLineItemInformation.class;
            case "Address Details":
                return AddressBean.class;

            default:
                throw new IllegalArgumentException(format("Unable to identify section with name %s", sectionName));
        }
    }
    public static Class<? extends ApplicationSectionData> getTableClass(String tableName) {
        switch (tableName) {
            case "Location contact person(s)":
                return LocationContactPersonBean.class;
            case "Licensure":
                return LicensureCertificationBean.class;
            case "Email":
                return ServiceLocationBillingBean.class;
            case "Address Information":
                return ServiceLocationBillingBean.class;
            case "Ownership information":
                return OwnershipTableBean.class;
            case "Managing/directing information":
                return OwnershipTableBean.class;
            case "Subcontractor information":
                return OwnershipTableBean.class;
            case "Relative information":
                return OwnershipBean.class;
            case "Federal program":
                return ExclusionSanctionBean.class;
            case "Name":
                return ExclusionSanctionBean.class;
            case "Billing software":
                return ElectronicTransactionSubmissionBean.class;
            case "Billing agent/Clearing house":
                return ElectronicTransactionSubmissionBean.class;
            case "Affiliation":
                return AffiliationBean.class;
            case "Group Affiliation":
                return AffiliationBean.class;
            case "NPI":
                return AffiliationBean.class;
            case "Contact Information":
                return LocationContactPersonBean.class;
            case "Basic Line Item":
                return BasicLineItemTable.class;
            default:
                throw new IllegalArgumentException(format("Unable to identify table with name %s", tableName));
        }
    }

}
