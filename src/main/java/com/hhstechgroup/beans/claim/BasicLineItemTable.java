package com.hhstechgroup.beans.claim;

import com.hhstechgroup.beans.application.ApplicationSectionData;
import lombok.Data;

@Data
public class BasicLineItemTable implements ApplicationSectionData {

    private String serviceDateBegin;
    private String serviceDateEnd;
    private String procedureCode;
    private String modifier1;
    private String modifier2;
    private String modifier3;
    private String modifier4;
    private String diagnosisPointer;
    private String lineItemChargeAmount;
}
