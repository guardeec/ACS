package pojo.arduino;

import pojo.GeneralParams;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Guardeec on 08.02.16.
 */
public class CashAdminDBData extends GeneralParams {
    private Integer deviceId;
    private List<CashAdminDBElemData> admins;
    private String message;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public CashAdminDBData() {
        admins = new LinkedList<CashAdminDBElemData>();
    }

    public void addElem(CashAdminDBElemData cashAdminDBElemData){
        this.admins.add(cashAdminDBElemData);
    }

    public List<CashAdminDBElemData> getElems(){
        return this.admins;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
