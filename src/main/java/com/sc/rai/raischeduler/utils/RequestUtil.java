package com.sc.rai.raischeduler.utils;

import java.util.Arrays;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class RequestUtil {

    private static Logger log = LoggerFactory.getLogger(RequestUtil.class);
    /*key properties*/
    private static final String USERPWD       = "admin:admin";
    private static final String HEADER_KEY    = "Authorization";
    private static final String HEADER_VALUE  = "Basic ";
    private static final String SPACE         = " ";/*CAREFULL*/

    public static HttpEntity<String> getPreFormattedRequestWithUserPassword(String username,String password) {
        String userPassword = username+":"+password;
        byte[] passwordByte           = userPassword.getBytes();
        byte[] base64passwordByte     = Base64.encodeBase64(passwordByte);
        String base64passwordString   = new String(base64passwordByte);
        HttpHeaders httpHeaders       = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add(HEADER_KEY,HEADER_VALUE+base64passwordString);
        log.debug(HEADER_KEY+"   "+HEADER_VALUE+base64passwordString);
        return new HttpEntity<>(httpHeaders);
    }

    public static HttpEntity<String> getPreFormattedRequestWithUserPasswordForByteHandler() {
        byte[] passwordByte           = USERPWD.getBytes();
        byte[] base64passwordByte     = Base64.encodeBase64(passwordByte);
        String base64passwordString   = new String(base64passwordByte);
        HttpHeaders httpHeaders       = new HttpHeaders();
        httpHeaders.add(HEADER_KEY,HEADER_VALUE+SPACE+base64passwordString);

        return new HttpEntity<>(httpHeaders);
    }
}