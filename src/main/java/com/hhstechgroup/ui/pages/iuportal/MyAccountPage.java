package com.hhstechgroup.ui.pages.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class MyAccountPage extends AbstractPage {

    private static final String KEYS = "//h2[contains(text(), '%s')]/following-sibling::div[1]//span[contains(@class, 'my-account_titles')]/span";
    private static final String VALUES = "//h2[contains(text(), '%s')]/following-sibling::div[1]//span[contains(@class, 'my-account_values')]/span";
    private static final String USER_PHOTO = "//input[contains(@class, 'avatar')]";
    private static final String ERROR_DISPLAYED = "//div[contains(@class, 'my-account_errors')]/span";
    private static final String PHOTO_UPLOADED = "//img[contains(@class, 'avatar')]";

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    public Map<String, String> getMappedValues(String sectionHeader) {
        Map<String, String> fields = new HashMap<>();
        final List<WebElementFacade> titles = findAll(format(KEYS, sectionHeader));
        final List<WebElementFacade> values = findAll(format(VALUES, sectionHeader));
        for (int i = 0; i < titles.size(); i++) {
            final WebElementFacade titleElement = titles.get(i);
            final WebElementFacade valueElement = values.get(i);
            fields.put(titleElement.getText(), valueElement.getText());
        }
        return fields;
    }

    public void uploadUserPhoto(String path) {
        WebElement element = findBy(USER_PHOTO);
        evaluateJavascript("arguments[0].style = \"\"; arguments[0].style.display = \"block\"; arguments[0].style.visibility = \"visible\";", element);
        upload(path).to(element);
    }

    public String getErrorDisplayed() {
        return findBy(ERROR_DISPLAYED).getText();
    }

    public boolean isPhotoUploaded() {
        return isElementPresent(PHOTO_UPLOADED);
    }

}
