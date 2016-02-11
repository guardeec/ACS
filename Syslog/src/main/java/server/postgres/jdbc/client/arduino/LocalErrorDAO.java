package server.postgres.jdbc.client.arduino;
import pojo.client.arduino.LocalErrorDATA;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by root on 08.10.15.
 */
public class LocalErrorDAO extends JdbcDaoSupport implements LocalErrorImpl {

    @Override
    public String log(LocalErrorDATA initialisationError) {
        return "Success";
    }
}
