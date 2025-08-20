package com.hhstechgroup.ui.pages.IUFlowPages;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.enrollment.BaseEnrollmentPanel;
import org.openqa.selenium.WebDriver;

public class IUMCOPage extends AbstractPage {

    private static final String ADD_MCO_BUTTON = "//button//span[contains(text(),'MCO')]";

    public IUMCOPage(WebDriver driver) {
        super(driver);
    }

    BaseEnrollmentPanel baseEnrollmentPanel;


    public void clickAddMCOButton() {
        waitForPresenceOf(ADD_MCO_BUTTON);
        findBy(ADD_MCO_BUTTON).click();
    }

//    private static final String OWNERS_LESS_THAN_FIVEPERCENT="Are there any owners with less than 5% (All owners not equal to 100%)?";
private static final String OWNERS_LESS_THAN_FIVEPERCENT=".//span[contains(@data-for,'Are there any owners with less than 5% (All owners not equal to 100%)?')]//input[@value='Yes']";
    public void setAnyOwnersLessThanFivePercent(){
        waitABit(500);
//        baseEnrollmentPanel.selectRadionButton(OWNERS_LESS_THAN_FIVEPERCENT,lessThanFivePercent);
        findBy(OWNERS_LESS_THAN_FIVEPERCENT).click();
        waitABit(500);
    }

    private static final String Go_TO_MCO = "//span[contains(text(),'Go to MCO')]";
    public void click_GO_TO_MCO(){
        waitAbit(500);
        findBy(Go_TO_MCO).click();
        waitAbit(500);
    }


} 