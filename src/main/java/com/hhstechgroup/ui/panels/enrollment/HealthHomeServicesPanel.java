package com.hhstechgroup.ui.panels.enrollment;

import com.hhstechgroup.ui.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.lang.String.format;

public class HealthHomeServicesPanel extends BaseEnrollmentPanel {
    private static final String COMPREHENSIVE_CARE_MANAGEMENT = "(//input[@type='text'])[1]";
    private static final String CARE_COORDINATION = "(//input[@type='text'])[2]";
    private static final String HEALTH_PROMOTION = "(//input[@type='text'])[3]";
    private static final String COMPREHENSIVE_TRADITIONAL_CARE = "(//input[@type='text'])[4]";
    private static final String FAMILY_SUPPORT_SERVICES = "(//input[@type='text'])[5]";
    private static final String SOCIAL_SUPPORT_SERVICES = "(//input[@type='text'])[6]";
    private static final String EMERGENCY_ROOM_UTILIZATION = "(//input[@type='text'])[7]";
    private static final String NOTIFICATION_OF_EMERGENCY_ROOM = "(//input[@type='text'])[8]";
    private static final String HEALTH_HOME = "(//input[@type='text'])[9]";
    private static final String PRIMARY_CARE_PRACTICE = "(//input[@type='text'])[10]";
    private static final String APPLICABLE_RESPONSE = "//label[text()='Please select all applicable Responses']/../div";
    private static final String OPTIONS = "//ul/li[node()='%s']";

    public HealthHomeServicesPanel(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void setComprehensiveCareManagement(String comprehensiveCareManagement) {
        waitABit(500);
        findBy(COMPREHENSIVE_CARE_MANAGEMENT).type(comprehensiveCareManagement);
        waitABit(500);
    }

    public void setCareCoordination(String careCoordination) {
        waitABit(500);
        findBy(CARE_COORDINATION).type(careCoordination);
        waitABit(500);
    }

    public void setHealthPromotion(String healthPromotion) {
        waitABit(500);
        findBy(HEALTH_PROMOTION).type(healthPromotion);
        waitABit(500);
    }

    public void setComprehensiveTraditionalCare(String comprehensiveTraditionalCare) {
        waitABit(500);
        findBy(COMPREHENSIVE_TRADITIONAL_CARE).type(comprehensiveTraditionalCare);
        waitABit(500);
    }

    public void setFamilySupportServices(String familySupportServices) {
        waitABit(500);
        findBy(FAMILY_SUPPORT_SERVICES).type(familySupportServices);
        waitABit(500);
    }

    public void setSocialSupportServices(String socialSupportServices) {
        waitABit(500);
        findBy(SOCIAL_SUPPORT_SERVICES).type(socialSupportServices);
        waitABit(500);
    }

    public void setEmergencyRoomUtilization(String emergencyRoomUtilization) {
        waitABit(500);
        findBy(EMERGENCY_ROOM_UTILIZATION).type(emergencyRoomUtilization);
        waitABit(500);
    }

    public void setHealthHome(String healthHome) {
        waitABit(500);
        findBy(HEALTH_HOME).type(healthHome);
        waitABit(500);
    }

    public void setNotificationOfEmergencyRoom(String notificationOfEmergencyRoom) {
        waitABit(500);
        findBy(NOTIFICATION_OF_EMERGENCY_ROOM).type(notificationOfEmergencyRoom);
        waitABit(500);
    }

    public void setPrimaryCarePractice(String primaryCarePractice) {
        waitABit(500);
        findBy(PRIMARY_CARE_PRACTICE).type(primaryCarePractice);
        waitABit(500);
    }

    public void setApplicableResponse(String applicableResponse) {
        scrollToElement(APPLICABLE_RESPONSE);
        waitABit(500);
        findBy(APPLICABLE_RESPONSE).click();
        waitABit(500);
        findBy(format(OPTIONS, applicableResponse)).click();
        waitABit(500);
    }

}

