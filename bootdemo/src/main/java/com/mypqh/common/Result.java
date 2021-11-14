package com.mypqh.common;

public class Result {
    private String resultCode;
    private String resultDetail;

    public Result(String code, String detail){
        this.resultCode=code;
        this.resultDetail=detail;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDetail() {
        return resultDetail;
    }

    public void setResultDetail(String resultDetail) {
        this.resultDetail = resultDetail;
    }
}
