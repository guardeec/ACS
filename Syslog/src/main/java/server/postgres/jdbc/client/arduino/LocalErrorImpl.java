package server.postgres.jdbc.client.arduino;
import pojo.client.arduino.LocalErrorDATA;

/**
 * Created by root on 28.10.15.
 */
public interface LocalErrorImpl {
    public String log(LocalErrorDATA initialisationError);
}
