package steps.initialization;

import methods.InitializationParams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by guardeec on 22.06.15.
 */
public class Initialisation {


    public static void start() {

        InitializationParams initializationParams = InitializationParams.getInstance();

        //setting the configuration
        String[] configuration = getConfigurationFromFile(new File("config.txt"));

        if(configuration != null){
            initializationParams.setHttpAddress(configuration[0]);
            initializationParams.setHttpAddressCheckRunnable(configuration[1]);
            initializationParams.setHttpAddressCashAdminDB(configuration[2]);

            initializationParams.setInputFile(configuration[3]);
            initializationParams.setOutputFile(configuration[4]);
            initializationParams.setCheckRunnableFile(configuration[5]);
            initializationParams.setAdminDBFile(configuration[6]);
            initializationParams.setDeviceId(configuration[7]);

            File files[] = {    new File(initializationParams.getInputFile()),
                                new File(initializationParams.getOutputFile()),
                                new File(initializationParams.getCheckRunnableFile()),
                                new File(initializationParams.getAdminDBFile())
            };
            makeFiles(files);
        }else {
            System.exit(0);
        }
    }

    private static String[] getConfigurationFromFile(File config){
        String[] configuration = null;
        if(config.exists()){
            try {
                Scanner in = new Scanner(config);
                configuration = new String[8];
                try{
                    configuration[0] = in.nextLine(); //http
                    configuration[1] = in.nextLine(); //httpCheck
                    configuration[2] = in.nextLine(); //httpCash
                    configuration[3] = in.nextLine(); //input
                    configuration[4] = in.nextLine(); //output
                    configuration[5] = in.nextLine(); //check
                    configuration[6] = in.nextLine(); //cash
                    configuration[7] = in.nextLine(); //deviceId
                }catch (java.util.NoSuchElementException ex){
                    configuration = null;
                    System.out.print(   "\nЗаполнены не все поля конфигурационного файла.\n" +
                            "Создайте файл config.txt и занесите в него первой адрес сервера Access\n"+
                            "Например localhost:8080/Get\n"+
                            "не указывайте тип соединения (http/https) и параметры после адреса целевого сервиса такие как ? % | & и т.д.\n"+
                            "второй строкой занесите адрес проверки работоспособности сервера\n"+
                            "третей строкой занесите адрес копирования БД администраторов\n"+
                            "четвёртой строкой занесите название входного файла, например read.txt\n"+
                            "пятой строкой занесите название выходного файла, например write.txt\n"+
                            "шестой строкой занесите название файла для проверки соединения, например connection.txt\n"+
                            "седьмой строкой занесите название файла БД администраторов, например adminDB.txt\n"+
                            "восьмой строчкой укажите id устройства"
                    );
                }
                in.close();
                System.exit(0);
            } catch (FileNotFoundException e) {
                configuration = null;
            }
        }else {
            System.out.print(   "\nНет конфигурационного файла.\n" +
                    "Создайте файл config.txt и занесите в него первой адрес сервера Access\n"+
                    "Например localhost:8080/Get\n"+
                    "не указывайте тип соединения (http/https) и параметры после адреса целевого сервиса такие как ? % | & и т.д.\n"+
                    "второй строкой занесите адрес проверки работоспособности сервера\n"+
                    "третей строкой занесите адрес копирования БД администраторов\n"+
                    "четвёртой строкой занесите название входного файла, например read.txt\n"+
                    "пятой строкой занесите название выходного файла, например write.txt\n"+
                    "шестой строкой занесите название файла для проверки соединения, например connection.txt\n"+
                    "седьмой строкой занесите название файла БД администраторов, например adminDB.txt\n"+
                    "восьмой строчкой укажите id устройства"
            );
            System.exit(0);
        }
        return configuration;
    }

    private static void makeFiles(File[] files){
        for (int i=0; i<4; i++){
            if(!files[i].exists()){
                try {
                    files[i].createNewFile();
                    switch (i){
                        case 0 : System.out.println("Нет файла для чтения. Создаём...");
                        case 1 : System.out.println("Нет файла для записи. Создаём...");
                        case 2 : System.out.println("Нет файла для проверки соединения. Создаём...");
                        case 3 : System.out.println("Нет файла локальной БД администраторов. Создаём...");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }






}
