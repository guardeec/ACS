package steps.run;

import com.google.gson.Gson;
import methods.AccessServerRequest;
import methods.ConnectionStatus;
import methods.InitializationParams;
import pojo.arduino.GetAccessData;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by guardeec on 22.06.15.
 */
public class Access extends Thread{

    private ConnectionStatus connectionStatus = new ConnectionStatus();
    private AccessServerRequest accessServerRequest = new AccessServerRequest();
    private Gson gson = new Gson();

    public void run() {
        File readFile = new File(InitializationParams.getInstance().getInputFile());
        File writeFile = new File(InitializationParams.getInstance().getOutputFile());
        methods.File fileMethods = new methods.File();

        try{
            for (;;) {

                //если соединение с сервером присутсивует
                if (!fileMethods.isEmpty(readFile)){
                    if (connectionStatus.get()){
                        try {
                            String cardNumber = fileMethods.read(readFile);
                            GetAccessData getAccessData = new GetAccessData();
                            getAccessData.setCardNumber(cardNumber);
                            getAccessData.setDeviceId(Integer.parseInt(InitializationParams.getInstance().getDeviceId()));
                            getAccessData = accessServerRequest.getAccess(getAccessData);
                            fileMethods.write(readFile, "");

                            fileMethods.write(writeFile, "name="+getAccessData.getEmployeeName()+"&id="+getAccessData.getEmployeeId().toString()+"&access="+getAccessData.getAccess().toString());
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            System.exit(0);
                        }
                    }else {
                        try {
                            String cardNumber = fileMethods.read(readFile);
                            GetAccessData getAccessData = new GetAccessData();
                            getAccessData.setCardNumber(cardNumber);
                            getAccessData.setDeviceId(Integer.parseInt(InitializationParams.getInstance().getDeviceId()));
                            getAccessData = accessServerRequest.getAccessDataFromLocalDB(getAccessData);
                            fileMethods.write(readFile, "");

                            fileMethods.write(writeFile, "name="+getAccessData.getEmployeeName()+"&id="+getAccessData.getEmployeeId().toString()+"&access="+getAccessData.getAccess().toString());
                        } catch (FileNotFoundException e){
                            e.printStackTrace();
                            System.exit(0);
                        }
                    }
                }
                Thread.sleep(100);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
