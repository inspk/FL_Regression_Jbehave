package com.hhstechgroup.steps.jbehave.scenarios;

import com.github.javafaker.Faker;
import com.hhstechgroup.steps.serenity.registration.RegistrationSteps;
import com.hhstechgroup.util.converters.DateConverter;
import com.hhstechgroup.util.properties.ProviderProperties;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

import static com.hhstechgroup.util.converters.DateConverter.*;
import static net.thucydides.core.steps.StepEventBus.getEventBus;

public class TestDataCreationScenario {

    private static final int RANDOM_VALUE_LENGTH = 5;
    private static final int RANDOM_NPI = 10;
    private static final int RANDOM_ICN = 9;
    private static final int RANDOM_TCN = 16;
    private static final int RANDOM_RTN = 5;
    private static final int RANDOM_MEMBER_ID = 11;
    private static final String INFO_MESSAGE = "Value %s is saved to variable %s";
    private static final String NPI_MESSAGE = "Value %s is saved to variable NPI";
    private static final String ICN_MESSAGE = "Value %s is saved to variable ICN";
    private static final String TCN_MESSAGE = "Value %s is saved to variable TCN";
    private static final String RTN_MESSAGE = "Value %s is saved to variable RTN";
    private static final String MEMBER_ID_MESSAGE = "Value %s is saved to variable MEMBER_ID";
    private static final String CLAIM_PAID_DATE_FORMAT = "yyyyMMdd";
    private Logger logger = Logger.getLogger(TestDataCreationScenario.class);

    @Steps
    RegistrationSteps registrationSteps;

    @Given("unique value for variable '$variable' is generated")
    public void generateValue(String variable) {
        String value = RandomStringUtils.random(RANDOM_VALUE_LENGTH, true, false).toLowerCase();
        System.out.println(value);
        Serenity.setSessionVariable(variable).to(value);
        logger.info(String.format(INFO_MESSAGE, value, variable));
    }

    @Given("unique role name value for variable '$roleName' is generated")
    public void generateRoleName(String roleName) {
        String randomNumber = RandomStringUtils.random(RANDOM_VALUE_LENGTH, false, true);
        String role = "New Role " + randomNumber;
        Serenity.setSessionVariable(roleName).to(role);
        logger.info(String.format(INFO_MESSAGE, role, roleName));
    }
    //latest
    @Given("unique bussiness name value for variable '$bussinessName' is generated")
    public void generateBussinessName(String bussinessName) {
        String randomNumber = RandomStringUtils.random(RANDOM_VALUE_LENGTH, false, true);
        String tpbussinessname = "New Bussiness Name " + randomNumber;
        Serenity.setSessionVariable(bussinessName).to(tpbussinessname);
        logger.info(String.format(INFO_MESSAGE, tpbussinessname, bussinessName));
    }


    @Given("unique member ID for variable '$memberId' is generated")
    public void generateMemberId(String memberId) {
        String memId = RandomStringUtils.random(RANDOM_MEMBER_ID, false, true);
        Serenity.setSessionVariable(memberId).to(memId);
        logger.info(String.format(MEMBER_ID_MESSAGE, memId, memberId));
    }

    @Given("unique NPI for variable '$NPI' is generated")
    public void generateNPI(String NPI) {
        String nationalProviderIdentifier = RandomStringUtils.random(RANDOM_NPI, false, true);
        Serenity.setSessionVariable(NPI).to(nationalProviderIdentifier);
        logger.info(String.format(NPI_MESSAGE, nationalProviderIdentifier, NPI));
    }


    @Given("unique LCAE number '$LCAE' is generated")
    public void generateNPI1(String LCAE) {
        String nationalProviderIdentifier = RandomStringUtils.random(RANDOM_NPI, false, true);
        Serenity.setSessionVariable(LCAE).to(nationalProviderIdentifier);
        logger.info(String.format(NPI_MESSAGE, nationalProviderIdentifier, LCAE));
    }

    @Given("unique interchange control number for variable '$ICN' is generated")
    public void generateICN(String ICN) {
        String interchangeControlNumber = RandomStringUtils.random(RANDOM_ICN, false, true);
        Serenity.setSessionVariable(ICN).to(interchangeControlNumber);
        logger.info(String.format(ICN_MESSAGE, interchangeControlNumber, ICN));
    }

    @Given("unique transaction control number for variable '$TCN' is generated")
    public void generateTCN(String TCN) {
        String transactionControlNumber = RandomStringUtils.random(RANDOM_TCN , false, true);
        Serenity.setSessionVariable(TCN).to(transactionControlNumber);
        logger.info(String.format(TCN_MESSAGE, transactionControlNumber, TCN));
    }

    @Given("unique reassociation trace number for variable '$RTN' is generated")
    public void generateRTN(String RTN) {
        String randomNumber = RandomStringUtils.random(RANDOM_RTN, false, true);
        String transactionControlNumber = "A04B001017." + randomNumber;
        Serenity.setSessionVariable(RTN).to(transactionControlNumber);
        logger.info(String.format(RTN_MESSAGE, transactionControlNumber, RTN));
    }

    @Given("save current date to variable '$variable'")
    @When("save current date to variable '$variable'")
    public void saveCurrentDate(String variable) {
        String value = convert(LocalDateTime.now());
        Serenity.setSessionVariable(variable).to(value);
        logger.info(String.format(INFO_MESSAGE, value, variable));
    }

    @When("save current date plus $count years to variable '$variable'")
    public void saveExpirationDate(int count, String variable) {
        String value = convert(LocalDateTime.now().plusYears(count));
        Serenity.setSessionVariable(variable).to(value);
        logger.info(String.format(INFO_MESSAGE, value, variable));
    }
    //latest
    @When("save current date plus $count one day to variable end data '$variable'")
    public void saveEndDate(int count, String variable) {
        //String value = convert1(LocalDateTime.now().plusDays(count));
        String value = convert(LocalDateTime.now().plusDays(count));
        Serenity.setSessionVariable(variable).to(value);
        logger.info(String.format(INFO_MESSAGE, value, variable));
    }
    @When("save yesterday's date to variable '$variable'")
    public void saveYesterdaysDate(String variable) {
        String value = convert(LocalDateTime.now().minusDays(1));
        Serenity.setSessionVariable(variable).to(value);
        logger.info(String.format(INFO_MESSAGE, value, variable));
    }

    @When("save current date plus $count one minute to variable end data '$variable'")
    public void saveFromDate(int count, String variable) {
        String value = convert1(LocalDateTime.now().plusMinutes(count));
        Serenity.setSessionVariable(variable).to(value);
        logger.info(String.format(INFO_MESSAGE, value, variable));
    }


    @When("save message received time")
    public void saveMessageTime() {
        Serenity.setSessionVariable(SUBMIT_TIME).to(DateConverter.getSubmissionDate());
    }

    @Given("save value '$value' to variable '$variable'")
    public void saveValue(String value, String variable) {
        Serenity.setSessionVariable(variable).to(value);
    }

    @Given("save start claim paid date within 7 days from today to variable '$variable'")
    public void saveClaimStartPaidDate(String variable) {
        Serenity.setSessionVariable(variable).to(convert(LocalDateTime.now().minusDays(1), CLAIM_PAID_DATE_FORMAT));
    }

    @Given("save end claim paid date within 7 days from today to variable '$variable'")
    @Alias("save projected claim date within 7 days from today to variable '$variable'")
    public void saveClaimEndPaidDate(String variable) {
        Serenity.setSessionVariable(variable).to(convert(LocalDateTime.now().plusDays(3), CLAIM_PAID_DATE_FORMAT));
        logger.info(String.format("Claim date was saved to variable: ", variable));
    }

    @Given("save information for individual provider to session variables")
    public void saveIndividualProviderData() {
        Map<String, String> data = getEventBus().getBaseStepListener().getTestOutcomes().get(0).getDataTable().currentRow().toStringMap();
        data.forEach((key, value) -> {
            logger.info(String.format("%s - %s", key, value));
            Serenity.setSessionVariable(key).to(value);
        });
        }

        //Latest
        @Given("unique risk Level name value for variable '$riskLevelName' is generated")
        public void generateRiskLevelName(String riskLevelName) {
            String randomNumber = RandomStringUtils.random(RANDOM_VALUE_LENGTH, false, true);
            String risklevel = "Risk Level " + randomNumber;
            Serenity.setSessionVariable(riskLevelName).to(risklevel);
            logger.info(String.format(INFO_MESSAGE, risklevel, riskLevelName));
        }

    @Given("unique rule name value for variable '$ruleName' is generated")
    public void generateNewRuleName(String ruleName) {
        String randomNumber = RandomStringUtils.random(RANDOM_VALUE_LENGTH, false, true);
        String rule = "New Rule " + randomNumber;
        Serenity.setSessionVariable(ruleName).to(rule);
        logger.info(String.format(INFO_MESSAGE, rule, ruleName));
    }

    //sp23

    @Given("save current date '$variable'")
    @When("save current date '$variable'")
    public void saveCurrentDate2(String variable) {
        String value = convert2(LocalDateTime.now());
        Serenity.setSessionVariable(variable).to(value);
        logger.info(String.format(INFO_MESSAGE, value, variable));
    }
    @Given("generate firstname, lastname, middlename and email credentials for '$index'")
    public void generateCredentials(String index) {
        Faker faker = new Faker();

        // Generate realistic names
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String middleName = faker.name().firstName();

        // Generate random names
//        String firstName = RandomStringUtils.random(1, "QWERTYUIOPASDFGHJKKLZXCVBNM")+ RandomStringUtils.random(7, "abcdefghijklmnopqrstuvwxyz");
//        String lastName = RandomStringUtils.random(1, "QWERTYUIOPASDFGHJKKLZXCVBNM")+ RandomStringUtils.random(7, "abcdefghijklmnopqrstuvwxyz");
//        String middleName = RandomStringUtils.random(1, "QWERTYUIOPASDFGHJKKLZXCVBNM")+ RandomStringUtils.random(7, "abcdefghijklmnopqrstuvwxyz");
        String email = registrationSteps.generateEmail("gmail.com");

        // Save in properties file
        ProviderProperties.save1("First_name", firstName, index, "Initialized");
        ProviderProperties.save1("Last_name", lastName, index, "Initialized");
        ProviderProperties.save1("Middle_name", lastName, index, "Initialized");
        ProviderProperties.save1("Email", email, index, "Initialized");

        // Save in Serenity session variables
        Serenity.setSessionVariable("firstName").to(firstName);
        Serenity.setSessionVariable("lastName").to(lastName);
        Serenity.setSessionVariable("middleName").to(middleName);
        Serenity.setSessionVariable("email").to(email);

    }

    @Given("generate new random email credentials for '$index'")
    public void generateNewEmail(String index) {
        String email = registrationSteps.generateEmail("gmail.com");
        ProviderProperties.save1("Email", email, index, "Initialized");
        Serenity.setSessionVariable("email").to(email);
        Serenity.setSessionVariable("index").to(index);

    }

    @Then("rewrite stage of credentials to '$stage' for '$index'")
    public void replaceCredentials(String stage, String index){
        String firstName = (String)Serenity.getCurrentSession().get("firstName");
        String lastName = (String)Serenity.getCurrentSession().get("lastName");
        String email = (String)Serenity.getCurrentSession().get("email");
        String npi = (String)Serenity.getCurrentSession().get("npi");
        Serenity.getCurrentSession().remove("firstName");
        Serenity.getCurrentSession().remove("lastName");
        Serenity.getCurrentSession().remove("email");
        Serenity.getCurrentSession().remove("npi");
        ProviderProperties.save("First_name", firstName, index, stage);
        ProviderProperties.save("Last_name", lastName, index, stage);
        ProviderProperties.save("Email", email, index, stage);
        ProviderProperties.save("npi",npi,index,stage);
    }

    @Given("take firstname, lastname and email credentials for type '$type' and '$stage' and use in session")
    public void getCredentials(String type, String stage) {
        Serenity.setSessionVariable("firstName").to(ProviderProperties.getData("First_name", type, stage));
        Serenity.setSessionVariable("lastName").to(ProviderProperties.getData("Last_name", type, stage));
        Serenity.setSessionVariable("email").to(ProviderProperties.getData("Email", type, stage));
//        Serenity.setSessionVariable("npi").to("1982612081");
        Serenity.setSessionVariable("npi").to(ProviderProperties.getData("npi",type,stage));
    }
    //sp26
    @Given("take firstname, lastname and email new credentials for type reassign '$type' and '$stage' and use in session")
    public void getNewCredentials(String type, String stage) {
        Serenity.setSessionVariable("firstName1").to(ProviderProperties.getData("First_name1", type, stage));
        Serenity.setSessionVariable("lastName1").to(ProviderProperties.getData("Last_name1", type, stage));
        Serenity.setSessionVariable("email1").to(ProviderProperties.getData("Email1", type, stage));
    }

    @Given("generate firstname, lastname and email credentials for reassign '$index'")
    public void generateNewCredentials(String index) {
        String firstName = RandomStringUtils.random(1, "QWERTYUIOPASDFGHJKKLZXCVBNM")+ RandomStringUtils.random(7, "abcdefghijklmnopqrstuvwxyz");
        String lastName = RandomStringUtils.random(1, "QWERTYUIOPASDFGHJKKLZXCVBNM")+ RandomStringUtils.random(7, "abcdefghijklmnopqrstuvwxyz");
        String email = registrationSteps.generateEmail("gmail.com");
        ProviderProperties.save1("First_name1", firstName, index, "Initialized");
        ProviderProperties.save1("Last_name1", lastName, index, "Initialized");
        ProviderProperties.save1("Email1", email, index, "Initialized");
        Serenity.setSessionVariable("firstName1").to(firstName);
        Serenity.setSessionVariable("lastName1").to(lastName);
        Serenity.setSessionVariable("email1").to(email);

    }
   //collaborator
    @Given("take firstname, lastname and email new credentials for type collaborator '$type' and '$stage' and use in session")
    public void getCollCredentials(String type, String stage) {
        Serenity.setSessionVariable("collfirstName1").to(ProviderProperties.getData("CollFirst_name1", type, stage));
        Serenity.setSessionVariable("colllastName1").to(ProviderProperties.getData("CollLast_name1", type, stage));
        Serenity.setSessionVariable("collemail1").to(ProviderProperties.getData("CollEmail1", type, stage));
    }

    @Given("generate firstname, lastname and email credentials for collaborator '$index'")
    public void generateCollCredentials(String index) {
        String firstName = RandomStringUtils.random(1, "QWERTYUIOPASDFGHJKKLZXCVBNM")+ RandomStringUtils.random(7, "abcdefghijklmnopqrstuvwxyz");
        String lastName = RandomStringUtils.random(1, "QWERTYUIOPASDFGHJKKLZXCVBNM")+ RandomStringUtils.random(7, "abcdefghijklmnopqrstuvwxyz");
        String email = registrationSteps.generateEmail("gmail.com");
        ProviderProperties.save1("CollFirst_name1", firstName, index, "Initialized");
        ProviderProperties.save1("CollLast_name1", lastName, index, "Initialized");
        ProviderProperties.save1("CollEmail1", email, index, "Initialized");
        Serenity.setSessionVariable("collfirstName1").to(firstName);
        Serenity.setSessionVariable("colllastName1").to(lastName);
        Serenity.setSessionVariable("collemail1").to(email);
    }


    @Given("set duplicate npi '$npi'")
    public void setDuplicateNpi(String npi){
        ProviderProperties.save("duplicateNpi", npi);
        Serenity.setSessionVariable("duplicateNpi").to(npi);
        logger.info(npi + " is set as duplicateNpi!");
    }

    @Given("get duplicate npi")
    public void getDuplicateNpi(){
        logger.info(ProviderProperties.getData("duplicateNpi") + " got as duplicateNpi!");
        Serenity.setSessionVariable("duplicateNpi").to(ProviderProperties.getData("duplicateNpi"));
    }


}
