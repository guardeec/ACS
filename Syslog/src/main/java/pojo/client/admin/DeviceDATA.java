package pojo.client.admin;


import pojo.GeneralParams;

/**
 * Created by root on 27.10.15.
 */
public class DeviceDATA extends GeneralParams {
    private Integer deviceId;
    private String deviceIp;
    private String deviceMac;
    private String deviceSpecification;
    private Boolean deviceCondition;
    private String deviceSecription;

    public void setSpecificParams(
            Integer deviceId,
            String deviceIp,
            String deviceMac,
            String deviceSpecification,
            Boolean deviceCondition,
            String deviceSecription
    ) {
        this.deviceId = deviceId;
        this.deviceIp = deviceIp;
        this.deviceMac = deviceMac;
        this.deviceSpecification = deviceSpecification;
        this.deviceCondition = deviceCondition;
        this.deviceSecription = deviceSecription;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public String getDeviceSpecification() {
        return deviceSpecification;
    }

    public void setDeviceSpecification(String deviceSpecification) {
        this.deviceSpecification = deviceSpecification;
    }

    public Boolean getDeviceCondition() {
        return deviceCondition;
    }

    public void setDeviceCondition(Boolean deviceCondition) {
        this.deviceCondition = deviceCondition;
    }

    public String getDeviceSecription() {
        return deviceSecription;
    }

    public void setDeviceSecription(String deviceSecription) {
        this.deviceSecription = deviceSecription;
    }
}
