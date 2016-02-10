package server.postgress.arduino;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pojo.client.arduino.CashAdminDBData;
import pojo.client.arduino.CashAdminDBElemData;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by root on 12.08.15.
 */
public class CashAdminDBDAO extends JdbcDaoSupport implements CashAdminDBImpl {
    @Override
    public CashAdminDBData get(CashAdminDBData cashAdminDBData) {
        try{
            cashAdminDBData = (CashAdminDBData) getJdbcTemplate().queryForObject(
                    "SELECT employees.id, employees.name, cards.number FROM employees JOIN employees_and_cards ON employees.id = employees_and_cards.employee_id JOIN cards ON cards.id = employees_and_cards.card_id JOIN employees_and_roles ON employees.id = employees_and_roles.employee_id JOIN system_roles ON employees_and_roles.system_role_id = system_roles.id JOIN access_rights ON system_roles.id = access_rights.system_role_id WHERE employee_status_id = 1 AND access_rights.system_role_id = 3 AND device_id = ?;",
                    new Object[]{cashAdminDBData.getDeviceId()},
                    new SearchRowMapper()
            );
        }catch (org.springframework.dao.EmptyResultDataAccessException | CannotGetJdbcConnectionException ex){
            cashAdminDBData.setMessage("FAIL");
        }
        return cashAdminDBData;
    }

    private class SearchRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            CashAdminDBData cashAdminDBData = new CashAdminDBData();
            do {
                CashAdminDBElemData cashAdminDBElemData = new CashAdminDBElemData();

                cashAdminDBElemData.setAdminId(resultSet.getInt("id"));
                cashAdminDBElemData.setName(resultSet.getString("name"));
                cashAdminDBElemData.setNumber(resultSet.getString("number"));

                cashAdminDBData.addElem(cashAdminDBElemData);
            }while (resultSet.next());

            cashAdminDBData.setMessage("SUCCESS");
            return cashAdminDBData;
        }
    }
}
