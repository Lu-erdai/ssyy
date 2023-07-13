package com.ruoyi.project.tool.swagger;

public class AuthorizationVO {
    private String deviceType;

    private String token;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return "AuthorizationVO{" +
                "deviceType='" + deviceType + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
