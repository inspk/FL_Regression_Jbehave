package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.beans.application.EmploymentAuthorizationInformationBean;
import com.hhstechgroup.beans.application.OtherCredentialingInformationBean;
import com.hhstechgroup.steps.serenity.EmploymentAuthorizationInformationSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class EmploymentAuthorizationInformationScenario {
    @Steps
    EmploymentAuthorizationInformationSteps employmentAuthorizationInformationSteps;

    @When("To fill the Employment Authorization Information for Enrollment: $table")
    public void setEmploymentAuthorizationInformation(ExamplesTable user){
        employmentAuthorizationInformationSteps.setEmploymentAuthorizationInformation(ExamplesTableUtil.parseTableToClass(user, EmploymentAuthorizationInformationBean.class).get(0));
    }
}
