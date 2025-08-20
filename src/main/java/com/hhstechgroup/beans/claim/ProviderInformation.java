package com.hhstechgroup.beans.claim;

import com.hhstechgroup.beans.application.ApplicationSectionData;
import lombok.Data;

@Data
public class ProviderInformation implements ApplicationSectionData {

    private String nationalProviderID;
    private String taxID;
    private String prefix;
    private String firstName;
    private String mi;
    private String lastName;
    private String suffix;
    private String physicalAddress;
    private String zip;
}
