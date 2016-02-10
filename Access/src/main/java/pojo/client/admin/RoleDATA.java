package pojo.client.admin;


import pojo.GeneralParams;

/**
 * Created by root on 27.10.15.
 */
public class RoleDATA extends GeneralParams {
    private Integer systemRoleId;
    private String systemRoleTitle;

    public void setSpecificParams(
            Integer systemRoleId,
            String systemRoleTitle
    ) {
        this.systemRoleId = systemRoleId;
        this.systemRoleTitle = systemRoleTitle;
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
}
