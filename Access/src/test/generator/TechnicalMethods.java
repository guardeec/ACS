package generator;

import com.google.gson.Gson;
import soap.SoapURL;
import soap.technical.DeviceDATA;
import soap.technical.TechnicalSOAP;
import soap.technical.TechnicalSOAPService;

import java.util.List;

/**
 * Created by Guardeec on 12.02.16.
 */
public class TechnicalMethods {

    private static final java.net.URL URL = SoapURL.getInstance().TECHNICAL_URL();

    public static DeviceDATA addDevice(DeviceDATA deviceDATA){
        TechnicalSOAPService technicalSOAPService = new TechnicalSOAPService(URL);
        TechnicalSOAP technicalSOAP = technicalSOAPService.getTechnicalSOAPPort();

        deviceDATA = (DeviceDATA) technicalSOAP.technicalMethods("DEVICE_CREATE", deviceDATA);

        return deviceDATA;
    }

    public static DeviceDATA changeDevice(DeviceDATA deviceDATA){
        TechnicalSOAPService technicalSOAPService = new TechnicalSOAPService(URL);
        TechnicalSOAP technicalSOAP = technicalSOAPService.getTechnicalSOAPPort();

        deviceDATA = (DeviceDATA) technicalSOAP.technicalMethods("DEVICE_UPDATE", deviceDATA);

        return deviceDATA;
    }

    public static DeviceDATA deleteDevice(DeviceDATA deviceDATA){
        TechnicalSOAPService technicalSOAPService = new TechnicalSOAPService(URL);
        TechnicalSOAP technicalSOAP = technicalSOAPService.getTechnicalSOAPPort();

        deviceDATA = (DeviceDATA) technicalSOAP.technicalMethods("DEVICE_DELETE", deviceDATA);

        return deviceDATA;

    }

    public static List<DeviceDATA> getDevice(DeviceDATA deviceDATA){
        TechnicalSOAPService technicalSOAPService = new TechnicalSOAPService(URL);
        TechnicalSOAP technicalSOAP = technicalSOAPService.getTechnicalSOAPPort();

        String json = (String) technicalSOAP.technicalMethods("DEVICE_READ", deviceDATA);
        Gson gson = new Gson();
        return gson.fromJson(json, List.class);
    }
}
