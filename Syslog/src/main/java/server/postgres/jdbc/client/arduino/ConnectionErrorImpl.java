package server.postgres.jdbc.client.arduino;

import pojo.client.arduino.ConnectionErrorDATA;

/**
 * Created by root on 28.10.15.
 */
public interface ConnectionErrorImpl {
    public String log(ConnectionErrorDATA workError);
}
