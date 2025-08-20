package com.hhstechgroup.ui.panels.iuportal.approval;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.lang.String.format;

public class ApprovalPanel extends AbstractPanel {

    private static final String APPROVE_DENY_BUTTON = ".//button[span[text()='%s']]";
    private static final String VOTE_TEXT = ".//h2[text()='%s']";



    public ApprovalPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }


    public boolean isVoteTextPresent(String text) {
        return isElementPresent(format(VOTE_TEXT, text));
    }

    public void clickApproveDeny(String vote) {
        waitFor(ExpectedConditions.elementToBeClickable(By.xpath(format(APPROVE_DENY_BUTTON, vote))));
        scrollToElement(format(APPROVE_DENY_BUTTON, vote));
        waitABit(1000);
        findBy(format(APPROVE_DENY_BUTTON, vote)).click();
    }






}
