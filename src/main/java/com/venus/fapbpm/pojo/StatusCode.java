package com.venus.fapbpm.pojo;

public enum StatusCode {
    SUCCESS(200,"成功"),
    ERROR(500,"系统内部错误"),
    UNKNOWN_ACCOUNT(5010,"无此用户"),
    AUTHENTICATE_ERROR(5011,"认证密码错误"),
    ARGUMENT_ERROR(502,"请求参数错误");
    private Integer code;
    private String message;
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    StatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
