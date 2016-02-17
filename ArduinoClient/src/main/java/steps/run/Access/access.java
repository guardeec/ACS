package steps.run.Access;

import com.google.gson.Gson;
import methods.AccessServerRequest;
import methods.ConnectionStatus;
import methods.InitializationParams;
import pojo.arduino.GetAccessData;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by guardeec on 22.06.15.
 */
public class Access extends Thread{

    private ConnectionStatus connectionStatus = new ConnectionStatus();
    private AccessServerRequest accessServerRequest = new AccessServerRequest();
    private Gson gson = new Gson();

    public void run() {

        try{
            for (;;) {
                if (connectionStatus.get()){
                    try {
                        Scanner in = new Scanner(InitializationParams.getInstance().getInputFile());
                        if (in.hasNext()) {
                            GetAccessData getAccessData = accessServerRequest.getAccess(gson.fromJson(in.nextLine(),GetAccessData.class));
                            in.close();
                            PrintWriter out = new PrintWriter(InitializationParams.getInstance().getInputFile().getAbsoluteFile());
                            out.write("");
                            out.close();

                            //HTTP request to server
                            Map<String, String> output = accessRequest.make(input, httpAddress);


                            //Writing to WriteFile
                            out = new PrintWriter(writeFile.getAbsoluteFile());
                            String outputMessage = "name=" + output.get("name") + "&";
                            outputMessage += "id=" + output.get("id") + "&";
                            outputMessage += "Access=" + output.get("Access");
                            out.write(outputMessage);
                            out.close();
                        } else {
                            in.close();
                        }

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        Scanner in = new Scanner(readFile);
                        if (in.hasNext() == true) {


                            //Reading readFile
                            Map<String, String> input = AccessServerRequest.parseHttp2Map(in.nextLine());
                            in.close();
                            PrintWriter out = new PrintWriter(readFile.getAbsoluteFile());
                            out.write("");
                            out.close();

                            //HTTP request to localDB
                            Map<String, String> output = accessRequestToLocalDB.make(input);
                            System.out.println(output.entrySet());
                            //Writing to WriteFile
                            out = new PrintWriter(writeFile.getAbsoluteFile());
                            String outputMessage = "name=" + output.get("name") + "&";
                            outputMessage += "id=" + output.get("id") + "&";
                            outputMessage += "Access=" + output.get("Access");
                            out.write(outputMessage);
                            out.close();
                        } else {
                            in.close();
                        }

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }


                Thread.sleep(100);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
