package com.hhstechgroup.beans;

public class AuditEventsSearchBean {

    private String userId;
    private String userName;
    private String userRole;
    private String portal;
    private String page;
    private String eventName;
    private String dateFrom;
    private String dateTo;
    private String tags;

    public String getParameterValues() {
        return parameterValues;
    }

    public void setParameterValues(String parameterValues) {
        this.parameterValues = parameterValues;
    }

    private String parameterValues;

    public String getTimestampFrom() {
        return timestampFrom;
    }

    public void setTimestampFrom(String timestampFrom) {
        this.timestampFrom = timestampFrom;
    }

    public String getTimestampTo() {
        return timestampTo;
    }

    public void setTimestampTo(String timestampTo) {
        this.timestampTo = timestampTo;
    }

    private String timestampFrom;

    private String timestampTo;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userIP) {
        this.userName = userIP;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

}
