package com.chat.letter.common.msg;

public class ResultMessage<T> {

    private String code;
    private String message;
    private T data;

    public ResultMessage(String code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }


    /**
     * 成功
     * @param data
     * @return
     */
    public static ResultMessage success(Object data){
        return new ResultMessage(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),data);
    }

    /**
     * 成功
     * @return
     */
    public static ResultMessage success(){
        return new ResultMessage(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),null);
    }

    /**
     * 成功
     * @return
     */
    public static ResultMessage successStr(String message){
        return new ResultMessage(ResultCode.SUCCESS.getCode(), message,null);
    }

    /**
     * 失败
     * @return
     */
    public static ResultMessage error(){
        return new ResultMessage(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMessage(),null);
    }

    /**
     * 失败
     * @return
     */
    public static ResultMessage errorStr(String message){
        return new ResultMessage(ResultCode.ERROR.getCode(), message,null);
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
