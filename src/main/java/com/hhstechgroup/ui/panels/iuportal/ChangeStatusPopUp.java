package com.hhstechgroup.ui.panels.iuportal;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.BaseModalPanel;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.String.format;

public class ChangeStatusPopUp extends BaseModalPanel {

    private static final String STATUS = ".//input[contains(@id, 'Status')]/preceding-sibling::div";
    private static final String APPLY_BUTTON = ".//button[span[text() = 'Apply']]";
    private static final String REASON = ".//input[contains(@id, 'Reason')]/preceding-sibling::div";
    private static final String EFFECTIVE_DATE=".//label[text() = 'Effective Date *']/following-sibling::div/input/following-sibling::div/button";
    private static final String CALENDAR = "//div[@role='document']";


    public ChangeStatusPopUp(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setStatus(String status) {
        findBy(STATUS).click();
        selectFromDropDown(status);
    }

    public void setRequestAdditionalInformationStatus(String status){
        waitABit(200);
        findBy(STATUS).click();
        waitABit(500);
       selectFromDropDown("Requested Additional Information");
//        selectFromDropDown(status);

    }

    public void setReason(String reason) {
        waitForPopUpAttributeAppear();
        findBy(REASON).click();
        waitABit(500);
        selectFromDropDown(reason);
    }

    //new
    public void setReason1(String reason) {
   //     waitForPopUpAttributeAppear();
        waitABit(100);
   //     jsClick(REASON);
        findBy(REASON).click();
        waitABit(100);
        selectFromDropDown(reason);
        waitABit(100);
    }
    //sp60 adding new filed original status in appeal
    //sp62 changing the xpath for original status in appeal
    private static final String ORIGINAL_STATUS =  ".//input[contains(@id, 'original')]/preceding-sibling::div" ;

    public void setOriginalStatus(String originalStatus) {
//        waitForPopUpAttributeAppear();
        waitABit(100);
//        jsClick(ORIGINAL_STATUS);
        findBy(ORIGINAL_STATUS).click();
        waitABit(100);
        selectFromDropDown(originalStatus);
        waitABit(100);
    }


    //SP18 new approval form
    public void fillInNewApprovalForm(){
        try{
            LocalDateTime ldt =  LocalDateTime.now();
            String formattedDate = ldt.format(DateTimeFormatter.ofPattern("yyyy`-MM-dd"));
            findBy(EFFECTIVE_DATE).sendKeys(formattedDate);
            setReason1("Positive Result");
        }catch (Exception e){

        }
    }



    private static final String EFFECTIVE_DATE1=".//label[contains(text(),'Effective Date *')]/..//div/input[@placeholder='MM/DD/YYYY']";
    public void setEffectiveDate(String effectiveDate) {
        // jsClick(EFFECTIVE_DATE1);
        findBy(EFFECTIVE_DATE1).click();
        waitABit(1000);
        findBy(format(EFFECTIVE_DATE1, effectiveDate)).type(effectiveDate);
        waitABit(500);

    }
    public void clickApply() {
  //      waitForPopUpAttributeAppear();
        findBy(APPLY_BUTTON).click();
//        waitForPopUpClosed();
    }
    //sp32
    public void setDocumentReviewStatus(String status) {
        findBy(STATUS).click();
        selectFromDropDown("Document Review Approved");
    }

    //sp37
    private static final String YESBUTTON = ".//span[text()='Yes']/..//input[contains(@type,'radio')]" ;
    public void  clickYesInRetroApprovalButton(){
        waitABit(100);
        findBy(YESBUTTON).click();
        waitABit(100);
    }

    //sp57
    public void setDocumentReviewStatus1(String status) {
        findBy(STATUS).click();
        selectFromDropDown("Under Screening");
    }

    // SD-04

    public void setDocumentReviewStatus2(String status) {
        findBy(STATUS).click();
        selectFromDropDown("Document Review");
    }

    private static final String NOTES_PROVIDER = ".//label[contains(text(), '%s')]/../div" ;

    public boolean isNotesToProviderIsDisplaying(String text){
        scrollToElement(format(NOTES_PROVIDER,text));
        waitABit(500);
        return findBy(format(NOTES_PROVIDER,text)).isDisplayed();
    }

    private static final String FUTURE_APPROVE_POPUP = "(//button/span[text()='%s'])[last()]";
    public void futureApprovePopup(String option){
        waitABit(500);
        findBy(format(FUTURE_APPROVE_POPUP,option)).click();
        waitABit(500);
    }

    private static final String TP_AGENTID = "//div[label[text()='Trading Partner Agent ID']]/..//textarea[1]";
    public void setTpAgentid(String tpAgentid){
        waitABit(500);
        findBy(TP_AGENTID).type(tpAgentid);
    }

    public void setTerminationApprove(String status){
        waitABit(500);
        findBy(STATUS).click();
        selectFromDropDown("Approved");
    }

    public void setClearingHouseCheck(String status){
        findBy(STATUS).click();
        selectFromDropDown("Clearing House Check Completed");
    }

    public void setRateSettingStatus(String status) {
        findBy(STATUS).click();
        selectFromDropDown("Under Screening");
    }

}
