package com.mypqh.common;

import io.swagger.annotations.ApiModelProperty;

public class UserInfo {
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "MIMA")
    private String password;

    private String agreeBox;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAgreeBox() {
        return agreeBox;
    }

    public void setAgreeBox(String agreeBox) {
        this.agreeBox = agreeBox;
    }
}
