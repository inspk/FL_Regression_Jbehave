package com.hhstechgroup.steps.jbehave.scenarios.autoassignscenario;



import com.hhstechgroup.steps.serenity.autoassignsteps.AutoAssignSteps;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.core.Is;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import static org.junit.Assert.*;

import java.util.Map;

public class AutoAssignScenario {

    @Steps
    AutoAssignSteps autoAssignSteps;

    @When("click on create rule button")
    public void clickOnCreateRuleButton(){autoAssignSteps.clickOnCreateRuleButton();}

    @When("create an rule with an name '$ruleName'")
    public void fillRuleName(String ruleName) {autoAssignSteps.fillRuleName(ruleName);}

    @When("click on add condition link to select the parameters")
    public void clickOnAddConditionLink(){autoAssignSteps.clickOnAddConditionLink();}

    @When("click on dropdown in the rule")
    public void clickOnDropdown(){autoAssignSteps.clickOnDropdown();}

    @When("select the parameter '$dropdown' and '$parameter' in the rule")
    public void setParameter(String dropdown,String parameter) {autoAssignSteps.setParameter(dropdown,parameter);}

    @When("select the second parameter '$dropdown2' and '$parameter2' in the rule")
    public void setsecondParameter(String dropdown2,String parameter2) {autoAssignSteps.setsecondParameter(dropdown2,parameter2);}

    //sp22
    @When("select the document review parameter '$dropdown2' and '$parameter2' in the rule")
    public void setDocumentReviewParameter(String dropdown3,String parameter3) {
        autoAssignSteps.setDocumentReviewParameter(dropdown3,parameter3);}

        @When("select the if '$condition' condition in the rule")
    public void selectCondtions(String condition) {autoAssignSteps.selectCondtions(condition);}

    @When("cilck on '$saveorCancel' button in the rule")
    public void clickOnSaveOrCancelButton(String saveOrCancel) {autoAssignSteps.clickOnSaveOrCancelButton(saveOrCancel);}

    @When("search by rule '$rulename' from the rule list")
    public void seachByRuleName(String ruleName){autoAssignSteps.seachByRuleName(ruleName);}

    @When("Select '$action' from the rule list")
    public void selectRemoveOption(String action){autoAssignSteps.selectRemoveOption(action);}

    @When("click on ok button to remove the record from the rule list")
    public void removeRuleFromRuleList(){autoAssignSteps.removeRuleFromRuleList();}

    @When("fill the effective from'$date' and effective end '$date' to create the rule")
    public void fillEffecteDates(String dateFrom,String dateEnd){ autoAssignSteps.fillEffecteDates(dateFrom,dateEnd);}

    @When("fill the value equal to '$parameter','$name' and '$value'")
    public void fillValue(String parameter,String name,String value){autoAssignSteps.fillValue(parameter,name,value);}

    @When("fill the provider Name as '$providerName'")
    public void typeProviderName(String providerName){autoAssignSteps.typeProviderName(providerName);}

    @When("fill the address Name as '$providerName'")
    public void typeProviderName1(String providerName){autoAssignSteps.typeProviderName(providerName);}

    @When("Select '$condition' condition in the rule")
    public void setConditon(String condition) {autoAssignSteps.setConditon(condition);}


    //sp23
    @Then("verifying the Auto Assignee rules: $table")
    public void getMappedDateValues(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(autoAssignSteps.getMappedDateValues(), Is.is(expectedInfo));
    }
    //sp24
    @Then("click on the rule in the Auto Assign Rule list page")
    public void clickRuleFromRuleList(){
    autoAssignSteps.clickRuleFromRuleList();
    }

    @Then("click the '$button' to Auto Assign List page")
    public  void clickOnBckToList(String button) {
        autoAssignSteps.clickOnBckToList(button);
    }

    @When("verify the veiw history button is displaying in the Auto Assign list page")
    public void  verifyViewHistorytButton() {
        System.out.println("Veiw History Button is Displaying");
        assertTrue(autoAssignSteps.verifyViewHistorytButton());
    }

    @Then("click on the veiw history button in the AutoAssign rule list page")
    public void clickVeiwHistoryButton(){
        autoAssignSteps.clickVeiwHistoryButton();
    }

    @Then("verifying the effective dates in the veiwing history page: $table")
    public void getMappedEffectiveDateValues(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(autoAssignSteps.getMappedEffectiveDateValues(), Is.is(expectedInfo));
    }

    @Then("verifying the updated dates in the veiwing history page: $table")
    public void getMappedUpdatedDateValues(ExamplesTable table) {
        Map<String, String> expectedInfo = table.getRow(0);
        assertThat(autoAssignSteps.getMappedUpdatedDateValues(), Is.is(expectedInfo));
    }

    @Then("click on the effective dates in the veiwing history page")
    public void clickEffectiveDates(){
        autoAssignSteps.clickEffectiveDates();
    }

    @Then("click on the '$button' back to history records page")
    public void clickBackToHistoryRecords(String button) {
    autoAssignSteps.clickBackToHistoryRecords(button);
    }

    @Then("click on the Edit Button in the AutoAssign rule list page")
    public void clickEditButton(){
        autoAssignSteps.clickEditButton();
    }

    @Then("click on the '$exit' Button in the veiwing history page")
    public void clickExitButton(String exit){
        autoAssignSteps.clickExitButton(exit);
    }

    //sp37
    @Then("select the risklevel '$value' in rule")
    public void typerisklevelvalue(String value) { autoAssignSteps.typerisklevelvalue(value); }

    @When("select the status parameter '$dropdown2' and '$parameter2' in the rule")
    public void setstatusParameter(String dropdown3,String parameter3) {
        autoAssignSteps.setstatusParameter(dropdown3,parameter3);}

    //in SP-73 Adding click for new rules section
    @When("click on '$action' in rules")
    public void clickOnRules(String action){
        autoAssignSteps.clickOnRules(action);
    }

    @When("select the action parameter '$dropdown' and '$parameter' in the rule")
    public void setActionParameter(String dropdown,String parameter) {
        autoAssignSteps.setActionParameter(dropdown, parameter);
    }

}
