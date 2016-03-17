package com.common.util;
import java.util.Base64;
import java.io.UnsupportedEncodingException;

public class EncodeDecodeUtil {
	
	public String getEncodeValue(String beforeEncode) throws UnsupportedEncodingException {
        String base64encodedString = Base64.getEncoder().encodeToString(beforeEncode.getBytes("utf-8"));
       // base64encodedString = Base64.getUrlEncoder().encodeToString(beforeEncode.getBytes("utf-8"));
		return base64encodedString;
	}
	
	public String getDecodeValue(String beforeDecode) throws UnsupportedEncodingException {
		 byte[] base64decodedBytes = Base64.getDecoder().decode(beforeDecode);
		 //base64decodedBytes = Base64.getUrlDecoder().decode(beforeDecode);
	     String afterDecode=new String(base64decodedBytes,"utf-8");
	     return afterDecode;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		EncodeDecodeUtil encode=new EncodeDecodeUtil();
		String encodeValue= encode.getEncodeValue("Pramoj");
		System.out.println(encodeValue);
		String deCodeValue= encode.getDecodeValue(encodeValue);
		System.out.println(deCodeValue);
	}
	
}
