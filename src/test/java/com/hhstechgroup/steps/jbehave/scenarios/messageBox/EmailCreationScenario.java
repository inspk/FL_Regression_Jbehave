package com.hhstechgroup.steps.jbehave.scenarios.messageBox;


import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import static org.junit.Assert.assertTrue;

public class EmailCreationScenario {

    private static final String INFO_MESSAGE = "Value %s is saved to variable %s";
    private Logger logger = Logger.getLogger(EmailCreationScenario.class);





    @Given("save revalidation date to variable '$variable'")
    public void saveRevalidationDateUI(String variable) throws ParseException {
        Calendar currentDate = Calendar.getInstance();
        currentDate.add(Calendar.MONTH, 3);
        currentDate.set(Calendar.DATE, currentDate.getActualMaximum(Calendar.DATE));
        Date revalidationDate = (currentDate.getTime());
        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String formatedDate = sdf.format(revalidationDate);
        Serenity.setSessionVariable(variable).to(formatedDate);
        logger.info(String.format(INFO_MESSAGE, formatedDate, variable));
    }


}