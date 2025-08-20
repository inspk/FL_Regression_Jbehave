package com.hhstechgroup.steps.serenity.peportalpages;


import com.hhstechgroup.ui.pages.peportal.EDIPage;
import com.hhstechgroup.util.common.FileUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class EDISteps extends ScenarioSteps{

    EDIPage ediPage;

    @Step
    public boolean pageHasTitle (String title){
      return ediPage.pageHasTitle(title);
    }

    @Step
    public void clickAddDocument (){
        ediPage.clickAddDocument();
    }

    @Step
    public void clickUploadFile (){
        ediPage.clickUploadFile();
    }

    @Step
    public void uploadFile(String path){
        ediPage.getAddFilePopUp().uploadEdiFile(FileUtils.getAbsolutePath(FileUtils.FILES_PATH + path));
    }
    @Step
    public void clickOnAddFileButton(String button){ediPage.clickOnAddFileButton(button);}
}
