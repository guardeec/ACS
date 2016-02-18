package steps.initialization;

import methods.InitializationParams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by guardeec on 22.06.15.
 */
public class Initialization {


    public static void startInitialization(String configFile) {
        InitializationParams initializationParams = InitializationParams.getInstance();

        try {

            Scanner in = new Scanner(new File(configFile));
            try{
                initializationParams.setHttpAddress(in.nextLine());
                initializationParams.setHttpAddressCheckRunnable(in.nextLine());
                initializationParams.setHttpAddressCashAdminDB(in.nextLine());

                initializationParams.setAdminDBFile("AdminLocalDB");

                initializationParams.setInputFile(in.nextLine());
                initializationParams.setOutputFile(in.nextLine());
                initializationParams.setCheckRunnableFile(in.nextLine());
                initializationParams.setDeviceId(in.nextLine());
            }catch (java.util.NoSuchElementException ex){
                System.out.print(   "\nЗаполнены не все поля конфигурационного файла.\n" +
                        "Создайте файл и занесите в него первой строкой адрес сервиса для получения права доступа\n"+
                        "Например http://localhost:8080/Get\n"+
                        "второй строкой занесите адрес проверки работоспособности сервера\n"+
                        "третей строкой занесите адрес копирования БД администраторов\n"+
                        "четвёртой строкой занесите название входного файла в соответствии с настройками Arduino, например read.txt\n"+
                        "пятой строкой занесите название выходного файла в соответствии с настройками Arduino, например write.txt\n"+
                        "шестой строкой занесите название файла проверки соединения в соответствии с настройками Arduino, например write.txt\n"+
                        "седьмой строкой укажите id устройства\n"
                );
                System.exit(0);
            }
            in.close();

        } catch (FileNotFoundException e) {
            System.out.print(   "\nКонфигурационный файл не найден.\n" +
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

        File files[] = {
                new File(initializationParams.getInputFile()),
                new File(initializationParams.getOutputFile()),
                new File(initializationParams.getCheckRunnableFile()),
                new File(initializationParams.getAdminDBFile())
        };
        makeFiles(files);
    }

    private static void makeFiles(File[] files){
        for (File file : files) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Создаем файл " + file.getName());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
