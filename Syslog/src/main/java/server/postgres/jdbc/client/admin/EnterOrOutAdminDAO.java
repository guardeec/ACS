package server.postgres.jdbc.client.admin;
import pojo.client.admin.AdminClientSessionDATA;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by root on 08.10.15.
 */
public class EnterOrOutAdminDAO extends JdbcDaoSupport implements EnterOrOutAdminImpl {

    @Override
    public String log(AdminClientSessionDATA session) {
        try{
            getJdbcTemplate().update(
                    "INSERT INTO adm_cl_auth_events (event_id, cl_acc_id, cl_acc_l, acc_r) VALUES (?, ?, ?, ?);",
                    session.getGeneralEventTypeId(),
                    session.getClientAccountId(),
                    session.getClientAccountLogin(),
                    session.getAccessRights());
            return "Success";
        }catch (CannotGetJdbcConnectionException ex){
            return "Error";
        }
    }
}
