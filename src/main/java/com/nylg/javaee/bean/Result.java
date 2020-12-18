package com.nylg.javaee.bean;

/**
 * 用来表示响应体数据的封装
 */
public class Result {
    private Integer code;

    private Object data;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result(Integer code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Result() {
    }

    public static Result ok(){
        return new Result(0,null, null);
    }

    public static Result ok(Object data){
        return new Result(0, data, null);
    }

    public static Result error(String message){
        return new Result(10000, null, message);
    }
}
