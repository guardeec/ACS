package server.postgress.server.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import server.postgress.server.interfaces.CheckRunnableImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by root on 12.08.15.
 */
public class CheckRunnableDAO extends JdbcDaoSupport implements CheckRunnableImpl {
    @Override
    public Boolean check() {
        try{
            getJdbcTemplate().queryForObject(
                    "SELECT 1;",
                    new Object[]{},
                    Boolean.class
            );
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.BadSqlGrammarException ex){
            return true;
        } catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            return false;
        }
        return false;
    }

    private class SearchRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            return true;
        }
    }
}
