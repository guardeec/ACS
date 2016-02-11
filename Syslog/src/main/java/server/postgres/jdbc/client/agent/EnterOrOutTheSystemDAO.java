package server.postgres.jdbc.client.agent;
import pojo.client.agent.UserClientSessionDATA;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by root on 08.10.15.
 */
public class EnterOrOutTheSystemDAO extends JdbcDaoSupport implements EnterOtOutTheSystemImpl {

    @Override
    public String log(UserClientSessionDATA userClientSession) {
        try{
            getJdbcTemplate().update(
                    "INSERT INTO host_ag_events (event_id, empl_id, empl_name, os_acc_id, os_acc_l) VALUES (?, ?, ?, ?, ?);",
                    userClientSession.getGeneralEventTypeId(),
                    userClientSession.getEmployerId(),
                    userClientSession.getEmployerName(),
                    userClientSession.getOperationSystemAccountId(),
                    userClientSession.getOsperationSystemAccountLogin());
            return "Success";
        }catch (CannotGetJdbcConnectionException ex){
            return "Error";
        }
    }

}
