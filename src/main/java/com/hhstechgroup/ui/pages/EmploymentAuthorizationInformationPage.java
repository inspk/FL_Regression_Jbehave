package com.hhstechgroup.ui.pages;

import com.hhstechgroup.ui.panels.enrollment.EmploymentAuthorizationInformationPanel;
import com.hhstechgroup.ui.panels.enrollment.OtherCredentialingInformationPanel;
import org.openqa.selenium.WebDriver;

public class EmploymentAuthorizationInformationPage extends ProviderManagementBasePage{
    public EmploymentAuthorizationInformationPage(WebDriver driver) {
        super(driver);
    }
    private static final String ENROLLMENT_SECTION_PANEL = ".//div[contains(@class,'section-inner')]";

    public EmploymentAuthorizationInformationPanel getEmploymentAuthorizationInformation(){
        return new EmploymentAuthorizationInformationPanel(findBy(ENROLLMENT_SECTION_PANEL), this);

    }
}
