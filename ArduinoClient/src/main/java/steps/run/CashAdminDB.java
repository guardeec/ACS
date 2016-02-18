package steps.run;


import com.google.gson.Gson;
import methods.AccessServerRequest;
import methods.ConnectionStatus;
import methods.InitializationParams;
import pojo.arduino.CashAdminDBData;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by root on 12.08.15.
 */
public class CashAdminDB extends Thread {
    private Gson gson = new Gson();

    public void run() {
        File adminDB = new File(InitializationParams.getInstance().getAdminDBFile());
        methods.File fileMethods = new methods.File();
        AccessServerRequest accessServerRequest = new AccessServerRequest();
        ConnectionStatus connectionStatus = new ConnectionStatus();

        try {
            for (;;){
                System.out.println("Starting cache ADB");
                if(connectionStatus.get()){
                    try {
                        CashAdminDBData cashAdminDBData = new CashAdminDBData();
                        cashAdminDBData.setDeviceId(Integer.parseInt(InitializationParams.getInstance().getDeviceId()));
                        cashAdminDBData = accessServerRequest.getAdminDB(cashAdminDBData);
                        fileMethods.write(adminDB, gson.toJson(cashAdminDBData));
                        System.out.println("Caching ADB success");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        System.exit(0);
                    }
                }else {
                    try {
                        fileMethods.write(adminDB, gson.toJson(new CashAdminDBData()));
                        System.out.println("Caching ADB fail");
                    } catch (FileNotFoundException e) {
                        System.exit(0);
                        e.printStackTrace();
                    }
                }
                Thread.sleep(20000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
