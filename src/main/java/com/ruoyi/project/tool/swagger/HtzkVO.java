package com.ruoyi.project.tool.swagger;

public class HtzkVO {

    private String body;

    private String msgCode;

    private String msgContent;

    private String status;


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "HtzkVO{" +
                "body='" + body + '\'' +
                ", msgCode='" + msgCode + '\'' +
                ", msgContent='" + msgContent + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
