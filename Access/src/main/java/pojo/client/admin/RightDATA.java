package pojo.client.admin;


import pojo.GeneralParams;

/**
 * Created by root on 27.10.15.
 */
public class RightDATA extends GeneralParams {
    private Integer deviceId;
    private String deviceSpecification;
    private Integer systemRoleId;
    private String systemRoleTitle;
    private Boolean access;

    public void setSpecificParams(
            Integer deviceId,
            String deviceSpecification,
            Integer systemRoleId,
            String systemRoleTitle,
            Boolean access
    ) {
        this.deviceId = deviceId;
        this.deviceSpecification = deviceSpecification;
        this.systemRoleId = systemRoleId;
        this.systemRoleTitle = systemRoleTitle;
        this.access = access;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceSpecification() {
        return deviceSpecification;
    }

    public void setDeviceSpecification(String deviceSpecification) {
        this.deviceSpecification = deviceSpecification;
    }

    public Integer getSystemRoleId() {
        return systemRoleId;
    }

    public void setSystemRoleId(Integer systemRoleId) {
        this.systemRoleId = systemRoleId;
    }

    public String getSystemRoleTitle() {
        return systemRoleTitle;
    }

    public void setSystemRoleTitle(String systemRoleTitle) {
        this.systemRoleTitle = systemRoleTitle;
    }

    public Boolean getAccess() {
        return access;
    }

    public void setAccess(Boolean access) {
        this.access = access;
    }
}
