package com.hhstechgroup.ui.panels.enrollment.affiliation;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.CalendarPopUp;
import com.hhstechgroup.ui.panels.enrollment.BaseTable;
import com.hhstechgroup.util.converters.DateConverter;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.time.LocalDate;

public class AffiliationTable extends BaseTable {

    private final static String GROUP_PRACTICE_NAME = ".//label[contains(text(), 'Group practice name')]/parent::div//input";
    private final static String ID_TYPE = ".//label[contains(text(), 'ID type')]/parent::div//input";
    private final static String NPI_API = ".//label[contains(text(), 'NPI')]/parent::div//input";
    private final static String PROVIDER_TYPE = ".//label[contains(text(), 'Provider type')]/parent::div//input/preceding-sibling::div";
    private final static String AFFILIATION_EFFECTIVE_DATE = ".//label[contains(text(), 'date')]/parent::div//button";
    private final static String AFFILIATION_TYPE = ".//label[contains(text(), 'Affiliation type')]/parent::div//input";
    private static final String CALENDAR = "//div[@role='document']";
    private final static String PROVIDER_NAME = ".//label[contains(text(), 'Provider name')]/parent::div//input";

    public AffiliationTable(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setGroupPracticeName(String groupPracticeName) {
        waitForPresenceOf(GROUP_PRACTICE_NAME);
        findBy(GROUP_PRACTICE_NAME).type(groupPracticeName);
    }

    public void setIdType(String idType) {
        findBy(ID_TYPE).type(idType);
    }

    public void setNpiApi(String npiApi) {
        findBy(NPI_API).type(npiApi);
    }

    public void setProviderName(String providerName) {
        findBy(PROVIDER_NAME).type(providerName);
    }

    public void setProviderType(String providerType) {
        findBy(PROVIDER_TYPE).click();
        selectFromDropDown(providerType);
    }

    public void setAffiliationEffectiveDate(String affiliationEffectiveDate) {
        action().moveToElement(findBy(AFFILIATION_EFFECTIVE_DATE)).click().build().perform();
        LocalDate date = DateConverter.toLocalDate(affiliationEffectiveDate);
        waitForPopUpOpened();
        CalendarPopUp calendar = new CalendarPopUp(findBy(CALENDAR), getBasePage());
        calendar.setYear(date.getYear());
        calendar.setMonth(date.getMonthValue());
        calendar.setDayOfMonth(date.getDayOfMonth());
    }

    public void setTableAffiliationType(String tableAffiliationType) {
        action().moveToElement(findBy(AFFILIATION_TYPE)).sendKeys(Keys.TAB).build().perform();
        findBy(AFFILIATION_TYPE).type(tableAffiliationType);
    }
}
