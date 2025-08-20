package com.hhstechgroup.steps.jbehave.scenarios.systemoptions;
import com.hhstechgroup.beans.application.ContactInformationBean;
import com.hhstechgroup.beans.application.PaymentConfigarationBean;
import com.hhstechgroup.steps.serenity.systemoption.UserProfileSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class UserProfileScenario {

    @Steps
    UserProfileSteps userProfileSteps;

    @Then("click on the '$value' contact info in update profile page")
    public void clickOnContactInfo(String contactinfo){userProfileSteps.clickOnContactInfo(contactinfo);}

    @Then("click on edit button in user profile configuration page")
    public void clickoneditbutton() { userProfileSteps.clickoneditbutton();}

    @Then("{Enable|Disable} the switch in user profile configuration page")
    public void clickOnEnableUserUpdateProfile(){userProfileSteps.clickOnEnableUserUpdateProfile();}

    @Then("set the '$value' days in the user profile configuaration page")
    public void setUserProfileUpdateDays(String days){userProfileSteps.setUserProfileUpdateDays(days);}

    @Then("click on the save button in user profile configuration page")
    public void clickOnSaveButton() {userProfileSteps.clickOnSaveButton();}

    @When("user fill the contact info: $table")
    public void setUserUpdateProfile(ExamplesTable contactinfo) {
        userProfileSteps.setUserUpdateProfile(ExamplesTableUtil.parseTableToClass(contactinfo, ContactInformationBean.class).get(0));
    }

    @Then("click on update button in user update profile page")
    public void clickOnUpdateButton() {userProfileSteps.clickOnUpdateButton();}

    @Then("click on Ok button in user update profile page")
    public void clickOKButton() {userProfileSteps.clickOKButton();}

}
