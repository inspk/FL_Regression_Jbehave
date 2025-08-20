package com.hhstechgroup.beans.application;

public class OtherMedicaidStateBean implements ApplicationSectionData {
    //sp26
    private String otherMedicaidState;
    private String stateProgram;
    private String enrollmentBeginDate;
    private String enrollmentEndDate;

    public String getOtherMedicaidState() {
        return otherMedicaidState;
    }

    public void setOtherMedicaidState(String otherMedicaidState) {
        this.otherMedicaidState = otherMedicaidState;
    }

    public String getStateProgram() {
        return stateProgram;
    }

    public void setStateProgram(String stateProgram) {
        this.stateProgram = stateProgram;
    }

    public String getEnrollmentBeginDate() {
        return enrollmentBeginDate;
    }

    public void setEnrollmentBeginDate(String enrollmentBeginDate) {
        this.enrollmentBeginDate = enrollmentBeginDate;
    }

    public String getEnrollmentEndDate() {
        return enrollmentEndDate;
    }

    public void setEnrollmentEndDate(String enrollmentEndDate) {
        this.enrollmentEndDate = enrollmentEndDate;
    }
}

