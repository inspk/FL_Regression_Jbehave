package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.PayersSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

public class PayersScenario {

    @Steps
    PayersSteps payersSteps;

    @When("click on add payer button")
    public void clickAddPayer() {
        payersSteps.clickAddPayer();
    }

    @When("select payer '$payer' from add payer popup")
    public void selectPayer(String payer) {
        payersSteps.selectPayer(payer);
    }

    @When("click add button on add payer popup")
    public void clickAddButton() {
        payersSteps.addPayer();
    }

    @When("expand Payer '$payer' details")
    public void openPayerDetails(String payer) {
        payersSteps.clickExpandPayer(payer);
    }
    @When("click on Sign button for new Payer")
    public void clickSignForPayer() {
        payersSteps.clickSign();
    }
    @When("click navigate to payers")
    public void clickNavigateToPayers() {
        payersSteps.clickNavigateToPayers();
    }
}
