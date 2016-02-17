package methods;

import com.google.gson.Gson;
import pojo.arduino.CashAdminDBData;
import pojo.arduino.GetAccessData;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class AccessServerRequest {

    private Gson gson = new Gson();

    public GetAccessData getAccess(GetAccessData getAccessData){
        URLConnection conn;
        InitializationParams initializationParams = InitializationParams.getInstance();
        String message = gson.toJson(getAccessData);
        try {
            conn = new URL(initializationParams.getHttpAddress()+"?"+message).openConnection();
            message = readStreamToString(conn.getInputStream(), "UTF-8");
            getAccessData = gson.fromJson(message, GetAccessData.class);
            return getAccessData;
        }catch (IOException ex){
            getAccessData.setSpecificParams(null,null,null,null,"NO_CONNECTION",null,null,false,null,null);
            return getAccessData;
        }
    }

    private CashAdminDBData getAdminDB(CashAdminDBData cashAdminDBData){
        URLConnection conn;
        InitializationParams initializationParams = InitializationParams.getInstance();
        String message = gson.toJson(cashAdminDBData);
        try {
            conn = new URL(initializationParams.getHttpAddress()+"?"+message).openConnection();
            message = readStreamToString(conn.getInputStream(), "UTF-8");
            return gson.fromJson(message, CashAdminDBData.class);
        }catch (IOException ex){
            return null;
        }
    }

    private String readStreamToString(InputStream in, String encoding) throws IOException {
        StringBuffer b = new StringBuffer();
        InputStreamReader r = new InputStreamReader(in, encoding);
        int c;
        while ((c = r.read()) != -1) {
            b.append((char)c);
        }
        return b.toString();
    }



}
