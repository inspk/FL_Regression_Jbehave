package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

public class TrainingRequiredPanel  extends BaseEnrollmentPanel{

    private static final String TRAINING_REQUIRED = "Please select the Training Required?";

    public TrainingRequiredPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setTrainingRequired(String trainingRequired) {
        setCheckbox(TRAINING_REQUIRED, trainingRequired);
    }
}
