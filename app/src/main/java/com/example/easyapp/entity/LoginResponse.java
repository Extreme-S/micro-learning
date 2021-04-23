package com.example.easyapp.entity;

public class LoginResponse {

    /**
     * msg : success
     * code : 0
     * expire : 604800
     * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI2IiwiaWF0IjoxNjE1MzYzODQyLCJleHAiOjE2MTU5Njg2NDJ9.N3-g2meppKcoc3_YPuZwbRZVphzCaozJNVPyxBgE2UQUDoJ7Ztvtow1_uzz7ViYAW-RBFJ9o-qOx3jxyB7oPlg
     */


    private String msg;

    private Integer code;

    private Integer expire;

    private String token;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
