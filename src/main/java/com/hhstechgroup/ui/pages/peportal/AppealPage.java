package com.hhstechgroup.ui.pages.peportal;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.appeal.AppealPanel;
import com.hhstechgroup.ui.panels.pedashboard.SuccessPanel;
import org.openqa.selenium.WebDriver;
import com.hhstechgroup.ui.panels.peportal.MainInfoBlock;
import java.util.Map;
import static java.lang.String.format;
import static java.util.stream.Collectors.toMap;

public class AppealPage extends ProviderManagementBasePage {

    //sp65
    private static final String APPEAL_PANEL = ".//h3[contains(text(), 'Appeal')]/parent::div/..";
    private static final String APPEAL_CLAIM_BUTTON = "//span[contains(text(), 'APPEAL')]";
    private static final String APPEAL_BUTTON = "//button[span[contains(text(), 'Appeal')]]";
    private static final String SUBMIT_BUTTON = "//span[contains(text(), 'Submit')]";
    private static final String SUCCESS_PANEL = ".//p[text() = 'Success!']/parent::div";
    private static final String PLUS_APPEAL = "//span[contains(text(), 'Appeal')]/parent::button";
    private static final String APPEAL_WITH_ID = "//div[contains(@class, 'appeals_row')]/div[1]/span[contains(text(), '%s')]/../parent::div//span[contains(text(), 'Appeal')]";
    private static final String APPEAL_FORM = "//h4[contains(text(), 'Appeal application')]";
    private static final String APPEAL_FOR_ID = "//span[contains(text(), '%s')]//../..//span[contains(text(), 'Appeal')]/parent::button";
    private static final String MAIN_INFO_PANEL = "//div[contains(@class, 'main-info-panel_card_')]";
    private static final String APPEAL_ID = "//p[contains(text(), '%s')]//ancestor-or-self::div[contains(@class, 'summary')]";
    private static final String APPLICATION_INFO_DETAILS = ".//div[contains(@class, 'application_info-item_')]";
    private static final String APPLICATION_INFO_HEADER = ".//h6";
    private static final String APPLICATION_INFO_VALUE =  ".//p";
    private static final String APP_TAB_IN_APPEAL_DETAILS = ".//button//span[text() = '%s']";
    private static final String HEARING_DETAILS_BLOCK = ".//div[contains(@class, 'details_hearing-container_')][%s]//div[contains(@class, 'details_line')]";
    private static final String HEARING_VALUE = "./div";
    private static final String APPEAL_FILES_AND_DOCUMENTS_PANEL = ".//div[contains(@class, 'layout_app-details-inner-body')]";

    public AppealPage(WebDriver driver) {
        super(driver);
    }

    public void clickAppeal() {
        findBy(APPEAL_BUTTON).click();
    }

    public void clickAppealFromAppeals() {
        findBy(PLUS_APPEAL).click();
    }

    public void clickAppealWithId(String requestId) {
        String hover = String.format(APPEAL_WITH_ID, requestId);
        jsClick(hover);

    }

    public void clickAppealClaim() {
        findBy(APPEAL_CLAIM_BUTTON).click();
    }

    public AppealPanel getAppealPanel() {
        return new AppealPanel(findBy(APPEAL_PANEL), this);
    }

    public void waitForAppealPanel() {
        waitForPresenceOf(APPEAL_PANEL);
    }

    public void submitAppeal() {
        waitAbit(1500);
        jsClick(SUBMIT_BUTTON);
        waitAbit(1500);
        //findBy(SUBMIT_BUTTON).click();
    }

    public SuccessPanel getSuccessPanel() {
        return new SuccessPanel(findBy(SUCCESS_PANEL), this);
    }

    public boolean isAppealButtonPresent() {
        waitForSpinnerToDisappear();
        return isElementPresent(APPEAL_BUTTON);
    }

    public boolean isAppealFormPresent() {
        waitForSpinnerToDisappear();
        return isElementPresent(APPEAL_FORM);
    }

    public void createAppealForId(String id) {
        findBy(String.format(APPEAL_FOR_ID, id)).click();
    }

    public void clickOnAppealWithId (String appealId) {
        findBy(format(APPEAL_ID, appealId)).click();
    }

    public Map<String, String> getAppealMainInfo() {
        Map<String, String> info = new MainInfoBlock(findBy(MAIN_INFO_PANEL), this).getMappedValues();
        return info.entrySet().stream().collect(toMap(Map.Entry::getKey, entry -> entry.getValue().replaceAll("\\n", " ")));
    }

    public Map<String, String> getAppTabInfoIU() {
        return findAll(APPLICATION_INFO_DETAILS).stream().collect(toMap(element -> element.thenFindAll(APPLICATION_INFO_HEADER).get(0).getAttribute("innerText"), element -> element.thenFindAll(APPLICATION_INFO_VALUE).get(0).getAttribute("innerText")));
    }
    public void clickTabInAppealDetails(String appTab) { waitAbit(3000);
        findBy(format(APP_TAB_IN_APPEAL_DETAILS, appTab)).click();
    }

    public Map<String, String> getHearingBlock(String blockNumber) {
        return findAll(format(HEARING_DETAILS_BLOCK, blockNumber)).stream().collect(toMap(element -> element.thenFindAll(HEARING_VALUE).get(0).getAttribute("innerText"), element -> element.thenFindAll(HEARING_VALUE).get(1).getAttribute("innerText")));
    }

    public AppealPanel getAppealFilesDocumentsPanel() {
        return new AppealPanel(findBy(APPEAL_FILES_AND_DOCUMENTS_PANEL), this);
    }

    //wyomi WY-63 updating appeal
    private static final String APPEAL_PANEL1 = ".//h2[contains(text(), 'Create Appeal')]/parent::div/..";
    public AppealPanel getAppealPanel1() {
        return new AppealPanel(findBy(APPEAL_PANEL1), this);
    }

}
