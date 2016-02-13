package generator;

import soap.technical.DeviceDATA;
import soap.technical.TechnicalSOAP;
import soap.technical.TechnicalSOAPService;

import java.util.LinkedList;

/**
 * Created by Guardeec on 12.02.16.
 */
public class TechnicalMethods {


    public static DeviceDATA addDevice(DeviceDATA deviceDATA){

        TechnicalSOAPService technicalSOAPService = new TechnicalSOAPService();
        TechnicalSOAP technicalSOAP = technicalSOAPService.getTechnicalSOAPPort();

        deviceDATA = (DeviceDATA) technicalSOAP.technicalMethods("DEVICE_CREATE", deviceDATA);

        return deviceDATA;
    }

    public static DeviceDATA changeDevice(DeviceDATA deviceDATA){
        TechnicalSOAPService technicalSOAPService = new TechnicalSOAPService();
        TechnicalSOAP technicalSOAP = technicalSOAPService.getTechnicalSOAPPort();

        deviceDATA = (DeviceDATA) technicalSOAP.technicalMethods("DEVICE_UPDATE", deviceDATA);

        return deviceDATA;
    }

    public static DeviceDATA deleteDevice(DeviceDATA deviceDATA){
        TechnicalSOAPService technicalSOAPService = new TechnicalSOAPService();
        TechnicalSOAP technicalSOAP = technicalSOAPService.getTechnicalSOAPPort();

        deviceDATA = (DeviceDATA) technicalSOAP.technicalMethods("DEVICE_DELETE", deviceDATA);

        return deviceDATA;

    }

    public static LinkedList<DeviceDATA> getDevice(DeviceDATA deviceDATA){
        return null;
    }
}
