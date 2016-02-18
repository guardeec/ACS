package methods;

import com.google.gson.Gson;
import pojo.arduino.CashAdminDBData;
import pojo.arduino.CashAdminDBElemData;
import pojo.arduino.GetAccessData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class AccessServerRequest {

    private Gson gson = new Gson();
    private ConnectionStatus connectionStatus = new ConnectionStatus();

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
            connectionStatus.setNoConnection();
            return getAccessData;
        }
    }

    public GetAccessData getAccessDataFromLocalDB(GetAccessData getAccessData) throws FileNotFoundException {
        getAccessData.setEmployeeId(null);
        getAccessData.setEmployeeName("NOT_ADMIN");
        getAccessData.setAccess(false);
        File fileMethods = new File();
        List<CashAdminDBElemData> cashAdminDBElemDataList = gson.fromJson(fileMethods.read(new java.io.File(InitializationParams.getInstance().getAdminDBFile())),CashAdminDBData.class).getElems();
        for (CashAdminDBElemData cashAdminDBElemData : cashAdminDBElemDataList){
            if (getAccessData.getCardNumber().compareTo(cashAdminDBElemData.getNumber())==0){
                getAccessData.setEmployeeId(cashAdminDBElemData.getAdminId());
                getAccessData.setEmployeeName(cashAdminDBElemData.getName());
                getAccessData.setAccess(true);
            }
        }
        return getAccessData;
    }

    public CashAdminDBData getAdminDB(CashAdminDBData cashAdminDBData){
        URLConnection conn;
        InitializationParams initializationParams = InitializationParams.getInstance();
        String message = gson.toJson(cashAdminDBData);
        try {
            conn = new URL(initializationParams.getHttpAddress()+"?"+message).openConnection();
            message = readStreamToString(conn.getInputStream(), "UTF-8");
            return gson.fromJson(message, CashAdminDBData.class);
        }catch (IOException ex){
            connectionStatus.setNoConnection();
            return new CashAdminDBData();
        }
    }

    public Boolean CheckConnection(){
        URLConnection conn;
        try {
            conn = new URL(InitializationParams.getInstance().getHttpAddressCheckRunnable()).openConnection();
            String message = readStreamToString(conn.getInputStream(), "UTF-8");
            return Boolean.parseBoolean(message);
        } catch (IOException e) {
            return false;
        }

    }

    private String readStreamToString(InputStream in, String encoding) throws IOException {
        StringBuilder b = new StringBuilder();
        InputStreamReader r = new InputStreamReader(in, encoding);
        int c;
        while ((c = r.read()) != -1) {
            b.append((char)c);
        }
        return b.toString();
    }



}
