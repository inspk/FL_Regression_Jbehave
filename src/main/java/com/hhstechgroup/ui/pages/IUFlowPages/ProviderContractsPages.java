package com.hhstechgroup.ui.pages.IUFlowPages;

import com.hhstechgroup.ui.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProviderContractsPages extends AbstractPage {

    public ProviderContractsPages(WebDriver driver){
        super(driver);
    }

    public static final String ARROW_FOR_REDIRECTION=("//div[contains(@class, 'MuiTabs-scrollButtons') and @aria-disabled='false']");
    public static final String PROVIDER_CONTRACT=("//button[.//span[text()='Provider Contracts']]");

    public void verifyProvidercontract(){
        waitAbit(5000);
        findBy(ARROW_FOR_REDIRECTION).click();
        waitAbit(5000);
        findBy(PROVIDER_CONTRACT).click();
        System.out.println("Clicked on Providers contract");
        waitAbit(5000);
        WebElement firstRow = getDriver().findElement(By.xpath("(//div[contains(@class,'tile-table-body')]//div[contains(@class,'tile-table-row')])[1]"));
        Assert.assertTrue("First provider contract row is not visible", firstRow.isDisplayed());

    }
}
