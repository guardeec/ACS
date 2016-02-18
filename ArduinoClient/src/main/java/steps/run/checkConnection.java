package steps.run;

import methods.AccessServerRequest;
import methods.ConnectionStatus;

/**
 * Created by root on 12.08.15.
 */
public class CheckConnection extends Thread {

    public void run() {
        AccessServerRequest accessServerRequest = new AccessServerRequest();
        ConnectionStatus connectionStatus = new ConnectionStatus();
        for (;;){
            if (accessServerRequest.CheckConnection()){
                connectionStatus.setYesConnetion();
            }else {
                connectionStatus.setNoConnection();
            }
        }
    }
}
