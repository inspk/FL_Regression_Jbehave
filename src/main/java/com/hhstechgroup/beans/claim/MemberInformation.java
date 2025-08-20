package com.hhstechgroup.beans.claim;

import com.hhstechgroup.beans.application.ApplicationSectionData;
import lombok.Data;

@Data
public class MemberInformation implements ApplicationSectionData {

    private String memberID;
    private String prefix;
    private String firstName;
    private String mi;
    private String lastName;
    private String suffix;
    private String dateOfBirth;
    private String gender;
    private String physicalAddress;
    private String zip;
}
