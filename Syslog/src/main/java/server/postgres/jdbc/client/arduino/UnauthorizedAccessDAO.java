package server.postgres.jdbc.client.arduino;

import pojo.client.arduino.UnuathorizedAccessDATA;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by root on 08.10.15.
 */
public class UnauthorizedAccessDAO extends JdbcDaoSupport implements UnauthorizedAccessImpl {

    @Override
    public String log(UnuathorizedAccessDATA unuathorizedAccess) {
        return "Success";
    }
}
