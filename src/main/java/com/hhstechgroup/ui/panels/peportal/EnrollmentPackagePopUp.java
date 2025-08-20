package com.hhstechgroup.ui.panels.peportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

import static java.lang.String.format;

public class EnrollmentPackagePopUp extends BaseModalPanel {

    private static final String TITLE = ".//h2";
    private static final String DESCRIPTION = ".//div[contains(@class, 'dialog-control')][1]";
    private static final String APPLICATION_TYPE = ".//h2[contains(text(), 'package')]/ancestor::div[@role = 'document']//div[text() = 'Application type']//label[text() = '%s']/preceding-sibling::span//input";
    private static final String ADDITIONAL_INFORMATION = ".//h2[contains(text(), 'package')]/ancestor::div[@role = 'document']//div[text() = 'Additional information']//label[text() = '%s']/preceding-sibling::span//input";
    private static final String DOWNLOAD = ".//button[span[text() = 'Download']]";
    private static final String CANCEL = ".//button[span[text() = 'Cancel']]";

    public EnrollmentPackagePopUp(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public String getTitle() {
        return findBy(TITLE).getText();
    }

    public String getDescription() {
        return findBy(DESCRIPTION).getText();
    }

    public void selectApplicationType(List<String> types) {
        types.forEach(type -> findBy(format(APPLICATION_TYPE, type)).click());
    }

    public void selectAdditionalInformation(List<String> infos) {
        infos.forEach(info -> findBy(format(ADDITIONAL_INFORMATION, info)).click());
    }

    public void clickDownload() {
        findBy(DOWNLOAD).click();
        waitABit(1000);
    }

    public void clickCancel() {
        findBy(CANCEL).click();
    }
}
