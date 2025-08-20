package com.hhstechgroup.beans.claim;

import com.hhstechgroup.beans.application.ApplicationSectionData;
import lombok.Data;

@Data
public class BasicLineItemInformation implements ApplicationSectionData {

    private String totalClaimChargeAmount;
}
