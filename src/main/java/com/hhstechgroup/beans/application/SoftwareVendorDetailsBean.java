package com.hhstechgroup.beans.application;

public class SoftwareVendorDetailsBean implements ApplicationSectionData {
    private String softwareVendorName;
    private String softwareName;
    private String versionId;
    private String entityCode;

    public String getSoftwareVendorName() {
        return softwareVendorName;
    }

    public void setSoftwareVendorName(String softwareVendorName) {
        this.softwareVendorName = softwareVendorName;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

}
