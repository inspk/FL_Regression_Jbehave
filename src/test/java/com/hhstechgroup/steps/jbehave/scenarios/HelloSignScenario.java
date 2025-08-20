package com.hhstechgroup.steps.jbehave.scenarios;

import com.hhstechgroup.steps.serenity.HelloSignSteps;
import com.hhstechgroup.util.common.ExternalEmails;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

public class HelloSignScenario {

    @Steps
    HelloSignSteps helloSignSteps;

    @When("sign application for user '$fullName'")
    public void signApplication(String fullName) {
        helloSignSteps.setFullName(fullName);
        helloSignSteps.clickToSign();
        helloSignSteps.createSignature();
        helloSignSteps.clickContinue();
        helloSignSteps.clickAgree();
        //helloSignSteps.waitForDocumentSigned();
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

    @When("click sign button")
    public void clickSign(){
        helloSignSteps.clickSign();
    }

    //Newly Added
    @When("sign provider application for user '$fullName'")
    public void signApplication1(String fullName) {
        helloSignSteps.clickGetStarted();
        helloSignSteps.clickToSign1();
        //newly added method
        helloSignSteps.createSignature2(fullName);
        helloSignSteps.clickContinue();
        helloSignSteps.clickAgree();
        // helloSignSteps.waitForDocumentSigned();
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

    @When("sign the affiliation provider application for user '$fullName'")
    public void clickAffiliationSign(String fullName) {
        helloSignSteps.setFullName(fullName);
        //helloSignSteps.clickAffiliationSign();
       // helloSignSteps.createSignature1();
        helloSignSteps.clickContinue();
        helloSignSteps.clickAgree();
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

    //Newly Added
    @When("sign1 provider application for user '$fullName'")
    public void signApplication2(String fullName) {
       helloSignSteps.clickYesAndGetStarted();
        //newly added method
        helloSignSteps.clickToSign1();
        helloSignSteps.createSignature2(fullName);
        helloSignSteps.clickContinue();
        helloSignSteps.clickAgree();
        // helloSignSteps.waitForDocumentSigned();
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

    @When("sign1 provider application for user titel & '$fullName'")
    public void signApplication4(String fullName) {
        helloSignSteps.clickGetStarted();
        //newly added method
        helloSignSteps.clickToSign1();
        helloSignSteps.createSignature2(fullName);
        helloSignSteps.enterSignTitel();
        helloSignSteps.clickContinue();
        helloSignSteps.clickAgree();
        // helloSignSteps.waitForDocumentSigned();
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

    //Newly Added
    @When("sign2 provider application for user '$fullName'")
    public void signApplication3(String fullName) {
        helloSignSteps.clickGetStarted();
        //newly added method
        helloSignSteps.setFullName1(fullName);
        helloSignSteps.clickToSign1();
        helloSignSteps.createSignature2(fullName);
        helloSignSteps.clickContinue();
        helloSignSteps.clickAgree();
        // helloSignSteps.waitForDocumentSigned();
        Serenity.setSessionVariable(ExternalEmails.STATUS_CHANGE.getValue()).to(DateConverter.convert(LocalDateTime.now(), "h:mm a"));
    }

    @When("verify the presence of below '${text}' agreement parameters: $table")
    public void verifyAgreement(ExamplesTable table) {
        Map<String, String> headers = table.getRow(0);
        Optional.ofNullable(headers.get("npi")).ifPresent(npi -> {
            System.out.println("NPI: " + helloSignSteps.getAgreementNPI());
            assertTrue(helloSignSteps.getAgreementNPI().contains(npi));
        });
        Optional.ofNullable(headers.get("providerName")).ifPresent(providerName -> {
            System.out.println("Provider name: "+helloSignSteps.getAgreementProvidername());
            assertTrue(helloSignSteps.getAgreementProvidername().contains(providerName));
        });
    }

}
