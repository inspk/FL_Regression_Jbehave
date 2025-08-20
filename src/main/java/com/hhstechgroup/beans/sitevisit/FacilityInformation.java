package com.hhstechgroup.beans.sitevisit;

import com.hhstechgroup.beans.application.ApplicationSectionData;
import lombok.Data;

@Data
public class FacilityInformation implements ApplicationSectionData {

    private String facilityName;
    private String npi;
    private String practiceLocation;
    private String zip;
    private String phone;
    private String authorizedRepresentativeName;
}
