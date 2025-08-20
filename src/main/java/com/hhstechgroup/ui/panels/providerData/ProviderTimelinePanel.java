package com.hhstechgroup.ui.panels.providerData;
import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.HashMap;
import java.util.Map;
import static java.lang.String.format;

public class ProviderTimelinePanel extends AbstractPanel {
    private static final String TIMELINE_RECORD = ".//div[contains(@class, 'timeline_list-item')][%s]";
    private static final String TIMELINE_STATUS = "//div[contains(@class, 'timeline_status')]/span";
    private static final String TYMELINE_NAME = "//p[contains(@class, 'timeline_main-type')]";
    private static final String TIMELINE_TYPE = "//p[contains(@class, 'timeline_second-type')]";
    private static final String TIMELINE_ID = "//p[contains(@class, 'timeline_main-type')]/span";
    private static final String TIMELINE_DATE = "//div[contains(@class, 'timeline_item-date-text')]/span[1]";
    private static final String TIMELINE_RECORD_CLICKABLE_AREA = "//div[contains(@class, 'timeline_row')]";
    private static final String TIMELINE_SORT_IN_ROW = "//div[contains(@class, 'timeline_sort-actions')]";



    public ProviderTimelinePanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public Map<String, String> getMappedTimelineValuesForRecord(String record) {
        Map<String, String> map = new HashMap<String, String>();
        scrollToElement(TIMELINE_STATUS);
        map.put("STATUS",(findBy(format(TIMELINE_RECORD+TIMELINE_STATUS, record))).getText());
//        map.put("NAME",(findBy(format(TIMELINE_RECORD+TYMELINE_NAME, record))).getText());
        map.put("TYPE",(findBy(format(TIMELINE_RECORD+TIMELINE_TYPE, record))).getText());
//        map.put("DATE",(findBy(format(TIMELINE_RECORD+TIMELINE_DATE, record))).getText());
        return  map;
    }

    public void clickOnTimelineRecordWithNumber (String record)
    {
       findBy(format(TIMELINE_RECORD+TIMELINE_RECORD_CLICKABLE_AREA, record)).click();
       waitForPresenceOf(format(TIMELINE_RECORD+TIMELINE_SORT_IN_ROW, record));
    }

    public void clickOnRequestLinkInTimeline (String record)
    {
        findBy(format(TIMELINE_RECORD+TIMELINE_ID, record)).click();
        waitForAbsenceOf(format(TIMELINE_RECORD+TIMELINE_ID, record));
    }
}




