package com.hhstechgroup.ui.pages;


import com.hhstechgroup.ui.panels.systemoptions.ExternalizationPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExternalizationPage extends AbstractPage {
    public ExternalizationPage(WebDriver driver) {
        super(driver);
    }
    //adding Taxonomy in sp21
    private static final String  ADD_TAXONOMY_PANEL = ".//div[contains(@class,'addtaxonomy_dialog')]" ;
    private static final String  ADD_TAXONOMY_BUTTON = ".//button/span[contains(text(),'Add')]" ;
    private static final String  SAVE_TAXONOMY_BUTTON = ".//button/span[contains(text(),'Save')]" ;
    private static final String  OK_BUTTON = ".//button/span[contains(text(),'OK')]";
    public ExternalizationPanel getTaxonomyInfo(){
        return  new ExternalizationPanel(
                findBy(ADD_TAXONOMY_PANEL),this); }

    public void clickOnAddTaxonomyButton(){
        scrollToElement(ADD_TAXONOMY_BUTTON);
        findBy(ADD_TAXONOMY_BUTTON).click();
        waitAbit(200);
    }
    public void saveTaxonomy(){
        waitAbit(200);
        scrollToElement(SAVE_TAXONOMY_BUTTON);
        waitAbit(500);
        jsClick(SAVE_TAXONOMY_BUTTON);
        waitAbit(200);
        jsClick(OK_BUTTON);
        waitAbit(200);
    }

    //SD-10 fild validation

    public boolean isSaveButtonEnabled(){
        waitAbit(200);
        scrollToElement("//button/span[text()='Save']/parent::button");
        waitAbit(500);
        WebElement save = getDriver().findElement(By.xpath("//button/span[text()='Save']/parent::button"));
        return save.isEnabled();
    }

}
