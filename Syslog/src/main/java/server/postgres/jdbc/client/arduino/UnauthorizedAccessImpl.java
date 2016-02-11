package server.postgres.jdbc.client.arduino;

import pojo.client.arduino.UnuathorizedAccessDATA;

/**
 * Created by root on 28.10.15.
 */
public interface UnauthorizedAccessImpl {
    public String log(UnuathorizedAccessDATA unuathorizedAccess);
}
