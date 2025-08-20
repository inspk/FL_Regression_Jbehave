package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class UpdateProfilePanel extends BaseEnrollmentPanel {

    public UpdateProfilePanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    private static final String DISPLAY_NAME = "//input[@id='display name']";
    private static final String TIME_ZONE = "//label[contains(text(), 'Timezone')]/../div";
    private static final String LANGUAGE = "//label[contains(text(), 'Language')]/../div";
    private static final String COMPANY = "//input[@id='company']";
    private static final String JOB_TITLE = "//input[@id='job Title']";
    private static final String DEPARTMENT = "//input[@id='department']";
    private static final String LOCATION = "//label[contains(text(), 'Location')]/../div";
    private static final String MOBILE = "//input[@placeholder='Mobile']";
    private static final String PHONE = "//input[@name='Phone']";
    private static final String EXT = "//input[@id='extension']";
    private static final String FAX = "//input[@placeholder='Fax']";
    private static final String OPTIONS = "//ul/li[node()='%s']";


    public void setDisplayName(String displayName){
        findBy(DISPLAY_NAME).type(displayName);
        waitABit(500);
    }

    public void setTimeZone(String timeZone){
        findBy(TIME_ZONE).click();
        waitABit(500);
        jsClick(format(OPTIONS, timeZone));
    }

    public void setLanguage(String language){
        findBy(LANGUAGE).click();
        waitABit(500);
        jsClick(format(OPTIONS, language));
        waitABit(500);
        findBy("//*").click();
    }

    public void setCompany(String company){
        findBy(COMPANY).type(company);
        waitABit(500);
    }

    public void setJobTitle(String jobTitle){
        findBy(JOB_TITLE).type(jobTitle);
        waitABit(500);
    }

    public void setDepartment(String department){
        findBy(DEPARTMENT).type(department);
        waitABit(500);
    }

    public void setLocation(String location){
        findBy(LOCATION).type(location);
        waitABit(500);
    }

    public void setMobile(String mobile){
        findBy(MOBILE).type(mobile);
        waitABit(500);
    }

    public void setPhone(String phone){
        findBy(PHONE).type(phone);
        waitABit(500);
    }

    public void setFax(String fax){
        findBy(FAX).type(fax);
        waitABit(500);
    }

    public void setExt(String ext){
        findBy(EXT).type(ext);
        waitABit(500);
    }
}
