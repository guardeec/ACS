package methods;

/**
 * Created by Guardeec on 17.02.16.
 */
public class InitializationParams {
    private static InitializationParams ourInstance = new InitializationParams();

    public static InitializationParams getInstance() {
        return ourInstance;
    }

    private String httpAddress;
    private String httpAddressCheckRunnable;
    private String httpAddressCashAdminDB;
    private String inputFile;
    private String outputFile;
    private String checkRunnableFile;
    private String adminDBFile;
    private String deviceId;

    public static InitializationParams getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(InitializationParams ourInstance) {
        InitializationParams.ourInstance = ourInstance;
    }

    public String getHttpAddress() {
        return httpAddress;
    }

    public void setHttpAddress(String httpAddress) {
        this.httpAddress = httpAddress;
    }

    public String getHttpAddressCheckRunnable() {
        return httpAddressCheckRunnable;
    }

    public void setHttpAddressCheckRunnable(String httpAddressCheckRunnable) {
        this.httpAddressCheckRunnable = httpAddressCheckRunnable;
    }

    public String getHttpAddressCashAdminDB() {
        return httpAddressCashAdminDB;
    }

    public void setHttpAddressCashAdminDB(String httpAddressCashAdminDB) {
        this.httpAddressCashAdminDB = httpAddressCashAdminDB;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public String getCheckRunnableFile() {
        return checkRunnableFile;
    }

    public void setCheckRunnableFile(String checkRunnableFile) {
        this.checkRunnableFile = checkRunnableFile;
    }

    public String getAdminDBFile() {
        return adminDBFile;
    }

    public void setAdminDBFile(String adminDBFile) {
        this.adminDBFile = adminDBFile;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    private InitializationParams() {
    }
}
