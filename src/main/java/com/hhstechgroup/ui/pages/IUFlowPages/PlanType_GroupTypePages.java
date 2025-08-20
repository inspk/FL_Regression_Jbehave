package com.hhstechgroup.ui.pages.IUFlowPages;

import com.hhstechgroup.ui.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class PlanType_GroupTypePages extends AbstractPage {
    public PlanType_GroupTypePages(WebDriver driver){
        super(driver);
    }

    private static final String Group_Type = ".//label[contains(text(), 'Group Type')]/following-sibling::div//input";
    private static final String Group_Type_List = ".//div/strong[text()='%s']";

    private static final String Plan_Type = ".//label[contains(text(), 'Plan Type Options')]/following-sibling::div//input";
    private static final String Plan_Type_List = ".//div/strong[text()='%s']";

    public void setPlanTypefield(String plantype) {
        waitABit(500);
        findBy(Plan_Type).click();
//        findBy(format(Plan_Type_List, plantype)).click();
        waitABit(500);
        findBy(Plan_Type).sendKeys(plantype);
    }

    public void setGroupTypefield(String grouptype){
        waitABit(500);
        findBy(Group_Type).click();
        waitAbit(2000);
        findBy(Group_Type).sendKeys(grouptype);
        waitAbit(200);
//        clickAnyOptionInList(1);
//        findBy(format(Group_Type_List, grouptype)).click();

    }

}
