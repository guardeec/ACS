package server.postgress.admin;

import pojo.client.admin.DeviceDATA;

import java.util.List;

/**
 * Created by Guardeec on 09.02.16.
 */
public interface TechnicalImpl {
    public DeviceDATA addDevice(DeviceDATA deviceDATA);
    public DeviceDATA changeDevice(DeviceDATA deviceDATA);
    public DeviceDATA deleteDevice(DeviceDATA deviceDATA);
    public List<DeviceDATA> getDevice(DeviceDATA deviceDATA);
}
