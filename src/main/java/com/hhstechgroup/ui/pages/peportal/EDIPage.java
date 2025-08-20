package com.hhstechgroup.ui.pages.peportal;


import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import com.hhstechgroup.ui.panels.iuportal.AddFilePopUp;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class EDIPage extends ProviderManagementBasePage {

    private final static String TITLE = ".//div[contains(@class, 'wr')]/div[i]";
    private final static String BUTTON_NAME = ".//span[text()='Add document']/parent::button";
    private static final String ADD_FILE_POP_UP = "//div[contains(@class, 'edi_upload-dialog')]/div[contains(@role, 'document')]";
    private final static String UPLOAD_FILE = ".//span[text()='Upload file']/parent::button";
    private final static String SELECT_FILE = ".//span[text()='Select File']/parent::span";
    public final static String CLICK_BUTTON = ".//*[contains(text(), '%s')]//button";

    public EDIPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageHasTitle(String title){
       return findBy(TITLE).containsText(title);
    }

    public void clickAddDocument(){
        waitForSpinnerToDisappear();
        findBy(BUTTON_NAME).click();
    }

    public AddFilePopUp getAddFilePopUp() {
        return new AddFilePopUp(findBy(ADD_FILE_POP_UP), this);
    }

    public void clickUploadFile(){
        findBy(UPLOAD_FILE).click();
    }

    public void clickOnAddFileButton(String button){ waitAbit(2000);
        findBy(format(CLICK_BUTTON, button)).click();
    }

}
