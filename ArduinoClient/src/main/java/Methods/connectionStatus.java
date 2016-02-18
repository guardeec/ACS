package methods;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by root on 13.08.15.
 */
public class ConnectionStatus {

    public void setNoConnection(){
        File file = new File(InitializationParams.getInstance().getCheckRunnableFile());
        try {
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            out.write("1");
            out.close();
            System.out.println("Server is down");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setYesConnetion(){
        File file = new File(InitializationParams.getInstance().getCheckRunnableFile());
        try {
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            out.write("");
            out.close();
            System.out.println("Server is up");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean get(){
        File file = new File(InitializationParams.getInstance().getCheckRunnableFile());
        boolean status=true;
        if (file.length() > 0){
            status=false;
        }
        return status;
    }
}
