package pojo.arduino;

import pojo.GeneralParams;

/**
 * Created by Guardeec on 08.02.16.
 */
public class GetAccessData extends GeneralParams {
    private Integer deviceId;
    private String cardNumber;
    private Integer cardId;

    private Integer employeeId;
    private String employeeName;
    private Integer systemRoleId;
    private String systemRoleTitle;
    private Boolean access;
    private String type;
    private String message;

    public void setSpecificParams(Integer deviceId, String cardNumber, Integer cardId, Integer employeeId, String employeeName, Integer systemRoleId, String systemRoleTitle, Boolean access, String type, String message) {
        this.deviceId = deviceId;
        this.cardNumber = cardNumber;
        this.cardId = cardId;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.systemRoleId = systemRoleId;
        this.systemRoleTitle = systemRoleTitle;
        this.access = access;
        this.type = type;
        this.message = message;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Boolean getAccess() {
        return access;
    }

    public void setAccess(Boolean access) {
        this.access = access;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSystemRoleTitle() {
        return systemRoleTitle;
    }

    public void setSystemRoleTitle(String systemRoleTitle) {
        this.systemRoleTitle = systemRoleTitle;
    }

    public Integer getSystemRoleId() {
        return systemRoleId;
    }

    public void setSystemRoleId(Integer systemRoleId) {
        this.systemRoleId = systemRoleId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }
}
