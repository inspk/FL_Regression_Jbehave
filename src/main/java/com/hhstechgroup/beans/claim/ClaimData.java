package com.hhstechgroup.beans.claim;

import com.hhstechgroup.beans.application.ApplicationSectionData;
import lombok.Data;

@Data
public class ClaimData implements ApplicationSectionData {

    private String diagnosis1;
    private String diagnosis2;
    private String diagnosis3;
    private String diagnosis4;
    private String diagnosis5;
    private String diagnosis6;
    private String diagnosis7;
}
