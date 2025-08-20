package com.hhstechgroup.ui.pages.sitevisit;

import com.hhstechgroup.ui.pages.ProviderManagementBasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class SystemOptionsDypPage extends ProviderManagementBasePage {

    private static final String  USERS = "//div/h1[text()='Users']";
    private static final String SCREENING = "//div/h1[text()='Screening']";
    private static final String AUTO_ASSIGN = "//div/h1[text()='Auto Assign']";
    private static final String  DATA_CHANGE = "//div/h1[text()='Data Change']";
    private static final String  APPROVALS= "//div/h1[text()='Approvals']";
    private static final String ROLES = "//div/h1[text()='Roles']";
    private static final String REVALIDATION = "//div/h1[text()='Revalidation']";
    private static final String SITE_VISIT = "//div//h1[text()='Site Visit']";

    public SystemOptionsDypPage(WebDriver driver) {  super(driver); }

    private static final String   SYSTEM_OPTIONS_TILE = ".//div/h1[text()='%s']";
    private static final String   EXIT_LINKS = ".//div/h4[text()='%s']";
    private static final String   SYSTEM_OPTIONS_NAMES = ".//div[contains(@class,'system')]/div/h1";

    public List<String> getSystemOptionsNames() { waitAbit(1000);
        return findAll(SYSTEM_OPTIONS_NAMES).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }
    public void clickOnLinksInSystemOptionsPage(String link) { waitAbit(1000);
        scrollToElement(format(SYSTEM_OPTIONS_TILE,link));
        findBy(format(SYSTEM_OPTIONS_TILE,link)).click();
    }

     public void clickOnExitLinks(String link){ waitAbit(1000);
        scrollToElement(format(EXIT_LINKS,link));
         jsClick(format(EXIT_LINKS,link));
         //findBy(format(EXIT_LINKS,link)).click();
     }

     public boolean ValidatingUserLinkDisplaying() { return findBy(USERS).isDisplayed();}
    public boolean ValidatingScreeningLinkDisplaying() { return findBy(SCREENING).isDisplayed();}
    public boolean ValidatingAutoAssignLinkDisplaying() { return findBy(AUTO_ASSIGN).isDisplayed();}
    public boolean ValidatingDataChangeLinkDisplaying() { return findBy(DATA_CHANGE).isDisplayed();}
    public boolean ValidatingApprovalsLinkDisplaying() { return findBy(APPROVALS).isDisplayed();}
    public boolean ValidatingRolesLinkDisplaying() { return findBy(ROLES).isDisplayed();}
    public boolean ValidatingRevalidationLinkDisplaying() { return findBy(REVALIDATION).isDisplayed();}
    public boolean ValidatingSiteVisitLinkDisplaying() { return findBy(SITE_VISIT).isDisplayed();}

    public void clickOnUserLink(){jsClick(USERS);}
    public void clickOnScreeningLink(){jsClick(SCREENING);}
    public void clickOnAutoAssignLink(){jsClick(AUTO_ASSIGN);}
    public void clickOnDataChangeLink(){jsClick(DATA_CHANGE);}
    public void clickOnApprovalsLink(){jsClick(APPROVALS);}
    public void clickOnRolesLink(){jsClick(ROLES);}
    public void clickOnRevalidationLink(){jsClick(REVALIDATION);}
    public void clickOnSiteVisitLink(){jsClick(SITE_VISIT);}

    private static final String  CLICK_EXIT_USER_MANAGEMENT = "//div/h4[text()='←Exit User Management']";
    private static final String  CLICK_EXIT_SCREENING = "//div/h4[text()='←Exit Screening']";
    private static final String   CLICK_EXIT_AUTO_ASSIGN = "//div/h4[text()='←Exit Auto Assign']";
    private static final String   CLICK_EXIT_DATA_CHANGE = "//div/h4[text()='←Exit Data Change Management']";
    // private static final String   CLICK_EXIT_APPROVALS = "//div/h4[text()='←Exit Approvals']";
    //sp22
    private static final String   CLICK_EXIT_APPROVALS = "//div/span[text()='Back to Approvals list']";
    private static final String   CLICK_EXIT_ROLES = "//div/h4[text()='←Exit Role Management']";
    private static final String   CLICK_EXIT_REVALIDATION = "//div/h4[text()='←Exit Revalidation']";


    public  void clickOnExitUser() {jsClick(CLICK_EXIT_USER_MANAGEMENT);}
    public  void clickOnExitScreeing() {jsClick(CLICK_EXIT_SCREENING);}
    public  void clickOnExitAutoAssign() {jsClick(CLICK_EXIT_AUTO_ASSIGN);}
    public  void clickOnExitDataChange() {jsClick(CLICK_EXIT_DATA_CHANGE);}
    public  void clickOnExitApprovals() {
        waitAbit(200);
        scrollToElement(CLICK_EXIT_APPROVALS);
        waitAbit(200);
        jsClick(CLICK_EXIT_APPROVALS);
        waitAbit(200);
    }

    public  void clickOnExitRoles() {jsClick(CLICK_EXIT_ROLES);}
    public  void clickOnExitRevalidation() {jsClick(CLICK_EXIT_REVALIDATION);}
    //sp39.2
    private static final String  CLICK_EXIT_USER_LIST = ".//div/span[text()='Back to Users List']";
    public  void clickOnExitUserList() {
        waitAbit(200);
        jsClick(CLICK_EXIT_USER_LIST);
    }

    private static final String  EXIT_LINT = "//div/h4[text()='%s']";
    public boolean exitLinkIsDisplaying(String text){
        scrollToElement(format(EXIT_LINT,text));
        waitAbit(500);
        return findBy(format(EXIT_LINT,text)).isDisplayed();
    }

    private static final String TEXT="//div[text()='%s']";

    public boolean checkText(String text){
        scrollToElement(format(TEXT,text));
        waitAbit(100);
        return findBy(format(TEXT,text)).isDisplayed();

    }
    private static final String EDIT_BUTTON="//span[text()='%s']";

    public boolean checkEditButton(String editButton){
        scrollToElement(format(EDIT_BUTTON,editButton));
        waitAbit(200);
        return findBy(format(EDIT_BUTTON,editButton)).isDisplayed();

    }

}
