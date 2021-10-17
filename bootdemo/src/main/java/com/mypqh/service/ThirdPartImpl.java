package com.mypqh.service;

import java.net.MalformedURLException;
import java.net.URL;

//请求第三方接口的实现，还没搞完
public class ThirdPartImpl {
    public static void main(String[] args) {
        try {
            URL u=new URL("https://route.showapi.com/6-1?num=15195813626&showapi_appid=717190.0&showapi_timestamp=20210727142441&showapi_sign=35eb5878353d495fb90c660c5948bc20");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
