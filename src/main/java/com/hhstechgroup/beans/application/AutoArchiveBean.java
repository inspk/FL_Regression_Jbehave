package com.hhstechgroup.beans.application;

public class AutoArchiveBean {
    private String schedule;
    private String period;
    private String scheduleForFiles;
    private String periodForFiles;

    public String getScheduleForFiles() {
        return scheduleForFiles;
    }

    public void setScheduleForFiles(String scheduleForFiles) {
        this.scheduleForFiles = scheduleForFiles;
    }

    public String getPeriodForFiles() {
        return periodForFiles;
    }

    public void setPeriodForFiles(String periodForFiles) {
        this.periodForFiles = periodForFiles;
    }



    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }


}
