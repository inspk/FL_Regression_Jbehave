package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.BuilderSteps;
import com.hhstechgroup.ui.panels.peportal.Table;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import static org.junit.Assert.assertEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class BuilderScenario {

    @Steps
    BuilderSteps builderSteps;

    @Given("user navigated to Builder")
    public void openBuilder() {
        builderSteps.openBuilder();
    }

    @When("set application name - '$name'")
    public void setAppName(String name) {
        builderSteps.setApplicationName(name);
    }

    @When("change element name from '$oldName' to '$newName'")
    public void changeName(String oldName, String newName) {
        builderSteps.changeName(oldName, newName);
    }

    @When("change table column name from '$oldName' to '$newName'")
    public void changeTableColumnName(String oldName, String newName) {
        builderSteps.setTableColumnName(oldName, newName);
    }

    @When("hide table column - '$column'")
    public void hideTableColumn(String column) {
        builderSteps.hideTableColumn(column);
    }

    @When("select column '$column' type - '$type'")
    public void selectTableColumnType(String column, String type) {
        builderSteps.selectTableColumnType(column, type);
    }

    @When("open settings for element with name - '$name'")
    public void changeName(String name) {
        builderSteps.openSettingsFor(name);
    }

    @When("select field type - '$type'")
    public void selectFieldType(String type) {
        builderSteps.selectFieldType(type);
    }

    @When("specify next options for choice field type: $table")
    public void setOptions(ExamplesTable table) {
        builderSteps.setOptions(ExamplesTableUtil.parseTableColumnAsList(table, 0));
    }

    @When("specify next options for table column '$name': $table")
    public void setOptions(String name, ExamplesTable table) {
        builderSteps.setColumnOptions(name, ExamplesTableUtil.parseTableColumnAsList(table, 0));
    }

    @When("remove current options for choice field type")
    public void removeOptions() {
        builderSteps.removeOptions();
    }

    @When("select presentation - '$presentation'")
    public void setPresentation(String presentation) {
        builderSteps.setPresentation(presentation);
    }

    @When("select count of columns - '$columns'")
    public void selectCountOfColumns(String columns) {
        builderSteps.selectCountOfColumns(columns);
    }

    @When("add new field element")
    public void addNewField() {
        builderSteps.addNewField();
    }

    @When("add new group element")
    public void addNewGroup() {
        builderSteps.addNewGroup();
    }

    @When("add new field to group $group element")
    public void addFieldToGroup(String group) {
        builderSteps.addFieldToGroup(group);
    }

    @When("copy current element")
    public void copyCurrentElement() {
        builderSteps.copyCurrentElement();
    }

    @When("navigate to tab - '$tab' on element settings")
    public void navigateToTab(String tabName) {
        builderSteps.clickOnTab(tabName);
    }

    @When("set text field default value - '$defaultValue'")
    public void setTextDefaultValue(String defaultValue) {
        builderSteps.setTextDefaultValue(defaultValue);
    }

    @When("select destination field -  '$fieldValue'")
    public void selectMappingDestinationField(String fieldValue) {
        builderSteps.selectMappingDestinationField(fieldValue);
    }

    @Then("application name - '$name' should be displayed")
    public void checkAppName(String name) {
        assertEquals(name, builderSteps.getApplicationName());
    }

    @Then("count of columns should have next options: $table")
    public void checkCountOfColumnsOptions(ExamplesTable table) {
        assertReflectionEquals(ExamplesTableUtil.parseTableColumnAsList(table, 0), builderSteps.getCountOfColumnsOptions());
    }

    @Then("next message - '$message' should be displayed on Data mapping tab")
    public void checkDataMappingTabMessage(String expectedMessage) {
        assertEquals(expectedMessage, builderSteps.getDataMappingMessage());
    }

    @Then("next fields should be avilable in data mapping: $table")
    public void checkMappingFields(ExamplesTable table) {
        assertReflectionEquals(ExamplesTableUtil.parseTableColumnAsList(table, 0), builderSteps.getMappingOptions());
    }

    @Then("next fields should be selected as destination fields: $table")
    public void checkMappingDestinationFields(ExamplesTable table) {
        assertReflectionEquals(ExamplesTableUtil.parseTableColumnAsList(table, 0), builderSteps.getDestinationFields());
    }
}
