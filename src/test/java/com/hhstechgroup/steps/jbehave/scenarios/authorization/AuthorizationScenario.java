package com.hhstechgroup.steps.jbehave.scenarios.authorization;



import com.hhstechgroup.steps.serenity.peportalpages.AuthorizationSteps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.When;

import java.io.IOException;



public class AuthorizationScenario {

    @Steps
    AuthorizationSteps authorizationSteps;
//    @Steps
//    AttachmentsSteps attachmentsSteps;
//
//    @When("generate 278 file from json '$jsonFilePath' file and save it's id to variable '$variable'")
//    public void generateAuthorizationRequest(String ICN, String jsonFilePath, String variable) throws IOException {
//        String fileId = authorizationSteps.generate278AndGetId(jsonFilePath);
//        Serenity.setSessionVariable(variable).to(fileId);
//    }

//    @When("save authorization request file with id '$fileId' to '$path'")
//    public void getAuthRequest(String fileId, String path) throws Exception {
//        attachmentsSteps.saveFile(fileId, path);
//    }

//    @Then("authorization request should be found in DB by requestControlNumber '$ICN'")
//     public void findAuthorizationRequest(String interchangeRequestNumber){
//        List <AuthorizationDTO> authorizationDTO = authorizationSteps.getRequestByControlNumber(interchangeRequestNumber);
//        assertTrue(authorizationDTO.size() !=0);
//    }

//    @When("generate 278 response file from '$responseSourcePath' and save it to '$responseFilePath'")
//    @Alias("generate 278 request file from '$responseSourcePath' and save it to '$responseFilePath'")
//        public void saveResponseFile(String filePath, String writePath) throws IOException {
//        authorizationSteps.saveFile(filePath, writePath);
//    }
//
//    @When("upload 278 request files from folder '$authFolder' and save it to folder '$responseFilePath'")
//    public void saveFolderFile(String authFolder, String writePath) throws IOException {
//        authorizationSteps.saveFilesFromFolder(authFolder, writePath);
//    }

//    @Then("response with '$ICN' should be found in DB with parameters: $table")
//    public void searchResponseDB(String interchangeControlNumber, ExamplesTable table) {
//        AuthorizationDTO expectedResponse = ExamplesTableUtil.parseTableToClass(table, AuthorizationDTO.class).get(0);
//        List <ServicesDTO> listServices = new ArrayList<>();
//        ServicesDTO servicesDTO1 = new ServicesDTO();
//        servicesDTO1.setResponseCertificationNumber(table.getRows().get(0).get("services.responseCertificationNumber"));
//        servicesDTO1.setResponseStatusCode(table.getRows().get(0).get("services.responseStatusCode"));
//        ServicesDTO servicesDTO2 = new ServicesDTO();
//        servicesDTO2.setResponseCertificationNumber(table.getRows().get(0).get("services.responseCertificationNumber1"));
//        servicesDTO2.setResponseStatusCode(table.getRows().get(0).get("services.responseStatusCode1"));
//        listServices.add(0,servicesDTO1);
//        listServices.add(1,servicesDTO2);
//        expectedResponse.setServices(listServices);
//        AuthorizationDTO actualResponse = ExamplesTableUtil.replaceByHeaders(table.getHeaders(), authorizationSteps.getRequestByControlNumber(interchangeControlNumber).get(0));
//        assertReflectionEquals(expectedResponse, actualResponse);
//    }
}
