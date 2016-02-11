package pojo.client.admin;

import pojo.GeneralParams;

/**
 * Created by root on 27.10.15.
 */
public class EmployeeDATA extends GeneralParams {

    private Integer employeeId;
    private String employeeName;
    private Integer employeeStateId;
    private String employeeStateDescription;
    private Integer systemRoleId;
    private String systemRoleTitle;
    private Integer cardId;

    public void setSpecificParams(
            Integer employeeId,
            String employeeName,
            Integer employeeStateId,
            String employeeStateDescription,
            Integer systemRoleId,
            String systemRoleTitle,
            Integer cardId
    ) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeStateId = employeeStateId;
        this.employeeStateDescription = employeeStateDescription;
        this.systemRoleId = systemRoleId;
        this.systemRoleTitle = systemRoleTitle;
        this.cardId = cardId;
    }

    public EmployeeDATA() {
        super();
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

    public Integer getEmployeeStateId() {
        return employeeStateId;
    }

    public void setEmployeeStateId(Integer employeeStateId) {
        this.employeeStateId = employeeStateId;
    }

    public String getEmployeeStateDescription() {
        return employeeStateDescription;
    }

    public void setEmployeeStateDescription(String employeeStateDescription) {
        this.employeeStateDescription = employeeStateDescription;
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

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }
}
