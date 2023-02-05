package model;



public class DeviceTokenBean  {
    private String userId;
    private String deviceType;
    private String module;
    private String token;

    public DeviceTokenBean(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "DeviceTokenBean{" +
                "userId='" + userId + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", module='" + module + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
