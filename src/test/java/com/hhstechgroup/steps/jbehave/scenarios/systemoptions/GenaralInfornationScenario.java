package com.hhstechgroup.steps.jbehave.scenarios.systemoptions;

import com.hhstechgroup.beans.application.*;
import com.hhstechgroup.steps.serenity.systemoption.GeneralInformationSteps;
import com.hhstechgroup.ui.panels.peportal.Table;
import com.hhstechgroup.util.jbehave.ExamplesTableUtil;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.Map;

public class GenaralInfornationScenario {
    @Steps
    GeneralInformationSteps generalInformationSteps;

    @When("user is navigate to genaral info: $table")
    public  void setGenaralInfo(ExamplesTable user){
        generalInformationSteps.setGenaralInfo(ExamplesTableUtil.parseTableToClass(user, GeneralInformationBean.class).get(0));
    }
    @When("set Licensure info for group: $table")
    public  void setLicensureInfo1(ExamplesTable user){
        generalInformationSteps.setLicensureInfo1(ExamplesTableUtil.parseTableToClass(user, LicensureCertificationBean.class).get(0));
    }
    @When("type and select first taxonomy options '$taxonomy' and '$description'")
    public void fillInTaxonomyInfoInLicensureSection(String taxonomy, String taxonomyDecsription){
        generalInformationSteps.fillInTaxonomyInfoInLicensure(taxonomy, taxonomyDecsription);
    }

    //new sp20
    @When("to select the taxonomy options '$taxonomy'")
    public void fillInTaxonomyInfoInLicensureSection1(String taxonomy){
        generalInformationSteps.fillInTaxonomyInfoInLicensure1(taxonomy);
    }

    @When("set provider identification number info: $table")
    public  void setProviderIdentificationNumberInfo(ExamplesTable user){
        generalInformationSteps.setnpiInfo(ExamplesTableUtil.parseTableToClass(user, ProviderIdentifierNumberBean.class).get(0));
    }

    @When("scroll to general information section in the user details page")
    public void scrollToGeneralInfor(){generalInformationSteps.scrollToGeneralInfor();}

    @When("set Indentifying info: $table")
    public  void setIdentificationInfo(ExamplesTable user){
        generalInformationSteps.setIdentificationInfo(ExamplesTableUtil.parseTableToClass(user, IdentifyingInformationBean.class).get(0));
    }

    @When("set Licensure info: $table")
    public  void setLicensureInfo(ExamplesTable user){
        generalInformationSteps.setLicensureInfo(ExamplesTableUtil.parseTableToClass(user, LicensureCertificationBean.class).get(0));
    }

    @When("set Address info: $table")
    public  void setAddressInfo(ExamplesTable user){
        generalInformationSteps.setAddressInfo(ExamplesTableUtil.parseTableToClass(user, AddressBean.class).get(0));
    }

    @When("To fill the address info in the identification section for TP: $table")
    public  void setTPAddressInfo(ExamplesTable user){
        generalInformationSteps.setTPAddressInfo(ExamplesTableUtil.parseTableToClass(user, AddressBean.class).get(0));
    }

    @When("To fill the Address details for TP: $table")
    public  void setAddressDetails(ExamplesTable user){
        generalInformationSteps.setAddressDetails(ExamplesTableUtil.parseTableToClass(user, AddressBean.class).get(0));
    }


    @When("to fill in Enrollment application from: $table")
    public void setAddressDetails2(ExamplesTable table){
        Map<String, String> m = table.getRow(0);
        generalInformationSteps.fillInEnrollment(m.get("type"),m.get("firstName"),m.get("lastName"), m.get("gender"),
                m.get("dateOfBirth"), m.get("email"),m.get("providerType"), m.get("speciality"), m.get("npi"),  m.get("providerAddress"), m.get("building"), m.get("zip"));
    }

    @When("select first Training required checkbox")
    public void clickTrainingRequiredCheckbox(){
        generalInformationSteps.selectTrainingRequiredCheckbox();
    }

    //sp26
    @When("to select the primary taxonomy options '$primarytaxonomy'")
    public void fillPrimaryTaxonomy(String taxonomy){
        generalInformationSteps.fillPrimaryTaxonomy(taxonomy);
    }
    //sp29
    @When("to select the pharmacy primary taxonomy options '$primarytaxonomy'")
    public void fillPrimaryTaxonomyCode(String taxonomy){
        generalInformationSteps.fillPrimaryTaxonomyCode(taxonomy);
    }

    //Demo

}
