package pojo.client.agent;


import pojo.GeneralParams;

/**
 * Created by root on 27.10.15.
 */
public class UserClientSessionDATA extends GeneralParams {
    private Integer employerId;
    private String employerName;
    private Integer operationSystemAccountId;
    private String osperationSystemAccountLogin;

    public void setSpecificParams(Integer employerId, String employerName, Integer operationSystemAccountId, String osperationSystemAccountLogin) {
        this.employerId = employerId;
        this.employerName = employerName;
        this.operationSystemAccountId = operationSystemAccountId;
        this.osperationSystemAccountLogin = osperationSystemAccountLogin;
    }

    public Integer getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Integer employerId) {
        this.employerId = employerId;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public Integer getOperationSystemAccountId() {
        return operationSystemAccountId;
    }

    public void setOperationSystemAccountId(Integer operationSystemAccountId) {
        this.operationSystemAccountId = operationSystemAccountId;
    }

    public String getOsperationSystemAccountLogin() {
        return osperationSystemAccountLogin;
    }

    public void setOsperationSystemAccountLogin(String osperationSystemAccountLogin) {
        this.osperationSystemAccountLogin = osperationSystemAccountLogin;
    }
}
