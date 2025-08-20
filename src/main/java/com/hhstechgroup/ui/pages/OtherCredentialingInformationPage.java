package com.hhstechgroup.ui.pages;

import com.hhstechgroup.ui.panels.enrollment.OtherCredentialingInformationPanel;
import org.openqa.selenium.WebDriver;

public class OtherCredentialingInformationPage extends ProviderManagementBasePage{
    public OtherCredentialingInformationPage(WebDriver driver) {
        super(driver);
    }
    private static final String ENROLLMENT_SECTION_PANEL = ".//div[contains(@class,'section-inner')]";
    public OtherCredentialingInformationPanel getOtherCredentialingInformation(){
        return new OtherCredentialingInformationPanel(findBy(ENROLLMENT_SECTION_PANEL), this);
    }
}
