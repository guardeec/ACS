package methods;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Guardeec on 18.02.16.
 */
public class File {

    public String read(java.io.File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        String message = "";
        do {
            message += in.next();
        }while (in.hasNext());
        in.close();
        return message;
    }

    public boolean isEmpty(java.io.File file){
        return file.length()==0;
    }

    public void write(java.io.File file, String message) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
        out.write(message);
        out.close();
    }
}
