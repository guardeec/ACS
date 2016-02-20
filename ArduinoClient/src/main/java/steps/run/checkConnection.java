package steps.run;

import methods.AccessServerRequest;
import methods.ConnectionStatus;

/**
 * Created by root on 12.08.15.
 */
public class CheckConnection extends Thread {

    public void run() {
        try {
            AccessServerRequest accessServerRequest = new AccessServerRequest();
            ConnectionStatus connectionStatus = new ConnectionStatus();
            for (;;){
                System.out.println("Checking Connection");
                if (accessServerRequest.CheckConnection()){
                    connectionStatus.setYesConnetion();
                }else {
                    connectionStatus.setNoConnection();
                }
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
