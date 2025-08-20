package com.hhstechgroup.steps.serenity.systemoption;

import com.hhstechgroup.beans.application.*;
import com.hhstechgroup.ui.pages.peportal.DashboardPage;
import com.hhstechgroup.ui.pages.sitevisit.UserPage;
import com.hhstechgroup.ui.panels.enrollment.*;
import com.hhstechgroup.ui.panels.enrollment.licensure.LicensureCertificationPanel;
import com.hhstechgroup.ui.panels.systemoptions.GeneralInformationPanel;
import com.hhstechgroup.util.common.BeanUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class GeneralInformationSteps extends ScenarioSteps {
    UserPage userPage;
    DashboardPage dashboardPage;

    @Step
    public void setGenaralInfo(GeneralInformationBean newUserBeans) {
        GeneralInformationPanel panel = userPage.getGenaralInfo();
        waitABit(200);
        BeanUtils.copyPropertiesInOrder(panel, newUserBeans);
    }

    @Step
    public void setIdentificationInfo(IdentifyingInformationBean newIdentiBeans) {
        IdentifyingInformationPanel panel = userPage.getIdentificationInfo();
        waitABit(500);
        BeanUtils.copyPropertiesInOrder(panel, newIdentiBeans);
    }

    @Step
    public void setLicensureInfo(LicensureCertificationBean newLicensureBeans) {
        LicensureCertificationPanel panel = userPage.getLicensureInfo();
        waitABit(200);
        BeanUtils.copyPropertiesInOrder(panel, newLicensureBeans);
    }

    @Step
    public void setAddressInfo(AddressBean newAddressBeans) {
        AddressPanel panel = userPage.getAddressInfo();
        waitABit(500);
        BeanUtils.copyPropertiesInOrder(panel, newAddressBeans);
    }

    @Step
    public void setAddressDetails(AddressBean newAddressBeans) {
        TPAddressDetailsPanel panel = userPage.getAddressDetails();
        waitABit(500);
        BeanUtils.copyPropertiesInOrder(panel, newAddressBeans);
    }

    @Step
    public void setTPAddressInfo(AddressBean newAddressBeans) {
        TPAddressInfoPanel panel = userPage.getTPAddressinfo();
        waitABit(500);
        BeanUtils.copyPropertiesInOrder(panel, newAddressBeans);
    }

    @Step
    public void scrollToGeneralInfor() {
        userPage.scrollToGeneralInfor();
    }

    @Step
    public void setLicensureInfo1(LicensureCertificationBean newLicensureBeans) {
        LicensureCertificationPanel panel = userPage.getLicensureInfo();
        waitABit(200);
        BeanUtils.copyPropertiesInOrder(panel, newLicensureBeans);
    }

    @Step
    public void fillInTaxonomyInfoInLicensure(String taxonomy, String taxonomyDescription) {
        userPage.fillInTaxonomyInfo(taxonomy, taxonomyDescription);
    }
    //new sp20
    @Step
    public void fillInTaxonomyInfoInLicensure1(String taxonomy) {
      userPage.fillInTaxonomyInfo1(taxonomy);
     }

    @Step
    public void setnpiInfo(ProviderIdentifierNumberBean newnpi) {
        ProviderIdentifierNumberPanel panel = userPage.getnpiInfo();
        waitABit(500);
        BeanUtils.copyPropertiesInOrder(panel, newnpi);
    }

    @Step
    public void fillInEnrollment(String type, String firstName, String lastName, String gender,
                                 String  dateOfBirth, String email, String providerType, String speciality,
                                 String npi, String providerAddress, String building, String zip){
        dashboardPage.getBodyPanel().getEnrollmentMiniPanel(type).clickOnType();
        userPage.fillInProviderEnrollment(firstName, lastName, gender,
                dateOfBirth,email,providerType, speciality, npi, providerAddress,
                building, zip);
    }

    @Step
    public void selectTrainingRequiredCheckbox(){
       userPage.clickTrainingRequiredCheckbox();
    }

    //sp26
    @Step
    public void fillPrimaryTaxonomy(String taxonomy) {
        userPage.fillPrimaryTaxonomy(taxonomy);
    }
    //sp29
    @Step
    public void fillPrimaryTaxonomyCode(String taxonomy){
        userPage.fillPrimaryTaxonomyCode(taxonomy);
    }
}


