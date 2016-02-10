package server.postgress.arduino;

import pojo.client.arduino.CashAdminDBData;

/**
 * Created by root on 12.08.15.
 */
public interface CashAdminDBImpl {
    public CashAdminDBData get(CashAdminDBData cashAdminDBData);
}
