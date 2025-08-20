package com.hhstechgroup.beans.sitevisit;

import com.hhstechgroup.beans.application.ApplicationSectionData;
import lombok.Data;

@Data
public class DatesAndReason implements ApplicationSectionData {

    private String dateOrdered;
    private String dateOfFirstVisit;
    private String dateOfSecondVisit;
    private String reason;
}
