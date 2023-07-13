package com.ruoyi.project.tool.swagger;

public class HtzkApiPOJO {
    private String status;
    private String msgContent;

    private String msgCode;

    private BodyInfoVo body;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public BodyInfoVo getBody() {
        return body;
    }

    public void setBody(BodyInfoVo body) {
        this.body = body;
    }
}
