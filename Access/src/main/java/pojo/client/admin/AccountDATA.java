package pojo.client.admin;

import pojo.GeneralParams;

/**
 * Created by root on 27.10.15.
 */
public class AccountDATA extends GeneralParams {
    private Integer employeeId;
    private String employeeName;
    private Integer clientAccountId;
    private String clientAccountLogin;
    private String accessRights;
    private String password;

    public void setSpecificParams(
            Integer employeeId,
            String employeeName,
            Integer clientAccountId,
            String clientAccountLogin,
            String accessRights,
            String password
    ) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.clientAccountId = clientAccountId;
        this.clientAccountLogin = clientAccountLogin;
        this.accessRights = accessRights;
        this.password = password;
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

    public Integer getClientAccountId() {
        return clientAccountId;
    }

    public void setClientAccountId(Integer clientAccountId) {
        this.clientAccountId = clientAccountId;
    }

    public String getClientAccountLogin() {
        return clientAccountLogin;
    }

    public void setClientAccountLogin(String clientAccountLogin) {
        this.clientAccountLogin = clientAccountLogin;
    }

    public String getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(String accessRights) {
        this.accessRights = accessRights;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
