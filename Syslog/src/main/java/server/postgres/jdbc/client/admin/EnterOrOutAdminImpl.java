package server.postgres.jdbc.client.admin;

import pojo.client.admin.AdminClientSessionDATA;

/**
 * Created by root on 08.10.15.
 */
public interface EnterOrOutAdminImpl {
    public String log(AdminClientSessionDATA session);
}
