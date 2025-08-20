package com.hhstechgroup.ui.pages.sitevisit;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.enrollment.LeftMenuPanel;
import com.hhstechgroup.ui.panels.peportal.MainInfoBlock;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class AddRequestPage extends ProviderManagementBasePage {

    private static final String REQUEST_DETAILS = "//div[contains(@class, 'main-info-panel_card_')]";
    private static final String NO_AUTHOR_PROVIDER_NAME = ".//div[contains(@class, 'details_blue') and contains(text(), 'No Author')]";

    public AddRequestPage(WebDriver driver) {
        super(driver);
    }

    public Map<String, String> getRequestDetails() {
        System.out.println(isElementPresent(NO_AUTHOR_PROVIDER_NAME));
        waitForAbsenceOf(NO_AUTHOR_PROVIDER_NAME);
        Map<String, String> info = new MainInfoBlock(findBy(REQUEST_DETAILS), this).getMappedValues();
        return info.entrySet().stream().collect(toMap(Map.Entry::getKey, entry -> entry.getValue().replaceAll("\\n", " ")));
    }
}
