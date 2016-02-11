package server.postgres.jdbc.client.admin;


import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pojo.client.admin.AccountDATA;

/**
 * Created by root on 08.10.15.
 */
public class AccountDAO extends JdbcDaoSupport implements AccountImpl{

    @Override
    public String log(AccountDATA account) {
        try{
            getJdbcTemplate().update(
                    "INSERT INTO sec_dep_acc_events (event_id, empl_id, empl_name, cl_acc_id, cl_acc_l, acc_r) VALUES (?,?,?,?,?,?);",
                    account.getGeneralEventTypeId(),
                    account.getEmployeeId(),
                    account.getEmployeeName(),
                    account.getClientAccountId(),
                    account.getClientAccountLogin(),
                    account.getAccessRights());
            return "Success";
        }catch (CannotGetJdbcConnectionException ex){
            return "Error";
        }
    }
}
