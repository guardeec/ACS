package pojo;

/**
 * Created by root on 27.10.15.
 */
public abstract class GeneralParams {
    //sourceParams
    private Integer sourceTypeId;
    private String sourceIp;
    private String sourceMac;
    private Integer sourceDeviceId;
    private Integer sourceClientAccountId;
    private String sourceClientAccountLogin;

    //generalParams
    private Integer generalEventTypeId;
    private Long generalDatetime;
    private Boolean generalResultType;
    private String generalDescription;

    public void setGeneralParams(
            Integer sourceTypeId,
            String sourceIp,
            String sourceMac,
            Integer sourceDeviceId,
            Integer sourceClientAccountId,
            String sourceClientAccountLogin
    ) {
        this.sourceTypeId = sourceTypeId;
        this.sourceIp = sourceIp;
        this.sourceMac = sourceMac;
        this.sourceDeviceId = sourceDeviceId;
        this.sourceClientAccountId = sourceClientAccountId;
        this.sourceClientAccountLogin = sourceClientAccountLogin;
    }

    public void setGeneralParams(
            Integer generalEventTypeId,
            Long generalDatetime,
            Boolean generalResultType,
            String generalDescription
    ) {
        this.generalEventTypeId = generalEventTypeId;
        this.generalDatetime = generalDatetime;
        this.generalResultType = generalResultType;
        this.generalDescription = generalDescription;
    }

    public Integer getSourceTypeId() {
        return sourceTypeId;
    }

    public void setSourceTypeId(Integer sourceTypeId) {
        this.sourceTypeId = sourceTypeId;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getSourceMac() {
        return sourceMac;
    }

    public void setSourceMac(String sourceMac) {
        this.sourceMac = sourceMac;
    }

    public Integer getSourceDeviceId() {
        return sourceDeviceId;
    }

    public void setSourceDeviceId(Integer sourceDeviceId) {
        this.sourceDeviceId = sourceDeviceId;
    }

    public Integer getSourceClientAccountId() {
        return sourceClientAccountId;
    }

    public void setSourceClientAccountId(Integer sourceClientAccountId) {
        this.sourceClientAccountId = sourceClientAccountId;
    }

    public String getSourceClientAccountLogin() {
        return sourceClientAccountLogin;
    }

    public void setSourceClientAccountLogin(String sourceClientAccountLogin) {
        this.sourceClientAccountLogin = sourceClientAccountLogin;
    }

    public Integer getGeneralEventTypeId() {
        return generalEventTypeId;
    }

    public void setGeneralEventTypeId(Integer generalEventTypeId) {
        this.generalEventTypeId = generalEventTypeId;
    }

    public Long getGeneralDatetime() {
        return generalDatetime;
    }

    public void setGeneralDatetime(Long generalDatetime) {
        this.generalDatetime = generalDatetime;
    }

    public Boolean getGeneralResultType() {
        return generalResultType;
    }

    public void setGeneralResultType(Boolean generalResultType) {
        this.generalResultType = generalResultType;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }
}
