package com.chat.letter.common.msg;

public enum ResultCode {

    SUCCESS("000000","成功！"),
    ERROR("999999","失败！");

    ResultCode(String code, String message){
        this.code = code;
        this.message =message;
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
