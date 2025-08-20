package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;
import java.time.LocalDate;

public class RequestRetroactiveAdjustmentPanel  extends BaseEnrollmentPanel{
    //private static final String REASON_CODE = "Reason Code";
    //sp20
    private static final String REASON_CODE = ".//label[text() = 'Reason Code']/following-sibling::div/input";
    private static final String JUSTIFICATION_REQUEST = "Justification for Retroactive Request";
    private static final String EFFECTIVE_DATE= ".//label[contains(text(),'Effective Date *')]/..//div/input[@placeholder='MM/DD/YYYY']";
    private static final String EFFECTIVE_DATE1=".//label[text() = 'Effective Date *']/following-sibling::div/input/following-sibling::div/button";
    private static final String CALENDAR = "//div[@role='document']";
    private static final String REQUEST_RETROACTIVE_ADJUSTMENT = "Do you want to be approved retroactively?";

    public RequestRetroactiveAdjustmentPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setRequestRetroactiveAdjustment(String requestRetroactiveAdjustment) {
        selectRadionButton(REQUEST_RETROACTIVE_ADJUSTMENT, requestRetroactiveAdjustment);
        waitABit(500);
    }
    public void setReasonCode(String reasonCode){
        findBy(REASON_CODE).click();
       // select(REASON_CODE,reasonCode);
        //sp20
        selectFromDropDown(reasonCode);
        waitABit(500);
    }
    public void setJustificationRequest(String justificationRequest){
        fillField(JUSTIFICATION_REQUEST,justificationRequest);
    }

    public void setEffectiveDate(String effectiveDate) {
        LocalDate date = DateConverter.toLocalDate(effectiveDate);
        findBy(EFFECTIVE_DATE1).click();
        waitForCalendarPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setYear(date.getYear());
        waitABit(500);
        calendar.setMonth(date.getMonthValue());
        waitABit(500);
        calendar.setDayOfMonth(date.getDayOfMonth());
        waitABit(500);
    }
    //sp26
    private static final String OTHER_MEDIACID_STATE = "Are you or have you been previously enrolled as a Medicaid or CHIP provider in another state?";
    public void setOtherMediacidState(String otherMediacidState){
        waitABit(500);
        selectRadionButton(OTHER_MEDIACID_STATE,otherMediacidState);
        waitABit(500);
    }
}
