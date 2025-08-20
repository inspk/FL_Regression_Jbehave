package com.hhstechgroup.steps.jbehave.scenarios.applications;



public class ApplicationScenario {


    private String getTrackingNumber(String trackingNumber) {
        final String defaultTrackingNumber = "000000000";
        String formattedTrackingNumber = new StringBuilder(defaultTrackingNumber.substring(0, defaultTrackingNumber.length() - trackingNumber.length())).append(trackingNumber).toString();
        return formattedTrackingNumber.replaceFirst("(\\d{3})(\\d{3})(\\d{3})",  "$1-$2-$3");
    }



}