package pojo.client.admin;

import pojo.GeneralParams;

/**
 * Created by root on 27.10.15.
 */
public class AdminClientSessionDATA extends GeneralParams {
    private Integer clientAccountId;
    private String clientAccountLogin;
    private String accessRights;

    public void setSpecificParams(
            Integer clientAccountId,
            String clientAccountLogin,
            String accessRights
    ) {
        this.clientAccountId = clientAccountId;
        this.clientAccountLogin = clientAccountLogin;
        this.accessRights = accessRights;
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
}
