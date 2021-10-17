package com.mypqh.util;

import com.mypqh.common.Constant;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIP{
	public static String getIp(){
		InetAddress address =null;
		try{
			address=InetAddress.getLocalHost();
		}catch(UnknownHostException e){
			System.exit(Constant.TWO);
		}
		StringBuffer stringBuffer =new StringBuffer();
		stringBuffer.append(address.getHostAddress());
		return stringBuffer.toString();
	}
	
}

