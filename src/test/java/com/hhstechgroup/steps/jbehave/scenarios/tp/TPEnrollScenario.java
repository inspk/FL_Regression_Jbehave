package com.hhstechgroup.steps.jbehave.scenarios.tp;

import com.hhstechgroup.beans.application.EnrollmentIUBean;
import com.hhstechgroup.beans.application.SoftwareVendorDetailsBean;
import com.hhstechgroup.steps.serenity.tp.TPEnrollSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class TPEnrollScenario {
    @Steps
    TPEnrollSteps tpEnrollSteps;

    @When("classification section to fill the application contact email from the tp '$email'")
    public void  setAppContactEmail(String email){
        tpEnrollSteps.setAppContactEmail(email); }

    @When("Click on Next button in classification section")
    public  void clickOnNextButton(){tpEnrollSteps.clickOnNextButton();}
    //letest
    @When("To fill the data for software vendor details section: $table")
    public void getSoftwareVendorPanel(ExamplesTable table) {
        SoftwareVendorDetailsBean parameters = ExamplesTableUtil.parseTableToClass(table, SoftwareVendorDetailsBean.class).get(0);
        tpEnrollSteps.getSoftwareVendorPanel(parameters);}
}
