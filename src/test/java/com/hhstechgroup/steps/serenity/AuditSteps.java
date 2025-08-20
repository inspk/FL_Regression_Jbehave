package com.hhstechgroup.steps.serenity;


import com.hhstechgroup.beans.AuditEventsSearchBean;
import com.hhstechgroup.ui.pages.iuportal.AuditPage;
import com.hhstechgroup.ui.panels.iuportal.AuditSearchPanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;
import java.util.Map;


public class AuditSteps extends ScenarioSteps {

    AuditPage auditPage;

    @Step
    public boolean isAllContainsTag(String tag) {
        return auditPage.getAuditResultsPanel().getAllResults().stream().allMatch(mp -> mp.get("Tags").contains(tag));
    }

    @Step
    public void setSearchCriteria(AuditEventsSearchBean criteria) {
        AuditSearchPanel panel = auditPage.getSearchPanel();
        waitABit(2000);
        BeanUtils.copyPropertiesInOrder(panel, criteria);
    }

    @Step
    public void clickSearch() {
        auditPage.getSearchPanel().clickSearch();
    }

    @Step
    public List<Map<String, String>> getResults() {
        return auditPage.getAuditResultsPanel().getResults();
    }

    @Step
    public void expandRow(String rowText) {
        auditPage.getAuditResultsPanel().expandRowWithText(rowText);
    }

    @Step
    public Map<String, String> getExpandedRowInfo() {
        return auditPage.getAuditResultsPanel().getExpandedRowInfo();
    }

    @Step
    public void clickAndSelectParameter(String parameteroption) {
        auditPage.clickAndSelectParameter(parameteroption);
}
    @Step
    public void setUserId(String userId){
        auditPage.setUserId(userId);
    }

    @Step
    public void clickAndExpand(String userId) {
        auditPage.clickAndExpand(userId);
    }


    @Step
    public void setUserName(String userName){
        auditPage.setUserName(userName);
    }

    @Step
    public void clickAndExpand1(String userName) {
        auditPage.clickAndExpand1(userName);
    }

}


