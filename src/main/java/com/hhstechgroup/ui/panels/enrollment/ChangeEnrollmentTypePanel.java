package com.hhstechgroup.ui.panels.enrollment;
import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChangeEnrollmentTypePanel extends BaseEnrollmentPanel {
    //sp37
    private static final String CHANGEENROLLMENT_TYPE = ".//label/span/span//input[contains(@type,'radio')]";
    private static final String REASON_FEILD = ".//input[contains(@id, 'Select reason-')]/preceding-sibling::div";
    private static final String  REASON = ".//ul[@role='listbox']/li[text()='%s']" ;
    private static final String  NOTE = ".//label[contains(text(), 'Note')]/../div" ;
    private static final String  APPLY_BUTTON = ".//button[span[text() = 'Apply']]" ;

    public ChangeEnrollmentTypePanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }
    public void setChangeenrollmenttype(String changeenrollmenttype){
       waitABit(500);
       findBy(CHANGEENROLLMENT_TYPE).click();
       waitABit(100);
    }
    public void setReason(String reason) {
        waitABit(100);
        jsClick(REASON_FEILD);
        waitABit(100);
        selectFromDropDown("RS01");
    }
    public void setNote(String note) {
        findBy(NOTE).click();
        findBy(NOTE).type(note);
        waitABit(500);
        findBy(APPLY_BUTTON).click();
        waitABit(100);
    }
}