package com.hhstechgroup.steps.serenity;

import com.hhstechgroup.ui.pages.BuilderMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class BuilderSteps extends ScenarioSteps {

    BuilderMainPage builderMainPage;

    @Step
    public void openBuilder() {
        builderMainPage.open();
    }

    @Step
    public void setApplicationName(String name) {
        builderMainPage.getHeader().setApplicationName(name);
    }

    @Step
    public String getApplicationName() {
        return builderMainPage.getHeader().getApplicationName();
    }

    @Step
    public void changeName(String oldName, String newName) {
        builderMainPage.getBody().setNewElementName(oldName, newName);
    }

    @Step
    public void openSettingsFor(String name) {
        builderMainPage.getBody().openSettingsFor(name);
    }

    @Step
    public void selectFieldType(String type) {
        builderMainPage.getBody().getElementSettings().selectFieldType(type);
    }

    @Step
    public void setOptions(List<String> options) {
        builderMainPage.getBody().getElementSettings().setOptions(options);
    }

    @Step
    public void setColumnOptions(String tableColumnName, List<String> options) {
        builderMainPage.getBody().getElementSettings().setColumnOptions(tableColumnName, options);
    }

    @Step
    public void removeOptions() {
        builderMainPage.getBody().getElementSettings().removeOptions();
    }

    @Step
    public void setPresentation(String presentation) {
        builderMainPage.getBody().getElementSettings().setPresentation(presentation);
    }

    @Step
    public void selectCountOfColumns(String count) {
        builderMainPage.getBody().getElementSettings().selectColumnsCount(count);
    }

    @Step
    public List<String> getCountOfColumnsOptions() {
        return builderMainPage.getBody().getElementSettings().getAllColumnsCountOptions();
    }

    @Step
    public void addNewField() {
        builderMainPage.getBody().addNewFieldElement();
    }

    @Step
    public void addNewGroup() {
        builderMainPage.getBody().addNewGroupElement();
    }

    @Step
    public void addFieldToGroup(String group) {
        builderMainPage.getBody().addNewFieldToGroup(group);
    }

    @Step
    public void copyCurrentElement() {
        builderMainPage.getBody().getElementSettings().copyCurrentElement();
    }

    @Step
    public void setTableColumnName(String oldName, String newName) {
        builderMainPage.getBody().getElementSettings().setNewColumnName(oldName, newName);
    }

    @Step
    public void hideTableColumn(String columnName) {
        builderMainPage.getBody().getElementSettings().hideTableColumn(columnName);
    }

    @Step
    public void selectTableColumnType(String columnName, String type) {
        builderMainPage.getBody().getElementSettings().selectTableColumnType(columnName, type);
    }

    @Step
    public void clickOnTab(String tab) {
        builderMainPage.getBody().getElementSettings().clickOnTab(tab);
    }

    @Step
    public String getDataMappingMessage() {
        return builderMainPage.getBody().getElementSettings().getDataMappingMessage();
    }

    @Step
    public List<String> getMappingOptions() {
        return builderMainPage.getBody().getElementSettings().getMappingOptions();
    }

    @Step
    public void setTextDefaultValue(String defaultValue) {
        builderMainPage.getBody().getElementSettings().setDefaultValue(defaultValue);
    }

    @Step
    public void selectMappingDestinationField(String fieldName) {
        builderMainPage.getBody().getElementSettings().selectMappingDestinationField(fieldName);
    }

    @Step
    public List<String> getDestinationFields() {
        return builderMainPage.getBody().getElementSettings().getDestinationFields();
    }
}
