package server.postgres.jdbc.client.arduino;
import pojo.client.arduino.ConnectionErrorDATA;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by root on 08.10.15.
 */
public class ConnectionErrorDAO extends JdbcDaoSupport implements ConnectionErrorImpl {

    @Override
    public String log(ConnectionErrorDATA workError) {
        return "Success";
    }
}
