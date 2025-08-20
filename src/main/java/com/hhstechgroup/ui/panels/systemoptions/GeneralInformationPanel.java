package com.hhstechgroup.ui.panels.systemoptions;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class GeneralInformationPanel extends AbstractPanel {
        private static final String COMPANY_FIELD = ".//input[@id='company']";
        private static final String DEPARTMENT_FIELD = ".//div/input[@id='department']";
        private static final String JOBTITLE_FIELD = ".//div/input[@id='job Title']";
        private static final String MOBILE = ".//div/input[@id='Mobile']";
        private static final String PHONE = ".//div/input[@id='Phone']";
        private static final String FAX = ".//div/input[@id='Fax']";
        private static final String LOCATION = ".//div/input[contains(@id,'Location')]";

    public GeneralInformationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

        public void setCompanyName(String companyName) {findBy(COMPANY_FIELD).type(companyName); }

        public void setDepartmentName(String departmentName) {
        findBy(DEPARTMENT_FIELD).type(departmentName);
    }

        public void setJobTitle(String jobTitle) { findBy(JOBTITLE_FIELD).type(jobTitle); }

        public void setMobileNo(String mobileNo) {
        findBy(MOBILE).type(mobileNo);
    }

        public void setPhoneNo(String phoneNo) {

        waitABit(1000);
        findBy(format(PHONE,phoneNo)).click();
        waitABit(1000);
        //String field1 = format(CLICK_USERNAME,userName);
        findBy(format(PHONE,phoneNo)).clear();
        waitABit(1000);
        findBy(PHONE).type(phoneNo);}

        public void setFax(String fax) { findBy(FAX).type(fax);}

        public void setLocation(String location) {
        scrollToElement(LOCATION);
        findBy(LOCATION).type(location);}

    }
