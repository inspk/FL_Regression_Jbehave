package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.systemoption.RequestAddtionalInformationSteps;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RequestAddtionalInfomationScenario {

    RequestAddtionalInformationSteps requestAddtionalInformationSteps;

    @When("verify the Request Addtional Infomation Remainders notifications info: $table")
    public  void verifyRequestAddtionalInfo(ExamplesTable table){
        Map<String, String> row = table.getRow(0);
        assertEquals(row.get("firstNotification"), requestAddtionalInformationSteps.getFirstNotification());
        assertEquals(row.get("secondNotification"), requestAddtionalInformationSteps.getSecondNotification());
        assertEquals(row.get("thirdNotification"), requestAddtionalInformationSteps.getThirdNotification());

    }
}
