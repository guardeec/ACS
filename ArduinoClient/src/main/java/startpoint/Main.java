package startpoint;

import steps.initialization.Initialization;
import steps.run.Access;
import steps.run.CashAdminDB;
import steps.run.CheckConnection;
import steps.shutdown.Shutdown;

/**
 * Created by guardeec on 18.05.15.
 */
public class Main {
    public static void main(String args[]) {

        if (args.length==0){
            System.out.println(
                    "[-h] : Help\n" +
                    "[-config <FileName>] : Старт клиента\n"
            );
            System.exit(0);
        }

        if (args[0].compareTo("-h")==0){
            System.out.print(
                    "\nArduino ACS client\n" +
                    "[-h] : Помощь\n"+
                    "[-config <FileName>] : Старт клиента \n"+
                    "\n"+
                    "Создайте файл и занесите в него первой строкой адрес сервиса для получения права доступа\n"+
                    "Например http://localhost:8080/Get\n"+
                    "второй строкой занесите адрес проверки работоспособности сервера\n"+
                    "третей строкой занесите адрес копирования БД администраторов\n"+
                    "четвёртой строкой занесите название входного файла в соответствии с настройками Arduino, например read.txt\n"+
                    "пятой строкой занесите название выходного файла в соответствии с настройками Arduino, например write.txt\n"+
                    "шестой строчкой укажите id устройства\n"
            );
            System.exit(0);
        }

        if (args[0].compareTo("-config")==0){
            Initialization.startInitialization(args[1]);
            new CheckConnection().start();
            new CashAdminDB().start();
            new Access().start();
            new Shutdown().start();
        }


    }

}

