package com.hhstechgroup.ui.pages.IUFlowPages;

import com.hhstechgroup.ui.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AffiliationPages extends AbstractPage {
    public AffiliationPages(WebDriver driver){
        super(driver);
    }

//    public static final String SECTION_AFFILIATION = "//div[contains(@class, 'menu')]//span[text() ='Affiliation']";
public static final String SECTION_AFFILIATION = "//div[contains(@class, 'menu-item')]//span[text() ='Affiliation']";
    public static final String ADD_AFFILIATION_BTN = "//span[contains(.,'ADD AFFILIATION')]";
    public static final String TYPE_AFFILIATION= "//label[text()='Type']/following-sibling::div//div[@role='button']";
    public static final String PLAN_TYPE="//label[text()='Plan Type']/following-sibling::div//div[@role='button']";
    public static final String AFFILIATION_SEARCH_BTN = "//button[contains(.,'Search')]";
    public static final String ADD_TAXONOMY_BUTTON= "(//div[contains(@class, 'provider-item')]//button[contains(@class, 'MuiButton-containedPrimary')]//span[contains(text(), 'Add')])[1]";
    public static final String SELECT_REGION= "//div[contains(@id, 'Select Region') and @role='button']";
    public static final String TAXONOMY_RADIO_BTN="(//input[@type='radio' and @name='providerPPRadio'])[1]";
//    public static final String AFFILIATION_LOCATION_EFFECTIVE_START="Affiliate Location Effective start date *";
    public static final String AFFILIATION_LOCATION_EFFECTIVE_START = "(//label[contains(text(),'Affiliate Location Effective start date')]/..//input)[1]";
    public static final String AFFILIATION_TAXONOMY_EFFECTIVE_START = "(//label[contains(text(),'Affiliate Taxonomy Effective Start Date')]/..//input)[1]";
    public static final String NEXT_AFFILIATION_POPUP="//button[.//span[text()='Cancel']]/following-sibling::button[.//span[text()='Next']]";
    public static final String ADD_AFFILIATION="//button[.//span[text()='Cancel']]/following-sibling::button[.//span[text()='Add']]";

    public static final String MCO_Option = "//ul[@aria-label='Select an option']//li[3]";
    public static final String Taxonomy_Checkbox = "//div[contains(@class,'LicenseRow')]//input[@type='checkbox']";

    public void fillInAffiliationSectionwithMCO(String enrollmenttype,String planType){
        waitAbit(2000);
        System.out.println("Fill in Affiliation Section");
        findBy(SECTION_AFFILIATION).click();
        System.out.println("Clicked on Affiliation Section");

        findBy(ADD_AFFILIATION_BTN).click();
        System.out.println("Clicked on ADD AFFILIATION button");
        waitAbit(2000);

        waitAbit(2000);
        findBy(TYPE_AFFILIATION).click();
        waitAbit(2000);
        findBy(MCO_Option).click();
//        selectFromDropDown("MCO");
//        setSpecificOptionInListbox("MCO");
//        driver.findElement(By.xpath("//ul[@aria-label='Select an option']//li[3]"));
//        driver.findElement(By.xpath("//li[contains(@class,'MuiMenuItem-root') and normalize-space(text())='"+ enrollmenttype +"']"));
        System.out.println("Clicked Affiliation Type is :"+enrollmenttype);


        waitAbit(2000);
        findBy(PLAN_TYPE).click();
        waitAbit(2000);
//        driver.findElement(By.xpath("//li[contains(@class, 'MuiMenuItem-root') and normalize-space(text())='" + planType + "']"));
        selectFromDropDown(planType);
        System.out.println("Clicked Plan Type: "+planType);

        waitAbit(2000);
        findBy(AFFILIATION_SEARCH_BTN).click();

        waitAbit(2000);
        findBy(ADD_TAXONOMY_BUTTON).click();

        waitAbit(2000);
        findBy(SELECT_REGION).click();
        waitAbit(2000);
        selectFromDropDown("Region B");

        waitAbit(2000);
        findBy(TAXONOMY_RADIO_BTN).click();
        waitAbit(5000);

        findBy(AFFILIATION_LOCATION_EFFECTIVE_START).click();
        waitAbit(2000);
        findBy(AFFILIATION_LOCATION_EFFECTIVE_START).type(getCurrentDate());
//        fillInCalendar(getCurrentDate(),AFFILIATION_LOCATION_EFFECTIVE_START);
        waitAbit(2000);

        findBy(NEXT_AFFILIATION_POPUP).click();
        waitAbit(2000);

        findBy(Taxonomy_Checkbox).click();
        waitAbit(2000);
        findBy(AFFILIATION_TAXONOMY_EFFECTIVE_START).click();
        waitAbit(2000);
        findBy(AFFILIATION_TAXONOMY_EFFECTIVE_START).type(getCurrentDate());
        waitAbit(2000);

//        for (WebElement checkbox : licenseCheckboxes) {
//            if (!checkbox.isSelected()) {
//                checkbox.click();
//            }
//            findBy(AFFILIATION_LOCATION_EFFECTIVE_START).type(getCurrentDate());
//            fillInCalendar(getCurrentDate(), AFFILIATION_LOCATION_EFFECTIVE_START);
//            waitAbit(2000);
//        }

        findBy(ADD_AFFILIATION).click();
        waitAbit(2000);


    }

    public void fillInAffiliationSectionforMCO(String enrollmenttype){
        waitAbit(2000);
        System.out.println("Fill in Affiliation Section");
        findBy(SECTION_AFFILIATION).click();
        System.out.println("Clicked on Affiliation Section");

        waitAbit(2000);
        findBy(ADD_AFFILIATION_BTN).click();
        System.out.println("Clicked on ADD AFFILIATION button");
        waitAbit(2000);

        waitAbit(2000);
        findBy(TYPE_AFFILIATION).click();
        selectFromDropDown(enrollmenttype);
//        driver.findElement(By.xpath("//li[contains(@class,'MuiMenuItem-root') and normalize-space(text())='"+ enrollmenttype +"']"));
        System.out.println("Clicked Affiliation Type is :"+enrollmenttype);


//        waitAbit(2000);
//        findBy(PLAN_TYPE).click();
//        waitAbit(2000);
//        driver.findElement(By.xpath("//li[contains(@class, 'MuiMenuItem-root') and normalize-space(text())='" + planType + "']"));

        waitAbit(2000);
        findBy(AFFILIATION_SEARCH_BTN).click();

        waitAbit(2000);
        findBy(ADD_TAXONOMY_BUTTON).click();

        waitAbit(2000);
        findBy(SELECT_REGION).click();
        waitAbit(2000);
        selectFromDropDown("Region A");

        waitAbit(2000);
        findBy(TAXONOMY_RADIO_BTN).click();
        waitAbit(2000);

        findBy(AFFILIATION_LOCATION_EFFECTIVE_START).click();
        waitAbit(2000);
        findBy(AFFILIATION_LOCATION_EFFECTIVE_START).type(getCurrentDate());
//        fillInCalendar(getCurrentDate(),AFFILIATION_LOCATION_EFFECTIVE_START);
        waitAbit(2000);

        findBy(NEXT_AFFILIATION_POPUP).click();
        waitAbit(2000);

        findBy(Taxonomy_Checkbox).click();
        waitAbit(2000);
        findBy(AFFILIATION_TAXONOMY_EFFECTIVE_START).click();
        waitAbit(2000);
        findBy(AFFILIATION_TAXONOMY_EFFECTIVE_START).type(getCurrentDate());
        waitAbit(2000);

//        for (WebElement checkbox : licenseCheckboxes) {
//            if (!checkbox.isSelected()) {
//                checkbox.click();
//            }
//            findBy(AFFILIATION_LOCATION_EFFECTIVE_START).type(getCurrentDate());
//            fillInCalendar(getCurrentDate(), AFFILIATION_LOCATION_EFFECTIVE_START);
//            waitAbit(2000);
//        }

        findBy(ADD_AFFILIATION).click();
        waitAbit(2000);


    }

}
