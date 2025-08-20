package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

public class AuthorizedSignaturePanel extends BaseEnrollmentPanel {
    //sp26
    private static final String TITLEOFPERSON_SUBMITTING_ENROLLMENT = "Title of person submitting enrollment";

    public AuthorizedSignaturePanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setTitleOfPersonSubmittingEnrollment(String titleOfPersonSubmittingEnrollment) {
        waitABit(500);
        fillField(TITLEOFPERSON_SUBMITTING_ENROLLMENT, titleOfPersonSubmittingEnrollment);
        waitABit(500);
        findBy("//*").click();
        waitABit(1000);
    }

    //sp43.2
    private static final String SIGNATURE_OF_PERSON_SUBMITTING_ENROLLEMNT = "Name of Authorized Individual Submitting Enrollment & Signing the Provider Agreement";
    public void setSignatureOfPersonSubmittingEnrollment(String signatureOfPersonSubmittingEnrollment) {
        waitABit(500);
        fillField(SIGNATURE_OF_PERSON_SUBMITTING_ENROLLEMNT,signatureOfPersonSubmittingEnrollment);
        waitABit(500);
        findBy("//*").click();
        waitABit(1000);
    }

    private static final String TITLE = "Title";
    public void setTitle(String title) {
        waitABit(500);
        fillModifiedField(TITLE, title);
        waitABit(500);
        findBy("//html").click();
        waitABit(1000);
    }

    private static final String NAME = "Name";
    public void setName(String name) {
        waitABit(500);
        fillModifiedField(NAME,name);
        waitABit(500);
        findBy("//html").click();
        waitABit(1000);

    }

}
