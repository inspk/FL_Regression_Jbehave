package com.hhstechgroup.ui.panels.sitevisit;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class FacilityInspectionPanel extends BaseEnrollmentPanel {

    private static final String UPLOAD_PHOTOGRAPH = ".//h4[text() = 'Photograph']/../../div[contains(@class, 'upload_upload-controls')]/input";

    public FacilityInspectionPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void uploadPhotograph(String path) {
        WebElement element = findBy(UPLOAD_PHOTOGRAPH);
        upload(element, path);
    }
}
