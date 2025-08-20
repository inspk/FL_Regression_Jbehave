package com.hhstechgroup.ui.panels.enrollment;
import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.HashMap;
import java.util.Map;
import static java.lang.String.format;

public class AffiliationInformationPanel extends BaseEnrollmentPanel {
    //sp33
    private final static String NPI_FEIN_NUMBER = ".//label[contains(text(), 'NPI/FEIN Number')]/parent::div//input";
    private final static String AFFILIATION_TYPE = ".//label[contains(text(), 'Affiliation Type')]/parent::div//input/preceding-sibling::div";
    private final static String EFFECTIVE_DATE_FORM = ".//label[text() = 'Effective Date From']/following-sibling::div/input/following-sibling::div/button";
    private final static String EXPIRATION_DATE_TO = ".//label[text() = 'Effective Date To']/following-sibling::div/input/following-sibling::div/button";

    public AffiliationInformationPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setNpifeinNumber(String npifeinNumber) {
        waitABit(500);
        findBy(NPI_FEIN_NUMBER).type(npifeinNumber);
    }

    public void setAffiliationType(String affiliationType) {
        waitABit(500);
        findBy(AFFILIATION_TYPE).click();
        selectFromDropDown(affiliationType);
    }

    public void setEffectiveDateForm(String effectiveDateForm) {
        waitABit(2000);
        jsClick(EFFECTIVE_DATE_FORM);
        findBy(EFFECTIVE_DATE_FORM).sendKeys(effectiveDateForm);
        waitABit(2500);
    }
    public void setEffectiveDateTO(String effectiveDateTO) {
        waitABit(2000);
        jsClick(EXPIRATION_DATE_TO);
        findBy(EXPIRATION_DATE_TO).sendKeys(effectiveDateTO);
        waitABit(2500);
    }

    private static final String FACILITY_PROVIDER_NAME = ".//div/h3[contains(@class, 'affiliation_group-title')]";
    private static final String AFFILAITION_TYPE = ".//div[contains(@class, 'affiliation_cell_')]/div[contains(text(),'individual to facility')]";
    private static final String FACILITY_NAME = ".//div[contains(@class, 'affiliation_cell_')]/div[contains(text(),'CHN - Community League Health Center')]";

    public Map<String, String> getMappedProviderValuesForAffilaition() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("AFFILAITION TYPE", (findBy(format(AFFILAITION_TYPE))).getText());
       // map.put("FACILITY_NAME", (findBy(format(FACILITY_NAME))).getText());
        return map;
    }
}