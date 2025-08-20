package com.hhstechgroup.ui.panels.pedashboard;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import com.hhstechgroup.ui.panels.peportal.AppealBlock;
import com.hhstechgroup.ui.panels.peportal.MainInfoBlock;
import net.serenitybdd.core.pages.WebElementFacade;

public class BodyPanel extends AbstractPanel {

    private static final String INVITATION_MESSAGE = ".//div[contains(@class, 'dashboard_utility')]//div";
    private static final String WELCOME_MESSAGE = "//h1";
    private static final String ENROLLMENT_TYPE_PANEL = ".//div[contains(@class, 'link-wrap')]//div[contains(@class, 'link-box')]/h2[text() = '%s']";
    private static final String PAYER = ".//div[contains(@class, 'styles_payer-list')]/div[contains(@class, 'styles_payer')]/h3[text()='%s']/..";
    private static final String ENROLLMENT_INFO_PANEL = ".//div[contains(@class, 'main_info_panel')]";
    private static final String APPEAL_INFO_PANEL = ".//div[contains(@class, 'main-info-panel_card_')][2]";
    private static final String PAYMENT_TYPE_PANEL = ".//h3[contains(text(), '%s')]//ancestor::div[contains(@class, 'tab-box')]";
    private static final String ELIGIBILITY_TYPE_PANEL = ".//span[contains(text(), '%s')]//ancestor::div[contains(@class, 'search-box')]";
    private static final String ENROLLMENT_PANEL = ".//h3[contains(text(), 'Enrollment info')]//parent::div";
    private static final String PAYMENTS_LIST = ".//div[contains(@class, 'details_header')]/parent::div";
    private static final String APPEAL_BLOCK = ".//h1/following-sibling::*[2]";
    private static final String ENROLLMENT_PACKAGE_TITLE = ".//div[contains(@class, 'helptour_package')]//h1[text() = 'Enrollment package']";
    private static final String ENROLLMENT_PACKAGE_TEXT = ".//div[contains(@class, 'helptour_package')]//h3";
    private static final String ENROLLMENT_PACKAGE_DOWNLOAD = ".//div[contains(@class, 'styles_download-btn')]";
    private static final String ENROLLMENT_PACKAGE_REQUEST = ".//button[span[text() = 'REQUEST']]";
    private static final String REVALIDATION_WIDGET = ".//div[contains(@class, '_revalidation_')]";
    private static final String ENROLLMENT_TERMINATED_DESCRIPTION = ".//p";

    public BodyPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public String getInvitationMessage() {
        return findBy(INVITATION_MESSAGE).getText();
    }

    public EnrollmentMiniPanel getEnrollmentMiniPanel(String panel) {
        return new EnrollmentMiniPanel(findBy(String.format(ENROLLMENT_TYPE_PANEL, panel)), getBasePage());
    }

    public MainInfoBlock getContinueEnrollmentPanel() {
        return new MainInfoBlock(findBy(ENROLLMENT_INFO_PANEL), getBasePage());
    }

    public MainInfoBlock getAppealPanel() {
        return new MainInfoBlock(findBy(APPEAL_INFO_PANEL), getBasePage());
    }

    public AppealBlock getAppealBlock() {
        return new AppealBlock(findBy(APPEAL_BLOCK), getBasePage());
    }

    public PaymentClaimPanel getPaymentClaimPanel(String panel) {
        return new PaymentClaimPanel(findBy(String.format(PAYMENT_TYPE_PANEL, panel)), getBasePage());
    }

    public EnrollmentInfoPanel getEnrollmentInfoPanel() {
        return new EnrollmentInfoPanel(findBy(ENROLLMENT_PANEL), getBasePage());
    }

    public boolean isEnrollmentInfoPanelPresent() {
        return isElementPresent(ENROLLMENT_PANEL);
    }

    public EligibilityPanel getEligibilityPanel(String form) {
        return new EligibilityPanel(findBy(String.format(ELIGIBILITY_TYPE_PANEL, form)), getBasePage());
    }

    public String getWelcomeMessage() {
        return findBy(WELCOME_MESSAGE).getText();
    }

    public void clickSelectPayer(String payer) {
        findBy(String.format(PAYER, payer)).click();
        waitForAbsenceOf(SPINNER);
    }

    public boolean isPaymentsListDisplayed() {
        waitForPresenceOf(PAYMENTS_LIST);
        return isElementPresent(PAYMENTS_LIST);
    }

    public PaymentsList getPaymentsList() {
        return new PaymentsList(findBy(PAYMENTS_LIST), getBasePage());
    }

    public boolean getEnrollmentPackageTitle() {
        return isElementPresent(ENROLLMENT_PACKAGE_TITLE);
    }

    public String getEnrollmentPackageText() {
        return findBy(ENROLLMENT_PACKAGE_TEXT).getText();
    }

    public void clickDownloadPackage() {
        findBy(ENROLLMENT_PACKAGE_DOWNLOAD).click();
    }

    public void clickRequestPackage() {
        findBy(ENROLLMENT_PACKAGE_REQUEST).click();
    }

    public RevalidationWidget getRevalidationWidget() {
        return new RevalidationWidget(findBy(REVALIDATION_WIDGET), getBasePage());
    }

    public String getEnrollmentTerminatedDescription() {
        return findBy(ENROLLMENT_TERMINATED_DESCRIPTION).getText();
    }

}
