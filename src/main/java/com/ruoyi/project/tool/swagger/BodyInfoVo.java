package com.ruoyi.project.tool.swagger;

import java.io.Serializable;
import java.util.List;

public class BodyInfoVo implements Serializable {
    private String gatewayTypeName;

    private String gatewayName;

    private String gatewaySN;


    private List<SensorValueVO> sensorValues;


    public String getGatewayTypeName() {
        return gatewayTypeName;
    }

    public void setGatewayTypeName(String gatewayTypeName) {
        this.gatewayTypeName = gatewayTypeName;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getGatewaySN() {
        return gatewaySN;
    }

    public void setGatewaySN(String gatewaySN) {
        this.gatewaySN = gatewaySN;
    }

    public List<SensorValueVO> getSensorValues() {
        return sensorValues;
    }

    public void setSensorValues(List<SensorValueVO> sensorValues) {
        this.sensorValues = sensorValues;
    }
}
